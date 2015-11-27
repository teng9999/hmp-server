package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IUserBusiness;
import cn.pl.hmp.server.dao.entity.User;
import cn.pl.hmp.server.dao.entity.UserExample;
import cn.pl.hmp.server.dao.mapper.UserMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserBusinessImpl extends BoostBusinessImpl implements IUserBusiness{

	@Autowired
	private UserMapper mapper;

	@Override
	public int deleteByUserId(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public long insert(User record) {
		return mapper.insert(record);
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
		return mapper.updateByPrimaryKey(record);
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

}
