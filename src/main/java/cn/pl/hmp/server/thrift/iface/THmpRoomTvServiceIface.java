package cn.pl.hmp.server.thrift.iface;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pl.frame.annotation.ThriftService;
import cn.pl.hmp.commons.thrift.define.THmpRoomTv;
import cn.pl.hmp.commons.thrift.service.THmpRoomTvService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IHmpRoomTvBusiness;
import cn.pl.hmp.server.dao.entity.HmpRoomTv;

@Component
@ThriftService
public class THmpRoomTvServiceIface implements THmpRoomTvService.Iface {

    @Autowired
    private IHmpRoomTvBusiness business;

    @Override
    public THmpRoomTv selectByHotelId(long hotelId) throws TException {
        HmpRoomTv roomTv = business.selectByHotelId(hotelId);
        if (null == roomTv) {
            roomTv = new HmpRoomTv();
        }
        return ObjectConverter.convet(roomTv, THmpRoomTv.class);
    }

    @Override
    public int deleteById(long id) throws TException {
        return business.deleteByHmpRoomTvId(id);
    }

    @Override
    public long insert(THmpRoomTv record) throws TException {
        return business.insert(ObjectConverter.convet(record, HmpRoomTv.class));
    }

    @Override
    public int updateById(THmpRoomTv record) throws TException {
        return business.update(ObjectConverter.convet(record, HmpRoomTv.class));
    }

    @Override
    public List<THmpRoomTv> selectAll() throws TException {
        List<HmpRoomTv> roomTvList = business.selectAll();
        if (null == roomTvList) {
            roomTvList = new ArrayList<HmpRoomTv>();
        }
        return ObjectConverter.convet(roomTvList, THmpRoomTv.class);
    }

}
