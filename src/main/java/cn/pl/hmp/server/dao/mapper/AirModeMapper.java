package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import cn.pl.hmp.server.dao.entity.AirMode;
import cn.pl.hmp.server.dao.entity.AirModeExample;

public interface AirModeMapper {
    int countByExample(AirModeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AirMode record);

    int insertSelective(AirMode record);

    List<AirMode> selectByExample(AirModeExample example);

    AirMode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AirMode record);

    int updateByPrimaryKey(AirMode record);
}