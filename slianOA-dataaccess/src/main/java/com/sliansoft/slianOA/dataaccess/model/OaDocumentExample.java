package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaDocumentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaDocumentExample() {
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

    public OaDocumentExample(int pageSize, int pageIndex) {
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

        public Criteria andDocumentIdIsNull() {
            addCriterion("document_id is null");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIsNotNull() {
            addCriterion("document_id is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentIdEqualTo(Integer value) {
            addCriterion("document_id =", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotEqualTo(Integer value) {
            addCriterion("document_id <>", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdGreaterThan(Integer value) {
            addCriterion("document_id >", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("document_id >=", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLessThan(Integer value) {
            addCriterion("document_id <", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLessThanOrEqualTo(Integer value) {
            addCriterion("document_id <=", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIn(List<Integer> values) {
            addCriterion("document_id in", values, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotIn(List<Integer> values) {
            addCriterion("document_id not in", values, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdBetween(Integer value1, Integer value2) {
            addCriterion("document_id between", value1, value2, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("document_id not between", value1, value2, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocNumberIsNull() {
            addCriterion("doc_number is null");
            return (Criteria) this;
        }

        public Criteria andDocNumberIsNotNull() {
            addCriterion("doc_number is not null");
            return (Criteria) this;
        }

        public Criteria andDocNumberEqualTo(String value) {
            addCriterion("doc_number =", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberNotEqualTo(String value) {
            addCriterion("doc_number <>", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberGreaterThan(String value) {
            addCriterion("doc_number >", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberGreaterThanOrEqualTo(String value) {
            addCriterion("doc_number >=", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberLessThan(String value) {
            addCriterion("doc_number <", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberLessThanOrEqualTo(String value) {
            addCriterion("doc_number <=", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberLike(String value) {
            addCriterion("doc_number like", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberNotLike(String value) {
            addCriterion("doc_number not like", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberIn(List<String> values) {
            addCriterion("doc_number in", values, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberNotIn(List<String> values) {
            addCriterion("doc_number not in", values, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberBetween(String value1, String value2) {
            addCriterion("doc_number between", value1, value2, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberNotBetween(String value1, String value2) {
            addCriterion("doc_number not between", value1, value2, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocPostManIsNull() {
            addCriterion("doc_post_man is null");
            return (Criteria) this;
        }

        public Criteria andDocPostManIsNotNull() {
            addCriterion("doc_post_man is not null");
            return (Criteria) this;
        }

        public Criteria andDocPostManEqualTo(String value) {
            addCriterion("doc_post_man =", value, "docPostMan");
            return (Criteria) this;
        }

        public Criteria andDocPostManNotEqualTo(String value) {
            addCriterion("doc_post_man <>", value, "docPostMan");
            return (Criteria) this;
        }

        public Criteria andDocPostManGreaterThan(String value) {
            addCriterion("doc_post_man >", value, "docPostMan");
            return (Criteria) this;
        }

        public Criteria andDocPostManGreaterThanOrEqualTo(String value) {
            addCriterion("doc_post_man >=", value, "docPostMan");
            return (Criteria) this;
        }

        public Criteria andDocPostManLessThan(String value) {
            addCriterion("doc_post_man <", value, "docPostMan");
            return (Criteria) this;
        }

        public Criteria andDocPostManLessThanOrEqualTo(String value) {
            addCriterion("doc_post_man <=", value, "docPostMan");
            return (Criteria) this;
        }

        public Criteria andDocPostManLike(String value) {
            addCriterion("doc_post_man like", value, "docPostMan");
            return (Criteria) this;
        }

        public Criteria andDocPostManNotLike(String value) {
            addCriterion("doc_post_man not like", value, "docPostMan");
            return (Criteria) this;
        }

        public Criteria andDocPostManIn(List<String> values) {
            addCriterion("doc_post_man in", values, "docPostMan");
            return (Criteria) this;
        }

        public Criteria andDocPostManNotIn(List<String> values) {
            addCriterion("doc_post_man not in", values, "docPostMan");
            return (Criteria) this;
        }

        public Criteria andDocPostManBetween(String value1, String value2) {
            addCriterion("doc_post_man between", value1, value2, "docPostMan");
            return (Criteria) this;
        }

        public Criteria andDocPostManNotBetween(String value1, String value2) {
            addCriterion("doc_post_man not between", value1, value2, "docPostMan");
            return (Criteria) this;
        }

        public Criteria andDocRegistPersonIsNull() {
            addCriterion("doc_regist_person is null");
            return (Criteria) this;
        }

        public Criteria andDocRegistPersonIsNotNull() {
            addCriterion("doc_regist_person is not null");
            return (Criteria) this;
        }

        public Criteria andDocRegistPersonEqualTo(String value) {
            addCriterion("doc_regist_person =", value, "docRegistPerson");
            return (Criteria) this;
        }

        public Criteria andDocRegistPersonNotEqualTo(String value) {
            addCriterion("doc_regist_person <>", value, "docRegistPerson");
            return (Criteria) this;
        }

        public Criteria andDocRegistPersonGreaterThan(String value) {
            addCriterion("doc_regist_person >", value, "docRegistPerson");
            return (Criteria) this;
        }

        public Criteria andDocRegistPersonGreaterThanOrEqualTo(String value) {
            addCriterion("doc_regist_person >=", value, "docRegistPerson");
            return (Criteria) this;
        }

        public Criteria andDocRegistPersonLessThan(String value) {
            addCriterion("doc_regist_person <", value, "docRegistPerson");
            return (Criteria) this;
        }

        public Criteria andDocRegistPersonLessThanOrEqualTo(String value) {
            addCriterion("doc_regist_person <=", value, "docRegistPerson");
            return (Criteria) this;
        }

        public Criteria andDocRegistPersonLike(String value) {
            addCriterion("doc_regist_person like", value, "docRegistPerson");
            return (Criteria) this;
        }

        public Criteria andDocRegistPersonNotLike(String value) {
            addCriterion("doc_regist_person not like", value, "docRegistPerson");
            return (Criteria) this;
        }

        public Criteria andDocRegistPersonIn(List<String> values) {
            addCriterion("doc_regist_person in", values, "docRegistPerson");
            return (Criteria) this;
        }

        public Criteria andDocRegistPersonNotIn(List<String> values) {
            addCriterion("doc_regist_person not in", values, "docRegistPerson");
            return (Criteria) this;
        }

        public Criteria andDocRegistPersonBetween(String value1, String value2) {
            addCriterion("doc_regist_person between", value1, value2, "docRegistPerson");
            return (Criteria) this;
        }

        public Criteria andDocRegistPersonNotBetween(String value1, String value2) {
            addCriterion("doc_regist_person not between", value1, value2, "docRegistPerson");
            return (Criteria) this;
        }

        public Criteria andDocTimeIsNull() {
            addCriterion("doc_time is null");
            return (Criteria) this;
        }

        public Criteria andDocTimeIsNotNull() {
            addCriterion("doc_time is not null");
            return (Criteria) this;
        }

        public Criteria andDocTimeEqualTo(Date value) {
            addCriterion("doc_time =", value, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeNotEqualTo(Date value) {
            addCriterion("doc_time <>", value, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeGreaterThan(Date value) {
            addCriterion("doc_time >", value, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("doc_time >=", value, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeLessThan(Date value) {
            addCriterion("doc_time <", value, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeLessThanOrEqualTo(Date value) {
            addCriterion("doc_time <=", value, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeIn(List<Date> values) {
            addCriterion("doc_time in", values, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeNotIn(List<Date> values) {
            addCriterion("doc_time not in", values, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeBetween(Date value1, Date value2) {
            addCriterion("doc_time between", value1, value2, "docTime");
            return (Criteria) this;
        }

        public Criteria andDocTimeNotBetween(Date value1, Date value2) {
            addCriterion("doc_time not between", value1, value2, "docTime");
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

        public Criteria andSubtitleIsNull() {
            addCriterion("subtitle is null");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNotNull() {
            addCriterion("subtitle is not null");
            return (Criteria) this;
        }

        public Criteria andSubtitleEqualTo(String value) {
            addCriterion("subtitle =", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotEqualTo(String value) {
            addCriterion("subtitle <>", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThan(String value) {
            addCriterion("subtitle >", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("subtitle >=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThan(String value) {
            addCriterion("subtitle <", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThanOrEqualTo(String value) {
            addCriterion("subtitle <=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLike(String value) {
            addCriterion("subtitle like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotLike(String value) {
            addCriterion("subtitle not like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleIn(List<String> values) {
            addCriterion("subtitle in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotIn(List<String> values) {
            addCriterion("subtitle not in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleBetween(String value1, String value2) {
            addCriterion("subtitle between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotBetween(String value1, String value2) {
            addCriterion("subtitle not between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andDocFromInstitutionIsNull() {
            addCriterion("doc_from_Institution is null");
            return (Criteria) this;
        }

        public Criteria andDocFromInstitutionIsNotNull() {
            addCriterion("doc_from_Institution is not null");
            return (Criteria) this;
        }

        public Criteria andDocFromInstitutionEqualTo(String value) {
            addCriterion("doc_from_Institution =", value, "docFromInstitution");
            return (Criteria) this;
        }

        public Criteria andDocFromInstitutionNotEqualTo(String value) {
            addCriterion("doc_from_Institution <>", value, "docFromInstitution");
            return (Criteria) this;
        }

        public Criteria andDocFromInstitutionGreaterThan(String value) {
            addCriterion("doc_from_Institution >", value, "docFromInstitution");
            return (Criteria) this;
        }

        public Criteria andDocFromInstitutionGreaterThanOrEqualTo(String value) {
            addCriterion("doc_from_Institution >=", value, "docFromInstitution");
            return (Criteria) this;
        }

        public Criteria andDocFromInstitutionLessThan(String value) {
            addCriterion("doc_from_Institution <", value, "docFromInstitution");
            return (Criteria) this;
        }

        public Criteria andDocFromInstitutionLessThanOrEqualTo(String value) {
            addCriterion("doc_from_Institution <=", value, "docFromInstitution");
            return (Criteria) this;
        }

        public Criteria andDocFromInstitutionLike(String value) {
            addCriterion("doc_from_Institution like", value, "docFromInstitution");
            return (Criteria) this;
        }

        public Criteria andDocFromInstitutionNotLike(String value) {
            addCriterion("doc_from_Institution not like", value, "docFromInstitution");
            return (Criteria) this;
        }

        public Criteria andDocFromInstitutionIn(List<String> values) {
            addCriterion("doc_from_Institution in", values, "docFromInstitution");
            return (Criteria) this;
        }

        public Criteria andDocFromInstitutionNotIn(List<String> values) {
            addCriterion("doc_from_Institution not in", values, "docFromInstitution");
            return (Criteria) this;
        }

        public Criteria andDocFromInstitutionBetween(String value1, String value2) {
            addCriterion("doc_from_Institution between", value1, value2, "docFromInstitution");
            return (Criteria) this;
        }

        public Criteria andDocFromInstitutionNotBetween(String value1, String value2) {
            addCriterion("doc_from_Institution not between", value1, value2, "docFromInstitution");
            return (Criteria) this;
        }

        public Criteria andDocIsEmergencyIsNull() {
            addCriterion("doc_is_emergency is null");
            return (Criteria) this;
        }

        public Criteria andDocIsEmergencyIsNotNull() {
            addCriterion("doc_is_emergency is not null");
            return (Criteria) this;
        }

        public Criteria andDocIsEmergencyEqualTo(String value) {
            addCriterion("doc_is_emergency =", value, "docIsEmergency");
            return (Criteria) this;
        }

        public Criteria andDocIsEmergencyNotEqualTo(String value) {
            addCriterion("doc_is_emergency <>", value, "docIsEmergency");
            return (Criteria) this;
        }

        public Criteria andDocIsEmergencyGreaterThan(String value) {
            addCriterion("doc_is_emergency >", value, "docIsEmergency");
            return (Criteria) this;
        }

        public Criteria andDocIsEmergencyGreaterThanOrEqualTo(String value) {
            addCriterion("doc_is_emergency >=", value, "docIsEmergency");
            return (Criteria) this;
        }

        public Criteria andDocIsEmergencyLessThan(String value) {
            addCriterion("doc_is_emergency <", value, "docIsEmergency");
            return (Criteria) this;
        }

        public Criteria andDocIsEmergencyLessThanOrEqualTo(String value) {
            addCriterion("doc_is_emergency <=", value, "docIsEmergency");
            return (Criteria) this;
        }

        public Criteria andDocIsEmergencyLike(String value) {
            addCriterion("doc_is_emergency like", value, "docIsEmergency");
            return (Criteria) this;
        }

        public Criteria andDocIsEmergencyNotLike(String value) {
            addCriterion("doc_is_emergency not like", value, "docIsEmergency");
            return (Criteria) this;
        }

        public Criteria andDocIsEmergencyIn(List<String> values) {
            addCriterion("doc_is_emergency in", values, "docIsEmergency");
            return (Criteria) this;
        }

        public Criteria andDocIsEmergencyNotIn(List<String> values) {
            addCriterion("doc_is_emergency not in", values, "docIsEmergency");
            return (Criteria) this;
        }

        public Criteria andDocIsEmergencyBetween(String value1, String value2) {
            addCriterion("doc_is_emergency between", value1, value2, "docIsEmergency");
            return (Criteria) this;
        }

        public Criteria andDocIsEmergencyNotBetween(String value1, String value2) {
            addCriterion("doc_is_emergency not between", value1, value2, "docIsEmergency");
            return (Criteria) this;
        }

        public Criteria andDocFromNumIsNull() {
            addCriterion("doc_from_num is null");
            return (Criteria) this;
        }

        public Criteria andDocFromNumIsNotNull() {
            addCriterion("doc_from_num is not null");
            return (Criteria) this;
        }

        public Criteria andDocFromNumEqualTo(String value) {
            addCriterion("doc_from_num =", value, "docFromNum");
            return (Criteria) this;
        }

        public Criteria andDocFromNumNotEqualTo(String value) {
            addCriterion("doc_from_num <>", value, "docFromNum");
            return (Criteria) this;
        }

        public Criteria andDocFromNumGreaterThan(String value) {
            addCriterion("doc_from_num >", value, "docFromNum");
            return (Criteria) this;
        }

        public Criteria andDocFromNumGreaterThanOrEqualTo(String value) {
            addCriterion("doc_from_num >=", value, "docFromNum");
            return (Criteria) this;
        }

        public Criteria andDocFromNumLessThan(String value) {
            addCriterion("doc_from_num <", value, "docFromNum");
            return (Criteria) this;
        }

        public Criteria andDocFromNumLessThanOrEqualTo(String value) {
            addCriterion("doc_from_num <=", value, "docFromNum");
            return (Criteria) this;
        }

        public Criteria andDocFromNumLike(String value) {
            addCriterion("doc_from_num like", value, "docFromNum");
            return (Criteria) this;
        }

        public Criteria andDocFromNumNotLike(String value) {
            addCriterion("doc_from_num not like", value, "docFromNum");
            return (Criteria) this;
        }

        public Criteria andDocFromNumIn(List<String> values) {
            addCriterion("doc_from_num in", values, "docFromNum");
            return (Criteria) this;
        }

        public Criteria andDocFromNumNotIn(List<String> values) {
            addCriterion("doc_from_num not in", values, "docFromNum");
            return (Criteria) this;
        }

        public Criteria andDocFromNumBetween(String value1, String value2) {
            addCriterion("doc_from_num between", value1, value2, "docFromNum");
            return (Criteria) this;
        }

        public Criteria andDocFromNumNotBetween(String value1, String value2) {
            addCriterion("doc_from_num not between", value1, value2, "docFromNum");
            return (Criteria) this;
        }

        public Criteria andDocPagesIsNull() {
            addCriterion("doc_pages is null");
            return (Criteria) this;
        }

        public Criteria andDocPagesIsNotNull() {
            addCriterion("doc_pages is not null");
            return (Criteria) this;
        }

        public Criteria andDocPagesEqualTo(Integer value) {
            addCriterion("doc_pages =", value, "docPages");
            return (Criteria) this;
        }

        public Criteria andDocPagesNotEqualTo(Integer value) {
            addCriterion("doc_pages <>", value, "docPages");
            return (Criteria) this;
        }

        public Criteria andDocPagesGreaterThan(Integer value) {
            addCriterion("doc_pages >", value, "docPages");
            return (Criteria) this;
        }

        public Criteria andDocPagesGreaterThanOrEqualTo(Integer value) {
            addCriterion("doc_pages >=", value, "docPages");
            return (Criteria) this;
        }

        public Criteria andDocPagesLessThan(Integer value) {
            addCriterion("doc_pages <", value, "docPages");
            return (Criteria) this;
        }

        public Criteria andDocPagesLessThanOrEqualTo(Integer value) {
            addCriterion("doc_pages <=", value, "docPages");
            return (Criteria) this;
        }

        public Criteria andDocPagesIn(List<Integer> values) {
            addCriterion("doc_pages in", values, "docPages");
            return (Criteria) this;
        }

        public Criteria andDocPagesNotIn(List<Integer> values) {
            addCriterion("doc_pages not in", values, "docPages");
            return (Criteria) this;
        }

        public Criteria andDocPagesBetween(Integer value1, Integer value2) {
            addCriterion("doc_pages between", value1, value2, "docPages");
            return (Criteria) this;
        }

        public Criteria andDocPagesNotBetween(Integer value1, Integer value2) {
            addCriterion("doc_pages not between", value1, value2, "docPages");
            return (Criteria) this;
        }

        public Criteria andDocCopiesIsNull() {
            addCriterion("doc_copies is null");
            return (Criteria) this;
        }

        public Criteria andDocCopiesIsNotNull() {
            addCriterion("doc_copies is not null");
            return (Criteria) this;
        }

        public Criteria andDocCopiesEqualTo(Integer value) {
            addCriterion("doc_copies =", value, "docCopies");
            return (Criteria) this;
        }

        public Criteria andDocCopiesNotEqualTo(Integer value) {
            addCriterion("doc_copies <>", value, "docCopies");
            return (Criteria) this;
        }

        public Criteria andDocCopiesGreaterThan(Integer value) {
            addCriterion("doc_copies >", value, "docCopies");
            return (Criteria) this;
        }

        public Criteria andDocCopiesGreaterThanOrEqualTo(Integer value) {
            addCriterion("doc_copies >=", value, "docCopies");
            return (Criteria) this;
        }

        public Criteria andDocCopiesLessThan(Integer value) {
            addCriterion("doc_copies <", value, "docCopies");
            return (Criteria) this;
        }

        public Criteria andDocCopiesLessThanOrEqualTo(Integer value) {
            addCriterion("doc_copies <=", value, "docCopies");
            return (Criteria) this;
        }

        public Criteria andDocCopiesIn(List<Integer> values) {
            addCriterion("doc_copies in", values, "docCopies");
            return (Criteria) this;
        }

        public Criteria andDocCopiesNotIn(List<Integer> values) {
            addCriterion("doc_copies not in", values, "docCopies");
            return (Criteria) this;
        }

        public Criteria andDocCopiesBetween(Integer value1, Integer value2) {
            addCriterion("doc_copies between", value1, value2, "docCopies");
            return (Criteria) this;
        }

        public Criteria andDocCopiesNotBetween(Integer value1, Integer value2) {
            addCriterion("doc_copies not between", value1, value2, "docCopies");
            return (Criteria) this;
        }

        public Criteria andDocOfficeHandingIsNull() {
            addCriterion("doc_office_handing is null");
            return (Criteria) this;
        }

        public Criteria andDocOfficeHandingIsNotNull() {
            addCriterion("doc_office_handing is not null");
            return (Criteria) this;
        }

        public Criteria andDocOfficeHandingEqualTo(String value) {
            addCriterion("doc_office_handing =", value, "docOfficeHanding");
            return (Criteria) this;
        }

        public Criteria andDocOfficeHandingNotEqualTo(String value) {
            addCriterion("doc_office_handing <>", value, "docOfficeHanding");
            return (Criteria) this;
        }

        public Criteria andDocOfficeHandingGreaterThan(String value) {
            addCriterion("doc_office_handing >", value, "docOfficeHanding");
            return (Criteria) this;
        }

        public Criteria andDocOfficeHandingGreaterThanOrEqualTo(String value) {
            addCriterion("doc_office_handing >=", value, "docOfficeHanding");
            return (Criteria) this;
        }

        public Criteria andDocOfficeHandingLessThan(String value) {
            addCriterion("doc_office_handing <", value, "docOfficeHanding");
            return (Criteria) this;
        }

        public Criteria andDocOfficeHandingLessThanOrEqualTo(String value) {
            addCriterion("doc_office_handing <=", value, "docOfficeHanding");
            return (Criteria) this;
        }

        public Criteria andDocOfficeHandingLike(String value) {
            addCriterion("doc_office_handing like", value, "docOfficeHanding");
            return (Criteria) this;
        }

        public Criteria andDocOfficeHandingNotLike(String value) {
            addCriterion("doc_office_handing not like", value, "docOfficeHanding");
            return (Criteria) this;
        }

        public Criteria andDocOfficeHandingIn(List<String> values) {
            addCriterion("doc_office_handing in", values, "docOfficeHanding");
            return (Criteria) this;
        }

        public Criteria andDocOfficeHandingNotIn(List<String> values) {
            addCriterion("doc_office_handing not in", values, "docOfficeHanding");
            return (Criteria) this;
        }

        public Criteria andDocOfficeHandingBetween(String value1, String value2) {
            addCriterion("doc_office_handing between", value1, value2, "docOfficeHanding");
            return (Criteria) this;
        }

        public Criteria andDocOfficeHandingNotBetween(String value1, String value2) {
            addCriterion("doc_office_handing not between", value1, value2, "docOfficeHanding");
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

        public Criteria andDocDraftTimeIsNull() {
            addCriterion("doc_draft_time is null");
            return (Criteria) this;
        }

        public Criteria andDocDraftTimeIsNotNull() {
            addCriterion("doc_draft_time is not null");
            return (Criteria) this;
        }

        public Criteria andDocDraftTimeEqualTo(Date value) {
            addCriterion("doc_draft_time =", value, "docDraftTime");
            return (Criteria) this;
        }

        public Criteria andDocDraftTimeNotEqualTo(Date value) {
            addCriterion("doc_draft_time <>", value, "docDraftTime");
            return (Criteria) this;
        }

        public Criteria andDocDraftTimeGreaterThan(Date value) {
            addCriterion("doc_draft_time >", value, "docDraftTime");
            return (Criteria) this;
        }

        public Criteria andDocDraftTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("doc_draft_time >=", value, "docDraftTime");
            return (Criteria) this;
        }

        public Criteria andDocDraftTimeLessThan(Date value) {
            addCriterion("doc_draft_time <", value, "docDraftTime");
            return (Criteria) this;
        }

        public Criteria andDocDraftTimeLessThanOrEqualTo(Date value) {
            addCriterion("doc_draft_time <=", value, "docDraftTime");
            return (Criteria) this;
        }

        public Criteria andDocDraftTimeIn(List<Date> values) {
            addCriterion("doc_draft_time in", values, "docDraftTime");
            return (Criteria) this;
        }

        public Criteria andDocDraftTimeNotIn(List<Date> values) {
            addCriterion("doc_draft_time not in", values, "docDraftTime");
            return (Criteria) this;
        }

        public Criteria andDocDraftTimeBetween(Date value1, Date value2) {
            addCriterion("doc_draft_time between", value1, value2, "docDraftTime");
            return (Criteria) this;
        }

        public Criteria andDocDraftTimeNotBetween(Date value1, Date value2) {
            addCriterion("doc_draft_time not between", value1, value2, "docDraftTime");
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

        public Criteria andDocMainToUnitIsNull() {
            addCriterion("doc_main_to_unit is null");
            return (Criteria) this;
        }

        public Criteria andDocMainToUnitIsNotNull() {
            addCriterion("doc_main_to_unit is not null");
            return (Criteria) this;
        }

        public Criteria andDocMainToUnitEqualTo(String value) {
            addCriterion("doc_main_to_unit =", value, "docMainToUnit");
            return (Criteria) this;
        }

        public Criteria andDocMainToUnitNotEqualTo(String value) {
            addCriterion("doc_main_to_unit <>", value, "docMainToUnit");
            return (Criteria) this;
        }

        public Criteria andDocMainToUnitGreaterThan(String value) {
            addCriterion("doc_main_to_unit >", value, "docMainToUnit");
            return (Criteria) this;
        }

        public Criteria andDocMainToUnitGreaterThanOrEqualTo(String value) {
            addCriterion("doc_main_to_unit >=", value, "docMainToUnit");
            return (Criteria) this;
        }

        public Criteria andDocMainToUnitLessThan(String value) {
            addCriterion("doc_main_to_unit <", value, "docMainToUnit");
            return (Criteria) this;
        }

        public Criteria andDocMainToUnitLessThanOrEqualTo(String value) {
            addCriterion("doc_main_to_unit <=", value, "docMainToUnit");
            return (Criteria) this;
        }

        public Criteria andDocMainToUnitLike(String value) {
            addCriterion("doc_main_to_unit like", value, "docMainToUnit");
            return (Criteria) this;
        }

        public Criteria andDocMainToUnitNotLike(String value) {
            addCriterion("doc_main_to_unit not like", value, "docMainToUnit");
            return (Criteria) this;
        }

        public Criteria andDocMainToUnitIn(List<String> values) {
            addCriterion("doc_main_to_unit in", values, "docMainToUnit");
            return (Criteria) this;
        }

        public Criteria andDocMainToUnitNotIn(List<String> values) {
            addCriterion("doc_main_to_unit not in", values, "docMainToUnit");
            return (Criteria) this;
        }

        public Criteria andDocMainToUnitBetween(String value1, String value2) {
            addCriterion("doc_main_to_unit between", value1, value2, "docMainToUnit");
            return (Criteria) this;
        }

        public Criteria andDocMainToUnitNotBetween(String value1, String value2) {
            addCriterion("doc_main_to_unit not between", value1, value2, "docMainToUnit");
            return (Criteria) this;
        }

        public Criteria andDocCopyToUnitsIsNull() {
            addCriterion("doc_copy_to_units is null");
            return (Criteria) this;
        }

        public Criteria andDocCopyToUnitsIsNotNull() {
            addCriterion("doc_copy_to_units is not null");
            return (Criteria) this;
        }

        public Criteria andDocCopyToUnitsEqualTo(String value) {
            addCriterion("doc_copy_to_units =", value, "docCopyToUnits");
            return (Criteria) this;
        }

        public Criteria andDocCopyToUnitsNotEqualTo(String value) {
            addCriterion("doc_copy_to_units <>", value, "docCopyToUnits");
            return (Criteria) this;
        }

        public Criteria andDocCopyToUnitsGreaterThan(String value) {
            addCriterion("doc_copy_to_units >", value, "docCopyToUnits");
            return (Criteria) this;
        }

        public Criteria andDocCopyToUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("doc_copy_to_units >=", value, "docCopyToUnits");
            return (Criteria) this;
        }

        public Criteria andDocCopyToUnitsLessThan(String value) {
            addCriterion("doc_copy_to_units <", value, "docCopyToUnits");
            return (Criteria) this;
        }

        public Criteria andDocCopyToUnitsLessThanOrEqualTo(String value) {
            addCriterion("doc_copy_to_units <=", value, "docCopyToUnits");
            return (Criteria) this;
        }

        public Criteria andDocCopyToUnitsLike(String value) {
            addCriterion("doc_copy_to_units like", value, "docCopyToUnits");
            return (Criteria) this;
        }

        public Criteria andDocCopyToUnitsNotLike(String value) {
            addCriterion("doc_copy_to_units not like", value, "docCopyToUnits");
            return (Criteria) this;
        }

        public Criteria andDocCopyToUnitsIn(List<String> values) {
            addCriterion("doc_copy_to_units in", values, "docCopyToUnits");
            return (Criteria) this;
        }

        public Criteria andDocCopyToUnitsNotIn(List<String> values) {
            addCriterion("doc_copy_to_units not in", values, "docCopyToUnits");
            return (Criteria) this;
        }

        public Criteria andDocCopyToUnitsBetween(String value1, String value2) {
            addCriterion("doc_copy_to_units between", value1, value2, "docCopyToUnits");
            return (Criteria) this;
        }

        public Criteria andDocCopyToUnitsNotBetween(String value1, String value2) {
            addCriterion("doc_copy_to_units not between", value1, value2, "docCopyToUnits");
            return (Criteria) this;
        }

        public Criteria andDocSendTimeIsNull() {
            addCriterion("doc_send_time is null");
            return (Criteria) this;
        }

        public Criteria andDocSendTimeIsNotNull() {
            addCriterion("doc_send_time is not null");
            return (Criteria) this;
        }

        public Criteria andDocSendTimeEqualTo(Date value) {
            addCriterion("doc_send_time =", value, "docSendTime");
            return (Criteria) this;
        }

        public Criteria andDocSendTimeNotEqualTo(Date value) {
            addCriterion("doc_send_time <>", value, "docSendTime");
            return (Criteria) this;
        }

        public Criteria andDocSendTimeGreaterThan(Date value) {
            addCriterion("doc_send_time >", value, "docSendTime");
            return (Criteria) this;
        }

        public Criteria andDocSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("doc_send_time >=", value, "docSendTime");
            return (Criteria) this;
        }

        public Criteria andDocSendTimeLessThan(Date value) {
            addCriterion("doc_send_time <", value, "docSendTime");
            return (Criteria) this;
        }

        public Criteria andDocSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("doc_send_time <=", value, "docSendTime");
            return (Criteria) this;
        }

        public Criteria andDocSendTimeIn(List<Date> values) {
            addCriterion("doc_send_time in", values, "docSendTime");
            return (Criteria) this;
        }

        public Criteria andDocSendTimeNotIn(List<Date> values) {
            addCriterion("doc_send_time not in", values, "docSendTime");
            return (Criteria) this;
        }

        public Criteria andDocSendTimeBetween(Date value1, Date value2) {
            addCriterion("doc_send_time between", value1, value2, "docSendTime");
            return (Criteria) this;
        }

        public Criteria andDocSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("doc_send_time not between", value1, value2, "docSendTime");
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