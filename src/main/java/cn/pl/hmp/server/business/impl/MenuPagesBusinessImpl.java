package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IMenuPagesBusiness;
import cn.pl.hmp.server.dao.entity.MenuPages;
import cn.pl.hmp.server.dao.entity.MenuPagesExample;
import cn.pl.hmp.server.dao.mapper.MenuPagesMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MenuPagesBusinessImpl extends BoostBusinessImpl implements IMenuPagesBusiness{

	@Autowired
	private MenuPagesMapper mapper;

	@Override
	public int deleteByMenuPagesId(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(MenuPages record) {
	    int res =mapper.insertSelective(record);
	    if(res >0 ) {
            return -1;
        }
        return res;
	}

	@Override
	public MenuPages selectByMenuPagesId(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<MenuPages> selectAll() {
		return mapper.selectByExample(new MenuPagesExample());
	}

	@Override
	public int update(MenuPages record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

    @Override
    public Map<Pages, List<MenuPages>> selectByPages(MenuPagesExample example,
            Pages page) {
        Map<Pages,List<MenuPages>> map = new HashMap<Pages, List<MenuPages>>();
        if(null == example)
            example = new MenuPagesExample();
        PageHelper.startPage(page.getPageNum(),page.getPageSize()); 
        System.out.println(page.getPageNum()+"--"+page.getPageSize());
        List<MenuPages> menuPagesList = mapper.selectByExample(example);
        if(null == menuPagesList)
            menuPagesList = new ArrayList<MenuPages>();
        PageInfo<MenuPages> pageInfo =  new PageInfo<MenuPages>(menuPagesList);
        Pages pages = PageConverter.converter(pageInfo);
        
        map.put(pages, menuPagesList);
        return map;
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
        //return mapper.deleteOnBatch(idList);
        return 0;
    }

    @Override
    public List<MenuPages> selectByExample(MenuPagesExample example) {
        if(null == example)
            example = new MenuPagesExample();
        return mapper.selectByExample(example);
    }

}
