package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoomType;

public interface IHotelRoomTypeBusiness extends IBusiness {
    /**
	 * 通过id删除
	 * 
	 * @param id
	 * @return
	 */
	int delete(Long id);

    /**
	 * 新增
	 * 
	 * @param record
	 * @return
	 */
	long insert(HotelRoomType record);

    /**
	 * 通过编号查询
	 * 
	 * @param id
	 * @return
	 */
	HotelRoomType selectById(Long id);
    /**
	 * 条件查询
	 * @return
	 */
	List<HotelRoomType> selectByHotel(Long hotelId);

    /**
	 * 条件分页查询
	 * 
	 * @param example
	 * @param page
	 * @return
	 */
	Map<Pages, List<HotelRoomType>> selectByPages(Long hotelId,
			Pages page);

    /**
	 * 更新
	 * 
	 * @param record
	 * @return
	 */
	int update(HotelRoomType record);

    /**
	 * 批量删除
	 * 
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
