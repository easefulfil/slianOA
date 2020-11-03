package com.sliansoft.slianOA.dataaccess.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysEmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public SysEmployeeExample() {
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

    public SysEmployeeExample(int pageSize, int pageIndex) {
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

        public Criteria andEmployeeDepartmentIsNull() {
            addCriterion("employee_department is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeDepartmentIsNotNull() {
            addCriterion("employee_department is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeDepartmentEqualTo(Integer value) {
            addCriterion("employee_department =", value, "employeeDepartment");
            return (Criteria) this;
        }

        public Criteria andEmployeeDepartmentNotEqualTo(Integer value) {
            addCriterion("employee_department <>", value, "employeeDepartment");
            return (Criteria) this;
        }

        public Criteria andEmployeeDepartmentGreaterThan(Integer value) {
            addCriterion("employee_department >", value, "employeeDepartment");
            return (Criteria) this;
        }

        public Criteria andEmployeeDepartmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_department >=", value, "employeeDepartment");
            return (Criteria) this;
        }

        public Criteria andEmployeeDepartmentLessThan(Integer value) {
            addCriterion("employee_department <", value, "employeeDepartment");
            return (Criteria) this;
        }

        public Criteria andEmployeeDepartmentLessThanOrEqualTo(Integer value) {
            addCriterion("employee_department <=", value, "employeeDepartment");
            return (Criteria) this;
        }

        public Criteria andEmployeeDepartmentIn(List<Integer> values) {
            addCriterion("employee_department in", values, "employeeDepartment");
            return (Criteria) this;
        }

        public Criteria andEmployeeDepartmentNotIn(List<Integer> values) {
            addCriterion("employee_department not in", values, "employeeDepartment");
            return (Criteria) this;
        }

        public Criteria andEmployeeDepartmentBetween(Integer value1, Integer value2) {
            addCriterion("employee_department between", value1, value2, "employeeDepartment");
            return (Criteria) this;
        }

        public Criteria andEmployeeDepartmentNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_department not between", value1, value2, "employeeDepartment");
            return (Criteria) this;
        }

        public Criteria andEmployeeCodeIsNull() {
            addCriterion("employee_code is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeCodeIsNotNull() {
            addCriterion("employee_code is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeCodeEqualTo(String value) {
            addCriterion("employee_code =", value, "employeeCode");
            return (Criteria) this;
        }

        public Criteria andEmployeeCodeNotEqualTo(String value) {
            addCriterion("employee_code <>", value, "employeeCode");
            return (Criteria) this;
        }

        public Criteria andEmployeeCodeGreaterThan(String value) {
            addCriterion("employee_code >", value, "employeeCode");
            return (Criteria) this;
        }

        public Criteria andEmployeeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("employee_code >=", value, "employeeCode");
            return (Criteria) this;
        }

        public Criteria andEmployeeCodeLessThan(String value) {
            addCriterion("employee_code <", value, "employeeCode");
            return (Criteria) this;
        }

        public Criteria andEmployeeCodeLessThanOrEqualTo(String value) {
            addCriterion("employee_code <=", value, "employeeCode");
            return (Criteria) this;
        }

        public Criteria andEmployeeCodeLike(String value) {
            addCriterion("employee_code like", value, "employeeCode");
            return (Criteria) this;
        }

        public Criteria andEmployeeCodeNotLike(String value) {
            addCriterion("employee_code not like", value, "employeeCode");
            return (Criteria) this;
        }

        public Criteria andEmployeeCodeIn(List<String> values) {
            addCriterion("employee_code in", values, "employeeCode");
            return (Criteria) this;
        }

        public Criteria andEmployeeCodeNotIn(List<String> values) {
            addCriterion("employee_code not in", values, "employeeCode");
            return (Criteria) this;
        }

        public Criteria andEmployeeCodeBetween(String value1, String value2) {
            addCriterion("employee_code between", value1, value2, "employeeCode");
            return (Criteria) this;
        }

        public Criteria andEmployeeCodeNotBetween(String value1, String value2) {
            addCriterion("employee_code not between", value1, value2, "employeeCode");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdcardIsNull() {
            addCriterion("employee_idcard is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdcardIsNotNull() {
            addCriterion("employee_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdcardEqualTo(String value) {
            addCriterion("employee_idcard =", value, "employeeIdcard");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdcardNotEqualTo(String value) {
            addCriterion("employee_idcard <>", value, "employeeIdcard");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdcardGreaterThan(String value) {
            addCriterion("employee_idcard >", value, "employeeIdcard");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("employee_idcard >=", value, "employeeIdcard");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdcardLessThan(String value) {
            addCriterion("employee_idcard <", value, "employeeIdcard");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdcardLessThanOrEqualTo(String value) {
            addCriterion("employee_idcard <=", value, "employeeIdcard");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdcardLike(String value) {
            addCriterion("employee_idcard like", value, "employeeIdcard");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdcardNotLike(String value) {
            addCriterion("employee_idcard not like", value, "employeeIdcard");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdcardIn(List<String> values) {
            addCriterion("employee_idcard in", values, "employeeIdcard");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdcardNotIn(List<String> values) {
            addCriterion("employee_idcard not in", values, "employeeIdcard");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdcardBetween(String value1, String value2) {
            addCriterion("employee_idcard between", value1, value2, "employeeIdcard");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdcardNotBetween(String value1, String value2) {
            addCriterion("employee_idcard not between", value1, value2, "employeeIdcard");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNull() {
            addCriterion("employee_name is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNotNull() {
            addCriterion("employee_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameEqualTo(String value) {
            addCriterion("employee_name =", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotEqualTo(String value) {
            addCriterion("employee_name <>", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThan(String value) {
            addCriterion("employee_name >", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("employee_name >=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThan(String value) {
            addCriterion("employee_name <", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThanOrEqualTo(String value) {
            addCriterion("employee_name <=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLike(String value) {
            addCriterion("employee_name like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotLike(String value) {
            addCriterion("employee_name not like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIn(List<String> values) {
            addCriterion("employee_name in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotIn(List<String> values) {
            addCriterion("employee_name not in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameBetween(String value1, String value2) {
            addCriterion("employee_name between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotBetween(String value1, String value2) {
            addCriterion("employee_name not between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNull() {
            addCriterion("english_name is null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNotNull() {
            addCriterion("english_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameEqualTo(String value) {
            addCriterion("english_name =", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotEqualTo(String value) {
            addCriterion("english_name <>", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThan(String value) {
            addCriterion("english_name >", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThanOrEqualTo(String value) {
            addCriterion("english_name >=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThan(String value) {
            addCriterion("english_name <", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThanOrEqualTo(String value) {
            addCriterion("english_name <=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLike(String value) {
            addCriterion("english_name like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotLike(String value) {
            addCriterion("english_name not like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIn(List<String> values) {
            addCriterion("english_name in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotIn(List<String> values) {
            addCriterion("english_name not in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameBetween(String value1, String value2) {
            addCriterion("english_name between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotBetween(String value1, String value2) {
            addCriterion("english_name not between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexIsNull() {
            addCriterion("employee_sex is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexIsNotNull() {
            addCriterion("employee_sex is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexEqualTo(String value) {
            addCriterion("employee_sex =", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexNotEqualTo(String value) {
            addCriterion("employee_sex <>", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexGreaterThan(String value) {
            addCriterion("employee_sex >", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexGreaterThanOrEqualTo(String value) {
            addCriterion("employee_sex >=", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexLessThan(String value) {
            addCriterion("employee_sex <", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexLessThanOrEqualTo(String value) {
            addCriterion("employee_sex <=", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexLike(String value) {
            addCriterion("employee_sex like", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexNotLike(String value) {
            addCriterion("employee_sex not like", value, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexIn(List<String> values) {
            addCriterion("employee_sex in", values, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexNotIn(List<String> values) {
            addCriterion("employee_sex not in", values, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexBetween(String value1, String value2) {
            addCriterion("employee_sex between", value1, value2, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeSexNotBetween(String value1, String value2) {
            addCriterion("employee_sex not between", value1, value2, "employeeSex");
            return (Criteria) this;
        }

        public Criteria andEmployeeFromIsNull() {
            addCriterion("employee_from is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeFromIsNotNull() {
            addCriterion("employee_from is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeFromEqualTo(String value) {
            addCriterion("employee_from =", value, "employeeFrom");
            return (Criteria) this;
        }

        public Criteria andEmployeeFromNotEqualTo(String value) {
            addCriterion("employee_from <>", value, "employeeFrom");
            return (Criteria) this;
        }

        public Criteria andEmployeeFromGreaterThan(String value) {
            addCriterion("employee_from >", value, "employeeFrom");
            return (Criteria) this;
        }

        public Criteria andEmployeeFromGreaterThanOrEqualTo(String value) {
            addCriterion("employee_from >=", value, "employeeFrom");
            return (Criteria) this;
        }

        public Criteria andEmployeeFromLessThan(String value) {
            addCriterion("employee_from <", value, "employeeFrom");
            return (Criteria) this;
        }

        public Criteria andEmployeeFromLessThanOrEqualTo(String value) {
            addCriterion("employee_from <=", value, "employeeFrom");
            return (Criteria) this;
        }

        public Criteria andEmployeeFromLike(String value) {
            addCriterion("employee_from like", value, "employeeFrom");
            return (Criteria) this;
        }

        public Criteria andEmployeeFromNotLike(String value) {
            addCriterion("employee_from not like", value, "employeeFrom");
            return (Criteria) this;
        }

        public Criteria andEmployeeFromIn(List<String> values) {
            addCriterion("employee_from in", values, "employeeFrom");
            return (Criteria) this;
        }

        public Criteria andEmployeeFromNotIn(List<String> values) {
            addCriterion("employee_from not in", values, "employeeFrom");
            return (Criteria) this;
        }

        public Criteria andEmployeeFromBetween(String value1, String value2) {
            addCriterion("employee_from between", value1, value2, "employeeFrom");
            return (Criteria) this;
        }

        public Criteria andEmployeeFromNotBetween(String value1, String value2) {
            addCriterion("employee_from not between", value1, value2, "employeeFrom");
            return (Criteria) this;
        }

        public Criteria andEmployeeGraduateIsNull() {
            addCriterion("employee_graduate is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeGraduateIsNotNull() {
            addCriterion("employee_graduate is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeGraduateEqualTo(String value) {
            addCriterion("employee_graduate =", value, "employeeGraduate");
            return (Criteria) this;
        }

        public Criteria andEmployeeGraduateNotEqualTo(String value) {
            addCriterion("employee_graduate <>", value, "employeeGraduate");
            return (Criteria) this;
        }

        public Criteria andEmployeeGraduateGreaterThan(String value) {
            addCriterion("employee_graduate >", value, "employeeGraduate");
            return (Criteria) this;
        }

        public Criteria andEmployeeGraduateGreaterThanOrEqualTo(String value) {
            addCriterion("employee_graduate >=", value, "employeeGraduate");
            return (Criteria) this;
        }

        public Criteria andEmployeeGraduateLessThan(String value) {
            addCriterion("employee_graduate <", value, "employeeGraduate");
            return (Criteria) this;
        }

        public Criteria andEmployeeGraduateLessThanOrEqualTo(String value) {
            addCriterion("employee_graduate <=", value, "employeeGraduate");
            return (Criteria) this;
        }

        public Criteria andEmployeeGraduateLike(String value) {
            addCriterion("employee_graduate like", value, "employeeGraduate");
            return (Criteria) this;
        }

        public Criteria andEmployeeGraduateNotLike(String value) {
            addCriterion("employee_graduate not like", value, "employeeGraduate");
            return (Criteria) this;
        }

        public Criteria andEmployeeGraduateIn(List<String> values) {
            addCriterion("employee_graduate in", values, "employeeGraduate");
            return (Criteria) this;
        }

        public Criteria andEmployeeGraduateNotIn(List<String> values) {
            addCriterion("employee_graduate not in", values, "employeeGraduate");
            return (Criteria) this;
        }

        public Criteria andEmployeeGraduateBetween(String value1, String value2) {
            addCriterion("employee_graduate between", value1, value2, "employeeGraduate");
            return (Criteria) this;
        }

        public Criteria andEmployeeGraduateNotBetween(String value1, String value2) {
            addCriterion("employee_graduate not between", value1, value2, "employeeGraduate");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayIsNull() {
            addCriterion("employee_birthday is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayIsNotNull() {
            addCriterion("employee_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayEqualTo(String value) {
            addCriterion("employee_birthday =", value, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayNotEqualTo(String value) {
            addCriterion("employee_birthday <>", value, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayGreaterThan(String value) {
            addCriterion("employee_birthday >", value, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("employee_birthday >=", value, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayLessThan(String value) {
            addCriterion("employee_birthday <", value, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayLessThanOrEqualTo(String value) {
            addCriterion("employee_birthday <=", value, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayLike(String value) {
            addCriterion("employee_birthday like", value, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayNotLike(String value) {
            addCriterion("employee_birthday not like", value, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayIn(List<String> values) {
            addCriterion("employee_birthday in", values, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayNotIn(List<String> values) {
            addCriterion("employee_birthday not in", values, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayBetween(String value1, String value2) {
            addCriterion("employee_birthday between", value1, value2, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andEmployeeBirthdayNotBetween(String value1, String value2) {
            addCriterion("employee_birthday not between", value1, value2, "employeeBirthday");
            return (Criteria) this;
        }

        public Criteria andIsMarryIsNull() {
            addCriterion("is_marry is null");
            return (Criteria) this;
        }

        public Criteria andIsMarryIsNotNull() {
            addCriterion("is_marry is not null");
            return (Criteria) this;
        }

        public Criteria andIsMarryEqualTo(String value) {
            addCriterion("is_marry =", value, "isMarry");
            return (Criteria) this;
        }

        public Criteria andIsMarryNotEqualTo(String value) {
            addCriterion("is_marry <>", value, "isMarry");
            return (Criteria) this;
        }

        public Criteria andIsMarryGreaterThan(String value) {
            addCriterion("is_marry >", value, "isMarry");
            return (Criteria) this;
        }

        public Criteria andIsMarryGreaterThanOrEqualTo(String value) {
            addCriterion("is_marry >=", value, "isMarry");
            return (Criteria) this;
        }

        public Criteria andIsMarryLessThan(String value) {
            addCriterion("is_marry <", value, "isMarry");
            return (Criteria) this;
        }

        public Criteria andIsMarryLessThanOrEqualTo(String value) {
            addCriterion("is_marry <=", value, "isMarry");
            return (Criteria) this;
        }

        public Criteria andIsMarryLike(String value) {
            addCriterion("is_marry like", value, "isMarry");
            return (Criteria) this;
        }

        public Criteria andIsMarryNotLike(String value) {
            addCriterion("is_marry not like", value, "isMarry");
            return (Criteria) this;
        }

        public Criteria andIsMarryIn(List<String> values) {
            addCriterion("is_marry in", values, "isMarry");
            return (Criteria) this;
        }

        public Criteria andIsMarryNotIn(List<String> values) {
            addCriterion("is_marry not in", values, "isMarry");
            return (Criteria) this;
        }

        public Criteria andIsMarryBetween(String value1, String value2) {
            addCriterion("is_marry between", value1, value2, "isMarry");
            return (Criteria) this;
        }

        public Criteria andIsMarryNotBetween(String value1, String value2) {
            addCriterion("is_marry not between", value1, value2, "isMarry");
            return (Criteria) this;
        }

        public Criteria andHasChildIsNull() {
            addCriterion("has_child is null");
            return (Criteria) this;
        }

        public Criteria andHasChildIsNotNull() {
            addCriterion("has_child is not null");
            return (Criteria) this;
        }

        public Criteria andHasChildEqualTo(String value) {
            addCriterion("has_child =", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildNotEqualTo(String value) {
            addCriterion("has_child <>", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildGreaterThan(String value) {
            addCriterion("has_child >", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildGreaterThanOrEqualTo(String value) {
            addCriterion("has_child >=", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildLessThan(String value) {
            addCriterion("has_child <", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildLessThanOrEqualTo(String value) {
            addCriterion("has_child <=", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildLike(String value) {
            addCriterion("has_child like", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildNotLike(String value) {
            addCriterion("has_child not like", value, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildIn(List<String> values) {
            addCriterion("has_child in", values, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildNotIn(List<String> values) {
            addCriterion("has_child not in", values, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildBetween(String value1, String value2) {
            addCriterion("has_child between", value1, value2, "hasChild");
            return (Criteria) this;
        }

        public Criteria andHasChildNotBetween(String value1, String value2) {
            addCriterion("has_child not between", value1, value2, "hasChild");
            return (Criteria) this;
        }

        public Criteria andCharacterIsNull() {
            addCriterion("character is null");
            return (Criteria) this;
        }

        public Criteria andCharacterIsNotNull() {
            addCriterion("character is not null");
            return (Criteria) this;
        }

        public Criteria andCharacterEqualTo(String value) {
            addCriterion("character =", value, "character");
            return (Criteria) this;
        }

        public Criteria andCharacterNotEqualTo(String value) {
            addCriterion("character <>", value, "character");
            return (Criteria) this;
        }

        public Criteria andCharacterGreaterThan(String value) {
            addCriterion("character >", value, "character");
            return (Criteria) this;
        }

        public Criteria andCharacterGreaterThanOrEqualTo(String value) {
            addCriterion("character >=", value, "character");
            return (Criteria) this;
        }

        public Criteria andCharacterLessThan(String value) {
            addCriterion("character <", value, "character");
            return (Criteria) this;
        }

        public Criteria andCharacterLessThanOrEqualTo(String value) {
            addCriterion("character <=", value, "character");
            return (Criteria) this;
        }

        public Criteria andCharacterLike(String value) {
            addCriterion("character like", value, "character");
            return (Criteria) this;
        }

        public Criteria andCharacterNotLike(String value) {
            addCriterion("character not like", value, "character");
            return (Criteria) this;
        }

        public Criteria andCharacterIn(List<String> values) {
            addCriterion("character in", values, "character");
            return (Criteria) this;
        }

        public Criteria andCharacterNotIn(List<String> values) {
            addCriterion("character not in", values, "character");
            return (Criteria) this;
        }

        public Criteria andCharacterBetween(String value1, String value2) {
            addCriterion("character between", value1, value2, "character");
            return (Criteria) this;
        }

        public Criteria andCharacterNotBetween(String value1, String value2) {
            addCriterion("character not between", value1, value2, "character");
            return (Criteria) this;
        }

        public Criteria andInteristIsNull() {
            addCriterion("interist is null");
            return (Criteria) this;
        }

        public Criteria andInteristIsNotNull() {
            addCriterion("interist is not null");
            return (Criteria) this;
        }

        public Criteria andInteristEqualTo(String value) {
            addCriterion("interist =", value, "interist");
            return (Criteria) this;
        }

        public Criteria andInteristNotEqualTo(String value) {
            addCriterion("interist <>", value, "interist");
            return (Criteria) this;
        }

        public Criteria andInteristGreaterThan(String value) {
            addCriterion("interist >", value, "interist");
            return (Criteria) this;
        }

        public Criteria andInteristGreaterThanOrEqualTo(String value) {
            addCriterion("interist >=", value, "interist");
            return (Criteria) this;
        }

        public Criteria andInteristLessThan(String value) {
            addCriterion("interist <", value, "interist");
            return (Criteria) this;
        }

        public Criteria andInteristLessThanOrEqualTo(String value) {
            addCriterion("interist <=", value, "interist");
            return (Criteria) this;
        }

        public Criteria andInteristLike(String value) {
            addCriterion("interist like", value, "interist");
            return (Criteria) this;
        }

        public Criteria andInteristNotLike(String value) {
            addCriterion("interist not like", value, "interist");
            return (Criteria) this;
        }

        public Criteria andInteristIn(List<String> values) {
            addCriterion("interist in", values, "interist");
            return (Criteria) this;
        }

        public Criteria andInteristNotIn(List<String> values) {
            addCriterion("interist not in", values, "interist");
            return (Criteria) this;
        }

        public Criteria andInteristBetween(String value1, String value2) {
            addCriterion("interist between", value1, value2, "interist");
            return (Criteria) this;
        }

        public Criteria andInteristNotBetween(String value1, String value2) {
            addCriterion("interist not between", value1, value2, "interist");
            return (Criteria) this;
        }

        public Criteria andEmployeeStatusIsNull() {
            addCriterion("employee_status is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeStatusIsNotNull() {
            addCriterion("employee_status is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeStatusEqualTo(String value) {
            addCriterion("employee_status =", value, "employeeStatus");
            return (Criteria) this;
        }

        public Criteria andEmployeeStatusNotEqualTo(String value) {
            addCriterion("employee_status <>", value, "employeeStatus");
            return (Criteria) this;
        }

        public Criteria andEmployeeStatusGreaterThan(String value) {
            addCriterion("employee_status >", value, "employeeStatus");
            return (Criteria) this;
        }

        public Criteria andEmployeeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("employee_status >=", value, "employeeStatus");
            return (Criteria) this;
        }

        public Criteria andEmployeeStatusLessThan(String value) {
            addCriterion("employee_status <", value, "employeeStatus");
            return (Criteria) this;
        }

        public Criteria andEmployeeStatusLessThanOrEqualTo(String value) {
            addCriterion("employee_status <=", value, "employeeStatus");
            return (Criteria) this;
        }

        public Criteria andEmployeeStatusLike(String value) {
            addCriterion("employee_status like", value, "employeeStatus");
            return (Criteria) this;
        }

        public Criteria andEmployeeStatusNotLike(String value) {
            addCriterion("employee_status not like", value, "employeeStatus");
            return (Criteria) this;
        }

        public Criteria andEmployeeStatusIn(List<String> values) {
            addCriterion("employee_status in", values, "employeeStatus");
            return (Criteria) this;
        }

        public Criteria andEmployeeStatusNotIn(List<String> values) {
            addCriterion("employee_status not in", values, "employeeStatus");
            return (Criteria) this;
        }

        public Criteria andEmployeeStatusBetween(String value1, String value2) {
            addCriterion("employee_status between", value1, value2, "employeeStatus");
            return (Criteria) this;
        }

        public Criteria andEmployeeStatusNotBetween(String value1, String value2) {
            addCriterion("employee_status not between", value1, value2, "employeeStatus");
            return (Criteria) this;
        }

        public Criteria andHomeTelIsNull() {
            addCriterion("home_tel is null");
            return (Criteria) this;
        }

        public Criteria andHomeTelIsNotNull() {
            addCriterion("home_tel is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTelEqualTo(String value) {
            addCriterion("home_tel =", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelNotEqualTo(String value) {
            addCriterion("home_tel <>", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelGreaterThan(String value) {
            addCriterion("home_tel >", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelGreaterThanOrEqualTo(String value) {
            addCriterion("home_tel >=", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelLessThan(String value) {
            addCriterion("home_tel <", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelLessThanOrEqualTo(String value) {
            addCriterion("home_tel <=", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelLike(String value) {
            addCriterion("home_tel like", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelNotLike(String value) {
            addCriterion("home_tel not like", value, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelIn(List<String> values) {
            addCriterion("home_tel in", values, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelNotIn(List<String> values) {
            addCriterion("home_tel not in", values, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelBetween(String value1, String value2) {
            addCriterion("home_tel between", value1, value2, "homeTel");
            return (Criteria) this;
        }

        public Criteria andHomeTelNotBetween(String value1, String value2) {
            addCriterion("home_tel not between", value1, value2, "homeTel");
            return (Criteria) this;
        }

        public Criteria andEmployeeCellPhoneIsNull() {
            addCriterion("employee_cell_phone is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeCellPhoneIsNotNull() {
            addCriterion("employee_cell_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeCellPhoneEqualTo(String value) {
            addCriterion("employee_cell_phone =", value, "employeeCellPhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeCellPhoneNotEqualTo(String value) {
            addCriterion("employee_cell_phone <>", value, "employeeCellPhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeCellPhoneGreaterThan(String value) {
            addCriterion("employee_cell_phone >", value, "employeeCellPhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeCellPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("employee_cell_phone >=", value, "employeeCellPhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeCellPhoneLessThan(String value) {
            addCriterion("employee_cell_phone <", value, "employeeCellPhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeCellPhoneLessThanOrEqualTo(String value) {
            addCriterion("employee_cell_phone <=", value, "employeeCellPhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeCellPhoneLike(String value) {
            addCriterion("employee_cell_phone like", value, "employeeCellPhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeCellPhoneNotLike(String value) {
            addCriterion("employee_cell_phone not like", value, "employeeCellPhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeCellPhoneIn(List<String> values) {
            addCriterion("employee_cell_phone in", values, "employeeCellPhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeCellPhoneNotIn(List<String> values) {
            addCriterion("employee_cell_phone not in", values, "employeeCellPhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeCellPhoneBetween(String value1, String value2) {
            addCriterion("employee_cell_phone between", value1, value2, "employeeCellPhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeCellPhoneNotBetween(String value1, String value2) {
            addCriterion("employee_cell_phone not between", value1, value2, "employeeCellPhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeOfficePhoneIsNull() {
            addCriterion("employee_office_phone is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeOfficePhoneIsNotNull() {
            addCriterion("employee_office_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeOfficePhoneEqualTo(String value) {
            addCriterion("employee_office_phone =", value, "employeeOfficePhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeOfficePhoneNotEqualTo(String value) {
            addCriterion("employee_office_phone <>", value, "employeeOfficePhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeOfficePhoneGreaterThan(String value) {
            addCriterion("employee_office_phone >", value, "employeeOfficePhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeOfficePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("employee_office_phone >=", value, "employeeOfficePhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeOfficePhoneLessThan(String value) {
            addCriterion("employee_office_phone <", value, "employeeOfficePhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeOfficePhoneLessThanOrEqualTo(String value) {
            addCriterion("employee_office_phone <=", value, "employeeOfficePhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeOfficePhoneLike(String value) {
            addCriterion("employee_office_phone like", value, "employeeOfficePhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeOfficePhoneNotLike(String value) {
            addCriterion("employee_office_phone not like", value, "employeeOfficePhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeOfficePhoneIn(List<String> values) {
            addCriterion("employee_office_phone in", values, "employeeOfficePhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeOfficePhoneNotIn(List<String> values) {
            addCriterion("employee_office_phone not in", values, "employeeOfficePhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeOfficePhoneBetween(String value1, String value2) {
            addCriterion("employee_office_phone between", value1, value2, "employeeOfficePhone");
            return (Criteria) this;
        }

        public Criteria andEmployeeOfficePhoneNotBetween(String value1, String value2) {
            addCriterion("employee_office_phone not between", value1, value2, "employeeOfficePhone");
            return (Criteria) this;
        }

        public Criteria andMsnIsNull() {
            addCriterion("MSN is null");
            return (Criteria) this;
        }

        public Criteria andMsnIsNotNull() {
            addCriterion("MSN is not null");
            return (Criteria) this;
        }

        public Criteria andMsnEqualTo(String value) {
            addCriterion("MSN =", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnNotEqualTo(String value) {
            addCriterion("MSN <>", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnGreaterThan(String value) {
            addCriterion("MSN >", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnGreaterThanOrEqualTo(String value) {
            addCriterion("MSN >=", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnLessThan(String value) {
            addCriterion("MSN <", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnLessThanOrEqualTo(String value) {
            addCriterion("MSN <=", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnLike(String value) {
            addCriterion("MSN like", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnNotLike(String value) {
            addCriterion("MSN not like", value, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnIn(List<String> values) {
            addCriterion("MSN in", values, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnNotIn(List<String> values) {
            addCriterion("MSN not in", values, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnBetween(String value1, String value2) {
            addCriterion("MSN between", value1, value2, "msn");
            return (Criteria) this;
        }

        public Criteria andMsnNotBetween(String value1, String value2) {
            addCriterion("MSN not between", value1, value2, "msn");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqIsNull() {
            addCriterion("employee_QQ is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqIsNotNull() {
            addCriterion("employee_QQ is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqEqualTo(String value) {
            addCriterion("employee_QQ =", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqNotEqualTo(String value) {
            addCriterion("employee_QQ <>", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqGreaterThan(String value) {
            addCriterion("employee_QQ >", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqGreaterThanOrEqualTo(String value) {
            addCriterion("employee_QQ >=", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqLessThan(String value) {
            addCriterion("employee_QQ <", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqLessThanOrEqualTo(String value) {
            addCriterion("employee_QQ <=", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqLike(String value) {
            addCriterion("employee_QQ like", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqNotLike(String value) {
            addCriterion("employee_QQ not like", value, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqIn(List<String> values) {
            addCriterion("employee_QQ in", values, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqNotIn(List<String> values) {
            addCriterion("employee_QQ not in", values, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqBetween(String value1, String value2) {
            addCriterion("employee_QQ between", value1, value2, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeQqNotBetween(String value1, String value2) {
            addCriterion("employee_QQ not between", value1, value2, "employeeQq");
            return (Criteria) this;
        }

        public Criteria andEmployeeDutiesIsNull() {
            addCriterion("employee_duties is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeDutiesIsNotNull() {
            addCriterion("employee_duties is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeDutiesEqualTo(String value) {
            addCriterion("employee_duties =", value, "employeeDuties");
            return (Criteria) this;
        }

        public Criteria andEmployeeDutiesNotEqualTo(String value) {
            addCriterion("employee_duties <>", value, "employeeDuties");
            return (Criteria) this;
        }

        public Criteria andEmployeeDutiesGreaterThan(String value) {
            addCriterion("employee_duties >", value, "employeeDuties");
            return (Criteria) this;
        }

        public Criteria andEmployeeDutiesGreaterThanOrEqualTo(String value) {
            addCriterion("employee_duties >=", value, "employeeDuties");
            return (Criteria) this;
        }

        public Criteria andEmployeeDutiesLessThan(String value) {
            addCriterion("employee_duties <", value, "employeeDuties");
            return (Criteria) this;
        }

        public Criteria andEmployeeDutiesLessThanOrEqualTo(String value) {
            addCriterion("employee_duties <=", value, "employeeDuties");
            return (Criteria) this;
        }

        public Criteria andEmployeeDutiesLike(String value) {
            addCriterion("employee_duties like", value, "employeeDuties");
            return (Criteria) this;
        }

        public Criteria andEmployeeDutiesNotLike(String value) {
            addCriterion("employee_duties not like", value, "employeeDuties");
            return (Criteria) this;
        }

        public Criteria andEmployeeDutiesIn(List<String> values) {
            addCriterion("employee_duties in", values, "employeeDuties");
            return (Criteria) this;
        }

        public Criteria andEmployeeDutiesNotIn(List<String> values) {
            addCriterion("employee_duties not in", values, "employeeDuties");
            return (Criteria) this;
        }

        public Criteria andEmployeeDutiesBetween(String value1, String value2) {
            addCriterion("employee_duties between", value1, value2, "employeeDuties");
            return (Criteria) this;
        }

        public Criteria andEmployeeDutiesNotBetween(String value1, String value2) {
            addCriterion("employee_duties not between", value1, value2, "employeeDuties");
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

        public Criteria andWeixinOpenidIsNull() {
            addCriterion("weixin_openid is null");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenidIsNotNull() {
            addCriterion("weixin_openid is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenidEqualTo(String value) {
            addCriterion("weixin_openid =", value, "weixinOpenid");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenidNotEqualTo(String value) {
            addCriterion("weixin_openid <>", value, "weixinOpenid");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenidGreaterThan(String value) {
            addCriterion("weixin_openid >", value, "weixinOpenid");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_openid >=", value, "weixinOpenid");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenidLessThan(String value) {
            addCriterion("weixin_openid <", value, "weixinOpenid");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenidLessThanOrEqualTo(String value) {
            addCriterion("weixin_openid <=", value, "weixinOpenid");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenidLike(String value) {
            addCriterion("weixin_openid like", value, "weixinOpenid");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenidNotLike(String value) {
            addCriterion("weixin_openid not like", value, "weixinOpenid");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenidIn(List<String> values) {
            addCriterion("weixin_openid in", values, "weixinOpenid");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenidNotIn(List<String> values) {
            addCriterion("weixin_openid not in", values, "weixinOpenid");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenidBetween(String value1, String value2) {
            addCriterion("weixin_openid between", value1, value2, "weixinOpenid");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenidNotBetween(String value1, String value2) {
            addCriterion("weixin_openid not between", value1, value2, "weixinOpenid");
            return (Criteria) this;
        }

        public Criteria andWechatAccountIsNull() {
            addCriterion("wechat_account is null");
            return (Criteria) this;
        }

        public Criteria andWechatAccountIsNotNull() {
            addCriterion("wechat_account is not null");
            return (Criteria) this;
        }

        public Criteria andWechatAccountEqualTo(String value) {
            addCriterion("wechat_account =", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountNotEqualTo(String value) {
            addCriterion("wechat_account <>", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountGreaterThan(String value) {
            addCriterion("wechat_account >", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_account >=", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountLessThan(String value) {
            addCriterion("wechat_account <", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountLessThanOrEqualTo(String value) {
            addCriterion("wechat_account <=", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountLike(String value) {
            addCriterion("wechat_account like", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountNotLike(String value) {
            addCriterion("wechat_account not like", value, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountIn(List<String> values) {
            addCriterion("wechat_account in", values, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountNotIn(List<String> values) {
            addCriterion("wechat_account not in", values, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountBetween(String value1, String value2) {
            addCriterion("wechat_account between", value1, value2, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andWechatAccountNotBetween(String value1, String value2) {
            addCriterion("wechat_account not between", value1, value2, "wechatAccount");
            return (Criteria) this;
        }

        public Criteria andUsedNameIsNull() {
            addCriterion("used_name is null");
            return (Criteria) this;
        }

        public Criteria andUsedNameIsNotNull() {
            addCriterion("used_name is not null");
            return (Criteria) this;
        }

        public Criteria andUsedNameEqualTo(String value) {
            addCriterion("used_name =", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameNotEqualTo(String value) {
            addCriterion("used_name <>", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameGreaterThan(String value) {
            addCriterion("used_name >", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameGreaterThanOrEqualTo(String value) {
            addCriterion("used_name >=", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameLessThan(String value) {
            addCriterion("used_name <", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameLessThanOrEqualTo(String value) {
            addCriterion("used_name <=", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameLike(String value) {
            addCriterion("used_name like", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameNotLike(String value) {
            addCriterion("used_name not like", value, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameIn(List<String> values) {
            addCriterion("used_name in", values, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameNotIn(List<String> values) {
            addCriterion("used_name not in", values, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameBetween(String value1, String value2) {
            addCriterion("used_name between", value1, value2, "usedName");
            return (Criteria) this;
        }

        public Criteria andUsedNameNotBetween(String value1, String value2) {
            addCriterion("used_name not between", value1, value2, "usedName");
            return (Criteria) this;
        }

        public Criteria andNameSpellingIsNull() {
            addCriterion("name_spelling is null");
            return (Criteria) this;
        }

        public Criteria andNameSpellingIsNotNull() {
            addCriterion("name_spelling is not null");
            return (Criteria) this;
        }

        public Criteria andNameSpellingEqualTo(String value) {
            addCriterion("name_spelling =", value, "nameSpelling");
            return (Criteria) this;
        }

        public Criteria andNameSpellingNotEqualTo(String value) {
            addCriterion("name_spelling <>", value, "nameSpelling");
            return (Criteria) this;
        }

        public Criteria andNameSpellingGreaterThan(String value) {
            addCriterion("name_spelling >", value, "nameSpelling");
            return (Criteria) this;
        }

        public Criteria andNameSpellingGreaterThanOrEqualTo(String value) {
            addCriterion("name_spelling >=", value, "nameSpelling");
            return (Criteria) this;
        }

        public Criteria andNameSpellingLessThan(String value) {
            addCriterion("name_spelling <", value, "nameSpelling");
            return (Criteria) this;
        }

        public Criteria andNameSpellingLessThanOrEqualTo(String value) {
            addCriterion("name_spelling <=", value, "nameSpelling");
            return (Criteria) this;
        }

        public Criteria andNameSpellingLike(String value) {
            addCriterion("name_spelling like", value, "nameSpelling");
            return (Criteria) this;
        }

        public Criteria andNameSpellingNotLike(String value) {
            addCriterion("name_spelling not like", value, "nameSpelling");
            return (Criteria) this;
        }

        public Criteria andNameSpellingIn(List<String> values) {
            addCriterion("name_spelling in", values, "nameSpelling");
            return (Criteria) this;
        }

        public Criteria andNameSpellingNotIn(List<String> values) {
            addCriterion("name_spelling not in", values, "nameSpelling");
            return (Criteria) this;
        }

        public Criteria andNameSpellingBetween(String value1, String value2) {
            addCriterion("name_spelling between", value1, value2, "nameSpelling");
            return (Criteria) this;
        }

        public Criteria andNameSpellingNotBetween(String value1, String value2) {
            addCriterion("name_spelling not between", value1, value2, "nameSpelling");
            return (Criteria) this;
        }

        public Criteria andAccountNumberIsNull() {
            addCriterion("account_number is null");
            return (Criteria) this;
        }

        public Criteria andAccountNumberIsNotNull() {
            addCriterion("account_number is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNumberEqualTo(String value) {
            addCriterion("account_number =", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNotEqualTo(String value) {
            addCriterion("account_number <>", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberGreaterThan(String value) {
            addCriterion("account_number >", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberGreaterThanOrEqualTo(String value) {
            addCriterion("account_number >=", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberLessThan(String value) {
            addCriterion("account_number <", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberLessThanOrEqualTo(String value) {
            addCriterion("account_number <=", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberLike(String value) {
            addCriterion("account_number like", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNotLike(String value) {
            addCriterion("account_number not like", value, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberIn(List<String> values) {
            addCriterion("account_number in", values, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNotIn(List<String> values) {
            addCriterion("account_number not in", values, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberBetween(String value1, String value2) {
            addCriterion("account_number between", value1, value2, "accountNumber");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNotBetween(String value1, String value2) {
            addCriterion("account_number not between", value1, value2, "accountNumber");
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

        public Criteria andMaritalStatusIsNull() {
            addCriterion("marital_status is null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNotNull() {
            addCriterion("marital_status is not null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusEqualTo(String value) {
            addCriterion("marital_status =", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotEqualTo(String value) {
            addCriterion("marital_status <>", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThan(String value) {
            addCriterion("marital_status >", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("marital_status >=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThan(String value) {
            addCriterion("marital_status <", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThanOrEqualTo(String value) {
            addCriterion("marital_status <=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLike(String value) {
            addCriterion("marital_status like", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotLike(String value) {
            addCriterion("marital_status not like", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIn(List<String> values) {
            addCriterion("marital_status in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotIn(List<String> values) {
            addCriterion("marital_status not in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusBetween(String value1, String value2) {
            addCriterion("marital_status between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotBetween(String value1, String value2) {
            addCriterion("marital_status not between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationPlaceIsNull() {
            addCriterion("nation_place is null");
            return (Criteria) this;
        }

        public Criteria andNationPlaceIsNotNull() {
            addCriterion("nation_place is not null");
            return (Criteria) this;
        }

        public Criteria andNationPlaceEqualTo(String value) {
            addCriterion("nation_place =", value, "nationPlace");
            return (Criteria) this;
        }

        public Criteria andNationPlaceNotEqualTo(String value) {
            addCriterion("nation_place <>", value, "nationPlace");
            return (Criteria) this;
        }

        public Criteria andNationPlaceGreaterThan(String value) {
            addCriterion("nation_place >", value, "nationPlace");
            return (Criteria) this;
        }

        public Criteria andNationPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("nation_place >=", value, "nationPlace");
            return (Criteria) this;
        }

        public Criteria andNationPlaceLessThan(String value) {
            addCriterion("nation_place <", value, "nationPlace");
            return (Criteria) this;
        }

        public Criteria andNationPlaceLessThanOrEqualTo(String value) {
            addCriterion("nation_place <=", value, "nationPlace");
            return (Criteria) this;
        }

        public Criteria andNationPlaceLike(String value) {
            addCriterion("nation_place like", value, "nationPlace");
            return (Criteria) this;
        }

        public Criteria andNationPlaceNotLike(String value) {
            addCriterion("nation_place not like", value, "nationPlace");
            return (Criteria) this;
        }

        public Criteria andNationPlaceIn(List<String> values) {
            addCriterion("nation_place in", values, "nationPlace");
            return (Criteria) this;
        }

        public Criteria andNationPlaceNotIn(List<String> values) {
            addCriterion("nation_place not in", values, "nationPlace");
            return (Criteria) this;
        }

        public Criteria andNationPlaceBetween(String value1, String value2) {
            addCriterion("nation_place between", value1, value2, "nationPlace");
            return (Criteria) this;
        }

        public Criteria andNationPlaceNotBetween(String value1, String value2) {
            addCriterion("nation_place not between", value1, value2, "nationPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIsNull() {
            addCriterion("birth_place is null");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIsNotNull() {
            addCriterion("birth_place is not null");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceEqualTo(String value) {
            addCriterion("birth_place =", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotEqualTo(String value) {
            addCriterion("birth_place <>", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceGreaterThan(String value) {
            addCriterion("birth_place >", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("birth_place >=", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLessThan(String value) {
            addCriterion("birth_place <", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLessThanOrEqualTo(String value) {
            addCriterion("birth_place <=", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLike(String value) {
            addCriterion("birth_place like", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotLike(String value) {
            addCriterion("birth_place not like", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIn(List<String> values) {
            addCriterion("birth_place in", values, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotIn(List<String> values) {
            addCriterion("birth_place not in", values, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceBetween(String value1, String value2) {
            addCriterion("birth_place between", value1, value2, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotBetween(String value1, String value2) {
            addCriterion("birth_place not between", value1, value2, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIsNull() {
            addCriterion("home_address is null");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIsNotNull() {
            addCriterion("home_address is not null");
            return (Criteria) this;
        }

        public Criteria andHomeAddressEqualTo(String value) {
            addCriterion("home_address =", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotEqualTo(String value) {
            addCriterion("home_address <>", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThan(String value) {
            addCriterion("home_address >", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("home_address >=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThan(String value) {
            addCriterion("home_address <", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThanOrEqualTo(String value) {
            addCriterion("home_address <=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLike(String value) {
            addCriterion("home_address like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotLike(String value) {
            addCriterion("home_address not like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIn(List<String> values) {
            addCriterion("home_address in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotIn(List<String> values) {
            addCriterion("home_address not in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressBetween(String value1, String value2) {
            addCriterion("home_address between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotBetween(String value1, String value2) {
            addCriterion("home_address not between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andBodyStatusIsNull() {
            addCriterion("body_status is null");
            return (Criteria) this;
        }

        public Criteria andBodyStatusIsNotNull() {
            addCriterion("body_status is not null");
            return (Criteria) this;
        }

        public Criteria andBodyStatusEqualTo(String value) {
            addCriterion("body_status =", value, "bodyStatus");
            return (Criteria) this;
        }

        public Criteria andBodyStatusNotEqualTo(String value) {
            addCriterion("body_status <>", value, "bodyStatus");
            return (Criteria) this;
        }

        public Criteria andBodyStatusGreaterThan(String value) {
            addCriterion("body_status >", value, "bodyStatus");
            return (Criteria) this;
        }

        public Criteria andBodyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("body_status >=", value, "bodyStatus");
            return (Criteria) this;
        }

        public Criteria andBodyStatusLessThan(String value) {
            addCriterion("body_status <", value, "bodyStatus");
            return (Criteria) this;
        }

        public Criteria andBodyStatusLessThanOrEqualTo(String value) {
            addCriterion("body_status <=", value, "bodyStatus");
            return (Criteria) this;
        }

        public Criteria andBodyStatusLike(String value) {
            addCriterion("body_status like", value, "bodyStatus");
            return (Criteria) this;
        }

        public Criteria andBodyStatusNotLike(String value) {
            addCriterion("body_status not like", value, "bodyStatus");
            return (Criteria) this;
        }

        public Criteria andBodyStatusIn(List<String> values) {
            addCriterion("body_status in", values, "bodyStatus");
            return (Criteria) this;
        }

        public Criteria andBodyStatusNotIn(List<String> values) {
            addCriterion("body_status not in", values, "bodyStatus");
            return (Criteria) this;
        }

        public Criteria andBodyStatusBetween(String value1, String value2) {
            addCriterion("body_status between", value1, value2, "bodyStatus");
            return (Criteria) this;
        }

        public Criteria andBodyStatusNotBetween(String value1, String value2) {
            addCriterion("body_status not between", value1, value2, "bodyStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticStatusIsNull() {
            addCriterion("politic_Status is null");
            return (Criteria) this;
        }

        public Criteria andPoliticStatusIsNotNull() {
            addCriterion("politic_Status is not null");
            return (Criteria) this;
        }

        public Criteria andPoliticStatusEqualTo(String value) {
            addCriterion("politic_Status =", value, "politicStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticStatusNotEqualTo(String value) {
            addCriterion("politic_Status <>", value, "politicStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticStatusGreaterThan(String value) {
            addCriterion("politic_Status >", value, "politicStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticStatusGreaterThanOrEqualTo(String value) {
            addCriterion("politic_Status >=", value, "politicStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticStatusLessThan(String value) {
            addCriterion("politic_Status <", value, "politicStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticStatusLessThanOrEqualTo(String value) {
            addCriterion("politic_Status <=", value, "politicStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticStatusLike(String value) {
            addCriterion("politic_Status like", value, "politicStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticStatusNotLike(String value) {
            addCriterion("politic_Status not like", value, "politicStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticStatusIn(List<String> values) {
            addCriterion("politic_Status in", values, "politicStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticStatusNotIn(List<String> values) {
            addCriterion("politic_Status not in", values, "politicStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticStatusBetween(String value1, String value2) {
            addCriterion("politic_Status between", value1, value2, "politicStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticStatusNotBetween(String value1, String value2) {
            addCriterion("politic_Status not between", value1, value2, "politicStatus");
            return (Criteria) this;
        }

        public Criteria andJoinPartyTimeIsNull() {
            addCriterion("join_party_time is null");
            return (Criteria) this;
        }

        public Criteria andJoinPartyTimeIsNotNull() {
            addCriterion("join_party_time is not null");
            return (Criteria) this;
        }

        public Criteria andJoinPartyTimeEqualTo(Date value) {
            addCriterion("join_party_time =", value, "joinPartyTime");
            return (Criteria) this;
        }

        public Criteria andJoinPartyTimeNotEqualTo(Date value) {
            addCriterion("join_party_time <>", value, "joinPartyTime");
            return (Criteria) this;
        }

        public Criteria andJoinPartyTimeGreaterThan(Date value) {
            addCriterion("join_party_time >", value, "joinPartyTime");
            return (Criteria) this;
        }

        public Criteria andJoinPartyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("join_party_time >=", value, "joinPartyTime");
            return (Criteria) this;
        }

        public Criteria andJoinPartyTimeLessThan(Date value) {
            addCriterion("join_party_time <", value, "joinPartyTime");
            return (Criteria) this;
        }

        public Criteria andJoinPartyTimeLessThanOrEqualTo(Date value) {
            addCriterion("join_party_time <=", value, "joinPartyTime");
            return (Criteria) this;
        }

        public Criteria andJoinPartyTimeIn(List<Date> values) {
            addCriterion("join_party_time in", values, "joinPartyTime");
            return (Criteria) this;
        }

        public Criteria andJoinPartyTimeNotIn(List<Date> values) {
            addCriterion("join_party_time not in", values, "joinPartyTime");
            return (Criteria) this;
        }

        public Criteria andJoinPartyTimeBetween(Date value1, Date value2) {
            addCriterion("join_party_time between", value1, value2, "joinPartyTime");
            return (Criteria) this;
        }

        public Criteria andJoinPartyTimeNotBetween(Date value1, Date value2) {
            addCriterion("join_party_time not between", value1, value2, "joinPartyTime");
            return (Criteria) this;
        }

        public Criteria andJoinWorkingTimeIsNull() {
            addCriterion("join_working_time is null");
            return (Criteria) this;
        }

        public Criteria andJoinWorkingTimeIsNotNull() {
            addCriterion("join_working_time is not null");
            return (Criteria) this;
        }

        public Criteria andJoinWorkingTimeEqualTo(Date value) {
            addCriterion("join_working_time =", value, "joinWorkingTime");
            return (Criteria) this;
        }

        public Criteria andJoinWorkingTimeNotEqualTo(Date value) {
            addCriterion("join_working_time <>", value, "joinWorkingTime");
            return (Criteria) this;
        }

        public Criteria andJoinWorkingTimeGreaterThan(Date value) {
            addCriterion("join_working_time >", value, "joinWorkingTime");
            return (Criteria) this;
        }

        public Criteria andJoinWorkingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("join_working_time >=", value, "joinWorkingTime");
            return (Criteria) this;
        }

        public Criteria andJoinWorkingTimeLessThan(Date value) {
            addCriterion("join_working_time <", value, "joinWorkingTime");
            return (Criteria) this;
        }

        public Criteria andJoinWorkingTimeLessThanOrEqualTo(Date value) {
            addCriterion("join_working_time <=", value, "joinWorkingTime");
            return (Criteria) this;
        }

        public Criteria andJoinWorkingTimeIn(List<Date> values) {
            addCriterion("join_working_time in", values, "joinWorkingTime");
            return (Criteria) this;
        }

        public Criteria andJoinWorkingTimeNotIn(List<Date> values) {
            addCriterion("join_working_time not in", values, "joinWorkingTime");
            return (Criteria) this;
        }

        public Criteria andJoinWorkingTimeBetween(Date value1, Date value2) {
            addCriterion("join_working_time between", value1, value2, "joinWorkingTime");
            return (Criteria) this;
        }

        public Criteria andJoinWorkingTimeNotBetween(Date value1, Date value2) {
            addCriterion("join_working_time not between", value1, value2, "joinWorkingTime");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTimeIsNull() {
            addCriterion("join_unit_time is null");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTimeIsNotNull() {
            addCriterion("join_unit_time is not null");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTimeEqualTo(Date value) {
            addCriterion("join_unit_time =", value, "joinUnitTime");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTimeNotEqualTo(Date value) {
            addCriterion("join_unit_time <>", value, "joinUnitTime");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTimeGreaterThan(Date value) {
            addCriterion("join_unit_time >", value, "joinUnitTime");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("join_unit_time >=", value, "joinUnitTime");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTimeLessThan(Date value) {
            addCriterion("join_unit_time <", value, "joinUnitTime");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTimeLessThanOrEqualTo(Date value) {
            addCriterion("join_unit_time <=", value, "joinUnitTime");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTimeIn(List<Date> values) {
            addCriterion("join_unit_time in", values, "joinUnitTime");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTimeNotIn(List<Date> values) {
            addCriterion("join_unit_time not in", values, "joinUnitTime");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTimeBetween(Date value1, Date value2) {
            addCriterion("join_unit_time between", value1, value2, "joinUnitTime");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTimeNotBetween(Date value1, Date value2) {
            addCriterion("join_unit_time not between", value1, value2, "joinUnitTime");
            return (Criteria) this;
        }

        public Criteria andTopEducationIsNull() {
            addCriterion("top_education is null");
            return (Criteria) this;
        }

        public Criteria andTopEducationIsNotNull() {
            addCriterion("top_education is not null");
            return (Criteria) this;
        }

        public Criteria andTopEducationEqualTo(String value) {
            addCriterion("top_education =", value, "topEducation");
            return (Criteria) this;
        }

        public Criteria andTopEducationNotEqualTo(String value) {
            addCriterion("top_education <>", value, "topEducation");
            return (Criteria) this;
        }

        public Criteria andTopEducationGreaterThan(String value) {
            addCriterion("top_education >", value, "topEducation");
            return (Criteria) this;
        }

        public Criteria andTopEducationGreaterThanOrEqualTo(String value) {
            addCriterion("top_education >=", value, "topEducation");
            return (Criteria) this;
        }

        public Criteria andTopEducationLessThan(String value) {
            addCriterion("top_education <", value, "topEducation");
            return (Criteria) this;
        }

        public Criteria andTopEducationLessThanOrEqualTo(String value) {
            addCriterion("top_education <=", value, "topEducation");
            return (Criteria) this;
        }

        public Criteria andTopEducationLike(String value) {
            addCriterion("top_education like", value, "topEducation");
            return (Criteria) this;
        }

        public Criteria andTopEducationNotLike(String value) {
            addCriterion("top_education not like", value, "topEducation");
            return (Criteria) this;
        }

        public Criteria andTopEducationIn(List<String> values) {
            addCriterion("top_education in", values, "topEducation");
            return (Criteria) this;
        }

        public Criteria andTopEducationNotIn(List<String> values) {
            addCriterion("top_education not in", values, "topEducation");
            return (Criteria) this;
        }

        public Criteria andTopEducationBetween(String value1, String value2) {
            addCriterion("top_education between", value1, value2, "topEducation");
            return (Criteria) this;
        }

        public Criteria andTopEducationNotBetween(String value1, String value2) {
            addCriterion("top_education not between", value1, value2, "topEducation");
            return (Criteria) this;
        }

        public Criteria andTopDiplomaIsNull() {
            addCriterion("top_diploma is null");
            return (Criteria) this;
        }

        public Criteria andTopDiplomaIsNotNull() {
            addCriterion("top_diploma is not null");
            return (Criteria) this;
        }

        public Criteria andTopDiplomaEqualTo(String value) {
            addCriterion("top_diploma =", value, "topDiploma");
            return (Criteria) this;
        }

        public Criteria andTopDiplomaNotEqualTo(String value) {
            addCriterion("top_diploma <>", value, "topDiploma");
            return (Criteria) this;
        }

        public Criteria andTopDiplomaGreaterThan(String value) {
            addCriterion("top_diploma >", value, "topDiploma");
            return (Criteria) this;
        }

        public Criteria andTopDiplomaGreaterThanOrEqualTo(String value) {
            addCriterion("top_diploma >=", value, "topDiploma");
            return (Criteria) this;
        }

        public Criteria andTopDiplomaLessThan(String value) {
            addCriterion("top_diploma <", value, "topDiploma");
            return (Criteria) this;
        }

        public Criteria andTopDiplomaLessThanOrEqualTo(String value) {
            addCriterion("top_diploma <=", value, "topDiploma");
            return (Criteria) this;
        }

        public Criteria andTopDiplomaLike(String value) {
            addCriterion("top_diploma like", value, "topDiploma");
            return (Criteria) this;
        }

        public Criteria andTopDiplomaNotLike(String value) {
            addCriterion("top_diploma not like", value, "topDiploma");
            return (Criteria) this;
        }

        public Criteria andTopDiplomaIn(List<String> values) {
            addCriterion("top_diploma in", values, "topDiploma");
            return (Criteria) this;
        }

        public Criteria andTopDiplomaNotIn(List<String> values) {
            addCriterion("top_diploma not in", values, "topDiploma");
            return (Criteria) this;
        }

        public Criteria andTopDiplomaBetween(String value1, String value2) {
            addCriterion("top_diploma between", value1, value2, "topDiploma");
            return (Criteria) this;
        }

        public Criteria andTopDiplomaNotBetween(String value1, String value2) {
            addCriterion("top_diploma not between", value1, value2, "topDiploma");
            return (Criteria) this;
        }

        public Criteria andNowPostNameIsNull() {
            addCriterion("now_post_name is null");
            return (Criteria) this;
        }

        public Criteria andNowPostNameIsNotNull() {
            addCriterion("now_post_name is not null");
            return (Criteria) this;
        }

        public Criteria andNowPostNameEqualTo(String value) {
            addCriterion("now_post_name =", value, "nowPostName");
            return (Criteria) this;
        }

        public Criteria andNowPostNameNotEqualTo(String value) {
            addCriterion("now_post_name <>", value, "nowPostName");
            return (Criteria) this;
        }

        public Criteria andNowPostNameGreaterThan(String value) {
            addCriterion("now_post_name >", value, "nowPostName");
            return (Criteria) this;
        }

        public Criteria andNowPostNameGreaterThanOrEqualTo(String value) {
            addCriterion("now_post_name >=", value, "nowPostName");
            return (Criteria) this;
        }

        public Criteria andNowPostNameLessThan(String value) {
            addCriterion("now_post_name <", value, "nowPostName");
            return (Criteria) this;
        }

        public Criteria andNowPostNameLessThanOrEqualTo(String value) {
            addCriterion("now_post_name <=", value, "nowPostName");
            return (Criteria) this;
        }

        public Criteria andNowPostNameLike(String value) {
            addCriterion("now_post_name like", value, "nowPostName");
            return (Criteria) this;
        }

        public Criteria andNowPostNameNotLike(String value) {
            addCriterion("now_post_name not like", value, "nowPostName");
            return (Criteria) this;
        }

        public Criteria andNowPostNameIn(List<String> values) {
            addCriterion("now_post_name in", values, "nowPostName");
            return (Criteria) this;
        }

        public Criteria andNowPostNameNotIn(List<String> values) {
            addCriterion("now_post_name not in", values, "nowPostName");
            return (Criteria) this;
        }

        public Criteria andNowPostNameBetween(String value1, String value2) {
            addCriterion("now_post_name between", value1, value2, "nowPostName");
            return (Criteria) this;
        }

        public Criteria andNowPostNameNotBetween(String value1, String value2) {
            addCriterion("now_post_name not between", value1, value2, "nowPostName");
            return (Criteria) this;
        }

        public Criteria andBeginPostTimeIsNull() {
            addCriterion("begin_post_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginPostTimeIsNotNull() {
            addCriterion("begin_post_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginPostTimeEqualTo(Date value) {
            addCriterion("begin_post_time =", value, "beginPostTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostTimeNotEqualTo(Date value) {
            addCriterion("begin_post_time <>", value, "beginPostTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostTimeGreaterThan(Date value) {
            addCriterion("begin_post_time >", value, "beginPostTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_post_time >=", value, "beginPostTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostTimeLessThan(Date value) {
            addCriterion("begin_post_time <", value, "beginPostTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_post_time <=", value, "beginPostTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostTimeIn(List<Date> values) {
            addCriterion("begin_post_time in", values, "beginPostTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostTimeNotIn(List<Date> values) {
            addCriterion("begin_post_time not in", values, "beginPostTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostTimeBetween(Date value1, Date value2) {
            addCriterion("begin_post_time between", value1, value2, "beginPostTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_post_time not between", value1, value2, "beginPostTime");
            return (Criteria) this;
        }

        public Criteria andNowPostLevelIsNull() {
            addCriterion("now_post_level is null");
            return (Criteria) this;
        }

        public Criteria andNowPostLevelIsNotNull() {
            addCriterion("now_post_level is not null");
            return (Criteria) this;
        }

        public Criteria andNowPostLevelEqualTo(String value) {
            addCriterion("now_post_level =", value, "nowPostLevel");
            return (Criteria) this;
        }

        public Criteria andNowPostLevelNotEqualTo(String value) {
            addCriterion("now_post_level <>", value, "nowPostLevel");
            return (Criteria) this;
        }

        public Criteria andNowPostLevelGreaterThan(String value) {
            addCriterion("now_post_level >", value, "nowPostLevel");
            return (Criteria) this;
        }

        public Criteria andNowPostLevelGreaterThanOrEqualTo(String value) {
            addCriterion("now_post_level >=", value, "nowPostLevel");
            return (Criteria) this;
        }

        public Criteria andNowPostLevelLessThan(String value) {
            addCriterion("now_post_level <", value, "nowPostLevel");
            return (Criteria) this;
        }

        public Criteria andNowPostLevelLessThanOrEqualTo(String value) {
            addCriterion("now_post_level <=", value, "nowPostLevel");
            return (Criteria) this;
        }

        public Criteria andNowPostLevelLike(String value) {
            addCriterion("now_post_level like", value, "nowPostLevel");
            return (Criteria) this;
        }

        public Criteria andNowPostLevelNotLike(String value) {
            addCriterion("now_post_level not like", value, "nowPostLevel");
            return (Criteria) this;
        }

        public Criteria andNowPostLevelIn(List<String> values) {
            addCriterion("now_post_level in", values, "nowPostLevel");
            return (Criteria) this;
        }

        public Criteria andNowPostLevelNotIn(List<String> values) {
            addCriterion("now_post_level not in", values, "nowPostLevel");
            return (Criteria) this;
        }

        public Criteria andNowPostLevelBetween(String value1, String value2) {
            addCriterion("now_post_level between", value1, value2, "nowPostLevel");
            return (Criteria) this;
        }

        public Criteria andNowPostLevelNotBetween(String value1, String value2) {
            addCriterion("now_post_level not between", value1, value2, "nowPostLevel");
            return (Criteria) this;
        }

        public Criteria andBeginPostLevelTimeIsNull() {
            addCriterion("begin_post_level_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginPostLevelTimeIsNotNull() {
            addCriterion("begin_post_level_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginPostLevelTimeEqualTo(String value) {
            addCriterion("begin_post_level_time =", value, "beginPostLevelTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostLevelTimeNotEqualTo(String value) {
            addCriterion("begin_post_level_time <>", value, "beginPostLevelTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostLevelTimeGreaterThan(String value) {
            addCriterion("begin_post_level_time >", value, "beginPostLevelTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostLevelTimeGreaterThanOrEqualTo(String value) {
            addCriterion("begin_post_level_time >=", value, "beginPostLevelTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostLevelTimeLessThan(String value) {
            addCriterion("begin_post_level_time <", value, "beginPostLevelTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostLevelTimeLessThanOrEqualTo(String value) {
            addCriterion("begin_post_level_time <=", value, "beginPostLevelTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostLevelTimeLike(String value) {
            addCriterion("begin_post_level_time like", value, "beginPostLevelTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostLevelTimeNotLike(String value) {
            addCriterion("begin_post_level_time not like", value, "beginPostLevelTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostLevelTimeIn(List<String> values) {
            addCriterion("begin_post_level_time in", values, "beginPostLevelTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostLevelTimeNotIn(List<String> values) {
            addCriterion("begin_post_level_time not in", values, "beginPostLevelTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostLevelTimeBetween(String value1, String value2) {
            addCriterion("begin_post_level_time between", value1, value2, "beginPostLevelTime");
            return (Criteria) this;
        }

        public Criteria andBeginPostLevelTimeNotBetween(String value1, String value2) {
            addCriterion("begin_post_level_time not between", value1, value2, "beginPostLevelTime");
            return (Criteria) this;
        }

        public Criteria andNowPostCategoryIsNull() {
            addCriterion("now_post_category is null");
            return (Criteria) this;
        }

        public Criteria andNowPostCategoryIsNotNull() {
            addCriterion("now_post_category is not null");
            return (Criteria) this;
        }

        public Criteria andNowPostCategoryEqualTo(String value) {
            addCriterion("now_post_category =", value, "nowPostCategory");
            return (Criteria) this;
        }

        public Criteria andNowPostCategoryNotEqualTo(String value) {
            addCriterion("now_post_category <>", value, "nowPostCategory");
            return (Criteria) this;
        }

        public Criteria andNowPostCategoryGreaterThan(String value) {
            addCriterion("now_post_category >", value, "nowPostCategory");
            return (Criteria) this;
        }

        public Criteria andNowPostCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("now_post_category >=", value, "nowPostCategory");
            return (Criteria) this;
        }

        public Criteria andNowPostCategoryLessThan(String value) {
            addCriterion("now_post_category <", value, "nowPostCategory");
            return (Criteria) this;
        }

        public Criteria andNowPostCategoryLessThanOrEqualTo(String value) {
            addCriterion("now_post_category <=", value, "nowPostCategory");
            return (Criteria) this;
        }

        public Criteria andNowPostCategoryLike(String value) {
            addCriterion("now_post_category like", value, "nowPostCategory");
            return (Criteria) this;
        }

        public Criteria andNowPostCategoryNotLike(String value) {
            addCriterion("now_post_category not like", value, "nowPostCategory");
            return (Criteria) this;
        }

        public Criteria andNowPostCategoryIn(List<String> values) {
            addCriterion("now_post_category in", values, "nowPostCategory");
            return (Criteria) this;
        }

        public Criteria andNowPostCategoryNotIn(List<String> values) {
            addCriterion("now_post_category not in", values, "nowPostCategory");
            return (Criteria) this;
        }

        public Criteria andNowPostCategoryBetween(String value1, String value2) {
            addCriterion("now_post_category between", value1, value2, "nowPostCategory");
            return (Criteria) this;
        }

        public Criteria andNowPostCategoryNotBetween(String value1, String value2) {
            addCriterion("now_post_category not between", value1, value2, "nowPostCategory");
            return (Criteria) this;
        }

        public Criteria andEmployeeCategoryIsNull() {
            addCriterion("employee_category is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeCategoryIsNotNull() {
            addCriterion("employee_category is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeCategoryEqualTo(String value) {
            addCriterion("employee_category =", value, "employeeCategory");
            return (Criteria) this;
        }

        public Criteria andEmployeeCategoryNotEqualTo(String value) {
            addCriterion("employee_category <>", value, "employeeCategory");
            return (Criteria) this;
        }

        public Criteria andEmployeeCategoryGreaterThan(String value) {
            addCriterion("employee_category >", value, "employeeCategory");
            return (Criteria) this;
        }

        public Criteria andEmployeeCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("employee_category >=", value, "employeeCategory");
            return (Criteria) this;
        }

        public Criteria andEmployeeCategoryLessThan(String value) {
            addCriterion("employee_category <", value, "employeeCategory");
            return (Criteria) this;
        }

        public Criteria andEmployeeCategoryLessThanOrEqualTo(String value) {
            addCriterion("employee_category <=", value, "employeeCategory");
            return (Criteria) this;
        }

        public Criteria andEmployeeCategoryLike(String value) {
            addCriterion("employee_category like", value, "employeeCategory");
            return (Criteria) this;
        }

        public Criteria andEmployeeCategoryNotLike(String value) {
            addCriterion("employee_category not like", value, "employeeCategory");
            return (Criteria) this;
        }

        public Criteria andEmployeeCategoryIn(List<String> values) {
            addCriterion("employee_category in", values, "employeeCategory");
            return (Criteria) this;
        }

        public Criteria andEmployeeCategoryNotIn(List<String> values) {
            addCriterion("employee_category not in", values, "employeeCategory");
            return (Criteria) this;
        }

        public Criteria andEmployeeCategoryBetween(String value1, String value2) {
            addCriterion("employee_category between", value1, value2, "employeeCategory");
            return (Criteria) this;
        }

        public Criteria andEmployeeCategoryNotBetween(String value1, String value2) {
            addCriterion("employee_category not between", value1, value2, "employeeCategory");
            return (Criteria) this;
        }

        public Criteria andAurhorizedPropertyIsNull() {
            addCriterion("aurhorized_property is null");
            return (Criteria) this;
        }

        public Criteria andAurhorizedPropertyIsNotNull() {
            addCriterion("aurhorized_property is not null");
            return (Criteria) this;
        }

        public Criteria andAurhorizedPropertyEqualTo(String value) {
            addCriterion("aurhorized_property =", value, "aurhorizedProperty");
            return (Criteria) this;
        }

        public Criteria andAurhorizedPropertyNotEqualTo(String value) {
            addCriterion("aurhorized_property <>", value, "aurhorizedProperty");
            return (Criteria) this;
        }

        public Criteria andAurhorizedPropertyGreaterThan(String value) {
            addCriterion("aurhorized_property >", value, "aurhorizedProperty");
            return (Criteria) this;
        }

        public Criteria andAurhorizedPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("aurhorized_property >=", value, "aurhorizedProperty");
            return (Criteria) this;
        }

        public Criteria andAurhorizedPropertyLessThan(String value) {
            addCriterion("aurhorized_property <", value, "aurhorizedProperty");
            return (Criteria) this;
        }

        public Criteria andAurhorizedPropertyLessThanOrEqualTo(String value) {
            addCriterion("aurhorized_property <=", value, "aurhorizedProperty");
            return (Criteria) this;
        }

        public Criteria andAurhorizedPropertyLike(String value) {
            addCriterion("aurhorized_property like", value, "aurhorizedProperty");
            return (Criteria) this;
        }

        public Criteria andAurhorizedPropertyNotLike(String value) {
            addCriterion("aurhorized_property not like", value, "aurhorizedProperty");
            return (Criteria) this;
        }

        public Criteria andAurhorizedPropertyIn(List<String> values) {
            addCriterion("aurhorized_property in", values, "aurhorizedProperty");
            return (Criteria) this;
        }

        public Criteria andAurhorizedPropertyNotIn(List<String> values) {
            addCriterion("aurhorized_property not in", values, "aurhorizedProperty");
            return (Criteria) this;
        }

        public Criteria andAurhorizedPropertyBetween(String value1, String value2) {
            addCriterion("aurhorized_property between", value1, value2, "aurhorizedProperty");
            return (Criteria) this;
        }

        public Criteria andAurhorizedPropertyNotBetween(String value1, String value2) {
            addCriterion("aurhorized_property not between", value1, value2, "aurhorizedProperty");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIsNull() {
            addCriterion("work_status is null");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIsNotNull() {
            addCriterion("work_status is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStatusEqualTo(String value) {
            addCriterion("work_status =", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotEqualTo(String value) {
            addCriterion("work_status <>", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusGreaterThan(String value) {
            addCriterion("work_status >", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusGreaterThanOrEqualTo(String value) {
            addCriterion("work_status >=", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLessThan(String value) {
            addCriterion("work_status <", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLessThanOrEqualTo(String value) {
            addCriterion("work_status <=", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLike(String value) {
            addCriterion("work_status like", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotLike(String value) {
            addCriterion("work_status not like", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIn(List<String> values) {
            addCriterion("work_status in", values, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotIn(List<String> values) {
            addCriterion("work_status not in", values, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusBetween(String value1, String value2) {
            addCriterion("work_status between", value1, value2, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotBetween(String value1, String value2) {
            addCriterion("work_status not between", value1, value2, "workStatus");
            return (Criteria) this;
        }

        public Criteria andJoinCivilServantTimeIsNull() {
            addCriterion("join_civil_servant_time is null");
            return (Criteria) this;
        }

        public Criteria andJoinCivilServantTimeIsNotNull() {
            addCriterion("join_civil_servant_time is not null");
            return (Criteria) this;
        }

        public Criteria andJoinCivilServantTimeEqualTo(Date value) {
            addCriterion("join_civil_servant_time =", value, "joinCivilServantTime");
            return (Criteria) this;
        }

        public Criteria andJoinCivilServantTimeNotEqualTo(Date value) {
            addCriterion("join_civil_servant_time <>", value, "joinCivilServantTime");
            return (Criteria) this;
        }

        public Criteria andJoinCivilServantTimeGreaterThan(Date value) {
            addCriterion("join_civil_servant_time >", value, "joinCivilServantTime");
            return (Criteria) this;
        }

        public Criteria andJoinCivilServantTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("join_civil_servant_time >=", value, "joinCivilServantTime");
            return (Criteria) this;
        }

        public Criteria andJoinCivilServantTimeLessThan(Date value) {
            addCriterion("join_civil_servant_time <", value, "joinCivilServantTime");
            return (Criteria) this;
        }

        public Criteria andJoinCivilServantTimeLessThanOrEqualTo(Date value) {
            addCriterion("join_civil_servant_time <=", value, "joinCivilServantTime");
            return (Criteria) this;
        }

        public Criteria andJoinCivilServantTimeIn(List<Date> values) {
            addCriterion("join_civil_servant_time in", values, "joinCivilServantTime");
            return (Criteria) this;
        }

        public Criteria andJoinCivilServantTimeNotIn(List<Date> values) {
            addCriterion("join_civil_servant_time not in", values, "joinCivilServantTime");
            return (Criteria) this;
        }

        public Criteria andJoinCivilServantTimeBetween(Date value1, Date value2) {
            addCriterion("join_civil_servant_time between", value1, value2, "joinCivilServantTime");
            return (Criteria) this;
        }

        public Criteria andJoinCivilServantTimeNotBetween(Date value1, Date value2) {
            addCriterion("join_civil_servant_time not between", value1, value2, "joinCivilServantTime");
            return (Criteria) this;
        }

        public Criteria andCivilServantRegisterTimeIsNull() {
            addCriterion("civil_servant_register_time is null");
            return (Criteria) this;
        }

        public Criteria andCivilServantRegisterTimeIsNotNull() {
            addCriterion("civil_servant_register_time is not null");
            return (Criteria) this;
        }

        public Criteria andCivilServantRegisterTimeEqualTo(Date value) {
            addCriterion("civil_servant_register_time =", value, "civilServantRegisterTime");
            return (Criteria) this;
        }

        public Criteria andCivilServantRegisterTimeNotEqualTo(Date value) {
            addCriterion("civil_servant_register_time <>", value, "civilServantRegisterTime");
            return (Criteria) this;
        }

        public Criteria andCivilServantRegisterTimeGreaterThan(Date value) {
            addCriterion("civil_servant_register_time >", value, "civilServantRegisterTime");
            return (Criteria) this;
        }

        public Criteria andCivilServantRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("civil_servant_register_time >=", value, "civilServantRegisterTime");
            return (Criteria) this;
        }

        public Criteria andCivilServantRegisterTimeLessThan(Date value) {
            addCriterion("civil_servant_register_time <", value, "civilServantRegisterTime");
            return (Criteria) this;
        }

        public Criteria andCivilServantRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("civil_servant_register_time <=", value, "civilServantRegisterTime");
            return (Criteria) this;
        }

        public Criteria andCivilServantRegisterTimeIn(List<Date> values) {
            addCriterion("civil_servant_register_time in", values, "civilServantRegisterTime");
            return (Criteria) this;
        }

        public Criteria andCivilServantRegisterTimeNotIn(List<Date> values) {
            addCriterion("civil_servant_register_time not in", values, "civilServantRegisterTime");
            return (Criteria) this;
        }

        public Criteria andCivilServantRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("civil_servant_register_time between", value1, value2, "civilServantRegisterTime");
            return (Criteria) this;
        }

        public Criteria andCivilServantRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("civil_servant_register_time not between", value1, value2, "civilServantRegisterTime");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTypeIsNull() {
            addCriterion("join_unit_type is null");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTypeIsNotNull() {
            addCriterion("join_unit_type is not null");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTypeEqualTo(String value) {
            addCriterion("join_unit_type =", value, "joinUnitType");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTypeNotEqualTo(String value) {
            addCriterion("join_unit_type <>", value, "joinUnitType");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTypeGreaterThan(String value) {
            addCriterion("join_unit_type >", value, "joinUnitType");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("join_unit_type >=", value, "joinUnitType");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTypeLessThan(String value) {
            addCriterion("join_unit_type <", value, "joinUnitType");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTypeLessThanOrEqualTo(String value) {
            addCriterion("join_unit_type <=", value, "joinUnitType");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTypeLike(String value) {
            addCriterion("join_unit_type like", value, "joinUnitType");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTypeNotLike(String value) {
            addCriterion("join_unit_type not like", value, "joinUnitType");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTypeIn(List<String> values) {
            addCriterion("join_unit_type in", values, "joinUnitType");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTypeNotIn(List<String> values) {
            addCriterion("join_unit_type not in", values, "joinUnitType");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTypeBetween(String value1, String value2) {
            addCriterion("join_unit_type between", value1, value2, "joinUnitType");
            return (Criteria) this;
        }

        public Criteria andJoinUnitTypeNotBetween(String value1, String value2) {
            addCriterion("join_unit_type not between", value1, value2, "joinUnitType");
            return (Criteria) this;
        }

        public Criteria andBaseWorkTimeIsNull() {
            addCriterion("base_work_time is null");
            return (Criteria) this;
        }

        public Criteria andBaseWorkTimeIsNotNull() {
            addCriterion("base_work_time is not null");
            return (Criteria) this;
        }

        public Criteria andBaseWorkTimeEqualTo(String value) {
            addCriterion("base_work_time =", value, "baseWorkTime");
            return (Criteria) this;
        }

        public Criteria andBaseWorkTimeNotEqualTo(String value) {
            addCriterion("base_work_time <>", value, "baseWorkTime");
            return (Criteria) this;
        }

        public Criteria andBaseWorkTimeGreaterThan(String value) {
            addCriterion("base_work_time >", value, "baseWorkTime");
            return (Criteria) this;
        }

        public Criteria andBaseWorkTimeGreaterThanOrEqualTo(String value) {
            addCriterion("base_work_time >=", value, "baseWorkTime");
            return (Criteria) this;
        }

        public Criteria andBaseWorkTimeLessThan(String value) {
            addCriterion("base_work_time <", value, "baseWorkTime");
            return (Criteria) this;
        }

        public Criteria andBaseWorkTimeLessThanOrEqualTo(String value) {
            addCriterion("base_work_time <=", value, "baseWorkTime");
            return (Criteria) this;
        }

        public Criteria andBaseWorkTimeLike(String value) {
            addCriterion("base_work_time like", value, "baseWorkTime");
            return (Criteria) this;
        }

        public Criteria andBaseWorkTimeNotLike(String value) {
            addCriterion("base_work_time not like", value, "baseWorkTime");
            return (Criteria) this;
        }

        public Criteria andBaseWorkTimeIn(List<String> values) {
            addCriterion("base_work_time in", values, "baseWorkTime");
            return (Criteria) this;
        }

        public Criteria andBaseWorkTimeNotIn(List<String> values) {
            addCriterion("base_work_time not in", values, "baseWorkTime");
            return (Criteria) this;
        }

        public Criteria andBaseWorkTimeBetween(String value1, String value2) {
            addCriterion("base_work_time between", value1, value2, "baseWorkTime");
            return (Criteria) this;
        }

        public Criteria andBaseWorkTimeNotBetween(String value1, String value2) {
            addCriterion("base_work_time not between", value1, value2, "baseWorkTime");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsIsNull() {
            addCriterion("working_years is null");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsIsNotNull() {
            addCriterion("working_years is not null");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsEqualTo(String value) {
            addCriterion("working_years =", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsNotEqualTo(String value) {
            addCriterion("working_years <>", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsGreaterThan(String value) {
            addCriterion("working_years >", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsGreaterThanOrEqualTo(String value) {
            addCriterion("working_years >=", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsLessThan(String value) {
            addCriterion("working_years <", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsLessThanOrEqualTo(String value) {
            addCriterion("working_years <=", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsLike(String value) {
            addCriterion("working_years like", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsNotLike(String value) {
            addCriterion("working_years not like", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsIn(List<String> values) {
            addCriterion("working_years in", values, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsNotIn(List<String> values) {
            addCriterion("working_years not in", values, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsBetween(String value1, String value2) {
            addCriterion("working_years between", value1, value2, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsNotBetween(String value1, String value2) {
            addCriterion("working_years not between", value1, value2, "workingYears");
            return (Criteria) this;
        }

        public Criteria andSpecialityIsNull() {
            addCriterion("speciality is null");
            return (Criteria) this;
        }

        public Criteria andSpecialityIsNotNull() {
            addCriterion("speciality is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialityEqualTo(String value) {
            addCriterion("speciality =", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotEqualTo(String value) {
            addCriterion("speciality <>", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityGreaterThan(String value) {
            addCriterion("speciality >", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityGreaterThanOrEqualTo(String value) {
            addCriterion("speciality >=", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityLessThan(String value) {
            addCriterion("speciality <", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityLessThanOrEqualTo(String value) {
            addCriterion("speciality <=", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityLike(String value) {
            addCriterion("speciality like", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotLike(String value) {
            addCriterion("speciality not like", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityIn(List<String> values) {
            addCriterion("speciality in", values, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotIn(List<String> values) {
            addCriterion("speciality not in", values, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityBetween(String value1, String value2) {
            addCriterion("speciality between", value1, value2, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotBetween(String value1, String value2) {
            addCriterion("speciality not between", value1, value2, "speciality");
            return (Criteria) this;
        }

        public Criteria andOtherDemandsIsNull() {
            addCriterion("other_demands is null");
            return (Criteria) this;
        }

        public Criteria andOtherDemandsIsNotNull() {
            addCriterion("other_demands is not null");
            return (Criteria) this;
        }

        public Criteria andOtherDemandsEqualTo(String value) {
            addCriterion("other_demands =", value, "otherDemands");
            return (Criteria) this;
        }

        public Criteria andOtherDemandsNotEqualTo(String value) {
            addCriterion("other_demands <>", value, "otherDemands");
            return (Criteria) this;
        }

        public Criteria andOtherDemandsGreaterThan(String value) {
            addCriterion("other_demands >", value, "otherDemands");
            return (Criteria) this;
        }

        public Criteria andOtherDemandsGreaterThanOrEqualTo(String value) {
            addCriterion("other_demands >=", value, "otherDemands");
            return (Criteria) this;
        }

        public Criteria andOtherDemandsLessThan(String value) {
            addCriterion("other_demands <", value, "otherDemands");
            return (Criteria) this;
        }

        public Criteria andOtherDemandsLessThanOrEqualTo(String value) {
            addCriterion("other_demands <=", value, "otherDemands");
            return (Criteria) this;
        }

        public Criteria andOtherDemandsLike(String value) {
            addCriterion("other_demands like", value, "otherDemands");
            return (Criteria) this;
        }

        public Criteria andOtherDemandsNotLike(String value) {
            addCriterion("other_demands not like", value, "otherDemands");
            return (Criteria) this;
        }

        public Criteria andOtherDemandsIn(List<String> values) {
            addCriterion("other_demands in", values, "otherDemands");
            return (Criteria) this;
        }

        public Criteria andOtherDemandsNotIn(List<String> values) {
            addCriterion("other_demands not in", values, "otherDemands");
            return (Criteria) this;
        }

        public Criteria andOtherDemandsBetween(String value1, String value2) {
            addCriterion("other_demands between", value1, value2, "otherDemands");
            return (Criteria) this;
        }

        public Criteria andOtherDemandsNotBetween(String value1, String value2) {
            addCriterion("other_demands not between", value1, value2, "otherDemands");
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

        public Criteria andWechatIdIsNull() {
            addCriterion("wechat_id is null");
            return (Criteria) this;
        }

        public Criteria andWechatIdIsNotNull() {
            addCriterion("wechat_id is not null");
            return (Criteria) this;
        }

        public Criteria andWechatIdEqualTo(String value) {
            addCriterion("wechat_id =", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdNotEqualTo(String value) {
            addCriterion("wechat_id <>", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdGreaterThan(String value) {
            addCriterion("wechat_id >", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_id >=", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdLessThan(String value) {
            addCriterion("wechat_id <", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdLessThanOrEqualTo(String value) {
            addCriterion("wechat_id <=", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdLike(String value) {
            addCriterion("wechat_id like", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdNotLike(String value) {
            addCriterion("wechat_id not like", value, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdIn(List<String> values) {
            addCriterion("wechat_id in", values, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdNotIn(List<String> values) {
            addCriterion("wechat_id not in", values, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdBetween(String value1, String value2) {
            addCriterion("wechat_id between", value1, value2, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatIdNotBetween(String value1, String value2) {
            addCriterion("wechat_id not between", value1, value2, "wechatId");
            return (Criteria) this;
        }

        public Criteria andWechatDepartmentIsNull() {
            addCriterion("wechat_department is null");
            return (Criteria) this;
        }

        public Criteria andWechatDepartmentIsNotNull() {
            addCriterion("wechat_department is not null");
            return (Criteria) this;
        }

        public Criteria andWechatDepartmentEqualTo(String value) {
            addCriterion("wechat_department =", value, "wechatDepartment");
            return (Criteria) this;
        }

        public Criteria andWechatDepartmentNotEqualTo(String value) {
            addCriterion("wechat_department <>", value, "wechatDepartment");
            return (Criteria) this;
        }

        public Criteria andWechatDepartmentGreaterThan(String value) {
            addCriterion("wechat_department >", value, "wechatDepartment");
            return (Criteria) this;
        }

        public Criteria andWechatDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_department >=", value, "wechatDepartment");
            return (Criteria) this;
        }

        public Criteria andWechatDepartmentLessThan(String value) {
            addCriterion("wechat_department <", value, "wechatDepartment");
            return (Criteria) this;
        }

        public Criteria andWechatDepartmentLessThanOrEqualTo(String value) {
            addCriterion("wechat_department <=", value, "wechatDepartment");
            return (Criteria) this;
        }

        public Criteria andWechatDepartmentLike(String value) {
            addCriterion("wechat_department like", value, "wechatDepartment");
            return (Criteria) this;
        }

        public Criteria andWechatDepartmentNotLike(String value) {
            addCriterion("wechat_department not like", value, "wechatDepartment");
            return (Criteria) this;
        }

        public Criteria andWechatDepartmentIn(List<String> values) {
            addCriterion("wechat_department in", values, "wechatDepartment");
            return (Criteria) this;
        }

        public Criteria andWechatDepartmentNotIn(List<String> values) {
            addCriterion("wechat_department not in", values, "wechatDepartment");
            return (Criteria) this;
        }

        public Criteria andWechatDepartmentBetween(String value1, String value2) {
            addCriterion("wechat_department between", value1, value2, "wechatDepartment");
            return (Criteria) this;
        }

        public Criteria andWechatDepartmentNotBetween(String value1, String value2) {
            addCriterion("wechat_department not between", value1, value2, "wechatDepartment");
            return (Criteria) this;
        }

        public Criteria andWechatPictureUrlIsNull() {
            addCriterion("wechat_picture_url is null");
            return (Criteria) this;
        }

        public Criteria andWechatPictureUrlIsNotNull() {
            addCriterion("wechat_picture_url is not null");
            return (Criteria) this;
        }

        public Criteria andWechatPictureUrlEqualTo(String value) {
            addCriterion("wechat_picture_url =", value, "wechatPictureUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPictureUrlNotEqualTo(String value) {
            addCriterion("wechat_picture_url <>", value, "wechatPictureUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPictureUrlGreaterThan(String value) {
            addCriterion("wechat_picture_url >", value, "wechatPictureUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPictureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_picture_url >=", value, "wechatPictureUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPictureUrlLessThan(String value) {
            addCriterion("wechat_picture_url <", value, "wechatPictureUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPictureUrlLessThanOrEqualTo(String value) {
            addCriterion("wechat_picture_url <=", value, "wechatPictureUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPictureUrlLike(String value) {
            addCriterion("wechat_picture_url like", value, "wechatPictureUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPictureUrlNotLike(String value) {
            addCriterion("wechat_picture_url not like", value, "wechatPictureUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPictureUrlIn(List<String> values) {
            addCriterion("wechat_picture_url in", values, "wechatPictureUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPictureUrlNotIn(List<String> values) {
            addCriterion("wechat_picture_url not in", values, "wechatPictureUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPictureUrlBetween(String value1, String value2) {
            addCriterion("wechat_picture_url between", value1, value2, "wechatPictureUrl");
            return (Criteria) this;
        }

        public Criteria andWechatPictureUrlNotBetween(String value1, String value2) {
            addCriterion("wechat_picture_url not between", value1, value2, "wechatPictureUrl");
            return (Criteria) this;
        }

        public Criteria andLeaveUnitTimeIsNull() {
            addCriterion("leave_unit_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaveUnitTimeIsNotNull() {
            addCriterion("leave_unit_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveUnitTimeEqualTo(Date value) {
            addCriterion("leave_unit_time =", value, "leaveUnitTime");
            return (Criteria) this;
        }

        public Criteria andLeaveUnitTimeNotEqualTo(Date value) {
            addCriterion("leave_unit_time <>", value, "leaveUnitTime");
            return (Criteria) this;
        }

        public Criteria andLeaveUnitTimeGreaterThan(Date value) {
            addCriterion("leave_unit_time >", value, "leaveUnitTime");
            return (Criteria) this;
        }

        public Criteria andLeaveUnitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("leave_unit_time >=", value, "leaveUnitTime");
            return (Criteria) this;
        }

        public Criteria andLeaveUnitTimeLessThan(Date value) {
            addCriterion("leave_unit_time <", value, "leaveUnitTime");
            return (Criteria) this;
        }

        public Criteria andLeaveUnitTimeLessThanOrEqualTo(Date value) {
            addCriterion("leave_unit_time <=", value, "leaveUnitTime");
            return (Criteria) this;
        }

        public Criteria andLeaveUnitTimeIn(List<Date> values) {
            addCriterion("leave_unit_time in", values, "leaveUnitTime");
            return (Criteria) this;
        }

        public Criteria andLeaveUnitTimeNotIn(List<Date> values) {
            addCriterion("leave_unit_time not in", values, "leaveUnitTime");
            return (Criteria) this;
        }

        public Criteria andLeaveUnitTimeBetween(Date value1, Date value2) {
            addCriterion("leave_unit_time between", value1, value2, "leaveUnitTime");
            return (Criteria) this;
        }

        public Criteria andLeaveUnitTimeNotBetween(Date value1, Date value2) {
            addCriterion("leave_unit_time not between", value1, value2, "leaveUnitTime");
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