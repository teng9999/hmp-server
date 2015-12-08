package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.hmp.server.business.iface.ICommondityTypeBusiness;
import cn.pl.hmp.server.dao.entity.CommondityType;
import cn.pl.hmp.server.dao.entity.CommondityTypeExample;
import cn.pl.hmp.server.dao.mapper.CommondityTypeMapper;
@Service
public class CommondityTypeBusinessImpl extends BoostBusinessImpl implements ICommondityTypeBusiness{
    @Autowired
    private CommondityTypeMapper mapper;
    @Override
    public int deleteByMenuChannelId(Long menuChannelId) {
        return mapper.deleteByMenuId(menuChannelId);
    }

    @Override
    public List<CommondityType> selectByExample(CommondityTypeExample example) {
        List<CommondityType> list = mapper.selectByExample(example);
        if(null == list) {
            list = new ArrayList<CommondityType>();
        }
        return list;
    }

    @Override
    public int insertBatch(List<CommondityType> list) {
        return mapper.insertBatch(list);
    }

}
