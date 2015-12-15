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
import cn.pl.hmp.commons.thrift.define.TSysProgPkgs;
import cn.pl.hmp.commons.thrift.service.TSysProgPkgsService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.ISysProgPkgsBusiness;
import cn.pl.hmp.server.dao.entity.SysProgPkgs;
import cn.pl.hmp.server.dao.entity.SysProgPkgsExample;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class TSysProgPkgsServiceIface implements TSysProgPkgsService.Iface {

    @Autowired
    private ISysProgPkgsBusiness progPkgsBusiness;

    @Override
    public int deleteById(long id) throws TException {
        return progPkgsBusiness.deleteBySysProgPkgsId(id);
    }

    @Override
    public long save(TSysProgPkgs record) throws TException {
        return progPkgsBusiness.insert(ObjectConverter.convet(record, SysProgPkgs.class));
    }

    @Override
    public TSysProgPkgs queryById(long id) throws TException {
        SysProgPkgs progPkgs = progPkgsBusiness.selectBySysProgPkgsId(id);
        return ObjectConverter.convet(progPkgs, TSysProgPkgs.class);
    }

    @Override
    public int update(TSysProgPkgs record) throws TException {
        return progPkgsBusiness.update(ObjectConverter.convet(record, SysProgPkgs.class));
    }

    @Override
    public Map<TPages, List<TSysProgPkgs>> queryByPages(TPages pages) throws TException {
        Map<TPages, List<TSysProgPkgs>> tmap = new HashMap<TPages, List<TSysProgPkgs>>();
        TPages tempPage = null;
        Map<Pages, List<SysProgPkgs>> progPkgsMap = progPkgsBusiness.selectByPages(null,
                ObjectConverter.convet(pages, Pages.class));
        if (null != progPkgsMap && !progPkgsMap.isEmpty()) {
            Set<Pages> set = progPkgsMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(progPkgsMap.get(page), TSysProgPkgs.class));
            }
        }
        return tmap;
    }

    @Override
    public int deleteOnbatch(List<Long> idList) throws TException {
        return progPkgsBusiness.deleteOnBatch(idList);
    }

    @Override
    public TSysProgPkgs queryLastestByPkgType(String pkgType) throws TException {
        SysProgPkgsExample packsExample = new SysProgPkgsExample();
        packsExample.createCriteria().andPkgTypeEqualTo(pkgType);
        packsExample.setOrderByClause("createTime desc");
        SysProgPkgs progPkgs = new SysProgPkgs();
        List<SysProgPkgs> pkgsList = progPkgsBusiness.selectByExample(packsExample);
        if(null != pkgsList && !pkgsList.isEmpty()) {
            progPkgs = pkgsList.get(0);
        }
        return ObjectConverter.convet(progPkgs, TSysProgPkgs.class);
    }
}
