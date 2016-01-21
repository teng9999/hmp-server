package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IHmpTvMenuTempletBusiness;
import cn.pl.hmp.server.dao.entity.HmpTvMenuTemplet;
import cn.pl.hmp.server.dao.entity.HmpTvMenuTempletExample;
import cn.pl.hmp.server.dao.mapper.HmpTvMenuTempletMapper;
import cn.pl.hmp.server.utils.PageConverter;

@Service
public class HmpTvMenuTempletBusinessImpl extends BoostBusinessImpl implements IHmpTvMenuTempletBusiness {
    @Autowired
    private HmpTvMenuTempletMapper mapper;

    @Override
    public int deleteById(Long id) {
        if (id == null)
            return 0;
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
    	return mapper.deleteOnBatch(idList);
    }
    
    @Override
    public long insert(HmpTvMenuTemplet record) {
    	if (null == record) {
    		return 0;
    	}
        mapper.insertSelective(record);
        return record.getId();
    }

    @Override
    public List<HmpTvMenuTemplet> selectAll() {
        return mapper.selectByExample(new HmpTvMenuTempletExample());
    }

    @Override
    public Map<Pages, List<HmpTvMenuTemplet>> selectByPages(HmpTvMenuTempletExample example, Pages page) {
        Map<Pages, List<HmpTvMenuTemplet>> map = new HashMap<Pages, List<HmpTvMenuTemplet>>();
        if (null == example)
            example = new HmpTvMenuTempletExample();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        System.out.println(page.getPageNum() + "--" + page.getPageSize());
        List<HmpTvMenuTemplet> tvList = mapper.selectByExample(example);
        if (null == tvList)
            tvList = new ArrayList<HmpTvMenuTemplet>();
        PageInfo<HmpTvMenuTemplet> pageInfo = new PageInfo<HmpTvMenuTemplet>(tvList);
        Pages pages = PageConverter.converter(pageInfo);
        map.put(pages, tvList);

        return map;
    }

    @Override
    public int update(HmpTvMenuTemplet record) {
        if (record == null || record.getId() == null)
            return 0;
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<HmpTvMenuTemplet> selectByExample(HmpTvMenuTempletExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public HmpTvMenuTemplet selectByPrimaryKey(Long id) {
        
        HmpTvMenuTemplet roomTv = mapper.selectByPrimaryKey(id);
        if (null == roomTv) {
        	roomTv = new HmpTvMenuTemplet();
        }
        return roomTv;
    }

}