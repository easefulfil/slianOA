package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.List;

public class OaAttendanceEmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaAttendanceEmployeeExample() {
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

    public void setPageIndex(int pageIndex) {
        this.pageIndex=pageIndex;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize=pageSize;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getSkipRecordCount() {
        return (this.pageIndex-1)*this.pageSize;
    }

    public int getEndRecordCount() {
        return this.pageIndex*this.pageSize;
    }

    public OaAttendanceEmployeeExample(int pageSize, int pageIndex) {
        this();
        this.pageSize=pageSize;
        this.pageIndex=pageIndex;
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

        public Criteria andAttendanceEmployeeIdIsNull() {
            addCriterion("attendance_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceEmployeeIdIsNotNull() {
            addCriterion("attendance_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceEmployeeIdEqualTo(Integer value) {
            addCriterion("attendance_employee_id =", value, "attendanceEmployeeId");
            return (Criteria) this;
        }

        public Criteria andAttendanceEmployeeIdNotEqualTo(Integer value) {
            addCriterion("attendance_employee_id <>", value, "attendanceEmployeeId");
            return (Criteria) this;
        }

        public Criteria andAttendanceEmployeeIdGreaterThan(Integer value) {
            addCriterion("attendance_employee_id >", value, "attendanceEmployeeId");
            return (Criteria) this;
        }

        public Criteria andAttendanceEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attendance_employee_id >=", value, "attendanceEmployeeId");
            return (Criteria) this;
        }

        public Criteria andAttendanceEmployeeIdLessThan(Integer value) {
            addCriterion("attendance_employee_id <", value, "attendanceEmployeeId");
            return (Criteria) this;
        }

        public Criteria andAttendanceEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("attendance_employee_id <=", value, "attendanceEmployeeId");
            return (Criteria) this;
        }

        public Criteria andAttendanceEmployeeIdIn(List<Integer> values) {
            addCriterion("attendance_employee_id in", values, "attendanceEmployeeId");
            return (Criteria) this;
        }

        public Criteria andAttendanceEmployeeIdNotIn(List<Integer> values) {
            addCriterion("attendance_employee_id not in", values, "attendanceEmployeeId");
            return (Criteria) this;
        }

        public Criteria andAttendanceEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("attendance_employee_id between", value1, value2, "attendanceEmployeeId");
            return (Criteria) this;
        }

        public Criteria andAttendanceEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attendance_employee_id not between", value1, value2, "attendanceEmployeeId");
            return (Criteria) this;
        }

        public Criteria andAttendanceRuleIdIsNull() {
            addCriterion("attendance_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceRuleIdIsNotNull() {
            addCriterion("attendance_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceRuleIdEqualTo(Integer value) {
            addCriterion("attendance_rule_id =", value, "attendanceRuleId");
            return (Criteria) this;
        }

        public Criteria andAttendanceRuleIdNotEqualTo(Integer value) {
            addCriterion("attendance_rule_id <>", value, "attendanceRuleId");
            return (Criteria) this;
        }

        public Criteria andAttendanceRuleIdGreaterThan(Integer value) {
            addCriterion("attendance_rule_id >", value, "attendanceRuleId");
            return (Criteria) this;
        }

        public Criteria andAttendanceRuleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attendance_rule_id >=", value, "attendanceRuleId");
            return (Criteria) this;
        }

        public Criteria andAttendanceRuleIdLessThan(Integer value) {
            addCriterion("attendance_rule_id <", value, "attendanceRuleId");
            return (Criteria) this;
        }

        public Criteria andAttendanceRuleIdLessThanOrEqualTo(Integer value) {
            addCriterion("attendance_rule_id <=", value, "attendanceRuleId");
            return (Criteria) this;
        }

        public Criteria andAttendanceRuleIdIn(List<Integer> values) {
            addCriterion("attendance_rule_id in", values, "attendanceRuleId");
            return (Criteria) this;
        }

        public Criteria andAttendanceRuleIdNotIn(List<Integer> values) {
            addCriterion("attendance_rule_id not in", values, "attendanceRuleId");
            return (Criteria) this;
        }

        public Criteria andAttendanceRuleIdBetween(Integer value1, Integer value2) {
            addCriterion("attendance_rule_id between", value1, value2, "attendanceRuleId");
            return (Criteria) this;
        }

        public Criteria andAttendanceRuleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attendance_rule_id not between", value1, value2, "attendanceRuleId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNull() {
            addCriterion("employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(Integer value) {
            addCriterion("employee_id =", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(Integer value) {
            addCriterion("employee_id <>", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(Integer value) {
            addCriterion("employee_id >", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_id >=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(Integer value) {
            addCriterion("employee_id <", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("employee_id <=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<Integer> values) {
            addCriterion("employee_id in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<Integer> values) {
            addCriterion("employee_id not in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("employee_id between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_id not between", value1, value2, "employeeId");
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