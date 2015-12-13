package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.MenuPages;
import cn.pl.hmp.server.dao.entity.MenuPagesExample;

public interface IMenuPagesBusiness extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int deleteByMenuPagesId(Long id);

    /**
	 * 新增
	 * @param record
	 * @return
	 */
    int insert(MenuPages record);

    /**
     * 通过编号查询
     * @param id
     * @return
     */
    MenuPages selectByMenuPagesId(Long id);

    /**
     * 查询全部
     * @return
     */
    List<MenuPages> selectAll();

    /**
     * 条件查询
     * @return
     */
    List<MenuPages> selectByExample(MenuPagesExample example);

    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<MenuPages>> selectByPages(MenuPagesExample example,Pages page);

    /**
     * 更新
     * @param record
     * @return
     */
    int update(MenuPages record);

    /**
     * 批量删除
     * @param idList
     * @return
     */
    int deleteOnBatch(List<Long> idList);
}
