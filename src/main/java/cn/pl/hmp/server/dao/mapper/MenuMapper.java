package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.Menu;
import cn.pl.hmp.server.dao.entity.MenuExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);
   

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    /**
     * 根据父级查所有子级菜单和路径
     * @param parentId
     * @return
     */
    List<Menu> selectWithTarget(@Param("parentId") Long parentId);
    
    List<Menu> selectHotelMenuByHotelId(@Param("hotelId")Long hotelId,
            @Param("parentId") Long parentId);
    
}