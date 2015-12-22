package cn.pl.hmp.server.dao.entity;

import java.util.Date;

public class HotelInfo {
    private Long id;

    private Long sysId;

    private Long orgId;

    private String address;

    private String bus;

    private String city;

    private String env;

    private String fax;

    private String hotelNum;

    private String name;

    private String phone;

    private String postCode;

    private String subName;

    private String type;

    private String country;

    private String province;

    private String crIsoCode;

    private String uniqueNum;

    private Boolean needRcu;

    private Boolean needTv;

    private Boolean screen;

    private String welcomesCn;

    private String welcomesEn;

    private String weatherCode;

    private String cityNameEn;

    private String rollCn;

    private String rollEn;

    private String movieGroup;

    private String chainId;

    private String serviceIp;

    private String brandId;

    private Date tvLockTime;

    private String tvLockPercent;

    private String airConfig;

    private Date createTime;

    private Long creator;

    private Date modifyTime;

    private Long modifier;

    private Boolean available;

    private String lbsLngLat;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus == null ? null : bus.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env == null ? null : env.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getHotelNum() {
        return hotelNum;
    }

    public void setHotelNum(String hotelNum) {
        this.hotelNum = hotelNum == null ? null : hotelNum.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCrIsoCode() {
        return crIsoCode;
    }

    public void setCrIsoCode(String crIsoCode) {
        this.crIsoCode = crIsoCode == null ? null : crIsoCode.trim();
    }

    public String getUniqueNum() {
        return uniqueNum;
    }

    public void setUniqueNum(String uniqueNum) {
        this.uniqueNum = uniqueNum == null ? null : uniqueNum.trim();
    }

    public Boolean getNeedRcu() {
        return needRcu;
    }

    public void setNeedRcu(Boolean needRcu) {
        this.needRcu = needRcu;
    }

    public Boolean getNeedTv() {
        return needTv;
    }

    public void setNeedTv(Boolean needTv) {
        this.needTv = needTv;
    }

    public Boolean getScreen() {
        return screen;
    }

    public void setScreen(Boolean screen) {
        this.screen = screen;
    }

    public String getWelcomesCn() {
        return welcomesCn;
    }

    public void setWelcomesCn(String welcomesCn) {
        this.welcomesCn = welcomesCn == null ? null : welcomesCn.trim();
    }

    public String getWelcomesEn() {
        return welcomesEn;
    }

    public void setWelcomesEn(String welcomesEn) {
        this.welcomesEn = welcomesEn == null ? null : welcomesEn.trim();
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode == null ? null : weatherCode.trim();
    }

    public String getCityNameEn() {
        return cityNameEn;
    }

    public void setCityNameEn(String cityNameEn) {
        this.cityNameEn = cityNameEn == null ? null : cityNameEn.trim();
    }

    public String getRollCn() {
        return rollCn;
    }

    public void setRollCn(String rollCn) {
        this.rollCn = rollCn == null ? null : rollCn.trim();
    }

    public String getRollEn() {
        return rollEn;
    }

    public void setRollEn(String rollEn) {
        this.rollEn = rollEn == null ? null : rollEn.trim();
    }

    public String getMovieGroup() {
        return movieGroup;
    }

    public void setMovieGroup(String movieGroup) {
        this.movieGroup = movieGroup == null ? null : movieGroup.trim();
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId == null ? null : chainId.trim();
    }

    public String getServiceIp() {
        return serviceIp;
    }

    public void setServiceIp(String serviceIp) {
        this.serviceIp = serviceIp == null ? null : serviceIp.trim();
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    public Date getTvLockTime() {
        return tvLockTime;
    }

    public void setTvLockTime(Date tvLockTime) {
        this.tvLockTime = tvLockTime;
    }

    public String getTvLockPercent() {
        return tvLockPercent;
    }

    public void setTvLockPercent(String tvLockPercent) {
        this.tvLockPercent = tvLockPercent == null ? null : tvLockPercent.trim();
    }

    public String getAirConfig() {
        return airConfig;
    }

    public void setAirConfig(String airConfig) {
        this.airConfig = airConfig == null ? null : airConfig.trim();
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

    public String getLbsLngLat() {
        return lbsLngLat;
    }

    public void setLbsLngLat(String lbsLngLat) {
        this.lbsLngLat = lbsLngLat == null ? null : lbsLngLat.trim();
    }
}