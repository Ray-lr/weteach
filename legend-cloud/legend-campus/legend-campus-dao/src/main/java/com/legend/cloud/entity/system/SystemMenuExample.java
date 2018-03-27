package com.legend.cloud.entity.system;

        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

/**
 * SystemMenu的example类
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:04
 */
public class SystemMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemMenuExample() {
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
                addCriterion("${column.columnname} in", values, "${column.columnname}");
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
                    public Criteria andUrlIsNull() {
                addCriterion("url is null");
                return (Criteria) this;
            }

            public Criteria andUrlIsNotNull() {
                addCriterion("url is not null");
                return (Criteria) this;
            }

            public Criteria andUrlEqualTo(String value) {
                addCriterion("url =", value, "url");
                return (Criteria) this;
            }

            public Criteria andUrlNotEqualTo(String value) {
                addCriterion("'url <>", value, "url");
                return (Criteria) this;
            }

            public Criteria andUrlGreaterThan(String value) {
                addCriterion("url >", value, "url");
                return (Criteria) this;
            }

            public Criteria andUrlGreaterThanOrEqualTo(String value) {
                addCriterion("url >=", value, "url");
                return (Criteria) this;
            }

            public Criteria andUrlLessThan(String value) {
                addCriterion("url <", value, "url");
                return (Criteria) this;
            }

            public Criteria andUrlLessThanOrEqualTo(Integer value) {
                addCriterion("url <=", value, "url");
                return (Criteria) this;
            }

            public Criteria andUrlIn(List<String> values) {
                addCriterion("${column.columnname} in", values, "${column.columnname}");
                return (Criteria) this;
            }

            public Criteria andUrlNotIn(List<String> values) {
                addCriterion("url not in", values, "url");
                return (Criteria) this;
            }

            public Criteria andUrlBetween(String value1, String value2) {
                addCriterion("url between", value1, value2, "url");
                return (Criteria) this;
            }

            public Criteria andUrlNotBetween(String value1, String value2) {
                addCriterion("url not between", value1, value2, "url");
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
                    public Criteria andLevelIsNull() {
                addCriterion("level is null");
                return (Criteria) this;
            }

            public Criteria andLevelIsNotNull() {
                addCriterion("level is not null");
                return (Criteria) this;
            }

            public Criteria andLevelEqualTo(Integer value) {
                addCriterion("level =", value, "level");
                return (Criteria) this;
            }

            public Criteria andLevelNotEqualTo(Integer value) {
                addCriterion("'level <>", value, "level");
                return (Criteria) this;
            }

            public Criteria andLevelGreaterThan(Integer value) {
                addCriterion("level >", value, "level");
                return (Criteria) this;
            }

            public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
                addCriterion("level >=", value, "level");
                return (Criteria) this;
            }

            public Criteria andLevelLessThan(Integer value) {
                addCriterion("level <", value, "level");
                return (Criteria) this;
            }

            public Criteria andLevelLessThanOrEqualTo(Integer value) {
                addCriterion("level <=", value, "level");
                return (Criteria) this;
            }

            public Criteria andLevelIn(List<Integer> values) {
                addCriterion("${column.columnname} in", values, "${column.columnname}");
                return (Criteria) this;
            }

            public Criteria andLevelNotIn(List<Integer> values) {
                addCriterion("level not in", values, "level");
                return (Criteria) this;
            }

            public Criteria andLevelBetween(Integer value1, Integer value2) {
                addCriterion("level between", value1, value2, "level");
                return (Criteria) this;
            }

            public Criteria andLevelNotBetween(Integer value1, Integer value2) {
                addCriterion("level not between", value1, value2, "level");
                return (Criteria) this;
            }
                    public Criteria andParentIdIsNull() {
                addCriterion("parent_id is null");
                return (Criteria) this;
            }

            public Criteria andParentIdIsNotNull() {
                addCriterion("parent_id is not null");
                return (Criteria) this;
            }

            public Criteria andParentIdEqualTo(Integer value) {
                addCriterion("parent_id =", value, "parent_id");
                return (Criteria) this;
            }

            public Criteria andParentIdNotEqualTo(Integer value) {
                addCriterion("'parent_id <>", value, "parent_id");
                return (Criteria) this;
            }

            public Criteria andParentIdGreaterThan(Integer value) {
                addCriterion("parent_id >", value, "parent_id");
                return (Criteria) this;
            }

            public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
                addCriterion("parent_id >=", value, "parent_id");
                return (Criteria) this;
            }

            public Criteria andParentIdLessThan(Integer value) {
                addCriterion("parent_id <", value, "parent_id");
                return (Criteria) this;
            }

            public Criteria andParentIdLessThanOrEqualTo(Integer value) {
                addCriterion("parent_id <=", value, "parent_id");
                return (Criteria) this;
            }

            public Criteria andParentIdIn(List<Integer> values) {
                addCriterion("${column.columnname} in", values, "${column.columnname}");
                return (Criteria) this;
            }

            public Criteria andParentIdNotIn(List<Integer> values) {
                addCriterion("parent_id not in", values, "parent_id");
                return (Criteria) this;
            }

            public Criteria andParentIdBetween(Integer value1, Integer value2) {
                addCriterion("parent_id between", value1, value2, "parent_id");
                return (Criteria) this;
            }

            public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
                addCriterion("parent_id not between", value1, value2, "parent_id");
                return (Criteria) this;
            }
                    public Criteria andSortIsNull() {
                addCriterion("sort is null");
                return (Criteria) this;
            }

            public Criteria andSortIsNotNull() {
                addCriterion("sort is not null");
                return (Criteria) this;
            }

            public Criteria andSortEqualTo(Integer value) {
                addCriterion("sort =", value, "sort");
                return (Criteria) this;
            }

            public Criteria andSortNotEqualTo(Integer value) {
                addCriterion("'sort <>", value, "sort");
                return (Criteria) this;
            }

            public Criteria andSortGreaterThan(Integer value) {
                addCriterion("sort >", value, "sort");
                return (Criteria) this;
            }

            public Criteria andSortGreaterThanOrEqualTo(Integer value) {
                addCriterion("sort >=", value, "sort");
                return (Criteria) this;
            }

            public Criteria andSortLessThan(Integer value) {
                addCriterion("sort <", value, "sort");
                return (Criteria) this;
            }

            public Criteria andSortLessThanOrEqualTo(Integer value) {
                addCriterion("sort <=", value, "sort");
                return (Criteria) this;
            }

            public Criteria andSortIn(List<Integer> values) {
                addCriterion("${column.columnname} in", values, "${column.columnname}");
                return (Criteria) this;
            }

            public Criteria andSortNotIn(List<Integer> values) {
                addCriterion("sort not in", values, "sort");
                return (Criteria) this;
            }

            public Criteria andSortBetween(Integer value1, Integer value2) {
                addCriterion("sort between", value1, value2, "sort");
                return (Criteria) this;
            }

            public Criteria andSortNotBetween(Integer value1, Integer value2) {
                addCriterion("sort not between", value1, value2, "sort");
                return (Criteria) this;
            }
                    public Criteria andClassNameIsNull() {
                addCriterion("class_name is null");
                return (Criteria) this;
            }

            public Criteria andClassNameIsNotNull() {
                addCriterion("class_name is not null");
                return (Criteria) this;
            }

            public Criteria andClassNameEqualTo(String value) {
                addCriterion("class_name =", value, "class_name");
                return (Criteria) this;
            }

            public Criteria andClassNameNotEqualTo(String value) {
                addCriterion("'class_name <>", value, "class_name");
                return (Criteria) this;
            }

            public Criteria andClassNameGreaterThan(String value) {
                addCriterion("class_name >", value, "class_name");
                return (Criteria) this;
            }

            public Criteria andClassNameGreaterThanOrEqualTo(String value) {
                addCriterion("class_name >=", value, "class_name");
                return (Criteria) this;
            }

            public Criteria andClassNameLessThan(String value) {
                addCriterion("class_name <", value, "class_name");
                return (Criteria) this;
            }

            public Criteria andClassNameLessThanOrEqualTo(Integer value) {
                addCriterion("class_name <=", value, "class_name");
                return (Criteria) this;
            }

            public Criteria andClassNameIn(List<String> values) {
                addCriterion("${column.columnname} in", values, "${column.columnname}");
                return (Criteria) this;
            }

            public Criteria andClassNameNotIn(List<String> values) {
                addCriterion("class_name not in", values, "class_name");
                return (Criteria) this;
            }

            public Criteria andClassNameBetween(String value1, String value2) {
                addCriterion("class_name between", value1, value2, "class_name");
                return (Criteria) this;
            }

            public Criteria andClassNameNotBetween(String value1, String value2) {
                addCriterion("class_name not between", value1, value2, "class_name");
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