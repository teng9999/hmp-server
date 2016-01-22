package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IHmpTvMenuTempletBusiness;
import cn.pl.hmp.server.dao.entity.HmpTvMenuTemplet;
import cn.pl.hmp.server.dao.entity.HmpTvMenuTempletExample;
import cn.pl.hmp.server.dao.mapper.HmpTvMenuTempletMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class HmpTvMenuTempletBusinessImpl extends BoostBusinessImpl implements
        IHmpTvMenuTempletBusiness {
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
        //验证排序号是否重复
        if (null != record.getOrderNum()) {
            HmpTvMenuTempletExample example = new HmpTvMenuTempletExample();
            example.createCriteria().andParentIdEqualTo(record.getParentId())
                    .andOrderNumEqualTo(record.getOrderNum());
            List<HmpTvMenuTemplet> menuList = mapper.selectByExample(example);
            if (null != menuList && !menuList.isEmpty()) {
                return -2;
            }
            
        }
        
        //验证名称是否重复
        HmpTvMenuTempletExample example2 = new HmpTvMenuTempletExample();
        example2.createCriteria().andParentIdEqualTo(record.getParentId())
        .andNameCnEqualTo(record.getNameCn());
        List<HmpTvMenuTemplet> menuList2 = mapper.selectByExample(example2);
        if (null != menuList2 && !menuList2.isEmpty()) {
            return -3;
        }
        mapper.insertSelective(record);
        return record.getId();
    }

    @Override
    public List<HmpTvMenuTemplet> selectAll() {
        return mapper.selectByExample(new HmpTvMenuTempletExample());
    }

    @Override
    public Map<Pages, List<HmpTvMenuTemplet>> selectByPages(
            HmpTvMenuTempletExample example, Pages page) {
        Map<Pages, List<HmpTvMenuTemplet>> map = new HashMap<Pages, List<HmpTvMenuTemplet>>();
        if (null == example)
            example = new HmpTvMenuTempletExample();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        System.out.println(page.getPageNum() + "--" + page.getPageSize());
        List<HmpTvMenuTemplet> tvList = mapper.selectByExample(example);
        if (null == tvList)
            tvList = new ArrayList<HmpTvMenuTemplet>();
        PageInfo<HmpTvMenuTemplet> pageInfo = new PageInfo<HmpTvMenuTemplet>(
                tvList);
        Pages pages = PageConverter.converter(pageInfo);
        map.put(pages, tvList);

        return map;
    }

    @Override
    public int update(HmpTvMenuTemplet record) {
        if (record == null || record.getId() == null)
            return 0;
        HmpTvMenuTemplet baseChannel = mapper.selectByPrimaryKey(record
                .getId());
        if (null != record.getOrderNum()) {
            HmpTvMenuTempletExample example = new HmpTvMenuTempletExample();
            example.createCriteria().andParentIdEqualTo(record.getParentId())
                    .andOrderNumEqualTo(record.getOrderNum());
            List<HmpTvMenuTemplet> menuList = mapper.selectByExample(example);
            if (null != menuList && !menuList.isEmpty()) {
                if (!(null == menuList.get(0).getOrderNum())) {
                    if (baseChannel.getOrderNum().intValue() != menuList.get(0)
                            .getOrderNum().intValue()) {
                        return -2;
                    }
                }
            }
        }
        
        //验证名称是否重复
        HmpTvMenuTempletExample example2 = new HmpTvMenuTempletExample();
        example2.createCriteria().andParentIdEqualTo(record.getParentId())
                .andNameCnEqualTo(record.getNameCn());
        List<HmpTvMenuTemplet> menuList2 = mapper.selectByExample(example2);
        if (null != menuList2 && !menuList2.isEmpty()) {
            if (!(null == menuList2.get(0).getNameCn())) {
                if (!baseChannel.getNameCn().equals(menuList2.get(0).getNameCn())) {
                    return -3;
                }
            }
        }
        
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<HmpTvMenuTemplet> selectByExample(
            HmpTvMenuTempletExample example) {
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
