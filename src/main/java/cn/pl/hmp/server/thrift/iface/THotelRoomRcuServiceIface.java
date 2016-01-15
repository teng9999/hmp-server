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
import cn.pl.hmp.commons.thrift.define.THotelRoomRcu;
import cn.pl.hmp.commons.thrift.service.THotelRoomRcuService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IHotelRCUCfgBusiness;
import cn.pl.hmp.server.business.iface.IHotelRoomRcuBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoomRcu;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class THotelRoomRcuServiceIface implements THotelRoomRcuService.Iface {
    @Autowired
    private IHotelRoomRcuBusiness roomRcuBusiness;
    @Autowired
    private IHotelRCUCfgBusiness rcuCfgBusiness;
    @Override
    public Map<TPages, List<THotelRoomRcu>> queryByPages(TPages pages,
            long hotelId) throws TException {
        Map<TPages, List<THotelRoomRcu>> tmap = new HashMap<TPages, List<THotelRoomRcu>>();
        
        Map<Pages,List<HotelRoomRcu>> roomRcuMap = roomRcuBusiness.selectPagesByRoom(hotelId,ObjectConverter
                .convet(pages, Pages.class));
        TPages tempPage = null;
        if (null != roomRcuMap && !roomRcuMap.isEmpty()) {
            Set<Pages> set = roomRcuMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(roomRcuMap.get(page), THotelRoomRcu.class));
            }
        }
        return tmap;
    }
    @Override
    public int update(THotelRoomRcu roomRcu) throws TException {
        return roomRcuBusiness.update(ObjectConverter.convet(roomRcu, HotelRoomRcu.class));
    }
    @Override
    public int updateOnBatch(THotelRoomRcu roomRcu, String roomNums)
            throws TException {
        return roomRcuBusiness.updateOnBatch(ObjectConverter.convet(roomRcu, HotelRoomRcu.class),
                roomNums);
    }

}
