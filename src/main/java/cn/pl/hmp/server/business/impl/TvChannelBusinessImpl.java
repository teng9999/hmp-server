package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.ITvChannelBusiness;
import cn.pl.hmp.server.dao.entity.TvChannel;
import cn.pl.hmp.server.dao.entity.TvChannelExample;
import cn.pl.hmp.server.dao.mapper.TvChannelMapper;
import cn.pl.hmp.server.utils.PageConverter;
import com.github.pagehelper.PageInfo;
@Service
public class TvChannelBusinessImpl extends BoostBusinessImpl implements ITvChannelBusiness {
	
	@Autowired
	private TvChannelMapper mapper;

	@Override
	public int deleteByTvChannelId(Long id) {
		if (id == null)
			return 0;
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public long insert(TvChannel record) {
		mapper.insert(record);
		return record.getId();
	}

	@Override
	public List<TvChannel> selectAll() {
		return mapper.selectByExample(new TvChannelExample());
	}

	@Override
	public int update(TvChannel record) {
		if (null == record || record.getId() == null)
			return 0;
		return mapper.updateByPrimaryKey(record);
	}

    @Override
    public Map<Pages, List<TvChannel>> selectByPages(TvChannelExample example,
            Pages page) {
        Map<Pages,List<TvChannel>> map = new HashMap<Pages, List<TvChannel>>();
        if(null == example)
            example = new TvChannelExample();
        PageHelper.startPage(page.getPageNum(),page.getPageSize()); 
        System.out.println(page.getPageNum()+"--"+page.getPageSize());
        List<TvChannel> userList = mapper.selectByExample(example);
        if(null == userList)
            userList = new ArrayList<TvChannel>();
        PageInfo<TvChannel> pageInfo =  new PageInfo<TvChannel>(userList);
        Pages pages = PageConverter.converter(pageInfo);
        
        map.put(pages, userList);
        return map;
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
    	if (idList == null || idList.isEmpty())
    		return 0;
        return mapper.deleteOnBatch(idList);
    }
    
	@Override
	public List<TvChannel> selectByExample(TvChannelExample example) {
		if (null == example) {
			return null;
		}
		return mapper.selectByExample(example);
	}

    
}
