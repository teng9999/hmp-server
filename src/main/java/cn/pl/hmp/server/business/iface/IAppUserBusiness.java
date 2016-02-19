package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.AppResidenceInfo;
import cn.pl.hmp.server.dao.entity.AppUser;
import cn.pl.hmp.server.dao.entity.AppUserExample;

public interface IAppUserBusiness extends IBusiness {
    /**
     * 通过id删除
     * @param id
     * @return
     */
	int delete(Long id);

    /**
	 * 新增
	 * @param record
	 * @return
	 */
	long insert(AppUser record);

    /**
     * 通过编号查询
     * @param id
     * @return
     */
    AppUser selectById(Long id);
    
    /**
     * 根据证件号查用户
     * @return
     */
    AppUser selectByUserName(String credNum,String name);
    
    /**
     * 更新
     * @param record
     * @return
     */
    int update(AppUser record);

    /**
     * 查询全部
     * @return
     */
    List<AppUser> selectAll();

    /**
     * 条件分页查询
     * @param example
     * @param page
     * @return
     */
    Map<Pages, List<AppUser>> selectByPages(AppUserExample example,Pages page);
    /**
     * 重置密码
     * @param password
     * @param credType
     * @param credNum
     * @return
     */
    int resetPasswordByCred(String password,int credType,String credNum,String name);
    /**
     * 获取登陆用户的入住信息
     * @param credType
     * @param credNum
     * @param name
     * @return
     */
    AppResidenceInfo queryResidenceInfo(int credType,String credNum,String name);

}
