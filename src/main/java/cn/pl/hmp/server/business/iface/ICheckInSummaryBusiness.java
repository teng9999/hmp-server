package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.CheckInCount;
import cn.pl.hmp.server.dao.entity.CheckInSummary;

public interface ICheckInSummaryBusiness extends IBusiness{
    /**
     *  查询指定天数的信息，并且以天分组，list存储
     * @param page          分页插件       
     * @param roomType      房间类型
     * @param lastDay       
     * @param plugInterval  插卡拔卡间隔时间
     * @param gapType       查询类型（年、月、日：w、m、d）
     * @return  以天分组的结果集   
     */
    List<List<CheckInSummary>> selectListByDays(String roomType,int lastDay
            ,int plugInterval,long hotelId,String gapType);
    /**
     * 查询指定天数的信息，并且以天分组 map存储
     * @param page          分页插件       
     * @param roomType      房间类型
     * @param lastDay       前查时间数，间隔状态以gapType判断
     * @param plugInterval  插卡拔卡间隔时间
     * @param gapType       查询类型（年、月、日：w、m、d）
     * @return  以天分组的结果集   
     */
    Map<String, List<CheckInSummary>> selectByDays(String roomType,int lastDay
            ,int plugInterval,long hotelId,String gapType);
    /**
     * 查询最近一天的住房数量情况
     * @param gapType       查询类型（年、月、日：w、m、d）
     * @param lastDay       前查时间数，间隔状态以gapType判断
     * @param plugInterval  插卡拔卡间隔时间
     * @param hotelId       酒店编号
     * @return  一天住房量信息结果集
     */
    CheckInCount selectCount(String gapType, int lastDay,
            int plugInterval, long hotelId);
}
