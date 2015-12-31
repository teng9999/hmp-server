package cn.pl.hmp.server.business.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.utils.StringUtils;
import cn.pl.hmp.server.business.iface.IDealOldDataBusiness;
import cn.pl.hmp.server.dao.entity.DataDict;
import cn.pl.hmp.server.dao.entity.HotelRoom;
import cn.pl.hmp.server.dao.entity.HotelRoomExample;
import cn.pl.hmp.server.dao.entity.HotelRoomType;
import cn.pl.hmp.server.dao.entity.HotelRoomTypeExample;
import cn.pl.hmp.server.dao.entity.PmsCheckInInfo;
import cn.pl.hmp.server.dao.entity.PmsCheckInInfoExample;
import cn.pl.hmp.server.dao.entity.RoomRCUCfg;
import cn.pl.hmp.server.dao.entity.RoomRCUCfgExample;
import cn.pl.hmp.server.dao.mapper.DataDictMapper;
import cn.pl.hmp.server.dao.mapper.HotelRoomMapper;
import cn.pl.hmp.server.dao.mapper.HotelRoomTypeMapper;
import cn.pl.hmp.server.dao.mapper.PmsCheckInInfoMapper;
import cn.pl.hmp.server.dao.mapper.RoomRCUCfgMapper;

@Service
public class DealOldDataBusinessImpl extends BoostBusinessImpl implements
        IDealOldDataBusiness {

    @Autowired
    private HotelRoomTypeMapper roomTypeMapper;
    @Autowired
    private HotelRoomMapper roomMapper;
    @Autowired
    private RoomRCUCfgMapper roomRcuMapper;
    @Autowired
    private PmsCheckInInfoMapper pmsInfoMapper;
    @Autowired
    private DataDictMapper dictMapper;
    // oldtypeId:oldtypeName
    Map<String, String> allOldTypeMap = null;
    // hotelid-typeId:newTypeId
    Map<String, Long> ioldTypeMap = null;
    // hotelName-typeId:newTypeId
    Map<String, Long> noldTypeMap = null;

    private void initOldRoomType(Map<String, String> allOldTypeMap) {
        List<DataDict> dictList = dictMapper.selectByParentName("RoomType");
        if (null != dictList && !dictList.isEmpty()) {
            for (DataDict dataDict : dictList) {
                if (null != dataDict) {
                    allOldTypeMap.put(dataDict.getName(), dataDict.getNameCn());
                }
            }
        }
    }

    @Override
    public int dealOldRoomType() {
        allOldTypeMap = new HashMap<String, String>();
        ioldTypeMap = new HashMap<String, Long>();
        noldTypeMap = new HashMap<String, Long>();
        try{
            this.initOldRoomType(allOldTypeMap);
            this.dealHotelRoom();
            this.dealRoomRCUCfg();
            this.dealPmsCheckInInfo();
            return 1;
        }catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void dealHotelRoom() {
       List<HotelRoom> roomList = roomMapper.selectByExample(new HotelRoomExample());
       String key = null;
       Long newTypeId = -1L;
       String oldRoomType = null;
       Long hotelId = -1L;
       if(null != roomList && !roomList.isEmpty()) {
           for(HotelRoom roomTemp : roomList) {
               if(null != roomTemp ) {
                   hotelId = roomTemp.getHotelId();
                   oldRoomType = roomTemp.getRoomType();
                   if(null == hotelId || StringUtils.isBlank(oldRoomType)) {
                       System.out.println("酒店号或房间类型为空");
                       continue;
                   }else {
                       
                       key = hotelId+"-"+oldRoomType;
                       
                       if(ioldTypeMap.containsKey(key)) {
                           newTypeId = ioldTypeMap.get(key);
                       }else {
                           if(allOldTypeMap.containsKey(oldRoomType)) {
                               newTypeId = this.addRoomType(roomTemp.getHotelId(),
                                       allOldTypeMap.get(oldRoomType));
                               ioldTypeMap.put(key, newTypeId);
                           }else {
                               System.out.println("原字典表中不存在该房间类型:"+roomTemp.getRoomType());
                               continue;
                           }
                       }
                   }
                   
                   roomTemp.setRoomType(newTypeId+"");
                   roomMapper.updateByPrimaryKey(roomTemp);
               }
           }
       }
    }
    
    
    
    private void dealRoomRCUCfg() {
        List<RoomRCUCfg> roomRcuList = roomRcuMapper.selectByExample(new RoomRCUCfgExample());
        String key = null;
        Long newTypeId = -1L;
        String oldRoomType = null;
        Long hotelId = -1L;
        if(null != roomRcuList && !roomRcuList.isEmpty()) {
            for(RoomRCUCfg roomRcuTemp : roomRcuList) {
                if(null != roomRcuTemp ) {
                    hotelId = roomRcuTemp.getHotelId();
                    oldRoomType = roomRcuTemp.getRoomType();
                    if(null == hotelId || StringUtils.isBlank(oldRoomType)) {
                        System.out.println("酒店号或房间类型为空");
                        continue;
                    }else {
                        
                        key = hotelId+"-"+oldRoomType;
                        
                        if(ioldTypeMap.containsKey(key)) {
                            newTypeId = ioldTypeMap.get(key);
                        }else {
                            if(allOldTypeMap.containsKey(oldRoomType)) {
                                newTypeId = this.addRoomType(roomRcuTemp.getHotelId(),
                                        allOldTypeMap.get(oldRoomType));
                                
                                ioldTypeMap.put(key, newTypeId);
                            }else {
                                System.out.println("原字典表中不存在该房间类型:"+roomRcuTemp.getRoomType());
                                continue;
                            }
                        }
                    }
                    
                    roomRcuTemp.setRoomType(newTypeId+"");
                    
                    roomRcuMapper.updateByPrimaryKey(roomRcuTemp);
                }
            }
        }
    }
    
    private void dealPmsCheckInInfo() {
        List<PmsCheckInInfo> roomRcuList = pmsInfoMapper.selectByExample(new PmsCheckInInfoExample());
        String key = null;
        Long newTypeId = -1L;
        String oldRoomType = null;
        String hotelName = null;
        Long hotelId = -1L;
        if(null != roomRcuList && !roomRcuList.isEmpty()) {
            for(PmsCheckInInfo pmsInfoTemp : roomRcuList) {
                if(null != pmsInfoTemp ) {
                    hotelName = pmsInfoTemp.getHotelName();
                    oldRoomType = pmsInfoTemp.getRoomTypeCn();
                    if(StringUtils.isBlank(hotelName) || StringUtils.isBlank(oldRoomType)) {
                        System.out.println("酒店名称或房间类型为空");
                        continue;
                    }else {
                        
                        key = hotelName+"-"+oldRoomType;
                        
                        if(noldTypeMap.containsKey(key)) {
                            newTypeId = noldTypeMap.get(key);
                        }else {
                            if(allOldTypeMap.containsKey(oldRoomType)) {
                                HotelRoomExample roomExample = new HotelRoomExample();
                                roomExample.createCriteria()
                                .andRoomNumEqualTo(pmsInfoTemp.getRoomNum());
                                List<HotelRoom> roomList = roomMapper.selectByExample(roomExample);
                                if(null != roomList && !roomList.isEmpty()) {
                                    hotelId = roomList.get(0).getHotelId();
                                }
                                
                                newTypeId = this.addRoomType(hotelId,
                                        allOldTypeMap.get(oldRoomType));
                                
                                noldTypeMap.put(key, newTypeId);
                            }else {
                                System.out.println("原字典表中不存在该房间类型:"+oldRoomType);
                                continue;
                            }
                        }
                    }
                    
                    pmsInfoTemp.setRoomTypeCn(newTypeId+"");
                    
                    pmsInfoMapper.updateByPrimaryKey(pmsInfoTemp);
                }
            }
        }
    }
    
    private Long checkName(Long hotelId, String name) {
        HotelRoomTypeExample example = new HotelRoomTypeExample();
        example.createCriteria().andHotelIdEqualTo(hotelId)
        .andNameEqualTo(name);
        List<HotelRoomType> roomTypeList = roomTypeMapper.selectByExample(example);
        if(null != roomTypeList && !roomTypeList.isEmpty()) {
            return roomTypeList.get(0).getId();
        }
        return -1L;
    }
    
    private Long addRoomType(Long hotelId, String typeName) {
        Long resId = this.checkName(hotelId,typeName);
        if(resId > 0) {
            return resId;
        }
        HotelRoomType roomType = new HotelRoomType();
        roomType.setHotelId(hotelId);
        roomType.setName(typeName);
        roomType.setCreateTime(new Date());
        roomTypeMapper.insert(roomType);
        return roomType.getId();
    }

}
