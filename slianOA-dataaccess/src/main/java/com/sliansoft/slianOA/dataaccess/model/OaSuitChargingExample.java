package com.sliansoft.slianOA.dataaccess.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaSuitChargingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaSuitChargingExample() {
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

    public OaSuitChargingExample(int pageSize, int pageIndex) {
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

        public Criteria andSuitChargingIdIsNull() {
            addCriterion("suit_charging_id is null");
            return (Criteria) this;
        }

        public Criteria andSuitChargingIdIsNotNull() {
            addCriterion("suit_charging_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuitChargingIdEqualTo(Integer value) {
            addCriterion("suit_charging_id =", value, "suitChargingId");
            return (Criteria) this;
        }

        public Criteria andSuitChargingIdNotEqualTo(Integer value) {
            addCriterion("suit_charging_id <>", value, "suitChargingId");
            return (Criteria) this;
        }

        public Criteria andSuitChargingIdGreaterThan(Integer value) {
            addCriterion("suit_charging_id >", value, "suitChargingId");
            return (Criteria) this;
        }

        public Criteria andSuitChargingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("suit_charging_id >=", value, "suitChargingId");
            return (Criteria) this;
        }

        public Criteria andSuitChargingIdLessThan(Integer value) {
            addCriterion("suit_charging_id <", value, "suitChargingId");
            return (Criteria) this;
        }

        public Criteria andSuitChargingIdLessThanOrEqualTo(Integer value) {
            addCriterion("suit_charging_id <=", value, "suitChargingId");
            return (Criteria) this;
        }

        public Criteria andSuitChargingIdIn(List<Integer> values) {
            addCriterion("suit_charging_id in", values, "suitChargingId");
            return (Criteria) this;
        }

        public Criteria andSuitChargingIdNotIn(List<Integer> values) {
            addCriterion("suit_charging_id not in", values, "suitChargingId");
            return (Criteria) this;
        }

        public Criteria andSuitChargingIdBetween(Integer value1, Integer value2) {
            addCriterion("suit_charging_id between", value1, value2, "suitChargingId");
            return (Criteria) this;
        }

        public Criteria andSuitChargingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("suit_charging_id not between", value1, value2, "suitChargingId");
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

        public Criteria andSuitIdIsNull() {
            addCriterion("suit_id is null");
            return (Criteria) this;
        }

        public Criteria andSuitIdIsNotNull() {
            addCriterion("suit_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuitIdEqualTo(Integer value) {
            addCriterion("suit_id =", value, "suitId");
            return (Criteria) this;
        }

        public Criteria andSuitIdNotEqualTo(Integer value) {
            addCriterion("suit_id <>", value, "suitId");
            return (Criteria) this;
        }

        public Criteria andSuitIdGreaterThan(Integer value) {
            addCriterion("suit_id >", value, "suitId");
            return (Criteria) this;
        }

        public Criteria andSuitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("suit_id >=", value, "suitId");
            return (Criteria) this;
        }

        public Criteria andSuitIdLessThan(Integer value) {
            addCriterion("suit_id <", value, "suitId");
            return (Criteria) this;
        }

        public Criteria andSuitIdLessThanOrEqualTo(Integer value) {
            addCriterion("suit_id <=", value, "suitId");
            return (Criteria) this;
        }

        public Criteria andSuitIdIn(List<Integer> values) {
            addCriterion("suit_id in", values, "suitId");
            return (Criteria) this;
        }

        public Criteria andSuitIdNotIn(List<Integer> values) {
            addCriterion("suit_id not in", values, "suitId");
            return (Criteria) this;
        }

        public Criteria andSuitIdBetween(Integer value1, Integer value2) {
            addCriterion("suit_id between", value1, value2, "suitId");
            return (Criteria) this;
        }

        public Criteria andSuitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("suit_id not between", value1, value2, "suitId");
            return (Criteria) this;
        }

        public Criteria andSuitTimeIsNull() {
            addCriterion("suit_time is null");
            return (Criteria) this;
        }

        public Criteria andSuitTimeIsNotNull() {
            addCriterion("suit_time is not null");
            return (Criteria) this;
        }

        public Criteria andSuitTimeEqualTo(Date value) {
            addCriterion("suit_time =", value, "suitTime");
            return (Criteria) this;
        }

        public Criteria andSuitTimeNotEqualTo(Date value) {
            addCriterion("suit_time <>", value, "suitTime");
            return (Criteria) this;
        }

        public Criteria andSuitTimeGreaterThan(Date value) {
            addCriterion("suit_time >", value, "suitTime");
            return (Criteria) this;
        }

        public Criteria andSuitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("suit_time >=", value, "suitTime");
            return (Criteria) this;
        }

        public Criteria andSuitTimeLessThan(Date value) {
            addCriterion("suit_time <", value, "suitTime");
            return (Criteria) this;
        }

        public Criteria andSuitTimeLessThanOrEqualTo(Date value) {
            addCriterion("suit_time <=", value, "suitTime");
            return (Criteria) this;
        }

        public Criteria andSuitTimeIn(List<Date> values) {
            addCriterion("suit_time in", values, "suitTime");
            return (Criteria) this;
        }

        public Criteria andSuitTimeNotIn(List<Date> values) {
            addCriterion("suit_time not in", values, "suitTime");
            return (Criteria) this;
        }

        public Criteria andSuitTimeBetween(Date value1, Date value2) {
            addCriterion("suit_time between", value1, value2, "suitTime");
            return (Criteria) this;
        }

        public Criteria andSuitTimeNotBetween(Date value1, Date value2) {
            addCriterion("suit_time not between", value1, value2, "suitTime");
            return (Criteria) this;
        }

        public Criteria andSuitMoneyIsNull() {
            addCriterion("suit_money is null");
            return (Criteria) this;
        }

        public Criteria andSuitMoneyIsNotNull() {
            addCriterion("suit_money is not null");
            return (Criteria) this;
        }

        public Criteria andSuitMoneyEqualTo(BigDecimal value) {
            addCriterion("suit_money =", value, "suitMoney");
            return (Criteria) this;
        }

        public Criteria andSuitMoneyNotEqualTo(BigDecimal value) {
            addCriterion("suit_money <>", value, "suitMoney");
            return (Criteria) this;
        }

        public Criteria andSuitMoneyGreaterThan(BigDecimal value) {
            addCriterion("suit_money >", value, "suitMoney");
            return (Criteria) this;
        }

        public Criteria andSuitMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("suit_money >=", value, "suitMoney");
            return (Criteria) this;
        }

        public Criteria andSuitMoneyLessThan(BigDecimal value) {
            addCriterion("suit_money <", value, "suitMoney");
            return (Criteria) this;
        }

        public Criteria andSuitMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("suit_money <=", value, "suitMoney");
            return (Criteria) this;
        }

        public Criteria andSuitMoneyIn(List<BigDecimal> values) {
            addCriterion("suit_money in", values, "suitMoney");
            return (Criteria) this;
        }

        public Criteria andSuitMoneyNotIn(List<BigDecimal> values) {
            addCriterion("suit_money not in", values, "suitMoney");
            return (Criteria) this;
        }

        public Criteria andSuitMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("suit_money between", value1, value2, "suitMoney");
            return (Criteria) this;
        }

        public Criteria andSuitMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("suit_money not between", value1, value2, "suitMoney");
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