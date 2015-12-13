package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.PublishPkgs;
import cn.pl.hmp.server.dao.entity.PublishPkgsExample;

public interface PublishPkgsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PublishPkgs record);

    int insertSelective(PublishPkgs record);

    List<PublishPkgs> selectByExample(PublishPkgsExample example);

    PublishPkgs selectByPrimaryKey(Long id);

    PublishPkgs selectByHotelIdWhichLastTime(@Param(value="hotelId")Long hotelId);

    int updateByPrimaryKeySelective(PublishPkgs record);

    int updateByPrimaryKey(PublishPkgs record);
}