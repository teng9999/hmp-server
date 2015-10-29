/*
 * ExampleBusinessImpl.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.business.impl;

import cn.pl.hmp.server.business.AbstractBusiness;
import cn.pl.hmp.server.business.iface.IExampleBusiness;
import cn.pl.hmp.server.dao.entity.HmpTest;
import cn.pl.hmp.server.dao.entity.HmpTestExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 示例业务逻辑
 *
 * @author alanyuan
 */
@Service
public class ExampleBusinessImpl extends AbstractBusiness implements IExampleBusiness {
    
    /*
     * (non-Javadoc)
     * @see
     * cn.pl.hmp.server.business.AbstractBusiness#query(cn.pl.hmp.server.entity
     * .DxsTestExample)
     */
    @Override
    public List<HmpTest> query(HmpTestExample example) {
        if (example == null)
            example = new HmpTestExample();
        return hmpTestMapper.selectByExample(example);
    }
    
    /*
     * (non-Javadoc)
     * @see cn.pl.hmp.server.business.AbstractBusiness#get(java.lang.Integer)
     */
    @Override
    public HmpTest get(Integer id) {
        if (id == null)
            return null;
        return hmpTestMapper.selectByPrimaryKey(id);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * cn.pl.hmp.server.business.AbstractBusiness#create(cn.pl.hmp.server.entity
     * .DxsTest)
     */
    @Override
    public int create(HmpTest record) {
        if (record == null || record.getId() != null)
            return 0;
        return hmpTestMapper.insertSelective(record);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * cn.pl.hmp.server.business.AbstractBusiness#update(cn.pl.hmp.server.entity
     * .DxsTest)
     */
    @Override
    public int update(HmpTest record) {
        if (record == null || record.getId() == null || StringUtils.isBlank(record.getName()))
            return 0;
        return hmpTestMapper.updateByPrimaryKeySelective(record);
    }
    
    /*
     * (non-Javadoc)
     * @see cn.pl.hmp.server.business.AbstractBusiness#remove(java.lang.Integer)
     */
    @Override
    public int remove(Integer id) {
        if (id == null)
            return 0;
        return hmpTestMapper.deleteByPrimaryKey(id);
    }
    
}
