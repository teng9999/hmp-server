package cn.pl.hmp.server.test.object2thrift;

import org.junit.Test;

import cn.pl.hmp.server.dao.entity.HotelRoom;

public class JunitTest {
	@Test
	public void thrift() {
		// System.out.println(Java2ThriftStruct.java2thrift(WxTxtFile.class));
		// System.out.println(Java2ThriftStruct.java2thrift(WxTxtHotel2Protocol.class));
		// System.out.println(Java2ThriftStruct.java2thrift(WxTxtProtocol.class));
		// System.out.println(Java2ThriftStruct.java2thrift(User2Hotel.class));
		// System.out.println(Java2ThriftStruct.java2thrift(HotelDinnerCode.class));
		// System.out.println(Java2ThriftStruct.java2thrift(DinnerTable.class));
		// System.out.println(Java2ThriftStruct.java2thrift(TotalOrder.class));
		// System.out.println(Java2ThriftStruct.java2thrift(SingleOrder.class));
		// System.out.println(Java2ThriftStruct.java2thrift(TotalOrderStatus.class));
		// System.out.println(Java2ThriftStruct.java2thrift(SingleOrderStatus.class));
		// System.out.println(Java2ThriftStruct.java2thrift(Orderbean.class));

		// System.out.println(Java2ThriftStruct.java2thrift(UpdateDetail.class));
		// System.out.println(Java2ThriftStruct.java2thrift(UpdateRecord.class));
		// System.out.println(Java2ThriftStruct.java2thrift(WxSystemPackage.class));
		// System.out.println(Java2ThriftStruct.java2thrift(ProgramePackage.class));
		System.out.println(Java2ThriftStruct.java2thrift(HotelRoom.class));
	}
}
