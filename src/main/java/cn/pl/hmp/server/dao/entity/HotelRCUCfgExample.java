package cn.pl.hmp.server.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelRCUCfgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotelRCUCfgExample() {
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

        public Criteria andAnalogInputNumIsNull() {
            addCriterion("analog_input_num is null");
            return (Criteria) this;
        }

        public Criteria andAnalogInputNumIsNotNull() {
            addCriterion("analog_input_num is not null");
            return (Criteria) this;
        }

        public Criteria andAnalogInputNumEqualTo(String value) {
            addCriterion("analog_input_num =", value, "analogInputNum");
            return (Criteria) this;
        }

        public Criteria andAnalogInputNumNotEqualTo(String value) {
            addCriterion("analog_input_num <>", value, "analogInputNum");
            return (Criteria) this;
        }

        public Criteria andAnalogInputNumGreaterThan(String value) {
            addCriterion("analog_input_num >", value, "analogInputNum");
            return (Criteria) this;
        }

        public Criteria andAnalogInputNumGreaterThanOrEqualTo(String value) {
            addCriterion("analog_input_num >=", value, "analogInputNum");
            return (Criteria) this;
        }

        public Criteria andAnalogInputNumLessThan(String value) {
            addCriterion("analog_input_num <", value, "analogInputNum");
            return (Criteria) this;
        }

        public Criteria andAnalogInputNumLessThanOrEqualTo(String value) {
            addCriterion("analog_input_num <=", value, "analogInputNum");
            return (Criteria) this;
        }

        public Criteria andAnalogInputNumLike(String value) {
            addCriterion("analog_input_num like", value, "analogInputNum");
            return (Criteria) this;
        }

        public Criteria andAnalogInputNumNotLike(String value) {
            addCriterion("analog_input_num not like", value, "analogInputNum");
            return (Criteria) this;
        }

        public Criteria andAnalogInputNumIn(List<String> values) {
            addCriterion("analog_input_num in", values, "analogInputNum");
            return (Criteria) this;
        }

        public Criteria andAnalogInputNumNotIn(List<String> values) {
            addCriterion("analog_input_num not in", values, "analogInputNum");
            return (Criteria) this;
        }

        public Criteria andAnalogInputNumBetween(String value1, String value2) {
            addCriterion("analog_input_num between", value1, value2, "analogInputNum");
            return (Criteria) this;
        }

        public Criteria andAnalogInputNumNotBetween(String value1, String value2) {
            addCriterion("analog_input_num not between", value1, value2, "analogInputNum");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNumIsNull() {
            addCriterion("air_conditioner_num is null");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNumIsNotNull() {
            addCriterion("air_conditioner_num is not null");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNumEqualTo(String value) {
            addCriterion("air_conditioner_num =", value, "airConditionerNum");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNumNotEqualTo(String value) {
            addCriterion("air_conditioner_num <>", value, "airConditionerNum");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNumGreaterThan(String value) {
            addCriterion("air_conditioner_num >", value, "airConditionerNum");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNumGreaterThanOrEqualTo(String value) {
            addCriterion("air_conditioner_num >=", value, "airConditionerNum");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNumLessThan(String value) {
            addCriterion("air_conditioner_num <", value, "airConditionerNum");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNumLessThanOrEqualTo(String value) {
            addCriterion("air_conditioner_num <=", value, "airConditionerNum");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNumLike(String value) {
            addCriterion("air_conditioner_num like", value, "airConditionerNum");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNumNotLike(String value) {
            addCriterion("air_conditioner_num not like", value, "airConditionerNum");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNumIn(List<String> values) {
            addCriterion("air_conditioner_num in", values, "airConditionerNum");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNumNotIn(List<String> values) {
            addCriterion("air_conditioner_num not in", values, "airConditionerNum");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNumBetween(String value1, String value2) {
            addCriterion("air_conditioner_num between", value1, value2, "airConditionerNum");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNumNotBetween(String value1, String value2) {
            addCriterion("air_conditioner_num not between", value1, value2, "airConditionerNum");
            return (Criteria) this;
        }

        public Criteria andBoardTypeIsNull() {
            addCriterion("board_type is null");
            return (Criteria) this;
        }

        public Criteria andBoardTypeIsNotNull() {
            addCriterion("board_type is not null");
            return (Criteria) this;
        }

        public Criteria andBoardTypeEqualTo(String value) {
            addCriterion("board_type =", value, "boardType");
            return (Criteria) this;
        }

        public Criteria andBoardTypeNotEqualTo(String value) {
            addCriterion("board_type <>", value, "boardType");
            return (Criteria) this;
        }

        public Criteria andBoardTypeGreaterThan(String value) {
            addCriterion("board_type >", value, "boardType");
            return (Criteria) this;
        }

        public Criteria andBoardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("board_type >=", value, "boardType");
            return (Criteria) this;
        }

        public Criteria andBoardTypeLessThan(String value) {
            addCriterion("board_type <", value, "boardType");
            return (Criteria) this;
        }

        public Criteria andBoardTypeLessThanOrEqualTo(String value) {
            addCriterion("board_type <=", value, "boardType");
            return (Criteria) this;
        }

        public Criteria andBoardTypeLike(String value) {
            addCriterion("board_type like", value, "boardType");
            return (Criteria) this;
        }

        public Criteria andBoardTypeNotLike(String value) {
            addCriterion("board_type not like", value, "boardType");
            return (Criteria) this;
        }

        public Criteria andBoardTypeIn(List<String> values) {
            addCriterion("board_type in", values, "boardType");
            return (Criteria) this;
        }

        public Criteria andBoardTypeNotIn(List<String> values) {
            addCriterion("board_type not in", values, "boardType");
            return (Criteria) this;
        }

        public Criteria andBoardTypeBetween(String value1, String value2) {
            addCriterion("board_type between", value1, value2, "boardType");
            return (Criteria) this;
        }

        public Criteria andBoardTypeNotBetween(String value1, String value2) {
            addCriterion("board_type not between", value1, value2, "boardType");
            return (Criteria) this;
        }

        public Criteria andConnNumIsNull() {
            addCriterion("conn_num is null");
            return (Criteria) this;
        }

        public Criteria andConnNumIsNotNull() {
            addCriterion("conn_num is not null");
            return (Criteria) this;
        }

        public Criteria andConnNumEqualTo(Integer value) {
            addCriterion("conn_num =", value, "connNum");
            return (Criteria) this;
        }

        public Criteria andConnNumNotEqualTo(Integer value) {
            addCriterion("conn_num <>", value, "connNum");
            return (Criteria) this;
        }

        public Criteria andConnNumGreaterThan(Integer value) {
            addCriterion("conn_num >", value, "connNum");
            return (Criteria) this;
        }

        public Criteria andConnNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("conn_num >=", value, "connNum");
            return (Criteria) this;
        }

        public Criteria andConnNumLessThan(Integer value) {
            addCriterion("conn_num <", value, "connNum");
            return (Criteria) this;
        }

        public Criteria andConnNumLessThanOrEqualTo(Integer value) {
            addCriterion("conn_num <=", value, "connNum");
            return (Criteria) this;
        }

        public Criteria andConnNumIn(List<Integer> values) {
            addCriterion("conn_num in", values, "connNum");
            return (Criteria) this;
        }

        public Criteria andConnNumNotIn(List<Integer> values) {
            addCriterion("conn_num not in", values, "connNum");
            return (Criteria) this;
        }

        public Criteria andConnNumBetween(Integer value1, Integer value2) {
            addCriterion("conn_num between", value1, value2, "connNum");
            return (Criteria) this;
        }

        public Criteria andConnNumNotBetween(Integer value1, Integer value2) {
            addCriterion("conn_num not between", value1, value2, "connNum");
            return (Criteria) this;
        }

        public Criteria andDigitalInputNumIsNull() {
            addCriterion("digital_input_num is null");
            return (Criteria) this;
        }

        public Criteria andDigitalInputNumIsNotNull() {
            addCriterion("digital_input_num is not null");
            return (Criteria) this;
        }

        public Criteria andDigitalInputNumEqualTo(String value) {
            addCriterion("digital_input_num =", value, "digitalInputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalInputNumNotEqualTo(String value) {
            addCriterion("digital_input_num <>", value, "digitalInputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalInputNumGreaterThan(String value) {
            addCriterion("digital_input_num >", value, "digitalInputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalInputNumGreaterThanOrEqualTo(String value) {
            addCriterion("digital_input_num >=", value, "digitalInputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalInputNumLessThan(String value) {
            addCriterion("digital_input_num <", value, "digitalInputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalInputNumLessThanOrEqualTo(String value) {
            addCriterion("digital_input_num <=", value, "digitalInputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalInputNumLike(String value) {
            addCriterion("digital_input_num like", value, "digitalInputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalInputNumNotLike(String value) {
            addCriterion("digital_input_num not like", value, "digitalInputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalInputNumIn(List<String> values) {
            addCriterion("digital_input_num in", values, "digitalInputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalInputNumNotIn(List<String> values) {
            addCriterion("digital_input_num not in", values, "digitalInputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalInputNumBetween(String value1, String value2) {
            addCriterion("digital_input_num between", value1, value2, "digitalInputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalInputNumNotBetween(String value1, String value2) {
            addCriterion("digital_input_num not between", value1, value2, "digitalInputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalOutputNumIsNull() {
            addCriterion("digital_output_num is null");
            return (Criteria) this;
        }

        public Criteria andDigitalOutputNumIsNotNull() {
            addCriterion("digital_output_num is not null");
            return (Criteria) this;
        }

        public Criteria andDigitalOutputNumEqualTo(String value) {
            addCriterion("digital_output_num =", value, "digitalOutputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalOutputNumNotEqualTo(String value) {
            addCriterion("digital_output_num <>", value, "digitalOutputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalOutputNumGreaterThan(String value) {
            addCriterion("digital_output_num >", value, "digitalOutputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalOutputNumGreaterThanOrEqualTo(String value) {
            addCriterion("digital_output_num >=", value, "digitalOutputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalOutputNumLessThan(String value) {
            addCriterion("digital_output_num <", value, "digitalOutputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalOutputNumLessThanOrEqualTo(String value) {
            addCriterion("digital_output_num <=", value, "digitalOutputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalOutputNumLike(String value) {
            addCriterion("digital_output_num like", value, "digitalOutputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalOutputNumNotLike(String value) {
            addCriterion("digital_output_num not like", value, "digitalOutputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalOutputNumIn(List<String> values) {
            addCriterion("digital_output_num in", values, "digitalOutputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalOutputNumNotIn(List<String> values) {
            addCriterion("digital_output_num not in", values, "digitalOutputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalOutputNumBetween(String value1, String value2) {
            addCriterion("digital_output_num between", value1, value2, "digitalOutputNum");
            return (Criteria) this;
        }

        public Criteria andDigitalOutputNumNotBetween(String value1, String value2) {
            addCriterion("digital_output_num not between", value1, value2, "digitalOutputNum");
            return (Criteria) this;
        }

        public Criteria andFactoryNumIsNull() {
            addCriterion("factory_num is null");
            return (Criteria) this;
        }

        public Criteria andFactoryNumIsNotNull() {
            addCriterion("factory_num is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryNumEqualTo(String value) {
            addCriterion("factory_num =", value, "factoryNum");
            return (Criteria) this;
        }

        public Criteria andFactoryNumNotEqualTo(String value) {
            addCriterion("factory_num <>", value, "factoryNum");
            return (Criteria) this;
        }

        public Criteria andFactoryNumGreaterThan(String value) {
            addCriterion("factory_num >", value, "factoryNum");
            return (Criteria) this;
        }

        public Criteria andFactoryNumGreaterThanOrEqualTo(String value) {
            addCriterion("factory_num >=", value, "factoryNum");
            return (Criteria) this;
        }

        public Criteria andFactoryNumLessThan(String value) {
            addCriterion("factory_num <", value, "factoryNum");
            return (Criteria) this;
        }

        public Criteria andFactoryNumLessThanOrEqualTo(String value) {
            addCriterion("factory_num <=", value, "factoryNum");
            return (Criteria) this;
        }

        public Criteria andFactoryNumLike(String value) {
            addCriterion("factory_num like", value, "factoryNum");
            return (Criteria) this;
        }

        public Criteria andFactoryNumNotLike(String value) {
            addCriterion("factory_num not like", value, "factoryNum");
            return (Criteria) this;
        }

        public Criteria andFactoryNumIn(List<String> values) {
            addCriterion("factory_num in", values, "factoryNum");
            return (Criteria) this;
        }

        public Criteria andFactoryNumNotIn(List<String> values) {
            addCriterion("factory_num not in", values, "factoryNum");
            return (Criteria) this;
        }

        public Criteria andFactoryNumBetween(String value1, String value2) {
            addCriterion("factory_num between", value1, value2, "factoryNum");
            return (Criteria) this;
        }

        public Criteria andFactoryNumNotBetween(String value1, String value2) {
            addCriterion("factory_num not between", value1, value2, "factoryNum");
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

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andOsVersionIsNull() {
            addCriterion("os_version is null");
            return (Criteria) this;
        }

        public Criteria andOsVersionIsNotNull() {
            addCriterion("os_version is not null");
            return (Criteria) this;
        }

        public Criteria andOsVersionEqualTo(String value) {
            addCriterion("os_version =", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotEqualTo(String value) {
            addCriterion("os_version <>", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionGreaterThan(String value) {
            addCriterion("os_version >", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionGreaterThanOrEqualTo(String value) {
            addCriterion("os_version >=", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionLessThan(String value) {
            addCriterion("os_version <", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionLessThanOrEqualTo(String value) {
            addCriterion("os_version <=", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionLike(String value) {
            addCriterion("os_version like", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotLike(String value) {
            addCriterion("os_version not like", value, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionIn(List<String> values) {
            addCriterion("os_version in", values, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotIn(List<String> values) {
            addCriterion("os_version not in", values, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionBetween(String value1, String value2) {
            addCriterion("os_version between", value1, value2, "osVersion");
            return (Criteria) this;
        }

        public Criteria andOsVersionNotBetween(String value1, String value2) {
            addCriterion("os_version not between", value1, value2, "osVersion");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(Integer value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(Integer value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(Integer value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(Integer value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(Integer value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<Integer> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<Integer> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(Integer value1, Integer value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(Integer value1, Integer value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andProduceTimeIsNull() {
            addCriterion("produce_time is null");
            return (Criteria) this;
        }

        public Criteria andProduceTimeIsNotNull() {
            addCriterion("produce_time is not null");
            return (Criteria) this;
        }

        public Criteria andProduceTimeEqualTo(Date value) {
            addCriterion("produce_time =", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotEqualTo(Date value) {
            addCriterion("produce_time <>", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeGreaterThan(Date value) {
            addCriterion("produce_time >", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("produce_time >=", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeLessThan(Date value) {
            addCriterion("produce_time <", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeLessThanOrEqualTo(Date value) {
            addCriterion("produce_time <=", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeIn(List<Date> values) {
            addCriterion("produce_time in", values, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotIn(List<Date> values) {
            addCriterion("produce_time not in", values, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeBetween(Date value1, Date value2) {
            addCriterion("produce_time between", value1, value2, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotBetween(Date value1, Date value2) {
            addCriterion("produce_time not between", value1, value2, "produceTime");
            return (Criteria) this;
        }

        public Criteria andPowerNumIsNull() {
            addCriterion("power_num is null");
            return (Criteria) this;
        }

        public Criteria andPowerNumIsNotNull() {
            addCriterion("power_num is not null");
            return (Criteria) this;
        }

        public Criteria andPowerNumEqualTo(String value) {
            addCriterion("power_num =", value, "powerNum");
            return (Criteria) this;
        }

        public Criteria andPowerNumNotEqualTo(String value) {
            addCriterion("power_num <>", value, "powerNum");
            return (Criteria) this;
        }

        public Criteria andPowerNumGreaterThan(String value) {
            addCriterion("power_num >", value, "powerNum");
            return (Criteria) this;
        }

        public Criteria andPowerNumGreaterThanOrEqualTo(String value) {
            addCriterion("power_num >=", value, "powerNum");
            return (Criteria) this;
        }

        public Criteria andPowerNumLessThan(String value) {
            addCriterion("power_num <", value, "powerNum");
            return (Criteria) this;
        }

        public Criteria andPowerNumLessThanOrEqualTo(String value) {
            addCriterion("power_num <=", value, "powerNum");
            return (Criteria) this;
        }

        public Criteria andPowerNumLike(String value) {
            addCriterion("power_num like", value, "powerNum");
            return (Criteria) this;
        }

        public Criteria andPowerNumNotLike(String value) {
            addCriterion("power_num not like", value, "powerNum");
            return (Criteria) this;
        }

        public Criteria andPowerNumIn(List<String> values) {
            addCriterion("power_num in", values, "powerNum");
            return (Criteria) this;
        }

        public Criteria andPowerNumNotIn(List<String> values) {
            addCriterion("power_num not in", values, "powerNum");
            return (Criteria) this;
        }

        public Criteria andPowerNumBetween(String value1, String value2) {
            addCriterion("power_num between", value1, value2, "powerNum");
            return (Criteria) this;
        }

        public Criteria andPowerNumNotBetween(String value1, String value2) {
            addCriterion("power_num not between", value1, value2, "powerNum");
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

        public Criteria andDimmerNumIsNull() {
            addCriterion("dimmer_num is null");
            return (Criteria) this;
        }

        public Criteria andDimmerNumIsNotNull() {
            addCriterion("dimmer_num is not null");
            return (Criteria) this;
        }

        public Criteria andDimmerNumEqualTo(String value) {
            addCriterion("dimmer_num =", value, "dimmerNum");
            return (Criteria) this;
        }

        public Criteria andDimmerNumNotEqualTo(String value) {
            addCriterion("dimmer_num <>", value, "dimmerNum");
            return (Criteria) this;
        }

        public Criteria andDimmerNumGreaterThan(String value) {
            addCriterion("dimmer_num >", value, "dimmerNum");
            return (Criteria) this;
        }

        public Criteria andDimmerNumGreaterThanOrEqualTo(String value) {
            addCriterion("dimmer_num >=", value, "dimmerNum");
            return (Criteria) this;
        }

        public Criteria andDimmerNumLessThan(String value) {
            addCriterion("dimmer_num <", value, "dimmerNum");
            return (Criteria) this;
        }

        public Criteria andDimmerNumLessThanOrEqualTo(String value) {
            addCriterion("dimmer_num <=", value, "dimmerNum");
            return (Criteria) this;
        }

        public Criteria andDimmerNumLike(String value) {
            addCriterion("dimmer_num like", value, "dimmerNum");
            return (Criteria) this;
        }

        public Criteria andDimmerNumNotLike(String value) {
            addCriterion("dimmer_num not like", value, "dimmerNum");
            return (Criteria) this;
        }

        public Criteria andDimmerNumIn(List<String> values) {
            addCriterion("dimmer_num in", values, "dimmerNum");
            return (Criteria) this;
        }

        public Criteria andDimmerNumNotIn(List<String> values) {
            addCriterion("dimmer_num not in", values, "dimmerNum");
            return (Criteria) this;
        }

        public Criteria andDimmerNumBetween(String value1, String value2) {
            addCriterion("dimmer_num between", value1, value2, "dimmerNum");
            return (Criteria) this;
        }

        public Criteria andDimmerNumNotBetween(String value1, String value2) {
            addCriterion("dimmer_num not between", value1, value2, "dimmerNum");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andAirConditionerStartIsNull() {
            addCriterion("air_conditioner_start is null");
            return (Criteria) this;
        }

        public Criteria andAirConditionerStartIsNotNull() {
            addCriterion("air_conditioner_start is not null");
            return (Criteria) this;
        }

        public Criteria andAirConditionerStartEqualTo(Integer value) {
            addCriterion("air_conditioner_start =", value, "airConditionerStart");
            return (Criteria) this;
        }

        public Criteria andAirConditionerStartNotEqualTo(Integer value) {
            addCriterion("air_conditioner_start <>", value, "airConditionerStart");
            return (Criteria) this;
        }

        public Criteria andAirConditionerStartGreaterThan(Integer value) {
            addCriterion("air_conditioner_start >", value, "airConditionerStart");
            return (Criteria) this;
        }

        public Criteria andAirConditionerStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("air_conditioner_start >=", value, "airConditionerStart");
            return (Criteria) this;
        }

        public Criteria andAirConditionerStartLessThan(Integer value) {
            addCriterion("air_conditioner_start <", value, "airConditionerStart");
            return (Criteria) this;
        }

        public Criteria andAirConditionerStartLessThanOrEqualTo(Integer value) {
            addCriterion("air_conditioner_start <=", value, "airConditionerStart");
            return (Criteria) this;
        }

        public Criteria andAirConditionerStartIn(List<Integer> values) {
            addCriterion("air_conditioner_start in", values, "airConditionerStart");
            return (Criteria) this;
        }

        public Criteria andAirConditionerStartNotIn(List<Integer> values) {
            addCriterion("air_conditioner_start not in", values, "airConditionerStart");
            return (Criteria) this;
        }

        public Criteria andAirConditionerStartBetween(Integer value1, Integer value2) {
            addCriterion("air_conditioner_start between", value1, value2, "airConditionerStart");
            return (Criteria) this;
        }

        public Criteria andAirConditionerStartNotBetween(Integer value1, Integer value2) {
            addCriterion("air_conditioner_start not between", value1, value2, "airConditionerStart");
            return (Criteria) this;
        }

        public Criteria andLightStartIsNull() {
            addCriterion("light_start is null");
            return (Criteria) this;
        }

        public Criteria andLightStartIsNotNull() {
            addCriterion("light_start is not null");
            return (Criteria) this;
        }

        public Criteria andLightStartEqualTo(Integer value) {
            addCriterion("light_start =", value, "lightStart");
            return (Criteria) this;
        }

        public Criteria andLightStartNotEqualTo(Integer value) {
            addCriterion("light_start <>", value, "lightStart");
            return (Criteria) this;
        }

        public Criteria andLightStartGreaterThan(Integer value) {
            addCriterion("light_start >", value, "lightStart");
            return (Criteria) this;
        }

        public Criteria andLightStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("light_start >=", value, "lightStart");
            return (Criteria) this;
        }

        public Criteria andLightStartLessThan(Integer value) {
            addCriterion("light_start <", value, "lightStart");
            return (Criteria) this;
        }

        public Criteria andLightStartLessThanOrEqualTo(Integer value) {
            addCriterion("light_start <=", value, "lightStart");
            return (Criteria) this;
        }

        public Criteria andLightStartIn(List<Integer> values) {
            addCriterion("light_start in", values, "lightStart");
            return (Criteria) this;
        }

        public Criteria andLightStartNotIn(List<Integer> values) {
            addCriterion("light_start not in", values, "lightStart");
            return (Criteria) this;
        }

        public Criteria andLightStartBetween(Integer value1, Integer value2) {
            addCriterion("light_start between", value1, value2, "lightStart");
            return (Criteria) this;
        }

        public Criteria andLightStartNotBetween(Integer value1, Integer value2) {
            addCriterion("light_start not between", value1, value2, "lightStart");
            return (Criteria) this;
        }

        public Criteria andTimeLockIsNull() {
            addCriterion("time_lock is null");
            return (Criteria) this;
        }

        public Criteria andTimeLockIsNotNull() {
            addCriterion("time_lock is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLockEqualTo(String value) {
            addCriterion("time_lock =", value, "timeLock");
            return (Criteria) this;
        }

        public Criteria andTimeLockNotEqualTo(String value) {
            addCriterion("time_lock <>", value, "timeLock");
            return (Criteria) this;
        }

        public Criteria andTimeLockGreaterThan(String value) {
            addCriterion("time_lock >", value, "timeLock");
            return (Criteria) this;
        }

        public Criteria andTimeLockGreaterThanOrEqualTo(String value) {
            addCriterion("time_lock >=", value, "timeLock");
            return (Criteria) this;
        }

        public Criteria andTimeLockLessThan(String value) {
            addCriterion("time_lock <", value, "timeLock");
            return (Criteria) this;
        }

        public Criteria andTimeLockLessThanOrEqualTo(String value) {
            addCriterion("time_lock <=", value, "timeLock");
            return (Criteria) this;
        }

        public Criteria andTimeLockLike(String value) {
            addCriterion("time_lock like", value, "timeLock");
            return (Criteria) this;
        }

        public Criteria andTimeLockNotLike(String value) {
            addCriterion("time_lock not like", value, "timeLock");
            return (Criteria) this;
        }

        public Criteria andTimeLockIn(List<String> values) {
            addCriterion("time_lock in", values, "timeLock");
            return (Criteria) this;
        }

        public Criteria andTimeLockNotIn(List<String> values) {
            addCriterion("time_lock not in", values, "timeLock");
            return (Criteria) this;
        }

        public Criteria andTimeLockBetween(String value1, String value2) {
            addCriterion("time_lock between", value1, value2, "timeLock");
            return (Criteria) this;
        }

        public Criteria andTimeLockNotBetween(String value1, String value2) {
            addCriterion("time_lock not between", value1, value2, "timeLock");
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