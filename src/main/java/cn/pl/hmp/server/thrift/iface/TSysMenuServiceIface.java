package cn.pl.hmp.server.thrift.iface;

import java.util.ArrayList;
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
import cn.pl.hmp.commons.thrift.define.TSysMenu;
import cn.pl.hmp.commons.thrift.service.TSysMenuService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.ISysMenuBusiness;
import cn.pl.hmp.server.dao.entity.SysMenu;
import cn.pl.hmp.server.dao.entity.SysMenuExample;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class TSysMenuServiceIface implements TSysMenuService.Iface {

    @Autowired
    private ISysMenuBusiness menuBusiness;


    @Override
    public int deleteById(long id) throws TException {
        return menuBusiness.deleteByMenuId(id);
    }

    @Override
    public long save(TSysMenu record) throws TException {
        return menuBusiness.insert(ObjectConverter.convet(record, SysMenu.class));
    }

    @Override
    public int update(TSysMenu record) throws TException {
        return menuBusiness.update(ObjectConverter.convet(record, SysMenu.class));
    }

    @Override
    public Map<TPages, List<TSysMenu>> queryByPages(TPages pages) throws TException {
        Map<TPages, List<TSysMenu>> tmap = new HashMap<TPages, List<TSysMenu>>();
        TPages tempPage = null;
        Map<Pages, List<SysMenu>> menuMap = menuBusiness.selectByPages(null,ObjectConverter.convet(pages, Pages.class));
        if (null != menuMap && !menuMap.isEmpty()) {
            Set<Pages> set = menuMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(menuMap.get(page), TSysMenu.class));
            }
        }
        return tmap;
    }

    @Override
    public Map<TPages, List<TSysMenu>> queryByParentId(TPages pages,long id) throws TException {
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andParentIdEqualTo(id);
        Map<TPages, List<TSysMenu>> tmap = new HashMap<TPages, List<TSysMenu>>();
        TPages tempPage = null;
        Map<Pages, List<SysMenu>> menuMap = menuBusiness.selectByPages(example,ObjectConverter.convet(pages, Pages.class));
        if (null != menuMap && !menuMap.isEmpty()) {
            Set<Pages> set = menuMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, ObjectConverter.convet(menuMap.get(page), TSysMenu.class));
            }
        }
        return tmap;
    }

    @Override
    public TSysMenu queryByMenuId(long id) throws TException {
        SysMenu menu = menuBusiness.selectByMenuId(id);
        if(null == menu) {
            menu = new SysMenu();
        }
        return ObjectConverter.convet(menu, TSysMenu.class);
    }
    /**
     * 查询某个角色下的所有导航菜单
     * @param topId 用户类型的数字类型
     */
    @Override
    public List<TSysMenu> queryByUserType(long topId) throws TException {
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andPathLike("%"+topId+"%");
        List<SysMenu> menuList = menuBusiness.selectByExample(example);
        if(null == menuList ) {
            menuList = new ArrayList<SysMenu>();
        }
        return ObjectConverter.convet(menuList, TSysMenu.class);
    }

    @Override
    public boolean hasOrderNum(long parentId,int orderNum) throws TException {
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andParentIdEqualTo(parentId)
        .andOrderNumEqualTo(orderNum);
        List<SysMenu> menuList = menuBusiness.selectByExample(example);
        if(null != menuList && !menuList.isEmpty()) {
            return true;
        }
        return false;
    }

}
