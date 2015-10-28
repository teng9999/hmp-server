/*
 * HmpDaemon.java Copyright Bejing Passion Tech Co.,Ltd. All Rights Reserved.
 */
package cn.pl.hmp.server;

import cn.pl.hmp.server.core.service.BaseServer;
import cn.pl.hmp.server.utils.SpringContextUtil;
import com.alibaba.druid.support.spring.stat.SpringStat;
import com.alibaba.druid.support.spring.stat.SpringStatManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * HMP服务守护服务
 *
 * @author alanyuan
 */
public class HmpDaemon {
    private static Logger     logger = LoggerFactory.getLogger(HmpDaemon.class);
    // 基础服务
    private static BaseServer server;
    // 服务管理主线程
    private static Thread     thread;
    // 服务管理任务
    private static ServerTask task;
                              
    static {
        try {
            if (SpringContextUtil.getApplicationContext() == null) {
                SpringContextUtil.getApplicationContextByClassPath("spring.xml");
                while (SpringContextUtil.getApplicationContext() == null) {
                    logger.info("Wait Spring Content Initializ...");
                    TimeUnit.SECONDS.sleep(2);
                }
                
                logger.info("Spring Context Initializ...Complete. Now Create TaskScheduler.");
                // 初始化基础服务
                server = BaseServer.getInstance();
                // 初始化服务管理任务
                task = new ServerTask(server);
                // 初始化服务管理主线程
                thread = new Thread(task);
                thread.setName("HMP_DAEMON_SERVER");
                thread.setDaemon(true);
            }
        } catch (InterruptedException e) {
            logger.warn("HmpDaemon Interrupted. Now Quit...");
        }
    }
    
    /**
     * 启动服务
     */
    public static void startup() {
        if (server.isRunning()) {
            logger.info("HMP Server is Running...");
        } else {
            logger.info("=> HMP Server Startup");
            thread.start();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                logger.warn("HMP Server Interrupted");
            }
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    logger.warn("Thread Interrupted");
                }
                if (Thread.interrupted()) {
                    task.cancel();
                    thread.interrupt();
                    break;
                }
            }
            
        }
    }
    
    /**
     * 关闭服务
     */
    public static void shutdown() {
        try {
            if (server != null && server.isRunning()) {
                task.cancel();
                thread.interrupt();
                logger.info("=> HMP Server Shutdown");
            }
        } catch (Exception e) {
            logger.error("=> HMP Server Shutdown Failure...", e);
        }
    }
    
    /**
     * 关闭钩子
     */
    public static void shutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                HmpDaemon.shutdown();
            }
        });
    }
    
    private static class ServerTask implements Runnable {
        private BaseServer server;
                           
        private boolean    running = false;
                                   
        public ServerTask(BaseServer server) {
            this.server = server;
        }
        
        /*
         * (non-Javadoc)
         * @see java.lang.Thread#run()
         */
        @Override
        public void run() {
            if (!running) {
                running = true;
                
                if (server != null && !server.isRunning())
                    server.startup();
                    
                logger.info("HMP Server Started");
                logger.info("---------------------Druid Statistic start---------------------------");
                StringBuffer sb = new StringBuffer();
                Set<Object> stat = SpringStatManager.getInstance().getSpringStatSet();
                
                for (Object obj : stat) {
                    SpringStat statObj = (SpringStat) obj;
                    List<Map<String, Object>> datas = statObj.getMethodStatDataList();
                    for (Map<String, Object> maps : datas) {
                        for (String method : maps.keySet()) {
                            Object value = maps.get(method);
                            sb.append("\n\t\t" + method + ": \t\t\t\t\t\t" + value);
                        }
                    }
                }
                
                logger.info(sb.toString());
                logger.info("---------------------Druid Statistic end---------------------------");
                
                while (running) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        logger.warn("Thread Interrupted");
                    }
                }
            }
        }
        
        public void cancel() {
            if (running) {
                running = false;
                if (server != null && server.isRunning())
                    server.shutdown();
                    
                logger.info("HMP Server Stop");
            }
        }
    }
}
