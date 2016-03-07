package cn.pl.hmp.server.business.iface;

import java.util.Date;


public interface ISysLsOpLogBusiness extends IBoostBusiness{
    int[] saveTotalData(Date BeginTime);
}
