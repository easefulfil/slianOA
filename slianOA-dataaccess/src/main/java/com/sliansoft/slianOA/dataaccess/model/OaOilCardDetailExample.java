package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaOilCardDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaOilCardDetailExample() {
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

    public OaOilCardDetailExample(int pageSize, int pageIndex) {
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

        public Criteria andOilCardDetailIdIsNull() {
            addCriterion("oil_card_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andOilCardDetailIdIsNotNull() {
            addCriterion("oil_card_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andOilCardDetailIdEqualTo(Integer value) {
            addCriterion("oil_card_detail_id =", value, "oilCardDetailId");
            return (Criteria) this;
        }

        public Criteria andOilCardDetailIdNotEqualTo(Integer value) {
            addCriterion("oil_card_detail_id <>", value, "oilCardDetailId");
            return (Criteria) this;
        }

        public Criteria andOilCardDetailIdGreaterThan(Integer value) {
            addCriterion("oil_card_detail_id >", value, "oilCardDetailId");
            return (Criteria) this;
        }

        public Criteria andOilCardDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("oil_card_detail_id >=", value, "oilCardDetailId");
            return (Criteria) this;
        }

        public Criteria andOilCardDetailIdLessThan(Integer value) {
            addCriterion("oil_card_detail_id <", value, "oilCardDetailId");
            return (Criteria) this;
        }

        public Criteria andOilCardDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("oil_card_detail_id <=", value, "oilCardDetailId");
            return (Criteria) this;
        }

        public Criteria andOilCardDetailIdIn(List<Integer> values) {
            addCriterion("oil_card_detail_id in", values, "oilCardDetailId");
            return (Criteria) this;
        }

        public Criteria andOilCardDetailIdNotIn(List<Integer> values) {
            addCriterion("oil_card_detail_id not in", values, "oilCardDetailId");
            return (Criteria) this;
        }

        public Criteria andOilCardDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("oil_card_detail_id between", value1, value2, "oilCardDetailId");
            return (Criteria) this;
        }

        public Criteria andOilCardDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("oil_card_detail_id not between", value1, value2, "oilCardDetailId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIsNull() {
            addCriterion("vehicle_id is null");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIsNotNull() {
            addCriterion("vehicle_id is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleIdEqualTo(Integer value) {
            addCriterion("vehicle_id =", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotEqualTo(Integer value) {
            addCriterion("vehicle_id <>", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdGreaterThan(Integer value) {
            addCriterion("vehicle_id >", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicle_id >=", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdLessThan(Integer value) {
            addCriterion("vehicle_id <", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdLessThanOrEqualTo(Integer value) {
            addCriterion("vehicle_id <=", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIn(List<Integer> values) {
            addCriterion("vehicle_id in", values, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotIn(List<Integer> values) {
            addCriterion("vehicle_id not in", values, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_id between", value1, value2, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_id not between", value1, value2, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdIsNull() {
            addCriterion("oil_card_id is null");
            return (Criteria) this;
        }

        public Criteria andOilCardIdIsNotNull() {
            addCriterion("oil_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andOilCardIdEqualTo(Integer value) {
            addCriterion("oil_card_id =", value, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdNotEqualTo(Integer value) {
            addCriterion("oil_card_id <>", value, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdGreaterThan(Integer value) {
            addCriterion("oil_card_id >", value, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("oil_card_id >=", value, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdLessThan(Integer value) {
            addCriterion("oil_card_id <", value, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdLessThanOrEqualTo(Integer value) {
            addCriterion("oil_card_id <=", value, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdIn(List<Integer> values) {
            addCriterion("oil_card_id in", values, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdNotIn(List<Integer> values) {
            addCriterion("oil_card_id not in", values, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdBetween(Integer value1, Integer value2) {
            addCriterion("oil_card_id between", value1, value2, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("oil_card_id not between", value1, value2, "oilCardId");
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

        public Criteria andOcdAmountIsNull() {
            addCriterion("ocd_amount is null");
            return (Criteria) this;
        }

        public Criteria andOcdAmountIsNotNull() {
            addCriterion("ocd_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOcdAmountEqualTo(Double value) {
            addCriterion("ocd_amount =", value, "ocdAmount");
            return (Criteria) this;
        }

        public Criteria andOcdAmountNotEqualTo(Double value) {
            addCriterion("ocd_amount <>", value, "ocdAmount");
            return (Criteria) this;
        }

        public Criteria andOcdAmountGreaterThan(Double value) {
            addCriterion("ocd_amount >", value, "ocdAmount");
            return (Criteria) this;
        }

        public Criteria andOcdAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("ocd_amount >=", value, "ocdAmount");
            return (Criteria) this;
        }

        public Criteria andOcdAmountLessThan(Double value) {
            addCriterion("ocd_amount <", value, "ocdAmount");
            return (Criteria) this;
        }

        public Criteria andOcdAmountLessThanOrEqualTo(Double value) {
            addCriterion("ocd_amount <=", value, "ocdAmount");
            return (Criteria) this;
        }

        public Criteria andOcdAmountIn(List<Double> values) {
            addCriterion("ocd_amount in", values, "ocdAmount");
            return (Criteria) this;
        }

        public Criteria andOcdAmountNotIn(List<Double> values) {
            addCriterion("ocd_amount not in", values, "ocdAmount");
            return (Criteria) this;
        }

        public Criteria andOcdAmountBetween(Double value1, Double value2) {
            addCriterion("ocd_amount between", value1, value2, "ocdAmount");
            return (Criteria) this;
        }

        public Criteria andOcdAmountNotBetween(Double value1, Double value2) {
            addCriterion("ocd_amount not between", value1, value2, "ocdAmount");
            return (Criteria) this;
        }

        public Criteria andOcdStyleIsNull() {
            addCriterion("ocd_style is null");
            return (Criteria) this;
        }

        public Criteria andOcdStyleIsNotNull() {
            addCriterion("ocd_style is not null");
            return (Criteria) this;
        }

        public Criteria andOcdStyleEqualTo(String value) {
            addCriterion("ocd_style =", value, "ocdStyle");
            return (Criteria) this;
        }

        public Criteria andOcdStyleNotEqualTo(String value) {
            addCriterion("ocd_style <>", value, "ocdStyle");
            return (Criteria) this;
        }

        public Criteria andOcdStyleGreaterThan(String value) {
            addCriterion("ocd_style >", value, "ocdStyle");
            return (Criteria) this;
        }

        public Criteria andOcdStyleGreaterThanOrEqualTo(String value) {
            addCriterion("ocd_style >=", value, "ocdStyle");
            return (Criteria) this;
        }

        public Criteria andOcdStyleLessThan(String value) {
            addCriterion("ocd_style <", value, "ocdStyle");
            return (Criteria) this;
        }

        public Criteria andOcdStyleLessThanOrEqualTo(String value) {
            addCriterion("ocd_style <=", value, "ocdStyle");
            return (Criteria) this;
        }

        public Criteria andOcdStyleLike(String value) {
            addCriterion("ocd_style like", value, "ocdStyle");
            return (Criteria) this;
        }

        public Criteria andOcdStyleNotLike(String value) {
            addCriterion("ocd_style not like", value, "ocdStyle");
            return (Criteria) this;
        }

        public Criteria andOcdStyleIn(List<String> values) {
            addCriterion("ocd_style in", values, "ocdStyle");
            return (Criteria) this;
        }

        public Criteria andOcdStyleNotIn(List<String> values) {
            addCriterion("ocd_style not in", values, "ocdStyle");
            return (Criteria) this;
        }

        public Criteria andOcdStyleBetween(String value1, String value2) {
            addCriterion("ocd_style between", value1, value2, "ocdStyle");
            return (Criteria) this;
        }

        public Criteria andOcdStyleNotBetween(String value1, String value2) {
            addCriterion("ocd_style not between", value1, value2, "ocdStyle");
            return (Criteria) this;
        }

        public Criteria andOcdParTimeIsNull() {
            addCriterion("ocd_par_time is null");
            return (Criteria) this;
        }

        public Criteria andOcdParTimeIsNotNull() {
            addCriterion("ocd_par_time is not null");
            return (Criteria) this;
        }

        public Criteria andOcdParTimeEqualTo(Date value) {
            addCriterion("ocd_par_time =", value, "ocdParTime");
            return (Criteria) this;
        }

        public Criteria andOcdParTimeNotEqualTo(Date value) {
            addCriterion("ocd_par_time <>", value, "ocdParTime");
            return (Criteria) this;
        }

        public Criteria andOcdParTimeGreaterThan(Date value) {
            addCriterion("ocd_par_time >", value, "ocdParTime");
            return (Criteria) this;
        }

        public Criteria andOcdParTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ocd_par_time >=", value, "ocdParTime");
            return (Criteria) this;
        }

        public Criteria andOcdParTimeLessThan(Date value) {
            addCriterion("ocd_par_time <", value, "ocdParTime");
            return (Criteria) this;
        }

        public Criteria andOcdParTimeLessThanOrEqualTo(Date value) {
            addCriterion("ocd_par_time <=", value, "ocdParTime");
            return (Criteria) this;
        }

        public Criteria andOcdParTimeIn(List<Date> values) {
            addCriterion("ocd_par_time in", values, "ocdParTime");
            return (Criteria) this;
        }

        public Criteria andOcdParTimeNotIn(List<Date> values) {
            addCriterion("ocd_par_time not in", values, "ocdParTime");
            return (Criteria) this;
        }

        public Criteria andOcdParTimeBetween(Date value1, Date value2) {
            addCriterion("ocd_par_time between", value1, value2, "ocdParTime");
            return (Criteria) this;
        }

        public Criteria andOcdParTimeNotBetween(Date value1, Date value2) {
            addCriterion("ocd_par_time not between", value1, value2, "ocdParTime");
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