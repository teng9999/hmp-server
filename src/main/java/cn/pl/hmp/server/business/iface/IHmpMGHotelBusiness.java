package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HmpMGHotel;
import cn.pl.hmp.server.dao.entity.HmpMGHotelExample;
import cn.pl.hmp.server.datasource.DataSource;

public interface IHmpMGHotelBusiness extends IBusiness {
	/**
	 * 按条件查询
	 *
	 * @param example
	 * @return
	 */
	@DataSource("cluster")
	public List<HmpMGHotel> query(HmpMGHotelExample example);

	/**
	 * 按条件分页查询
	 *
	 * @param example
	 * @param pages
	 * @return
	 */
	@DataSource("cluster")
	public Map<Pages, List<HmpMGHotel>> queryPages(HmpMGHotelExample example,Pages pages);

	/**
	 * 获取
	 *
	 * @param id
	 * @return
	 */
	@DataSource("cluster")
	public HmpMGHotel get(Long id);

	/**
	 * 创建
	 *
	 * @param record
	 * @return
	 */
	@DataSource("cluster")
	public int create(HmpMGHotel record);

	/**
	 * 更新
	 *
	 * @param record
	 * @return
	 */
	@DataSource("cluster")
	public int update(HmpMGHotel record);

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
	public List<Long> queryByHotelId(Long hotelId);

	/***
	 * 批量删除
	 * @param mgList
	 * @return
	 */
	@DataSource("cluster")
	public int saveOnBatch(List<HmpMGHotel> mgList);

	/***
	 * 
	 */
	@DataSource("cluster")
	public int deleteOnBatch(List<Long> idList,Long hotelId);

	/***
	 * 
	 */
	@DataSource("cluster")
	public int deleteByHotelIdOnBatch(Long hotelId);
}
