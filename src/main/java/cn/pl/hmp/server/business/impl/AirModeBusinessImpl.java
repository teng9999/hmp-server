/*
 * ExampleBusinessImpl.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.AbstractBusiness;
import cn.pl.hmp.server.business.iface.IAirModeBusiness;
import cn.pl.hmp.server.dao.entity.AirMode;
import cn.pl.hmp.server.dao.entity.AirModeExample;
import cn.pl.hmp.server.dao.mapper.AirModeMapper;

/**
 * rcu
 *
 * @author zhoujianbiao
 */
@Service
public class AirModeBusinessImpl extends AbstractBusiness implements IAirModeBusiness {
    @Autowired
    private AirModeMapper airModeMapper;

    /*
     * (非 Javadoc) <p>Title: query</p> <p>Description: </p>
     * 
     * @param example
     * 
     * @return
     * 
     * @see cn.pl.hmp.server.business.iface.IAirModeBusiness#query(cn.pl.hmp.
     * server.dao.entity.AirModeExample)
     */
    @Override
    public List<AirMode> query(AirModeExample example) {
        if (example == null)
            example = new AirModeExample();
        return airModeMapper.selectByExample(example);
    }

    @Override
    public Map<Pages, List<AirMode>> queryPages(AirModeExample example, Pages pages) {
        Map<Pages, List<AirMode>> result = new HashMap<>();
        if (example == null)
            example = new AirModeExample();
        if (pages == null) {
            List<AirMode> list = airModeMapper.selectByExample(example);
            if (list == null)
                list = new ArrayList<AirMode>();
            pages = new Pages();
            result.put(pages, list);
        } else {
            PageHelper.startPage(pages.getPageNum(), pages.getPageSize());
            List<AirMode> list = airModeMapper.selectByExample(example);
            if (list == null) {
                list = new ArrayList<AirMode>();
                result.put(pages, list);
            } else {
                Page<AirMode> page = (Page<AirMode>) list;
                if (page.getResult() != null && !page.getResult().isEmpty()) {
                    pages.setPageNum(page.getPageNum());
                    pages.setPageSize(page.getPageSize());
                    pages.setSize(page.size());
                    pages.setOrderBy(page.getOrderBy());
                    pages.setEndRow(page.getEndRow());
                    pages.setTotal(page.getTotal());
                    pages.setPages(page.getPages());
                    result.put(pages, page.getResult());
                } else {
                    result.put(pages, new ArrayList<AirMode>());
                }
            }

        }
        return result;
    }

    /**
     * 
     * @Title: get @Description: TODO(这里用一句话描述这个方法的作用) @param @param
     * id @param @return 设定文件 @return HmpTest 返回类型 @throws
     */
    @Override
    public AirMode get(Long id) {
        if (id == null)
            return null;
        return airModeMapper.selectByPrimaryKey(id);
    }

    /**
     * 
     */
    @Override
    public int create(AirMode record) {
        if (record == null)
            return 0;
        return airModeMapper.insertSelective(record);
    }

    @Override
    public int update(AirMode record) {
        if (record == null || record.getId() == null)
            return 0;
        return airModeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int remove(Long id) {
        if (id == null)
            return 0;
        return airModeMapper.deleteByPrimaryKey(id);
    }

}
