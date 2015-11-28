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
import cn.pl.hmp.commons.thrift.define.THmpTvProgram;
import cn.pl.hmp.commons.thrift.service.THmpTvProgramService;
import cn.pl.hmp.commons.thrift.service.THmpTvProgramService.AsyncProcessor.selectByTvPlayContent;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.ITvProgramBusiness;
import cn.pl.hmp.server.dao.entity.TvProgram;
import cn.pl.hmp.server.dao.entity.TvProgramExample;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class THmpTvProgramServiceIface implements THmpTvProgramService.Iface {
	
	@Autowired
	private ITvProgramBusiness business;
	
	@Override
	public int deleteById(long id) throws TException {
		return business.deleteByTvProgramId(id);
	}

	@Override
	public long insert(THmpTvProgram record) throws TException {
		
		return business.insert(ObjectConverter.convet(record, TvProgram.class));
	}

	@Override
	public int updateById(THmpTvProgram record) throws TException {
		return business.update(ObjectConverter.convet(record, TvProgram.class));
	}

	@Override
	public int deleteOnBatch(List<Long> idList) throws TException {
		return business.deleteOnBatch(idList);
	}
	
	@Override 
	public List<THmpTvProgram> selectByTvPlayContent(String content) throws TException {
		TvProgramExample example = new TvProgramExample();
		example.createCriteria().andPlayContentLike(content);
		List<TvProgram> programList = business.selectByExample(example);
		return ObjectConverter.convet(programList, THmpTvProgram.class);
	}

	@Override
	public List<THmpTvProgram> selectAll() throws TException {
		return ObjectConverter.convet(business.selectAll(), THmpTvProgram.class);
	}

	@Override
	public Map<TPages, List<THmpTvProgram>> loadPages(TPages page) throws TException {
		Map<TPages, List<THmpTvProgram>> tMap = new HashMap<TPages, List<THmpTvProgram>>();
		TPages tempPage = null;
		Map<Pages, List<TvProgram>> tvMap = business.selectByPages(null, ObjectConverter.convet(page, Pages.class));
		if (null != tvMap && !tvMap.isEmpty()) {
			Set<Pages> set = tvMap.keySet();
			for(Pages pages:set) {
				tempPage = ServerTransform.transform(pages);
				tMap.put(tempPage, ObjectConverter.convet(tvMap.get(pages), THmpTvProgram.class));
			}
		}
		return tMap;
	}
}
