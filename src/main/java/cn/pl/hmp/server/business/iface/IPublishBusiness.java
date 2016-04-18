package cn.pl.hmp.server.business.iface;

import cn.pl.hmp.server.business.IBusiness;

public interface IPublishBusiness extends IBusiness {
    /**
     * 根据酒店编号打包该店的发布信息
     * @param hotelId   酒店编号
     * @return
     */
    String publish(Long hotelId);
}
