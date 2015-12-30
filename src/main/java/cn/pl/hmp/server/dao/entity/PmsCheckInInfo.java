package cn.pl.hmp.server.dao.entity;

import java.util.Date;

public class PmsCheckInInfo {
    private Long id;

    private Long sysId;

    private Long orgId;

    private Long guestId;

    private Long chainId;

    private String hotelName;

    private Long sourceId;

    private String groupId;

    private String roomNum;

    private String roomTypeCn;

    private String roomTypeEn;

    private String newRoomNum;

    private String oldRoomNum;

    private Date checkInTime;

    private Date checkOutTime;

    private Date changeTime;

    private String checkFlag;

    private String postType;

    private Long tranId;

    private Date createTime;

    private Date modifyTime;
    
    private String guestName;
    
    private String sex;
    
    private String birthday;
    
    private String mobile;
    
    private String roomType;
    
    private Integer age;
    
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public Long getChainId() {
        return chainId;
    }

    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum == null ? null : roomNum.trim();
    }

    public String getRoomTypeCn() {
        return roomTypeCn;
    }

    public void setRoomTypeCn(String roomTypeCn) {
        this.roomTypeCn = roomTypeCn == null ? null : roomTypeCn.trim();
    }

    public String getRoomTypeEn() {
        return roomTypeEn;
    }

    public void setRoomTypeEn(String roomTypeEn) {
        this.roomTypeEn = roomTypeEn == null ? null : roomTypeEn.trim();
    }

    public String getNewRoomNum() {
        return newRoomNum;
    }

    public void setNewRoomNum(String newRoomNum) {
        this.newRoomNum = newRoomNum == null ? null : newRoomNum.trim();
    }

    public String getOldRoomNum() {
        return oldRoomNum;
    }

    public void setOldRoomNum(String oldRoomNum) {
        this.oldRoomNum = oldRoomNum == null ? null : oldRoomNum.trim();
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag == null ? null : checkFlag.trim();
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType == null ? null : postType.trim();
    }

    public Long getTranId() {
        return tranId;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}