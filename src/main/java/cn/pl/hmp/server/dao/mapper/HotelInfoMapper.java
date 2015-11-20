package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.HotelInfo;
import cn.pl.hmp.server.dao.entity.HotelInfoExample;
import java.util.List;

public interface HotelInfoMapper {
    int deleteByPrimaryKey(Long id);

    long insert(HotelInfo record);

    long insertSelective(HotelInfo record);

    List<HotelInfo> selectByExample(HotelInfoExample example);

    HotelInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelInfo record);

    int updateByPrimaryKey(HotelInfo record);
}