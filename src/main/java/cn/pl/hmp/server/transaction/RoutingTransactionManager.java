/*
 * RoutingTransactionManager.java Copyright Bejing Pinglian Tech Co.,Ltd. All
 * Rights Reserved.
 */
package cn.pl.hmp.server.transaction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.Validate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

import cn.pl.hmp.server.datasource.RoutingContextHolder;

/**
 * 多数据源路由事务
 *
 * @author alanyuan
 */
public class RoutingTransactionManager implements PlatformTransactionManager {
    private Map<Object, PlatformTransactionManager> targetTransactionManagers = new ConcurrentHashMap<Object, PlatformTransactionManager>();

    public void setTargetTransactionManagers(Map<Object, PlatformTransactionManager> targetTransactionManagers) {
        this.targetTransactionManagers = targetTransactionManagers;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.transaction.PlatformTransactionManager#commit(org
     * .springframework.transaction.TransactionStatus)
     */
    @Override
    public void commit(TransactionStatus status) throws TransactionException {
        getTargetTransactionManager().commit(status);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.transaction.PlatformTransactionManager#getTransaction
     * (org.springframework.transaction.TransactionDefinition)
     */
    @Override
    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
        return getTargetTransactionManager().getTransaction(definition);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.transaction.PlatformTransactionManager#rollback(org
     * .springframework.transaction.TransactionStatus)
     */
    @Override
    public void rollback(TransactionStatus status) throws TransactionException {
        getTargetTransactionManager().rollback(status);
    }

    protected PlatformTransactionManager getTargetTransactionManager() {
        Object context = RoutingContextHolder.getContext();
        Validate.notNull(context, "Routing Context is Required!");
        return targetTransactionManagers.get(context);
    }

}
