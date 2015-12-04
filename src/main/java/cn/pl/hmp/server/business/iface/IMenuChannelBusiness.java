package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.MenuChannel;
import cn.pl.hmp.server.dao.entity.MenuChannelExample;

public interface IMenuChannelBusiness  extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int deleteByMenuChannelId(Long id);
	/**
	 * 新增
	 * @param record
	 * @return
	 */
	long insert(MenuChannel record);
    /**
     * 通过编号查询
     * @param id
     * @return
     */
    MenuChannel selectByMenuChannelId(Long id);
    /**
     * 查询全部
     * @return
     */
    List<MenuChannel> selectAll();
    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<MenuChannel>> selectByPages(MenuChannelExample example,Pages page);
    /**
     * 更新
     * @param record
     * @return
     */
    int update(MenuChannel record);
    /**
     * 批量删除
     * @param idList
     * @return
     */
    int deleteOnBatch(List<Long> idList);
    /**
     * 根据用户名查用户
     * @return
     */
    List<MenuChannel> selectByExample(MenuChannelExample example);
    /**
     * 电视频道的发布
     * @param hotelId
     * @return
     * @throws Exception
     */
    JSONArray publish(Long hotelId);
}
