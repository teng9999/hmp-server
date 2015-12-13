package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import cn.pl.hmp.server.dao.entity.HmpRoomTv;
import cn.pl.hmp.server.dao.entity.HmpRoomTvExample;

public interface HmpRoomTvMapper {
    int countByExample(HmpRoomTvExample example);

    int deleteByPrimaryKey(Long id);

    long insert(HmpRoomTv record);

    int insertSelective(HmpRoomTv record);

    List<HmpRoomTv> selectByExample(HmpRoomTvExample example);

    HmpRoomTv selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HmpRoomTv record);

    int updateByPrimaryKey(HmpRoomTv record);

    List<HmpRoomTv> selectByHotelId(Long hotelId);
}