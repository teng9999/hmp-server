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
import cn.pl.hmp.commons.thrift.define.THmpHotelToolPacks;
import cn.pl.hmp.commons.thrift.service.THmpHotelToolPacksService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IHmpHotelToolPacksBusiness;
import cn.pl.hmp.server.dao.entity.HmpHotelToolPacks;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class THmpHotelToolPacksServiceIface implements THmpHotelToolPacksService.Iface {

    @Autowired
    private IHmpHotelToolPacksBusiness business;

    @Override
    public int deleteById(long id) throws TException {
        return business.delete(id);
    }

    @Override
    public long insert(THmpHotelToolPacks record) throws TException {

        return business.insert(ObjectConverter.convet(record, HmpHotelToolPacks.class));
    }

    @Override
    public int update(THmpHotelToolPacks record) throws TException {
        return business.update(ObjectConverter.convet(record, HmpHotelToolPacks.class));
    }
    
    @Override
    public List<THmpHotelToolPacks> queryList() throws TException {
    	return ObjectConverter.convet(business.queryList(), THmpHotelToolPacks.class);
    };

    @Override
    public List<THmpHotelToolPacks> selectAll() throws TException {
        return ObjectConverter.convet(business.selectAll(), THmpHotelToolPacks.class);
    }

    @Override
    public Map<TPages, List<THmpHotelToolPacks>> loadPages(TPages page) throws TException {
        Map<TPages, List<THmpHotelToolPacks>> tMap = new HashMap<TPages, List<THmpHotelToolPacks>>();
        TPages tempPage = null;
        Map<Pages, List<HmpHotelToolPacks>> tvMap = business.selectByPages(null, ObjectConverter.convet(page, Pages.class));
        if (null != tvMap && !tvMap.isEmpty()) {
            Set<Pages> set = tvMap.keySet();
            for (Pages pages : set) {
                tempPage = ServerTransform.transform(pages);
                tMap.put(tempPage, ObjectConverter.convet(tvMap.get(pages), THmpHotelToolPacks.class));
            }
        }
        return tMap;
    }
}
