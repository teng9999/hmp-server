/*
 * TExampleServiceIface.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.thrift.iface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.pl.commons.pages.Pages;
import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrift.define.TPages;
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

    /*
     * (non-Javadoc)
     * 
     * @see cn.pl.hmp.commons.thrift.service.TExampleService.Iface#get(int)
     */
    @Override
    public TExample get(int id) throws ThriftException, TException {
        if (business == null)
            return null;
        return ServerTransform.transform(business.get(id));
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.pl.hmp.commons.thrift.service.TExampleService.Iface#loadAll()
     */
    @Override
    public List<TExample> loadAll() throws ThriftException, TException {
        if (business == null)
            return null;
        return transformExample(business.query(null));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.pl.hmp.commons.thrift.service.TExampleService.Iface#loadPages(cn.pl
     * .frame.thrift.define.TPages)
     */
    @Override
    public Map<TPages, List<TExample>> loadPages(TPages tPages) throws ThriftException, TException {
        if (business == null)
            return null;
        // 转换Thrift分页对象为Pages
        Pages pages = ServerTransform.transform(tPages);
        if (pages == null)
            pages = new Pages();
        // 分页查询
        Map<Pages, List<HmpTest>> result = business.queryPages(null, pages);
        // 处理查询结果
        Map<TPages, List<TExample>> rtn = new HashMap<>();
        TPages rtnPages = null;
        List<TExample> rtnList = null;
        if (result == null || result.isEmpty()) {
            // 查询结果为空
            rtnPages = new TPages();
            rtnList = new ArrayList<>();
        } else {
            // 查询结果不为空
            for (Pages key : result.keySet()) {
                List<HmpTest> datas = result.get(key);
                if (datas == null || datas.isEmpty()) {
                    // 查询结果包含的实际数据为空
                    rtnPages = new TPages();
                    rtnList = new ArrayList<>();
                } else {
                    // 转换查询结果和分页对象
                    rtnPages = ServerTransform.transform(key);
                    rtnList = transformExample(datas);
                }
                break;
            }
        }
        rtn.put(rtnPages, rtnList);

        return rtn;
    }

    private List<TExample> transformExample(List<HmpTest> list) {
        List<TExample> result = new ArrayList<>();

        if (list != null && !list.isEmpty()) {
            for (HmpTest from : list) {
                TExample to = ServerTransform.transform(from);
                if (to != null)
                    result.add(to);
            }
        }

        return result;
    }

}
