package cn.pl.hmp.server.dao.entity;

import java.util.Date;

public class HotelRCUCfg {
	private Long id;

	private Long sysId;

	private Long orgId;

	private String analogInputNum;

	private String airConditionerNum;
	/**
	 * RCU板卡类型：万通（WANTONG），屏联（PINGLIAN）
	 */
	private String boardType;

	private Integer connNum;

	private String digitalInputNum;

	private String digitalOutputNum;

	private String factoryNum;

	private Long hotelId;

	private String ip;

	private String osVersion;

	private Integer port;

	private Date produceTime;

	private String powerNum;

	private Long roomId;

	private String dimmerNum;

	private String version;

	private Integer airConditionerStart;

	private Integer lightStart;

	private String timeLock;

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

	public String getAnalogInputNum() {
		return analogInputNum;
	}

	public void setAnalogInputNum(String analogInputNum) {
		this.analogInputNum = analogInputNum == null ? null : analogInputNum
				.trim();
	}

	public String getAirConditionerNum() {
		return airConditionerNum;
	}

	public void setAirConditionerNum(String airConditionerNum) {
		this.airConditionerNum = airConditionerNum == null ? null
				: airConditionerNum.trim();
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType == null ? null : boardType.trim();
	}

	public Integer getConnNum() {
		return connNum;
	}

	public void setConnNum(Integer connNum) {
		this.connNum = connNum;
	}

	public String getDigitalInputNum() {
		return digitalInputNum;
	}

	public void setDigitalInputNum(String digitalInputNum) {
		this.digitalInputNum = digitalInputNum == null ? null : digitalInputNum
				.trim();
	}

	public String getDigitalOutputNum() {
		return digitalOutputNum;
	}

	public void setDigitalOutputNum(String digitalOutputNum) {
		this.digitalOutputNum = digitalOutputNum == null ? null
				: digitalOutputNum.trim();
	}

	public String getFactoryNum() {
		return factoryNum;
	}

	public void setFactoryNum(String factoryNum) {
		this.factoryNum = factoryNum == null ? null : factoryNum.trim();
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion == null ? null : osVersion.trim();
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Date getProduceTime() {
		return produceTime;
	}

	public void setProduceTime(Date produceTime) {
		this.produceTime = produceTime;
	}

	public String getPowerNum() {
		return powerNum;
	}

	public void setPowerNum(String powerNum) {
		this.powerNum = powerNum == null ? null : powerNum.trim();
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getDimmerNum() {
		return dimmerNum;
	}

	public void setDimmerNum(String dimmerNum) {
		this.dimmerNum = dimmerNum == null ? null : dimmerNum.trim();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version == null ? null : version.trim();
	}

	public Integer getAirConditionerStart() {
		return airConditionerStart;
	}

	public void setAirConditionerStart(Integer airConditionerStart) {
		this.airConditionerStart = airConditionerStart;
	}

	public Integer getLightStart() {
		return lightStart;
	}

	public void setLightStart(Integer lightStart) {
		this.lightStart = lightStart;
	}

	public String getTimeLock() {
		return timeLock;
	}

	public void setTimeLock(String timeLock) {
		this.timeLock = timeLock == null ? null : timeLock.trim();
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