package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.HotelInfo;
import cn.pl.hmp.server.dao.entity.HotelInfoExample;

public interface HotelInfoMapper {
    int deleteByPrimaryKey(Long id);

    long insert(HotelInfo record);

    long insertSelective(HotelInfo record);

    List<HotelInfo> selectByExample(HotelInfoExample example);

    HotelInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelInfo record);

    int updateByPrimaryKey(HotelInfo record);

    List<HotelInfo> selectByUserId(@Param("userId")Long userId);
}