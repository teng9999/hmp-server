package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.commons.utils.StringUtils;
import cn.pl.hmp.server.business.iface.IPmsCheckInInfoBusiness;
import cn.pl.hmp.server.dao.entity.PmsCheckInInfo;
import cn.pl.hmp.server.dao.entity.PmsCheckInInfoCondition;
import cn.pl.hmp.server.dao.mapper.PmsCheckInInfoMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class PmsCheckInInfoBusinessImpl extends BoostBusinessImpl implements IPmsCheckInInfoBusiness{
    @Autowired
    private PmsCheckInInfoMapper infoMapper;
    @Override
    public int delete(Long id) {
        if(null == id) {
            return -1;
        }
        return infoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public long insert(PmsCheckInInfo record) {
        if(null == record) {
            return -1;
        }
        return infoMapper.insert(record);
    }

    @Override
    public PmsCheckInInfo selectById(Long id) {
        if(null == id) {
            return null;
        }
        return infoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(PmsCheckInInfo record) {
        if(null == record) {
            return -1;
        }
        return infoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Map<Pages, List<PmsCheckInInfo>> selectByPages(PmsCheckInInfoCondition condition,
            Pages page) {
        if(page == null ) {
            page = new Pages(); 
        }
        Map<Pages, List<PmsCheckInInfo>> map = new HashMap<Pages, List<PmsCheckInInfo>>();
        //如果酒店的pms编号为空时 返回空列表
        String schainId = condition.getSchainId();
        if(StringUtils.isNotBlank(schainId) && "hotelBlankPms".equals(schainId)) {
            return map;
        }
        
        this.formatCodition(condition);
        PageHelper.startPage(page.getPageNum(), page.getPageSize(),page.getOrderBy());
        List<PmsCheckInInfo> hotelRoomList = infoMapper.selectCombInfoList(condition);
        if (null == hotelRoomList)
            hotelRoomList = new ArrayList<PmsCheckInInfo>();
        PageInfo<PmsCheckInInfo> pageInfo = new PageInfo<PmsCheckInInfo>(hotelRoomList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, hotelRoomList);
        return map;
    }
    
    private void formatCodition(PmsCheckInInfoCondition condition) {
        String schainId = condition.getSchainId();
        String timeRange = condition.getTimeRange();
        //pmsid
        if(StringUtils.isNotBlank(schainId) && NumberUtils.isNumber(schainId)) {
            condition.setChainId(Long.parseLong(schainId));
        }
        //日期
        if(StringUtils.isNotBlank(timeRange)) {
            String[] times = timeRange.split("~");
            if(null != times) {
                if(times.length > 0 && StringUtils.isNotBlank(times[0])) {
                        condition.setBeginTime(times[0]);
                }
                if(times.length > 1 && StringUtils.isNotBlank(times[1]) ) {
                    condition.setEndTime(times[1]);
                }
            }
        }
        condition.setGuestName(StringUtils.isBlank(condition.getGuestName())
                ?null:condition.getGuestName());
        condition.setHotelName(StringUtils.isBlank(condition.getHotelName())
                ?null:condition.getHotelName());
        condition.setRoomType(StringUtils.isBlank(condition.getRoomType())
                ?null:condition.getRoomType());
        condition.setSex(StringUtils.isBlank(condition.getSex())
                ?null:condition.getSex());
    }
    
}
