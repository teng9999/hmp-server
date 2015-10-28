/*
 * Property.java Copyright Bejing Passion Tech Co.,Ltd. All Rights Reserved.
 */
package cn.pl.hmp.server.config;

import org.apache.http.conn.util.InetAddressUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * 属性
 *
 * @author alanyuan
 */
public class Property {
    public Logger  logger = LoggerFactory.getLogger(Property.class);
    /**
     * 属性名
     */
    private String name;
    /**
     * 属性值
     */
    private Object value;
                   
    public Property() {
        super();
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the value
     */
    @SuppressWarnings( "unchecked" )
    public <X> X getValue() {
        return (X) value;
    }
    
    /**
     * @param value
     *            the value to set
     */
    public <X> void setValue(X value) {
        this.value = value;
    }
    
    public String getString() {
        if (value == null)
            return null;
        return String.valueOf(value).trim();
    }
    
    public Boolean getBoolean() {
        if (getString() == null)
            return false;
        return Boolean.valueOf(getString().replaceAll(" ", ""));
    }
    
    public Integer getInt() {
        if (getString() == null)
            return null;
        return Integer.valueOf(getString().replaceAll(" ", ""));
    }
    
    public Long getLong() {
        if (getString() == null)
            return null;
        return Long.valueOf(getString().replaceAll(" ", ""));
    }
    
    public Float getFloat() {
        if (getString() == null)
            return null;
        return Float.valueOf(getString().replaceAll(" ", ""));
    }
    
    public Double getDouble() {
        if (getString() == null)
            return null;
        return Double.valueOf(getString().replaceAll(" ", ""));
    }
    
    public BigDecimal getBig() {
        if (getString() == null)
            return null;
        return new BigDecimal(getString().replaceAll(" ", ""));
    }
    
    public InetSocketAddress getInetSocketAddress() {
        if (getString() == null)
            return null;
        String[] addr = getString().replaceAll(" ", "").split(":");
        if (addr == null || addr.length != 2)
            return null;
            
        InetSocketAddress rtn = null;
        InetAddress inetAddr = null;
        Integer port = null;
        try {
            port = Integer.valueOf(addr[1]);
        } catch (Exception e) {
            logger.error("Current Property parse Internet Socket Address Port Error", e);
            return null;
        }
        
        try {
            if (InetAddressUtils.isIPv4Address(addr[0])) {
                inetAddr = InetAddress.getByName(addr[0]);
            } else if (InetAddressUtils.isIPv6Address(addr[0])) {
                inetAddr = InetAddress.getByName(addr[0]);
            } else {
                inetAddr = InetAddress.getByName(addr[0]);
            }
        } catch (UnknownHostException e) {
            logger.error("Current Property parse Internet Socket Address Host Error", e);
            return null;
        }
        
        if (inetAddr == null) {
            rtn = new InetSocketAddress(port);
        } else {
            rtn = new InetSocketAddress(inetAddr, port);
        }
        
        return rtn;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Property [name=" + name + ", value=" + value + "]";
    }
    
}
