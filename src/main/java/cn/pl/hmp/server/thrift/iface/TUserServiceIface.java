package cn.pl.hmp.server.thrift.iface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pl.commons.pages.Pages;
import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrift.define.TPages;
import cn.pl.hmp.commons.thrift.define.TUser;
import cn.pl.hmp.commons.thrift.service.TUserService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IUserBusiness;
import cn.pl.hmp.server.dao.entity.User;
import cn.pl.hmp.server.dao.entity.UserExample;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class TUserServiceIface implements TUserService.Iface {
	
	@Autowired
	private IUserBusiness userBusiness;
	@Override
	public List<TUser> queryAll() throws TException {
		return ObjectConverter.convet(userBusiness.selectAll(), TUser.class);
	}

	@Override
	public int deleteById(long id) throws TException {
		return userBusiness.deleteByUserId(id);
	}

	@Override
	public long save(TUser record) throws TException {
		return userBusiness.insert(ObjectConverter.convet(record, User.class));
	}

	@Override
	public TUser queryById(long id) throws TException {
		User user = userBusiness.selectByUserId(id);
		return ObjectConverter.convet(user, TUser.class);
	}

	@Override
	public int update(TUser record) throws TException {
		return userBusiness.update(ObjectConverter.convet(record, User.class));
	}

    @Override
    public Map<TPages, List<TUser>> queryByPages(TPages pages)
            throws TException {
        Map<TPages,List<TUser>> tmap = new HashMap<TPages, List<TUser>>();
        TPages tempPage = null;
        Map<Pages,List<User>> userMap = userBusiness.selectByPages(null,ObjectConverter.convet(pages, Pages.class));
        if(null != userMap&& !userMap.isEmpty()){
            Set<Pages> set = userMap.keySet();
            for(Pages page:set){
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage,ObjectConverter.convet(userMap.get(page), TUser.class));
            }
        }
        return tmap;
    }

    @Override
    public int deleteOnbatch(List<Long> idList) throws TException {
        return userBusiness.deleteOnBatch(idList);
    }

    @Override
    public TUser queryByUserName(String userName) throws TException {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        User user = null;
        List<User> list = userBusiness.selectByExample(example);
        if(null != list && list.size()>0) {
            user = list.get(0);
        }
        return ObjectConverter.convet(user, TUser.class);
    }

}
