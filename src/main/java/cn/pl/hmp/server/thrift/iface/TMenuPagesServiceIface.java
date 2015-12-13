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
import cn.pl.hmp.commons.thrift.define.TMenuPages;
import cn.pl.hmp.commons.thrift.service.TMenuPagesService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IMenuPagesBusiness;
import cn.pl.hmp.server.dao.entity.MenuPages;
import cn.pl.hmp.server.dao.entity.MenuPagesExample;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class TMenuPagesServiceIface implements TMenuPagesService.Iface {

    @Autowired
    private IMenuPagesBusiness menuPagesBusiness;

    @Override
    public List<TMenuPages> queryAll() throws TException {
        return ObjectConverter.convet(menuPagesBusiness.selectAll(), TMenuPages.class);
    }

    @Override
    public int deleteById(long id) throws TException {
        return menuPagesBusiness.deleteByMenuPagesId(id);
    }

    @Override
    public int save(TMenuPages record) throws TException {
        return menuPagesBusiness.insert(ObjectConverter.convet(record, MenuPages.class));
    }

    @Override
    public TMenuPages queryById(long id) throws TException {
        MenuPages menuPages = menuPagesBusiness.selectByMenuPagesId(id);
        return ObjectConverter.convet(menuPages, TMenuPages.class);
    }

    @Override
    public int update(TMenuPages record) throws TException {
        return menuPagesBusiness.update(ObjectConverter.convet(record, MenuPages.class));
    }

    @Override
    public Map<TPages, List<TMenuPages>> queryByPages(TPages pages) throws TException {
        Map<TPages, List<TMenuPages>> tmap = new HashMap<TPages, List<TMenuPages>>();
        TPages tempPage = null;
        Map<Pages, List<MenuPages>> menuPagesMap = menuPagesBusiness.selectByPages(null,
                ObjectConverter.convet(pages, Pages.class));
        if (null != menuPagesMap && !menuPagesMap.isEmpty()) {
            Set<Pages> set = menuPagesMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(menuPagesMap.get(page), TMenuPages.class));
            }
        }
        return tmap;
    }

    @Override
    public int deleteOnbatch(List<Long> idList) throws TException {
        return menuPagesBusiness.deleteOnBatch(idList);
    }

    @Override
    public List<TMenuPages> queryByChannelId(long channelId) throws TException {
        MenuPagesExample example = new MenuPagesExample();
        example.createCriteria().andMenuIdEqualTo(channelId);
        return ObjectConverter.convet(menuPagesBusiness.selectByExample(example), TMenuPages.class);
    }

}
