package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.HotelRoomRcu;
import cn.pl.hmp.server.dao.entity.HotelRoomRcuExample;

public interface HotelRoomRcuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelRoomRcu record);

    int insertSelective(HotelRoomRcu record);

    List<HotelRoomRcu> selectByExample(HotelRoomRcuExample example);

    HotelRoomRcu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelRoomRcu record);

    int updateByPrimaryKey(HotelRoomRcu record);
    
    List<HotelRoomRcu> selectListByHotel(@Param("hotelId") Long hotelId);
}