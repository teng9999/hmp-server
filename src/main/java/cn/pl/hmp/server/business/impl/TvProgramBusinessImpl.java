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
import cn.pl.hmp.server.business.iface.ITvProgramBusiness;
import cn.pl.hmp.server.dao.entity.TvProgram;
import cn.pl.hmp.server.dao.entity.TvProgramExample;
import cn.pl.hmp.server.dao.mapper.TvProgramMapper;
import cn.pl.hmp.server.utils.PageConverter;

@Service
public class TvProgramBusinessImpl extends BoostBusinessImpl implements ITvProgramBusiness {
    @Autowired
    private TvProgramMapper mapper;

    @Override
    public int deleteByTvProgramId(Long id) {
        if (id == null)
            return 0;
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public long insert(TvProgram record) {
        mapper.insert(record);
        return record.getId();
    }

    @Override
    public List<TvProgram> selectAll() {
        return mapper.selectByExample(new TvProgramExample());
    }

    @Override
    public Map<Pages, List<TvProgram>> selectByPages(TvProgramExample example, Pages page) {
        Map<Pages, List<TvProgram>> map = new HashMap<Pages, List<TvProgram>>();
        if (null == example)
            example = new TvProgramExample();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        System.out.println(page.getPageNum() + "--" + page.getPageSize());
        List<TvProgram> tvList = mapper.selectByExample(example);
        if (null == tvList)
            tvList = new ArrayList<TvProgram>();
        PageInfo<TvProgram> pageInfo = new PageInfo<TvProgram>(tvList);
        Pages pages = PageConverter.converter(pageInfo);
        map.put(pages, tvList);

        return map;
    }

    @Override
    public int update(TvProgram record) {
        if (record == null || record.getId() == null)
            return 0;
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
        if (idList == null || idList.isEmpty())
            return 0;
        return mapper.deleteOnBatch(idList);
    }

    @Override
    public List<TvProgram> selectByExample(TvProgramExample example) {
        // if (null == example) {
        // return null;
        // }
        return mapper.selectByExample(example);
    }
}
