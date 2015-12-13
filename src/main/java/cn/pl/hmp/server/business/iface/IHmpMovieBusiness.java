package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HmpMovie;
import cn.pl.hmp.server.dao.entity.HmpMovieExample;
import cn.pl.hmp.server.datasource.DataSource;

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
}
