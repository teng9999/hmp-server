package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.SysMenu;
import cn.pl.hmp.server.dao.entity.SysMenuExample;

/**
 * menu接口
 * 
 * @author rjw
 *
 */

public interface ISysMenuBusiness extends IBusiness {
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
    long insert(SysMenu record);

    /**
     * 通过编号查询
     * @param id
     * @return
     */
    SysMenu selectByMenuId(Long id);

    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<SysMenu>> selectByPages(SysMenuExample example,Pages page);

    /**
     * 更新
     * @param record
     * @return
     */
    int update(SysMenu record);
    
    /**
     * 条件查询
     * @param example
     * @param page
     * @return
     */
    List<SysMenu> selectByExample(SysMenuExample example);

}
