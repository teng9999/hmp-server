package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import cn.pl.hmp.server.dao.entity.TvChannel;
import cn.pl.hmp.server.dao.entity.TvChannelExample;

public interface TvChannelMapper {
    int countByExample(TvChannelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TvChannel record);

    int insertSelective(TvChannel record);

    List<TvChannel> selectByExample(TvChannelExample example);

    int updateByPrimaryKeySelective(TvChannel record);

    int updateByPrimaryKey(TvChannel record);

    int deleteOnBatch(List<Long> idList);
}