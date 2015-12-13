package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import cn.pl.hmp.server.dao.entity.APPInfo;
import cn.pl.hmp.server.dao.entity.APPInfoExample;

public interface APPInfoMapper {
    int countByExample(APPInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(APPInfo record);

    int insertSelective(APPInfo record);

    List<APPInfo> selectByExample(APPInfoExample example);

    APPInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(APPInfo record);

    int updateByPrimaryKey(APPInfo record);
}