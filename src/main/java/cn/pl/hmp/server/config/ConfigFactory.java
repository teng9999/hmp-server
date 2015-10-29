/**
 * ConfigFactory.java
 * <p/>
 * Copyright Bejing Pinglian Tech Co.,Ltd. All Rights Reserved.
 */
package cn.pl.hmp.server.config;

import cn.pl.hmp.server.exception.ConfigException;

/**
 * 配置工厂
 *
 * @author Alan
 *        
 */
public class ConfigFactory {
    
    /**
     * 创建配置
     *
     * @return
     * @throws ConfigException
     */
    public static ServerConfig createConfig() throws ConfigException {
        ServerConfig config = new ServerConfig();
        config.load();
        return config;
    }
    
    /**
     * 创建配置
     *
     * @param file
     * @return
     * @throws ConfigException
     */
    public static ServerConfig createConfig(String file) throws ConfigException {
        ServerConfig config = new ServerConfig(file);
        config.load();
        return config;
    }
    
}
