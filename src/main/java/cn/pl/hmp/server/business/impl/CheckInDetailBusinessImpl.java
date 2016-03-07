package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.commons.utils.StringUtils;
import cn.pl.hmp.server.business.iface.ICheckInDetailBusiness;
import cn.pl.hmp.server.dao.entity.CheckInDetail;
import cn.pl.hmp.server.dao.mapper.CheckInDetailMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CheckInDetailBusinessImpl extends BoostBusinessImpl implements ICheckInDetailBusiness{
    @Autowired
    private CheckInDetailMapper detailMapper;
    @Override
    public Map<Pages, List<CheckInDetail>> selectByPages(Pages page,
            int opStatus, String nowDate,long roomId) {
        Map<Pages, List<CheckInDetail>> map = new HashMap<Pages, List<CheckInDetail>>();
        if(StringUtils.isBlank(nowDate)) return map;
        
        PageHelper.startPage(page.getPageNum(), page.getPageSize(),page.getOrderBy());
        System.out.println(page.getPageNum() + "--" + page.getPageSize());
        List<CheckInDetail> tvList = detailMapper.selectByCondition(opStatus,nowDate,roomId);
        if (null == tvList)
            tvList = new ArrayList<CheckInDetail>();
        PageInfo<CheckInDetail> pageInfo = new PageInfo<CheckInDetail>(tvList);
        Pages pages = PageConverter.converter(pageInfo);
        map.put(pages, tvList);
        return map;
    }

}
