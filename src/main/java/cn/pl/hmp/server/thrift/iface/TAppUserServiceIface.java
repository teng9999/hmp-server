package cn.pl.hmp.server.thrift.iface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pl.commons.pages.Pages;
import cn.pl.commons.utils.StringUtils;
import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrift.define.TPages;
import cn.pl.hmp.commons.thrift.define.TAppResidenceInfo;
import cn.pl.hmp.commons.thrift.define.TAppUser;
import cn.pl.hmp.commons.thrift.service.TAppUserService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IAppUserBusiness;
import cn.pl.hmp.server.dao.entity.AppUser;
import cn.pl.hmp.server.dao.entity.AppUserExample;
import cn.pl.hmp.server.dao.entity.AppUserExample.Criteria;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class TAppUserServiceIface implements TAppUserService.Iface{
    @Autowired
    private IAppUserBusiness userBusiness;
    @Override
    public int deleteById(long id) throws TException {
        return userBusiness.delete(id);
    }

    @Override
    public long insert(TAppUser record) throws TException {
        return userBusiness.insert(ObjectConverter.convet(record, AppUser.class));
    }

    @Override
    public TAppUser selectById(long id) throws TException {
        return ObjectConverter.convet(userBusiness.selectById(id),TAppUser.class);
    }

    @Override
    public TAppUser selectByUserName(String credNum,String name) throws TException {
        return ObjectConverter.convet(userBusiness.selectByUserName(credNum,name),TAppUser.class);
    }

    @Override
    public int update(TAppUser record) throws TException {
        return userBusiness.update(ObjectConverter.convet(record, AppUser.class));
    }

    @Override
    public Map<TPages, List<TAppUser>> selectByPages(TPages pages,
            String credType, String registration, String fixCondition)
            throws TException {
        Map<TPages, List<TAppUser>> tmap = new HashMap<TPages, List<TAppUser>>();
        AppUserExample example = new AppUserExample();
        Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(credType)) {
            criteria.andCredTypeEqualTo(Integer.parseInt(credType));
        }
        if(StringUtils.isNotBlank(registration)) {
            criteria.andRegistrationEqualTo(Integer.parseInt(registration));
        }
        if(StringUtils.isNotBlank(fixCondition)) {
            example.or().andCredNumEqualTo(fixCondition);
            example.or().andNameEqualTo(fixCondition);
            example.or().andMobileEqualTo(fixCondition);
        }
        TPages tempPage = null;
        Map<Pages, List<AppUser>> userMap = userBusiness.selectByPages(null, ObjectConverter.convet(pages, Pages.class));
        if (null != userMap && !userMap.isEmpty()) {
            Set<Pages> set = userMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(userMap.get(page), TAppUser.class));
            }
        }
        return tmap;
    }

    @Override
    public int resetPasswordByCred(String password, int credType, String credNum,String name)
            throws TException {
        return userBusiness.resetPasswordByCred(password, credType, credNum,name);
    }

    @Override
    public TAppResidenceInfo queryResidenceInfo(int credType, String credNum,
            String name) throws TException {
        return ObjectConverter.convet(userBusiness.queryResidenceInfo(credType, credNum, name)
                ,TAppResidenceInfo.class);
    }

}
