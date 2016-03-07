package cn.pl.hmp.server.quartz;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.pl.hmp.server.business.iface.ISysLsOpLogBusiness;

public class DataCountJob {
	
	private static Log log = LogFactory.getLog(DataCountJob.class);
	@Autowired
	private ISysLsOpLogBusiness logBusiness;
	//意向和无效拜访 7天自动转公海
	public void work() {
		try {
			System.err.println("开始调度-----------------------------------------");
			Date beginTime = new Date(new Date().getTime() - 30*24*60*60*1000L);
//			Date beginTime = null;
			int[] resArray = logBusiness.saveTotalData(beginTime);
			if(null != resArray && resArray.length > 1 ) {
			    System.err.println("summary count:"+resArray[0]+",detail count:"+resArray);
			}else {
			    System.err.println("没查到数据。。。。。。");
			}
		} catch (Exception e) {
			log.error("自动转入公海  Error", e);
			e.printStackTrace();
		}
	}
}