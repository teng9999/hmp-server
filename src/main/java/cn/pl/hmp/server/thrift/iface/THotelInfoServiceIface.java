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
import cn.pl.hmp.commons.thrift.define.THotelInfo;
import cn.pl.hmp.commons.thrift.service.THotelInfoService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IHotelInfoBusiness;
import cn.pl.hmp.server.dao.entity.HotelInfo;
import cn.pl.hmp.server.thrift.transform.ServerTransform;


@Component
@ThriftService
public class THotelInfoServiceIface implements THotelInfoService.Iface{
	
	@Autowired
	private IHotelInfoBusiness hotelBusiness;
	@Override
	public int deleteById(long id) throws TException {
		return hotelBusiness.deleteByHotelId(id);
	}

	@Override
	public long save(THotelInfo record) throws TException {
		return hotelBusiness.insert(ObjectConverter.convet(record, HotelInfo.class));
	}

	@Override
	public THotelInfo selectByHotelId(long id) throws TException {
		return ObjectConverter.convet(hotelBusiness.selectByHotelId(id),THotelInfo.class);
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
    public Map<TPages, List<THotelInfo>> queryByPages(TPages pages)
            throws TException {
        
        Map<TPages,List<THotelInfo>> tmap = new HashMap<TPages, List<THotelInfo>>();
        TPages tempPage = null;
        Map<Pages,List<HotelInfo>> userMap = hotelBusiness.selectByPages(null,ObjectConverter.convet(pages, Pages.class));
        if(null != userMap&& !userMap.isEmpty()){
            Set<Pages> set = userMap.keySet();
            for(Pages page:set){
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage,ObjectConverter.convet(userMap.get(page), THotelInfo.class));
            }
        }
        return tmap;
    }

    @Override
    public int deleteOnBatch(List<Long> idList) throws TException {
        // TODO Auto-generated method stub
        return 0;
    }

}
