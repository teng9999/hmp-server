package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.PublishPkgs;
import cn.pl.hmp.server.dao.entity.PublishPkgsExample;

public interface IPublishPkgsBusiness extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int deleteById(Long id);

    /**
	 * 新增
	 * @param record
	 * @return
	 */
	long insert(PublishPkgs record);

    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<PublishPkgs>> selectByPages(PublishPkgsExample example,Pages page);

    /**
     * 更新
     * @param record
     * @return
     */
    int update(PublishPkgs record);

    PublishPkgs selectById(Long id);

    PublishPkgs selectByHotelIdWhichLastTime(Long hotelId);

}
