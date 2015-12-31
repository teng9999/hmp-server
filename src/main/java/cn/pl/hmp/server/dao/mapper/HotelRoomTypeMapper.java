package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import cn.pl.hmp.server.dao.entity.HotelRoomType;
import cn.pl.hmp.server.dao.entity.HotelRoomTypeExample;

public interface HotelRoomTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelRoomType record);

    int insertSelective(HotelRoomType record);

    List<HotelRoomType> selectByExample(HotelRoomTypeExample example);

    HotelRoomType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelRoomType record);

    int updateByPrimaryKey(HotelRoomType record);
    
    List<String> selectDistinctName();
}