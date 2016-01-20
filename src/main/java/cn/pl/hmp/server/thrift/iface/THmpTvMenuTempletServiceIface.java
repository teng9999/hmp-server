package cn.pl.hmp.server.thrift.iface;

import java.util.ArrayList;
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
import cn.pl.frame.thrift.exception.ThriftException;
import cn.pl.hmp.commons.thrift.define.THmpTvMenuTemplet;
import cn.pl.hmp.commons.thrift.define.THotelRCUCfg;
import cn.pl.hmp.commons.thrift.service.THmpTvMenuTempletService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IHmpTvMenuTempletBusiness;
import cn.pl.hmp.server.dao.entity.HmpTvMenuTemplet;
import cn.pl.hmp.server.dao.entity.HotelRCUCfg;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class THmpTvMenuTempletServiceIface implements THmpTvMenuTempletService.Iface {

    @Autowired
    private IHmpTvMenuTempletBusiness business;

    @Override
    public int deleteById(long id) throws TException {
        return business.deleteById(id);
    }

    @Override
    public long insert(THmpTvMenuTemplet record) throws TException {
        return business.insert(ObjectConverter.convet(record, HmpTvMenuTemplet.class));
    }

    @Override
    public int updateById(THmpTvMenuTemplet record) throws TException {
        return business.update(ObjectConverter.convet(record, HmpTvMenuTemplet.class));
    }

    @Override
    public int deleteOnBatch(List<Long> idList) throws TException {
        return business.deleteOnBatch(idList);
    }

    @Override
    public List<THmpTvMenuTemplet> selectAll() throws TException {
        return ObjectConverter.convet(business.selectAll(), THmpTvMenuTemplet.class);
    }

    @Override
    public Map<TPages, List<THmpTvMenuTemplet>> loadPages(TPages page) throws TException {
        Map<TPages, List<THmpTvMenuTemplet>> tMap = new HashMap<TPages, List<THmpTvMenuTemplet>>();
        TPages tempPage = null;
        Map<Pages, List<HmpTvMenuTemplet>> tvMap = business.selectByPages(null, ObjectConverter.convet(page, Pages.class));
        if (null != tvMap && !tvMap.isEmpty()) {
            Set<Pages> set = tvMap.keySet();
            for (Pages pages : set) {
                tempPage = ServerTransform.transform(pages);
                tMap.put(tempPage, listTransform(tvMap.get(pages)));
            }
        }
        return tMap;
    }
    
    private List<THmpTvMenuTemplet> listTransform(List<HmpTvMenuTemplet> lists) {
        List<THmpTvMenuTemplet> resultLists = new ArrayList<THmpTvMenuTemplet>();
        if (lists != null && lists.size() > 0) {
            for (HmpTvMenuTemplet temp : lists) {
            	THmpTvMenuTemplet result = ServerTransform.transform(temp);
                resultLists.add(result);
            }
        }
        return resultLists;
    }

	@Override
	public THmpTvMenuTemplet selectByPrimaryKey(long id) throws ThriftException, TException {
		return ObjectConverter.convet(business.selectByPrimaryKey(id), THmpTvMenuTemplet.class);
	}
}
