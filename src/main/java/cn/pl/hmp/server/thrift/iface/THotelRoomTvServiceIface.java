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
import cn.pl.hmp.commons.thrift.define.THotelRoomTv;
import cn.pl.hmp.commons.thrift.service.THotelRoomTvService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IHotelRoomTvBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoomTv;
import cn.pl.hmp.server.dao.entity.HotelRoomTvExample;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class THotelRoomTvServiceIface implements THotelRoomTvService.Iface {
    @Autowired
    private IHotelRoomTvBusiness roomRcuBusiness;
    @Override
    public Map<TPages, List<THotelRoomTv>> queryByPages(TPages pages,
            long hotelId) throws TException {
        Map<TPages, List<THotelRoomTv>> tmap = new HashMap<TPages, List<THotelRoomTv>>();
        HotelRoomTvExample example = new HotelRoomTvExample();
        example.createCriteria().andHotelIdEqualTo(hotelId);
        Map<Pages,List<HotelRoomTv>> roomRcuMap = roomRcuBusiness.selectByPages(example, ObjectConverter
                .convet(pages, Pages.class));
        TPages tempPage = null;
        if (null != roomRcuMap && !roomRcuMap.isEmpty()) {
            Set<Pages> set = roomRcuMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(roomRcuMap.get(page), THotelRoomTv.class));
            }
        }
        return tmap;
    }

}
