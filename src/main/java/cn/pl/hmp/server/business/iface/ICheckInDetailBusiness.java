package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.CheckInDetail;

public interface ICheckInDetailBusiness extends IBusiness{
    /**
     * 条件分页查询
     * @param page      分页条件
     * @param opStatus  操作状态 0：拔卡 1:插卡
     * @param nowDate   当前时间 yyyy-MM-dd状态字符串
     * @param roomId    房间编号
     * @return  结果集Map  key为分页条件,value为结果集列表
     */
    Map<Pages, List<CheckInDetail>> selectByPages(Pages page,int opStatus,String nowDate,long roomId);
}
