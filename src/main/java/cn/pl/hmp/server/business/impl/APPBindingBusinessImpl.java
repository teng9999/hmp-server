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
import cn.pl.hmp.server.business.iface.IAPPBindingBusiness;
import cn.pl.hmp.server.dao.entity.APPBinding;
import cn.pl.hmp.server.dao.entity.APPBindingExample;
import cn.pl.hmp.server.dao.mapper.APPBindingMapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * appInfo
 *
 * @author zhoujianbiao
 */
@Service
public class APPBindingBusinessImpl extends AbstractBusiness implements
		IAPPBindingBusiness {
	@Autowired
	private APPBindingMapper aPPBindingMapper;

	/*
	 * (非 Javadoc) <p>Title: query</p> <p>Description: </p>
	 * 
	 * @param example
	 * 
	 * @return
	 * 
	 * @see cn.pl.hmp.server.business.iface.IAPPBindingBusiness#query(cn.pl.hmp.
	 * server.dao.entity.APPBindingExample)
	 */
	@Override
	public List<APPBinding> query(APPBindingExample example) {
		if (example == null)
			example = new APPBindingExample();
		return aPPBindingMapper.selectByExample(example);
	}

	@Override
	public Map<Pages, List<APPBinding>> queryPages(APPBindingExample example,
			Pages pages) {
		Map<Pages, List<APPBinding>> result = new HashMap<>();
		if (example == null)
			example = new APPBindingExample();
		if (pages == null) {
			List<APPBinding> list = aPPBindingMapper.selectByExample(example);
			if (list == null)
				list = new ArrayList<APPBinding>();
			pages = new Pages();
			result.put(pages, list);
		} else {
			PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
			List<APPBinding> list = aPPBindingMapper.selectByExample(example);
			if (list == null) {
				list = new ArrayList<APPBinding>();
				result.put(pages, list);
			} else {
				Page<APPBinding> page = (Page<APPBinding>) list;
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
					result.put(pages, new ArrayList<APPBinding>());
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
	public APPBinding get(Long id) {
		if (id == null)
			return null;
		return aPPBindingMapper.selectByPrimaryKey(id);
	}

	/**
	 * 
	 */
	@Override
	public int create(APPBinding record) {
		if (record == null)
			return 0;
		return aPPBindingMapper.insertSelective(record);
	}

	@Override
	public int update(APPBinding record) {
		if (record == null || record.getId() == null)
			return 0;
		return aPPBindingMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int remove(Long id) {
		if (id == null)
			return 0;
		return aPPBindingMapper.deleteByPrimaryKey(id);
	}

}
