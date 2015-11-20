package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.DataDict;
import cn.pl.hmp.server.dao.entity.DataDictExample;

public interface IDataDictBusiness  extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int deleteByDataDictId(Long id);
	/**
	 * 新增
	 * @param record
	 * @return
	 */
    int insert(DataDict record);
    /**
     * 通过编号查询
     * @param id
     * @return
     */
    DataDict selectByDataDictId(Long id);
    /**
     * 查询全部
     * @return
     */
    List<DataDict> selectAll();
    /**
     * 查询全部
     * @return
     */
    List<DataDict> selectByCase(DataDictExample example);
    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<DataDict>> selectByPages(DataDictExample example,Pages page);
    /**
     * 更新
     * @param record
     * @return
     */
    int update(DataDict record);
    /**
     * 批量删除
     * @param idList
     * @return
     */
    int deleteOnBatch(List<Long> idList);
}
