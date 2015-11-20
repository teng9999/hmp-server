package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.Menu;
import cn.pl.hmp.server.dao.entity.MenuExample;
import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}