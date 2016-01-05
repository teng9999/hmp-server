package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IHotelRoomTvBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoomTv;
import cn.pl.hmp.server.dao.entity.HotelRoomTvExample;
import cn.pl.hmp.server.dao.mapper.HotelRoomTvMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class HotelRoomTvBusinessImpl extends BoostBusinessImpl implements IHotelRoomTvBusiness{
    @Autowired
    private HotelRoomTvMapper mapper;
    @Override
    public int delete(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public long insert(HotelRoomTv record) {
        mapper.insertSelective(record);
        return record.getId();
    }

    @Override
    public HotelRoomTv selectById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<Pages, List<HotelRoomTv>> selectByPages(
            HotelRoomTvExample example, Pages page) {
        Map<Pages, List<HotelRoomTv>> map = new HashMap<Pages, List<HotelRoomTv>>();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<HotelRoomTv> hotelRoomTvList = mapper.selectByExample(example);
        if (null == hotelRoomTvList) {
            hotelRoomTvList = new ArrayList<HotelRoomTv>();
        }
        PageInfo<HotelRoomTv> pageInfo = new PageInfo<HotelRoomTv>(hotelRoomTvList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, hotelRoomTvList);
        return map;
    }

    @Override
    public int update(HotelRoomTv record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Map<Pages, List<HotelRoomTv>> selectPagesByRoom(Long hotelId,
            Pages page) {
        Map<Pages, List<HotelRoomTv>> map = new HashMap<Pages, List<HotelRoomTv>>();
        PageHelper.startPage(page.getPageNum(), page.getPageSize(),page.getOrderBy());
        List<HotelRoomTv> hotelRoomTvList = mapper.selectListByHotel(hotelId);
        if (null == hotelRoomTvList) {
            hotelRoomTvList = new ArrayList<HotelRoomTv>();
        }
        PageInfo<HotelRoomTv> pageInfo = new PageInfo<HotelRoomTv>(hotelRoomTvList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, hotelRoomTvList);
        return map;
    }

}
