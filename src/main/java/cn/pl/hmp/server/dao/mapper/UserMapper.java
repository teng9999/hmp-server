package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.User;
import cn.pl.hmp.server.dao.entity.UserExample;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);
    
    int deleteOnBatch(List<Long> idList);

    long insert(User record);

    long insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    
}