package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.SysProgPkgs;
import cn.pl.hmp.server.dao.entity.SysProgPkgsExample;

public interface ISysProgPkgsBusiness  extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int deleteBySysProgPkgsId(Long id);
	/**
	 * 新增
	 * @param record
	 * @return
	 */
	long insert(SysProgPkgs record);
    /**
     * 通过编号查询
     * @param id
     * @return
     */
    SysProgPkgs selectBySysProgPkgsId(Long id);
    /**
     * 查询全部
     * @return
     */
    List<SysProgPkgs> selectAll();
    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<SysProgPkgs>> selectByPages(SysProgPkgsExample example,Pages page);
    /**
     * 更新
     * @param record
     * @return
     */
    int update(SysProgPkgs record);
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
    List<SysProgPkgs> selectByExample(SysProgPkgsExample example);
}
