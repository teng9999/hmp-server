package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.AppLoginInfo;
import cn.pl.hmp.server.dao.entity.AppLoginInfoExample;
import java.util.List;

public interface AppLoginInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(AppLoginInfo record);

    int insertSelective(AppLoginInfo record);

    List<AppLoginInfo> selectByExample(AppLoginInfoExample example);

    AppLoginInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AppLoginInfo record);

    int updateByPrimaryKey(AppLoginInfo record);
}