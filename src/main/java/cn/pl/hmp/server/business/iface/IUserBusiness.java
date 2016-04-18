package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HotelInfo;
import cn.pl.hmp.server.dao.entity.User;
import cn.pl.hmp.server.dao.entity.UserExample;
/**
 * 用户
 * @author renjw
 *
 */
public interface IUserBusiness extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int deleteUserAndHotelByUserId(Long id);

    /**
	 * 新增
	 * @param record
	 * @return
	 */
	long insert(User record);

    /**
     * 新增
     * @param record
     * @return
     */
    long insertAll(User record,HotelInfo hotel);

    /**
     * 通过编号查询
     * @param id
     * @return
     */
    User selectByUserId(Long id);

    /**
     * 查询全部
     * @return
     */
    List<User> selectAll();

    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<User>> selectByPages(UserExample example,Pages page);

    /**
     * 更新
     * @param record
     * @return
     */
    int update(User record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateAll(User user,HotelInfo hotel);

    /**
     * 批量删除
     * @param idList
     * @return
     */
    int deleteOnBatch(List<Long> idList);

    /**
     * 根据用户名查用户
     * @return
     */
    List<User> selectByExample(UserExample example);
    /**
     * 根据酒店编号查用户
     * @return
     */
    User selectByHotelId(Long hotelId);

}
