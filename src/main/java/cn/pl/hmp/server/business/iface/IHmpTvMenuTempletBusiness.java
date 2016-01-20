package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HmpTvMenuTemplet;
import cn.pl.hmp.server.dao.entity.HmpTvMenuTempletExample;;

public interface IHmpTvMenuTempletBusiness extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int deleteById(Long id);

	/**
     * 批量删除
     * @param id
     * @return
     */
	int deleteOnBatch(List<Long> idList);
	
    /**
	 * 新增
	 * @param record
	 * @return
	 */
	long insert(HmpTvMenuTemplet record);

    /**
     * 通过条件查询
     * @param example
     * @return
     */
    List<HmpTvMenuTemplet> selectByExample(HmpTvMenuTempletExample example);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    HmpTvMenuTemplet selectByPrimaryKey(Long id);

    /**
     * 查询全部
     * @return
     */
    List<HmpTvMenuTemplet> selectAll();

    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<HmpTvMenuTemplet>> selectByPages(HmpTvMenuTempletExample example,Pages page);

    /**
     * 更新
     * @param record
     * @return
     */
    int update(HmpTvMenuTemplet record);

}
