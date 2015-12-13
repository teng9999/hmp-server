package cn.pl.hmp.server.thrift.iface;

import java.util.List;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pl.frame.annotation.ThriftService;
import cn.pl.hmp.commons.thrift.define.TCommondityType;
import cn.pl.hmp.commons.thrift.service.TCommondityTypeService;
import cn.pl.hmp.commons.utils.ObjectConverter;
import cn.pl.hmp.server.business.iface.ICommondityTypeBusiness;
import cn.pl.hmp.server.dao.entity.CommondityTypeExample;

@Component
@ThriftService
public class TCommondityTypeServiceIface implements TCommondityTypeService.Iface {

    @Autowired
    private ICommondityTypeBusiness commondityBusiness;

    @Override
    public List<TCommondityType> queryByMenuId(long menuChannelId) throws TException {
        CommondityTypeExample example = new CommondityTypeExample();
        example.createCriteria().andMenuIdEqualTo(menuChannelId);
        return ObjectConverter.convet(commondityBusiness.selectByExample(example), TCommondityType.class);
    }

}
