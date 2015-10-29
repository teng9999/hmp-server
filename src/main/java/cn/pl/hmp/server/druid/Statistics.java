/*
 * Statistics.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights Reserved.
 */
package cn.pl.hmp.server.druid;

import com.alibaba.druid.support.spring.stat.SpringMethodStatValue;
import com.alibaba.druid.support.spring.stat.SpringStat;
import com.alibaba.druid.support.spring.stat.SpringStatManager;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Druid统计
 *
 * @author alanyuan
 */
public class Statistics {
    private static SpringStatManager springStatManager = SpringStatManager.getInstance();
    
    /**
     * 获取经Spring拦截的统计信息
     *
     * @return
     */
    public static Map<String, List<SpringMethodStatValue>> springStat() {
        if (springStatManager == null)
            return null;
        Map<String, List<SpringMethodStatValue>> result = null;
        Set<Object> stat = springStatManager.getSpringStatSet();
        if (stat != null && !stat.isEmpty()) {
            result = new ConcurrentHashMap<String, List<SpringMethodStatValue>>();
            for (Object obj : stat) {
                SpringStat statObj = (SpringStat) obj;
                List<SpringMethodStatValue> datas = statObj.getStatList(false);
                result.put(statObj.getClass().getName(), datas);
            }
        }
        return result;
    }
}
