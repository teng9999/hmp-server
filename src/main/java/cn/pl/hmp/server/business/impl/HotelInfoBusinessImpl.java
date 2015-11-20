package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IHotelInfoBusiness;
import cn.pl.hmp.server.dao.entity.HotelInfo;
import cn.pl.hmp.server.dao.entity.HotelInfoExample;
import cn.pl.hmp.server.dao.mapper.HotelInfoMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class HotelInfoBusinessImpl extends BoostBusinessImpl implements
		IHotelInfoBusiness {
	
	@Autowired
	private HotelInfoMapper mapper;

	@Override
	public int deleteByHotelId(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public long insert(HotelInfo record) {
		return mapper.insert(record);
	}

	@Override
	public HotelInfo selectByHotelId(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<HotelInfo> selectAll() {
		return mapper.selectByExample(new HotelInfoExample());
	}
	
	@Override
	public int update(HotelInfo record) {
		return mapper.updateByPrimaryKey(record);
	}

    @Override
    public Map<Pages, List<HotelInfo>> selectByPages(HotelInfoExample example,
            Pages page) {
        Map<Pages,List<HotelInfo>> map = new HashMap<Pages, List<HotelInfo>>();
        if(null == example)
            example = new HotelInfoExample();
        PageHelper.startPage(page.getPageNum(),page.getPageSize()); 
        List<HotelInfo> hotelList = mapper.selectByExample(example);
        if(null == hotelList)
            hotelList = new ArrayList<HotelInfo>();
        PageInfo<HotelInfo> pageInfo =  new PageInfo<HotelInfo>(hotelList);
        Pages pages = PageConverter.converter(pageInfo);
        map.put(pages, hotelList);
        return map;
    }
}
