package com.legend.cloud.entity.campus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * CampusTeacher的example类
 *
 * @author hupeiD
 * @date 2018-03-28 10:33:29
 */
public class CampusTeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CampusTeacherExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("'user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andVerifyNumIsNull() {
            addCriterion("verify_num is null");
            return (Criteria) this;
        }

        public Criteria andVerifyNumIsNotNull() {
            addCriterion("verify_num is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyNumEqualTo(Integer value) {
            addCriterion("verify_num =", value, "verify_num");
            return (Criteria) this;
        }

        public Criteria andVerifyNumNotEqualTo(Integer value) {
            addCriterion("'verify_num <>", value, "verify_num");
            return (Criteria) this;
        }

        public Criteria andVerifyNumGreaterThan(Integer value) {
            addCriterion("verify_num >", value, "verify_num");
            return (Criteria) this;
        }

        public Criteria andVerifyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("verify_num >=", value, "verify_num");
            return (Criteria) this;
        }

        public Criteria andVerifyNumLessThan(Integer value) {
            addCriterion("verify_num <", value, "verify_num");
            return (Criteria) this;
        }

        public Criteria andVerifyNumLessThanOrEqualTo(Integer value) {
            addCriterion("verify_num <=", value, "verify_num");
            return (Criteria) this;
        }

        public Criteria andVerifyNumIn(List<Integer> values) {
            addCriterion("verify_num in", values, "verify_num");
            return (Criteria) this;
        }

        public Criteria andVerifyNumNotIn(List<Integer> values) {
            addCriterion("verify_num not in", values, "verify_num");
            return (Criteria) this;
        }

        public Criteria andVerifyNumBetween(Integer value1, Integer value2) {
            addCriterion("verify_num between", value1, value2, "verify_num");
            return (Criteria) this;
        }

        public Criteria andVerifyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("verify_num not between", value1, value2, "verify_num");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNull() {
            addCriterion("is_enabled is null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNotNull() {
            addCriterion("is_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledEqualTo(Boolean value) {
            addCriterion("is_enabled =", value, "is_enabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotEqualTo(Boolean value) {
            addCriterion("'is_enabled <>", value, "is_enabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThan(Boolean value) {
            addCriterion("is_enabled >", value, "is_enabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_enabled >=", value, "is_enabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThan(Boolean value) {
            addCriterion("is_enabled <", value, "is_enabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("is_enabled <=", value, "is_enabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIn(List<Boolean> values) {
            addCriterion("is_enabled in", values, "is_enabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotIn(List<Boolean> values) {
            addCriterion("is_enabled not in", values, "is_enabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enabled between", value1, value2, "is_enabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enabled not between", value1, value2, "is_enabled");
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