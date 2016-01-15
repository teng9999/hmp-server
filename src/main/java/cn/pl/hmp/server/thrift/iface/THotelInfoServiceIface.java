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
import cn.pl.hmp.commons.thrift.define.THotelInfo;
import cn.pl.hmp.commons.thrift.define.TUser;
import cn.pl.hmp.commons.thrift.service.THotelInfoService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IHotelInfoBusiness;
import cn.pl.hmp.server.dao.entity.HotelInfo;
import cn.pl.hmp.server.dao.entity.HotelInfoExample;
import cn.pl.hmp.server.dao.entity.HotelInfoExample.Criteria;
import cn.pl.hmp.server.dao.entity.User;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class THotelInfoServiceIface implements THotelInfoService.Iface {

    @Autowired
    private IHotelInfoBusiness hotelBusiness;
    // @Autowired
    // private IUserHotelBusiness userHotelBusiness;

    @Override
    public int deleteById(long id) throws TException {
        return hotelBusiness.deleteHotelAndUserByHotelId(id);
    }

    @Override
    public long save(THotelInfo record) throws TException {
        return hotelBusiness.insert(ObjectConverter.convet(record, HotelInfo.class));
    }

    @Override
    public THotelInfo selectByHotelId(long id) throws TException {
        return ObjectConverter.convet(hotelBusiness.selectListWithUserByHotelId(id), THotelInfo.class);
    }

    @Override
    public List<THotelInfo> queryAll() throws TException {
        return ObjectConverter.convet(hotelBusiness.selectAll(), THotelInfo.class);
    }

    @Override
    public int update(THotelInfo record) throws TException {
        return hotelBusiness.update(ObjectConverter.convet(record, HotelInfo.class));
    }

    @Override
    public Map<TPages, List<THotelInfo>> queryByPages(TPages pages) throws TException {

        Map<TPages, List<THotelInfo>> tmap = new HashMap<TPages, List<THotelInfo>>();
        TPages tempPage = null;
        Map<Pages, List<HotelInfo>> userMap = hotelBusiness.selectByPages(null,
                ObjectConverter.convet(pages, Pages.class));
        if (null != userMap && !userMap.isEmpty()) {
            Set<Pages> set = userMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(userMap.get(page), THotelInfo.class));
            }
        }
        return tmap;
    }

    @Override
    public int deleteOnBatch(List<Long> idList) throws TException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<THotelInfo> selectByUserId(long id) throws TException {
        return ObjectConverter.convet(hotelBusiness.selectByUserId(id), THotelInfo.class);
    }

    @Override
    public long saveAll(THotelInfo record, TUser user) throws TException {
        return hotelBusiness.saveAll(ObjectConverter.convet(record, HotelInfo.class),
                ObjectConverter.convet(user, User.class));
    }

    @Override
    public Map<TPages, List<THotelInfo>> queryByPagesWithMonitor(TPages pages,
            String condition, String name,String province) throws TException {
        HotelInfoExample example = new HotelInfoExample();
        Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(condition)) {
            criteria.andSubNameLike("%"+condition+"%");
        }
        if(StringUtils.isNotBlank(name)) {
            criteria.andNameEqualTo(name);
        }
        if(StringUtils.isNotBlank(province)) {
            criteria.andProvinceEqualTo(province);
        }
        Map<TPages, List<THotelInfo>> tmap = new HashMap<TPages, List<THotelInfo>>();
        TPages tempPage = null;
        Map<Pages, List<HotelInfo>> userMap = hotelBusiness.selectByPages(example,
                ObjectConverter.convet(pages, Pages.class));
        if (null != userMap && !userMap.isEmpty()) {
            Set<Pages> set = userMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(userMap.get(page), THotelInfo.class));
            }
        }
        return tmap;
    }

    @Override
    public Map<TPages, List<THotelInfo>> queryByPagesWithUser(TPages pages,
            String province, String name, String condition) throws TException {
        if (StringUtils.isBlank(province)) {
            province = null;
        }
        if (StringUtils.isBlank(name)) {
            name = null;
        }
        if (StringUtils.isBlank(condition)) {
            condition = null;
        }
        Map<TPages, List<THotelInfo>> tmap = new HashMap<TPages, List<THotelInfo>>();
        TPages tempPage = null;
        Map<Pages, List<HotelInfo>> userMap = hotelBusiness.selectByPagesWithUser(
                ObjectConverter.convet(pages, Pages.class), 
                province, name, condition);
        if (null != userMap && !userMap.isEmpty()) {
            Set<Pages> set = userMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(userMap.get(page), THotelInfo.class));
            }
        }
        return tmap;
    }
}
