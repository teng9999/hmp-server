/**
 * ConfigException.java
 * <p/>
 * Copyright Bejing Pinglian Tech Co.,Ltd. All Rights Reserved.
 */
package cn.pl.hmp.server.exception;

/**
 * 配置异常
 *
 * @author Alan
 *        
 */
public class ConfigException extends Exception {
    
    /**
     *
     */
    private static final long serialVersionUID = 6813261615182125008L;
    
    /**
     *
     */
    public ConfigException() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param msg
     */
    public ConfigException(String msg) {
        super(msg);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param e
     */
    public ConfigException(Throwable e) {
        super(e);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param msg
     * @param e
     */
    public ConfigException(String msg, Throwable e) {
        super(msg, e);
        // TODO Auto-generated constructor stub
    }
    
}
