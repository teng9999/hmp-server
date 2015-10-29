/*
 * ServerConfig.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights Reserved.
 */
package cn.pl.hmp.server.config;

import cn.pl.commons.utils.StringUtils;
import cn.pl.commons.utils.XmlValidateUtil;
import cn.pl.hmp.server.core.service.BaseServer;
import cn.pl.hmp.server.exception.ConfigException;
import cn.pl.hmp.server.utils.BeanUtil;
import cn.pl.hmp.server.utils.ThriftConfHelper;
import cn.pl.hmp.server.utils.ZooKeeperConfHelper;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * 服务环境配置
 *
 * @author alanyuan
 */
public class ServerConfig {
    /**
     * 缺省服务配置文件
     */
    public static final String          SERVER_CONF                                         = "/server.cfg.xml";
    /**
     * 缺省服务配置验证文件
     */
    public static final String          SERVER_CONF_XSD                                     = "/hmp-server-cfg-1.0.xsd";
    /**
     * 缺省服务名
     */
    public static final String          DEFAULT_NAME                                        = "HMP Server";
    /**
     * 缺省Thrift服务类
     */
    public static final String          DEFAULT_SERVER_CLASS                                = "org.apache.thrift.server.TThreadedSelectorServer";
    /**
     * 缺省Thrift服务类
     */
    public static final String          HSHA_SERVER_CLASS                                   = "org.apache.thrift.server.THsHaServer";
    /**
     * 缺省Thrift服务参数类
     */
    public static final String          DEFAULT_SERVER_ARGS_CLASS                           = "org.apache.thrift.server.TThreadedSelectorServer.Args";
    /**
     * 缺省Thrift传输类
     */
    public static final String          DEFAULT_SERVER_TRANSPORT_CLASS                      = "org.apache.thrift.transport.TNonblockingServerTransport";
    /**
     * 缺省Thrift协议类
     */
    public static final String          DEFAULT_PROTOCOL_FACTORY_CLASS                      = "org.apache.thrift.protocol.TCompactProtocol.Factory";
    /**
     * 缺省Thrift处理器类
     */
    public static final String          DEFAULT_PROCESSOR_CLASS                             = "org.apache.thrift.TMultiplexedProcessor";
    /**
     * 缺省Thrift传输超时
     */
    public static final int             DEFAULT_TRANSPORT_TIMEOUT                           = 1000;
    /**
     * 缺省ZooKeeper注册器类
     */
    public static final String          DEFAULT_ZOOKEEPER_REGISTER_CLASS                    = "cn.pl.hmp.server.zk.BaseZooKeeperRegister";
    /**
     * 缺省Thrift服务接口类
     */
    public static final String          DEFAULT_THRIFT_IFACE_ANNOTATION_CLASS               = "cn.pl.frame.annotation.ThriftService";
    // 属性名常量
    public static final String          PROPERTY_THRIFT_SERVER_NODENAME                     = "thrift.server.nodename";
    public static final String          PROPERTY_THRIFT_SERVER_IP                           = "thrift.server.ip";
    public static final String          PROPERTY_THRIFT_SERVER_PORT                         = "thrift.server.port";
    public static final String          PROPERTY_THRIFT_SERVER_TIMEOUT                      = "thrift.server.timeout";
    public static final String          PROPERTY_THRIFT_SERVER_READBUFFER                   = "thrift.server.readbuffer";
    public static final String          PROPERTY_THRIFT_SERVER_SELECTOR_THREADS             = "thrift.server.selector.threads";
    public static final String          PROPERTY_THRIFT_SERVER_WORK_THREADS                 = "thrift.server.work.threads";
    public static final String          PROPERTY_THRIFT_SERVER_ACCEPT_QUEUE_SIZE_PER_THREAD = "thrift.server.accept.queue.size.per.thread";
    public static final String          PROPERTY_THRIFT_SERVER_STOP_TIMEOUT_UNIT            = "thrift.server.stop.timeout.unit";
    public static final String          PROPERTY_THRIFT_SERVER_STOP_TIMEOUT_VAL             = "thrift.server.stop.timeout.val";
    public static final String          PROPERTY_ZOOKEEPER_ENS_IP                           = "zookeeper.ens.ip";
    public static final String          PROPERTY_ZOOKEEPER_ENS_ENABLE                       = "zookeeper.ens.enable";
    // 配置文件节点名常量
    public static final String          ROOT_NODE                                           = "hmp-server";
    public static final String          SETTING                                             = "setting";
    public static final String          PROPERTIES_NODE                                     = "properties";
    public static final String          PROPERTIE                                           = "property";
    public static final String          THRIFT_NODE                                         = "thrift";
    public static final String          SERVER                                              = "server";
    public static final String          SERVER_ARGS                                         = "server-args";
    public static final String          SERVER_TRANSPORT                                    = "server-transport";
    public static final String          PROTOCOL_FACTORY                                    = "protocol-factory";
    public static final String          PROCESSOR                                           = "processor";
    public static final String          PROCESSOR_IFACE                                     = "processor-iface";
    public static final String          IFACE                                               = "iface";
    public static final String          ZK_NODE                                             = "zookeeper";
    public static final String          ZK_REGISTER                                         = "register";
    private static Logger               logger                                              = LoggerFactory
            .getLogger(ServerConfig.class);
    private Hashtable<String, Property> properties                                          = new Hashtable<String, Property>();
                                                                                            
    /**
     * SERVER配置文件
     */
    private String                      serverFile                                          = SERVER_CONF;
    /**
     * SERVER配置验证文件
     */
    private String                      serverXsd                                           = SERVER_CONF_XSD;
    /**
     * 输入流
     */
    private InputStream                 input                                               = null;
    /**
     * xsd输入流
     */
    private InputStream                 xsdInput                                            = null;
    /**
     * 服务名
     */
    private String                      serverName                                          = DEFAULT_NAME;
    private int                         corePoolSize                                        = 50;
    private int                         maxPoolSize                                         = 50;
    private long                        keepAliveTime                                       = 5;
    private TimeUnit                    timeUnit                                            = TimeUnit.SECONDS;
    private int                         workQueueSize                                       = 100000;
    private int                         callQueueSize                                       = 100000;
    private int                         taskTimeout                                         = 5;
                                                                                            
    /**
     * Thrift配置
     */
    private ThriftConf                  thriftConf                                          = new ThriftConf();
    /**
     * ZooKeeper配置
     */
    private ZooKeeperConf               zookeeperConf                                       = new ZooKeeperConf();
                                                                                            
    public ServerConfig() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public ServerConfig(String serverFile) {
        super();
        this.serverFile = serverFile;
    }
    
    /**
     * @return the properties
     */
    public Hashtable<String, Property> getProperties() {
        return properties;
    }
    
    /**
     * @return the serverFile
     */
    public String getServerFile() {
        return serverFile;
    }
    
    /**
     * @return the serverName
     */
    public String getServerName() {
        return serverName;
    }
    
    /**
     * @return the corePoolSize
     */
    public int getCorePoolSize() {
        return corePoolSize;
    }
    
    /**
     * @return the maxPoolSize
     */
    public int getMaxPoolSize() {
        return maxPoolSize;
    }
    
    /**
     * @return the keepAliveTime
     */
    public long getKeepAliveTime() {
        return keepAliveTime;
    }
    
    /**
     * @return the timeUnit
     */
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
    
    /**
     * @return the workQueueSize
     */
    public int getWorkQueueSize() {
        return workQueueSize;
    }
    
    /**
     * @return the callQueueSize
     */
    public int getCallQueueSize() {
        return callQueueSize;
    }
    
    /**
     * @return the taskTimeout
     */
    public int getTaskTimeout() {
        return taskTimeout;
    }
    
    /**
     * @return the thriftConf
     */
    public ThriftConf getThriftConf() {
        return thriftConf;
    }
    
    /**
     * @return the zookeeperConf
     */
    public ZooKeeperConf getZookeeperConf() {
        return zookeeperConf;
    }
    
    /**
     * 装载初始化
     *
     * @throws ConfigException
     */
    public void load() throws ConfigException {
        init();
    }
    
    /**
     * 初始化
     */
    protected void init() throws ConfigException {
        try {
            // 构建配置文件输入流
            buildStream();
            // 校验xml格式
            XmlValidateUtil.validate(input, xsdInput);
            
            buildStream();
            xsdInput.close();
            SAXReader reader = new SAXReader();
            Document document = reader.read(input);
            Element root = document.getRootElement();
            
            // 初始化服务配置
            initServer(root);
            // 初始化属性配置
            initProperties(root);
            // 初始化Thrift配置
            initThrift(root);
            // 初始化ZK配置
            initZooKeeper(root);
            
            logger.debug(thriftConf.toString());
            ThriftConfHelper.buildConf(thriftConf, properties);
            logger.debug(thriftConf.toString());
            
            logger.debug(zookeeperConf.toString());
            ZooKeeperConfHelper.buildConf(zookeeperConf, properties);
            logger.debug(zookeeperConf.toString());
        } catch (Exception _ex) {
            logger.error("Configuration initialize error:", _ex);
            throw new ConfigException("Configuration initialize error:", _ex);
        }
    }
    
    /**
     * build stream by connection configure
     */
    protected void buildStream() throws ConfigException {
        input = ServerConfig.class.getResourceAsStream(serverFile);
        if (input == null) {
            input = Thread.currentThread().getContextClassLoader().getResourceAsStream(serverFile);
        }
        if (input == null) {
            throw new ConfigException("Can't find the file:" + serverFile);
        }
        
        xsdInput = ServerConfig.class.getResourceAsStream(serverXsd);
        if (xsdInput == null) {
            xsdInput = Thread.currentThread().getContextClassLoader().getResourceAsStream(serverXsd);
        }
        if (xsdInput == null) {
            throw new ConfigException("Can't find the file:" + serverXsd);
        }
    }
    
    /**
     * 初始化属性配置
     *
     * @throws ConfigException
     */
    @SuppressWarnings( "unchecked" )
    private void initServer(Element root) throws ConfigException {
        if (!root.getName().equalsIgnoreCase(ROOT_NODE))
            return;
        serverName = root.attributeValue("name");
        if (StringUtils.isBlank(serverName))
            serverName = DEFAULT_NAME;
            
        for (Iterator<Element> it = root.elementIterator(SETTING); it.hasNext();) {
            Element node = it.next();
            
            Element element = node.element("core-pool-size");
            if (element == null || StringUtils.isBlank(element.getTextTrim()))
                corePoolSize = BaseServer.DEFAULT_CORE_POOL_SIZE;
            else
                corePoolSize = Integer.valueOf(element.getTextTrim());
                
            element = node.element("max-pool-size");
            if (element == null || StringUtils.isBlank(element.getTextTrim()))
                maxPoolSize = BaseServer.DEFAULT_MAX_POOL_SIZE;
            else
                maxPoolSize = Integer.valueOf(element.getTextTrim());
                
            element = node.element("keep-alive-time");
            if (element == null || StringUtils.isBlank(element.getTextTrim()))
                keepAliveTime = BaseServer.DEFAULT_KEEP_ALIVE_TIME;
            else
                keepAliveTime = Integer.valueOf(element.getTextTrim());
                
            element = node.element("time-unit");
            if (element == null || StringUtils.isBlank(element.getTextTrim()))
                timeUnit = BaseServer.DEFAULT_TIME_UNIT;
            else
                timeUnit = TimeUnit.valueOf(element.getTextTrim());
                
            element = node.element("work-queue-size");
            if (element == null || StringUtils.isBlank(element.getTextTrim()))
                workQueueSize = BaseServer.DEFAULT_WORK_QUEUE_SIZE;
            else
                workQueueSize = Integer.valueOf(element.getTextTrim());
                
            element = node.element("call-queue-size");
            if (element == null || StringUtils.isBlank(element.getTextTrim()))
                callQueueSize = BaseServer.DEFAULT_CALL_QUEUE_SIZE;
            else
                callQueueSize = Integer.valueOf(element.getTextTrim());
                
            element = node.element("task-timeout");
            if (element == null || StringUtils.isBlank(element.getTextTrim()))
                taskTimeout = BaseServer.DEFAULT_TASK_TIMEOUT;
            else
                taskTimeout = Integer.valueOf(element.getTextTrim());
        }
    }
    
    /**
     * 初始化属性配置
     *
     * @throws ConfigException
     */
    @SuppressWarnings( "unchecked" )
    private void initProperties(Element root) throws ConfigException {
        for (Iterator<Element> it = root.elementIterator(PROPERTIES_NODE); it.hasNext();) {
            Element parent = it.next();
            for (Iterator<Element> ir = parent.elementIterator(PROPERTIE); ir.hasNext();) {
                Element node = ir.next();
                if (!node.getName().equalsIgnoreCase(PROPERTIE))
                    continue;
                String name = node.attributeValue("name");
                if (StringUtils.isBlank(name))
                    continue;
                String value = node.attributeValue("value");
                if (StringUtils.isBlank(value))
                    continue;
                Property p = new Property();
                p.setName(name.trim());
                p.setValue(value.trim());
                if (properties == null)
                    properties = new Hashtable<String, Property>();
                properties.put(p.getName(), p);
            }
            
        }
    }
    
    /**
     * 初始化Thrift配置
     *
     * @throws ConfigException
     */
    @SuppressWarnings( "unchecked" )
    private void initThrift(Element root) throws ConfigException {
        for (Iterator<Element> it = root.elementIterator(THRIFT_NODE); it.hasNext();) {
            Element node = it.next();
            for (Object subObj : node.elements()) {
                Element sub = (Element) subObj;
                parseThrift(sub);
            }
        }
        
    }
    
    /**
     * 初始化ZooKeeper配置
     *
     * @throws ConfigException
     */
    @SuppressWarnings( "unchecked" )
    private void initZooKeeper(Element root) throws ConfigException {
        for (Iterator<Element> it = root.elementIterator(ZK_NODE); it.hasNext();) {
            Element node = it.next();
            for (Object subObj : node.elements()) {
                Element sub = (Element) subObj;
                parseZooKeeper(sub);
            }
        }
        
    }
    
    /**
     * 解析Thrift节点
     *
     * @param node
     * @throws ConfigException
     */
    @SuppressWarnings( "unchecked" )
    private void parseThrift(Element node) throws ConfigException {
        if (node.getName().equalsIgnoreCase(SERVER)) {
            String name = node.attributeValue("class");
            if (StringUtils.isBlank(name)) {
                logger.warn("Thrift Server Class is Null, Use Default{}", DEFAULT_SERVER_CLASS);
                name = DEFAULT_SERVER_CLASS;
            }
            thriftConf.setServerClass(name);
        } else if (node.getName().equalsIgnoreCase(SERVER_ARGS)) {
            String name = node.attributeValue("class");
            if (StringUtils.isBlank(name)) {
                logger.warn("Thrift Server Args Class is Null, Use Default{}", DEFAULT_SERVER_ARGS_CLASS);
                name = DEFAULT_SERVER_ARGS_CLASS;
            }
            thriftConf.setServerArgsClass(name);
        } else if (node.getName().equalsIgnoreCase(SERVER_TRANSPORT)) {
            String name = node.attributeValue("class");
            if (StringUtils.isBlank(name)) {
                logger.warn("Thrift Server Transport Class is Null, Use Default{}", DEFAULT_SERVER_TRANSPORT_CLASS);
                name = DEFAULT_SERVER_TRANSPORT_CLASS;
            }
            thriftConf.setServerTransportClass(name);
        } else if (node.getName().equalsIgnoreCase(PROTOCOL_FACTORY)) {
            String name = node.attributeValue("class");
            if (StringUtils.isBlank(name)) {
                logger.warn("Thrift Protocol Factory Class is Null, Use Default{}", DEFAULT_PROTOCOL_FACTORY_CLASS);
                name = DEFAULT_PROTOCOL_FACTORY_CLASS;
            }
            thriftConf.setProtocolFactoryClass(name);
        } else if (node.getName().equalsIgnoreCase(PROCESSOR)) {
            String name = node.attributeValue("class");
            if (StringUtils.isBlank(name)) {
                logger.warn("Thrift Processor Class is Null, Use Default{}", DEFAULT_PROCESSOR_CLASS);
                name = DEFAULT_PROCESSOR_CLASS;
            }
            thriftConf.setProcessorClass(name);
        } else if (node.getName().equalsIgnoreCase(PROCESSOR_IFACE)) {
            for (Iterator<Element> it = node.elementIterator(IFACE); it.hasNext();) {
                Element ifaceNode = it.next();
                parseProcessorIface(ifaceNode);
            }
        } else {
            logger.warn("Unsupported Thrift Property [{}]", node.getName());
        }
    }
    
    /**
     * 解析处理器节点
     *
     * @param node
     * @throws ConfigException
     */
    private void parseProcessorIface(Element node) throws ConfigException {
        if (node.getName().equalsIgnoreCase(IFACE)) {
            try {
                String name = node.attributeValue("class");
                if (StringUtils.isBlank(name)) {
                    logger.warn("Thrift Processor Interface Implement Class is Null, Skip");
                } else {
                    BeanUtil.loadInterfaces(name, thriftConf);
                }
                
            } catch (Exception e) {
                logger.error("Parse Processor Interface Error, Skip", e);
            }
        }
    }
    
    /**
     * 解析zk节点
     *
     * @param node
     * @throws ConfigException
     */
    private void parseZooKeeper(Element node) throws ConfigException {
        if (node.getName().equalsIgnoreCase(ZK_REGISTER)) {
            String name = node.attributeValue("class");
            if (StringUtils.isBlank(name)) {
                logger.warn("ZooKeeper Server Class is Null, Use Default{}", DEFAULT_ZOOKEEPER_REGISTER_CLASS);
                name = DEFAULT_ZOOKEEPER_REGISTER_CLASS;
            }
            zookeeperConf.setRegisterClass(name);
        }
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ServerConfig [properties=" + properties + ", serverFile=" + serverFile + ", serverXsd=" + serverXsd
                + ", input=" + input + ", xsdInput=" + xsdInput + ", serverName=" + serverName + ", thriftConf="
                + thriftConf + ", zookeeperConf=" + zookeeperConf + "]";
    }
    
}
