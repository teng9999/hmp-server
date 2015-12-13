package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HmpMovieGroup;
import cn.pl.hmp.server.dao.entity.HmpMovieGroupExample;
import cn.pl.hmp.server.datasource.DataSource;

/**
* 
*/
public interface IHmpMovieGroupBusiness extends IBusiness {
    /**
	 * 按条件查询
	 *
	 * @param example
	 * @return
	 */
	@DataSource("cluster")
	public List<HmpMovieGroup> query(HmpMovieGroupExample example);

    /**
	 * 按条件查询
	 *
	 * @param example
	 * @param pages
	 * @return
	 */
	@DataSource("cluster")
	public Map<Pages, List<HmpMovieGroup>> queryPages(HmpMovieGroupExample example,Pages pages);

    /**
	 * 获取
	 *
	 * @param id
	 * @return
	 */
	@DataSource("cluster")
	public HmpMovieGroup get(Long id);

    /**
	 * 创建
	 *
	 * @param record
	 * @return
	 */
	public int create(HmpMovieGroup record);

    /**
	 * 更新
	 *
	 * @param record
	 * @return
	 */
	public int update(HmpMovieGroup record);

    /**
	 * 删除
	 *
	 * @param id
	 * @return
	 */
	public int remove(Long id);

    /**
	 * 按照组类型获取分组
	 * 
	 * @param groupId
	 * @return
	 */
	public List<HmpMovieGroup> selectByGroupType (Long groupId);
}
