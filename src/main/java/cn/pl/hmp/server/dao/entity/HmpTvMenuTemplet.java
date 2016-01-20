package cn.pl.hmp.server.dao.entity;

import java.util.Date;

public class HmpTvMenuTemplet {
    private Long id;

    private Long sysId;

    private Long orgId;

    private String nameCn;

    private String nameEn;

    private String backImg;

    private String menuImg;

    private String menuType;

    private String serviceType;

    private String subMenuType;

    private Integer orderNum;

    private String isProperty;

    private String propertyType;

    private Boolean hide;

    private String brandId;

    private String breedId;

    private Long parentId;

    private String path;

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

    public String getBackImg() {
        return backImg;
    }

    public void setBackImg(String backImg) {
        this.backImg = backImg == null ? null : backImg.trim();
    }

    public String getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg == null ? null : menuImg.trim();
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getSubMenuType() {
        return subMenuType;
    }

    public void setSubMenuType(String subMenuType) {
        this.subMenuType = subMenuType == null ? null : subMenuType.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getIsProperty() {
        return isProperty;
    }

    public void setIsProperty(String isProperty) {
        this.isProperty = isProperty == null ? null : isProperty.trim();
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType == null ? null : propertyType.trim();
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    public String getBreedId() {
        return breedId;
    }

    public void setBreedId(String breedId) {
        this.breedId = breedId == null ? null : breedId.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
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