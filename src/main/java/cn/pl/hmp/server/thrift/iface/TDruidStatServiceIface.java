/*
 * TDruidStatServiceIface.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.thrift.iface;

import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrfit.service.TDruidStatService.Iface;
import cn.pl.frame.thrift.define.TDruidSpringMethodStat;
import cn.pl.hmp.server.druid.Statistics;
import com.alibaba.druid.support.spring.stat.SpringMethodStatValue;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Druid统计服务接口实现
 *
 * @author alanyuan
 */
@Component
@ThriftService
public class TDruidStatServiceIface implements Iface {
    
    /*
     * (non-Javadoc)
     * @see cn.pl.frame.thrift.service.TDruidStatService.Iface#
     * getDruidSpringMethodStat()
     */
    @Override
    public Map<String, List<TDruidSpringMethodStat>> getDruidSpringMethodStat() throws TException {
        Map<String, List<TDruidSpringMethodStat>> tMethodStats = new ConcurrentHashMap<String, List<TDruidSpringMethodStat>>();
        Map<String, List<SpringMethodStatValue>> methodStats = Statistics.springStat();
        
        if (methodStats != null) {
            for (String name : methodStats.keySet()) {
                List<SpringMethodStatValue> list = methodStats.get(name);
                if (list == null || list.isEmpty())
                    continue;
                List<TDruidSpringMethodStat> stats = new ArrayList<TDruidSpringMethodStat>();
                for (SpringMethodStatValue tstat : list) {
                    if (tstat == null)
                        continue;
                        
                    TDruidSpringMethodStat stat = new TDruidSpringMethodStat();
                    stat.setClassName(tstat.getClassName());
                    stat.setSignature(tstat.getSignature());
                    stat.setRunningCount(tstat.getRunningCount());
                    stat.setConcurrentMax(tstat.getConcurrentMax());
                    stat.setExecuteCount(tstat.getExecuteCount());
                    stat.setExecuteErrorCount(tstat.getExecuteErrorCount());
                    stat.setExecuteTimeNano(tstat.getExecuteTimeNano());
                    stat.setJdbcCommitCount(tstat.getJdbcCommitCount());
                    stat.setJdbcExecuteCount(tstat.getJdbcExecuteCount());
                    stat.setJdbcExecuteErrorCount(tstat.getJdbcExecuteErrorCount());
                    stat.setJdbcExecuteTimeNano(tstat.getJdbcExecuteTimeNano());
                    stat.setJdbcFetchRowCount(tstat.getJdbcFetchRowCount());
                    stat.setJdbcPoolConnectionCloseCount(tstat.getJdbcPoolConnectionCloseCount());
                    stat.setJdbcPoolConnectionOpenCount(tstat.getJdbcPoolConnectionOpenCount());
                    stat.setJdbcResultSetCloseCount(tstat.getJdbcResultSetCloseCount());
                    stat.setJdbcResultSetOpenCount(tstat.getJdbcResultSetOpenCount());
                    stat.setJdbcRollbackCount(tstat.getJdbcRollbackCount());
                    stat.setJdbcUpdateCount(tstat.getJdbcUpdateCount());
                    stat.setLastErrorClass(0);
                    stat.setLastErrorMessage(0);
                    stat.setLastErrorStackTrace(0);
                    stat.setLastErrorTimeMillis(tstat.getLastErrorTimeMillis());
                    
                    stats.add(stat);
                }
                if (!stats.isEmpty()) {
                    tMethodStats.put(name, stats);
                }
            }
        }
        
        return tMethodStats;
    }
    
}
