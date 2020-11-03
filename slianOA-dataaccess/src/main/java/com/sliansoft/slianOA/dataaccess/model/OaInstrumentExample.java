package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OaInstrumentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaInstrumentExample() {
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

    public OaInstrumentExample(int pageSize, int pageIndex) {
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

        public Criteria andInstrumentIdIsNull() {
            addCriterion("instrument_id is null");
            return (Criteria) this;
        }

        public Criteria andInstrumentIdIsNotNull() {
            addCriterion("instrument_id is not null");
            return (Criteria) this;
        }

        public Criteria andInstrumentIdEqualTo(Integer value) {
            addCriterion("instrument_id =", value, "instrumentId");
            return (Criteria) this;
        }

        public Criteria andInstrumentIdNotEqualTo(Integer value) {
            addCriterion("instrument_id <>", value, "instrumentId");
            return (Criteria) this;
        }

        public Criteria andInstrumentIdGreaterThan(Integer value) {
            addCriterion("instrument_id >", value, "instrumentId");
            return (Criteria) this;
        }

        public Criteria andInstrumentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("instrument_id >=", value, "instrumentId");
            return (Criteria) this;
        }

        public Criteria andInstrumentIdLessThan(Integer value) {
            addCriterion("instrument_id <", value, "instrumentId");
            return (Criteria) this;
        }

        public Criteria andInstrumentIdLessThanOrEqualTo(Integer value) {
            addCriterion("instrument_id <=", value, "instrumentId");
            return (Criteria) this;
        }

        public Criteria andInstrumentIdIn(List<Integer> values) {
            addCriterion("instrument_id in", values, "instrumentId");
            return (Criteria) this;
        }

        public Criteria andInstrumentIdNotIn(List<Integer> values) {
            addCriterion("instrument_id not in", values, "instrumentId");
            return (Criteria) this;
        }

        public Criteria andInstrumentIdBetween(Integer value1, Integer value2) {
            addCriterion("instrument_id between", value1, value2, "instrumentId");
            return (Criteria) this;
        }

        public Criteria andInstrumentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("instrument_id not between", value1, value2, "instrumentId");
            return (Criteria) this;
        }

        public Criteria andInstrumentNameIsNull() {
            addCriterion("instrument_name is null");
            return (Criteria) this;
        }

        public Criteria andInstrumentNameIsNotNull() {
            addCriterion("instrument_name is not null");
            return (Criteria) this;
        }

        public Criteria andInstrumentNameEqualTo(String value) {
            addCriterion("instrument_name =", value, "instrumentName");
            return (Criteria) this;
        }

        public Criteria andInstrumentNameNotEqualTo(String value) {
            addCriterion("instrument_name <>", value, "instrumentName");
            return (Criteria) this;
        }

        public Criteria andInstrumentNameGreaterThan(String value) {
            addCriterion("instrument_name >", value, "instrumentName");
            return (Criteria) this;
        }

        public Criteria andInstrumentNameGreaterThanOrEqualTo(String value) {
            addCriterion("instrument_name >=", value, "instrumentName");
            return (Criteria) this;
        }

        public Criteria andInstrumentNameLessThan(String value) {
            addCriterion("instrument_name <", value, "instrumentName");
            return (Criteria) this;
        }

        public Criteria andInstrumentNameLessThanOrEqualTo(String value) {
            addCriterion("instrument_name <=", value, "instrumentName");
            return (Criteria) this;
        }

        public Criteria andInstrumentNameLike(String value) {
            addCriterion("instrument_name like", value, "instrumentName");
            return (Criteria) this;
        }

        public Criteria andInstrumentNameNotLike(String value) {
            addCriterion("instrument_name not like", value, "instrumentName");
            return (Criteria) this;
        }

        public Criteria andInstrumentNameIn(List<String> values) {
            addCriterion("instrument_name in", values, "instrumentName");
            return (Criteria) this;
        }

        public Criteria andInstrumentNameNotIn(List<String> values) {
            addCriterion("instrument_name not in", values, "instrumentName");
            return (Criteria) this;
        }

        public Criteria andInstrumentNameBetween(String value1, String value2) {
            addCriterion("instrument_name between", value1, value2, "instrumentName");
            return (Criteria) this;
        }

        public Criteria andInstrumentNameNotBetween(String value1, String value2) {
            addCriterion("instrument_name not between", value1, value2, "instrumentName");
            return (Criteria) this;
        }

        public Criteria andInstrumentCodeIsNull() {
            addCriterion("instrument_code is null");
            return (Criteria) this;
        }

        public Criteria andInstrumentCodeIsNotNull() {
            addCriterion("instrument_code is not null");
            return (Criteria) this;
        }

        public Criteria andInstrumentCodeEqualTo(String value) {
            addCriterion("instrument_code =", value, "instrumentCode");
            return (Criteria) this;
        }

        public Criteria andInstrumentCodeNotEqualTo(String value) {
            addCriterion("instrument_code <>", value, "instrumentCode");
            return (Criteria) this;
        }

        public Criteria andInstrumentCodeGreaterThan(String value) {
            addCriterion("instrument_code >", value, "instrumentCode");
            return (Criteria) this;
        }

        public Criteria andInstrumentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("instrument_code >=", value, "instrumentCode");
            return (Criteria) this;
        }

        public Criteria andInstrumentCodeLessThan(String value) {
            addCriterion("instrument_code <", value, "instrumentCode");
            return (Criteria) this;
        }

        public Criteria andInstrumentCodeLessThanOrEqualTo(String value) {
            addCriterion("instrument_code <=", value, "instrumentCode");
            return (Criteria) this;
        }

        public Criteria andInstrumentCodeLike(String value) {
            addCriterion("instrument_code like", value, "instrumentCode");
            return (Criteria) this;
        }

        public Criteria andInstrumentCodeNotLike(String value) {
            addCriterion("instrument_code not like", value, "instrumentCode");
            return (Criteria) this;
        }

        public Criteria andInstrumentCodeIn(List<String> values) {
            addCriterion("instrument_code in", values, "instrumentCode");
            return (Criteria) this;
        }

        public Criteria andInstrumentCodeNotIn(List<String> values) {
            addCriterion("instrument_code not in", values, "instrumentCode");
            return (Criteria) this;
        }

        public Criteria andInstrumentCodeBetween(String value1, String value2) {
            addCriterion("instrument_code between", value1, value2, "instrumentCode");
            return (Criteria) this;
        }

        public Criteria andInstrumentCodeNotBetween(String value1, String value2) {
            addCriterion("instrument_code not between", value1, value2, "instrumentCode");
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

        public Criteria andBuyDateIsNull() {
            addCriterion("buy_date is null");
            return (Criteria) this;
        }

        public Criteria andBuyDateIsNotNull() {
            addCriterion("buy_date is not null");
            return (Criteria) this;
        }

        public Criteria andBuyDateEqualTo(Date value) {
            addCriterionForJDBCDate("buy_date =", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("buy_date <>", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateGreaterThan(Date value) {
            addCriterionForJDBCDate("buy_date >", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buy_date >=", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateLessThan(Date value) {
            addCriterionForJDBCDate("buy_date <", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buy_date <=", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateIn(List<Date> values) {
            addCriterionForJDBCDate("buy_date in", values, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("buy_date not in", values, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buy_date between", value1, value2, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buy_date not between", value1, value2, "buyDate");
            return (Criteria) this;
        }

        public Criteria andCalibrationTimeIsNull() {
            addCriterion("calibration_time is null");
            return (Criteria) this;
        }

        public Criteria andCalibrationTimeIsNotNull() {
            addCriterion("calibration_time is not null");
            return (Criteria) this;
        }

        public Criteria andCalibrationTimeEqualTo(Date value) {
            addCriterion("calibration_time =", value, "calibrationTime");
            return (Criteria) this;
        }

        public Criteria andCalibrationTimeNotEqualTo(Date value) {
            addCriterion("calibration_time <>", value, "calibrationTime");
            return (Criteria) this;
        }

        public Criteria andCalibrationTimeGreaterThan(Date value) {
            addCriterion("calibration_time >", value, "calibrationTime");
            return (Criteria) this;
        }

        public Criteria andCalibrationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("calibration_time >=", value, "calibrationTime");
            return (Criteria) this;
        }

        public Criteria andCalibrationTimeLessThan(Date value) {
            addCriterion("calibration_time <", value, "calibrationTime");
            return (Criteria) this;
        }

        public Criteria andCalibrationTimeLessThanOrEqualTo(Date value) {
            addCriterion("calibration_time <=", value, "calibrationTime");
            return (Criteria) this;
        }

        public Criteria andCalibrationTimeIn(List<Date> values) {
            addCriterion("calibration_time in", values, "calibrationTime");
            return (Criteria) this;
        }

        public Criteria andCalibrationTimeNotIn(List<Date> values) {
            addCriterion("calibration_time not in", values, "calibrationTime");
            return (Criteria) this;
        }

        public Criteria andCalibrationTimeBetween(Date value1, Date value2) {
            addCriterion("calibration_time between", value1, value2, "calibrationTime");
            return (Criteria) this;
        }

        public Criteria andCalibrationTimeNotBetween(Date value1, Date value2) {
            addCriterion("calibration_time not between", value1, value2, "calibrationTime");
            return (Criteria) this;
        }

        public Criteria andCalibrationStatusIsNull() {
            addCriterion("calibration_status is null");
            return (Criteria) this;
        }

        public Criteria andCalibrationStatusIsNotNull() {
            addCriterion("calibration_status is not null");
            return (Criteria) this;
        }

        public Criteria andCalibrationStatusEqualTo(String value) {
            addCriterion("calibration_status =", value, "calibrationStatus");
            return (Criteria) this;
        }

        public Criteria andCalibrationStatusNotEqualTo(String value) {
            addCriterion("calibration_status <>", value, "calibrationStatus");
            return (Criteria) this;
        }

        public Criteria andCalibrationStatusGreaterThan(String value) {
            addCriterion("calibration_status >", value, "calibrationStatus");
            return (Criteria) this;
        }

        public Criteria andCalibrationStatusGreaterThanOrEqualTo(String value) {
            addCriterion("calibration_status >=", value, "calibrationStatus");
            return (Criteria) this;
        }

        public Criteria andCalibrationStatusLessThan(String value) {
            addCriterion("calibration_status <", value, "calibrationStatus");
            return (Criteria) this;
        }

        public Criteria andCalibrationStatusLessThanOrEqualTo(String value) {
            addCriterion("calibration_status <=", value, "calibrationStatus");
            return (Criteria) this;
        }

        public Criteria andCalibrationStatusLike(String value) {
            addCriterion("calibration_status like", value, "calibrationStatus");
            return (Criteria) this;
        }

        public Criteria andCalibrationStatusNotLike(String value) {
            addCriterion("calibration_status not like", value, "calibrationStatus");
            return (Criteria) this;
        }

        public Criteria andCalibrationStatusIn(List<String> values) {
            addCriterion("calibration_status in", values, "calibrationStatus");
            return (Criteria) this;
        }

        public Criteria andCalibrationStatusNotIn(List<String> values) {
            addCriterion("calibration_status not in", values, "calibrationStatus");
            return (Criteria) this;
        }

        public Criteria andCalibrationStatusBetween(String value1, String value2) {
            addCriterion("calibration_status between", value1, value2, "calibrationStatus");
            return (Criteria) this;
        }

        public Criteria andCalibrationStatusNotBetween(String value1, String value2) {
            addCriterion("calibration_status not between", value1, value2, "calibrationStatus");
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