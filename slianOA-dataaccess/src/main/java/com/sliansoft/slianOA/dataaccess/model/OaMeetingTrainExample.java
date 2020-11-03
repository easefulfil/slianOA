package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaMeetingTrainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaMeetingTrainExample() {
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

    public OaMeetingTrainExample(int pageSize, int pageIndex) {
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

        public Criteria andMeetingTrainIdIsNull() {
            addCriterion("meeting_train_id is null");
            return (Criteria) this;
        }

        public Criteria andMeetingTrainIdIsNotNull() {
            addCriterion("meeting_train_id is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingTrainIdEqualTo(Integer value) {
            addCriterion("meeting_train_id =", value, "meetingTrainId");
            return (Criteria) this;
        }

        public Criteria andMeetingTrainIdNotEqualTo(Integer value) {
            addCriterion("meeting_train_id <>", value, "meetingTrainId");
            return (Criteria) this;
        }

        public Criteria andMeetingTrainIdGreaterThan(Integer value) {
            addCriterion("meeting_train_id >", value, "meetingTrainId");
            return (Criteria) this;
        }

        public Criteria andMeetingTrainIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("meeting_train_id >=", value, "meetingTrainId");
            return (Criteria) this;
        }

        public Criteria andMeetingTrainIdLessThan(Integer value) {
            addCriterion("meeting_train_id <", value, "meetingTrainId");
            return (Criteria) this;
        }

        public Criteria andMeetingTrainIdLessThanOrEqualTo(Integer value) {
            addCriterion("meeting_train_id <=", value, "meetingTrainId");
            return (Criteria) this;
        }

        public Criteria andMeetingTrainIdIn(List<Integer> values) {
            addCriterion("meeting_train_id in", values, "meetingTrainId");
            return (Criteria) this;
        }

        public Criteria andMeetingTrainIdNotIn(List<Integer> values) {
            addCriterion("meeting_train_id not in", values, "meetingTrainId");
            return (Criteria) this;
        }

        public Criteria andMeetingTrainIdBetween(Integer value1, Integer value2) {
            addCriterion("meeting_train_id between", value1, value2, "meetingTrainId");
            return (Criteria) this;
        }

        public Criteria andMeetingTrainIdNotBetween(Integer value1, Integer value2) {
            addCriterion("meeting_train_id not between", value1, value2, "meetingTrainId");
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

        public Criteria andMtNumbersIsNull() {
            addCriterion("mt_numbers is null");
            return (Criteria) this;
        }

        public Criteria andMtNumbersIsNotNull() {
            addCriterion("mt_numbers is not null");
            return (Criteria) this;
        }

        public Criteria andMtNumbersEqualTo(String value) {
            addCriterion("mt_numbers =", value, "mtNumbers");
            return (Criteria) this;
        }

        public Criteria andMtNumbersNotEqualTo(String value) {
            addCriterion("mt_numbers <>", value, "mtNumbers");
            return (Criteria) this;
        }

        public Criteria andMtNumbersGreaterThan(String value) {
            addCriterion("mt_numbers >", value, "mtNumbers");
            return (Criteria) this;
        }

        public Criteria andMtNumbersGreaterThanOrEqualTo(String value) {
            addCriterion("mt_numbers >=", value, "mtNumbers");
            return (Criteria) this;
        }

        public Criteria andMtNumbersLessThan(String value) {
            addCriterion("mt_numbers <", value, "mtNumbers");
            return (Criteria) this;
        }

        public Criteria andMtNumbersLessThanOrEqualTo(String value) {
            addCriterion("mt_numbers <=", value, "mtNumbers");
            return (Criteria) this;
        }

        public Criteria andMtNumbersLike(String value) {
            addCriterion("mt_numbers like", value, "mtNumbers");
            return (Criteria) this;
        }

        public Criteria andMtNumbersNotLike(String value) {
            addCriterion("mt_numbers not like", value, "mtNumbers");
            return (Criteria) this;
        }

        public Criteria andMtNumbersIn(List<String> values) {
            addCriterion("mt_numbers in", values, "mtNumbers");
            return (Criteria) this;
        }

        public Criteria andMtNumbersNotIn(List<String> values) {
            addCriterion("mt_numbers not in", values, "mtNumbers");
            return (Criteria) this;
        }

        public Criteria andMtNumbersBetween(String value1, String value2) {
            addCriterion("mt_numbers between", value1, value2, "mtNumbers");
            return (Criteria) this;
        }

        public Criteria andMtNumbersNotBetween(String value1, String value2) {
            addCriterion("mt_numbers not between", value1, value2, "mtNumbers");
            return (Criteria) this;
        }

        public Criteria andMtSiteIsNull() {
            addCriterion("mt_site is null");
            return (Criteria) this;
        }

        public Criteria andMtSiteIsNotNull() {
            addCriterion("mt_site is not null");
            return (Criteria) this;
        }

        public Criteria andMtSiteEqualTo(String value) {
            addCriterion("mt_site =", value, "mtSite");
            return (Criteria) this;
        }

        public Criteria andMtSiteNotEqualTo(String value) {
            addCriterion("mt_site <>", value, "mtSite");
            return (Criteria) this;
        }

        public Criteria andMtSiteGreaterThan(String value) {
            addCriterion("mt_site >", value, "mtSite");
            return (Criteria) this;
        }

        public Criteria andMtSiteGreaterThanOrEqualTo(String value) {
            addCriterion("mt_site >=", value, "mtSite");
            return (Criteria) this;
        }

        public Criteria andMtSiteLessThan(String value) {
            addCriterion("mt_site <", value, "mtSite");
            return (Criteria) this;
        }

        public Criteria andMtSiteLessThanOrEqualTo(String value) {
            addCriterion("mt_site <=", value, "mtSite");
            return (Criteria) this;
        }

        public Criteria andMtSiteLike(String value) {
            addCriterion("mt_site like", value, "mtSite");
            return (Criteria) this;
        }

        public Criteria andMtSiteNotLike(String value) {
            addCriterion("mt_site not like", value, "mtSite");
            return (Criteria) this;
        }

        public Criteria andMtSiteIn(List<String> values) {
            addCriterion("mt_site in", values, "mtSite");
            return (Criteria) this;
        }

        public Criteria andMtSiteNotIn(List<String> values) {
            addCriterion("mt_site not in", values, "mtSite");
            return (Criteria) this;
        }

        public Criteria andMtSiteBetween(String value1, String value2) {
            addCriterion("mt_site between", value1, value2, "mtSite");
            return (Criteria) this;
        }

        public Criteria andMtSiteNotBetween(String value1, String value2) {
            addCriterion("mt_site not between", value1, value2, "mtSite");
            return (Criteria) this;
        }

        public Criteria andMtTimeIsNull() {
            addCriterion("mt_time is null");
            return (Criteria) this;
        }

        public Criteria andMtTimeIsNotNull() {
            addCriterion("mt_time is not null");
            return (Criteria) this;
        }

        public Criteria andMtTimeEqualTo(Date value) {
            addCriterion("mt_time =", value, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeNotEqualTo(Date value) {
            addCriterion("mt_time <>", value, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeGreaterThan(Date value) {
            addCriterion("mt_time >", value, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mt_time >=", value, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeLessThan(Date value) {
            addCriterion("mt_time <", value, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeLessThanOrEqualTo(Date value) {
            addCriterion("mt_time <=", value, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeIn(List<Date> values) {
            addCriterion("mt_time in", values, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeNotIn(List<Date> values) {
            addCriterion("mt_time not in", values, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeBetween(Date value1, Date value2) {
            addCriterion("mt_time between", value1, value2, "mtTime");
            return (Criteria) this;
        }

        public Criteria andMtTimeNotBetween(Date value1, Date value2) {
            addCriterion("mt_time not between", value1, value2, "mtTime");
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

        public Criteria andMtJoinPersonsIsNull() {
            addCriterion("mt_join_persons is null");
            return (Criteria) this;
        }

        public Criteria andMtJoinPersonsIsNotNull() {
            addCriterion("mt_join_persons is not null");
            return (Criteria) this;
        }

        public Criteria andMtJoinPersonsEqualTo(String value) {
            addCriterion("mt_join_persons =", value, "mtJoinPersons");
            return (Criteria) this;
        }

        public Criteria andMtJoinPersonsNotEqualTo(String value) {
            addCriterion("mt_join_persons <>", value, "mtJoinPersons");
            return (Criteria) this;
        }

        public Criteria andMtJoinPersonsGreaterThan(String value) {
            addCriterion("mt_join_persons >", value, "mtJoinPersons");
            return (Criteria) this;
        }

        public Criteria andMtJoinPersonsGreaterThanOrEqualTo(String value) {
            addCriterion("mt_join_persons >=", value, "mtJoinPersons");
            return (Criteria) this;
        }

        public Criteria andMtJoinPersonsLessThan(String value) {
            addCriterion("mt_join_persons <", value, "mtJoinPersons");
            return (Criteria) this;
        }

        public Criteria andMtJoinPersonsLessThanOrEqualTo(String value) {
            addCriterion("mt_join_persons <=", value, "mtJoinPersons");
            return (Criteria) this;
        }

        public Criteria andMtJoinPersonsLike(String value) {
            addCriterion("mt_join_persons like", value, "mtJoinPersons");
            return (Criteria) this;
        }

        public Criteria andMtJoinPersonsNotLike(String value) {
            addCriterion("mt_join_persons not like", value, "mtJoinPersons");
            return (Criteria) this;
        }

        public Criteria andMtJoinPersonsIn(List<String> values) {
            addCriterion("mt_join_persons in", values, "mtJoinPersons");
            return (Criteria) this;
        }

        public Criteria andMtJoinPersonsNotIn(List<String> values) {
            addCriterion("mt_join_persons not in", values, "mtJoinPersons");
            return (Criteria) this;
        }

        public Criteria andMtJoinPersonsBetween(String value1, String value2) {
            addCriterion("mt_join_persons between", value1, value2, "mtJoinPersons");
            return (Criteria) this;
        }

        public Criteria andMtJoinPersonsNotBetween(String value1, String value2) {
            addCriterion("mt_join_persons not between", value1, value2, "mtJoinPersons");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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