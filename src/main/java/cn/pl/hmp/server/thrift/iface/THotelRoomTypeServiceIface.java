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
import cn.pl.hmp.commons.thrift.define.THotelRoomType;
import cn.pl.hmp.commons.thrift.service.THotelRoomTypeService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IHotelRoomTypeBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoomType;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class THotelRoomTypeServiceIface implements THotelRoomTypeService.Iface {
   
    @Autowired
    private IHotelRoomTypeBusiness roomTypeBusiness;
    @Override
    public int deleteById(long id) throws TException {
        return roomTypeBusiness.delete(id);
    }

    @Override
    public int deleteOnbatch(List<Long> idList) throws TException {
        return roomTypeBusiness.deleteOnBatch(idList);
    }

    @Override
    public long save(THotelRoomType record) throws TException {
        return roomTypeBusiness.insert(ObjectConverter.convet(record, HotelRoomType.class));
    }

    @Override
    public int update(THotelRoomType record) throws TException {
        return roomTypeBusiness.update(ObjectConverter.convet(record, HotelRoomType.class));
    }

    @Override
    public THotelRoomType queryById(long id) throws TException {
        return ObjectConverter.convet(roomTypeBusiness.selectById(id),THotelRoomType.class);
    }

    @Override
    public Map<TPages, List<THotelRoomType>> queryByPages(long hotelId,
            TPages pages) throws TException {
        Map<TPages, List<THotelRoomType>> tmap = new HashMap<TPages, List<THotelRoomType>>();
        
        Map<Pages, List<HotelRoomType>> roomTypeMap = roomTypeBusiness.selectByPages(hotelId, 
                ObjectConverter.convet(pages, Pages.class));
        TPages tempPage = null;
        if (null != roomTypeMap && !roomTypeMap.isEmpty()) {
            Set<Pages> set = roomTypeMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(roomTypeMap.get(page), THotelRoomType.class));
            }
        }
        return tmap;
    }

    @Override
    public boolean checkRoomTypeName(String name, long hotelId)
            throws TException {
        return roomTypeBusiness.checkName(hotelId, name);
    }

}
