package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.TvProgram;
import cn.pl.hmp.server.dao.entity.TvProgramExample;

public interface ITvProgramBusiness extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int deleteByTvProgramId(Long id);

    /**
	 * 新增
	 * @param record
	 * @return
	 */
	long insert(TvProgram record);

    /**
     * 通过播放内容查询
     * @param content
     * @return
     */
    List<TvProgram> selectByExample(TvProgramExample example);

    /**
     * 查询全部
     * @return
     */
    List<TvProgram> selectAll();

    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<TvProgram>> selectByPages(TvProgramExample example,Pages page);

    /**
     * 更新
     * @param record
     * @return
     */
    int update(TvProgram record);

    /**
     * 批量删除
     * @param idList
     * @return
     */
    int deleteOnBatch(List<Long> idList);
}
