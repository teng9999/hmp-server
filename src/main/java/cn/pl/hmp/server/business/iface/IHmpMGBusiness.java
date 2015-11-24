package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HmpMG;
import cn.pl.hmp.server.dao.entity.HmpMGExample;
import cn.pl.hmp.server.datasource.DataSource;

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
	 * 批量删除
	 * @param mgList
	 * @return
	 */
	@DataSource("cluster")
	public int saveOnBatch(List<HmpMG> mgList , int hotelId);
	
	/***
	 * 
	 */
	@DataSource("cluster")
	public int deleteOnBatch(List<Long> idList,int hotelId);
}
