package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.AppResidenceInfo;
import cn.pl.hmp.server.dao.entity.AppUser;
import cn.pl.hmp.server.dao.entity.AppUserExample;

public interface AppUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppUser record);

    int insertSelective(AppUser record);

    List<AppUser> selectByExample(AppUserExample example);
    
    List<AppUser> selectByCondition(@Param("credType")String credType, 
            @Param("registration")String registration, @Param("fixCondition")String fixCondition);

    AppUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppUser record);

    int updateByPrimaryKey(AppUser record);
    
    List<AppResidenceInfo> queryResidenceInfo(@Param("credType")int credType,
            @Param("credNum")String credNum,@Param("name")String name);
}