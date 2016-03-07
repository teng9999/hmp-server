package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.datasource.DataSource;
import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HmpMovie;
import cn.pl.hmp.server.dao.entity.HmpMovieExample;

import com.alibaba.fastjson.JSONArray;

/**
 * 电影资源
 * 
 * @author devpltc
 *
 */
public interface IHmpMovieBusiness extends IBusiness {

    /**
	 * 按条件查询
	 *
	 * @param example
	 * @return
	 */
	@DataSource("cluster")
	public List<HmpMovie> query(HmpMovieExample example);

    /**
	 * 按条件查询
	 *
	 * @param example
	 * @param pages
	 * @return
	 */
	@DataSource("cluster")
	public Map<Pages, List<HmpMovie>> queryPages(HmpMovieExample example,Pages pages);

    /**
	 * 获取
	 *
	 * @param id
	 * @return
	 */
	@DataSource("cluster")
	public HmpMovie get(Long id);

    /**
	 * 创建
	 *
	 * @param record
	 * @return
	 */
	@DataSource("cluster")
	public int insert(HmpMovie record);

    /**
	 * 更新
	 *
	 * @param record
	 * @return
	 */
	@DataSource("cluster")
	public int update(HmpMovie record);

    /**
	 * 删除
	 *
	 * @param id
	 * @return
	 */
	@DataSource("cluster")
	public int remove(Long id);

    /***
	 * 
	 * @param movieIds
	 * @return
	 */
	@DataSource("cluster")
	public List<HmpMovie> queryByIds(List<Long> movieIds);

    /**
	 * 获取
	 *
	 * @param id
	 * @return
	 */
	@DataSource("cluster")
	public List<HmpMovie> queryByHotel(Long hotelId);
	
	/**
	 * 发布电影信息
	 * @param HotelId
	 * @return
	 */
	public JSONArray publish(Long hotelId);
	/**
	 * 分页查询某酒店的电影信息
	 * @param pages
	 * @param hotelId
	 * @return
	 */
	Map<Pages, List<HmpMovie>> selectPagesByHotel(Pages pages,Long hotelId,String name);
}
