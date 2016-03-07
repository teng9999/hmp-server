package cn.pl.hmp.server.thrift.iface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pl.frame.annotation.ThriftService;
import cn.pl.hmp.commons.thrift.define.TCheckInCount;
import cn.pl.hmp.commons.thrift.define.TCheckInSummary;
import cn.pl.hmp.commons.thrift.service.TCheckInSummaryService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.ICheckInSummaryBusiness;
import cn.pl.hmp.server.dao.entity.CheckInSummary;

@Component
@ThriftService
public class TCheckInSummaryServiceIface implements TCheckInSummaryService.Iface{
    @Autowired
    private ICheckInSummaryBusiness summaryBusiness;

    @Override
    public Map<String, List<TCheckInSummary>> selectByDays(String roomType,
            int lastDay, int plugInterval,long hotelId,String gapType) throws TException {
        Map<String,List<TCheckInSummary>> tMap = new HashMap<String, List<TCheckInSummary>>();
        Map<String,List<CheckInSummary>> summaryMap = summaryBusiness.selectByDays(roomType, lastDay, 
                plugInterval,hotelId,gapType);
        if(null != summaryMap && !summaryMap.isEmpty()) {
            for(String key: summaryMap.keySet()) {
                tMap.put(key, ObjectConverter.convet(summaryMap.get(key), TCheckInSummary.class));
            }
        }
        return tMap;
    }

    @Override
    public List<List<TCheckInSummary>> selectListByDays(String roomType,
            int lastDay, int plugInterval, long hotelId, String gapType)
            throws TException {
        List<List<TCheckInSummary>> totalList = new ArrayList<List<TCheckInSummary>>();
        List<List<CheckInSummary>> summaryList = summaryBusiness.selectListByDays(roomType, lastDay, plugInterval, 
                hotelId, gapType);
        if(null != summaryList && !summaryList.isEmpty()) {
            for(List<CheckInSummary> subList : summaryList) {
                totalList.add(ObjectConverter.convet(subList, TCheckInSummary.class));
            }
        }
        return totalList;
    }

    @Override
    public TCheckInCount selectCount(String gapType, int lastDay,
            int plugInterval, long hotelId) throws TException {
        return ObjectConverter.convet(summaryBusiness.selectCount(gapType, lastDay,
                plugInterval, hotelId), TCheckInCount.class);
    }
}
