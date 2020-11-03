package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaVehicleUsedRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaVehicleUsedRecordExample() {
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

    public OaVehicleUsedRecordExample(int pageSize, int pageIndex) {
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

        public Criteria andVehicleUsedRecordIdIsNull() {
            addCriterion("vehicle_used_record_id is null");
            return (Criteria) this;
        }

        public Criteria andVehicleUsedRecordIdIsNotNull() {
            addCriterion("vehicle_used_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleUsedRecordIdEqualTo(Integer value) {
            addCriterion("vehicle_used_record_id =", value, "vehicleUsedRecordId");
            return (Criteria) this;
        }

        public Criteria andVehicleUsedRecordIdNotEqualTo(Integer value) {
            addCriterion("vehicle_used_record_id <>", value, "vehicleUsedRecordId");
            return (Criteria) this;
        }

        public Criteria andVehicleUsedRecordIdGreaterThan(Integer value) {
            addCriterion("vehicle_used_record_id >", value, "vehicleUsedRecordId");
            return (Criteria) this;
        }

        public Criteria andVehicleUsedRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicle_used_record_id >=", value, "vehicleUsedRecordId");
            return (Criteria) this;
        }

        public Criteria andVehicleUsedRecordIdLessThan(Integer value) {
            addCriterion("vehicle_used_record_id <", value, "vehicleUsedRecordId");
            return (Criteria) this;
        }

        public Criteria andVehicleUsedRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("vehicle_used_record_id <=", value, "vehicleUsedRecordId");
            return (Criteria) this;
        }

        public Criteria andVehicleUsedRecordIdIn(List<Integer> values) {
            addCriterion("vehicle_used_record_id in", values, "vehicleUsedRecordId");
            return (Criteria) this;
        }

        public Criteria andVehicleUsedRecordIdNotIn(List<Integer> values) {
            addCriterion("vehicle_used_record_id not in", values, "vehicleUsedRecordId");
            return (Criteria) this;
        }

        public Criteria andVehicleUsedRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_used_record_id between", value1, value2, "vehicleUsedRecordId");
            return (Criteria) this;
        }

        public Criteria andVehicleUsedRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicle_used_record_id not between", value1, value2, "vehicleUsedRecordId");
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

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeIsNull() {
            addCriterion("plan_return_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeIsNotNull() {
            addCriterion("plan_return_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeEqualTo(Date value) {
            addCriterion("plan_return_time =", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeNotEqualTo(Date value) {
            addCriterion("plan_return_time <>", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeGreaterThan(Date value) {
            addCriterion("plan_return_time >", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_return_time >=", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeLessThan(Date value) {
            addCriterion("plan_return_time <", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_return_time <=", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeIn(List<Date> values) {
            addCriterion("plan_return_time in", values, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeNotIn(List<Date> values) {
            addCriterion("plan_return_time not in", values, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeBetween(Date value1, Date value2) {
            addCriterion("plan_return_time between", value1, value2, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_return_time not between", value1, value2, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andTrueReturnTimeIsNull() {
            addCriterion("true_return_time is null");
            return (Criteria) this;
        }

        public Criteria andTrueReturnTimeIsNotNull() {
            addCriterion("true_return_time is not null");
            return (Criteria) this;
        }

        public Criteria andTrueReturnTimeEqualTo(Date value) {
            addCriterion("true_return_time =", value, "trueReturnTime");
            return (Criteria) this;
        }

        public Criteria andTrueReturnTimeNotEqualTo(Date value) {
            addCriterion("true_return_time <>", value, "trueReturnTime");
            return (Criteria) this;
        }

        public Criteria andTrueReturnTimeGreaterThan(Date value) {
            addCriterion("true_return_time >", value, "trueReturnTime");
            return (Criteria) this;
        }

        public Criteria andTrueReturnTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("true_return_time >=", value, "trueReturnTime");
            return (Criteria) this;
        }

        public Criteria andTrueReturnTimeLessThan(Date value) {
            addCriterion("true_return_time <", value, "trueReturnTime");
            return (Criteria) this;
        }

        public Criteria andTrueReturnTimeLessThanOrEqualTo(Date value) {
            addCriterion("true_return_time <=", value, "trueReturnTime");
            return (Criteria) this;
        }

        public Criteria andTrueReturnTimeIn(List<Date> values) {
            addCriterion("true_return_time in", values, "trueReturnTime");
            return (Criteria) this;
        }

        public Criteria andTrueReturnTimeNotIn(List<Date> values) {
            addCriterion("true_return_time not in", values, "trueReturnTime");
            return (Criteria) this;
        }

        public Criteria andTrueReturnTimeBetween(Date value1, Date value2) {
            addCriterion("true_return_time between", value1, value2, "trueReturnTime");
            return (Criteria) this;
        }

        public Criteria andTrueReturnTimeNotBetween(Date value1, Date value2) {
            addCriterion("true_return_time not between", value1, value2, "trueReturnTime");
            return (Criteria) this;
        }

        public Criteria andVurDestinationIsNull() {
            addCriterion("vur_destination is null");
            return (Criteria) this;
        }

        public Criteria andVurDestinationIsNotNull() {
            addCriterion("vur_destination is not null");
            return (Criteria) this;
        }

        public Criteria andVurDestinationEqualTo(String value) {
            addCriterion("vur_destination =", value, "vurDestination");
            return (Criteria) this;
        }

        public Criteria andVurDestinationNotEqualTo(String value) {
            addCriterion("vur_destination <>", value, "vurDestination");
            return (Criteria) this;
        }

        public Criteria andVurDestinationGreaterThan(String value) {
            addCriterion("vur_destination >", value, "vurDestination");
            return (Criteria) this;
        }

        public Criteria andVurDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("vur_destination >=", value, "vurDestination");
            return (Criteria) this;
        }

        public Criteria andVurDestinationLessThan(String value) {
            addCriterion("vur_destination <", value, "vurDestination");
            return (Criteria) this;
        }

        public Criteria andVurDestinationLessThanOrEqualTo(String value) {
            addCriterion("vur_destination <=", value, "vurDestination");
            return (Criteria) this;
        }

        public Criteria andVurDestinationLike(String value) {
            addCriterion("vur_destination like", value, "vurDestination");
            return (Criteria) this;
        }

        public Criteria andVurDestinationNotLike(String value) {
            addCriterion("vur_destination not like", value, "vurDestination");
            return (Criteria) this;
        }

        public Criteria andVurDestinationIn(List<String> values) {
            addCriterion("vur_destination in", values, "vurDestination");
            return (Criteria) this;
        }

        public Criteria andVurDestinationNotIn(List<String> values) {
            addCriterion("vur_destination not in", values, "vurDestination");
            return (Criteria) this;
        }

        public Criteria andVurDestinationBetween(String value1, String value2) {
            addCriterion("vur_destination between", value1, value2, "vurDestination");
            return (Criteria) this;
        }

        public Criteria andVurDestinationNotBetween(String value1, String value2) {
            addCriterion("vur_destination not between", value1, value2, "vurDestination");
            return (Criteria) this;
        }

        public Criteria andVurTogetherIsNull() {
            addCriterion("vur_together is null");
            return (Criteria) this;
        }

        public Criteria andVurTogetherIsNotNull() {
            addCriterion("vur_together is not null");
            return (Criteria) this;
        }

        public Criteria andVurTogetherEqualTo(String value) {
            addCriterion("vur_together =", value, "vurTogether");
            return (Criteria) this;
        }

        public Criteria andVurTogetherNotEqualTo(String value) {
            addCriterion("vur_together <>", value, "vurTogether");
            return (Criteria) this;
        }

        public Criteria andVurTogetherGreaterThan(String value) {
            addCriterion("vur_together >", value, "vurTogether");
            return (Criteria) this;
        }

        public Criteria andVurTogetherGreaterThanOrEqualTo(String value) {
            addCriterion("vur_together >=", value, "vurTogether");
            return (Criteria) this;
        }

        public Criteria andVurTogetherLessThan(String value) {
            addCriterion("vur_together <", value, "vurTogether");
            return (Criteria) this;
        }

        public Criteria andVurTogetherLessThanOrEqualTo(String value) {
            addCriterion("vur_together <=", value, "vurTogether");
            return (Criteria) this;
        }

        public Criteria andVurTogetherLike(String value) {
            addCriterion("vur_together like", value, "vurTogether");
            return (Criteria) this;
        }

        public Criteria andVurTogetherNotLike(String value) {
            addCriterion("vur_together not like", value, "vurTogether");
            return (Criteria) this;
        }

        public Criteria andVurTogetherIn(List<String> values) {
            addCriterion("vur_together in", values, "vurTogether");
            return (Criteria) this;
        }

        public Criteria andVurTogetherNotIn(List<String> values) {
            addCriterion("vur_together not in", values, "vurTogether");
            return (Criteria) this;
        }

        public Criteria andVurTogetherBetween(String value1, String value2) {
            addCriterion("vur_together between", value1, value2, "vurTogether");
            return (Criteria) this;
        }

        public Criteria andVurTogetherNotBetween(String value1, String value2) {
            addCriterion("vur_together not between", value1, value2, "vurTogether");
            return (Criteria) this;
        }

        public Criteria andVurReportSiteIsNull() {
            addCriterion("vur_report_site is null");
            return (Criteria) this;
        }

        public Criteria andVurReportSiteIsNotNull() {
            addCriterion("vur_report_site is not null");
            return (Criteria) this;
        }

        public Criteria andVurReportSiteEqualTo(String value) {
            addCriterion("vur_report_site =", value, "vurReportSite");
            return (Criteria) this;
        }

        public Criteria andVurReportSiteNotEqualTo(String value) {
            addCriterion("vur_report_site <>", value, "vurReportSite");
            return (Criteria) this;
        }

        public Criteria andVurReportSiteGreaterThan(String value) {
            addCriterion("vur_report_site >", value, "vurReportSite");
            return (Criteria) this;
        }

        public Criteria andVurReportSiteGreaterThanOrEqualTo(String value) {
            addCriterion("vur_report_site >=", value, "vurReportSite");
            return (Criteria) this;
        }

        public Criteria andVurReportSiteLessThan(String value) {
            addCriterion("vur_report_site <", value, "vurReportSite");
            return (Criteria) this;
        }

        public Criteria andVurReportSiteLessThanOrEqualTo(String value) {
            addCriterion("vur_report_site <=", value, "vurReportSite");
            return (Criteria) this;
        }

        public Criteria andVurReportSiteLike(String value) {
            addCriterion("vur_report_site like", value, "vurReportSite");
            return (Criteria) this;
        }

        public Criteria andVurReportSiteNotLike(String value) {
            addCriterion("vur_report_site not like", value, "vurReportSite");
            return (Criteria) this;
        }

        public Criteria andVurReportSiteIn(List<String> values) {
            addCriterion("vur_report_site in", values, "vurReportSite");
            return (Criteria) this;
        }

        public Criteria andVurReportSiteNotIn(List<String> values) {
            addCriterion("vur_report_site not in", values, "vurReportSite");
            return (Criteria) this;
        }

        public Criteria andVurReportSiteBetween(String value1, String value2) {
            addCriterion("vur_report_site between", value1, value2, "vurReportSite");
            return (Criteria) this;
        }

        public Criteria andVurReportSiteNotBetween(String value1, String value2) {
            addCriterion("vur_report_site not between", value1, value2, "vurReportSite");
            return (Criteria) this;
        }

        public Criteria andVurLinkmanIsNull() {
            addCriterion("vur_linkman is null");
            return (Criteria) this;
        }

        public Criteria andVurLinkmanIsNotNull() {
            addCriterion("vur_linkman is not null");
            return (Criteria) this;
        }

        public Criteria andVurLinkmanEqualTo(String value) {
            addCriterion("vur_linkman =", value, "vurLinkman");
            return (Criteria) this;
        }

        public Criteria andVurLinkmanNotEqualTo(String value) {
            addCriterion("vur_linkman <>", value, "vurLinkman");
            return (Criteria) this;
        }

        public Criteria andVurLinkmanGreaterThan(String value) {
            addCriterion("vur_linkman >", value, "vurLinkman");
            return (Criteria) this;
        }

        public Criteria andVurLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("vur_linkman >=", value, "vurLinkman");
            return (Criteria) this;
        }

        public Criteria andVurLinkmanLessThan(String value) {
            addCriterion("vur_linkman <", value, "vurLinkman");
            return (Criteria) this;
        }

        public Criteria andVurLinkmanLessThanOrEqualTo(String value) {
            addCriterion("vur_linkman <=", value, "vurLinkman");
            return (Criteria) this;
        }

        public Criteria andVurLinkmanLike(String value) {
            addCriterion("vur_linkman like", value, "vurLinkman");
            return (Criteria) this;
        }

        public Criteria andVurLinkmanNotLike(String value) {
            addCriterion("vur_linkman not like", value, "vurLinkman");
            return (Criteria) this;
        }

        public Criteria andVurLinkmanIn(List<String> values) {
            addCriterion("vur_linkman in", values, "vurLinkman");
            return (Criteria) this;
        }

        public Criteria andVurLinkmanNotIn(List<String> values) {
            addCriterion("vur_linkman not in", values, "vurLinkman");
            return (Criteria) this;
        }

        public Criteria andVurLinkmanBetween(String value1, String value2) {
            addCriterion("vur_linkman between", value1, value2, "vurLinkman");
            return (Criteria) this;
        }

        public Criteria andVurLinkmanNotBetween(String value1, String value2) {
            addCriterion("vur_linkman not between", value1, value2, "vurLinkman");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andAssignmentIsNull() {
            addCriterion("assignment is null");
            return (Criteria) this;
        }

        public Criteria andAssignmentIsNotNull() {
            addCriterion("assignment is not null");
            return (Criteria) this;
        }

        public Criteria andAssignmentEqualTo(String value) {
            addCriterion("assignment =", value, "assignment");
            return (Criteria) this;
        }

        public Criteria andAssignmentNotEqualTo(String value) {
            addCriterion("assignment <>", value, "assignment");
            return (Criteria) this;
        }

        public Criteria andAssignmentGreaterThan(String value) {
            addCriterion("assignment >", value, "assignment");
            return (Criteria) this;
        }

        public Criteria andAssignmentGreaterThanOrEqualTo(String value) {
            addCriterion("assignment >=", value, "assignment");
            return (Criteria) this;
        }

        public Criteria andAssignmentLessThan(String value) {
            addCriterion("assignment <", value, "assignment");
            return (Criteria) this;
        }

        public Criteria andAssignmentLessThanOrEqualTo(String value) {
            addCriterion("assignment <=", value, "assignment");
            return (Criteria) this;
        }

        public Criteria andAssignmentLike(String value) {
            addCriterion("assignment like", value, "assignment");
            return (Criteria) this;
        }

        public Criteria andAssignmentNotLike(String value) {
            addCriterion("assignment not like", value, "assignment");
            return (Criteria) this;
        }

        public Criteria andAssignmentIn(List<String> values) {
            addCriterion("assignment in", values, "assignment");
            return (Criteria) this;
        }

        public Criteria andAssignmentNotIn(List<String> values) {
            addCriterion("assignment not in", values, "assignment");
            return (Criteria) this;
        }

        public Criteria andAssignmentBetween(String value1, String value2) {
            addCriterion("assignment between", value1, value2, "assignment");
            return (Criteria) this;
        }

        public Criteria andAssignmentNotBetween(String value1, String value2) {
            addCriterion("assignment not between", value1, value2, "assignment");
            return (Criteria) this;
        }

        public Criteria andBeginVelMileageIsNull() {
            addCriterion("begin_vel_mileage is null");
            return (Criteria) this;
        }

        public Criteria andBeginVelMileageIsNotNull() {
            addCriterion("begin_vel_mileage is not null");
            return (Criteria) this;
        }

        public Criteria andBeginVelMileageEqualTo(Double value) {
            addCriterion("begin_vel_mileage =", value, "beginVelMileage");
            return (Criteria) this;
        }

        public Criteria andBeginVelMileageNotEqualTo(Double value) {
            addCriterion("begin_vel_mileage <>", value, "beginVelMileage");
            return (Criteria) this;
        }

        public Criteria andBeginVelMileageGreaterThan(Double value) {
            addCriterion("begin_vel_mileage >", value, "beginVelMileage");
            return (Criteria) this;
        }

        public Criteria andBeginVelMileageGreaterThanOrEqualTo(Double value) {
            addCriterion("begin_vel_mileage >=", value, "beginVelMileage");
            return (Criteria) this;
        }

        public Criteria andBeginVelMileageLessThan(Double value) {
            addCriterion("begin_vel_mileage <", value, "beginVelMileage");
            return (Criteria) this;
        }

        public Criteria andBeginVelMileageLessThanOrEqualTo(Double value) {
            addCriterion("begin_vel_mileage <=", value, "beginVelMileage");
            return (Criteria) this;
        }

        public Criteria andBeginVelMileageIn(List<Double> values) {
            addCriterion("begin_vel_mileage in", values, "beginVelMileage");
            return (Criteria) this;
        }

        public Criteria andBeginVelMileageNotIn(List<Double> values) {
            addCriterion("begin_vel_mileage not in", values, "beginVelMileage");
            return (Criteria) this;
        }

        public Criteria andBeginVelMileageBetween(Double value1, Double value2) {
            addCriterion("begin_vel_mileage between", value1, value2, "beginVelMileage");
            return (Criteria) this;
        }

        public Criteria andBeginVelMileageNotBetween(Double value1, Double value2) {
            addCriterion("begin_vel_mileage not between", value1, value2, "beginVelMileage");
            return (Criteria) this;
        }

        public Criteria andReturnVelMileageIsNull() {
            addCriterion("return_vel_mileage is null");
            return (Criteria) this;
        }

        public Criteria andReturnVelMileageIsNotNull() {
            addCriterion("return_vel_mileage is not null");
            return (Criteria) this;
        }

        public Criteria andReturnVelMileageEqualTo(Double value) {
            addCriterion("return_vel_mileage =", value, "returnVelMileage");
            return (Criteria) this;
        }

        public Criteria andReturnVelMileageNotEqualTo(Double value) {
            addCriterion("return_vel_mileage <>", value, "returnVelMileage");
            return (Criteria) this;
        }

        public Criteria andReturnVelMileageGreaterThan(Double value) {
            addCriterion("return_vel_mileage >", value, "returnVelMileage");
            return (Criteria) this;
        }

        public Criteria andReturnVelMileageGreaterThanOrEqualTo(Double value) {
            addCriterion("return_vel_mileage >=", value, "returnVelMileage");
            return (Criteria) this;
        }

        public Criteria andReturnVelMileageLessThan(Double value) {
            addCriterion("return_vel_mileage <", value, "returnVelMileage");
            return (Criteria) this;
        }

        public Criteria andReturnVelMileageLessThanOrEqualTo(Double value) {
            addCriterion("return_vel_mileage <=", value, "returnVelMileage");
            return (Criteria) this;
        }

        public Criteria andReturnVelMileageIn(List<Double> values) {
            addCriterion("return_vel_mileage in", values, "returnVelMileage");
            return (Criteria) this;
        }

        public Criteria andReturnVelMileageNotIn(List<Double> values) {
            addCriterion("return_vel_mileage not in", values, "returnVelMileage");
            return (Criteria) this;
        }

        public Criteria andReturnVelMileageBetween(Double value1, Double value2) {
            addCriterion("return_vel_mileage between", value1, value2, "returnVelMileage");
            return (Criteria) this;
        }

        public Criteria andReturnVelMileageNotBetween(Double value1, Double value2) {
            addCriterion("return_vel_mileage not between", value1, value2, "returnVelMileage");
            return (Criteria) this;
        }

        public Criteria andTrueOutTimeIsNull() {
            addCriterion("true_out_time is null");
            return (Criteria) this;
        }

        public Criteria andTrueOutTimeIsNotNull() {
            addCriterion("true_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andTrueOutTimeEqualTo(Date value) {
            addCriterion("true_out_time =", value, "trueOutTime");
            return (Criteria) this;
        }

        public Criteria andTrueOutTimeNotEqualTo(Date value) {
            addCriterion("true_out_time <>", value, "trueOutTime");
            return (Criteria) this;
        }

        public Criteria andTrueOutTimeGreaterThan(Date value) {
            addCriterion("true_out_time >", value, "trueOutTime");
            return (Criteria) this;
        }

        public Criteria andTrueOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("true_out_time >=", value, "trueOutTime");
            return (Criteria) this;
        }

        public Criteria andTrueOutTimeLessThan(Date value) {
            addCriterion("true_out_time <", value, "trueOutTime");
            return (Criteria) this;
        }

        public Criteria andTrueOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("true_out_time <=", value, "trueOutTime");
            return (Criteria) this;
        }

        public Criteria andTrueOutTimeIn(List<Date> values) {
            addCriterion("true_out_time in", values, "trueOutTime");
            return (Criteria) this;
        }

        public Criteria andTrueOutTimeNotIn(List<Date> values) {
            addCriterion("true_out_time not in", values, "trueOutTime");
            return (Criteria) this;
        }

        public Criteria andTrueOutTimeBetween(Date value1, Date value2) {
            addCriterion("true_out_time between", value1, value2, "trueOutTime");
            return (Criteria) this;
        }

        public Criteria andTrueOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("true_out_time not between", value1, value2, "trueOutTime");
            return (Criteria) this;
        }

        public Criteria andPreEventsIsNull() {
            addCriterion("pre_events is null");
            return (Criteria) this;
        }

        public Criteria andPreEventsIsNotNull() {
            addCriterion("pre_events is not null");
            return (Criteria) this;
        }

        public Criteria andPreEventsEqualTo(String value) {
            addCriterion("pre_events =", value, "preEvents");
            return (Criteria) this;
        }

        public Criteria andPreEventsNotEqualTo(String value) {
            addCriterion("pre_events <>", value, "preEvents");
            return (Criteria) this;
        }

        public Criteria andPreEventsGreaterThan(String value) {
            addCriterion("pre_events >", value, "preEvents");
            return (Criteria) this;
        }

        public Criteria andPreEventsGreaterThanOrEqualTo(String value) {
            addCriterion("pre_events >=", value, "preEvents");
            return (Criteria) this;
        }

        public Criteria andPreEventsLessThan(String value) {
            addCriterion("pre_events <", value, "preEvents");
            return (Criteria) this;
        }

        public Criteria andPreEventsLessThanOrEqualTo(String value) {
            addCriterion("pre_events <=", value, "preEvents");
            return (Criteria) this;
        }

        public Criteria andPreEventsLike(String value) {
            addCriterion("pre_events like", value, "preEvents");
            return (Criteria) this;
        }

        public Criteria andPreEventsNotLike(String value) {
            addCriterion("pre_events not like", value, "preEvents");
            return (Criteria) this;
        }

        public Criteria andPreEventsIn(List<String> values) {
            addCriterion("pre_events in", values, "preEvents");
            return (Criteria) this;
        }

        public Criteria andPreEventsNotIn(List<String> values) {
            addCriterion("pre_events not in", values, "preEvents");
            return (Criteria) this;
        }

        public Criteria andPreEventsBetween(String value1, String value2) {
            addCriterion("pre_events between", value1, value2, "preEvents");
            return (Criteria) this;
        }

        public Criteria andPreEventsNotBetween(String value1, String value2) {
            addCriterion("pre_events not between", value1, value2, "preEvents");
            return (Criteria) this;
        }

        public Criteria andIsReadedIsNull() {
            addCriterion("is_readed is null");
            return (Criteria) this;
        }

        public Criteria andIsReadedIsNotNull() {
            addCriterion("is_readed is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadedEqualTo(String value) {
            addCriterion("is_readed =", value, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedNotEqualTo(String value) {
            addCriterion("is_readed <>", value, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedGreaterThan(String value) {
            addCriterion("is_readed >", value, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedGreaterThanOrEqualTo(String value) {
            addCriterion("is_readed >=", value, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedLessThan(String value) {
            addCriterion("is_readed <", value, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedLessThanOrEqualTo(String value) {
            addCriterion("is_readed <=", value, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedLike(String value) {
            addCriterion("is_readed like", value, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedNotLike(String value) {
            addCriterion("is_readed not like", value, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedIn(List<String> values) {
            addCriterion("is_readed in", values, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedNotIn(List<String> values) {
            addCriterion("is_readed not in", values, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedBetween(String value1, String value2) {
            addCriterion("is_readed between", value1, value2, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedNotBetween(String value1, String value2) {
            addCriterion("is_readed not between", value1, value2, "isReaded");
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

        public Criteria andStepIsNull() {
            addCriterion("step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(String value) {
            addCriterion("step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(String value) {
            addCriterion("step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(String value) {
            addCriterion("step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(String value) {
            addCriterion("step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(String value) {
            addCriterion("step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(String value) {
            addCriterion("step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLike(String value) {
            addCriterion("step like", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotLike(String value) {
            addCriterion("step not like", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<String> values) {
            addCriterion("step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<String> values) {
            addCriterion("step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(String value1, String value2) {
            addCriterion("step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(String value1, String value2) {
            addCriterion("step not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andDriverIsNull() {
            addCriterion("driver is null");
            return (Criteria) this;
        }

        public Criteria andDriverIsNotNull() {
            addCriterion("driver is not null");
            return (Criteria) this;
        }

        public Criteria andDriverEqualTo(Integer value) {
            addCriterion("driver =", value, "driver");
            return (Criteria) this;
        }

        public Criteria andDriverNotEqualTo(Integer value) {
            addCriterion("driver <>", value, "driver");
            return (Criteria) this;
        }

        public Criteria andDriverGreaterThan(Integer value) {
            addCriterion("driver >", value, "driver");
            return (Criteria) this;
        }

        public Criteria andDriverGreaterThanOrEqualTo(Integer value) {
            addCriterion("driver >=", value, "driver");
            return (Criteria) this;
        }

        public Criteria andDriverLessThan(Integer value) {
            addCriterion("driver <", value, "driver");
            return (Criteria) this;
        }

        public Criteria andDriverLessThanOrEqualTo(Integer value) {
            addCriterion("driver <=", value, "driver");
            return (Criteria) this;
        }

        public Criteria andDriverIn(List<Integer> values) {
            addCriterion("driver in", values, "driver");
            return (Criteria) this;
        }

        public Criteria andDriverNotIn(List<Integer> values) {
            addCriterion("driver not in", values, "driver");
            return (Criteria) this;
        }

        public Criteria andDriverBetween(Integer value1, Integer value2) {
            addCriterion("driver between", value1, value2, "driver");
            return (Criteria) this;
        }

        public Criteria andDriverNotBetween(Integer value1, Integer value2) {
            addCriterion("driver not between", value1, value2, "driver");
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