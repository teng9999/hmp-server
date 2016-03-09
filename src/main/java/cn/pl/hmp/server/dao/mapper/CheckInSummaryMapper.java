package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.CheckInDetailCount;
import cn.pl.hmp.server.dao.entity.CheckInSummary;
import cn.pl.hmp.server.dao.entity.CheckInSummaryExample;

public interface CheckInSummaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CheckInSummary record);

    int insertSelective(CheckInSummary record);

    List<CheckInSummary> selectByExample(CheckInSummaryExample example);

    CheckInSummary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CheckInSummary record);

    int updateByPrimaryKey(CheckInSummary record);
    /**
     * 批量插入
     * @param list
     * @return
     */
    int insertOnBatch(List<CheckInSummary> list);
    /**
     * 条件查询
     * @param roomType
     * @param lastDay
     * @param plugInterval
     * @return
     */
    List<CheckInSummary> selectByCondition(@Param("roomType")String roomType
            , @Param("plugInterval")int plugInterval,@Param("lastDay")int lastDay
            ,@Param("hotelId")long hotelId,@Param("gapInc") int gapInc);
    
    List<CheckInDetailCount> selectCount(@Param("gapInc")int gapInc,@Param("lastDay") int lastDay,
            @Param("plugInterval") int plugInterval, @Param("hotelId") long hotelId);
    
    /**
     * 查询昨天全部有入住房间数
     * @return
     */
    int selectTotalCount(@Param("gapInc")int gapInc,@Param("lastDay") int lastDay,
            @Param("plugInterval") int plugInterval, @Param("hotelId") long hotelId);
    /**
     * 获取每天最早插卡时间
     * @param lastDay
     * @return
     */
    List<CheckInSummary> selectEarliestInList(@Param("beginTime") String beginTime);
    
}