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
import cn.pl.hmp.commons.thrift.define.TPublishPkgs;
import cn.pl.hmp.commons.thrift.service.TPublishPkgsService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IPublishPkgsBusiness;
import cn.pl.hmp.server.dao.entity.PublishPkgs;
import cn.pl.hmp.server.dao.entity.PublishPkgsExample;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class TPublishPkgsServiceIface  implements TPublishPkgsService.Iface {
    @Autowired
    private IPublishPkgsBusiness pkgBusiness;
    @Override
    public int deleteById(long id) throws TException {
        return pkgBusiness.deleteById(id);
    }

    @Override
    public long save(TPublishPkgs record) throws TException {
        return pkgBusiness.insert(ObjectConverter.convet(record, PublishPkgs.class));
    }

    @Override
    public long update(TPublishPkgs record) throws TException {
        return pkgBusiness.update(ObjectConverter.convet(record, PublishPkgs.class));
    }

    @Override
    public Map<TPages, List<TPublishPkgs>> queryByPages(TPages pages,long hotelId)
            throws TException {
        Map<TPages,List<TPublishPkgs>> tmap = new HashMap<TPages, List<TPublishPkgs>>();
        TPages tempPage = null;
        PublishPkgsExample example = new PublishPkgsExample();
        example.setOrderByClause("version desc");
        example.createCriteria().andHotelIdEqualTo(hotelId);
        Map<Pages,List<PublishPkgs>> pkgsMap = pkgBusiness.selectByPages(example,ObjectConverter
                .convet(pages, Pages.class));
        if(null != pkgsMap&& !pkgsMap.isEmpty()){
            Set<Pages> set = pkgsMap.keySet();
            for(Pages page:set){
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage,ObjectConverter.convet(pkgsMap.get(page), TPublishPkgs.class));
            }
        }
        return tmap;
    }

    @Override
    public TPublishPkgs queryById(long id) throws TException {
        return ObjectConverter.convet(pkgBusiness.selectById(id), TPublishPkgs.class);
    }

    @Override
    public TPublishPkgs queryByHotelWhichLastTime(long hotelId)
            throws TException {
        return ObjectConverter.convet(pkgBusiness.selectByHotelIdWhichLastTime(hotelId), TPublishPkgs.class);
    }

}
