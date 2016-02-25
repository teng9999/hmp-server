package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.AppLoginInfo;

public interface IAppLoginInfoBusiness extends IBusiness {

    /**
	 * 新增
	 * @param record
	 * @return
	 */
	long insert(AppLoginInfo record);
	
	AppLoginInfo selectById(String id);

    /**
     * 新增
     * @param record
     * @return
     */
//    long insertSelective(AppLoginInfo record);

    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<AppLoginInfo>> selectByPages(Pages page,String name, String fixCondition);

    /**
     * 根据用户名查用户
     * @return
     */
//    List<AppLoginInfo> selectByExample(AppLoginInfoExample example);

    /**
     * 查询全部
     * @return
     */
//    List<User> selectAll();
    
    /**
     * 通过id删除
     * @param id
     * @return
     */
//	int deleteByPrimaryKey(Long id);
    
    /**
     * 更新
     * @param record
     * @return
     */
//    int update(User record);

    /**
     * 更新
     * @param record
     * @return
     */
//    int updateAll(AppLoginInfo record);

    /**
     * 批量删除
     * @param idList
     * @return
     */
//    int deleteOnBatch(List<Long> idList);


}
