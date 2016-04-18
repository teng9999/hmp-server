package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.AppOpInfo;
import cn.pl.hmp.server.dao.entity.AppOpInfoExample;

public interface IAppOpInfoBusiness extends IBusiness {
    /**
     * 插入
     * @param info  对象实例
     * @param map   操作类型及状态集 key:操作路数，value :操作结果码（如果为空调温度等就为温度数，其他的为开关状态）
     * @return
     */
   int saveOnBatch(AppOpInfo info,Map<String,String> map);
   
   /**
    * 条件分页查询
    * @param example 查询条件实例
    * @param page   分页条件
    * @return  结果集Map  key为分页条件,value为结果集列表
    */
   Map<Pages, List<AppOpInfo>> selectByPages(AppOpInfoExample example,Pages page);
}
