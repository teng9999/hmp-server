package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoom;
import cn.pl.hmp.server.dao.entity.HotelRoomExample;

public interface IHotelRoomBusiness  extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int deleteByHotelRoomId(Long id);
	/**
	 * 新增
	 * @param record
	 * @return
	 */
	long insert(HotelRoom record);
    /**
     * 通过编号查询
     * @param id
     * @return
     */
    HotelRoom selectByHotelRoomId(Long id);
    /**
     * 查询全部
     * @return
     */
    List<HotelRoom> selectAll();
    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<HotelRoom>> selectByPages(HotelRoomExample example,Pages page);
    /**
     * 更新
     * @param record
     * @return
     */
    int update(HotelRoom record);
    /**
     * 批量删除
     * @param idList
     * @return
     */
    int deleteOnBatch(List<Long> idList);
}
