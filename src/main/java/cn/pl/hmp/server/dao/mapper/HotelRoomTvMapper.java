package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.HotelRoomTv;
import cn.pl.hmp.server.dao.entity.HotelRoomTvExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HotelRoomTvMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelRoomTv record);

    int insertSelective(HotelRoomTv record);

    List<HotelRoomTv> selectByExample(HotelRoomTvExample example);

    HotelRoomTv selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelRoomTv record);

    int updateByPrimaryKey(HotelRoomTv record);
    
    List<HotelRoomTv> selectListByHotel(@Param("hotelId") Long hotelId);
}