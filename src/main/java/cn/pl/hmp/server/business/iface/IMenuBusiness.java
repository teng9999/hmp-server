package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.Menu;
import cn.pl.hmp.server.dao.entity.MenuExample;

/**
 * menu接口
 * 
 * @author rjw
 *
 */

public interface IMenuBusiness extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int deleteByMenuId(Long id);

    /**
	 * 新增
	 * @param record
	 * @return
	 */
    int insert(Menu record);

    /**
     * 通过编号查询
     * @param id
     * @return
     */
    Menu selectByMenuId(Long id);

    /**
     * 查询全部
     * @return
     */
    List<Menu> selectAll();

    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<Menu>> selectByPages(MenuExample example,Pages page);

    /**
     * 根据酒店编号和父级编号分页查询（hotelId=0 表示公用 parentId=）
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<Menu>> selectHotelMenuByHotelId(Long hotelId,Long parentId,Pages page);

    /**
     * 更新
     * @param record
     * @return
     */
    int update(Menu record);

    /**
     * 批量删除
     * @param idList
     * @return
     */
    int deleteOnBatch(List<Long> idList);

    /**
     * 根据父级查所有子级菜单和路径
     * @param parentId
     * @return
     */
    List<Menu> selectByParentId(Long parentId);
}
