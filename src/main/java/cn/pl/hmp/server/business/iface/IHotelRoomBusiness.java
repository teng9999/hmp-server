package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HotelRoom;
import cn.pl.hmp.server.dao.entity.HotelRoomExample;

import com.alibaba.fastjson.JSONArray;

public interface IHotelRoomBusiness extends IBusiness {
    /**
	 * 通过房间编号删除
	 * @param id   房间编号
	 * @return 状态码
	 */
	int deleteByHotelRoomId(Long id);

    /**
	 * 新增  
	 * @param record   房间信息对象
	 * @return 新增房间编号
	 */
	long insert(HotelRoom record);

    /**
	 * 通过编号查询
	 * @param id   房间编号
	 * @return 房间信息
	 */
	HotelRoom selectByHotelRoomId(Long id);

    /**
	 * 查询全部
	 * @return 房间信息结果集
	 */
	List<HotelRoom> selectAll();

    /**
     * 条件查询
     * @param example   查询条件
     * @return  房间信息结果集
     */
	List<HotelRoom> selectByExample(HotelRoomExample example);

    /**
     * 通过酒店编号分页条件查询
     * @param hotelId   酒店编号
     * @param page      分页条件
     * @return  结果集Map  key为分页条件,value为结果集列表
     */
	Map<Pages, List<HotelRoom>> selectByPages(Long hotelId,
			Pages page);

    /**
	 * 更新
	 * @param record   房间信息
	 * @return 状态码
	 */
	int update(HotelRoom record);

    /**
	 * 根据编号列表批量删除
	 * @param idList   房间编号列表
	 * @return 状态码
	 */
	int deleteOnBatch(List<Long> idList);

    /**
	 * 批量添加
	 * @param idList
	 * @return
	 */
	int saveOnBatch(HotelRoom record, String rcutemplateStr,String roomNums);

    /**
	 * @param hotelId
	 * @Title: updateAndRcu
	 * @Description: 更新房间和rcu模板配置
	 * @param @param convet
	 * @param @param rcutemplateStr
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	long updateAndRcu(HotelRoom convet, String templateCfg, long hotelId);

    /**
	 * 通过酒店编号获取酒店房间发布包
	 * @param hotelId      酒店编号
	 * @return 房间信息发布包
	 */
    JSONArray publish(Long hotelId);
    
    /**
     * 插入房间信息 如果该房间号存在对信息进行更新
     * @param room  房间信息
     * @return  房间编号
     */
    Long insertRoomAndType(HotelRoom room);
    /**
     * 批量修改房间的rcu时间
     * @param record    修改模板
     * @param roomNums  要修改的房间号集合
     * @return  状态码
     */
    int updateRcuTimeOnBatch(HotelRoom record, String roomNums);
}
