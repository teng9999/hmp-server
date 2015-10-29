/*
 * Context.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights Reserved.
 */
package cn.pl.hmp.server.context;

import cn.pl.hmp.server.entity.BaseEntity;

/**
 * 上下文
 *
 * @author alanyuan
 */
public class Context extends BaseEntity {
    
    public static final String DEFAULT_RELEASE_VERSION = "1.0";
    public static final String DEFAULT_PLATFORM        = "HMP";
    /**
     *
     */
    private static final long  serialVersionUID        = -1584496454579585052L;
    protected static String    releaseVersion;
    protected static String    platform;
                               
    static {
        releaseVersion = DEFAULT_RELEASE_VERSION;
        platform = DEFAULT_PLATFORM;
    }
    
    /**
     * 获取系统版本号
     *
     * @return the version
     */
    public static String getReleaseVersion() {
        return releaseVersion;
    }
    
    /**
     * 设置系统版本号
     *
     * @param version
     *            the version to set
     */
    public static void setReleaseVersion(String ver) {
        releaseVersion = ver;
    }
    
    /**
     * 获取平台
     *
     * @return the platform
     */
    public static String getPlatform() {
        return platform;
    }
    
    /**
     * 设置平台
     *
     * @param platform
     *            the platform to set
     */
    public static void setPlatform(String p) {
        platform = p;
    }
    
    public static void init() {
        releaseVersion = DEFAULT_RELEASE_VERSION;
        platform = DEFAULT_PLATFORM;
    }
    
}
