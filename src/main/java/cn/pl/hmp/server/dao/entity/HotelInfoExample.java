package cn.pl.hmp.server.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotelInfoExample() {
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andBusIsNull() {
            addCriterion("bus is null");
            return (Criteria) this;
        }

        public Criteria andBusIsNotNull() {
            addCriterion("bus is not null");
            return (Criteria) this;
        }

        public Criteria andBusEqualTo(String value) {
            addCriterion("bus =", value, "bus");
            return (Criteria) this;
        }

        public Criteria andBusNotEqualTo(String value) {
            addCriterion("bus <>", value, "bus");
            return (Criteria) this;
        }

        public Criteria andBusGreaterThan(String value) {
            addCriterion("bus >", value, "bus");
            return (Criteria) this;
        }

        public Criteria andBusGreaterThanOrEqualTo(String value) {
            addCriterion("bus >=", value, "bus");
            return (Criteria) this;
        }

        public Criteria andBusLessThan(String value) {
            addCriterion("bus <", value, "bus");
            return (Criteria) this;
        }

        public Criteria andBusLessThanOrEqualTo(String value) {
            addCriterion("bus <=", value, "bus");
            return (Criteria) this;
        }

        public Criteria andBusLike(String value) {
            addCriterion("bus like", value, "bus");
            return (Criteria) this;
        }

        public Criteria andBusNotLike(String value) {
            addCriterion("bus not like", value, "bus");
            return (Criteria) this;
        }

        public Criteria andBusIn(List<String> values) {
            addCriterion("bus in", values, "bus");
            return (Criteria) this;
        }

        public Criteria andBusNotIn(List<String> values) {
            addCriterion("bus not in", values, "bus");
            return (Criteria) this;
        }

        public Criteria andBusBetween(String value1, String value2) {
            addCriterion("bus between", value1, value2, "bus");
            return (Criteria) this;
        }

        public Criteria andBusNotBetween(String value1, String value2) {
            addCriterion("bus not between", value1, value2, "bus");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andEnvIsNull() {
            addCriterion("env is null");
            return (Criteria) this;
        }

        public Criteria andEnvIsNotNull() {
            addCriterion("env is not null");
            return (Criteria) this;
        }

        public Criteria andEnvEqualTo(String value) {
            addCriterion("env =", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvNotEqualTo(String value) {
            addCriterion("env <>", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvGreaterThan(String value) {
            addCriterion("env >", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvGreaterThanOrEqualTo(String value) {
            addCriterion("env >=", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvLessThan(String value) {
            addCriterion("env <", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvLessThanOrEqualTo(String value) {
            addCriterion("env <=", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvLike(String value) {
            addCriterion("env like", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvNotLike(String value) {
            addCriterion("env not like", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvIn(List<String> values) {
            addCriterion("env in", values, "env");
            return (Criteria) this;
        }

        public Criteria andEnvNotIn(List<String> values) {
            addCriterion("env not in", values, "env");
            return (Criteria) this;
        }

        public Criteria andEnvBetween(String value1, String value2) {
            addCriterion("env between", value1, value2, "env");
            return (Criteria) this;
        }

        public Criteria andEnvNotBetween(String value1, String value2) {
            addCriterion("env not between", value1, value2, "env");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andHotelNumIsNull() {
            addCriterion("hotel_num is null");
            return (Criteria) this;
        }

        public Criteria andHotelNumIsNotNull() {
            addCriterion("hotel_num is not null");
            return (Criteria) this;
        }

        public Criteria andHotelNumEqualTo(String value) {
            addCriterion("hotel_num =", value, "hotelNum");
            return (Criteria) this;
        }

        public Criteria andHotelNumNotEqualTo(String value) {
            addCriterion("hotel_num <>", value, "hotelNum");
            return (Criteria) this;
        }

        public Criteria andHotelNumGreaterThan(String value) {
            addCriterion("hotel_num >", value, "hotelNum");
            return (Criteria) this;
        }

        public Criteria andHotelNumGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_num >=", value, "hotelNum");
            return (Criteria) this;
        }

        public Criteria andHotelNumLessThan(String value) {
            addCriterion("hotel_num <", value, "hotelNum");
            return (Criteria) this;
        }

        public Criteria andHotelNumLessThanOrEqualTo(String value) {
            addCriterion("hotel_num <=", value, "hotelNum");
            return (Criteria) this;
        }

        public Criteria andHotelNumLike(String value) {
            addCriterion("hotel_num like", value, "hotelNum");
            return (Criteria) this;
        }

        public Criteria andHotelNumNotLike(String value) {
            addCriterion("hotel_num not like", value, "hotelNum");
            return (Criteria) this;
        }

        public Criteria andHotelNumIn(List<String> values) {
            addCriterion("hotel_num in", values, "hotelNum");
            return (Criteria) this;
        }

        public Criteria andHotelNumNotIn(List<String> values) {
            addCriterion("hotel_num not in", values, "hotelNum");
            return (Criteria) this;
        }

        public Criteria andHotelNumBetween(String value1, String value2) {
            addCriterion("hotel_num between", value1, value2, "hotelNum");
            return (Criteria) this;
        }

        public Criteria andHotelNumNotBetween(String value1, String value2) {
            addCriterion("hotel_num not between", value1, value2, "hotelNum");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNull() {
            addCriterion("post_code is null");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNotNull() {
            addCriterion("post_code is not null");
            return (Criteria) this;
        }

        public Criteria andPostCodeEqualTo(String value) {
            addCriterion("post_code =", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotEqualTo(String value) {
            addCriterion("post_code <>", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThan(String value) {
            addCriterion("post_code >", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThanOrEqualTo(String value) {
            addCriterion("post_code >=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThan(String value) {
            addCriterion("post_code <", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThanOrEqualTo(String value) {
            addCriterion("post_code <=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLike(String value) {
            addCriterion("post_code like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotLike(String value) {
            addCriterion("post_code not like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeIn(List<String> values) {
            addCriterion("post_code in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotIn(List<String> values) {
            addCriterion("post_code not in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeBetween(String value1, String value2) {
            addCriterion("post_code between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotBetween(String value1, String value2) {
            addCriterion("post_code not between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andSubNameIsNull() {
            addCriterion("sub_name is null");
            return (Criteria) this;
        }

        public Criteria andSubNameIsNotNull() {
            addCriterion("sub_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubNameEqualTo(String value) {
            addCriterion("sub_name =", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotEqualTo(String value) {
            addCriterion("sub_name <>", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameGreaterThan(String value) {
            addCriterion("sub_name >", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameGreaterThanOrEqualTo(String value) {
            addCriterion("sub_name >=", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLessThan(String value) {
            addCriterion("sub_name <", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLessThanOrEqualTo(String value) {
            addCriterion("sub_name <=", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLike(String value) {
            addCriterion("sub_name like", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotLike(String value) {
            addCriterion("sub_name not like", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameIn(List<String> values) {
            addCriterion("sub_name in", values, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotIn(List<String> values) {
            addCriterion("sub_name not in", values, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameBetween(String value1, String value2) {
            addCriterion("sub_name between", value1, value2, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotBetween(String value1, String value2) {
            addCriterion("sub_name not between", value1, value2, "subName");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCrIsoCodeIsNull() {
            addCriterion("cr_iso_code is null");
            return (Criteria) this;
        }

        public Criteria andCrIsoCodeIsNotNull() {
            addCriterion("cr_iso_code is not null");
            return (Criteria) this;
        }

        public Criteria andCrIsoCodeEqualTo(String value) {
            addCriterion("cr_iso_code =", value, "crIsoCode");
            return (Criteria) this;
        }

        public Criteria andCrIsoCodeNotEqualTo(String value) {
            addCriterion("cr_iso_code <>", value, "crIsoCode");
            return (Criteria) this;
        }

        public Criteria andCrIsoCodeGreaterThan(String value) {
            addCriterion("cr_iso_code >", value, "crIsoCode");
            return (Criteria) this;
        }

        public Criteria andCrIsoCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cr_iso_code >=", value, "crIsoCode");
            return (Criteria) this;
        }

        public Criteria andCrIsoCodeLessThan(String value) {
            addCriterion("cr_iso_code <", value, "crIsoCode");
            return (Criteria) this;
        }

        public Criteria andCrIsoCodeLessThanOrEqualTo(String value) {
            addCriterion("cr_iso_code <=", value, "crIsoCode");
            return (Criteria) this;
        }

        public Criteria andCrIsoCodeLike(String value) {
            addCriterion("cr_iso_code like", value, "crIsoCode");
            return (Criteria) this;
        }

        public Criteria andCrIsoCodeNotLike(String value) {
            addCriterion("cr_iso_code not like", value, "crIsoCode");
            return (Criteria) this;
        }

        public Criteria andCrIsoCodeIn(List<String> values) {
            addCriterion("cr_iso_code in", values, "crIsoCode");
            return (Criteria) this;
        }

        public Criteria andCrIsoCodeNotIn(List<String> values) {
            addCriterion("cr_iso_code not in", values, "crIsoCode");
            return (Criteria) this;
        }

        public Criteria andCrIsoCodeBetween(String value1, String value2) {
            addCriterion("cr_iso_code between", value1, value2, "crIsoCode");
            return (Criteria) this;
        }

        public Criteria andCrIsoCodeNotBetween(String value1, String value2) {
            addCriterion("cr_iso_code not between", value1, value2, "crIsoCode");
            return (Criteria) this;
        }

        public Criteria andUniqueNumIsNull() {
            addCriterion("unique_num is null");
            return (Criteria) this;
        }

        public Criteria andUniqueNumIsNotNull() {
            addCriterion("unique_num is not null");
            return (Criteria) this;
        }

        public Criteria andUniqueNumEqualTo(String value) {
            addCriterion("unique_num =", value, "uniqueNum");
            return (Criteria) this;
        }

        public Criteria andUniqueNumNotEqualTo(String value) {
            addCriterion("unique_num <>", value, "uniqueNum");
            return (Criteria) this;
        }

        public Criteria andUniqueNumGreaterThan(String value) {
            addCriterion("unique_num >", value, "uniqueNum");
            return (Criteria) this;
        }

        public Criteria andUniqueNumGreaterThanOrEqualTo(String value) {
            addCriterion("unique_num >=", value, "uniqueNum");
            return (Criteria) this;
        }

        public Criteria andUniqueNumLessThan(String value) {
            addCriterion("unique_num <", value, "uniqueNum");
            return (Criteria) this;
        }

        public Criteria andUniqueNumLessThanOrEqualTo(String value) {
            addCriterion("unique_num <=", value, "uniqueNum");
            return (Criteria) this;
        }

        public Criteria andUniqueNumLike(String value) {
            addCriterion("unique_num like", value, "uniqueNum");
            return (Criteria) this;
        }

        public Criteria andUniqueNumNotLike(String value) {
            addCriterion("unique_num not like", value, "uniqueNum");
            return (Criteria) this;
        }

        public Criteria andUniqueNumIn(List<String> values) {
            addCriterion("unique_num in", values, "uniqueNum");
            return (Criteria) this;
        }

        public Criteria andUniqueNumNotIn(List<String> values) {
            addCriterion("unique_num not in", values, "uniqueNum");
            return (Criteria) this;
        }

        public Criteria andUniqueNumBetween(String value1, String value2) {
            addCriterion("unique_num between", value1, value2, "uniqueNum");
            return (Criteria) this;
        }

        public Criteria andUniqueNumNotBetween(String value1, String value2) {
            addCriterion("unique_num not between", value1, value2, "uniqueNum");
            return (Criteria) this;
        }

        public Criteria andNeedRcuIsNull() {
            addCriterion("need_rcu is null");
            return (Criteria) this;
        }

        public Criteria andNeedRcuIsNotNull() {
            addCriterion("need_rcu is not null");
            return (Criteria) this;
        }

        public Criteria andNeedRcuEqualTo(Boolean value) {
            addCriterion("need_rcu =", value, "needRcu");
            return (Criteria) this;
        }

        public Criteria andNeedRcuNotEqualTo(Boolean value) {
            addCriterion("need_rcu <>", value, "needRcu");
            return (Criteria) this;
        }

        public Criteria andNeedRcuGreaterThan(Boolean value) {
            addCriterion("need_rcu >", value, "needRcu");
            return (Criteria) this;
        }

        public Criteria andNeedRcuGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_rcu >=", value, "needRcu");
            return (Criteria) this;
        }

        public Criteria andNeedRcuLessThan(Boolean value) {
            addCriterion("need_rcu <", value, "needRcu");
            return (Criteria) this;
        }

        public Criteria andNeedRcuLessThanOrEqualTo(Boolean value) {
            addCriterion("need_rcu <=", value, "needRcu");
            return (Criteria) this;
        }

        public Criteria andNeedRcuIn(List<Boolean> values) {
            addCriterion("need_rcu in", values, "needRcu");
            return (Criteria) this;
        }

        public Criteria andNeedRcuNotIn(List<Boolean> values) {
            addCriterion("need_rcu not in", values, "needRcu");
            return (Criteria) this;
        }

        public Criteria andNeedRcuBetween(Boolean value1, Boolean value2) {
            addCriterion("need_rcu between", value1, value2, "needRcu");
            return (Criteria) this;
        }

        public Criteria andNeedRcuNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_rcu not between", value1, value2, "needRcu");
            return (Criteria) this;
        }

        public Criteria andNeedTvIsNull() {
            addCriterion("need_tv is null");
            return (Criteria) this;
        }

        public Criteria andNeedTvIsNotNull() {
            addCriterion("need_tv is not null");
            return (Criteria) this;
        }

        public Criteria andNeedTvEqualTo(Boolean value) {
            addCriterion("need_tv =", value, "needTv");
            return (Criteria) this;
        }

        public Criteria andNeedTvNotEqualTo(Boolean value) {
            addCriterion("need_tv <>", value, "needTv");
            return (Criteria) this;
        }

        public Criteria andNeedTvGreaterThan(Boolean value) {
            addCriterion("need_tv >", value, "needTv");
            return (Criteria) this;
        }

        public Criteria andNeedTvGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_tv >=", value, "needTv");
            return (Criteria) this;
        }

        public Criteria andNeedTvLessThan(Boolean value) {
            addCriterion("need_tv <", value, "needTv");
            return (Criteria) this;
        }

        public Criteria andNeedTvLessThanOrEqualTo(Boolean value) {
            addCriterion("need_tv <=", value, "needTv");
            return (Criteria) this;
        }

        public Criteria andNeedTvIn(List<Boolean> values) {
            addCriterion("need_tv in", values, "needTv");
            return (Criteria) this;
        }

        public Criteria andNeedTvNotIn(List<Boolean> values) {
            addCriterion("need_tv not in", values, "needTv");
            return (Criteria) this;
        }

        public Criteria andNeedTvBetween(Boolean value1, Boolean value2) {
            addCriterion("need_tv between", value1, value2, "needTv");
            return (Criteria) this;
        }

        public Criteria andNeedTvNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_tv not between", value1, value2, "needTv");
            return (Criteria) this;
        }

        public Criteria andScreenIsNull() {
            addCriterion("screen is null");
            return (Criteria) this;
        }

        public Criteria andScreenIsNotNull() {
            addCriterion("screen is not null");
            return (Criteria) this;
        }

        public Criteria andScreenEqualTo(Boolean value) {
            addCriterion("screen =", value, "screen");
            return (Criteria) this;
        }

        public Criteria andScreenNotEqualTo(Boolean value) {
            addCriterion("screen <>", value, "screen");
            return (Criteria) this;
        }

        public Criteria andScreenGreaterThan(Boolean value) {
            addCriterion("screen >", value, "screen");
            return (Criteria) this;
        }

        public Criteria andScreenGreaterThanOrEqualTo(Boolean value) {
            addCriterion("screen >=", value, "screen");
            return (Criteria) this;
        }

        public Criteria andScreenLessThan(Boolean value) {
            addCriterion("screen <", value, "screen");
            return (Criteria) this;
        }

        public Criteria andScreenLessThanOrEqualTo(Boolean value) {
            addCriterion("screen <=", value, "screen");
            return (Criteria) this;
        }

        public Criteria andScreenIn(List<Boolean> values) {
            addCriterion("screen in", values, "screen");
            return (Criteria) this;
        }

        public Criteria andScreenNotIn(List<Boolean> values) {
            addCriterion("screen not in", values, "screen");
            return (Criteria) this;
        }

        public Criteria andScreenBetween(Boolean value1, Boolean value2) {
            addCriterion("screen between", value1, value2, "screen");
            return (Criteria) this;
        }

        public Criteria andScreenNotBetween(Boolean value1, Boolean value2) {
            addCriterion("screen not between", value1, value2, "screen");
            return (Criteria) this;
        }

        public Criteria andWelcomesCnIsNull() {
            addCriterion("welcomes_cn is null");
            return (Criteria) this;
        }

        public Criteria andWelcomesCnIsNotNull() {
            addCriterion("welcomes_cn is not null");
            return (Criteria) this;
        }

        public Criteria andWelcomesCnEqualTo(String value) {
            addCriterion("welcomes_cn =", value, "welcomesCn");
            return (Criteria) this;
        }

        public Criteria andWelcomesCnNotEqualTo(String value) {
            addCriterion("welcomes_cn <>", value, "welcomesCn");
            return (Criteria) this;
        }

        public Criteria andWelcomesCnGreaterThan(String value) {
            addCriterion("welcomes_cn >", value, "welcomesCn");
            return (Criteria) this;
        }

        public Criteria andWelcomesCnGreaterThanOrEqualTo(String value) {
            addCriterion("welcomes_cn >=", value, "welcomesCn");
            return (Criteria) this;
        }

        public Criteria andWelcomesCnLessThan(String value) {
            addCriterion("welcomes_cn <", value, "welcomesCn");
            return (Criteria) this;
        }

        public Criteria andWelcomesCnLessThanOrEqualTo(String value) {
            addCriterion("welcomes_cn <=", value, "welcomesCn");
            return (Criteria) this;
        }

        public Criteria andWelcomesCnLike(String value) {
            addCriterion("welcomes_cn like", value, "welcomesCn");
            return (Criteria) this;
        }

        public Criteria andWelcomesCnNotLike(String value) {
            addCriterion("welcomes_cn not like", value, "welcomesCn");
            return (Criteria) this;
        }

        public Criteria andWelcomesCnIn(List<String> values) {
            addCriterion("welcomes_cn in", values, "welcomesCn");
            return (Criteria) this;
        }

        public Criteria andWelcomesCnNotIn(List<String> values) {
            addCriterion("welcomes_cn not in", values, "welcomesCn");
            return (Criteria) this;
        }

        public Criteria andWelcomesCnBetween(String value1, String value2) {
            addCriterion("welcomes_cn between", value1, value2, "welcomesCn");
            return (Criteria) this;
        }

        public Criteria andWelcomesCnNotBetween(String value1, String value2) {
            addCriterion("welcomes_cn not between", value1, value2, "welcomesCn");
            return (Criteria) this;
        }

        public Criteria andWelcomesEnIsNull() {
            addCriterion("welcomes_en is null");
            return (Criteria) this;
        }

        public Criteria andWelcomesEnIsNotNull() {
            addCriterion("welcomes_en is not null");
            return (Criteria) this;
        }

        public Criteria andWelcomesEnEqualTo(String value) {
            addCriterion("welcomes_en =", value, "welcomesEn");
            return (Criteria) this;
        }

        public Criteria andWelcomesEnNotEqualTo(String value) {
            addCriterion("welcomes_en <>", value, "welcomesEn");
            return (Criteria) this;
        }

        public Criteria andWelcomesEnGreaterThan(String value) {
            addCriterion("welcomes_en >", value, "welcomesEn");
            return (Criteria) this;
        }

        public Criteria andWelcomesEnGreaterThanOrEqualTo(String value) {
            addCriterion("welcomes_en >=", value, "welcomesEn");
            return (Criteria) this;
        }

        public Criteria andWelcomesEnLessThan(String value) {
            addCriterion("welcomes_en <", value, "welcomesEn");
            return (Criteria) this;
        }

        public Criteria andWelcomesEnLessThanOrEqualTo(String value) {
            addCriterion("welcomes_en <=", value, "welcomesEn");
            return (Criteria) this;
        }

        public Criteria andWelcomesEnLike(String value) {
            addCriterion("welcomes_en like", value, "welcomesEn");
            return (Criteria) this;
        }

        public Criteria andWelcomesEnNotLike(String value) {
            addCriterion("welcomes_en not like", value, "welcomesEn");
            return (Criteria) this;
        }

        public Criteria andWelcomesEnIn(List<String> values) {
            addCriterion("welcomes_en in", values, "welcomesEn");
            return (Criteria) this;
        }

        public Criteria andWelcomesEnNotIn(List<String> values) {
            addCriterion("welcomes_en not in", values, "welcomesEn");
            return (Criteria) this;
        }

        public Criteria andWelcomesEnBetween(String value1, String value2) {
            addCriterion("welcomes_en between", value1, value2, "welcomesEn");
            return (Criteria) this;
        }

        public Criteria andWelcomesEnNotBetween(String value1, String value2) {
            addCriterion("welcomes_en not between", value1, value2, "welcomesEn");
            return (Criteria) this;
        }

        public Criteria andWeatherCodeIsNull() {
            addCriterion("weather_code is null");
            return (Criteria) this;
        }

        public Criteria andWeatherCodeIsNotNull() {
            addCriterion("weather_code is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherCodeEqualTo(String value) {
            addCriterion("weather_code =", value, "weatherCode");
            return (Criteria) this;
        }

        public Criteria andWeatherCodeNotEqualTo(String value) {
            addCriterion("weather_code <>", value, "weatherCode");
            return (Criteria) this;
        }

        public Criteria andWeatherCodeGreaterThan(String value) {
            addCriterion("weather_code >", value, "weatherCode");
            return (Criteria) this;
        }

        public Criteria andWeatherCodeGreaterThanOrEqualTo(String value) {
            addCriterion("weather_code >=", value, "weatherCode");
            return (Criteria) this;
        }

        public Criteria andWeatherCodeLessThan(String value) {
            addCriterion("weather_code <", value, "weatherCode");
            return (Criteria) this;
        }

        public Criteria andWeatherCodeLessThanOrEqualTo(String value) {
            addCriterion("weather_code <=", value, "weatherCode");
            return (Criteria) this;
        }

        public Criteria andWeatherCodeLike(String value) {
            addCriterion("weather_code like", value, "weatherCode");
            return (Criteria) this;
        }

        public Criteria andWeatherCodeNotLike(String value) {
            addCriterion("weather_code not like", value, "weatherCode");
            return (Criteria) this;
        }

        public Criteria andWeatherCodeIn(List<String> values) {
            addCriterion("weather_code in", values, "weatherCode");
            return (Criteria) this;
        }

        public Criteria andWeatherCodeNotIn(List<String> values) {
            addCriterion("weather_code not in", values, "weatherCode");
            return (Criteria) this;
        }

        public Criteria andWeatherCodeBetween(String value1, String value2) {
            addCriterion("weather_code between", value1, value2, "weatherCode");
            return (Criteria) this;
        }

        public Criteria andWeatherCodeNotBetween(String value1, String value2) {
            addCriterion("weather_code not between", value1, value2, "weatherCode");
            return (Criteria) this;
        }

        public Criteria andCityNameEnIsNull() {
            addCriterion("city_name_en is null");
            return (Criteria) this;
        }

        public Criteria andCityNameEnIsNotNull() {
            addCriterion("city_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEnEqualTo(String value) {
            addCriterion("city_name_en =", value, "cityNameEn");
            return (Criteria) this;
        }

        public Criteria andCityNameEnNotEqualTo(String value) {
            addCriterion("city_name_en <>", value, "cityNameEn");
            return (Criteria) this;
        }

        public Criteria andCityNameEnGreaterThan(String value) {
            addCriterion("city_name_en >", value, "cityNameEn");
            return (Criteria) this;
        }

        public Criteria andCityNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("city_name_en >=", value, "cityNameEn");
            return (Criteria) this;
        }

        public Criteria andCityNameEnLessThan(String value) {
            addCriterion("city_name_en <", value, "cityNameEn");
            return (Criteria) this;
        }

        public Criteria andCityNameEnLessThanOrEqualTo(String value) {
            addCriterion("city_name_en <=", value, "cityNameEn");
            return (Criteria) this;
        }

        public Criteria andCityNameEnLike(String value) {
            addCriterion("city_name_en like", value, "cityNameEn");
            return (Criteria) this;
        }

        public Criteria andCityNameEnNotLike(String value) {
            addCriterion("city_name_en not like", value, "cityNameEn");
            return (Criteria) this;
        }

        public Criteria andCityNameEnIn(List<String> values) {
            addCriterion("city_name_en in", values, "cityNameEn");
            return (Criteria) this;
        }

        public Criteria andCityNameEnNotIn(List<String> values) {
            addCriterion("city_name_en not in", values, "cityNameEn");
            return (Criteria) this;
        }

        public Criteria andCityNameEnBetween(String value1, String value2) {
            addCriterion("city_name_en between", value1, value2, "cityNameEn");
            return (Criteria) this;
        }

        public Criteria andCityNameEnNotBetween(String value1, String value2) {
            addCriterion("city_name_en not between", value1, value2, "cityNameEn");
            return (Criteria) this;
        }

        public Criteria andRollCnIsNull() {
            addCriterion("roll_cn is null");
            return (Criteria) this;
        }

        public Criteria andRollCnIsNotNull() {
            addCriterion("roll_cn is not null");
            return (Criteria) this;
        }

        public Criteria andRollCnEqualTo(String value) {
            addCriterion("roll_cn =", value, "rollCn");
            return (Criteria) this;
        }

        public Criteria andRollCnNotEqualTo(String value) {
            addCriterion("roll_cn <>", value, "rollCn");
            return (Criteria) this;
        }

        public Criteria andRollCnGreaterThan(String value) {
            addCriterion("roll_cn >", value, "rollCn");
            return (Criteria) this;
        }

        public Criteria andRollCnGreaterThanOrEqualTo(String value) {
            addCriterion("roll_cn >=", value, "rollCn");
            return (Criteria) this;
        }

        public Criteria andRollCnLessThan(String value) {
            addCriterion("roll_cn <", value, "rollCn");
            return (Criteria) this;
        }

        public Criteria andRollCnLessThanOrEqualTo(String value) {
            addCriterion("roll_cn <=", value, "rollCn");
            return (Criteria) this;
        }

        public Criteria andRollCnLike(String value) {
            addCriterion("roll_cn like", value, "rollCn");
            return (Criteria) this;
        }

        public Criteria andRollCnNotLike(String value) {
            addCriterion("roll_cn not like", value, "rollCn");
            return (Criteria) this;
        }

        public Criteria andRollCnIn(List<String> values) {
            addCriterion("roll_cn in", values, "rollCn");
            return (Criteria) this;
        }

        public Criteria andRollCnNotIn(List<String> values) {
            addCriterion("roll_cn not in", values, "rollCn");
            return (Criteria) this;
        }

        public Criteria andRollCnBetween(String value1, String value2) {
            addCriterion("roll_cn between", value1, value2, "rollCn");
            return (Criteria) this;
        }

        public Criteria andRollCnNotBetween(String value1, String value2) {
            addCriterion("roll_cn not between", value1, value2, "rollCn");
            return (Criteria) this;
        }

        public Criteria andRollEnIsNull() {
            addCriterion("roll_en is null");
            return (Criteria) this;
        }

        public Criteria andRollEnIsNotNull() {
            addCriterion("roll_en is not null");
            return (Criteria) this;
        }

        public Criteria andRollEnEqualTo(String value) {
            addCriterion("roll_en =", value, "rollEn");
            return (Criteria) this;
        }

        public Criteria andRollEnNotEqualTo(String value) {
            addCriterion("roll_en <>", value, "rollEn");
            return (Criteria) this;
        }

        public Criteria andRollEnGreaterThan(String value) {
            addCriterion("roll_en >", value, "rollEn");
            return (Criteria) this;
        }

        public Criteria andRollEnGreaterThanOrEqualTo(String value) {
            addCriterion("roll_en >=", value, "rollEn");
            return (Criteria) this;
        }

        public Criteria andRollEnLessThan(String value) {
            addCriterion("roll_en <", value, "rollEn");
            return (Criteria) this;
        }

        public Criteria andRollEnLessThanOrEqualTo(String value) {
            addCriterion("roll_en <=", value, "rollEn");
            return (Criteria) this;
        }

        public Criteria andRollEnLike(String value) {
            addCriterion("roll_en like", value, "rollEn");
            return (Criteria) this;
        }

        public Criteria andRollEnNotLike(String value) {
            addCriterion("roll_en not like", value, "rollEn");
            return (Criteria) this;
        }

        public Criteria andRollEnIn(List<String> values) {
            addCriterion("roll_en in", values, "rollEn");
            return (Criteria) this;
        }

        public Criteria andRollEnNotIn(List<String> values) {
            addCriterion("roll_en not in", values, "rollEn");
            return (Criteria) this;
        }

        public Criteria andRollEnBetween(String value1, String value2) {
            addCriterion("roll_en between", value1, value2, "rollEn");
            return (Criteria) this;
        }

        public Criteria andRollEnNotBetween(String value1, String value2) {
            addCriterion("roll_en not between", value1, value2, "rollEn");
            return (Criteria) this;
        }

        public Criteria andMovieGroupIsNull() {
            addCriterion("movie_group is null");
            return (Criteria) this;
        }

        public Criteria andMovieGroupIsNotNull() {
            addCriterion("movie_group is not null");
            return (Criteria) this;
        }

        public Criteria andMovieGroupEqualTo(String value) {
            addCriterion("movie_group =", value, "movieGroup");
            return (Criteria) this;
        }

        public Criteria andMovieGroupNotEqualTo(String value) {
            addCriterion("movie_group <>", value, "movieGroup");
            return (Criteria) this;
        }

        public Criteria andMovieGroupGreaterThan(String value) {
            addCriterion("movie_group >", value, "movieGroup");
            return (Criteria) this;
        }

        public Criteria andMovieGroupGreaterThanOrEqualTo(String value) {
            addCriterion("movie_group >=", value, "movieGroup");
            return (Criteria) this;
        }

        public Criteria andMovieGroupLessThan(String value) {
            addCriterion("movie_group <", value, "movieGroup");
            return (Criteria) this;
        }

        public Criteria andMovieGroupLessThanOrEqualTo(String value) {
            addCriterion("movie_group <=", value, "movieGroup");
            return (Criteria) this;
        }

        public Criteria andMovieGroupLike(String value) {
            addCriterion("movie_group like", value, "movieGroup");
            return (Criteria) this;
        }

        public Criteria andMovieGroupNotLike(String value) {
            addCriterion("movie_group not like", value, "movieGroup");
            return (Criteria) this;
        }

        public Criteria andMovieGroupIn(List<String> values) {
            addCriterion("movie_group in", values, "movieGroup");
            return (Criteria) this;
        }

        public Criteria andMovieGroupNotIn(List<String> values) {
            addCriterion("movie_group not in", values, "movieGroup");
            return (Criteria) this;
        }

        public Criteria andMovieGroupBetween(String value1, String value2) {
            addCriterion("movie_group between", value1, value2, "movieGroup");
            return (Criteria) this;
        }

        public Criteria andMovieGroupNotBetween(String value1, String value2) {
            addCriterion("movie_group not between", value1, value2, "movieGroup");
            return (Criteria) this;
        }

        public Criteria andChainIdIsNull() {
            addCriterion("chain_id is null");
            return (Criteria) this;
        }

        public Criteria andChainIdIsNotNull() {
            addCriterion("chain_id is not null");
            return (Criteria) this;
        }

        public Criteria andChainIdEqualTo(String value) {
            addCriterion("chain_id =", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotEqualTo(String value) {
            addCriterion("chain_id <>", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdGreaterThan(String value) {
            addCriterion("chain_id >", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdGreaterThanOrEqualTo(String value) {
            addCriterion("chain_id >=", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdLessThan(String value) {
            addCriterion("chain_id <", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdLessThanOrEqualTo(String value) {
            addCriterion("chain_id <=", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdLike(String value) {
            addCriterion("chain_id like", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotLike(String value) {
            addCriterion("chain_id not like", value, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdIn(List<String> values) {
            addCriterion("chain_id in", values, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotIn(List<String> values) {
            addCriterion("chain_id not in", values, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdBetween(String value1, String value2) {
            addCriterion("chain_id between", value1, value2, "chainId");
            return (Criteria) this;
        }

        public Criteria andChainIdNotBetween(String value1, String value2) {
            addCriterion("chain_id not between", value1, value2, "chainId");
            return (Criteria) this;
        }

        public Criteria andServiceIpIsNull() {
            addCriterion("service_ip is null");
            return (Criteria) this;
        }

        public Criteria andServiceIpIsNotNull() {
            addCriterion("service_ip is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIpEqualTo(String value) {
            addCriterion("service_ip =", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotEqualTo(String value) {
            addCriterion("service_ip <>", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpGreaterThan(String value) {
            addCriterion("service_ip >", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpGreaterThanOrEqualTo(String value) {
            addCriterion("service_ip >=", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLessThan(String value) {
            addCriterion("service_ip <", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLessThanOrEqualTo(String value) {
            addCriterion("service_ip <=", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLike(String value) {
            addCriterion("service_ip like", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotLike(String value) {
            addCriterion("service_ip not like", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpIn(List<String> values) {
            addCriterion("service_ip in", values, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotIn(List<String> values) {
            addCriterion("service_ip not in", values, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpBetween(String value1, String value2) {
            addCriterion("service_ip between", value1, value2, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotBetween(String value1, String value2) {
            addCriterion("service_ip not between", value1, value2, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(String value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(String value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(String value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(String value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(String value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(String value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLike(String value) {
            addCriterion("brand_id like", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotLike(String value) {
            addCriterion("brand_id not like", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<String> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<String> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(String value1, String value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(String value1, String value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andAirConfigIsNull() {
            addCriterion("air_config is null");
            return (Criteria) this;
        }

        public Criteria andAirConfigIsNotNull() {
            addCriterion("air_config is not null");
            return (Criteria) this;
        }

        public Criteria andAirConfigEqualTo(String value) {
            addCriterion("air_config =", value, "airConfig");
            return (Criteria) this;
        }

        public Criteria andAirConfigNotEqualTo(String value) {
            addCriterion("air_config <>", value, "airConfig");
            return (Criteria) this;
        }

        public Criteria andAirConfigGreaterThan(String value) {
            addCriterion("air_config >", value, "airConfig");
            return (Criteria) this;
        }

        public Criteria andAirConfigGreaterThanOrEqualTo(String value) {
            addCriterion("air_config >=", value, "airConfig");
            return (Criteria) this;
        }

        public Criteria andAirConfigLessThan(String value) {
            addCriterion("air_config <", value, "airConfig");
            return (Criteria) this;
        }

        public Criteria andAirConfigLessThanOrEqualTo(String value) {
            addCriterion("air_config <=", value, "airConfig");
            return (Criteria) this;
        }

        public Criteria andAirConfigLike(String value) {
            addCriterion("air_config like", value, "airConfig");
            return (Criteria) this;
        }

        public Criteria andAirConfigNotLike(String value) {
            addCriterion("air_config not like", value, "airConfig");
            return (Criteria) this;
        }

        public Criteria andAirConfigIn(List<String> values) {
            addCriterion("air_config in", values, "airConfig");
            return (Criteria) this;
        }

        public Criteria andAirConfigNotIn(List<String> values) {
            addCriterion("air_config not in", values, "airConfig");
            return (Criteria) this;
        }

        public Criteria andAirConfigBetween(String value1, String value2) {
            addCriterion("air_config between", value1, value2, "airConfig");
            return (Criteria) this;
        }

        public Criteria andAirConfigNotBetween(String value1, String value2) {
            addCriterion("air_config not between", value1, value2, "airConfig");
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

        public Criteria andAvailableIsNull() {
            addCriterion("available is null");
            return (Criteria) this;
        }

        public Criteria andAvailableIsNotNull() {
            addCriterion("available is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableEqualTo(Boolean value) {
            addCriterion("available =", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotEqualTo(Boolean value) {
            addCriterion("available <>", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableGreaterThan(Boolean value) {
            addCriterion("available >", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("available >=", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLessThan(Boolean value) {
            addCriterion("available <", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLessThanOrEqualTo(Boolean value) {
            addCriterion("available <=", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableIn(List<Boolean> values) {
            addCriterion("available in", values, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotIn(List<Boolean> values) {
            addCriterion("available not in", values, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableBetween(Boolean value1, Boolean value2) {
            addCriterion("available between", value1, value2, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("available not between", value1, value2, "available");
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