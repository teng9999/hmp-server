package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.HmpMGHotel;
import cn.pl.hmp.server.dao.entity.HmpMGHotelExample;
import java.util.List;

public interface HmpMGHotelMapper {
    int countByExample(HmpMGHotelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HmpMGHotel record);

    int insertSelective(HmpMGHotel record);

    List<HmpMGHotel> selectByExample(HmpMGHotelExample example);

    HmpMGHotel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HmpMGHotel record);

    int updateByPrimaryKey(HmpMGHotel record);
    
    List<Long> selectByHotelId(Long hotelId);
    
    int delelteByHotelId(Long hotelId);
    
    int deleteOnBatch(List<Long> groupId , Long hotelId);
    
    int saveOnBatch(List<HmpMGHotel> lists);
}