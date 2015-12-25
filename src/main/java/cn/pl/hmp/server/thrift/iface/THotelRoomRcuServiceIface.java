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
import cn.pl.hmp.commons.thrift.define.THotelRoomRcu;
import cn.pl.hmp.commons.thrift.service.THotelRoomRcuService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IHotelRCUCfgBusiness;
import cn.pl.hmp.server.business.iface.IHotelRoomRcuBusiness;
import cn.pl.hmp.server.dao.entity.HotelRCUCfg;
import cn.pl.hmp.server.dao.entity.HotelRCUCfgExample;
import cn.pl.hmp.server.dao.entity.HotelRoomRcu;
import cn.pl.hmp.server.dao.entity.HotelRoomRcuExample;
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
        HotelRoomRcuExample example = new HotelRoomRcuExample();
        example.createCriteria().andHotelIdEqualTo(hotelId);
        
        HotelRCUCfgExample cfgExample = new HotelRCUCfgExample();
        cfgExample.createCriteria().andHotelIdEqualTo(hotelId);
        List<HotelRCUCfg> cfgList = rcuCfgBusiness.query(cfgExample);
        int limitTime = 0;
        if(null != cfgList && !cfgList.isEmpty()) {
            String timeLock = cfgList.get(0).getTimeLock();
            if(StringUtils.isNotBlank(timeLock)) {
                limitTime = Integer.parseInt(timeLock);
            }
        }
        Map<Pages,List<HotelRoomRcu>> roomRcuMap = roomRcuBusiness.selectByPages(example, ObjectConverter
                .convet(pages, Pages.class));
        TPages tempPage = null;
        if (null != roomRcuMap && !roomRcuMap.isEmpty()) {
            Set<Pages> set = roomRcuMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                List<HotelRoomRcu> rcuList = roomRcuMap.get(page);
                for(HotelRoomRcu roomRcu:rcuList) {
                    if(null == roomRcu.getLimitedTime()) {
                        roomRcu.setLimitedTime(limitTime);
                    }
                }
                tmap.put(tempPage, ObjectConverter.convet(roomRcuMap.get(page), THotelRoomRcu.class));
            }
        }
        return tmap;
    }

}
