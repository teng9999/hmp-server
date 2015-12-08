package cn.pl.hmp.server.dao.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CommondityTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommondityTypeExample() {
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

        public Criteria andColorEnIsNull() {
            addCriterion("color_en is null");
            return (Criteria) this;
        }

        public Criteria andColorEnIsNotNull() {
            addCriterion("color_en is not null");
            return (Criteria) this;
        }

        public Criteria andColorEnEqualTo(String value) {
            addCriterion("color_en =", value, "colorEn");
            return (Criteria) this;
        }

        public Criteria andColorEnNotEqualTo(String value) {
            addCriterion("color_en <>", value, "colorEn");
            return (Criteria) this;
        }

        public Criteria andColorEnGreaterThan(String value) {
            addCriterion("color_en >", value, "colorEn");
            return (Criteria) this;
        }

        public Criteria andColorEnGreaterThanOrEqualTo(String value) {
            addCriterion("color_en >=", value, "colorEn");
            return (Criteria) this;
        }

        public Criteria andColorEnLessThan(String value) {
            addCriterion("color_en <", value, "colorEn");
            return (Criteria) this;
        }

        public Criteria andColorEnLessThanOrEqualTo(String value) {
            addCriterion("color_en <=", value, "colorEn");
            return (Criteria) this;
        }

        public Criteria andColorEnLike(String value) {
            addCriterion("color_en like", value, "colorEn");
            return (Criteria) this;
        }

        public Criteria andColorEnNotLike(String value) {
            addCriterion("color_en not like", value, "colorEn");
            return (Criteria) this;
        }

        public Criteria andColorEnIn(List<String> values) {
            addCriterion("color_en in", values, "colorEn");
            return (Criteria) this;
        }

        public Criteria andColorEnNotIn(List<String> values) {
            addCriterion("color_en not in", values, "colorEn");
            return (Criteria) this;
        }

        public Criteria andColorEnBetween(String value1, String value2) {
            addCriterion("color_en between", value1, value2, "colorEn");
            return (Criteria) this;
        }

        public Criteria andColorEnNotBetween(String value1, String value2) {
            addCriterion("color_en not between", value1, value2, "colorEn");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Long value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Long value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Long value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Long value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Long value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Long> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Long> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Long value1, Long value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Long value1, Long value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andSizesIsNull() {
            addCriterion("sizes is null");
            return (Criteria) this;
        }

        public Criteria andSizesIsNotNull() {
            addCriterion("sizes is not null");
            return (Criteria) this;
        }

        public Criteria andSizesEqualTo(String value) {
            addCriterion("sizes =", value, "sizes");
            return (Criteria) this;
        }

        public Criteria andSizesNotEqualTo(String value) {
            addCriterion("sizes <>", value, "sizes");
            return (Criteria) this;
        }

        public Criteria andSizesGreaterThan(String value) {
            addCriterion("sizes >", value, "sizes");
            return (Criteria) this;
        }

        public Criteria andSizesGreaterThanOrEqualTo(String value) {
            addCriterion("sizes >=", value, "sizes");
            return (Criteria) this;
        }

        public Criteria andSizesLessThan(String value) {
            addCriterion("sizes <", value, "sizes");
            return (Criteria) this;
        }

        public Criteria andSizesLessThanOrEqualTo(String value) {
            addCriterion("sizes <=", value, "sizes");
            return (Criteria) this;
        }

        public Criteria andSizesLike(String value) {
            addCriterion("sizes like", value, "sizes");
            return (Criteria) this;
        }

        public Criteria andSizesNotLike(String value) {
            addCriterion("sizes not like", value, "sizes");
            return (Criteria) this;
        }

        public Criteria andSizesIn(List<String> values) {
            addCriterion("sizes in", values, "sizes");
            return (Criteria) this;
        }

        public Criteria andSizesNotIn(List<String> values) {
            addCriterion("sizes not in", values, "sizes");
            return (Criteria) this;
        }

        public Criteria andSizesBetween(String value1, String value2) {
            addCriterion("sizes between", value1, value2, "sizes");
            return (Criteria) this;
        }

        public Criteria andSizesNotBetween(String value1, String value2) {
            addCriterion("sizes not between", value1, value2, "sizes");
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

        public Criteria andColorCnIsNull() {
            addCriterion("color_cn is null");
            return (Criteria) this;
        }

        public Criteria andColorCnIsNotNull() {
            addCriterion("color_cn is not null");
            return (Criteria) this;
        }

        public Criteria andColorCnEqualTo(String value) {
            addCriterion("color_cn =", value, "colorCn");
            return (Criteria) this;
        }

        public Criteria andColorCnNotEqualTo(String value) {
            addCriterion("color_cn <>", value, "colorCn");
            return (Criteria) this;
        }

        public Criteria andColorCnGreaterThan(String value) {
            addCriterion("color_cn >", value, "colorCn");
            return (Criteria) this;
        }

        public Criteria andColorCnGreaterThanOrEqualTo(String value) {
            addCriterion("color_cn >=", value, "colorCn");
            return (Criteria) this;
        }

        public Criteria andColorCnLessThan(String value) {
            addCriterion("color_cn <", value, "colorCn");
            return (Criteria) this;
        }

        public Criteria andColorCnLessThanOrEqualTo(String value) {
            addCriterion("color_cn <=", value, "colorCn");
            return (Criteria) this;
        }

        public Criteria andColorCnLike(String value) {
            addCriterion("color_cn like", value, "colorCn");
            return (Criteria) this;
        }

        public Criteria andColorCnNotLike(String value) {
            addCriterion("color_cn not like", value, "colorCn");
            return (Criteria) this;
        }

        public Criteria andColorCnIn(List<String> values) {
            addCriterion("color_cn in", values, "colorCn");
            return (Criteria) this;
        }

        public Criteria andColorCnNotIn(List<String> values) {
            addCriterion("color_cn not in", values, "colorCn");
            return (Criteria) this;
        }

        public Criteria andColorCnBetween(String value1, String value2) {
            addCriterion("color_cn between", value1, value2, "colorCn");
            return (Criteria) this;
        }

        public Criteria andColorCnNotBetween(String value1, String value2) {
            addCriterion("color_cn not between", value1, value2, "colorCn");
            return (Criteria) this;
        }

        public Criteria andVipPriceIsNull() {
            addCriterion("vip_price is null");
            return (Criteria) this;
        }

        public Criteria andVipPriceIsNotNull() {
            addCriterion("vip_price is not null");
            return (Criteria) this;
        }

        public Criteria andVipPriceEqualTo(BigDecimal value) {
            addCriterion("vip_price =", value, "vipPrice");
            return (Criteria) this;
        }

        public Criteria andVipPriceNotEqualTo(BigDecimal value) {
            addCriterion("vip_price <>", value, "vipPrice");
            return (Criteria) this;
        }

        public Criteria andVipPriceGreaterThan(BigDecimal value) {
            addCriterion("vip_price >", value, "vipPrice");
            return (Criteria) this;
        }

        public Criteria andVipPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_price >=", value, "vipPrice");
            return (Criteria) this;
        }

        public Criteria andVipPriceLessThan(BigDecimal value) {
            addCriterion("vip_price <", value, "vipPrice");
            return (Criteria) this;
        }

        public Criteria andVipPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_price <=", value, "vipPrice");
            return (Criteria) this;
        }

        public Criteria andVipPriceIn(List<BigDecimal> values) {
            addCriterion("vip_price in", values, "vipPrice");
            return (Criteria) this;
        }

        public Criteria andVipPriceNotIn(List<BigDecimal> values) {
            addCriterion("vip_price not in", values, "vipPrice");
            return (Criteria) this;
        }

        public Criteria andVipPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_price between", value1, value2, "vipPrice");
            return (Criteria) this;
        }

        public Criteria andVipPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_price not between", value1, value2, "vipPrice");
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