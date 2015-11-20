package cn.pl.hmp.server.business.iface;

import java.util.List;

import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.UserHotel;

public interface IUserHotelBusiness   extends IBusiness {
	int deleteById(Long id);

    int insert(UserHotel record);

    List<UserHotel> selectByUserId(Long id);
    
    List<UserHotel> selectByHotelId(Long id);
    
    int update(UserHotel record);
}
