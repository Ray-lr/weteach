package com.legend.cloud.entity.campus;

        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

/**
 * CampusStatistics的example类
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:06
 */
public class CampusStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CampusStatisticsExample() {
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
                addCriterion("${column.columnname} in", values, "${column.columnname}");
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
                    public Criteria andDescriptionIsNull() {
                addCriterion("description is null");
                return (Criteria) this;
            }

            public Criteria andDescriptionIsNotNull() {
                addCriterion("description is not null");
                return (Criteria) this;
            }

            public Criteria andDescriptionEqualTo(String value) {
                addCriterion("description =", value, "description");
                return (Criteria) this;
            }

            public Criteria andDescriptionNotEqualTo(String value) {
                addCriterion("'description <>", value, "description");
                return (Criteria) this;
            }

            public Criteria andDescriptionGreaterThan(String value) {
                addCriterion("description >", value, "description");
                return (Criteria) this;
            }

            public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
                addCriterion("description >=", value, "description");
                return (Criteria) this;
            }

            public Criteria andDescriptionLessThan(String value) {
                addCriterion("description <", value, "description");
                return (Criteria) this;
            }

            public Criteria andDescriptionLessThanOrEqualTo(Integer value) {
                addCriterion("description <=", value, "description");
                return (Criteria) this;
            }

            public Criteria andDescriptionIn(List<String> values) {
                addCriterion("${column.columnname} in", values, "${column.columnname}");
                return (Criteria) this;
            }

            public Criteria andDescriptionNotIn(List<String> values) {
                addCriterion("description not in", values, "description");
                return (Criteria) this;
            }

            public Criteria andDescriptionBetween(String value1, String value2) {
                addCriterion("description between", value1, value2, "description");
                return (Criteria) this;
            }

            public Criteria andDescriptionNotBetween(String value1, String value2) {
                addCriterion("description not between", value1, value2, "description");
                return (Criteria) this;
            }
                    public Criteria andRemarkIsNull() {
                addCriterion("remark is null");
                return (Criteria) this;
            }

            public Criteria andRemarkIsNotNull() {
                addCriterion("remark is not null");
                return (Criteria) this;
            }

            public Criteria andRemarkEqualTo(String value) {
                addCriterion("remark =", value, "remark");
                return (Criteria) this;
            }

            public Criteria andRemarkNotEqualTo(String value) {
                addCriterion("'remark <>", value, "remark");
                return (Criteria) this;
            }

            public Criteria andRemarkGreaterThan(String value) {
                addCriterion("remark >", value, "remark");
                return (Criteria) this;
            }

            public Criteria andRemarkGreaterThanOrEqualTo(String value) {
                addCriterion("remark >=", value, "remark");
                return (Criteria) this;
            }

            public Criteria andRemarkLessThan(String value) {
                addCriterion("remark <", value, "remark");
                return (Criteria) this;
            }

            public Criteria andRemarkLessThanOrEqualTo(Integer value) {
                addCriterion("remark <=", value, "remark");
                return (Criteria) this;
            }

            public Criteria andRemarkIn(List<String> values) {
                addCriterion("${column.columnname} in", values, "${column.columnname}");
                return (Criteria) this;
            }

            public Criteria andRemarkNotIn(List<String> values) {
                addCriterion("remark not in", values, "remark");
                return (Criteria) this;
            }

            public Criteria andRemarkBetween(String value1, String value2) {
                addCriterion("remark between", value1, value2, "remark");
                return (Criteria) this;
            }

            public Criteria andRemarkNotBetween(String value1, String value2) {
                addCriterion("remark not between", value1, value2, "remark");
                return (Criteria) this;
            }
                    public Criteria andDataIsNull() {
                addCriterion("data is null");
                return (Criteria) this;
            }

            public Criteria andDataIsNotNull() {
                addCriterion("data is not null");
                return (Criteria) this;
            }

            public Criteria andDataEqualTo(Integer value) {
                addCriterion("data =", value, "data");
                return (Criteria) this;
            }

            public Criteria andDataNotEqualTo(Integer value) {
                addCriterion("'data <>", value, "data");
                return (Criteria) this;
            }

            public Criteria andDataGreaterThan(Integer value) {
                addCriterion("data >", value, "data");
                return (Criteria) this;
            }

            public Criteria andDataGreaterThanOrEqualTo(Integer value) {
                addCriterion("data >=", value, "data");
                return (Criteria) this;
            }

            public Criteria andDataLessThan(Integer value) {
                addCriterion("data <", value, "data");
                return (Criteria) this;
            }

            public Criteria andDataLessThanOrEqualTo(Integer value) {
                addCriterion("data <=", value, "data");
                return (Criteria) this;
            }

            public Criteria andDataIn(List<Integer> values) {
                addCriterion("${column.columnname} in", values, "${column.columnname}");
                return (Criteria) this;
            }

            public Criteria andDataNotIn(List<Integer> values) {
                addCriterion("data not in", values, "data");
                return (Criteria) this;
            }

            public Criteria andDataBetween(Integer value1, Integer value2) {
                addCriterion("data between", value1, value2, "data");
                return (Criteria) this;
            }

            public Criteria andDataNotBetween(Integer value1, Integer value2) {
                addCriterion("data not between", value1, value2, "data");
                return (Criteria) this;
            }
                    public Criteria andProbabilityIsNull() {
                addCriterion("probability is null");
                return (Criteria) this;
            }

            public Criteria andProbabilityIsNotNull() {
                addCriterion("probability is not null");
                return (Criteria) this;
            }

            public Criteria andProbabilityEqualTo(Double value) {
                addCriterion("probability =", value, "probability");
                return (Criteria) this;
            }

            public Criteria andProbabilityNotEqualTo(Double value) {
                addCriterion("'probability <>", value, "probability");
                return (Criteria) this;
            }

            public Criteria andProbabilityGreaterThan(Double value) {
                addCriterion("probability >", value, "probability");
                return (Criteria) this;
            }

            public Criteria andProbabilityGreaterThanOrEqualTo(Double value) {
                addCriterion("probability >=", value, "probability");
                return (Criteria) this;
            }

            public Criteria andProbabilityLessThan(Double value) {
                addCriterion("probability <", value, "probability");
                return (Criteria) this;
            }

            public Criteria andProbabilityLessThanOrEqualTo(Integer value) {
                addCriterion("probability <=", value, "probability");
                return (Criteria) this;
            }

            public Criteria andProbabilityIn(List<Double> values) {
                addCriterion("${column.columnname} in", values, "${column.columnname}");
                return (Criteria) this;
            }

            public Criteria andProbabilityNotIn(List<Double> values) {
                addCriterion("probability not in", values, "probability");
                return (Criteria) this;
            }

            public Criteria andProbabilityBetween(Double value1, Double value2) {
                addCriterion("probability between", value1, value2, "probability");
                return (Criteria) this;
            }

            public Criteria andProbabilityNotBetween(Double value1, Double value2) {
                addCriterion("probability not between", value1, value2, "probability");
                return (Criteria) this;
            }
                    public Criteria andCodeIsNull() {
                addCriterion("code is null");
                return (Criteria) this;
            }

            public Criteria andCodeIsNotNull() {
                addCriterion("code is not null");
                return (Criteria) this;
            }

            public Criteria andCodeEqualTo(String value) {
                addCriterion("code =", value, "code");
                return (Criteria) this;
            }

            public Criteria andCodeNotEqualTo(String value) {
                addCriterion("'code <>", value, "code");
                return (Criteria) this;
            }

            public Criteria andCodeGreaterThan(String value) {
                addCriterion("code >", value, "code");
                return (Criteria) this;
            }

            public Criteria andCodeGreaterThanOrEqualTo(String value) {
                addCriterion("code >=", value, "code");
                return (Criteria) this;
            }

            public Criteria andCodeLessThan(String value) {
                addCriterion("code <", value, "code");
                return (Criteria) this;
            }

            public Criteria andCodeLessThanOrEqualTo(Integer value) {
                addCriterion("code <=", value, "code");
                return (Criteria) this;
            }

            public Criteria andCodeIn(List<String> values) {
                addCriterion("${column.columnname} in", values, "${column.columnname}");
                return (Criteria) this;
            }

            public Criteria andCodeNotIn(List<String> values) {
                addCriterion("code not in", values, "code");
                return (Criteria) this;
            }

            public Criteria andCodeBetween(String value1, String value2) {
                addCriterion("code between", value1, value2, "code");
                return (Criteria) this;
            }

            public Criteria andCodeNotBetween(String value1, String value2) {
                addCriterion("code not between", value1, value2, "code");
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
                addCriterion("${column.columnname} in", values, "${column.columnname}");
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
                addCriterion("${column.columnname} in", values, "${column.columnname}");
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
                addCriterion("${column.columnname} in", values, "${column.columnname}");
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