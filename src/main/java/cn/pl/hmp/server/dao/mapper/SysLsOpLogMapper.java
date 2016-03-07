package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.SysLsOpLog;
import cn.pl.hmp.server.dao.entity.SysLsOpLogExample;

public interface SysLsOpLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLsOpLog record);

    int insertSelective(SysLsOpLog record);

    List<SysLsOpLog> selectByExample(SysLsOpLogExample example);

    SysLsOpLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLsOpLog record);

    int updateByPrimaryKey(SysLsOpLog record);
    /**
     * 条件查询
     * @param beginTime
     * @param endTime
     * @return
     */
    List<SysLsOpLog> selectByCondition(@Param("beginTime")String beginTime
            ,@Param("endTime")String endTime);
}