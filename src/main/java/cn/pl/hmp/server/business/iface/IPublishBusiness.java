package cn.pl.hmp.server.business.iface;

import cn.pl.hmp.server.business.IBusiness;

public interface IPublishBusiness  extends IBusiness {
    String publish(Long hotelId);
}
