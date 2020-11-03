package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaErrorCorrectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaErrorCorrectionExample() {
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

    public OaErrorCorrectionExample(int pageSize, int pageIndex) {
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

        public Criteria andErrorCorrectionIdIsNull() {
            addCriterion("error_correction_id is null");
            return (Criteria) this;
        }

        public Criteria andErrorCorrectionIdIsNotNull() {
            addCriterion("error_correction_id is not null");
            return (Criteria) this;
        }

        public Criteria andErrorCorrectionIdEqualTo(Integer value) {
            addCriterion("error_correction_id =", value, "errorCorrectionId");
            return (Criteria) this;
        }

        public Criteria andErrorCorrectionIdNotEqualTo(Integer value) {
            addCriterion("error_correction_id <>", value, "errorCorrectionId");
            return (Criteria) this;
        }

        public Criteria andErrorCorrectionIdGreaterThan(Integer value) {
            addCriterion("error_correction_id >", value, "errorCorrectionId");
            return (Criteria) this;
        }

        public Criteria andErrorCorrectionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("error_correction_id >=", value, "errorCorrectionId");
            return (Criteria) this;
        }

        public Criteria andErrorCorrectionIdLessThan(Integer value) {
            addCriterion("error_correction_id <", value, "errorCorrectionId");
            return (Criteria) this;
        }

        public Criteria andErrorCorrectionIdLessThanOrEqualTo(Integer value) {
            addCriterion("error_correction_id <=", value, "errorCorrectionId");
            return (Criteria) this;
        }

        public Criteria andErrorCorrectionIdIn(List<Integer> values) {
            addCriterion("error_correction_id in", values, "errorCorrectionId");
            return (Criteria) this;
        }

        public Criteria andErrorCorrectionIdNotIn(List<Integer> values) {
            addCriterion("error_correction_id not in", values, "errorCorrectionId");
            return (Criteria) this;
        }

        public Criteria andErrorCorrectionIdBetween(Integer value1, Integer value2) {
            addCriterion("error_correction_id between", value1, value2, "errorCorrectionId");
            return (Criteria) this;
        }

        public Criteria andErrorCorrectionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("error_correction_id not between", value1, value2, "errorCorrectionId");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andProposerIdIsNull() {
            addCriterion("proposer_id is null");
            return (Criteria) this;
        }

        public Criteria andProposerIdIsNotNull() {
            addCriterion("proposer_id is not null");
            return (Criteria) this;
        }

        public Criteria andProposerIdEqualTo(Integer value) {
            addCriterion("proposer_id =", value, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdNotEqualTo(Integer value) {
            addCriterion("proposer_id <>", value, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdGreaterThan(Integer value) {
            addCriterion("proposer_id >", value, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("proposer_id >=", value, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdLessThan(Integer value) {
            addCriterion("proposer_id <", value, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdLessThanOrEqualTo(Integer value) {
            addCriterion("proposer_id <=", value, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdIn(List<Integer> values) {
            addCriterion("proposer_id in", values, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdNotIn(List<Integer> values) {
            addCriterion("proposer_id not in", values, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdBetween(Integer value1, Integer value2) {
            addCriterion("proposer_id between", value1, value2, "proposerId");
            return (Criteria) this;
        }

        public Criteria andProposerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("proposer_id not between", value1, value2, "proposerId");
            return (Criteria) this;
        }

        public Criteria andDutyIdIsNull() {
            addCriterion("duty_id is null");
            return (Criteria) this;
        }

        public Criteria andDutyIdIsNotNull() {
            addCriterion("duty_id is not null");
            return (Criteria) this;
        }

        public Criteria andDutyIdEqualTo(Integer value) {
            addCriterion("duty_id =", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdNotEqualTo(Integer value) {
            addCriterion("duty_id <>", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdGreaterThan(Integer value) {
            addCriterion("duty_id >", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("duty_id >=", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdLessThan(Integer value) {
            addCriterion("duty_id <", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdLessThanOrEqualTo(Integer value) {
            addCriterion("duty_id <=", value, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdIn(List<Integer> values) {
            addCriterion("duty_id in", values, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdNotIn(List<Integer> values) {
            addCriterion("duty_id not in", values, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdBetween(Integer value1, Integer value2) {
            addCriterion("duty_id between", value1, value2, "dutyId");
            return (Criteria) this;
        }

        public Criteria andDutyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("duty_id not between", value1, value2, "dutyId");
            return (Criteria) this;
        }

        public Criteria andChargerIdIsNull() {
            addCriterion("charger_id is null");
            return (Criteria) this;
        }

        public Criteria andChargerIdIsNotNull() {
            addCriterion("charger_id is not null");
            return (Criteria) this;
        }

        public Criteria andChargerIdEqualTo(Integer value) {
            addCriterion("charger_id =", value, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdNotEqualTo(Integer value) {
            addCriterion("charger_id <>", value, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdGreaterThan(Integer value) {
            addCriterion("charger_id >", value, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("charger_id >=", value, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdLessThan(Integer value) {
            addCriterion("charger_id <", value, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdLessThanOrEqualTo(Integer value) {
            addCriterion("charger_id <=", value, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdIn(List<Integer> values) {
            addCriterion("charger_id in", values, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdNotIn(List<Integer> values) {
            addCriterion("charger_id not in", values, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdBetween(Integer value1, Integer value2) {
            addCriterion("charger_id between", value1, value2, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("charger_id not between", value1, value2, "chargerId");
            return (Criteria) this;
        }

        public Criteria andQualityIdIsNull() {
            addCriterion("quality_id is null");
            return (Criteria) this;
        }

        public Criteria andQualityIdIsNotNull() {
            addCriterion("quality_id is not null");
            return (Criteria) this;
        }

        public Criteria andQualityIdEqualTo(Integer value) {
            addCriterion("quality_id =", value, "qualityId");
            return (Criteria) this;
        }

        public Criteria andQualityIdNotEqualTo(Integer value) {
            addCriterion("quality_id <>", value, "qualityId");
            return (Criteria) this;
        }

        public Criteria andQualityIdGreaterThan(Integer value) {
            addCriterion("quality_id >", value, "qualityId");
            return (Criteria) this;
        }

        public Criteria andQualityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality_id >=", value, "qualityId");
            return (Criteria) this;
        }

        public Criteria andQualityIdLessThan(Integer value) {
            addCriterion("quality_id <", value, "qualityId");
            return (Criteria) this;
        }

        public Criteria andQualityIdLessThanOrEqualTo(Integer value) {
            addCriterion("quality_id <=", value, "qualityId");
            return (Criteria) this;
        }

        public Criteria andQualityIdIn(List<Integer> values) {
            addCriterion("quality_id in", values, "qualityId");
            return (Criteria) this;
        }

        public Criteria andQualityIdNotIn(List<Integer> values) {
            addCriterion("quality_id not in", values, "qualityId");
            return (Criteria) this;
        }

        public Criteria andQualityIdBetween(Integer value1, Integer value2) {
            addCriterion("quality_id between", value1, value2, "qualityId");
            return (Criteria) this;
        }

        public Criteria andQualityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("quality_id not between", value1, value2, "qualityId");
            return (Criteria) this;
        }

        public Criteria andContent1IsNull() {
            addCriterion("content1 is null");
            return (Criteria) this;
        }

        public Criteria andContent1IsNotNull() {
            addCriterion("content1 is not null");
            return (Criteria) this;
        }

        public Criteria andContent1EqualTo(String value) {
            addCriterion("content1 =", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1NotEqualTo(String value) {
            addCriterion("content1 <>", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1GreaterThan(String value) {
            addCriterion("content1 >", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1GreaterThanOrEqualTo(String value) {
            addCriterion("content1 >=", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1LessThan(String value) {
            addCriterion("content1 <", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1LessThanOrEqualTo(String value) {
            addCriterion("content1 <=", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1Like(String value) {
            addCriterion("content1 like", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1NotLike(String value) {
            addCriterion("content1 not like", value, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1In(List<String> values) {
            addCriterion("content1 in", values, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1NotIn(List<String> values) {
            addCriterion("content1 not in", values, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1Between(String value1, String value2) {
            addCriterion("content1 between", value1, value2, "content1");
            return (Criteria) this;
        }

        public Criteria andContent1NotBetween(String value1, String value2) {
            addCriterion("content1 not between", value1, value2, "content1");
            return (Criteria) this;
        }

        public Criteria andContent2IsNull() {
            addCriterion("content2 is null");
            return (Criteria) this;
        }

        public Criteria andContent2IsNotNull() {
            addCriterion("content2 is not null");
            return (Criteria) this;
        }

        public Criteria andContent2EqualTo(String value) {
            addCriterion("content2 =", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2NotEqualTo(String value) {
            addCriterion("content2 <>", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2GreaterThan(String value) {
            addCriterion("content2 >", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2GreaterThanOrEqualTo(String value) {
            addCriterion("content2 >=", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2LessThan(String value) {
            addCriterion("content2 <", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2LessThanOrEqualTo(String value) {
            addCriterion("content2 <=", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2Like(String value) {
            addCriterion("content2 like", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2NotLike(String value) {
            addCriterion("content2 not like", value, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2In(List<String> values) {
            addCriterion("content2 in", values, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2NotIn(List<String> values) {
            addCriterion("content2 not in", values, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2Between(String value1, String value2) {
            addCriterion("content2 between", value1, value2, "content2");
            return (Criteria) this;
        }

        public Criteria andContent2NotBetween(String value1, String value2) {
            addCriterion("content2 not between", value1, value2, "content2");
            return (Criteria) this;
        }

        public Criteria andContent3IsNull() {
            addCriterion("content3 is null");
            return (Criteria) this;
        }

        public Criteria andContent3IsNotNull() {
            addCriterion("content3 is not null");
            return (Criteria) this;
        }

        public Criteria andContent3EqualTo(String value) {
            addCriterion("content3 =", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3NotEqualTo(String value) {
            addCriterion("content3 <>", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3GreaterThan(String value) {
            addCriterion("content3 >", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3GreaterThanOrEqualTo(String value) {
            addCriterion("content3 >=", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3LessThan(String value) {
            addCriterion("content3 <", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3LessThanOrEqualTo(String value) {
            addCriterion("content3 <=", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3Like(String value) {
            addCriterion("content3 like", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3NotLike(String value) {
            addCriterion("content3 not like", value, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3In(List<String> values) {
            addCriterion("content3 in", values, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3NotIn(List<String> values) {
            addCriterion("content3 not in", values, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3Between(String value1, String value2) {
            addCriterion("content3 between", value1, value2, "content3");
            return (Criteria) this;
        }

        public Criteria andContent3NotBetween(String value1, String value2) {
            addCriterion("content3 not between", value1, value2, "content3");
            return (Criteria) this;
        }

        public Criteria andContent4IsNull() {
            addCriterion("content4 is null");
            return (Criteria) this;
        }

        public Criteria andContent4IsNotNull() {
            addCriterion("content4 is not null");
            return (Criteria) this;
        }

        public Criteria andContent4EqualTo(String value) {
            addCriterion("content4 =", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4NotEqualTo(String value) {
            addCriterion("content4 <>", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4GreaterThan(String value) {
            addCriterion("content4 >", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4GreaterThanOrEqualTo(String value) {
            addCriterion("content4 >=", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4LessThan(String value) {
            addCriterion("content4 <", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4LessThanOrEqualTo(String value) {
            addCriterion("content4 <=", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4Like(String value) {
            addCriterion("content4 like", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4NotLike(String value) {
            addCriterion("content4 not like", value, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4In(List<String> values) {
            addCriterion("content4 in", values, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4NotIn(List<String> values) {
            addCriterion("content4 not in", values, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4Between(String value1, String value2) {
            addCriterion("content4 between", value1, value2, "content4");
            return (Criteria) this;
        }

        public Criteria andContent4NotBetween(String value1, String value2) {
            addCriterion("content4 not between", value1, value2, "content4");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIsNull() {
            addCriterion("complete_time is null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIsNotNull() {
            addCriterion("complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeEqualTo(Date value) {
            addCriterion("complete_time =", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotEqualTo(Date value) {
            addCriterion("complete_time <>", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThan(Date value) {
            addCriterion("complete_time >", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("complete_time >=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThan(Date value) {
            addCriterion("complete_time <", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("complete_time <=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIn(List<Date> values) {
            addCriterion("complete_time in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotIn(List<Date> values) {
            addCriterion("complete_time not in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeBetween(Date value1, Date value2) {
            addCriterion("complete_time between", value1, value2, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("complete_time not between", value1, value2, "completeTime");
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