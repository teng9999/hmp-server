package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IHmpRoomTvBusiness;
import cn.pl.hmp.server.dao.entity.HmpRoomTv;
import cn.pl.hmp.server.dao.entity.HmpRoomTvExample;
import cn.pl.hmp.server.dao.mapper.HmpRoomTvMapper;
import cn.pl.hmp.server.utils.PageConverter;
import com.github.pagehelper.PageInfo;

@Service
public class HmpRoomTvBusinessImpl extends BoostBusinessImpl implements IHmpRoomTvBusiness {
	@Autowired
	private HmpRoomTvMapper mapper;
	
	@Override
	public int deleteByHmpRoomTvId(Long id) {
		if(id == null)
			return 0;
		return mapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public long insert(HmpRoomTv record) {
		if (record.getHotelId() == null) {
			return 0;
		}
		mapper.insert(record);
		return record.getId();
	}
	
	@Override
	public List<HmpRoomTv> selectAll() {
		return mapper.selectByExample(new HmpRoomTvExample());
	}
	
	@Override
	public Map<Pages, List<HmpRoomTv>> selectByPages(HmpRoomTvExample example,Pages page) {
		Map<Pages, List<HmpRoomTv>> map = new HashMap<Pages, List<HmpRoomTv>>();
		if (null == example)
			example = new HmpRoomTvExample();
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
        System.out.println(page.getPageNum()+"--"+page.getPageSize());
		List<HmpRoomTv> tvList = mapper.selectByExample(example);
		if (null == tvList)
			tvList = new ArrayList<HmpRoomTv>();
		PageInfo<HmpRoomTv> pageInfo = new PageInfo<HmpRoomTv>(tvList);
		Pages pages = PageConverter.converter(pageInfo);
		map.put(pages, tvList);
		
		return map;
	}
	
	@Override
	public int update(HmpRoomTv record) {
		if(record == null || record.getId() == null || record.getHotelId() == null)
			return 0;
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<HmpRoomTv> selectByExample(HmpRoomTvExample example) {
		return mapper.selectByExample(example);
	}
	
	@Override
	public HmpRoomTv selectByHotelId(Long hotelId) {
		return mapper.selectByHotelId(hotelId);
	}
}
