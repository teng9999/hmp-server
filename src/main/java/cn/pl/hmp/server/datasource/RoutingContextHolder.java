/*
 * RoutingContextHolder.java Copyright Bejing Passion Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.datasource;

import org.apache.commons.lang3.Validate;

/**
 * 路由上下文Holder
 *
 * @author alanyuan
 */
@SuppressWarnings( "unchecked" )
public class RoutingContextHolder<T> {
    private static final ThreadLocal<Object> contextHolder = new ThreadLocal<Object>();
    
    public static <T> T getContext() {
        return (T) contextHolder.get();
    }
    
    public static <T> void setContext(T context) {
        Validate.notNull(context, "Routing Context is Required!");
        contextHolder.set(context);
    }
}
