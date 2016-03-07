package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.CheckInDetail;

public interface ICheckInDetailBusiness extends IBusiness{
    /**
     *  条件分页查询
     * @param page
     * @param roomType
     * @param lastDay
     * @param plugInterval
     * @return
     */
    Map<Pages, List<CheckInDetail>> selectByPages(Pages page,int opStatus,String nowDate,long roomId);
}
