package cn.pl.hmp.server.business.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.utils.StringUtils;
import cn.pl.hmp.server.business.iface.ICheckInSummaryBusiness;
import cn.pl.hmp.server.dao.entity.CheckInCount;
import cn.pl.hmp.server.dao.entity.CheckInDetailCount;
import cn.pl.hmp.server.dao.entity.CheckInSummary;
import cn.pl.hmp.server.dao.mapper.CheckInSummaryMapper;
@Service
public class CheckInSummaryBusinessImpl extends BoostBusinessImpl implements ICheckInSummaryBusiness{
    @Autowired
    private CheckInSummaryMapper summaryMapper;
    @Override
    public Map<String, List<CheckInSummary>> selectByDays(String roomType,
            int lastDay, int plugInterval,long hotelId,String gapType) {
        Map<String, List<CheckInSummary>> map = new LinkedHashMap<String, List<CheckInSummary>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int gapInc = 1;
        if(StringUtils.isBlank(gapType)) {
            return map;
        }else {
            if("w".equals(gapType.trim())) {
                gapInc = 7;
            }else if("m".equals(gapType.trim())) {
                gapInc = 30;
            }
        }
        List<CheckInSummary> summaryList = summaryMapper.selectByCondition(roomType, plugInterval,
                lastDay,hotelId,gapInc);
        String timeKey = "";
        List<CheckInSummary> tempList = null;
        if(null != summaryList && !summaryList.isEmpty()) {
           for(CheckInSummary summary: summaryList) {
               if(null == summary.getCheckInTime()) {
                   continue;
               }
               timeKey = sdf.format(summary.getCheckInTime());
               if(map.containsKey(timeKey)) {
                   map.get(timeKey).add(summary);
               }else {
                   tempList = new ArrayList<CheckInSummary>();
                   tempList.add(summary);
                   map.put(timeKey, tempList);
               }
           }
        }
        
        return map;
    }
    
    private int getGupInc(String gapType) {
        int gapInc = 1;
        if("w".equals(gapType.trim())) {
            gapInc = 7;
        }else if("m".equals(gapType.trim())) {
            gapInc = 30;
        }
        return gapInc;
    }
    @Override
    public CheckInCount selectCount(String gapType, int lastDay,
            int plugInterval, long hotelId) {
        CheckInCount checkInCount = new CheckInCount();
        int gapInc = 1;
        if(StringUtils.isBlank(gapType)) {
           return checkInCount; 
        }else {
            gapInc = getGupInc(gapType);
        }
        List<CheckInDetailCount> detailCountList = summaryMapper.selectCount(gapInc, lastDay,
                plugInterval, hotelId);
        int totalCount = summaryMapper.selectTotalCount(gapInc, lastDay, plugInterval, hotelId);
        if(null != detailCountList && !detailCountList.isEmpty()) {
            Map<String,Integer> map = new HashMap<String, Integer>();
            for(CheckInDetailCount detailCount: detailCountList) {
                if(null == detailCount) continue;
                map.put(detailCount.getRoomType(), detailCount.getCount());
            }
            checkInCount.setTypeCountMap(map);
        }
        checkInCount.setTotalCount(totalCount);
        return checkInCount;
    }
    @Override
    public List<List<CheckInSummary>> selectListByDays(String roomType, int lastDay,
            int plugInterval, long hotelId,String gapType) {
        List<List<CheckInSummary>> totalList = new ArrayList<List<CheckInSummary>>();
        Map<String, List<CheckInSummary>> map = new LinkedHashMap<String, List<CheckInSummary>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int gapInc = 1;
        if(StringUtils.isBlank(gapType)) {
            return totalList;
        }else {
            if("w".equals(gapType.trim())) {
                gapInc = 7;
            }else if("m".equals(gapType.trim())) {
                gapInc = 30;
            }
        }
        List<CheckInSummary> summaryList = summaryMapper.selectByCondition(roomType, plugInterval,
                lastDay,hotelId,gapInc);
        String timeKey = "";
        List<CheckInSummary> tempList = null;
        if(null != summaryList && !summaryList.isEmpty()) {
           for(CheckInSummary summary: summaryList) {
               if(null == summary.getCheckInTime()) {
                   continue;
               }
               timeKey = sdf.format(summary.getCheckInTime());
               if(map.containsKey(timeKey)) {
                   map.get(timeKey).add(summary);
               }else {
                   tempList = new ArrayList<CheckInSummary>();
                   tempList.add(summary);
                   map.put(timeKey, tempList);
               }
           }
        }
        for(String key :map.keySet()) {
            totalList.add(map.get(key));
        }
        
        return totalList;
    }

}
