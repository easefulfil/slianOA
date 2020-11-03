package com.slianOAsys.model.ex;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.slianOAsys.model.SlianoaAttendanceExample.Criteria;
import com.slianOAsys.page.Page;

public class AttendanceExExample {
	protected Page page;
	public void setPage(Page page) {
	        this.page=page;
	    }

	    public Page getPage() {
	        return page;
	    }
		/**
	     * This field was generated by MyBatis Generator.
	     * This field corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
	    protected String orderByClause;

	    /**
	     * This field was generated by MyBatis Generator.
	     * This field corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
	    protected boolean distinct;

	    /**
	     * This field was generated by MyBatis Generator.
	     * This field corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
	    protected List<Criteria> oredCriteria;

	    /**
	     * This method was generated by MyBatis Generator.
	     * This method corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
	    public AttendanceExExample() {
	        oredCriteria = new ArrayList<Criteria>();
	    }

	    /**
	     * This method was generated by MyBatis Generator.
	     * This method corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
	    public void setOrderByClause(String orderByClause) {
	        this.orderByClause = orderByClause;
	    }

	    /**
	     * This method was generated by MyBatis Generator.
	     * This method corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
	    public String getOrderByClause() {
	        return orderByClause;
	    }

	    /**
	     * This method was generated by MyBatis Generator.
	     * This method corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
	    public void setDistinct(boolean distinct) {
	        this.distinct = distinct;
	    }

	    /**
	     * This method was generated by MyBatis Generator.
	     * This method corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
	    public boolean isDistinct() {
	        return distinct;
	    }

	    /**
	     * This method was generated by MyBatis Generator.
	     * This method corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
	    public List<Criteria> getOredCriteria() {
	        return oredCriteria;
	    }

	    /**
	     * This method was generated by MyBatis Generator.
	     * This method corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
	    public void or(Criteria criteria) {
	        oredCriteria.add(criteria);
	    }

	    /**
	     * This method was generated by MyBatis Generator.
	     * This method corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
	    public Criteria or() {
	        Criteria criteria = createCriteriaInternal();
	        oredCriteria.add(criteria);
	        return criteria;
	    }

	    /**
	     * This method was generated by MyBatis Generator.
	     * This method corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
	    public Criteria createCriteria() {
	        Criteria criteria = createCriteriaInternal();
	        if (oredCriteria.size() == 0) {
	            oredCriteria.add(criteria);
	        }
	        return criteria;
	    }

	    /**
	     * This method was generated by MyBatis Generator.
	     * This method corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
	    protected Criteria createCriteriaInternal() {
	        Criteria criteria = new Criteria();
	        return criteria;
	    }

	    /**
	     * This method was generated by MyBatis Generator.
	     * This method corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
	    public void clear() {
	        oredCriteria.clear();
	        orderByClause = null;
	        distinct = false;
	    }

	    /**
	     * This class was generated by MyBatis Generator.
	     * This class corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
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

	        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
	            if (value == null) {
	                throw new RuntimeException("Value for " + property + " cannot be null");
	            }
	            addCriterion(condition, new java.sql.Date(value.getTime()), property);
	        }

	        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
	            if (values == null || values.size() == 0) {
	                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
	            }
	            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
	            Iterator<Date> iter = values.iterator();
	            while (iter.hasNext()) {
	                dateList.add(new java.sql.Date(iter.next().getTime()));
	            }
	            addCriterion(condition, dateList, property);
	        }

	        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
	            if (value1 == null || value2 == null) {
	                throw new RuntimeException("Between values for " + property + " cannot be null");
	            }
	            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
	        }

	        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
	            if (value == null) {
	                throw new RuntimeException("Value for " + property + " cannot be null");
	            }
	            addCriterion(condition, new java.sql.Time(value.getTime()), property);
	        }

	        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
	            if (values == null || values.size() == 0) {
	                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
	            }
	            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
	            Iterator<Date> iter = values.iterator();
	            while (iter.hasNext()) {
	                timeList.add(new java.sql.Time(iter.next().getTime()));
	            }
	            addCriterion(condition, timeList, property);
	        }

	        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
	            if (value1 == null || value2 == null) {
	                throw new RuntimeException("Between values for " + property + " cannot be null");
	            }
	            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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
	        
	        
	        /*
	        public Criteria andClassIdEqualTo(Integer value) {
	            addCriterion("class_id =", value, "classId");
	            return (Criteria) this;
	        }public Criteria andDepartIdEqualTo(Integer value) {
	            addCriterion("depart_id =", value, "departId");
	            return (Criteria) this;
	        }
*/
	        
	        
	        
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
	        
	        
	        public Criteria andEmployeeNameLike(String value) {
	            addCriterion("employee_name like", value, "employeeName");
	            return (Criteria) this;
	        }
	        public Criteria andClassNameEqualTo(String value) {
	            addCriterion("class_name =", value, "className");
	            return (Criteria) this;
	        }
	        public Criteria andDepartNameLike(String value) {
	            addCriterion("depart_name like", value, "departName");
	            return (Criteria) this;
	        }
	        public Criteria andDepartNameEqualTo(String value) {
	            addCriterion("depart_name =", value, "departName");
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

	        public Criteria andAttendanceSigntimeIsNull() {
	            addCriterion("attendance_signtime is null");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSigntimeIsNotNull() {
	            addCriterion("attendance_signtime is not null");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSigntimeEqualTo(Date value) {
	            addCriterionForJDBCTime("attendance_signtime =", value, "attendanceSigntime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSigntimeNotEqualTo(Date value) {
	            addCriterionForJDBCTime("attendance_signtime <>", value, "attendanceSigntime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSigntimeGreaterThan(Date value) {
	            addCriterionForJDBCTime("attendance_signtime >", value, "attendanceSigntime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSigntimeGreaterThanOrEqualTo(Date value) {
	            addCriterionForJDBCTime("attendance_signtime >=", value, "attendanceSigntime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSigntimeLessThan(Date value) {
	            addCriterionForJDBCTime("attendance_signtime <", value, "attendanceSigntime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSigntimeLessThanOrEqualTo(Date value) {
	            addCriterionForJDBCTime("attendance_signtime <=", value, "attendanceSigntime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSigntimeIn(List<Date> values) {
	            addCriterionForJDBCTime("attendance_signtime in", values, "attendanceSigntime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSigntimeNotIn(List<Date> values) {
	            addCriterionForJDBCTime("attendance_signtime not in", values, "attendanceSigntime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSigntimeBetween(Date value1, Date value2) {
	            addCriterionForJDBCTime("attendance_signtime between", value1, value2, "attendanceSigntime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSigntimeNotBetween(Date value1, Date value2) {
	            addCriterionForJDBCTime("attendance_signtime not between", value1, value2, "attendanceSigntime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOfftimeIsNull() {
	            addCriterion("attendance_offtime is null");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOfftimeIsNotNull() {
	            addCriterion("attendance_offtime is not null");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOfftimeEqualTo(Date value) {
	            addCriterionForJDBCTime("attendance_offtime =", value, "attendanceOfftime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOfftimeNotEqualTo(Date value) {
	            addCriterionForJDBCTime("attendance_offtime <>", value, "attendanceOfftime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOfftimeGreaterThan(Date value) {
	            addCriterionForJDBCTime("attendance_offtime >", value, "attendanceOfftime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOfftimeGreaterThanOrEqualTo(Date value) {
	            addCriterionForJDBCTime("attendance_offtime >=", value, "attendanceOfftime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOfftimeLessThan(Date value) {
	            addCriterionForJDBCTime("attendance_offtime <", value, "attendanceOfftime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOfftimeLessThanOrEqualTo(Date value) {
	            addCriterionForJDBCTime("attendance_offtime <=", value, "attendanceOfftime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOfftimeIn(List<Date> values) {
	            addCriterionForJDBCTime("attendance_offtime in", values, "attendanceOfftime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOfftimeNotIn(List<Date> values) {
	            addCriterionForJDBCTime("attendance_offtime not in", values, "attendanceOfftime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOfftimeBetween(Date value1, Date value2) {
	            addCriterionForJDBCTime("attendance_offtime between", value1, value2, "attendanceOfftime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOfftimeNotBetween(Date value1, Date value2) {
	            addCriterionForJDBCTime("attendance_offtime not between", value1, value2, "attendanceOfftime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignaddressIsNull() {
	            addCriterion("attendance_signaddress is null");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignaddressIsNotNull() {
	            addCriterion("attendance_signaddress is not null");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignaddressEqualTo(String value) {
	            addCriterion("attendance_signaddress =", value, "attendanceSignaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignaddressNotEqualTo(String value) {
	            addCriterion("attendance_signaddress <>", value, "attendanceSignaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignaddressGreaterThan(String value) {
	            addCriterion("attendance_signaddress >", value, "attendanceSignaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignaddressGreaterThanOrEqualTo(String value) {
	            addCriterion("attendance_signaddress >=", value, "attendanceSignaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignaddressLessThan(String value) {
	            addCriterion("attendance_signaddress <", value, "attendanceSignaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignaddressLessThanOrEqualTo(String value) {
	            addCriterion("attendance_signaddress <=", value, "attendanceSignaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignaddressLike(String value) {
	            addCriterion("attendance_signaddress like", value, "attendanceSignaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignaddressNotLike(String value) {
	            addCriterion("attendance_signaddress not like", value, "attendanceSignaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignaddressIn(List<String> values) {
	            addCriterion("attendance_signaddress in", values, "attendanceSignaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignaddressNotIn(List<String> values) {
	            addCriterion("attendance_signaddress not in", values, "attendanceSignaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignaddressBetween(String value1, String value2) {
	            addCriterion("attendance_signaddress between", value1, value2, "attendanceSignaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignaddressNotBetween(String value1, String value2) {
	            addCriterion("attendance_signaddress not between", value1, value2, "attendanceSignaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffaddressIsNull() {
	            addCriterion("attendance_offaddress is null");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffaddressIsNotNull() {
	            addCriterion("attendance_offaddress is not null");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffaddressEqualTo(String value) {
	            addCriterion("attendance_offaddress =", value, "attendanceOffaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffaddressNotEqualTo(String value) {
	            addCriterion("attendance_offaddress <>", value, "attendanceOffaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffaddressGreaterThan(String value) {
	            addCriterion("attendance_offaddress >", value, "attendanceOffaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffaddressGreaterThanOrEqualTo(String value) {
	            addCriterion("attendance_offaddress >=", value, "attendanceOffaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffaddressLessThan(String value) {
	            addCriterion("attendance_offaddress <", value, "attendanceOffaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffaddressLessThanOrEqualTo(String value) {
	            addCriterion("attendance_offaddress <=", value, "attendanceOffaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffaddressLike(String value) {
	            addCriterion("attendance_offaddress like", value, "attendanceOffaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffaddressNotLike(String value) {
	            addCriterion("attendance_offaddress not like", value, "attendanceOffaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffaddressIn(List<String> values) {
	            addCriterion("attendance_offaddress in", values, "attendanceOffaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffaddressNotIn(List<String> values) {
	            addCriterion("attendance_offaddress not in", values, "attendanceOffaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffaddressBetween(String value1, String value2) {
	            addCriterion("attendance_offaddress between", value1, value2, "attendanceOffaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffaddressNotBetween(String value1, String value2) {
	            addCriterion("attendance_offaddress not between", value1, value2, "attendanceOffaddress");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignstatusIsNull() {
	            addCriterion("attendance_signstatus is null");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignstatusIsNotNull() {
	            addCriterion("attendance_signstatus is not null");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignstatusEqualTo(String value) {
	            addCriterion("attendance_signstatus =", value, "attendanceSignstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignstatusNotEqualTo(String value) {
	            addCriterion("attendance_signstatus <>", value, "attendanceSignstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignstatusGreaterThan(String value) {
	            addCriterion("attendance_signstatus >", value, "attendanceSignstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignstatusGreaterThanOrEqualTo(String value) {
	            addCriterion("attendance_signstatus >=", value, "attendanceSignstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignstatusLessThan(String value) {
	            addCriterion("attendance_signstatus <", value, "attendanceSignstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignstatusLessThanOrEqualTo(String value) {
	            addCriterion("attendance_signstatus <=", value, "attendanceSignstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignstatusLike(String value) {
	            addCriterion("attendance_signstatus like", value, "attendanceSignstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignstatusNotLike(String value) {
	            addCriterion("attendance_signstatus not like", value, "attendanceSignstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignstatusIn(List<String> values) {
	            addCriterion("attendance_signstatus in", values, "attendanceSignstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignstatusNotIn(List<String> values) {
	            addCriterion("attendance_signstatus not in", values, "attendanceSignstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignstatusBetween(String value1, String value2) {
	            addCriterion("attendance_signstatus between", value1, value2, "attendanceSignstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceSignstatusNotBetween(String value1, String value2) {
	            addCriterion("attendance_signstatus not between", value1, value2, "attendanceSignstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffstatusIsNull() {
	            addCriterion("attendance_offstatus is null");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffstatusIsNotNull() {
	            addCriterion("attendance_offstatus is not null");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffstatusEqualTo(String value) {
	            addCriterion("attendance_offstatus =", value, "attendanceOffstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffstatusNotEqualTo(String value) {
	            addCriterion("attendance_offstatus <>", value, "attendanceOffstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffstatusGreaterThan(String value) {
	            addCriterion("attendance_offstatus >", value, "attendanceOffstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffstatusGreaterThanOrEqualTo(String value) {
	            addCriterion("attendance_offstatus >=", value, "attendanceOffstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffstatusLessThan(String value) {
	            addCriterion("attendance_offstatus <", value, "attendanceOffstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffstatusLessThanOrEqualTo(String value) {
	            addCriterion("attendance_offstatus <=", value, "attendanceOffstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffstatusLike(String value) {
	            addCriterion("attendance_offstatus like", value, "attendanceOffstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffstatusNotLike(String value) {
	            addCriterion("attendance_offstatus not like", value, "attendanceOffstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffstatusIn(List<String> values) {
	            addCriterion("attendance_offstatus in", values, "attendanceOffstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffstatusNotIn(List<String> values) {
	            addCriterion("attendance_offstatus not in", values, "attendanceOffstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffstatusBetween(String value1, String value2) {
	            addCriterion("attendance_offstatus between", value1, value2, "attendanceOffstatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceOffstatusNotBetween(String value1, String value2) {
	            addCriterion("attendance_offstatus not between", value1, value2, "attendanceOffstatus");
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

	        public Criteria andAttendanceTimeEqualTo(String value) {
	            addCriterion("attendance_time =", value, "attendanceTime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTimeNotEqualTo(String value) {
	            addCriterion("attendance_time <>", value, "attendanceTime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTimeGreaterThan(String value) {
	            addCriterion("attendance_time >", value, "attendanceTime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTimeGreaterThanOrEqualTo(String value) {
	            addCriterion("attendance_time >=", value, "attendanceTime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTimeLessThan(String value) {
	            addCriterion("attendance_time <", value, "attendanceTime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTimeLessThanOrEqualTo(String value) {
	            addCriterion("attendance_time <=", value, "attendanceTime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTimeLike(String value) {
	            addCriterion("attendance_time like", value, "attendanceTime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTimeNotLike(String value) {
	            addCriterion("attendance_time not like", value, "attendanceTime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTimeIn(List<String> values) {
	            addCriterion("attendance_time in", values, "attendanceTime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTimeNotIn(List<String> values) {
	            addCriterion("attendance_time not in", values, "attendanceTime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTimeBetween(String value1, String value2) {
	            addCriterion("attendance_time between", value1, value2, "attendanceTime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTimeNotBetween(String value1, String value2) {
	            addCriterion("attendance_time not between", value1, value2, "attendanceTime");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTotalStatusIsNull() {
	            addCriterion("attendance_total_status is null");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTotalStatusIsNotNull() {
	            addCriterion("attendance_total_status is not null");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTotalStatusEqualTo(String value) {
	            addCriterion("attendance_total_status =", value, "attendanceTotalStatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTotalStatusNotEqualTo(String value) {
	            addCriterion("attendance_total_status <>", value, "attendanceTotalStatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTotalStatusGreaterThan(String value) {
	            addCriterion("attendance_total_status >", value, "attendanceTotalStatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTotalStatusGreaterThanOrEqualTo(String value) {
	            addCriterion("attendance_total_status >=", value, "attendanceTotalStatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTotalStatusLessThan(String value) {
	            addCriterion("attendance_total_status <", value, "attendanceTotalStatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTotalStatusLessThanOrEqualTo(String value) {
	            addCriterion("attendance_total_status <=", value, "attendanceTotalStatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTotalStatusLike(String value) {
	            addCriterion("attendance_total_status like", value, "attendanceTotalStatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTotalStatusNotLike(String value) {
	            addCriterion("attendance_total_status not like", value, "attendanceTotalStatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTotalStatusIn(List<String> values) {
	            addCriterion("attendance_total_status in", values, "attendanceTotalStatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTotalStatusNotIn(List<String> values) {
	            addCriterion("attendance_total_status not in", values, "attendanceTotalStatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTotalStatusBetween(String value1, String value2) {
	            addCriterion("attendance_total_status between", value1, value2, "attendanceTotalStatus");
	            return (Criteria) this;
	        }

	        public Criteria andAttendanceTotalStatusNotBetween(String value1, String value2) {
	            addCriterion("attendance_total_status not between", value1, value2, "attendanceTotalStatus");
	            return (Criteria) this;
	        }
	    }

	    /**
	     * This class was generated by MyBatis Generator.
	     * This class corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated do_not_delete_during_merge
	     */
	    public static class Criteria extends GeneratedCriteria {

	        protected Criteria() {
	            super();
	        }
	    }

	    /**
	     * This class was generated by MyBatis Generator.
	     * This class corresponds to the database table slianoa_attendance
	     *
	     * @mbggenerated
	     */
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