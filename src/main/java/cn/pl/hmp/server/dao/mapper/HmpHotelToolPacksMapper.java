package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.HmpHotelToolPacks;
import cn.pl.hmp.server.dao.entity.HmpHotelToolPacksExample;
import java.util.List;

public interface HmpHotelToolPacksMapper {
    int countByExample(HmpHotelToolPacksExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HmpHotelToolPacks record);

    int insertSelective(HmpHotelToolPacks record);

    List<HmpHotelToolPacks> selectByExample(HmpHotelToolPacksExample example);

    HmpHotelToolPacks selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HmpHotelToolPacks record);

    int updateByPrimaryKey(HmpHotelToolPacks record);
    
    List<HmpHotelToolPacks> queryList();
}