/*
 * ZooKeeperConf.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.config;

import cn.pl.frame.spring.zk.register.IZooKeeperRegister;

/**
 * ZooKeeper配置
 *
 * @author alanyuan
 */
public class ZooKeeperConf {
    /**
     * IP表
     */
    private String             ipTable;
    /**
     * 启用标志
     */
    private boolean            enable = false;
    /**
     * 注册器类名
     */
    private String             registerClass;
    /**
     * 注册器实例
     */
    private IZooKeeperRegister register;
                               
    /**
     * @return the ipTable
     */
    public String getIpTable() {
        return ipTable;
    }
    
    /**
     * @param ipTable
     *            the ipTable to set
     */
    public void setIpTable(String ipTable) {
        this.ipTable = ipTable;
    }
    
    /**
     * @return the enable
     */
    public boolean isEnable() {
        return enable;
    }
    
    /**
     * @param enable
     *            the enable to set
     */
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    
    /**
     * @return the registerClass
     */
    public String getRegisterClass() {
        return registerClass;
    }
    
    /**
     * @param registerClass
     *            the registerClass to set
     */
    public void setRegisterClass(String registerClass) {
        this.registerClass = registerClass;
    }
    
    /**
     * @return the register
     */
    public IZooKeeperRegister getRegister() {
        return register;
    }
    
    /**
     * @param register
     *            the register to set
     */
    public void setRegister(IZooKeeperRegister register) {
        this.register = register;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ZooKeeperConf [ipTable=" + ipTable + ", enable=" + enable + ", registerClass=" + registerClass
                + ", register=" + register + "]";
    }
    
}
