/**
 * 
 */
package cn.pl.hmp.server.business.iface;

/**
 * 系统增强接口
 * 
 * @author alanyuan
 * 
 */
public interface IBoostBusiness {
    /**
	 * 前置增强逻辑
	 * @param param
	 */
	public Object before(Object param);

    /**
	 * 后置增强逻辑
	 * @param param
	 */
	public Object after(Object param);

    /**
	 * 
	 * @param param
	 * @return
	 */
	public Object around(Object param);
}
