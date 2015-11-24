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
import cn.pl.hmp.server.business.iface.IAPPInfoBusiness;
import cn.pl.hmp.server.dao.entity.APPInfo;
import cn.pl.hmp.server.dao.entity.APPInfoExample;
import cn.pl.hmp.server.dao.mapper.APPInfoMapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * appInfo
 *
 * @author zhoujianbiao
 */
@Service
public class APPInfoBusinessImpl extends AbstractBusiness implements
		IAPPInfoBusiness {
	@Autowired
	private APPInfoMapper aPPInfoMapper;

	/*
	 * (非 Javadoc) <p>Title: query</p> <p>Description: </p>
	 * 
	 * @param example
	 * 
	 * @return
	 * 
	 * @see cn.pl.hmp.server.business.iface.IAPPInfoBusiness#query(cn.pl.hmp.
	 * server.dao.entity.APPInfoExample)
	 */
	@Override
	public List<APPInfo> query(APPInfoExample example) {
		if (example == null)
			example = new APPInfoExample();
		return aPPInfoMapper.selectByExample(example);
	}

	@Override
	public Map<Pages, List<APPInfo>> queryPages(APPInfoExample example,
			Pages pages) {
		Map<Pages, List<APPInfo>> result = new HashMap<>();
		if (example == null)
			example = new APPInfoExample();
		if (pages == null) {
			List<APPInfo> list = aPPInfoMapper.selectByExample(example);
			if (list == null)
				list = new ArrayList<APPInfo>();
			pages = new Pages();
			result.put(pages, list);
		} else {
			PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
			List<APPInfo> list = aPPInfoMapper.selectByExample(example);
			if (list == null) {
				list = new ArrayList<APPInfo>();
				result.put(pages, list);
			} else {
				Page<APPInfo> page = (Page<APPInfo>) list;
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
					result.put(pages, new ArrayList<APPInfo>());
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
	public APPInfo get(Long id) {
		if (id == null)
			return null;
		return aPPInfoMapper.selectByPrimaryKey(id);
	}

	/**
	 * 
	 */
	@Override
	public int create(APPInfo record) {
		if (record == null || record.getId() != null)
			return 0;
		return aPPInfoMapper.insertSelective(record);
	}

	@Override
	public int update(APPInfo record) {
		if (record == null || record.getId() == null)
			return 0;
		return aPPInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int remove(Long id) {
		if (id == null)
			return 0;
		return aPPInfoMapper.deleteByPrimaryKey(id);
	}

}
