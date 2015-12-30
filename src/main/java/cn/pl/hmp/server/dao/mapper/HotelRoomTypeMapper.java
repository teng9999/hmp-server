package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.HotelRoomType;
import cn.pl.hmp.server.dao.entity.HotelRoomTypeExample;
import java.util.List;

public interface HotelRoomTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelRoomType record);

    int insertSelective(HotelRoomType record);

    List<HotelRoomType> selectByExample(HotelRoomTypeExample example);

    HotelRoomType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelRoomType record);

    int updateByPrimaryKey(HotelRoomType record);
}