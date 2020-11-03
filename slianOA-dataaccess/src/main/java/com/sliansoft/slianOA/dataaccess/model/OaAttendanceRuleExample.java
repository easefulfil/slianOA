package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaAttendanceRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaAttendanceRuleExample() {
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

    public OaAttendanceRuleExample(int pageSize, int pageIndex) {
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

        public Criteria andAttendNameIsNull() {
            addCriterion("attend_name is null");
            return (Criteria) this;
        }

        public Criteria andAttendNameIsNotNull() {
            addCriterion("attend_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttendNameEqualTo(String value) {
            addCriterion("attend_name =", value, "attendName");
            return (Criteria) this;
        }

        public Criteria andAttendNameNotEqualTo(String value) {
            addCriterion("attend_name <>", value, "attendName");
            return (Criteria) this;
        }

        public Criteria andAttendNameGreaterThan(String value) {
            addCriterion("attend_name >", value, "attendName");
            return (Criteria) this;
        }

        public Criteria andAttendNameGreaterThanOrEqualTo(String value) {
            addCriterion("attend_name >=", value, "attendName");
            return (Criteria) this;
        }

        public Criteria andAttendNameLessThan(String value) {
            addCriterion("attend_name <", value, "attendName");
            return (Criteria) this;
        }

        public Criteria andAttendNameLessThanOrEqualTo(String value) {
            addCriterion("attend_name <=", value, "attendName");
            return (Criteria) this;
        }

        public Criteria andAttendNameLike(String value) {
            addCriterion("attend_name like", value, "attendName");
            return (Criteria) this;
        }

        public Criteria andAttendNameNotLike(String value) {
            addCriterion("attend_name not like", value, "attendName");
            return (Criteria) this;
        }

        public Criteria andAttendNameIn(List<String> values) {
            addCriterion("attend_name in", values, "attendName");
            return (Criteria) this;
        }

        public Criteria andAttendNameNotIn(List<String> values) {
            addCriterion("attend_name not in", values, "attendName");
            return (Criteria) this;
        }

        public Criteria andAttendNameBetween(String value1, String value2) {
            addCriterion("attend_name between", value1, value2, "attendName");
            return (Criteria) this;
        }

        public Criteria andAttendNameNotBetween(String value1, String value2) {
            addCriterion("attend_name not between", value1, value2, "attendName");
            return (Criteria) this;
        }

        public Criteria andAttendAddressIsNull() {
            addCriterion("attend_address is null");
            return (Criteria) this;
        }

        public Criteria andAttendAddressIsNotNull() {
            addCriterion("attend_address is not null");
            return (Criteria) this;
        }

        public Criteria andAttendAddressEqualTo(String value) {
            addCriterion("attend_address =", value, "attendAddress");
            return (Criteria) this;
        }

        public Criteria andAttendAddressNotEqualTo(String value) {
            addCriterion("attend_address <>", value, "attendAddress");
            return (Criteria) this;
        }

        public Criteria andAttendAddressGreaterThan(String value) {
            addCriterion("attend_address >", value, "attendAddress");
            return (Criteria) this;
        }

        public Criteria andAttendAddressGreaterThanOrEqualTo(String value) {
            addCriterion("attend_address >=", value, "attendAddress");
            return (Criteria) this;
        }

        public Criteria andAttendAddressLessThan(String value) {
            addCriterion("attend_address <", value, "attendAddress");
            return (Criteria) this;
        }

        public Criteria andAttendAddressLessThanOrEqualTo(String value) {
            addCriterion("attend_address <=", value, "attendAddress");
            return (Criteria) this;
        }

        public Criteria andAttendAddressLike(String value) {
            addCriterion("attend_address like", value, "attendAddress");
            return (Criteria) this;
        }

        public Criteria andAttendAddressNotLike(String value) {
            addCriterion("attend_address not like", value, "attendAddress");
            return (Criteria) this;
        }

        public Criteria andAttendAddressIn(List<String> values) {
            addCriterion("attend_address in", values, "attendAddress");
            return (Criteria) this;
        }

        public Criteria andAttendAddressNotIn(List<String> values) {
            addCriterion("attend_address not in", values, "attendAddress");
            return (Criteria) this;
        }

        public Criteria andAttendAddressBetween(String value1, String value2) {
            addCriterion("attend_address between", value1, value2, "attendAddress");
            return (Criteria) this;
        }

        public Criteria andAttendAddressNotBetween(String value1, String value2) {
            addCriterion("attend_address not between", value1, value2, "attendAddress");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Double value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Double value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Double value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Double value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Double> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Double> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Double value1, Double value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andScopeIsNull() {
            addCriterion("scope is null");
            return (Criteria) this;
        }

        public Criteria andScopeIsNotNull() {
            addCriterion("scope is not null");
            return (Criteria) this;
        }

        public Criteria andScopeEqualTo(Integer value) {
            addCriterion("scope =", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotEqualTo(Integer value) {
            addCriterion("scope <>", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThan(Integer value) {
            addCriterion("scope >", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThanOrEqualTo(Integer value) {
            addCriterion("scope >=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThan(Integer value) {
            addCriterion("scope <", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThanOrEqualTo(Integer value) {
            addCriterion("scope <=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeIn(List<Integer> values) {
            addCriterion("scope in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotIn(List<Integer> values) {
            addCriterion("scope not in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeBetween(Integer value1, Integer value2) {
            addCriterion("scope between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotBetween(Integer value1, Integer value2) {
            addCriterion("scope not between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andWorkDaysIsNull() {
            addCriterion("work_days is null");
            return (Criteria) this;
        }

        public Criteria andWorkDaysIsNotNull() {
            addCriterion("work_days is not null");
            return (Criteria) this;
        }

        public Criteria andWorkDaysEqualTo(Float value) {
            addCriterion("work_days =", value, "workDays");
            return (Criteria) this;
        }

        public Criteria andWorkDaysNotEqualTo(Float value) {
            addCriterion("work_days <>", value, "workDays");
            return (Criteria) this;
        }

        public Criteria andWorkDaysGreaterThan(Float value) {
            addCriterion("work_days >", value, "workDays");
            return (Criteria) this;
        }

        public Criteria andWorkDaysGreaterThanOrEqualTo(Float value) {
            addCriterion("work_days >=", value, "workDays");
            return (Criteria) this;
        }

        public Criteria andWorkDaysLessThan(Float value) {
            addCriterion("work_days <", value, "workDays");
            return (Criteria) this;
        }

        public Criteria andWorkDaysLessThanOrEqualTo(Float value) {
            addCriterion("work_days <=", value, "workDays");
            return (Criteria) this;
        }

        public Criteria andWorkDaysIn(List<Float> values) {
            addCriterion("work_days in", values, "workDays");
            return (Criteria) this;
        }

        public Criteria andWorkDaysNotIn(List<Float> values) {
            addCriterion("work_days not in", values, "workDays");
            return (Criteria) this;
        }

        public Criteria andWorkDaysBetween(Float value1, Float value2) {
            addCriterion("work_days between", value1, value2, "workDays");
            return (Criteria) this;
        }

        public Criteria andWorkDaysNotBetween(Float value1, Float value2) {
            addCriterion("work_days not between", value1, value2, "workDays");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIsNull() {
            addCriterion("signin_time is null");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIsNotNull() {
            addCriterion("signin_time is not null");
            return (Criteria) this;
        }

        public Criteria andSigninTimeEqualTo(String value) {
            addCriterion("signin_time =", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotEqualTo(String value) {
            addCriterion("signin_time <>", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeGreaterThan(String value) {
            addCriterion("signin_time >", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeGreaterThanOrEqualTo(String value) {
            addCriterion("signin_time >=", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeLessThan(String value) {
            addCriterion("signin_time <", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeLessThanOrEqualTo(String value) {
            addCriterion("signin_time <=", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeLike(String value) {
            addCriterion("signin_time like", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotLike(String value) {
            addCriterion("signin_time not like", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIn(List<String> values) {
            addCriterion("signin_time in", values, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotIn(List<String> values) {
            addCriterion("signin_time not in", values, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeBetween(String value1, String value2) {
            addCriterion("signin_time between", value1, value2, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotBetween(String value1, String value2) {
            addCriterion("signin_time not between", value1, value2, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninBeginTimeIsNull() {
            addCriterion("signin_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andSigninBeginTimeIsNotNull() {
            addCriterion("signin_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andSigninBeginTimeEqualTo(String value) {
            addCriterion("signin_begin_time =", value, "signinBeginTime");
            return (Criteria) this;
        }

        public Criteria andSigninBeginTimeNotEqualTo(String value) {
            addCriterion("signin_begin_time <>", value, "signinBeginTime");
            return (Criteria) this;
        }

        public Criteria andSigninBeginTimeGreaterThan(String value) {
            addCriterion("signin_begin_time >", value, "signinBeginTime");
            return (Criteria) this;
        }

        public Criteria andSigninBeginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("signin_begin_time >=", value, "signinBeginTime");
            return (Criteria) this;
        }

        public Criteria andSigninBeginTimeLessThan(String value) {
            addCriterion("signin_begin_time <", value, "signinBeginTime");
            return (Criteria) this;
        }

        public Criteria andSigninBeginTimeLessThanOrEqualTo(String value) {
            addCriterion("signin_begin_time <=", value, "signinBeginTime");
            return (Criteria) this;
        }

        public Criteria andSigninBeginTimeLike(String value) {
            addCriterion("signin_begin_time like", value, "signinBeginTime");
            return (Criteria) this;
        }

        public Criteria andSigninBeginTimeNotLike(String value) {
            addCriterion("signin_begin_time not like", value, "signinBeginTime");
            return (Criteria) this;
        }

        public Criteria andSigninBeginTimeIn(List<String> values) {
            addCriterion("signin_begin_time in", values, "signinBeginTime");
            return (Criteria) this;
        }

        public Criteria andSigninBeginTimeNotIn(List<String> values) {
            addCriterion("signin_begin_time not in", values, "signinBeginTime");
            return (Criteria) this;
        }

        public Criteria andSigninBeginTimeBetween(String value1, String value2) {
            addCriterion("signin_begin_time between", value1, value2, "signinBeginTime");
            return (Criteria) this;
        }

        public Criteria andSigninBeginTimeNotBetween(String value1, String value2) {
            addCriterion("signin_begin_time not between", value1, value2, "signinBeginTime");
            return (Criteria) this;
        }

        public Criteria andSigninEndTimeIsNull() {
            addCriterion("signin_end_time is null");
            return (Criteria) this;
        }

        public Criteria andSigninEndTimeIsNotNull() {
            addCriterion("signin_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andSigninEndTimeEqualTo(String value) {
            addCriterion("signin_end_time =", value, "signinEndTime");
            return (Criteria) this;
        }

        public Criteria andSigninEndTimeNotEqualTo(String value) {
            addCriterion("signin_end_time <>", value, "signinEndTime");
            return (Criteria) this;
        }

        public Criteria andSigninEndTimeGreaterThan(String value) {
            addCriterion("signin_end_time >", value, "signinEndTime");
            return (Criteria) this;
        }

        public Criteria andSigninEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("signin_end_time >=", value, "signinEndTime");
            return (Criteria) this;
        }

        public Criteria andSigninEndTimeLessThan(String value) {
            addCriterion("signin_end_time <", value, "signinEndTime");
            return (Criteria) this;
        }

        public Criteria andSigninEndTimeLessThanOrEqualTo(String value) {
            addCriterion("signin_end_time <=", value, "signinEndTime");
            return (Criteria) this;
        }

        public Criteria andSigninEndTimeLike(String value) {
            addCriterion("signin_end_time like", value, "signinEndTime");
            return (Criteria) this;
        }

        public Criteria andSigninEndTimeNotLike(String value) {
            addCriterion("signin_end_time not like", value, "signinEndTime");
            return (Criteria) this;
        }

        public Criteria andSigninEndTimeIn(List<String> values) {
            addCriterion("signin_end_time in", values, "signinEndTime");
            return (Criteria) this;
        }

        public Criteria andSigninEndTimeNotIn(List<String> values) {
            addCriterion("signin_end_time not in", values, "signinEndTime");
            return (Criteria) this;
        }

        public Criteria andSigninEndTimeBetween(String value1, String value2) {
            addCriterion("signin_end_time between", value1, value2, "signinEndTime");
            return (Criteria) this;
        }

        public Criteria andSigninEndTimeNotBetween(String value1, String value2) {
            addCriterion("signin_end_time not between", value1, value2, "signinEndTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeIsNull() {
            addCriterion("signout_time is null");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeIsNotNull() {
            addCriterion("signout_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeEqualTo(String value) {
            addCriterion("signout_time =", value, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeNotEqualTo(String value) {
            addCriterion("signout_time <>", value, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeGreaterThan(String value) {
            addCriterion("signout_time >", value, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeGreaterThanOrEqualTo(String value) {
            addCriterion("signout_time >=", value, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeLessThan(String value) {
            addCriterion("signout_time <", value, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeLessThanOrEqualTo(String value) {
            addCriterion("signout_time <=", value, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeLike(String value) {
            addCriterion("signout_time like", value, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeNotLike(String value) {
            addCriterion("signout_time not like", value, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeIn(List<String> values) {
            addCriterion("signout_time in", values, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeNotIn(List<String> values) {
            addCriterion("signout_time not in", values, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeBetween(String value1, String value2) {
            addCriterion("signout_time between", value1, value2, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeNotBetween(String value1, String value2) {
            addCriterion("signout_time not between", value1, value2, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutBeginTimeIsNull() {
            addCriterion("signout_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andSignoutBeginTimeIsNotNull() {
            addCriterion("signout_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignoutBeginTimeEqualTo(String value) {
            addCriterion("signout_begin_time =", value, "signoutBeginTime");
            return (Criteria) this;
        }

        public Criteria andSignoutBeginTimeNotEqualTo(String value) {
            addCriterion("signout_begin_time <>", value, "signoutBeginTime");
            return (Criteria) this;
        }

        public Criteria andSignoutBeginTimeGreaterThan(String value) {
            addCriterion("signout_begin_time >", value, "signoutBeginTime");
            return (Criteria) this;
        }

        public Criteria andSignoutBeginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("signout_begin_time >=", value, "signoutBeginTime");
            return (Criteria) this;
        }

        public Criteria andSignoutBeginTimeLessThan(String value) {
            addCriterion("signout_begin_time <", value, "signoutBeginTime");
            return (Criteria) this;
        }

        public Criteria andSignoutBeginTimeLessThanOrEqualTo(String value) {
            addCriterion("signout_begin_time <=", value, "signoutBeginTime");
            return (Criteria) this;
        }

        public Criteria andSignoutBeginTimeLike(String value) {
            addCriterion("signout_begin_time like", value, "signoutBeginTime");
            return (Criteria) this;
        }

        public Criteria andSignoutBeginTimeNotLike(String value) {
            addCriterion("signout_begin_time not like", value, "signoutBeginTime");
            return (Criteria) this;
        }

        public Criteria andSignoutBeginTimeIn(List<String> values) {
            addCriterion("signout_begin_time in", values, "signoutBeginTime");
            return (Criteria) this;
        }

        public Criteria andSignoutBeginTimeNotIn(List<String> values) {
            addCriterion("signout_begin_time not in", values, "signoutBeginTime");
            return (Criteria) this;
        }

        public Criteria andSignoutBeginTimeBetween(String value1, String value2) {
            addCriterion("signout_begin_time between", value1, value2, "signoutBeginTime");
            return (Criteria) this;
        }

        public Criteria andSignoutBeginTimeNotBetween(String value1, String value2) {
            addCriterion("signout_begin_time not between", value1, value2, "signoutBeginTime");
            return (Criteria) this;
        }

        public Criteria andSignoutEndtimeIsNull() {
            addCriterion("signout_endtime is null");
            return (Criteria) this;
        }

        public Criteria andSignoutEndtimeIsNotNull() {
            addCriterion("signout_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andSignoutEndtimeEqualTo(String value) {
            addCriterion("signout_endtime =", value, "signoutEndtime");
            return (Criteria) this;
        }

        public Criteria andSignoutEndtimeNotEqualTo(String value) {
            addCriterion("signout_endtime <>", value, "signoutEndtime");
            return (Criteria) this;
        }

        public Criteria andSignoutEndtimeGreaterThan(String value) {
            addCriterion("signout_endtime >", value, "signoutEndtime");
            return (Criteria) this;
        }

        public Criteria andSignoutEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("signout_endtime >=", value, "signoutEndtime");
            return (Criteria) this;
        }

        public Criteria andSignoutEndtimeLessThan(String value) {
            addCriterion("signout_endtime <", value, "signoutEndtime");
            return (Criteria) this;
        }

        public Criteria andSignoutEndtimeLessThanOrEqualTo(String value) {
            addCriterion("signout_endtime <=", value, "signoutEndtime");
            return (Criteria) this;
        }

        public Criteria andSignoutEndtimeLike(String value) {
            addCriterion("signout_endtime like", value, "signoutEndtime");
            return (Criteria) this;
        }

        public Criteria andSignoutEndtimeNotLike(String value) {
            addCriterion("signout_endtime not like", value, "signoutEndtime");
            return (Criteria) this;
        }

        public Criteria andSignoutEndtimeIn(List<String> values) {
            addCriterion("signout_endtime in", values, "signoutEndtime");
            return (Criteria) this;
        }

        public Criteria andSignoutEndtimeNotIn(List<String> values) {
            addCriterion("signout_endtime not in", values, "signoutEndtime");
            return (Criteria) this;
        }

        public Criteria andSignoutEndtimeBetween(String value1, String value2) {
            addCriterion("signout_endtime between", value1, value2, "signoutEndtime");
            return (Criteria) this;
        }

        public Criteria andSignoutEndtimeNotBetween(String value1, String value2) {
            addCriterion("signout_endtime not between", value1, value2, "signoutEndtime");
            return (Criteria) this;
        }

        public Criteria andSignLocationIdsIsNull() {
            addCriterion("sign_location_ids is null");
            return (Criteria) this;
        }

        public Criteria andSignLocationIdsIsNotNull() {
            addCriterion("sign_location_ids is not null");
            return (Criteria) this;
        }

        public Criteria andSignLocationIdsEqualTo(String value) {
            addCriterion("sign_location_ids =", value, "signLocationIds");
            return (Criteria) this;
        }

        public Criteria andSignLocationIdsNotEqualTo(String value) {
            addCriterion("sign_location_ids <>", value, "signLocationIds");
            return (Criteria) this;
        }

        public Criteria andSignLocationIdsGreaterThan(String value) {
            addCriterion("sign_location_ids >", value, "signLocationIds");
            return (Criteria) this;
        }

        public Criteria andSignLocationIdsGreaterThanOrEqualTo(String value) {
            addCriterion("sign_location_ids >=", value, "signLocationIds");
            return (Criteria) this;
        }

        public Criteria andSignLocationIdsLessThan(String value) {
            addCriterion("sign_location_ids <", value, "signLocationIds");
            return (Criteria) this;
        }

        public Criteria andSignLocationIdsLessThanOrEqualTo(String value) {
            addCriterion("sign_location_ids <=", value, "signLocationIds");
            return (Criteria) this;
        }

        public Criteria andSignLocationIdsLike(String value) {
            addCriterion("sign_location_ids like", value, "signLocationIds");
            return (Criteria) this;
        }

        public Criteria andSignLocationIdsNotLike(String value) {
            addCriterion("sign_location_ids not like", value, "signLocationIds");
            return (Criteria) this;
        }

        public Criteria andSignLocationIdsIn(List<String> values) {
            addCriterion("sign_location_ids in", values, "signLocationIds");
            return (Criteria) this;
        }

        public Criteria andSignLocationIdsNotIn(List<String> values) {
            addCriterion("sign_location_ids not in", values, "signLocationIds");
            return (Criteria) this;
        }

        public Criteria andSignLocationIdsBetween(String value1, String value2) {
            addCriterion("sign_location_ids between", value1, value2, "signLocationIds");
            return (Criteria) this;
        }

        public Criteria andSignLocationIdsNotBetween(String value1, String value2) {
            addCriterion("sign_location_ids not between", value1, value2, "signLocationIds");
            return (Criteria) this;
        }

        public Criteria andUnattendDaysIsNull() {
            addCriterion("unattend_days is null");
            return (Criteria) this;
        }

        public Criteria andUnattendDaysIsNotNull() {
            addCriterion("unattend_days is not null");
            return (Criteria) this;
        }

        public Criteria andUnattendDaysEqualTo(String value) {
            addCriterion("unattend_days =", value, "unattendDays");
            return (Criteria) this;
        }

        public Criteria andUnattendDaysNotEqualTo(String value) {
            addCriterion("unattend_days <>", value, "unattendDays");
            return (Criteria) this;
        }

        public Criteria andUnattendDaysGreaterThan(String value) {
            addCriterion("unattend_days >", value, "unattendDays");
            return (Criteria) this;
        }

        public Criteria andUnattendDaysGreaterThanOrEqualTo(String value) {
            addCriterion("unattend_days >=", value, "unattendDays");
            return (Criteria) this;
        }

        public Criteria andUnattendDaysLessThan(String value) {
            addCriterion("unattend_days <", value, "unattendDays");
            return (Criteria) this;
        }

        public Criteria andUnattendDaysLessThanOrEqualTo(String value) {
            addCriterion("unattend_days <=", value, "unattendDays");
            return (Criteria) this;
        }

        public Criteria andUnattendDaysLike(String value) {
            addCriterion("unattend_days like", value, "unattendDays");
            return (Criteria) this;
        }

        public Criteria andUnattendDaysNotLike(String value) {
            addCriterion("unattend_days not like", value, "unattendDays");
            return (Criteria) this;
        }

        public Criteria andUnattendDaysIn(List<String> values) {
            addCriterion("unattend_days in", values, "unattendDays");
            return (Criteria) this;
        }

        public Criteria andUnattendDaysNotIn(List<String> values) {
            addCriterion("unattend_days not in", values, "unattendDays");
            return (Criteria) this;
        }

        public Criteria andUnattendDaysBetween(String value1, String value2) {
            addCriterion("unattend_days between", value1, value2, "unattendDays");
            return (Criteria) this;
        }

        public Criteria andUnattendDaysNotBetween(String value1, String value2) {
            addCriterion("unattend_days not between", value1, value2, "unattendDays");
            return (Criteria) this;
        }

        public Criteria andViewEmployeeIdsIsNull() {
            addCriterion("view_employee_ids is null");
            return (Criteria) this;
        }

        public Criteria andViewEmployeeIdsIsNotNull() {
            addCriterion("view_employee_ids is not null");
            return (Criteria) this;
        }

        public Criteria andViewEmployeeIdsEqualTo(String value) {
            addCriterion("view_employee_ids =", value, "viewEmployeeIds");
            return (Criteria) this;
        }

        public Criteria andViewEmployeeIdsNotEqualTo(String value) {
            addCriterion("view_employee_ids <>", value, "viewEmployeeIds");
            return (Criteria) this;
        }

        public Criteria andViewEmployeeIdsGreaterThan(String value) {
            addCriterion("view_employee_ids >", value, "viewEmployeeIds");
            return (Criteria) this;
        }

        public Criteria andViewEmployeeIdsGreaterThanOrEqualTo(String value) {
            addCriterion("view_employee_ids >=", value, "viewEmployeeIds");
            return (Criteria) this;
        }

        public Criteria andViewEmployeeIdsLessThan(String value) {
            addCriterion("view_employee_ids <", value, "viewEmployeeIds");
            return (Criteria) this;
        }

        public Criteria andViewEmployeeIdsLessThanOrEqualTo(String value) {
            addCriterion("view_employee_ids <=", value, "viewEmployeeIds");
            return (Criteria) this;
        }

        public Criteria andViewEmployeeIdsLike(String value) {
            addCriterion("view_employee_ids like", value, "viewEmployeeIds");
            return (Criteria) this;
        }

        public Criteria andViewEmployeeIdsNotLike(String value) {
            addCriterion("view_employee_ids not like", value, "viewEmployeeIds");
            return (Criteria) this;
        }

        public Criteria andViewEmployeeIdsIn(List<String> values) {
            addCriterion("view_employee_ids in", values, "viewEmployeeIds");
            return (Criteria) this;
        }

        public Criteria andViewEmployeeIdsNotIn(List<String> values) {
            addCriterion("view_employee_ids not in", values, "viewEmployeeIds");
            return (Criteria) this;
        }

        public Criteria andViewEmployeeIdsBetween(String value1, String value2) {
            addCriterion("view_employee_ids between", value1, value2, "viewEmployeeIds");
            return (Criteria) this;
        }

        public Criteria andViewEmployeeIdsNotBetween(String value1, String value2) {
            addCriterion("view_employee_ids not between", value1, value2, "viewEmployeeIds");
            return (Criteria) this;
        }

        public Criteria andIsMondayIsNull() {
            addCriterion("is_monday is null");
            return (Criteria) this;
        }

        public Criteria andIsMondayIsNotNull() {
            addCriterion("is_monday is not null");
            return (Criteria) this;
        }

        public Criteria andIsMondayEqualTo(Integer value) {
            addCriterion("is_monday =", value, "isMonday");
            return (Criteria) this;
        }

        public Criteria andIsMondayNotEqualTo(Integer value) {
            addCriterion("is_monday <>", value, "isMonday");
            return (Criteria) this;
        }

        public Criteria andIsMondayGreaterThan(Integer value) {
            addCriterion("is_monday >", value, "isMonday");
            return (Criteria) this;
        }

        public Criteria andIsMondayGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_monday >=", value, "isMonday");
            return (Criteria) this;
        }

        public Criteria andIsMondayLessThan(Integer value) {
            addCriterion("is_monday <", value, "isMonday");
            return (Criteria) this;
        }

        public Criteria andIsMondayLessThanOrEqualTo(Integer value) {
            addCriterion("is_monday <=", value, "isMonday");
            return (Criteria) this;
        }

        public Criteria andIsMondayIn(List<Integer> values) {
            addCriterion("is_monday in", values, "isMonday");
            return (Criteria) this;
        }

        public Criteria andIsMondayNotIn(List<Integer> values) {
            addCriterion("is_monday not in", values, "isMonday");
            return (Criteria) this;
        }

        public Criteria andIsMondayBetween(Integer value1, Integer value2) {
            addCriterion("is_monday between", value1, value2, "isMonday");
            return (Criteria) this;
        }

        public Criteria andIsMondayNotBetween(Integer value1, Integer value2) {
            addCriterion("is_monday not between", value1, value2, "isMonday");
            return (Criteria) this;
        }

        public Criteria andIsTuesdanyIsNull() {
            addCriterion("is_tuesdany is null");
            return (Criteria) this;
        }

        public Criteria andIsTuesdanyIsNotNull() {
            addCriterion("is_tuesdany is not null");
            return (Criteria) this;
        }

        public Criteria andIsTuesdanyEqualTo(Integer value) {
            addCriterion("is_tuesdany =", value, "isTuesdany");
            return (Criteria) this;
        }

        public Criteria andIsTuesdanyNotEqualTo(Integer value) {
            addCriterion("is_tuesdany <>", value, "isTuesdany");
            return (Criteria) this;
        }

        public Criteria andIsTuesdanyGreaterThan(Integer value) {
            addCriterion("is_tuesdany >", value, "isTuesdany");
            return (Criteria) this;
        }

        public Criteria andIsTuesdanyGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_tuesdany >=", value, "isTuesdany");
            return (Criteria) this;
        }

        public Criteria andIsTuesdanyLessThan(Integer value) {
            addCriterion("is_tuesdany <", value, "isTuesdany");
            return (Criteria) this;
        }

        public Criteria andIsTuesdanyLessThanOrEqualTo(Integer value) {
            addCriterion("is_tuesdany <=", value, "isTuesdany");
            return (Criteria) this;
        }

        public Criteria andIsTuesdanyIn(List<Integer> values) {
            addCriterion("is_tuesdany in", values, "isTuesdany");
            return (Criteria) this;
        }

        public Criteria andIsTuesdanyNotIn(List<Integer> values) {
            addCriterion("is_tuesdany not in", values, "isTuesdany");
            return (Criteria) this;
        }

        public Criteria andIsTuesdanyBetween(Integer value1, Integer value2) {
            addCriterion("is_tuesdany between", value1, value2, "isTuesdany");
            return (Criteria) this;
        }

        public Criteria andIsTuesdanyNotBetween(Integer value1, Integer value2) {
            addCriterion("is_tuesdany not between", value1, value2, "isTuesdany");
            return (Criteria) this;
        }

        public Criteria andIsWednesdayIsNull() {
            addCriterion("is_wednesday is null");
            return (Criteria) this;
        }

        public Criteria andIsWednesdayIsNotNull() {
            addCriterion("is_wednesday is not null");
            return (Criteria) this;
        }

        public Criteria andIsWednesdayEqualTo(Integer value) {
            addCriterion("is_wednesday =", value, "isWednesday");
            return (Criteria) this;
        }

        public Criteria andIsWednesdayNotEqualTo(Integer value) {
            addCriterion("is_wednesday <>", value, "isWednesday");
            return (Criteria) this;
        }

        public Criteria andIsWednesdayGreaterThan(Integer value) {
            addCriterion("is_wednesday >", value, "isWednesday");
            return (Criteria) this;
        }

        public Criteria andIsWednesdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_wednesday >=", value, "isWednesday");
            return (Criteria) this;
        }

        public Criteria andIsWednesdayLessThan(Integer value) {
            addCriterion("is_wednesday <", value, "isWednesday");
            return (Criteria) this;
        }

        public Criteria andIsWednesdayLessThanOrEqualTo(Integer value) {
            addCriterion("is_wednesday <=", value, "isWednesday");
            return (Criteria) this;
        }

        public Criteria andIsWednesdayIn(List<Integer> values) {
            addCriterion("is_wednesday in", values, "isWednesday");
            return (Criteria) this;
        }

        public Criteria andIsWednesdayNotIn(List<Integer> values) {
            addCriterion("is_wednesday not in", values, "isWednesday");
            return (Criteria) this;
        }

        public Criteria andIsWednesdayBetween(Integer value1, Integer value2) {
            addCriterion("is_wednesday between", value1, value2, "isWednesday");
            return (Criteria) this;
        }

        public Criteria andIsWednesdayNotBetween(Integer value1, Integer value2) {
            addCriterion("is_wednesday not between", value1, value2, "isWednesday");
            return (Criteria) this;
        }

        public Criteria andIsThursdayIsNull() {
            addCriterion("is_thursday is null");
            return (Criteria) this;
        }

        public Criteria andIsThursdayIsNotNull() {
            addCriterion("is_thursday is not null");
            return (Criteria) this;
        }

        public Criteria andIsThursdayEqualTo(Integer value) {
            addCriterion("is_thursday =", value, "isThursday");
            return (Criteria) this;
        }

        public Criteria andIsThursdayNotEqualTo(Integer value) {
            addCriterion("is_thursday <>", value, "isThursday");
            return (Criteria) this;
        }

        public Criteria andIsThursdayGreaterThan(Integer value) {
            addCriterion("is_thursday >", value, "isThursday");
            return (Criteria) this;
        }

        public Criteria andIsThursdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_thursday >=", value, "isThursday");
            return (Criteria) this;
        }

        public Criteria andIsThursdayLessThan(Integer value) {
            addCriterion("is_thursday <", value, "isThursday");
            return (Criteria) this;
        }

        public Criteria andIsThursdayLessThanOrEqualTo(Integer value) {
            addCriterion("is_thursday <=", value, "isThursday");
            return (Criteria) this;
        }

        public Criteria andIsThursdayIn(List<Integer> values) {
            addCriterion("is_thursday in", values, "isThursday");
            return (Criteria) this;
        }

        public Criteria andIsThursdayNotIn(List<Integer> values) {
            addCriterion("is_thursday not in", values, "isThursday");
            return (Criteria) this;
        }

        public Criteria andIsThursdayBetween(Integer value1, Integer value2) {
            addCriterion("is_thursday between", value1, value2, "isThursday");
            return (Criteria) this;
        }

        public Criteria andIsThursdayNotBetween(Integer value1, Integer value2) {
            addCriterion("is_thursday not between", value1, value2, "isThursday");
            return (Criteria) this;
        }

        public Criteria andIsFridayIsNull() {
            addCriterion("is_friday is null");
            return (Criteria) this;
        }

        public Criteria andIsFridayIsNotNull() {
            addCriterion("is_friday is not null");
            return (Criteria) this;
        }

        public Criteria andIsFridayEqualTo(Integer value) {
            addCriterion("is_friday =", value, "isFriday");
            return (Criteria) this;
        }

        public Criteria andIsFridayNotEqualTo(Integer value) {
            addCriterion("is_friday <>", value, "isFriday");
            return (Criteria) this;
        }

        public Criteria andIsFridayGreaterThan(Integer value) {
            addCriterion("is_friday >", value, "isFriday");
            return (Criteria) this;
        }

        public Criteria andIsFridayGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_friday >=", value, "isFriday");
            return (Criteria) this;
        }

        public Criteria andIsFridayLessThan(Integer value) {
            addCriterion("is_friday <", value, "isFriday");
            return (Criteria) this;
        }

        public Criteria andIsFridayLessThanOrEqualTo(Integer value) {
            addCriterion("is_friday <=", value, "isFriday");
            return (Criteria) this;
        }

        public Criteria andIsFridayIn(List<Integer> values) {
            addCriterion("is_friday in", values, "isFriday");
            return (Criteria) this;
        }

        public Criteria andIsFridayNotIn(List<Integer> values) {
            addCriterion("is_friday not in", values, "isFriday");
            return (Criteria) this;
        }

        public Criteria andIsFridayBetween(Integer value1, Integer value2) {
            addCriterion("is_friday between", value1, value2, "isFriday");
            return (Criteria) this;
        }

        public Criteria andIsFridayNotBetween(Integer value1, Integer value2) {
            addCriterion("is_friday not between", value1, value2, "isFriday");
            return (Criteria) this;
        }

        public Criteria andIsSaturdayIsNull() {
            addCriterion("is_saturday is null");
            return (Criteria) this;
        }

        public Criteria andIsSaturdayIsNotNull() {
            addCriterion("is_saturday is not null");
            return (Criteria) this;
        }

        public Criteria andIsSaturdayEqualTo(Integer value) {
            addCriterion("is_saturday =", value, "isSaturday");
            return (Criteria) this;
        }

        public Criteria andIsSaturdayNotEqualTo(Integer value) {
            addCriterion("is_saturday <>", value, "isSaturday");
            return (Criteria) this;
        }

        public Criteria andIsSaturdayGreaterThan(Integer value) {
            addCriterion("is_saturday >", value, "isSaturday");
            return (Criteria) this;
        }

        public Criteria andIsSaturdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_saturday >=", value, "isSaturday");
            return (Criteria) this;
        }

        public Criteria andIsSaturdayLessThan(Integer value) {
            addCriterion("is_saturday <", value, "isSaturday");
            return (Criteria) this;
        }

        public Criteria andIsSaturdayLessThanOrEqualTo(Integer value) {
            addCriterion("is_saturday <=", value, "isSaturday");
            return (Criteria) this;
        }

        public Criteria andIsSaturdayIn(List<Integer> values) {
            addCriterion("is_saturday in", values, "isSaturday");
            return (Criteria) this;
        }

        public Criteria andIsSaturdayNotIn(List<Integer> values) {
            addCriterion("is_saturday not in", values, "isSaturday");
            return (Criteria) this;
        }

        public Criteria andIsSaturdayBetween(Integer value1, Integer value2) {
            addCriterion("is_saturday between", value1, value2, "isSaturday");
            return (Criteria) this;
        }

        public Criteria andIsSaturdayNotBetween(Integer value1, Integer value2) {
            addCriterion("is_saturday not between", value1, value2, "isSaturday");
            return (Criteria) this;
        }

        public Criteria andIsSundayIsNull() {
            addCriterion("is_sunday is null");
            return (Criteria) this;
        }

        public Criteria andIsSundayIsNotNull() {
            addCriterion("is_sunday is not null");
            return (Criteria) this;
        }

        public Criteria andIsSundayEqualTo(Integer value) {
            addCriterion("is_sunday =", value, "isSunday");
            return (Criteria) this;
        }

        public Criteria andIsSundayNotEqualTo(Integer value) {
            addCriterion("is_sunday <>", value, "isSunday");
            return (Criteria) this;
        }

        public Criteria andIsSundayGreaterThan(Integer value) {
            addCriterion("is_sunday >", value, "isSunday");
            return (Criteria) this;
        }

        public Criteria andIsSundayGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_sunday >=", value, "isSunday");
            return (Criteria) this;
        }

        public Criteria andIsSundayLessThan(Integer value) {
            addCriterion("is_sunday <", value, "isSunday");
            return (Criteria) this;
        }

        public Criteria andIsSundayLessThanOrEqualTo(Integer value) {
            addCriterion("is_sunday <=", value, "isSunday");
            return (Criteria) this;
        }

        public Criteria andIsSundayIn(List<Integer> values) {
            addCriterion("is_sunday in", values, "isSunday");
            return (Criteria) this;
        }

        public Criteria andIsSundayNotIn(List<Integer> values) {
            addCriterion("is_sunday not in", values, "isSunday");
            return (Criteria) this;
        }

        public Criteria andIsSundayBetween(Integer value1, Integer value2) {
            addCriterion("is_sunday between", value1, value2, "isSunday");
            return (Criteria) this;
        }

        public Criteria andIsSundayNotBetween(Integer value1, Integer value2) {
            addCriterion("is_sunday not between", value1, value2, "isSunday");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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