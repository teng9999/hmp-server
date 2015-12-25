package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.HotelRoomRcu;
import cn.pl.hmp.server.dao.entity.HotelRoomRcuExample;
import java.util.List;

public interface HotelRoomRcuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelRoomRcu record);

    int insertSelective(HotelRoomRcu record);

    List<HotelRoomRcu> selectByExample(HotelRoomRcuExample example);

    HotelRoomRcu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelRoomRcu record);

    int updateByPrimaryKey(HotelRoomRcu record);
}