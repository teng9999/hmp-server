package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IMenuBusiness;
import cn.pl.hmp.server.dao.entity.Menu;
import cn.pl.hmp.server.dao.entity.MenuExample;
import cn.pl.hmp.server.dao.mapper.MenuMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MenuBusinessImpl extends BoostBusinessImpl implements IMenuBusiness{

	@Autowired
	private MenuMapper mapper;

	@Override
	public int deleteByMenuId(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Menu record) {
		return mapper.insert(record);
	}

	@Override
	public Menu selectByMenuId(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Menu> selectAll() {
		return mapper.selectByExample(new MenuExample());
	}

	@Override
	public int update(Menu record) {
		return mapper.updateByPrimaryKey(record);
	}

    @Override
    public Map<Pages, List<Menu>> selectByPages(MenuExample example,
            Pages page) {
        Map<Pages,List<Menu>> map = new HashMap<Pages, List<Menu>>();
        if(null == example)
            example = new MenuExample();
        PageHelper.startPage(page.getPageNum(),page.getPageSize()); 
        List<Menu> menuList = mapper.selectByExample(example);
        if(null == menuList)
            menuList = new ArrayList<Menu>();
        PageInfo<Menu> pageInfo =  new PageInfo<Menu>(menuList);
        Pages pages = PageConverter.converter(pageInfo);
        
        map.put(pages, menuList);
        return map;
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
        //return mapper.deleteOnBatch(idList);
        return 0;
    }

}
