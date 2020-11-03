package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysOrganizationStructureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public SysOrganizationStructureExample() {
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

    public SysOrganizationStructureExample(int pageSize, int pageIndex) {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSuperiorIsNull() {
            addCriterion("superior is null");
            return (Criteria) this;
        }

        public Criteria andSuperiorIsNotNull() {
            addCriterion("superior is not null");
            return (Criteria) this;
        }

        public Criteria andSuperiorEqualTo(String value) {
            addCriterion("superior =", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorNotEqualTo(String value) {
            addCriterion("superior <>", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorGreaterThan(String value) {
            addCriterion("superior >", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorGreaterThanOrEqualTo(String value) {
            addCriterion("superior >=", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorLessThan(String value) {
            addCriterion("superior <", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorLessThanOrEqualTo(String value) {
            addCriterion("superior <=", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorLike(String value) {
            addCriterion("superior like", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorNotLike(String value) {
            addCriterion("superior not like", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorIn(List<String> values) {
            addCriterion("superior in", values, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorNotIn(List<String> values) {
            addCriterion("superior not in", values, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorBetween(String value1, String value2) {
            addCriterion("superior between", value1, value2, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorNotBetween(String value1, String value2) {
            addCriterion("superior not between", value1, value2, "superior");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andOrgUsedNameIsNull() {
            addCriterion("org_used_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgUsedNameIsNotNull() {
            addCriterion("org_used_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgUsedNameEqualTo(String value) {
            addCriterion("org_used_name =", value, "orgUsedName");
            return (Criteria) this;
        }

        public Criteria andOrgUsedNameNotEqualTo(String value) {
            addCriterion("org_used_name <>", value, "orgUsedName");
            return (Criteria) this;
        }

        public Criteria andOrgUsedNameGreaterThan(String value) {
            addCriterion("org_used_name >", value, "orgUsedName");
            return (Criteria) this;
        }

        public Criteria andOrgUsedNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_used_name >=", value, "orgUsedName");
            return (Criteria) this;
        }

        public Criteria andOrgUsedNameLessThan(String value) {
            addCriterion("org_used_name <", value, "orgUsedName");
            return (Criteria) this;
        }

        public Criteria andOrgUsedNameLessThanOrEqualTo(String value) {
            addCriterion("org_used_name <=", value, "orgUsedName");
            return (Criteria) this;
        }

        public Criteria andOrgUsedNameLike(String value) {
            addCriterion("org_used_name like", value, "orgUsedName");
            return (Criteria) this;
        }

        public Criteria andOrgUsedNameNotLike(String value) {
            addCriterion("org_used_name not like", value, "orgUsedName");
            return (Criteria) this;
        }

        public Criteria andOrgUsedNameIn(List<String> values) {
            addCriterion("org_used_name in", values, "orgUsedName");
            return (Criteria) this;
        }

        public Criteria andOrgUsedNameNotIn(List<String> values) {
            addCriterion("org_used_name not in", values, "orgUsedName");
            return (Criteria) this;
        }

        public Criteria andOrgUsedNameBetween(String value1, String value2) {
            addCriterion("org_used_name between", value1, value2, "orgUsedName");
            return (Criteria) this;
        }

        public Criteria andOrgUsedNameNotBetween(String value1, String value2) {
            addCriterion("org_used_name not between", value1, value2, "orgUsedName");
            return (Criteria) this;
        }

        public Criteria andLicenseKeyIsNull() {
            addCriterion("license_key is null");
            return (Criteria) this;
        }

        public Criteria andLicenseKeyIsNotNull() {
            addCriterion("license_key is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseKeyEqualTo(String value) {
            addCriterion("license_key =", value, "licenseKey");
            return (Criteria) this;
        }

        public Criteria andLicenseKeyNotEqualTo(String value) {
            addCriterion("license_key <>", value, "licenseKey");
            return (Criteria) this;
        }

        public Criteria andLicenseKeyGreaterThan(String value) {
            addCriterion("license_key >", value, "licenseKey");
            return (Criteria) this;
        }

        public Criteria andLicenseKeyGreaterThanOrEqualTo(String value) {
            addCriterion("license_key >=", value, "licenseKey");
            return (Criteria) this;
        }

        public Criteria andLicenseKeyLessThan(String value) {
            addCriterion("license_key <", value, "licenseKey");
            return (Criteria) this;
        }

        public Criteria andLicenseKeyLessThanOrEqualTo(String value) {
            addCriterion("license_key <=", value, "licenseKey");
            return (Criteria) this;
        }

        public Criteria andLicenseKeyLike(String value) {
            addCriterion("license_key like", value, "licenseKey");
            return (Criteria) this;
        }

        public Criteria andLicenseKeyNotLike(String value) {
            addCriterion("license_key not like", value, "licenseKey");
            return (Criteria) this;
        }

        public Criteria andLicenseKeyIn(List<String> values) {
            addCriterion("license_key in", values, "licenseKey");
            return (Criteria) this;
        }

        public Criteria andLicenseKeyNotIn(List<String> values) {
            addCriterion("license_key not in", values, "licenseKey");
            return (Criteria) this;
        }

        public Criteria andLicenseKeyBetween(String value1, String value2) {
            addCriterion("license_key between", value1, value2, "licenseKey");
            return (Criteria) this;
        }

        public Criteria andLicenseKeyNotBetween(String value1, String value2) {
            addCriterion("license_key not between", value1, value2, "licenseKey");
            return (Criteria) this;
        }

        public Criteria andManagementStatusIsNull() {
            addCriterion("management_status is null");
            return (Criteria) this;
        }

        public Criteria andManagementStatusIsNotNull() {
            addCriterion("management_status is not null");
            return (Criteria) this;
        }

        public Criteria andManagementStatusEqualTo(Integer value) {
            addCriterion("management_status =", value, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusNotEqualTo(Integer value) {
            addCriterion("management_status <>", value, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusGreaterThan(Integer value) {
            addCriterion("management_status >", value, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("management_status >=", value, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusLessThan(Integer value) {
            addCriterion("management_status <", value, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusLessThanOrEqualTo(Integer value) {
            addCriterion("management_status <=", value, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusIn(List<Integer> values) {
            addCriterion("management_status in", values, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusNotIn(List<Integer> values) {
            addCriterion("management_status not in", values, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusBetween(Integer value1, Integer value2) {
            addCriterion("management_status between", value1, value2, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("management_status not between", value1, value2, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andAssayOfficeIsNull() {
            addCriterion("assay_office is null");
            return (Criteria) this;
        }

        public Criteria andAssayOfficeIsNotNull() {
            addCriterion("assay_office is not null");
            return (Criteria) this;
        }

        public Criteria andAssayOfficeEqualTo(String value) {
            addCriterion("assay_office =", value, "assayOffice");
            return (Criteria) this;
        }

        public Criteria andAssayOfficeNotEqualTo(String value) {
            addCriterion("assay_office <>", value, "assayOffice");
            return (Criteria) this;
        }

        public Criteria andAssayOfficeGreaterThan(String value) {
            addCriterion("assay_office >", value, "assayOffice");
            return (Criteria) this;
        }

        public Criteria andAssayOfficeGreaterThanOrEqualTo(String value) {
            addCriterion("assay_office >=", value, "assayOffice");
            return (Criteria) this;
        }

        public Criteria andAssayOfficeLessThan(String value) {
            addCriterion("assay_office <", value, "assayOffice");
            return (Criteria) this;
        }

        public Criteria andAssayOfficeLessThanOrEqualTo(String value) {
            addCriterion("assay_office <=", value, "assayOffice");
            return (Criteria) this;
        }

        public Criteria andAssayOfficeLike(String value) {
            addCriterion("assay_office like", value, "assayOffice");
            return (Criteria) this;
        }

        public Criteria andAssayOfficeNotLike(String value) {
            addCriterion("assay_office not like", value, "assayOffice");
            return (Criteria) this;
        }

        public Criteria andAssayOfficeIn(List<String> values) {
            addCriterion("assay_office in", values, "assayOffice");
            return (Criteria) this;
        }

        public Criteria andAssayOfficeNotIn(List<String> values) {
            addCriterion("assay_office not in", values, "assayOffice");
            return (Criteria) this;
        }

        public Criteria andAssayOfficeBetween(String value1, String value2) {
            addCriterion("assay_office between", value1, value2, "assayOffice");
            return (Criteria) this;
        }

        public Criteria andAssayOfficeNotBetween(String value1, String value2) {
            addCriterion("assay_office not between", value1, value2, "assayOffice");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(Integer value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(Integer value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(Integer value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(Integer value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<Integer> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<Integer> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(Integer value1, Integer value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andZzjgdmzhIsNull() {
            addCriterion("ZZJGDMZH is null");
            return (Criteria) this;
        }

        public Criteria andZzjgdmzhIsNotNull() {
            addCriterion("ZZJGDMZH is not null");
            return (Criteria) this;
        }

        public Criteria andZzjgdmzhEqualTo(String value) {
            addCriterion("ZZJGDMZH =", value, "zzjgdmzh");
            return (Criteria) this;
        }

        public Criteria andZzjgdmzhNotEqualTo(String value) {
            addCriterion("ZZJGDMZH <>", value, "zzjgdmzh");
            return (Criteria) this;
        }

        public Criteria andZzjgdmzhGreaterThan(String value) {
            addCriterion("ZZJGDMZH >", value, "zzjgdmzh");
            return (Criteria) this;
        }

        public Criteria andZzjgdmzhGreaterThanOrEqualTo(String value) {
            addCriterion("ZZJGDMZH >=", value, "zzjgdmzh");
            return (Criteria) this;
        }

        public Criteria andZzjgdmzhLessThan(String value) {
            addCriterion("ZZJGDMZH <", value, "zzjgdmzh");
            return (Criteria) this;
        }

        public Criteria andZzjgdmzhLessThanOrEqualTo(String value) {
            addCriterion("ZZJGDMZH <=", value, "zzjgdmzh");
            return (Criteria) this;
        }

        public Criteria andZzjgdmzhLike(String value) {
            addCriterion("ZZJGDMZH like", value, "zzjgdmzh");
            return (Criteria) this;
        }

        public Criteria andZzjgdmzhNotLike(String value) {
            addCriterion("ZZJGDMZH not like", value, "zzjgdmzh");
            return (Criteria) this;
        }

        public Criteria andZzjgdmzhIn(List<String> values) {
            addCriterion("ZZJGDMZH in", values, "zzjgdmzh");
            return (Criteria) this;
        }

        public Criteria andZzjgdmzhNotIn(List<String> values) {
            addCriterion("ZZJGDMZH not in", values, "zzjgdmzh");
            return (Criteria) this;
        }

        public Criteria andZzjgdmzhBetween(String value1, String value2) {
            addCriterion("ZZJGDMZH between", value1, value2, "zzjgdmzh");
            return (Criteria) this;
        }

        public Criteria andZzjgdmzhNotBetween(String value1, String value2) {
            addCriterion("ZZJGDMZH not between", value1, value2, "zzjgdmzh");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIsNull() {
            addCriterion("approval_number is null");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIsNotNull() {
            addCriterion("approval_number is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberEqualTo(String value) {
            addCriterion("approval_number =", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotEqualTo(String value) {
            addCriterion("approval_number <>", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberGreaterThan(String value) {
            addCriterion("approval_number >", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberGreaterThanOrEqualTo(String value) {
            addCriterion("approval_number >=", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLessThan(String value) {
            addCriterion("approval_number <", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLessThanOrEqualTo(String value) {
            addCriterion("approval_number <=", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLike(String value) {
            addCriterion("approval_number like", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotLike(String value) {
            addCriterion("approval_number not like", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIn(List<String> values) {
            addCriterion("approval_number in", values, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotIn(List<String> values) {
            addCriterion("approval_number not in", values, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberBetween(String value1, String value2) {
            addCriterion("approval_number between", value1, value2, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotBetween(String value1, String value2) {
            addCriterion("approval_number not between", value1, value2, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andZgsfjIsNull() {
            addCriterion("ZGSFJ is null");
            return (Criteria) this;
        }

        public Criteria andZgsfjIsNotNull() {
            addCriterion("ZGSFJ is not null");
            return (Criteria) this;
        }

        public Criteria andZgsfjEqualTo(String value) {
            addCriterion("ZGSFJ =", value, "zgsfj");
            return (Criteria) this;
        }

        public Criteria andZgsfjNotEqualTo(String value) {
            addCriterion("ZGSFJ <>", value, "zgsfj");
            return (Criteria) this;
        }

        public Criteria andZgsfjGreaterThan(String value) {
            addCriterion("ZGSFJ >", value, "zgsfj");
            return (Criteria) this;
        }

        public Criteria andZgsfjGreaterThanOrEqualTo(String value) {
            addCriterion("ZGSFJ >=", value, "zgsfj");
            return (Criteria) this;
        }

        public Criteria andZgsfjLessThan(String value) {
            addCriterion("ZGSFJ <", value, "zgsfj");
            return (Criteria) this;
        }

        public Criteria andZgsfjLessThanOrEqualTo(String value) {
            addCriterion("ZGSFJ <=", value, "zgsfj");
            return (Criteria) this;
        }

        public Criteria andZgsfjLike(String value) {
            addCriterion("ZGSFJ like", value, "zgsfj");
            return (Criteria) this;
        }

        public Criteria andZgsfjNotLike(String value) {
            addCriterion("ZGSFJ not like", value, "zgsfj");
            return (Criteria) this;
        }

        public Criteria andZgsfjIn(List<String> values) {
            addCriterion("ZGSFJ in", values, "zgsfj");
            return (Criteria) this;
        }

        public Criteria andZgsfjNotIn(List<String> values) {
            addCriterion("ZGSFJ not in", values, "zgsfj");
            return (Criteria) this;
        }

        public Criteria andZgsfjBetween(String value1, String value2) {
            addCriterion("ZGSFJ between", value1, value2, "zgsfj");
            return (Criteria) this;
        }

        public Criteria andZgsfjNotBetween(String value1, String value2) {
            addCriterion("ZGSFJ not between", value1, value2, "zgsfj");
            return (Criteria) this;
        }

        public Criteria andApprovalDateIsNull() {
            addCriterion("approval_date is null");
            return (Criteria) this;
        }

        public Criteria andApprovalDateIsNotNull() {
            addCriterion("approval_date is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalDateEqualTo(Date value) {
            addCriterion("approval_date =", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateNotEqualTo(Date value) {
            addCriterion("approval_date <>", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateGreaterThan(Date value) {
            addCriterion("approval_date >", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateGreaterThanOrEqualTo(Date value) {
            addCriterion("approval_date >=", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateLessThan(Date value) {
            addCriterion("approval_date <", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateLessThanOrEqualTo(Date value) {
            addCriterion("approval_date <=", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateIn(List<Date> values) {
            addCriterion("approval_date in", values, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateNotIn(List<Date> values) {
            addCriterion("approval_date not in", values, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateBetween(Date value1, Date value2) {
            addCriterion("approval_date between", value1, value2, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateNotBetween(Date value1, Date value2) {
            addCriterion("approval_date not between", value1, value2, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityBeginIsNull() {
            addCriterion("period_validity_begin is null");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityBeginIsNotNull() {
            addCriterion("period_validity_begin is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityBeginEqualTo(Date value) {
            addCriterion("period_validity_begin =", value, "periodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityBeginNotEqualTo(Date value) {
            addCriterion("period_validity_begin <>", value, "periodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityBeginGreaterThan(Date value) {
            addCriterion("period_validity_begin >", value, "periodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityBeginGreaterThanOrEqualTo(Date value) {
            addCriterion("period_validity_begin >=", value, "periodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityBeginLessThan(Date value) {
            addCriterion("period_validity_begin <", value, "periodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityBeginLessThanOrEqualTo(Date value) {
            addCriterion("period_validity_begin <=", value, "periodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityBeginIn(List<Date> values) {
            addCriterion("period_validity_begin in", values, "periodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityBeginNotIn(List<Date> values) {
            addCriterion("period_validity_begin not in", values, "periodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityBeginBetween(Date value1, Date value2) {
            addCriterion("period_validity_begin between", value1, value2, "periodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityBeginNotBetween(Date value1, Date value2) {
            addCriterion("period_validity_begin not between", value1, value2, "periodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityEndIsNull() {
            addCriterion("period_validity_end is null");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityEndIsNotNull() {
            addCriterion("period_validity_end is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityEndEqualTo(Date value) {
            addCriterion("period_validity_end =", value, "periodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityEndNotEqualTo(Date value) {
            addCriterion("period_validity_end <>", value, "periodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityEndGreaterThan(Date value) {
            addCriterion("period_validity_end >", value, "periodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityEndGreaterThanOrEqualTo(Date value) {
            addCriterion("period_validity_end >=", value, "periodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityEndLessThan(Date value) {
            addCriterion("period_validity_end <", value, "periodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityEndLessThanOrEqualTo(Date value) {
            addCriterion("period_validity_end <=", value, "periodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityEndIn(List<Date> values) {
            addCriterion("period_validity_end in", values, "periodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityEndNotIn(List<Date> values) {
            addCriterion("period_validity_end not in", values, "periodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityEndBetween(Date value1, Date value2) {
            addCriterion("period_validity_end between", value1, value2, "periodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPeriodValidityEndNotBetween(Date value1, Date value2) {
            addCriterion("period_validity_end not between", value1, value2, "periodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNull() {
            addCriterion("property is null");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNotNull() {
            addCriterion("property is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyEqualTo(String value) {
            addCriterion("property =", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotEqualTo(String value) {
            addCriterion("property <>", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThan(String value) {
            addCriterion("property >", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("property >=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThan(String value) {
            addCriterion("property <", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThanOrEqualTo(String value) {
            addCriterion("property <=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLike(String value) {
            addCriterion("property like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotLike(String value) {
            addCriterion("property not like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyIn(List<String> values) {
            addCriterion("property in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotIn(List<String> values) {
            addCriterion("property not in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyBetween(String value1, String value2) {
            addCriterion("property between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotBetween(String value1, String value2) {
            addCriterion("property not between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andFqdwxzIsNull() {
            addCriterion("FQDWXZ is null");
            return (Criteria) this;
        }

        public Criteria andFqdwxzIsNotNull() {
            addCriterion("FQDWXZ is not null");
            return (Criteria) this;
        }

        public Criteria andFqdwxzEqualTo(String value) {
            addCriterion("FQDWXZ =", value, "fqdwxz");
            return (Criteria) this;
        }

        public Criteria andFqdwxzNotEqualTo(String value) {
            addCriterion("FQDWXZ <>", value, "fqdwxz");
            return (Criteria) this;
        }

        public Criteria andFqdwxzGreaterThan(String value) {
            addCriterion("FQDWXZ >", value, "fqdwxz");
            return (Criteria) this;
        }

        public Criteria andFqdwxzGreaterThanOrEqualTo(String value) {
            addCriterion("FQDWXZ >=", value, "fqdwxz");
            return (Criteria) this;
        }

        public Criteria andFqdwxzLessThan(String value) {
            addCriterion("FQDWXZ <", value, "fqdwxz");
            return (Criteria) this;
        }

        public Criteria andFqdwxzLessThanOrEqualTo(String value) {
            addCriterion("FQDWXZ <=", value, "fqdwxz");
            return (Criteria) this;
        }

        public Criteria andFqdwxzLike(String value) {
            addCriterion("FQDWXZ like", value, "fqdwxz");
            return (Criteria) this;
        }

        public Criteria andFqdwxzNotLike(String value) {
            addCriterion("FQDWXZ not like", value, "fqdwxz");
            return (Criteria) this;
        }

        public Criteria andFqdwxzIn(List<String> values) {
            addCriterion("FQDWXZ in", values, "fqdwxz");
            return (Criteria) this;
        }

        public Criteria andFqdwxzNotIn(List<String> values) {
            addCriterion("FQDWXZ not in", values, "fqdwxz");
            return (Criteria) this;
        }

        public Criteria andFqdwxzBetween(String value1, String value2) {
            addCriterion("FQDWXZ between", value1, value2, "fqdwxz");
            return (Criteria) this;
        }

        public Criteria andFqdwxzNotBetween(String value1, String value2) {
            addCriterion("FQDWXZ not between", value1, value2, "fqdwxz");
            return (Criteria) this;
        }

        public Criteria andFinancialResourcesIsNull() {
            addCriterion("financial_resources is null");
            return (Criteria) this;
        }

        public Criteria andFinancialResourcesIsNotNull() {
            addCriterion("financial_resources is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialResourcesEqualTo(String value) {
            addCriterion("financial_resources =", value, "financialResources");
            return (Criteria) this;
        }

        public Criteria andFinancialResourcesNotEqualTo(String value) {
            addCriterion("financial_resources <>", value, "financialResources");
            return (Criteria) this;
        }

        public Criteria andFinancialResourcesGreaterThan(String value) {
            addCriterion("financial_resources >", value, "financialResources");
            return (Criteria) this;
        }

        public Criteria andFinancialResourcesGreaterThanOrEqualTo(String value) {
            addCriterion("financial_resources >=", value, "financialResources");
            return (Criteria) this;
        }

        public Criteria andFinancialResourcesLessThan(String value) {
            addCriterion("financial_resources <", value, "financialResources");
            return (Criteria) this;
        }

        public Criteria andFinancialResourcesLessThanOrEqualTo(String value) {
            addCriterion("financial_resources <=", value, "financialResources");
            return (Criteria) this;
        }

        public Criteria andFinancialResourcesLike(String value) {
            addCriterion("financial_resources like", value, "financialResources");
            return (Criteria) this;
        }

        public Criteria andFinancialResourcesNotLike(String value) {
            addCriterion("financial_resources not like", value, "financialResources");
            return (Criteria) this;
        }

        public Criteria andFinancialResourcesIn(List<String> values) {
            addCriterion("financial_resources in", values, "financialResources");
            return (Criteria) this;
        }

        public Criteria andFinancialResourcesNotIn(List<String> values) {
            addCriterion("financial_resources not in", values, "financialResources");
            return (Criteria) this;
        }

        public Criteria andFinancialResourcesBetween(String value1, String value2) {
            addCriterion("financial_resources between", value1, value2, "financialResources");
            return (Criteria) this;
        }

        public Criteria andFinancialResourcesNotBetween(String value1, String value2) {
            addCriterion("financial_resources not between", value1, value2, "financialResources");
            return (Criteria) this;
        }

        public Criteria andDzbxsIsNull() {
            addCriterion("DZBXS is null");
            return (Criteria) this;
        }

        public Criteria andDzbxsIsNotNull() {
            addCriterion("DZBXS is not null");
            return (Criteria) this;
        }

        public Criteria andDzbxsEqualTo(String value) {
            addCriterion("DZBXS =", value, "dzbxs");
            return (Criteria) this;
        }

        public Criteria andDzbxsNotEqualTo(String value) {
            addCriterion("DZBXS <>", value, "dzbxs");
            return (Criteria) this;
        }

        public Criteria andDzbxsGreaterThan(String value) {
            addCriterion("DZBXS >", value, "dzbxs");
            return (Criteria) this;
        }

        public Criteria andDzbxsGreaterThanOrEqualTo(String value) {
            addCriterion("DZBXS >=", value, "dzbxs");
            return (Criteria) this;
        }

        public Criteria andDzbxsLessThan(String value) {
            addCriterion("DZBXS <", value, "dzbxs");
            return (Criteria) this;
        }

        public Criteria andDzbxsLessThanOrEqualTo(String value) {
            addCriterion("DZBXS <=", value, "dzbxs");
            return (Criteria) this;
        }

        public Criteria andDzbxsLike(String value) {
            addCriterion("DZBXS like", value, "dzbxs");
            return (Criteria) this;
        }

        public Criteria andDzbxsNotLike(String value) {
            addCriterion("DZBXS not like", value, "dzbxs");
            return (Criteria) this;
        }

        public Criteria andDzbxsIn(List<String> values) {
            addCriterion("DZBXS in", values, "dzbxs");
            return (Criteria) this;
        }

        public Criteria andDzbxsNotIn(List<String> values) {
            addCriterion("DZBXS not in", values, "dzbxs");
            return (Criteria) this;
        }

        public Criteria andDzbxsBetween(String value1, String value2) {
            addCriterion("DZBXS between", value1, value2, "dzbxs");
            return (Criteria) this;
        }

        public Criteria andDzbxsNotBetween(String value1, String value2) {
            addCriterion("DZBXS not between", value1, value2, "dzbxs");
            return (Criteria) this;
        }

        public Criteria andSlzczeIsNull() {
            addCriterion("SLZCZE is null");
            return (Criteria) this;
        }

        public Criteria andSlzczeIsNotNull() {
            addCriterion("SLZCZE is not null");
            return (Criteria) this;
        }

        public Criteria andSlzczeEqualTo(Double value) {
            addCriterion("SLZCZE =", value, "slzcze");
            return (Criteria) this;
        }

        public Criteria andSlzczeNotEqualTo(Double value) {
            addCriterion("SLZCZE <>", value, "slzcze");
            return (Criteria) this;
        }

        public Criteria andSlzczeGreaterThan(Double value) {
            addCriterion("SLZCZE >", value, "slzcze");
            return (Criteria) this;
        }

        public Criteria andSlzczeGreaterThanOrEqualTo(Double value) {
            addCriterion("SLZCZE >=", value, "slzcze");
            return (Criteria) this;
        }

        public Criteria andSlzczeLessThan(Double value) {
            addCriterion("SLZCZE <", value, "slzcze");
            return (Criteria) this;
        }

        public Criteria andSlzczeLessThanOrEqualTo(Double value) {
            addCriterion("SLZCZE <=", value, "slzcze");
            return (Criteria) this;
        }

        public Criteria andSlzczeIn(List<Double> values) {
            addCriterion("SLZCZE in", values, "slzcze");
            return (Criteria) this;
        }

        public Criteria andSlzczeNotIn(List<Double> values) {
            addCriterion("SLZCZE not in", values, "slzcze");
            return (Criteria) this;
        }

        public Criteria andSlzczeBetween(Double value1, Double value2) {
            addCriterion("SLZCZE between", value1, value2, "slzcze");
            return (Criteria) this;
        }

        public Criteria andSlzczeNotBetween(Double value1, Double value2) {
            addCriterion("SLZCZE not between", value1, value2, "slzcze");
            return (Criteria) this;
        }

        public Criteria andOfficeAreaIsNull() {
            addCriterion("office_area is null");
            return (Criteria) this;
        }

        public Criteria andOfficeAreaIsNotNull() {
            addCriterion("office_area is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeAreaEqualTo(Double value) {
            addCriterion("office_area =", value, "officeArea");
            return (Criteria) this;
        }

        public Criteria andOfficeAreaNotEqualTo(Double value) {
            addCriterion("office_area <>", value, "officeArea");
            return (Criteria) this;
        }

        public Criteria andOfficeAreaGreaterThan(Double value) {
            addCriterion("office_area >", value, "officeArea");
            return (Criteria) this;
        }

        public Criteria andOfficeAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("office_area >=", value, "officeArea");
            return (Criteria) this;
        }

        public Criteria andOfficeAreaLessThan(Double value) {
            addCriterion("office_area <", value, "officeArea");
            return (Criteria) this;
        }

        public Criteria andOfficeAreaLessThanOrEqualTo(Double value) {
            addCriterion("office_area <=", value, "officeArea");
            return (Criteria) this;
        }

        public Criteria andOfficeAreaIn(List<Double> values) {
            addCriterion("office_area in", values, "officeArea");
            return (Criteria) this;
        }

        public Criteria andOfficeAreaNotIn(List<Double> values) {
            addCriterion("office_area not in", values, "officeArea");
            return (Criteria) this;
        }

        public Criteria andOfficeAreaBetween(Double value1, Double value2) {
            addCriterion("office_area between", value1, value2, "officeArea");
            return (Criteria) this;
        }

        public Criteria andOfficeAreaNotBetween(Double value1, Double value2) {
            addCriterion("office_area not between", value1, value2, "officeArea");
            return (Criteria) this;
        }

        public Criteria andIsanalysisIsNull() {
            addCriterion("isAnalysis is null");
            return (Criteria) this;
        }

        public Criteria andIsanalysisIsNotNull() {
            addCriterion("isAnalysis is not null");
            return (Criteria) this;
        }

        public Criteria andIsanalysisEqualTo(String value) {
            addCriterion("isAnalysis =", value, "isanalysis");
            return (Criteria) this;
        }

        public Criteria andIsanalysisNotEqualTo(String value) {
            addCriterion("isAnalysis <>", value, "isanalysis");
            return (Criteria) this;
        }

        public Criteria andIsanalysisGreaterThan(String value) {
            addCriterion("isAnalysis >", value, "isanalysis");
            return (Criteria) this;
        }

        public Criteria andIsanalysisGreaterThanOrEqualTo(String value) {
            addCriterion("isAnalysis >=", value, "isanalysis");
            return (Criteria) this;
        }

        public Criteria andIsanalysisLessThan(String value) {
            addCriterion("isAnalysis <", value, "isanalysis");
            return (Criteria) this;
        }

        public Criteria andIsanalysisLessThanOrEqualTo(String value) {
            addCriterion("isAnalysis <=", value, "isanalysis");
            return (Criteria) this;
        }

        public Criteria andIsanalysisLike(String value) {
            addCriterion("isAnalysis like", value, "isanalysis");
            return (Criteria) this;
        }

        public Criteria andIsanalysisNotLike(String value) {
            addCriterion("isAnalysis not like", value, "isanalysis");
            return (Criteria) this;
        }

        public Criteria andIsanalysisIn(List<String> values) {
            addCriterion("isAnalysis in", values, "isanalysis");
            return (Criteria) this;
        }

        public Criteria andIsanalysisNotIn(List<String> values) {
            addCriterion("isAnalysis not in", values, "isanalysis");
            return (Criteria) this;
        }

        public Criteria andIsanalysisBetween(String value1, String value2) {
            addCriterion("isAnalysis between", value1, value2, "isanalysis");
            return (Criteria) this;
        }

        public Criteria andIsanalysisNotBetween(String value1, String value2) {
            addCriterion("isAnalysis not between", value1, value2, "isanalysis");
            return (Criteria) this;
        }

        public Criteria andAbbreviationIsNull() {
            addCriterion("abbreviation is null");
            return (Criteria) this;
        }

        public Criteria andAbbreviationIsNotNull() {
            addCriterion("abbreviation is not null");
            return (Criteria) this;
        }

        public Criteria andAbbreviationEqualTo(String value) {
            addCriterion("abbreviation =", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationNotEqualTo(String value) {
            addCriterion("abbreviation <>", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationGreaterThan(String value) {
            addCriterion("abbreviation >", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationGreaterThanOrEqualTo(String value) {
            addCriterion("abbreviation >=", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationLessThan(String value) {
            addCriterion("abbreviation <", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationLessThanOrEqualTo(String value) {
            addCriterion("abbreviation <=", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationLike(String value) {
            addCriterion("abbreviation like", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationNotLike(String value) {
            addCriterion("abbreviation not like", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationIn(List<String> values) {
            addCriterion("abbreviation in", values, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationNotIn(List<String> values) {
            addCriterion("abbreviation not in", values, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationBetween(String value1, String value2) {
            addCriterion("abbreviation between", value1, value2, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationNotBetween(String value1, String value2) {
            addCriterion("abbreviation not between", value1, value2, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andContactsIsNull() {
            addCriterion("contacts is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("contacts is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(Integer value) {
            addCriterion("contacts =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(Integer value) {
            addCriterion("contacts <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(Integer value) {
            addCriterion("contacts >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(Integer value) {
            addCriterion("contacts >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(Integer value) {
            addCriterion("contacts <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(Integer value) {
            addCriterion("contacts <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<Integer> values) {
            addCriterion("contacts in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<Integer> values) {
            addCriterion("contacts not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(Integer value1, Integer value2) {
            addCriterion("contacts between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(Integer value1, Integer value2) {
            addCriterion("contacts not between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andHeadIsNull() {
            addCriterion("head is null");
            return (Criteria) this;
        }

        public Criteria andHeadIsNotNull() {
            addCriterion("head is not null");
            return (Criteria) this;
        }

        public Criteria andHeadEqualTo(String value) {
            addCriterion("head =", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotEqualTo(String value) {
            addCriterion("head <>", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadGreaterThan(String value) {
            addCriterion("head >", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadGreaterThanOrEqualTo(String value) {
            addCriterion("head >=", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLessThan(String value) {
            addCriterion("head <", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLessThanOrEqualTo(String value) {
            addCriterion("head <=", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadLike(String value) {
            addCriterion("head like", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotLike(String value) {
            addCriterion("head not like", value, "head");
            return (Criteria) this;
        }

        public Criteria andHeadIn(List<String> values) {
            addCriterion("head in", values, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotIn(List<String> values) {
            addCriterion("head not in", values, "head");
            return (Criteria) this;
        }

        public Criteria andHeadBetween(String value1, String value2) {
            addCriterion("head between", value1, value2, "head");
            return (Criteria) this;
        }

        public Criteria andHeadNotBetween(String value1, String value2) {
            addCriterion("head not between", value1, value2, "head");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("postcode is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("postcode is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("postcode =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("postcode <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("postcode >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postcode >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("postcode <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("postcode <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("postcode like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("postcode not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("postcode in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("postcode not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("postcode between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("postcode not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNull() {
            addCriterion("website is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNotNull() {
            addCriterion("website is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteEqualTo(String value) {
            addCriterion("website =", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotEqualTo(String value) {
            addCriterion("website <>", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThan(String value) {
            addCriterion("website >", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("website >=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThan(String value) {
            addCriterion("website <", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThanOrEqualTo(String value) {
            addCriterion("website <=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLike(String value) {
            addCriterion("website like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotLike(String value) {
            addCriterion("website not like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteIn(List<String> values) {
            addCriterion("website in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotIn(List<String> values) {
            addCriterion("website not in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteBetween(String value1, String value2) {
            addCriterion("website between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotBetween(String value1, String value2) {
            addCriterion("website not between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andScopeBusinessIsNull() {
            addCriterion("scope_business is null");
            return (Criteria) this;
        }

        public Criteria andScopeBusinessIsNotNull() {
            addCriterion("scope_business is not null");
            return (Criteria) this;
        }

        public Criteria andScopeBusinessEqualTo(String value) {
            addCriterion("scope_business =", value, "scopeBusiness");
            return (Criteria) this;
        }

        public Criteria andScopeBusinessNotEqualTo(String value) {
            addCriterion("scope_business <>", value, "scopeBusiness");
            return (Criteria) this;
        }

        public Criteria andScopeBusinessGreaterThan(String value) {
            addCriterion("scope_business >", value, "scopeBusiness");
            return (Criteria) this;
        }

        public Criteria andScopeBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("scope_business >=", value, "scopeBusiness");
            return (Criteria) this;
        }

        public Criteria andScopeBusinessLessThan(String value) {
            addCriterion("scope_business <", value, "scopeBusiness");
            return (Criteria) this;
        }

        public Criteria andScopeBusinessLessThanOrEqualTo(String value) {
            addCriterion("scope_business <=", value, "scopeBusiness");
            return (Criteria) this;
        }

        public Criteria andScopeBusinessLike(String value) {
            addCriterion("scope_business like", value, "scopeBusiness");
            return (Criteria) this;
        }

        public Criteria andScopeBusinessNotLike(String value) {
            addCriterion("scope_business not like", value, "scopeBusiness");
            return (Criteria) this;
        }

        public Criteria andScopeBusinessIn(List<String> values) {
            addCriterion("scope_business in", values, "scopeBusiness");
            return (Criteria) this;
        }

        public Criteria andScopeBusinessNotIn(List<String> values) {
            addCriterion("scope_business not in", values, "scopeBusiness");
            return (Criteria) this;
        }

        public Criteria andScopeBusinessBetween(String value1, String value2) {
            addCriterion("scope_business between", value1, value2, "scopeBusiness");
            return (Criteria) this;
        }

        public Criteria andScopeBusinessNotBetween(String value1, String value2) {
            addCriterion("scope_business not between", value1, value2, "scopeBusiness");
            return (Criteria) this;
        }

        public Criteria andSchpdjrqIsNull() {
            addCriterion("SCHPDJRQ is null");
            return (Criteria) this;
        }

        public Criteria andSchpdjrqIsNotNull() {
            addCriterion("SCHPDJRQ is not null");
            return (Criteria) this;
        }

        public Criteria andSchpdjrqEqualTo(Date value) {
            addCriterion("SCHPDJRQ =", value, "schpdjrq");
            return (Criteria) this;
        }

        public Criteria andSchpdjrqNotEqualTo(Date value) {
            addCriterion("SCHPDJRQ <>", value, "schpdjrq");
            return (Criteria) this;
        }

        public Criteria andSchpdjrqGreaterThan(Date value) {
            addCriterion("SCHPDJRQ >", value, "schpdjrq");
            return (Criteria) this;
        }

        public Criteria andSchpdjrqGreaterThanOrEqualTo(Date value) {
            addCriterion("SCHPDJRQ >=", value, "schpdjrq");
            return (Criteria) this;
        }

        public Criteria andSchpdjrqLessThan(Date value) {
            addCriterion("SCHPDJRQ <", value, "schpdjrq");
            return (Criteria) this;
        }

        public Criteria andSchpdjrqLessThanOrEqualTo(Date value) {
            addCriterion("SCHPDJRQ <=", value, "schpdjrq");
            return (Criteria) this;
        }

        public Criteria andSchpdjrqIn(List<Date> values) {
            addCriterion("SCHPDJRQ in", values, "schpdjrq");
            return (Criteria) this;
        }

        public Criteria andSchpdjrqNotIn(List<Date> values) {
            addCriterion("SCHPDJRQ not in", values, "schpdjrq");
            return (Criteria) this;
        }

        public Criteria andSchpdjrqBetween(Date value1, Date value2) {
            addCriterion("SCHPDJRQ between", value1, value2, "schpdjrq");
            return (Criteria) this;
        }

        public Criteria andSchpdjrqNotBetween(Date value1, Date value2) {
            addCriterion("SCHPDJRQ not between", value1, value2, "schpdjrq");
            return (Criteria) this;
        }

        public Criteria andChangeInformationIsNull() {
            addCriterion("change_information is null");
            return (Criteria) this;
        }

        public Criteria andChangeInformationIsNotNull() {
            addCriterion("change_information is not null");
            return (Criteria) this;
        }

        public Criteria andChangeInformationEqualTo(String value) {
            addCriterion("change_information =", value, "changeInformation");
            return (Criteria) this;
        }

        public Criteria andChangeInformationNotEqualTo(String value) {
            addCriterion("change_information <>", value, "changeInformation");
            return (Criteria) this;
        }

        public Criteria andChangeInformationGreaterThan(String value) {
            addCriterion("change_information >", value, "changeInformation");
            return (Criteria) this;
        }

        public Criteria andChangeInformationGreaterThanOrEqualTo(String value) {
            addCriterion("change_information >=", value, "changeInformation");
            return (Criteria) this;
        }

        public Criteria andChangeInformationLessThan(String value) {
            addCriterion("change_information <", value, "changeInformation");
            return (Criteria) this;
        }

        public Criteria andChangeInformationLessThanOrEqualTo(String value) {
            addCriterion("change_information <=", value, "changeInformation");
            return (Criteria) this;
        }

        public Criteria andChangeInformationLike(String value) {
            addCriterion("change_information like", value, "changeInformation");
            return (Criteria) this;
        }

        public Criteria andChangeInformationNotLike(String value) {
            addCriterion("change_information not like", value, "changeInformation");
            return (Criteria) this;
        }

        public Criteria andChangeInformationIn(List<String> values) {
            addCriterion("change_information in", values, "changeInformation");
            return (Criteria) this;
        }

        public Criteria andChangeInformationNotIn(List<String> values) {
            addCriterion("change_information not in", values, "changeInformation");
            return (Criteria) this;
        }

        public Criteria andChangeInformationBetween(String value1, String value2) {
            addCriterion("change_information between", value1, value2, "changeInformation");
            return (Criteria) this;
        }

        public Criteria andChangeInformationNotBetween(String value1, String value2) {
            addCriterion("change_information not between", value1, value2, "changeInformation");
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

        public Criteria andMemberNumberIsNull() {
            addCriterion("member_number is null");
            return (Criteria) this;
        }

        public Criteria andMemberNumberIsNotNull() {
            addCriterion("member_number is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNumberEqualTo(Integer value) {
            addCriterion("member_number =", value, "memberNumber");
            return (Criteria) this;
        }

        public Criteria andMemberNumberNotEqualTo(Integer value) {
            addCriterion("member_number <>", value, "memberNumber");
            return (Criteria) this;
        }

        public Criteria andMemberNumberGreaterThan(Integer value) {
            addCriterion("member_number >", value, "memberNumber");
            return (Criteria) this;
        }

        public Criteria andMemberNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_number >=", value, "memberNumber");
            return (Criteria) this;
        }

        public Criteria andMemberNumberLessThan(Integer value) {
            addCriterion("member_number <", value, "memberNumber");
            return (Criteria) this;
        }

        public Criteria andMemberNumberLessThanOrEqualTo(Integer value) {
            addCriterion("member_number <=", value, "memberNumber");
            return (Criteria) this;
        }

        public Criteria andMemberNumberIn(List<Integer> values) {
            addCriterion("member_number in", values, "memberNumber");
            return (Criteria) this;
        }

        public Criteria andMemberNumberNotIn(List<Integer> values) {
            addCriterion("member_number not in", values, "memberNumber");
            return (Criteria) this;
        }

        public Criteria andMemberNumberBetween(Integer value1, Integer value2) {
            addCriterion("member_number between", value1, value2, "memberNumber");
            return (Criteria) this;
        }

        public Criteria andMemberNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("member_number not between", value1, value2, "memberNumber");
            return (Criteria) this;
        }

        public Criteria andAssistantNumberIsNull() {
            addCriterion("assistant_number is null");
            return (Criteria) this;
        }

        public Criteria andAssistantNumberIsNotNull() {
            addCriterion("assistant_number is not null");
            return (Criteria) this;
        }

        public Criteria andAssistantNumberEqualTo(Integer value) {
            addCriterion("assistant_number =", value, "assistantNumber");
            return (Criteria) this;
        }

        public Criteria andAssistantNumberNotEqualTo(Integer value) {
            addCriterion("assistant_number <>", value, "assistantNumber");
            return (Criteria) this;
        }

        public Criteria andAssistantNumberGreaterThan(Integer value) {
            addCriterion("assistant_number >", value, "assistantNumber");
            return (Criteria) this;
        }

        public Criteria andAssistantNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("assistant_number >=", value, "assistantNumber");
            return (Criteria) this;
        }

        public Criteria andAssistantNumberLessThan(Integer value) {
            addCriterion("assistant_number <", value, "assistantNumber");
            return (Criteria) this;
        }

        public Criteria andAssistantNumberLessThanOrEqualTo(Integer value) {
            addCriterion("assistant_number <=", value, "assistantNumber");
            return (Criteria) this;
        }

        public Criteria andAssistantNumberIn(List<Integer> values) {
            addCriterion("assistant_number in", values, "assistantNumber");
            return (Criteria) this;
        }

        public Criteria andAssistantNumberNotIn(List<Integer> values) {
            addCriterion("assistant_number not in", values, "assistantNumber");
            return (Criteria) this;
        }

        public Criteria andAssistantNumberBetween(Integer value1, Integer value2) {
            addCriterion("assistant_number between", value1, value2, "assistantNumber");
            return (Criteria) this;
        }

        public Criteria andAssistantNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("assistant_number not between", value1, value2, "assistantNumber");
            return (Criteria) this;
        }

        public Criteria andJudicialNumberIsNull() {
            addCriterion("judicial_number is null");
            return (Criteria) this;
        }

        public Criteria andJudicialNumberIsNotNull() {
            addCriterion("judicial_number is not null");
            return (Criteria) this;
        }

        public Criteria andJudicialNumberEqualTo(Integer value) {
            addCriterion("judicial_number =", value, "judicialNumber");
            return (Criteria) this;
        }

        public Criteria andJudicialNumberNotEqualTo(Integer value) {
            addCriterion("judicial_number <>", value, "judicialNumber");
            return (Criteria) this;
        }

        public Criteria andJudicialNumberGreaterThan(Integer value) {
            addCriterion("judicial_number >", value, "judicialNumber");
            return (Criteria) this;
        }

        public Criteria andJudicialNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("judicial_number >=", value, "judicialNumber");
            return (Criteria) this;
        }

        public Criteria andJudicialNumberLessThan(Integer value) {
            addCriterion("judicial_number <", value, "judicialNumber");
            return (Criteria) this;
        }

        public Criteria andJudicialNumberLessThanOrEqualTo(Integer value) {
            addCriterion("judicial_number <=", value, "judicialNumber");
            return (Criteria) this;
        }

        public Criteria andJudicialNumberIn(List<Integer> values) {
            addCriterion("judicial_number in", values, "judicialNumber");
            return (Criteria) this;
        }

        public Criteria andJudicialNumberNotIn(List<Integer> values) {
            addCriterion("judicial_number not in", values, "judicialNumber");
            return (Criteria) this;
        }

        public Criteria andJudicialNumberBetween(Integer value1, Integer value2) {
            addCriterion("judicial_number between", value1, value2, "judicialNumber");
            return (Criteria) this;
        }

        public Criteria andJudicialNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("judicial_number not between", value1, value2, "judicialNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberIsNull() {
            addCriterion("identify_number is null");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberIsNotNull() {
            addCriterion("identify_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberEqualTo(Integer value) {
            addCriterion("identify_number =", value, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberNotEqualTo(Integer value) {
            addCriterion("identify_number <>", value, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberGreaterThan(Integer value) {
            addCriterion("identify_number >", value, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("identify_number >=", value, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberLessThan(Integer value) {
            addCriterion("identify_number <", value, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberLessThanOrEqualTo(Integer value) {
            addCriterion("identify_number <=", value, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberIn(List<Integer> values) {
            addCriterion("identify_number in", values, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberNotIn(List<Integer> values) {
            addCriterion("identify_number not in", values, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberBetween(Integer value1, Integer value2) {
            addCriterion("identify_number between", value1, value2, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("identify_number not between", value1, value2, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andParttimeAssistantNumberIsNull() {
            addCriterion("parttime_assistant_number is null");
            return (Criteria) this;
        }

        public Criteria andParttimeAssistantNumberIsNotNull() {
            addCriterion("parttime_assistant_number is not null");
            return (Criteria) this;
        }

        public Criteria andParttimeAssistantNumberEqualTo(Integer value) {
            addCriterion("parttime_assistant_number =", value, "parttimeAssistantNumber");
            return (Criteria) this;
        }

        public Criteria andParttimeAssistantNumberNotEqualTo(Integer value) {
            addCriterion("parttime_assistant_number <>", value, "parttimeAssistantNumber");
            return (Criteria) this;
        }

        public Criteria andParttimeAssistantNumberGreaterThan(Integer value) {
            addCriterion("parttime_assistant_number >", value, "parttimeAssistantNumber");
            return (Criteria) this;
        }

        public Criteria andParttimeAssistantNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("parttime_assistant_number >=", value, "parttimeAssistantNumber");
            return (Criteria) this;
        }

        public Criteria andParttimeAssistantNumberLessThan(Integer value) {
            addCriterion("parttime_assistant_number <", value, "parttimeAssistantNumber");
            return (Criteria) this;
        }

        public Criteria andParttimeAssistantNumberLessThanOrEqualTo(Integer value) {
            addCriterion("parttime_assistant_number <=", value, "parttimeAssistantNumber");
            return (Criteria) this;
        }

        public Criteria andParttimeAssistantNumberIn(List<Integer> values) {
            addCriterion("parttime_assistant_number in", values, "parttimeAssistantNumber");
            return (Criteria) this;
        }

        public Criteria andParttimeAssistantNumberNotIn(List<Integer> values) {
            addCriterion("parttime_assistant_number not in", values, "parttimeAssistantNumber");
            return (Criteria) this;
        }

        public Criteria andParttimeAssistantNumberBetween(Integer value1, Integer value2) {
            addCriterion("parttime_assistant_number between", value1, value2, "parttimeAssistantNumber");
            return (Criteria) this;
        }

        public Criteria andParttimeAssistantNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("parttime_assistant_number not between", value1, value2, "parttimeAssistantNumber");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber1IsNull() {
            addCriterion("parttime_number1 is null");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber1IsNotNull() {
            addCriterion("parttime_number1 is not null");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber1EqualTo(Integer value) {
            addCriterion("parttime_number1 =", value, "parttimeNumber1");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber1NotEqualTo(Integer value) {
            addCriterion("parttime_number1 <>", value, "parttimeNumber1");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber1GreaterThan(Integer value) {
            addCriterion("parttime_number1 >", value, "parttimeNumber1");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber1GreaterThanOrEqualTo(Integer value) {
            addCriterion("parttime_number1 >=", value, "parttimeNumber1");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber1LessThan(Integer value) {
            addCriterion("parttime_number1 <", value, "parttimeNumber1");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber1LessThanOrEqualTo(Integer value) {
            addCriterion("parttime_number1 <=", value, "parttimeNumber1");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber1In(List<Integer> values) {
            addCriterion("parttime_number1 in", values, "parttimeNumber1");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber1NotIn(List<Integer> values) {
            addCriterion("parttime_number1 not in", values, "parttimeNumber1");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber1Between(Integer value1, Integer value2) {
            addCriterion("parttime_number1 between", value1, value2, "parttimeNumber1");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber1NotBetween(Integer value1, Integer value2) {
            addCriterion("parttime_number1 not between", value1, value2, "parttimeNumber1");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber2IsNull() {
            addCriterion("parttime_number2 is null");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber2IsNotNull() {
            addCriterion("parttime_number2 is not null");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber2EqualTo(Integer value) {
            addCriterion("parttime_number2 =", value, "parttimeNumber2");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber2NotEqualTo(Integer value) {
            addCriterion("parttime_number2 <>", value, "parttimeNumber2");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber2GreaterThan(Integer value) {
            addCriterion("parttime_number2 >", value, "parttimeNumber2");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber2GreaterThanOrEqualTo(Integer value) {
            addCriterion("parttime_number2 >=", value, "parttimeNumber2");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber2LessThan(Integer value) {
            addCriterion("parttime_number2 <", value, "parttimeNumber2");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber2LessThanOrEqualTo(Integer value) {
            addCriterion("parttime_number2 <=", value, "parttimeNumber2");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber2In(List<Integer> values) {
            addCriterion("parttime_number2 in", values, "parttimeNumber2");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber2NotIn(List<Integer> values) {
            addCriterion("parttime_number2 not in", values, "parttimeNumber2");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber2Between(Integer value1, Integer value2) {
            addCriterion("parttime_number2 between", value1, value2, "parttimeNumber2");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber2NotBetween(Integer value1, Integer value2) {
            addCriterion("parttime_number2 not between", value1, value2, "parttimeNumber2");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber3IsNull() {
            addCriterion("parttime_number3 is null");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber3IsNotNull() {
            addCriterion("parttime_number3 is not null");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber3EqualTo(Integer value) {
            addCriterion("parttime_number3 =", value, "parttimeNumber3");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber3NotEqualTo(Integer value) {
            addCriterion("parttime_number3 <>", value, "parttimeNumber3");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber3GreaterThan(Integer value) {
            addCriterion("parttime_number3 >", value, "parttimeNumber3");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber3GreaterThanOrEqualTo(Integer value) {
            addCriterion("parttime_number3 >=", value, "parttimeNumber3");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber3LessThan(Integer value) {
            addCriterion("parttime_number3 <", value, "parttimeNumber3");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber3LessThanOrEqualTo(Integer value) {
            addCriterion("parttime_number3 <=", value, "parttimeNumber3");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber3In(List<Integer> values) {
            addCriterion("parttime_number3 in", values, "parttimeNumber3");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber3NotIn(List<Integer> values) {
            addCriterion("parttime_number3 not in", values, "parttimeNumber3");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber3Between(Integer value1, Integer value2) {
            addCriterion("parttime_number3 between", value1, value2, "parttimeNumber3");
            return (Criteria) this;
        }

        public Criteria andParttimeNumber3NotBetween(Integer value1, Integer value2) {
            addCriterion("parttime_number3 not between", value1, value2, "parttimeNumber3");
            return (Criteria) this;
        }

        public Criteria andContinuityIsNull() {
            addCriterion("continuity is null");
            return (Criteria) this;
        }

        public Criteria andContinuityIsNotNull() {
            addCriterion("continuity is not null");
            return (Criteria) this;
        }

        public Criteria andContinuityEqualTo(String value) {
            addCriterion("continuity =", value, "continuity");
            return (Criteria) this;
        }

        public Criteria andContinuityNotEqualTo(String value) {
            addCriterion("continuity <>", value, "continuity");
            return (Criteria) this;
        }

        public Criteria andContinuityGreaterThan(String value) {
            addCriterion("continuity >", value, "continuity");
            return (Criteria) this;
        }

        public Criteria andContinuityGreaterThanOrEqualTo(String value) {
            addCriterion("continuity >=", value, "continuity");
            return (Criteria) this;
        }

        public Criteria andContinuityLessThan(String value) {
            addCriterion("continuity <", value, "continuity");
            return (Criteria) this;
        }

        public Criteria andContinuityLessThanOrEqualTo(String value) {
            addCriterion("continuity <=", value, "continuity");
            return (Criteria) this;
        }

        public Criteria andContinuityLike(String value) {
            addCriterion("continuity like", value, "continuity");
            return (Criteria) this;
        }

        public Criteria andContinuityNotLike(String value) {
            addCriterion("continuity not like", value, "continuity");
            return (Criteria) this;
        }

        public Criteria andContinuityIn(List<String> values) {
            addCriterion("continuity in", values, "continuity");
            return (Criteria) this;
        }

        public Criteria andContinuityNotIn(List<String> values) {
            addCriterion("continuity not in", values, "continuity");
            return (Criteria) this;
        }

        public Criteria andContinuityBetween(String value1, String value2) {
            addCriterion("continuity between", value1, value2, "continuity");
            return (Criteria) this;
        }

        public Criteria andContinuityNotBetween(String value1, String value2) {
            addCriterion("continuity not between", value1, value2, "continuity");
            return (Criteria) this;
        }

        public Criteria andLegalManNameIsNull() {
            addCriterion("legal_man_name is null");
            return (Criteria) this;
        }

        public Criteria andLegalManNameIsNotNull() {
            addCriterion("legal_man_name is not null");
            return (Criteria) this;
        }

        public Criteria andLegalManNameEqualTo(String value) {
            addCriterion("legal_man_name =", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameNotEqualTo(String value) {
            addCriterion("legal_man_name <>", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameGreaterThan(String value) {
            addCriterion("legal_man_name >", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameGreaterThanOrEqualTo(String value) {
            addCriterion("legal_man_name >=", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameLessThan(String value) {
            addCriterion("legal_man_name <", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameLessThanOrEqualTo(String value) {
            addCriterion("legal_man_name <=", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameLike(String value) {
            addCriterion("legal_man_name like", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameNotLike(String value) {
            addCriterion("legal_man_name not like", value, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameIn(List<String> values) {
            addCriterion("legal_man_name in", values, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameNotIn(List<String> values) {
            addCriterion("legal_man_name not in", values, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameBetween(String value1, String value2) {
            addCriterion("legal_man_name between", value1, value2, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManNameNotBetween(String value1, String value2) {
            addCriterion("legal_man_name not between", value1, value2, "legalManName");
            return (Criteria) this;
        }

        public Criteria andLegalManPostIsNull() {
            addCriterion("legal_man_post is null");
            return (Criteria) this;
        }

        public Criteria andLegalManPostIsNotNull() {
            addCriterion("legal_man_post is not null");
            return (Criteria) this;
        }

        public Criteria andLegalManPostEqualTo(String value) {
            addCriterion("legal_man_post =", value, "legalManPost");
            return (Criteria) this;
        }

        public Criteria andLegalManPostNotEqualTo(String value) {
            addCriterion("legal_man_post <>", value, "legalManPost");
            return (Criteria) this;
        }

        public Criteria andLegalManPostGreaterThan(String value) {
            addCriterion("legal_man_post >", value, "legalManPost");
            return (Criteria) this;
        }

        public Criteria andLegalManPostGreaterThanOrEqualTo(String value) {
            addCriterion("legal_man_post >=", value, "legalManPost");
            return (Criteria) this;
        }

        public Criteria andLegalManPostLessThan(String value) {
            addCriterion("legal_man_post <", value, "legalManPost");
            return (Criteria) this;
        }

        public Criteria andLegalManPostLessThanOrEqualTo(String value) {
            addCriterion("legal_man_post <=", value, "legalManPost");
            return (Criteria) this;
        }

        public Criteria andLegalManPostLike(String value) {
            addCriterion("legal_man_post like", value, "legalManPost");
            return (Criteria) this;
        }

        public Criteria andLegalManPostNotLike(String value) {
            addCriterion("legal_man_post not like", value, "legalManPost");
            return (Criteria) this;
        }

        public Criteria andLegalManPostIn(List<String> values) {
            addCriterion("legal_man_post in", values, "legalManPost");
            return (Criteria) this;
        }

        public Criteria andLegalManPostNotIn(List<String> values) {
            addCriterion("legal_man_post not in", values, "legalManPost");
            return (Criteria) this;
        }

        public Criteria andLegalManPostBetween(String value1, String value2) {
            addCriterion("legal_man_post between", value1, value2, "legalManPost");
            return (Criteria) this;
        }

        public Criteria andLegalManPostNotBetween(String value1, String value2) {
            addCriterion("legal_man_post not between", value1, value2, "legalManPost");
            return (Criteria) this;
        }

        public Criteria andLegalManSexIsNull() {
            addCriterion("legal_man_sex is null");
            return (Criteria) this;
        }

        public Criteria andLegalManSexIsNotNull() {
            addCriterion("legal_man_sex is not null");
            return (Criteria) this;
        }

        public Criteria andLegalManSexEqualTo(String value) {
            addCriterion("legal_man_sex =", value, "legalManSex");
            return (Criteria) this;
        }

        public Criteria andLegalManSexNotEqualTo(String value) {
            addCriterion("legal_man_sex <>", value, "legalManSex");
            return (Criteria) this;
        }

        public Criteria andLegalManSexGreaterThan(String value) {
            addCriterion("legal_man_sex >", value, "legalManSex");
            return (Criteria) this;
        }

        public Criteria andLegalManSexGreaterThanOrEqualTo(String value) {
            addCriterion("legal_man_sex >=", value, "legalManSex");
            return (Criteria) this;
        }

        public Criteria andLegalManSexLessThan(String value) {
            addCriterion("legal_man_sex <", value, "legalManSex");
            return (Criteria) this;
        }

        public Criteria andLegalManSexLessThanOrEqualTo(String value) {
            addCriterion("legal_man_sex <=", value, "legalManSex");
            return (Criteria) this;
        }

        public Criteria andLegalManSexLike(String value) {
            addCriterion("legal_man_sex like", value, "legalManSex");
            return (Criteria) this;
        }

        public Criteria andLegalManSexNotLike(String value) {
            addCriterion("legal_man_sex not like", value, "legalManSex");
            return (Criteria) this;
        }

        public Criteria andLegalManSexIn(List<String> values) {
            addCriterion("legal_man_sex in", values, "legalManSex");
            return (Criteria) this;
        }

        public Criteria andLegalManSexNotIn(List<String> values) {
            addCriterion("legal_man_sex not in", values, "legalManSex");
            return (Criteria) this;
        }

        public Criteria andLegalManSexBetween(String value1, String value2) {
            addCriterion("legal_man_sex between", value1, value2, "legalManSex");
            return (Criteria) this;
        }

        public Criteria andLegalManSexNotBetween(String value1, String value2) {
            addCriterion("legal_man_sex not between", value1, value2, "legalManSex");
            return (Criteria) this;
        }

        public Criteria andLegalManPhoneIsNull() {
            addCriterion("legal_man_phone is null");
            return (Criteria) this;
        }

        public Criteria andLegalManPhoneIsNotNull() {
            addCriterion("legal_man_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLegalManPhoneEqualTo(String value) {
            addCriterion("legal_man_phone =", value, "legalManPhone");
            return (Criteria) this;
        }

        public Criteria andLegalManPhoneNotEqualTo(String value) {
            addCriterion("legal_man_phone <>", value, "legalManPhone");
            return (Criteria) this;
        }

        public Criteria andLegalManPhoneGreaterThan(String value) {
            addCriterion("legal_man_phone >", value, "legalManPhone");
            return (Criteria) this;
        }

        public Criteria andLegalManPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("legal_man_phone >=", value, "legalManPhone");
            return (Criteria) this;
        }

        public Criteria andLegalManPhoneLessThan(String value) {
            addCriterion("legal_man_phone <", value, "legalManPhone");
            return (Criteria) this;
        }

        public Criteria andLegalManPhoneLessThanOrEqualTo(String value) {
            addCriterion("legal_man_phone <=", value, "legalManPhone");
            return (Criteria) this;
        }

        public Criteria andLegalManPhoneLike(String value) {
            addCriterion("legal_man_phone like", value, "legalManPhone");
            return (Criteria) this;
        }

        public Criteria andLegalManPhoneNotLike(String value) {
            addCriterion("legal_man_phone not like", value, "legalManPhone");
            return (Criteria) this;
        }

        public Criteria andLegalManPhoneIn(List<String> values) {
            addCriterion("legal_man_phone in", values, "legalManPhone");
            return (Criteria) this;
        }

        public Criteria andLegalManPhoneNotIn(List<String> values) {
            addCriterion("legal_man_phone not in", values, "legalManPhone");
            return (Criteria) this;
        }

        public Criteria andLegalManPhoneBetween(String value1, String value2) {
            addCriterion("legal_man_phone between", value1, value2, "legalManPhone");
            return (Criteria) this;
        }

        public Criteria andLegalManPhoneNotBetween(String value1, String value2) {
            addCriterion("legal_man_phone not between", value1, value2, "legalManPhone");
            return (Criteria) this;
        }

        public Criteria andChargeNameIsNull() {
            addCriterion("charge_name is null");
            return (Criteria) this;
        }

        public Criteria andChargeNameIsNotNull() {
            addCriterion("charge_name is not null");
            return (Criteria) this;
        }

        public Criteria andChargeNameEqualTo(String value) {
            addCriterion("charge_name =", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameNotEqualTo(String value) {
            addCriterion("charge_name <>", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameGreaterThan(String value) {
            addCriterion("charge_name >", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameGreaterThanOrEqualTo(String value) {
            addCriterion("charge_name >=", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameLessThan(String value) {
            addCriterion("charge_name <", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameLessThanOrEqualTo(String value) {
            addCriterion("charge_name <=", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameLike(String value) {
            addCriterion("charge_name like", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameNotLike(String value) {
            addCriterion("charge_name not like", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameIn(List<String> values) {
            addCriterion("charge_name in", values, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameNotIn(List<String> values) {
            addCriterion("charge_name not in", values, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameBetween(String value1, String value2) {
            addCriterion("charge_name between", value1, value2, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameNotBetween(String value1, String value2) {
            addCriterion("charge_name not between", value1, value2, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargePostIsNull() {
            addCriterion("charge_post is null");
            return (Criteria) this;
        }

        public Criteria andChargePostIsNotNull() {
            addCriterion("charge_post is not null");
            return (Criteria) this;
        }

        public Criteria andChargePostEqualTo(String value) {
            addCriterion("charge_post =", value, "chargePost");
            return (Criteria) this;
        }

        public Criteria andChargePostNotEqualTo(String value) {
            addCriterion("charge_post <>", value, "chargePost");
            return (Criteria) this;
        }

        public Criteria andChargePostGreaterThan(String value) {
            addCriterion("charge_post >", value, "chargePost");
            return (Criteria) this;
        }

        public Criteria andChargePostGreaterThanOrEqualTo(String value) {
            addCriterion("charge_post >=", value, "chargePost");
            return (Criteria) this;
        }

        public Criteria andChargePostLessThan(String value) {
            addCriterion("charge_post <", value, "chargePost");
            return (Criteria) this;
        }

        public Criteria andChargePostLessThanOrEqualTo(String value) {
            addCriterion("charge_post <=", value, "chargePost");
            return (Criteria) this;
        }

        public Criteria andChargePostLike(String value) {
            addCriterion("charge_post like", value, "chargePost");
            return (Criteria) this;
        }

        public Criteria andChargePostNotLike(String value) {
            addCriterion("charge_post not like", value, "chargePost");
            return (Criteria) this;
        }

        public Criteria andChargePostIn(List<String> values) {
            addCriterion("charge_post in", values, "chargePost");
            return (Criteria) this;
        }

        public Criteria andChargePostNotIn(List<String> values) {
            addCriterion("charge_post not in", values, "chargePost");
            return (Criteria) this;
        }

        public Criteria andChargePostBetween(String value1, String value2) {
            addCriterion("charge_post between", value1, value2, "chargePost");
            return (Criteria) this;
        }

        public Criteria andChargePostNotBetween(String value1, String value2) {
            addCriterion("charge_post not between", value1, value2, "chargePost");
            return (Criteria) this;
        }

        public Criteria andChargeSexIsNull() {
            addCriterion("charge_sex is null");
            return (Criteria) this;
        }

        public Criteria andChargeSexIsNotNull() {
            addCriterion("charge_sex is not null");
            return (Criteria) this;
        }

        public Criteria andChargeSexEqualTo(String value) {
            addCriterion("charge_sex =", value, "chargeSex");
            return (Criteria) this;
        }

        public Criteria andChargeSexNotEqualTo(String value) {
            addCriterion("charge_sex <>", value, "chargeSex");
            return (Criteria) this;
        }

        public Criteria andChargeSexGreaterThan(String value) {
            addCriterion("charge_sex >", value, "chargeSex");
            return (Criteria) this;
        }

        public Criteria andChargeSexGreaterThanOrEqualTo(String value) {
            addCriterion("charge_sex >=", value, "chargeSex");
            return (Criteria) this;
        }

        public Criteria andChargeSexLessThan(String value) {
            addCriterion("charge_sex <", value, "chargeSex");
            return (Criteria) this;
        }

        public Criteria andChargeSexLessThanOrEqualTo(String value) {
            addCriterion("charge_sex <=", value, "chargeSex");
            return (Criteria) this;
        }

        public Criteria andChargeSexLike(String value) {
            addCriterion("charge_sex like", value, "chargeSex");
            return (Criteria) this;
        }

        public Criteria andChargeSexNotLike(String value) {
            addCriterion("charge_sex not like", value, "chargeSex");
            return (Criteria) this;
        }

        public Criteria andChargeSexIn(List<String> values) {
            addCriterion("charge_sex in", values, "chargeSex");
            return (Criteria) this;
        }

        public Criteria andChargeSexNotIn(List<String> values) {
            addCriterion("charge_sex not in", values, "chargeSex");
            return (Criteria) this;
        }

        public Criteria andChargeSexBetween(String value1, String value2) {
            addCriterion("charge_sex between", value1, value2, "chargeSex");
            return (Criteria) this;
        }

        public Criteria andChargeSexNotBetween(String value1, String value2) {
            addCriterion("charge_sex not between", value1, value2, "chargeSex");
            return (Criteria) this;
        }

        public Criteria andChargePhoneIsNull() {
            addCriterion("charge_phone is null");
            return (Criteria) this;
        }

        public Criteria andChargePhoneIsNotNull() {
            addCriterion("charge_phone is not null");
            return (Criteria) this;
        }

        public Criteria andChargePhoneEqualTo(String value) {
            addCriterion("charge_phone =", value, "chargePhone");
            return (Criteria) this;
        }

        public Criteria andChargePhoneNotEqualTo(String value) {
            addCriterion("charge_phone <>", value, "chargePhone");
            return (Criteria) this;
        }

        public Criteria andChargePhoneGreaterThan(String value) {
            addCriterion("charge_phone >", value, "chargePhone");
            return (Criteria) this;
        }

        public Criteria andChargePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("charge_phone >=", value, "chargePhone");
            return (Criteria) this;
        }

        public Criteria andChargePhoneLessThan(String value) {
            addCriterion("charge_phone <", value, "chargePhone");
            return (Criteria) this;
        }

        public Criteria andChargePhoneLessThanOrEqualTo(String value) {
            addCriterion("charge_phone <=", value, "chargePhone");
            return (Criteria) this;
        }

        public Criteria andChargePhoneLike(String value) {
            addCriterion("charge_phone like", value, "chargePhone");
            return (Criteria) this;
        }

        public Criteria andChargePhoneNotLike(String value) {
            addCriterion("charge_phone not like", value, "chargePhone");
            return (Criteria) this;
        }

        public Criteria andChargePhoneIn(List<String> values) {
            addCriterion("charge_phone in", values, "chargePhone");
            return (Criteria) this;
        }

        public Criteria andChargePhoneNotIn(List<String> values) {
            addCriterion("charge_phone not in", values, "chargePhone");
            return (Criteria) this;
        }

        public Criteria andChargePhoneBetween(String value1, String value2) {
            addCriterion("charge_phone between", value1, value2, "chargePhone");
            return (Criteria) this;
        }

        public Criteria andChargePhoneNotBetween(String value1, String value2) {
            addCriterion("charge_phone not between", value1, value2, "chargePhone");
            return (Criteria) this;
        }

        public Criteria andBranchNameIsNull() {
            addCriterion("branch_name is null");
            return (Criteria) this;
        }

        public Criteria andBranchNameIsNotNull() {
            addCriterion("branch_name is not null");
            return (Criteria) this;
        }

        public Criteria andBranchNameEqualTo(String value) {
            addCriterion("branch_name =", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotEqualTo(String value) {
            addCriterion("branch_name <>", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameGreaterThan(String value) {
            addCriterion("branch_name >", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameGreaterThanOrEqualTo(String value) {
            addCriterion("branch_name >=", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameLessThan(String value) {
            addCriterion("branch_name <", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameLessThanOrEqualTo(String value) {
            addCriterion("branch_name <=", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameLike(String value) {
            addCriterion("branch_name like", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotLike(String value) {
            addCriterion("branch_name not like", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameIn(List<String> values) {
            addCriterion("branch_name in", values, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotIn(List<String> values) {
            addCriterion("branch_name not in", values, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameBetween(String value1, String value2) {
            addCriterion("branch_name between", value1, value2, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotBetween(String value1, String value2) {
            addCriterion("branch_name not between", value1, value2, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchChargeIsNull() {
            addCriterion("branch_charge is null");
            return (Criteria) this;
        }

        public Criteria andBranchChargeIsNotNull() {
            addCriterion("branch_charge is not null");
            return (Criteria) this;
        }

        public Criteria andBranchChargeEqualTo(String value) {
            addCriterion("branch_charge =", value, "branchCharge");
            return (Criteria) this;
        }

        public Criteria andBranchChargeNotEqualTo(String value) {
            addCriterion("branch_charge <>", value, "branchCharge");
            return (Criteria) this;
        }

        public Criteria andBranchChargeGreaterThan(String value) {
            addCriterion("branch_charge >", value, "branchCharge");
            return (Criteria) this;
        }

        public Criteria andBranchChargeGreaterThanOrEqualTo(String value) {
            addCriterion("branch_charge >=", value, "branchCharge");
            return (Criteria) this;
        }

        public Criteria andBranchChargeLessThan(String value) {
            addCriterion("branch_charge <", value, "branchCharge");
            return (Criteria) this;
        }

        public Criteria andBranchChargeLessThanOrEqualTo(String value) {
            addCriterion("branch_charge <=", value, "branchCharge");
            return (Criteria) this;
        }

        public Criteria andBranchChargeLike(String value) {
            addCriterion("branch_charge like", value, "branchCharge");
            return (Criteria) this;
        }

        public Criteria andBranchChargeNotLike(String value) {
            addCriterion("branch_charge not like", value, "branchCharge");
            return (Criteria) this;
        }

        public Criteria andBranchChargeIn(List<String> values) {
            addCriterion("branch_charge in", values, "branchCharge");
            return (Criteria) this;
        }

        public Criteria andBranchChargeNotIn(List<String> values) {
            addCriterion("branch_charge not in", values, "branchCharge");
            return (Criteria) this;
        }

        public Criteria andBranchChargeBetween(String value1, String value2) {
            addCriterion("branch_charge between", value1, value2, "branchCharge");
            return (Criteria) this;
        }

        public Criteria andBranchChargeNotBetween(String value1, String value2) {
            addCriterion("branch_charge not between", value1, value2, "branchCharge");
            return (Criteria) this;
        }

        public Criteria andBranchLicenseKeyIsNull() {
            addCriterion("branch_license_key is null");
            return (Criteria) this;
        }

        public Criteria andBranchLicenseKeyIsNotNull() {
            addCriterion("branch_license_key is not null");
            return (Criteria) this;
        }

        public Criteria andBranchLicenseKeyEqualTo(String value) {
            addCriterion("branch_license_key =", value, "branchLicenseKey");
            return (Criteria) this;
        }

        public Criteria andBranchLicenseKeyNotEqualTo(String value) {
            addCriterion("branch_license_key <>", value, "branchLicenseKey");
            return (Criteria) this;
        }

        public Criteria andBranchLicenseKeyGreaterThan(String value) {
            addCriterion("branch_license_key >", value, "branchLicenseKey");
            return (Criteria) this;
        }

        public Criteria andBranchLicenseKeyGreaterThanOrEqualTo(String value) {
            addCriterion("branch_license_key >=", value, "branchLicenseKey");
            return (Criteria) this;
        }

        public Criteria andBranchLicenseKeyLessThan(String value) {
            addCriterion("branch_license_key <", value, "branchLicenseKey");
            return (Criteria) this;
        }

        public Criteria andBranchLicenseKeyLessThanOrEqualTo(String value) {
            addCriterion("branch_license_key <=", value, "branchLicenseKey");
            return (Criteria) this;
        }

        public Criteria andBranchLicenseKeyLike(String value) {
            addCriterion("branch_license_key like", value, "branchLicenseKey");
            return (Criteria) this;
        }

        public Criteria andBranchLicenseKeyNotLike(String value) {
            addCriterion("branch_license_key not like", value, "branchLicenseKey");
            return (Criteria) this;
        }

        public Criteria andBranchLicenseKeyIn(List<String> values) {
            addCriterion("branch_license_key in", values, "branchLicenseKey");
            return (Criteria) this;
        }

        public Criteria andBranchLicenseKeyNotIn(List<String> values) {
            addCriterion("branch_license_key not in", values, "branchLicenseKey");
            return (Criteria) this;
        }

        public Criteria andBranchLicenseKeyBetween(String value1, String value2) {
            addCriterion("branch_license_key between", value1, value2, "branchLicenseKey");
            return (Criteria) this;
        }

        public Criteria andBranchLicenseKeyNotBetween(String value1, String value2) {
            addCriterion("branch_license_key not between", value1, value2, "branchLicenseKey");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityBeginIsNull() {
            addCriterion("branch_period_validity_begin is null");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityBeginIsNotNull() {
            addCriterion("branch_period_validity_begin is not null");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityBeginEqualTo(Date value) {
            addCriterion("branch_period_validity_begin =", value, "branchPeriodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityBeginNotEqualTo(Date value) {
            addCriterion("branch_period_validity_begin <>", value, "branchPeriodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityBeginGreaterThan(Date value) {
            addCriterion("branch_period_validity_begin >", value, "branchPeriodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityBeginGreaterThanOrEqualTo(Date value) {
            addCriterion("branch_period_validity_begin >=", value, "branchPeriodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityBeginLessThan(Date value) {
            addCriterion("branch_period_validity_begin <", value, "branchPeriodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityBeginLessThanOrEqualTo(Date value) {
            addCriterion("branch_period_validity_begin <=", value, "branchPeriodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityBeginIn(List<Date> values) {
            addCriterion("branch_period_validity_begin in", values, "branchPeriodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityBeginNotIn(List<Date> values) {
            addCriterion("branch_period_validity_begin not in", values, "branchPeriodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityBeginBetween(Date value1, Date value2) {
            addCriterion("branch_period_validity_begin between", value1, value2, "branchPeriodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityBeginNotBetween(Date value1, Date value2) {
            addCriterion("branch_period_validity_begin not between", value1, value2, "branchPeriodValidityBegin");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityEndIsNull() {
            addCriterion("branch_period_validity_end is null");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityEndIsNotNull() {
            addCriterion("branch_period_validity_end is not null");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityEndEqualTo(Date value) {
            addCriterion("branch_period_validity_end =", value, "branchPeriodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityEndNotEqualTo(Date value) {
            addCriterion("branch_period_validity_end <>", value, "branchPeriodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityEndGreaterThan(Date value) {
            addCriterion("branch_period_validity_end >", value, "branchPeriodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityEndGreaterThanOrEqualTo(Date value) {
            addCriterion("branch_period_validity_end >=", value, "branchPeriodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityEndLessThan(Date value) {
            addCriterion("branch_period_validity_end <", value, "branchPeriodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityEndLessThanOrEqualTo(Date value) {
            addCriterion("branch_period_validity_end <=", value, "branchPeriodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityEndIn(List<Date> values) {
            addCriterion("branch_period_validity_end in", values, "branchPeriodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityEndNotIn(List<Date> values) {
            addCriterion("branch_period_validity_end not in", values, "branchPeriodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityEndBetween(Date value1, Date value2) {
            addCriterion("branch_period_validity_end between", value1, value2, "branchPeriodValidityEnd");
            return (Criteria) this;
        }

        public Criteria andBranchPeriodValidityEndNotBetween(Date value1, Date value2) {
            addCriterion("branch_period_validity_end not between", value1, value2, "branchPeriodValidityEnd");
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