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
import cn.pl.hmp.commons.thrift.define.TDataDict;
import cn.pl.hmp.commons.thrift.service.TDataDictService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IDataDictBusiness;
import cn.pl.hmp.server.dao.entity.DataDict;
import cn.pl.hmp.server.dao.entity.DataDictExample;
import cn.pl.hmp.server.dao.entity.DataDictExample.Criteria;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class TDataDictServiceIface implements TDataDictService.Iface {
	
	@Autowired
	private IDataDictBusiness dataDictBusiness;
	@Override
	public List<TDataDict> queryAll() throws TException {
		return ObjectConverter.convet(dataDictBusiness.selectAll(), TDataDict.class);
	}

	@Override
	public int deleteById(long id) throws TException {
		return dataDictBusiness.deleteByDataDictId(id);
	}

	@Override
	public int save(TDataDict record) throws TException {
		return dataDictBusiness.insert(ObjectConverter.convet(record, DataDict.class));
	}

	@Override
	public TDataDict queryById(long id) throws TException {
		DataDict dataDict = dataDictBusiness.selectByDataDictId(id);
		return ObjectConverter.convet(dataDict, TDataDict.class);
	}

	@Override
	public int update(TDataDict record) throws TException {
		return dataDictBusiness.update(ObjectConverter.convet(record, DataDict.class));
	}

    @Override
    public Map<TPages, List<TDataDict>> queryByPages(TPages pages)
            throws TException {
        Map<TPages,List<TDataDict>> tmap = new HashMap<TPages, List<TDataDict>>();
        TPages tempPage = null;
        Map<Pages,List<DataDict>> dataDictMap = dataDictBusiness.selectByPages(null,ObjectConverter.convet(pages, Pages.class));
        if(null != dataDictMap&& !dataDictMap.isEmpty()){
            Set<Pages> set = dataDictMap.keySet();
            for(Pages page:set){
                tempPage = ServerTransform.transform(page);
                tmap.put(tempPage,ObjectConverter.convet(dataDictMap.get(page), TDataDict.class));
            }
        }
        return tmap;
    }

    @Override
    public int deleteOnbatch(List<Long> idList) throws TException {
        return dataDictBusiness.deleteOnBatch(idList);
    }

    @Override
    public List<TDataDict> queryByName(String name) throws TException {
        DataDictExample example = new DataDictExample();
        example.createCriteria().andNameEqualTo(name);
        return ObjectConverter.convet(dataDictBusiness.selectByCase(example),TDataDict.class);
    }

    @Override
    public List<TDataDict> queryByParentId(long parentId) throws TException {
        DataDictExample example = new DataDictExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        return ObjectConverter.convet(dataDictBusiness.selectByCase(example),TDataDict.class);
    }

    @Override
    public List<TDataDict> queryByCases(TDataDict record) throws TException {
       DataDictExample example = new DataDictExample();
        Criteria criteria =example.createCriteria();
        try {
            ObjectConverter.copyValues(record,criteria);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return ObjectConverter.convet(dataDictBusiness.selectByCase(example),TDataDict.class);
    }
}
