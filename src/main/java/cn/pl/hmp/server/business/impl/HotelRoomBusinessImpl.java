package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.commons.utils.StringUtils;
import cn.pl.hmp.server.business.iface.IHotelRoomBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoom;
import cn.pl.hmp.server.dao.entity.HotelRoomExample;
import cn.pl.hmp.server.dao.entity.RoomRCUCfg;
import cn.pl.hmp.server.dao.entity.RoomRCUCfgExample;
import cn.pl.hmp.server.dao.mapper.HotelRoomMapper;
import cn.pl.hmp.server.dao.mapper.RoomRCUCfgMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class HotelRoomBusinessImpl extends BoostBusinessImpl implements
		IHotelRoomBusiness {

	@Autowired
	private HotelRoomMapper mapper;
	@Autowired
	private RoomRCUCfgMapper roomRCUCfgMapper;

	@Override
	public int deleteByHotelRoomId(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public long insert(HotelRoom record) {
		mapper.insertSelective(record);
		return record.getId();
	}

	@Override
	public HotelRoom selectByHotelRoomId(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<HotelRoom> selectAll() {
		return mapper.selectByExample(new HotelRoomExample());
	}

	@Override
	public int update(HotelRoom record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public Map<Pages, List<HotelRoom>> selectByPages(HotelRoomExample example,
			Pages page) {
		Map<Pages, List<HotelRoom>> map = new HashMap<Pages, List<HotelRoom>>();
		if (null == example)
			example = new HotelRoomExample();
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<HotelRoom> hotelRoomList = mapper.selectListAddUniqueNum(example);
		if (null == hotelRoomList)
			hotelRoomList = new ArrayList<HotelRoom>();
		PageInfo<HotelRoom> pageInfo = new PageInfo<HotelRoom>(hotelRoomList);
		Pages pages = PageConverter.converter(pageInfo);

		map.put(pages, hotelRoomList);
		return map;
	}

	@Override
	public int deleteOnBatch(List<Long> idList) {
		return 0;
		// return mapper.deleteOnBatch(idList);
	}

	@Override
	public int saveOnBatch(HotelRoom record, String roomNums) {
		if (null == record || null == roomNums || "".equals(roomNums.trim()))
			return 0;
		List<HotelRoom> roomList = new ArrayList<HotelRoom>();
		HotelRoom tempRoom = null;
		String[] roomNumArray = roomNums.split("-");
		if (null == roomNumArray || roomNums.length() < 2)
			return 0;
		for (int i = Integer.parseInt(roomNumArray[0]); i <= Integer
				.parseInt(roomNumArray[1]); i++) {
			tempRoom = record.clone(record);
			tempRoom.setRoomNum(i + "");
			roomList.add(tempRoom);
		}
		return mapper.insertBatch(roomList);
	}

	@Override
	public long updateAndRcu(HotelRoom hotelRoom, String templateCfg,
			long hotelId) {
		if (hotelRoom == null) {
			return 0;
		}
		RoomRCUCfgExample roomRCUCfgExample = new RoomRCUCfgExample();
		if (hotelRoom.getId() != null) {
			roomRCUCfgExample.createCriteria().andHotelIdEqualTo(hotelId)
					.andRoomIdEqualTo(hotelRoom.getId());
		}
		List<RoomRCUCfg> oldRoomRCUCfgs = roomRCUCfgMapper
				.selectByExample(roomRCUCfgExample);
		try {
			// 先删除
			if (oldRoomRCUCfgs != null && !oldRoomRCUCfgs.isEmpty()) {
				for (RoomRCUCfg roomRCUCfg : oldRoomRCUCfgs) {
					roomRCUCfgMapper.deleteByPrimaryKey(roomRCUCfg.getId());
				}
			}
			if (!StringUtils.isBlank(templateCfg)) {
				List<RoomRCUCfg> roomRCUCfgs = new ArrayList<RoomRCUCfg>();
				// light:1@镜前灯;2@卫间灯带;Air:1@中央空调;
				String light = templateCfg.substring(
						templateCfg.indexOf("Light") + 6,
						templateCfg.indexOf("Air"));
				String[] lightStrs = light.split(";");
				for (int i = 0; i < lightStrs.length; i++) {
					String tempStr = lightStrs[i];
					if (tempStr.length() > 0) {
						String[] lightSingleStr = tempStr.split("@");
						RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
						roomRCUCfg.setHotelId(hotelId);
						roomRCUCfg.setNum(lightSingleStr[0]);

						if (lightSingleStr.length >= 2) {
							roomRCUCfg.setName(lightSingleStr[1]);
						} else {
							roomRCUCfg.setName("");
						}
						roomRCUCfg.setRoomType(hotelRoom.getRoomType());
						roomRCUCfg.setRoomId(hotelRoom.getId());
						roomRCUCfg.setCreateTime(new Date());
						roomRCUCfg.setModifyTime(new Date());
						roomRCUCfg.setLineType("Light");
						roomRCUCfgs.add(roomRCUCfg);
					}
				}
				String air = templateCfg.substring(
						templateCfg.indexOf("Air") + 4,
						templateCfg.indexOf("Curtain"));
				lightStrs = air.split(";");
				for (int i = 0; i < lightStrs.length; i++) {
					String tempStr = lightStrs[i];
					if (tempStr.length() > 0) {
						String[] lightSingleStr = tempStr.split("@");
						RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
						roomRCUCfg.setHotelId(hotelId);
						roomRCUCfg.setNum(lightSingleStr[0]);
						if (lightSingleStr.length >= 2) {
							roomRCUCfg.setName(lightSingleStr[1]);
						} else {
							roomRCUCfg.setName("");
						}
						roomRCUCfg.setRoomType(hotelRoom.getRoomType());
						roomRCUCfg.setRoomId(hotelRoom.getId());
						roomRCUCfg.setCreateTime(new Date());
						roomRCUCfg.setModifyTime(new Date());
						roomRCUCfg.setLineType("Air");
						roomRCUCfgs.add(roomRCUCfg);
					}
				}

				String curtain = templateCfg.substring(
						templateCfg.indexOf("Curtain") + 8,
						templateCfg.indexOf("PWMLight"));
				lightStrs = curtain.split(";");
				for (int i = 0; i < lightStrs.length; i++) {
					String tempStr = lightStrs[i];
					if (tempStr.length() > 0) {
						String[] lightSingleStr = tempStr.split("@");
						RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
						roomRCUCfg.setHotelId(hotelId);
						roomRCUCfg.setNum(lightSingleStr[0]);
						if (lightSingleStr.length >= 2) {
							roomRCUCfg.setName(lightSingleStr[1]);
						} else {
							roomRCUCfg.setName("");
						}
						roomRCUCfg.setRoomType(hotelRoom.getRoomType());
						roomRCUCfg.setRoomId(hotelRoom.getId());
						roomRCUCfg.setCreateTime(new Date());
						roomRCUCfg.setModifyTime(new Date());
						roomRCUCfg.setLineType("Curtain");
						roomRCUCfgs.add(roomRCUCfg);
					}
				}
				String pwmLight = templateCfg.substring(
						templateCfg.indexOf("PWMLight") + 9,
						templateCfg.indexOf("AdjustLight"));
				lightStrs = pwmLight.split(";");
				for (int i = 0; i < lightStrs.length; i++) {
					String tempStr = lightStrs[i];
					if (tempStr.length() > 0) {
						String[] lightSingleStr = tempStr.split("@");
						RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
						roomRCUCfg.setHotelId(hotelId);
						roomRCUCfg.setNum(lightSingleStr[0]);
						if (lightSingleStr.length >= 2) {
							roomRCUCfg.setName(lightSingleStr[1]);
						} else {
							roomRCUCfg.setName("");
						}
						roomRCUCfg.setRoomType(hotelRoom.getRoomType());
						roomRCUCfg.setRoomId(hotelRoom.getId());
						roomRCUCfg.setCreateTime(new Date());
						roomRCUCfg.setModifyTime(new Date());
						roomRCUCfg.setLineType("PWMLight");
						roomRCUCfgs.add(roomRCUCfg);
					}
				}
				String adjustLight = templateCfg.substring(templateCfg
						.indexOf("AdjustLight") + 12);
				lightStrs = adjustLight.split(";");
				for (int i = 0; i < lightStrs.length; i++) {
					String tempStr = lightStrs[i];
					if (tempStr.length() > 0) {
						String[] lightSingleStr = tempStr.split("@");
						RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
						roomRCUCfg.setHotelId(hotelId);
						roomRCUCfg.setNum(lightSingleStr[0]);
						if (lightSingleStr.length >= 2) {
							roomRCUCfg.setName(lightSingleStr[1]);
						} else {
							roomRCUCfg.setName("");
						}
						roomRCUCfg.setRoomType(hotelRoom.getRoomType());
						roomRCUCfg.setRoomId(hotelRoom.getId());
						roomRCUCfg.setCreateTime(new Date());
						roomRCUCfg.setModifyTime(new Date());
						roomRCUCfg.setLineType("AdjustLight");
						roomRCUCfgs.add(roomRCUCfg);
					}
				}
				// 插入修改后的模板。
				if (roomRCUCfgs.size() > 0) {
					for (RoomRCUCfg entity : roomRCUCfgs) {
						roomRCUCfgMapper.insert(entity);
					}
				}
			}
			if (hotelRoom.getId() != 0) {
				// 修改hotelRoom
				hotelRoom.setCreateTime(new Date());
				update(hotelRoom);
			} else {
				hotelRoom.setHotelId(hotelId);
				hotelRoom.setCreateTime(new Date());
				hotelRoom.setCreateTime(new Date());
				long i = insert(hotelRoom);
				return i;
			}
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}
