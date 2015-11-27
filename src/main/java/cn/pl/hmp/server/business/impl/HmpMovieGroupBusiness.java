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
import cn.pl.hmp.server.business.iface.IHmpMovieGroupBusiness;
import cn.pl.hmp.server.dao.entity.HmpMGHotel;
import cn.pl.hmp.server.dao.entity.HmpMovieGroup;
import cn.pl.hmp.server.dao.entity.HmpMovieGroupExample;
import cn.pl.hmp.server.dao.mapper.HmpMGHotelMapper;
import cn.pl.hmp.server.dao.mapper.HmpMovieGroupMapper;

@Service
public class HmpMovieGroupBusiness implements IHmpMovieGroupBusiness {

	@Autowired
	private HmpMovieGroupMapper hmpMovieGroupMapper;
	@Autowired
	private HmpMGHotelMapper hmpMGHotelMapper;
	
	@Override
	public List<HmpMovieGroup> query(HmpMovieGroupExample example) {
		// TODO Auto-generated method stub
		if (example == null)
			example = new HmpMovieGroupExample();
		return hmpMovieGroupMapper.selectByExample(example);
	}

	@Override
	public Map<Pages, List<HmpMovieGroup>> queryPages(HmpMovieGroupExample example, Pages pages) {
		// TODO Auto-generated method stub
		Map<Pages,List<HmpMovieGroup>> result = new HashMap<>();
		if(null == example)
			example = new HmpMovieGroupExample();
		if(null == pages) {
			List<HmpMovieGroup> list =  hmpMovieGroupMapper.selectByExample(example);
			if(null == list)
				list =  new ArrayList<HmpMovieGroup>(); 
			pages = new Pages();
			result.put(pages, list);
		}else{
			PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
			List<HmpMovieGroup> list =  hmpMovieGroupMapper.selectByExample(example);
			if(null == list){
				list =  new ArrayList<HmpMovieGroup>(); 
				result.put(pages, list);
			}else{
				Page<HmpMovieGroup>page =  (Page<HmpMovieGroup>) list;
				if (page.getResult() != null && !page.getResult().isEmpty()) {
					pages.setPageNum(page.getPageNum());
					pages.setPageSize(page.getPageSize());
					pages.setSize(page.size());
					pages.setOrderBy(page.getOrderBy());
					pages.setEndRow(page.getEndRow());
					pages.setTotal(page.getTotal());
					pages.setPages(page.getPages());
					result.put(pages, page.getResult());
				} else {
					result.put(pages, new ArrayList<HmpMovieGroup>());
				}
			}
		}	
		return result;
	}

	@Override
	public HmpMovieGroup get(Long id) {
		// TODO Auto-generated method stub
		if(0 > id)
			return null;
		return hmpMovieGroupMapper.selectByPrimaryKey(id);
		
	}

	@Override
	public int create(HmpMovieGroup record) {
		// TODO Auto-generated method stub
		if(null ==record )
			return -1;
	   int rlt= hmpMovieGroupMapper.insertSelective(record);
	   if(null !=record.getHotelId() && 0 < record.getHotelId() && 0 < rlt ){
		   	HmpMGHotel hmpMGHotel = new HmpMGHotel();
		   	hmpMGHotel.setGroupId((long)rlt);
		   	hmpMGHotel.setHotelId(record.getHotelId());
			return  hmpMGHotelMapper.insert(hmpMGHotel);
	   }
	   
	   return rlt;
	}

	@Override
	public int update(HmpMovieGroup record) {
		// TODO Auto-generated method stub
		if(null == record)
			return -1;
		return hmpMovieGroupMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int remove(Long id) {
		// TODO Auto-generated method stub
		if(0 < id)
			return hmpMovieGroupMapper.deleteByPrimaryKey(id);
		return -1;
	}

	@Override
	public List<HmpMovieGroup> selectByGroupType(Long groupId) {
		// TODO Auto-generated method stub
		if(null == groupId || 0 > groupId.longValue())
			return null;
		return hmpMovieGroupMapper.selectByGroupType(groupId);
	}

}
