/*
 * ServerTransform.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.thrift.transform;

import cn.pl.commons.pages.Pages;
import cn.pl.commons.utils.DateUtil;
import cn.pl.frame.client.thrift.transform.ThriftTransform;
import cn.pl.frame.thrift.define.TPages;
import cn.pl.hmp.commons.thrift.define.TAirMode;
import cn.pl.hmp.commons.thrift.define.TExample;
import cn.pl.hmp.commons.thrift.define.THotelRCUCfg;
import cn.pl.hmp.commons.thrift.define.TRoomRCUCfg;
import cn.pl.hmp.server.dao.entity.AirMode;
import cn.pl.hmp.server.dao.entity.HmpTest;
import cn.pl.hmp.server.dao.entity.HotelRCUCfg;
import cn.pl.hmp.server.dao.entity.RoomRCUCfg;

/**
 * @author alanyuan
 *
 */
public class ServerTransform extends ThriftTransform {
	public static HmpTest transform(TExample info) {
		if (info == null)
			return null;
		HmpTest result = new HmpTest();
		result.setId(info.getId());
		result.setName(info.getName());
		return result;
	}

	public static TExample transform(HmpTest rlt) {
		if (rlt == null)
			return null;
		TExample result = new TExample();
		result.setId(rlt.getId());
		result.setName(rlt.getName());
		return result;
	}

	public static Pages transform(TPages pages) {
		if (pages == null)
			return null;
		Pages result = new Pages();
		result.setPageNum(pages.getPageNum());
		result.setPageSize(pages.getPageSize());
		result.setSize(pages.getSize());
		result.setOrderBy(pages.getOrderBy());
		result.setEndRow(pages.getEndRow());
		result.setTotal(pages.getTotal());
		result.setPages(pages.getPages());
		result.setFirstPage(pages.getFirstPage());
		result.setPrePage(pages.getPrePage());
		result.setNextPage(pages.getNextPage());
		result.setLastPage(pages.getLastPage());
		result.setOnFirstPage(pages.isOnFirstPage());
		result.setOnLastPage(pages.isOnLastPage());
		result.setHasPreviousPage(pages.isHasPreviousPage());
		result.setHasNextPage(pages.isHasNextPage());
		result.setNavigatePages(pages.getNavigatePages());
		result.setNavigatepageNums(pages.getNavigatepageNums());

		return result;
	}

	public static TPages transform(Pages pages) {
		if (pages == null)
			return null;
		TPages result = new TPages();
		result.setPageNum(pages.getPageNum());
		result.setPageSize(pages.getPageSize());
		result.setSize(pages.getSize());
		result.setOrderBy(pages.getOrderBy());
		result.setEndRow(pages.getEndRow());
		result.setTotal(pages.getTotal());
		result.setPages(pages.getPages());
		result.setFirstPage(pages.getFirstPage());
		result.setPrePage(pages.getPrePage());
		result.setNextPage(pages.getNextPage());
		result.setLastPage(pages.getLastPage());
		result.setOnFirstPage(pages.isOnFirstPage());
		result.setOnLastPage(pages.isOnLastPage());
		result.setHasPreviousPage(pages.isHasPreviousPage());
		result.setHasNextPage(pages.isHasNextPage());
		result.setNavigatePages(pages.getNavigatePages());
		result.setNavigatepageNums(pages.getNavigatepageNums());

		return result;
	}

	/**
	 * @Title: transform
	 * @Description: TODO 将THotelRCUCfg对象转化为HotelRCUCfg对象。
	 * @param rlt
	 *            待转化的THotelRCUCfg对象。
	 * @return HotelRCUCfg 如果rlt为null，则返回null。相反则返回转化好的HotelRCUCfg对象。
	 */
	public static HotelRCUCfg transform(THotelRCUCfg rlt) {
		if (rlt == null)
			return null;
		HotelRCUCfg result = new HotelRCUCfg();
		if (rlt.getAirConditionerNum() != null) {
			result.setAirConditionerNum(rlt.getAirConditionerNum());
		}
		result.setAirConditionerStart(rlt.getAirConditionerStart());
		if (rlt.getAnalogInputNum() != null) {
			result.setAnalogInputNum(rlt.getAnalogInputNum());
		}
		result.setAvailable(rlt.isAvailable());
		if (rlt.getBoardType() != null) {
			result.setBoardType(rlt.getBoardType());
		}
		result.setConnNum(rlt.getConnNum());
		if (rlt.getCreateTime() != null) {
			result.setCreateTime(DateUtil.text2date(rlt.getCreateTime(), null));
		}
		result.setCreator(rlt.getCreator());
		if (rlt.getDigitalInputNum() != null) {
			result.setDigitalInputNum(rlt.getDigitalInputNum());
		}
		if (rlt.getDigitalOutputNum() != null) {
			result.setDigitalOutputNum(rlt.getDigitalOutputNum());
		}
		if (rlt.getDimmerNum() != null) {
			result.setDimmerNum(rlt.getDimmerNum());
		}
		if (rlt.getFactoryNum() != null) {
			result.setFactoryNum(rlt.getFactoryNum());
		}
		result.setHotelId(rlt.getHotelId());
		result.setId(rlt.getId());
		if (rlt.getIp() != null) {
			result.setIp(rlt.getIp());
		}
		result.setLightStart(rlt.getLightStart());
		result.setModifier(rlt.getModifier());
		if (rlt.getModifyTime() != null) {
			result.setModifyTime(DateUtil.text2date(rlt.getModifyTime(), null));
		}
		if (rlt.getOsVersion() != null) {
			result.setOsVersion(rlt.getOsVersion());
		}
		result.setPort(rlt.getPort());
		if (rlt.getPowerNum() != null) {
			result.setPowerNum(rlt.getPowerNum());
		}
		if (rlt.getProduceTime() != null) {
			result.setProduceTime(DateUtil.text2date(rlt.getProduceTime(), null));
		}
		result.setRoomId(rlt.getRoomId());
		if (rlt.getTimeLock() != null) {
			result.setTimeLock(rlt.getTimeLock());
		}
		if (rlt.getVersion() != null) {
			result.setVersion(rlt.getVersion());
		}
		return result;
	}

	/**
	 * @Title: transform
	 * @Description: TODO 将HotelRCUCfg对象转化为THotelRCUCfg对象。
	 * @param rlt
	 *            待转化的HotelRCUCfg对象。
	 * @return THotelRCUCfg 如果rlt为null，则返回null。相反则返回转化好的THotelRCUCfg对象。
	 */
	public static THotelRCUCfg transform(HotelRCUCfg rlt) {
		if (rlt == null)
			return null;
		THotelRCUCfg result = new THotelRCUCfg();
		if (rlt.getAirConditionerNum() != null) {
			result.setAirConditionerNum(rlt.getAirConditionerNum());
		}
		if (rlt.getAirConditionerStart() != null) {
			result.setAirConditionerStart(rlt.getAirConditionerStart());
		}
		if (rlt.getAnalogInputNum() != null) {
			result.setAnalogInputNum(rlt.getAnalogInputNum());
		}
		if (rlt.getAvailable() != null) {
			result.setAvailable(rlt.getAvailable());
		}
		if (rlt.getBoardType() != null) {
			result.setBoardType(rlt.getBoardType());
		}
		if (rlt.getConnNum() != null) {
			result.setConnNum(rlt.getConnNum());
		}
		if (rlt.getCreateTime() != null) {
			result.setCreateTime(DateUtil.date2Text(rlt.getCreateTime(), null));
		}
		if (rlt.getCreator() != null) {
			result.setCreator(rlt.getCreator());
		}
		if (rlt.getDigitalInputNum() != null) {
			result.setDigitalInputNum(rlt.getDigitalInputNum());
		}
		if (rlt.getDigitalOutputNum() != null) {
			result.setDigitalOutputNum(rlt.getDigitalOutputNum());
		}
		if (rlt.getDimmerNum() != null) {
			result.setDimmerNum(rlt.getDimmerNum());
		}
		if (rlt.getFactoryNum() != null) {
			result.setFactoryNum(rlt.getFactoryNum());
		}
		if (rlt.getHotelId() != null) {
			result.setHotelId(rlt.getHotelId());
		}
		if (rlt.getId() != null) {
			result.setId(rlt.getId());
		}
		if (rlt.getIp() != null) {
			result.setIp(rlt.getIp());
		}
		if (rlt.getLightStart() != null) {
			result.setLightStart(rlt.getLightStart());
		}
		if (rlt.getModifier() != null) {
			result.setModifier(rlt.getModifier());
		}
		if (rlt.getModifyTime() != null) {
			result.setModifyTime(DateUtil.date2Text(rlt.getModifyTime(), null));
		}
		if (rlt.getOsVersion() != null) {
			result.setOsVersion(rlt.getOsVersion());
		}
		if (rlt.getPort() != null) {
			result.setPort(rlt.getPort());
		}
		if (rlt.getPowerNum() != null) {
			result.setPowerNum(rlt.getPowerNum());
		}
		if (rlt.getProduceTime() != null) {
			result.setProduceTime(DateUtil.date2Text(rlt.getProduceTime(), null));
		}
		if (rlt.getRoomId() != null) {
			result.setRoomId(rlt.getRoomId());
		}
		if (rlt.getTimeLock() != null) {
			result.setTimeLock(rlt.getTimeLock());
		}
		if (rlt.getVersion() != null) {
			result.setVersion(rlt.getVersion());
		}
		return result;
	}

	/**
	 * @Title: transform
	 * @Description: TODO 将TRoomRCUCfg对象转化为RoomRCUCfg对象。
	 * @param rlt
	 *            待转化的TRoomRCUCfg对象。
	 * @return RoomRCUCfg 如果rlt为null，则返回null。相反则返回转化好的RoomRCUCfg对象。
	 */
	public static RoomRCUCfg transform(TRoomRCUCfg rlt) {
		if (rlt == null)
			return null;
		RoomRCUCfg result = new RoomRCUCfg();
		if (rlt.getCreateTime() != null) {
			result.setCreateTime(DateUtil.text2date(rlt.getCreateTime(), null));
		}
		result.setCreator(rlt.getCreator());
		result.setAvailable(rlt.isAvailable());
		result.setHotelId(rlt.getHotelId());
		result.setId(rlt.getId());
		result.setIp(rlt.getIp());
		if (rlt.getLineType() != null) {
			result.setLineType(rlt.getLineType());
		}
		result.setModifier(rlt.getModifier());
		if (rlt.getModifyTime() != null) {
			result.setModifyTime(DateUtil.text2date(rlt.getModifyTime(), null));
		}
		if (rlt.getName() != null) {
			result.setName(rlt.getName());
		}
		if (rlt.getNum() != null) {
			result.setNum(rlt.getNum());
		}
		if (rlt.getRemark() != null) {
			result.setRemark(rlt.getRemark());
		}
		result.setRoomId(rlt.getRoomId());
		if (rlt.getRoomType() != null) {
			result.setRoomType(rlt.getRoomType());
		}
		return result;
	}

	/**
	 * @Title: transform
	 * @Description: TODO 将RoomRCUCfg对象转化为TRoomRCUCfg对象。
	 * @param rlt
	 *            待转化的RoomRCUCfg对象。
	 * @return TRoomRCUCfg 如果rlt为null，则返回null。相反则返回转化好的TRoomRCUCfg对象。
	 */
	public static TRoomRCUCfg transform(RoomRCUCfg rlt) {
		if (rlt == null)
			return null;
		TRoomRCUCfg result = new TRoomRCUCfg();
		if (rlt.getCreateTime() != null) {
			result.setCreateTime(DateUtil.date2Text(rlt.getCreateTime(), null));
		}
		if (rlt.getCreator() != null) {
			result.setCreator(rlt.getCreator());
		}
		if (rlt.getAvailable() != null) {
			result.setAvailable(rlt.getAvailable());
		}
		if (rlt.getHotelId() != null) {
			result.setHotelId(rlt.getHotelId());
		}
		if (rlt.getId() != null) {
			result.setId(rlt.getId());
		}
		if (rlt.getIp() != null) {
			result.setIp(rlt.getIp());
		}
		if (rlt.getLineType() != null) {
			result.setLineType(rlt.getLineType());
		}
		if (rlt.getModifier() != null) {
			result.setModifier(rlt.getModifier());
		}
		if (rlt.getModifyTime() != null) {
			result.setModifyTime(DateUtil.date2Text(rlt.getModifyTime(), null));
		}
		if (rlt.getName() != null) {
			result.setName(rlt.getName());
		}
		if (rlt.getNum() != null) {
			result.setNum(rlt.getNum());
		}
		if (rlt.getRemark() != null) {
			result.setRemark(rlt.getRemark());
		}
		if (rlt.getRoomId() != null) {
			result.setRoomId(rlt.getRoomId());
		}
		if (rlt.getRoomType() != null) {
			result.setRoomType(rlt.getRoomType());
		}
		return result;
	}

	/**
	 * @Title: transform
	 * @Description: TODO 将TAirMode对象转化为AirMode对象。
	 * @param rlt
	 *            待转化的TAirMode对象。
	 * @return AirMode 如果rlt为null，则返回null。相反则返回转化好的AirMode对象。
	 */
	public static AirMode transform(TAirMode rlt) {
		if (rlt == null)
			return null;
		AirMode result = new AirMode();
		result.setAvailable(rlt.isAvailable());
		if (rlt.getCreateTime() != null) {
			result.setCreateTime(DateUtil.text2date(rlt.getCreateTime(), null));
		}
		result.setCreator(rlt.getCreator());
		result.setHotelId(rlt.getHotelId());
		result.setId(rlt.getId());
		if (rlt.getMode() != null) {
			result.setMode(rlt.getMode());
		}
		if (rlt.getModeId() != null) {
			result.setModeId(rlt.getModeId());
		}
		result.setModifier(rlt.getModifier());
		if (rlt.getModifyTime() != null) {
			result.setModifyTime(DateUtil.text2date(rlt.getModifyTime(), null));
		}
		if (rlt.getNid() != null) {
			result.setNid(rlt.getNid());
		}
		if (rlt.getNums() != null) {
			result.setNums(rlt.getNums());
		}
		return result;
	}

	/**
	 * @Title: transform
	 * @Description: TODO 将AirMode对象转化为TAirMode对象。
	 * @param rlt
	 *            待转化的AirMode对象。
	 * @return TAirMode 如果rlt为null，则返回null。相反则返回转化好的TAirMode对象。
	 */
	public static TAirMode transform(AirMode rlt) {
		if (rlt == null)
			return null;
		TAirMode result = new TAirMode();
		if (rlt.getAvailable() != null) {
			result.setAvailable(rlt.getAvailable());
		}
		if (rlt.getCreateTime() != null) {
			result.setCreateTime(DateUtil.date2Text(rlt.getCreateTime(), null));
		}
		if (rlt.getCreator() != null) {
			result.setCreator(rlt.getCreator());
		}
		if (rlt.getHotelId() != null) {
			result.setHotelId(rlt.getHotelId());
		}
		if (rlt.getId() != null) {
			result.setId(rlt.getId());
		}
		if (rlt.getMode() != null) {
			result.setMode(rlt.getMode());
		}
		if (rlt.getModeId() != null) {
			result.setModeId(rlt.getModeId());
		}
		if (rlt.getModifier() != null) {
			result.setModifier(rlt.getModifier());
		}
		if (rlt.getModifyTime() != null) {
			result.setModifyTime(DateUtil.date2Text(rlt.getModifyTime(), null));
		}
		if (rlt.getNid() != null) {
			result.setNid(rlt.getNid());
		}
		if (rlt.getNums() != null) {
			result.setNums(rlt.getNums());
		}
		return result;
	}
}
