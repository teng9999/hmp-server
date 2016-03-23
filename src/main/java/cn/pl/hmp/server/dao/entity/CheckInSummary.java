package cn.pl.hmp.server.dao.entity;

import java.util.Date;

public class CheckInSummary {
    private Long id;

    private Long sysId;

    private Long orgId;

    private Long roomId;

    private Long hotelId;
    //24小时前开房状态 0:没人 1:有人
    private Integer lastRoomStatus;
    //插拔卡次数
    private Integer plugNumber;
    //插拔卡间隔时长
    private Integer plugInterval;
    //首次插卡时间
    private Date plugInTime;
    //末次拔卡时间
    private Date plugOutTime;
    //首次开放时间
    private Date checkInTime;

    private Date createTime;

    private Long creator;

    private Date modifyTime;

    private Long modifier;
    
    private String roomType;
    
    private String unit;
    
    private Integer floor;
    
    private String roomNum;
    
    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public Integer getPlugInterval() {
        return plugInterval;
    }

    public void setPlugInterval(Integer plugInterval) {
        this.plugInterval = plugInterval;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getLastRoomStatus() {
        return lastRoomStatus;
    }

    public void setLastRoomStatus(Integer lastRoomStatus) {
        this.lastRoomStatus = lastRoomStatus;
    }

    public Integer getPlugNumber() {
        return plugNumber;
    }

    public void setPlugNumber(Integer plugNumber) {
        this.plugNumber = plugNumber;
    }

    public Date getPlugInTime() {
        return plugInTime;
    }

    public void setPlugInTime(Date plugInTime) {
        this.plugInTime = plugInTime;
    }

    public Date getPlugOutTime() {
        return plugOutTime;
    }

    public void setPlugOutTime(Date plugOutTime) {
        this.plugOutTime = plugOutTime;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }
}