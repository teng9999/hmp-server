package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IHmpMGHotelBusiness;
import cn.pl.hmp.server.dao.entity.HmpMGHotel;
import cn.pl.hmp.server.dao.entity.HmpMGHotelExample;
import cn.pl.hmp.server.dao.mapper.HmpMGHotelMapper;

@Service
public class HmpMGHotelBusinessImpl implements IHmpMGHotelBusiness {

	@Autowired
	private HmpMGHotelMapper hmpMGHotelMapper;

	
	@Override
	public List<HmpMGHotel> query(HmpMGHotelExample example) {
		// TODO Auto-generated method stub
		if (null == example)
			example = new HmpMGHotelExample();
		return hmpMGHotelMapper.selectByExample(example);
	}

	@Override
	public Map<Pages, List<HmpMGHotel>> queryPages(HmpMGHotelExample example, Pages pages) {
		// TODO Auto-generated method stub
		Map<Pages, List<HmpMGHotel>> result = new HashMap<>();
		if (null == example)
			example = new HmpMGHotelExample();
		if (null == pages) {
			List<HmpMGHotel> list = hmpMGHotelMapper.selectByExample(example);
			if (null == list)
				list = new ArrayList<HmpMGHotel>();
			pages = new Pages();
			result.put(pages, list);
		} else {
			PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
			List<HmpMGHotel> list = hmpMGHotelMapper.selectByExample(example);
			if (null == list) {
				list = new ArrayList<HmpMGHotel>();
				result.put(pages, list);
			} else {
				Page<HmpMGHotel> page = (Page<HmpMGHotel>) list;
				if (null != page.getResult() && !page.getResult().isEmpty()) {
					pages.setPageNum(page.getPageNum());
					pages.setPageSize(page.getPageSize());
					pages.setSize(page.size());
					pages.setOrderBy(page.getOrderBy());
					pages.setEndRow(page.getEndRow());
					pages.setTotal(page.getTotal());
					pages.setPages(page.getPages());
					result.put(pages, page.getResult());
				} else {
					result.put(pages, new ArrayList<HmpMGHotel>());
				}
			}
		}
		return result;
	}

	@Override
	public HmpMGHotel get(Long id) {
		if (null == id  ||  0 > id.longValue())
			return new HmpMGHotel();
		return hmpMGHotelMapper.selectByPrimaryKey(id);
	}

	@Override
	public int create(HmpMGHotel record) {
		// TODO Auto-generated method stub
		if (null == record || null != record.getId())
			return 0;
		if (null == record.getHotelId() ||  0 > record.getHotelId().longValue() 
			|| null == record.getGroupId() || 0 > record.getGroupId().longValue())
			return 0;
		return hmpMGHotelMapper.insertSelective(record);
	}

	@Override
	public int update(HmpMGHotel record) {
		// TODO Auto-generated method stub
		if (null == record)
			return -1;
		if (null == record.getId() || 0 > record.getId().longValue())
			return 0;
		return hmpMGHotelMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int remove(Long id) {
		// TODO Auto-generated method stub
		if (null == id || 0 > id.longValue())
			return -1;
		return hmpMGHotelMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Long> queryByHotelId(Long hotelId) {
		if (null == hotelId || 0 > hotelId.longValue())
			return new ArrayList<Long>();
		List<Long> lists = hmpMGHotelMapper.selectByHotelId(hotelId);
		if (null == lists || lists.isEmpty())
			return new ArrayList<Long>();
		return lists;
	}

	@Override
	public int saveOnBatch(List<HmpMGHotel> mgList) {
		// TODO Auto-generated method stub
		if(null == mgList || mgList.isEmpty())
			return 0;
		return hmpMGHotelMapper.saveOnBatch(mgList);
	}

	@Override
	public int deleteOnBatch(List<Long> idList, Long hotelId) {
		// TODO Auto-generated method stub
		if(null == hotelId || 0 > hotelId.longValue())
			return 0;
		return hmpMGHotelMapper.deleteOnBatch(idList,hotelId);
	}

	@Override
	public int deleteByHotelIdOnBatch(Long hotelId) {
		// TODO Auto-generated method stub
		if(null == hotelId || 0 > hotelId.longValue())
			return 0;
		return hmpMGHotelMapper.delelteByHotelId(hotelId);
	}



}
