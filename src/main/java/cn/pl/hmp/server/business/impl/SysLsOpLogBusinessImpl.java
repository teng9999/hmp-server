package cn.pl.hmp.server.business.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.hmp.server.business.iface.ISysLsOpLogBusiness;
import cn.pl.hmp.server.dao.entity.CheckInDetail;
import cn.pl.hmp.server.dao.entity.CheckInSummary;
import cn.pl.hmp.server.dao.entity.CheckInSummaryExample;
import cn.pl.hmp.server.dao.entity.HotelRoom;
import cn.pl.hmp.server.dao.entity.HotelRoomExample;
import cn.pl.hmp.server.dao.entity.SysLsOpLog;
import cn.pl.hmp.server.dao.mapper.CheckInDetailMapper;
import cn.pl.hmp.server.dao.mapper.CheckInSummaryMapper;
import cn.pl.hmp.server.dao.mapper.HotelRoomMapper;
import cn.pl.hmp.server.dao.mapper.SysLsOpLogMapper;

@Service
public class SysLsOpLogBusinessImpl extends BoostBusinessImpl implements
        ISysLsOpLogBusiness {
    @Autowired
    private SysLsOpLogMapper mapper;
    @Autowired
    private HotelRoomMapper roomMapper;
    @Autowired
    private CheckInSummaryMapper summaryMapper;
    @Autowired
    private CheckInDetailMapper detailMapper;
    
    private Map<String, HotelRoom> roomMap;
    private Map<String, List<SysLsOpLog>> slMap;
    private Map<String,Long> earlyMap;//lastDay内每天最早的插卡时间
    private Map<String, String> summaryMap;//最近lastDay内的房间入住信息
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Logger log = LoggerFactory.getLogger(SysLsOpLogBusinessImpl.class);

    @Override
    public int[] saveTotalData(int lastDay) {
        String sbTime = null;
        String sdTime = null;
        if (lastDay < 1) {
            lastDay = 2;
        } 
        
        sbTime = sdf.format(getFormatDate(new Date(new Date().getTime() - lastDay*24 * 60 * 60 * 1000L), 0));
        summaryMap = getHistorySummaryMap(lastDay);
        sdTime = sdf.format(getFormatDate(new Date(new Date().getTime() - 24 * 60 * 60 * 1000L), 1));
        System.err.println("开始：" + sbTime + "，结束：" + sdTime);
        List<SysLsOpLog> list = mapper.selectByCondition(sbTime, sdTime);
        roomMap = getRoomMap();
        log.info("总共的操作日志条数:" + list.size());
        slMap = getSysLsOpMap(list);
        initEarliestMap(lastDay); //加载每天最早的插卡时间

        return saveAllData();

    }

    public int[] saveAllData() {
        int[] resArray = new int[2];
        List<CheckInSummary> summaryList = new ArrayList<CheckInSummary>();
        List<CheckInDetail> detailList = new ArrayList<CheckInDetail>();
        if (null != slMap && !slMap.isEmpty()) {
            for (String key : slMap.keySet()) {
                saveFormatLog(summaryList, detailList, slMap.get(key),
                        key);

                if (!summaryList.isEmpty() && summaryList.size() > 1000) {
                    resArray[0] = resArray[0]
                            + summaryMapper.insertOnBatch(summaryList);
                    summaryList.clear();
                    log.debug("添加了 summary 数据：" + summaryList.size()
                            + "---------------------------------");
                }
                if (!detailList.isEmpty() && detailList.size() > 1000) {
                    resArray[1] = detailMapper.insertOnBatch(detailList);
                    detailList.clear();
                    log.debug("添加了 detail 数据：" + detailList.size()
                            + "++++++++++++++++++++++++++++++++++");
                }
            }
        }
        System.err.println("大概数据个数:" + summaryList.size());
        System.err.println(",详细数据个数:" + detailList.size());
        if (!summaryList.isEmpty()) {
            resArray[0] = resArray[0]
                    + summaryMapper.insertOnBatch(summaryList);
            log.debug("添加了 summary 数据：" + summaryList.size()
                    + "---------------------------------");
        }
        if (!detailList.isEmpty()) {
            resArray[1] = detailMapper.insertOnBatch(detailList);
            log.debug("添加了 detail 数据：" + detailList.size()
                    + "++++++++++++++++++++++++++++++++++");
        }
        return resArray;

    }

    /**
     * 保存一个房间某段时间插卡取卡流程
     * 
     * @param list
     * @param hotelId
     * @param roomNum
     */
    public void saveFormatLog(List<CheckInSummary> summaryList,
            List<CheckInDetail> detailList, List<SysLsOpLog> list, String tempKey) {
        boolean token = true;
        Date firstOpTime = null; // 首次插卡时间
        Date lastOpTime = null; // 末次拔卡时间
        boolean tempCheckInStatus = false;

        String summaryKey = null;
        String earlyKey = null;

        SysLsOpLog sl = null;
        CheckInSummary summary = null;
        HotelRoom tempRoom = null;
        CheckInDetail tempDetail = null;
        Date yyesterday = new Date(new Date().getTime() - 2 * 24 * 60 * 60
                * 1000L);

        if (!roomMap.containsKey(tempKey)) {
            return;
        } else {
            System.out.println("tempKey:" + tempKey);
        }
        tempRoom = roomMap.get(tempKey);
        if (null == tempRoom) {
            return;
        }
        // 获取24小时前是否有人入住
        Long sysRoomId = tempRoom.getId();
        CheckInSummaryExample example = new CheckInSummaryExample();
        example.createCriteria().andPlugOutTimeBetween(getFormatDate(yyesterday, 0),
                        getFormatDate(yyesterday, 1))
                .andRoomIdEqualTo(sysRoomId);
        example.or( example.createCriteria().andPlugInTimeBetween(getFormatDate(yyesterday, 0),
                getFormatDate(yyesterday, 1))
        .andRoomIdEqualTo(sysRoomId));
        List<CheckInSummary> ysummaryList = summaryMapper
                .selectByExample(example);
        int lastRoomStatus = 0;
        if (null != ysummaryList && !ysummaryList.isEmpty()) {
            lastRoomStatus = 1;
        }

        if (null != list && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                sl = list.get(i);
                if ("0".equals(sl.getOpData())) {
                    token = false;
                } else if ("1".equals(sl.getOpData())) {
                    token = true;
                } else {
                    continue;
                }

                if (token) {
                    if (!tempCheckInStatus) {
                        firstOpTime = sl.getOpTime();

                        tempCheckInStatus = true;
                    }
                } else {
                    if (tempCheckInStatus) {
                        lastOpTime = sl.getOpTime();
                        tempCheckInStatus = false;
                        int plugInterval = Math
                                .round((lastOpTime.getTime() - firstOpTime
                                        .getTime()) / (60 * 1000));
                        if (plugInterval < 30) {
                            continue;
                        }
                        // 验证该条入住信息是否已存在(如果存在则跳过改操作)
                        summaryKey = tempRoom.getId()+"_"+sdf.format(firstOpTime) + "_"
                                + sdf.format(lastOpTime);
                        if (summaryMap.containsKey(summaryKey)) {
                            continue;
                        }
                        
                        //验证是否为有效的插卡操作
                        earlyKey = tempRoom.getId()+"_" + sdf.format(getFormatDate(firstOpTime, 0));
                        if(earlyMap.containsKey(earlyKey)) {
                            if(firstOpTime.getTime() <= earlyMap.get(earlyKey)) {
                                continue;
                            }
                        }

                        // 入房插卡操作记录
                        tempDetail = new CheckInDetail();
                        tempDetail.setOpStatus(1);
                        tempDetail.setOpTime(firstOpTime);
                        tempDetail.setRoomStatus(1);
                        tempDetail.setHotelId(tempRoom.getHotelId());
                        tempDetail.setRoomId(tempRoom.getId());
                        tempDetail.setCreateTime(new Date());
                        detailList.add(tempDetail);
                        // 退房插卡操作记录
                        tempDetail = new CheckInDetail();
                        tempDetail.setOpStatus(0);
                        tempDetail.setOpTime(lastOpTime);
                        tempDetail.setRoomStatus(0);
                        tempDetail.setHotelId(tempRoom.getHotelId());
                        tempDetail.setRoomId(tempRoom.getId());
                        tempDetail.setCreateTime(new Date());
                        detailList.add(tempDetail);
                        // 一次住房的总记录操作记录
                        summary = new CheckInSummary();
                        summary.setRoomId(tempRoom.getId());
                        summary.setHotelId(tempRoom.getHotelId());
                        summary.setPlugInTime(firstOpTime);
                        summary.setPlugOutTime(lastOpTime);
                        summary.setCheckInTime(getFormatDate(firstOpTime, 0));
                        summary.setPlugInterval(plugInterval);
                        summary.setLastRoomStatus(lastRoomStatus);
                        summary.setCreateTime(new Date());
                        summaryList.add(summary);
                    }
                }
            }
        }
    }

    /**
     * 凌晨
     * 
     * @param date
     * @flag 0 返回yyyy-MM-dd 00:00:00日期<br>
     *       1 返回yyyy-MM-dd 23:59:59日期
     * @return
     */
    public static Date getFormatDate(Date date, int flag) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        // 时分秒（毫秒数）
        long millisecond = hour * 60 * 60 * 1000 + minute * 60 * 1000 + second
                * 1000;
        // 凌晨00:00:00
        cal.setTimeInMillis(cal.getTimeInMillis() - millisecond);

        if (flag == 0) {
            return cal.getTime();
        } else if (flag == 1) {
            // 凌晨23:59:59
            cal.setTimeInMillis(cal.getTimeInMillis() + 23 * 60 * 60 * 1000
                    + 59 * 60 * 1000 + 59 * 1000);
        }
        return cal.getTime();
    }

    /**
     * 获取某酒店的房间对应关系
     * 
     * @param hotelId
     */
    public Map<String, HotelRoom> getRoomMap() {
        String keyTemp = null;
        Map<String, HotelRoom> roomMap = new HashMap<String, HotelRoom>();
        List<HotelRoom> roomList = roomMapper
                .selectByExample(new HotelRoomExample());
        if (null != roomList && !roomList.isEmpty()) {
            for (HotelRoom room : roomList) {
                if (null == room) {
                    continue;
                }
                keyTemp = room.getHotelId() + "-" + room.getRoomNum();
                roomMap.put(keyTemp, room);
            }
        }
        return roomMap;
    }

    /**
     * 获取酒店房间房态对应关系
     * 
     * @param list
     * @return
     */
    public Map<String, List<SysLsOpLog>> getSysLsOpMap(List<SysLsOpLog> list) {
        List<SysLsOpLog> tempList = null;
        String keyTemp = null;
        // 每个酒店房间号对应的房间插拔卡列表
        Map<String, List<SysLsOpLog>> slMap = new HashMap<String, List<SysLsOpLog>>();
        if (null != list && !list.isEmpty()) {
            for (SysLsOpLog op : list) {
                if (null == op) {
                    continue;
                }
                keyTemp = op.getHotelId() + "-" + op.getRoomNum();
                if (!slMap.containsKey(keyTemp)) {
                    tempList = new ArrayList<SysLsOpLog>();
                    slMap.put(keyTemp, tempList);
                } else {
                    tempList = slMap.get(keyTemp);
                }
                tempList.add(op);
            }
        }
        return slMap;
    }

    /**
     * 获取最近几天住房概况日期对应关系 （为了插入时排除已插入信息）
     * 
     * @param lastDay
     * @return
     */
    public Map<String, String> getHistorySummaryMap(int lastDay) {
        Map<String, String> summaryMap = new HashMap<String, String>();
        CheckInSummaryExample example = new CheckInSummaryExample();
        String keyTemp = null;
        example.createCriteria().andCheckInTimeGreaterThan(
                getFormatDate(new Date(new Date().getTime() - (lastDay+1) * 24 * 60
                        * 60 * 1000L), 1));
        List<CheckInSummary> list = summaryMapper.selectByExample(example);
        if (null != list && !list.isEmpty()) {
            for (CheckInSummary summary : list) {
                if (null == summary) {
                    continue;
                }
                keyTemp =summary.getRoomId()+"_" + sdf.format(summary.getPlugInTime()) + "_"
                        + sdf.format(summary.getPlugOutTime());
                if (!summaryMap.containsKey(keyTemp)) {
                    summaryMap.put(keyTemp, null);
                }
            }
        }
        return summaryMap;
    }
    
    public void initEarliestMap(int lastDay) {
        Date beginTime =getFormatDate(new Date(new Date().getTime() - lastDay * 24 * 60
                * 60 * 1000L), 0);
        String keyTemp = null;
        List<CheckInSummary> list = summaryMapper.selectEarliestInList(sdf.format(beginTime));
        if (null != list && !list.isEmpty()) {
            earlyMap = new HashMap<String, Long>();
            for (CheckInSummary summary : list) {
                if (null == summary) {
                    continue;
                }
                keyTemp =summary.getRoomId()+"_" + sdf.format(summary.getCheckInTime());
                if (!earlyMap.containsKey(keyTemp)) {
                    earlyMap.put(keyTemp, summary.getPlugInTime().getTime());
                }
            }
        }
    }
}
