package cn.pl.hmp.server.dao.mapper;

import java.util.List;

import cn.pl.hmp.server.dao.entity.PmsCheckInInfo;
import cn.pl.hmp.server.dao.entity.PmsCheckInInfoCondition;
import cn.pl.hmp.server.dao.entity.PmsCheckInInfoExample;

public interface PmsCheckInInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsCheckInInfo record);

    int insertSelective(PmsCheckInInfo record);

    List<PmsCheckInInfo> selectByExample(PmsCheckInInfoExample example);

    PmsCheckInInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsCheckInInfo record);

    int updateByPrimaryKey(PmsCheckInInfo record);
    
    /**
     * 统一查询混合数据接口
     * @param conditon 参数对象
     * @return
     */
    List<PmsCheckInInfo> selectCombInfoList(PmsCheckInInfoCondition condition);
}