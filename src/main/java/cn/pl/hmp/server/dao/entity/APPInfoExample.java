package cn.pl.hmp.server.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class APPInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public APPInfoExample() {
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

        public Criteria andAndroidAddrIsNull() {
            addCriterion("android_addr is null");
            return (Criteria) this;
        }

        public Criteria andAndroidAddrIsNotNull() {
            addCriterion("android_addr is not null");
            return (Criteria) this;
        }

        public Criteria andAndroidAddrEqualTo(String value) {
            addCriterion("android_addr =", value, "androidAddr");
            return (Criteria) this;
        }

        public Criteria andAndroidAddrNotEqualTo(String value) {
            addCriterion("android_addr <>", value, "androidAddr");
            return (Criteria) this;
        }

        public Criteria andAndroidAddrGreaterThan(String value) {
            addCriterion("android_addr >", value, "androidAddr");
            return (Criteria) this;
        }

        public Criteria andAndroidAddrGreaterThanOrEqualTo(String value) {
            addCriterion("android_addr >=", value, "androidAddr");
            return (Criteria) this;
        }

        public Criteria andAndroidAddrLessThan(String value) {
            addCriterion("android_addr <", value, "androidAddr");
            return (Criteria) this;
        }

        public Criteria andAndroidAddrLessThanOrEqualTo(String value) {
            addCriterion("android_addr <=", value, "androidAddr");
            return (Criteria) this;
        }

        public Criteria andAndroidAddrLike(String value) {
            addCriterion("android_addr like", value, "androidAddr");
            return (Criteria) this;
        }

        public Criteria andAndroidAddrNotLike(String value) {
            addCriterion("android_addr not like", value, "androidAddr");
            return (Criteria) this;
        }

        public Criteria andAndroidAddrIn(List<String> values) {
            addCriterion("android_addr in", values, "androidAddr");
            return (Criteria) this;
        }

        public Criteria andAndroidAddrNotIn(List<String> values) {
            addCriterion("android_addr not in", values, "androidAddr");
            return (Criteria) this;
        }

        public Criteria andAndroidAddrBetween(String value1, String value2) {
            addCriterion("android_addr between", value1, value2, "androidAddr");
            return (Criteria) this;
        }

        public Criteria andAndroidAddrNotBetween(String value1, String value2) {
            addCriterion("android_addr not between", value1, value2, "androidAddr");
            return (Criteria) this;
        }

        public Criteria andIosAddrIsNull() {
            addCriterion("ios_addr is null");
            return (Criteria) this;
        }

        public Criteria andIosAddrIsNotNull() {
            addCriterion("ios_addr is not null");
            return (Criteria) this;
        }

        public Criteria andIosAddrEqualTo(String value) {
            addCriterion("ios_addr =", value, "iosAddr");
            return (Criteria) this;
        }

        public Criteria andIosAddrNotEqualTo(String value) {
            addCriterion("ios_addr <>", value, "iosAddr");
            return (Criteria) this;
        }

        public Criteria andIosAddrGreaterThan(String value) {
            addCriterion("ios_addr >", value, "iosAddr");
            return (Criteria) this;
        }

        public Criteria andIosAddrGreaterThanOrEqualTo(String value) {
            addCriterion("ios_addr >=", value, "iosAddr");
            return (Criteria) this;
        }

        public Criteria andIosAddrLessThan(String value) {
            addCriterion("ios_addr <", value, "iosAddr");
            return (Criteria) this;
        }

        public Criteria andIosAddrLessThanOrEqualTo(String value) {
            addCriterion("ios_addr <=", value, "iosAddr");
            return (Criteria) this;
        }

        public Criteria andIosAddrLike(String value) {
            addCriterion("ios_addr like", value, "iosAddr");
            return (Criteria) this;
        }

        public Criteria andIosAddrNotLike(String value) {
            addCriterion("ios_addr not like", value, "iosAddr");
            return (Criteria) this;
        }

        public Criteria andIosAddrIn(List<String> values) {
            addCriterion("ios_addr in", values, "iosAddr");
            return (Criteria) this;
        }

        public Criteria andIosAddrNotIn(List<String> values) {
            addCriterion("ios_addr not in", values, "iosAddr");
            return (Criteria) this;
        }

        public Criteria andIosAddrBetween(String value1, String value2) {
            addCriterion("ios_addr between", value1, value2, "iosAddr");
            return (Criteria) this;
        }

        public Criteria andIosAddrNotBetween(String value1, String value2) {
            addCriterion("ios_addr not between", value1, value2, "iosAddr");
            return (Criteria) this;
        }

        public Criteria andSecondAddrIsNull() {
            addCriterion("second_addr is null");
            return (Criteria) this;
        }

        public Criteria andSecondAddrIsNotNull() {
            addCriterion("second_addr is not null");
            return (Criteria) this;
        }

        public Criteria andSecondAddrEqualTo(String value) {
            addCriterion("second_addr =", value, "secondAddr");
            return (Criteria) this;
        }

        public Criteria andSecondAddrNotEqualTo(String value) {
            addCriterion("second_addr <>", value, "secondAddr");
            return (Criteria) this;
        }

        public Criteria andSecondAddrGreaterThan(String value) {
            addCriterion("second_addr >", value, "secondAddr");
            return (Criteria) this;
        }

        public Criteria andSecondAddrGreaterThanOrEqualTo(String value) {
            addCriterion("second_addr >=", value, "secondAddr");
            return (Criteria) this;
        }

        public Criteria andSecondAddrLessThan(String value) {
            addCriterion("second_addr <", value, "secondAddr");
            return (Criteria) this;
        }

        public Criteria andSecondAddrLessThanOrEqualTo(String value) {
            addCriterion("second_addr <=", value, "secondAddr");
            return (Criteria) this;
        }

        public Criteria andSecondAddrLike(String value) {
            addCriterion("second_addr like", value, "secondAddr");
            return (Criteria) this;
        }

        public Criteria andSecondAddrNotLike(String value) {
            addCriterion("second_addr not like", value, "secondAddr");
            return (Criteria) this;
        }

        public Criteria andSecondAddrIn(List<String> values) {
            addCriterion("second_addr in", values, "secondAddr");
            return (Criteria) this;
        }

        public Criteria andSecondAddrNotIn(List<String> values) {
            addCriterion("second_addr not in", values, "secondAddr");
            return (Criteria) this;
        }

        public Criteria andSecondAddrBetween(String value1, String value2) {
            addCriterion("second_addr between", value1, value2, "secondAddr");
            return (Criteria) this;
        }

        public Criteria andSecondAddrNotBetween(String value1, String value2) {
            addCriterion("second_addr not between", value1, value2, "secondAddr");
            return (Criteria) this;
        }

        public Criteria andIntroIsNull() {
            addCriterion("intro is null");
            return (Criteria) this;
        }

        public Criteria andIntroIsNotNull() {
            addCriterion("intro is not null");
            return (Criteria) this;
        }

        public Criteria andIntroEqualTo(String value) {
            addCriterion("intro =", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotEqualTo(String value) {
            addCriterion("intro <>", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThan(String value) {
            addCriterion("intro >", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThanOrEqualTo(String value) {
            addCriterion("intro >=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThan(String value) {
            addCriterion("intro <", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThanOrEqualTo(String value) {
            addCriterion("intro <=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLike(String value) {
            addCriterion("intro like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotLike(String value) {
            addCriterion("intro not like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroIn(List<String> values) {
            addCriterion("intro in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotIn(List<String> values) {
            addCriterion("intro not in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroBetween(String value1, String value2) {
            addCriterion("intro between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotBetween(String value1, String value2) {
            addCriterion("intro not between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andAppImageIsNull() {
            addCriterion("app_image is null");
            return (Criteria) this;
        }

        public Criteria andAppImageIsNotNull() {
            addCriterion("app_image is not null");
            return (Criteria) this;
        }

        public Criteria andAppImageEqualTo(String value) {
            addCriterion("app_image =", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageNotEqualTo(String value) {
            addCriterion("app_image <>", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageGreaterThan(String value) {
            addCriterion("app_image >", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageGreaterThanOrEqualTo(String value) {
            addCriterion("app_image >=", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageLessThan(String value) {
            addCriterion("app_image <", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageLessThanOrEqualTo(String value) {
            addCriterion("app_image <=", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageLike(String value) {
            addCriterion("app_image like", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageNotLike(String value) {
            addCriterion("app_image not like", value, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageIn(List<String> values) {
            addCriterion("app_image in", values, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageNotIn(List<String> values) {
            addCriterion("app_image not in", values, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageBetween(String value1, String value2) {
            addCriterion("app_image between", value1, value2, "appImage");
            return (Criteria) this;
        }

        public Criteria andAppImageNotBetween(String value1, String value2) {
            addCriterion("app_image not between", value1, value2, "appImage");
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