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
     * @param id    对象编号
     * @return      删除数据影响行数
     */
	int delete(Long id);

	/**
     * 新增
     * @param record   对象实例
     * @return 插入数据影响行数
     */
	long insert(AppUser record);


	/**
     * 通过编号查询
     * @param id   对象编号
     * @return     结果对象
     */
    AppUser selectById(Long id);
    
    /**
     * 根据证件号和用户名查用户
     * @param credNum   证件号
     * @param name      用户名
     * @return          结果对象
     */
    AppUser selectByUserName(String credNum,String name);
    
    /**
     * 更新
     * @param id   对象编号
     * @return     结果对象
     */
    int update(AppUser record);

    /**
     * 查询全部
     * @return      全部的用户列表
     */
    List<AppUser> selectAll();

    /**
     * 条件分页查询
     * @param example 查询条件实例
     * @param page   分页条件
     * @return  结果集Map  key为分页条件,value为结果集列表
     */

    Map<Pages, List<AppUser>> selectByPages(AppUserExample example,Pages page);
    
    /**
     * 根据证件类型、注册类型、以及模糊查询条件查询
     * @param page          分页信息
     * @param credType      证件类型
     * @param registration  注册类型
     * @param fixCondition  模糊查询条件
     * @return  结果集Map  key为分页条件,value为结果集列表
     */
    Map<Pages, List<AppUser>> selectByCondition(Pages page,String credType, 
            String registration, String fixCondition);
    /**
     * 重置密码
     * @param password  密码
     * @param credType  证件类型
     * @param credNum   证件号
     * @return  结果码 >0 成功
     */
    int resetPasswordByCred(String password,int credType,String credNum,String name);
    /**
     * 获取登陆用户的入住信息
     * @param credType  证件类型
     * @param credNum   证件号
     * @param name      用户名
     * @return  app登陆成功结果数据集  
     */
    AppResidenceInfo queryResidenceInfo(int credType,String credNum,String name);

}
