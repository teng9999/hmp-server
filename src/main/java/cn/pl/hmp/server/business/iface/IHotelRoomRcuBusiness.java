package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoomRcu;
import cn.pl.hmp.server.dao.entity.HotelRoomRcuExample;

public interface IHotelRoomRcuBusiness  extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 插入一条数据
     * @param record
     * @return
     */
    long insert(HotelRoomRcu record);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    HotelRoomRcu selectById(Long id);

   
    /**
     * 条件分页查询
     * @param record
     * @return
     */
    Map<Pages, List<HotelRoomRcu>> selectByPages(HotelRoomRcuExample example,Pages page);

    /**
     * 修改酒店信息
     * @param record
     * @return
     */
    int update(HotelRoomRcu record);
    /**
     * 条件分页查询已房间为准
     * @param record
     * @return
     */
    Map<Pages, List<HotelRoomRcu>> selectPagesByRoom(Long hotelId,Pages page);
    
    /**
     * 批量修改
     * 
     * @param idList
     * @return
     */
    int updateOnBatch(HotelRoomRcu record, String roomNums);

}
