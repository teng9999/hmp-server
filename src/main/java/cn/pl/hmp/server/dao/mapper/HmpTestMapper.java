package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.HmpTest;
import cn.pl.hmp.server.dao.entity.HmpTestExample;

import java.util.List;

public interface HmpTestMapper {
    int countByExample(HmpTestExample example);
    
    int deleteByPrimaryKey(Integer id);
    
    int insert(HmpTest record);
    
    int insertSelective(HmpTest record);
    
    List<HmpTest> selectByExample(HmpTestExample example);
    
    HmpTest selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(HmpTest record);
    
    int updateByPrimaryKey(HmpTest record);
}
