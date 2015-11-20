/*
 * IExampleBusiness.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.RoomRCUCfg;
import cn.pl.hmp.server.dao.entity.RoomRCUCfgExample;
import cn.pl.hmp.server.datasource.DataSource;

/**
 * RoomRcu
 *
 * @author zhoujianbiao
 */
public interface IRoomRCUCfgBusiness extends IBusiness {
	/**
	 * 按条件查询
	 *
	 * @param example
	 * @return
	 */
	@DataSource("cluster")
	public List<RoomRCUCfg> query(RoomRCUCfgExample example);

	/**
	 * 按条件查询
	 *
	 * @param example
	 * @param pages
	 * @return
	 */
	@DataSource("cluster")
	public Map<Pages, List<RoomRCUCfg>> queryPages(RoomRCUCfgExample example,
			Pages pages);

	/**
	 * 获取
	 *
	 * @param id
	 * @return
	 */
	@DataSource("cluster")
	public RoomRCUCfg get(Long id);

	/**
	 * 创建
	 *
	 * @param record
	 * @return
	 */
	public int create(RoomRCUCfg record);

	/**
	 * 更新
	 *
	 * @param record
	 * @return
	 */
	public int update(RoomRCUCfg record);

	/**
	 * 删除
	 *
	 * @param id
	 * @return
	 */
	public int remove(Long id);
}
