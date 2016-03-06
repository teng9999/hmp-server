/**
 * 
 */
package cn.pl.hmp.server.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.pl.commons.datasource.DataSource;
import cn.pl.commons.datasource.RoutingContextHolder;

/**
 * 数据源切面
 * 
 * @author alanyuan
 * 
 */
public class DataSourceAspect {
    private Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    public void pointCut() {
    };

    public void before(JoinPoint point) {
        Object target = point.getTarget();
        logger.debug("DataSourceAspect Cut: {}", target.toString());
        String method = point.getSignature().getName();
        // logger.debug("DataSourceAspect Method: {}", method);
        Class<?>[] classz = target.getClass().getInterfaces();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m != null) {
                logger.debug("DataSourceAspect Method[{}]: ", m.getName());
                for (Annotation a : m.getAnnotations()) {
                    logger.debug("Annotation: {}", a.getClass().getSimpleName());
                }
            }
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource data = m.getAnnotation(DataSource.class);
                RoutingContextHolder.setContext(data.value());
                logger.debug("DataSourceAspect Routing [{}]", data.value());
            }

        } catch (Exception e) {
            logger.error("Join Point Error.", e);
        }
    }

}
