package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.HmpTvMenuTemplet;
import cn.pl.hmp.server.dao.entity.HmpTvMenuTempletExample;
import java.util.List;

public interface HmpTvMenuTempletMapper {
    int countByExample(HmpTvMenuTempletExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HmpTvMenuTemplet record);

    int insertSelective(HmpTvMenuTemplet record);

    List<HmpTvMenuTemplet> selectByExample(HmpTvMenuTempletExample example);

    HmpTvMenuTemplet selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HmpTvMenuTemplet record);

    int updateByPrimaryKey(HmpTvMenuTemplet record);
    
    int deleteOnBatch(List<Long> idList);
}