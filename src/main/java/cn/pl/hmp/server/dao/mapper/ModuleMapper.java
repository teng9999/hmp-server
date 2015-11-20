package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.Module;
import cn.pl.hmp.server.dao.entity.ModuleExample;
import java.util.List;

public interface ModuleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExample(ModuleExample example);

    Module selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}