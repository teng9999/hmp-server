/*
 * SpringContext.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.context;

import cn.pl.hmp.server.global.SpringContextInitializationLock;
import cn.pl.hmp.server.utils.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Spring上下文注入
 *
 * @author alanyuan
 */
@Component
public class SpringContext extends Context implements InitializingBean, DisposableBean, ApplicationContextAware {
    
    /**
     *
     */
    private static final long  serialVersionUID = 3145625627240417248L;
    private static Logger      logger           = LoggerFactory.getLogger(SpringContext.class);
    private ApplicationContext context;
                               
    public SpringContext() {
        super();
        boolean lock = SpringContextInitializationLock.lock();
        while (!lock) {
            if (SpringContextInitializationLock.isOk())
                break;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    /*
     * (non-Javadoc)
     * @see
     * org.springframework.context.ApplicationContextAware#setApplicationContext
     * (org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }
    
    @Override
    public void destroy() throws Exception {
        SpringContextUtil.setApplicationContext(null);
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        if (!SpringContextInitializationLock.isOk()) {
            SpringContextUtil.setApplicationContext(context);
            SpringContextInitializationLock.unlock();
        } else {
            logger.info("Spring Context Init Complete");
        }
    }
    
}
