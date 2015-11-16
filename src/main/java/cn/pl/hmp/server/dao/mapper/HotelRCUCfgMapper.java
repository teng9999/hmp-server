package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.HotelRCUCfg;
import cn.pl.hmp.server.dao.entity.HotelRCUCfgExample;
import java.util.List;

public interface HotelRCUCfgMapper {
    int countByExample(HotelRCUCfgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HotelRCUCfg record);

    int insertSelective(HotelRCUCfg record);

    List<HotelRCUCfg> selectByExample(HotelRCUCfgExample example);

    HotelRCUCfg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelRCUCfg record);

    int updateByPrimaryKey(HotelRCUCfg record);
}