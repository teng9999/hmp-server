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
import cn.pl.hmp.server.business.iface.IModuleBusiness;
import cn.pl.hmp.server.dao.entity.Module;
import cn.pl.hmp.server.dao.entity.ModuleExample;
import cn.pl.hmp.server.dao.mapper.ModuleMapper;
import cn.pl.hmp.server.utils.PageConverter;

@Service
public class ModuleBusinessImpl extends BoostBusinessImpl implements IModuleBusiness {

    @Autowired
    private ModuleMapper mapper;

    @Override
    public int deleteByModuleId(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Module record) {
        return mapper.insert(record);
    }

    @Override
    public Module selectByModuleId(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Module> selectAll() {
        return mapper.selectByExample(new ModuleExample());
    }

    @Override
    public int update(Module record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public Map<Pages, List<Module>> selectByPages(ModuleExample example, Pages page) {
        Map<Pages, List<Module>> map = new HashMap<Pages, List<Module>>();
        if (null == example)
            example = new ModuleExample();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        System.out.println(page.getPageNum() + "--" + page.getPageSize());
        List<Module> moduleList = mapper.selectByExample(example);
        if (null == moduleList)
            moduleList = new ArrayList<Module>();
        PageInfo<Module> pageInfo = new PageInfo<Module>(moduleList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, moduleList);
        return map;
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
        return 0;
        // return mapper.deleteOnBatch(idList);
    }

}
