/*
 * ServerTransform.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.thrift.transform;

import cn.pl.commons.pages.Pages;
import cn.pl.commons.utils.DateUtil;
import cn.pl.frame.client.thrift.transform.ThriftTransform;
import cn.pl.frame.thrift.define.TPages;
import cn.pl.hmp.commons.thrift.define.TExample;
import cn.pl.hmp.commons.thrift.define.THotelRCUCfg;
import cn.pl.hmp.server.dao.entity.HmpTest;
import cn.pl.hmp.server.dao.entity.HotelRCUCfg;

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
}
