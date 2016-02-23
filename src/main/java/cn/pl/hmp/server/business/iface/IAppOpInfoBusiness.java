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
     * @param info
     * @param list
     * @return
     */
   int saveOnBatch(AppOpInfo info,Map<String,String> map);
   
   /**
    * 条件分页查询
    * @param example
    * @param page
    * @return
    */
   Map<Pages, List<AppOpInfo>> selectByPages(AppOpInfoExample example,Pages page);
}
