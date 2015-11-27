package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.TvChannel;
import cn.pl.hmp.server.dao.entity.TvChannelExample;
import java.util.List;

public interface TvChannelMapper {
    int countByExample(TvChannelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TvChannel record);

    int insertSelective(TvChannel record);

    List<TvChannel> selectByExample(TvChannelExample example);

    List<TvChannel> selectByTvName(String tvName);

    int updateByPrimaryKeySelective(TvChannel record);

    int updateByPrimaryKey(TvChannel record);
    
    int deleteOnBatch(List<Long> idList);
}