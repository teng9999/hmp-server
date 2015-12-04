package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.DataDict;
import cn.pl.hmp.server.dao.entity.DataDictExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DataDictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DataDict record);

    int insertSelective(DataDict record);

    List<DataDict> selectByExample(DataDictExample example);

    DataDict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataDict record);

    int updateByPrimaryKey(DataDict record);
    
    List<DataDict> selectByParentName(@Param(value="parentName")String parentName);
}