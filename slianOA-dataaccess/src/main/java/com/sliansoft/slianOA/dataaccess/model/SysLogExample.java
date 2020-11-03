package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public SysLogExample() {
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

    public SysLogExample(int pageSize, int pageIndex) {
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

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Integer value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Integer value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Integer value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Integer value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Integer> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Integer> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Integer value1, Integer value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNull() {
            addCriterion("log_time is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("log_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeEqualTo(Date value) {
            addCriterion("log_time =", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(Date value) {
            addCriterion("log_time <>", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(Date value) {
            addCriterion("log_time >", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_time >=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(Date value) {
            addCriterion("log_time <", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(Date value) {
            addCriterion("log_time <=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(List<Date> values) {
            addCriterion("log_time in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(List<Date> values) {
            addCriterion("log_time not in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(Date value1, Date value2) {
            addCriterion("log_time between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(Date value1, Date value2) {
            addCriterion("log_time not between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(String value) {
            addCriterion("log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(String value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(String value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(String value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(String value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(String value) {
            addCriterion("log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLike(String value) {
            addCriterion("log_type like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotLike(String value) {
            addCriterion("log_type not like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<String> values) {
            addCriterion("log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<String> values) {
            addCriterion("log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(String value1, String value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(String value1, String value2) {
            addCriterion("log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogUserIdIsNull() {
            addCriterion("log_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLogUserIdIsNotNull() {
            addCriterion("log_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogUserIdEqualTo(Integer value) {
            addCriterion("log_user_id =", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdNotEqualTo(Integer value) {
            addCriterion("log_user_id <>", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdGreaterThan(Integer value) {
            addCriterion("log_user_id >", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_user_id >=", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdLessThan(Integer value) {
            addCriterion("log_user_id <", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("log_user_id <=", value, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdIn(List<Integer> values) {
            addCriterion("log_user_id in", values, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdNotIn(List<Integer> values) {
            addCriterion("log_user_id not in", values, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdBetween(Integer value1, Integer value2) {
            addCriterion("log_user_id between", value1, value2, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("log_user_id not between", value1, value2, "logUserId");
            return (Criteria) this;
        }

        public Criteria andLogUserIpIsNull() {
            addCriterion("log_user_ip is null");
            return (Criteria) this;
        }

        public Criteria andLogUserIpIsNotNull() {
            addCriterion("log_user_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLogUserIpEqualTo(String value) {
            addCriterion("log_user_ip =", value, "logUserIp");
            return (Criteria) this;
        }

        public Criteria andLogUserIpNotEqualTo(String value) {
            addCriterion("log_user_ip <>", value, "logUserIp");
            return (Criteria) this;
        }

        public Criteria andLogUserIpGreaterThan(String value) {
            addCriterion("log_user_ip >", value, "logUserIp");
            return (Criteria) this;
        }

        public Criteria andLogUserIpGreaterThanOrEqualTo(String value) {
            addCriterion("log_user_ip >=", value, "logUserIp");
            return (Criteria) this;
        }

        public Criteria andLogUserIpLessThan(String value) {
            addCriterion("log_user_ip <", value, "logUserIp");
            return (Criteria) this;
        }

        public Criteria andLogUserIpLessThanOrEqualTo(String value) {
            addCriterion("log_user_ip <=", value, "logUserIp");
            return (Criteria) this;
        }

        public Criteria andLogUserIpLike(String value) {
            addCriterion("log_user_ip like", value, "logUserIp");
            return (Criteria) this;
        }

        public Criteria andLogUserIpNotLike(String value) {
            addCriterion("log_user_ip not like", value, "logUserIp");
            return (Criteria) this;
        }

        public Criteria andLogUserIpIn(List<String> values) {
            addCriterion("log_user_ip in", values, "logUserIp");
            return (Criteria) this;
        }

        public Criteria andLogUserIpNotIn(List<String> values) {
            addCriterion("log_user_ip not in", values, "logUserIp");
            return (Criteria) this;
        }

        public Criteria andLogUserIpBetween(String value1, String value2) {
            addCriterion("log_user_ip between", value1, value2, "logUserIp");
            return (Criteria) this;
        }

        public Criteria andLogUserIpNotBetween(String value1, String value2) {
            addCriterion("log_user_ip not between", value1, value2, "logUserIp");
            return (Criteria) this;
        }

        public Criteria andLogClassIsNull() {
            addCriterion("log_class is null");
            return (Criteria) this;
        }

        public Criteria andLogClassIsNotNull() {
            addCriterion("log_class is not null");
            return (Criteria) this;
        }

        public Criteria andLogClassEqualTo(String value) {
            addCriterion("log_class =", value, "logClass");
            return (Criteria) this;
        }

        public Criteria andLogClassNotEqualTo(String value) {
            addCriterion("log_class <>", value, "logClass");
            return (Criteria) this;
        }

        public Criteria andLogClassGreaterThan(String value) {
            addCriterion("log_class >", value, "logClass");
            return (Criteria) this;
        }

        public Criteria andLogClassGreaterThanOrEqualTo(String value) {
            addCriterion("log_class >=", value, "logClass");
            return (Criteria) this;
        }

        public Criteria andLogClassLessThan(String value) {
            addCriterion("log_class <", value, "logClass");
            return (Criteria) this;
        }

        public Criteria andLogClassLessThanOrEqualTo(String value) {
            addCriterion("log_class <=", value, "logClass");
            return (Criteria) this;
        }

        public Criteria andLogClassLike(String value) {
            addCriterion("log_class like", value, "logClass");
            return (Criteria) this;
        }

        public Criteria andLogClassNotLike(String value) {
            addCriterion("log_class not like", value, "logClass");
            return (Criteria) this;
        }

        public Criteria andLogClassIn(List<String> values) {
            addCriterion("log_class in", values, "logClass");
            return (Criteria) this;
        }

        public Criteria andLogClassNotIn(List<String> values) {
            addCriterion("log_class not in", values, "logClass");
            return (Criteria) this;
        }

        public Criteria andLogClassBetween(String value1, String value2) {
            addCriterion("log_class between", value1, value2, "logClass");
            return (Criteria) this;
        }

        public Criteria andLogClassNotBetween(String value1, String value2) {
            addCriterion("log_class not between", value1, value2, "logClass");
            return (Criteria) this;
        }

        public Criteria andLogFunctionIsNull() {
            addCriterion("log_function is null");
            return (Criteria) this;
        }

        public Criteria andLogFunctionIsNotNull() {
            addCriterion("log_function is not null");
            return (Criteria) this;
        }

        public Criteria andLogFunctionEqualTo(String value) {
            addCriterion("log_function =", value, "logFunction");
            return (Criteria) this;
        }

        public Criteria andLogFunctionNotEqualTo(String value) {
            addCriterion("log_function <>", value, "logFunction");
            return (Criteria) this;
        }

        public Criteria andLogFunctionGreaterThan(String value) {
            addCriterion("log_function >", value, "logFunction");
            return (Criteria) this;
        }

        public Criteria andLogFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("log_function >=", value, "logFunction");
            return (Criteria) this;
        }

        public Criteria andLogFunctionLessThan(String value) {
            addCriterion("log_function <", value, "logFunction");
            return (Criteria) this;
        }

        public Criteria andLogFunctionLessThanOrEqualTo(String value) {
            addCriterion("log_function <=", value, "logFunction");
            return (Criteria) this;
        }

        public Criteria andLogFunctionLike(String value) {
            addCriterion("log_function like", value, "logFunction");
            return (Criteria) this;
        }

        public Criteria andLogFunctionNotLike(String value) {
            addCriterion("log_function not like", value, "logFunction");
            return (Criteria) this;
        }

        public Criteria andLogFunctionIn(List<String> values) {
            addCriterion("log_function in", values, "logFunction");
            return (Criteria) this;
        }

        public Criteria andLogFunctionNotIn(List<String> values) {
            addCriterion("log_function not in", values, "logFunction");
            return (Criteria) this;
        }

        public Criteria andLogFunctionBetween(String value1, String value2) {
            addCriterion("log_function between", value1, value2, "logFunction");
            return (Criteria) this;
        }

        public Criteria andLogFunctionNotBetween(String value1, String value2) {
            addCriterion("log_function not between", value1, value2, "logFunction");
            return (Criteria) this;
        }

        public Criteria andLogParametersIsNull() {
            addCriterion("log_parameters is null");
            return (Criteria) this;
        }

        public Criteria andLogParametersIsNotNull() {
            addCriterion("log_parameters is not null");
            return (Criteria) this;
        }

        public Criteria andLogParametersEqualTo(String value) {
            addCriterion("log_parameters =", value, "logParameters");
            return (Criteria) this;
        }

        public Criteria andLogParametersNotEqualTo(String value) {
            addCriterion("log_parameters <>", value, "logParameters");
            return (Criteria) this;
        }

        public Criteria andLogParametersGreaterThan(String value) {
            addCriterion("log_parameters >", value, "logParameters");
            return (Criteria) this;
        }

        public Criteria andLogParametersGreaterThanOrEqualTo(String value) {
            addCriterion("log_parameters >=", value, "logParameters");
            return (Criteria) this;
        }

        public Criteria andLogParametersLessThan(String value) {
            addCriterion("log_parameters <", value, "logParameters");
            return (Criteria) this;
        }

        public Criteria andLogParametersLessThanOrEqualTo(String value) {
            addCriterion("log_parameters <=", value, "logParameters");
            return (Criteria) this;
        }

        public Criteria andLogParametersLike(String value) {
            addCriterion("log_parameters like", value, "logParameters");
            return (Criteria) this;
        }

        public Criteria andLogParametersNotLike(String value) {
            addCriterion("log_parameters not like", value, "logParameters");
            return (Criteria) this;
        }

        public Criteria andLogParametersIn(List<String> values) {
            addCriterion("log_parameters in", values, "logParameters");
            return (Criteria) this;
        }

        public Criteria andLogParametersNotIn(List<String> values) {
            addCriterion("log_parameters not in", values, "logParameters");
            return (Criteria) this;
        }

        public Criteria andLogParametersBetween(String value1, String value2) {
            addCriterion("log_parameters between", value1, value2, "logParameters");
            return (Criteria) this;
        }

        public Criteria andLogParametersNotBetween(String value1, String value2) {
            addCriterion("log_parameters not between", value1, value2, "logParameters");
            return (Criteria) this;
        }

        public Criteria andLogReturnIsNull() {
            addCriterion("log_return is null");
            return (Criteria) this;
        }

        public Criteria andLogReturnIsNotNull() {
            addCriterion("log_return is not null");
            return (Criteria) this;
        }

        public Criteria andLogReturnEqualTo(String value) {
            addCriterion("log_return =", value, "logReturn");
            return (Criteria) this;
        }

        public Criteria andLogReturnNotEqualTo(String value) {
            addCriterion("log_return <>", value, "logReturn");
            return (Criteria) this;
        }

        public Criteria andLogReturnGreaterThan(String value) {
            addCriterion("log_return >", value, "logReturn");
            return (Criteria) this;
        }

        public Criteria andLogReturnGreaterThanOrEqualTo(String value) {
            addCriterion("log_return >=", value, "logReturn");
            return (Criteria) this;
        }

        public Criteria andLogReturnLessThan(String value) {
            addCriterion("log_return <", value, "logReturn");
            return (Criteria) this;
        }

        public Criteria andLogReturnLessThanOrEqualTo(String value) {
            addCriterion("log_return <=", value, "logReturn");
            return (Criteria) this;
        }

        public Criteria andLogReturnLike(String value) {
            addCriterion("log_return like", value, "logReturn");
            return (Criteria) this;
        }

        public Criteria andLogReturnNotLike(String value) {
            addCriterion("log_return not like", value, "logReturn");
            return (Criteria) this;
        }

        public Criteria andLogReturnIn(List<String> values) {
            addCriterion("log_return in", values, "logReturn");
            return (Criteria) this;
        }

        public Criteria andLogReturnNotIn(List<String> values) {
            addCriterion("log_return not in", values, "logReturn");
            return (Criteria) this;
        }

        public Criteria andLogReturnBetween(String value1, String value2) {
            addCriterion("log_return between", value1, value2, "logReturn");
            return (Criteria) this;
        }

        public Criteria andLogReturnNotBetween(String value1, String value2) {
            addCriterion("log_return not between", value1, value2, "logReturn");
            return (Criteria) this;
        }

        public Criteria andLogMessageIsNull() {
            addCriterion("log_message is null");
            return (Criteria) this;
        }

        public Criteria andLogMessageIsNotNull() {
            addCriterion("log_message is not null");
            return (Criteria) this;
        }

        public Criteria andLogMessageEqualTo(String value) {
            addCriterion("log_message =", value, "logMessage");
            return (Criteria) this;
        }

        public Criteria andLogMessageNotEqualTo(String value) {
            addCriterion("log_message <>", value, "logMessage");
            return (Criteria) this;
        }

        public Criteria andLogMessageGreaterThan(String value) {
            addCriterion("log_message >", value, "logMessage");
            return (Criteria) this;
        }

        public Criteria andLogMessageGreaterThanOrEqualTo(String value) {
            addCriterion("log_message >=", value, "logMessage");
            return (Criteria) this;
        }

        public Criteria andLogMessageLessThan(String value) {
            addCriterion("log_message <", value, "logMessage");
            return (Criteria) this;
        }

        public Criteria andLogMessageLessThanOrEqualTo(String value) {
            addCriterion("log_message <=", value, "logMessage");
            return (Criteria) this;
        }

        public Criteria andLogMessageLike(String value) {
            addCriterion("log_message like", value, "logMessage");
            return (Criteria) this;
        }

        public Criteria andLogMessageNotLike(String value) {
            addCriterion("log_message not like", value, "logMessage");
            return (Criteria) this;
        }

        public Criteria andLogMessageIn(List<String> values) {
            addCriterion("log_message in", values, "logMessage");
            return (Criteria) this;
        }

        public Criteria andLogMessageNotIn(List<String> values) {
            addCriterion("log_message not in", values, "logMessage");
            return (Criteria) this;
        }

        public Criteria andLogMessageBetween(String value1, String value2) {
            addCriterion("log_message between", value1, value2, "logMessage");
            return (Criteria) this;
        }

        public Criteria andLogMessageNotBetween(String value1, String value2) {
            addCriterion("log_message not between", value1, value2, "logMessage");
            return (Criteria) this;
        }

        public Criteria andLogStatusIsNull() {
            addCriterion("log_status is null");
            return (Criteria) this;
        }

        public Criteria andLogStatusIsNotNull() {
            addCriterion("log_status is not null");
            return (Criteria) this;
        }

        public Criteria andLogStatusEqualTo(String value) {
            addCriterion("log_status =", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusNotEqualTo(String value) {
            addCriterion("log_status <>", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusGreaterThan(String value) {
            addCriterion("log_status >", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusGreaterThanOrEqualTo(String value) {
            addCriterion("log_status >=", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusLessThan(String value) {
            addCriterion("log_status <", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusLessThanOrEqualTo(String value) {
            addCriterion("log_status <=", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusLike(String value) {
            addCriterion("log_status like", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusNotLike(String value) {
            addCriterion("log_status not like", value, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusIn(List<String> values) {
            addCriterion("log_status in", values, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusNotIn(List<String> values) {
            addCriterion("log_status not in", values, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusBetween(String value1, String value2) {
            addCriterion("log_status between", value1, value2, "logStatus");
            return (Criteria) this;
        }

        public Criteria andLogStatusNotBetween(String value1, String value2) {
            addCriterion("log_status not between", value1, value2, "logStatus");
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