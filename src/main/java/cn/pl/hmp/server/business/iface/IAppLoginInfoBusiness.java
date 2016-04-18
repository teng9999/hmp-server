package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.AppLoginInfo;

public interface IAppLoginInfoBusiness extends IBusiness {

    /**
	 * 新增
	 * @param record   对象实例
	 * @return 插入数据影响行数
	 */
	long insert(AppLoginInfo record);
	
	/**
	 * 
	 * @param id   对象编号
	 * @return     结果对象
	 */
	AppLoginInfo selectById(String id);


    /**
     * 条件分页查询
     * @param name  用户名
     * @param fixCondition  前端混合搜索条件
     * @param page   分页条件
     * @return  结果集Map  key为分页条件,value为结果集列表
     */
    Map<Pages, List<AppLoginInfo>> selectByPages(Pages page,String name, String fixCondition);
}
