package cn.pl.hmp.server.business.iface;

import java.util.List;

import cn.pl.hmp.server.dao.entity.CommondityType;
import cn.pl.hmp.server.dao.entity.CommondityTypeExample;

public interface ICommondityTypeBusiness {

    int deleteByMenuChannelId(Long menuChannelId);

    List<CommondityType> selectByExample(CommondityTypeExample example);

    int insertBatch(List<CommondityType> list);
}
