/*
 * MapperFactory.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据源工厂
 *
 * @author alanyuan
 */
public class MapperFactory {
    private static MapperFactory           instance       = new MapperFactory();
    /**
     * 多数据源散列
     */
    private Map<String, SqlSessionFactory> sessionFactory = null;
                                                          
    private MapperFactory() {
        sessionFactory = new ConcurrentHashMap<String, SqlSessionFactory>();
    }
    
    public static MapperFactory getInstance() {
        return instance;
    }
    
    /**
     * 加入数据源
     *
     * @param id
     * @param factory
     */
    public void addSessionFactory(String id, SqlSessionFactory factory) {
        if (id == null || factory == null)
            return;
        sessionFactory.put(id, factory);
    }
    
    /**
     * 获取SqlSessionFactory
     *
     * @param factoryId
     * @return
     */
    public SqlSessionFactory getSessionFactory(String factoryId) {
        if (factoryId == null)
            return null;
        return sessionFactory.get(factoryId);
    }
    
    /**
     * 获取数据库Session
     *
     * @param factoryId
     * @return
     */
    public SqlSession getSession(String factoryId) {
        if (factoryId == null || sessionFactory == null)
            return null;
        SqlSessionFactory factory = sessionFactory.get(factoryId);
        if (factory == null)
            return null;
        // 使用SqlSessionUtils获取sqlsession，utils里已经实现了spring事务相关的获取sqlsession
        // 如果自己实现需要实现事务相关功能
        return SqlSessionUtils.getSqlSession(factory);
    }
    
    /**
     * 关闭数据库Session
     *
     * @param factoryId
     * @param session
     */
    public void closeSession(String factoryId, SqlSession session) {
        if (factoryId == null || sessionFactory == null || session == null)
            return;
        SqlSessionFactory factory = sessionFactory.get(factoryId);
        if (factory == null)
            return;
        SqlSessionUtils.closeSqlSession(session, factory);
    }
    
    /**
     * 获取Mapper实例
     *
     * @param factoryId
     * @param className
     * @return
     */
    public <T> T getMapper(String factoryId, Class<T> className) {
        SqlSession session = getSession(factoryId);
        return session.getMapper(className);
    }
}
