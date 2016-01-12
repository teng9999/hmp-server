package cn.pl.hmp.server.thrift.iface;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pl.frame.annotation.ThriftService;
import cn.pl.hmp.commons.thrift.service.TDealOldDataService;
import cn.pl.hmp.server.business.iface.IDealOldDataBusiness;

@Component
@ThriftService
public class TDealOldDataServiceIface  implements TDealOldDataService.Iface {
    
    @Autowired
    private IDealOldDataBusiness dealDataBusiness;
    @Override
    public int dealOldRoomType() throws TException {
        
       return dealDataBusiness.dealOldRoomType();
    }
    @Override
    public int dealMenuChannelLitter() throws TException {
        return dealDataBusiness.dealMenuChannelLitter();
    }

}
