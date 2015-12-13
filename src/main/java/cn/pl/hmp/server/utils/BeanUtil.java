/*
 * BeanUtil.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights Reserved.
 */
package cn.pl.hmp.server.utils;

import java.lang.reflect.Constructor;
import java.net.InetSocketAddress;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.AbstractServerArgs;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.pl.commons.utils.StringUtils;
import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.spring.zk.register.IZooKeeperRegister;
import cn.pl.hmp.server.config.ServerConfig;
import cn.pl.hmp.server.config.ThriftConf;

/**
 * Bean工具
 *
 * @author alanyuan
 */
public class BeanUtil {
    private static Logger logger = LoggerFactory.getLogger(BeanUtil.class);

    /**
     * 获取Class
     *
     * @param className
     * @return
     * @throws Exception
     */
    public static Class<?> getClass(String className) throws Exception {
        if (StringUtils.isBlank(className))
            return null;
        Class<?> clazz = Class.forName(className);

        return clazz;
    }

    /**
     * 获取实例
     *
     * @param className
     * @return
     * @throws Exception
     */
    public static Object getObject(String className) throws Exception {
        if (StringUtils.isBlank(className))
            return null;
        Class<?> clazz = Class.forName(className);
        if (clazz != null)
            return clazz.newInstance();
        else
            return null;
    }

    /**
     * 创建Bean实例
     *
     * @param ctor
     * @param args
     * @return
     * @throws Exception
     */
    public static <X> X createBean(Constructor<X> ctor, Object... args) throws Exception {
        if (ctor == null)
            return null;
        X x = null;
        x = ctor.newInstance(args);

        return x;
    }

    /**
     * 生成Thrift处理器
     *
     * @param className
     * @return
     * @throws Exception
     */
    public static TProcessor createProcessor(String className) throws Exception {
        if (StringUtils.isBlank(className))
            return null;
        TProcessor processor = null;
        processor = (TProcessor) Class.forName(className).newInstance();

        return processor;
    }

    /**
     * 生成Thrift协议工厂
     *
     * @param className
     * @return
     * @throws Exception
     */
    public static TProtocolFactory createProtocolFactory(String className) throws Exception {
        if (StringUtils.isBlank(className))
            return null;
        TProtocolFactory factory = null;
        factory = (TProtocolFactory) Class.forName(className).newInstance();

        return factory;
    }

    /**
     * 生成Thrift服务传输配置
     *
     * @param className
     * @param addr
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static TServerTransport createServerTransport(String className, InetSocketAddress addr, int clientTimeout)
            throws Exception {
        if (StringUtils.isBlank(className) || addr == null)
            return null;
        TServerTransport serverTransport = null;
        Class<TServerTransport> clazz = (Class<TServerTransport>) Class.forName(className);
        Constructor<TServerTransport> clazz1 = clazz.getDeclaredConstructor(InetSocketAddress.class, int.class);
        int timeout = clientTimeout;
        if (timeout <= 0)
            timeout = ServerConfig.DEFAULT_TRANSPORT_TIMEOUT;
        serverTransport = clazz1.newInstance(addr, timeout);

        return serverTransport;
    }

    /**
     * 生成Thrift服务参数
     *
     * @param className
     * @param transport
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static AbstractServerArgs<?> createServerArgs(String className, TServerTransport transport)
            throws Exception {
        if (StringUtils.isBlank(className) || transport == null)
            return null;
        AbstractServerArgs<?> server = null;
        Class<AbstractServerArgs<?>> clazz = (Class<AbstractServerArgs<?>>) Class.forName(className);
        Constructor<AbstractServerArgs<?>> clazz1 = null;
        // Thrift接口写的太特殊了，枚举判断实例的Class
        if (clazz.getClass().isInstance(TThreadedSelectorServer.Args.class))
            clazz1 = clazz.getDeclaredConstructor(TNonblockingServerTransport.class);
        else
            clazz1 = clazz.getDeclaredConstructor(TServerTransport.class);
        server = clazz1.newInstance(transport);

        return server;
    }

    /**
     * 生成Thrift服务
     *
     * @param className
     * @param transport
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static TServer createServer(String className, AbstractServerArgs<?> args) throws Exception {
        if (StringUtils.isBlank(className) || args == null)
            return null;
        TServer server = null;
        Class<TServer> clazz = (Class<TServer>) Class.forName(className);
        Constructor<TServer> clazz1 = null;
        clazz1 = clazz.getDeclaredConstructor(args.getClass());
        server = clazz1.newInstance(args);

        return server;
    }

    /**
     * 生成ZooKeeper注册器
     *
     * @param className
     * @return
     * @throws Exception
     */
    public static IZooKeeperRegister createZooKeeperRegister(String className) throws Exception {
        if (StringUtils.isBlank(className))
            return null;
        IZooKeeperRegister register = null;
        register = (IZooKeeperRegister) Class.forName(className).newInstance();

        return register;
    }

    /**
     * 装载Processer的接口实现实例
     *
     * @param className
     * @param thriftConf
     */
    public static void loadInterfaces(String className, ThriftConf thriftConf) {
        if (StringUtils.isBlank(className) || thriftConf == null)
            return;
        Object obj;
        try {
            obj = getObject(className);

            if (obj.getClass().isAnnotationPresent(ThriftService.class)) {
                ThriftService service = obj.getClass().getAnnotation(ThriftService.class);
                String serviceName = StringUtils.isNotBlank(service.name()) ? service.name()
                        : obj.getClass().getSimpleName();
                Class<?> pClazz = service.processor();
                if (TProcessor.class.isAssignableFrom(pClazz)) {
                    thriftConf.setInterface(serviceName,
                            (TProcessor) (BeanUtil.createBean(pClazz.getConstructors()[0], obj)));

                } else {
                    Class<?>[] interfaces = obj.getClass().getInterfaces();
                    if (interfaces.length == 0) {
                        logger.warn("Service {} Implements Iface", serviceName);
                    } else {
                        for (Class<?> iface : interfaces) {
                            String cname = iface.getSimpleName();
                            if (StringUtils.isNotBlank(cname)
                                    && (cname.equals("Iface") || cname.equals("AsyncIface"))) {
                                String pname = iface.getEnclosingClass().getName() + "$Processor";
                                Class<?> pclass = ServerConfig.class.getClassLoader().loadClass(pname);
                                if (TProcessor.class.isAssignableFrom(pclass)) {
                                    thriftConf.setInterface(serviceName,
                                            (TProcessor) (BeanUtil.createBean(pclass.getConstructor(iface), obj)));
                                } else {
                                    logger.warn("Service {} Type Error", serviceName);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Load Thrift Processor Interface[{}] Fail.", className);
        }
    }
}
