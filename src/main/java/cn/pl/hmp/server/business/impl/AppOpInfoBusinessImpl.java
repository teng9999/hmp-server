package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IAppOpInfoBusiness;
import cn.pl.hmp.server.dao.entity.AppOpInfo;
import cn.pl.hmp.server.dao.entity.AppOpInfoExample;
import cn.pl.hmp.server.dao.entity.RoomRCUCfg;
import cn.pl.hmp.server.dao.mapper.AppOpInfoMapper;
import cn.pl.hmp.server.dao.mapper.RoomRCUCfgMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class AppOpInfoBusinessImpl extends BoostBusinessImpl implements IAppOpInfoBusiness{
    @Autowired
    private AppOpInfoMapper opInfoMapper;
    @Autowired
    private RoomRCUCfgMapper roomRcuCfgMapper;
    @Override
    public int saveOnBatch(AppOpInfo info, Map<String,String> map) {
        AppOpInfo tempInfo = null;
        List<AppOpInfo> list = null;
        RoomRCUCfg tempRoomCfg = null;
        if(null != map && !map.isEmpty()) {
            List<RoomRCUCfg> roomRcuCfgList = roomRcuCfgMapper
                    .selectByLineType(info.getDeviceType(), info.getRoomId());
            Map<String,RoomRCUCfg>  roomRcuCfgMap = new HashMap<String, RoomRCUCfg>();
            if(null != roomRcuCfgList && !roomRcuCfgList.isEmpty()) {
                for(RoomRCUCfg roomRcuCfg : roomRcuCfgList) {
                    if(null == roomRcuCfg) {
                        continue;
                    }
                    roomRcuCfgMap.put(roomRcuCfg.getNum(), roomRcuCfg);
                }
            }else {
                return 0;
            }
            Date nowDate = new Date();
            list = new ArrayList<AppOpInfo>();
            for(String key :map.keySet()) {
                tempRoomCfg = roomRcuCfgMap.get(key);
                if(tempRoomCfg == null) {
                    continue;
                }
                tempInfo = new AppOpInfo();
                tempInfo.setCreateTime(nowDate);
                tempInfo.setOpTime(nowDate);
                tempInfo.setDeviceStatu(map.get(key));
                tempInfo.setDeviceType(info.getDeviceType());
                tempInfo.setLoginId(info.getLoginId());
                tempInfo.setDeviceName("第"+key+"路"+tempRoomCfg.getName());
                list.add(tempInfo);
            }
            return opInfoMapper.insertOnBatch(list);
            
        }
        return 0;
    }

    @Override
    public Map<Pages, List<AppOpInfo>> selectByPages(AppOpInfoExample example,
            Pages page) {
        Map<Pages, List<AppOpInfo>> map = new HashMap<Pages, List<AppOpInfo>>();
        if (null == example)
            example = new AppOpInfoExample();
        PageHelper.startPage(page.getPageNum(), page.getPageSize(),page.getOrderBy());
        System.out.println(page.getPageNum() + "--" + page.getPageSize());
        List<AppOpInfo> opInfoList = opInfoMapper.selectByExample(example);
        if (null == opInfoList)
            opInfoList = new ArrayList<AppOpInfo>();
        PageInfo<AppOpInfo> pageInfo = new PageInfo<AppOpInfo>(opInfoList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, opInfoList);
        return map;
    }

}
