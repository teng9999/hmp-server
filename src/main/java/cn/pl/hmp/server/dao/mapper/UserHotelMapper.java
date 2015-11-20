package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.UserHotel;
import cn.pl.hmp.server.dao.entity.UserHotelExample;
import java.util.List;

public interface UserHotelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserHotel record);

    int insertSelective(UserHotel record);

    List<UserHotel> selectByExample(UserHotelExample example);

    UserHotel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserHotel record);

    int updateByPrimaryKey(UserHotel record);
}