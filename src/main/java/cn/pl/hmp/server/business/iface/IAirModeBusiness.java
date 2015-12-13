/*
 * IExampleBusiness.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.AirMode;
import cn.pl.hmp.server.dao.entity.AirModeExample;
import cn.pl.hmp.server.datasource.DataSource;

/**
 * AirMode
 *
 * @author zhoujianbiao
 */
public interface IAirModeBusiness extends IBusiness {
    /**
	 * 按条件查询
	 *
	 * @param example
	 * @return
	 */
	@DataSource("cluster")
	public List<AirMode> query(AirModeExample example);

    /**
	 * 按条件查询
	 *
	 * @param example
	 * @param pages
	 * @return
	 */
	@DataSource("cluster")
	public Map<Pages, List<AirMode>> queryPages(AirModeExample example,
			Pages pages);

    /**
	 * 获取
	 *
	 * @param id
	 * @return
	 */
	@DataSource("cluster")
	public AirMode get(Long id);

    /**
	 * 创建
	 *
	 * @param record
	 * @return
	 */
	public int create(AirMode record);

    /**
	 * 更新
	 *
	 * @param record
	 * @return
	 */
	public int update(AirMode record);

    /**
	 * 删除
	 *
	 * @param id
	 * @return
	 */
	public int remove(Long id);
}
