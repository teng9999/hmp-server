package cn.pl.hmp.server.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IHotelRoomRcuBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoomRcu;
import cn.pl.hmp.server.dao.entity.HotelRoomRcuExample;
import cn.pl.hmp.server.dao.mapper.HotelRCUCfgMapper;
import cn.pl.hmp.server.dao.mapper.HotelRoomRcuMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class HotelRoomRcuBusinessImpl extends BoostBusinessImpl implements IHotelRoomRcuBusiness{
    @Autowired
    private HotelRoomRcuMapper mapper;
    @Autowired
    private HotelRCUCfgMapper rcuCfgMapper;
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

}
