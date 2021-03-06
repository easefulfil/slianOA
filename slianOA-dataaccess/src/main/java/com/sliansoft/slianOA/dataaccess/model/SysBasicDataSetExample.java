package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.List;

public class SysBasicDataSetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public SysBasicDataSetExample() {
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

    public SysBasicDataSetExample(int pageSize, int pageIndex) {
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

        public Criteria andBasicDataIdIsNull() {
            addCriterion("basic_data_id is null");
            return (Criteria) this;
        }

        public Criteria andBasicDataIdIsNotNull() {
            addCriterion("basic_data_id is not null");
            return (Criteria) this;
        }

        public Criteria andBasicDataIdEqualTo(Integer value) {
            addCriterion("basic_data_id =", value, "basicDataId");
            return (Criteria) this;
        }

        public Criteria andBasicDataIdNotEqualTo(Integer value) {
            addCriterion("basic_data_id <>", value, "basicDataId");
            return (Criteria) this;
        }

        public Criteria andBasicDataIdGreaterThan(Integer value) {
            addCriterion("basic_data_id >", value, "basicDataId");
            return (Criteria) this;
        }

        public Criteria andBasicDataIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("basic_data_id >=", value, "basicDataId");
            return (Criteria) this;
        }

        public Criteria andBasicDataIdLessThan(Integer value) {
            addCriterion("basic_data_id <", value, "basicDataId");
            return (Criteria) this;
        }

        public Criteria andBasicDataIdLessThanOrEqualTo(Integer value) {
            addCriterion("basic_data_id <=", value, "basicDataId");
            return (Criteria) this;
        }

        public Criteria andBasicDataIdIn(List<Integer> values) {
            addCriterion("basic_data_id in", values, "basicDataId");
            return (Criteria) this;
        }

        public Criteria andBasicDataIdNotIn(List<Integer> values) {
            addCriterion("basic_data_id not in", values, "basicDataId");
            return (Criteria) this;
        }

        public Criteria andBasicDataIdBetween(Integer value1, Integer value2) {
            addCriterion("basic_data_id between", value1, value2, "basicDataId");
            return (Criteria) this;
        }

        public Criteria andBasicDataIdNotBetween(Integer value1, Integer value2) {
            addCriterion("basic_data_id not between", value1, value2, "basicDataId");
            return (Criteria) this;
        }

        public Criteria andChineseNameIsNull() {
            addCriterion("Chinese_name is null");
            return (Criteria) this;
        }

        public Criteria andChineseNameIsNotNull() {
            addCriterion("Chinese_name is not null");
            return (Criteria) this;
        }

        public Criteria andChineseNameEqualTo(String value) {
            addCriterion("Chinese_name =", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotEqualTo(String value) {
            addCriterion("Chinese_name <>", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameGreaterThan(String value) {
            addCriterion("Chinese_name >", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameGreaterThanOrEqualTo(String value) {
            addCriterion("Chinese_name >=", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameLessThan(String value) {
            addCriterion("Chinese_name <", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameLessThanOrEqualTo(String value) {
            addCriterion("Chinese_name <=", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameLike(String value) {
            addCriterion("Chinese_name like", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotLike(String value) {
            addCriterion("Chinese_name not like", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameIn(List<String> values) {
            addCriterion("Chinese_name in", values, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotIn(List<String> values) {
            addCriterion("Chinese_name not in", values, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameBetween(String value1, String value2) {
            addCriterion("Chinese_name between", value1, value2, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotBetween(String value1, String value2) {
            addCriterion("Chinese_name not between", value1, value2, "chineseName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNull() {
            addCriterion("English_name is null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNotNull() {
            addCriterion("English_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameEqualTo(String value) {
            addCriterion("English_name =", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotEqualTo(String value) {
            addCriterion("English_name <>", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThan(String value) {
            addCriterion("English_name >", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThanOrEqualTo(String value) {
            addCriterion("English_name >=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThan(String value) {
            addCriterion("English_name <", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThanOrEqualTo(String value) {
            addCriterion("English_name <=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLike(String value) {
            addCriterion("English_name like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotLike(String value) {
            addCriterion("English_name not like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIn(List<String> values) {
            addCriterion("English_name in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotIn(List<String> values) {
            addCriterion("English_name not in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameBetween(String value1, String value2) {
            addCriterion("English_name between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotBetween(String value1, String value2) {
            addCriterion("English_name not between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdIsNull() {
            addCriterion("parent_node_id is null");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdIsNotNull() {
            addCriterion("parent_node_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdEqualTo(Integer value) {
            addCriterion("parent_node_id =", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdNotEqualTo(Integer value) {
            addCriterion("parent_node_id <>", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdGreaterThan(Integer value) {
            addCriterion("parent_node_id >", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_node_id >=", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdLessThan(Integer value) {
            addCriterion("parent_node_id <", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_node_id <=", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdIn(List<Integer> values) {
            addCriterion("parent_node_id in", values, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdNotIn(List<Integer> values) {
            addCriterion("parent_node_id not in", values, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_node_id between", value1, value2, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_node_id not between", value1, value2, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andBasicDataTypeIsNull() {
            addCriterion("basic_data_type is null");
            return (Criteria) this;
        }

        public Criteria andBasicDataTypeIsNotNull() {
            addCriterion("basic_data_type is not null");
            return (Criteria) this;
        }

        public Criteria andBasicDataTypeEqualTo(String value) {
            addCriterion("basic_data_type =", value, "basicDataType");
            return (Criteria) this;
        }

        public Criteria andBasicDataTypeNotEqualTo(String value) {
            addCriterion("basic_data_type <>", value, "basicDataType");
            return (Criteria) this;
        }

        public Criteria andBasicDataTypeGreaterThan(String value) {
            addCriterion("basic_data_type >", value, "basicDataType");
            return (Criteria) this;
        }

        public Criteria andBasicDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("basic_data_type >=", value, "basicDataType");
            return (Criteria) this;
        }

        public Criteria andBasicDataTypeLessThan(String value) {
            addCriterion("basic_data_type <", value, "basicDataType");
            return (Criteria) this;
        }

        public Criteria andBasicDataTypeLessThanOrEqualTo(String value) {
            addCriterion("basic_data_type <=", value, "basicDataType");
            return (Criteria) this;
        }

        public Criteria andBasicDataTypeLike(String value) {
            addCriterion("basic_data_type like", value, "basicDataType");
            return (Criteria) this;
        }

        public Criteria andBasicDataTypeNotLike(String value) {
            addCriterion("basic_data_type not like", value, "basicDataType");
            return (Criteria) this;
        }

        public Criteria andBasicDataTypeIn(List<String> values) {
            addCriterion("basic_data_type in", values, "basicDataType");
            return (Criteria) this;
        }

        public Criteria andBasicDataTypeNotIn(List<String> values) {
            addCriterion("basic_data_type not in", values, "basicDataType");
            return (Criteria) this;
        }

        public Criteria andBasicDataTypeBetween(String value1, String value2) {
            addCriterion("basic_data_type between", value1, value2, "basicDataType");
            return (Criteria) this;
        }

        public Criteria andBasicDataTypeNotBetween(String value1, String value2) {
            addCriterion("basic_data_type not between", value1, value2, "basicDataType");
            return (Criteria) this;
        }

        public Criteria andBasicDataStatusIsNull() {
            addCriterion("basic_data_status is null");
            return (Criteria) this;
        }

        public Criteria andBasicDataStatusIsNotNull() {
            addCriterion("basic_data_status is not null");
            return (Criteria) this;
        }

        public Criteria andBasicDataStatusEqualTo(String value) {
            addCriterion("basic_data_status =", value, "basicDataStatus");
            return (Criteria) this;
        }

        public Criteria andBasicDataStatusNotEqualTo(String value) {
            addCriterion("basic_data_status <>", value, "basicDataStatus");
            return (Criteria) this;
        }

        public Criteria andBasicDataStatusGreaterThan(String value) {
            addCriterion("basic_data_status >", value, "basicDataStatus");
            return (Criteria) this;
        }

        public Criteria andBasicDataStatusGreaterThanOrEqualTo(String value) {
            addCriterion("basic_data_status >=", value, "basicDataStatus");
            return (Criteria) this;
        }

        public Criteria andBasicDataStatusLessThan(String value) {
            addCriterion("basic_data_status <", value, "basicDataStatus");
            return (Criteria) this;
        }

        public Criteria andBasicDataStatusLessThanOrEqualTo(String value) {
            addCriterion("basic_data_status <=", value, "basicDataStatus");
            return (Criteria) this;
        }

        public Criteria andBasicDataStatusLike(String value) {
            addCriterion("basic_data_status like", value, "basicDataStatus");
            return (Criteria) this;
        }

        public Criteria andBasicDataStatusNotLike(String value) {
            addCriterion("basic_data_status not like", value, "basicDataStatus");
            return (Criteria) this;
        }

        public Criteria andBasicDataStatusIn(List<String> values) {
            addCriterion("basic_data_status in", values, "basicDataStatus");
            return (Criteria) this;
        }

        public Criteria andBasicDataStatusNotIn(List<String> values) {
            addCriterion("basic_data_status not in", values, "basicDataStatus");
            return (Criteria) this;
        }

        public Criteria andBasicDataStatusBetween(String value1, String value2) {
            addCriterion("basic_data_status between", value1, value2, "basicDataStatus");
            return (Criteria) this;
        }

        public Criteria andBasicDataStatusNotBetween(String value1, String value2) {
            addCriterion("basic_data_status not between", value1, value2, "basicDataStatus");
            return (Criteria) this;
        }

        public Criteria andBasicDataRemarkIsNull() {
            addCriterion("basic_data_remark is null");
            return (Criteria) this;
        }

        public Criteria andBasicDataRemarkIsNotNull() {
            addCriterion("basic_data_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBasicDataRemarkEqualTo(String value) {
            addCriterion("basic_data_remark =", value, "basicDataRemark");
            return (Criteria) this;
        }

        public Criteria andBasicDataRemarkNotEqualTo(String value) {
            addCriterion("basic_data_remark <>", value, "basicDataRemark");
            return (Criteria) this;
        }

        public Criteria andBasicDataRemarkGreaterThan(String value) {
            addCriterion("basic_data_remark >", value, "basicDataRemark");
            return (Criteria) this;
        }

        public Criteria andBasicDataRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("basic_data_remark >=", value, "basicDataRemark");
            return (Criteria) this;
        }

        public Criteria andBasicDataRemarkLessThan(String value) {
            addCriterion("basic_data_remark <", value, "basicDataRemark");
            return (Criteria) this;
        }

        public Criteria andBasicDataRemarkLessThanOrEqualTo(String value) {
            addCriterion("basic_data_remark <=", value, "basicDataRemark");
            return (Criteria) this;
        }

        public Criteria andBasicDataRemarkLike(String value) {
            addCriterion("basic_data_remark like", value, "basicDataRemark");
            return (Criteria) this;
        }

        public Criteria andBasicDataRemarkNotLike(String value) {
            addCriterion("basic_data_remark not like", value, "basicDataRemark");
            return (Criteria) this;
        }

        public Criteria andBasicDataRemarkIn(List<String> values) {
            addCriterion("basic_data_remark in", values, "basicDataRemark");
            return (Criteria) this;
        }

        public Criteria andBasicDataRemarkNotIn(List<String> values) {
            addCriterion("basic_data_remark not in", values, "basicDataRemark");
            return (Criteria) this;
        }

        public Criteria andBasicDataRemarkBetween(String value1, String value2) {
            addCriterion("basic_data_remark between", value1, value2, "basicDataRemark");
            return (Criteria) this;
        }

        public Criteria andBasicDataRemarkNotBetween(String value1, String value2) {
            addCriterion("basic_data_remark not between", value1, value2, "basicDataRemark");
            return (Criteria) this;
        }

        public Criteria andBasicDataPopularityIsNull() {
            addCriterion("basic_data_popularity is null");
            return (Criteria) this;
        }

        public Criteria andBasicDataPopularityIsNotNull() {
            addCriterion("basic_data_popularity is not null");
            return (Criteria) this;
        }

        public Criteria andBasicDataPopularityEqualTo(Integer value) {
            addCriterion("basic_data_popularity =", value, "basicDataPopularity");
            return (Criteria) this;
        }

        public Criteria andBasicDataPopularityNotEqualTo(Integer value) {
            addCriterion("basic_data_popularity <>", value, "basicDataPopularity");
            return (Criteria) this;
        }

        public Criteria andBasicDataPopularityGreaterThan(Integer value) {
            addCriterion("basic_data_popularity >", value, "basicDataPopularity");
            return (Criteria) this;
        }

        public Criteria andBasicDataPopularityGreaterThanOrEqualTo(Integer value) {
            addCriterion("basic_data_popularity >=", value, "basicDataPopularity");
            return (Criteria) this;
        }

        public Criteria andBasicDataPopularityLessThan(Integer value) {
            addCriterion("basic_data_popularity <", value, "basicDataPopularity");
            return (Criteria) this;
        }

        public Criteria andBasicDataPopularityLessThanOrEqualTo(Integer value) {
            addCriterion("basic_data_popularity <=", value, "basicDataPopularity");
            return (Criteria) this;
        }

        public Criteria andBasicDataPopularityIn(List<Integer> values) {
            addCriterion("basic_data_popularity in", values, "basicDataPopularity");
            return (Criteria) this;
        }

        public Criteria andBasicDataPopularityNotIn(List<Integer> values) {
            addCriterion("basic_data_popularity not in", values, "basicDataPopularity");
            return (Criteria) this;
        }

        public Criteria andBasicDataPopularityBetween(Integer value1, Integer value2) {
            addCriterion("basic_data_popularity between", value1, value2, "basicDataPopularity");
            return (Criteria) this;
        }

        public Criteria andBasicDataPopularityNotBetween(Integer value1, Integer value2) {
            addCriterion("basic_data_popularity not between", value1, value2, "basicDataPopularity");
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