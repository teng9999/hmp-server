package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.MenuPages;
import cn.pl.hmp.server.dao.entity.MenuPagesExample;

public interface MenuPagesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MenuPages record);

    int insertSelective(MenuPages record);

    List<MenuPages> selectByExample(MenuPagesExample example);

    MenuPages selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MenuPages record);

    int updateByPrimaryKey(MenuPages record);

    List<MenuPages> selectByMenuId(@Param(value="channelId")Long channelId);

    int deleteByChannelId(@Param(value="channelId") Long channelId);
    
    List<MenuPages> selectByHotel(@Param(value="hotelId") Long hotelId);
}