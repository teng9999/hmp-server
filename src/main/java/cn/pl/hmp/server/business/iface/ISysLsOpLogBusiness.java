package cn.pl.hmp.server.business.iface;



public interface ISysLsOpLogBusiness extends IBoostBusiness{
    /**
     * 
     * @param lastDay 多少天
     * @return
     */
    int[] saveTotalData(int lastDay);
}
