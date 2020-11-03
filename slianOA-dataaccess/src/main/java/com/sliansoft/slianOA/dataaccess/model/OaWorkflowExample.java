package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaWorkflowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaWorkflowExample() {
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

    public OaWorkflowExample(int pageSize, int pageIndex) {
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

        public Criteria andWorkflowIdIsNull() {
            addCriterion("workflow_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdIsNotNull() {
            addCriterion("workflow_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdEqualTo(Integer value) {
            addCriterion("workflow_id =", value, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdNotEqualTo(Integer value) {
            addCriterion("workflow_id <>", value, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdGreaterThan(Integer value) {
            addCriterion("workflow_id >", value, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("workflow_id >=", value, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdLessThan(Integer value) {
            addCriterion("workflow_id <", value, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdLessThanOrEqualTo(Integer value) {
            addCriterion("workflow_id <=", value, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdIn(List<Integer> values) {
            addCriterion("workflow_id in", values, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdNotIn(List<Integer> values) {
            addCriterion("workflow_id not in", values, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdBetween(Integer value1, Integer value2) {
            addCriterion("workflow_id between", value1, value2, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowIdNotBetween(Integer value1, Integer value2) {
            addCriterion("workflow_id not between", value1, value2, "workflowId");
            return (Criteria) this;
        }

        public Criteria andWorkflowCustomIdIsNull() {
            addCriterion("workflow_custom_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowCustomIdIsNotNull() {
            addCriterion("workflow_custom_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowCustomIdEqualTo(Integer value) {
            addCriterion("workflow_custom_id =", value, "workflowCustomId");
            return (Criteria) this;
        }

        public Criteria andWorkflowCustomIdNotEqualTo(Integer value) {
            addCriterion("workflow_custom_id <>", value, "workflowCustomId");
            return (Criteria) this;
        }

        public Criteria andWorkflowCustomIdGreaterThan(Integer value) {
            addCriterion("workflow_custom_id >", value, "workflowCustomId");
            return (Criteria) this;
        }

        public Criteria andWorkflowCustomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("workflow_custom_id >=", value, "workflowCustomId");
            return (Criteria) this;
        }

        public Criteria andWorkflowCustomIdLessThan(Integer value) {
            addCriterion("workflow_custom_id <", value, "workflowCustomId");
            return (Criteria) this;
        }

        public Criteria andWorkflowCustomIdLessThanOrEqualTo(Integer value) {
            addCriterion("workflow_custom_id <=", value, "workflowCustomId");
            return (Criteria) this;
        }

        public Criteria andWorkflowCustomIdIn(List<Integer> values) {
            addCriterion("workflow_custom_id in", values, "workflowCustomId");
            return (Criteria) this;
        }

        public Criteria andWorkflowCustomIdNotIn(List<Integer> values) {
            addCriterion("workflow_custom_id not in", values, "workflowCustomId");
            return (Criteria) this;
        }

        public Criteria andWorkflowCustomIdBetween(Integer value1, Integer value2) {
            addCriterion("workflow_custom_id between", value1, value2, "workflowCustomId");
            return (Criteria) this;
        }

        public Criteria andWorkflowCustomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("workflow_custom_id not between", value1, value2, "workflowCustomId");
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

        public Criteria andBusinessTableIsNull() {
            addCriterion("business_table is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTableIsNotNull() {
            addCriterion("business_table is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTableEqualTo(String value) {
            addCriterion("business_table =", value, "businessTable");
            return (Criteria) this;
        }

        public Criteria andBusinessTableNotEqualTo(String value) {
            addCriterion("business_table <>", value, "businessTable");
            return (Criteria) this;
        }

        public Criteria andBusinessTableGreaterThan(String value) {
            addCriterion("business_table >", value, "businessTable");
            return (Criteria) this;
        }

        public Criteria andBusinessTableGreaterThanOrEqualTo(String value) {
            addCriterion("business_table >=", value, "businessTable");
            return (Criteria) this;
        }

        public Criteria andBusinessTableLessThan(String value) {
            addCriterion("business_table <", value, "businessTable");
            return (Criteria) this;
        }

        public Criteria andBusinessTableLessThanOrEqualTo(String value) {
            addCriterion("business_table <=", value, "businessTable");
            return (Criteria) this;
        }

        public Criteria andBusinessTableLike(String value) {
            addCriterion("business_table like", value, "businessTable");
            return (Criteria) this;
        }

        public Criteria andBusinessTableNotLike(String value) {
            addCriterion("business_table not like", value, "businessTable");
            return (Criteria) this;
        }

        public Criteria andBusinessTableIn(List<String> values) {
            addCriterion("business_table in", values, "businessTable");
            return (Criteria) this;
        }

        public Criteria andBusinessTableNotIn(List<String> values) {
            addCriterion("business_table not in", values, "businessTable");
            return (Criteria) this;
        }

        public Criteria andBusinessTableBetween(String value1, String value2) {
            addCriterion("business_table between", value1, value2, "businessTable");
            return (Criteria) this;
        }

        public Criteria andBusinessTableNotBetween(String value1, String value2) {
            addCriterion("business_table not between", value1, value2, "businessTable");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNull() {
            addCriterion("business_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNotNull() {
            addCriterion("business_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdEqualTo(Integer value) {
            addCriterion("business_id =", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotEqualTo(Integer value) {
            addCriterion("business_id <>", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThan(Integer value) {
            addCriterion("business_id >", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("business_id >=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThan(Integer value) {
            addCriterion("business_id <", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThanOrEqualTo(Integer value) {
            addCriterion("business_id <=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIn(List<Integer> values) {
            addCriterion("business_id in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotIn(List<Integer> values) {
            addCriterion("business_id not in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdBetween(Integer value1, Integer value2) {
            addCriterion("business_id between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotBetween(Integer value1, Integer value2) {
            addCriterion("business_id not between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andWorkflowTimeIsNull() {
            addCriterion("workflow_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowTimeIsNotNull() {
            addCriterion("workflow_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowTimeEqualTo(Date value) {
            addCriterion("workflow_time =", value, "workflowTime");
            return (Criteria) this;
        }

        public Criteria andWorkflowTimeNotEqualTo(Date value) {
            addCriterion("workflow_time <>", value, "workflowTime");
            return (Criteria) this;
        }

        public Criteria andWorkflowTimeGreaterThan(Date value) {
            addCriterion("workflow_time >", value, "workflowTime");
            return (Criteria) this;
        }

        public Criteria andWorkflowTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("workflow_time >=", value, "workflowTime");
            return (Criteria) this;
        }

        public Criteria andWorkflowTimeLessThan(Date value) {
            addCriterion("workflow_time <", value, "workflowTime");
            return (Criteria) this;
        }

        public Criteria andWorkflowTimeLessThanOrEqualTo(Date value) {
            addCriterion("workflow_time <=", value, "workflowTime");
            return (Criteria) this;
        }

        public Criteria andWorkflowTimeIn(List<Date> values) {
            addCriterion("workflow_time in", values, "workflowTime");
            return (Criteria) this;
        }

        public Criteria andWorkflowTimeNotIn(List<Date> values) {
            addCriterion("workflow_time not in", values, "workflowTime");
            return (Criteria) this;
        }

        public Criteria andWorkflowTimeBetween(Date value1, Date value2) {
            addCriterion("workflow_time between", value1, value2, "workflowTime");
            return (Criteria) this;
        }

        public Criteria andWorkflowTimeNotBetween(Date value1, Date value2) {
            addCriterion("workflow_time not between", value1, value2, "workflowTime");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIsNull() {
            addCriterion("workflow_result is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIsNotNull() {
            addCriterion("workflow_result is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultEqualTo(String value) {
            addCriterion("workflow_result =", value, "workflowResult");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultNotEqualTo(String value) {
            addCriterion("workflow_result <>", value, "workflowResult");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultGreaterThan(String value) {
            addCriterion("workflow_result >", value, "workflowResult");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultGreaterThanOrEqualTo(String value) {
            addCriterion("workflow_result >=", value, "workflowResult");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultLessThan(String value) {
            addCriterion("workflow_result <", value, "workflowResult");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultLessThanOrEqualTo(String value) {
            addCriterion("workflow_result <=", value, "workflowResult");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultLike(String value) {
            addCriterion("workflow_result like", value, "workflowResult");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultNotLike(String value) {
            addCriterion("workflow_result not like", value, "workflowResult");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultIn(List<String> values) {
            addCriterion("workflow_result in", values, "workflowResult");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultNotIn(List<String> values) {
            addCriterion("workflow_result not in", values, "workflowResult");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultBetween(String value1, String value2) {
            addCriterion("workflow_result between", value1, value2, "workflowResult");
            return (Criteria) this;
        }

        public Criteria andWorkflowResultNotBetween(String value1, String value2) {
            addCriterion("workflow_result not between", value1, value2, "workflowResult");
            return (Criteria) this;
        }

        public Criteria andWorkflowOpinionIsNull() {
            addCriterion("workflow_opinion is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowOpinionIsNotNull() {
            addCriterion("workflow_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowOpinionEqualTo(String value) {
            addCriterion("workflow_opinion =", value, "workflowOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkflowOpinionNotEqualTo(String value) {
            addCriterion("workflow_opinion <>", value, "workflowOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkflowOpinionGreaterThan(String value) {
            addCriterion("workflow_opinion >", value, "workflowOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkflowOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("workflow_opinion >=", value, "workflowOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkflowOpinionLessThan(String value) {
            addCriterion("workflow_opinion <", value, "workflowOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkflowOpinionLessThanOrEqualTo(String value) {
            addCriterion("workflow_opinion <=", value, "workflowOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkflowOpinionLike(String value) {
            addCriterion("workflow_opinion like", value, "workflowOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkflowOpinionNotLike(String value) {
            addCriterion("workflow_opinion not like", value, "workflowOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkflowOpinionIn(List<String> values) {
            addCriterion("workflow_opinion in", values, "workflowOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkflowOpinionNotIn(List<String> values) {
            addCriterion("workflow_opinion not in", values, "workflowOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkflowOpinionBetween(String value1, String value2) {
            addCriterion("workflow_opinion between", value1, value2, "workflowOpinion");
            return (Criteria) this;
        }

        public Criteria andWorkflowOpinionNotBetween(String value1, String value2) {
            addCriterion("workflow_opinion not between", value1, value2, "workflowOpinion");
            return (Criteria) this;
        }

        public Criteria andNextStepIsNull() {
            addCriterion("next_step is null");
            return (Criteria) this;
        }

        public Criteria andNextStepIsNotNull() {
            addCriterion("next_step is not null");
            return (Criteria) this;
        }

        public Criteria andNextStepEqualTo(Integer value) {
            addCriterion("next_step =", value, "nextStep");
            return (Criteria) this;
        }

        public Criteria andNextStepNotEqualTo(Integer value) {
            addCriterion("next_step <>", value, "nextStep");
            return (Criteria) this;
        }

        public Criteria andNextStepGreaterThan(Integer value) {
            addCriterion("next_step >", value, "nextStep");
            return (Criteria) this;
        }

        public Criteria andNextStepGreaterThanOrEqualTo(Integer value) {
            addCriterion("next_step >=", value, "nextStep");
            return (Criteria) this;
        }

        public Criteria andNextStepLessThan(Integer value) {
            addCriterion("next_step <", value, "nextStep");
            return (Criteria) this;
        }

        public Criteria andNextStepLessThanOrEqualTo(Integer value) {
            addCriterion("next_step <=", value, "nextStep");
            return (Criteria) this;
        }

        public Criteria andNextStepIn(List<Integer> values) {
            addCriterion("next_step in", values, "nextStep");
            return (Criteria) this;
        }

        public Criteria andNextStepNotIn(List<Integer> values) {
            addCriterion("next_step not in", values, "nextStep");
            return (Criteria) this;
        }

        public Criteria andNextStepBetween(Integer value1, Integer value2) {
            addCriterion("next_step between", value1, value2, "nextStep");
            return (Criteria) this;
        }

        public Criteria andNextStepNotBetween(Integer value1, Integer value2) {
            addCriterion("next_step not between", value1, value2, "nextStep");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeIsNull() {
            addCriterion("workflow_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeIsNotNull() {
            addCriterion("workflow_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeEqualTo(String value) {
            addCriterion("workflow_type =", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeNotEqualTo(String value) {
            addCriterion("workflow_type <>", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeGreaterThan(String value) {
            addCriterion("workflow_type >", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeGreaterThanOrEqualTo(String value) {
            addCriterion("workflow_type >=", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeLessThan(String value) {
            addCriterion("workflow_type <", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeLessThanOrEqualTo(String value) {
            addCriterion("workflow_type <=", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeLike(String value) {
            addCriterion("workflow_type like", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeNotLike(String value) {
            addCriterion("workflow_type not like", value, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeIn(List<String> values) {
            addCriterion("workflow_type in", values, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeNotIn(List<String> values) {
            addCriterion("workflow_type not in", values, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeBetween(String value1, String value2) {
            addCriterion("workflow_type between", value1, value2, "workflowType");
            return (Criteria) this;
        }

        public Criteria andWorkflowTypeNotBetween(String value1, String value2) {
            addCriterion("workflow_type not between", value1, value2, "workflowType");
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