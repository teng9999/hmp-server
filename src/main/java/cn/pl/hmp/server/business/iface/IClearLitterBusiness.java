package cn.pl.hmp.server.business.iface;

public interface IClearLitterBusiness {
    /**
     * 清理历史垃圾数据，可以不予管理
     * @param hotelId   酒店编号
     * @return  状态码 >0 成功
     * @throws Exception
     */
    long deleteAllDataExceptHotelId(Long hotelId) throws Exception;
}
