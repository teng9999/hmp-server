package cn.pl.hmp.server.business.iface;

import java.util.List;

import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.UserHotel;
/**
 * 酒店用户中间表
 * @author renjw
 *
 */
public interface IUserHotelBusiness extends IBusiness {
    /**
     * 根据编号删除
     * @param id    编号
     * @return
     */
    int deleteById(Long id);
    
    /**
     * 插入一条数据
     * @param record
     * @return
     */
    int insert(UserHotel record);
    
    /**
     * 根据用户编号查询
     * @param id    用户编号
     * @return
     */
    List<UserHotel> selectByUserId(Long id);
    /**
     * 根据酒店编号查询
     * @param id    酒店编号
     * @return
     */
    List<UserHotel> selectByHotelId(Long id);

    /**
     * 更新数据
     * @param record
     * @return
     */
    int update(UserHotel record);
}
