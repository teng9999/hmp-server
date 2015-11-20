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
import cn.pl.hmp.commons.thrift.define.THotelRoom;
import cn.pl.hmp.commons.thrift.service.THotelRoomService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IHotelRoomBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoom;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class THotelRoomServiceIface implements THotelRoomService.Iface {
	
	@Autowired
	private IHotelRoomBusiness hotelRoomBusiness;

	@Override
	public int deleteById(long id) throws TException {
		return hotelRoomBusiness.deleteByHotelRoomId(id);
	}

	@Override
	public long save(THotelRoom record) throws TException {
		return hotelRoomBusiness.insert(ObjectConverter.convet(record, HotelRoom.class));
	}

	@Override
	public THotelRoom queryById(long id) throws TException {
		HotelRoom hotelRoom = hotelRoomBusiness.selectByHotelRoomId(id);
		return ObjectConverter.convet(hotelRoom, THotelRoom.class);
	}

	@Override
	public int update(THotelRoom record) throws TException {
		return hotelRoomBusiness.update(ObjectConverter.convet(record, HotelRoom.class));
	}

    @Override
    public Map<TPages, List<THotelRoom>> queryByPages(TPages pages)
            throws TException {
        Map<TPages,List<THotelRoom>> tmap = new HashMap<TPages, List<THotelRoom>>();
        TPages tempPage = null;
        Map<Pages,List<HotelRoom>> hotelRoomMap = hotelRoomBusiness.selectByPages(null,ObjectConverter.convet(pages, Pages.class));
        if(null != hotelRoomMap&& !hotelRoomMap.isEmpty()){
            Set<Pages> set = hotelRoomMap.keySet();
            for(Pages page:set){
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage,ObjectConverter.convet(hotelRoomMap.get(page), THotelRoom.class));
            }
        }
        return tmap;
    }

    @Override
    public int deleteOnbatch(List<Long> idList) throws TException {
        return hotelRoomBusiness.deleteOnBatch(idList);
    }

}
