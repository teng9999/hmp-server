package cn.pl.hmp.server.dao.entity;

import java.util.Map;

public class CheckInCount {
    private Integer totalCount; 
    private Map<String,Integer> typeCountMap;
    public Integer getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
    public Map<String, Integer> getTypeCountMap() {
        return typeCountMap;
    }
    public void setTypeCountMap(Map<String, Integer> typeCountMap) {
        this.typeCountMap = typeCountMap;
    } 
    
}
