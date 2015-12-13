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
import cn.pl.hmp.commons.thrift.define.TModule;
import cn.pl.hmp.commons.thrift.service.TModuleService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IModuleBusiness;
import cn.pl.hmp.server.dao.entity.Module;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class TModuleServiceIface implements TModuleService.Iface {

    @Autowired
    private IModuleBusiness moduleBusiness;

    @Override
    public List<TModule> queryAll() throws TException {
        return ObjectConverter.convet(moduleBusiness.selectAll(), TModule.class);
    }

    @Override
    public int deleteById(long id) throws TException {
        return moduleBusiness.deleteByModuleId(id);
    }

    @Override
    public int save(TModule record) throws TException {
        return moduleBusiness.insert(ObjectConverter.convet(record, Module.class));
    }

    @Override
    public TModule queryById(long id) throws TException {
        Module module = moduleBusiness.selectByModuleId(id);
        return ObjectConverter.convet(module, TModule.class);
    }

    @Override
    public int update(TModule record) throws TException {
        return moduleBusiness.update(ObjectConverter.convet(record, Module.class));
    }

    @Override
    public Map<TPages, List<TModule>> queryByPages(TPages pages) throws TException {
        Map<TPages, List<TModule>> tmap = new HashMap<TPages, List<TModule>>();
        TPages tempPage = null;
        Map<Pages, List<Module>> moduleMap = moduleBusiness.selectByPages(null,
                ObjectConverter.convet(pages, Pages.class));
        if (null != moduleMap && !moduleMap.isEmpty()) {
            Set<Pages> set = moduleMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(moduleMap.get(page), TModule.class));
            }
        }
        return tmap;
    }

    @Override
    public int deleteOnbatch(List<Long> idList) throws TException {
        return moduleBusiness.deleteOnBatch(idList);
    }

}
