package cn.pl.hmp.server.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.commons.pages.Pages;
import cn.pl.commons.utils.StringUtils;
import cn.pl.hmp.commons.enums.BoardType;
import cn.pl.hmp.commons.enums.RcuLineType;
import cn.pl.hmp.server.business.iface.IHotelRoomBusiness;
import cn.pl.hmp.server.dao.entity.HotelRCUCfg;
import cn.pl.hmp.server.dao.entity.HotelRCUCfgExample;
import cn.pl.hmp.server.dao.entity.HotelRoom;
import cn.pl.hmp.server.dao.entity.HotelRoomExample;
import cn.pl.hmp.server.dao.entity.HotelRoomType;
import cn.pl.hmp.server.dao.entity.HotelRoomTypeExample;
import cn.pl.hmp.server.dao.entity.RoomRCUCfg;
import cn.pl.hmp.server.dao.entity.RoomRCUCfgExample;
import cn.pl.hmp.server.dao.mapper.DataDictMapper;
import cn.pl.hmp.server.dao.mapper.HotelRCUCfgMapper;
import cn.pl.hmp.server.dao.mapper.HotelRoomMapper;
import cn.pl.hmp.server.dao.mapper.HotelRoomTypeMapper;
import cn.pl.hmp.server.dao.mapper.RoomRCUCfgMapper;
import cn.pl.hmp.server.utils.PageConverter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class HotelRoomBusinessImpl extends BoostBusinessImpl implements IHotelRoomBusiness {

    @Autowired
    private HotelRoomMapper mapper;
    @Autowired
    private RoomRCUCfgMapper roomRCUCfgMapper;
    @Autowired
    private RoomRCUCfgMapper rcuMapper;
    @Autowired
    private HotelRCUCfgMapper hotelRcuMapper;
    @Autowired
    private DataDictMapper dictMapper;
    @Autowired
    private HotelRoomTypeMapper roomTypeMapper;

    @Override
    public int deleteByHotelRoomId(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public long insert(HotelRoom record) {
        mapper.insertSelective(record);
        return record.getId();
    }

    @Override
    public HotelRoom selectByHotelRoomId(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<HotelRoom> selectAll() {
        return mapper.selectByExample(new HotelRoomExample());
    }

    @Override
    public int update(HotelRoom record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public Map<Pages, List<HotelRoom>> selectByPages(Long hotelId, Pages page) {
        Map<Pages, List<HotelRoom>> map = new HashMap<Pages, List<HotelRoom>>();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<HotelRoom> hotelRoomList = mapper.selectListAddUniqueNum(hotelId);
        if (null == hotelRoomList)
            hotelRoomList = new ArrayList<HotelRoom>();
        PageInfo<HotelRoom> pageInfo = new PageInfo<HotelRoom>(hotelRoomList);
        Pages pages = PageConverter.converter(pageInfo);

        map.put(pages, hotelRoomList);
        return map;
    }

    @Override
    public int deleteOnBatch(List<Long> idList) {
        return 0;
        // return mapper.deleteOnBatch(idList);
    }

    @Override
    public int saveOnBatch(HotelRoom record, String templateCfg, String roomNums) {
        if (null == record || null == roomNums || "".equals(roomNums.trim()))
            return 0;
//        List<HotelRoom> roomList = new ArrayList<HotelRoom>();
        int count = Integer.parseInt(roomNums);
        if (count < 1)
            return 0;
        int roomNum = Integer.parseInt(record.getRoomNum());
        int ip = -1;
        int rcuIp = -1;
        
        String[] ipArray = null;
        if (StringUtils.isNotBlank(record.getIp())) {
            ipArray = new String[4];
        	ipArray = record.getIp().split("\\.");
        	if (4 == ipArray.length)
        		ip = Integer.parseInt(ipArray[ipArray.length - 1]);
        }
        
        
        String[] rcuIpArray = null;
        if (StringUtils.isNotBlank(record.getRcuIp())) {
            rcuIpArray = new String[4];
        	rcuIpArray = record.getRcuIp().split("\\.");
        	if (4 == rcuIpArray.length)
        		rcuIp = Integer.parseInt(rcuIpArray[rcuIpArray.length - 1]);
        }
        
        HotelRoomExample example = new HotelRoomExample();
        example.createCriteria().andHotelIdEqualTo(record.getHotelId());
        example.createCriteria().andUnitEqualTo(record.getUnit());
        List<HotelRoom> list = mapper.selectByExample(example);
        List<String> roomNumList = new ArrayList<String>();
        for(HotelRoom hotelRoom:list) {
        	if (null != hotelRoom.getRoomNum())
        		roomNumList.add(hotelRoom.getRoomNum());
        }
        
        for (int i = 0; i < count; i++, roomNum++) {
    		String room = String.format("%0" + record.getRoomNum().length() + "d", roomNum);
        	if (!roomNumList.contains(room)) {
        		record = record.clone(record);
        		record.setId(new Long(0));
        		record.setRoomNum(room);
        		
        		if(ipArray != null ) {
        		    if (-1 != ip) {
        		        record.setIp(ipArray[0] + "." + ipArray[1] + "." + ipArray[2] + "." + ip + "");
        		        ip++; 
        		    }
        		}
        		
        		if(rcuIpArray != null ) {
            		if (-1 != rcuIp) {
            			record.setRcuIp(rcuIpArray[0] + "." + rcuIpArray[1] + "." + rcuIpArray[2] + "." + rcuIp + "");
            			rcuIp++;
            		}
        		}
             // 解析templateCfg
                List<RoomRCUCfg> roomRCUCfgs = new ArrayList<RoomRCUCfg>();
                // light:1@镜前灯;2@卫间灯带;Air:1@中央空调;
                if (null != templateCfg && !"".equals(templateCfg)) {
                	String light = templateCfg.substring(templateCfg.indexOf("Light") + 6, templateCfg.indexOf("Air"));
                    String[] lightStrs = light.split(";");
                    for (int j = 0; j < lightStrs.length; j++) {
                        String tempStr = lightStrs[j];
                        if (tempStr.length() > 0) {
                            String[] lightSingleStr = tempStr.split("@");
                            RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
                            roomRCUCfg.setHotelId(record.getHotelId());
                            roomRCUCfg.setNum(lightSingleStr[0]);

                            if (lightSingleStr.length >= 2) {
                                roomRCUCfg.setName(lightSingleStr[1]);
                            } else {
                                roomRCUCfg.setName("");
                            }
                            roomRCUCfg.setRoomType(record.getRoomType());
                            roomRCUCfg.setRoomId(record.getId());
                            roomRCUCfg.setCreateTime(new Date());
                            roomRCUCfg.setModifyTime(new Date());
                            roomRCUCfg.setLineType("Light");
                            roomRCUCfgs.add(roomRCUCfg);
                        }
                    }
                    String air = templateCfg.substring(templateCfg.indexOf("Air") + 4, templateCfg.indexOf("Curtain"));
                    lightStrs = air.split(";");
                    for (int j = 0; j < lightStrs.length; j++) {
                        String tempStr = lightStrs[j];
                        if (tempStr.length() > 0) {
                            String[] lightSingleStr = tempStr.split("@");
                            RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
                            roomRCUCfg.setHotelId(record.getHotelId());
                            roomRCUCfg.setNum(lightSingleStr[0]);
                            if (lightSingleStr.length >= 2) {
                                roomRCUCfg.setName(lightSingleStr[1]);
                            } else {
                                roomRCUCfg.setName("");
                            }
                            roomRCUCfg.setRoomType(record.getRoomType());
                            roomRCUCfg.setRoomId(record.getId());
                            roomRCUCfg.setCreateTime(new Date());
                            roomRCUCfg.setModifyTime(new Date());
                            roomRCUCfg.setLineType("Air");
                            roomRCUCfgs.add(roomRCUCfg);
                        }
                    }

                    String curtain = templateCfg.substring(templateCfg.indexOf("Curtain") + 8, templateCfg.indexOf("PWMLight"));
                    lightStrs = curtain.split(";");
                    for (int j = 0; j < lightStrs.length; j++) {
                        String tempStr = lightStrs[j];
                        if (tempStr.length() > 0) {
                            String[] lightSingleStr = tempStr.split("@");
                            RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
                            roomRCUCfg.setHotelId(record.getHotelId());
                            roomRCUCfg.setNum(lightSingleStr[0]);
                            if (lightSingleStr.length >= 2) {
                                roomRCUCfg.setName(lightSingleStr[1]);
                            } else {
                                roomRCUCfg.setName("");
                            }
                            roomRCUCfg.setRoomType(record.getRoomType());
                            roomRCUCfg.setRoomId(record.getId());
                            roomRCUCfg.setCreateTime(new Date());
                            roomRCUCfg.setModifyTime(new Date());
                            roomRCUCfg.setLineType("Curtain");
                            roomRCUCfgs.add(roomRCUCfg);
                        }
                    }
                    String pwmLight = templateCfg.substring(templateCfg.indexOf("PWMLight") + 9,
                            templateCfg.indexOf("AdjustLight"));
                    lightStrs = pwmLight.split(";");
                    for (int j = 0; j < lightStrs.length; j++) {
                        String tempStr = lightStrs[j];
                        if (tempStr.length() > 0) {
                            String[] lightSingleStr = tempStr.split("@");
                            RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
                            roomRCUCfg.setHotelId(record.getHotelId());
                            roomRCUCfg.setNum(lightSingleStr[0]);
                            if (lightSingleStr.length >= 2) {
                                roomRCUCfg.setName(lightSingleStr[1]);
                            } else {
                                roomRCUCfg.setName("");
                            }
                            roomRCUCfg.setRoomType(record.getRoomType());
                            roomRCUCfg.setRoomId(record.getId());
                            roomRCUCfg.setCreateTime(new Date());
                            roomRCUCfg.setModifyTime(new Date());
                            roomRCUCfg.setLineType("PWMLight");
                            roomRCUCfgs.add(roomRCUCfg);
                        }
                    }
                    String adjustLight = templateCfg.substring(templateCfg.indexOf("AdjustLight") + 12);
                    lightStrs = adjustLight.split(";");
                    for (int j = 0; j < lightStrs.length; j++) {
                        String tempStr = lightStrs[j];
                        if (tempStr.length() > 0) {
                            String[] lightSingleStr = tempStr.split("@");
                            RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
                            roomRCUCfg.setHotelId(record.getHotelId());
                            roomRCUCfg.setNum(lightSingleStr[0]);
                            if (lightSingleStr.length >= 2) {
                                roomRCUCfg.setName(lightSingleStr[1]);
                            } else {
                                roomRCUCfg.setName("");
                            }
                            roomRCUCfg.setRoomType(record.getRoomType());
                            roomRCUCfg.setRoomId(record.getId());
                            roomRCUCfg.setCreateTime(new Date());
                            roomRCUCfg.setModifyTime(new Date());
                            roomRCUCfg.setLineType("AdjustLight");
                            roomRCUCfgs.add(roomRCUCfg);
                        }
                    }
                }
                
//                int rets = mapper.insertBatch(roomList);
            	record.setCreateTime(new Date());
            	record.setModifyTime(new Date());
                long roomId = insert(record);
                if (roomId < 1) {
                	return 0;
                }
                // 插入修改后的模板。
                if (roomRCUCfgs.size() > 0) {
                    for (RoomRCUCfg entity : roomRCUCfgs) {
                        entity.setRoomId(roomId);
                        roomRCUCfgMapper.insert(entity);
                    }
                }
                
        	}
        }
        
        return 1;
    }

    @Override
    public long updateAndRcu(HotelRoom hotelRoom, String templateCfg, long hotelId) {
        if (hotelRoom == null) {
            return 0;
        }
        // 查询出该房间相关的rcu模板配置。注意不是原始模板。
        RoomRCUCfgExample roomRCUCfgExample = new RoomRCUCfgExample();
        if (hotelRoom.getId() != null) {
            roomRCUCfgExample.createCriteria().andHotelIdEqualTo(hotelId).andRoomIdEqualTo(hotelRoom.getId());
        }
        List<RoomRCUCfg> oldRoomRCUCfgs = roomRCUCfgMapper.selectByExample(roomRCUCfgExample);
        try {
            // 先删除之前的rcu配置。
            if (oldRoomRCUCfgs != null && !oldRoomRCUCfgs.isEmpty()) {
                for (RoomRCUCfg roomRCUCfg : oldRoomRCUCfgs) {
                    roomRCUCfgMapper.deleteByPrimaryKey(roomRCUCfg.getId());
                }
            }   
            // 解析templateCfg
            List<RoomRCUCfg> roomRCUCfgs = new ArrayList<RoomRCUCfg>();
            // light:1@镜前灯;2@卫间灯带;Air:1@中央空调;
            String light = templateCfg.substring(templateCfg.indexOf("Light") + 6, templateCfg.indexOf("Air"));
            String[] lightStrs = light.split(";");
            for (int i = 0; i < lightStrs.length; i++) {
                String tempStr = lightStrs[i];
                if (tempStr.length() > 0) {
                    String[] lightSingleStr = tempStr.split("@");
                    RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
                    roomRCUCfg.setHotelId(hotelId);
                    roomRCUCfg.setNum(lightSingleStr[0]);

                    if (lightSingleStr.length >= 2) {
                        roomRCUCfg.setName(lightSingleStr[1]);
                    } else {
                        roomRCUCfg.setName("");
                    }
                    roomRCUCfg.setRoomType(hotelRoom.getRoomType());
                    roomRCUCfg.setRoomId(hotelRoom.getId());
                    roomRCUCfg.setCreateTime(new Date());
                    roomRCUCfg.setModifyTime(new Date());
                    roomRCUCfg.setLineType("Light");
                    roomRCUCfgs.add(roomRCUCfg);
                }
            }
            String air = templateCfg.substring(templateCfg.indexOf("Air") + 4, templateCfg.indexOf("Curtain"));
            lightStrs = air.split(";");
            for (int i = 0; i < lightStrs.length; i++) {
                String tempStr = lightStrs[i];
                if (tempStr.length() > 0) {
                    String[] lightSingleStr = tempStr.split("@");
                    RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
                    roomRCUCfg.setHotelId(hotelId);
                    roomRCUCfg.setNum(lightSingleStr[0]);
                    if (lightSingleStr.length >= 2) {
                        roomRCUCfg.setName(lightSingleStr[1]);
                    } else {
                        roomRCUCfg.setName("");
                    }
                    roomRCUCfg.setRoomType(hotelRoom.getRoomType());
                    roomRCUCfg.setRoomId(hotelRoom.getId());
                    roomRCUCfg.setCreateTime(new Date());
                    roomRCUCfg.setModifyTime(new Date());
                    roomRCUCfg.setLineType("Air");
                    roomRCUCfgs.add(roomRCUCfg);
                }
            }

            String curtain = templateCfg.substring(templateCfg.indexOf("Curtain") + 8, templateCfg.indexOf("PWMLight"));
            lightStrs = curtain.split(";");
            for (int i = 0; i < lightStrs.length; i++) {
                String tempStr = lightStrs[i];
                if (tempStr.length() > 0) {
                    String[] lightSingleStr = tempStr.split("@");
                    RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
                    roomRCUCfg.setHotelId(hotelId);
                    roomRCUCfg.setNum(lightSingleStr[0]);
                    if (lightSingleStr.length >= 2) {
                        roomRCUCfg.setName(lightSingleStr[1]);
                    } else {
                        roomRCUCfg.setName("");
                    }
                    roomRCUCfg.setRoomType(hotelRoom.getRoomType());
                    roomRCUCfg.setRoomId(hotelRoom.getId());
                    roomRCUCfg.setCreateTime(new Date());
                    roomRCUCfg.setModifyTime(new Date());
                    roomRCUCfg.setLineType("Curtain");
                    roomRCUCfgs.add(roomRCUCfg);
                }
            }
            String pwmLight = templateCfg.substring(templateCfg.indexOf("PWMLight") + 9,
                    templateCfg.indexOf("AdjustLight"));
            lightStrs = pwmLight.split(";");
            for (int i = 0; i < lightStrs.length; i++) {
                String tempStr = lightStrs[i];
                if (tempStr.length() > 0) {
                    String[] lightSingleStr = tempStr.split("@");
                    RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
                    roomRCUCfg.setHotelId(hotelId);
                    roomRCUCfg.setNum(lightSingleStr[0]);
                    if (lightSingleStr.length >= 2) {
                        roomRCUCfg.setName(lightSingleStr[1]);
                    } else {
                        roomRCUCfg.setName("");
                    }
                    roomRCUCfg.setRoomType(hotelRoom.getRoomType());
                    roomRCUCfg.setRoomId(hotelRoom.getId());
                    roomRCUCfg.setCreateTime(new Date());
                    roomRCUCfg.setModifyTime(new Date());
                    roomRCUCfg.setLineType("PWMLight");
                    roomRCUCfgs.add(roomRCUCfg);
                }
            }
            String adjustLight = templateCfg.substring(templateCfg.indexOf("AdjustLight") + 12);
            lightStrs = adjustLight.split(";");
            for (int i = 0; i < lightStrs.length; i++) {
                String tempStr = lightStrs[i];
                if (tempStr.length() > 0) {
                    String[] lightSingleStr = tempStr.split("@");
                    RoomRCUCfg roomRCUCfg = new RoomRCUCfg();
                    roomRCUCfg.setHotelId(hotelId);
                    roomRCUCfg.setNum(lightSingleStr[0]);
                    if (lightSingleStr.length >= 2) {
                        roomRCUCfg.setName(lightSingleStr[1]);
                    } else {
                        roomRCUCfg.setName("");
                    }
                    roomRCUCfg.setRoomType(hotelRoom.getRoomType());
                    roomRCUCfg.setRoomId(hotelRoom.getId());
                    roomRCUCfg.setCreateTime(new Date());
                    roomRCUCfg.setModifyTime(new Date());
                    roomRCUCfg.setLineType("AdjustLight");
                    roomRCUCfgs.add(roomRCUCfg);
                }
            }
            // 操作数据库
            if (hotelRoom.getId() != 0) {
                // 修改hotelRoom
                hotelRoom.setModifyTime(new Date());
                update(hotelRoom);
                // 插入修改后的模板。
                if (roomRCUCfgs.size() > 0) {
                    for (RoomRCUCfg entity : roomRCUCfgs) {
                        roomRCUCfgMapper.insert(entity);
                    }
                }
            } else {
                hotelRoom.setHotelId(hotelId);
                hotelRoom.setCreateTime(new Date());
                hotelRoom.setModifyTime(new Date());
                long roomId = insert(hotelRoom);
                // 插入修改后的模板。
                if (roomRCUCfgs.size() > 0) {
                    for (RoomRCUCfg entity : roomRCUCfgs) {
                        entity.setRoomId(roomId);
                        roomRCUCfgMapper.insert(entity);
                    }
                }
                // 插入的时候需要返回插入后的房间Id。
                return roomId;
            }
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 封装房间rcu信息到json数据
     * 
     * @param roomRcu
     * @param rcuObj
     * @param boardType
     * @param lightStart
     * @param airStart
     */
    public void saveRcu(RoomRCUCfg roomRcu, JSONObject rcuObj, BoardType boardType, int lightStart, int airStart) {
        String lineType = roomRcu.getLineType();
        if (null == boardType)
            boardType = BoardType.PINGLIAN;

        switch (boardType) {
        case PINGLIAN:
            if (roomRcu.getName() != null) {
                try {
                    rcuObj.put("name", roomRcu.getName());
                    int t = 0;
                    try {
                        t = Integer.parseInt(roomRcu.getNum());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    rcuObj.put("num", t);// 路数
                    rcuObj.put("id", t);// ID.屏联的id跟路数一样
                    if (RcuLineType.AdjustLight.name().equalsIgnoreCase(lineType)) {
                        rcuObj.put("state", 0);// state
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        case WANTONG:
            if (roomRcu.getName() != null) {
                try {
                    rcuObj.put("name", roomRcu.getName());
                    int t = 0;
                    int idNum = 0;
                    try {
                        idNum = Integer.parseInt(roomRcu.getNum());
                        t = idNum;
                        if (RcuLineType.Light.name().equalsIgnoreCase(lineType)
                                || RcuLineType.Curtain.name().equalsIgnoreCase(lineType)) {
                            t = ((((t - 1) / 8) + lightStart) << 8) + ((t - 1) % 8);
                        } else if (RcuLineType.Air.name().equalsIgnoreCase(lineType)) {
                            t = airStart;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    rcuObj.put("num", t);// 路数：需要算一下。
                    rcuObj.put("id", idNum);// ID.万通的ID直接取路数
                    if (RcuLineType.AdjustLight.name().equalsIgnoreCase(lineType)) {
                        rcuObj.put("state", 0);// state
                    }
                    System.err
                            .println("wantong:  name:" + roomRcu.getName() + ",num:" + t + ",id:" + t + ",state:" + 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        default:
            break;
        }
    }

    public void saveHotelRoom(HotelRoom room, JSONObject roomObj, HotelRCUCfg hotelRcuTemplate,
            Map<String, String> roomTypeNameMap,BoardType boardType) {
        String timeLock = hotelRcuTemplate.getTimeLock();
        Boolean hongwai = room.getIrCut();

        roomObj.put("houseType", room.getRoomType() == null ? "户型" : room.getHouseType());// 户型
        roomObj.put("area", null != room.getArea() ? room.getArea().intValue() : 0);// 面积
        roomObj.put("roomType", roomTypeNameMap.get(room.getRoomType()));// 房型

        roomObj.put("roomNum", room.getRoomNum());
        roomObj.put("rcuIp", room.getRcuIp());
        roomObj.put("port", hotelRcuTemplate.getPort());
        Long roomId = room.getId();
        try {
            roomId = Long.parseLong(room.getRoomNum());
        } catch (Exception e) {
            System.out.println(room.getRoomNum() + "---" + e);
        }
        roomObj.put("roomId", roomId);// roomId
        roomObj.put("boardType", boardType.toIntVal());// boardType
        roomObj.put("card", 1);// card==null?0:1
        roomObj.put("hongwai", null != hongwai ? (hongwai ? 1 : 0) : 0);// hongwai

        roomObj.put("unit", room.getUnit());// 楼
        roomObj.put("floor", room.getFloor());// 层
        roomObj.put("timeLock", StringUtils.isNotBlank(timeLock) ? timeLock : "-1");// 时间锁
    }

    @Override
    public JSONArray publish(Long hotelId) {
        JSONArray array = new JSONArray();
        HotelRoomExample roomExample = new HotelRoomExample();
        roomExample.createCriteria().andHotelIdEqualTo(hotelId);
        List<HotelRoom> roomList = mapper.selectByExample(roomExample);
        if (null == roomList || roomList.size() < 1) {
            return array;
        }
        
        //获取酒店rcu配置信息
        HotelRCUCfg hotelRcuTemplate = null;
        HotelRCUCfgExample hotelRcuExample = new HotelRCUCfgExample();
        hotelRcuExample.createCriteria().andHotelIdEqualTo(hotelId);
        List<HotelRCUCfg> hotelRcuList = hotelRcuMapper.selectByExample(hotelRcuExample);
        if (null == hotelRcuList || hotelRcuList.size() < 1) {
            return array;
        }else {
            hotelRcuTemplate = hotelRcuList.get(0);
        }
        if (null == hotelRcuTemplate) {
            return array;
        }
        
        //获取酒店所有房间rcu配置信息
        Map<String, List<RoomRCUCfg>> hotelRoomRcuMap = queryHotelRoomRcuCfg(hotelId);

        // 查询房型字典信息
        Map<String, String> roomTypeNameMap = queryHotelRoomType(hotelId);
        
        //板卡类型
        String sboardType = hotelRcuTemplate.getBoardType();
        BoardType boardType = BoardType.PINGLIAN;
        if (null != sboardType && !("".equals(sboardType.trim()))) {
            sboardType = dictMapper.selectByPrimaryKey(Long.parseLong(sboardType)).getNameCn();
            if(null !=sboardType && sboardType.length() >= 2) {
                String headToken = sboardType.substring(0,2);
                if("wt".equals(headToken)) {
                    boardType = BoardType.WANTONG;
                }
            }
        }
        
        int lightStart = hotelRcuTemplate.getLightStart();
        int airStart = hotelRcuTemplate.getAirConditionerStart();
        
        List<RoomRCUCfg> tempRoomRcuList = null;
        for (HotelRoom room : roomList) {
            JSONObject roomObj = new JSONObject();
            saveHotelRoom(room, roomObj, hotelRcuTemplate, roomTypeNameMap,boardType);
            RcuLineType[] RcuLineTypes = RcuLineType.values();
            JSONArray roomRcuArray = null;
            JSONObject roomRcuTemp = null;
            for (RcuLineType lineType : RcuLineTypes) {
                roomRcuArray = new JSONArray();
                tempRoomRcuList = hotelRoomRcuMap.get(room.getId()+"-"+lineType.name());
                if(tempRoomRcuList != null && !tempRoomRcuList.isEmpty()) {
                    for (RoomRCUCfg roomRcu : tempRoomRcuList) {
                        roomRcuTemp = new JSONObject();
                        saveRcu(roomRcu, roomRcuTemp, boardType, lightStart, airStart);
                        roomRcuArray.add(roomRcuTemp);
                    }
                }
                roomObj.put(lineType.name(), roomRcuArray);
            }
            array.add(roomObj);
        }
        return array;
    }
    /**
     * 获取某酒店的所有房间rcu配置信息
     * @param hotelId
     * @return
     */
    public Map<String,List<RoomRCUCfg>> queryHotelRoomRcuCfg(Long hotelId) {
        Map<String,List<RoomRCUCfg>> roomRcuMap = new HashMap<String, List<RoomRCUCfg>>();
        RoomRCUCfgExample roomRcuExample = new RoomRCUCfgExample();
        roomRcuExample.createCriteria().andHotelIdEqualTo(hotelId);
        List<RoomRCUCfg> roomRcuList = rcuMapper.selectByExample(roomRcuExample);
        String tempKey = null;
        List<RoomRCUCfg> tempRoomRcuList = null;
        if(null != roomRcuList && !roomRcuList.isEmpty()) {
            for(RoomRCUCfg roomRcu : roomRcuList) {
                tempKey = roomRcu.getRoomId()+"-"+roomRcu.getLineType();
                if(roomRcuMap.containsKey(tempKey)) {
                    roomRcuMap.get(tempKey).add(roomRcu);
                }else {
                    tempRoomRcuList = new ArrayList<RoomRCUCfg>();
                    tempRoomRcuList.add(roomRcu);
                    roomRcuMap.put(tempKey, tempRoomRcuList);
                }
            }
        }
        return roomRcuMap;
    }
    /**
     * 获取某酒店的所有房间类型配置信息
     * @param hotelId
     * @return
     */
    public Map<String,String> queryHotelRoomType(Long hotelId) {
        HotelRoomTypeExample example = new HotelRoomTypeExample();
        example.createCriteria().andHotelIdEqualTo(hotelId);
        List<HotelRoomType> roomTypeList = roomTypeMapper.selectByExample(example);
        Map<String, String> roomTypeNameMap = new HashMap<String, String>();
        if (null != roomTypeList && roomTypeList.size() > 0) {
            for (HotelRoomType roomType : roomTypeList) {
                if (null != roomType) {
                    roomTypeNameMap.put(roomType.getId()+"", roomType.getName());
                }
            }
        }
        return roomTypeNameMap;
    }

    @Override
    public List<HotelRoom> selectByExample(HotelRoomExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Long insertRoomAndType(HotelRoom room) {
        if(null == room) {
            return 0L;
        }
        room.setRoomType(getRoomTypeId(room)+"");
        HotelRoomExample example = new HotelRoomExample();
        example.createCriteria().andHotelIdEqualTo(room.getHotelId())
        .andRoomNumEqualTo(room.getRoomNum());
        List<HotelRoom> roomList = mapper.selectByExample(example);
        if(null != roomList && !roomList.isEmpty()) {
            room.setId(roomList.get(0).getId());
            return (long) mapper.updateByPrimaryKeySelective(room);
        }
        mapper.insertSelective(room);
        return room.getId();
    }
    
    public Long getRoomTypeId(HotelRoom room) {
        HotelRoomTypeExample example = new HotelRoomTypeExample();
        example.createCriteria().andHotelIdEqualTo(room.getHotelId())
        .andNameEqualTo(room.getRoomType());
        List<HotelRoomType> roomTypeList = roomTypeMapper.selectByExample(example);
        if(null != roomTypeList && !roomTypeList.isEmpty()) {
            return roomTypeList.get(0).getId();
        }else {
            HotelRoomType roomType = new HotelRoomType();
            roomType.setCreateTime(new Date());
            roomType.setHotelId(room.getHotelId());
            roomType.setName(room.getRoomType());
            roomType.setCreator(room.getCreator());
            roomTypeMapper.insertSelective(roomType);
            return roomType.getId();
        }
    }

    @Override
    public int updateRcuTimeOnBatch(HotelRoom record, String roomNums) {
        int count = 0;
        if(StringUtils.isBlank(roomNums)) {
            return count;
        }
        HotelRoomExample roomExample = new HotelRoomExample();
        roomExample.createCriteria().andHotelIdEqualTo(record.getHotelId());
        List<HotelRoom> roomList = mapper.selectByExample(roomExample);
        Map<String,HotelRoom> roomNumMap = new HashMap<String,HotelRoom>();
        for(HotelRoom room : roomList) {
            roomNumMap.put(room.getRoomNum(), room);
        }
        Date nowDate = new Date();
        HotelRoom updateRoom = null;
        int res = -1;
        String[] roomNumArray = roomNums.split(",");
        if(null != roomNumArray && roomNumArray.length > 0 ) {
            for(String roomNum : roomNumArray) {
                if(roomNumMap.containsKey(roomNum)) {
                    updateRoom = roomNumMap.get(roomNum);
                    updateRoom.setModifyTime(nowDate);
                    updateRoom.setRcuTime(record.getRcuTime());
                    res = mapper.updateByPrimaryKeySelective(updateRoom);
                    if(res > 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
