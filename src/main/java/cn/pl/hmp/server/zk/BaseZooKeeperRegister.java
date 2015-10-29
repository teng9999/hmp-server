/*
 * ZooKeeperRegister.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.zk;

import cn.pl.commons.utils.NetUtil;
import cn.pl.commons.utils.StringUtils;
import cn.pl.frame.zk.configuration.BasicServerMetaManager;
import cn.pl.frame.zk.configuration.IServerMetaManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * ZooKeeper注册器基本实现
 *
 * @author alanyuan
 */
public class BaseZooKeeperRegister implements IZooKeeperRegister {
    private static Logger logger = LoggerFactory.getLogger(BaseZooKeeperRegister.class);
    
    public BaseZooKeeperRegister() {
    }
    
    @Override
    public boolean register(String serverIpTable, String nodeName, String nodeIp, int nodePort) {
        if (isOK(serverIpTable, nodeName, nodePort)) {
            String nIp = nodeIp;
            if (nIp == null || nIp.equalsIgnoreCase("0.0.0.0"))
                nIp = NetUtil.getLocalInetAddress();
            logger.info("ZooKeeper Server [{}], Node[{},{},{}]", serverIpTable, nodeName, nIp, nodePort);
            IServerMetaManager serverMetaManager = BasicServerMetaManager.getInstance();
            // 向zk注册服务，notename为节点名称,address为ip:port
            if (serverMetaManager != null) {
                serverMetaManager.init(serverIpTable);
                boolean succ = serverMetaManager.register(nodeName, nIp, nodePort);
                if (succ)
                    logger.info("ZooKeeper Register Success");
                else
                    logger.error("ZooKeeper Register Fail");
            } else {
                logger.error("ZooKeeper Register Fail: IServerMetaManager is Null");
            }
        }
        return true;
    }
    
    @Override
    public List<String> getServerList(String serverIpTable, String nodeName) {
        List<String> result = null;
        if (StringUtils.isBlank(nodeName))
            return result;
        logger.info("ZooKeeper Server [{}], Node[{}]", serverIpTable, nodeName);
        IServerMetaManager serverMetaManager = BasicServerMetaManager.getInstance();
        if (serverMetaManager != null) {
            serverMetaManager.init(serverIpTable);
            result = serverMetaManager.getServerList(nodeName);
            if (result == null || result.isEmpty())
                logger.info("Get Node[{}] from ZooKeeper Server [{}] is Null", nodeName, serverIpTable);
            else
                logger.info("Get Node[{}] from ZooKeeper Server [{}]: {}", nodeName, serverIpTable, result.toArray());
        }
        
        return result;
    }
    
    private boolean isOK(String serverIpTable, String nodeName, int nodePort) {
        if (StringUtils.isBlank(serverIpTable) || StringUtils.isBlank(nodeName)) {
            logger.error("ZooKeeperRegister Error: The Config[zk ip, node name, node port] is required!");
            return false;
        }
        return true;
    }
}
