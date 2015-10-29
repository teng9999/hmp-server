/*
 * ServerUtil.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights Reserved.
 */
package cn.pl.hmp.server.utils;

import cn.pl.commons.utils.NetUtil;
import cn.pl.commons.utils.StringUtils;
import cn.pl.hmp.server.config.Env;
import cn.pl.hmp.server.config.ThriftConf;
import cn.pl.hmp.server.config.ZooKeeperConf;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务维护工具
 *
 * @author alanyuan
 */
public class ServerUtil {
    /**
     * 获取所有注册到ZooKeeper的服务节点的地址 {x.x.x.x:port,x.x.x.x:port...}
     *
     * @return
     */
    public static List<String> getServerAddress() {
        ThriftConf thConf = Env.getConfig().getThriftConf();
        if (thConf == null)
            return null;
        List<String> result = null;
        ZooKeeperConf zkConf = Env.getConfig().getZookeeperConf();
        if (StringUtils.isNotBlank(thConf.getName()) && zkConf != null && zkConf.getRegister() != null
                && zkConf.isEnable()) {
            result = zkConf.getRegister().getServerList(zkConf.getIpTable(), thConf.getName());
        } else if (StringUtils.isNotBlank(thConf.getHost()) && thConf.getPort() > 0) {
            String host = thConf.getHost();
            int port = thConf.getPort();
            if ("0.0.0.0".equalsIgnoreCase(host)) {
                host = NetUtil.getLocalInetAddress();
            }
            result = new ArrayList<String>();
            result.add(host + ":" + port);
        }
        return result;
    }
}
