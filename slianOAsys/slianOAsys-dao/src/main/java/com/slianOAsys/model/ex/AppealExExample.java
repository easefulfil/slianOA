package com.slianOAsys.model.ex;

import java.util.ArrayList;
import java.util.List;

import com.slianOAsys.model.ex.AttendanceExExample.Criteria;
import com.slianOAsys.page.Page;

public class AppealExExample {
	protected Page page;
	public void setPage(Page page) {
	        this.page=page;
	    }

	    public Page getPage() {
	        return page;
	    }
	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table slianoa_appeal
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table slianoa_appeal
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table slianoa_appeal
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_appeal
     *
     * @mbggenerated
     */
    public AppealExExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_appeal
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_appeal
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_appeal
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_appeal
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_appeal
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_appeal
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_appeal
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
     * This method corresponds to the database table slianoa_appeal
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
     * This method corresponds to the database table slianoa_appeal
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_appeal
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
     * This class corresponds to the database table slianoa_appeal
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

        public Criteria andAppealTimeIsNull() {
            addCriterion("appeal_time is null");
            return (Criteria) this;
        }

        public Criteria andAppealTimeIsNotNull() {
            addCriterion("appeal_time is not null");
            return (Criteria) this;
        }

        public Criteria andAppealTimeEqualTo(String value) {
            addCriterion("appeal_time =", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeNotEqualTo(String value) {
            addCriterion("appeal_time <>", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeGreaterThan(String value) {
            addCriterion("appeal_time >", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeGreaterThanOrEqualTo(String value) {
            addCriterion("appeal_time >=", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeLessThan(String value) {
            addCriterion("appeal_time <", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeLessThanOrEqualTo(String value) {
            addCriterion("appeal_time <=", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeLike(String value) {
            addCriterion("appeal_time like", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeNotLike(String value) {
            addCriterion("appeal_time not like", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeIn(List<String> values) {
            addCriterion("appeal_time in", values, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeNotIn(List<String> values) {
            addCriterion("appeal_time not in", values, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeBetween(String value1, String value2) {
            addCriterion("appeal_time between", value1, value2, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeNotBetween(String value1, String value2) {
            addCriterion("appeal_time not between", value1, value2, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAbnormalStatusIsNull() {
            addCriterion("abnormal_status is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalStatusIsNotNull() {
            addCriterion("abnormal_status is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalStatusEqualTo(String value) {
            addCriterion("abnormal_status =", value, "abnormalStatus");
            return (Criteria) this;
        }

        public Criteria andAbnormalStatusNotEqualTo(String value) {
            addCriterion("abnormal_status <>", value, "abnormalStatus");
            return (Criteria) this;
        }

        public Criteria andAbnormalStatusGreaterThan(String value) {
            addCriterion("abnormal_status >", value, "abnormalStatus");
            return (Criteria) this;
        }

        public Criteria andAbnormalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("abnormal_status >=", value, "abnormalStatus");
            return (Criteria) this;
        }

        public Criteria andAbnormalStatusLessThan(String value) {
            addCriterion("abnormal_status <", value, "abnormalStatus");
            return (Criteria) this;
        }

        public Criteria andAbnormalStatusLessThanOrEqualTo(String value) {
            addCriterion("abnormal_status <=", value, "abnormalStatus");
            return (Criteria) this;
        }

        public Criteria andAbnormalStatusLike(String value) {
            addCriterion("abnormal_status like", value, "abnormalStatus");
            return (Criteria) this;
        }

        public Criteria andAbnormalStatusNotLike(String value) {
            addCriterion("abnormal_status not like", value, "abnormalStatus");
            return (Criteria) this;
        }

        public Criteria andAbnormalStatusIn(List<String> values) {
            addCriterion("abnormal_status in", values, "abnormalStatus");
            return (Criteria) this;
        }

        public Criteria andAbnormalStatusNotIn(List<String> values) {
            addCriterion("abnormal_status not in", values, "abnormalStatus");
            return (Criteria) this;
        }

        public Criteria andAbnormalStatusBetween(String value1, String value2) {
            addCriterion("abnormal_status between", value1, value2, "abnormalStatus");
            return (Criteria) this;
        }

        public Criteria andAbnormalStatusNotBetween(String value1, String value2) {
            addCriterion("abnormal_status not between", value1, value2, "abnormalStatus");
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

        public Criteria andAppealStatusIsNull() {
            addCriterion("appeal_status is null");
            return (Criteria) this;
        }

        public Criteria andAppealStatusIsNotNull() {
            addCriterion("appeal_status is not null");
            return (Criteria) this;
        }

        public Criteria andAppealStatusEqualTo(String value) {
            addCriterion("appeal_status =", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusNotEqualTo(String value) {
            addCriterion("appeal_status <>", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusGreaterThan(String value) {
            addCriterion("appeal_status >", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusGreaterThanOrEqualTo(String value) {
            addCriterion("appeal_status >=", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusLessThan(String value) {
            addCriterion("appeal_status <", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusLessThanOrEqualTo(String value) {
            addCriterion("appeal_status <=", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusLike(String value) {
            addCriterion("appeal_status like", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusNotLike(String value) {
            addCriterion("appeal_status not like", value, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusIn(List<String> values) {
            addCriterion("appeal_status in", values, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusNotIn(List<String> values) {
            addCriterion("appeal_status not in", values, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusBetween(String value1, String value2) {
            addCriterion("appeal_status between", value1, value2, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andAppealStatusNotBetween(String value1, String value2) {
            addCriterion("appeal_status not between", value1, value2, "appealStatus");
            return (Criteria) this;
        }

        public Criteria andHandleEmployeeIdIsNull() {
            addCriterion("handle_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andHandleEmployeeIdIsNotNull() {
            addCriterion("handle_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andHandleEmployeeIdEqualTo(Integer value) {
            addCriterion("handle_employee_id =", value, "handleEmployeeId");
            return (Criteria) this;
        }

        public Criteria andHandleEmployeeIdNotEqualTo(Integer value) {
            addCriterion("handle_employee_id <>", value, "handleEmployeeId");
            return (Criteria) this;
        }

        public Criteria andHandleEmployeeIdGreaterThan(Integer value) {
            addCriterion("handle_employee_id >", value, "handleEmployeeId");
            return (Criteria) this;
        }

        public Criteria andHandleEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("handle_employee_id >=", value, "handleEmployeeId");
            return (Criteria) this;
        }

        public Criteria andHandleEmployeeIdLessThan(Integer value) {
            addCriterion("handle_employee_id <", value, "handleEmployeeId");
            return (Criteria) this;
        }

        public Criteria andHandleEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("handle_employee_id <=", value, "handleEmployeeId");
            return (Criteria) this;
        }

        public Criteria andHandleEmployeeIdIn(List<Integer> values) {
            addCriterion("handle_employee_id in", values, "handleEmployeeId");
            return (Criteria) this;
        }

        public Criteria andHandleEmployeeIdNotIn(List<Integer> values) {
            addCriterion("handle_employee_id not in", values, "handleEmployeeId");
            return (Criteria) this;
        }

        public Criteria andHandleEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("handle_employee_id between", value1, value2, "handleEmployeeId");
            return (Criteria) this;
        }

        public Criteria andHandleEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("handle_employee_id not between", value1, value2, "handleEmployeeId");
            return (Criteria) this;
        }

        public Criteria andRelatedEmployeeIsNull() {
            addCriterion("related_employee is null");
            return (Criteria) this;
        }

        public Criteria andRelatedEmployeeIsNotNull() {
            addCriterion("related_employee is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedEmployeeEqualTo(String value) {
            addCriterion("related_employee =", value, "relatedEmployee");
            return (Criteria) this;
        }

        public Criteria andRelatedEmployeeNotEqualTo(String value) {
            addCriterion("related_employee <>", value, "relatedEmployee");
            return (Criteria) this;
        }

        public Criteria andRelatedEmployeeGreaterThan(String value) {
            addCriterion("related_employee >", value, "relatedEmployee");
            return (Criteria) this;
        }

        public Criteria andRelatedEmployeeGreaterThanOrEqualTo(String value) {
            addCriterion("related_employee >=", value, "relatedEmployee");
            return (Criteria) this;
        }

        public Criteria andRelatedEmployeeLessThan(String value) {
            addCriterion("related_employee <", value, "relatedEmployee");
            return (Criteria) this;
        }

        public Criteria andRelatedEmployeeLessThanOrEqualTo(String value) {
            addCriterion("related_employee <=", value, "relatedEmployee");
            return (Criteria) this;
        }

        public Criteria andRelatedEmployeeLike(String value) {
            addCriterion("related_employee like", value, "relatedEmployee");
            return (Criteria) this;
        }

        public Criteria andRelatedEmployeeNotLike(String value) {
            addCriterion("related_employee not like", value, "relatedEmployee");
            return (Criteria) this;
        }

        public Criteria andRelatedEmployeeIn(List<String> values) {
            addCriterion("related_employee in", values, "relatedEmployee");
            return (Criteria) this;
        }

        public Criteria andRelatedEmployeeNotIn(List<String> values) {
            addCriterion("related_employee not in", values, "relatedEmployee");
            return (Criteria) this;
        }

        public Criteria andRelatedEmployeeBetween(String value1, String value2) {
            addCriterion("related_employee between", value1, value2, "relatedEmployee");
            return (Criteria) this;
        }

        public Criteria andRelatedEmployeeNotBetween(String value1, String value2) {
            addCriterion("related_employee not between", value1, value2, "relatedEmployee");
            return (Criteria) this;
        }
        public Criteria andEmployeeWechatLike(String value) {
            addCriterion("employee_wechat like", value, "employeeWechat");
            return (Criteria) this;
        }
        public Criteria andEmployeeNameLike(String value) {
            addCriterion("employee_name like", value, "employeeName");
            return (Criteria) this;
        }
        public Criteria andDepartNameLike(String value) {
            addCriterion("depart_name like", value, "departName");
            return (Criteria) this;
        }
        
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table slianoa_appeal
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
     * This class corresponds to the database table slianoa_appeal
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