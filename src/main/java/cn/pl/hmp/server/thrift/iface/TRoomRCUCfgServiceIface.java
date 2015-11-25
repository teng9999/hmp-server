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
import cn.pl.hmp.commons.thrift.define.TRoomRCUCfg;
import cn.pl.hmp.server.business.iface.IRoomRCUCfgBusiness;
import cn.pl.hmp.server.dao.entity.RoomRCUCfg;
import cn.pl.hmp.server.dao.entity.RoomRCUCfgExample;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

/**
 * rcu
 * 
 * @author zhoujianbiao
 *
 */
@Component
@ThriftService
public class TRoomRCUCfgServiceIface implements
		cn.pl.hmp.commons.thrift.service.TRoomRCUCfgService.Iface {
	@Autowired
	private IRoomRCUCfgBusiness business;

	@Override
	public int deleteById(long id) throws TException {
		if (business == null) {
			return 0;
		}

		return business.remove(id);
	}

	@Override
	public int insert(TRoomRCUCfg record) throws TException {
		if (business == null) {
			return 0;
		}
		RoomRCUCfg roomRCUCfg = ServerTransform.transform(record);
		if (roomRCUCfg == null) {
			roomRCUCfg = new RoomRCUCfg();
		}
		return business.create(roomRCUCfg);
	}

	@Override
	public TRoomRCUCfg selectById(long id) throws TException {
		if (business == null) {
			return null;
		}
		RoomRCUCfg roomRCUCfg = business.get(id);
		if (roomRCUCfg == null) {
			roomRCUCfg = new RoomRCUCfg();
		}
		return ServerTransform.transform(roomRCUCfg);
	}

	@Override
	public int updateById(TRoomRCUCfg record) throws TException {
		if (business == null) {
			return 0;
		}
		if (record == null) {
			return 0;
		}
		RoomRCUCfg roomRCUCfg = ServerTransform.transform(record);
		return business.update(roomRCUCfg);
	}

	@Override
	public List<TRoomRCUCfg> loadAll() throws ThriftException, TException {
		if (business == null) {
			return null;
		}
		List<RoomRCUCfg> lists = business.query(null);
		return listTransform(lists);
	}

	private List<TRoomRCUCfg> listTransform(List<RoomRCUCfg> lists) {
		List<TRoomRCUCfg> resultLists = new ArrayList<TRoomRCUCfg>();
		for (RoomRCUCfg roomRCUCfg : lists) {
			TRoomRCUCfg result = ServerTransform.transform(roomRCUCfg);
			resultLists.add(result);
		}
		return resultLists;
	}

	@Override
	public Map<TPages, List<TRoomRCUCfg>> loadPages(TPages tPages)
			throws ThriftException, TException {
		if (business == null)
			return null;
		// 转换Thrift分页对象为Pages
		Pages pages = ServerTransform.transform(tPages);
		if (pages == null)
			pages = new Pages();
		// 分页查询
		Map<Pages, List<RoomRCUCfg>> result = business.queryPages(null, pages);
		// 处理查询结果
		Map<TPages, List<TRoomRCUCfg>> rtn = new HashMap<>();
		TPages rtnPages = null;
		List<TRoomRCUCfg> rtnList = null;
		if (result == null || result.isEmpty()) {
			// 查询结果为空
			rtnPages = new TPages();
			rtnList = new ArrayList<>();
		} else {
			// 查询结果不为空
			for (Pages key : result.keySet()) {
				List<RoomRCUCfg> datas = result.get(key);
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

	@Override
	public List<TRoomRCUCfg> queryByHotelId(long hotelId)
			throws ThriftException, TException {
		if (business == null) {
			return null;
		}
		RoomRCUCfgExample roomRCUCfgExample = new RoomRCUCfgExample();
		roomRCUCfgExample.createCriteria().andHotelIdEqualTo(hotelId);
		List<RoomRCUCfg> airModes = business.query(roomRCUCfgExample);
		return listTransform(airModes);
	}
}
