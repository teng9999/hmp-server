package cn.pl.hmp.server.business.iface;

public interface IClearLitterBusiness {
    long deleteAllDataExceptHotelId(Long hotelId) throws Exception;
}
