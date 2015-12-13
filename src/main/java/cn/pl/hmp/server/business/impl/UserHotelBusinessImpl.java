package cn.pl.hmp.server.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.hmp.server.business.iface.IUserHotelBusiness;
import cn.pl.hmp.server.dao.entity.UserHotel;
import cn.pl.hmp.server.dao.entity.UserHotelExample;
import cn.pl.hmp.server.dao.mapper.UserHotelMapper;

@Service
public class UserHotelBusinessImpl extends BoostBusinessImpl implements IUserHotelBusiness {

    @Autowired
    private UserHotelMapper mapper;

    @Override
    public int deleteById(Long id) {
        if (null == id)
            return 0;
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserHotel record) {
        if (null == record)
            return 0;
        return mapper.insert(record);
    }

    @Override
    public List<UserHotel> selectByUserId(Long id) {
        if (null == id)
            return null;
        UserHotelExample example = new UserHotelExample();
        example.createCriteria().andUserIdEqualTo(id);
        return mapper.selectByExample(example);
    }

    @Override
    public List<UserHotel> selectByHotelId(Long id) {
        if (null == id)
            return null;
        UserHotelExample example = new UserHotelExample();
        example.createCriteria().andHotelIdEqualTo(id);
        return mapper.selectByExample(example);
    }

    @Override
    public int update(UserHotel record) {
        if (null == record)
            return 0;
        return mapper.updateByPrimaryKeySelective(record);
    }

}
