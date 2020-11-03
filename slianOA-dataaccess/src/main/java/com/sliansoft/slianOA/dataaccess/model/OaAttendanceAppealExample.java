package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaAttendanceAppealExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaAttendanceAppealExample() {
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

    public OaAttendanceAppealExample(int pageSize, int pageIndex) {
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

        public Criteria andAppealIdIsNull() {
            addCriterion("appeal_id is null");
            return (Criteria) this;
        }

        public Criteria andAppealIdIsNotNull() {
            addCriterion("appeal_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppealIdEqualTo(Integer value) {
            addCriterion("appeal_id =", value, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdNotEqualTo(Integer value) {
            addCriterion("appeal_id <>", value, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdGreaterThan(Integer value) {
            addCriterion("appeal_id >", value, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("appeal_id >=", value, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdLessThan(Integer value) {
            addCriterion("appeal_id <", value, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdLessThanOrEqualTo(Integer value) {
            addCriterion("appeal_id <=", value, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdIn(List<Integer> values) {
            addCriterion("appeal_id in", values, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdNotIn(List<Integer> values) {
            addCriterion("appeal_id not in", values, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdBetween(Integer value1, Integer value2) {
            addCriterion("appeal_id between", value1, value2, "appealId");
            return (Criteria) this;
        }

        public Criteria andAppealIdNotBetween(Integer value1, Integer value2) {
            addCriterion("appeal_id not between", value1, value2, "appealId");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAppealNameIsNull() {
            addCriterion("appeal_name is null");
            return (Criteria) this;
        }

        public Criteria andAppealNameIsNotNull() {
            addCriterion("appeal_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppealNameEqualTo(String value) {
            addCriterion("appeal_name =", value, "appealName");
            return (Criteria) this;
        }

        public Criteria andAppealNameNotEqualTo(String value) {
            addCriterion("appeal_name <>", value, "appealName");
            return (Criteria) this;
        }

        public Criteria andAppealNameGreaterThan(String value) {
            addCriterion("appeal_name >", value, "appealName");
            return (Criteria) this;
        }

        public Criteria andAppealNameGreaterThanOrEqualTo(String value) {
            addCriterion("appeal_name >=", value, "appealName");
            return (Criteria) this;
        }

        public Criteria andAppealNameLessThan(String value) {
            addCriterion("appeal_name <", value, "appealName");
            return (Criteria) this;
        }

        public Criteria andAppealNameLessThanOrEqualTo(String value) {
            addCriterion("appeal_name <=", value, "appealName");
            return (Criteria) this;
        }

        public Criteria andAppealNameLike(String value) {
            addCriterion("appeal_name like", value, "appealName");
            return (Criteria) this;
        }

        public Criteria andAppealNameNotLike(String value) {
            addCriterion("appeal_name not like", value, "appealName");
            return (Criteria) this;
        }

        public Criteria andAppealNameIn(List<String> values) {
            addCriterion("appeal_name in", values, "appealName");
            return (Criteria) this;
        }

        public Criteria andAppealNameNotIn(List<String> values) {
            addCriterion("appeal_name not in", values, "appealName");
            return (Criteria) this;
        }

        public Criteria andAppealNameBetween(String value1, String value2) {
            addCriterion("appeal_name between", value1, value2, "appealName");
            return (Criteria) this;
        }

        public Criteria andAppealNameNotBetween(String value1, String value2) {
            addCriterion("appeal_name not between", value1, value2, "appealName");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeIsNull() {
            addCriterion("attendance_time is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeIsNotNull() {
            addCriterion("attendance_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeEqualTo(Date value) {
            addCriterion("attendance_time =", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeNotEqualTo(Date value) {
            addCriterion("attendance_time <>", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeGreaterThan(Date value) {
            addCriterion("attendance_time >", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attendance_time >=", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeLessThan(Date value) {
            addCriterion("attendance_time <", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeLessThanOrEqualTo(Date value) {
            addCriterion("attendance_time <=", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeIn(List<Date> values) {
            addCriterion("attendance_time in", values, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeNotIn(List<Date> values) {
            addCriterion("attendance_time not in", values, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeBetween(Date value1, Date value2) {
            addCriterion("attendance_time between", value1, value2, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeNotBetween(Date value1, Date value2) {
            addCriterion("attendance_time not between", value1, value2, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAbnormalSituationIsNull() {
            addCriterion("abnormal_situation is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalSituationIsNotNull() {
            addCriterion("abnormal_situation is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalSituationEqualTo(String value) {
            addCriterion("abnormal_situation =", value, "abnormalSituation");
            return (Criteria) this;
        }

        public Criteria andAbnormalSituationNotEqualTo(String value) {
            addCriterion("abnormal_situation <>", value, "abnormalSituation");
            return (Criteria) this;
        }

        public Criteria andAbnormalSituationGreaterThan(String value) {
            addCriterion("abnormal_situation >", value, "abnormalSituation");
            return (Criteria) this;
        }

        public Criteria andAbnormalSituationGreaterThanOrEqualTo(String value) {
            addCriterion("abnormal_situation >=", value, "abnormalSituation");
            return (Criteria) this;
        }

        public Criteria andAbnormalSituationLessThan(String value) {
            addCriterion("abnormal_situation <", value, "abnormalSituation");
            return (Criteria) this;
        }

        public Criteria andAbnormalSituationLessThanOrEqualTo(String value) {
            addCriterion("abnormal_situation <=", value, "abnormalSituation");
            return (Criteria) this;
        }

        public Criteria andAbnormalSituationLike(String value) {
            addCriterion("abnormal_situation like", value, "abnormalSituation");
            return (Criteria) this;
        }

        public Criteria andAbnormalSituationNotLike(String value) {
            addCriterion("abnormal_situation not like", value, "abnormalSituation");
            return (Criteria) this;
        }

        public Criteria andAbnormalSituationIn(List<String> values) {
            addCriterion("abnormal_situation in", values, "abnormalSituation");
            return (Criteria) this;
        }

        public Criteria andAbnormalSituationNotIn(List<String> values) {
            addCriterion("abnormal_situation not in", values, "abnormalSituation");
            return (Criteria) this;
        }

        public Criteria andAbnormalSituationBetween(String value1, String value2) {
            addCriterion("abnormal_situation between", value1, value2, "abnormalSituation");
            return (Criteria) this;
        }

        public Criteria andAbnormalSituationNotBetween(String value1, String value2) {
            addCriterion("abnormal_situation not between", value1, value2, "abnormalSituation");
            return (Criteria) this;
        }

        public Criteria andAppealTimesIsNull() {
            addCriterion("appeal_times is null");
            return (Criteria) this;
        }

        public Criteria andAppealTimesIsNotNull() {
            addCriterion("appeal_times is not null");
            return (Criteria) this;
        }

        public Criteria andAppealTimesEqualTo(Integer value) {
            addCriterion("appeal_times =", value, "appealTimes");
            return (Criteria) this;
        }

        public Criteria andAppealTimesNotEqualTo(Integer value) {
            addCriterion("appeal_times <>", value, "appealTimes");
            return (Criteria) this;
        }

        public Criteria andAppealTimesGreaterThan(Integer value) {
            addCriterion("appeal_times >", value, "appealTimes");
            return (Criteria) this;
        }

        public Criteria andAppealTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("appeal_times >=", value, "appealTimes");
            return (Criteria) this;
        }

        public Criteria andAppealTimesLessThan(Integer value) {
            addCriterion("appeal_times <", value, "appealTimes");
            return (Criteria) this;
        }

        public Criteria andAppealTimesLessThanOrEqualTo(Integer value) {
            addCriterion("appeal_times <=", value, "appealTimes");
            return (Criteria) this;
        }

        public Criteria andAppealTimesIn(List<Integer> values) {
            addCriterion("appeal_times in", values, "appealTimes");
            return (Criteria) this;
        }

        public Criteria andAppealTimesNotIn(List<Integer> values) {
            addCriterion("appeal_times not in", values, "appealTimes");
            return (Criteria) this;
        }

        public Criteria andAppealTimesBetween(Integer value1, Integer value2) {
            addCriterion("appeal_times between", value1, value2, "appealTimes");
            return (Criteria) this;
        }

        public Criteria andAppealTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("appeal_times not between", value1, value2, "appealTimes");
            return (Criteria) this;
        }

        public Criteria andApproveStateIsNull() {
            addCriterion("approve_state is null");
            return (Criteria) this;
        }

        public Criteria andApproveStateIsNotNull() {
            addCriterion("approve_state is not null");
            return (Criteria) this;
        }

        public Criteria andApproveStateEqualTo(String value) {
            addCriterion("approve_state =", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateNotEqualTo(String value) {
            addCriterion("approve_state <>", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateGreaterThan(String value) {
            addCriterion("approve_state >", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateGreaterThanOrEqualTo(String value) {
            addCriterion("approve_state >=", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateLessThan(String value) {
            addCriterion("approve_state <", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateLessThanOrEqualTo(String value) {
            addCriterion("approve_state <=", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateLike(String value) {
            addCriterion("approve_state like", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateNotLike(String value) {
            addCriterion("approve_state not like", value, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateIn(List<String> values) {
            addCriterion("approve_state in", values, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateNotIn(List<String> values) {
            addCriterion("approve_state not in", values, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateBetween(String value1, String value2) {
            addCriterion("approve_state between", value1, value2, "approveState");
            return (Criteria) this;
        }

        public Criteria andApproveStateNotBetween(String value1, String value2) {
            addCriterion("approve_state not between", value1, value2, "approveState");
            return (Criteria) this;
        }

        public Criteria andAttendanceDetailsIsNull() {
            addCriterion("attendance_details is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceDetailsIsNotNull() {
            addCriterion("attendance_details is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceDetailsEqualTo(String value) {
            addCriterion("attendance_details =", value, "attendanceDetails");
            return (Criteria) this;
        }

        public Criteria andAttendanceDetailsNotEqualTo(String value) {
            addCriterion("attendance_details <>", value, "attendanceDetails");
            return (Criteria) this;
        }

        public Criteria andAttendanceDetailsGreaterThan(String value) {
            addCriterion("attendance_details >", value, "attendanceDetails");
            return (Criteria) this;
        }

        public Criteria andAttendanceDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("attendance_details >=", value, "attendanceDetails");
            return (Criteria) this;
        }

        public Criteria andAttendanceDetailsLessThan(String value) {
            addCriterion("attendance_details <", value, "attendanceDetails");
            return (Criteria) this;
        }

        public Criteria andAttendanceDetailsLessThanOrEqualTo(String value) {
            addCriterion("attendance_details <=", value, "attendanceDetails");
            return (Criteria) this;
        }

        public Criteria andAttendanceDetailsLike(String value) {
            addCriterion("attendance_details like", value, "attendanceDetails");
            return (Criteria) this;
        }

        public Criteria andAttendanceDetailsNotLike(String value) {
            addCriterion("attendance_details not like", value, "attendanceDetails");
            return (Criteria) this;
        }

        public Criteria andAttendanceDetailsIn(List<String> values) {
            addCriterion("attendance_details in", values, "attendanceDetails");
            return (Criteria) this;
        }

        public Criteria andAttendanceDetailsNotIn(List<String> values) {
            addCriterion("attendance_details not in", values, "attendanceDetails");
            return (Criteria) this;
        }

        public Criteria andAttendanceDetailsBetween(String value1, String value2) {
            addCriterion("attendance_details between", value1, value2, "attendanceDetails");
            return (Criteria) this;
        }

        public Criteria andAttendanceDetailsNotBetween(String value1, String value2) {
            addCriterion("attendance_details not between", value1, value2, "attendanceDetails");
            return (Criteria) this;
        }

        public Criteria andAppealDateIsNull() {
            addCriterion("appeal_date is null");
            return (Criteria) this;
        }

        public Criteria andAppealDateIsNotNull() {
            addCriterion("appeal_date is not null");
            return (Criteria) this;
        }

        public Criteria andAppealDateEqualTo(Date value) {
            addCriterion("appeal_date =", value, "appealDate");
            return (Criteria) this;
        }

        public Criteria andAppealDateNotEqualTo(Date value) {
            addCriterion("appeal_date <>", value, "appealDate");
            return (Criteria) this;
        }

        public Criteria andAppealDateGreaterThan(Date value) {
            addCriterion("appeal_date >", value, "appealDate");
            return (Criteria) this;
        }

        public Criteria andAppealDateGreaterThanOrEqualTo(Date value) {
            addCriterion("appeal_date >=", value, "appealDate");
            return (Criteria) this;
        }

        public Criteria andAppealDateLessThan(Date value) {
            addCriterion("appeal_date <", value, "appealDate");
            return (Criteria) this;
        }

        public Criteria andAppealDateLessThanOrEqualTo(Date value) {
            addCriterion("appeal_date <=", value, "appealDate");
            return (Criteria) this;
        }

        public Criteria andAppealDateIn(List<Date> values) {
            addCriterion("appeal_date in", values, "appealDate");
            return (Criteria) this;
        }

        public Criteria andAppealDateNotIn(List<Date> values) {
            addCriterion("appeal_date not in", values, "appealDate");
            return (Criteria) this;
        }

        public Criteria andAppealDateBetween(Date value1, Date value2) {
            addCriterion("appeal_date between", value1, value2, "appealDate");
            return (Criteria) this;
        }

        public Criteria andAppealDateNotBetween(Date value1, Date value2) {
            addCriterion("appeal_date not between", value1, value2, "appealDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceRulesIsNull() {
            addCriterion("attendance_rules is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceRulesIsNotNull() {
            addCriterion("attendance_rules is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceRulesEqualTo(String value) {
            addCriterion("attendance_rules =", value, "attendanceRules");
            return (Criteria) this;
        }

        public Criteria andAttendanceRulesNotEqualTo(String value) {
            addCriterion("attendance_rules <>", value, "attendanceRules");
            return (Criteria) this;
        }

        public Criteria andAttendanceRulesGreaterThan(String value) {
            addCriterion("attendance_rules >", value, "attendanceRules");
            return (Criteria) this;
        }

        public Criteria andAttendanceRulesGreaterThanOrEqualTo(String value) {
            addCriterion("attendance_rules >=", value, "attendanceRules");
            return (Criteria) this;
        }

        public Criteria andAttendanceRulesLessThan(String value) {
            addCriterion("attendance_rules <", value, "attendanceRules");
            return (Criteria) this;
        }

        public Criteria andAttendanceRulesLessThanOrEqualTo(String value) {
            addCriterion("attendance_rules <=", value, "attendanceRules");
            return (Criteria) this;
        }

        public Criteria andAttendanceRulesLike(String value) {
            addCriterion("attendance_rules like", value, "attendanceRules");
            return (Criteria) this;
        }

        public Criteria andAttendanceRulesNotLike(String value) {
            addCriterion("attendance_rules not like", value, "attendanceRules");
            return (Criteria) this;
        }

        public Criteria andAttendanceRulesIn(List<String> values) {
            addCriterion("attendance_rules in", values, "attendanceRules");
            return (Criteria) this;
        }

        public Criteria andAttendanceRulesNotIn(List<String> values) {
            addCriterion("attendance_rules not in", values, "attendanceRules");
            return (Criteria) this;
        }

        public Criteria andAttendanceRulesBetween(String value1, String value2) {
            addCriterion("attendance_rules between", value1, value2, "attendanceRules");
            return (Criteria) this;
        }

        public Criteria andAttendanceRulesNotBetween(String value1, String value2) {
            addCriterion("attendance_rules not between", value1, value2, "attendanceRules");
            return (Criteria) this;
        }

        public Criteria andAppealReasonIsNull() {
            addCriterion("appeal_reason is null");
            return (Criteria) this;
        }

        public Criteria andAppealReasonIsNotNull() {
            addCriterion("appeal_reason is not null");
            return (Criteria) this;
        }

        public Criteria andAppealReasonEqualTo(String value) {
            addCriterion("appeal_reason =", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonNotEqualTo(String value) {
            addCriterion("appeal_reason <>", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonGreaterThan(String value) {
            addCriterion("appeal_reason >", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonGreaterThanOrEqualTo(String value) {
            addCriterion("appeal_reason >=", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonLessThan(String value) {
            addCriterion("appeal_reason <", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonLessThanOrEqualTo(String value) {
            addCriterion("appeal_reason <=", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonLike(String value) {
            addCriterion("appeal_reason like", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonNotLike(String value) {
            addCriterion("appeal_reason not like", value, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonIn(List<String> values) {
            addCriterion("appeal_reason in", values, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonNotIn(List<String> values) {
            addCriterion("appeal_reason not in", values, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonBetween(String value1, String value2) {
            addCriterion("appeal_reason between", value1, value2, "appealReason");
            return (Criteria) this;
        }

        public Criteria andAppealReasonNotBetween(String value1, String value2) {
            addCriterion("appeal_reason not between", value1, value2, "appealReason");
            return (Criteria) this;
        }

        public Criteria andApproveNameIsNull() {
            addCriterion("approve_name is null");
            return (Criteria) this;
        }

        public Criteria andApproveNameIsNotNull() {
            addCriterion("approve_name is not null");
            return (Criteria) this;
        }

        public Criteria andApproveNameEqualTo(String value) {
            addCriterion("approve_name =", value, "approveName");
            return (Criteria) this;
        }

        public Criteria andApproveNameNotEqualTo(String value) {
            addCriterion("approve_name <>", value, "approveName");
            return (Criteria) this;
        }

        public Criteria andApproveNameGreaterThan(String value) {
            addCriterion("approve_name >", value, "approveName");
            return (Criteria) this;
        }

        public Criteria andApproveNameGreaterThanOrEqualTo(String value) {
            addCriterion("approve_name >=", value, "approveName");
            return (Criteria) this;
        }

        public Criteria andApproveNameLessThan(String value) {
            addCriterion("approve_name <", value, "approveName");
            return (Criteria) this;
        }

        public Criteria andApproveNameLessThanOrEqualTo(String value) {
            addCriterion("approve_name <=", value, "approveName");
            return (Criteria) this;
        }

        public Criteria andApproveNameLike(String value) {
            addCriterion("approve_name like", value, "approveName");
            return (Criteria) this;
        }

        public Criteria andApproveNameNotLike(String value) {
            addCriterion("approve_name not like", value, "approveName");
            return (Criteria) this;
        }

        public Criteria andApproveNameIn(List<String> values) {
            addCriterion("approve_name in", values, "approveName");
            return (Criteria) this;
        }

        public Criteria andApproveNameNotIn(List<String> values) {
            addCriterion("approve_name not in", values, "approveName");
            return (Criteria) this;
        }

        public Criteria andApproveNameBetween(String value1, String value2) {
            addCriterion("approve_name between", value1, value2, "approveName");
            return (Criteria) this;
        }

        public Criteria andApproveNameNotBetween(String value1, String value2) {
            addCriterion("approve_name not between", value1, value2, "approveName");
            return (Criteria) this;
        }

        public Criteria andApproveDateIsNull() {
            addCriterion("approve_date is null");
            return (Criteria) this;
        }

        public Criteria andApproveDateIsNotNull() {
            addCriterion("approve_date is not null");
            return (Criteria) this;
        }

        public Criteria andApproveDateEqualTo(Date value) {
            addCriterion("approve_date =", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotEqualTo(Date value) {
            addCriterion("approve_date <>", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateGreaterThan(Date value) {
            addCriterion("approve_date >", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("approve_date >=", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLessThan(Date value) {
            addCriterion("approve_date <", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLessThanOrEqualTo(Date value) {
            addCriterion("approve_date <=", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateIn(List<Date> values) {
            addCriterion("approve_date in", values, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotIn(List<Date> values) {
            addCriterion("approve_date not in", values, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateBetween(Date value1, Date value2) {
            addCriterion("approve_date between", value1, value2, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotBetween(Date value1, Date value2) {
            addCriterion("approve_date not between", value1, value2, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveContentIsNull() {
            addCriterion("approve_content is null");
            return (Criteria) this;
        }

        public Criteria andApproveContentIsNotNull() {
            addCriterion("approve_content is not null");
            return (Criteria) this;
        }

        public Criteria andApproveContentEqualTo(String value) {
            addCriterion("approve_content =", value, "approveContent");
            return (Criteria) this;
        }

        public Criteria andApproveContentNotEqualTo(String value) {
            addCriterion("approve_content <>", value, "approveContent");
            return (Criteria) this;
        }

        public Criteria andApproveContentGreaterThan(String value) {
            addCriterion("approve_content >", value, "approveContent");
            return (Criteria) this;
        }

        public Criteria andApproveContentGreaterThanOrEqualTo(String value) {
            addCriterion("approve_content >=", value, "approveContent");
            return (Criteria) this;
        }

        public Criteria andApproveContentLessThan(String value) {
            addCriterion("approve_content <", value, "approveContent");
            return (Criteria) this;
        }

        public Criteria andApproveContentLessThanOrEqualTo(String value) {
            addCriterion("approve_content <=", value, "approveContent");
            return (Criteria) this;
        }

        public Criteria andApproveContentLike(String value) {
            addCriterion("approve_content like", value, "approveContent");
            return (Criteria) this;
        }

        public Criteria andApproveContentNotLike(String value) {
            addCriterion("approve_content not like", value, "approveContent");
            return (Criteria) this;
        }

        public Criteria andApproveContentIn(List<String> values) {
            addCriterion("approve_content in", values, "approveContent");
            return (Criteria) this;
        }

        public Criteria andApproveContentNotIn(List<String> values) {
            addCriterion("approve_content not in", values, "approveContent");
            return (Criteria) this;
        }

        public Criteria andApproveContentBetween(String value1, String value2) {
            addCriterion("approve_content between", value1, value2, "approveContent");
            return (Criteria) this;
        }

        public Criteria andApproveContentNotBetween(String value1, String value2) {
            addCriterion("approve_content not between", value1, value2, "approveContent");
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