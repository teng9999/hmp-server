/*
 * IExampleBusiness.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.APPInfo;
import cn.pl.hmp.server.dao.entity.APPInfoExample;
import cn.pl.hmp.server.datasource.DataSource;

/**
 * RoomRcu
 *
 * @author zhoujianbiao
 */
public interface IAPPInfoBusiness extends IBusiness {
    /**
	 * 按条件查询
	 *
	 * @param example
	 * @return
	 */
	@DataSource("cluster")
	public List<APPInfo> query(APPInfoExample example);

    /**
	 * 按条件查询
	 *
	 * @param example
	 * @param pages
	 * @return
	 */
	@DataSource("cluster")
	public Map<Pages, List<APPInfo>> queryPages(APPInfoExample example,
			Pages pages);

    /**
	 * 获取
	 *
	 * @param id
	 * @return
	 */
	@DataSource("cluster")
	public APPInfo get(Long id);

    /**
	 * 创建
	 *
	 * @param record
	 * @return
	 */
	public int create(APPInfo record);

    /**
	 * 更新
	 *
	 * @param record
	 * @return
	 */
	public int update(APPInfo record);

    /**
	 * 删除
	 *
	 * @param id
	 * @return
	 */
	public int remove(Long id);
}
