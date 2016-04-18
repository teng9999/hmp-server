package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.TvChannel;
import cn.pl.hmp.server.dao.entity.TvChannelExample;
/**
 * 电视频道
 * @author gaot
 *
 */
public interface ITvChannelBusiness extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int deleteByTvChannelId(Long id);

    /**
	 * 新增
	 * @param record
	 * @return
	 */
	long insert(TvChannel record);

    /**
     * 通过电视台名称查询
     * @param example
     * @return
     */
    List<TvChannel> selectByExample(TvChannelExample example);

    /**
     * 查询全部
     * @return
     */
    List<TvChannel> selectAll();

    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<TvChannel>> selectByPages(TvChannelExample example,Pages page);

    /**
     * 更新
     * @param record
     * @return
     */
    int update(TvChannel record);

    /**
     * 批量删除
     * @param idList
     * @return
     */
    int deleteOnBatch(List<Long> idList);
}
