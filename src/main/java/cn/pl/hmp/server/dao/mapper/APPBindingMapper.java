package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import cn.pl.hmp.server.dao.entity.APPBinding;
import cn.pl.hmp.server.dao.entity.APPBindingExample;

public interface APPBindingMapper {
    int countByExample(APPBindingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(APPBinding record);

    int insertSelective(APPBinding record);

    List<APPBinding> selectByExample(APPBindingExample example);

    APPBinding selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(APPBinding record);

    int updateByPrimaryKey(APPBinding record);
}