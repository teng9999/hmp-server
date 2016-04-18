package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoomType;

public interface IHotelRoomTypeBusiness extends IBusiness {
    /**
	 * 通过房间类型编号删除
	 * @param id   房间类型编号
	 * @return 状态码
	 */
	int delete(Long id);

    /**
	 * 新增
	 * @param record   房间类型信息
	 * @return 房间类型编号
	 */
	long insert(HotelRoomType record);

    /**
	 * 通过编号查询
	 * @param id   房间类型编号
	 * @return  房间类型信息
	 */
	HotelRoomType selectById(Long id);
    /**
	 * 条件查询
	 * @return
	 */
	List<HotelRoomType> selectByHotel(Long hotelId);

	/**
     * 条件分页查询
     * @param example 查询条件实例
     * @param page   分页条件
     * @return  结果集Map  key为分页条件,value为结果集列表
     */
	Map<Pages, List<HotelRoomType>> selectByPages(Long hotelId,
			Pages page);

	 /**
     * 更新
     * @param record   对象实例
     * @return 更新数据影响行数
     */
	int update(HotelRoomType record);

    /**
	 * 批量删除
	 * @param idList   
	 * @return
	 */
	int deleteOnBatch(List<Long> idList);
	/**
	 * 批量修改
	 * 
	 * @param idList
	 * @return
	 */
	int updateOnBatch(List<HotelRoomType> typeList);
	/**
	 * 检验是否存在该房型
	 * @param hotelId
	 * @param name
	 * @return
	 */
	boolean checkName(HotelRoomType roomType);
	/**
	 * 为已存在酒店添加默认房间类型
	 * @param typeList
	 * @return
	 */
	int addDefaultTypes(List<String> typeList);
	/**
	 * 查看不重复的房间类型列表
	 * @return
	 */
	List<String> queryAllDistinct(long hotelId);

}
