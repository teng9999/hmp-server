/**
 * Env.java
 * <p/>
 * Copyright Bejing Pinglian Tech Co.,Ltd. All Rights Reserved.
 */
package cn.pl.hmp.server.config;

import cn.pl.hmp.server.exception.ConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 环境配置
 *
 * @author Alan
 *        
 */
public class Env {
    private static Logger       log = LoggerFactory.getLogger(Env.class);
    private static ServerConfig config;
    // TODO 加入其他的环境配置
    
    static {
        try {
            if (Env.config == null)
                Env.config = ConfigFactory.createConfig();
        } catch (ConfigException e) {
            log.error("Init configure error", e);
        }
    }
    
    /**
     * 获取配置
     */
    public static ServerConfig getConfig() {
        return Env.config;
    }
    
    /**
     * @param config
     *            the config to set
     */
    public static void setConfig(ServerConfig config) {
        Env.config = config;
    }
    
    /**
     * 重装载配置
     */
    public static void reload() {
        try {
            Env.config = ConfigFactory.createConfig();
        } catch (ConfigException e) {
            log.error("Reload configure error", e);
        }
    }
    
    /**
     * 重装载配置
     *
     * @param file
     */
    public static void reload(String file) {
        try {
            Env.config = ConfigFactory.createConfig(file);
        } catch (ConfigException e) {
            log.error("Reload configure error", e);
        }
    }
}
