package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HmpRoomTv;
import cn.pl.hmp.server.dao.entity.HmpRoomTvExample;

public interface IHmpRoomTvBusiness extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int deleteByHmpRoomTvId(Long id);

    /**
	 * 新增
	 * @param record
	 * @return
	 */
	long insert(HmpRoomTv record);

    /**
     * 通过播放内容查询
     * @param content
     * @return
     */
    List<HmpRoomTv> selectByExample(HmpRoomTvExample example);

    /**
     * 通过播放内容查询
     * @param content
     * @return
     */
    HmpRoomTv selectByHotelId(Long hotelId);

    /**
     * 查询全部
     * @return
     */
    List<HmpRoomTv> selectAll();

    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<HmpRoomTv>> selectByPages(HmpRoomTvExample example,Pages page);

    /**
     * 更新
     * @param record
     * @return
     */
    int update(HmpRoomTv record);

    /**
     * 发布
     * @param hotelId
     * @return
     */
    JSONObject publish(Long hotelId);
}
