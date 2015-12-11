package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IHmpHotelToolPacksBusiness;
import cn.pl.hmp.server.dao.entity.HmpHotelToolPacks;
import cn.pl.hmp.server.dao.entity.HmpHotelToolPacksExample;
import cn.pl.hmp.server.dao.entity.PublishPkgs;
import cn.pl.hmp.server.dao.mapper.HmpHotelToolPacksMapper;
import cn.pl.hmp.server.dao.mapper.PublishPkgsMapper;
import cn.pl.hmp.server.utils.PageConverter;
import com.github.pagehelper.PageInfo;

@Service
public class HmpHotelToolPacksBusinessImpl extends BoostBusinessImpl implements IHmpHotelToolPacksBusiness {
	@Autowired
	private HmpHotelToolPacksMapper mapper;
	
	@Override
	public int delete(Long id) {
		if (null == id) {
			return 0;
		}
		return mapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public long insert(HmpHotelToolPacks record) {
		if (record == null || record.getHotelId() == null || record.getPkgType() == null || record.getCurVersion() == null) {
			return 0;
		}
		mapper.insert(record);
		return record.getId();
	}
	
	@Override
	public List<HmpHotelToolPacks> selectByExample(HmpHotelToolPacksExample example) {
		return mapper.selectByExample(example);
	}
	
	@Override
	public List<HmpHotelToolPacks> selectAll() {
		return mapper.selectByExample(new HmpHotelToolPacksExample());
	}
	
	@Override
	public List<HmpHotelToolPacks> queryList() {
		List<HmpHotelToolPacks> list = mapper.queryList();
		return list;
	}
	
	@Override
	public Map<Pages, List<HmpHotelToolPacks>> selectByPages(HmpHotelToolPacksExample example,Pages page) {
		Map<Pages, List<HmpHotelToolPacks>> map = new HashMap<Pages, List<HmpHotelToolPacks>>();
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
        System.out.println(page.getPageNum()+"--"+page.getPageSize());
		List<HmpHotelToolPacks> list = mapper.queryList();
		if (null == list)
			list = new ArrayList<HmpHotelToolPacks>();
		PageInfo<HmpHotelToolPacks> pageInfo = new PageInfo<HmpHotelToolPacks>(list);
		Pages pages = PageConverter.converter(pageInfo);
		map.put(pages, list);
		
		return map;
	}

	@Override
	public int update(HmpHotelToolPacks record) {
		if (null == record || record.getId() == null || record.getPkgType() == null || record.getCurVersion() == null) {
			return 0;
		}
		return mapper.updateByPrimaryKey(record);
	}
}
