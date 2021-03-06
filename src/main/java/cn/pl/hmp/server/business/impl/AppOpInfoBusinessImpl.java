package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.hmp.server.business.iface.IAppOpInfoBusiness;
import cn.pl.hmp.server.dao.entity.AirMode;
import cn.pl.hmp.server.dao.entity.AirModeExample;
import cn.pl.hmp.server.dao.entity.AppOpInfo;
import cn.pl.hmp.server.dao.entity.AppOpInfoExample;
import cn.pl.hmp.server.dao.entity.HotelRoom;
import cn.pl.hmp.server.dao.entity.RoomRCUCfg;
import cn.pl.hmp.server.dao.mapper.AirModeMapper;
import cn.pl.hmp.server.dao.mapper.AppOpInfoMapper;
import cn.pl.hmp.server.dao.mapper.HotelRoomMapper;
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
    @Autowired
    private HotelRoomMapper roomMapper;
    @Autowired
    private AirModeMapper airModeMapper;
    
    private Logger logger = LoggerFactory.getLogger(AppOpInfoBusinessImpl.class);
    @Override
    public int saveOnBatch(AppOpInfo info, Map<String,String> map) {
        AppOpInfo tempInfo = null;
        List<AppOpInfo> list = null;
        RoomRCUCfg tempRoomCfg = null;
        if(null != map && !map.isEmpty()) {
            HotelRoom room = roomMapper.selectByPrimaryKey(info.getRoomId());
            Long hotelId = -1L;
            if(null == room) {
                return 0;
            }else {
                hotelId = room.getHotelId();
            }
            AirModeExample airModeExample = new AirModeExample();
            airModeExample.createCriteria().andHotelIdEqualTo(hotelId);
            List<AirMode> airModes = airModeMapper.selectByExample(airModeExample);
            Map<String,AirMode> airModeMap = new HashMap<String, AirMode>();
            if(null !=airModes && !airModes.isEmpty()) {
                for(AirMode air : airModes) {
                    if(null == air) continue;
                    airModeMap.put(air.getNid(), air);
                }
            }
            boolean token = false;
            List<RoomRCUCfg> roomRcuCfgList = roomRcuCfgMapper
                    .selectByLineType(info.getDeviceType(), info.getRoomId());
            Map<String,RoomRCUCfg>  roomRcuCfgMap = new HashMap<String, RoomRCUCfg>();
            if(null != roomRcuCfgList && !roomRcuCfgList.isEmpty()) {
                token = true;
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
            String opName = "";
            for(String key :map.keySet()) {
                tempRoomCfg = roomRcuCfgMap.get(key);
                if("SCENE".equalsIgnoreCase(info.getDeviceType())) {
                    opName = "灯光场景模式";
                }else {
                    if(tempRoomCfg == null) {
                        if("Air".equalsIgnoreCase(info.getDeviceType())) {
                            if(!token) {
                                continue;
                            }
                            opName = "Air";
                        }else {
                            continue;
                        }
                    }else {
                        opName = tempRoomCfg.getName();
                    }
                }
                
                tempInfo = new AppOpInfo();
                tempInfo.setCreateTime(nowDate);
                tempInfo.setOpTime(nowDate);
                tempInfo.setDeviceStatu(map.get(key));
                tempInfo.setDeviceType(info.getDeviceType());
                tempInfo.setLoginId(info.getLoginId());
                String deviceName = getDevice(info.getDeviceType(), key,
                        map.get(key), opName, airModeMap);
                tempInfo.setDeviceName(deviceName);
                list.add(tempInfo);
            }
            if(list.isEmpty()) {
                return 0;
            }else {
                logger.error("add op info ："+list.size());
                return opInfoMapper.insertOnBatch(list);
            }
            
        }
        return 0;
    }
    /**
     * 
     * @param lineType  线路类型
     * @param key       路数
     * @param status    操作结果码
     * @param name      操作名称 
     * @param modeMap   该房间的模式集 key为模式号
     * @return          操作结果字符串
     */
    private String getDevice(String lineType,String key ,String status,String name,Map<String,AirMode> modeMap) {
        String deviceName = "";
        if("LIGHT".equalsIgnoreCase(lineType)) {
            deviceName = "第"+status+"路"+name;
            if("0".equals(status)) {
                deviceName = "关闭"+deviceName;
            }else if("1".equals(status)) {
                deviceName = "打开"+deviceName;
            }else {
                deviceName = "未知操作";
            }
        }else if("CURTAIN".equalsIgnoreCase(lineType)) {
            logger.error("CURTAIN key:"+key+",value:"+status+"-----------------------------------");
            deviceName =  name;
            if("0".equals(status)) {
                deviceName = "停止"+ deviceName;
            }else if("1".equals(status)) {
                deviceName ="打开" + deviceName;
            }else if("2".equals(status)) {
                deviceName ="关闭" + deviceName;
            }else {
                deviceName = "未知操作";
            } 
        }else if("AIR".equalsIgnoreCase(lineType)) {
            if("1".equals(key.trim())) {
                deviceName = "设置温度为："+status;
            }else if("2".equals(key.trim())) {
                deviceName = "空调模式为：";
                if("0".equals(status)) {
                    deviceName = deviceName+"制冷";
                }else if("1".equals(status)) {
                    deviceName = deviceName + "制热";
                }else if("2".equals(status)) {
                    deviceName = deviceName + "通风";
                }else if("3".equals(status)) {
                    deviceName = deviceName + "除湿";
                }else {
                    deviceName = "未知操作";
                }
            }else if("3".equals(key.trim())) {
                if("0".equals(status)) {
                    deviceName = "关阀";
                }else if("1".equals(status)){
                    deviceName = "开阀";
                }else {
                    deviceName = "未知操作";
                }
            }else if("4".equals(key.trim())) {
                deviceName = "空调模式为：";
                if("0".equals(status)) {
                    deviceName =deviceName + "自动";
                }else if("1".equals(status)) {
                    deviceName =deviceName + "低速";
                }else if("2".equals(status)){
                    deviceName =deviceName + "中速";
                }else if("3".equals(status)){
                    deviceName =deviceName + "高速";
                }else {
                    deviceName = "未知操作";
                }
            }else if("5".equals(key.trim())) {
                if("0".equals(status)) {
                    deviceName = "关机";
                }else if("1".equals(status)){
                    deviceName = "开机";
                }else {
                    deviceName = "未知操作";
                }
            }else if("6".equals(key.trim())) {
                deviceName = "未开发操作";
            }
        }else if("SCENE".equalsIgnoreCase(lineType)) {
            if(modeMap.containsKey(key)) {
                deviceName = modeMap.get(key).getMode();
            }else {
                deviceName = "未知操作";
            }
        }else {
            deviceName = "未知错误";
        }
        return deviceName;
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
