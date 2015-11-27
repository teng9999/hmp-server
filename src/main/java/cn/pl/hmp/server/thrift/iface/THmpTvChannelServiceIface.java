package cn.pl.hmp.server.thrift.iface;

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
import cn.pl.hmp.commons.thrift.define.THmpTvChannel;
import cn.pl.hmp.commons.thrift.service.THmpTvChannelService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.ITvChannelBusiness;
import cn.pl.hmp.server.dao.entity.TvChannel;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class THmpTvChannelServiceIface implements THmpTvChannelService.Iface {
	
	@Autowired
	private ITvChannelBusiness business;
	
	@Override
	public int deleteByPrimaryKey(long id) throws TException {
		return business.deleteByTvChannelId(id);
	}

	@Override
	public long insert(THmpTvChannel record) throws TException {
		return business.insert(ObjectConverter.convet(record, TvChannel.class));
	}

	@Override
	public int updateById(THmpTvChannel record) throws TException {
		return business.update(ObjectConverter.convet(record, TvChannel.class));
	}

	@Override
	public int deleteOnBatch(List<Long> idList) throws TException {
		return business.deleteOnBatch(idList);
	}
	
	@Override
	public List<THmpTvChannel> selectByTvName(String tvName) throws TException {
		return ObjectConverter.convet(business.selectByTvName(tvName), THmpTvChannel.class);
	}

	@Override
	public List<THmpTvChannel> selectAll() throws TException {
		return ObjectConverter.convet(business.selectAll(), THmpTvChannel.class);
	}

	@Override
	public Map<TPages, List<THmpTvChannel>> loadPages(TPages page) throws TException {
		Map<TPages, List<THmpTvChannel>> tMap = new HashMap<TPages, List<THmpTvChannel>>();
		TPages tempPage = null;
		Map<Pages, List<TvChannel>> tvMap = business.selectByPages(null, ObjectConverter.convet(page, Pages.class));
		if (null != tvMap && !tvMap.isEmpty()) {
			Set<Pages> set = tvMap.keySet();
			for(Pages pages:set) {
				tempPage = ServerTransform.transform(pages);
				tMap.put(tempPage, ObjectConverter.convet(tvMap.get(pages), THmpTvChannel.class));
			}
		}
		return tMap;
	}
}
