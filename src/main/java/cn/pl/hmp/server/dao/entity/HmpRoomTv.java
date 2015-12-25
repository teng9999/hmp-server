package cn.pl.hmp.server.dao.entity;

import java.util.Date;

public class HmpRoomTv {
    private Long id;

    private Long sysId;

    private Long orgId;

    private String backMusic;

    private String helpImg;

    private String homeImg;

    private String logoImg;

    private String screenImg;

    private String solgan;

    private String tvCode;

    private String tvModel;

    private String tvNum;

    private Long roomId;

    private Long hotelId;

    private String welcomeCt;

    private String welcomeCtEn;

    private String welcomeImg;

    private String solganCn;

    private Date createTime;

    private Long creator;

    private Date modifyTime;

    private Long modifier;

    private Boolean available;
    
    private String signalSource;

    public String getSignalSource() {
        return signalSource;
    }

    public void setSignalSource(String signalSource) {
        this.signalSource = signalSource;
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

    public String getBackMusic() {
        return backMusic;
    }

    public void setBackMusic(String backMusic) {
        this.backMusic = backMusic == null ? null : backMusic.trim();
    }

    public String getHelpImg() {
        return helpImg;
    }

    public void setHelpImg(String helpImg) {
        this.helpImg = helpImg == null ? null : helpImg.trim();
    }

    public String getHomeImg() {
        return homeImg;
    }

    public void setHomeImg(String homeImg) {
        this.homeImg = homeImg == null ? null : homeImg.trim();
    }

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg == null ? null : logoImg.trim();
    }

    public String getScreenImg() {
        return screenImg;
    }

    public void setScreenImg(String screenImg) {
        this.screenImg = screenImg == null ? null : screenImg.trim();
    }

    public String getSolgan() {
        return solgan;
    }

    public void setSolgan(String solgan) {
        this.solgan = solgan == null ? null : solgan.trim();
    }

    public String getTvCode() {
        return tvCode;
    }

    public void setTvCode(String tvCode) {
        this.tvCode = tvCode == null ? null : tvCode.trim();
    }

    public String getTvModel() {
        return tvModel;
    }

    public void setTvModel(String tvModel) {
        this.tvModel = tvModel == null ? null : tvModel.trim();
    }

    public String getTvNum() {
        return tvNum;
    }

    public void setTvNum(String tvNum) {
        this.tvNum = tvNum == null ? null : tvNum.trim();
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

    public String getWelcomeCt() {
        return welcomeCt;
    }

    public void setWelcomeCt(String welcomeCt) {
        this.welcomeCt = welcomeCt == null ? null : welcomeCt.trim();
    }

    public String getWelcomeCtEn() {
        return welcomeCtEn;
    }

    public void setWelcomeCtEn(String welcomeCtEn) {
        this.welcomeCtEn = welcomeCtEn == null ? null : welcomeCtEn.trim();
    }

    public String getWelcomeImg() {
        return welcomeImg;
    }

    public void setWelcomeImg(String welcomeImg) {
        this.welcomeImg = welcomeImg == null ? null : welcomeImg.trim();
    }

    public String getSolganCn() {
        return solganCn;
    }

    public void setSolganCn(String solganCn) {
        this.solganCn = solganCn == null ? null : solganCn.trim();
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}