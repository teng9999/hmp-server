/**
 * 
 */
package cn.pl.hmp.server.business.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.pl.hmp.server.business.AbstractBusiness;
import cn.pl.hmp.server.business.iface.IBoostBusiness;

/**
 * 增强业务逻辑
 * 
 * @author alanyuan
 * 
 */
@Service
public class BoostBusinessImpl extends AbstractBusiness implements IBoostBusiness {
    private Logger logger = LoggerFactory.getLogger(BoostBusinessImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see cn.pl.hmp.server.business.IBoostBusiness#booster(java.lang.Object)
     */
    @Override
    public Object before(Object param) {
        logger.debug("Boost Before...");
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.pl.hmp.server.business.IBoostBusiness#after(java.lang.Object)
     */
    @Override
    public Object after(Object param) {
        logger.debug("Boost After...");
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.pl.hmp.server.business.IBoostBusiness#around(java.lang.Object)
     */
    @Override
    public Object around(Object param) {
        logger.debug("Boost Around...");
        return null;
    }

}
