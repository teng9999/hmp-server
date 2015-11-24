package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.HmpMG;
import cn.pl.hmp.server.dao.entity.HmpMGExample;
import java.util.List;

public interface HmpMGMapper {
    int countByExample(HmpMGExample example);

    int deleteByPrimaryKey(Long id);
    
    int deleteBatch(List<Long> movieIdlist , int hotelId);
    
    List<Long> selectByGroupId(Long groupId);

    int insert(HmpMG record);

    int insertSelective(HmpMG record);
    
    int insertBatch(List<Long>movieIdlist, int hotelId);
    

    List<HmpMG> selectByExample(HmpMGExample example);

    HmpMG selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HmpMG record);

    int updateByPrimaryKey(HmpMG record);
}