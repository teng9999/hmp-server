package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.CommondityType;
import cn.pl.hmp.server.dao.entity.CommondityTypeExample;

public interface CommondityTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommondityType record);

    int insertSelective(CommondityType record);

    List<CommondityType> selectByExample(CommondityTypeExample example);

    CommondityType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommondityType record);

    int updateByPrimaryKey(CommondityType record);
    
    int insertBatch(List<CommondityType> list);
    
    int deleteByMenuId(@Param(value = "menuChannelId")Long menuChannelId);
}