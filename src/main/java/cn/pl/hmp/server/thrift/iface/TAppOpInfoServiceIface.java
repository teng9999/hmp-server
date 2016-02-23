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
import cn.pl.hmp.commons.thrift.define.TAppOpInfo;
import cn.pl.hmp.commons.thrift.service.TAppOpInfoService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IAppOpInfoBusiness;
import cn.pl.hmp.server.dao.entity.AppOpInfo;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class TAppOpInfoServiceIface implements TAppOpInfoService.Iface{
    @Autowired
    private IAppOpInfoBusiness opInfoBusiness;
    @Override
    public int saveOnBatch(TAppOpInfo info, Map<String, String> paramMap)
            throws TException {
        return opInfoBusiness.saveOnBatch(ObjectConverter.convet(info, AppOpInfo.class), paramMap);
    }

    @Override
    public Map<TPages, List<TAppOpInfo>> selectByPages(TPages pages)
            throws TException {
        Map<TPages, List<TAppOpInfo>> tmap = new HashMap<TPages, List<TAppOpInfo>>();
        TPages tempPage = null;
        Map<Pages, List<AppOpInfo>> opInfoMap = opInfoBusiness.selectByPages(null,
                ObjectConverter.convet(pages, Pages.class));
        if (null != opInfoMap && !opInfoMap.isEmpty()) {
            Set<Pages> set = opInfoMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(opInfoMap.get(page), TAppOpInfo.class));
            }
        }
        return tmap;
    }

}
