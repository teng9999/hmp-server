package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.ISysProgPkgsBusiness;
import cn.pl.hmp.server.dao.entity.SysProgPkgs;
import cn.pl.hmp.server.dao.entity.SysProgPkgsExample;
import cn.pl.hmp.server.dao.mapper.SysProgPkgsMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SysProgPkgsBusinessImpl extends BoostBusinessImpl implements ISysProgPkgsBusiness{

	@Autowired
	private SysProgPkgsMapper mapper;

	@Override
	public int deleteBySysProgPkgsId(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public long insert(SysProgPkgs record) {
	    mapper.insert(record);
		return record.getId();
	}

	@Override
	public SysProgPkgs selectBySysProgPkgsId(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SysProgPkgs> selectAll() {
		return mapper.selectByExample(new SysProgPkgsExample());
	}

	@Override
	public int update(SysProgPkgs record) {
		return mapper.updateByPrimaryKey(record);
	}

    @Override
    public Map<Pages, List<SysProgPkgs>> selectByPages(SysProgPkgsExample example,
            Pages page) {
        Map<Pages,List<SysProgPkgs>> map = new HashMap<Pages, List<SysProgPkgs>>();
        if(null == example)
            example = new SysProgPkgsExample();
        PageHelper.startPage(page.getPageNum(),page.getPageSize()); 
        System.out.println(page.getPageNum()+"--"+page.getPageSize());
        List<SysProgPkgs> sysProgPkgsList = mapper.selectByExample(example);
        if(null == sysProgPkgsList)
            sysProgPkgsList = new ArrayList<SysProgPkgs>();
        PageInfo<SysProgPkgs> pageInfo =  new PageInfo<SysProgPkgs>(sysProgPkgsList);
        Pages pages = PageConverter.converter(pageInfo);
        
        map.put(pages, sysProgPkgsList);
        return map;
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
//        return mapper.deleteOnBatch(idList);
        return 0;
    }

    @Override
    public List<SysProgPkgs> selectByExample(SysProgPkgsExample example) {
       if(null == example) {
           return null;
       }
       return mapper.selectByExample(example);
    }

}
