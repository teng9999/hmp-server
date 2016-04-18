package cn.pl.hmp.server.business.iface;


/**
 * 板子操作日志信息表
 * @author renjw
 *
 */
public interface ISysLsOpLogBusiness extends IBoostBusiness{
    /**
     * 主要是为了每天晚上跑批数据
     * @param lastDay 多少天
     * @return
     */
    int[] saveTotalData(int lastDay);
}
