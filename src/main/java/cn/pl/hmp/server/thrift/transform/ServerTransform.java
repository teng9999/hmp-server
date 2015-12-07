/*
 * ServerTransform.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.thrift.transform;

import java.util.Date;

import cn.pl.commons.pages.Pages;
import cn.pl.commons.utils.DateUtil;
import cn.pl.frame.client.thrift.transform.ThriftTransform;
import cn.pl.frame.thrift.define.TPages;
import cn.pl.hmp.commons.thrift.define.TAPPBinding;
import cn.pl.hmp.commons.thrift.define.TAPPInfo;
import cn.pl.hmp.commons.thrift.define.TAirMode;
import cn.pl.hmp.commons.thrift.define.TExample;
import cn.pl.hmp.commons.thrift.define.THmpHotelToolPacks;
import cn.pl.hmp.commons.thrift.define.THmpMG;
import cn.pl.hmp.commons.thrift.define.THmpMGHotel;
import cn.pl.hmp.commons.thrift.define.THmpMovie;
import cn.pl.hmp.commons.thrift.define.THmpMovieGroup;
import cn.pl.hmp.commons.thrift.define.THotelRCUCfg;
import cn.pl.hmp.commons.thrift.define.TRoomRCUCfg;
import cn.pl.hmp.server.dao.entity.APPBinding;
import cn.pl.hmp.server.dao.entity.APPInfo;
import cn.pl.hmp.server.dao.entity.AirMode;
import cn.pl.hmp.server.dao.entity.HmpHotelToolPacks;
import cn.pl.hmp.server.dao.entity.HmpMG;
import cn.pl.hmp.server.dao.entity.HmpMGHotel;
import cn.pl.hmp.server.dao.entity.HmpMovie;
import cn.pl.hmp.server.dao.entity.HmpMovieGroup;
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



	/**
	 * @Title: transform
	 * @Description: 将TAPPInfo对象转化为APPInfo对象。
	 * @param rlt
	 *            待转化的TAPPInfo对象。
	 * @return APPInfo 如果rlt为null，则返回null。相反则返回转化好的APPInfo对象。
	 */
	public static APPInfo transform(TAPPInfo rlt) {
		if (rlt == null)
			return null;
		APPInfo result = new APPInfo();
		if (rlt.getAllSpell() != null) {
			result.setAllSpell(rlt.getAllSpell());
		}
		if (rlt.getAndroidAddr() != null) {
			result.setAndroidAddr(rlt.getAndroidAddr());
		}
		if (rlt.getAppImage() != null) {
			rlt.setAppImage(rlt.getAppImage());
		}
		if (rlt.getCreateTime() != null) {
			result.setCreateTime(DateUtil.text2date(rlt.getCreateTime(), null));
		}
		result.setCreator(rlt.getCreator());
		if (rlt.getFirstSpell() != null) {
			result.setFirstSpell(rlt.getFirstSpell());
		}
		result.setId(rlt.getId());
		if (rlt.getIntro() != null) {
			result.setIntro(rlt.getIntro());
		}
		if (rlt.getIosAddr() != null) {
			result.setIosAddr(rlt.getIosAddr());
		}
		result.setModifier(rlt.getModifier());
		if (rlt.getModifyTime() != null) {
			result.setModifyTime(DateUtil.text2date(rlt.getModifyTime(), null));
		}
		if (rlt.getNameCn() != null) {
			result.setNameCn(rlt.getNameCn());
		}
		if (rlt.getNameEn() != null) {
			result.setNameEn(rlt.getNameEn());
		}
		if (rlt.getSecondAddr() != null) {
			result.setSecondAddr(rlt.getSecondAddr());
		}
		result.setOrgId(rlt.getOrgId());
		result.setSysId(rlt.getSysId());
		return result;
	}

	/**
	 * @Title: transform
	 * @Description: 将APPInfo对象转化为TAPPInfo对象。
	 * @param rlt
	 *            待转化的APPInfo对象。
	 * @return TAPPInfo 如果rlt为null，则返回null。相反则返回转化好的TAPPInfo对象。
	 */
	public static TAPPInfo transform(APPInfo rlt) {
		if (rlt == null)
			return null;
		TAPPInfo result = new TAPPInfo();
		if (rlt.getAllSpell() != null) {
			result.setAllSpell(rlt.getAllSpell());
		}
		if (rlt.getAndroidAddr() != null) {
			result.setAndroidAddr(rlt.getAndroidAddr());
		}
		if (rlt.getAppImage() != null) {
			rlt.setAppImage(rlt.getAppImage());
		}
		if (rlt.getCreateTime() != null) {
			result.setCreateTime(DateUtil.date2Text(rlt.getCreateTime(), null));
		}
		if (rlt.getCreator() != null) {
			result.setCreator(rlt.getCreator());
		}
		if (rlt.getFirstSpell() != null) {
			result.setFirstSpell(rlt.getFirstSpell());
		}
		if (rlt.getId() != null) {
			result.setId(rlt.getId());
		}
		if (rlt.getIntro() != null) {
			result.setIntro(rlt.getIntro());
		}
		if (rlt.getIosAddr() != null) {
			result.setIosAddr(rlt.getIosAddr());
		}
		if (rlt.getModifier() != null) {
			result.setModifier(rlt.getModifier());
		}
		if (rlt.getModifyTime() != null) {
			result.setModifyTime(DateUtil.date2Text(rlt.getModifyTime(), null));
		}
		if (rlt.getNameCn() != null) {
			result.setNameCn(rlt.getNameCn());
		}
		if (rlt.getNameEn() != null) {
			result.setNameEn(rlt.getNameEn());
		}
		if (rlt.getSecondAddr() != null) {
			result.setSecondAddr(rlt.getSecondAddr());
		}
		if (rlt.getOrgId() != null) {
			result.setOrgId(rlt.getOrgId());
		}
		if (rlt.getSysId() != null) {
			result.setSysId(rlt.getSysId());
		}
		return result;
	}

	/**
	 * @Title: transform
	 * @Description: 将TAPPBinding对象转化为APPBinding对象。
	 * @param rlt
	 *            待转化的TAPPBinding对象。
	 * @return APPBinding 如果rlt为null，则返回null。相反则返回转化好的APPBinding对象。
	 */
	public static APPBinding transform(TAPPBinding rlt) {
		if (rlt == null)
			return null;
		APPBinding result = new APPBinding();
		if (rlt.getAppId() != null) {
			result.setAppId(rlt.getAppId());
		}
		if (rlt.getAppPath() != null) {
			result.setAppPath(rlt.getAppPath());
		}
		result.setAppStatus(rlt.getAppStatus());
		result.setDownTime(rlt.getDownTime());
		result.setHotelId(rlt.getHotelId());
		result.setId(rlt.getId());
		result.setOrgId(rlt.getOrgId());
		if (rlt.getRoomNum() != null) {
			result.setRoomNum(rlt.getRoomNum());
		}
		result.setSysId(rlt.getSysId());
		return result;
	}

	/**
	 * @Title: transform
	 * @Description: 将APPBinding对象转化为TAPPBinding对象。
	 * @param rlt
	 *            待转化的APPBinding对象。
	 * @return TAPPBinding 如果rlt为null，则返回null。相反则返回转化好的TAPPBinding对象。
	 */
	public static TAPPBinding transform(APPBinding rlt) {
		if (rlt == null)
			return null;
		TAPPBinding result = new TAPPBinding();
		if (rlt.getAppId() != null) {
			result.setAppId(rlt.getAppId());
		}
		if (rlt.getAppPath() != null) {
			result.setAppPath(rlt.getAppPath());
		}
		if (rlt.getAppStatus() != null) {
			result.setAppStatus(rlt.getAppStatus());
		}
		if (rlt.getDownTime() != null) {
			result.setDownTime(rlt.getDownTime());
		}
		if (rlt.getHotelId() != null) {
			result.setHotelId(rlt.getHotelId());
		}
		if (rlt.getId() != null) {
			result.setId(rlt.getId());
		}
		if (rlt.getOrgId() != null) {
			result.setOrgId(rlt.getOrgId());
		}
		if (rlt.getRoomNum() != null) {
			result.setRoomNum(rlt.getRoomNum());
		}
		if (rlt.getSysId() != null) {
			result.setSysId(rlt.getSysId());
		}
		return result;
	}
	
	public static HmpMovie transform(THmpMovie info) {
		if (info == null)
			return null;
		HmpMovie result = new HmpMovie();
		if(0 < info.getId())
			result.setId(info.getId());
		if (null != info.getNameCn())
			result.setNameCn(info.getNameCn());
		if (null != info.getNameEn())
			result.setNameEn(info.getNameEn());
		if (null != info.getFirstSpell())
			result.setFirstSpell(info.getFirstSpell());
		if (null != info.getAllSpell())
			result.setAllSpell(info.getAllSpell());
		if (0 < info.getHotelId())
			result.setHotelId(info.getHotelId());
		if (null != info.getPath())
			result.setPath(info.getPath());
		if (null != info.getBackImg())
			result.setBackImg(info.getBackImg());
		if (null != info.getBackImgSmall())
			result.setBackImgSmall(info.getBackImgSmall());
		if (null != info.getPlaceNum())
			result.setPlaceNum(info.getPlaceNum());
		if (null != info.getFirstClass())
			result.setFirstClass(info.getFirstClass());
		if (null != info.getSencondClass())
			result.setSecondClass(info.getSencondClass());
		if (null != info.getShowYear())
			result.setShowYear(info.getShowYear());
		if (null != info.getArea())
			result.setArea(info.getArea());
		if (null != info.getSetNum())
			result.setSetNum(info.getSetNum());
		if (null != info.getDirect())
			result.setDirect(info.getDirect());
		if (null != info.getMovieLan())
			result.setMovieLan(info.getMovieLan());
		if (null != info.getTimeLength())
			result.setTimeLength(info.getTimeLength());
		if (null != info.getTimeLength() && 0 < info.getTimeLength().length())
			result.setCreateTime(DateUtil.text2date(info.getTimeLength(), null));
		else
			result.setCreateTime(new Date());
		if (null != info.getIntro())
			result.setIntro(info.getIntro());
		return result;
	}
	public static THmpMovie transform(HmpMovie info) {
		if (null == info)
			return null;
		THmpMovie result = new THmpMovie();
		if(null != info.getNameCn() && 0 < info.getId())
			result.setId(info.getId());
		if(null != info.getNameCn())
			result.setNameCn(info.getNameCn());
		if (null != info.getNameEn())
			result.setNameEn(info.getNameEn());
		if (null != info.getFirstSpell())
			result.setFirstSpell(info.getFirstSpell());
		if (null != info.getFirstSpell())
			result.setAllSpell(info.getAllSpell());
		if (null != info.getHotelId() && info.getHotelId() > 0)
			result.setHotelId(info.getHotelId());
		if (null != info.getPath())
			result.setPath(info.getPath());
		if (null != info.getBackImg())
			result.setBackImg(info.getBackImg());
		if (null != info.getBackImgSmall())
			result.setBackImgSmall(info.getBackImgSmall());
		if (null != info.getPlaceNum())
			result.setPlaceNum(info.getPlaceNum());
		if (null != info.getFirstClass())
			result.setFirstClass(info.getFirstClass());
		if (null != info.getSecondClass())
			result.setSencondClass(info.getSecondClass());
		if (null != info.getShowYear())
			result.setShowYear(info.getShowYear());
		if (null != info.getArea())
			result.setArea(info.getArea());
		if (null != info.getSetNum())
			result.setSetNum(info.getSetNum());
		if (null != info.getDirect())
			result.setDirect(info.getDirect());
		if (null != info.getMovieLan())
			result.setMovieLan(info.getMovieLan());
		if (null != info.getTimeLength())
			result.setTimeLength(info.getTimeLength());
		if (null != info.getCreateTime())
			result.setCreateTime(DateUtil.date2Text(info.getCreateTime(), null));
		if (null != info.getIntro())
			result.setIntro(info.getIntro());
		return result;
	}
	
	public static HmpMovieGroup transform(THmpMovieGroup info) {
		if (info == null)
			return null;
		HmpMovieGroup result = new HmpMovieGroup();
		if(0 < info.getId())
			result.setId(info.getId());
		if(0 < info.getSysId())
			result.setSysId(info.getSysId());
		if(0 < info.getOrgId())
			result.setOrgId(info.getOrgId());
		if(0 < info.getHotelId())
			result.setHotelId(info.getHotelId());
		if (null != info.getGroupName())
			result.setGroupName(info.getGroupName());
		if (0 <  info.getGroupType())
			result.setGroupType(true);
		else
			result.setGroupType(false);
		if(0 < info.getAdminFlag())
			result.setAdminFlag(true);
		else
			result.setAdminFlag(false);
		if(null != info.getCreateTime())
			result.setCreateTime(DateUtil.text2date(info.getCreateTime(), null));
		if(0 < info.getCreator())
			result.setCreator(info.getCreator());
		if(null != info.getModifyTime())
			result.setModifyTime(DateUtil.text2date(info.getModifyTime(), null));
		if(0 < info.getModifier())
			result.setModifier(info.getModifier());
		if(0 < info.getAvailable())
			result.setAvailable(true);
		else
			result.setAvailable(false);
		return result;
	}
	
	public static  THmpMovieGroup transform(HmpMovieGroup info) {
		if (info == null)
			return null;
		THmpMovieGroup result = new THmpMovieGroup();
		result.setId(info.getId());
		if(null != info.getSysId() && 0 < info.getSysId())
			result.setSysId(info.getSysId());
		if(null != info.getOrgId() && 0 < info.getOrgId())
			result.setOrgId(info.getOrgId());
		if(null != info.getHotelId() && 0 < info.getHotelId())
			result.setHotelId(info.getHotelId());
		if (null != info.getGroupName())
			result.setGroupName(info.getGroupName());
		if (info.getGroupType())
			result.setGroupType((short)1);
		else
			result.setGroupType((short) 0);
		if(info.getAdminFlag())
			result.setAdminFlag((short)1);
		else
			result.setAdminFlag((short)0);
		if(null != info.getCreateTime())
			result.setCreateTime(DateUtil.date2Text(info.getCreateTime(), null));
		if(null != info.getCreator() && 0 < info.getCreator())
			result.setCreator(info.getCreator());
		if(null != info.getModifyTime())
			result.setModifyTime(DateUtil.date2Text(info.getModifyTime(), null));
		if(info.getModifier() !=null && 0 < info.getModifier())
			result.setModifier(info.getModifier());
		if(info.getAvailable() != null && info.getAvailable())
			result.setAvailable((short)1);
		else
			result.setAvailable((short)0);
		return result;
	}
	
	public static THmpMG transform(HmpMG info) {
		if (null == info)
			return null;
		THmpMG result = new THmpMG();
		if (null != info.getId() && 0 < info.getId())
			result.setId(info.getId());
		if (null != info.getSysId() && 0 < info.getSysId())
			result.setSysId(info.getSysId());
		if (null != info.getOrgId() && 0 < info.getOrgId())
			result.setOrgId(info.getOrgId());
		if (null != info.getGroupId() && 0 < info.getGroupId())
			result.setGroupId(info.getGroupId());
		if (null != info.getMovieId() && 0 < info.getMovieId())
			result.setMovieId(info.getMovieId());
		if (null != info.getCreateTime())
			result.setCreateTime(DateUtil.date2Text(info.getCreateTime(), null));
		else 
			result.setCreateTime(DateUtil.date2Text(new Date(), null));
		if (null != info.getCreator() && 0 < info.getCreator())
			result.setCreator(info.getCreator());
		return result;
	}
	
	public static HmpMG transform(THmpMG info) {
		if (null == info)
			return null;
		HmpMG result = new HmpMG();
		if (0 < info.getId())
			result.setId(info.getId());
		if (0 < info.getSysId())
			result.setSysId(info.getSysId());
		if (0 < info.getOrgId())
			result.setOrgId(info.getOrgId());
		if (0 < info.getGroupId())
			result.setGroupId(info.getGroupId());
		if (0 < info.getMovieId())
			result.setMovieId(info.getMovieId());
		if (null != info.getCreateTime())
			result.setCreateTime(DateUtil.text2date(info.getCreateTime(), null));
		if (0 < info.getCreator())
			result.setCreator(info.getCreator());
		return result;
	}
	public static THmpMGHotel transform(HmpMGHotel info) {
		if (null == info)
			return null;
		THmpMGHotel result = new THmpMGHotel();
		if (null != info.getId() && 0 < info.getId())
			result.setId(info.getId());
		if (null != info.getSysId() && 0 < info.getSysId())
			result.setSysId(info.getSysId());
		if (null != info.getOrgId() && 0 < info.getOrgId())
			result.setOrgId(info.getOrgId());
		if (null != info.getGroupId() && 0 < info.getGroupId())
			result.setGroupId(info.getGroupId());
		if (null != info.getHotelId() && 0 < info.getHotelId())
			result.setHotelId(info.getHotelId());
		if (null != info.getCreateTime())
			result.setCreateTime(DateUtil.date2Text(info.getCreateTime(), null));
		else 
			result.setCreateTime(DateUtil.date2Text(new Date(), null));
		if (null != info.getCreator() && 0 < info.getCreator())
			result.setCreator(info.getCreator());
		return result;
	}
	
	public static HmpMGHotel transform(THmpMGHotel info) {
		if (null == info)
			return null;
		HmpMGHotel result = new HmpMGHotel();
		if (0 < info.getId())
			result.setId(info.getId());
		if (0 < info.getSysId())
			result.setSysId(info.getSysId());
		if (0 < info.getOrgId())
			result.setOrgId(info.getOrgId());
		if (0 < info.getGroupId())
			result.setGroupId(info.getGroupId());
		if (0 < info.getHotelId())
			result.setHotelId(info.getHotelId());
		if (null != info.getCreateTime())
			result.setCreateTime(DateUtil.text2date(info.getCreateTime(), null));
		if (0 < info.getCreator())
			result.setCreator(info.getCreator());
		return result;
	}
	
	public static HmpHotelToolPacks transform(THmpHotelToolPacks info) {
		if (null == info) {
			return null;
		}
		HmpHotelToolPacks result = new HmpHotelToolPacks();
		if (0 < info.getId())
			result.setId(info.getId());
		if (0 < info.getSysId())
			result.setSysId(info.getSysId());
		if (0 < info.getOrgId())
			result.setOrgId(info.getOrgId());
		if (0 < info.getHotelId())
			result.setHotelId(info.getHotelId());
		if (null != info.getPkgType())
			result.setPkgType(info.getPkgType());
		if (null != info.getCurVersion())
			result.setCurVersion(info.getCurVersion());
		if (null != info.getCreateDate())
			result.setCreateDate(DateUtil.text2date(info.getCreateDate(), null));
		if (null != info.getModifyTime())
			result.setModifyTime(DateUtil.text2date(info.getModifyTime(), null));
		if (null != info.getHotelName())
			result.setHotelName(info.getHotelName());
		if (null != info.getSubName())
			result.setSubName(info.getSubName());
		if (null != info.getType())
			result.setType(info.getType());
		if (null != info.getAddress())
			result.setAddress(info.getAddress());
		if (null != info.getLastVersion())
			result.setLastVersion(info.getLastVersion());
		if (null != info.getLink())
			result.setLink(info.getLink());
		
		result.setOnline(info.isOnline());
			
		return result;
	}
	
	public static THmpHotelToolPacks transform(HmpHotelToolPacks info) {
		if (null == info) {
			return null;
		}
		THmpHotelToolPacks result = new THmpHotelToolPacks();
		result.setId(info.getId());
		if (null != info.getSysId())
			result.setSysId(info.getSysId());
		if (null != info.getOrgId())
			result.setOrgId(info.getOrgId());
		if (null != info.getHotelId() && 0 < info.getHotelId())
			result.setHotelId(info.getHotelId());
		if (null != info.getPkgType())
			result.setPkgType(info.getPkgType());
		if (null != info.getCurVersion())
			result.setCurVersion(info.getCurVersion());
		if (null != info.getCreateDate())
			result.setCreateDate(DateUtil.date2Text(info.getCreateDate(), null));
		if (null != info.getModifyTime())
			result.setModifyTime(DateUtil.date2Text(info.getModifyTime(), null));
		if (null != info.getHotelName())
			result.setHotelName(info.getHotelName());
		if (null != info.getSubName())
			result.setSubName(info.getSubName());
		if (null != info.getType())
			result.setType(info.getType());
		if (null != info.getAddress())
			result.setAddress(info.getAddress());
		if (null != info.getLastVersion())
			result.setLastVersion(info.getLastVersion());
		if (null != info.getLink())
			result.setLink(info.getLink());
		
		result.setOnline(info.getOnline());
		return result;
	}
}
