/*
 * AbstractBusiness.java Copyright Bejing Passion Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.business;

import cn.pl.hmp.server.dao.mapper.HmpTestMapper;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 业务逻辑层
 * 
 * @author alanyuan
 */
public abstract class AbstractBusiness implements IBusiness {
    @Autowired
    protected HmpTestMapper hmpTestMapper;
    
}
