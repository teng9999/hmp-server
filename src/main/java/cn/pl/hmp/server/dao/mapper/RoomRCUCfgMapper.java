package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.RoomRCUCfg;
import cn.pl.hmp.server.dao.entity.RoomRCUCfgExample;
import java.util.List;

public interface RoomRCUCfgMapper {
    int countByExample(RoomRCUCfgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoomRCUCfg record);

    int insertSelective(RoomRCUCfg record);

    List<RoomRCUCfg> selectByExample(RoomRCUCfgExample example);

    RoomRCUCfg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoomRCUCfg record);

    int updateByPrimaryKey(RoomRCUCfg record);
}