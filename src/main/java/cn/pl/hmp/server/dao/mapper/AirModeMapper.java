package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.AirMode;
import cn.pl.hmp.server.dao.entity.AirModeExample;
import java.util.List;

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