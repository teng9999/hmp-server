package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HmpHotelToolPacks;
import cn.pl.hmp.server.dao.entity.HmpHotelToolPacksExample;

public interface IHmpHotelToolPacksBusiness extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int delete(Long id);

    /**
	 * 新增
	 * @param record
	 * @return
	 */
	long insert(HmpHotelToolPacks record);

    /**
     * 查询全部
     * @param content
     * @return
     */
    List<HmpHotelToolPacks> selectByExample(HmpHotelToolPacksExample example);

    /**
     * 通过id查询
     * @return
     */
    HmpHotelToolPacks selectById(Long id);

    /**
     * 查询全部
     * @return
     */
    List<HmpHotelToolPacks> selectAll();

    /**
     * 列表查询
     * @return
     */
    List<HmpHotelToolPacks> queryList();

    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<HmpHotelToolPacks>> selectByPages(HmpHotelToolPacksExample example,Pages page);

    /**
     * 更新
     * @param record
     * @return
     */
    int update(HmpHotelToolPacks record);
}
