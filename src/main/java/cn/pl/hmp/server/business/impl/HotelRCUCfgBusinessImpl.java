/*
 * ExampleBusinessImpl.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.AbstractBusiness;
import cn.pl.hmp.server.business.iface.IHotelRCUCfgBusiness;
import cn.pl.hmp.server.dao.entity.HotelRCUCfg;
import cn.pl.hmp.server.dao.entity.HotelRCUCfgExample;
import cn.pl.hmp.server.dao.mapper.HotelRCUCfgMapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * rcu
 *
 * @author zhoujianbiao
 */
@Service
public class HotelRCUCfgBusinessImpl extends AbstractBusiness implements
		IHotelRCUCfgBusiness {
	@Autowired
	private HotelRCUCfgMapper hotelRCUCfgMapper;

	/*
	 * (非 Javadoc) <p>Title: query</p> <p>Description: </p>
	 * 
	 * @param example
	 * 
	 * @return
	 * 
	 * @see
	 * cn.pl.hmp.server.business.iface.IHotelRCUCfgBusiness#query(cn.pl.hmp.
	 * server.dao.entity.HotelRCUCfgExample)
	 */
	@Override
	public List<HotelRCUCfg> query(HotelRCUCfgExample example) {
		if (example == null)
			example = new HotelRCUCfgExample();
		return hotelRCUCfgMapper.selectByExample(example);
	}

	@Override
	public Map<Pages, List<HotelRCUCfg>> queryPages(HotelRCUCfgExample example,
			Pages pages) {
		Map<Pages, List<HotelRCUCfg>> result = new HashMap<>();
		if (example == null)
			example = new HotelRCUCfgExample();
		if (pages == null) {
			List<HotelRCUCfg> list = hotelRCUCfgMapper.selectByExample(example);
			if (list == null)
				list = new ArrayList<HotelRCUCfg>();
			pages = new Pages();
			result.put(pages, list);
		} else {
			PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
			List<HotelRCUCfg> list = hotelRCUCfgMapper.selectByExample(example);
			if (list == null) {
				list = new ArrayList<HotelRCUCfg>();
				result.put(pages, list);
			} else {
				Page<HotelRCUCfg> page = (Page<HotelRCUCfg>) list;
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
					result.put(pages, new ArrayList<HotelRCUCfg>());
				}
			}

		}
		return result;
	}

	/**
	 * 
	 * @Title: get
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @return 设定文件
	 * @return HmpTest 返回类型
	 * @throws
	 */
	@Override
	public HotelRCUCfg get(Long id) {
		if (id == null)
			return null;
		return hotelRCUCfgMapper.selectByPrimaryKey(id);
	}

	/**
	 * 
	 */
	@Override
	public int create(HotelRCUCfg record) {
		if (record == null)
			return 0;
		return hotelRCUCfgMapper.insertSelective(record);
	}

	@Override
	public int update(HotelRCUCfg record) {
		if (record == null || record.getId() == null)
			return 0;
		return hotelRCUCfgMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int remove(Long id) {
		if (id == null)
			return 0;
		return hotelRCUCfgMapper.deleteByPrimaryKey(id);
	}

}
