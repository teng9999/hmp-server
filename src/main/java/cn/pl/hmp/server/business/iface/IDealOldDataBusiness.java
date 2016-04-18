package cn.pl.hmp.server.business.iface;

import cn.pl.hmp.server.business.IBusiness;
/**
 * 清理脏数据，可以不予考虑
 * @author 
 *
 */
public interface IDealOldDataBusiness extends IBusiness  {
    int dealOldRoomType();
    
    int dealMenuChannelLitter();
}
