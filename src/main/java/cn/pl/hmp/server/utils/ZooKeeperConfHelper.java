/*
 * ZooKeeperConfHelper.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.utils;

import cn.pl.hmp.server.config.Property;
import cn.pl.hmp.server.config.ServerConfig;
import cn.pl.hmp.server.config.ZooKeeperConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Hashtable;

/**
 * ZooKeeper配置Helper
 *
 * @author alanyuan
 */
public class ZooKeeperConfHelper {
    private static Logger logger = LoggerFactory.getLogger(ZooKeeperConfHelper.class);
    
    /**
     * 构建配置
     *
     * @param conf
     * @param properties
     * @throws Exception
     */
    public static void buildConf(ZooKeeperConf conf, Hashtable<String, Property> properties) throws Exception {
        if (check(conf)) {
            if (properties != null && properties.containsKey(ServerConfig.PROPERTY_ZOOKEEPER_ENS_IP)) {
                Property p = properties.get(ServerConfig.PROPERTY_ZOOKEEPER_ENS_IP);
                if (p.getValue() != null)
                    conf.setIpTable(p.getString());
            }
            if (properties != null && properties.containsKey(ServerConfig.PROPERTY_ZOOKEEPER_ENS_ENABLE)) {
                Property p = properties.get(ServerConfig.PROPERTY_ZOOKEEPER_ENS_ENABLE);
                if (p.getValue() != null)
                    conf.setEnable(p.getBoolean());
            }
            conf.setRegister(BeanUtil.createZooKeeperRegister(conf.getRegisterClass()));
        }
    }
    
    private static boolean check(ZooKeeperConf conf) {
        if (conf == null) {
            logger.error("ZooKeeper Config Error: {}", conf);
            return false;
        } else if (conf.getRegisterClass() == null) {
            logger.error("ZooKeeper Config Error: Register Class Undefined");
            return false;
        }
        return true;
    }
    
}
