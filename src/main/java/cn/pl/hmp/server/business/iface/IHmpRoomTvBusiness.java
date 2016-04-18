package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HmpRoomTv;
import cn.pl.hmp.server.dao.entity.HmpRoomTvExample;

public interface IHmpRoomTvBusiness extends IBusiness {

    /**
    * 删除
    * @param id    对象编号
    * @return 删除数据影响行数
    */
	int deleteByHmpRoomTvId(Long id);

    /**
     * 新增
     * @param record   对象实例
     * @return 插入数据编号
     */
	long insert(HmpRoomTv record);

	/**
     * 条件分页查询
     * @param example 查询条件实例
     * @return  结果集列表
     */
    List<HmpRoomTv> selectByExample(HmpRoomTvExample example);

    /**
     * 通过酒店编号查询
     * @param hotelId   酒店编号
     * @return  房间电视对象
     */
    HmpRoomTv selectByHotelId(Long hotelId);

    /**
     * 查询全部
     * @return  全部结果集合
     */
    List<HmpRoomTv> selectAll();

    /**
     * 条件分页查询
     * @param example 查询条件实例
     * @param page   分页条件
     * @return  结果集Map  key为分页条件,value为结果集列表
     */
    Map<Pages, List<HmpRoomTv>> selectByPages(HmpRoomTvExample example,Pages page);


    /**
    * 更新
    * @param record   对象实例
    * @return 更新数据影响行数
    */
    int update(HmpRoomTv record);

    /**
     * 通过酒店编号获取要发布数据json包
     * @param hotelId   酒店编号
     * @return  房间电视json包
     */
    JSONObject publish(Long hotelId);
}
