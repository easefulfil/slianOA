package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaComplaintExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaComplaintExample() {
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

    public OaComplaintExample(int pageSize, int pageIndex) {
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

        public Criteria andComplaintIdIsNull() {
            addCriterion("complaint_id is null");
            return (Criteria) this;
        }

        public Criteria andComplaintIdIsNotNull() {
            addCriterion("complaint_id is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintIdEqualTo(Integer value) {
            addCriterion("complaint_id =", value, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdNotEqualTo(Integer value) {
            addCriterion("complaint_id <>", value, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdGreaterThan(Integer value) {
            addCriterion("complaint_id >", value, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("complaint_id >=", value, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdLessThan(Integer value) {
            addCriterion("complaint_id <", value, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdLessThanOrEqualTo(Integer value) {
            addCriterion("complaint_id <=", value, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdIn(List<Integer> values) {
            addCriterion("complaint_id in", values, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdNotIn(List<Integer> values) {
            addCriterion("complaint_id not in", values, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdBetween(Integer value1, Integer value2) {
            addCriterion("complaint_id between", value1, value2, "complaintId");
            return (Criteria) this;
        }

        public Criteria andComplaintIdNotBetween(Integer value1, Integer value2) {
            addCriterion("complaint_id not between", value1, value2, "complaintId");
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

        public Criteria andComplaintTimeIsNull() {
            addCriterion("complaint_time is null");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeIsNotNull() {
            addCriterion("complaint_time is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeEqualTo(Date value) {
            addCriterion("complaint_time =", value, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeNotEqualTo(Date value) {
            addCriterion("complaint_time <>", value, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeGreaterThan(Date value) {
            addCriterion("complaint_time >", value, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("complaint_time >=", value, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeLessThan(Date value) {
            addCriterion("complaint_time <", value, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeLessThanOrEqualTo(Date value) {
            addCriterion("complaint_time <=", value, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeIn(List<Date> values) {
            addCriterion("complaint_time in", values, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeNotIn(List<Date> values) {
            addCriterion("complaint_time not in", values, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeBetween(Date value1, Date value2) {
            addCriterion("complaint_time between", value1, value2, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeNotBetween(Date value1, Date value2) {
            addCriterion("complaint_time not between", value1, value2, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintPersonIsNull() {
            addCriterion("complaint_person is null");
            return (Criteria) this;
        }

        public Criteria andComplaintPersonIsNotNull() {
            addCriterion("complaint_person is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintPersonEqualTo(String value) {
            addCriterion("complaint_person =", value, "complaintPerson");
            return (Criteria) this;
        }

        public Criteria andComplaintPersonNotEqualTo(String value) {
            addCriterion("complaint_person <>", value, "complaintPerson");
            return (Criteria) this;
        }

        public Criteria andComplaintPersonGreaterThan(String value) {
            addCriterion("complaint_person >", value, "complaintPerson");
            return (Criteria) this;
        }

        public Criteria andComplaintPersonGreaterThanOrEqualTo(String value) {
            addCriterion("complaint_person >=", value, "complaintPerson");
            return (Criteria) this;
        }

        public Criteria andComplaintPersonLessThan(String value) {
            addCriterion("complaint_person <", value, "complaintPerson");
            return (Criteria) this;
        }

        public Criteria andComplaintPersonLessThanOrEqualTo(String value) {
            addCriterion("complaint_person <=", value, "complaintPerson");
            return (Criteria) this;
        }

        public Criteria andComplaintPersonLike(String value) {
            addCriterion("complaint_person like", value, "complaintPerson");
            return (Criteria) this;
        }

        public Criteria andComplaintPersonNotLike(String value) {
            addCriterion("complaint_person not like", value, "complaintPerson");
            return (Criteria) this;
        }

        public Criteria andComplaintPersonIn(List<String> values) {
            addCriterion("complaint_person in", values, "complaintPerson");
            return (Criteria) this;
        }

        public Criteria andComplaintPersonNotIn(List<String> values) {
            addCriterion("complaint_person not in", values, "complaintPerson");
            return (Criteria) this;
        }

        public Criteria andComplaintPersonBetween(String value1, String value2) {
            addCriterion("complaint_person between", value1, value2, "complaintPerson");
            return (Criteria) this;
        }

        public Criteria andComplaintPersonNotBetween(String value1, String value2) {
            addCriterion("complaint_person not between", value1, value2, "complaintPerson");
            return (Criteria) this;
        }

        public Criteria andComplaintContentIsNull() {
            addCriterion("complaint_content is null");
            return (Criteria) this;
        }

        public Criteria andComplaintContentIsNotNull() {
            addCriterion("complaint_content is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintContentEqualTo(String value) {
            addCriterion("complaint_content =", value, "complaintContent");
            return (Criteria) this;
        }

        public Criteria andComplaintContentNotEqualTo(String value) {
            addCriterion("complaint_content <>", value, "complaintContent");
            return (Criteria) this;
        }

        public Criteria andComplaintContentGreaterThan(String value) {
            addCriterion("complaint_content >", value, "complaintContent");
            return (Criteria) this;
        }

        public Criteria andComplaintContentGreaterThanOrEqualTo(String value) {
            addCriterion("complaint_content >=", value, "complaintContent");
            return (Criteria) this;
        }

        public Criteria andComplaintContentLessThan(String value) {
            addCriterion("complaint_content <", value, "complaintContent");
            return (Criteria) this;
        }

        public Criteria andComplaintContentLessThanOrEqualTo(String value) {
            addCriterion("complaint_content <=", value, "complaintContent");
            return (Criteria) this;
        }

        public Criteria andComplaintContentLike(String value) {
            addCriterion("complaint_content like", value, "complaintContent");
            return (Criteria) this;
        }

        public Criteria andComplaintContentNotLike(String value) {
            addCriterion("complaint_content not like", value, "complaintContent");
            return (Criteria) this;
        }

        public Criteria andComplaintContentIn(List<String> values) {
            addCriterion("complaint_content in", values, "complaintContent");
            return (Criteria) this;
        }

        public Criteria andComplaintContentNotIn(List<String> values) {
            addCriterion("complaint_content not in", values, "complaintContent");
            return (Criteria) this;
        }

        public Criteria andComplaintContentBetween(String value1, String value2) {
            addCriterion("complaint_content between", value1, value2, "complaintContent");
            return (Criteria) this;
        }

        public Criteria andComplaintContentNotBetween(String value1, String value2) {
            addCriterion("complaint_content not between", value1, value2, "complaintContent");
            return (Criteria) this;
        }

        public Criteria andComplaintAttachmentIsNull() {
            addCriterion("complaint_attachment is null");
            return (Criteria) this;
        }

        public Criteria andComplaintAttachmentIsNotNull() {
            addCriterion("complaint_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintAttachmentEqualTo(String value) {
            addCriterion("complaint_attachment =", value, "complaintAttachment");
            return (Criteria) this;
        }

        public Criteria andComplaintAttachmentNotEqualTo(String value) {
            addCriterion("complaint_attachment <>", value, "complaintAttachment");
            return (Criteria) this;
        }

        public Criteria andComplaintAttachmentGreaterThan(String value) {
            addCriterion("complaint_attachment >", value, "complaintAttachment");
            return (Criteria) this;
        }

        public Criteria andComplaintAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("complaint_attachment >=", value, "complaintAttachment");
            return (Criteria) this;
        }

        public Criteria andComplaintAttachmentLessThan(String value) {
            addCriterion("complaint_attachment <", value, "complaintAttachment");
            return (Criteria) this;
        }

        public Criteria andComplaintAttachmentLessThanOrEqualTo(String value) {
            addCriterion("complaint_attachment <=", value, "complaintAttachment");
            return (Criteria) this;
        }

        public Criteria andComplaintAttachmentLike(String value) {
            addCriterion("complaint_attachment like", value, "complaintAttachment");
            return (Criteria) this;
        }

        public Criteria andComplaintAttachmentNotLike(String value) {
            addCriterion("complaint_attachment not like", value, "complaintAttachment");
            return (Criteria) this;
        }

        public Criteria andComplaintAttachmentIn(List<String> values) {
            addCriterion("complaint_attachment in", values, "complaintAttachment");
            return (Criteria) this;
        }

        public Criteria andComplaintAttachmentNotIn(List<String> values) {
            addCriterion("complaint_attachment not in", values, "complaintAttachment");
            return (Criteria) this;
        }

        public Criteria andComplaintAttachmentBetween(String value1, String value2) {
            addCriterion("complaint_attachment between", value1, value2, "complaintAttachment");
            return (Criteria) this;
        }

        public Criteria andComplaintAttachmentNotBetween(String value1, String value2) {
            addCriterion("complaint_attachment not between", value1, value2, "complaintAttachment");
            return (Criteria) this;
        }

        public Criteria andComplaintResultIsNull() {
            addCriterion("complaint_result is null");
            return (Criteria) this;
        }

        public Criteria andComplaintResultIsNotNull() {
            addCriterion("complaint_result is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintResultEqualTo(String value) {
            addCriterion("complaint_result =", value, "complaintResult");
            return (Criteria) this;
        }

        public Criteria andComplaintResultNotEqualTo(String value) {
            addCriterion("complaint_result <>", value, "complaintResult");
            return (Criteria) this;
        }

        public Criteria andComplaintResultGreaterThan(String value) {
            addCriterion("complaint_result >", value, "complaintResult");
            return (Criteria) this;
        }

        public Criteria andComplaintResultGreaterThanOrEqualTo(String value) {
            addCriterion("complaint_result >=", value, "complaintResult");
            return (Criteria) this;
        }

        public Criteria andComplaintResultLessThan(String value) {
            addCriterion("complaint_result <", value, "complaintResult");
            return (Criteria) this;
        }

        public Criteria andComplaintResultLessThanOrEqualTo(String value) {
            addCriterion("complaint_result <=", value, "complaintResult");
            return (Criteria) this;
        }

        public Criteria andComplaintResultLike(String value) {
            addCriterion("complaint_result like", value, "complaintResult");
            return (Criteria) this;
        }

        public Criteria andComplaintResultNotLike(String value) {
            addCriterion("complaint_result not like", value, "complaintResult");
            return (Criteria) this;
        }

        public Criteria andComplaintResultIn(List<String> values) {
            addCriterion("complaint_result in", values, "complaintResult");
            return (Criteria) this;
        }

        public Criteria andComplaintResultNotIn(List<String> values) {
            addCriterion("complaint_result not in", values, "complaintResult");
            return (Criteria) this;
        }

        public Criteria andComplaintResultBetween(String value1, String value2) {
            addCriterion("complaint_result between", value1, value2, "complaintResult");
            return (Criteria) this;
        }

        public Criteria andComplaintResultNotBetween(String value1, String value2) {
            addCriterion("complaint_result not between", value1, value2, "complaintResult");
            return (Criteria) this;
        }

        public Criteria andRejectedReasonIsNull() {
            addCriterion("rejected_reason is null");
            return (Criteria) this;
        }

        public Criteria andRejectedReasonIsNotNull() {
            addCriterion("rejected_reason is not null");
            return (Criteria) this;
        }

        public Criteria andRejectedReasonEqualTo(String value) {
            addCriterion("rejected_reason =", value, "rejectedReason");
            return (Criteria) this;
        }

        public Criteria andRejectedReasonNotEqualTo(String value) {
            addCriterion("rejected_reason <>", value, "rejectedReason");
            return (Criteria) this;
        }

        public Criteria andRejectedReasonGreaterThan(String value) {
            addCriterion("rejected_reason >", value, "rejectedReason");
            return (Criteria) this;
        }

        public Criteria andRejectedReasonGreaterThanOrEqualTo(String value) {
            addCriterion("rejected_reason >=", value, "rejectedReason");
            return (Criteria) this;
        }

        public Criteria andRejectedReasonLessThan(String value) {
            addCriterion("rejected_reason <", value, "rejectedReason");
            return (Criteria) this;
        }

        public Criteria andRejectedReasonLessThanOrEqualTo(String value) {
            addCriterion("rejected_reason <=", value, "rejectedReason");
            return (Criteria) this;
        }

        public Criteria andRejectedReasonLike(String value) {
            addCriterion("rejected_reason like", value, "rejectedReason");
            return (Criteria) this;
        }

        public Criteria andRejectedReasonNotLike(String value) {
            addCriterion("rejected_reason not like", value, "rejectedReason");
            return (Criteria) this;
        }

        public Criteria andRejectedReasonIn(List<String> values) {
            addCriterion("rejected_reason in", values, "rejectedReason");
            return (Criteria) this;
        }

        public Criteria andRejectedReasonNotIn(List<String> values) {
            addCriterion("rejected_reason not in", values, "rejectedReason");
            return (Criteria) this;
        }

        public Criteria andRejectedReasonBetween(String value1, String value2) {
            addCriterion("rejected_reason between", value1, value2, "rejectedReason");
            return (Criteria) this;
        }

        public Criteria andRejectedReasonNotBetween(String value1, String value2) {
            addCriterion("rejected_reason not between", value1, value2, "rejectedReason");
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