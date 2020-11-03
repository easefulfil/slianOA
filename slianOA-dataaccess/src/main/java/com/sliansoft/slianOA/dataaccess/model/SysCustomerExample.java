package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysCustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public SysCustomerExample() {
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

    public SysCustomerExample(int pageSize, int pageIndex) {
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

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeIsNull() {
            addCriterion("customer_type is null");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeIsNotNull() {
            addCriterion("customer_type is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeEqualTo(Integer value) {
            addCriterion("customer_type =", value, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNotEqualTo(Integer value) {
            addCriterion("customer_type <>", value, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeGreaterThan(Integer value) {
            addCriterion("customer_type >", value, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_type >=", value, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeLessThan(Integer value) {
            addCriterion("customer_type <", value, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("customer_type <=", value, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeIn(List<Integer> values) {
            addCriterion("customer_type in", values, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNotIn(List<Integer> values) {
            addCriterion("customer_type not in", values, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeBetween(Integer value1, Integer value2) {
            addCriterion("customer_type between", value1, value2, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_type not between", value1, value2, "customerType");
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

        public Criteria andCompanyCodeIsNull() {
            addCriterion("company_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNotNull() {
            addCriterion("company_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeEqualTo(String value) {
            addCriterion("company_code =", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotEqualTo(String value) {
            addCriterion("company_code <>", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThan(String value) {
            addCriterion("company_code >", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("company_code >=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThan(String value) {
            addCriterion("company_code <", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("company_code <=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLike(String value) {
            addCriterion("company_code like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotLike(String value) {
            addCriterion("company_code not like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIn(List<String> values) {
            addCriterion("company_code in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotIn(List<String> values) {
            addCriterion("company_code not in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeBetween(String value1, String value2) {
            addCriterion("company_code between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("company_code not between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andOfficeAddrIsNull() {
            addCriterion("office_addr is null");
            return (Criteria) this;
        }

        public Criteria andOfficeAddrIsNotNull() {
            addCriterion("office_addr is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeAddrEqualTo(String value) {
            addCriterion("office_addr =", value, "officeAddr");
            return (Criteria) this;
        }

        public Criteria andOfficeAddrNotEqualTo(String value) {
            addCriterion("office_addr <>", value, "officeAddr");
            return (Criteria) this;
        }

        public Criteria andOfficeAddrGreaterThan(String value) {
            addCriterion("office_addr >", value, "officeAddr");
            return (Criteria) this;
        }

        public Criteria andOfficeAddrGreaterThanOrEqualTo(String value) {
            addCriterion("office_addr >=", value, "officeAddr");
            return (Criteria) this;
        }

        public Criteria andOfficeAddrLessThan(String value) {
            addCriterion("office_addr <", value, "officeAddr");
            return (Criteria) this;
        }

        public Criteria andOfficeAddrLessThanOrEqualTo(String value) {
            addCriterion("office_addr <=", value, "officeAddr");
            return (Criteria) this;
        }

        public Criteria andOfficeAddrLike(String value) {
            addCriterion("office_addr like", value, "officeAddr");
            return (Criteria) this;
        }

        public Criteria andOfficeAddrNotLike(String value) {
            addCriterion("office_addr not like", value, "officeAddr");
            return (Criteria) this;
        }

        public Criteria andOfficeAddrIn(List<String> values) {
            addCriterion("office_addr in", values, "officeAddr");
            return (Criteria) this;
        }

        public Criteria andOfficeAddrNotIn(List<String> values) {
            addCriterion("office_addr not in", values, "officeAddr");
            return (Criteria) this;
        }

        public Criteria andOfficeAddrBetween(String value1, String value2) {
            addCriterion("office_addr between", value1, value2, "officeAddr");
            return (Criteria) this;
        }

        public Criteria andOfficeAddrNotBetween(String value1, String value2) {
            addCriterion("office_addr not between", value1, value2, "officeAddr");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("CID is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("CID is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(String value) {
            addCriterion("CID =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(String value) {
            addCriterion("CID <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(String value) {
            addCriterion("CID >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(String value) {
            addCriterion("CID >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(String value) {
            addCriterion("CID <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(String value) {
            addCriterion("CID <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLike(String value) {
            addCriterion("CID like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotLike(String value) {
            addCriterion("CID not like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<String> values) {
            addCriterion("CID in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<String> values) {
            addCriterion("CID not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(String value1, String value2) {
            addCriterion("CID between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(String value1, String value2) {
            addCriterion("CID not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andTypeDescIsNull() {
            addCriterion("type_desc is null");
            return (Criteria) this;
        }

        public Criteria andTypeDescIsNotNull() {
            addCriterion("type_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTypeDescEqualTo(String value) {
            addCriterion("type_desc =", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotEqualTo(String value) {
            addCriterion("type_desc <>", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescGreaterThan(String value) {
            addCriterion("type_desc >", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescGreaterThanOrEqualTo(String value) {
            addCriterion("type_desc >=", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescLessThan(String value) {
            addCriterion("type_desc <", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescLessThanOrEqualTo(String value) {
            addCriterion("type_desc <=", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescLike(String value) {
            addCriterion("type_desc like", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotLike(String value) {
            addCriterion("type_desc not like", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescIn(List<String> values) {
            addCriterion("type_desc in", values, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotIn(List<String> values) {
            addCriterion("type_desc not in", values, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescBetween(String value1, String value2) {
            addCriterion("type_desc between", value1, value2, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotBetween(String value1, String value2) {
            addCriterion("type_desc not between", value1, value2, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andObjectIsNull() {
            addCriterion("object is null");
            return (Criteria) this;
        }

        public Criteria andObjectIsNotNull() {
            addCriterion("object is not null");
            return (Criteria) this;
        }

        public Criteria andObjectEqualTo(String value) {
            addCriterion("object =", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectNotEqualTo(String value) {
            addCriterion("object <>", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectGreaterThan(String value) {
            addCriterion("object >", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectGreaterThanOrEqualTo(String value) {
            addCriterion("object >=", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectLessThan(String value) {
            addCriterion("object <", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectLessThanOrEqualTo(String value) {
            addCriterion("object <=", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectLike(String value) {
            addCriterion("object like", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectNotLike(String value) {
            addCriterion("object not like", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectIn(List<String> values) {
            addCriterion("object in", values, "object");
            return (Criteria) this;
        }

        public Criteria andObjectNotIn(List<String> values) {
            addCriterion("object not in", values, "object");
            return (Criteria) this;
        }

        public Criteria andObjectBetween(String value1, String value2) {
            addCriterion("object between", value1, value2, "object");
            return (Criteria) this;
        }

        public Criteria andObjectNotBetween(String value1, String value2) {
            addCriterion("object not between", value1, value2, "object");
            return (Criteria) this;
        }

        public Criteria andScaleIsNull() {
            addCriterion("scale is null");
            return (Criteria) this;
        }

        public Criteria andScaleIsNotNull() {
            addCriterion("scale is not null");
            return (Criteria) this;
        }

        public Criteria andScaleEqualTo(String value) {
            addCriterion("scale =", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotEqualTo(String value) {
            addCriterion("scale <>", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThan(String value) {
            addCriterion("scale >", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThanOrEqualTo(String value) {
            addCriterion("scale >=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThan(String value) {
            addCriterion("scale <", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThanOrEqualTo(String value) {
            addCriterion("scale <=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLike(String value) {
            addCriterion("scale like", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotLike(String value) {
            addCriterion("scale not like", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleIn(List<String> values) {
            addCriterion("scale in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotIn(List<String> values) {
            addCriterion("scale not in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleBetween(String value1, String value2) {
            addCriterion("scale between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotBetween(String value1, String value2) {
            addCriterion("scale not between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleDescIsNull() {
            addCriterion("scale_desc is null");
            return (Criteria) this;
        }

        public Criteria andScaleDescIsNotNull() {
            addCriterion("scale_desc is not null");
            return (Criteria) this;
        }

        public Criteria andScaleDescEqualTo(String value) {
            addCriterion("scale_desc =", value, "scaleDesc");
            return (Criteria) this;
        }

        public Criteria andScaleDescNotEqualTo(String value) {
            addCriterion("scale_desc <>", value, "scaleDesc");
            return (Criteria) this;
        }

        public Criteria andScaleDescGreaterThan(String value) {
            addCriterion("scale_desc >", value, "scaleDesc");
            return (Criteria) this;
        }

        public Criteria andScaleDescGreaterThanOrEqualTo(String value) {
            addCriterion("scale_desc >=", value, "scaleDesc");
            return (Criteria) this;
        }

        public Criteria andScaleDescLessThan(String value) {
            addCriterion("scale_desc <", value, "scaleDesc");
            return (Criteria) this;
        }

        public Criteria andScaleDescLessThanOrEqualTo(String value) {
            addCriterion("scale_desc <=", value, "scaleDesc");
            return (Criteria) this;
        }

        public Criteria andScaleDescLike(String value) {
            addCriterion("scale_desc like", value, "scaleDesc");
            return (Criteria) this;
        }

        public Criteria andScaleDescNotLike(String value) {
            addCriterion("scale_desc not like", value, "scaleDesc");
            return (Criteria) this;
        }

        public Criteria andScaleDescIn(List<String> values) {
            addCriterion("scale_desc in", values, "scaleDesc");
            return (Criteria) this;
        }

        public Criteria andScaleDescNotIn(List<String> values) {
            addCriterion("scale_desc not in", values, "scaleDesc");
            return (Criteria) this;
        }

        public Criteria andScaleDescBetween(String value1, String value2) {
            addCriterion("scale_desc between", value1, value2, "scaleDesc");
            return (Criteria) this;
        }

        public Criteria andScaleDescNotBetween(String value1, String value2) {
            addCriterion("scale_desc not between", value1, value2, "scaleDesc");
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

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNull() {
            addCriterion("introduce is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("introduce is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("introduce =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("introduce <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("introduce >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("introduce >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("introduce <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("introduce <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("introduce like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("introduce not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("introduce in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("introduce not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("introduce between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("introduce not between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumIsNull() {
            addCriterion("employee_num is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumIsNotNull() {
            addCriterion("employee_num is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumEqualTo(String value) {
            addCriterion("employee_num =", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumNotEqualTo(String value) {
            addCriterion("employee_num <>", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumGreaterThan(String value) {
            addCriterion("employee_num >", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumGreaterThanOrEqualTo(String value) {
            addCriterion("employee_num >=", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumLessThan(String value) {
            addCriterion("employee_num <", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumLessThanOrEqualTo(String value) {
            addCriterion("employee_num <=", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumLike(String value) {
            addCriterion("employee_num like", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumNotLike(String value) {
            addCriterion("employee_num not like", value, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumIn(List<String> values) {
            addCriterion("employee_num in", values, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumNotIn(List<String> values) {
            addCriterion("employee_num not in", values, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumBetween(String value1, String value2) {
            addCriterion("employee_num between", value1, value2, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumNotBetween(String value1, String value2) {
            addCriterion("employee_num not between", value1, value2, "employeeNum");
            return (Criteria) this;
        }

        public Criteria andSpecialDemandIsNull() {
            addCriterion("special_demand is null");
            return (Criteria) this;
        }

        public Criteria andSpecialDemandIsNotNull() {
            addCriterion("special_demand is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialDemandEqualTo(String value) {
            addCriterion("special_demand =", value, "specialDemand");
            return (Criteria) this;
        }

        public Criteria andSpecialDemandNotEqualTo(String value) {
            addCriterion("special_demand <>", value, "specialDemand");
            return (Criteria) this;
        }

        public Criteria andSpecialDemandGreaterThan(String value) {
            addCriterion("special_demand >", value, "specialDemand");
            return (Criteria) this;
        }

        public Criteria andSpecialDemandGreaterThanOrEqualTo(String value) {
            addCriterion("special_demand >=", value, "specialDemand");
            return (Criteria) this;
        }

        public Criteria andSpecialDemandLessThan(String value) {
            addCriterion("special_demand <", value, "specialDemand");
            return (Criteria) this;
        }

        public Criteria andSpecialDemandLessThanOrEqualTo(String value) {
            addCriterion("special_demand <=", value, "specialDemand");
            return (Criteria) this;
        }

        public Criteria andSpecialDemandLike(String value) {
            addCriterion("special_demand like", value, "specialDemand");
            return (Criteria) this;
        }

        public Criteria andSpecialDemandNotLike(String value) {
            addCriterion("special_demand not like", value, "specialDemand");
            return (Criteria) this;
        }

        public Criteria andSpecialDemandIn(List<String> values) {
            addCriterion("special_demand in", values, "specialDemand");
            return (Criteria) this;
        }

        public Criteria andSpecialDemandNotIn(List<String> values) {
            addCriterion("special_demand not in", values, "specialDemand");
            return (Criteria) this;
        }

        public Criteria andSpecialDemandBetween(String value1, String value2) {
            addCriterion("special_demand between", value1, value2, "specialDemand");
            return (Criteria) this;
        }

        public Criteria andSpecialDemandNotBetween(String value1, String value2) {
            addCriterion("special_demand not between", value1, value2, "specialDemand");
            return (Criteria) this;
        }

        public Criteria andRunMethodIsNull() {
            addCriterion("run_method is null");
            return (Criteria) this;
        }

        public Criteria andRunMethodIsNotNull() {
            addCriterion("run_method is not null");
            return (Criteria) this;
        }

        public Criteria andRunMethodEqualTo(String value) {
            addCriterion("run_method =", value, "runMethod");
            return (Criteria) this;
        }

        public Criteria andRunMethodNotEqualTo(String value) {
            addCriterion("run_method <>", value, "runMethod");
            return (Criteria) this;
        }

        public Criteria andRunMethodGreaterThan(String value) {
            addCriterion("run_method >", value, "runMethod");
            return (Criteria) this;
        }

        public Criteria andRunMethodGreaterThanOrEqualTo(String value) {
            addCriterion("run_method >=", value, "runMethod");
            return (Criteria) this;
        }

        public Criteria andRunMethodLessThan(String value) {
            addCriterion("run_method <", value, "runMethod");
            return (Criteria) this;
        }

        public Criteria andRunMethodLessThanOrEqualTo(String value) {
            addCriterion("run_method <=", value, "runMethod");
            return (Criteria) this;
        }

        public Criteria andRunMethodLike(String value) {
            addCriterion("run_method like", value, "runMethod");
            return (Criteria) this;
        }

        public Criteria andRunMethodNotLike(String value) {
            addCriterion("run_method not like", value, "runMethod");
            return (Criteria) this;
        }

        public Criteria andRunMethodIn(List<String> values) {
            addCriterion("run_method in", values, "runMethod");
            return (Criteria) this;
        }

        public Criteria andRunMethodNotIn(List<String> values) {
            addCriterion("run_method not in", values, "runMethod");
            return (Criteria) this;
        }

        public Criteria andRunMethodBetween(String value1, String value2) {
            addCriterion("run_method between", value1, value2, "runMethod");
            return (Criteria) this;
        }

        public Criteria andRunMethodNotBetween(String value1, String value2) {
            addCriterion("run_method not between", value1, value2, "runMethod");
            return (Criteria) this;
        }

        public Criteria andBusinessSituIsNull() {
            addCriterion("business_situ is null");
            return (Criteria) this;
        }

        public Criteria andBusinessSituIsNotNull() {
            addCriterion("business_situ is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessSituEqualTo(String value) {
            addCriterion("business_situ =", value, "businessSitu");
            return (Criteria) this;
        }

        public Criteria andBusinessSituNotEqualTo(String value) {
            addCriterion("business_situ <>", value, "businessSitu");
            return (Criteria) this;
        }

        public Criteria andBusinessSituGreaterThan(String value) {
            addCriterion("business_situ >", value, "businessSitu");
            return (Criteria) this;
        }

        public Criteria andBusinessSituGreaterThanOrEqualTo(String value) {
            addCriterion("business_situ >=", value, "businessSitu");
            return (Criteria) this;
        }

        public Criteria andBusinessSituLessThan(String value) {
            addCriterion("business_situ <", value, "businessSitu");
            return (Criteria) this;
        }

        public Criteria andBusinessSituLessThanOrEqualTo(String value) {
            addCriterion("business_situ <=", value, "businessSitu");
            return (Criteria) this;
        }

        public Criteria andBusinessSituLike(String value) {
            addCriterion("business_situ like", value, "businessSitu");
            return (Criteria) this;
        }

        public Criteria andBusinessSituNotLike(String value) {
            addCriterion("business_situ not like", value, "businessSitu");
            return (Criteria) this;
        }

        public Criteria andBusinessSituIn(List<String> values) {
            addCriterion("business_situ in", values, "businessSitu");
            return (Criteria) this;
        }

        public Criteria andBusinessSituNotIn(List<String> values) {
            addCriterion("business_situ not in", values, "businessSitu");
            return (Criteria) this;
        }

        public Criteria andBusinessSituBetween(String value1, String value2) {
            addCriterion("business_situ between", value1, value2, "businessSitu");
            return (Criteria) this;
        }

        public Criteria andBusinessSituNotBetween(String value1, String value2) {
            addCriterion("business_situ not between", value1, value2, "businessSitu");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andAttitudeIsNull() {
            addCriterion("attitude is null");
            return (Criteria) this;
        }

        public Criteria andAttitudeIsNotNull() {
            addCriterion("attitude is not null");
            return (Criteria) this;
        }

        public Criteria andAttitudeEqualTo(String value) {
            addCriterion("attitude =", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeNotEqualTo(String value) {
            addCriterion("attitude <>", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeGreaterThan(String value) {
            addCriterion("attitude >", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeGreaterThanOrEqualTo(String value) {
            addCriterion("attitude >=", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeLessThan(String value) {
            addCriterion("attitude <", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeLessThanOrEqualTo(String value) {
            addCriterion("attitude <=", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeLike(String value) {
            addCriterion("attitude like", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeNotLike(String value) {
            addCriterion("attitude not like", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeIn(List<String> values) {
            addCriterion("attitude in", values, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeNotIn(List<String> values) {
            addCriterion("attitude not in", values, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeBetween(String value1, String value2) {
            addCriterion("attitude between", value1, value2, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeNotBetween(String value1, String value2) {
            addCriterion("attitude not between", value1, value2, "attitude");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andDutyManIsNull() {
            addCriterion("duty_man is null");
            return (Criteria) this;
        }

        public Criteria andDutyManIsNotNull() {
            addCriterion("duty_man is not null");
            return (Criteria) this;
        }

        public Criteria andDutyManEqualTo(Integer value) {
            addCriterion("duty_man =", value, "dutyMan");
            return (Criteria) this;
        }

        public Criteria andDutyManNotEqualTo(Integer value) {
            addCriterion("duty_man <>", value, "dutyMan");
            return (Criteria) this;
        }

        public Criteria andDutyManGreaterThan(Integer value) {
            addCriterion("duty_man >", value, "dutyMan");
            return (Criteria) this;
        }

        public Criteria andDutyManGreaterThanOrEqualTo(Integer value) {
            addCriterion("duty_man >=", value, "dutyMan");
            return (Criteria) this;
        }

        public Criteria andDutyManLessThan(Integer value) {
            addCriterion("duty_man <", value, "dutyMan");
            return (Criteria) this;
        }

        public Criteria andDutyManLessThanOrEqualTo(Integer value) {
            addCriterion("duty_man <=", value, "dutyMan");
            return (Criteria) this;
        }

        public Criteria andDutyManIn(List<Integer> values) {
            addCriterion("duty_man in", values, "dutyMan");
            return (Criteria) this;
        }

        public Criteria andDutyManNotIn(List<Integer> values) {
            addCriterion("duty_man not in", values, "dutyMan");
            return (Criteria) this;
        }

        public Criteria andDutyManBetween(Integer value1, Integer value2) {
            addCriterion("duty_man between", value1, value2, "dutyMan");
            return (Criteria) this;
        }

        public Criteria andDutyManNotBetween(Integer value1, Integer value2) {
            addCriterion("duty_man not between", value1, value2, "dutyMan");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNull() {
            addCriterion("register_time is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNotNull() {
            addCriterion("register_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeEqualTo(Date value) {
            addCriterion("register_time =", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotEqualTo(Date value) {
            addCriterion("register_time <>", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThan(Date value) {
            addCriterion("register_time >", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("register_time >=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThan(Date value) {
            addCriterion("register_time <", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("register_time <=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIn(List<Date> values) {
            addCriterion("register_time in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotIn(List<Date> values) {
            addCriterion("register_time not in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("register_time between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("register_time not between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andFlushTimeIsNull() {
            addCriterion("flush_time is null");
            return (Criteria) this;
        }

        public Criteria andFlushTimeIsNotNull() {
            addCriterion("flush_time is not null");
            return (Criteria) this;
        }

        public Criteria andFlushTimeEqualTo(Date value) {
            addCriterion("flush_time =", value, "flushTime");
            return (Criteria) this;
        }

        public Criteria andFlushTimeNotEqualTo(Date value) {
            addCriterion("flush_time <>", value, "flushTime");
            return (Criteria) this;
        }

        public Criteria andFlushTimeGreaterThan(Date value) {
            addCriterion("flush_time >", value, "flushTime");
            return (Criteria) this;
        }

        public Criteria andFlushTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("flush_time >=", value, "flushTime");
            return (Criteria) this;
        }

        public Criteria andFlushTimeLessThan(Date value) {
            addCriterion("flush_time <", value, "flushTime");
            return (Criteria) this;
        }

        public Criteria andFlushTimeLessThanOrEqualTo(Date value) {
            addCriterion("flush_time <=", value, "flushTime");
            return (Criteria) this;
        }

        public Criteria andFlushTimeIn(List<Date> values) {
            addCriterion("flush_time in", values, "flushTime");
            return (Criteria) this;
        }

        public Criteria andFlushTimeNotIn(List<Date> values) {
            addCriterion("flush_time not in", values, "flushTime");
            return (Criteria) this;
        }

        public Criteria andFlushTimeBetween(Date value1, Date value2) {
            addCriterion("flush_time between", value1, value2, "flushTime");
            return (Criteria) this;
        }

        public Criteria andFlushTimeNotBetween(Date value1, Date value2) {
            addCriterion("flush_time not between", value1, value2, "flushTime");
            return (Criteria) this;
        }

        public Criteria andFlushCountIsNull() {
            addCriterion("flush_count is null");
            return (Criteria) this;
        }

        public Criteria andFlushCountIsNotNull() {
            addCriterion("flush_count is not null");
            return (Criteria) this;
        }

        public Criteria andFlushCountEqualTo(Integer value) {
            addCriterion("flush_count =", value, "flushCount");
            return (Criteria) this;
        }

        public Criteria andFlushCountNotEqualTo(Integer value) {
            addCriterion("flush_count <>", value, "flushCount");
            return (Criteria) this;
        }

        public Criteria andFlushCountGreaterThan(Integer value) {
            addCriterion("flush_count >", value, "flushCount");
            return (Criteria) this;
        }

        public Criteria andFlushCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("flush_count >=", value, "flushCount");
            return (Criteria) this;
        }

        public Criteria andFlushCountLessThan(Integer value) {
            addCriterion("flush_count <", value, "flushCount");
            return (Criteria) this;
        }

        public Criteria andFlushCountLessThanOrEqualTo(Integer value) {
            addCriterion("flush_count <=", value, "flushCount");
            return (Criteria) this;
        }

        public Criteria andFlushCountIn(List<Integer> values) {
            addCriterion("flush_count in", values, "flushCount");
            return (Criteria) this;
        }

        public Criteria andFlushCountNotIn(List<Integer> values) {
            addCriterion("flush_count not in", values, "flushCount");
            return (Criteria) this;
        }

        public Criteria andFlushCountBetween(Integer value1, Integer value2) {
            addCriterion("flush_count between", value1, value2, "flushCount");
            return (Criteria) this;
        }

        public Criteria andFlushCountNotBetween(Integer value1, Integer value2) {
            addCriterion("flush_count not between", value1, value2, "flushCount");
            return (Criteria) this;
        }

        public Criteria andFlushEveMonIsNull() {
            addCriterion("flush_eve_mon is null");
            return (Criteria) this;
        }

        public Criteria andFlushEveMonIsNotNull() {
            addCriterion("flush_eve_mon is not null");
            return (Criteria) this;
        }

        public Criteria andFlushEveMonEqualTo(String value) {
            addCriterion("flush_eve_mon =", value, "flushEveMon");
            return (Criteria) this;
        }

        public Criteria andFlushEveMonNotEqualTo(String value) {
            addCriterion("flush_eve_mon <>", value, "flushEveMon");
            return (Criteria) this;
        }

        public Criteria andFlushEveMonGreaterThan(String value) {
            addCriterion("flush_eve_mon >", value, "flushEveMon");
            return (Criteria) this;
        }

        public Criteria andFlushEveMonGreaterThanOrEqualTo(String value) {
            addCriterion("flush_eve_mon >=", value, "flushEveMon");
            return (Criteria) this;
        }

        public Criteria andFlushEveMonLessThan(String value) {
            addCriterion("flush_eve_mon <", value, "flushEveMon");
            return (Criteria) this;
        }

        public Criteria andFlushEveMonLessThanOrEqualTo(String value) {
            addCriterion("flush_eve_mon <=", value, "flushEveMon");
            return (Criteria) this;
        }

        public Criteria andFlushEveMonLike(String value) {
            addCriterion("flush_eve_mon like", value, "flushEveMon");
            return (Criteria) this;
        }

        public Criteria andFlushEveMonNotLike(String value) {
            addCriterion("flush_eve_mon not like", value, "flushEveMon");
            return (Criteria) this;
        }

        public Criteria andFlushEveMonIn(List<String> values) {
            addCriterion("flush_eve_mon in", values, "flushEveMon");
            return (Criteria) this;
        }

        public Criteria andFlushEveMonNotIn(List<String> values) {
            addCriterion("flush_eve_mon not in", values, "flushEveMon");
            return (Criteria) this;
        }

        public Criteria andFlushEveMonBetween(String value1, String value2) {
            addCriterion("flush_eve_mon between", value1, value2, "flushEveMon");
            return (Criteria) this;
        }

        public Criteria andFlushEveMonNotBetween(String value1, String value2) {
            addCriterion("flush_eve_mon not between", value1, value2, "flushEveMon");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyIsNull() {
            addCriterion("customer_company is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyIsNotNull() {
            addCriterion("customer_company is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyEqualTo(String value) {
            addCriterion("customer_company =", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyNotEqualTo(String value) {
            addCriterion("customer_company <>", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyGreaterThan(String value) {
            addCriterion("customer_company >", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("customer_company >=", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyLessThan(String value) {
            addCriterion("customer_company <", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyLessThanOrEqualTo(String value) {
            addCriterion("customer_company <=", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyLike(String value) {
            addCriterion("customer_company like", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyNotLike(String value) {
            addCriterion("customer_company not like", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyIn(List<String> values) {
            addCriterion("customer_company in", values, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyNotIn(List<String> values) {
            addCriterion("customer_company not in", values, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyBetween(String value1, String value2) {
            addCriterion("customer_company between", value1, value2, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyNotBetween(String value1, String value2) {
            addCriterion("customer_company not between", value1, value2, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCellPhoneIsNull() {
            addCriterion("customer_cell_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCellPhoneIsNotNull() {
            addCriterion("customer_cell_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCellPhoneEqualTo(String value) {
            addCriterion("customer_cell_phone =", value, "customerCellPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerCellPhoneNotEqualTo(String value) {
            addCriterion("customer_cell_phone <>", value, "customerCellPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerCellPhoneGreaterThan(String value) {
            addCriterion("customer_cell_phone >", value, "customerCellPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerCellPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("customer_cell_phone >=", value, "customerCellPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerCellPhoneLessThan(String value) {
            addCriterion("customer_cell_phone <", value, "customerCellPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerCellPhoneLessThanOrEqualTo(String value) {
            addCriterion("customer_cell_phone <=", value, "customerCellPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerCellPhoneLike(String value) {
            addCriterion("customer_cell_phone like", value, "customerCellPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerCellPhoneNotLike(String value) {
            addCriterion("customer_cell_phone not like", value, "customerCellPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerCellPhoneIn(List<String> values) {
            addCriterion("customer_cell_phone in", values, "customerCellPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerCellPhoneNotIn(List<String> values) {
            addCriterion("customer_cell_phone not in", values, "customerCellPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerCellPhoneBetween(String value1, String value2) {
            addCriterion("customer_cell_phone between", value1, value2, "customerCellPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerCellPhoneNotBetween(String value1, String value2) {
            addCriterion("customer_cell_phone not between", value1, value2, "customerCellPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerOfficePhoneIsNull() {
            addCriterion("customer_office_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustomerOfficePhoneIsNotNull() {
            addCriterion("customer_office_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerOfficePhoneEqualTo(String value) {
            addCriterion("customer_office_phone =", value, "customerOfficePhone");
            return (Criteria) this;
        }

        public Criteria andCustomerOfficePhoneNotEqualTo(String value) {
            addCriterion("customer_office_phone <>", value, "customerOfficePhone");
            return (Criteria) this;
        }

        public Criteria andCustomerOfficePhoneGreaterThan(String value) {
            addCriterion("customer_office_phone >", value, "customerOfficePhone");
            return (Criteria) this;
        }

        public Criteria andCustomerOfficePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("customer_office_phone >=", value, "customerOfficePhone");
            return (Criteria) this;
        }

        public Criteria andCustomerOfficePhoneLessThan(String value) {
            addCriterion("customer_office_phone <", value, "customerOfficePhone");
            return (Criteria) this;
        }

        public Criteria andCustomerOfficePhoneLessThanOrEqualTo(String value) {
            addCriterion("customer_office_phone <=", value, "customerOfficePhone");
            return (Criteria) this;
        }

        public Criteria andCustomerOfficePhoneLike(String value) {
            addCriterion("customer_office_phone like", value, "customerOfficePhone");
            return (Criteria) this;
        }

        public Criteria andCustomerOfficePhoneNotLike(String value) {
            addCriterion("customer_office_phone not like", value, "customerOfficePhone");
            return (Criteria) this;
        }

        public Criteria andCustomerOfficePhoneIn(List<String> values) {
            addCriterion("customer_office_phone in", values, "customerOfficePhone");
            return (Criteria) this;
        }

        public Criteria andCustomerOfficePhoneNotIn(List<String> values) {
            addCriterion("customer_office_phone not in", values, "customerOfficePhone");
            return (Criteria) this;
        }

        public Criteria andCustomerOfficePhoneBetween(String value1, String value2) {
            addCriterion("customer_office_phone between", value1, value2, "customerOfficePhone");
            return (Criteria) this;
        }

        public Criteria andCustomerOfficePhoneNotBetween(String value1, String value2) {
            addCriterion("customer_office_phone not between", value1, value2, "customerOfficePhone");
            return (Criteria) this;
        }

        public Criteria andCustomerQqIsNull() {
            addCriterion("customer_QQ is null");
            return (Criteria) this;
        }

        public Criteria andCustomerQqIsNotNull() {
            addCriterion("customer_QQ is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerQqEqualTo(String value) {
            addCriterion("customer_QQ =", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotEqualTo(String value) {
            addCriterion("customer_QQ <>", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqGreaterThan(String value) {
            addCriterion("customer_QQ >", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqGreaterThanOrEqualTo(String value) {
            addCriterion("customer_QQ >=", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqLessThan(String value) {
            addCriterion("customer_QQ <", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqLessThanOrEqualTo(String value) {
            addCriterion("customer_QQ <=", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqLike(String value) {
            addCriterion("customer_QQ like", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotLike(String value) {
            addCriterion("customer_QQ not like", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqIn(List<String> values) {
            addCriterion("customer_QQ in", values, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotIn(List<String> values) {
            addCriterion("customer_QQ not in", values, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqBetween(String value1, String value2) {
            addCriterion("customer_QQ between", value1, value2, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotBetween(String value1, String value2) {
            addCriterion("customer_QQ not between", value1, value2, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerCountermanIsNull() {
            addCriterion("customer_counterman is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCountermanIsNotNull() {
            addCriterion("customer_counterman is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCountermanEqualTo(Integer value) {
            addCriterion("customer_counterman =", value, "customerCounterman");
            return (Criteria) this;
        }

        public Criteria andCustomerCountermanNotEqualTo(Integer value) {
            addCriterion("customer_counterman <>", value, "customerCounterman");
            return (Criteria) this;
        }

        public Criteria andCustomerCountermanGreaterThan(Integer value) {
            addCriterion("customer_counterman >", value, "customerCounterman");
            return (Criteria) this;
        }

        public Criteria andCustomerCountermanGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_counterman >=", value, "customerCounterman");
            return (Criteria) this;
        }

        public Criteria andCustomerCountermanLessThan(Integer value) {
            addCriterion("customer_counterman <", value, "customerCounterman");
            return (Criteria) this;
        }

        public Criteria andCustomerCountermanLessThanOrEqualTo(Integer value) {
            addCriterion("customer_counterman <=", value, "customerCounterman");
            return (Criteria) this;
        }

        public Criteria andCustomerCountermanIn(List<Integer> values) {
            addCriterion("customer_counterman in", values, "customerCounterman");
            return (Criteria) this;
        }

        public Criteria andCustomerCountermanNotIn(List<Integer> values) {
            addCriterion("customer_counterman not in", values, "customerCounterman");
            return (Criteria) this;
        }

        public Criteria andCustomerCountermanBetween(Integer value1, Integer value2) {
            addCriterion("customer_counterman between", value1, value2, "customerCounterman");
            return (Criteria) this;
        }

        public Criteria andCustomerCountermanNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_counterman not between", value1, value2, "customerCounterman");
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

        public Criteria andCustomerStatusIsNull() {
            addCriterion("customer_status is null");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusIsNotNull() {
            addCriterion("customer_status is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusEqualTo(String value) {
            addCriterion("customer_status =", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusNotEqualTo(String value) {
            addCriterion("customer_status <>", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusGreaterThan(String value) {
            addCriterion("customer_status >", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusGreaterThanOrEqualTo(String value) {
            addCriterion("customer_status >=", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusLessThan(String value) {
            addCriterion("customer_status <", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusLessThanOrEqualTo(String value) {
            addCriterion("customer_status <=", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusLike(String value) {
            addCriterion("customer_status like", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusNotLike(String value) {
            addCriterion("customer_status not like", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusIn(List<String> values) {
            addCriterion("customer_status in", values, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusNotIn(List<String> values) {
            addCriterion("customer_status not in", values, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusBetween(String value1, String value2) {
            addCriterion("customer_status between", value1, value2, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusNotBetween(String value1, String value2) {
            addCriterion("customer_status not between", value1, value2, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andWinxinOpenidIsNull() {
            addCriterion("winxin_openid is null");
            return (Criteria) this;
        }

        public Criteria andWinxinOpenidIsNotNull() {
            addCriterion("winxin_openid is not null");
            return (Criteria) this;
        }

        public Criteria andWinxinOpenidEqualTo(String value) {
            addCriterion("winxin_openid =", value, "winxinOpenid");
            return (Criteria) this;
        }

        public Criteria andWinxinOpenidNotEqualTo(String value) {
            addCriterion("winxin_openid <>", value, "winxinOpenid");
            return (Criteria) this;
        }

        public Criteria andWinxinOpenidGreaterThan(String value) {
            addCriterion("winxin_openid >", value, "winxinOpenid");
            return (Criteria) this;
        }

        public Criteria andWinxinOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("winxin_openid >=", value, "winxinOpenid");
            return (Criteria) this;
        }

        public Criteria andWinxinOpenidLessThan(String value) {
            addCriterion("winxin_openid <", value, "winxinOpenid");
            return (Criteria) this;
        }

        public Criteria andWinxinOpenidLessThanOrEqualTo(String value) {
            addCriterion("winxin_openid <=", value, "winxinOpenid");
            return (Criteria) this;
        }

        public Criteria andWinxinOpenidLike(String value) {
            addCriterion("winxin_openid like", value, "winxinOpenid");
            return (Criteria) this;
        }

        public Criteria andWinxinOpenidNotLike(String value) {
            addCriterion("winxin_openid not like", value, "winxinOpenid");
            return (Criteria) this;
        }

        public Criteria andWinxinOpenidIn(List<String> values) {
            addCriterion("winxin_openid in", values, "winxinOpenid");
            return (Criteria) this;
        }

        public Criteria andWinxinOpenidNotIn(List<String> values) {
            addCriterion("winxin_openid not in", values, "winxinOpenid");
            return (Criteria) this;
        }

        public Criteria andWinxinOpenidBetween(String value1, String value2) {
            addCriterion("winxin_openid between", value1, value2, "winxinOpenid");
            return (Criteria) this;
        }

        public Criteria andWinxinOpenidNotBetween(String value1, String value2) {
            addCriterion("winxin_openid not between", value1, value2, "winxinOpenid");
            return (Criteria) this;
        }

        public Criteria andWeixinNameIsNull() {
            addCriterion("weixin_name is null");
            return (Criteria) this;
        }

        public Criteria andWeixinNameIsNotNull() {
            addCriterion("weixin_name is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinNameEqualTo(String value) {
            addCriterion("weixin_name =", value, "weixinName");
            return (Criteria) this;
        }

        public Criteria andWeixinNameNotEqualTo(String value) {
            addCriterion("weixin_name <>", value, "weixinName");
            return (Criteria) this;
        }

        public Criteria andWeixinNameGreaterThan(String value) {
            addCriterion("weixin_name >", value, "weixinName");
            return (Criteria) this;
        }

        public Criteria andWeixinNameGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_name >=", value, "weixinName");
            return (Criteria) this;
        }

        public Criteria andWeixinNameLessThan(String value) {
            addCriterion("weixin_name <", value, "weixinName");
            return (Criteria) this;
        }

        public Criteria andWeixinNameLessThanOrEqualTo(String value) {
            addCriterion("weixin_name <=", value, "weixinName");
            return (Criteria) this;
        }

        public Criteria andWeixinNameLike(String value) {
            addCriterion("weixin_name like", value, "weixinName");
            return (Criteria) this;
        }

        public Criteria andWeixinNameNotLike(String value) {
            addCriterion("weixin_name not like", value, "weixinName");
            return (Criteria) this;
        }

        public Criteria andWeixinNameIn(List<String> values) {
            addCriterion("weixin_name in", values, "weixinName");
            return (Criteria) this;
        }

        public Criteria andWeixinNameNotIn(List<String> values) {
            addCriterion("weixin_name not in", values, "weixinName");
            return (Criteria) this;
        }

        public Criteria andWeixinNameBetween(String value1, String value2) {
            addCriterion("weixin_name between", value1, value2, "weixinName");
            return (Criteria) this;
        }

        public Criteria andWeixinNameNotBetween(String value1, String value2) {
            addCriterion("weixin_name not between", value1, value2, "weixinName");
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

        public Criteria andCustomerPhotoIsNull() {
            addCriterion("customer_photo is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoIsNotNull() {
            addCriterion("customer_photo is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoEqualTo(String value) {
            addCriterion("customer_photo =", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoNotEqualTo(String value) {
            addCriterion("customer_photo <>", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoGreaterThan(String value) {
            addCriterion("customer_photo >", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("customer_photo >=", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoLessThan(String value) {
            addCriterion("customer_photo <", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoLessThanOrEqualTo(String value) {
            addCriterion("customer_photo <=", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoLike(String value) {
            addCriterion("customer_photo like", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoNotLike(String value) {
            addCriterion("customer_photo not like", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoIn(List<String> values) {
            addCriterion("customer_photo in", values, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoNotIn(List<String> values) {
            addCriterion("customer_photo not in", values, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoBetween(String value1, String value2) {
            addCriterion("customer_photo between", value1, value2, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoNotBetween(String value1, String value2) {
            addCriterion("customer_photo not between", value1, value2, "customerPhoto");
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

        public Criteria andAmenderEqualTo(String value) {
            addCriterion("amender =", value, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderNotEqualTo(String value) {
            addCriterion("amender <>", value, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderGreaterThan(String value) {
            addCriterion("amender >", value, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderGreaterThanOrEqualTo(String value) {
            addCriterion("amender >=", value, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderLessThan(String value) {
            addCriterion("amender <", value, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderLessThanOrEqualTo(String value) {
            addCriterion("amender <=", value, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderLike(String value) {
            addCriterion("amender like", value, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderNotLike(String value) {
            addCriterion("amender not like", value, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderIn(List<String> values) {
            addCriterion("amender in", values, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderNotIn(List<String> values) {
            addCriterion("amender not in", values, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderBetween(String value1, String value2) {
            addCriterion("amender between", value1, value2, "amender");
            return (Criteria) this;
        }

        public Criteria andAmenderNotBetween(String value1, String value2) {
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