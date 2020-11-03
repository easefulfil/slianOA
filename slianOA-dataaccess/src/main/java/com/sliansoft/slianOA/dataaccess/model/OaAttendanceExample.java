package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaAttendanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaAttendanceExample() {
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

    public OaAttendanceExample(int pageSize, int pageIndex) {
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

        public Criteria andAttendanceIdIsNull() {
            addCriterion("attendance_id is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceIdIsNotNull() {
            addCriterion("attendance_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceIdEqualTo(Integer value) {
            addCriterion("attendance_id =", value, "attendanceId");
            return (Criteria) this;
        }

        public Criteria andAttendanceIdNotEqualTo(Integer value) {
            addCriterion("attendance_id <>", value, "attendanceId");
            return (Criteria) this;
        }

        public Criteria andAttendanceIdGreaterThan(Integer value) {
            addCriterion("attendance_id >", value, "attendanceId");
            return (Criteria) this;
        }

        public Criteria andAttendanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attendance_id >=", value, "attendanceId");
            return (Criteria) this;
        }

        public Criteria andAttendanceIdLessThan(Integer value) {
            addCriterion("attendance_id <", value, "attendanceId");
            return (Criteria) this;
        }

        public Criteria andAttendanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("attendance_id <=", value, "attendanceId");
            return (Criteria) this;
        }

        public Criteria andAttendanceIdIn(List<Integer> values) {
            addCriterion("attendance_id in", values, "attendanceId");
            return (Criteria) this;
        }

        public Criteria andAttendanceIdNotIn(List<Integer> values) {
            addCriterion("attendance_id not in", values, "attendanceId");
            return (Criteria) this;
        }

        public Criteria andAttendanceIdBetween(Integer value1, Integer value2) {
            addCriterion("attendance_id between", value1, value2, "attendanceId");
            return (Criteria) this;
        }

        public Criteria andAttendanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attendance_id not between", value1, value2, "attendanceId");
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

        public Criteria andSignDateIsNull() {
            addCriterion("sign_date is null");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNotNull() {
            addCriterion("sign_date is not null");
            return (Criteria) this;
        }

        public Criteria andSignDateEqualTo(Date value) {
            addCriterion("sign_date =", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotEqualTo(Date value) {
            addCriterion("sign_date <>", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThan(Date value) {
            addCriterion("sign_date >", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_date >=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThan(Date value) {
            addCriterion("sign_date <", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThanOrEqualTo(Date value) {
            addCriterion("sign_date <=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateIn(List<Date> values) {
            addCriterion("sign_date in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotIn(List<Date> values) {
            addCriterion("sign_date not in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateBetween(Date value1, Date value2) {
            addCriterion("sign_date between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotBetween(Date value1, Date value2) {
            addCriterion("sign_date not between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andSigninAddressIsNull() {
            addCriterion("signin_address is null");
            return (Criteria) this;
        }

        public Criteria andSigninAddressIsNotNull() {
            addCriterion("signin_address is not null");
            return (Criteria) this;
        }

        public Criteria andSigninAddressEqualTo(String value) {
            addCriterion("signin_address =", value, "signinAddress");
            return (Criteria) this;
        }

        public Criteria andSigninAddressNotEqualTo(String value) {
            addCriterion("signin_address <>", value, "signinAddress");
            return (Criteria) this;
        }

        public Criteria andSigninAddressGreaterThan(String value) {
            addCriterion("signin_address >", value, "signinAddress");
            return (Criteria) this;
        }

        public Criteria andSigninAddressGreaterThanOrEqualTo(String value) {
            addCriterion("signin_address >=", value, "signinAddress");
            return (Criteria) this;
        }

        public Criteria andSigninAddressLessThan(String value) {
            addCriterion("signin_address <", value, "signinAddress");
            return (Criteria) this;
        }

        public Criteria andSigninAddressLessThanOrEqualTo(String value) {
            addCriterion("signin_address <=", value, "signinAddress");
            return (Criteria) this;
        }

        public Criteria andSigninAddressLike(String value) {
            addCriterion("signin_address like", value, "signinAddress");
            return (Criteria) this;
        }

        public Criteria andSigninAddressNotLike(String value) {
            addCriterion("signin_address not like", value, "signinAddress");
            return (Criteria) this;
        }

        public Criteria andSigninAddressIn(List<String> values) {
            addCriterion("signin_address in", values, "signinAddress");
            return (Criteria) this;
        }

        public Criteria andSigninAddressNotIn(List<String> values) {
            addCriterion("signin_address not in", values, "signinAddress");
            return (Criteria) this;
        }

        public Criteria andSigninAddressBetween(String value1, String value2) {
            addCriterion("signin_address between", value1, value2, "signinAddress");
            return (Criteria) this;
        }

        public Criteria andSigninAddressNotBetween(String value1, String value2) {
            addCriterion("signin_address not between", value1, value2, "signinAddress");
            return (Criteria) this;
        }

        public Criteria andSigninLatitudeIsNull() {
            addCriterion("signin_latitude is null");
            return (Criteria) this;
        }

        public Criteria andSigninLatitudeIsNotNull() {
            addCriterion("signin_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andSigninLatitudeEqualTo(Double value) {
            addCriterion("signin_latitude =", value, "signinLatitude");
            return (Criteria) this;
        }

        public Criteria andSigninLatitudeNotEqualTo(Double value) {
            addCriterion("signin_latitude <>", value, "signinLatitude");
            return (Criteria) this;
        }

        public Criteria andSigninLatitudeGreaterThan(Double value) {
            addCriterion("signin_latitude >", value, "signinLatitude");
            return (Criteria) this;
        }

        public Criteria andSigninLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("signin_latitude >=", value, "signinLatitude");
            return (Criteria) this;
        }

        public Criteria andSigninLatitudeLessThan(Double value) {
            addCriterion("signin_latitude <", value, "signinLatitude");
            return (Criteria) this;
        }

        public Criteria andSigninLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("signin_latitude <=", value, "signinLatitude");
            return (Criteria) this;
        }

        public Criteria andSigninLatitudeIn(List<Double> values) {
            addCriterion("signin_latitude in", values, "signinLatitude");
            return (Criteria) this;
        }

        public Criteria andSigninLatitudeNotIn(List<Double> values) {
            addCriterion("signin_latitude not in", values, "signinLatitude");
            return (Criteria) this;
        }

        public Criteria andSigninLatitudeBetween(Double value1, Double value2) {
            addCriterion("signin_latitude between", value1, value2, "signinLatitude");
            return (Criteria) this;
        }

        public Criteria andSigninLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("signin_latitude not between", value1, value2, "signinLatitude");
            return (Criteria) this;
        }

        public Criteria andSigninLongitudeIsNull() {
            addCriterion("signin_longitude is null");
            return (Criteria) this;
        }

        public Criteria andSigninLongitudeIsNotNull() {
            addCriterion("signin_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andSigninLongitudeEqualTo(Double value) {
            addCriterion("signin_longitude =", value, "signinLongitude");
            return (Criteria) this;
        }

        public Criteria andSigninLongitudeNotEqualTo(Double value) {
            addCriterion("signin_longitude <>", value, "signinLongitude");
            return (Criteria) this;
        }

        public Criteria andSigninLongitudeGreaterThan(Double value) {
            addCriterion("signin_longitude >", value, "signinLongitude");
            return (Criteria) this;
        }

        public Criteria andSigninLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("signin_longitude >=", value, "signinLongitude");
            return (Criteria) this;
        }

        public Criteria andSigninLongitudeLessThan(Double value) {
            addCriterion("signin_longitude <", value, "signinLongitude");
            return (Criteria) this;
        }

        public Criteria andSigninLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("signin_longitude <=", value, "signinLongitude");
            return (Criteria) this;
        }

        public Criteria andSigninLongitudeIn(List<Double> values) {
            addCriterion("signin_longitude in", values, "signinLongitude");
            return (Criteria) this;
        }

        public Criteria andSigninLongitudeNotIn(List<Double> values) {
            addCriterion("signin_longitude not in", values, "signinLongitude");
            return (Criteria) this;
        }

        public Criteria andSigninLongitudeBetween(Double value1, Double value2) {
            addCriterion("signin_longitude between", value1, value2, "signinLongitude");
            return (Criteria) this;
        }

        public Criteria andSigninLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("signin_longitude not between", value1, value2, "signinLongitude");
            return (Criteria) this;
        }

        public Criteria andSigninStatusIsNull() {
            addCriterion("signin_status is null");
            return (Criteria) this;
        }

        public Criteria andSigninStatusIsNotNull() {
            addCriterion("signin_status is not null");
            return (Criteria) this;
        }

        public Criteria andSigninStatusEqualTo(String value) {
            addCriterion("signin_status =", value, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusNotEqualTo(String value) {
            addCriterion("signin_status <>", value, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusGreaterThan(String value) {
            addCriterion("signin_status >", value, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusGreaterThanOrEqualTo(String value) {
            addCriterion("signin_status >=", value, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusLessThan(String value) {
            addCriterion("signin_status <", value, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusLessThanOrEqualTo(String value) {
            addCriterion("signin_status <=", value, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusLike(String value) {
            addCriterion("signin_status like", value, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusNotLike(String value) {
            addCriterion("signin_status not like", value, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusIn(List<String> values) {
            addCriterion("signin_status in", values, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusNotIn(List<String> values) {
            addCriterion("signin_status not in", values, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusBetween(String value1, String value2) {
            addCriterion("signin_status between", value1, value2, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusNotBetween(String value1, String value2) {
            addCriterion("signin_status not between", value1, value2, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninRemarkIsNull() {
            addCriterion("signin_remark is null");
            return (Criteria) this;
        }

        public Criteria andSigninRemarkIsNotNull() {
            addCriterion("signin_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSigninRemarkEqualTo(String value) {
            addCriterion("signin_remark =", value, "signinRemark");
            return (Criteria) this;
        }

        public Criteria andSigninRemarkNotEqualTo(String value) {
            addCriterion("signin_remark <>", value, "signinRemark");
            return (Criteria) this;
        }

        public Criteria andSigninRemarkGreaterThan(String value) {
            addCriterion("signin_remark >", value, "signinRemark");
            return (Criteria) this;
        }

        public Criteria andSigninRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("signin_remark >=", value, "signinRemark");
            return (Criteria) this;
        }

        public Criteria andSigninRemarkLessThan(String value) {
            addCriterion("signin_remark <", value, "signinRemark");
            return (Criteria) this;
        }

        public Criteria andSigninRemarkLessThanOrEqualTo(String value) {
            addCriterion("signin_remark <=", value, "signinRemark");
            return (Criteria) this;
        }

        public Criteria andSigninRemarkLike(String value) {
            addCriterion("signin_remark like", value, "signinRemark");
            return (Criteria) this;
        }

        public Criteria andSigninRemarkNotLike(String value) {
            addCriterion("signin_remark not like", value, "signinRemark");
            return (Criteria) this;
        }

        public Criteria andSigninRemarkIn(List<String> values) {
            addCriterion("signin_remark in", values, "signinRemark");
            return (Criteria) this;
        }

        public Criteria andSigninRemarkNotIn(List<String> values) {
            addCriterion("signin_remark not in", values, "signinRemark");
            return (Criteria) this;
        }

        public Criteria andSigninRemarkBetween(String value1, String value2) {
            addCriterion("signin_remark between", value1, value2, "signinRemark");
            return (Criteria) this;
        }

        public Criteria andSigninRemarkNotBetween(String value1, String value2) {
            addCriterion("signin_remark not between", value1, value2, "signinRemark");
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

        public Criteria andSigninTimeEqualTo(Date value) {
            addCriterion("signin_time =", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotEqualTo(Date value) {
            addCriterion("signin_time <>", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeGreaterThan(Date value) {
            addCriterion("signin_time >", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("signin_time >=", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeLessThan(Date value) {
            addCriterion("signin_time <", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeLessThanOrEqualTo(Date value) {
            addCriterion("signin_time <=", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIn(List<Date> values) {
            addCriterion("signin_time in", values, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotIn(List<Date> values) {
            addCriterion("signin_time not in", values, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeBetween(Date value1, Date value2) {
            addCriterion("signin_time between", value1, value2, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotBetween(Date value1, Date value2) {
            addCriterion("signin_time not between", value1, value2, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSignoutAddressIsNull() {
            addCriterion("signout_address is null");
            return (Criteria) this;
        }

        public Criteria andSignoutAddressIsNotNull() {
            addCriterion("signout_address is not null");
            return (Criteria) this;
        }

        public Criteria andSignoutAddressEqualTo(String value) {
            addCriterion("signout_address =", value, "signoutAddress");
            return (Criteria) this;
        }

        public Criteria andSignoutAddressNotEqualTo(String value) {
            addCriterion("signout_address <>", value, "signoutAddress");
            return (Criteria) this;
        }

        public Criteria andSignoutAddressGreaterThan(String value) {
            addCriterion("signout_address >", value, "signoutAddress");
            return (Criteria) this;
        }

        public Criteria andSignoutAddressGreaterThanOrEqualTo(String value) {
            addCriterion("signout_address >=", value, "signoutAddress");
            return (Criteria) this;
        }

        public Criteria andSignoutAddressLessThan(String value) {
            addCriterion("signout_address <", value, "signoutAddress");
            return (Criteria) this;
        }

        public Criteria andSignoutAddressLessThanOrEqualTo(String value) {
            addCriterion("signout_address <=", value, "signoutAddress");
            return (Criteria) this;
        }

        public Criteria andSignoutAddressLike(String value) {
            addCriterion("signout_address like", value, "signoutAddress");
            return (Criteria) this;
        }

        public Criteria andSignoutAddressNotLike(String value) {
            addCriterion("signout_address not like", value, "signoutAddress");
            return (Criteria) this;
        }

        public Criteria andSignoutAddressIn(List<String> values) {
            addCriterion("signout_address in", values, "signoutAddress");
            return (Criteria) this;
        }

        public Criteria andSignoutAddressNotIn(List<String> values) {
            addCriterion("signout_address not in", values, "signoutAddress");
            return (Criteria) this;
        }

        public Criteria andSignoutAddressBetween(String value1, String value2) {
            addCriterion("signout_address between", value1, value2, "signoutAddress");
            return (Criteria) this;
        }

        public Criteria andSignoutAddressNotBetween(String value1, String value2) {
            addCriterion("signout_address not between", value1, value2, "signoutAddress");
            return (Criteria) this;
        }

        public Criteria andSignoutLatitudeIsNull() {
            addCriterion("signout_latitude is null");
            return (Criteria) this;
        }

        public Criteria andSignoutLatitudeIsNotNull() {
            addCriterion("signout_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andSignoutLatitudeEqualTo(Double value) {
            addCriterion("signout_latitude =", value, "signoutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLatitudeNotEqualTo(Double value) {
            addCriterion("signout_latitude <>", value, "signoutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLatitudeGreaterThan(Double value) {
            addCriterion("signout_latitude >", value, "signoutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("signout_latitude >=", value, "signoutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLatitudeLessThan(Double value) {
            addCriterion("signout_latitude <", value, "signoutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("signout_latitude <=", value, "signoutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLatitudeIn(List<Double> values) {
            addCriterion("signout_latitude in", values, "signoutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLatitudeNotIn(List<Double> values) {
            addCriterion("signout_latitude not in", values, "signoutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLatitudeBetween(Double value1, Double value2) {
            addCriterion("signout_latitude between", value1, value2, "signoutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("signout_latitude not between", value1, value2, "signoutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLongitudeIsNull() {
            addCriterion("signout_longitude is null");
            return (Criteria) this;
        }

        public Criteria andSignoutLongitudeIsNotNull() {
            addCriterion("signout_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andSignoutLongitudeEqualTo(Double value) {
            addCriterion("signout_longitude =", value, "signoutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLongitudeNotEqualTo(Double value) {
            addCriterion("signout_longitude <>", value, "signoutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLongitudeGreaterThan(Double value) {
            addCriterion("signout_longitude >", value, "signoutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("signout_longitude >=", value, "signoutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLongitudeLessThan(Double value) {
            addCriterion("signout_longitude <", value, "signoutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("signout_longitude <=", value, "signoutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLongitudeIn(List<Double> values) {
            addCriterion("signout_longitude in", values, "signoutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLongitudeNotIn(List<Double> values) {
            addCriterion("signout_longitude not in", values, "signoutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLongitudeBetween(Double value1, Double value2) {
            addCriterion("signout_longitude between", value1, value2, "signoutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignoutLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("signout_longitude not between", value1, value2, "signoutLongitude");
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

        public Criteria andSignoutTimeEqualTo(Date value) {
            addCriterion("signout_time =", value, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeNotEqualTo(Date value) {
            addCriterion("signout_time <>", value, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeGreaterThan(Date value) {
            addCriterion("signout_time >", value, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("signout_time >=", value, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeLessThan(Date value) {
            addCriterion("signout_time <", value, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeLessThanOrEqualTo(Date value) {
            addCriterion("signout_time <=", value, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeIn(List<Date> values) {
            addCriterion("signout_time in", values, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeNotIn(List<Date> values) {
            addCriterion("signout_time not in", values, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeBetween(Date value1, Date value2) {
            addCriterion("signout_time between", value1, value2, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutTimeNotBetween(Date value1, Date value2) {
            addCriterion("signout_time not between", value1, value2, "signoutTime");
            return (Criteria) this;
        }

        public Criteria andSignoutStatusIsNull() {
            addCriterion("signout_status is null");
            return (Criteria) this;
        }

        public Criteria andSignoutStatusIsNotNull() {
            addCriterion("signout_status is not null");
            return (Criteria) this;
        }

        public Criteria andSignoutStatusEqualTo(String value) {
            addCriterion("signout_status =", value, "signoutStatus");
            return (Criteria) this;
        }

        public Criteria andSignoutStatusNotEqualTo(String value) {
            addCriterion("signout_status <>", value, "signoutStatus");
            return (Criteria) this;
        }

        public Criteria andSignoutStatusGreaterThan(String value) {
            addCriterion("signout_status >", value, "signoutStatus");
            return (Criteria) this;
        }

        public Criteria andSignoutStatusGreaterThanOrEqualTo(String value) {
            addCriterion("signout_status >=", value, "signoutStatus");
            return (Criteria) this;
        }

        public Criteria andSignoutStatusLessThan(String value) {
            addCriterion("signout_status <", value, "signoutStatus");
            return (Criteria) this;
        }

        public Criteria andSignoutStatusLessThanOrEqualTo(String value) {
            addCriterion("signout_status <=", value, "signoutStatus");
            return (Criteria) this;
        }

        public Criteria andSignoutStatusLike(String value) {
            addCriterion("signout_status like", value, "signoutStatus");
            return (Criteria) this;
        }

        public Criteria andSignoutStatusNotLike(String value) {
            addCriterion("signout_status not like", value, "signoutStatus");
            return (Criteria) this;
        }

        public Criteria andSignoutStatusIn(List<String> values) {
            addCriterion("signout_status in", values, "signoutStatus");
            return (Criteria) this;
        }

        public Criteria andSignoutStatusNotIn(List<String> values) {
            addCriterion("signout_status not in", values, "signoutStatus");
            return (Criteria) this;
        }

        public Criteria andSignoutStatusBetween(String value1, String value2) {
            addCriterion("signout_status between", value1, value2, "signoutStatus");
            return (Criteria) this;
        }

        public Criteria andSignoutStatusNotBetween(String value1, String value2) {
            addCriterion("signout_status not between", value1, value2, "signoutStatus");
            return (Criteria) this;
        }

        public Criteria andSignoutRemarkIsNull() {
            addCriterion("signout_remark is null");
            return (Criteria) this;
        }

        public Criteria andSignoutRemarkIsNotNull() {
            addCriterion("signout_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSignoutRemarkEqualTo(String value) {
            addCriterion("signout_remark =", value, "signoutRemark");
            return (Criteria) this;
        }

        public Criteria andSignoutRemarkNotEqualTo(String value) {
            addCriterion("signout_remark <>", value, "signoutRemark");
            return (Criteria) this;
        }

        public Criteria andSignoutRemarkGreaterThan(String value) {
            addCriterion("signout_remark >", value, "signoutRemark");
            return (Criteria) this;
        }

        public Criteria andSignoutRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("signout_remark >=", value, "signoutRemark");
            return (Criteria) this;
        }

        public Criteria andSignoutRemarkLessThan(String value) {
            addCriterion("signout_remark <", value, "signoutRemark");
            return (Criteria) this;
        }

        public Criteria andSignoutRemarkLessThanOrEqualTo(String value) {
            addCriterion("signout_remark <=", value, "signoutRemark");
            return (Criteria) this;
        }

        public Criteria andSignoutRemarkLike(String value) {
            addCriterion("signout_remark like", value, "signoutRemark");
            return (Criteria) this;
        }

        public Criteria andSignoutRemarkNotLike(String value) {
            addCriterion("signout_remark not like", value, "signoutRemark");
            return (Criteria) this;
        }

        public Criteria andSignoutRemarkIn(List<String> values) {
            addCriterion("signout_remark in", values, "signoutRemark");
            return (Criteria) this;
        }

        public Criteria andSignoutRemarkNotIn(List<String> values) {
            addCriterion("signout_remark not in", values, "signoutRemark");
            return (Criteria) this;
        }

        public Criteria andSignoutRemarkBetween(String value1, String value2) {
            addCriterion("signout_remark between", value1, value2, "signoutRemark");
            return (Criteria) this;
        }

        public Criteria andSignoutRemarkNotBetween(String value1, String value2) {
            addCriterion("signout_remark not between", value1, value2, "signoutRemark");
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
            addCriterion("remark <>", value, "remark");
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

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
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

        public Criteria andApprovalIsNull() {
            addCriterion("approval is null");
            return (Criteria) this;
        }

        public Criteria andApprovalIsNotNull() {
            addCriterion("approval is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalEqualTo(String value) {
            addCriterion("approval =", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalNotEqualTo(String value) {
            addCriterion("approval <>", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalGreaterThan(String value) {
            addCriterion("approval >", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalGreaterThanOrEqualTo(String value) {
            addCriterion("approval >=", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalLessThan(String value) {
            addCriterion("approval <", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalLessThanOrEqualTo(String value) {
            addCriterion("approval <=", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalLike(String value) {
            addCriterion("approval like", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalNotLike(String value) {
            addCriterion("approval not like", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalIn(List<String> values) {
            addCriterion("approval in", values, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalNotIn(List<String> values) {
            addCriterion("approval not in", values, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalBetween(String value1, String value2) {
            addCriterion("approval between", value1, value2, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalNotBetween(String value1, String value2) {
            addCriterion("approval not between", value1, value2, "approval");
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