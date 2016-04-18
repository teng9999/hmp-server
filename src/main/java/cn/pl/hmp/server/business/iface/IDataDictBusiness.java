package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.DataDict;
import cn.pl.hmp.server.dao.entity.DataDictExample;

public interface IDataDictBusiness extends IBusiness {

    /**
    * 删除
    * @param id    对象编号
    * @return 删除数据影响行数
    */
	int deleteByDataDictId(Long id);

    /**
     * 新增
     * @param record   对象实例
     * @return 插入数据影响行数
     */
    int insert(DataDict record);


    /**
     * 通过编号查询
     * @param id   对象编号
     * @return     结果对象
     */
    DataDict selectByDataDictId(Long id);

    /**
     * 查询全部
     * @return  全部字典数据结果集
     */
    List<DataDict> selectAll();

    /**
     * 条件查询
     * @return  字典数据结果集
     */
    List<DataDict> selectByCase(DataDictExample example);

    /**
     * 条件分页查询
     * @param example 查询条件实例
     * @param page   分页条件
     * @return  结果集Map  key为分页条件,value为结果集列表
     */

    Map<Pages, List<DataDict>> selectByPages(DataDictExample example,Pages page);


    /**
    * 更新
    * @param record   对象实例
    * @return 更新数据影响行数
    */
    int update(DataDict record);

    /**
     * 批量删除
     * @param idList    要删除编号列表
     * @return  状态码     删除成功个数
     */
    int deleteOnBatch(List<Long> idList);
    
    /**
     * 通过父级唯一名查询所有字典项
     * @param parentName    父级名称 
     * @return  某个父级下的所有子级项
     */
    List<DataDict> selectByParentName(String parentName);
}
