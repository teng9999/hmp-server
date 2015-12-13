package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import cn.pl.hmp.server.dao.entity.TvProgram;
import cn.pl.hmp.server.dao.entity.TvProgramExample;

public interface TvProgramMapper {

    int countByExample(TvProgramExample example);

    int deleteOnBatch(List<Long> idList);

    int deleteByPrimaryKey(Long id);

    int insert(TvProgram record);

    int insertSelective(TvProgram record);

    List<TvProgram> selectByExample(TvProgramExample example);

    List<TvProgram> selectByPlayContent(String content);

    int updateByPrimaryKeySelective(TvProgram record);

    int updateByPrimaryKey(TvProgram record);
}