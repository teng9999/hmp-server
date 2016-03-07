package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.CheckInCount;
import cn.pl.hmp.server.dao.entity.CheckInSummary;

public interface ICheckInSummaryBusiness extends IBusiness{
    /**
     *  查询指定天数的信息，并且以天分组，list存储
     * @param page
     * @param roomType
     * @param lastDay
     * @param plugInterval
     * @param gapType
     * @return
     */
    List<List<CheckInSummary>> selectListByDays(String roomType,int lastDay
            ,int plugInterval,long hotelId,String gapType);
    /**
     * 查询指定天数的信息，并且以天分组
     * @param roomType
     * @param lastDay
     * @param plugInterval
     * @return
     */
    Map<String, List<CheckInSummary>> selectByDays(String roomType,int lastDay
            ,int plugInterval,long hotelId,String gapType);
    /**
     * 查询最近一天的住房数量情况
     * @param hotelId
     * @return
     */
    CheckInCount selectCount(String gapType, int lastDay,
            int plugInterval, long hotelId);
}
