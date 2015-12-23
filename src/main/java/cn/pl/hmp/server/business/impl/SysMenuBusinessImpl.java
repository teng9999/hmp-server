package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.ISysMenuBusiness;
import cn.pl.hmp.server.dao.entity.SysMenu;
import cn.pl.hmp.server.dao.entity.SysMenuExample;
import cn.pl.hmp.server.dao.mapper.SysMenuMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SysMenuBusinessImpl extends BoostBusinessImpl implements ISysMenuBusiness{
    
    @Autowired
    private SysMenuMapper menuMapper;
    @Override
    public int deleteByMenuId(Long id) {
        SysMenuExample menuExample = new SysMenuExample();
        menuExample.createCriteria().andPathLike("%"+id+"%");
        List<SysMenu> menuList = menuMapper.selectByExample(menuExample);
        if(null != menuList && menuList.size() >0) {
            for(SysMenu menu:menuList) {
                menuMapper.deleteByPrimaryKey(menu.getId());
            }
        }
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public long insert(SysMenu record) {
        
        SysMenu menu = menuMapper.selectByPrimaryKey(record.getParentId());
        String path = "";
        if(null == menu) {
            path = record.getParentId()+"";
        }else {
            path = menu.getPath()+"@"+record.getParentId();
        }
        record.setPath(path);
        int res = menuMapper.insertSelective(record);
        if(res < 1) {
            return -1L;
        }
        return record.getId();
    }

    @Override
    public SysMenu selectByMenuId(Long id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<Pages, List<SysMenu>> selectByPages(SysMenuExample example,
            Pages page) {
        Map<Pages, List<SysMenu>> map = new HashMap<Pages, List<SysMenu>>();
        if (null == example)
            example = new SysMenuExample();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<SysMenu> menuList = menuMapper.selectByExample(example);
        if (null == menuList)
            menuList = new ArrayList<SysMenu>();
        PageInfo<SysMenu> pageInfo = new PageInfo<SysMenu>(menuList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, menuList);
        return map;
    }

    @Override
    public int update(SysMenu record) {
        return menuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SysMenu> selectByExample(SysMenuExample example) {
        return menuMapper.selectByExample(example);
    }

}
