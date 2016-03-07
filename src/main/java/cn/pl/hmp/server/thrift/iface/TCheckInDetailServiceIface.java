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
import cn.pl.hmp.commons.thrift.define.TCheckInDetail;
import cn.pl.hmp.commons.thrift.service.TCheckInDetailService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.ICheckInDetailBusiness;
import cn.pl.hmp.server.dao.entity.CheckInDetail;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class TCheckInDetailServiceIface implements TCheckInDetailService.Iface{
    @Autowired
    private ICheckInDetailBusiness detailBusiness;

    @Override
    public Map<TPages, List<TCheckInDetail>> selectByPages(TPages pages,
            int opStatus, String nowDate,long roomId) throws TException {
        Map<TPages, List<TCheckInDetail>> tmap = new HashMap<TPages, List<TCheckInDetail>>();
        TPages tempPage = null;
        Map<Pages, List<CheckInDetail>> detailMap = detailBusiness.selectByPages(ObjectConverter.convet(pages, Pages.class)
                , opStatus, nowDate,roomId);
        if (null != detailMap && !detailMap.isEmpty()) {
            Set<Pages> set = detailMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(detailMap.get(page), TCheckInDetail.class));
            }
        }
        return tmap;
    }
}
