package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaOilCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaOilCardExample() {
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

    public OaOilCardExample(int pageSize, int pageIndex) {
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

        public Criteria andOcNumberIsNull() {
            addCriterion("oc_number is null");
            return (Criteria) this;
        }

        public Criteria andOcNumberIsNotNull() {
            addCriterion("oc_number is not null");
            return (Criteria) this;
        }

        public Criteria andOcNumberEqualTo(String value) {
            addCriterion("oc_number =", value, "ocNumber");
            return (Criteria) this;
        }

        public Criteria andOcNumberNotEqualTo(String value) {
            addCriterion("oc_number <>", value, "ocNumber");
            return (Criteria) this;
        }

        public Criteria andOcNumberGreaterThan(String value) {
            addCriterion("oc_number >", value, "ocNumber");
            return (Criteria) this;
        }

        public Criteria andOcNumberGreaterThanOrEqualTo(String value) {
            addCriterion("oc_number >=", value, "ocNumber");
            return (Criteria) this;
        }

        public Criteria andOcNumberLessThan(String value) {
            addCriterion("oc_number <", value, "ocNumber");
            return (Criteria) this;
        }

        public Criteria andOcNumberLessThanOrEqualTo(String value) {
            addCriterion("oc_number <=", value, "ocNumber");
            return (Criteria) this;
        }

        public Criteria andOcNumberLike(String value) {
            addCriterion("oc_number like", value, "ocNumber");
            return (Criteria) this;
        }

        public Criteria andOcNumberNotLike(String value) {
            addCriterion("oc_number not like", value, "ocNumber");
            return (Criteria) this;
        }

        public Criteria andOcNumberIn(List<String> values) {
            addCriterion("oc_number in", values, "ocNumber");
            return (Criteria) this;
        }

        public Criteria andOcNumberNotIn(List<String> values) {
            addCriterion("oc_number not in", values, "ocNumber");
            return (Criteria) this;
        }

        public Criteria andOcNumberBetween(String value1, String value2) {
            addCriterion("oc_number between", value1, value2, "ocNumber");
            return (Criteria) this;
        }

        public Criteria andOcNumberNotBetween(String value1, String value2) {
            addCriterion("oc_number not between", value1, value2, "ocNumber");
            return (Criteria) this;
        }

        public Criteria andOcCorpIsNull() {
            addCriterion("oc_corp is null");
            return (Criteria) this;
        }

        public Criteria andOcCorpIsNotNull() {
            addCriterion("oc_corp is not null");
            return (Criteria) this;
        }

        public Criteria andOcCorpEqualTo(String value) {
            addCriterion("oc_corp =", value, "ocCorp");
            return (Criteria) this;
        }

        public Criteria andOcCorpNotEqualTo(String value) {
            addCriterion("oc_corp <>", value, "ocCorp");
            return (Criteria) this;
        }

        public Criteria andOcCorpGreaterThan(String value) {
            addCriterion("oc_corp >", value, "ocCorp");
            return (Criteria) this;
        }

        public Criteria andOcCorpGreaterThanOrEqualTo(String value) {
            addCriterion("oc_corp >=", value, "ocCorp");
            return (Criteria) this;
        }

        public Criteria andOcCorpLessThan(String value) {
            addCriterion("oc_corp <", value, "ocCorp");
            return (Criteria) this;
        }

        public Criteria andOcCorpLessThanOrEqualTo(String value) {
            addCriterion("oc_corp <=", value, "ocCorp");
            return (Criteria) this;
        }

        public Criteria andOcCorpLike(String value) {
            addCriterion("oc_corp like", value, "ocCorp");
            return (Criteria) this;
        }

        public Criteria andOcCorpNotLike(String value) {
            addCriterion("oc_corp not like", value, "ocCorp");
            return (Criteria) this;
        }

        public Criteria andOcCorpIn(List<String> values) {
            addCriterion("oc_corp in", values, "ocCorp");
            return (Criteria) this;
        }

        public Criteria andOcCorpNotIn(List<String> values) {
            addCriterion("oc_corp not in", values, "ocCorp");
            return (Criteria) this;
        }

        public Criteria andOcCorpBetween(String value1, String value2) {
            addCriterion("oc_corp between", value1, value2, "ocCorp");
            return (Criteria) this;
        }

        public Criteria andOcCorpNotBetween(String value1, String value2) {
            addCriterion("oc_corp not between", value1, value2, "ocCorp");
            return (Criteria) this;
        }

        public Criteria andManageTimeIsNull() {
            addCriterion("manage_time is null");
            return (Criteria) this;
        }

        public Criteria andManageTimeIsNotNull() {
            addCriterion("manage_time is not null");
            return (Criteria) this;
        }

        public Criteria andManageTimeEqualTo(Date value) {
            addCriterion("manage_time =", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeNotEqualTo(Date value) {
            addCriterion("manage_time <>", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeGreaterThan(Date value) {
            addCriterion("manage_time >", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("manage_time >=", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeLessThan(Date value) {
            addCriterion("manage_time <", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeLessThanOrEqualTo(Date value) {
            addCriterion("manage_time <=", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeIn(List<Date> values) {
            addCriterion("manage_time in", values, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeNotIn(List<Date> values) {
            addCriterion("manage_time not in", values, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeBetween(Date value1, Date value2) {
            addCriterion("manage_time between", value1, value2, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeNotBetween(Date value1, Date value2) {
            addCriterion("manage_time not between", value1, value2, "manageTime");
            return (Criteria) this;
        }

        public Criteria andOcBalanceIsNull() {
            addCriterion("oc_balance is null");
            return (Criteria) this;
        }

        public Criteria andOcBalanceIsNotNull() {
            addCriterion("oc_balance is not null");
            return (Criteria) this;
        }

        public Criteria andOcBalanceEqualTo(Double value) {
            addCriterion("oc_balance =", value, "ocBalance");
            return (Criteria) this;
        }

        public Criteria andOcBalanceNotEqualTo(Double value) {
            addCriterion("oc_balance <>", value, "ocBalance");
            return (Criteria) this;
        }

        public Criteria andOcBalanceGreaterThan(Double value) {
            addCriterion("oc_balance >", value, "ocBalance");
            return (Criteria) this;
        }

        public Criteria andOcBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("oc_balance >=", value, "ocBalance");
            return (Criteria) this;
        }

        public Criteria andOcBalanceLessThan(Double value) {
            addCriterion("oc_balance <", value, "ocBalance");
            return (Criteria) this;
        }

        public Criteria andOcBalanceLessThanOrEqualTo(Double value) {
            addCriterion("oc_balance <=", value, "ocBalance");
            return (Criteria) this;
        }

        public Criteria andOcBalanceIn(List<Double> values) {
            addCriterion("oc_balance in", values, "ocBalance");
            return (Criteria) this;
        }

        public Criteria andOcBalanceNotIn(List<Double> values) {
            addCriterion("oc_balance not in", values, "ocBalance");
            return (Criteria) this;
        }

        public Criteria andOcBalanceBetween(Double value1, Double value2) {
            addCriterion("oc_balance between", value1, value2, "ocBalance");
            return (Criteria) this;
        }

        public Criteria andOcBalanceNotBetween(Double value1, Double value2) {
            addCriterion("oc_balance not between", value1, value2, "ocBalance");
            return (Criteria) this;
        }

        public Criteria andBalanceRegTimeIsNull() {
            addCriterion("balance_reg_time is null");
            return (Criteria) this;
        }

        public Criteria andBalanceRegTimeIsNotNull() {
            addCriterion("balance_reg_time is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceRegTimeEqualTo(Date value) {
            addCriterion("balance_reg_time =", value, "balanceRegTime");
            return (Criteria) this;
        }

        public Criteria andBalanceRegTimeNotEqualTo(Date value) {
            addCriterion("balance_reg_time <>", value, "balanceRegTime");
            return (Criteria) this;
        }

        public Criteria andBalanceRegTimeGreaterThan(Date value) {
            addCriterion("balance_reg_time >", value, "balanceRegTime");
            return (Criteria) this;
        }

        public Criteria andBalanceRegTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("balance_reg_time >=", value, "balanceRegTime");
            return (Criteria) this;
        }

        public Criteria andBalanceRegTimeLessThan(Date value) {
            addCriterion("balance_reg_time <", value, "balanceRegTime");
            return (Criteria) this;
        }

        public Criteria andBalanceRegTimeLessThanOrEqualTo(Date value) {
            addCriterion("balance_reg_time <=", value, "balanceRegTime");
            return (Criteria) this;
        }

        public Criteria andBalanceRegTimeIn(List<Date> values) {
            addCriterion("balance_reg_time in", values, "balanceRegTime");
            return (Criteria) this;
        }

        public Criteria andBalanceRegTimeNotIn(List<Date> values) {
            addCriterion("balance_reg_time not in", values, "balanceRegTime");
            return (Criteria) this;
        }

        public Criteria andBalanceRegTimeBetween(Date value1, Date value2) {
            addCriterion("balance_reg_time between", value1, value2, "balanceRegTime");
            return (Criteria) this;
        }

        public Criteria andBalanceRegTimeNotBetween(Date value1, Date value2) {
            addCriterion("balance_reg_time not between", value1, value2, "balanceRegTime");
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