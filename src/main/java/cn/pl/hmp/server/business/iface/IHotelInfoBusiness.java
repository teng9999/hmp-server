package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HotelInfo;
import cn.pl.hmp.server.dao.entity.HotelInfoExample;

public interface IHotelInfoBusiness extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int deleteHotelAndUserByHotelId(Long id);

    /**
	 * 插入一条数据
	 * @param record
	 * @return
	 */
	long insert(HotelInfo record);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    HotelInfo selectByHotelId(Long id);

    /**
     * 查询全部
     * @return
     */
    List<HotelInfo> selectAll();

    /**
     * 条件分页查询
     * @param record
     * @return
     */
    Map<Pages, List<HotelInfo>> selectByPages(HotelInfoExample example,Pages page);

    /**
     * 修改酒店信息
     * @param record
     * @return
     */
    int update(HotelInfo record);

    /**
     * 通过用户名查询酒店信息
     * @return
     */
    List<HotelInfo> selectByUserId(Long userId);

    /**
     * 发布功能获取酒店信息
     * @param hotelId
     * @return
     */
    public JSONObject publish(Long hotelId);

}
