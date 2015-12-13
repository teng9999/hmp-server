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
import cn.pl.hmp.commons.thrift.define.TAirMode;
import cn.pl.hmp.server.business.iface.IAirModeBusiness;
import cn.pl.hmp.server.dao.entity.AirMode;
import cn.pl.hmp.server.dao.entity.AirModeExample;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

/**
 * rcu
 * 
 * @author zhoujianbiao
 *
 */
@Component
@ThriftService
public class TAirModeServiceIface implements cn.pl.hmp.commons.thrift.service.TAirModeService.Iface {
    @Autowired
    private IAirModeBusiness business;

    @Override
    public int deleteById(long id) throws TException {
        if (business == null) {
            return 0;
        }

        return business.remove(id);
    }

    @Override
    public int insert(TAirMode record) throws TException {
        if (business == null) {
            return 0;
        }
        AirMode airMode = ServerTransform.transform(record);
        if (airMode == null) {
            airMode = new AirMode();
        }
        return business.create(airMode);
    }

    @Override
    public TAirMode selectById(long id) throws TException {
        if (business == null) {
            return null;
        }
        AirMode airMode = business.get(id);
        if (airMode == null) {
            airMode = new AirMode();
        }
        return ServerTransform.transform(airMode);
    }

    @Override
    public int updateById(TAirMode record) throws TException {
        if (business == null) {
            return 0;
        }
        if (record == null) {
            return 0;
        }
        AirMode airMode = ServerTransform.transform(record);
        return business.update(airMode);
    }

    @Override
    public List<TAirMode> loadAll() throws ThriftException, TException {
        if (business == null) {
            return null;
        }
        List<AirMode> lists = business.query(null);
        return listTransform(lists);
    }

    private List<TAirMode> listTransform(List<AirMode> lists) {
        List<TAirMode> resultLists = new ArrayList<TAirMode>();
        if (lists != null && lists.size() > 0) {
            for (AirMode airMode : lists) {
                TAirMode result = ServerTransform.transform(airMode);
                resultLists.add(result);
            }
        }
        return resultLists;
    }

    @Override
    public Map<TPages, List<TAirMode>> loadPages(TPages tPages) throws ThriftException, TException {
        if (business == null)
            return null;
        // 转换Thrift分页对象为Pages
        Pages pages = ServerTransform.transform(tPages);
        if (pages == null)
            pages = new Pages();
        // 分页查询
        Map<Pages, List<AirMode>> result = business.queryPages(null, pages);
        // 处理查询结果
        Map<TPages, List<TAirMode>> rtn = new HashMap<>();
        TPages rtnPages = null;
        List<TAirMode> rtnList = null;
        if (result == null || result.isEmpty()) {
            // 查询结果为空
            rtnPages = new TPages();
            rtnList = new ArrayList<>();
        } else {
            // 查询结果不为空
            for (Pages key : result.keySet()) {
                List<AirMode> datas = result.get(key);
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
    public List<TAirMode> queryByHotelId(long hotelId) throws ThriftException, TException {
        AirModeExample airModeExample = new AirModeExample();
        airModeExample.createCriteria().andHotelIdEqualTo(hotelId);
        List<AirMode> airModes = business.query(airModeExample);
        return listTransform(airModes);
    }

}
