package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.datasource.DataSource;
import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HmpMG;
import cn.pl.hmp.server.dao.entity.HmpMGExample;

public interface IHmpMGBusiness extends IBusiness {
    /**
	 * 按条件查询
	 *
	 * @param example
	 * @return
	 */
	@DataSource("cluster")
	public List<HmpMG> query(HmpMGExample example);

    /**
	 * 按条件分页查询
	 *
	 * @param example
	 * @param pages
	 * @return
	 */
	@DataSource("cluster")
	public Map<Pages, List<HmpMG>> queryPages(HmpMGExample example,Pages pages);

    /**
	 * 获取
	 *
	 * @param id
	 * @return
	 */
	@DataSource("cluster")
	public HmpMG get(Long id);

    /**
	 * 创建
	 *
	 * @param record
	 * @return
	 */
	@DataSource("cluster")
	public int create(HmpMG record);

    /**
	 * 更新
	 *
	 * @param record
	 * @return
	 */
	@DataSource("cluster")
	public int update(HmpMG record);

    /**
	 * 删除
	 *
	 * @param id
	 * @return
	 */
	@DataSource("cluster")
	public int remove(Long id);

    /**
	 * 按电影分组查询电影ID
	 *
	 * @param example
	 * @return
	 */
	@DataSource("cluster")
	public List<Long> queryByGroupId(Long groupId);

    /***
	 * 批量添加
	 * @param mgList
	 * @return
	 */
	@DataSource("cluster")
	public int saveOnBatch(List<HmpMG> mgList);

    /***
	 * 
	 */
	@DataSource("cluster")
	public int deleteOnBatch(List<Long> idList,Long groupId);

    /***
	 * 
	 */
	@DataSource("cluster")
	public int deleteByGroupIdOnBatch(Long groupId);

    /**
	 * 按电影分组List查询movie_id List
	 *
	 * @param example
	 * @return
	 */
	@DataSource("cluster")
	public List<Long> queryByGroupIdLists(List<Long> groupId);
}
