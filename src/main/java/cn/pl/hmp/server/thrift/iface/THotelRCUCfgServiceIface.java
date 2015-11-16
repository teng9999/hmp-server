/*
 * TExampleServiceIface.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.thrift.iface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pl.commons.pages.Pages;
import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrift.define.TPages;
import cn.pl.frame.thrift.exception.ThriftException;
import cn.pl.hmp.commons.thrift.define.THotelRCUCfg;
import cn.pl.hmp.server.business.iface.IHotelRCUCfgBusiness;
import cn.pl.hmp.server.dao.entity.HotelRCUCfg;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

/**
 * rcu
 * 
 * @author zhoujianbiao
 *
 */
@Component
@ThriftService
public class THotelRCUCfgServiceIface implements
		cn.pl.hmp.commons.thrift.service.THotelRCUCfgService.Iface {
	@Autowired
	private IHotelRCUCfgBusiness business;

	@Override
	public int deleteById(long id) throws TException {
		if (business == null) {
			return 0;
		}

		return business.remove(id);
	}

	@Override
	public int insert(THotelRCUCfg record) throws TException {
		if (business == null) {
			return 0;
		}
		HotelRCUCfg hotelRCUCfg = ServerTransform.transform(record);
		if (hotelRCUCfg == null) {
			hotelRCUCfg = new HotelRCUCfg();
		}
		return business.create(hotelRCUCfg);
	}

	@Override
	public THotelRCUCfg selectById(long id) throws TException {
		if (business == null) {
			return null;
		}
		HotelRCUCfg hotelRCUCfg = business.get(id);
		if (hotelRCUCfg == null) {
			hotelRCUCfg = new HotelRCUCfg();
		}
		return ServerTransform.transform(hotelRCUCfg);
	}

	@Override
	public int updateById(THotelRCUCfg record) throws TException {
		if (business == null) {
			return 0;
		}
		if (record == null) {
			return 0;
		}
		HotelRCUCfg hotelRCUCfg = ServerTransform.transform(record);
		return business.update(hotelRCUCfg);
	}

	@Override
	public List<THotelRCUCfg> loadAll() throws ThriftException, TException {
		if (business == null) {
			return null;
		}
		List<HotelRCUCfg> lists = business.query(null);
		return listTransform(lists);
	}

	private List<THotelRCUCfg> listTransform(List<HotelRCUCfg> lists) {
		List<THotelRCUCfg> resultLists = new ArrayList<THotelRCUCfg>();
		for (HotelRCUCfg hotelRCUCfg : lists) {
			THotelRCUCfg result = ServerTransform.transform(hotelRCUCfg);
			resultLists.add(result);
		}
		return resultLists;
	}

	@Override
	public Map<TPages, List<THotelRCUCfg>> loadPages(TPages tPages)
			throws ThriftException, TException {
		if (business == null)
			return null;
		// 转换Thrift分页对象为Pages
		Pages pages = ServerTransform.transform(tPages);
		if (pages == null)
			pages = new Pages();
		// 分页查询
		Map<Pages, List<HotelRCUCfg>> result = business.queryPages(null, pages);
		// 处理查询结果
		Map<TPages, List<THotelRCUCfg>> rtn = new HashMap<>();
		TPages rtnPages = null;
		List<THotelRCUCfg> rtnList = null;
		if (result == null || result.isEmpty()) {
			// 查询结果为空
			rtnPages = new TPages();
			rtnList = new ArrayList<>();
		} else {
			// 查询结果不为空
			for (Pages key : result.keySet()) {
				List<HotelRCUCfg> datas = result.get(key);
				if (datas == null || datas.isEmpty()) {
					// 查询结果包含的实际数据为空
					rtnPages = new TPages();
					rtnList = new ArrayList<>();
				} else {
					// 转换查询结果和分页对象
					rtnPages = ServerTransform.transform(key);
					rtnList = listTransform(datas);
				}
				break;
			}
		}
		rtn.put(rtnPages, rtnList);

		return rtn;
	}

}
