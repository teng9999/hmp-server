package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HotelInfo;
import cn.pl.hmp.server.dao.entity.HotelInfoExample;
import cn.pl.hmp.server.dao.entity.User;

import com.alibaba.fastjson.JSONObject;

public interface IHotelInfoBusiness extends IBusiness {
    /**
     * 通过酒店编号删除改酒店的酒店信息（包括账号等）
     * @param id    酒店编号
     * @return 状态码 
     */ 
	int deleteHotelAndUserByHotelId(Long id);

    /**
     * 新增
     * @param record   对象实例
     * @return 插入数据影响行数
     */
	long insert(HotelInfo record);

	/**
     * 通过编号查询
     * @param id   对象编号
     * @return     结果对象
     */
    HotelInfo selectByHotelId(Long id);

    /**
     * 查询全部
     * @return
     */
    List<HotelInfo> selectAll();

    /**
     * 条件分页查询
     * @param example 查询条件实例
     * @param page   分页条件
     * @return  结果集Map  key为分页条件,value为结果集列表
     */
    Map<Pages, List<HotelInfo>> selectByPages(HotelInfoExample example,Pages page);

    /**
     * 修改酒店信息
     * @param record   对象实例
     * @return 修改数据影响行数
     */
    int update(HotelInfo record);

    /**
     * 通过用户编号查询酒店信息
     * @param userId    用户编号
     * @return  该用户对应酒店列表
     */ 
    List<HotelInfo> selectByUserId(Long userId);

    /**
     * 发布功能获取酒店信息
     * @param hotelId
     * @return
     */
    public JSONObject publish(Long hotelId);
    
    /**
     * 包含用户名、省份、密码等的多条件查询
     * @param page      分页信息
     * @param province  省份
     * @param name      用户名
     * @param condition 模糊查询条件
     * @return  结果集Map  key为分页条件,value为结果集列表
     */
    Map<Pages, List<HotelInfo>> selectByPagesWithUser(Pages page,String province,
            String name,String condition);
    
    /**
     * 通过酒店编号查询酒店信息（包括用户部分信息）
     * @param hotelId   酒店编号
     * @return 酒店信息（包括用户部分信息）
     */
    HotelInfo selectListWithUserByHotelId(Long hotelId);
    
    /**
     * 保存用户和酒店信息
     * @param hotelInfo 酒店数据
     * @param user      用户信息数据
     * @return  状态码
     */
    long saveAll(HotelInfo hotelInfo,User user);
}
