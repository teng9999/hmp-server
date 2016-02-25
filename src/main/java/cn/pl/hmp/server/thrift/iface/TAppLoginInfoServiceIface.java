package cn.pl.hmp.server.thrift.iface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pl.commons.pages.Pages;
import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrift.define.TPages;
import cn.pl.hmp.commons.thrift.define.TAppLoginInfo;
import cn.pl.hmp.commons.thrift.service.TAppLoginInfoService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IAppLoginInfoBusiness;
import cn.pl.hmp.server.dao.entity.AppLoginInfo;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class TAppLoginInfoServiceIface implements TAppLoginInfoService.Iface {

    @Autowired
    private IAppLoginInfoBusiness business;

    @Override
    public long save(TAppLoginInfo record) throws TException {
        AppLoginInfo app = ServerTransform.transform(record);
        return business.insert(app);
    }


	public List<TAppLoginInfo> convert(List<AppLoginInfo> list) {
    	List<TAppLoginInfo> newList = new ArrayList<>();
    	for (AppLoginInfo info : list) {
			TAppLoginInfo entity = ServerTransform.transform(info);
			newList.add(entity);
		}
    	return newList;
    }

    @Override
    public TAppLoginInfo selectById(String id) throws TException {
        return ObjectConverter.convet(business.selectById(id),TAppLoginInfo.class);
    }

    @Override
    public Map<TPages, List<TAppLoginInfo>> selectByPages(TPages pages,
            String name, String fixCondition) throws TException {
        Map<TPages, List<TAppLoginInfo>> tmap = new HashMap<TPages, List<TAppLoginInfo>>();
        TPages tempPage = null;
        Map<Pages, List<AppLoginInfo>> userMap = business.selectByPages(ObjectConverter
                .convet(pages, Pages.class),name,fixCondition);
        if (null != userMap && !userMap.isEmpty()) {
            Set<Pages> set = userMap.keySet();
            for (Pages page : set) {
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage, convert(userMap.get(page)));
            }
        }
        return tmap;
    }
}
