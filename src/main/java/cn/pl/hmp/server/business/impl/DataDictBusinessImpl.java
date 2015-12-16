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
import cn.pl.hmp.server.business.iface.IDataDictBusiness;
import cn.pl.hmp.server.dao.entity.DataDict;
import cn.pl.hmp.server.dao.entity.DataDictExample;
import cn.pl.hmp.server.dao.mapper.DataDictMapper;
import cn.pl.hmp.server.utils.PageConverter;

@Service
public class DataDictBusinessImpl extends BoostBusinessImpl implements IDataDictBusiness {

    @Autowired
    private DataDictMapper mapper;

    @Override
    public int deleteByDataDictId(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DataDict record) {
        return mapper.insert(record);
    }

    @Override
    public DataDict selectByDataDictId(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DataDict> selectAll() {
        return mapper.selectByExample(new DataDictExample());
    }

    @Override
    public int update(DataDict record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public Map<Pages, List<DataDict>> selectByPages(DataDictExample example, Pages page) {
        Map<Pages, List<DataDict>> map = new HashMap<Pages, List<DataDict>>();
        if (null == example)
            example = new DataDictExample();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        System.out.println(page.getPageNum() + "--" + page.getPageSize());
        List<DataDict> dataDictList = mapper.selectByExample(example);
        if (null == dataDictList)
            dataDictList = new ArrayList<DataDict>();
        PageInfo<DataDict> pageInfo = new PageInfo<DataDict>(dataDictList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, dataDictList);
        return map;
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
        // return mapper.deleteOnBatch(idList);
        return 0;
    }

    @Override
    public List<DataDict> selectByCase(DataDictExample example) {
        if (null == example)
            return null;
        return mapper.selectByExample(example);
    }

    @Override
    public List<DataDict> selectByParentName(String parentName) {
        return mapper.selectByParentName(parentName);
    }

}
