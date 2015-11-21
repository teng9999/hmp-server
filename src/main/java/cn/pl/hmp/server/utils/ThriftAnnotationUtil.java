/*
 * ThriftAnnotationUtil.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.utils;

import cn.pl.frame.annotation.ThriftService;
import cn.pl.hmp.server.config.Env;
import cn.pl.hmp.server.config.ThriftConf;
import cn.pl.hmp.server.exception.ConfigException;
import cn.pl.hmp.server.global.ThriftServiceInitializationLock;
import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Thrift相关注解工具 此工具不用调用，将会被Spring上下文初始化时自动执行
 *
 * @author alanyuan
 */
@Component
public class ThriftAnnotationUtil implements InitializingBean, DisposableBean, ApplicationContextAware {
    private static Logger      logger = LoggerFactory.getLogger(ThriftAnnotationUtil.class);
    private ApplicationContext springContext;
                               
    public ThriftAnnotationUtil() {
        super();
        boolean lock = ThriftServiceInitializationLock.lock();
        while (!lock) {
            if (ThriftServiceInitializationLock.isOk())
                break;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void setApplicationContext(ApplicationContext springContext) throws BeansException {
        this.springContext = springContext;
    }
    
    @Override
    public void destroy() throws Exception {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        if (!ThriftServiceInitializationLock.isOk()) {
            ThriftConf conf = Env.getConfig().getThriftConf();
            TMultiplexedProcessor muliProcessor = (TMultiplexedProcessor) (conf.getProcessor());
            scan(muliProcessor);
            ThriftServiceInitializationLock.unlock();
        } else {
            logger.info("Spring Scan Annotation Complete");
        }
    }
    
    /**
     * 扫描ThriftService注解自动注册Iface，依赖于Srping上下文
     *
     * @param muliProcessor
     * @throws ConfigException
     */
    private void scan(TMultiplexedProcessor muliProcessor) throws ConfigException {
        if (muliProcessor == null || springContext == null)
            return;
        Map<String, Object> thriftMap = springContext.getBeansWithAnnotation(ThriftService.class);
        if (null != thriftMap && !thriftMap.isEmpty()) {
            logger.info("Spring Scan Annotation. Processor[TMultiplexedProcessor] Register the Interfaces...");
            for (String key : thriftMap.keySet()) {
                Object obj = thriftMap.get(key);
                ThriftService thriftServer = obj.getClass().getAnnotation(ThriftService.class);
                String ifaceName = StringUtils.isNotBlank(thriftServer.name()) ? thriftServer.name() : key;
                Class<?> clazz = thriftServer.processor();
                if (TProcessor.class.isAssignableFrom(clazz)) {
                    Object processor = BeanUtils.instantiateClass(clazz.getConstructors()[0], obj);
                    muliProcessor.registerProcessor(ifaceName, (TProcessor) processor);
                    logger.info("Register Processor Interface[{}] OK", ifaceName);
                } else {
                    Class<?>[] interfaces = obj.getClass().getInterfaces();
                    if (interfaces.length == 0) {
                        logger.warn("Register Processor Interface[{}] Implements is Null, Skip", ifaceName);
                    } else {
                        for (Class<?> iface : interfaces) {
                            String cname = iface.getSimpleName();
                            if (StringUtils.isNotBlank(cname) && (cname.equals("Iface") || cname.equals("AsyncIface"))) {
                                String pname = iface.getEnclosingClass().getName() + "$Processor";
                                Class<?> pclass;
                                try {
                                    pclass = springContext.getClassLoader().loadClass(pname);
                                    
                                    if (TProcessor.class.isAssignableFrom(pclass)) {
                                        Object processor = BeanUtils.instantiateClass(pclass.getConstructor(iface),
                                                obj);
                                        muliProcessor.registerProcessor(ifaceName, (TProcessor) processor);
                                        logger.info("Register Processor Interface[{}] OK", ifaceName);
                                    } else {
                                        logger.warn("Register Processor Interface[{}] type error", ifaceName);
                                    }
                                } catch (ClassNotFoundException | BeanInstantiationException | NoSuchMethodException
                                        | SecurityException e) {
                                    logger.error("Register Processor Interface[{}] Error", pname);
                                    throw new ConfigException(e);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
}
