/*
 * ThriftConfHelper.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.utils;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer.AbstractServerArgs;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.pl.commons.utils.NetUtil;
import cn.pl.hmp.server.config.Property;
import cn.pl.hmp.server.config.ServerConfig;
import cn.pl.hmp.server.config.ThriftConf;

/**
 * Thrift配置Helper
 *
 * @author alanyuan
 */
public class ThriftConfHelper {
    private static Logger logger = LoggerFactory.getLogger(ThriftConfHelper.class);

    /**
     * 构建配置
     *
     * @param conf
     * @param properties
     * @throws Exception
     */
    public static void buildConf(ThriftConf conf, Hashtable<String, Property> properties) throws Exception {
        if (check(conf)) {
            if (properties != null && properties.containsKey(ServerConfig.PROPERTY_THRIFT_SERVER_NODENAME)) {
                Property p = properties.get(ServerConfig.PROPERTY_THRIFT_SERVER_NODENAME);
                if (p.getValue() != null)
                    conf.setName(p.getString());
            }
            if (properties != null && properties.containsKey(ServerConfig.PROPERTY_THRIFT_SERVER_IP)) {
                Property p = properties.get(ServerConfig.PROPERTY_THRIFT_SERVER_IP);
                if (p.getValue() != null)
                    conf.setHost(p.getString());
            }
            if (properties != null && properties.containsKey(ServerConfig.PROPERTY_THRIFT_SERVER_PORT)) {
                Property p = properties.get(ServerConfig.PROPERTY_THRIFT_SERVER_PORT);
                if (p.getValue() != null)
                    conf.setPort(p.getInt());
            }
            if (properties != null && properties.containsKey(ServerConfig.PROPERTY_THRIFT_SERVER_TIMEOUT)) {
                Property p = properties.get(ServerConfig.PROPERTY_THRIFT_SERVER_TIMEOUT);
                if (p.getValue() != null)
                    conf.setTimeout(p.getInt());
            }
            conf.setSocketAddress(NetUtil.getInetSocketAddress(conf.getHost(), conf.getPort()));
            conf.setProcessor(BeanUtil.createProcessor(conf.getProcessorClass()));
            conf.setProtocolFactory(BeanUtil.createProtocolFactory(conf.getProtocolFactoryClass()));

            conf.setServerTransport(BeanUtil.createServerTransport(conf.getServerTransportClass(),
                    conf.getSocketAddress(), conf.getTimeout()));

            conf.setServerArgs(BeanUtil.createServerArgs(conf.getServerArgsClass(), conf.getServerTransport()));
            AbstractServerArgs<?> args = conf.getServerArgs();
            if (args != null) {
                args.processor(conf.getProcessor());
                args.protocolFactory(conf.getProtocolFactory());
                if (conf.getServerClass().equalsIgnoreCase(ServerConfig.DEFAULT_SERVER_CLASS)
                        || conf.getServerClass().equalsIgnoreCase(ServerConfig.HSHA_SERVER_CLASS)) {
                    args.transportFactory(new TFramedTransport.Factory(conf.getMaxReadBufferBytes()));

                    if (args instanceof TThreadedSelectorServer.Args) {
                        ((TThreadedSelectorServer.Args) args).maxReadBufferBytes = conf.getMaxReadBufferBytes();
                        if (properties != null
                                && properties.containsKey(ServerConfig.PROPERTY_THRIFT_SERVER_SELECTOR_THREADS)) {
                            Property p = properties.get(ServerConfig.PROPERTY_THRIFT_SERVER_SELECTOR_THREADS);
                            if (p.getValue() != null) {
                                ((TThreadedSelectorServer.Args) args).selectorThreads(p.getInt());
                            }
                        }
                        if (properties != null
                                && properties.containsKey(ServerConfig.PROPERTY_THRIFT_SERVER_WORK_THREADS)) {
                            Property p = properties.get(ServerConfig.PROPERTY_THRIFT_SERVER_WORK_THREADS);
                            if (p.getValue() != null) {
                                ((TThreadedSelectorServer.Args) args).workerThreads(p.getInt());
                            }
                        }
                        if (properties != null && properties
                                .containsKey(ServerConfig.PROPERTY_THRIFT_SERVER_ACCEPT_QUEUE_SIZE_PER_THREAD)) {
                            Property p = properties
                                    .get(ServerConfig.PROPERTY_THRIFT_SERVER_ACCEPT_QUEUE_SIZE_PER_THREAD);
                            if (p.getValue() != null) {
                                ((TThreadedSelectorServer.Args) args).acceptQueueSizePerThread(p.getInt());
                            }
                        }
                        if (properties != null
                                && properties.containsKey(ServerConfig.PROPERTY_THRIFT_SERVER_STOP_TIMEOUT_UNIT)) {
                            Property p = properties.get(ServerConfig.PROPERTY_THRIFT_SERVER_STOP_TIMEOUT_UNIT);
                            if (p.getValue() != null) {
                                ((TThreadedSelectorServer.Args) args).stopTimeoutUnit(TimeUnit.valueOf(p.getString()));
                            }
                        }
                        if (properties != null
                                && properties.containsKey(ServerConfig.PROPERTY_THRIFT_SERVER_STOP_TIMEOUT_VAL)) {
                            Property p = properties.get(ServerConfig.PROPERTY_THRIFT_SERVER_STOP_TIMEOUT_VAL);
                            if (p.getValue() != null) {
                                ((TThreadedSelectorServer.Args) args).stopTimeoutVal(p.getInt());
                            }
                        }
                    } else
                        BeanUtils.setProperty(args, "maxReadBufferBytes", conf.getMaxReadBufferBytes());
                }
                conf.setServer(BeanUtil.createServer(conf.getServerClass(), args));
            }
            if (conf.getProcessor() != null
                    && TMultiplexedProcessor.class.isAssignableFrom(conf.getProcessor().getClass())) {
                logger.info("Processor[TMultiplexedProcessor] Register the Interfaces...");
                TMultiplexedProcessor muliProcessor = (TMultiplexedProcessor) (conf.getProcessor());
                if (conf.getInterfaces() != null) {
                    for (String name : conf.getInterfaces().keySet()) {
                        TProcessor p = conf.getInterfaces().get(name);
                        muliProcessor.registerProcessor(name, p);
                        logger.info("Register Processor Interface[{}] OK", name);
                    }
                }
            } else if (conf.getProcessor() != null) {
                logger.error("Unsupport {}", conf.getProcessor().getClass());
            } else {
                logger.error("Processor Undefined");
            }
        }
    }

    private static boolean check(ThriftConf conf) {
        if (conf == null) {
            logger.error("Thrift Config Error: {}", conf);
            return false;
        } else if (conf.getServerClass() == null) {
            logger.error("Thrift Config Error: Server Class Undefined");
            return false;
        } else if (conf.getServerArgsClass() == null) {
            logger.error("Thrift Config Error: Server Args Class Undefined");
            return false;
        } else if (conf.getServerTransportClass() == null) {
            logger.error("Thrift Config Error: Server Transport Class Undefined");
            return false;
        } else if (conf.getProtocolFactoryClass() == null) {
            logger.error("Thrift Config Error: Protocol Factory Class Undefined");
            return false;
        } else if (conf.getProcessorClass() == null) {
            logger.error("Thrift Config Error: Processor Class Undefined");
            return false;
        }
        return true;
    }
}
