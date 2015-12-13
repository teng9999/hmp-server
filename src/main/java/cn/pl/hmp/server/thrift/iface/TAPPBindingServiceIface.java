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
import org.springframework.stereotype.Component;

import cn.pl.commons.pages.Pages;
import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrift.define.TPages;
import cn.pl.frame.thrift.exception.ThriftException;
import cn.pl.hmp.commons.thrift.define.TAPPBinding;
import cn.pl.hmp.server.business.iface.IAPPBindingBusiness;
import cn.pl.hmp.server.dao.entity.APPBinding;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

/**
 * TAPPBindingServiceIface
 * 
 * @author zhoujianbiao
 *
 */
@Component
@ThriftService
public class TAPPBindingServiceIface implements cn.pl.hmp.commons.thrift.service.TAPPBindingService.Iface {
    @Autowired
    private IAPPBindingBusiness business;

    @Override
    public int deleteById(long id) throws TException {
        if (business == null) {
            return 0;
        }

        return business.remove(id);
    }

    @Override
    public int insert(TAPPBinding record) throws TException {
        if (business == null) {
            return 0;
        }
        APPBinding aPPInfo = ServerTransform.transform(record);
        if (aPPInfo == null) {
            aPPInfo = new APPBinding();
        }
        return business.create(aPPInfo);
    }

    @Override
    public TAPPBinding selectById(long id) throws TException {
        if (business == null) {
            return null;
        }
        APPBinding aPPInfo = business.get(id);
        if (aPPInfo == null) {
            aPPInfo = new APPBinding();
        }
        return ServerTransform.transform(aPPInfo);
    }

    @Override
    public int updateById(TAPPBinding record) throws TException {
        if (business == null) {
            return 0;
        }
        if (record == null) {
            return 0;
        }
        APPBinding aPPInfo = ServerTransform.transform(record);
        return business.update(aPPInfo);
    }

    @Override
    public List<TAPPBinding> loadAll() throws ThriftException, TException {
        if (business == null) {
            return null;
        }
        List<APPBinding> lists = business.query(null);
        return listTransform(lists);
    }

    private List<TAPPBinding> listTransform(List<APPBinding> lists) {
        List<TAPPBinding> resultLists = new ArrayList<TAPPBinding>();
        for (APPBinding aPPInfo : lists) {
            TAPPBinding result = ServerTransform.transform(aPPInfo);
            resultLists.add(result);
        }
        return resultLists;
    }

    @Override
    public Map<TPages, List<TAPPBinding>> loadPages(TPages tPages) throws ThriftException, TException {
        if (business == null)
            return null;
        // 转换Thrift分页对象为Pages
        Pages pages = ServerTransform.transform(tPages);
        if (pages == null)
            pages = new Pages();
        // 分页查询
        Map<Pages, List<APPBinding>> result = business.queryPages(null, pages);
        // 处理查询结果
        Map<TPages, List<TAPPBinding>> rtn = new HashMap<>();
        TPages rtnPages = null;
        List<TAPPBinding> rtnList = null;
        if (result == null || result.isEmpty()) {
            // 查询结果为空
            rtnPages = new TPages();
            rtnList = new ArrayList<>();
        } else {
            // 查询结果不为空
            for (Pages key : result.keySet()) {
                List<APPBinding> datas = result.get(key);
                if (datas == null || datas.isEmpty()) {
                    // 查询结果包含的实际数据为空
                    rtnPages = new TPages();
                    rtnList = new ArrayList<>();
                } else {
                    // 转换查询结果和分页对象
                    rtnPages = ServerTransform.transform(key);
                    rtnList = listTransform(datas);
                }
                break;
            }
        }
        rtn.put(rtnPages, rtnList);

        return rtn;
    }

}
