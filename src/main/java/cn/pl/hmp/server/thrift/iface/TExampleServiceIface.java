/*
 * TExampleServiceIface.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.thrift.iface;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrift.exception.ThriftException;
import cn.pl.hmp.commons.thrift.define.TExample;
import cn.pl.hmp.commons.thrift.service.TExampleService.Iface;
import cn.pl.hmp.server.business.iface.IExampleBusiness;
import cn.pl.hmp.server.dao.entity.HmpTest;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

/**
 * 示例Thrift服务端接口实现
 * 
 * @author alanyuan
 *
 */
@Component
@ThriftService
public class TExampleServiceIface implements Iface {
    @Autowired
    @Qualifier("exampleBusinessImpl")
    private IExampleBusiness business;

    /* (non-Javadoc)
     * @see cn.pl.hmp.commons.thrift.service.TExampleService.Iface#get(int)
     */
    @Override
    public TExample get(int id) throws ThriftException, TException {
        if(business == null)
            return null;
        return ServerTransform.transform(business.get(id));
    }

    /* (non-Javadoc)
     * @see cn.pl.hmp.commons.thrift.service.TExampleService.Iface#loadAll()
     */
    @Override
    public List<TExample> loadAll() throws ThriftException, TException {
        if(business == null)
            return null;
        return transformExample(business.query(null));
    }
    
    private List<TExample> transformExample(List<HmpTest> list){
        List<TExample> result = new ArrayList<>();
        
        if(list != null && !list.isEmpty()){
            for(HmpTest from:list){
                TExample to = ServerTransform.transform(from);
                if(to != null)
                    result.add(to);
            }
        }
        
        return result;
    }

}
