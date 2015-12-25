package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoomTv;
import cn.pl.hmp.server.dao.entity.HotelRoomTvExample;

public interface IHotelRoomTvBusiness  extends IBusiness {
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
    long insert(HotelRoomTv record);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    HotelRoomTv selectById(Long id);

   
    /**
     * 条件分页查询
     * @param record
     * @return
     */
    Map<Pages, List<HotelRoomTv>> selectByPages(HotelRoomTvExample example,Pages page);

    /**
     * 修改酒店信息
     * @param record
     * @return
     */
    int update(HotelRoomTv record);

}
