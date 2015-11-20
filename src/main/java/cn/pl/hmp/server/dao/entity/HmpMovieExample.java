package cn.pl.hmp.server.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HmpMovieExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HmpMovieExample() {
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

        public Criteria andNameCnIsNull() {
            addCriterion("name_cn is null");
            return (Criteria) this;
        }

        public Criteria andNameCnIsNotNull() {
            addCriterion("name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andNameCnEqualTo(String value) {
            addCriterion("name_cn =", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotEqualTo(String value) {
            addCriterion("name_cn <>", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnGreaterThan(String value) {
            addCriterion("name_cn >", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("name_cn >=", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLessThan(String value) {
            addCriterion("name_cn <", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLessThanOrEqualTo(String value) {
            addCriterion("name_cn <=", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLike(String value) {
            addCriterion("name_cn like", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotLike(String value) {
            addCriterion("name_cn not like", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnIn(List<String> values) {
            addCriterion("name_cn in", values, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotIn(List<String> values) {
            addCriterion("name_cn not in", values, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnBetween(String value1, String value2) {
            addCriterion("name_cn between", value1, value2, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotBetween(String value1, String value2) {
            addCriterion("name_cn not between", value1, value2, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNull() {
            addCriterion("name_en is null");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNotNull() {
            addCriterion("name_en is not null");
            return (Criteria) this;
        }

        public Criteria andNameEnEqualTo(String value) {
            addCriterion("name_en =", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotEqualTo(String value) {
            addCriterion("name_en <>", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThan(String value) {
            addCriterion("name_en >", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("name_en >=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThan(String value) {
            addCriterion("name_en <", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThanOrEqualTo(String value) {
            addCriterion("name_en <=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLike(String value) {
            addCriterion("name_en like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotLike(String value) {
            addCriterion("name_en not like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnIn(List<String> values) {
            addCriterion("name_en in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotIn(List<String> values) {
            addCriterion("name_en not in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnBetween(String value1, String value2) {
            addCriterion("name_en between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotBetween(String value1, String value2) {
            addCriterion("name_en not between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andFirstSpellIsNull() {
            addCriterion("first_spell is null");
            return (Criteria) this;
        }

        public Criteria andFirstSpellIsNotNull() {
            addCriterion("first_spell is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSpellEqualTo(String value) {
            addCriterion("first_spell =", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellNotEqualTo(String value) {
            addCriterion("first_spell <>", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellGreaterThan(String value) {
            addCriterion("first_spell >", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellGreaterThanOrEqualTo(String value) {
            addCriterion("first_spell >=", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellLessThan(String value) {
            addCriterion("first_spell <", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellLessThanOrEqualTo(String value) {
            addCriterion("first_spell <=", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellLike(String value) {
            addCriterion("first_spell like", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellNotLike(String value) {
            addCriterion("first_spell not like", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellIn(List<String> values) {
            addCriterion("first_spell in", values, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellNotIn(List<String> values) {
            addCriterion("first_spell not in", values, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellBetween(String value1, String value2) {
            addCriterion("first_spell between", value1, value2, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellNotBetween(String value1, String value2) {
            addCriterion("first_spell not between", value1, value2, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andAllSpellIsNull() {
            addCriterion("all_spell is null");
            return (Criteria) this;
        }

        public Criteria andAllSpellIsNotNull() {
            addCriterion("all_spell is not null");
            return (Criteria) this;
        }

        public Criteria andAllSpellEqualTo(String value) {
            addCriterion("all_spell =", value, "allSpell");
            return (Criteria) this;
        }

        public Criteria andAllSpellNotEqualTo(String value) {
            addCriterion("all_spell <>", value, "allSpell");
            return (Criteria) this;
        }

        public Criteria andAllSpellGreaterThan(String value) {
            addCriterion("all_spell >", value, "allSpell");
            return (Criteria) this;
        }

        public Criteria andAllSpellGreaterThanOrEqualTo(String value) {
            addCriterion("all_spell >=", value, "allSpell");
            return (Criteria) this;
        }

        public Criteria andAllSpellLessThan(String value) {
            addCriterion("all_spell <", value, "allSpell");
            return (Criteria) this;
        }

        public Criteria andAllSpellLessThanOrEqualTo(String value) {
            addCriterion("all_spell <=", value, "allSpell");
            return (Criteria) this;
        }

        public Criteria andAllSpellLike(String value) {
            addCriterion("all_spell like", value, "allSpell");
            return (Criteria) this;
        }

        public Criteria andAllSpellNotLike(String value) {
            addCriterion("all_spell not like", value, "allSpell");
            return (Criteria) this;
        }

        public Criteria andAllSpellIn(List<String> values) {
            addCriterion("all_spell in", values, "allSpell");
            return (Criteria) this;
        }

        public Criteria andAllSpellNotIn(List<String> values) {
            addCriterion("all_spell not in", values, "allSpell");
            return (Criteria) this;
        }

        public Criteria andAllSpellBetween(String value1, String value2) {
            addCriterion("all_spell between", value1, value2, "allSpell");
            return (Criteria) this;
        }

        public Criteria andAllSpellNotBetween(String value1, String value2) {
            addCriterion("all_spell not between", value1, value2, "allSpell");
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

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andBackImgIsNull() {
            addCriterion("back_img is null");
            return (Criteria) this;
        }

        public Criteria andBackImgIsNotNull() {
            addCriterion("back_img is not null");
            return (Criteria) this;
        }

        public Criteria andBackImgEqualTo(String value) {
            addCriterion("back_img =", value, "backImg");
            return (Criteria) this;
        }

        public Criteria andBackImgNotEqualTo(String value) {
            addCriterion("back_img <>", value, "backImg");
            return (Criteria) this;
        }

        public Criteria andBackImgGreaterThan(String value) {
            addCriterion("back_img >", value, "backImg");
            return (Criteria) this;
        }

        public Criteria andBackImgGreaterThanOrEqualTo(String value) {
            addCriterion("back_img >=", value, "backImg");
            return (Criteria) this;
        }

        public Criteria andBackImgLessThan(String value) {
            addCriterion("back_img <", value, "backImg");
            return (Criteria) this;
        }

        public Criteria andBackImgLessThanOrEqualTo(String value) {
            addCriterion("back_img <=", value, "backImg");
            return (Criteria) this;
        }

        public Criteria andBackImgLike(String value) {
            addCriterion("back_img like", value, "backImg");
            return (Criteria) this;
        }

        public Criteria andBackImgNotLike(String value) {
            addCriterion("back_img not like", value, "backImg");
            return (Criteria) this;
        }

        public Criteria andBackImgIn(List<String> values) {
            addCriterion("back_img in", values, "backImg");
            return (Criteria) this;
        }

        public Criteria andBackImgNotIn(List<String> values) {
            addCriterion("back_img not in", values, "backImg");
            return (Criteria) this;
        }

        public Criteria andBackImgBetween(String value1, String value2) {
            addCriterion("back_img between", value1, value2, "backImg");
            return (Criteria) this;
        }

        public Criteria andBackImgNotBetween(String value1, String value2) {
            addCriterion("back_img not between", value1, value2, "backImg");
            return (Criteria) this;
        }

        public Criteria andBackImgSmallIsNull() {
            addCriterion("back_img_small is null");
            return (Criteria) this;
        }

        public Criteria andBackImgSmallIsNotNull() {
            addCriterion("back_img_small is not null");
            return (Criteria) this;
        }

        public Criteria andBackImgSmallEqualTo(String value) {
            addCriterion("back_img_small =", value, "backImgSmall");
            return (Criteria) this;
        }

        public Criteria andBackImgSmallNotEqualTo(String value) {
            addCriterion("back_img_small <>", value, "backImgSmall");
            return (Criteria) this;
        }

        public Criteria andBackImgSmallGreaterThan(String value) {
            addCriterion("back_img_small >", value, "backImgSmall");
            return (Criteria) this;
        }

        public Criteria andBackImgSmallGreaterThanOrEqualTo(String value) {
            addCriterion("back_img_small >=", value, "backImgSmall");
            return (Criteria) this;
        }

        public Criteria andBackImgSmallLessThan(String value) {
            addCriterion("back_img_small <", value, "backImgSmall");
            return (Criteria) this;
        }

        public Criteria andBackImgSmallLessThanOrEqualTo(String value) {
            addCriterion("back_img_small <=", value, "backImgSmall");
            return (Criteria) this;
        }

        public Criteria andBackImgSmallLike(String value) {
            addCriterion("back_img_small like", value, "backImgSmall");
            return (Criteria) this;
        }

        public Criteria andBackImgSmallNotLike(String value) {
            addCriterion("back_img_small not like", value, "backImgSmall");
            return (Criteria) this;
        }

        public Criteria andBackImgSmallIn(List<String> values) {
            addCriterion("back_img_small in", values, "backImgSmall");
            return (Criteria) this;
        }

        public Criteria andBackImgSmallNotIn(List<String> values) {
            addCriterion("back_img_small not in", values, "backImgSmall");
            return (Criteria) this;
        }

        public Criteria andBackImgSmallBetween(String value1, String value2) {
            addCriterion("back_img_small between", value1, value2, "backImgSmall");
            return (Criteria) this;
        }

        public Criteria andBackImgSmallNotBetween(String value1, String value2) {
            addCriterion("back_img_small not between", value1, value2, "backImgSmall");
            return (Criteria) this;
        }

        public Criteria andPlaceNumIsNull() {
            addCriterion("place_num is null");
            return (Criteria) this;
        }

        public Criteria andPlaceNumIsNotNull() {
            addCriterion("place_num is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceNumEqualTo(String value) {
            addCriterion("place_num =", value, "placeNum");
            return (Criteria) this;
        }

        public Criteria andPlaceNumNotEqualTo(String value) {
            addCriterion("place_num <>", value, "placeNum");
            return (Criteria) this;
        }

        public Criteria andPlaceNumGreaterThan(String value) {
            addCriterion("place_num >", value, "placeNum");
            return (Criteria) this;
        }

        public Criteria andPlaceNumGreaterThanOrEqualTo(String value) {
            addCriterion("place_num >=", value, "placeNum");
            return (Criteria) this;
        }

        public Criteria andPlaceNumLessThan(String value) {
            addCriterion("place_num <", value, "placeNum");
            return (Criteria) this;
        }

        public Criteria andPlaceNumLessThanOrEqualTo(String value) {
            addCriterion("place_num <=", value, "placeNum");
            return (Criteria) this;
        }

        public Criteria andPlaceNumLike(String value) {
            addCriterion("place_num like", value, "placeNum");
            return (Criteria) this;
        }

        public Criteria andPlaceNumNotLike(String value) {
            addCriterion("place_num not like", value, "placeNum");
            return (Criteria) this;
        }

        public Criteria andPlaceNumIn(List<String> values) {
            addCriterion("place_num in", values, "placeNum");
            return (Criteria) this;
        }

        public Criteria andPlaceNumNotIn(List<String> values) {
            addCriterion("place_num not in", values, "placeNum");
            return (Criteria) this;
        }

        public Criteria andPlaceNumBetween(String value1, String value2) {
            addCriterion("place_num between", value1, value2, "placeNum");
            return (Criteria) this;
        }

        public Criteria andPlaceNumNotBetween(String value1, String value2) {
            addCriterion("place_num not between", value1, value2, "placeNum");
            return (Criteria) this;
        }

        public Criteria andFirstClassIsNull() {
            addCriterion("first_class is null");
            return (Criteria) this;
        }

        public Criteria andFirstClassIsNotNull() {
            addCriterion("first_class is not null");
            return (Criteria) this;
        }

        public Criteria andFirstClassEqualTo(String value) {
            addCriterion("first_class =", value, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassNotEqualTo(String value) {
            addCriterion("first_class <>", value, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassGreaterThan(String value) {
            addCriterion("first_class >", value, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassGreaterThanOrEqualTo(String value) {
            addCriterion("first_class >=", value, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassLessThan(String value) {
            addCriterion("first_class <", value, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassLessThanOrEqualTo(String value) {
            addCriterion("first_class <=", value, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassLike(String value) {
            addCriterion("first_class like", value, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassNotLike(String value) {
            addCriterion("first_class not like", value, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassIn(List<String> values) {
            addCriterion("first_class in", values, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassNotIn(List<String> values) {
            addCriterion("first_class not in", values, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassBetween(String value1, String value2) {
            addCriterion("first_class between", value1, value2, "firstClass");
            return (Criteria) this;
        }

        public Criteria andFirstClassNotBetween(String value1, String value2) {
            addCriterion("first_class not between", value1, value2, "firstClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassIsNull() {
            addCriterion("second_class is null");
            return (Criteria) this;
        }

        public Criteria andSecondClassIsNotNull() {
            addCriterion("second_class is not null");
            return (Criteria) this;
        }

        public Criteria andSecondClassEqualTo(String value) {
            addCriterion("second_class =", value, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassNotEqualTo(String value) {
            addCriterion("second_class <>", value, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassGreaterThan(String value) {
            addCriterion("second_class >", value, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassGreaterThanOrEqualTo(String value) {
            addCriterion("second_class >=", value, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassLessThan(String value) {
            addCriterion("second_class <", value, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassLessThanOrEqualTo(String value) {
            addCriterion("second_class <=", value, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassLike(String value) {
            addCriterion("second_class like", value, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassNotLike(String value) {
            addCriterion("second_class not like", value, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassIn(List<String> values) {
            addCriterion("second_class in", values, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassNotIn(List<String> values) {
            addCriterion("second_class not in", values, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassBetween(String value1, String value2) {
            addCriterion("second_class between", value1, value2, "secondClass");
            return (Criteria) this;
        }

        public Criteria andSecondClassNotBetween(String value1, String value2) {
            addCriterion("second_class not between", value1, value2, "secondClass");
            return (Criteria) this;
        }

        public Criteria andShowYearIsNull() {
            addCriterion("show_year is null");
            return (Criteria) this;
        }

        public Criteria andShowYearIsNotNull() {
            addCriterion("show_year is not null");
            return (Criteria) this;
        }

        public Criteria andShowYearEqualTo(String value) {
            addCriterion("show_year =", value, "showYear");
            return (Criteria) this;
        }

        public Criteria andShowYearNotEqualTo(String value) {
            addCriterion("show_year <>", value, "showYear");
            return (Criteria) this;
        }

        public Criteria andShowYearGreaterThan(String value) {
            addCriterion("show_year >", value, "showYear");
            return (Criteria) this;
        }

        public Criteria andShowYearGreaterThanOrEqualTo(String value) {
            addCriterion("show_year >=", value, "showYear");
            return (Criteria) this;
        }

        public Criteria andShowYearLessThan(String value) {
            addCriterion("show_year <", value, "showYear");
            return (Criteria) this;
        }

        public Criteria andShowYearLessThanOrEqualTo(String value) {
            addCriterion("show_year <=", value, "showYear");
            return (Criteria) this;
        }

        public Criteria andShowYearLike(String value) {
            addCriterion("show_year like", value, "showYear");
            return (Criteria) this;
        }

        public Criteria andShowYearNotLike(String value) {
            addCriterion("show_year not like", value, "showYear");
            return (Criteria) this;
        }

        public Criteria andShowYearIn(List<String> values) {
            addCriterion("show_year in", values, "showYear");
            return (Criteria) this;
        }

        public Criteria andShowYearNotIn(List<String> values) {
            addCriterion("show_year not in", values, "showYear");
            return (Criteria) this;
        }

        public Criteria andShowYearBetween(String value1, String value2) {
            addCriterion("show_year between", value1, value2, "showYear");
            return (Criteria) this;
        }

        public Criteria andShowYearNotBetween(String value1, String value2) {
            addCriterion("show_year not between", value1, value2, "showYear");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andSetNumIsNull() {
            addCriterion("set_num is null");
            return (Criteria) this;
        }

        public Criteria andSetNumIsNotNull() {
            addCriterion("set_num is not null");
            return (Criteria) this;
        }

        public Criteria andSetNumEqualTo(String value) {
            addCriterion("set_num =", value, "setNum");
            return (Criteria) this;
        }

        public Criteria andSetNumNotEqualTo(String value) {
            addCriterion("set_num <>", value, "setNum");
            return (Criteria) this;
        }

        public Criteria andSetNumGreaterThan(String value) {
            addCriterion("set_num >", value, "setNum");
            return (Criteria) this;
        }

        public Criteria andSetNumGreaterThanOrEqualTo(String value) {
            addCriterion("set_num >=", value, "setNum");
            return (Criteria) this;
        }

        public Criteria andSetNumLessThan(String value) {
            addCriterion("set_num <", value, "setNum");
            return (Criteria) this;
        }

        public Criteria andSetNumLessThanOrEqualTo(String value) {
            addCriterion("set_num <=", value, "setNum");
            return (Criteria) this;
        }

        public Criteria andSetNumLike(String value) {
            addCriterion("set_num like", value, "setNum");
            return (Criteria) this;
        }

        public Criteria andSetNumNotLike(String value) {
            addCriterion("set_num not like", value, "setNum");
            return (Criteria) this;
        }

        public Criteria andSetNumIn(List<String> values) {
            addCriterion("set_num in", values, "setNum");
            return (Criteria) this;
        }

        public Criteria andSetNumNotIn(List<String> values) {
            addCriterion("set_num not in", values, "setNum");
            return (Criteria) this;
        }

        public Criteria andSetNumBetween(String value1, String value2) {
            addCriterion("set_num between", value1, value2, "setNum");
            return (Criteria) this;
        }

        public Criteria andSetNumNotBetween(String value1, String value2) {
            addCriterion("set_num not between", value1, value2, "setNum");
            return (Criteria) this;
        }

        public Criteria andDirectIsNull() {
            addCriterion("direct is null");
            return (Criteria) this;
        }

        public Criteria andDirectIsNotNull() {
            addCriterion("direct is not null");
            return (Criteria) this;
        }

        public Criteria andDirectEqualTo(String value) {
            addCriterion("direct =", value, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectNotEqualTo(String value) {
            addCriterion("direct <>", value, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectGreaterThan(String value) {
            addCriterion("direct >", value, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectGreaterThanOrEqualTo(String value) {
            addCriterion("direct >=", value, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectLessThan(String value) {
            addCriterion("direct <", value, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectLessThanOrEqualTo(String value) {
            addCriterion("direct <=", value, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectLike(String value) {
            addCriterion("direct like", value, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectNotLike(String value) {
            addCriterion("direct not like", value, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectIn(List<String> values) {
            addCriterion("direct in", values, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectNotIn(List<String> values) {
            addCriterion("direct not in", values, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectBetween(String value1, String value2) {
            addCriterion("direct between", value1, value2, "direct");
            return (Criteria) this;
        }

        public Criteria andDirectNotBetween(String value1, String value2) {
            addCriterion("direct not between", value1, value2, "direct");
            return (Criteria) this;
        }

        public Criteria andMovieLanIsNull() {
            addCriterion("movie_lan is null");
            return (Criteria) this;
        }

        public Criteria andMovieLanIsNotNull() {
            addCriterion("movie_lan is not null");
            return (Criteria) this;
        }

        public Criteria andMovieLanEqualTo(String value) {
            addCriterion("movie_lan =", value, "movieLan");
            return (Criteria) this;
        }

        public Criteria andMovieLanNotEqualTo(String value) {
            addCriterion("movie_lan <>", value, "movieLan");
            return (Criteria) this;
        }

        public Criteria andMovieLanGreaterThan(String value) {
            addCriterion("movie_lan >", value, "movieLan");
            return (Criteria) this;
        }

        public Criteria andMovieLanGreaterThanOrEqualTo(String value) {
            addCriterion("movie_lan >=", value, "movieLan");
            return (Criteria) this;
        }

        public Criteria andMovieLanLessThan(String value) {
            addCriterion("movie_lan <", value, "movieLan");
            return (Criteria) this;
        }

        public Criteria andMovieLanLessThanOrEqualTo(String value) {
            addCriterion("movie_lan <=", value, "movieLan");
            return (Criteria) this;
        }

        public Criteria andMovieLanLike(String value) {
            addCriterion("movie_lan like", value, "movieLan");
            return (Criteria) this;
        }

        public Criteria andMovieLanNotLike(String value) {
            addCriterion("movie_lan not like", value, "movieLan");
            return (Criteria) this;
        }

        public Criteria andMovieLanIn(List<String> values) {
            addCriterion("movie_lan in", values, "movieLan");
            return (Criteria) this;
        }

        public Criteria andMovieLanNotIn(List<String> values) {
            addCriterion("movie_lan not in", values, "movieLan");
            return (Criteria) this;
        }

        public Criteria andMovieLanBetween(String value1, String value2) {
            addCriterion("movie_lan between", value1, value2, "movieLan");
            return (Criteria) this;
        }

        public Criteria andMovieLanNotBetween(String value1, String value2) {
            addCriterion("movie_lan not between", value1, value2, "movieLan");
            return (Criteria) this;
        }

        public Criteria andTimeLengthIsNull() {
            addCriterion("time_length is null");
            return (Criteria) this;
        }

        public Criteria andTimeLengthIsNotNull() {
            addCriterion("time_length is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLengthEqualTo(String value) {
            addCriterion("time_length =", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthNotEqualTo(String value) {
            addCriterion("time_length <>", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthGreaterThan(String value) {
            addCriterion("time_length >", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthGreaterThanOrEqualTo(String value) {
            addCriterion("time_length >=", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthLessThan(String value) {
            addCriterion("time_length <", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthLessThanOrEqualTo(String value) {
            addCriterion("time_length <=", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthLike(String value) {
            addCriterion("time_length like", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthNotLike(String value) {
            addCriterion("time_length not like", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthIn(List<String> values) {
            addCriterion("time_length in", values, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthNotIn(List<String> values) {
            addCriterion("time_length not in", values, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthBetween(String value1, String value2) {
            addCriterion("time_length between", value1, value2, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthNotBetween(String value1, String value2) {
            addCriterion("time_length not between", value1, value2, "timeLength");
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