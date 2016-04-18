package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.PublishPkgs;
import cn.pl.hmp.server.dao.entity.PublishPkgsExample;
/**
 * 酒店发布包
 */
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
    
    /**
     * 根据编号查询
     * @param id    发布包编号
     * @return
     */
    PublishPkgs selectById(Long id);
    
    /**
     * 根据酒店编号查询最新的发布包
     * @param hotelId   酒店编号
     * @return
     */
    PublishPkgs selectByHotelIdWhichLastTime(Long hotelId);

}
