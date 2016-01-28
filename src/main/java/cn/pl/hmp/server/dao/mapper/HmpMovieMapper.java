package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.HmpMovie;
import cn.pl.hmp.server.dao.entity.HmpMovieExample;

public interface HmpMovieMapper {

    int countByExample(HmpMovieExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HmpMovie record);

    int insertSelective(HmpMovie record);

    List<HmpMovie> selectByExampleWithBLOBs(HmpMovieExample example);

    List<HmpMovie> selectByExample(HmpMovieExample example);

    HmpMovie selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HmpMovie record);

    int updateByPrimaryKeyWithBLOBs(HmpMovie record);

    int updateByPrimaryKey(HmpMovie record);

    List<HmpMovie> queryByIds(List<Long> ids);

    List<HmpMovie> queryByHotel(@Param("hotelId") Long hotelId,@Param("name") String name);

}