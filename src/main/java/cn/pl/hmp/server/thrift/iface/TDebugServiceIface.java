/*
 * TDebugServiceIface.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.thrift.iface;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.pl.commons.utils.StringUtils;
import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrfit.service.TDebugService.Iface;
import cn.pl.frame.thrift.define.TDebug;
import cn.pl.frame.thrift.exception.ThriftException;
import cn.pl.hmp.server.utils.ServerStatisticUtil;

/**
 * 调试服务接口实现
 *
 * @author alanyuan
 */
@Component
@ThriftService
public class TDebugServiceIface implements Iface {
    private static Logger logger = LoggerFactory.getLogger(TDebugServiceIface.class);
    // @Autowired private IEtlExampleBusiness business;

    /*
     * (non-Javadoc)
     * 
     * @see cn.pl.frame.thrift.service.TDebugService.Iface#info(java.lang.String
     * )
     */
    @Override
    public TDebug info(String info) throws ThriftException, TException {
        TDebug d = new TDebug(info);
        logger.info(d.getInfo());
        return d;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.pl.frame.thrift.service.TDebugService.Iface#warn(java.lang.String
     * )
     */
    @Override
    public TDebug warn(String warn) throws ThriftException, TException {
        TDebug d = new TDebug(warn);
        logger.debug(d.getInfo());
        return d;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.pl.frame.thrift.service.TDebugService.Iface#debug(java.lang.
     * String )
     */
    @Override
    public TDebug debug(String debug) throws ThriftException, TException {
        TDebug d = null;

        if (StringUtils.isNotBlank(debug) && debug.equalsIgnoreCase("serverstat")) {
            logger.warn("Debug Server Statistic");
            Thread[] thread = ServerStatisticUtil.findAllThreads();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < thread.length; i++) {
                Thread t = thread[i];
                if (i > 0)
                    sb.append("++");
                sb.append("Thread@@" + t.getName());
                sb.append("!!");
                sb.append("ThreadGroup@@" + t.getThreadGroup().getName());
                sb.append("!!");
                sb.append("Priority@@" + new Integer(t.getPriority()));
                sb.append("!!");
                sb.append("Alive@@" + new Boolean(t.isAlive()));
                sb.append("!!");
                sb.append("Daemon@@" + new Boolean(t.isDaemon()));
                sb.append("!!");
                sb.append("Interrupted@@" + new Boolean(t.isInterrupted()));
            }
            d = new TDebug(sb.toString());
        } else {
            d = new TDebug(debug);
            logger.warn(d.getInfo());
        }
        return d;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.pl.frame.thrift.service.TDebugService.Iface#error(java.lang.
     * String )
     */
    @Override
    public TDebug error(String error) throws ThriftException, TException {
        TDebug d = new TDebug(error);
        logger.error(d.getInfo());
        return d;
    }

}
