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
import cn.pl.hmp.commons.thrift.define.TMenuChannel;
import cn.pl.hmp.commons.thrift.define.TMenuPages;
import cn.pl.hmp.commons.thrift.service.TMenuChannelService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IMenuChannelBusiness;
import cn.pl.hmp.server.business.iface.IMenuPagesBusiness;
import cn.pl.hmp.server.dao.entity.MenuChannel;
import cn.pl.hmp.server.dao.entity.MenuChannelExample;
import cn.pl.hmp.server.dao.entity.MenuPages;
import cn.pl.hmp.server.dao.entity.MenuPagesExample;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class TMenuChannelServiceIface implements TMenuChannelService.Iface {

    @Autowired
    private IMenuChannelBusiness menuChannelBusiness;
    @Autowired
    private IMenuPagesBusiness menuPagesBusiness;

    @Override
    public int deleteById(long id) throws TException {
        return menuChannelBusiness.deleteAllId(id);
    }

    @Override
    public long save(TMenuChannel record) throws TException {
        return menuChannelBusiness.insert(ObjectConverter.convet(record, MenuChannel.class));
    }

    @Override
    public TMenuChannel queryById(long id) throws TException {
        MenuChannel menuChannel = menuChannelBusiness.selectByMenuChannelId(id);
        return ObjectConverter.convet(menuChannel, TMenuChannel.class);
    }

    @Override
    public int update(TMenuChannel record) throws TException {
        return menuChannelBusiness.update(ObjectConverter.convet(record, MenuChannel.class));
    }

    @Override
    public int deleteOnbatch(List<Long> idList) throws TException {
        return menuChannelBusiness.deleteOnBatch(idList);
    }

    @Override
    public Map<TPages, List<TMenuChannel>> queryByHotelId(long hotelId, TPages pages) throws TException {
        Map<TPages, List<TMenuChannel>> tmap = new HashMap<TPages, List<TMenuChannel>>();
        TPages tempPage = null;
        MenuChannelExample example = new MenuChannelExample();
        example.createCriteria().andHotelIdEqualTo(hotelId);
        Map<Pages, List<MenuChannel>> menuChannelMap = menuChannelBusiness.selectByPages(example,
                ObjectConverter.convet(pages, Pages.class));
        if (null != menuChannelMap && !menuChannelMap.isEmpty()) {
            Set<Pages> set = menuChannelMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(menuChannelMap.get(page), TMenuChannel.class));
            }
        }
        return tmap;
    }

    @Override
    public Map<TPages, List<TMenuChannel>> queryByParentId(long parentId, long hotelId, TPages pages)
            throws TException {
        Map<TPages, List<TMenuChannel>> tmap = new HashMap<TPages, List<TMenuChannel>>();
        TPages tempPage = null;
        MenuChannelExample example = new MenuChannelExample();
        example.createCriteria().andHotelIdEqualTo(hotelId).andParentIdEqualTo(parentId);
        Map<Pages, List<MenuChannel>> menuChannelMap = menuChannelBusiness.queryByParentIdList(parentId, hotelId,
                ObjectConverter.convet(pages, Pages.class));
        if (null != menuChannelMap && !menuChannelMap.isEmpty()) {
            Set<Pages> set = menuChannelMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(menuChannelMap.get(page), TMenuChannel.class));
            }
        }
        return tmap;
    }

    @Override
    public long saveAll(TMenuChannel tmenuChannel, TMenuPages tmenuPages) throws TException {
        MenuChannel menuChannel = ObjectConverter.convet(tmenuChannel, MenuChannel.class);
        MenuPages menuPages = ObjectConverter.convet(tmenuPages, MenuPages.class);
        Long channelId = menuChannelBusiness.insert(menuChannel);
        if (channelId > 0 && menuChannel.getParentId() != null && menuChannel.getParentId() != 0) {
            menuPages.setCreateTime(menuChannel.getCreateTime());
            menuPages.setCreator(menuChannel.getCreator());
            menuPages.setMenuId(channelId);
            menuPagesBusiness.insert(menuPages);
        }
        return channelId;
    }

    @Override
    public int updateAll(TMenuChannel tmenuChannel, TMenuPages tmenuPages) throws TException {
        MenuChannel menuChannel = ObjectConverter.convet(tmenuChannel, MenuChannel.class);
        MenuPages menuPages = ObjectConverter.convet(tmenuPages, MenuPages.class);
        int res = menuChannelBusiness.update(menuChannel);
        if (menuChannel.getParentId() != null && menuChannel.getParentId() != 0) {
            MenuPagesExample pagesExample = new MenuPagesExample();
            pagesExample.createCriteria().andMenuIdEqualTo(menuChannel.getId());
            List<MenuPages> pagesList = menuPagesBusiness.selectByExample(pagesExample);
            menuPages.setMenuId(tmenuChannel.getId());
            if (pagesList != null && !pagesList.isEmpty()) {
                menuPages.setId(pagesList.get(0).getId());
                menuPages.setModifyTime(menuChannel.getModifyTime());
                menuPagesBusiness.update(menuPages);
            } else {
                menuPages.setCreateTime(menuChannel.getModifyTime());
                menuPages.setCreator(menuChannel.getCreator());
                menuPagesBusiness.insert(menuPages);
            }
        }
        return res;
    }
}
