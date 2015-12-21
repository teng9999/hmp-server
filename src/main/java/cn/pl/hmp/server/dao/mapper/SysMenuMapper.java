package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.SysMenu;
import cn.pl.hmp.server.dao.entity.SysMenuExample;
import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}