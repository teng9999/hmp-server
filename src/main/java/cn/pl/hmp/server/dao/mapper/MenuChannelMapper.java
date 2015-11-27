package cn.pl.hmp.server.dao.mapper;

import cn.pl.hmp.server.dao.entity.MenuChannel;
import cn.pl.hmp.server.dao.entity.MenuChannelExample;
import java.util.List;

public interface MenuChannelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MenuChannel record);

    int insertSelective(MenuChannel record);

    List<MenuChannel> selectByExample(MenuChannelExample example);

    MenuChannel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MenuChannel record);

    int updateByPrimaryKey(MenuChannel record);
}