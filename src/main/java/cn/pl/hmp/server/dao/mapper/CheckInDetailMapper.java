package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.CheckInDetail;
import cn.pl.hmp.server.dao.entity.CheckInDetailExample;

public interface CheckInDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CheckInDetail record);

    int insertSelective(CheckInDetail record);

    List<CheckInDetail> selectByExample(CheckInDetailExample example);

    CheckInDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CheckInDetail record);

    int updateByPrimaryKey(CheckInDetail record);
    /**
     * 批量插入
     * @param list
     * @return
     */
    int insertOnBatch(List<CheckInDetail> list);
    /**
     * 条件查询
     * @param opStatus
     * @param lastDay
     * @return
     */
    List<CheckInDetail> selectByCondition(@Param("opStatus")int opStatus,
            @Param("nowDate")String lastDay,@Param("roomId")long roomId);
}