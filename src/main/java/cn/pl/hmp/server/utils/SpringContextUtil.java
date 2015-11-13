/*
 * SpringContextUtil.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.Assert;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.pl.hmp.commons.global.GlobalConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * Spring上下文
 *
 * @author alanyuan
 */
public class SpringContextUtil {
    private static ApplicationContext applicationContext;
    private static MapperFactory      mapperFactory = MapperFactory.getInstance();
                                                    
    public synchronized static ApplicationContext getApplicationContextByRequest(HttpServletRequest request) {
        if (applicationContext == null) {
            ApplicationContext ac = WebApplicationContextUtils
                    .getRequiredWebApplicationContext(request.getSession().getServletContext());
            return ac;
        } else {
            return applicationContext;
        }
        
    }
    
    public synchronized static ApplicationContext getApplicationContextByXmlFile(String xmlFilePath) {
        if (applicationContext == null) {
            ApplicationContext ac = new FileSystemXmlApplicationContext(xmlFilePath);
            return ac;
        } else {
            return applicationContext;
        }
    }
    
    public synchronized static ApplicationContext getApplicationContextByClassPath(String classPath) {
        if (applicationContext == null) {
            ApplicationContext ac = new ClassPathXmlApplicationContext(classPath);
            return ac;
        } else {
            return applicationContext;
        }
    }
    
    /**
     * @return the applicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    
    public synchronized static void setApplicationContext(ApplicationContext ac) {
        applicationContext = ac;
        SqlSessionFactory hmpFactory = getBean(GlobalConstants.HMP_SQLSESSIONFACTORY, SqlSessionFactory.class);
        mapperFactory.addSessionFactory(GlobalConstants.HMP_SQLSESSIONFACTORY, hmpFactory);
        SqlSessionFactory irsFactory = getBean(GlobalConstants.OLD_SQLSESSIONFACTORY, SqlSessionFactory.class);
        mapperFactory.addSessionFactory(GlobalConstants.OLD_SQLSESSIONFACTORY, irsFactory);
    }
    
    /**
     * @return the mapperFactory
     */
    public static MapperFactory getMapperFactory() {
        return mapperFactory;
    }
    
    /**
     * 获取对象
     *
     * @param beanName
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     */
    @SuppressWarnings( "unchecked" )
    public static <X> X getBean(String beanName) {
        Assert.notNull(applicationContext, "请先通过SpringUtil.setApplicationContext方法设置applicationContext");
        return (X) applicationContext.getBean(beanName);
    }
    
    /**
     * 获取类型为requiredType的对象
     * 如果bean不能被类型转换，相应的异常将会被抛出（BeanNotOfRequiredTypeException）
     *
     * @param beanName
     *            bean注册名
     * @param requiredType
     *            返回对象类型
     * @return Object 返回requiredType类型对象
     * @throws BeansException
     */
    public static <X> X getBean(String beanName, Class<X> requiredType) {
        Assert.notNull(applicationContext, "请先通过SpringUtil.setApplicationContext方法设置applicationContext");
        return applicationContext.getBean(beanName, requiredType);
    }
    
    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     *
     * @param beanName
     * @return boolean
     */
    public static boolean containsBean(String beanName) {
        return applicationContext.containsBean(beanName);
    }
    
    /**
     * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     *
     * @param beanName
     * @return boolean
     * @throws NoSuchBeanDefinitionException
     */
    public static boolean isSingleton(String beanName) throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(beanName);
    }
    
    /**
     * @param beanName
     * @return Class 注册对象的类型
     * @throws NoSuchBeanDefinitionException
     */
    public static Class<?> getType(String beanName) throws NoSuchBeanDefinitionException {
        return applicationContext.getType(beanName);
    }
    
    /**
     * 如果给定的bean名字在bean定义中有别名，则返回这些别名
     *
     * @param beanName
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    public static String[] getAliases(String beanName) throws NoSuchBeanDefinitionException {
        return applicationContext.getAliases(beanName);
    }
    
    /**
     * 获取SqlSessionFactory
     *
     * @param sessionFactoryId
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory(String sessionFactoryId) {
        return mapperFactory.getSessionFactory(sessionFactoryId);
    }
    
    /**
     * 获取Mapper
     *
     * @param sessionFactoryId
     * @param beanType
     * @return
     */
    public static <X> X getMapper(String sessionFactoryId, Class<X> beanType) {
        return mapperFactory.getMapper(sessionFactoryId, beanType);
    }
    
    /**
     * 获取Session
     *
     * @param factoryId
     * @return
     */
    public SqlSession getSession(String factoryId) {
        return mapperFactory.getSession(factoryId);
    }
    
    /**
     * 关闭Session
     *
     * @param factoryId
     * @param session
     */
    public void closeSession(String factoryId, SqlSession session) {
        mapperFactory.closeSession(factoryId, session);
    }
}
