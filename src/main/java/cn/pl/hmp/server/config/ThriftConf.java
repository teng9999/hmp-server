/*
 * ThriftConf.java Copyright Bejing Passion Tech Co.,Ltd. All Rights Reserved.
 */
package cn.pl.hmp.server.config;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.AbstractServerArgs;
import org.apache.thrift.transport.TServerTransport;

import java.net.InetSocketAddress;
import java.util.Hashtable;
import java.util.Map;

/**
 * ThriftConf配置
 *
 * @author alanyuan
 */
public class ThriftConf {
    /**
     * 服务节点名
     */
    private String                  name;
    /**
     * 服务主机
     */
    private String                  host;
    /**
     * 服务端口
     */
    private int                     port               = 9696;
    /**
     * 连接超时（<=0则使用Thrift默认设置）
     */
    private int                     timeout            = 0;
    /**
     * 读缓冲区极值
     */
    private int                     maxReadBufferBytes = 16384000;
    /**
     * 服务类名
     */
    private String                  serverClass;
    /**
     * 服务参数类名
     */
    private String                  serverArgsClass;
    /**
     * 传输类名
     */
    private String                  serverTransportClass;
    /**
     * 协议工厂类名
     */
    private String                  protocolFactoryClass;
    /**
     * 处理器类名
     */
    private String                  processorClass;
                                    
    /**
     * 服务实例
     */
    private TServer                 server;
    /**
     * 服务参数实例
     */
    private AbstractServerArgs<?>   serverArgs;
    /**
     * 服务传输实例
     */
    private TServerTransport        serverTransport;
    /**
     * 服务地址
     */
    private InetSocketAddress       socketAddress;
    /**
     * 协议工厂实例
     */
    private TProtocolFactory        protocolFactory;
    /**
     * 处理器实例
     */
    private TProcessor              processor;
    /**
     * 服务端处理实现接口映射表
     */
    private Map<String, TProcessor> interfaces;
                                    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the maxReadBufferBytes
     */
    public int getMaxReadBufferBytes() {
        return maxReadBufferBytes;
    }
    
    /**
     * @param maxReadBufferBytes
     *            the maxReadBufferBytes to set
     */
    public void setMaxReadBufferBytes(int maxReadBufferBytes) {
        this.maxReadBufferBytes = maxReadBufferBytes;
    }
    
    /**
     * @return the serverClass
     */
    public String getServerClass() {
        return serverClass;
    }
    
    /**
     * @param serverClass
     *            the serverClass to set
     */
    public void setServerClass(String serverClass) {
        this.serverClass = serverClass;
    }
    
    /**
     * @return the serverTransportClass
     */
    public String getServerTransportClass() {
        return serverTransportClass;
    }
    
    /**
     * @param serverTransportClass
     *            the serverTransportClass to set
     */
    public void setServerTransportClass(String serverTransportClass) {
        this.serverTransportClass = serverTransportClass;
    }
    
    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }
    
    /**
     * @param host
     *            the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }
    
    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }
    
    /**
     * @param port
     *            the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }
    
    /**
     * @return the timeout
     */
    public int getTimeout() {
        return timeout;
    }
    
    /**
     * @param timeout
     *            the timeout to set
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
    
    /**
     * @return the protocolFactoryClass
     */
    public String getProtocolFactoryClass() {
        return protocolFactoryClass;
    }
    
    /**
     * @param protocolFactoryClass
     *            the protocolFactoryClass to set
     */
    public void setProtocolFactoryClass(String protocolFactoryClass) {
        this.protocolFactoryClass = protocolFactoryClass;
    }
    
    /**
     * @return the processorClass
     */
    public String getProcessorClass() {
        return processorClass;
    }
    
    /**
     * @param processorClass
     *            the processorClass to set
     */
    public void setProcessorClass(String processorClass) {
        this.processorClass = processorClass;
    }
    
    /**
     * @return the cn.pl.hmp.server
     */
    public TServer getServer() {
        return server;
    }
    
    /**
     * @param cn.pl.hmp.server
     *            the cn.pl.hmp.server to set
     */
    public void setServer(TServer server) {
        this.server = server;
    }
    
    /**
     * @return the serverTransport
     */
    public TServerTransport getServerTransport() {
        return serverTransport;
    }
    
    /**
     * @param serverTransport
     *            the serverTransport to set
     */
    public void setServerTransport(TServerTransport serverTransport) {
        this.serverTransport = serverTransport;
    }
    
    /**
     * @return the socketAddress
     */
    public InetSocketAddress getSocketAddress() {
        return socketAddress;
    }
    
    /**
     * @param socketAddress
     *            the socketAddress to set
     */
    public void setSocketAddress(InetSocketAddress socketAddress) {
        this.socketAddress = socketAddress;
    }
    
    /**
     * @return the processor
     */
    public TProcessor getProcessor() {
        return processor;
    }
    
    /**
     * @param processor
     *            the processor to set
     */
    public void setProcessor(TProcessor processor) {
        this.processor = processor;
    }
    
    /**
     * @return the interfaces
     */
    public Map<String, TProcessor> getInterfaces() {
        return interfaces;
    }
    
    /**
     * @param interfaces
     *            the interfaces to set
     */
    public void setInterfaces(Map<String, TProcessor> interfaces) {
        this.interfaces = interfaces;
    }
    
    /**
     * @return the interfaces
     */
    public TProcessor getInterfaces(String name) {
        if (this.interfaces == null)
            return null;
        return this.interfaces.get(name);
    }
    
    /**
     * @param interfaces
     *            the interfaces to set
     */
    public void setInterface(String name, TProcessor iface) {
        if (this.interfaces == null)
            this.interfaces = new Hashtable<String, TProcessor>();
        this.interfaces.put(name, iface);
    }
    
    /**
     * @return the protocolFactory
     */
    public TProtocolFactory getProtocolFactory() {
        return protocolFactory;
    }
    
    /**
     * @param protocolFactory
     *            the protocolFactory to set
     */
    public void setProtocolFactory(TProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }
    
    /**
     * @return the serverArgsClass
     */
    public String getServerArgsClass() {
        return serverArgsClass;
    }
    
    /**
     * @param serverArgsClass
     *            the serverArgsClass to set
     */
    public void setServerArgsClass(String serverArgsClass) {
        this.serverArgsClass = serverArgsClass;
    }
    
    /**
     * @return the serverArgs
     */
    public AbstractServerArgs<?> getServerArgs() {
        return serverArgs;
    }
    
    /**
     * @param serverArgs
     *            the serverArgs to set
     */
    public void setServerArgs(AbstractServerArgs<?> serverArgs) {
        this.serverArgs = serverArgs;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ThriftConf [maxReadBufferBytes=" + maxReadBufferBytes + ", serverClass=" + serverClass
                + ", serverArgsClass=" + serverArgsClass + ", serverTransportClass=" + serverTransportClass + ", host="
                + host + ", port=" + port + ", timeout=" + timeout + ", protocolFactoryClass=" + protocolFactoryClass
                + ", processorClass=" + processorClass + ", cn.pl.hmp.server=" + server + ", serverArgs=" + serverArgs
                + ", serverTransport=" + serverTransport + ", socketAddress=" + socketAddress + ", protocolFactory="
                + protocolFactory + ", processor=" + processor + ", interfaces=" + interfaces + "]";
    }
    
}
