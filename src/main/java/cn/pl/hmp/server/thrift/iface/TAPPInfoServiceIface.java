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
import cn.pl.commons.utils.StringUtils;
import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrift.define.TPages;
import cn.pl.frame.thrift.exception.ThriftException;
import cn.pl.hmp.commons.thrift.define.TAPPInfo;
import cn.pl.hmp.server.business.iface.IAPPInfoBusiness;
import cn.pl.hmp.server.dao.entity.APPInfo;
import cn.pl.hmp.server.dao.entity.APPInfoExample;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

/**
 * TAPPInfoServiceIface
 * 
 * @author zhoujianbiao
 *
 */
@Component
@ThriftService
public class TAPPInfoServiceIface implements cn.pl.hmp.commons.thrift.service.TAPPInfoService.Iface {
    @Autowired
    private IAPPInfoBusiness business;

    @Override
    public int deleteById(long id) throws TException {
        if (business == null) {
            return 0;
        }

        return business.remove(id);
    }

    @Override
    public int insert(TAPPInfo record) throws TException {
        if (business == null) {
            return 0;
        }
        APPInfo aPPInfo = ServerTransform.transform(record);
        if (aPPInfo == null) {
            aPPInfo = new APPInfo();
        }
        return business.create(aPPInfo);
    }

    @Override
    public TAPPInfo selectById(long id) throws TException {
        if (business == null) {
            return null;
        }
        APPInfo aPPInfo = business.get(id);
        if (aPPInfo == null) {
            aPPInfo = new APPInfo();
        }
        return ServerTransform.transform(aPPInfo);
    }

    @Override
    public int updateById(TAPPInfo record) throws TException {
        if (business == null) {
            return 0;
        }
        if (record == null) {
            return 0;
        }
        APPInfo aPPInfo = ServerTransform.transform(record);
        return business.update(aPPInfo);
    }

    @Override
    public List<TAPPInfo> loadAll() throws ThriftException, TException {
        if (business == null) {
            return null;
        }
        List<APPInfo> lists = business.query(null);
        return listTransform(lists);
    }

    private List<TAPPInfo> listTransform(List<APPInfo> lists) {
        List<TAPPInfo> resultLists = new ArrayList<TAPPInfo>();
        for (APPInfo aPPInfo : lists) {
            TAPPInfo result = ServerTransform.transform(aPPInfo);
            resultLists.add(result);
        }
        return resultLists;
    }

    @Override
    public Map<TPages, List<TAPPInfo>> loadPages(TPages tPages) throws ThriftException, TException {
        if (business == null)
            return null;
        // 转换Thrift分页对象为Pages
        Pages pages = ServerTransform.transform(tPages);
        if (pages == null)
            pages = new Pages();
        // 分页查询
        Map<Pages, List<APPInfo>> result = business.queryPages(null, pages);
        // 处理查询结果
        Map<TPages, List<TAPPInfo>> rtn = new HashMap<>();
        TPages rtnPages = null;
        List<TAPPInfo> rtnList = null;
        if (result == null || result.isEmpty()) {
            // 查询结果为空
            rtnPages = new TPages();
            rtnList = new ArrayList<>();
        } else {
            // 查询结果不为空
            for (Pages key : result.keySet()) {
                List<APPInfo> datas = result.get(key);
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

    @Override
    public Map<TPages, List<TAPPInfo>> loadPagesByNameCn(TPages tPages, String nameCn)
            throws ThriftException, TException {
        if (business == null)
            return null;
        // 转换Thrift分页对象为Pages
        Pages pages = ServerTransform.transform(tPages);
        if (pages == null)
            pages = new Pages();
        // 查询条件-根据app中文名称来查询
        APPInfoExample appInfoExample = null;
        if (!StringUtils.isBlank(nameCn)) {
            appInfoExample = new APPInfoExample();
            appInfoExample.createCriteria().andNameCnLike(nameCn);
        }
        // 分页查询
        Map<Pages, List<APPInfo>> result = business.queryPages(appInfoExample, pages);
        // 处理查询结果
        Map<TPages, List<TAPPInfo>> rtn = new HashMap<>();
        TPages rtnPages = null;
        List<TAPPInfo> rtnList = null;
        if (result == null || result.isEmpty()) {
            // 查询结果为空
            rtnPages = new TPages();
            rtnList = new ArrayList<>();
        } else {
            // 查询结果不为空
            for (Pages key : result.keySet()) {
                List<APPInfo> datas = result.get(key);
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
