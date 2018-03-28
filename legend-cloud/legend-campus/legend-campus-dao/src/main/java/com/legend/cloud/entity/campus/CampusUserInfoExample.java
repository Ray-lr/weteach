package com.legend.cloud.entity.campus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * CampusUserInfo的example类
 *
 * @author hupeiD
 * @date 2018-03-28 10:33:29
 */
public class CampusUserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CampusUserInfoExample() {
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

    protected abstract static class AbstractGeneratedCriteria {
        protected List<Criterion> criteria;

        protected AbstractGeneratedCriteria() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("'id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdIsNull() {
            addCriterion("base_user_id is null");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdIsNotNull() {
            addCriterion("base_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdEqualTo(Integer value) {
            addCriterion("base_user_id =", value, "base_user_id");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdNotEqualTo(Integer value) {
            addCriterion("'base_user_id <>", value, "base_user_id");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdGreaterThan(Integer value) {
            addCriterion("base_user_id >", value, "base_user_id");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("base_user_id >=", value, "base_user_id");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdLessThan(Integer value) {
            addCriterion("base_user_id <", value, "base_user_id");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("base_user_id <=", value, "base_user_id");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdIn(List<Integer> values) {
            addCriterion("base_user_id in", values, "base_user_id");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdNotIn(List<Integer> values) {
            addCriterion("base_user_id not in", values, "base_user_id");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdBetween(Integer value1, Integer value2) {
            addCriterion("base_user_id between", value1, value2, "base_user_id");
            return (Criteria) this;
        }

        public Criteria andBaseUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("base_user_id not between", value1, value2, "base_user_id");
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
            addCriterion("'name <>", value, "name");
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

        public Criteria andNameLessThanOrEqualTo(Integer value) {
            addCriterion("name <=", value, "name");
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

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("'nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(Integer value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("'sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNull() {
            addCriterion("native_place is null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNotNull() {
            addCriterion("native_place is not null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceEqualTo(String value) {
            addCriterion("native_place =", value, "native_place");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotEqualTo(String value) {
            addCriterion("'native_place <>", value, "native_place");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThan(String value) {
            addCriterion("native_place >", value, "native_place");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("native_place >=", value, "native_place");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThan(String value) {
            addCriterion("native_place <", value, "native_place");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThanOrEqualTo(Integer value) {
            addCriterion("native_place <=", value, "native_place");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIn(List<String> values) {
            addCriterion("native_place in", values, "native_place");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotIn(List<String> values) {
            addCriterion("native_place not in", values, "native_place");
            return (Criteria) this;
        }

        public Criteria andNativePlaceBetween(String value1, String value2) {
            addCriterion("native_place between", value1, value2, "native_place");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotBetween(String value1, String value2) {
            addCriterion("native_place not between", value1, value2, "native_place");
            return (Criteria) this;
        }

        public Criteria andDeptIsNull() {
            addCriterion("dept is null");
            return (Criteria) this;
        }

        public Criteria andDeptIsNotNull() {
            addCriterion("dept is not null");
            return (Criteria) this;
        }

        public Criteria andDeptEqualTo(String value) {
            addCriterion("dept =", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotEqualTo(String value) {
            addCriterion("'dept <>", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptGreaterThan(String value) {
            addCriterion("dept >", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptGreaterThanOrEqualTo(String value) {
            addCriterion("dept >=", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLessThan(String value) {
            addCriterion("dept <", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLessThanOrEqualTo(Integer value) {
            addCriterion("dept <=", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptIn(List<String> values) {
            addCriterion("dept in", values, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotIn(List<String> values) {
            addCriterion("dept not in", values, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptBetween(String value1, String value2) {
            addCriterion("dept between", value1, value2, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotBetween(String value1, String value2) {
            addCriterion("dept not between", value1, value2, "dept");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("'major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(Integer value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(String value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(String value) {
            addCriterion("'direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(String value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(String value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(Integer value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<String> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<String> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(String value1, String value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(String value1, String value2) {
            addCriterion("direction not between", value1, value2, "direction");
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
            addCriterion("'phone <>", value, "phone");
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

        public Criteria andPhoneLessThanOrEqualTo(Integer value) {
            addCriterion("phone <=", value, "phone");
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

        public Criteria andQicqIsNull() {
            addCriterion("qicq is null");
            return (Criteria) this;
        }

        public Criteria andQicqIsNotNull() {
            addCriterion("qicq is not null");
            return (Criteria) this;
        }

        public Criteria andQicqEqualTo(String value) {
            addCriterion("qicq =", value, "qicq");
            return (Criteria) this;
        }

        public Criteria andQicqNotEqualTo(String value) {
            addCriterion("'qicq <>", value, "qicq");
            return (Criteria) this;
        }

        public Criteria andQicqGreaterThan(String value) {
            addCriterion("qicq >", value, "qicq");
            return (Criteria) this;
        }

        public Criteria andQicqGreaterThanOrEqualTo(String value) {
            addCriterion("qicq >=", value, "qicq");
            return (Criteria) this;
        }

        public Criteria andQicqLessThan(String value) {
            addCriterion("qicq <", value, "qicq");
            return (Criteria) this;
        }

        public Criteria andQicqLessThanOrEqualTo(Integer value) {
            addCriterion("qicq <=", value, "qicq");
            return (Criteria) this;
        }

        public Criteria andQicqIn(List<String> values) {
            addCriterion("qicq in", values, "qicq");
            return (Criteria) this;
        }

        public Criteria andQicqNotIn(List<String> values) {
            addCriterion("qicq not in", values, "qicq");
            return (Criteria) this;
        }

        public Criteria andQicqBetween(String value1, String value2) {
            addCriterion("qicq between", value1, value2, "qicq");
            return (Criteria) this;
        }

        public Criteria andQicqNotBetween(String value1, String value2) {
            addCriterion("qicq not between", value1, value2, "qicq");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("'email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(Integer value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCreditsIsNull() {
            addCriterion("credits is null");
            return (Criteria) this;
        }

        public Criteria andCreditsIsNotNull() {
            addCriterion("credits is not null");
            return (Criteria) this;
        }

        public Criteria andCreditsEqualTo(Integer value) {
            addCriterion("credits =", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotEqualTo(Integer value) {
            addCriterion("'credits <>", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsGreaterThan(Integer value) {
            addCriterion("credits >", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsGreaterThanOrEqualTo(Integer value) {
            addCriterion("credits >=", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsLessThan(Integer value) {
            addCriterion("credits <", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsLessThanOrEqualTo(Integer value) {
            addCriterion("credits <=", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsIn(List<Integer> values) {
            addCriterion("credits in", values, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotIn(List<Integer> values) {
            addCriterion("credits not in", values, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsBetween(Integer value1, Integer value2) {
            addCriterion("credits between", value1, value2, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotBetween(Integer value1, Integer value2) {
            addCriterion("credits not between", value1, value2, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsLevelIsNull() {
            addCriterion("credits_level is null");
            return (Criteria) this;
        }

        public Criteria andCreditsLevelIsNotNull() {
            addCriterion("credits_level is not null");
            return (Criteria) this;
        }

        public Criteria andCreditsLevelEqualTo(String value) {
            addCriterion("credits_level =", value, "credits_level");
            return (Criteria) this;
        }

        public Criteria andCreditsLevelNotEqualTo(String value) {
            addCriterion("'credits_level <>", value, "credits_level");
            return (Criteria) this;
        }

        public Criteria andCreditsLevelGreaterThan(String value) {
            addCriterion("credits_level >", value, "credits_level");
            return (Criteria) this;
        }

        public Criteria andCreditsLevelGreaterThanOrEqualTo(String value) {
            addCriterion("credits_level >=", value, "credits_level");
            return (Criteria) this;
        }

        public Criteria andCreditsLevelLessThan(String value) {
            addCriterion("credits_level <", value, "credits_level");
            return (Criteria) this;
        }

        public Criteria andCreditsLevelLessThanOrEqualTo(Integer value) {
            addCriterion("credits_level <=", value, "credits_level");
            return (Criteria) this;
        }

        public Criteria andCreditsLevelIn(List<String> values) {
            addCriterion("credits_level in", values, "credits_level");
            return (Criteria) this;
        }

        public Criteria andCreditsLevelNotIn(List<String> values) {
            addCriterion("credits_level not in", values, "credits_level");
            return (Criteria) this;
        }

        public Criteria andCreditsLevelBetween(String value1, String value2) {
            addCriterion("credits_level between", value1, value2, "credits_level");
            return (Criteria) this;
        }

        public Criteria andCreditsLevelNotBetween(String value1, String value2) {
            addCriterion("credits_level not between", value1, value2, "credits_level");
            return (Criteria) this;
        }

        public Criteria andOrderJoinIsNull() {
            addCriterion("order_join is null");
            return (Criteria) this;
        }

        public Criteria andOrderJoinIsNotNull() {
            addCriterion("order_join is not null");
            return (Criteria) this;
        }

        public Criteria andOrderJoinEqualTo(Integer value) {
            addCriterion("order_join =", value, "order_join");
            return (Criteria) this;
        }

        public Criteria andOrderJoinNotEqualTo(Integer value) {
            addCriterion("'order_join <>", value, "order_join");
            return (Criteria) this;
        }

        public Criteria andOrderJoinGreaterThan(Integer value) {
            addCriterion("order_join >", value, "order_join");
            return (Criteria) this;
        }

        public Criteria andOrderJoinGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_join >=", value, "order_join");
            return (Criteria) this;
        }

        public Criteria andOrderJoinLessThan(Integer value) {
            addCriterion("order_join <", value, "order_join");
            return (Criteria) this;
        }

        public Criteria andOrderJoinLessThanOrEqualTo(Integer value) {
            addCriterion("order_join <=", value, "order_join");
            return (Criteria) this;
        }

        public Criteria andOrderJoinIn(List<Integer> values) {
            addCriterion("order_join in", values, "order_join");
            return (Criteria) this;
        }

        public Criteria andOrderJoinNotIn(List<Integer> values) {
            addCriterion("order_join not in", values, "order_join");
            return (Criteria) this;
        }

        public Criteria andOrderJoinBetween(Integer value1, Integer value2) {
            addCriterion("order_join between", value1, value2, "order_join");
            return (Criteria) this;
        }

        public Criteria andOrderJoinNotBetween(Integer value1, Integer value2) {
            addCriterion("order_join not between", value1, value2, "order_join");
            return (Criteria) this;
        }

        public Criteria andOrderPublishIsNull() {
            addCriterion("order_publish is null");
            return (Criteria) this;
        }

        public Criteria andOrderPublishIsNotNull() {
            addCriterion("order_publish is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPublishEqualTo(Integer value) {
            addCriterion("order_publish =", value, "order_publish");
            return (Criteria) this;
        }

        public Criteria andOrderPublishNotEqualTo(Integer value) {
            addCriterion("'order_publish <>", value, "order_publish");
            return (Criteria) this;
        }

        public Criteria andOrderPublishGreaterThan(Integer value) {
            addCriterion("order_publish >", value, "order_publish");
            return (Criteria) this;
        }

        public Criteria andOrderPublishGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_publish >=", value, "order_publish");
            return (Criteria) this;
        }

        public Criteria andOrderPublishLessThan(Integer value) {
            addCriterion("order_publish <", value, "order_publish");
            return (Criteria) this;
        }

        public Criteria andOrderPublishLessThanOrEqualTo(Integer value) {
            addCriterion("order_publish <=", value, "order_publish");
            return (Criteria) this;
        }

        public Criteria andOrderPublishIn(List<Integer> values) {
            addCriterion("order_publish in", values, "order_publish");
            return (Criteria) this;
        }

        public Criteria andOrderPublishNotIn(List<Integer> values) {
            addCriterion("order_publish not in", values, "order_publish");
            return (Criteria) this;
        }

        public Criteria andOrderPublishBetween(Integer value1, Integer value2) {
            addCriterion("order_publish between", value1, value2, "order_publish");
            return (Criteria) this;
        }

        public Criteria andOrderPublishNotBetween(Integer value1, Integer value2) {
            addCriterion("order_publish not between", value1, value2, "order_publish");
            return (Criteria) this;
        }

        public Criteria andOrderFinishIsNull() {
            addCriterion("order_finish is null");
            return (Criteria) this;
        }

        public Criteria andOrderFinishIsNotNull() {
            addCriterion("order_finish is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFinishEqualTo(Integer value) {
            addCriterion("order_finish =", value, "order_finish");
            return (Criteria) this;
        }

        public Criteria andOrderFinishNotEqualTo(Integer value) {
            addCriterion("'order_finish <>", value, "order_finish");
            return (Criteria) this;
        }

        public Criteria andOrderFinishGreaterThan(Integer value) {
            addCriterion("order_finish >", value, "order_finish");
            return (Criteria) this;
        }

        public Criteria andOrderFinishGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_finish >=", value, "order_finish");
            return (Criteria) this;
        }

        public Criteria andOrderFinishLessThan(Integer value) {
            addCriterion("order_finish <", value, "order_finish");
            return (Criteria) this;
        }

        public Criteria andOrderFinishLessThanOrEqualTo(Integer value) {
            addCriterion("order_finish <=", value, "order_finish");
            return (Criteria) this;
        }

        public Criteria andOrderFinishIn(List<Integer> values) {
            addCriterion("order_finish in", values, "order_finish");
            return (Criteria) this;
        }

        public Criteria andOrderFinishNotIn(List<Integer> values) {
            addCriterion("order_finish not in", values, "order_finish");
            return (Criteria) this;
        }

        public Criteria andOrderFinishBetween(Integer value1, Integer value2) {
            addCriterion("order_finish between", value1, value2, "order_finish");
            return (Criteria) this;
        }

        public Criteria andOrderFinishNotBetween(Integer value1, Integer value2) {
            addCriterion("order_finish not between", value1, value2, "order_finish");
            return (Criteria) this;
        }

        public Criteria andPercentageCompleteIsNull() {
            addCriterion("percentage_complete is null");
            return (Criteria) this;
        }

        public Criteria andPercentageCompleteIsNotNull() {
            addCriterion("percentage_complete is not null");
            return (Criteria) this;
        }

        public Criteria andPercentageCompleteEqualTo(Double value) {
            addCriterion("percentage_complete =", value, "percentage_complete");
            return (Criteria) this;
        }

        public Criteria andPercentageCompleteNotEqualTo(Double value) {
            addCriterion("'percentage_complete <>", value, "percentage_complete");
            return (Criteria) this;
        }

        public Criteria andPercentageCompleteGreaterThan(Double value) {
            addCriterion("percentage_complete >", value, "percentage_complete");
            return (Criteria) this;
        }

        public Criteria andPercentageCompleteGreaterThanOrEqualTo(Double value) {
            addCriterion("percentage_complete >=", value, "percentage_complete");
            return (Criteria) this;
        }

        public Criteria andPercentageCompleteLessThan(Double value) {
            addCriterion("percentage_complete <", value, "percentage_complete");
            return (Criteria) this;
        }

        public Criteria andPercentageCompleteLessThanOrEqualTo(Integer value) {
            addCriterion("percentage_complete <=", value, "percentage_complete");
            return (Criteria) this;
        }

        public Criteria andPercentageCompleteIn(List<Double> values) {
            addCriterion("percentage_complete in", values, "percentage_complete");
            return (Criteria) this;
        }

        public Criteria andPercentageCompleteNotIn(List<Double> values) {
            addCriterion("percentage_complete not in", values, "percentage_complete");
            return (Criteria) this;
        }

        public Criteria andPercentageCompleteBetween(Double value1, Double value2) {
            addCriterion("percentage_complete between", value1, value2, "percentage_complete");
            return (Criteria) this;
        }

        public Criteria andPercentageCompleteNotBetween(Double value1, Double value2) {
            addCriterion("percentage_complete not between", value1, value2, "percentage_complete");
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
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("'create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("'update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("'is_deleted <>", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("is_deleted <=", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "is_deleted");
            return (Criteria) this;
        }
    }

    public static class Criteria extends AbstractGeneratedCriteria {

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