package com.sliansoft.slianOA.dataaccess.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaProjectEncourageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaProjectEncourageExample() {
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

    public OaProjectEncourageExample(int pageSize, int pageIndex) {
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

        public Criteria andProjectEncourageIdIsNull() {
            addCriterion("project_encourage_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageIdIsNotNull() {
            addCriterion("project_encourage_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageIdEqualTo(Integer value) {
            addCriterion("project_encourage_id =", value, "projectEncourageId");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageIdNotEqualTo(Integer value) {
            addCriterion("project_encourage_id <>", value, "projectEncourageId");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageIdGreaterThan(Integer value) {
            addCriterion("project_encourage_id >", value, "projectEncourageId");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_encourage_id >=", value, "projectEncourageId");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageIdLessThan(Integer value) {
            addCriterion("project_encourage_id <", value, "projectEncourageId");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_encourage_id <=", value, "projectEncourageId");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageIdIn(List<Integer> values) {
            addCriterion("project_encourage_id in", values, "projectEncourageId");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageIdNotIn(List<Integer> values) {
            addCriterion("project_encourage_id not in", values, "projectEncourageId");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageIdBetween(Integer value1, Integer value2) {
            addCriterion("project_encourage_id between", value1, value2, "projectEncourageId");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_encourage_id not between", value1, value2, "projectEncourageId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNull() {
            addCriterion("project_code is null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNotNull() {
            addCriterion("project_code is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeEqualTo(String value) {
            addCriterion("project_code =", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotEqualTo(String value) {
            addCriterion("project_code <>", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThan(String value) {
            addCriterion("project_code >", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_code >=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThan(String value) {
            addCriterion("project_code <", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThanOrEqualTo(String value) {
            addCriterion("project_code <=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLike(String value) {
            addCriterion("project_code like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotLike(String value) {
            addCriterion("project_code not like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIn(List<String> values) {
            addCriterion("project_code in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotIn(List<String> values) {
            addCriterion("project_code not in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeBetween(String value1, String value2) {
            addCriterion("project_code between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotBetween(String value1, String value2) {
            addCriterion("project_code not between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectTitleIsNull() {
            addCriterion("project_title is null");
            return (Criteria) this;
        }

        public Criteria andProjectTitleIsNotNull() {
            addCriterion("project_title is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTitleEqualTo(String value) {
            addCriterion("project_title =", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleNotEqualTo(String value) {
            addCriterion("project_title <>", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleGreaterThan(String value) {
            addCriterion("project_title >", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleGreaterThanOrEqualTo(String value) {
            addCriterion("project_title >=", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleLessThan(String value) {
            addCriterion("project_title <", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleLessThanOrEqualTo(String value) {
            addCriterion("project_title <=", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleLike(String value) {
            addCriterion("project_title like", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleNotLike(String value) {
            addCriterion("project_title not like", value, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleIn(List<String> values) {
            addCriterion("project_title in", values, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleNotIn(List<String> values) {
            addCriterion("project_title not in", values, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleBetween(String value1, String value2) {
            addCriterion("project_title between", value1, value2, "projectTitle");
            return (Criteria) this;
        }

        public Criteria andProjectTitleNotBetween(String value1, String value2) {
            addCriterion("project_title not between", value1, value2, "projectTitle");
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

        public Criteria andEmployeeNameIsNull() {
            addCriterion("employee_name is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNotNull() {
            addCriterion("employee_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameEqualTo(String value) {
            addCriterion("employee_name =", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotEqualTo(String value) {
            addCriterion("employee_name <>", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThan(String value) {
            addCriterion("employee_name >", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("employee_name >=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThan(String value) {
            addCriterion("employee_name <", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThanOrEqualTo(String value) {
            addCriterion("employee_name <=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLike(String value) {
            addCriterion("employee_name like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotLike(String value) {
            addCriterion("employee_name not like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIn(List<String> values) {
            addCriterion("employee_name in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotIn(List<String> values) {
            addCriterion("employee_name not in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameBetween(String value1, String value2) {
            addCriterion("employee_name between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotBetween(String value1, String value2) {
            addCriterion("employee_name not between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleIsNull() {
            addCriterion("employee_role is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleIsNotNull() {
            addCriterion("employee_role is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleEqualTo(String value) {
            addCriterion("employee_role =", value, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleNotEqualTo(String value) {
            addCriterion("employee_role <>", value, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleGreaterThan(String value) {
            addCriterion("employee_role >", value, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleGreaterThanOrEqualTo(String value) {
            addCriterion("employee_role >=", value, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleLessThan(String value) {
            addCriterion("employee_role <", value, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleLessThanOrEqualTo(String value) {
            addCriterion("employee_role <=", value, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleLike(String value) {
            addCriterion("employee_role like", value, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleNotLike(String value) {
            addCriterion("employee_role not like", value, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleIn(List<String> values) {
            addCriterion("employee_role in", values, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleNotIn(List<String> values) {
            addCriterion("employee_role not in", values, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleBetween(String value1, String value2) {
            addCriterion("employee_role between", value1, value2, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeRoleNotBetween(String value1, String value2) {
            addCriterion("employee_role not between", value1, value2, "employeeRole");
            return (Criteria) this;
        }

        public Criteria andEmployeeBeginDateIsNull() {
            addCriterion("employee_begin_date is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeBeginDateIsNotNull() {
            addCriterion("employee_begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeBeginDateEqualTo(Date value) {
            addCriterion("employee_begin_date =", value, "employeeBeginDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeBeginDateNotEqualTo(Date value) {
            addCriterion("employee_begin_date <>", value, "employeeBeginDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeBeginDateGreaterThan(Date value) {
            addCriterion("employee_begin_date >", value, "employeeBeginDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("employee_begin_date >=", value, "employeeBeginDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeBeginDateLessThan(Date value) {
            addCriterion("employee_begin_date <", value, "employeeBeginDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeBeginDateLessThanOrEqualTo(Date value) {
            addCriterion("employee_begin_date <=", value, "employeeBeginDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeBeginDateIn(List<Date> values) {
            addCriterion("employee_begin_date in", values, "employeeBeginDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeBeginDateNotIn(List<Date> values) {
            addCriterion("employee_begin_date not in", values, "employeeBeginDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeBeginDateBetween(Date value1, Date value2) {
            addCriterion("employee_begin_date between", value1, value2, "employeeBeginDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeBeginDateNotBetween(Date value1, Date value2) {
            addCriterion("employee_begin_date not between", value1, value2, "employeeBeginDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeEndDateIsNull() {
            addCriterion("employee_end_date is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeEndDateIsNotNull() {
            addCriterion("employee_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeEndDateEqualTo(Date value) {
            addCriterion("employee_end_date =", value, "employeeEndDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeEndDateNotEqualTo(Date value) {
            addCriterion("employee_end_date <>", value, "employeeEndDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeEndDateGreaterThan(Date value) {
            addCriterion("employee_end_date >", value, "employeeEndDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("employee_end_date >=", value, "employeeEndDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeEndDateLessThan(Date value) {
            addCriterion("employee_end_date <", value, "employeeEndDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeEndDateLessThanOrEqualTo(Date value) {
            addCriterion("employee_end_date <=", value, "employeeEndDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeEndDateIn(List<Date> values) {
            addCriterion("employee_end_date in", values, "employeeEndDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeEndDateNotIn(List<Date> values) {
            addCriterion("employee_end_date not in", values, "employeeEndDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeEndDateBetween(Date value1, Date value2) {
            addCriterion("employee_end_date between", value1, value2, "employeeEndDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeEndDateNotBetween(Date value1, Date value2) {
            addCriterion("employee_end_date not between", value1, value2, "employeeEndDate");
            return (Criteria) this;
        }

        public Criteria andEmployeePeriodIsNull() {
            addCriterion("employee_period is null");
            return (Criteria) this;
        }

        public Criteria andEmployeePeriodIsNotNull() {
            addCriterion("employee_period is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeePeriodEqualTo(Integer value) {
            addCriterion("employee_period =", value, "employeePeriod");
            return (Criteria) this;
        }

        public Criteria andEmployeePeriodNotEqualTo(Integer value) {
            addCriterion("employee_period <>", value, "employeePeriod");
            return (Criteria) this;
        }

        public Criteria andEmployeePeriodGreaterThan(Integer value) {
            addCriterion("employee_period >", value, "employeePeriod");
            return (Criteria) this;
        }

        public Criteria andEmployeePeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_period >=", value, "employeePeriod");
            return (Criteria) this;
        }

        public Criteria andEmployeePeriodLessThan(Integer value) {
            addCriterion("employee_period <", value, "employeePeriod");
            return (Criteria) this;
        }

        public Criteria andEmployeePeriodLessThanOrEqualTo(Integer value) {
            addCriterion("employee_period <=", value, "employeePeriod");
            return (Criteria) this;
        }

        public Criteria andEmployeePeriodIn(List<Integer> values) {
            addCriterion("employee_period in", values, "employeePeriod");
            return (Criteria) this;
        }

        public Criteria andEmployeePeriodNotIn(List<Integer> values) {
            addCriterion("employee_period not in", values, "employeePeriod");
            return (Criteria) this;
        }

        public Criteria andEmployeePeriodBetween(Integer value1, Integer value2) {
            addCriterion("employee_period between", value1, value2, "employeePeriod");
            return (Criteria) this;
        }

        public Criteria andEmployeePeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_period not between", value1, value2, "employeePeriod");
            return (Criteria) this;
        }

        public Criteria andProjectContractMoneyIsNull() {
            addCriterion("project_contract_money is null");
            return (Criteria) this;
        }

        public Criteria andProjectContractMoneyIsNotNull() {
            addCriterion("project_contract_money is not null");
            return (Criteria) this;
        }

        public Criteria andProjectContractMoneyEqualTo(BigDecimal value) {
            addCriterion("project_contract_money =", value, "projectContractMoney");
            return (Criteria) this;
        }

        public Criteria andProjectContractMoneyNotEqualTo(BigDecimal value) {
            addCriterion("project_contract_money <>", value, "projectContractMoney");
            return (Criteria) this;
        }

        public Criteria andProjectContractMoneyGreaterThan(BigDecimal value) {
            addCriterion("project_contract_money >", value, "projectContractMoney");
            return (Criteria) this;
        }

        public Criteria andProjectContractMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_contract_money >=", value, "projectContractMoney");
            return (Criteria) this;
        }

        public Criteria andProjectContractMoneyLessThan(BigDecimal value) {
            addCriterion("project_contract_money <", value, "projectContractMoney");
            return (Criteria) this;
        }

        public Criteria andProjectContractMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_contract_money <=", value, "projectContractMoney");
            return (Criteria) this;
        }

        public Criteria andProjectContractMoneyIn(List<BigDecimal> values) {
            addCriterion("project_contract_money in", values, "projectContractMoney");
            return (Criteria) this;
        }

        public Criteria andProjectContractMoneyNotIn(List<BigDecimal> values) {
            addCriterion("project_contract_money not in", values, "projectContractMoney");
            return (Criteria) this;
        }

        public Criteria andProjectContractMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_contract_money between", value1, value2, "projectContractMoney");
            return (Criteria) this;
        }

        public Criteria andProjectContractMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_contract_money not between", value1, value2, "projectContractMoney");
            return (Criteria) this;
        }

        public Criteria andProjectCorporateMoneyIsNull() {
            addCriterion("project_corporate_money is null");
            return (Criteria) this;
        }

        public Criteria andProjectCorporateMoneyIsNotNull() {
            addCriterion("project_corporate_money is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCorporateMoneyEqualTo(BigDecimal value) {
            addCriterion("project_corporate_money =", value, "projectCorporateMoney");
            return (Criteria) this;
        }

        public Criteria andProjectCorporateMoneyNotEqualTo(BigDecimal value) {
            addCriterion("project_corporate_money <>", value, "projectCorporateMoney");
            return (Criteria) this;
        }

        public Criteria andProjectCorporateMoneyGreaterThan(BigDecimal value) {
            addCriterion("project_corporate_money >", value, "projectCorporateMoney");
            return (Criteria) this;
        }

        public Criteria andProjectCorporateMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_corporate_money >=", value, "projectCorporateMoney");
            return (Criteria) this;
        }

        public Criteria andProjectCorporateMoneyLessThan(BigDecimal value) {
            addCriterion("project_corporate_money <", value, "projectCorporateMoney");
            return (Criteria) this;
        }

        public Criteria andProjectCorporateMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_corporate_money <=", value, "projectCorporateMoney");
            return (Criteria) this;
        }

        public Criteria andProjectCorporateMoneyIn(List<BigDecimal> values) {
            addCriterion("project_corporate_money in", values, "projectCorporateMoney");
            return (Criteria) this;
        }

        public Criteria andProjectCorporateMoneyNotIn(List<BigDecimal> values) {
            addCriterion("project_corporate_money not in", values, "projectCorporateMoney");
            return (Criteria) this;
        }

        public Criteria andProjectCorporateMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_corporate_money between", value1, value2, "projectCorporateMoney");
            return (Criteria) this;
        }

        public Criteria andProjectCorporateMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_corporate_money not between", value1, value2, "projectCorporateMoney");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageIsNull() {
            addCriterion("project_encourage is null");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageIsNotNull() {
            addCriterion("project_encourage is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageEqualTo(BigDecimal value) {
            addCriterion("project_encourage =", value, "projectEncourage");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageNotEqualTo(BigDecimal value) {
            addCriterion("project_encourage <>", value, "projectEncourage");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageGreaterThan(BigDecimal value) {
            addCriterion("project_encourage >", value, "projectEncourage");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_encourage >=", value, "projectEncourage");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageLessThan(BigDecimal value) {
            addCriterion("project_encourage <", value, "projectEncourage");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_encourage <=", value, "projectEncourage");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageIn(List<BigDecimal> values) {
            addCriterion("project_encourage in", values, "projectEncourage");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageNotIn(List<BigDecimal> values) {
            addCriterion("project_encourage not in", values, "projectEncourage");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_encourage between", value1, value2, "projectEncourage");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_encourage not between", value1, value2, "projectEncourage");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageLeaderIsNull() {
            addCriterion("project_encourage_leader is null");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageLeaderIsNotNull() {
            addCriterion("project_encourage_leader is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageLeaderEqualTo(BigDecimal value) {
            addCriterion("project_encourage_leader =", value, "projectEncourageLeader");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageLeaderNotEqualTo(BigDecimal value) {
            addCriterion("project_encourage_leader <>", value, "projectEncourageLeader");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageLeaderGreaterThan(BigDecimal value) {
            addCriterion("project_encourage_leader >", value, "projectEncourageLeader");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageLeaderGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_encourage_leader >=", value, "projectEncourageLeader");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageLeaderLessThan(BigDecimal value) {
            addCriterion("project_encourage_leader <", value, "projectEncourageLeader");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageLeaderLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_encourage_leader <=", value, "projectEncourageLeader");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageLeaderIn(List<BigDecimal> values) {
            addCriterion("project_encourage_leader in", values, "projectEncourageLeader");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageLeaderNotIn(List<BigDecimal> values) {
            addCriterion("project_encourage_leader not in", values, "projectEncourageLeader");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageLeaderBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_encourage_leader between", value1, value2, "projectEncourageLeader");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageLeaderNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_encourage_leader not between", value1, value2, "projectEncourageLeader");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageTeamIsNull() {
            addCriterion("project_encourage_team is null");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageTeamIsNotNull() {
            addCriterion("project_encourage_team is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageTeamEqualTo(BigDecimal value) {
            addCriterion("project_encourage_team =", value, "projectEncourageTeam");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageTeamNotEqualTo(BigDecimal value) {
            addCriterion("project_encourage_team <>", value, "projectEncourageTeam");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageTeamGreaterThan(BigDecimal value) {
            addCriterion("project_encourage_team >", value, "projectEncourageTeam");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageTeamGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_encourage_team >=", value, "projectEncourageTeam");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageTeamLessThan(BigDecimal value) {
            addCriterion("project_encourage_team <", value, "projectEncourageTeam");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageTeamLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_encourage_team <=", value, "projectEncourageTeam");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageTeamIn(List<BigDecimal> values) {
            addCriterion("project_encourage_team in", values, "projectEncourageTeam");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageTeamNotIn(List<BigDecimal> values) {
            addCriterion("project_encourage_team not in", values, "projectEncourageTeam");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageTeamBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_encourage_team between", value1, value2, "projectEncourageTeam");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageTeamNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_encourage_team not between", value1, value2, "projectEncourageTeam");
            return (Criteria) this;
        }

        public Criteria andFundingDateIsNull() {
            addCriterion("funding_date is null");
            return (Criteria) this;
        }

        public Criteria andFundingDateIsNotNull() {
            addCriterion("funding_date is not null");
            return (Criteria) this;
        }

        public Criteria andFundingDateEqualTo(Date value) {
            addCriterion("funding_date =", value, "fundingDate");
            return (Criteria) this;
        }

        public Criteria andFundingDateNotEqualTo(Date value) {
            addCriterion("funding_date <>", value, "fundingDate");
            return (Criteria) this;
        }

        public Criteria andFundingDateGreaterThan(Date value) {
            addCriterion("funding_date >", value, "fundingDate");
            return (Criteria) this;
        }

        public Criteria andFundingDateGreaterThanOrEqualTo(Date value) {
            addCriterion("funding_date >=", value, "fundingDate");
            return (Criteria) this;
        }

        public Criteria andFundingDateLessThan(Date value) {
            addCriterion("funding_date <", value, "fundingDate");
            return (Criteria) this;
        }

        public Criteria andFundingDateLessThanOrEqualTo(Date value) {
            addCriterion("funding_date <=", value, "fundingDate");
            return (Criteria) this;
        }

        public Criteria andFundingDateIn(List<Date> values) {
            addCriterion("funding_date in", values, "fundingDate");
            return (Criteria) this;
        }

        public Criteria andFundingDateNotIn(List<Date> values) {
            addCriterion("funding_date not in", values, "fundingDate");
            return (Criteria) this;
        }

        public Criteria andFundingDateBetween(Date value1, Date value2) {
            addCriterion("funding_date between", value1, value2, "fundingDate");
            return (Criteria) this;
        }

        public Criteria andFundingDateNotBetween(Date value1, Date value2) {
            addCriterion("funding_date not between", value1, value2, "fundingDate");
            return (Criteria) this;
        }

        public Criteria andFundingUsageIsNull() {
            addCriterion("funding_usage is null");
            return (Criteria) this;
        }

        public Criteria andFundingUsageIsNotNull() {
            addCriterion("funding_usage is not null");
            return (Criteria) this;
        }

        public Criteria andFundingUsageEqualTo(String value) {
            addCriterion("funding_usage =", value, "fundingUsage");
            return (Criteria) this;
        }

        public Criteria andFundingUsageNotEqualTo(String value) {
            addCriterion("funding_usage <>", value, "fundingUsage");
            return (Criteria) this;
        }

        public Criteria andFundingUsageGreaterThan(String value) {
            addCriterion("funding_usage >", value, "fundingUsage");
            return (Criteria) this;
        }

        public Criteria andFundingUsageGreaterThanOrEqualTo(String value) {
            addCriterion("funding_usage >=", value, "fundingUsage");
            return (Criteria) this;
        }

        public Criteria andFundingUsageLessThan(String value) {
            addCriterion("funding_usage <", value, "fundingUsage");
            return (Criteria) this;
        }

        public Criteria andFundingUsageLessThanOrEqualTo(String value) {
            addCriterion("funding_usage <=", value, "fundingUsage");
            return (Criteria) this;
        }

        public Criteria andFundingUsageLike(String value) {
            addCriterion("funding_usage like", value, "fundingUsage");
            return (Criteria) this;
        }

        public Criteria andFundingUsageNotLike(String value) {
            addCriterion("funding_usage not like", value, "fundingUsage");
            return (Criteria) this;
        }

        public Criteria andFundingUsageIn(List<String> values) {
            addCriterion("funding_usage in", values, "fundingUsage");
            return (Criteria) this;
        }

        public Criteria andFundingUsageNotIn(List<String> values) {
            addCriterion("funding_usage not in", values, "fundingUsage");
            return (Criteria) this;
        }

        public Criteria andFundingUsageBetween(String value1, String value2) {
            addCriterion("funding_usage between", value1, value2, "fundingUsage");
            return (Criteria) this;
        }

        public Criteria andFundingUsageNotBetween(String value1, String value2) {
            addCriterion("funding_usage not between", value1, value2, "fundingUsage");
            return (Criteria) this;
        }

        public Criteria andFundingCostIsNull() {
            addCriterion("funding_cost is null");
            return (Criteria) this;
        }

        public Criteria andFundingCostIsNotNull() {
            addCriterion("funding_cost is not null");
            return (Criteria) this;
        }

        public Criteria andFundingCostEqualTo(BigDecimal value) {
            addCriterion("funding_cost =", value, "fundingCost");
            return (Criteria) this;
        }

        public Criteria andFundingCostNotEqualTo(BigDecimal value) {
            addCriterion("funding_cost <>", value, "fundingCost");
            return (Criteria) this;
        }

        public Criteria andFundingCostGreaterThan(BigDecimal value) {
            addCriterion("funding_cost >", value, "fundingCost");
            return (Criteria) this;
        }

        public Criteria andFundingCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("funding_cost >=", value, "fundingCost");
            return (Criteria) this;
        }

        public Criteria andFundingCostLessThan(BigDecimal value) {
            addCriterion("funding_cost <", value, "fundingCost");
            return (Criteria) this;
        }

        public Criteria andFundingCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("funding_cost <=", value, "fundingCost");
            return (Criteria) this;
        }

        public Criteria andFundingCostIn(List<BigDecimal> values) {
            addCriterion("funding_cost in", values, "fundingCost");
            return (Criteria) this;
        }

        public Criteria andFundingCostNotIn(List<BigDecimal> values) {
            addCriterion("funding_cost not in", values, "fundingCost");
            return (Criteria) this;
        }

        public Criteria andFundingCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("funding_cost between", value1, value2, "fundingCost");
            return (Criteria) this;
        }

        public Criteria andFundingCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("funding_cost not between", value1, value2, "fundingCost");
            return (Criteria) this;
        }

        public Criteria andFundingLeftIsNull() {
            addCriterion("funding_left is null");
            return (Criteria) this;
        }

        public Criteria andFundingLeftIsNotNull() {
            addCriterion("funding_left is not null");
            return (Criteria) this;
        }

        public Criteria andFundingLeftEqualTo(BigDecimal value) {
            addCriterion("funding_left =", value, "fundingLeft");
            return (Criteria) this;
        }

        public Criteria andFundingLeftNotEqualTo(BigDecimal value) {
            addCriterion("funding_left <>", value, "fundingLeft");
            return (Criteria) this;
        }

        public Criteria andFundingLeftGreaterThan(BigDecimal value) {
            addCriterion("funding_left >", value, "fundingLeft");
            return (Criteria) this;
        }

        public Criteria andFundingLeftGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("funding_left >=", value, "fundingLeft");
            return (Criteria) this;
        }

        public Criteria andFundingLeftLessThan(BigDecimal value) {
            addCriterion("funding_left <", value, "fundingLeft");
            return (Criteria) this;
        }

        public Criteria andFundingLeftLessThanOrEqualTo(BigDecimal value) {
            addCriterion("funding_left <=", value, "fundingLeft");
            return (Criteria) this;
        }

        public Criteria andFundingLeftIn(List<BigDecimal> values) {
            addCriterion("funding_left in", values, "fundingLeft");
            return (Criteria) this;
        }

        public Criteria andFundingLeftNotIn(List<BigDecimal> values) {
            addCriterion("funding_left not in", values, "fundingLeft");
            return (Criteria) this;
        }

        public Criteria andFundingLeftBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("funding_left between", value1, value2, "fundingLeft");
            return (Criteria) this;
        }

        public Criteria andFundingLeftNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("funding_left not between", value1, value2, "fundingLeft");
            return (Criteria) this;
        }

        public Criteria andFundingRemarksIsNull() {
            addCriterion("funding_remarks is null");
            return (Criteria) this;
        }

        public Criteria andFundingRemarksIsNotNull() {
            addCriterion("funding_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andFundingRemarksEqualTo(String value) {
            addCriterion("funding_remarks =", value, "fundingRemarks");
            return (Criteria) this;
        }

        public Criteria andFundingRemarksNotEqualTo(String value) {
            addCriterion("funding_remarks <>", value, "fundingRemarks");
            return (Criteria) this;
        }

        public Criteria andFundingRemarksGreaterThan(String value) {
            addCriterion("funding_remarks >", value, "fundingRemarks");
            return (Criteria) this;
        }

        public Criteria andFundingRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("funding_remarks >=", value, "fundingRemarks");
            return (Criteria) this;
        }

        public Criteria andFundingRemarksLessThan(String value) {
            addCriterion("funding_remarks <", value, "fundingRemarks");
            return (Criteria) this;
        }

        public Criteria andFundingRemarksLessThanOrEqualTo(String value) {
            addCriterion("funding_remarks <=", value, "fundingRemarks");
            return (Criteria) this;
        }

        public Criteria andFundingRemarksLike(String value) {
            addCriterion("funding_remarks like", value, "fundingRemarks");
            return (Criteria) this;
        }

        public Criteria andFundingRemarksNotLike(String value) {
            addCriterion("funding_remarks not like", value, "fundingRemarks");
            return (Criteria) this;
        }

        public Criteria andFundingRemarksIn(List<String> values) {
            addCriterion("funding_remarks in", values, "fundingRemarks");
            return (Criteria) this;
        }

        public Criteria andFundingRemarksNotIn(List<String> values) {
            addCriterion("funding_remarks not in", values, "fundingRemarks");
            return (Criteria) this;
        }

        public Criteria andFundingRemarksBetween(String value1, String value2) {
            addCriterion("funding_remarks between", value1, value2, "fundingRemarks");
            return (Criteria) this;
        }

        public Criteria andFundingRemarksNotBetween(String value1, String value2) {
            addCriterion("funding_remarks not between", value1, value2, "fundingRemarks");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageSumIsNull() {
            addCriterion("project_encourage_sum is null");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageSumIsNotNull() {
            addCriterion("project_encourage_sum is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageSumEqualTo(BigDecimal value) {
            addCriterion("project_encourage_sum =", value, "projectEncourageSum");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageSumNotEqualTo(BigDecimal value) {
            addCriterion("project_encourage_sum <>", value, "projectEncourageSum");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageSumGreaterThan(BigDecimal value) {
            addCriterion("project_encourage_sum >", value, "projectEncourageSum");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_encourage_sum >=", value, "projectEncourageSum");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageSumLessThan(BigDecimal value) {
            addCriterion("project_encourage_sum <", value, "projectEncourageSum");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_encourage_sum <=", value, "projectEncourageSum");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageSumIn(List<BigDecimal> values) {
            addCriterion("project_encourage_sum in", values, "projectEncourageSum");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageSumNotIn(List<BigDecimal> values) {
            addCriterion("project_encourage_sum not in", values, "projectEncourageSum");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_encourage_sum between", value1, value2, "projectEncourageSum");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_encourage_sum not between", value1, value2, "projectEncourageSum");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceRateIsNull() {
            addCriterion("employee_performance_rate is null");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceRateIsNotNull() {
            addCriterion("employee_performance_rate is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceRateEqualTo(BigDecimal value) {
            addCriterion("employee_performance_rate =", value, "employeePerformanceRate");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceRateNotEqualTo(BigDecimal value) {
            addCriterion("employee_performance_rate <>", value, "employeePerformanceRate");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceRateGreaterThan(BigDecimal value) {
            addCriterion("employee_performance_rate >", value, "employeePerformanceRate");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("employee_performance_rate >=", value, "employeePerformanceRate");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceRateLessThan(BigDecimal value) {
            addCriterion("employee_performance_rate <", value, "employeePerformanceRate");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("employee_performance_rate <=", value, "employeePerformanceRate");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceRateIn(List<BigDecimal> values) {
            addCriterion("employee_performance_rate in", values, "employeePerformanceRate");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceRateNotIn(List<BigDecimal> values) {
            addCriterion("employee_performance_rate not in", values, "employeePerformanceRate");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("employee_performance_rate between", value1, value2, "employeePerformanceRate");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("employee_performance_rate not between", value1, value2, "employeePerformanceRate");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceMoneyIsNull() {
            addCriterion("employee_performance_money is null");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceMoneyIsNotNull() {
            addCriterion("employee_performance_money is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceMoneyEqualTo(BigDecimal value) {
            addCriterion("employee_performance_money =", value, "employeePerformanceMoney");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceMoneyNotEqualTo(BigDecimal value) {
            addCriterion("employee_performance_money <>", value, "employeePerformanceMoney");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceMoneyGreaterThan(BigDecimal value) {
            addCriterion("employee_performance_money >", value, "employeePerformanceMoney");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("employee_performance_money >=", value, "employeePerformanceMoney");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceMoneyLessThan(BigDecimal value) {
            addCriterion("employee_performance_money <", value, "employeePerformanceMoney");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("employee_performance_money <=", value, "employeePerformanceMoney");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceMoneyIn(List<BigDecimal> values) {
            addCriterion("employee_performance_money in", values, "employeePerformanceMoney");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceMoneyNotIn(List<BigDecimal> values) {
            addCriterion("employee_performance_money not in", values, "employeePerformanceMoney");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("employee_performance_money between", value1, value2, "employeePerformanceMoney");
            return (Criteria) this;
        }

        public Criteria andEmployeePerformanceMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("employee_performance_money not between", value1, value2, "employeePerformanceMoney");
            return (Criteria) this;
        }

        public Criteria andAccessGroupIsNull() {
            addCriterion("access_group is null");
            return (Criteria) this;
        }

        public Criteria andAccessGroupIsNotNull() {
            addCriterion("access_group is not null");
            return (Criteria) this;
        }

        public Criteria andAccessGroupEqualTo(Integer value) {
            addCriterion("access_group =", value, "accessGroup");
            return (Criteria) this;
        }

        public Criteria andAccessGroupNotEqualTo(Integer value) {
            addCriterion("access_group <>", value, "accessGroup");
            return (Criteria) this;
        }

        public Criteria andAccessGroupGreaterThan(Integer value) {
            addCriterion("access_group >", value, "accessGroup");
            return (Criteria) this;
        }

        public Criteria andAccessGroupGreaterThanOrEqualTo(Integer value) {
            addCriterion("access_group >=", value, "accessGroup");
            return (Criteria) this;
        }

        public Criteria andAccessGroupLessThan(Integer value) {
            addCriterion("access_group <", value, "accessGroup");
            return (Criteria) this;
        }

        public Criteria andAccessGroupLessThanOrEqualTo(Integer value) {
            addCriterion("access_group <=", value, "accessGroup");
            return (Criteria) this;
        }

        public Criteria andAccessGroupIn(List<Integer> values) {
            addCriterion("access_group in", values, "accessGroup");
            return (Criteria) this;
        }

        public Criteria andAccessGroupNotIn(List<Integer> values) {
            addCriterion("access_group not in", values, "accessGroup");
            return (Criteria) this;
        }

        public Criteria andAccessGroupBetween(Integer value1, Integer value2) {
            addCriterion("access_group between", value1, value2, "accessGroup");
            return (Criteria) this;
        }

        public Criteria andAccessGroupNotBetween(Integer value1, Integer value2) {
            addCriterion("access_group not between", value1, value2, "accessGroup");
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

        public Criteria andCreatorEqualTo(Integer value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(Integer value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(Integer value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(Integer value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(Integer value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<Integer> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<Integer> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(Integer value1, Integer value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(Integer value1, Integer value2) {
            addCriterion("creator not between", value1, value2, "creator");
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

        public Criteria andAmenderIsNull() {
            addCriterion("amender is null");
            return (Criteria) this;
        }

        public Criteria andAmenderIsNotNull() {
            addCriterion("amender is not null");
            return (Criteria) this;
        }

        public Criteria andAmenderEqualTo(Integer value) {
            addCriterion("amender =", value, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderNotEqualTo(Integer value) {
            addCriterion("amender <>", value, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderGreaterThan(Integer value) {
            addCriterion("amender >", value, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("amender >=", value, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderLessThan(Integer value) {
            addCriterion("amender <", value, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderLessThanOrEqualTo(Integer value) {
            addCriterion("amender <=", value, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderIn(List<Integer> values) {
            addCriterion("amender in", values, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderNotIn(List<Integer> values) {
            addCriterion("amender not in", values, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderBetween(Integer value1, Integer value2) {
            addCriterion("amender between", value1, value2, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderNotBetween(Integer value1, Integer value2) {
            addCriterion("amender not between", value1, value2, "amender");
            return (Criteria) this;
        }

        public Criteria andAmendTimeIsNull() {
            addCriterion("amend_time is null");
            return (Criteria) this;
        }

        public Criteria andAmendTimeIsNotNull() {
            addCriterion("amend_time is not null");
            return (Criteria) this;
        }

        public Criteria andAmendTimeEqualTo(Date value) {
            addCriterion("amend_time =", value, "amendTime");
            return (Criteria) this;
        }

        public Criteria andAmendTimeNotEqualTo(Date value) {
            addCriterion("amend_time <>", value, "amendTime");
            return (Criteria) this;
        }

        public Criteria andAmendTimeGreaterThan(Date value) {
            addCriterion("amend_time >", value, "amendTime");
            return (Criteria) this;
        }

        public Criteria andAmendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("amend_time >=", value, "amendTime");
            return (Criteria) this;
        }

        public Criteria andAmendTimeLessThan(Date value) {
            addCriterion("amend_time <", value, "amendTime");
            return (Criteria) this;
        }

        public Criteria andAmendTimeLessThanOrEqualTo(Date value) {
            addCriterion("amend_time <=", value, "amendTime");
            return (Criteria) this;
        }

        public Criteria andAmendTimeIn(List<Date> values) {
            addCriterion("amend_time in", values, "amendTime");
            return (Criteria) this;
        }

        public Criteria andAmendTimeNotIn(List<Date> values) {
            addCriterion("amend_time not in", values, "amendTime");
            return (Criteria) this;
        }

        public Criteria andAmendTimeBetween(Date value1, Date value2) {
            addCriterion("amend_time between", value1, value2, "amendTime");
            return (Criteria) this;
        }

        public Criteria andAmendTimeNotBetween(Date value1, Date value2) {
            addCriterion("amend_time not between", value1, value2, "amendTime");
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