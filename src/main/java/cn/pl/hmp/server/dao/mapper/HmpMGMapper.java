package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.HmpMG;
import cn.pl.hmp.server.dao.entity.HmpMGExample;

public interface HmpMGMapper {
    int countByExample(HmpMGExample example);

    int deleteByPrimaryKey(Long id);

    // int deleteBatch(List<Long> movieIdlist , Long groupId);

    int deleteBatch(List<Long> movieIdlist,@Param(value="groupId") Long groupId);

    int deleteBatchByGroupId(Long groupId);

    List<Long> queryByGroupId(Long groupId);

    List<Long> queryByGroupIdLists(List<Long> groupId);

    int insert(HmpMG record);

    int insertSelective(HmpMG record);

    int insertBatch(List<HmpMG>lists);

    List<HmpMG> selectByExample(HmpMGExample example);

    HmpMG selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HmpMG record);

    int updateByPrimaryKey(HmpMG record);
}