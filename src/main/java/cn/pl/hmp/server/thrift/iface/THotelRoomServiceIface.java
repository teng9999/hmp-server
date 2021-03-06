package cn.pl.hmp.server.thrift.iface;

import java.util.ArrayList;
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
import cn.pl.hmp.server.dao.entity.HotelRoomExample;
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
        HotelRoomExample example = new HotelRoomExample();
        example.createCriteria().andHotelIdEqualTo(record.getHotelId())
        .andRoomNumEqualTo(record.getRoomNum());
        List<HotelRoom> roomList = hotelRoomBusiness.selectByExample(example);
        if(null != roomList && !roomList.isEmpty()) {
            record.setId(roomList.get(0).getId());
            return hotelRoomBusiness.update(ObjectConverter.convet(record, HotelRoom.class));
        }
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
    public int deleteOnbatch(List<Long> idList) throws TException {
        return hotelRoomBusiness.deleteOnBatch(idList);
    }

    @Override
    public int saveBatch(THotelRoom record, String templateCfg, String roomNums) throws TException {
        return hotelRoomBusiness.saveOnBatch(ObjectConverter.convet(record, HotelRoom.class), templateCfg, roomNums);
    }

    @Override
    public long updateAndRcu(THotelRoom record, String rcutemplateStr, long hotelId) throws TException {
        return hotelRoomBusiness.updateAndRcu(ObjectConverter.convet(record, HotelRoom.class), rcutemplateStr, hotelId);
    }

    @Override
    public boolean checkByRoomNum(THotelRoom hotelRoom) throws TException {
        HotelRoomExample roomExample = new HotelRoomExample();
        roomExample.createCriteria().andHotelIdEqualTo(hotelRoom.getHotelId())
        .andRoomNumEqualTo(hotelRoom.getRoomNum());
        List<HotelRoom> roomList = hotelRoomBusiness.selectByExample(roomExample);
        if (null != roomList && roomList.size() > 0) {
            if(hotelRoom.getId() > 0 && hotelRoom.getId() == roomList.get(0).getId()) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public Map<TPages, List<THotelRoom>> queryByPages(TPages pages, long hotelId) throws TException {
        Map<TPages, List<THotelRoom>> tmap = new HashMap<TPages, List<THotelRoom>>();
        TPages tempPage = null;
        Map<Pages, List<HotelRoom>> hotelRoomMap = hotelRoomBusiness.selectByPages(hotelId,
                ObjectConverter.convet(pages, Pages.class));
        if (null != hotelRoomMap && !hotelRoomMap.isEmpty()) {
            Set<Pages> set = hotelRoomMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(hotelRoomMap.get(page), THotelRoom.class));
            }
        }
        return tmap;
    }

    @Override
    public List<THotelRoom> queryByRoomType(long hotelId, long typeId)
            throws TException {
        HotelRoomExample roomExample = new HotelRoomExample();
        roomExample.createCriteria().andHotelIdEqualTo(hotelId)
        .andRoomTypeEqualTo(typeId+"");
        List<HotelRoom> roomList = hotelRoomBusiness.selectByExample(roomExample); 
        if(null == roomList) {
            roomList = new ArrayList<HotelRoom>();
        }
        return ObjectConverter.convet(roomList, THotelRoom.class);
    }

    @Override
    public long saveRoomAndType(THotelRoom record) throws TException {
        return hotelRoomBusiness.insertRoomAndType(ObjectConverter.convet(record, HotelRoom.class));
    }

    @Override
    public int updateRcuTimeOnBatch(THotelRoom record, String roomNums)
            throws TException {
        return hotelRoomBusiness.updateRcuTimeOnBatch(ObjectConverter.convet(record, HotelRoom.class),
                roomNums);
    }

}
