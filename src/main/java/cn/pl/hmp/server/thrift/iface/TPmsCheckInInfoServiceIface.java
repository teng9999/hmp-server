package cn.pl.hmp.server.thrift.iface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pl.commons.pages.Pages;
import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrift.define.TPages;
import cn.pl.hmp.commons.thrift.define.TPmsCheckInInfo;
import cn.pl.hmp.commons.thrift.define.TPmsCheckInInfoCondition;
import cn.pl.hmp.commons.thrift.service.TPmsCheckInInfoService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IPmsCheckInInfoBusiness;
import cn.pl.hmp.server.dao.entity.PmsCheckInInfo;
import cn.pl.hmp.server.dao.entity.PmsCheckInInfoCondition;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class TPmsCheckInInfoServiceIface implements TPmsCheckInInfoService.Iface {
    @Autowired
    private IPmsCheckInInfoBusiness infoBusiness;

    @Override
    public Map<TPages, List<TPmsCheckInInfo>> queryCombInfoByPages(
            TPages pages, TPmsCheckInInfoCondition condition) throws TException {
        Map<TPages, List<TPmsCheckInInfo>> tmap = new HashMap<TPages, List<TPmsCheckInInfo>>();
        Map<Pages, List<PmsCheckInInfo>> roomTypeMap = infoBusiness.selectByPages(
                ObjectConverter.convet(condition, PmsCheckInInfoCondition.class),
                ObjectConverter.convet(pages, Pages.class));
        TPages tempPage = null;
        if (null != roomTypeMap && !roomTypeMap.isEmpty()) {
            Set<Pages> set = roomTypeMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(roomTypeMap.get(page), TPmsCheckInInfo.class));
            }
        }
        return tmap;
    }

}
