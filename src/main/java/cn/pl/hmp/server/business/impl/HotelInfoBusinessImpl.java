package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.commons.utils.TypeConvert;
import cn.pl.hmp.server.business.iface.IHotelInfoBusiness;
import cn.pl.hmp.server.dao.entity.HotelInfo;
import cn.pl.hmp.server.dao.entity.HotelInfoExample;
import cn.pl.hmp.server.dao.mapper.HotelInfoMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.alibaba.fastjson.JSONObject;
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
	    if(null == record) {
	        return 0;
	    }
	    mapper.insertSelective(record);
		return record.getId();
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
		return mapper.updateByPrimaryKeySelective(record);
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

    @Override
    public List<HotelInfo> selectByUserId(Long userId) {
        if(null == userId) {
            return null;
        }
        return mapper.selectByUserId(userId);
    }
    @Override
    public JSONObject publish(Long hotelId) {
        HotelInfo hotel = mapper.selectByPrimaryKey(hotelId);
        JSONObject json = new JSONObject();
        if(hotel == null) {
            return json;
        }
        json.put("id", hotel.getId());
        json.put("name",hotel.getName());
        json.put("address",hotel.getAddress());
        json.put("phone",hotel.getPhone());
        json.put("city",hotel.getCity());
        json.put("subName",hotel.getSubName());
        json.put("type",TypeConvert.hotelTypeConvert(hotel.getType()));
        json.put("fax",hotel.getFax());
        json.put("bus",hotel.getBus());
        json.put("env",hotel.getEnv());
        json.put("screen", hotel.getScreen()?"1" : "0");
        json.put("countryCode",hotel.getCountry());
        json.put("cityCode",hotel.getCity());
        json.put("weatherCode",hotel.getWeatherCode());
        json.put("welcomesCn",hotel.getWelcomesCn());
        json.put("welcomesEn",hotel.getWelcomesEn());
        json.put("cityNameEn",hotel.getCityNameEn());
        json.put("rollCn",hotel.getRollCn());
        json.put("rollEn",hotel.getRollEn());
        return json;
    }
}
