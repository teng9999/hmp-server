package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.MenuPages;
import cn.pl.hmp.server.dao.entity.MenuPagesExample;
import java.util.List;

public interface MenuPagesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MenuPages record);

    int insertSelective(MenuPages record);

    List<MenuPages> selectByExample(MenuPagesExample example);

    MenuPages selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MenuPages record);

    int updateByPrimaryKey(MenuPages record);
}