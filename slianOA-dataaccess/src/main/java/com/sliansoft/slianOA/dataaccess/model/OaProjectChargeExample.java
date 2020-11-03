package com.sliansoft.slianOA.dataaccess.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaProjectChargeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaProjectChargeExample() {
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

    public OaProjectChargeExample(int pageSize, int pageIndex) {
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

        public Criteria andProjectChargeIdIsNull() {
            addCriterion("project_charge_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectChargeIdIsNotNull() {
            addCriterion("project_charge_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectChargeIdEqualTo(Integer value) {
            addCriterion("project_charge_id =", value, "projectChargeId");
            return (Criteria) this;
        }

        public Criteria andProjectChargeIdNotEqualTo(Integer value) {
            addCriterion("project_charge_id <>", value, "projectChargeId");
            return (Criteria) this;
        }

        public Criteria andProjectChargeIdGreaterThan(Integer value) {
            addCriterion("project_charge_id >", value, "projectChargeId");
            return (Criteria) this;
        }

        public Criteria andProjectChargeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_charge_id >=", value, "projectChargeId");
            return (Criteria) this;
        }

        public Criteria andProjectChargeIdLessThan(Integer value) {
            addCriterion("project_charge_id <", value, "projectChargeId");
            return (Criteria) this;
        }

        public Criteria andProjectChargeIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_charge_id <=", value, "projectChargeId");
            return (Criteria) this;
        }

        public Criteria andProjectChargeIdIn(List<Integer> values) {
            addCriterion("project_charge_id in", values, "projectChargeId");
            return (Criteria) this;
        }

        public Criteria andProjectChargeIdNotIn(List<Integer> values) {
            addCriterion("project_charge_id not in", values, "projectChargeId");
            return (Criteria) this;
        }

        public Criteria andProjectChargeIdBetween(Integer value1, Integer value2) {
            addCriterion("project_charge_id between", value1, value2, "projectChargeId");
            return (Criteria) this;
        }

        public Criteria andProjectChargeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_charge_id not between", value1, value2, "projectChargeId");
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

        public Criteria andChargeDateIsNull() {
            addCriterion("charge_date is null");
            return (Criteria) this;
        }

        public Criteria andChargeDateIsNotNull() {
            addCriterion("charge_date is not null");
            return (Criteria) this;
        }

        public Criteria andChargeDateEqualTo(Date value) {
            addCriterion("charge_date =", value, "chargeDate");
            return (Criteria) this;
        }

        public Criteria andChargeDateNotEqualTo(Date value) {
            addCriterion("charge_date <>", value, "chargeDate");
            return (Criteria) this;
        }

        public Criteria andChargeDateGreaterThan(Date value) {
            addCriterion("charge_date >", value, "chargeDate");
            return (Criteria) this;
        }

        public Criteria andChargeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("charge_date >=", value, "chargeDate");
            return (Criteria) this;
        }

        public Criteria andChargeDateLessThan(Date value) {
            addCriterion("charge_date <", value, "chargeDate");
            return (Criteria) this;
        }

        public Criteria andChargeDateLessThanOrEqualTo(Date value) {
            addCriterion("charge_date <=", value, "chargeDate");
            return (Criteria) this;
        }

        public Criteria andChargeDateIn(List<Date> values) {
            addCriterion("charge_date in", values, "chargeDate");
            return (Criteria) this;
        }

        public Criteria andChargeDateNotIn(List<Date> values) {
            addCriterion("charge_date not in", values, "chargeDate");
            return (Criteria) this;
        }

        public Criteria andChargeDateBetween(Date value1, Date value2) {
            addCriterion("charge_date between", value1, value2, "chargeDate");
            return (Criteria) this;
        }

        public Criteria andChargeDateNotBetween(Date value1, Date value2) {
            addCriterion("charge_date not between", value1, value2, "chargeDate");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyIsNull() {
            addCriterion("charge_money is null");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyIsNotNull() {
            addCriterion("charge_money is not null");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyEqualTo(BigDecimal value) {
            addCriterion("charge_money =", value, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyNotEqualTo(BigDecimal value) {
            addCriterion("charge_money <>", value, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyGreaterThan(BigDecimal value) {
            addCriterion("charge_money >", value, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("charge_money >=", value, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyLessThan(BigDecimal value) {
            addCriterion("charge_money <", value, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("charge_money <=", value, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyIn(List<BigDecimal> values) {
            addCriterion("charge_money in", values, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyNotIn(List<BigDecimal> values) {
            addCriterion("charge_money not in", values, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("charge_money between", value1, value2, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("charge_money not between", value1, value2, "chargeMoney");
            return (Criteria) this;
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

        public Criteria andChargeStatusIsNull() {
            addCriterion("charge_status is null");
            return (Criteria) this;
        }

        public Criteria andChargeStatusIsNotNull() {
            addCriterion("charge_status is not null");
            return (Criteria) this;
        }

        public Criteria andChargeStatusEqualTo(String value) {
            addCriterion("charge_status =", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusNotEqualTo(String value) {
            addCriterion("charge_status <>", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusGreaterThan(String value) {
            addCriterion("charge_status >", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("charge_status >=", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusLessThan(String value) {
            addCriterion("charge_status <", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusLessThanOrEqualTo(String value) {
            addCriterion("charge_status <=", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusLike(String value) {
            addCriterion("charge_status like", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusNotLike(String value) {
            addCriterion("charge_status not like", value, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusIn(List<String> values) {
            addCriterion("charge_status in", values, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusNotIn(List<String> values) {
            addCriterion("charge_status not in", values, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusBetween(String value1, String value2) {
            addCriterion("charge_status between", value1, value2, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andChargeStatusNotBetween(String value1, String value2) {
            addCriterion("charge_status not between", value1, value2, "chargeStatus");
            return (Criteria) this;
        }

        public Criteria andFactDateIsNull() {
            addCriterion("fact_date is null");
            return (Criteria) this;
        }

        public Criteria andFactDateIsNotNull() {
            addCriterion("fact_date is not null");
            return (Criteria) this;
        }

        public Criteria andFactDateEqualTo(Date value) {
            addCriterion("fact_date =", value, "factDate");
            return (Criteria) this;
        }

        public Criteria andFactDateNotEqualTo(Date value) {
            addCriterion("fact_date <>", value, "factDate");
            return (Criteria) this;
        }

        public Criteria andFactDateGreaterThan(Date value) {
            addCriterion("fact_date >", value, "factDate");
            return (Criteria) this;
        }

        public Criteria andFactDateGreaterThanOrEqualTo(Date value) {
            addCriterion("fact_date >=", value, "factDate");
            return (Criteria) this;
        }

        public Criteria andFactDateLessThan(Date value) {
            addCriterion("fact_date <", value, "factDate");
            return (Criteria) this;
        }

        public Criteria andFactDateLessThanOrEqualTo(Date value) {
            addCriterion("fact_date <=", value, "factDate");
            return (Criteria) this;
        }

        public Criteria andFactDateIn(List<Date> values) {
            addCriterion("fact_date in", values, "factDate");
            return (Criteria) this;
        }

        public Criteria andFactDateNotIn(List<Date> values) {
            addCriterion("fact_date not in", values, "factDate");
            return (Criteria) this;
        }

        public Criteria andFactDateBetween(Date value1, Date value2) {
            addCriterion("fact_date between", value1, value2, "factDate");
            return (Criteria) this;
        }

        public Criteria andFactDateNotBetween(Date value1, Date value2) {
            addCriterion("fact_date not between", value1, value2, "factDate");
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