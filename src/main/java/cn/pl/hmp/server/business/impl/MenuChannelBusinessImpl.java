package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IMenuChannelBusiness;
import cn.pl.hmp.server.dao.entity.MenuChannel;
import cn.pl.hmp.server.dao.entity.MenuChannelExample;
import cn.pl.hmp.server.dao.mapper.MenuChannelMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MenuChannelBusinessImpl extends BoostBusinessImpl implements IMenuChannelBusiness{

	@Autowired
	private MenuChannelMapper mapper;

	@Override
	public int deleteByMenuChannelId(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public long insert(MenuChannel record) {
		return mapper.insert(record);
	}

	@Override
	public MenuChannel selectByMenuChannelId(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<MenuChannel> selectAll() {
		return mapper.selectByExample(new MenuChannelExample());
	}

	@Override
	public int update(MenuChannel record) {
		return mapper.updateByPrimaryKey(record);
	}

    @Override
    public Map<Pages, List<MenuChannel>> selectByPages(MenuChannelExample example,
            Pages page) {
        Map<Pages,List<MenuChannel>> map = new HashMap<Pages, List<MenuChannel>>();
        if(null == example)
            example = new MenuChannelExample();
        PageHelper.startPage(page.getPageNum(),page.getPageSize()); 
        System.out.println(page.getPageNum()+"--"+page.getPageSize());
        List<MenuChannel> menuChanneList = mapper.selectByExample(example);
        if(null == menuChanneList)
            menuChanneList = new ArrayList<MenuChannel>();
        PageInfo<MenuChannel> pageInfo =  new PageInfo<MenuChannel>(menuChanneList);
        Pages pages = PageConverter.converter(pageInfo);
        
        map.put(pages, menuChanneList);
        return map;
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
//        return mapper.deleteOnBatch(idList);
        return 0;
    }

    @Override
    public List<MenuChannel> selectByExample(MenuChannelExample example) {
       if(null == example) {
           return null;
       }
       return mapper.selectByExample(example);
    }

}
