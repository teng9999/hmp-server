/*
 * ThriftServer.java Copyright Bejing Passion Tech Co.,Ltd. All Rights Reserved.
 */
package cn.pl.hmp.server.thrift;

import cn.pl.hmp.server.config.ThriftConf;
import cn.pl.hmp.server.config.ZooKeeperConf;
import cn.pl.hmp.server.zk.IZooKeeperRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Thrift服务
 *
 * @author alanyuan
 */
public class ThriftServer {
    private static final Logger       logger   = LoggerFactory.getLogger(ThriftServer.class);
    private static final ThriftServer instance = new ThriftServer();
    /**
     * Thrift配置
     */
    private static ThriftConf         conf;
    /**
     * ZooKeeper配置
     */
    private static ZooKeeperConf      zk;
    /**
     * 服务线程
     */
    private ThriftThread              thread;
    /**
     * 运行状态
     */
    private boolean                   running  = false;
                                               
    private ThriftServer() {
        thread = new ThriftThread("Thrift Server");
    }
    
    public static ThriftServer getInstance(ThriftConf conf) {
        ThriftServer.conf = conf;
        if (ThriftServer.conf == null)
            logger.error("Get ThriftServer Instance Error: The Config is required!");
        zk = new ZooKeeperConf();
        zk.setEnable(false);
        return instance;
    }
    
    public synchronized static ThriftServer getInstance(ThriftConf tConf, ZooKeeperConf zkConf) {
        // synchronized (conf) {
        conf = tConf;
        if (conf == null)
            logger.error("Get ThriftServer Instance Error: The Config is required!");
        // }
        
        // synchronized (zk) {
        zk = zkConf;
        if (zk == null) {
            zk = new ZooKeeperConf();
            zk.setEnable(false);
        }
        // }
        return instance;
    }
    
    /**
     * @return the thread
     */
    public Thread getThread() {
        return thread;
    }
    
    /**
     * 启动服务
     */
    public void startup() {
        if (!running) {
            running = true;
            thread.setDaemon(true);
            thread.start();
            logger.info("Thrift Server is Started and is Listening at {}", conf.getSocketAddress());
        }
    }
    
    /**
     * 关闭服务
     */
    public void shutdown() {
        if (running) {
            running = false;
            thread.cancel();
            thread.interrupt();
            logger.info("Thrift Server is Shutdown and Release Socket Address {}", conf.getSocketAddress());
        }
    }
    
    /**
     * @return the running
     */
    public boolean isRunning() {
        return running;
    }
    
    private boolean isOK() {
        if (conf == null || conf.getServer() == null) {
            logger.error("Get ThriftServer Instance Error: The Config is required!");
            return false;
        }
        return true;
    }
    
    /**
     * thrift线程
     *
     * @author 志
     */
    private class ThriftThread extends Thread {
        public ThriftThread(String name) {
            super(name);
        }
        
        @Override
        public void run() {
            if (isOK()) {
                try {
                    if (zk.isEnable()) {
                        // 注册到ZK服务
                        IZooKeeperRegister register = zk.getRegister();
                        register.register(zk.getIpTable(), conf.getName(), conf.getHost(), conf.getPort());
                    }
                    conf.getServer().serve();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        public void cancel() {
            if (isOK() && conf.getServer().isServing()) {
                conf.getServer().stop();
                logger.info("Thrift Server is Shutdown");
            }
        }
    }
}
