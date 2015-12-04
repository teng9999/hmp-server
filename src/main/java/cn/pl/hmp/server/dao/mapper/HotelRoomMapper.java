package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.HotelRoom;
import cn.pl.hmp.server.dao.entity.HotelRoomExample;

public interface HotelRoomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelRoom record);

    int insertSelective(HotelRoom record);

    List<HotelRoom> selectByExample(HotelRoomExample example);
    
    List<HotelRoom> selectListAddUniqueNum(@Param(value="hotelId") Long hotelId);

    HotelRoom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelRoom record);

    int updateByPrimaryKey(HotelRoom record);
    
    int insertBatch(List<HotelRoom> list);
}