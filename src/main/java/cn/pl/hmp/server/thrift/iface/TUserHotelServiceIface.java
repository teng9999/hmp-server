package cn.pl.hmp.server.thrift.iface;

import java.util.List;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pl.frame.annotation.ThriftService;
import cn.pl.hmp.commons.thrift.define.TUserHotel;
import cn.pl.hmp.commons.thrift.service.TUserHotelService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.IUserHotelBusiness;
import cn.pl.hmp.server.dao.entity.UserHotel;

@Component
@ThriftService
public class TUserHotelServiceIface implements TUserHotelService.Iface {
	
	@Autowired
	private IUserHotelBusiness userHotelBusiness;
	@Override
	public List<TUserHotel> queryByUserId(long id) throws TException {
		return ObjectConverter.convet(userHotelBusiness.selectByUserId(id), TUserHotel.class);
	}

	@Override
	public int deleteById(long id) throws TException {
		return userHotelBusiness.deleteById(id);
	}

	@Override
	public int save(TUserHotel record) throws TException {
		return userHotelBusiness.insert(ObjectConverter.convet(record, UserHotel.class));
	}

	@Override
	public List<TUserHotel> queryByHotelId(long id) throws TException {
		return ObjectConverter.convet(userHotelBusiness.selectByHotelId(id), TUserHotel.class);
	}
	@Override
	public int update(TUserHotel record) throws TException {
		return userHotelBusiness.update(ObjectConverter.convet(record, UserHotel.class));
	}


}
