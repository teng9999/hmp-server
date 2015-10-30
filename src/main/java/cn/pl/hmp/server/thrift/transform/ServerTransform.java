/*
 * ServerTransform.java Copyright Bejing Pinglian Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.thrift.transform;

import cn.pl.frame.client.thrift.transform.ThriftTransform;
import cn.pl.hmp.commons.thrift.define.TExample;
import cn.pl.hmp.server.dao.entity.HmpTest;

/**
 * @author alanyuan
 *
 */
public class ServerTransform extends ThriftTransform {
    public static HmpTest transform(TExample info) {
        if(info == null)
            return null;
        HmpTest result = new HmpTest();
        result.setId(info.getId());
        result.setName(info.getName());
        return result;
    }

    public static TExample transform(HmpTest rlt) {
        if(rlt == null)
            return null;
        TExample result = new TExample();
        result.setId(rlt.getId());
        result.setName(rlt.getName());
        return result;
    }
}
