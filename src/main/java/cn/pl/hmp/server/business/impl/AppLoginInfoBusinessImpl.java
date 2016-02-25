package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.commons.utils.StringUtils;
import cn.pl.hmp.server.business.iface.IAppLoginInfoBusiness;
import cn.pl.hmp.server.dao.entity.AppLoginInfo;
import cn.pl.hmp.server.dao.mapper.AppLoginInfoMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class AppLoginInfoBusinessImpl extends BoostBusinessImpl implements IAppLoginInfoBusiness {
    @Autowired
    private AppLoginInfoMapper mapper;

	@Override
	public Map<Pages, List<AppLoginInfo>> selectByPages(Pages page,String name, String fixCondition) {
		Map<Pages, List<AppLoginInfo>> map = new HashMap<Pages, List<AppLoginInfo>>();
        PageHelper.startPage(page.getPageNum(), page.getPageSize(),page.getOrderBy());
        System.out.println(page.getPageNum() + "--" + page.getPageSize());
        List<AppLoginInfo> list = mapper.queryPages(name, fixCondition);
        if (null == list)
        	list = new ArrayList<AppLoginInfo>();
        PageInfo<AppLoginInfo> pageInfo = new PageInfo<AppLoginInfo>(list);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, list);
        return map;
	}

    @Override
    public long insert(AppLoginInfo record) {
        if(null != record) {
            return mapper.insertSelective(record);
        }
        return 0;
    }

    @Override
    public AppLoginInfo selectById(String id) {
        AppLoginInfo loginInfo = null;
        if(StringUtils.isNotBlank(id)) {
            loginInfo = mapper.selectByPrimaryKey(id);
        }
        if(null == loginInfo) {
            loginInfo = new AppLoginInfo();
        }
        return loginInfo;
    }
    
    

}
