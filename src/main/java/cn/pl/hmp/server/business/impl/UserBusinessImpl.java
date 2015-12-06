package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IUserBusiness;
import cn.pl.hmp.server.dao.entity.HmpMGHotel;
import cn.pl.hmp.server.dao.entity.HotelInfo;
import cn.pl.hmp.server.dao.entity.User;
import cn.pl.hmp.server.dao.entity.UserExample;
import cn.pl.hmp.server.dao.entity.UserHotel;
import cn.pl.hmp.server.dao.entity.UserHotelExample;
import cn.pl.hmp.server.dao.mapper.HmpMGHotelMapper;
import cn.pl.hmp.server.dao.mapper.HotelInfoMapper;
import cn.pl.hmp.server.dao.mapper.UserHotelMapper;
import cn.pl.hmp.server.dao.mapper.UserMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserBusinessImpl extends BoostBusinessImpl implements IUserBusiness{
	@Autowired
	private UserMapper mapper;
	@Autowired
	private HotelInfoMapper hotelMapper;
	@Autowired
	private HmpMGHotelMapper mgHotelMapper;
	@Autowired
	private UserHotelMapper userHotelMapper;

	@Override
	public int deleteUserAndHotelByUserId(Long id) {
	    UserHotelExample userHotelExample = new UserHotelExample();
	    userHotelExample.createCriteria().andUserIdEqualTo(id);
	    List<UserHotel> userHotelList = userHotelMapper.selectByExample(userHotelExample);
	    if(null != userHotelList && !userHotelList.isEmpty()) {
	        for(UserHotel userHotel : userHotelList) {
	            hotelMapper.deleteByPrimaryKey(userHotel.getHotelId());
	            userHotelMapper.deleteByPrimaryKey(userHotel.getId());
	        }
	    }
	    return  mapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public long insert(User record) {
	    if(null == record) {
	        return 0;
	    }
	    mapper.insertSelective(record);
		return record.getId();
	}

	@Override
	public User selectByUserId(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> selectAll() {
		return mapper.selectByExample(new UserExample());
	}

	@Override
	public int update(User record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

    @Override
    public Map<Pages, List<User>> selectByPages(UserExample example,
            Pages page) {
        Map<Pages,List<User>> map = new HashMap<Pages, List<User>>();
        if(null == example)
            example = new UserExample();
        PageHelper.startPage(page.getPageNum(),page.getPageSize()); 
        System.out.println(page.getPageNum()+"--"+page.getPageSize());
        List<User> userList = mapper.selectByExample(example);
        if(null == userList)
            userList = new ArrayList<User>();
        PageInfo<User> pageInfo =  new PageInfo<User>(userList);
        Pages pages = PageConverter.converter(pageInfo);
        
        map.put(pages, userList);
        return map;
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
        return mapper.deleteOnBatch(idList);
    }

    @Override
    public List<User> selectByExample(UserExample example) {
       if(null == example) {
           return null;
       }
       return mapper.selectByExample(example);
    }

    @Override
    public long insertAll(User user, HotelInfo hotelInfo) {
        Long userRes = mapper.insertSelective(user);
        Long hotelRes = hotelMapper.insertSelective(hotelInfo);
        if(userRes>0&&hotelRes>0) {
            UserHotel userHotel = new UserHotel();
            userHotel.setUserId(user.getId());
            userHotel.setHotelId(hotelInfo.getId());
            userHotel.setCreateTime(user.getCreateTime());
            userHotel.setCreator(user.getCreator());
            userHotelMapper.insert(userHotel);
        }
        String movieGroup = hotelInfo.getMovieGroup();
        if(null != movieGroup &&!("".equals(movieGroup))) {
            Long MovieGroupId = 0L;
            MovieGroupId = Long.parseLong(movieGroup);
            HmpMGHotel mgHotel = new HmpMGHotel();
            mgHotel.setCreateTime(user.getCreateTime());
            mgHotel.setCreator(user.getCreator());
            mgHotel.setGroupId(MovieGroupId);
            mgHotel.setHotelId(hotelInfo.getId());
            mgHotelMapper.insertSelective(mgHotel);
        }
        return user.getId();
    }

    @Override
    public int updateAll(User user, HotelInfo hotelInfo) {
        int userRes = mapper.updateByPrimaryKeySelective(user);
        UserHotelExample userHotelExample = new UserHotelExample();
        userHotelExample.createCriteria().andUserIdEqualTo(user.getId());
        List<UserHotel> userHotelList = userHotelMapper.selectByExample(userHotelExample);
        if(null == userHotelList || userHotelList.size()<1) {
            return 0;
        }
        
        hotelInfo.setId(userHotelList.get(0).getHotelId());
        int hotelRes = hotelMapper.updateByPrimaryKeySelective(hotelInfo);
        String movieGroup = hotelInfo.getMovieGroup();
        if(null != movieGroup &&!("".equals(movieGroup))) {
            mgHotelMapper.delelteByHotelId(hotelInfo.getId());
            Long MovieGroupId = 0L;
            MovieGroupId = Long.parseLong(movieGroup);
            HmpMGHotel mgHotel = new HmpMGHotel();
            mgHotel.setCreateTime(user.getCreateTime());
            mgHotel.setCreator(user.getCreator());
            mgHotel.setGroupId(MovieGroupId);
            mgHotel.setHotelId(hotelInfo.getId());
            mgHotelMapper.insertSelective(mgHotel);
        }
        return userRes+hotelRes;
    }

}
