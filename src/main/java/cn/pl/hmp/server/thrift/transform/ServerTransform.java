/*
 * ServerTransform.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.thrift.transform;

import cn.pl.commons.pages.Pages;
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
		result.setAirConditionerNum(rlt.getAirConditionerNum());
		result.setAirConditionerStart(rlt.getAirConditionerStart());
		result.setAnalogInputNum(rlt.getAnalogInputNum());
		result.setAvailable(rlt.isAvailable());
		result.setBoardType(rlt.getBoardType());
		return result;
	}

	public static THotelRCUCfg transform(HotelRCUCfg rlt) {
		if (rlt == null)
			return null;
		THotelRCUCfg result = new THotelRCUCfg();
		result.setAirConditionerNum(rlt.getAirConditionerNum());
		if (rlt.getAirConditionerStart() != null)
			result.setAirConditionerStart(rlt.getAirConditionerStart());
		result.setAnalogInputNum(rlt.getAnalogInputNum());
		if (rlt.getAvailable() != null)
			result.setAvailable(rlt.getAvailable());
		result.setBoardType(rlt.getBoardType());
		return result;
	}
}
