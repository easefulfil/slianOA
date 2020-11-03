package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaMonthlyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaMonthlyExample() {
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

    public OaMonthlyExample(int pageSize, int pageIndex) {
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

        public Criteria andMonthlyIdIsNull() {
            addCriterion("monthly_id is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyIdIsNotNull() {
            addCriterion("monthly_id is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyIdEqualTo(Integer value) {
            addCriterion("monthly_id =", value, "monthlyId");
            return (Criteria) this;
        }

        public Criteria andMonthlyIdNotEqualTo(Integer value) {
            addCriterion("monthly_id <>", value, "monthlyId");
            return (Criteria) this;
        }

        public Criteria andMonthlyIdGreaterThan(Integer value) {
            addCriterion("monthly_id >", value, "monthlyId");
            return (Criteria) this;
        }

        public Criteria andMonthlyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("monthly_id >=", value, "monthlyId");
            return (Criteria) this;
        }

        public Criteria andMonthlyIdLessThan(Integer value) {
            addCriterion("monthly_id <", value, "monthlyId");
            return (Criteria) this;
        }

        public Criteria andMonthlyIdLessThanOrEqualTo(Integer value) {
            addCriterion("monthly_id <=", value, "monthlyId");
            return (Criteria) this;
        }

        public Criteria andMonthlyIdIn(List<Integer> values) {
            addCriterion("monthly_id in", values, "monthlyId");
            return (Criteria) this;
        }

        public Criteria andMonthlyIdNotIn(List<Integer> values) {
            addCriterion("monthly_id not in", values, "monthlyId");
            return (Criteria) this;
        }

        public Criteria andMonthlyIdBetween(Integer value1, Integer value2) {
            addCriterion("monthly_id between", value1, value2, "monthlyId");
            return (Criteria) this;
        }

        public Criteria andMonthlyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("monthly_id not between", value1, value2, "monthlyId");
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

        public Criteria andNeedAttendanceDaysIsNull() {
            addCriterion("need_attendance_days is null");
            return (Criteria) this;
        }

        public Criteria andNeedAttendanceDaysIsNotNull() {
            addCriterion("need_attendance_days is not null");
            return (Criteria) this;
        }

        public Criteria andNeedAttendanceDaysEqualTo(Integer value) {
            addCriterion("need_attendance_days =", value, "needAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andNeedAttendanceDaysNotEqualTo(Integer value) {
            addCriterion("need_attendance_days <>", value, "needAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andNeedAttendanceDaysGreaterThan(Integer value) {
            addCriterion("need_attendance_days >", value, "needAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andNeedAttendanceDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_attendance_days >=", value, "needAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andNeedAttendanceDaysLessThan(Integer value) {
            addCriterion("need_attendance_days <", value, "needAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andNeedAttendanceDaysLessThanOrEqualTo(Integer value) {
            addCriterion("need_attendance_days <=", value, "needAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andNeedAttendanceDaysIn(List<Integer> values) {
            addCriterion("need_attendance_days in", values, "needAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andNeedAttendanceDaysNotIn(List<Integer> values) {
            addCriterion("need_attendance_days not in", values, "needAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andNeedAttendanceDaysBetween(Integer value1, Integer value2) {
            addCriterion("need_attendance_days between", value1, value2, "needAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andNeedAttendanceDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("need_attendance_days not between", value1, value2, "needAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRealAttendanceDaysIsNull() {
            addCriterion("real_attendance_days is null");
            return (Criteria) this;
        }

        public Criteria andRealAttendanceDaysIsNotNull() {
            addCriterion("real_attendance_days is not null");
            return (Criteria) this;
        }

        public Criteria andRealAttendanceDaysEqualTo(Integer value) {
            addCriterion("real_attendance_days =", value, "realAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRealAttendanceDaysNotEqualTo(Integer value) {
            addCriterion("real_attendance_days <>", value, "realAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRealAttendanceDaysGreaterThan(Integer value) {
            addCriterion("real_attendance_days >", value, "realAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRealAttendanceDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("real_attendance_days >=", value, "realAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRealAttendanceDaysLessThan(Integer value) {
            addCriterion("real_attendance_days <", value, "realAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRealAttendanceDaysLessThanOrEqualTo(Integer value) {
            addCriterion("real_attendance_days <=", value, "realAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRealAttendanceDaysIn(List<Integer> values) {
            addCriterion("real_attendance_days in", values, "realAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRealAttendanceDaysNotIn(List<Integer> values) {
            addCriterion("real_attendance_days not in", values, "realAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRealAttendanceDaysBetween(Integer value1, Integer value2) {
            addCriterion("real_attendance_days between", value1, value2, "realAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andRealAttendanceDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("real_attendance_days not between", value1, value2, "realAttendanceDays");
            return (Criteria) this;
        }

        public Criteria andLateTimesIsNull() {
            addCriterion("late_times is null");
            return (Criteria) this;
        }

        public Criteria andLateTimesIsNotNull() {
            addCriterion("late_times is not null");
            return (Criteria) this;
        }

        public Criteria andLateTimesEqualTo(Integer value) {
            addCriterion("late_times =", value, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesNotEqualTo(Integer value) {
            addCriterion("late_times <>", value, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesGreaterThan(Integer value) {
            addCriterion("late_times >", value, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("late_times >=", value, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesLessThan(Integer value) {
            addCriterion("late_times <", value, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesLessThanOrEqualTo(Integer value) {
            addCriterion("late_times <=", value, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesIn(List<Integer> values) {
            addCriterion("late_times in", values, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesNotIn(List<Integer> values) {
            addCriterion("late_times not in", values, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesBetween(Integer value1, Integer value2) {
            addCriterion("late_times between", value1, value2, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("late_times not between", value1, value2, "lateTimes");
            return (Criteria) this;
        }

        public Criteria andLateMinutesIsNull() {
            addCriterion("late_minutes is null");
            return (Criteria) this;
        }

        public Criteria andLateMinutesIsNotNull() {
            addCriterion("late_minutes is not null");
            return (Criteria) this;
        }

        public Criteria andLateMinutesEqualTo(Integer value) {
            addCriterion("late_minutes =", value, "lateMinutes");
            return (Criteria) this;
        }

        public Criteria andLateMinutesNotEqualTo(Integer value) {
            addCriterion("late_minutes <>", value, "lateMinutes");
            return (Criteria) this;
        }

        public Criteria andLateMinutesGreaterThan(Integer value) {
            addCriterion("late_minutes >", value, "lateMinutes");
            return (Criteria) this;
        }

        public Criteria andLateMinutesGreaterThanOrEqualTo(Integer value) {
            addCriterion("late_minutes >=", value, "lateMinutes");
            return (Criteria) this;
        }

        public Criteria andLateMinutesLessThan(Integer value) {
            addCriterion("late_minutes <", value, "lateMinutes");
            return (Criteria) this;
        }

        public Criteria andLateMinutesLessThanOrEqualTo(Integer value) {
            addCriterion("late_minutes <=", value, "lateMinutes");
            return (Criteria) this;
        }

        public Criteria andLateMinutesIn(List<Integer> values) {
            addCriterion("late_minutes in", values, "lateMinutes");
            return (Criteria) this;
        }

        public Criteria andLateMinutesNotIn(List<Integer> values) {
            addCriterion("late_minutes not in", values, "lateMinutes");
            return (Criteria) this;
        }

        public Criteria andLateMinutesBetween(Integer value1, Integer value2) {
            addCriterion("late_minutes between", value1, value2, "lateMinutes");
            return (Criteria) this;
        }

        public Criteria andLateMinutesNotBetween(Integer value1, Integer value2) {
            addCriterion("late_minutes not between", value1, value2, "lateMinutes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesIsNull() {
            addCriterion("leave_early_times is null");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesIsNotNull() {
            addCriterion("leave_early_times is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesEqualTo(Integer value) {
            addCriterion("leave_early_times =", value, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesNotEqualTo(Integer value) {
            addCriterion("leave_early_times <>", value, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesGreaterThan(Integer value) {
            addCriterion("leave_early_times >", value, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("leave_early_times >=", value, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesLessThan(Integer value) {
            addCriterion("leave_early_times <", value, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesLessThanOrEqualTo(Integer value) {
            addCriterion("leave_early_times <=", value, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesIn(List<Integer> values) {
            addCriterion("leave_early_times in", values, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesNotIn(List<Integer> values) {
            addCriterion("leave_early_times not in", values, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesBetween(Integer value1, Integer value2) {
            addCriterion("leave_early_times between", value1, value2, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("leave_early_times not between", value1, value2, "leaveEarlyTimes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyMinutesIsNull() {
            addCriterion("leave_early_minutes is null");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyMinutesIsNotNull() {
            addCriterion("leave_early_minutes is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyMinutesEqualTo(Integer value) {
            addCriterion("leave_early_minutes =", value, "leaveEarlyMinutes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyMinutesNotEqualTo(Integer value) {
            addCriterion("leave_early_minutes <>", value, "leaveEarlyMinutes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyMinutesGreaterThan(Integer value) {
            addCriterion("leave_early_minutes >", value, "leaveEarlyMinutes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyMinutesGreaterThanOrEqualTo(Integer value) {
            addCriterion("leave_early_minutes >=", value, "leaveEarlyMinutes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyMinutesLessThan(Integer value) {
            addCriterion("leave_early_minutes <", value, "leaveEarlyMinutes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyMinutesLessThanOrEqualTo(Integer value) {
            addCriterion("leave_early_minutes <=", value, "leaveEarlyMinutes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyMinutesIn(List<Integer> values) {
            addCriterion("leave_early_minutes in", values, "leaveEarlyMinutes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyMinutesNotIn(List<Integer> values) {
            addCriterion("leave_early_minutes not in", values, "leaveEarlyMinutes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyMinutesBetween(Integer value1, Integer value2) {
            addCriterion("leave_early_minutes between", value1, value2, "leaveEarlyMinutes");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyMinutesNotBetween(Integer value1, Integer value2) {
            addCriterion("leave_early_minutes not between", value1, value2, "leaveEarlyMinutes");
            return (Criteria) this;
        }

        public Criteria andAbsentDaysIsNull() {
            addCriterion("absent_days is null");
            return (Criteria) this;
        }

        public Criteria andAbsentDaysIsNotNull() {
            addCriterion("absent_days is not null");
            return (Criteria) this;
        }

        public Criteria andAbsentDaysEqualTo(Integer value) {
            addCriterion("absent_days =", value, "absentDays");
            return (Criteria) this;
        }

        public Criteria andAbsentDaysNotEqualTo(Integer value) {
            addCriterion("absent_days <>", value, "absentDays");
            return (Criteria) this;
        }

        public Criteria andAbsentDaysGreaterThan(Integer value) {
            addCriterion("absent_days >", value, "absentDays");
            return (Criteria) this;
        }

        public Criteria andAbsentDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("absent_days >=", value, "absentDays");
            return (Criteria) this;
        }

        public Criteria andAbsentDaysLessThan(Integer value) {
            addCriterion("absent_days <", value, "absentDays");
            return (Criteria) this;
        }

        public Criteria andAbsentDaysLessThanOrEqualTo(Integer value) {
            addCriterion("absent_days <=", value, "absentDays");
            return (Criteria) this;
        }

        public Criteria andAbsentDaysIn(List<Integer> values) {
            addCriterion("absent_days in", values, "absentDays");
            return (Criteria) this;
        }

        public Criteria andAbsentDaysNotIn(List<Integer> values) {
            addCriterion("absent_days not in", values, "absentDays");
            return (Criteria) this;
        }

        public Criteria andAbsentDaysBetween(Integer value1, Integer value2) {
            addCriterion("absent_days between", value1, value2, "absentDays");
            return (Criteria) this;
        }

        public Criteria andAbsentDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("absent_days not between", value1, value2, "absentDays");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveDaysIsNull() {
            addCriterion("casual_leave_days is null");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveDaysIsNotNull() {
            addCriterion("casual_leave_days is not null");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveDaysEqualTo(Integer value) {
            addCriterion("casual_leave_days =", value, "casualLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveDaysNotEqualTo(Integer value) {
            addCriterion("casual_leave_days <>", value, "casualLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveDaysGreaterThan(Integer value) {
            addCriterion("casual_leave_days >", value, "casualLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("casual_leave_days >=", value, "casualLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveDaysLessThan(Integer value) {
            addCriterion("casual_leave_days <", value, "casualLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveDaysLessThanOrEqualTo(Integer value) {
            addCriterion("casual_leave_days <=", value, "casualLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveDaysIn(List<Integer> values) {
            addCriterion("casual_leave_days in", values, "casualLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveDaysNotIn(List<Integer> values) {
            addCriterion("casual_leave_days not in", values, "casualLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveDaysBetween(Integer value1, Integer value2) {
            addCriterion("casual_leave_days between", value1, value2, "casualLeaveDays");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("casual_leave_days not between", value1, value2, "casualLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysIsNull() {
            addCriterion("sick_leave_days is null");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysIsNotNull() {
            addCriterion("sick_leave_days is not null");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysEqualTo(Integer value) {
            addCriterion("sick_leave_days =", value, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysNotEqualTo(Integer value) {
            addCriterion("sick_leave_days <>", value, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysGreaterThan(Integer value) {
            addCriterion("sick_leave_days >", value, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("sick_leave_days >=", value, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysLessThan(Integer value) {
            addCriterion("sick_leave_days <", value, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysLessThanOrEqualTo(Integer value) {
            addCriterion("sick_leave_days <=", value, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysIn(List<Integer> values) {
            addCriterion("sick_leave_days in", values, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysNotIn(List<Integer> values) {
            addCriterion("sick_leave_days not in", values, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysBetween(Integer value1, Integer value2) {
            addCriterion("sick_leave_days between", value1, value2, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andSickLeaveDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("sick_leave_days not between", value1, value2, "sickLeaveDays");
            return (Criteria) this;
        }

        public Criteria andOtherLeaveDaysIsNull() {
            addCriterion("other_leave_days is null");
            return (Criteria) this;
        }

        public Criteria andOtherLeaveDaysIsNotNull() {
            addCriterion("other_leave_days is not null");
            return (Criteria) this;
        }

        public Criteria andOtherLeaveDaysEqualTo(Integer value) {
            addCriterion("other_leave_days =", value, "otherLeaveDays");
            return (Criteria) this;
        }

        public Criteria andOtherLeaveDaysNotEqualTo(Integer value) {
            addCriterion("other_leave_days <>", value, "otherLeaveDays");
            return (Criteria) this;
        }

        public Criteria andOtherLeaveDaysGreaterThan(Integer value) {
            addCriterion("other_leave_days >", value, "otherLeaveDays");
            return (Criteria) this;
        }

        public Criteria andOtherLeaveDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("other_leave_days >=", value, "otherLeaveDays");
            return (Criteria) this;
        }

        public Criteria andOtherLeaveDaysLessThan(Integer value) {
            addCriterion("other_leave_days <", value, "otherLeaveDays");
            return (Criteria) this;
        }

        public Criteria andOtherLeaveDaysLessThanOrEqualTo(Integer value) {
            addCriterion("other_leave_days <=", value, "otherLeaveDays");
            return (Criteria) this;
        }

        public Criteria andOtherLeaveDaysIn(List<Integer> values) {
            addCriterion("other_leave_days in", values, "otherLeaveDays");
            return (Criteria) this;
        }

        public Criteria andOtherLeaveDaysNotIn(List<Integer> values) {
            addCriterion("other_leave_days not in", values, "otherLeaveDays");
            return (Criteria) this;
        }

        public Criteria andOtherLeaveDaysBetween(Integer value1, Integer value2) {
            addCriterion("other_leave_days between", value1, value2, "otherLeaveDays");
            return (Criteria) this;
        }

        public Criteria andOtherLeaveDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("other_leave_days not between", value1, value2, "otherLeaveDays");
            return (Criteria) this;
        }

        public Criteria andDateDetailsIsNull() {
            addCriterion("date_details is null");
            return (Criteria) this;
        }

        public Criteria andDateDetailsIsNotNull() {
            addCriterion("date_details is not null");
            return (Criteria) this;
        }

        public Criteria andDateDetailsEqualTo(String value) {
            addCriterion("date_details =", value, "dateDetails");
            return (Criteria) this;
        }

        public Criteria andDateDetailsNotEqualTo(String value) {
            addCriterion("date_details <>", value, "dateDetails");
            return (Criteria) this;
        }

        public Criteria andDateDetailsGreaterThan(String value) {
            addCriterion("date_details >", value, "dateDetails");
            return (Criteria) this;
        }

        public Criteria andDateDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("date_details >=", value, "dateDetails");
            return (Criteria) this;
        }

        public Criteria andDateDetailsLessThan(String value) {
            addCriterion("date_details <", value, "dateDetails");
            return (Criteria) this;
        }

        public Criteria andDateDetailsLessThanOrEqualTo(String value) {
            addCriterion("date_details <=", value, "dateDetails");
            return (Criteria) this;
        }

        public Criteria andDateDetailsLike(String value) {
            addCriterion("date_details like", value, "dateDetails");
            return (Criteria) this;
        }

        public Criteria andDateDetailsNotLike(String value) {
            addCriterion("date_details not like", value, "dateDetails");
            return (Criteria) this;
        }

        public Criteria andDateDetailsIn(List<String> values) {
            addCriterion("date_details in", values, "dateDetails");
            return (Criteria) this;
        }

        public Criteria andDateDetailsNotIn(List<String> values) {
            addCriterion("date_details not in", values, "dateDetails");
            return (Criteria) this;
        }

        public Criteria andDateDetailsBetween(String value1, String value2) {
            addCriterion("date_details between", value1, value2, "dateDetails");
            return (Criteria) this;
        }

        public Criteria andDateDetailsNotBetween(String value1, String value2) {
            addCriterion("date_details not between", value1, value2, "dateDetails");
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