package cn.pl.hmp.server.thrift.iface;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import cn.pl.frame.annotation.ThriftService;
import cn.pl.hmp.commons.thrift.service.TPublishService;
import cn.pl.hmp.server.business.iface.IHmpRoomTvBusiness;
import cn.pl.hmp.server.business.iface.IHotelInfoBusiness;
import cn.pl.hmp.server.business.iface.IHotelRoomBusiness;
import cn.pl.hmp.server.business.iface.IMenuChannelBusiness;

@Component
@ThriftService
public class TPublishServiceIface implements TPublishService.Iface {
    @Autowired
    private IHotelInfoBusiness hotelBusiness;
    @Autowired
    private IMenuChannelBusiness channelBusiness;
    @Autowired
    private IHotelRoomBusiness roomBusiness;
    @Autowired
    private IHmpRoomTvBusiness roomTvBusiness;

    @Override
    public String publish(long hotelId) throws TException {
        JSONObject topObj = new JSONObject();
        topObj.put("hotel", hotelBusiness.publish(hotelId));
        topObj.put("room", roomBusiness.publish(hotelId));
        topObj.put("menuChannel", channelBusiness.publish(hotelId));
        topObj.put("roomTv", roomTvBusiness.publish(hotelId));
        return topObj.toString();
    }
}
