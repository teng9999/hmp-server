package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoom;
import cn.pl.hmp.server.dao.entity.HotelRoomExample;

import com.alibaba.fastjson.JSONArray;

public interface IHotelRoomBusiness extends IBusiness {
	/**
	 * 通过id删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteByHotelRoomId(Long id);

	/**
	 * 新增
	 * 
	 * @param record
	 * @return
	 */
	long insert(HotelRoom record);

	/**
	 * 通过编号查询
	 * 
	 * @param id
	 * @return
	 */
	HotelRoom selectByHotelRoomId(Long id);

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	List<HotelRoom> selectAll();
	
	/**
	 * 条件查询
	 * @return
	 */
	List<HotelRoom> selectByExample(HotelRoomExample example);

	/**
	 * 条件分页查询
	 * 
	 * @param example
	 * @param page
	 * @return
	 */
	Map<Pages, List<HotelRoom>> selectByPages(Long hotelId,
			Pages page);

	/**
	 * 更新
	 * 
	 * @param record
	 * @return
	 */
	int update(HotelRoom record);

	/**
	 * 批量删除
	 * 
	 * @param idList
	 * @return
	 */
	int deleteOnBatch(List<Long> idList);

	/**
	 * 批量添加
	 * 
	 * @param idList
	 * @return
	 */
	int saveOnBatch(HotelRoom record, String roomNums);

	/**
	 * @param hotelId
	 * @Title: updateAndRcu
	 * @Description: 更新房间和rcu模板配置
	 * @param @param convet
	 * @param @param rcutemplateStr
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	long updateAndRcu(HotelRoom convet, String rcutemplateStr, long hotelId);
	/**
	 * 发布
	 * @param hotelId
	 * @return
	 */
    JSONArray publish(Long hotelId);
}
