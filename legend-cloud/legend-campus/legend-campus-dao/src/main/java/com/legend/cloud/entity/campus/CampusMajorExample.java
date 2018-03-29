package com.legend.cloud.entity.campus;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Date;

/**
 * CampusMajor的example类
 *
 * @author hupeiD
 * @date 2018-03-29 20:08:43
 */
public class CampusMajorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CampusMajorExample() {
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
                    public Criteria andDeptIdIsNull() {
                addCriterion("dept_id is null");
                return (Criteria) this;
            }

            public Criteria andDeptIdIsNotNull() {
                addCriterion("dept_id is not null");
                return (Criteria) this;
            }

            public Criteria andDeptIdEqualTo(Integer value) {
                addCriterion("dept_id =", value, "dept_id");
                return (Criteria) this;
            }

            public Criteria andDeptIdNotEqualTo(Integer value) {
                addCriterion("'dept_id <>", value, "dept_id");
                return (Criteria) this;
            }

            public Criteria andDeptIdGreaterThan(Integer value) {
                addCriterion("dept_id >", value, "dept_id");
                return (Criteria) this;
            }

            public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
                addCriterion("dept_id >=", value, "dept_id");
                return (Criteria) this;
            }

            public Criteria andDeptIdLessThan(Integer value) {
                addCriterion("dept_id <", value, "dept_id");
                return (Criteria) this;
            }

            public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
                addCriterion("dept_id <=", value, "dept_id");
                return (Criteria) this;
            }

            public Criteria andDeptIdIn(List<Integer> values) {
                addCriterion("dept_id in", values, "dept_id");
                return (Criteria) this;
            }

            public Criteria andDeptIdNotIn(List<Integer> values) {
                addCriterion("dept_id not in", values, "dept_id");
                return (Criteria) this;
            }

            public Criteria andDeptIdBetween(Integer value1, Integer value2) {
                addCriterion("dept_id between", value1, value2, "dept_id");
                return (Criteria) this;
            }

            public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
                addCriterion("dept_id not between", value1, value2, "dept_id");
                return (Criteria) this;
            }
                    public Criteria andAbbreviationIsNull() {
                addCriterion("abbreviation is null");
                return (Criteria) this;
            }

            public Criteria andAbbreviationIsNotNull() {
                addCriterion("abbreviation is not null");
                return (Criteria) this;
            }

            public Criteria andAbbreviationEqualTo(String value) {
                addCriterion("abbreviation =", value, "abbreviation");
                return (Criteria) this;
            }

            public Criteria andAbbreviationNotEqualTo(String value) {
                addCriterion("'abbreviation <>", value, "abbreviation");
                return (Criteria) this;
            }

            public Criteria andAbbreviationGreaterThan(String value) {
                addCriterion("abbreviation >", value, "abbreviation");
                return (Criteria) this;
            }

            public Criteria andAbbreviationGreaterThanOrEqualTo(String value) {
                addCriterion("abbreviation >=", value, "abbreviation");
                return (Criteria) this;
            }

            public Criteria andAbbreviationLessThan(String value) {
                addCriterion("abbreviation <", value, "abbreviation");
                return (Criteria) this;
            }

            public Criteria andAbbreviationLessThanOrEqualTo(Integer value) {
                addCriterion("abbreviation <=", value, "abbreviation");
                return (Criteria) this;
            }

            public Criteria andAbbreviationIn(List<String> values) {
                addCriterion("abbreviation in", values, "abbreviation");
                return (Criteria) this;
            }

            public Criteria andAbbreviationNotIn(List<String> values) {
                addCriterion("abbreviation not in", values, "abbreviation");
                return (Criteria) this;
            }

            public Criteria andAbbreviationBetween(String value1, String value2) {
                addCriterion("abbreviation between", value1, value2, "abbreviation");
                return (Criteria) this;
            }

            public Criteria andAbbreviationNotBetween(String value1, String value2) {
                addCriterion("abbreviation not between", value1, value2, "abbreviation");
                return (Criteria) this;
            }
                    public Criteria andTypeMajorIsNull() {
                addCriterion("type_major is null");
                return (Criteria) this;
            }

            public Criteria andTypeMajorIsNotNull() {
                addCriterion("type_major is not null");
                return (Criteria) this;
            }

            public Criteria andTypeMajorEqualTo(Integer value) {
                addCriterion("type_major =", value, "type_major");
                return (Criteria) this;
            }

            public Criteria andTypeMajorNotEqualTo(Integer value) {
                addCriterion("'type_major <>", value, "type_major");
                return (Criteria) this;
            }

            public Criteria andTypeMajorGreaterThan(Integer value) {
                addCriterion("type_major >", value, "type_major");
                return (Criteria) this;
            }

            public Criteria andTypeMajorGreaterThanOrEqualTo(Integer value) {
                addCriterion("type_major >=", value, "type_major");
                return (Criteria) this;
            }

            public Criteria andTypeMajorLessThan(Integer value) {
                addCriterion("type_major <", value, "type_major");
                return (Criteria) this;
            }

            public Criteria andTypeMajorLessThanOrEqualTo(Integer value) {
                addCriterion("type_major <=", value, "type_major");
                return (Criteria) this;
            }

            public Criteria andTypeMajorIn(List<Integer> values) {
                addCriterion("type_major in", values, "type_major");
                return (Criteria) this;
            }

            public Criteria andTypeMajorNotIn(List<Integer> values) {
                addCriterion("type_major not in", values, "type_major");
                return (Criteria) this;
            }

            public Criteria andTypeMajorBetween(Integer value1, Integer value2) {
                addCriterion("type_major between", value1, value2, "type_major");
                return (Criteria) this;
            }

            public Criteria andTypeMajorNotBetween(Integer value1, Integer value2) {
                addCriterion("type_major not between", value1, value2, "type_major");
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