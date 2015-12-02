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
import cn.pl.commons.utils.StringUtils;
import cn.pl.hmp.server.business.AbstractBusiness;
import cn.pl.hmp.server.business.iface.IRoomRCUCfgBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoom;
import cn.pl.hmp.server.dao.entity.HotelRoomExample;
import cn.pl.hmp.server.dao.entity.RoomRCUCfg;
import cn.pl.hmp.server.dao.entity.RoomRCUCfgExample;
import cn.pl.hmp.server.dao.mapper.HotelRoomMapper;
import cn.pl.hmp.server.dao.mapper.RoomRCUCfgMapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * rcu
 *
 * @author zhoujianbiao
 */
@Service
public class RoomRCUCfgBusinessImpl extends AbstractBusiness implements
		IRoomRCUCfgBusiness {
	@Autowired
	private RoomRCUCfgMapper roomRCUCfgMapper;

	@Autowired
	private HotelRoomMapper hotelRoomMapper;

	/*
	 * (非 Javadoc) <p>Title: query</p> <p>Description: </p>
	 * 
	 * @param example
	 * 
	 * @return
	 * 
	 * @see cn.pl.hmp.server.business.iface.IRoomRCUCfgBusiness#query(cn.pl.hmp.
	 * server.dao.entity.RoomRCUCfgExample)
	 */
	@Override
	public List<RoomRCUCfg> query(RoomRCUCfgExample example) {
		if (example == null)
			example = new RoomRCUCfgExample();
		return roomRCUCfgMapper.selectByExample(example);
	}

	@Override
	public Map<Pages, List<RoomRCUCfg>> queryPages(RoomRCUCfgExample example,
			Pages pages) {
		Map<Pages, List<RoomRCUCfg>> result = new HashMap<>();
		if (example == null)
			example = new RoomRCUCfgExample();
		if (pages == null) {
			List<RoomRCUCfg> list = roomRCUCfgMapper.selectByExample(example);
			if (list == null)
				list = new ArrayList<RoomRCUCfg>();
			pages = new Pages();
			result.put(pages, list);
		} else {
			PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
			List<RoomRCUCfg> list = roomRCUCfgMapper.selectByExample(example);
			if (list == null) {
				list = new ArrayList<RoomRCUCfg>();
				result.put(pages, list);
			} else {
				Page<RoomRCUCfg> page = (Page<RoomRCUCfg>) list;
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
					result.put(pages, new ArrayList<RoomRCUCfg>());
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
	public RoomRCUCfg get(Long id) {
		if (id == null)
			return null;
		return roomRCUCfgMapper.selectByPrimaryKey(id);
	}

	/**
	 * 
	 */
	@Override
	public int create(RoomRCUCfg record) {
		if (record == null)
			return 0;
		return roomRCUCfgMapper.insertSelective(record);
	}

	@Override
	public int update(RoomRCUCfg record) {
		if (record == null || record.getId() == null)
			return 0;
		return roomRCUCfgMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int remove(Long id) {
		if (id == null)
			return 0;
		return roomRCUCfgMapper.deleteByPrimaryKey(id);
	}

	@Override
	public boolean apply2room(String roomType, long hotelId) {
		// 拿到这个房型的模板的所有信息。
		List<RoomRCUCfg> roomRCUCfgs = queryListByRoomTypeAndHotelId(roomType,
				hotelId);
		if (roomRCUCfgs == null || roomRCUCfgs.isEmpty()) {
			return false;
		}
		// 拿到该酒店该房型的所有房间。
		HotelRoomExample hotelRoomExample = new HotelRoomExample();
		hotelRoomExample.createCriteria().andHotelIdEqualTo(hotelId)
				.andRoomTypeEqualTo(roomType.trim());
		List<HotelRoom> hotelRooms = hotelRoomMapper
				.selectByExample(hotelRoomExample);
		// 删掉原来的RCU配置。
		removeByHotelAndRoomType(roomType, hotelId);
		try {
			// 应用
			for (RoomRCUCfg roomRCUCfg : roomRCUCfgs) {
				for (HotelRoom hotelRoom : hotelRooms) {
					RoomRCUCfg tempCfg = new RoomRCUCfg(roomRCUCfg);
					// tempCfg.setId(null);
					tempCfg.setRoomId(hotelRoom.getId());
					create(tempCfg);

				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<RoomRCUCfg> queryListByRoomTypeAndHotelId(String roomType,
			long hotelId) {
		if (StringUtils.isBlank(roomType)) {
			return new ArrayList<RoomRCUCfg>();
		}
		RoomRCUCfgExample roomRCUCfgExample = new RoomRCUCfgExample();
		roomRCUCfgExample.createCriteria().andHotelIdEqualTo(hotelId)
				.andRoomTypeEqualTo(roomType.trim());
		return roomRCUCfgMapper.selectByExample(roomRCUCfgExample);
	}

	@Override
	public boolean removeByHotelAndRoomType(String roomType, long hotelId) {
		List<RoomRCUCfg> roomRCUCfgs = queryListByRoomTypeAndHotelId(roomType,
				hotelId);
		if (roomRCUCfgs == null || roomRCUCfgs.isEmpty()) {
			return false;
		}
		try {
			for (RoomRCUCfg roomRCUCfg : roomRCUCfgs) {
				remove(roomRCUCfg.getId());
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
