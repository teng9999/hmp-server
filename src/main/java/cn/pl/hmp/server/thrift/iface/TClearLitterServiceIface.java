package cn.pl.hmp.server.thrift.iface;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pl.frame.annotation.ThriftService;
import cn.pl.hmp.commons.thrift.service.TClearLitterService;
import cn.pl.hmp.server.business.iface.IClearLitterBusiness;

@Component
@ThriftService
public class TClearLitterServiceIface implements TClearLitterService.Iface {
    @Autowired
    private IClearLitterBusiness clearLitterBusiness;

    @Override
    public long deleteAllDataExceptHotelId(long hotelId) throws TException {
        try {
            clearLitterBusiness.deleteAllDataExceptHotelId(hotelId);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public long deleteAllDataExceptHotelName(String hotelName) throws TException {
        // TODO Auto-generated method stub
        return 0;
    }

}
