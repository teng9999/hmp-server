package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.PmsCheckInInfo;
import cn.pl.hmp.server.dao.entity.PmsCheckInInfoCondition;

public interface IPmsCheckInInfoBusiness extends IBusiness {
    /**
	 * 通过id删除
	 * 
	 * @param id
	 * @return
	 */
	int delete(Long id);

    /**
	 * 新增
	 * 
	 * @param record
	 * @return
	 */
	long insert(PmsCheckInInfo record);

    /**
	 * 通过编号查询
	 * 
	 * @param id
	 * @return
	 */
	PmsCheckInInfo selectById(Long id);
    /**
	 * 条件分页查询
	 * 
	 * @param example
	 * @param page
	 * @return
	 */
	Map<Pages, List<PmsCheckInInfo>> selectByPages(PmsCheckInInfoCondition condition,Pages page);
    /**
	 * 更新
	 * 
	 * @param record
	 * @return
	 */
	int update(PmsCheckInInfo record);
}
