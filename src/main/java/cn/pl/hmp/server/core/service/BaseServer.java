/**
 * BaseServer.java
 * <p/>
 * Copyright Bejing Pinglian Tech Co.,Ltd. All Rights Reserved.
 */
package cn.pl.hmp.server.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.pl.commons.thread.DaemonService;
import cn.pl.commons.thread.ScheduledService;
import cn.pl.commons.thread.ThreadCallableTask;
import cn.pl.commons.thread.ThreadTask;
import cn.pl.commons.thread.impl.DaemonServiceImpl;
import cn.pl.commons.thread.impl.ScheduledServiceImpl;
import cn.pl.commons.thread.impl.ThreadTaskImpl;
import cn.pl.commons.thread.task.CallableTask;
import cn.pl.hmp.server.config.Env;
import cn.pl.hmp.server.config.ServerConfig;
import cn.pl.hmp.server.thrift.ThriftServer;

/**
 * 酒店配置和管理平台服务管理
 *
 * @author Alan
 * 
 */
public class BaseServer implements Runnable {
    public static final String DEFAULT_SERVER_NAME = "HMP";
    public static final int DEFAULT_CORE_POOL_SIZE = 100;
    public static final int DEFAULT_MAX_POOL_SIZE = 200;
    public static final int DEFAULT_KEEP_ALIVE_TIME = 60;
    public static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.SECONDS;
    public static final int DEFAULT_WORK_QUEUE_SIZE = 100000;
    public static final int DEFAULT_CALL_QUEUE_SIZE = 100000;
    public static final int DEFAULT_TASK_TIMEOUT = 5;

    private static Logger logger = LoggerFactory.getLogger(BaseServer.class);
    private static BaseServer instance = new BaseServer();

    // 服务环境配置
    private ServerConfig conf;
    // 服务名
    private String serverName;
    // 线程池核心线程数边界
    private int corePoolSize;
    // 线程池最大边界
    private int maxPoolSize;
    // 保持线程活动时间
    private long keepAliveTime;
    // 保持线程活动时间单位
    private TimeUnit timeUnit;
    // 普通任务队列容量
    private int workQueueSize;
    // 回调任务队列容量
    private int callQueueSize;
    // 任务执行超时时长
    private int taskTimeout;

    // 通用服务
    private DaemonService service;
    // 定时服务
    private ScheduledService scheduled;
    // 普通任务轮询
    private BaseServer.ExecuteRunnable executeRunnable;
    // 回调任务轮询
    private BaseServer.ExecuteCallable executeCallable;
    // 服务状态
    private boolean running = false;
    // 普通任务队列
    private LinkedBlockingQueue<Runnable> runQueue;
    // 回调任务队列
    private LinkedBlockingQueue<Runnable> callQueue;
    // 回调结果散列
    private Map<String, Future<?>> callFuture;
    // 定时任务回调结果散列
    private Map<String, Future<?>> scheduledCallFuture;
    // 普通定时任务队列
    private LinkedBlockingQueue<Runnable> scheduledRunQueue;
    // 回调定时任务队列
    private LinkedBlockingQueue<Runnable> scheduledCallQueue;

    // 扩展功能线程组
    private ThreadGroup extendGroup;
    // 扩展功能：Thrift服务
    private ThriftServer thrift;

    /**
     *
     */
    private BaseServer() {
        super();
        // 服务环境初始化
        conf = Env.getConfig();
        serverName = conf.getServerName();
        corePoolSize = conf.getCorePoolSize();
        maxPoolSize = conf.getMaxPoolSize();
        keepAliveTime = conf.getKeepAliveTime();
        timeUnit = conf.getTimeUnit();
        workQueueSize = conf.getWorkQueueSize();
        callQueueSize = conf.getCallQueueSize();
        taskTimeout = conf.getTaskTimeout();

        // 普通任务队列初始化
        runQueue = new LinkedBlockingQueue<Runnable>(workQueueSize);
        callQueue = new LinkedBlockingQueue<Runnable>(callQueueSize);
        callFuture = new ConcurrentHashMap<String, Future<?>>();
        // 定时任务队列初始化
        scheduledCallFuture = new ConcurrentHashMap<String, Future<?>>();
        scheduledRunQueue = new LinkedBlockingQueue<Runnable>(workQueueSize);
        scheduledCallQueue = new LinkedBlockingQueue<Runnable>(callQueueSize);
        // 通用服务初始化
        service = new DaemonServiceImpl(serverName, corePoolSize, maxPoolSize, keepAliveTime, timeUnit, runQueue,
                new ThreadPoolExecutor.CallerRunsPolicy(), callQueue, callFuture);
        // 定时服务初始化
        scheduled = new ScheduledServiceImpl(serverName, corePoolSize, scheduledRunQueue,
                new ThreadPoolExecutor.CallerRunsPolicy(), scheduledCallQueue, scheduledCallFuture);

        // Thrift服务初始化
        thrift = ThriftServer.getInstance(conf.getThriftConf(), conf.getZookeeperConf());
        thrift.getThread().setName(DEFAULT_SERVER_NAME + "_THRIFT_SERVER");

        // 扩展功能服务线程组初始化
        List<Thread> baseThreads = new ArrayList<Thread>();
        baseThreads.add(thrift.getThread());

        extendGroup = new ThreadGroup(DEFAULT_SERVER_NAME + "_EXTEND_SERVER");
        extendGroup.enumerate(baseThreads.toArray(new Thread[0]));
        extendGroup.setDaemon(true);
    }

    public static BaseServer getInstance() {
        return instance;
    }

    public ServerConfig getConf() {
        return conf;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        startup();
    }

    /**
     * 服务启动
     */
    public void startup() {
        if (!running) {
            running = true;

            // 服务开始
            logger.info("General Base Server Startup...");
            service.startup();
            logger.info("General Base Server is OK!");
            logger.info("Schedule Base Server Startup...");
            scheduled.startup();
            logger.info("Schedule Base Server is OK!");

            // 普通任务轮询初始化
            executeRunnable = instance.new ExecuteRunnable();
            executeRunnable.setName(DEFAULT_SERVER_NAME + "_RUNNABLE_POLLING");

            // 回调任务轮询初始化
            executeCallable = instance.new ExecuteCallable();
            executeCallable.setName(DEFAULT_SERVER_NAME + "_CALLABLE_POLLING");

            // 开始轮询
            service.executeTask(executeRunnable);
            logger.info("Polling Runnable Task Startup...");
            service.executeTask(executeCallable);
            logger.info("Polling Callable Task Startup...");

            logger.info("General Extend Server Startup...");
            // Thrift服务开始
            if (thrift != null && !thrift.isRunning()) {
                thrift.startup();
                logger.info("Thrift Server Startup...");
            }
            logger.info("General Extend Server Startup...OK!");
        }
    }

    /**
     * 服务关闭
     */
    public void shutdown() {
        if (running) {
            logger.info("Now Shutdown Base Server...");
            running = false;

            if (thrift != null && thrift.isRunning()) {
                logger.info("Now Shutdown Thrift Server...");
                thrift.shutdown();
                logger.info("Now Shutdown Thrift Server...OK!");
            }

            if (executeRunnable != null) {
                logger.info("Now Cancel Polling Runnable...");
                executeRunnable.cancel();
                logger.info("Now Cancel Polling Runnable...OK!");
            }
            if (executeCallable != null) {
                logger.info("Now Cancel Polling Callable...");
                executeCallable.cancel();
                logger.info("Now Cancel Polling Callable...OK!");
            }

            logger.info("Now Shutdown General Base Server...");
            service.shutdown();
            logger.info("Now Shutdown General Base Server...OK!");

            logger.info("Now Shutdown Schedule Base Server...");
            scheduled.shutdown();
            logger.info("Now Shutdown Schedule Base Server...OK!");

            logger.info("Now Shutdown Extend Server...");
            extendGroup.interrupt();
            logger.info("Now Shutdown Extend Server...OK!");

            logger.info("Now Cleanup...");
            if (runQueue != null && !runQueue.isEmpty()) {
                for (Runnable task : runQueue) {
                    if (ThreadTask.class.isAssignableFrom(task.getClass())) {
                        ((ThreadTask) task).cancel();
                    }
                }
                runQueue.clear();
            }
            if (callQueue != null && !callQueue.isEmpty()) {
                for (Runnable task : callQueue) {
                    if (CallableTask.class.isAssignableFrom(task.getClass())) {
                        ((CallableTask<?>) task).cancel(true);
                    }
                }
                callQueue.clear();
            }
            if (callFuture != null && !callFuture.isEmpty()) {
                for (Future<?> ft : callFuture.values()) {
                    ft.cancel(true);
                }
                callFuture.clear();
            }

            if (scheduledRunQueue != null && !scheduledRunQueue.isEmpty()) {
                for (Runnable task : scheduledRunQueue) {
                    if (ThreadTask.class.isAssignableFrom(task.getClass())) {
                        ((ThreadTask) task).cancel();
                    }
                }
                scheduledRunQueue.clear();
            }
            if (scheduledCallQueue != null && !scheduledCallQueue.isEmpty()) {
                for (Runnable task : scheduledCallQueue) {
                    if (CallableTask.class.isAssignableFrom(task.getClass())) {
                        ((CallableTask<?>) task).cancel(true);
                    }
                }
                scheduledCallQueue.clear();
            }
            if (scheduledCallFuture != null && !scheduledCallFuture.isEmpty()) {
                for (Future<?> ft : scheduledCallFuture.values()) {
                    ft.cancel(true);
                }
                scheduledCallFuture.clear();
            }

            // 注意，如果这个服务需要停止后能再次启动则不要把以下变量置为空
            // 或在启动时再次初始化这些变量
            runQueue = null;
            callQueue = null;
            callFuture = null;
            scheduledCallFuture = null;
            scheduledRunQueue = null;
            scheduledCallQueue = null;
            service = null;
            scheduled = null;
            executeRunnable = null;
            executeCallable = null;
            extendGroup = null;
            logger.info("Now Cleanup...OK!");
        }
    }

    /**
     * 任务入队列
     *
     * @param task
     * @throws InterruptedException
     */
    public void put(ThreadTask task) throws InterruptedException {
        if (running && !runQueue.contains(task)) {
            logger.debug("=> put a task[{}] into queue", task.getName());
            service.putTask(task);
        }
    }

    /**
     * 回调任务入队列
     *
     * @param task
     * @throws InterruptedException
     */
    public void put(ThreadCallableTask<?> task) throws InterruptedException {
        if (running && !callQueue.contains(task)) {
            logger.debug("=> submit a task[{}] into callQueue", task.getName());
            service.putTask(task);
        }
    }

    /**
     * 回调任务结果
     *
     * @param taskName
     * @return
     */
    public Future<?> callResult(String taskName) {
        if (taskName == null)
            return null;
        return callFuture.get(taskName);
    }

    /**
     * 定时计划
     *
     * @param task
     * @param delay
     * @return
     */
    public ScheduledFuture<?> scheduleTask(ThreadCallableTask<?> task, long delay, TimeUnit delayUnit) {
        if (task == null || !running)
            return null;

        if (!scheduledCallQueue.contains(task))
            return scheduled.scheduleTask(task, delay, delayUnit);
        return null;
    }

    /**
     * 定时计划
     *
     * @param task
     * @param delay
     * @param unit
     * @return
     */
    public ScheduledFuture<?> scheduleTask(ThreadTask task, long delay, TimeUnit unit) {
        if (task == null || !running)
            return null;
        if (!scheduledRunQueue.contains(task))
            return scheduled.scheduleTask(task, delay, unit);
        return null;
    }

    /**
     * 定时计划
     *
     * @param task
     * @param initialDelay
     * @param period
     * @param unit
     * @return
     */
    public ScheduledFuture<?> scheduleAtFixedRateTask(ThreadTask task, long initialDelay, long period, TimeUnit unit) {
        if (task == null || !running)
            return null;
        if (!scheduledRunQueue.contains(task))
            return scheduled.scheduleAtFixedRateTask(task, initialDelay, period, unit);
        return null;
    }

    /**
     * 定时计划
     *
     * @param task
     * @param initialDelay
     * @param delay
     * @param unit
     * @return
     */
    public ScheduledFuture<?> scheduleWithFixedDelayTask(ThreadTask task, long initialDelay, long delay,
            TimeUnit unit) {
        if (task == null || !running)
            return null;
        if (!scheduledRunQueue.contains(task))
            return scheduled.scheduleWithFixedDelayTask(task, initialDelay, delay, unit);
        return null;
    }

    /**
     * @return the running
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * @return the serverName
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * @return the maxPoolSize
     */
    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    /**
     * @return the keepAliveTime
     */
    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    /**
     * @return the timeUnit
     */
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    /**
     * @return the workQueueSize
     */
    public int getWorkQueueSize() {
        return workQueueSize;
    }

    /**
     * @return the taskTimeout
     */
    public int getTaskTimeout() {
        return taskTimeout;
    }

    protected class ExecuteRunnable extends ThreadTaskImpl {
        private String name;
        private boolean running = false;

        /**
         *
         */
        public ExecuteRunnable() {
            super();
            // TODO Auto-generated constructor stub
        }

        /*
         * (non-Javadoc)
         * 
         * @see cn.pl.commons.thread.ThreadTask#getName()
         */
        @Override
        public String getName() {
            return this.name;
        }

        /*
         * (non-Javadoc)
         * 
         * @see cn.pl.commons.thread.ThreadTask#setName(java.lang.String)
         */
        @Override
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            if (!running) {
                logger.info("=> Run Polling Runnable Task");
                running = true;
                super.run();
                while (running) {
                    try {
                        if (Thread.currentThread().isInterrupted()) {
                            running = false;
                            break;
                        }
                        service.pollRunnable(2l, TimeUnit.SECONDS);

                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            logger.warn("Thread Interrupted");
                        }
                    } catch (Exception e) {
                        logger.error("Execute Runnable Error", e);
                    }
                }
            }
        }

        @Override
        public void cancel() {
            if (running) {
                logger.info("=> Cancel Polling Runnable Task");
                super.cancel();
                running = false;
                Thread.currentThread().interrupt();
            }
        }

    }

    protected class ExecuteCallable extends ThreadTaskImpl {
        private String name;
        private boolean running = false;

        /**
         *
         */
        public ExecuteCallable() {
            super();
            // TODO Auto-generated constructor stub
        }

        /*
         * (non-Javadoc)
         * 
         * @see cn.pl.commons.thread.ThreadTask#getName()
         */
        @Override
        public String getName() {
            return this.name;
        }

        /*
         * (non-Javadoc)
         * 
         * @see cn.pl.commons.thread.ThreadTask#setName(java.lang.String)
         */
        @Override
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            if (!running) {
                logger.info("=> Run Polling Callable Task");
                running = true;
                super.run();
                while (running) {
                    try {
                        if (Thread.currentThread().isInterrupted()) {
                            running = false;
                            break;
                        }
                        service.pollCallable(2l, TimeUnit.SECONDS);

                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            logger.warn("Thread Interrupted");
                        }
                    } catch (Exception e) {
                        logger.error("Execute Callable Error", e);
                    }
                }
            }
        }

        @Override
        public void cancel() {
            if (running) {
                logger.info("=> Cancel Polling Callable Task");
                super.cancel();
                running = false;
                Thread.currentThread().interrupt();
            }
        }

    }

}
