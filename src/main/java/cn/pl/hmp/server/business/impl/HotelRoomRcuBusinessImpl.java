package cn.pl.hmp.server.business.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.commons.utils.StringUtils;
import cn.pl.hmp.server.business.iface.IHotelRoomRcuBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoomRcu;
import cn.pl.hmp.server.dao.entity.HotelRoomRcuExample;
import cn.pl.hmp.server.dao.mapper.HotelRoomRcuMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class HotelRoomRcuBusinessImpl extends BoostBusinessImpl implements IHotelRoomRcuBusiness{
    @Autowired
    private HotelRoomRcuMapper mapper;
//    @Autowired
//    private HotelRCUCfgMapper rcuCfgMapper;
    @Override
    public int delete(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public long insert(HotelRoomRcu record) {
        mapper.insertSelective(record);
        return record.getId();
    }

    @Override
    public HotelRoomRcu selectById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<Pages, List<HotelRoomRcu>> selectByPages(
            HotelRoomRcuExample example, Pages page) {
        Map<Pages, List<HotelRoomRcu>> map = new HashMap<Pages, List<HotelRoomRcu>>();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<HotelRoomRcu> hotelRoomRcuList = mapper.selectByExample(example);
        PageInfo<HotelRoomRcu> pageInfo = new PageInfo<HotelRoomRcu>(hotelRoomRcuList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, hotelRoomRcuList);
        return map;
    }

    @Override
    public int update(HotelRoomRcu record) {
        record.setRunningTime(null);
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Map<Pages, List<HotelRoomRcu>> selectPagesByRoom(Long hotelId,
            Pages page) {
        Map<Pages, List<HotelRoomRcu>> map = new HashMap<Pages, List<HotelRoomRcu>>();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<HotelRoomRcu> hotelRoomRcuList = mapper.selectListByHotel(hotelId);
        PageInfo<HotelRoomRcu> pageInfo = new PageInfo<HotelRoomRcu>(hotelRoomRcuList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, hotelRoomRcuList);
        return map;
    }

    @Override
    public int updateOnBatch(HotelRoomRcu record, String roomNums) {
        int count = 0;
        if(StringUtils.isBlank(roomNums)) {
            return count;
        }
        HotelRoomRcuExample roomRcuExample = new HotelRoomRcuExample();
        roomRcuExample.createCriteria().andHotelIdEqualTo(record.getHotelId());
        List<HotelRoomRcu> roomRcuList = mapper.selectByExample(roomRcuExample);
        Map<String,HotelRoomRcu> roomNumMap = new HashMap<String,HotelRoomRcu>();
        for(HotelRoomRcu roomRcu : roomRcuList) {
            roomNumMap.put(roomRcu.getRoomNum(), roomRcu);
        }
        Date nowDate = new Date();
        HotelRoomRcu updateRoomRcu = null;
        HotelRoomRcu addRoomRcu = new HotelRoomRcu();
        addRoomRcu.setCreateTime(nowDate);
        addRoomRcu.setLimitedTime(record.getLimitedTime());
        addRoomRcu.setHotelId(record.getHotelId());
        
        int res = -1;
        String[] roomNumArray = roomNums.split(",");
        if(null != roomNumArray && roomNumArray.length > 0 ) {
            for(String roomNum : roomNumArray) {
                if(roomNumMap.containsKey(roomNum)) {
                    updateRoomRcu = roomNumMap.get(roomNum);
                    updateRoomRcu.setModifyTime(nowDate);
                    updateRoomRcu.setConfTime(record.getConfTime());
                    res = mapper.updateByPrimaryKeySelective(updateRoomRcu);
                    if(res > 0) {
                        count++;
                    }
                }else {
                    addRoomRcu.setId(null);
                    addRoomRcu.setRoomNum(roomNum);
                    res = mapper.insertSelective(addRoomRcu);
                    if(res > 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
