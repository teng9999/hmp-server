package cn.pl.hmp.server.thrift.iface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrift.define.TPages;
import cn.pl.frame.thrift.exception.ThriftException;
import cn.pl.hmp.commons.thrift.define.THmpMGHotel;
import cn.pl.hmp.commons.thrift.service.THmpMGHotelService.Iface;
import cn.pl.hmp.server.business.iface.IHmpMGHotelBusiness;
import cn.pl.hmp.server.dao.entity.HmpMGHotel;
import cn.pl.hmp.server.thrift.transform.ServerTransform;

@Component
@ThriftService
public class THmpMGHotelServiceIface implements Iface {

	@Autowired
	private IHmpMGHotelBusiness business;

	@Override
	public int deleteById(long id) throws TException {
		// TODO Auto-generated method stub
		if (0 > id)
			return 0;
		return business.remove(id);
	}

	@Override
	public int insert(THmpMGHotel record) throws TException {
		// TODO Auto-generated method stub
		if (null == business)
			return -1;
		if (null == record)
			return 0;
		HmpMGHotel entity = ServerTransform.transform(record);
		if (null == entity)
			return 0;
		return business.create(entity);

	}

	@Override
	public int saveOnBatch(List<THmpMGHotel> mgList) throws ThriftException, TException {
		// TODO Auto-generated method stub
		if (null == mgList || 0 > mgList.size())
			return -1;
		return business.saveOnBatch(listTrans(mgList));
	}

	@Override
	public int deleteOnBatch(List<Long> idList, long hotelId) throws ThriftException, TException {
		// TODO Auto-generated method stub
		if (null == idList || 0 > idList.size())
			return -1;
		return business.deleteOnBatch(idList, hotelId);
	}

	@Override
	public int deleteByGroupIdOnBatch(long hotelId) throws ThriftException, TException {
		// TODO Auto-generated method stub
		if (0 > hotelId)
			return -1;
		return business.deleteByHotelIdOnBatch(hotelId);
	}

	@Override
	public THmpMGHotel selectById(long id) throws TException {
		// TODO Auto-generated method stub
		if (null == business)
			return new THmpMGHotel();
		if (0 > id)
			return new THmpMGHotel();
		HmpMGHotel entity = business.get(id);
		if (null == entity)
			return new THmpMGHotel();
		return ServerTransform.transform(entity);
	}

	@Override
	public int updateById(THmpMGHotel record) throws TException {
		// TODO Auto-generated method stub
		if (null == business)
			return -1;
		if (null == record || 0 < record.getId())
			return 0;
		return business.update(ServerTransform.transform(record));
	}

	@Override
	public List<THmpMGHotel> loadAll() throws ThriftException, TException {
		// TODO Auto-generated method stub
		if (null == business)
			return null;
		List<HmpMGHotel> lists = business.query(null);
		if (null == lists || 0 < lists.size())
			return new ArrayList<THmpMGHotel>();
		return listTransform(lists);
	}

	@Override
	public List<Long> selectByHotelId(long HotelId) throws ThriftException, TException {
		// TODO Auto-generated method stub
		if (0 > HotelId)
			return new ArrayList<Long>();
		List<Long> lists = business.queryByHotelId(HotelId);
		if (null == lists || 0 >= lists.size())
			return new ArrayList<Long>();
		return lists;
	}

	@Override
	public Map<TPages, List<THmpMGHotel>> loadPages(TPages pages) throws ThriftException, TException {
		// TODO Auto-generated method stub
		return null;
	}

	private List<THmpMGHotel> listTransform(List<HmpMGHotel> lists) {
		List<THmpMGHotel> resultLists = new ArrayList<THmpMGHotel>();
		for (HmpMGHotel hmpMGHotel : lists) {
			THmpMGHotel result = ServerTransform.transform(hmpMGHotel);
			resultLists.add(result);
		}
		return resultLists;
	}

	private List<HmpMGHotel> listTrans(List<THmpMGHotel> lists) {
		List<HmpMGHotel> resultLists = new ArrayList<HmpMGHotel>();
		for (THmpMGHotel hmpMGHotel : lists) {
			HmpMGHotel result = ServerTransform.transform(hmpMGHotel);
			resultLists.add(result);
		}
		return resultLists;
	}

}
