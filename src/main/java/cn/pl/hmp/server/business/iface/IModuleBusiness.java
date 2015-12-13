package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.Module;
import cn.pl.hmp.server.dao.entity.ModuleExample;

public interface IModuleBusiness extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int deleteByModuleId(Long id);

    /**
	 * 新增
	 * @param record
	 * @return
	 */
    int insert(Module record);

    /**
     * 通过编号查询
     * @param id
     * @return
     */
    Module selectByModuleId(Long id);

    /**
     * 查询全部
     * @return
     */
    List<Module> selectAll();

    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<Module>> selectByPages(ModuleExample example,Pages page);

    /**
     * 更新
     * @param record
     * @return
     */
    int update(Module record);

    /**
     * 批量删除
     * @param idList
     * @return
     */
    int deleteOnBatch(List<Long> idList);
}
