package cn.pl.hmp.server.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuPagesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuPagesExample() {
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

        public Criteria andContentCnIsNull() {
            addCriterion("content_cn is null");
            return (Criteria) this;
        }

        public Criteria andContentCnIsNotNull() {
            addCriterion("content_cn is not null");
            return (Criteria) this;
        }

        public Criteria andContentCnEqualTo(String value) {
            addCriterion("content_cn =", value, "contentCn");
            return (Criteria) this;
        }

        public Criteria andContentCnNotEqualTo(String value) {
            addCriterion("content_cn <>", value, "contentCn");
            return (Criteria) this;
        }

        public Criteria andContentCnGreaterThan(String value) {
            addCriterion("content_cn >", value, "contentCn");
            return (Criteria) this;
        }

        public Criteria andContentCnGreaterThanOrEqualTo(String value) {
            addCriterion("content_cn >=", value, "contentCn");
            return (Criteria) this;
        }

        public Criteria andContentCnLessThan(String value) {
            addCriterion("content_cn <", value, "contentCn");
            return (Criteria) this;
        }

        public Criteria andContentCnLessThanOrEqualTo(String value) {
            addCriterion("content_cn <=", value, "contentCn");
            return (Criteria) this;
        }

        public Criteria andContentCnLike(String value) {
            addCriterion("content_cn like", value, "contentCn");
            return (Criteria) this;
        }

        public Criteria andContentCnNotLike(String value) {
            addCriterion("content_cn not like", value, "contentCn");
            return (Criteria) this;
        }

        public Criteria andContentCnIn(List<String> values) {
            addCriterion("content_cn in", values, "contentCn");
            return (Criteria) this;
        }

        public Criteria andContentCnNotIn(List<String> values) {
            addCriterion("content_cn not in", values, "contentCn");
            return (Criteria) this;
        }

        public Criteria andContentCnBetween(String value1, String value2) {
            addCriterion("content_cn between", value1, value2, "contentCn");
            return (Criteria) this;
        }

        public Criteria andContentCnNotBetween(String value1, String value2) {
            addCriterion("content_cn not between", value1, value2, "contentCn");
            return (Criteria) this;
        }

        public Criteria andContentEnIsNull() {
            addCriterion("content_en is null");
            return (Criteria) this;
        }

        public Criteria andContentEnIsNotNull() {
            addCriterion("content_en is not null");
            return (Criteria) this;
        }

        public Criteria andContentEnEqualTo(String value) {
            addCriterion("content_en =", value, "contentEn");
            return (Criteria) this;
        }

        public Criteria andContentEnNotEqualTo(String value) {
            addCriterion("content_en <>", value, "contentEn");
            return (Criteria) this;
        }

        public Criteria andContentEnGreaterThan(String value) {
            addCriterion("content_en >", value, "contentEn");
            return (Criteria) this;
        }

        public Criteria andContentEnGreaterThanOrEqualTo(String value) {
            addCriterion("content_en >=", value, "contentEn");
            return (Criteria) this;
        }

        public Criteria andContentEnLessThan(String value) {
            addCriterion("content_en <", value, "contentEn");
            return (Criteria) this;
        }

        public Criteria andContentEnLessThanOrEqualTo(String value) {
            addCriterion("content_en <=", value, "contentEn");
            return (Criteria) this;
        }

        public Criteria andContentEnLike(String value) {
            addCriterion("content_en like", value, "contentEn");
            return (Criteria) this;
        }

        public Criteria andContentEnNotLike(String value) {
            addCriterion("content_en not like", value, "contentEn");
            return (Criteria) this;
        }

        public Criteria andContentEnIn(List<String> values) {
            addCriterion("content_en in", values, "contentEn");
            return (Criteria) this;
        }

        public Criteria andContentEnNotIn(List<String> values) {
            addCriterion("content_en not in", values, "contentEn");
            return (Criteria) this;
        }

        public Criteria andContentEnBetween(String value1, String value2) {
            addCriterion("content_en between", value1, value2, "contentEn");
            return (Criteria) this;
        }

        public Criteria andContentEnNotBetween(String value1, String value2) {
            addCriterion("content_en not between", value1, value2, "contentEn");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgPositionIsNull() {
            addCriterion("img_position is null");
            return (Criteria) this;
        }

        public Criteria andImgPositionIsNotNull() {
            addCriterion("img_position is not null");
            return (Criteria) this;
        }

        public Criteria andImgPositionEqualTo(String value) {
            addCriterion("img_position =", value, "imgPosition");
            return (Criteria) this;
        }

        public Criteria andImgPositionNotEqualTo(String value) {
            addCriterion("img_position <>", value, "imgPosition");
            return (Criteria) this;
        }

        public Criteria andImgPositionGreaterThan(String value) {
            addCriterion("img_position >", value, "imgPosition");
            return (Criteria) this;
        }

        public Criteria andImgPositionGreaterThanOrEqualTo(String value) {
            addCriterion("img_position >=", value, "imgPosition");
            return (Criteria) this;
        }

        public Criteria andImgPositionLessThan(String value) {
            addCriterion("img_position <", value, "imgPosition");
            return (Criteria) this;
        }

        public Criteria andImgPositionLessThanOrEqualTo(String value) {
            addCriterion("img_position <=", value, "imgPosition");
            return (Criteria) this;
        }

        public Criteria andImgPositionLike(String value) {
            addCriterion("img_position like", value, "imgPosition");
            return (Criteria) this;
        }

        public Criteria andImgPositionNotLike(String value) {
            addCriterion("img_position not like", value, "imgPosition");
            return (Criteria) this;
        }

        public Criteria andImgPositionIn(List<String> values) {
            addCriterion("img_position in", values, "imgPosition");
            return (Criteria) this;
        }

        public Criteria andImgPositionNotIn(List<String> values) {
            addCriterion("img_position not in", values, "imgPosition");
            return (Criteria) this;
        }

        public Criteria andImgPositionBetween(String value1, String value2) {
            addCriterion("img_position between", value1, value2, "imgPosition");
            return (Criteria) this;
        }

        public Criteria andImgPositionNotBetween(String value1, String value2) {
            addCriterion("img_position not between", value1, value2, "imgPosition");
            return (Criteria) this;
        }

        public Criteria andImgWidthIsNull() {
            addCriterion("img_width is null");
            return (Criteria) this;
        }

        public Criteria andImgWidthIsNotNull() {
            addCriterion("img_width is not null");
            return (Criteria) this;
        }

        public Criteria andImgWidthEqualTo(Integer value) {
            addCriterion("img_width =", value, "imgWidth");
            return (Criteria) this;
        }

        public Criteria andImgWidthNotEqualTo(Integer value) {
            addCriterion("img_width <>", value, "imgWidth");
            return (Criteria) this;
        }

        public Criteria andImgWidthGreaterThan(Integer value) {
            addCriterion("img_width >", value, "imgWidth");
            return (Criteria) this;
        }

        public Criteria andImgWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("img_width >=", value, "imgWidth");
            return (Criteria) this;
        }

        public Criteria andImgWidthLessThan(Integer value) {
            addCriterion("img_width <", value, "imgWidth");
            return (Criteria) this;
        }

        public Criteria andImgWidthLessThanOrEqualTo(Integer value) {
            addCriterion("img_width <=", value, "imgWidth");
            return (Criteria) this;
        }

        public Criteria andImgWidthIn(List<Integer> values) {
            addCriterion("img_width in", values, "imgWidth");
            return (Criteria) this;
        }

        public Criteria andImgWidthNotIn(List<Integer> values) {
            addCriterion("img_width not in", values, "imgWidth");
            return (Criteria) this;
        }

        public Criteria andImgWidthBetween(Integer value1, Integer value2) {
            addCriterion("img_width between", value1, value2, "imgWidth");
            return (Criteria) this;
        }

        public Criteria andImgWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("img_width not between", value1, value2, "imgWidth");
            return (Criteria) this;
        }

        public Criteria andTitleCnIsNull() {
            addCriterion("title_cn is null");
            return (Criteria) this;
        }

        public Criteria andTitleCnIsNotNull() {
            addCriterion("title_cn is not null");
            return (Criteria) this;
        }

        public Criteria andTitleCnEqualTo(String value) {
            addCriterion("title_cn =", value, "titleCn");
            return (Criteria) this;
        }

        public Criteria andTitleCnNotEqualTo(String value) {
            addCriterion("title_cn <>", value, "titleCn");
            return (Criteria) this;
        }

        public Criteria andTitleCnGreaterThan(String value) {
            addCriterion("title_cn >", value, "titleCn");
            return (Criteria) this;
        }

        public Criteria andTitleCnGreaterThanOrEqualTo(String value) {
            addCriterion("title_cn >=", value, "titleCn");
            return (Criteria) this;
        }

        public Criteria andTitleCnLessThan(String value) {
            addCriterion("title_cn <", value, "titleCn");
            return (Criteria) this;
        }

        public Criteria andTitleCnLessThanOrEqualTo(String value) {
            addCriterion("title_cn <=", value, "titleCn");
            return (Criteria) this;
        }

        public Criteria andTitleCnLike(String value) {
            addCriterion("title_cn like", value, "titleCn");
            return (Criteria) this;
        }

        public Criteria andTitleCnNotLike(String value) {
            addCriterion("title_cn not like", value, "titleCn");
            return (Criteria) this;
        }

        public Criteria andTitleCnIn(List<String> values) {
            addCriterion("title_cn in", values, "titleCn");
            return (Criteria) this;
        }

        public Criteria andTitleCnNotIn(List<String> values) {
            addCriterion("title_cn not in", values, "titleCn");
            return (Criteria) this;
        }

        public Criteria andTitleCnBetween(String value1, String value2) {
            addCriterion("title_cn between", value1, value2, "titleCn");
            return (Criteria) this;
        }

        public Criteria andTitleCnNotBetween(String value1, String value2) {
            addCriterion("title_cn not between", value1, value2, "titleCn");
            return (Criteria) this;
        }

        public Criteria andTitleEnIsNull() {
            addCriterion("title_en is null");
            return (Criteria) this;
        }

        public Criteria andTitleEnIsNotNull() {
            addCriterion("title_en is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEnEqualTo(String value) {
            addCriterion("title_en =", value, "titleEn");
            return (Criteria) this;
        }

        public Criteria andTitleEnNotEqualTo(String value) {
            addCriterion("title_en <>", value, "titleEn");
            return (Criteria) this;
        }

        public Criteria andTitleEnGreaterThan(String value) {
            addCriterion("title_en >", value, "titleEn");
            return (Criteria) this;
        }

        public Criteria andTitleEnGreaterThanOrEqualTo(String value) {
            addCriterion("title_en >=", value, "titleEn");
            return (Criteria) this;
        }

        public Criteria andTitleEnLessThan(String value) {
            addCriterion("title_en <", value, "titleEn");
            return (Criteria) this;
        }

        public Criteria andTitleEnLessThanOrEqualTo(String value) {
            addCriterion("title_en <=", value, "titleEn");
            return (Criteria) this;
        }

        public Criteria andTitleEnLike(String value) {
            addCriterion("title_en like", value, "titleEn");
            return (Criteria) this;
        }

        public Criteria andTitleEnNotLike(String value) {
            addCriterion("title_en not like", value, "titleEn");
            return (Criteria) this;
        }

        public Criteria andTitleEnIn(List<String> values) {
            addCriterion("title_en in", values, "titleEn");
            return (Criteria) this;
        }

        public Criteria andTitleEnNotIn(List<String> values) {
            addCriterion("title_en not in", values, "titleEn");
            return (Criteria) this;
        }

        public Criteria andTitleEnBetween(String value1, String value2) {
            addCriterion("title_en between", value1, value2, "titleEn");
            return (Criteria) this;
        }

        public Criteria andTitleEnNotBetween(String value1, String value2) {
            addCriterion("title_en not between", value1, value2, "titleEn");
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