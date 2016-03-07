package cn.pl.hmp.server.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckInSummaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckInSummaryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSysIdIsNull() {
            addCriterion("sys_id is null");
            return (Criteria) this;
        }

        public Criteria andSysIdIsNotNull() {
            addCriterion("sys_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysIdEqualTo(Long value) {
            addCriterion("sys_id =", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotEqualTo(Long value) {
            addCriterion("sys_id <>", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThan(Long value) {
            addCriterion("sys_id >", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sys_id >=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThan(Long value) {
            addCriterion("sys_id <", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThanOrEqualTo(Long value) {
            addCriterion("sys_id <=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdIn(List<Long> values) {
            addCriterion("sys_id in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotIn(List<Long> values) {
            addCriterion("sys_id not in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdBetween(Long value1, Long value2) {
            addCriterion("sys_id between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotBetween(Long value1, Long value2) {
            addCriterion("sys_id not between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Long value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Long value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Long value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Long value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Long> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Long> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Long value1, Long value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Long value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Long value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Long value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Long value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Long value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Long value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Long> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Long> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Long value1, Long value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Long value1, Long value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNull() {
            addCriterion("hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(Long value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(Long value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(Long value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(Long value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(Long value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<Long> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<Long> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(Long value1, Long value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(Long value1, Long value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andLastRoomStatusIsNull() {
            addCriterion("last_room_status is null");
            return (Criteria) this;
        }

        public Criteria andLastRoomStatusIsNotNull() {
            addCriterion("last_room_status is not null");
            return (Criteria) this;
        }

        public Criteria andLastRoomStatusEqualTo(Integer value) {
            addCriterion("last_room_status =", value, "lastRoomStatus");
            return (Criteria) this;
        }

        public Criteria andLastRoomStatusNotEqualTo(Integer value) {
            addCriterion("last_room_status <>", value, "lastRoomStatus");
            return (Criteria) this;
        }

        public Criteria andLastRoomStatusGreaterThan(Integer value) {
            addCriterion("last_room_status >", value, "lastRoomStatus");
            return (Criteria) this;
        }

        public Criteria andLastRoomStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_room_status >=", value, "lastRoomStatus");
            return (Criteria) this;
        }

        public Criteria andLastRoomStatusLessThan(Integer value) {
            addCriterion("last_room_status <", value, "lastRoomStatus");
            return (Criteria) this;
        }

        public Criteria andLastRoomStatusLessThanOrEqualTo(Integer value) {
            addCriterion("last_room_status <=", value, "lastRoomStatus");
            return (Criteria) this;
        }

        public Criteria andLastRoomStatusIn(List<Integer> values) {
            addCriterion("last_room_status in", values, "lastRoomStatus");
            return (Criteria) this;
        }

        public Criteria andLastRoomStatusNotIn(List<Integer> values) {
            addCriterion("last_room_status not in", values, "lastRoomStatus");
            return (Criteria) this;
        }

        public Criteria andLastRoomStatusBetween(Integer value1, Integer value2) {
            addCriterion("last_room_status between", value1, value2, "lastRoomStatus");
            return (Criteria) this;
        }

        public Criteria andLastRoomStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("last_room_status not between", value1, value2, "lastRoomStatus");
            return (Criteria) this;
        }

        public Criteria andPlugIntervalIsNull() {
            addCriterion("plug_interval is null");
            return (Criteria) this;
        }

        public Criteria andPlugIntervalIsNotNull() {
            addCriterion("plug_interval is not null");
            return (Criteria) this;
        }

        public Criteria andPlugIntervalEqualTo(Integer value) {
            addCriterion("plug_interval =", value, "plugInterval");
            return (Criteria) this;
        }

        public Criteria andPlugIntervalNotEqualTo(Integer value) {
            addCriterion("plug_interval <>", value, "plugInterval");
            return (Criteria) this;
        }

        public Criteria andPlugIntervalGreaterThan(Integer value) {
            addCriterion("plug_interval >", value, "plugInterval");
            return (Criteria) this;
        }

        public Criteria andPlugIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("plug_interval >=", value, "plugInterval");
            return (Criteria) this;
        }

        public Criteria andPlugIntervalLessThan(Integer value) {
            addCriterion("plug_interval <", value, "plugInterval");
            return (Criteria) this;
        }

        public Criteria andPlugIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("plug_interval <=", value, "plugInterval");
            return (Criteria) this;
        }

        public Criteria andPlugIntervalIn(List<Integer> values) {
            addCriterion("plug_interval in", values, "plugInterval");
            return (Criteria) this;
        }

        public Criteria andPlugIntervalNotIn(List<Integer> values) {
            addCriterion("plug_interval not in", values, "plugInterval");
            return (Criteria) this;
        }

        public Criteria andPlugIntervalBetween(Integer value1, Integer value2) {
            addCriterion("plug_interval between", value1, value2, "plugInterval");
            return (Criteria) this;
        }

        public Criteria andPlugIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("plug_interval not between", value1, value2, "plugInterval");
            return (Criteria) this;
        }

        public Criteria andPlugInTimeIsNull() {
            addCriterion("plug_in_time is null");
            return (Criteria) this;
        }

        public Criteria andPlugInTimeIsNotNull() {
            addCriterion("plug_in_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlugInTimeEqualTo(Date value) {
            addCriterion("plug_in_time =", value, "plugInTime");
            return (Criteria) this;
        }

        public Criteria andPlugInTimeNotEqualTo(Date value) {
            addCriterion("plug_in_time <>", value, "plugInTime");
            return (Criteria) this;
        }

        public Criteria andPlugInTimeGreaterThan(Date value) {
            addCriterion("plug_in_time >", value, "plugInTime");
            return (Criteria) this;
        }

        public Criteria andPlugInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plug_in_time >=", value, "plugInTime");
            return (Criteria) this;
        }

        public Criteria andPlugInTimeLessThan(Date value) {
            addCriterion("plug_in_time <", value, "plugInTime");
            return (Criteria) this;
        }

        public Criteria andPlugInTimeLessThanOrEqualTo(Date value) {
            addCriterion("plug_in_time <=", value, "plugInTime");
            return (Criteria) this;
        }

        public Criteria andPlugInTimeIn(List<Date> values) {
            addCriterion("plug_in_time in", values, "plugInTime");
            return (Criteria) this;
        }

        public Criteria andPlugInTimeNotIn(List<Date> values) {
            addCriterion("plug_in_time not in", values, "plugInTime");
            return (Criteria) this;
        }

        public Criteria andPlugInTimeBetween(Date value1, Date value2) {
            addCriterion("plug_in_time between", value1, value2, "plugInTime");
            return (Criteria) this;
        }

        public Criteria andPlugInTimeNotBetween(Date value1, Date value2) {
            addCriterion("plug_in_time not between", value1, value2, "plugInTime");
            return (Criteria) this;
        }

        public Criteria andPlugOutTimeIsNull() {
            addCriterion("plug_out_time is null");
            return (Criteria) this;
        }

        public Criteria andPlugOutTimeIsNotNull() {
            addCriterion("plug_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlugOutTimeEqualTo(Date value) {
            addCriterion("plug_out_time =", value, "plugOutTime");
            return (Criteria) this;
        }

        public Criteria andPlugOutTimeNotEqualTo(Date value) {
            addCriterion("plug_out_time <>", value, "plugOutTime");
            return (Criteria) this;
        }

        public Criteria andPlugOutTimeGreaterThan(Date value) {
            addCriterion("plug_out_time >", value, "plugOutTime");
            return (Criteria) this;
        }

        public Criteria andPlugOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plug_out_time >=", value, "plugOutTime");
            return (Criteria) this;
        }

        public Criteria andPlugOutTimeLessThan(Date value) {
            addCriterion("plug_out_time <", value, "plugOutTime");
            return (Criteria) this;
        }

        public Criteria andPlugOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("plug_out_time <=", value, "plugOutTime");
            return (Criteria) this;
        }

        public Criteria andPlugOutTimeIn(List<Date> values) {
            addCriterion("plug_out_time in", values, "plugOutTime");
            return (Criteria) this;
        }

        public Criteria andPlugOutTimeNotIn(List<Date> values) {
            addCriterion("plug_out_time not in", values, "plugOutTime");
            return (Criteria) this;
        }

        public Criteria andPlugOutTimeBetween(Date value1, Date value2) {
            addCriterion("plug_out_time between", value1, value2, "plugOutTime");
            return (Criteria) this;
        }

        public Criteria andPlugOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("plug_out_time not between", value1, value2, "plugOutTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeIsNull() {
            addCriterion("check_in_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeIsNotNull() {
            addCriterion("check_in_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeEqualTo(Date value) {
            addCriterion("check_in_time =", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeNotEqualTo(Date value) {
            addCriterion("check_in_time <>", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeGreaterThan(Date value) {
            addCriterion("check_in_time >", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_in_time >=", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeLessThan(Date value) {
            addCriterion("check_in_time <", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_in_time <=", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeIn(List<Date> values) {
            addCriterion("check_in_time in", values, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeNotIn(List<Date> values) {
            addCriterion("check_in_time not in", values, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeBetween(Date value1, Date value2) {
            addCriterion("check_in_time between", value1, value2, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_in_time not between", value1, value2, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(Long value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(Long value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(Long value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(Long value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(Long value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(Long value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<Long> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<Long> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(Long value1, Long value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(Long value1, Long value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("modifier is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("modifier is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(Long value) {
            addCriterion("modifier =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(Long value) {
            addCriterion("modifier <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(Long value) {
            addCriterion("modifier >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(Long value) {
            addCriterion("modifier >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(Long value) {
            addCriterion("modifier <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(Long value) {
            addCriterion("modifier <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<Long> values) {
            addCriterion("modifier in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<Long> values) {
            addCriterion("modifier not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(Long value1, Long value2) {
            addCriterion("modifier between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(Long value1, Long value2) {
            addCriterion("modifier not between", value1, value2, "modifier");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}