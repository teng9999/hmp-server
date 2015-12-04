package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pl.hmp.server.dao.entity.RoomRCUCfg;
import cn.pl.hmp.server.dao.entity.RoomRCUCfgExample;

public interface RoomRCUCfgMapper {
    int countByExample(RoomRCUCfgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoomRCUCfg record);

    int insertSelective(RoomRCUCfg record);

    List<RoomRCUCfg> selectByExample(RoomRCUCfgExample example);

    RoomRCUCfg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoomRCUCfg record);

    int updateByPrimaryKey(RoomRCUCfg record);
    
    List<RoomRCUCfg> selectByLineType(@Param(value="lineType")String lineType
            ,@Param(value="roomId")long roomId);
}