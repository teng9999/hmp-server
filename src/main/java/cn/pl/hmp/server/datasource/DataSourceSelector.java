/**
 * 
 */
package cn.pl.hmp.server.datasource;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.Assert;

/**
 * 数据源路由Selector
 * 
 * @author alanyuan
 * 
 */
public class DataSourceSelector extends AbstractRoutingDataSource {
    public static final String CLUSTER_KEY_WORDS = "CLUSTER";
    public static final String CLUSTER_KEY_PREFIX = "CLUSTER@@";
    /**
     * 集群配置
     */
    private List<Object> cluster;
    /**
     * 集群数据源
     */
    private Map<Object, DataSource> clusterDataSources;
    /**
     * 当前集群选定的数据源序号
     */
    private AtomicInteger currCluster = new AtomicInteger(0);

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#
     * afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        // 配置集群数据源
        clusterDataSources = new ConcurrentHashMap<>();
        if (cluster != null && !cluster.isEmpty()) {
            AtomicInteger i = new AtomicInteger(0);
            for (Object o : cluster) {
                Object lookupKey = resolveSpecifiedLookupKey(DataSourceSelector.CLUSTER_KEY_PREFIX + i.get());
                DataSource dataSource = resolveSpecifiedDataSource(o);
                if (dataSource != null) {
                    clusterDataSources.put(lookupKey, dataSource);
                    i.incrementAndGet();
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#
     * determineTargetDataSource()
     */
    @Override
    protected DataSource determineTargetDataSource() {
        DataSource ds = null;
        Object key = determineCurrentLookupKey();
        if (key != null && key instanceof String
                && key.toString().trim().toUpperCase().indexOf(DataSourceSelector.CLUSTER_KEY_WORDS) == 0) {
            logger.debug("Routing Key: [" + key.toString() + "]");
            Assert.notNull(clusterDataSources, "Cluster DataSource router not initialized");
            ds = selectCluster();
            if (ds == null) {
                throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + key + "]");
            } else {
                logger.debug("Get Target DataSource from cluster[" + ds.toString() + "]");
            }
        } else {
            ds = super.determineTargetDataSource();
            logger.debug("Get Target DataSource from default[" + ds + "]");
        }

        return ds;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#
     * determineCurrentLookupKey()
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return RoutingContextHolder.getContext();
    }

    public void setCluster(List<Object> cluster) {
        this.cluster = cluster;
    }

    public void setClusterDataSources(Map<Object, DataSource> dataSources) {
        this.clusterDataSources = dataSources;
    }

    /**
     * 选择集群数据源
     * 
     * @return
     */
    private DataSource selectCluster() {
        DataSource ds = null;
        logger.debug("Select From DataSources Cluster");
        if (clusterDataSources == null || clusterDataSources.isEmpty())
            return ds;
        // 目前使用简单的轮流算法选择
        AtomicInteger total = new AtomicInteger(clusterDataSources.size());
        logger.debug("Cluster Total: " + total);
        AtomicInteger index = new AtomicInteger(0);
        if (total.get() > 1) {
            index = new AtomicInteger(currCluster.get() % total.get());
            if (currCluster.incrementAndGet() >= total.get()) {
                currCluster.set(0);
            }
        }
        String key = DataSourceSelector.CLUSTER_KEY_PREFIX + index.get();
        logger.debug("Select Cluster[" + key + "]");
        ds = clusterDataSources.get(key);
        return ds;
    }

}
