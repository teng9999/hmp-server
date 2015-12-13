package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.MenuChannel;
import cn.pl.hmp.server.dao.entity.MenuChannelExample;

public interface MenuChannelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MenuChannel record);

    int insertSelective(MenuChannel record);

    List<MenuChannel> selectByExample(MenuChannelExample example);

    MenuChannel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MenuChannel record);

    int updateByPrimaryKey(MenuChannel record);

    List<MenuChannel> selectByParentId(@Param("parentId")Long parentId);

    List<MenuChannel> selectByParentIdList(@Param("parentId")Long parentId
            ,@Param(value="hotelId") Long hotelId);

    MenuChannel selectByMenuId(@Param("menuId")Long menuId);
}