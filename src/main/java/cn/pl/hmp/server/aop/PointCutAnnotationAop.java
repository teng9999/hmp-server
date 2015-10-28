/*
 * PointCutAnnotationAop.java Copyright Bejing Passion Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

/**
 * 切面拦截注解注入
 *
 * @author alanyuan
 */
@Order( 1 )
@Aspect
public class PointCutAnnotationAop {
    private Logger logger = LoggerFactory.getLogger(PointCutAnnotationAop.class);
    
    /**
     * 前置增强逻辑注解
     */
    @Pointcut( "execution(public Object cn.pl.hmp.server.business.impl.BoostBusinessImpl.before(..))" )
    private void boostBefore() {
    }
    
    /**
     * 后置增强逻辑注解
     */
    @Pointcut( "execution(public Object cn.pl.hmp.server.business.impl.BoostBusinessImpl.after(..))" )
    private void boostAfter() {
    }
    
    /**
     * 包围增强逻辑注解
     */
    @Pointcut( "execution(public Object cn.pl.hmp.server.business.impl.BoostBusinessImpl.around(..))" )
    private void boostAround() {
    }
    
    /**
     * 业务逻辑通用拦截注解 匹配 cn.pl.hmp.server.*.business 包下所有类的所有方法作为切入点
     */
    @Pointcut( "execution(* cn.pl.hmp.server.*.business..*.*(..))" )
    private void ptbasic() {
    }
    
    /**
     * ptbasic()前置
     */
    @Before( "PointCutAnnotationAop.ptbasic()" )
    public void allBefore() {
        logger.debug("PointCutAnnotationAop Before Business");
    }
    
    /**
     * ptbasic()异常处理
     * 
     * @param ex
     */
    @AfterThrowing( throwing = "ex", pointcut = "PointCutAnnotationAop.ptbasic()" )
    public void doRecoverActions(Throwable ex) {
        logger.error("PointCutAnnotationAop Recover Actions Error", ex);
    }
    
    /**
     * boostBefore()前置
     * 
     * @param jp
     */
    @Before( "PointCutAnnotationAop.boostBefore()" )
    public void annotationbefore(JoinPoint jp) {
        logger.debug("PointCutAnnotationAop Annotation Before Business");
    }
    
    /**
     * boostAfter()后置
     * 
     * @param jp
     */
    @After( "PointCutAnnotationAop.boostAfter()" )
    public void annotationafter(JoinPoint jp) {
        logger.debug("PointCutAnnotationAop Annotation After Business");
    }
    
    /**
     * boostAfter()后置返回值处理
     * 
     * @param jp
     * @param returnValue
     */
    @AfterReturning( value = "PointCutAnnotationAop.boostAfter()", returning = "returnValue" )
    public void annotationAfterReturning(JoinPoint jp, Object returnValue) {
        logger.debug("PointCutAnnotationAop Annotation After Business Return [{}]", returnValue);
    }
    
    /**
     * boostAround()包围
     * 
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around( "PointCutAnnotationAop.boostAround()" )
    public Object annotationaround(ProceedingJoinPoint pjp) throws Throwable {
        logger.debug("PointCutAnnotationAop Annotation Around Business Before");
        Object[] args = pjp.getArgs();
        Object obj = pjp.proceed(args);
        
        logger.debug("PointCutAnnotationAop Annotation Around Business After");
        return Integer.parseInt("100" + obj.toString());
    }
}
