package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaSuitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaSuitExample() {
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

    public OaSuitExample(int pageSize, int pageIndex) {
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

        public Criteria andAppraisedPersonIsNull() {
            addCriterion("appraised_person is null");
            return (Criteria) this;
        }

        public Criteria andAppraisedPersonIsNotNull() {
            addCriterion("appraised_person is not null");
            return (Criteria) this;
        }

        public Criteria andAppraisedPersonEqualTo(String value) {
            addCriterion("appraised_person =", value, "appraisedPerson");
            return (Criteria) this;
        }

        public Criteria andAppraisedPersonNotEqualTo(String value) {
            addCriterion("appraised_person <>", value, "appraisedPerson");
            return (Criteria) this;
        }

        public Criteria andAppraisedPersonGreaterThan(String value) {
            addCriterion("appraised_person >", value, "appraisedPerson");
            return (Criteria) this;
        }

        public Criteria andAppraisedPersonGreaterThanOrEqualTo(String value) {
            addCriterion("appraised_person >=", value, "appraisedPerson");
            return (Criteria) this;
        }

        public Criteria andAppraisedPersonLessThan(String value) {
            addCriterion("appraised_person <", value, "appraisedPerson");
            return (Criteria) this;
        }

        public Criteria andAppraisedPersonLessThanOrEqualTo(String value) {
            addCriterion("appraised_person <=", value, "appraisedPerson");
            return (Criteria) this;
        }

        public Criteria andAppraisedPersonLike(String value) {
            addCriterion("appraised_person like", value, "appraisedPerson");
            return (Criteria) this;
        }

        public Criteria andAppraisedPersonNotLike(String value) {
            addCriterion("appraised_person not like", value, "appraisedPerson");
            return (Criteria) this;
        }

        public Criteria andAppraisedPersonIn(List<String> values) {
            addCriterion("appraised_person in", values, "appraisedPerson");
            return (Criteria) this;
        }

        public Criteria andAppraisedPersonNotIn(List<String> values) {
            addCriterion("appraised_person not in", values, "appraisedPerson");
            return (Criteria) this;
        }

        public Criteria andAppraisedPersonBetween(String value1, String value2) {
            addCriterion("appraised_person between", value1, value2, "appraisedPerson");
            return (Criteria) this;
        }

        public Criteria andAppraisedPersonNotBetween(String value1, String value2) {
            addCriterion("appraised_person not between", value1, value2, "appraisedPerson");
            return (Criteria) this;
        }

        public Criteria andSiteIsNull() {
            addCriterion("site is null");
            return (Criteria) this;
        }

        public Criteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (Criteria) this;
        }

        public Criteria andSiteEqualTo(String value) {
            addCriterion("site =", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotEqualTo(String value) {
            addCriterion("site <>", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThan(String value) {
            addCriterion("site >", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThanOrEqualTo(String value) {
            addCriterion("site >=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThan(String value) {
            addCriterion("site <", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThanOrEqualTo(String value) {
            addCriterion("site <=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLike(String value) {
            addCriterion("site like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotLike(String value) {
            addCriterion("site not like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteIn(List<String> values) {
            addCriterion("site in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotIn(List<String> values) {
            addCriterion("site not in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteBetween(String value1, String value2) {
            addCriterion("site between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotBetween(String value1, String value2) {
            addCriterion("site not between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andEntrustingDateIsNull() {
            addCriterion("entrusting_date is null");
            return (Criteria) this;
        }

        public Criteria andEntrustingDateIsNotNull() {
            addCriterion("entrusting_date is not null");
            return (Criteria) this;
        }

        public Criteria andEntrustingDateEqualTo(Date value) {
            addCriterion("entrusting_date =", value, "entrustingDate");
            return (Criteria) this;
        }

        public Criteria andEntrustingDateNotEqualTo(Date value) {
            addCriterion("entrusting_date <>", value, "entrustingDate");
            return (Criteria) this;
        }

        public Criteria andEntrustingDateGreaterThan(Date value) {
            addCriterion("entrusting_date >", value, "entrustingDate");
            return (Criteria) this;
        }

        public Criteria andEntrustingDateGreaterThanOrEqualTo(Date value) {
            addCriterion("entrusting_date >=", value, "entrustingDate");
            return (Criteria) this;
        }

        public Criteria andEntrustingDateLessThan(Date value) {
            addCriterion("entrusting_date <", value, "entrustingDate");
            return (Criteria) this;
        }

        public Criteria andEntrustingDateLessThanOrEqualTo(Date value) {
            addCriterion("entrusting_date <=", value, "entrustingDate");
            return (Criteria) this;
        }

        public Criteria andEntrustingDateIn(List<Date> values) {
            addCriterion("entrusting_date in", values, "entrustingDate");
            return (Criteria) this;
        }

        public Criteria andEntrustingDateNotIn(List<Date> values) {
            addCriterion("entrusting_date not in", values, "entrustingDate");
            return (Criteria) this;
        }

        public Criteria andEntrustingDateBetween(Date value1, Date value2) {
            addCriterion("entrusting_date between", value1, value2, "entrustingDate");
            return (Criteria) this;
        }

        public Criteria andEntrustingDateNotBetween(Date value1, Date value2) {
            addCriterion("entrusting_date not between", value1, value2, "entrustingDate");
            return (Criteria) this;
        }

        public Criteria andEntrustingPersonIsNull() {
            addCriterion("entrusting_person is null");
            return (Criteria) this;
        }

        public Criteria andEntrustingPersonIsNotNull() {
            addCriterion("entrusting_person is not null");
            return (Criteria) this;
        }

        public Criteria andEntrustingPersonEqualTo(String value) {
            addCriterion("entrusting_person =", value, "entrustingPerson");
            return (Criteria) this;
        }

        public Criteria andEntrustingPersonNotEqualTo(String value) {
            addCriterion("entrusting_person <>", value, "entrustingPerson");
            return (Criteria) this;
        }

        public Criteria andEntrustingPersonGreaterThan(String value) {
            addCriterion("entrusting_person >", value, "entrustingPerson");
            return (Criteria) this;
        }

        public Criteria andEntrustingPersonGreaterThanOrEqualTo(String value) {
            addCriterion("entrusting_person >=", value, "entrustingPerson");
            return (Criteria) this;
        }

        public Criteria andEntrustingPersonLessThan(String value) {
            addCriterion("entrusting_person <", value, "entrustingPerson");
            return (Criteria) this;
        }

        public Criteria andEntrustingPersonLessThanOrEqualTo(String value) {
            addCriterion("entrusting_person <=", value, "entrustingPerson");
            return (Criteria) this;
        }

        public Criteria andEntrustingPersonLike(String value) {
            addCriterion("entrusting_person like", value, "entrustingPerson");
            return (Criteria) this;
        }

        public Criteria andEntrustingPersonNotLike(String value) {
            addCriterion("entrusting_person not like", value, "entrustingPerson");
            return (Criteria) this;
        }

        public Criteria andEntrustingPersonIn(List<String> values) {
            addCriterion("entrusting_person in", values, "entrustingPerson");
            return (Criteria) this;
        }

        public Criteria andEntrustingPersonNotIn(List<String> values) {
            addCriterion("entrusting_person not in", values, "entrustingPerson");
            return (Criteria) this;
        }

        public Criteria andEntrustingPersonBetween(String value1, String value2) {
            addCriterion("entrusting_person between", value1, value2, "entrustingPerson");
            return (Criteria) this;
        }

        public Criteria andEntrustingPersonNotBetween(String value1, String value2) {
            addCriterion("entrusting_person not between", value1, value2, "entrustingPerson");
            return (Criteria) this;
        }

        public Criteria andCaseNumberIsNull() {
            addCriterion("case_number is null");
            return (Criteria) this;
        }

        public Criteria andCaseNumberIsNotNull() {
            addCriterion("case_number is not null");
            return (Criteria) this;
        }

        public Criteria andCaseNumberEqualTo(String value) {
            addCriterion("case_number =", value, "caseNumber");
            return (Criteria) this;
        }

        public Criteria andCaseNumberNotEqualTo(String value) {
            addCriterion("case_number <>", value, "caseNumber");
            return (Criteria) this;
        }

        public Criteria andCaseNumberGreaterThan(String value) {
            addCriterion("case_number >", value, "caseNumber");
            return (Criteria) this;
        }

        public Criteria andCaseNumberGreaterThanOrEqualTo(String value) {
            addCriterion("case_number >=", value, "caseNumber");
            return (Criteria) this;
        }

        public Criteria andCaseNumberLessThan(String value) {
            addCriterion("case_number <", value, "caseNumber");
            return (Criteria) this;
        }

        public Criteria andCaseNumberLessThanOrEqualTo(String value) {
            addCriterion("case_number <=", value, "caseNumber");
            return (Criteria) this;
        }

        public Criteria andCaseNumberLike(String value) {
            addCriterion("case_number like", value, "caseNumber");
            return (Criteria) this;
        }

        public Criteria andCaseNumberNotLike(String value) {
            addCriterion("case_number not like", value, "caseNumber");
            return (Criteria) this;
        }

        public Criteria andCaseNumberIn(List<String> values) {
            addCriterion("case_number in", values, "caseNumber");
            return (Criteria) this;
        }

        public Criteria andCaseNumberNotIn(List<String> values) {
            addCriterion("case_number not in", values, "caseNumber");
            return (Criteria) this;
        }

        public Criteria andCaseNumberBetween(String value1, String value2) {
            addCriterion("case_number between", value1, value2, "caseNumber");
            return (Criteria) this;
        }

        public Criteria andCaseNumberNotBetween(String value1, String value2) {
            addCriterion("case_number not between", value1, value2, "caseNumber");
            return (Criteria) this;
        }

        public Criteria andReceivableIsNull() {
            addCriterion("receivable is null");
            return (Criteria) this;
        }

        public Criteria andReceivableIsNotNull() {
            addCriterion("receivable is not null");
            return (Criteria) this;
        }

        public Criteria andReceivableEqualTo(Double value) {
            addCriterion("receivable =", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotEqualTo(Double value) {
            addCriterion("receivable <>", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableGreaterThan(Double value) {
            addCriterion("receivable >", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableGreaterThanOrEqualTo(Double value) {
            addCriterion("receivable >=", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableLessThan(Double value) {
            addCriterion("receivable <", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableLessThanOrEqualTo(Double value) {
            addCriterion("receivable <=", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableIn(List<Double> values) {
            addCriterion("receivable in", values, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotIn(List<Double> values) {
            addCriterion("receivable not in", values, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableBetween(Double value1, Double value2) {
            addCriterion("receivable between", value1, value2, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotBetween(Double value1, Double value2) {
            addCriterion("receivable not between", value1, value2, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivedIsNull() {
            addCriterion("received is null");
            return (Criteria) this;
        }

        public Criteria andReceivedIsNotNull() {
            addCriterion("received is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedEqualTo(Double value) {
            addCriterion("received =", value, "received");
            return (Criteria) this;
        }

        public Criteria andReceivedNotEqualTo(Double value) {
            addCriterion("received <>", value, "received");
            return (Criteria) this;
        }

        public Criteria andReceivedGreaterThan(Double value) {
            addCriterion("received >", value, "received");
            return (Criteria) this;
        }

        public Criteria andReceivedGreaterThanOrEqualTo(Double value) {
            addCriterion("received >=", value, "received");
            return (Criteria) this;
        }

        public Criteria andReceivedLessThan(Double value) {
            addCriterion("received <", value, "received");
            return (Criteria) this;
        }

        public Criteria andReceivedLessThanOrEqualTo(Double value) {
            addCriterion("received <=", value, "received");
            return (Criteria) this;
        }

        public Criteria andReceivedIn(List<Double> values) {
            addCriterion("received in", values, "received");
            return (Criteria) this;
        }

        public Criteria andReceivedNotIn(List<Double> values) {
            addCriterion("received not in", values, "received");
            return (Criteria) this;
        }

        public Criteria andReceivedBetween(Double value1, Double value2) {
            addCriterion("received between", value1, value2, "received");
            return (Criteria) this;
        }

        public Criteria andReceivedNotBetween(Double value1, Double value2) {
            addCriterion("received not between", value1, value2, "received");
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

        public Criteria andApprasingPersonIsNull() {
            addCriterion("apprasing_person is null");
            return (Criteria) this;
        }

        public Criteria andApprasingPersonIsNotNull() {
            addCriterion("apprasing_person is not null");
            return (Criteria) this;
        }

        public Criteria andApprasingPersonEqualTo(String value) {
            addCriterion("apprasing_person =", value, "apprasingPerson");
            return (Criteria) this;
        }

        public Criteria andApprasingPersonNotEqualTo(String value) {
            addCriterion("apprasing_person <>", value, "apprasingPerson");
            return (Criteria) this;
        }

        public Criteria andApprasingPersonGreaterThan(String value) {
            addCriterion("apprasing_person >", value, "apprasingPerson");
            return (Criteria) this;
        }

        public Criteria andApprasingPersonGreaterThanOrEqualTo(String value) {
            addCriterion("apprasing_person >=", value, "apprasingPerson");
            return (Criteria) this;
        }

        public Criteria andApprasingPersonLessThan(String value) {
            addCriterion("apprasing_person <", value, "apprasingPerson");
            return (Criteria) this;
        }

        public Criteria andApprasingPersonLessThanOrEqualTo(String value) {
            addCriterion("apprasing_person <=", value, "apprasingPerson");
            return (Criteria) this;
        }

        public Criteria andApprasingPersonLike(String value) {
            addCriterion("apprasing_person like", value, "apprasingPerson");
            return (Criteria) this;
        }

        public Criteria andApprasingPersonNotLike(String value) {
            addCriterion("apprasing_person not like", value, "apprasingPerson");
            return (Criteria) this;
        }

        public Criteria andApprasingPersonIn(List<String> values) {
            addCriterion("apprasing_person in", values, "apprasingPerson");
            return (Criteria) this;
        }

        public Criteria andApprasingPersonNotIn(List<String> values) {
            addCriterion("apprasing_person not in", values, "apprasingPerson");
            return (Criteria) this;
        }

        public Criteria andApprasingPersonBetween(String value1, String value2) {
            addCriterion("apprasing_person between", value1, value2, "apprasingPerson");
            return (Criteria) this;
        }

        public Criteria andApprasingPersonNotBetween(String value1, String value2) {
            addCriterion("apprasing_person not between", value1, value2, "apprasingPerson");
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