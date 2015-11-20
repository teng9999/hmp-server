package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.HotelRoom;
import cn.pl.hmp.server.dao.entity.HotelRoomExample;
import java.util.List;

public interface HotelRoomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelRoom record);

    int insertSelective(HotelRoom record);

    List<HotelRoom> selectByExample(HotelRoomExample example);
    
    List<HotelRoom> selectListAddUniqueNum(HotelRoomExample example);

    HotelRoom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelRoom record);

    int updateByPrimaryKey(HotelRoom record);
}