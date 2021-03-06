package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import cn.pl.hmp.server.dao.entity.SysProgPkgs;
import cn.pl.hmp.server.dao.entity.SysProgPkgsExample;

public interface SysProgPkgsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysProgPkgs record);

    int insertSelective(SysProgPkgs record);

    List<SysProgPkgs> selectByExample(SysProgPkgsExample example);

    SysProgPkgs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysProgPkgs record);

    int updateByPrimaryKey(SysProgPkgs record);
}