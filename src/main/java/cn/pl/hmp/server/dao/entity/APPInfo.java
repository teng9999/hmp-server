package cn.pl.hmp.server.dao.entity;

import java.util.Date;

public class APPInfo {
    private Long id;

    private Long sysId;

    private Long orgId;

    private String nameCn;

    private String nameEn;

    private String firstSpell;

    private String allSpell;

    private String androidAddr;

    private String iosAddr;

    private String secondAddr;

    private String intro;

    private String appImage;

    private Date createTime;

    private Long creator;

    private Date modifyTime;

    private Long modifier;

    private Boolean available;

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

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public String getFirstSpell() {
        return firstSpell;
    }

    public void setFirstSpell(String firstSpell) {
        this.firstSpell = firstSpell == null ? null : firstSpell.trim();
    }

    public String getAllSpell() {
        return allSpell;
    }

    public void setAllSpell(String allSpell) {
        this.allSpell = allSpell == null ? null : allSpell.trim();
    }

    public String getAndroidAddr() {
        return androidAddr;
    }

    public void setAndroidAddr(String androidAddr) {
        this.androidAddr = androidAddr == null ? null : androidAddr.trim();
    }

    public String getIosAddr() {
        return iosAddr;
    }

    public void setIosAddr(String iosAddr) {
        this.iosAddr = iosAddr == null ? null : iosAddr.trim();
    }

    public String getSecondAddr() {
        return secondAddr;
    }

    public void setSecondAddr(String secondAddr) {
        this.secondAddr = secondAddr == null ? null : secondAddr.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getAppImage() {
        return appImage;
    }

    public void setAppImage(String appImage) {
        this.appImage = appImage == null ? null : appImage.trim();
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