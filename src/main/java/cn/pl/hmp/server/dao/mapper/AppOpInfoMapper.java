package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import cn.pl.hmp.server.dao.entity.AppOpInfo;
import cn.pl.hmp.server.dao.entity.AppOpInfoExample;

public interface AppOpInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppOpInfo record);

    int insertSelective(AppOpInfo record);

    List<AppOpInfo> selectByExample(AppOpInfoExample example);

    AppOpInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppOpInfo record);

    int updateByPrimaryKey(AppOpInfo record);
    
    int insertOnBatch(List<AppOpInfo> list);
}