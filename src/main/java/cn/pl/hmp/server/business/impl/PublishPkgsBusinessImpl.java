package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IPublishPkgsBusiness;
import cn.pl.hmp.server.dao.entity.PublishPkgs;
import cn.pl.hmp.server.dao.entity.PublishPkgsExample;
import cn.pl.hmp.server.dao.mapper.PublishPkgsMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PublishPkgsBusinessImpl extends BoostBusinessImpl implements IPublishPkgsBusiness{
	@Autowired
	private PublishPkgsMapper mapper;

	@Override
	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public long insert(PublishPkgs record) {
	    if(null == record) {
	        return 0;
	    }
	    mapper.insertSelective(record);
		return record.getId();
	}

	@Override
	public int update(PublishPkgs record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

    @Override
    public Map<Pages, List<PublishPkgs>> selectByPages(PublishPkgsExample example,
            Pages page) {
        Map<Pages,List<PublishPkgs>> map = new HashMap<Pages, List<PublishPkgs>>();
        if(null == example)
            example = new PublishPkgsExample();
        PageHelper.startPage(page.getPageNum(),page.getPageSize()); 
        System.out.println(page.getPageNum()+"--"+page.getPageSize());
        List<PublishPkgs> publishPkgsList = mapper.selectByExample(example);
        if(null == publishPkgsList)
            publishPkgsList = new ArrayList<PublishPkgs>();
        PageInfo<PublishPkgs> pageInfo =  new PageInfo<PublishPkgs>(publishPkgsList);
        Pages pages = PageConverter.converter(pageInfo);
        
        map.put(pages, publishPkgsList);
        return map;
    }

    @Override
    public PublishPkgs selectById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PublishPkgs selectByHotelIdWhichLastTime(Long hotelId) {
        PublishPkgs pkgs = new PublishPkgs();
        PublishPkgsExample example = new PublishPkgsExample();
        example.createCriteria().andHotelIdEqualTo(hotelId);
        example.setOrderByClause("create_time desc");
        PageHelper.startPage(0,1); 
        List<PublishPkgs> publishPkgsList = mapper.selectByExample(example);
        if(null != publishPkgsList && !publishPkgsList.isEmpty()) {
            pkgs = publishPkgsList.get(0);
        }
        return pkgs;
    }

}
