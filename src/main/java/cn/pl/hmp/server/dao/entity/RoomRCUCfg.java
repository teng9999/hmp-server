package cn.pl.hmp.server.dao.entity;

import java.util.Date;

public class RoomRCUCfg {
	private Long id;

	private Long sysId;

	private Long orgId;

	private Long hotelId;

	private Long roomId;

	private String ip;

	private String name;

	private String num;

	private String remark;

	private String lineType;

	private String roomType;

	private Date createTime;

	private Long creator;

	private Date modifyTime;

	private Long modifier;

	private Boolean available;

	public RoomRCUCfg() {
	}

	public RoomRCUCfg(RoomRCUCfg roomRCUCfg) {
		if (roomRCUCfg != null) {
			this.id = roomRCUCfg.getId();
			this.sysId = roomRCUCfg.getSysId();
			this.orgId = roomRCUCfg.getSysId();
			this.hotelId = roomRCUCfg.getHotelId();
			this.roomId = roomRCUCfg.getRoomId();
			this.ip = roomRCUCfg.getIp();
			this.name = roomRCUCfg.getName();
			this.num = roomRCUCfg.getNum();
			this.remark = roomRCUCfg.getRemark();
			this.lineType = roomRCUCfg.getLineType();
			this.roomType = roomRCUCfg.getRoomType();
			this.createTime = roomRCUCfg.getCreateTime();
			this.creator = roomRCUCfg.getCreator();
			this.modifyTime = roomRCUCfg.getModifyTime();
			this.modifier = roomRCUCfg.getModifier();
			this.available = roomRCUCfg.getAvailable();
		}
	}

	public Boolean getAvailable() {
		return available;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Long getCreator() {
		return creator;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public Long getId() {
		return id;
	}

	public String getIp() {
		return ip;
	}

	public String getLineType() {
		return lineType;
	}

	public Long getModifier() {
		return modifier;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public String getName() {
		return name;
	}

	public String getNum() {
		return num;
	}

	public Long getOrgId() {
		return orgId;
	}

	public String getRemark() {
		return remark;
	}

	public Long getRoomId() {
		return roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public Long getSysId() {
		return sysId;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public void setLineType(String lineType) {
		this.lineType = lineType == null ? null : lineType.trim();
	}

	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public void setNum(String num) {
		this.num = num == null ? null : num.trim();
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType == null ? null : roomType.trim();
	}

	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}

}