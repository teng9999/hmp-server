package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.AppLoginInfo;
import cn.pl.hmp.server.dao.entity.AppLoginInfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AppLoginInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(AppLoginInfo record);

    int insertSelective(AppLoginInfo record);

    List<AppLoginInfo> selectByExample(AppLoginInfoExample example);
    
    List<AppLoginInfo> queryPages(@Param("name")String name,
            @Param("fixCondition")String fixCondition);

    AppLoginInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AppLoginInfo record);

    int updateByPrimaryKey(AppLoginInfo record);
}