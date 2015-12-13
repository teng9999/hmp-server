package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import cn.pl.hmp.server.dao.entity.HmpMovieGroup;
import cn.pl.hmp.server.dao.entity.HmpMovieGroupExample;

public interface HmpMovieGroupMapper {
    int countByExample(HmpMovieGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HmpMovieGroup record);

    int insertSelective(HmpMovieGroup record);

    List<HmpMovieGroup> selectByExample(HmpMovieGroupExample example);

    HmpMovieGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HmpMovieGroup record);

    int updateByPrimaryKey(HmpMovieGroup record);

    List<HmpMovieGroup> selectByGroupType(Long groupType);
}