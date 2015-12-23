package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.User;
import cn.pl.hmp.server.dao.entity.UserExample;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int deleteOnBatch(List<Long> idList);

    long insert(User record);

    long insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectByHotelId(@Param("hotelId")Long hotelId);

}