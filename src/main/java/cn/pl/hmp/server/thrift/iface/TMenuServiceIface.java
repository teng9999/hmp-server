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
import cn.pl.hmp.commons.thrift.define.TMenu;
import cn.pl.hmp.commons.thrift.service.TMenuService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IMenuBusiness;
import cn.pl.hmp.server.dao.entity.Menu;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class TMenuServiceIface implements TMenuService.Iface {
	
	@Autowired
	private IMenuBusiness menuBusiness;
	@Override
	public List<TMenu> queryAll() throws TException {
		return ObjectConverter.convet(menuBusiness.selectAll(), TMenu.class);
	}

	@Override
	public int deleteById(long id) throws TException {
		return menuBusiness.deleteByMenuId(id);
	}

	@Override
	public int save(TMenu record) throws TException {
		return menuBusiness.insert(ObjectConverter.convet(record, Menu.class));
	}

	@Override
	public TMenu queryById(long id) throws TException {
		Menu menu = menuBusiness.selectByMenuId(id);
		return ObjectConverter.convet(menu, TMenu.class);
	}

	@Override
	public int update(TMenu record) throws TException {
		return menuBusiness.update(ObjectConverter.convet(record, Menu.class));
	}

    @Override
    public Map<TPages, List<TMenu>> queryByPages(TPages pages)
            throws TException {
        Map<TPages,List<TMenu>> tmap = new HashMap<TPages, List<TMenu>>();
        TPages tempPage = null;
        Map<Pages,List<Menu>> menuMap = menuBusiness.selectByPages(null,ObjectConverter.convet(pages, Pages.class));
        if(null != menuMap&& !menuMap.isEmpty()){
            Set<Pages> set = menuMap.keySet();
            for(Pages page:set){
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage,ObjectConverter.convet(menuMap.get(page), TMenu.class));
            }
        }
        return tmap;
    }

    @Override
    public int deleteOnbatch(List<Long> idList) throws TException {
        return menuBusiness.deleteOnBatch(idList);
    }

    @Override
    public List<TMenu> queryByParentId(long id) throws TException {
        return ObjectConverter.convet(menuBusiness.selectByParentId(id), TMenu.class);
    }

}
