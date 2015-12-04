package cn.pl.hmp.server.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HmpRoomTvExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HmpRoomTvExample() {
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

        public Criteria andBackMusicIsNull() {
            addCriterion("back_music is null");
            return (Criteria) this;
        }

        public Criteria andBackMusicIsNotNull() {
            addCriterion("back_music is not null");
            return (Criteria) this;
        }

        public Criteria andBackMusicEqualTo(String value) {
            addCriterion("back_music =", value, "backMusic");
            return (Criteria) this;
        }

        public Criteria andBackMusicNotEqualTo(String value) {
            addCriterion("back_music <>", value, "backMusic");
            return (Criteria) this;
        }

        public Criteria andBackMusicGreaterThan(String value) {
            addCriterion("back_music >", value, "backMusic");
            return (Criteria) this;
        }

        public Criteria andBackMusicGreaterThanOrEqualTo(String value) {
            addCriterion("back_music >=", value, "backMusic");
            return (Criteria) this;
        }

        public Criteria andBackMusicLessThan(String value) {
            addCriterion("back_music <", value, "backMusic");
            return (Criteria) this;
        }

        public Criteria andBackMusicLessThanOrEqualTo(String value) {
            addCriterion("back_music <=", value, "backMusic");
            return (Criteria) this;
        }

        public Criteria andBackMusicLike(String value) {
            addCriterion("back_music like", value, "backMusic");
            return (Criteria) this;
        }

        public Criteria andBackMusicNotLike(String value) {
            addCriterion("back_music not like", value, "backMusic");
            return (Criteria) this;
        }

        public Criteria andBackMusicIn(List<String> values) {
            addCriterion("back_music in", values, "backMusic");
            return (Criteria) this;
        }

        public Criteria andBackMusicNotIn(List<String> values) {
            addCriterion("back_music not in", values, "backMusic");
            return (Criteria) this;
        }

        public Criteria andBackMusicBetween(String value1, String value2) {
            addCriterion("back_music between", value1, value2, "backMusic");
            return (Criteria) this;
        }

        public Criteria andBackMusicNotBetween(String value1, String value2) {
            addCriterion("back_music not between", value1, value2, "backMusic");
            return (Criteria) this;
        }

        public Criteria andHelpImgIsNull() {
            addCriterion("help_img is null");
            return (Criteria) this;
        }

        public Criteria andHelpImgIsNotNull() {
            addCriterion("help_img is not null");
            return (Criteria) this;
        }

        public Criteria andHelpImgEqualTo(String value) {
            addCriterion("help_img =", value, "helpImg");
            return (Criteria) this;
        }

        public Criteria andHelpImgNotEqualTo(String value) {
            addCriterion("help_img <>", value, "helpImg");
            return (Criteria) this;
        }

        public Criteria andHelpImgGreaterThan(String value) {
            addCriterion("help_img >", value, "helpImg");
            return (Criteria) this;
        }

        public Criteria andHelpImgGreaterThanOrEqualTo(String value) {
            addCriterion("help_img >=", value, "helpImg");
            return (Criteria) this;
        }

        public Criteria andHelpImgLessThan(String value) {
            addCriterion("help_img <", value, "helpImg");
            return (Criteria) this;
        }

        public Criteria andHelpImgLessThanOrEqualTo(String value) {
            addCriterion("help_img <=", value, "helpImg");
            return (Criteria) this;
        }

        public Criteria andHelpImgLike(String value) {
            addCriterion("help_img like", value, "helpImg");
            return (Criteria) this;
        }

        public Criteria andHelpImgNotLike(String value) {
            addCriterion("help_img not like", value, "helpImg");
            return (Criteria) this;
        }

        public Criteria andHelpImgIn(List<String> values) {
            addCriterion("help_img in", values, "helpImg");
            return (Criteria) this;
        }

        public Criteria andHelpImgNotIn(List<String> values) {
            addCriterion("help_img not in", values, "helpImg");
            return (Criteria) this;
        }

        public Criteria andHelpImgBetween(String value1, String value2) {
            addCriterion("help_img between", value1, value2, "helpImg");
            return (Criteria) this;
        }

        public Criteria andHelpImgNotBetween(String value1, String value2) {
            addCriterion("help_img not between", value1, value2, "helpImg");
            return (Criteria) this;
        }

        public Criteria andHomeImgIsNull() {
            addCriterion("home_img is null");
            return (Criteria) this;
        }

        public Criteria andHomeImgIsNotNull() {
            addCriterion("home_img is not null");
            return (Criteria) this;
        }

        public Criteria andHomeImgEqualTo(String value) {
            addCriterion("home_img =", value, "homeImg");
            return (Criteria) this;
        }

        public Criteria andHomeImgNotEqualTo(String value) {
            addCriterion("home_img <>", value, "homeImg");
            return (Criteria) this;
        }

        public Criteria andHomeImgGreaterThan(String value) {
            addCriterion("home_img >", value, "homeImg");
            return (Criteria) this;
        }

        public Criteria andHomeImgGreaterThanOrEqualTo(String value) {
            addCriterion("home_img >=", value, "homeImg");
            return (Criteria) this;
        }

        public Criteria andHomeImgLessThan(String value) {
            addCriterion("home_img <", value, "homeImg");
            return (Criteria) this;
        }

        public Criteria andHomeImgLessThanOrEqualTo(String value) {
            addCriterion("home_img <=", value, "homeImg");
            return (Criteria) this;
        }

        public Criteria andHomeImgLike(String value) {
            addCriterion("home_img like", value, "homeImg");
            return (Criteria) this;
        }

        public Criteria andHomeImgNotLike(String value) {
            addCriterion("home_img not like", value, "homeImg");
            return (Criteria) this;
        }

        public Criteria andHomeImgIn(List<String> values) {
            addCriterion("home_img in", values, "homeImg");
            return (Criteria) this;
        }

        public Criteria andHomeImgNotIn(List<String> values) {
            addCriterion("home_img not in", values, "homeImg");
            return (Criteria) this;
        }

        public Criteria andHomeImgBetween(String value1, String value2) {
            addCriterion("home_img between", value1, value2, "homeImg");
            return (Criteria) this;
        }

        public Criteria andHomeImgNotBetween(String value1, String value2) {
            addCriterion("home_img not between", value1, value2, "homeImg");
            return (Criteria) this;
        }

        public Criteria andLogoImgIsNull() {
            addCriterion("logo_img is null");
            return (Criteria) this;
        }

        public Criteria andLogoImgIsNotNull() {
            addCriterion("logo_img is not null");
            return (Criteria) this;
        }

        public Criteria andLogoImgEqualTo(String value) {
            addCriterion("logo_img =", value, "logoImg");
            return (Criteria) this;
        }

        public Criteria andLogoImgNotEqualTo(String value) {
            addCriterion("logo_img <>", value, "logoImg");
            return (Criteria) this;
        }

        public Criteria andLogoImgGreaterThan(String value) {
            addCriterion("logo_img >", value, "logoImg");
            return (Criteria) this;
        }

        public Criteria andLogoImgGreaterThanOrEqualTo(String value) {
            addCriterion("logo_img >=", value, "logoImg");
            return (Criteria) this;
        }

        public Criteria andLogoImgLessThan(String value) {
            addCriterion("logo_img <", value, "logoImg");
            return (Criteria) this;
        }

        public Criteria andLogoImgLessThanOrEqualTo(String value) {
            addCriterion("logo_img <=", value, "logoImg");
            return (Criteria) this;
        }

        public Criteria andLogoImgLike(String value) {
            addCriterion("logo_img like", value, "logoImg");
            return (Criteria) this;
        }

        public Criteria andLogoImgNotLike(String value) {
            addCriterion("logo_img not like", value, "logoImg");
            return (Criteria) this;
        }

        public Criteria andLogoImgIn(List<String> values) {
            addCriterion("logo_img in", values, "logoImg");
            return (Criteria) this;
        }

        public Criteria andLogoImgNotIn(List<String> values) {
            addCriterion("logo_img not in", values, "logoImg");
            return (Criteria) this;
        }

        public Criteria andLogoImgBetween(String value1, String value2) {
            addCriterion("logo_img between", value1, value2, "logoImg");
            return (Criteria) this;
        }

        public Criteria andLogoImgNotBetween(String value1, String value2) {
            addCriterion("logo_img not between", value1, value2, "logoImg");
            return (Criteria) this;
        }

        public Criteria andScreenImgIsNull() {
            addCriterion("screen_img is null");
            return (Criteria) this;
        }

        public Criteria andScreenImgIsNotNull() {
            addCriterion("screen_img is not null");
            return (Criteria) this;
        }

        public Criteria andScreenImgEqualTo(String value) {
            addCriterion("screen_img =", value, "screenImg");
            return (Criteria) this;
        }

        public Criteria andScreenImgNotEqualTo(String value) {
            addCriterion("screen_img <>", value, "screenImg");
            return (Criteria) this;
        }

        public Criteria andScreenImgGreaterThan(String value) {
            addCriterion("screen_img >", value, "screenImg");
            return (Criteria) this;
        }

        public Criteria andScreenImgGreaterThanOrEqualTo(String value) {
            addCriterion("screen_img >=", value, "screenImg");
            return (Criteria) this;
        }

        public Criteria andScreenImgLessThan(String value) {
            addCriterion("screen_img <", value, "screenImg");
            return (Criteria) this;
        }

        public Criteria andScreenImgLessThanOrEqualTo(String value) {
            addCriterion("screen_img <=", value, "screenImg");
            return (Criteria) this;
        }

        public Criteria andScreenImgLike(String value) {
            addCriterion("screen_img like", value, "screenImg");
            return (Criteria) this;
        }

        public Criteria andScreenImgNotLike(String value) {
            addCriterion("screen_img not like", value, "screenImg");
            return (Criteria) this;
        }

        public Criteria andScreenImgIn(List<String> values) {
            addCriterion("screen_img in", values, "screenImg");
            return (Criteria) this;
        }

        public Criteria andScreenImgNotIn(List<String> values) {
            addCriterion("screen_img not in", values, "screenImg");
            return (Criteria) this;
        }

        public Criteria andScreenImgBetween(String value1, String value2) {
            addCriterion("screen_img between", value1, value2, "screenImg");
            return (Criteria) this;
        }

        public Criteria andScreenImgNotBetween(String value1, String value2) {
            addCriterion("screen_img not between", value1, value2, "screenImg");
            return (Criteria) this;
        }

        public Criteria andSolganIsNull() {
            addCriterion("solgan is null");
            return (Criteria) this;
        }

        public Criteria andSolganIsNotNull() {
            addCriterion("solgan is not null");
            return (Criteria) this;
        }

        public Criteria andSolganEqualTo(String value) {
            addCriterion("solgan =", value, "solgan");
            return (Criteria) this;
        }

        public Criteria andSolganNotEqualTo(String value) {
            addCriterion("solgan <>", value, "solgan");
            return (Criteria) this;
        }

        public Criteria andSolganGreaterThan(String value) {
            addCriterion("solgan >", value, "solgan");
            return (Criteria) this;
        }

        public Criteria andSolganGreaterThanOrEqualTo(String value) {
            addCriterion("solgan >=", value, "solgan");
            return (Criteria) this;
        }

        public Criteria andSolganLessThan(String value) {
            addCriterion("solgan <", value, "solgan");
            return (Criteria) this;
        }

        public Criteria andSolganLessThanOrEqualTo(String value) {
            addCriterion("solgan <=", value, "solgan");
            return (Criteria) this;
        }

        public Criteria andSolganLike(String value) {
            addCriterion("solgan like", value, "solgan");
            return (Criteria) this;
        }

        public Criteria andSolganNotLike(String value) {
            addCriterion("solgan not like", value, "solgan");
            return (Criteria) this;
        }

        public Criteria andSolganIn(List<String> values) {
            addCriterion("solgan in", values, "solgan");
            return (Criteria) this;
        }

        public Criteria andSolganNotIn(List<String> values) {
            addCriterion("solgan not in", values, "solgan");
            return (Criteria) this;
        }

        public Criteria andSolganBetween(String value1, String value2) {
            addCriterion("solgan between", value1, value2, "solgan");
            return (Criteria) this;
        }

        public Criteria andSolganNotBetween(String value1, String value2) {
            addCriterion("solgan not between", value1, value2, "solgan");
            return (Criteria) this;
        }

        public Criteria andTvCodeIsNull() {
            addCriterion("tv_code is null");
            return (Criteria) this;
        }

        public Criteria andTvCodeIsNotNull() {
            addCriterion("tv_code is not null");
            return (Criteria) this;
        }

        public Criteria andTvCodeEqualTo(String value) {
            addCriterion("tv_code =", value, "tvCode");
            return (Criteria) this;
        }

        public Criteria andTvCodeNotEqualTo(String value) {
            addCriterion("tv_code <>", value, "tvCode");
            return (Criteria) this;
        }

        public Criteria andTvCodeGreaterThan(String value) {
            addCriterion("tv_code >", value, "tvCode");
            return (Criteria) this;
        }

        public Criteria andTvCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tv_code >=", value, "tvCode");
            return (Criteria) this;
        }

        public Criteria andTvCodeLessThan(String value) {
            addCriterion("tv_code <", value, "tvCode");
            return (Criteria) this;
        }

        public Criteria andTvCodeLessThanOrEqualTo(String value) {
            addCriterion("tv_code <=", value, "tvCode");
            return (Criteria) this;
        }

        public Criteria andTvCodeLike(String value) {
            addCriterion("tv_code like", value, "tvCode");
            return (Criteria) this;
        }

        public Criteria andTvCodeNotLike(String value) {
            addCriterion("tv_code not like", value, "tvCode");
            return (Criteria) this;
        }

        public Criteria andTvCodeIn(List<String> values) {
            addCriterion("tv_code in", values, "tvCode");
            return (Criteria) this;
        }

        public Criteria andTvCodeNotIn(List<String> values) {
            addCriterion("tv_code not in", values, "tvCode");
            return (Criteria) this;
        }

        public Criteria andTvCodeBetween(String value1, String value2) {
            addCriterion("tv_code between", value1, value2, "tvCode");
            return (Criteria) this;
        }

        public Criteria andTvCodeNotBetween(String value1, String value2) {
            addCriterion("tv_code not between", value1, value2, "tvCode");
            return (Criteria) this;
        }

        public Criteria andTvModelIsNull() {
            addCriterion("tv_model is null");
            return (Criteria) this;
        }

        public Criteria andTvModelIsNotNull() {
            addCriterion("tv_model is not null");
            return (Criteria) this;
        }

        public Criteria andTvModelEqualTo(String value) {
            addCriterion("tv_model =", value, "tvModel");
            return (Criteria) this;
        }

        public Criteria andTvModelNotEqualTo(String value) {
            addCriterion("tv_model <>", value, "tvModel");
            return (Criteria) this;
        }

        public Criteria andTvModelGreaterThan(String value) {
            addCriterion("tv_model >", value, "tvModel");
            return (Criteria) this;
        }

        public Criteria andTvModelGreaterThanOrEqualTo(String value) {
            addCriterion("tv_model >=", value, "tvModel");
            return (Criteria) this;
        }

        public Criteria andTvModelLessThan(String value) {
            addCriterion("tv_model <", value, "tvModel");
            return (Criteria) this;
        }

        public Criteria andTvModelLessThanOrEqualTo(String value) {
            addCriterion("tv_model <=", value, "tvModel");
            return (Criteria) this;
        }

        public Criteria andTvModelLike(String value) {
            addCriterion("tv_model like", value, "tvModel");
            return (Criteria) this;
        }

        public Criteria andTvModelNotLike(String value) {
            addCriterion("tv_model not like", value, "tvModel");
            return (Criteria) this;
        }

        public Criteria andTvModelIn(List<String> values) {
            addCriterion("tv_model in", values, "tvModel");
            return (Criteria) this;
        }

        public Criteria andTvModelNotIn(List<String> values) {
            addCriterion("tv_model not in", values, "tvModel");
            return (Criteria) this;
        }

        public Criteria andTvModelBetween(String value1, String value2) {
            addCriterion("tv_model between", value1, value2, "tvModel");
            return (Criteria) this;
        }

        public Criteria andTvModelNotBetween(String value1, String value2) {
            addCriterion("tv_model not between", value1, value2, "tvModel");
            return (Criteria) this;
        }

        public Criteria andTvNumIsNull() {
            addCriterion("tv_num is null");
            return (Criteria) this;
        }

        public Criteria andTvNumIsNotNull() {
            addCriterion("tv_num is not null");
            return (Criteria) this;
        }

        public Criteria andTvNumEqualTo(String value) {
            addCriterion("tv_num =", value, "tvNum");
            return (Criteria) this;
        }

        public Criteria andTvNumNotEqualTo(String value) {
            addCriterion("tv_num <>", value, "tvNum");
            return (Criteria) this;
        }

        public Criteria andTvNumGreaterThan(String value) {
            addCriterion("tv_num >", value, "tvNum");
            return (Criteria) this;
        }

        public Criteria andTvNumGreaterThanOrEqualTo(String value) {
            addCriterion("tv_num >=", value, "tvNum");
            return (Criteria) this;
        }

        public Criteria andTvNumLessThan(String value) {
            addCriterion("tv_num <", value, "tvNum");
            return (Criteria) this;
        }

        public Criteria andTvNumLessThanOrEqualTo(String value) {
            addCriterion("tv_num <=", value, "tvNum");
            return (Criteria) this;
        }

        public Criteria andTvNumLike(String value) {
            addCriterion("tv_num like", value, "tvNum");
            return (Criteria) this;
        }

        public Criteria andTvNumNotLike(String value) {
            addCriterion("tv_num not like", value, "tvNum");
            return (Criteria) this;
        }

        public Criteria andTvNumIn(List<String> values) {
            addCriterion("tv_num in", values, "tvNum");
            return (Criteria) this;
        }

        public Criteria andTvNumNotIn(List<String> values) {
            addCriterion("tv_num not in", values, "tvNum");
            return (Criteria) this;
        }

        public Criteria andTvNumBetween(String value1, String value2) {
            addCriterion("tv_num between", value1, value2, "tvNum");
            return (Criteria) this;
        }

        public Criteria andTvNumNotBetween(String value1, String value2) {
            addCriterion("tv_num not between", value1, value2, "tvNum");
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

        public Criteria andWelcomeCtIsNull() {
            addCriterion("welcome_ct is null");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtIsNotNull() {
            addCriterion("welcome_ct is not null");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEqualTo(String value) {
            addCriterion("welcome_ct =", value, "welcomeCt");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtNotEqualTo(String value) {
            addCriterion("welcome_ct <>", value, "welcomeCt");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtGreaterThan(String value) {
            addCriterion("welcome_ct >", value, "welcomeCt");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtGreaterThanOrEqualTo(String value) {
            addCriterion("welcome_ct >=", value, "welcomeCt");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtLessThan(String value) {
            addCriterion("welcome_ct <", value, "welcomeCt");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtLessThanOrEqualTo(String value) {
            addCriterion("welcome_ct <=", value, "welcomeCt");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtLike(String value) {
            addCriterion("welcome_ct like", value, "welcomeCt");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtNotLike(String value) {
            addCriterion("welcome_ct not like", value, "welcomeCt");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtIn(List<String> values) {
            addCriterion("welcome_ct in", values, "welcomeCt");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtNotIn(List<String> values) {
            addCriterion("welcome_ct not in", values, "welcomeCt");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtBetween(String value1, String value2) {
            addCriterion("welcome_ct between", value1, value2, "welcomeCt");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtNotBetween(String value1, String value2) {
            addCriterion("welcome_ct not between", value1, value2, "welcomeCt");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEnIsNull() {
            addCriterion("welcome_ct_en is null");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEnIsNotNull() {
            addCriterion("welcome_ct_en is not null");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEnEqualTo(String value) {
            addCriterion("welcome_ct_en =", value, "welcomeCtEn");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEnNotEqualTo(String value) {
            addCriterion("welcome_ct_en <>", value, "welcomeCtEn");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEnGreaterThan(String value) {
            addCriterion("welcome_ct_en >", value, "welcomeCtEn");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEnGreaterThanOrEqualTo(String value) {
            addCriterion("welcome_ct_en >=", value, "welcomeCtEn");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEnLessThan(String value) {
            addCriterion("welcome_ct_en <", value, "welcomeCtEn");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEnLessThanOrEqualTo(String value) {
            addCriterion("welcome_ct_en <=", value, "welcomeCtEn");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEnLike(String value) {
            addCriterion("welcome_ct_en like", value, "welcomeCtEn");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEnNotLike(String value) {
            addCriterion("welcome_ct_en not like", value, "welcomeCtEn");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEnIn(List<String> values) {
            addCriterion("welcome_ct_en in", values, "welcomeCtEn");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEnNotIn(List<String> values) {
            addCriterion("welcome_ct_en not in", values, "welcomeCtEn");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEnBetween(String value1, String value2) {
            addCriterion("welcome_ct_en between", value1, value2, "welcomeCtEn");
            return (Criteria) this;
        }

        public Criteria andWelcomeCtEnNotBetween(String value1, String value2) {
            addCriterion("welcome_ct_en not between", value1, value2, "welcomeCtEn");
            return (Criteria) this;
        }

        public Criteria andWelcomeImgIsNull() {
            addCriterion("welcome_img is null");
            return (Criteria) this;
        }

        public Criteria andWelcomeImgIsNotNull() {
            addCriterion("welcome_img is not null");
            return (Criteria) this;
        }

        public Criteria andWelcomeImgEqualTo(String value) {
            addCriterion("welcome_img =", value, "welcomeImg");
            return (Criteria) this;
        }

        public Criteria andWelcomeImgNotEqualTo(String value) {
            addCriterion("welcome_img <>", value, "welcomeImg");
            return (Criteria) this;
        }

        public Criteria andWelcomeImgGreaterThan(String value) {
            addCriterion("welcome_img >", value, "welcomeImg");
            return (Criteria) this;
        }

        public Criteria andWelcomeImgGreaterThanOrEqualTo(String value) {
            addCriterion("welcome_img >=", value, "welcomeImg");
            return (Criteria) this;
        }

        public Criteria andWelcomeImgLessThan(String value) {
            addCriterion("welcome_img <", value, "welcomeImg");
            return (Criteria) this;
        }

        public Criteria andWelcomeImgLessThanOrEqualTo(String value) {
            addCriterion("welcome_img <=", value, "welcomeImg");
            return (Criteria) this;
        }

        public Criteria andWelcomeImgLike(String value) {
            addCriterion("welcome_img like", value, "welcomeImg");
            return (Criteria) this;
        }

        public Criteria andWelcomeImgNotLike(String value) {
            addCriterion("welcome_img not like", value, "welcomeImg");
            return (Criteria) this;
        }

        public Criteria andWelcomeImgIn(List<String> values) {
            addCriterion("welcome_img in", values, "welcomeImg");
            return (Criteria) this;
        }

        public Criteria andWelcomeImgNotIn(List<String> values) {
            addCriterion("welcome_img not in", values, "welcomeImg");
            return (Criteria) this;
        }

        public Criteria andWelcomeImgBetween(String value1, String value2) {
            addCriterion("welcome_img between", value1, value2, "welcomeImg");
            return (Criteria) this;
        }

        public Criteria andWelcomeImgNotBetween(String value1, String value2) {
            addCriterion("welcome_img not between", value1, value2, "welcomeImg");
            return (Criteria) this;
        }

        public Criteria andSolganCnIsNull() {
            addCriterion("solgan_cn is null");
            return (Criteria) this;
        }

        public Criteria andSolganCnIsNotNull() {
            addCriterion("solgan_cn is not null");
            return (Criteria) this;
        }

        public Criteria andSolganCnEqualTo(String value) {
            addCriterion("solgan_cn =", value, "solganCn");
            return (Criteria) this;
        }

        public Criteria andSolganCnNotEqualTo(String value) {
            addCriterion("solgan_cn <>", value, "solganCn");
            return (Criteria) this;
        }

        public Criteria andSolganCnGreaterThan(String value) {
            addCriterion("solgan_cn >", value, "solganCn");
            return (Criteria) this;
        }

        public Criteria andSolganCnGreaterThanOrEqualTo(String value) {
            addCriterion("solgan_cn >=", value, "solganCn");
            return (Criteria) this;
        }

        public Criteria andSolganCnLessThan(String value) {
            addCriterion("solgan_cn <", value, "solganCn");
            return (Criteria) this;
        }

        public Criteria andSolganCnLessThanOrEqualTo(String value) {
            addCriterion("solgan_cn <=", value, "solganCn");
            return (Criteria) this;
        }

        public Criteria andSolganCnLike(String value) {
            addCriterion("solgan_cn like", value, "solganCn");
            return (Criteria) this;
        }

        public Criteria andSolganCnNotLike(String value) {
            addCriterion("solgan_cn not like", value, "solganCn");
            return (Criteria) this;
        }

        public Criteria andSolganCnIn(List<String> values) {
            addCriterion("solgan_cn in", values, "solganCn");
            return (Criteria) this;
        }

        public Criteria andSolganCnNotIn(List<String> values) {
            addCriterion("solgan_cn not in", values, "solganCn");
            return (Criteria) this;
        }

        public Criteria andSolganCnBetween(String value1, String value2) {
            addCriterion("solgan_cn between", value1, value2, "solganCn");
            return (Criteria) this;
        }

        public Criteria andSolganCnNotBetween(String value1, String value2) {
            addCriterion("solgan_cn not between", value1, value2, "solganCn");
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