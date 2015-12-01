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

	/**
	 * @Title: apply2room
	 * @Description: 模板配置页面的应用功能。
	 * @param @param roomType 房间类型
	 * @param @param hotelId 酒店ID
	 * @return void 返回类型
	 * @throws
	 */
	public boolean apply2room(String roomType, long hotelId);

	/**
	 * @Title: queryListByRoomTypeAndHotelId
	 * @Description: 根据酒店ID和roomType来查询模板。
	 * @param @param roomType
	 * @param @param hotelId
	 * @param @return 设定文件
	 * @return List<RoomRCUCfg> 返回类型
	 * @throws
	 */
	public List<RoomRCUCfg> queryListByRoomTypeAndHotelId(String roomType,
			long hotelId);

	/**
	 * @Title: removeByHotelAndRoomType
	 * @Description: 根据roomtype和hotelId来删除所有相关模板。
	 * @param @param roomType
	 * @param @param hotelId
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean removeByHotelAndRoomType(String roomType, long hotelId);
}
