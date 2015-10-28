/*
 * IExampleBusiness.java Copyright Bejing Passion Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.business.iface;

import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.HmpTest;
import cn.pl.hmp.server.dao.entity.HmpTestExample;
import cn.pl.hmp.server.datasource.DataSource;

import java.util.List;

/**
 * 示例业务逻辑（也可用Service命名）
 *
 * @author alanyuan
 */
public interface IExampleBusiness extends IBusiness {
    /**
     * 按条件查询
     *
     * @param example
     * @return
     */
	@DataSource("cluster")
    public List<HmpTest> query(HmpTestExample example);
    
    /**
     * 获取
     *
     * @param id
     * @return
     */
	@DataSource("cluster")
    public HmpTest get(Integer id);
    
    /**
     * 创建
     *
     * @param record
     * @return
     */
    public int create(HmpTest record);
    
    /**
     * 更新
     *
     * @param record
     * @return
     */
    public int update(HmpTest record);
    
    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int remove(Integer id);
}
