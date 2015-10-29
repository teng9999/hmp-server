/*
 * IZooKeeperRegister.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.zk;

import java.util.List;

/**
 * ZooKeeper注册器接口
 *
 * @author alanyuan
 */
public interface IZooKeeperRegister {
    /**
     * 注册节点
     *
     * @param serverIpTable
     * @param nodeName
     * @param nodeIp
     * @param nodePort
     * @return
     */
    public boolean register(String serverIpTable, String nodeName, String nodeIp, int nodePort);
    
    /**
     * 获取已注册服务节点列表
     *
     * @param serverIpTable
     * @param nodeName
     * @return
     */
    public List<String> getServerList(String serverIpTable, String nodeName);
}
