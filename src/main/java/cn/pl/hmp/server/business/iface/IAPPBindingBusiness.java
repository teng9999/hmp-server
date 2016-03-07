/*
 * IExampleBusiness.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.business.iface;

import java.util.List;
import java.util.Map;

import cn.pl.commons.datasource.DataSource;
import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.IBusiness;
import cn.pl.hmp.server.dao.entity.APPBinding;
import cn.pl.hmp.server.dao.entity.APPBindingExample;

/**
 *
 * @author zhoujianbiao
 */
public interface IAPPBindingBusiness extends IBusiness {
    /**
	 * 按条件查询
	 *
	 * @param example
	 * @return
	 */
	@DataSource("cluster")
	public List<APPBinding> query(APPBindingExample example);

    /**
	 * 按条件查询
	 *
	 * @param example
	 * @param pages
	 * @return
	 */
	@DataSource("cluster")
	public Map<Pages, List<APPBinding>> queryPages(APPBindingExample example,
			Pages pages);

    /**
	 * 获取
	 *
	 * @param id
	 * @return
	 */
	@DataSource("cluster")
	public APPBinding get(Long id);

    /**
	 * 创建
	 *
	 * @param record
	 * @return
	 */
	public int create(APPBinding record);

    /**
	 * 更新
	 *
	 * @param record
	 * @return
	 */
	public int update(APPBinding record);

    /**
	 * 删除
	 *
	 * @param id
	 * @return
	 */
	public int remove(Long id);
}
