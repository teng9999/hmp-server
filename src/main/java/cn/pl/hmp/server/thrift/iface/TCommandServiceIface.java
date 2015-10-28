/*
 * TCommandServiceIface.java Copyright Bejing Passion Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.thrift.iface;

import cn.pl.frame.annotation.ThriftService;
import cn.pl.frame.thrfit.service.TCommandService.Iface;
import cn.pl.commons.global.States;
import cn.pl.frame.thrift.define.TCommand;
import cn.pl.frame.thrift.define.TResult;
import cn.pl.frame.thrift.exception.ThriftException;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

/**
 * 命令服务接口实现
 *
 * @author alanyuan
 */
@Component
@ThriftService
public class TCommandServiceIface implements Iface {
    
    /*
     * (non-Javadoc)
     * @see
     * cn.pl.frame.thrift.service.TCommandService.Iface#command(cn.px.dxs
     * .common.thrift.define.TCommand)
     */
    @Override
    public TResult command(TCommand cmd) throws ThriftException, TException {
        TResult result = new TResult(States.FAIL.getCode(), States.FAIL.getMsg());
        return result;
    }
    
}
