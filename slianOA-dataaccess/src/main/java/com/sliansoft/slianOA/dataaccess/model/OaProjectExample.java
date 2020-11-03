package com.sliansoft.slianOA.dataaccess.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaProjectExample() {
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

    public OaProjectExample(int pageSize, int pageIndex) {
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

        public Criteria andProjectCustomerIsNull() {
            addCriterion("project_customer is null");
            return (Criteria) this;
        }

        public Criteria andProjectCustomerIsNotNull() {
            addCriterion("project_customer is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCustomerEqualTo(String value) {
            addCriterion("project_customer =", value, "projectCustomer");
            return (Criteria) this;
        }

        public Criteria andProjectCustomerNotEqualTo(String value) {
            addCriterion("project_customer <>", value, "projectCustomer");
            return (Criteria) this;
        }

        public Criteria andProjectCustomerGreaterThan(String value) {
            addCriterion("project_customer >", value, "projectCustomer");
            return (Criteria) this;
        }

        public Criteria andProjectCustomerGreaterThanOrEqualTo(String value) {
            addCriterion("project_customer >=", value, "projectCustomer");
            return (Criteria) this;
        }

        public Criteria andProjectCustomerLessThan(String value) {
            addCriterion("project_customer <", value, "projectCustomer");
            return (Criteria) this;
        }

        public Criteria andProjectCustomerLessThanOrEqualTo(String value) {
            addCriterion("project_customer <=", value, "projectCustomer");
            return (Criteria) this;
        }

        public Criteria andProjectCustomerLike(String value) {
            addCriterion("project_customer like", value, "projectCustomer");
            return (Criteria) this;
        }

        public Criteria andProjectCustomerNotLike(String value) {
            addCriterion("project_customer not like", value, "projectCustomer");
            return (Criteria) this;
        }

        public Criteria andProjectCustomerIn(List<String> values) {
            addCriterion("project_customer in", values, "projectCustomer");
            return (Criteria) this;
        }

        public Criteria andProjectCustomerNotIn(List<String> values) {
            addCriterion("project_customer not in", values, "projectCustomer");
            return (Criteria) this;
        }

        public Criteria andProjectCustomerBetween(String value1, String value2) {
            addCriterion("project_customer between", value1, value2, "projectCustomer");
            return (Criteria) this;
        }

        public Criteria andProjectCustomerNotBetween(String value1, String value2) {
            addCriterion("project_customer not between", value1, value2, "projectCustomer");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIsNull() {
            addCriterion("project_status is null");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIsNotNull() {
            addCriterion("project_status is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStatusEqualTo(String value) {
            addCriterion("project_status =", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotEqualTo(String value) {
            addCriterion("project_status <>", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusGreaterThan(String value) {
            addCriterion("project_status >", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusGreaterThanOrEqualTo(String value) {
            addCriterion("project_status >=", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLessThan(String value) {
            addCriterion("project_status <", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLessThanOrEqualTo(String value) {
            addCriterion("project_status <=", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLike(String value) {
            addCriterion("project_status like", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotLike(String value) {
            addCriterion("project_status not like", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIn(List<String> values) {
            addCriterion("project_status in", values, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotIn(List<String> values) {
            addCriterion("project_status not in", values, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusBetween(String value1, String value2) {
            addCriterion("project_status between", value1, value2, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotBetween(String value1, String value2) {
            addCriterion("project_status not between", value1, value2, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodIsNull() {
            addCriterion("project_period is null");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodIsNotNull() {
            addCriterion("project_period is not null");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodEqualTo(Integer value) {
            addCriterion("project_period =", value, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodNotEqualTo(Integer value) {
            addCriterion("project_period <>", value, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodGreaterThan(Integer value) {
            addCriterion("project_period >", value, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_period >=", value, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodLessThan(Integer value) {
            addCriterion("project_period <", value, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("project_period <=", value, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodIn(List<Integer> values) {
            addCriterion("project_period in", values, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodNotIn(List<Integer> values) {
            addCriterion("project_period not in", values, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodBetween(Integer value1, Integer value2) {
            addCriterion("project_period between", value1, value2, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("project_period not between", value1, value2, "projectPeriod");
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

        public Criteria andProjectLeftMoneyIsNull() {
            addCriterion("project_left_money is null");
            return (Criteria) this;
        }

        public Criteria andProjectLeftMoneyIsNotNull() {
            addCriterion("project_left_money is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLeftMoneyEqualTo(BigDecimal value) {
            addCriterion("project_left_money =", value, "projectLeftMoney");
            return (Criteria) this;
        }

        public Criteria andProjectLeftMoneyNotEqualTo(BigDecimal value) {
            addCriterion("project_left_money <>", value, "projectLeftMoney");
            return (Criteria) this;
        }

        public Criteria andProjectLeftMoneyGreaterThan(BigDecimal value) {
            addCriterion("project_left_money >", value, "projectLeftMoney");
            return (Criteria) this;
        }

        public Criteria andProjectLeftMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_left_money >=", value, "projectLeftMoney");
            return (Criteria) this;
        }

        public Criteria andProjectLeftMoneyLessThan(BigDecimal value) {
            addCriterion("project_left_money <", value, "projectLeftMoney");
            return (Criteria) this;
        }

        public Criteria andProjectLeftMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_left_money <=", value, "projectLeftMoney");
            return (Criteria) this;
        }

        public Criteria andProjectLeftMoneyIn(List<BigDecimal> values) {
            addCriterion("project_left_money in", values, "projectLeftMoney");
            return (Criteria) this;
        }

        public Criteria andProjectLeftMoneyNotIn(List<BigDecimal> values) {
            addCriterion("project_left_money not in", values, "projectLeftMoney");
            return (Criteria) this;
        }

        public Criteria andProjectLeftMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_left_money between", value1, value2, "projectLeftMoney");
            return (Criteria) this;
        }

        public Criteria andProjectLeftMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_left_money not between", value1, value2, "projectLeftMoney");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageMoneyIsNull() {
            addCriterion("project_encourage_money is null");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageMoneyIsNotNull() {
            addCriterion("project_encourage_money is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageMoneyEqualTo(BigDecimal value) {
            addCriterion("project_encourage_money =", value, "projectEncourageMoney");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageMoneyNotEqualTo(BigDecimal value) {
            addCriterion("project_encourage_money <>", value, "projectEncourageMoney");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageMoneyGreaterThan(BigDecimal value) {
            addCriterion("project_encourage_money >", value, "projectEncourageMoney");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_encourage_money >=", value, "projectEncourageMoney");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageMoneyLessThan(BigDecimal value) {
            addCriterion("project_encourage_money <", value, "projectEncourageMoney");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_encourage_money <=", value, "projectEncourageMoney");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageMoneyIn(List<BigDecimal> values) {
            addCriterion("project_encourage_money in", values, "projectEncourageMoney");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageMoneyNotIn(List<BigDecimal> values) {
            addCriterion("project_encourage_money not in", values, "projectEncourageMoney");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_encourage_money between", value1, value2, "projectEncourageMoney");
            return (Criteria) this;
        }

        public Criteria andProjectEncourageMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_encourage_money not between", value1, value2, "projectEncourageMoney");
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

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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

        public Criteria andMarketPersonIsNull() {
            addCriterion("market_person is null");
            return (Criteria) this;
        }

        public Criteria andMarketPersonIsNotNull() {
            addCriterion("market_person is not null");
            return (Criteria) this;
        }

        public Criteria andMarketPersonEqualTo(String value) {
            addCriterion("market_person =", value, "marketPerson");
            return (Criteria) this;
        }

        public Criteria andMarketPersonNotEqualTo(String value) {
            addCriterion("market_person <>", value, "marketPerson");
            return (Criteria) this;
        }

        public Criteria andMarketPersonGreaterThan(String value) {
            addCriterion("market_person >", value, "marketPerson");
            return (Criteria) this;
        }

        public Criteria andMarketPersonGreaterThanOrEqualTo(String value) {
            addCriterion("market_person >=", value, "marketPerson");
            return (Criteria) this;
        }

        public Criteria andMarketPersonLessThan(String value) {
            addCriterion("market_person <", value, "marketPerson");
            return (Criteria) this;
        }

        public Criteria andMarketPersonLessThanOrEqualTo(String value) {
            addCriterion("market_person <=", value, "marketPerson");
            return (Criteria) this;
        }

        public Criteria andMarketPersonLike(String value) {
            addCriterion("market_person like", value, "marketPerson");
            return (Criteria) this;
        }

        public Criteria andMarketPersonNotLike(String value) {
            addCriterion("market_person not like", value, "marketPerson");
            return (Criteria) this;
        }

        public Criteria andMarketPersonIn(List<String> values) {
            addCriterion("market_person in", values, "marketPerson");
            return (Criteria) this;
        }

        public Criteria andMarketPersonNotIn(List<String> values) {
            addCriterion("market_person not in", values, "marketPerson");
            return (Criteria) this;
        }

        public Criteria andMarketPersonBetween(String value1, String value2) {
            addCriterion("market_person between", value1, value2, "marketPerson");
            return (Criteria) this;
        }

        public Criteria andMarketPersonNotBetween(String value1, String value2) {
            addCriterion("market_person not between", value1, value2, "marketPerson");
            return (Criteria) this;
        }

        public Criteria andMarketCostIsNull() {
            addCriterion("market_cost is null");
            return (Criteria) this;
        }

        public Criteria andMarketCostIsNotNull() {
            addCriterion("market_cost is not null");
            return (Criteria) this;
        }

        public Criteria andMarketCostEqualTo(BigDecimal value) {
            addCriterion("market_cost =", value, "marketCost");
            return (Criteria) this;
        }

        public Criteria andMarketCostNotEqualTo(BigDecimal value) {
            addCriterion("market_cost <>", value, "marketCost");
            return (Criteria) this;
        }

        public Criteria andMarketCostGreaterThan(BigDecimal value) {
            addCriterion("market_cost >", value, "marketCost");
            return (Criteria) this;
        }

        public Criteria andMarketCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("market_cost >=", value, "marketCost");
            return (Criteria) this;
        }

        public Criteria andMarketCostLessThan(BigDecimal value) {
            addCriterion("market_cost <", value, "marketCost");
            return (Criteria) this;
        }

        public Criteria andMarketCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("market_cost <=", value, "marketCost");
            return (Criteria) this;
        }

        public Criteria andMarketCostIn(List<BigDecimal> values) {
            addCriterion("market_cost in", values, "marketCost");
            return (Criteria) this;
        }

        public Criteria andMarketCostNotIn(List<BigDecimal> values) {
            addCriterion("market_cost not in", values, "marketCost");
            return (Criteria) this;
        }

        public Criteria andMarketCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_cost between", value1, value2, "marketCost");
            return (Criteria) this;
        }

        public Criteria andMarketCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_cost not between", value1, value2, "marketCost");
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

        public Criteria andProjectBeginDateIsNull() {
            addCriterion("project_begin_date is null");
            return (Criteria) this;
        }

        public Criteria andProjectBeginDateIsNotNull() {
            addCriterion("project_begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andProjectBeginDateEqualTo(Date value) {
            addCriterion("project_begin_date =", value, "projectBeginDate");
            return (Criteria) this;
        }

        public Criteria andProjectBeginDateNotEqualTo(Date value) {
            addCriterion("project_begin_date <>", value, "projectBeginDate");
            return (Criteria) this;
        }

        public Criteria andProjectBeginDateGreaterThan(Date value) {
            addCriterion("project_begin_date >", value, "projectBeginDate");
            return (Criteria) this;
        }

        public Criteria andProjectBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("project_begin_date >=", value, "projectBeginDate");
            return (Criteria) this;
        }

        public Criteria andProjectBeginDateLessThan(Date value) {
            addCriterion("project_begin_date <", value, "projectBeginDate");
            return (Criteria) this;
        }

        public Criteria andProjectBeginDateLessThanOrEqualTo(Date value) {
            addCriterion("project_begin_date <=", value, "projectBeginDate");
            return (Criteria) this;
        }

        public Criteria andProjectBeginDateIn(List<Date> values) {
            addCriterion("project_begin_date in", values, "projectBeginDate");
            return (Criteria) this;
        }

        public Criteria andProjectBeginDateNotIn(List<Date> values) {
            addCriterion("project_begin_date not in", values, "projectBeginDate");
            return (Criteria) this;
        }

        public Criteria andProjectBeginDateBetween(Date value1, Date value2) {
            addCriterion("project_begin_date between", value1, value2, "projectBeginDate");
            return (Criteria) this;
        }

        public Criteria andProjectBeginDateNotBetween(Date value1, Date value2) {
            addCriterion("project_begin_date not between", value1, value2, "projectBeginDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateIsNull() {
            addCriterion("project_end_date is null");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateIsNotNull() {
            addCriterion("project_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateEqualTo(Date value) {
            addCriterion("project_end_date =", value, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateNotEqualTo(Date value) {
            addCriterion("project_end_date <>", value, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateGreaterThan(Date value) {
            addCriterion("project_end_date >", value, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("project_end_date >=", value, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateLessThan(Date value) {
            addCriterion("project_end_date <", value, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateLessThanOrEqualTo(Date value) {
            addCriterion("project_end_date <=", value, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateIn(List<Date> values) {
            addCriterion("project_end_date in", values, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateNotIn(List<Date> values) {
            addCriterion("project_end_date not in", values, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateBetween(Date value1, Date value2) {
            addCriterion("project_end_date between", value1, value2, "projectEndDate");
            return (Criteria) this;
        }

        public Criteria andProjectEndDateNotBetween(Date value1, Date value2) {
            addCriterion("project_end_date not between", value1, value2, "projectEndDate");
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