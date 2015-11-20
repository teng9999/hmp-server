package cn.pl.hmp.server.dao.entity;

import java.util.Date;

public class Menu {
    private Long id;

    private Long sysId;

    private Long orgId;

    private String backImg;

    private Boolean hide;

    private String menuImg;

    private String menuType;

    private String nameCn;

    private String nameEn;

    private Integer orderNum;

    private String serviceType;

    private String subMenuType;

    private Long hotelId;

    private Long pagesId;

    private Long parentId;

    private String isProperty;

    private String propertyYpe;

    private String brandId;

    private String breedId;

    private Date createTime;

    private Long creator;

    private Date modifyTime;

    private Long modifier;

    private Boolean available;

    private Long moduleId;

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

    public String getBackImg() {
        return backImg;
    }

    public void setBackImg(String backImg) {
        this.backImg = backImg == null ? null : backImg.trim();
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
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

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getPagesId() {
        return pagesId;
    }

    public void setPagesId(Long pagesId) {
        this.pagesId = pagesId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getIsProperty() {
        return isProperty;
    }

    public void setIsProperty(String isProperty) {
        this.isProperty = isProperty == null ? null : isProperty.trim();
    }

    public String getPropertyYpe() {
        return propertyYpe;
    }

    public void setPropertyYpe(String propertyYpe) {
        this.propertyYpe = propertyYpe == null ? null : propertyYpe.trim();
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

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
}