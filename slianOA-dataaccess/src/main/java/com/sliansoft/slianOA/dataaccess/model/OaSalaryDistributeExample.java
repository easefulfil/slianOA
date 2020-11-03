package com.sliansoft.slianOA.dataaccess.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaSalaryDistributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private int pageIndex;

    private int pageSize;

    public OaSalaryDistributeExample() {
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

    public OaSalaryDistributeExample(int pageSize, int pageIndex) {
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

        public Criteria andSalaryDistributeIdIsNull() {
            addCriterion("salary_distribute_id is null");
            return (Criteria) this;
        }

        public Criteria andSalaryDistributeIdIsNotNull() {
            addCriterion("salary_distribute_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryDistributeIdEqualTo(Integer value) {
            addCriterion("salary_distribute_id =", value, "salaryDistributeId");
            return (Criteria) this;
        }

        public Criteria andSalaryDistributeIdNotEqualTo(Integer value) {
            addCriterion("salary_distribute_id <>", value, "salaryDistributeId");
            return (Criteria) this;
        }

        public Criteria andSalaryDistributeIdGreaterThan(Integer value) {
            addCriterion("salary_distribute_id >", value, "salaryDistributeId");
            return (Criteria) this;
        }

        public Criteria andSalaryDistributeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("salary_distribute_id >=", value, "salaryDistributeId");
            return (Criteria) this;
        }

        public Criteria andSalaryDistributeIdLessThan(Integer value) {
            addCriterion("salary_distribute_id <", value, "salaryDistributeId");
            return (Criteria) this;
        }

        public Criteria andSalaryDistributeIdLessThanOrEqualTo(Integer value) {
            addCriterion("salary_distribute_id <=", value, "salaryDistributeId");
            return (Criteria) this;
        }

        public Criteria andSalaryDistributeIdIn(List<Integer> values) {
            addCriterion("salary_distribute_id in", values, "salaryDistributeId");
            return (Criteria) this;
        }

        public Criteria andSalaryDistributeIdNotIn(List<Integer> values) {
            addCriterion("salary_distribute_id not in", values, "salaryDistributeId");
            return (Criteria) this;
        }

        public Criteria andSalaryDistributeIdBetween(Integer value1, Integer value2) {
            addCriterion("salary_distribute_id between", value1, value2, "salaryDistributeId");
            return (Criteria) this;
        }

        public Criteria andSalaryDistributeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("salary_distribute_id not between", value1, value2, "salaryDistributeId");
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

        public Criteria andIdcardIsNull() {
            addCriterion("idcard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idcard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idcard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idcard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andBankCardIsNull() {
            addCriterion("bank_card is null");
            return (Criteria) this;
        }

        public Criteria andBankCardIsNotNull() {
            addCriterion("bank_card is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardEqualTo(String value) {
            addCriterion("bank_card =", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotEqualTo(String value) {
            addCriterion("bank_card <>", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardGreaterThan(String value) {
            addCriterion("bank_card >", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card >=", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLessThan(String value) {
            addCriterion("bank_card <", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLessThanOrEqualTo(String value) {
            addCriterion("bank_card <=", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLike(String value) {
            addCriterion("bank_card like", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotLike(String value) {
            addCriterion("bank_card not like", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardIn(List<String> values) {
            addCriterion("bank_card in", values, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotIn(List<String> values) {
            addCriterion("bank_card not in", values, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardBetween(String value1, String value2) {
            addCriterion("bank_card between", value1, value2, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotBetween(String value1, String value2) {
            addCriterion("bank_card not between", value1, value2, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryIsNull() {
            addCriterion("basic_salary is null");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryIsNotNull() {
            addCriterion("basic_salary is not null");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryEqualTo(BigDecimal value) {
            addCriterion("basic_salary =", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryNotEqualTo(BigDecimal value) {
            addCriterion("basic_salary <>", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryGreaterThan(BigDecimal value) {
            addCriterion("basic_salary >", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("basic_salary >=", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryLessThan(BigDecimal value) {
            addCriterion("basic_salary <", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("basic_salary <=", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryIn(List<BigDecimal> values) {
            addCriterion("basic_salary in", values, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryNotIn(List<BigDecimal> values) {
            addCriterion("basic_salary not in", values, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic_salary between", value1, value2, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic_salary not between", value1, value2, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andPerformanceSalaryIsNull() {
            addCriterion("performance_salary is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceSalaryIsNotNull() {
            addCriterion("performance_salary is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceSalaryEqualTo(BigDecimal value) {
            addCriterion("performance_salary =", value, "performanceSalary");
            return (Criteria) this;
        }

        public Criteria andPerformanceSalaryNotEqualTo(BigDecimal value) {
            addCriterion("performance_salary <>", value, "performanceSalary");
            return (Criteria) this;
        }

        public Criteria andPerformanceSalaryGreaterThan(BigDecimal value) {
            addCriterion("performance_salary >", value, "performanceSalary");
            return (Criteria) this;
        }

        public Criteria andPerformanceSalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("performance_salary >=", value, "performanceSalary");
            return (Criteria) this;
        }

        public Criteria andPerformanceSalaryLessThan(BigDecimal value) {
            addCriterion("performance_salary <", value, "performanceSalary");
            return (Criteria) this;
        }

        public Criteria andPerformanceSalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("performance_salary <=", value, "performanceSalary");
            return (Criteria) this;
        }

        public Criteria andPerformanceSalaryIn(List<BigDecimal> values) {
            addCriterion("performance_salary in", values, "performanceSalary");
            return (Criteria) this;
        }

        public Criteria andPerformanceSalaryNotIn(List<BigDecimal> values) {
            addCriterion("performance_salary not in", values, "performanceSalary");
            return (Criteria) this;
        }

        public Criteria andPerformanceSalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("performance_salary between", value1, value2, "performanceSalary");
            return (Criteria) this;
        }

        public Criteria andPerformanceSalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("performance_salary not between", value1, value2, "performanceSalary");
            return (Criteria) this;
        }

        public Criteria andAllowanceIsNull() {
            addCriterion("allowance is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceIsNotNull() {
            addCriterion("allowance is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceEqualTo(BigDecimal value) {
            addCriterion("allowance =", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotEqualTo(BigDecimal value) {
            addCriterion("allowance <>", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceGreaterThan(BigDecimal value) {
            addCriterion("allowance >", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("allowance >=", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceLessThan(BigDecimal value) {
            addCriterion("allowance <", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("allowance <=", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceIn(List<BigDecimal> values) {
            addCriterion("allowance in", values, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotIn(List<BigDecimal> values) {
            addCriterion("allowance not in", values, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("allowance between", value1, value2, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("allowance not between", value1, value2, "allowance");
            return (Criteria) this;
        }

        public Criteria andPaySumIsNull() {
            addCriterion("pay_sum is null");
            return (Criteria) this;
        }

        public Criteria andPaySumIsNotNull() {
            addCriterion("pay_sum is not null");
            return (Criteria) this;
        }

        public Criteria andPaySumEqualTo(BigDecimal value) {
            addCriterion("pay_sum =", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumNotEqualTo(BigDecimal value) {
            addCriterion("pay_sum <>", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumGreaterThan(BigDecimal value) {
            addCriterion("pay_sum >", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_sum >=", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumLessThan(BigDecimal value) {
            addCriterion("pay_sum <", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_sum <=", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumIn(List<BigDecimal> values) {
            addCriterion("pay_sum in", values, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumNotIn(List<BigDecimal> values) {
            addCriterion("pay_sum not in", values, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_sum between", value1, value2, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_sum not between", value1, value2, "paySum");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceIsNull() {
            addCriterion("medical_insurance is null");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceIsNotNull() {
            addCriterion("medical_insurance is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceEqualTo(BigDecimal value) {
            addCriterion("medical_insurance =", value, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceNotEqualTo(BigDecimal value) {
            addCriterion("medical_insurance <>", value, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceGreaterThan(BigDecimal value) {
            addCriterion("medical_insurance >", value, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("medical_insurance >=", value, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceLessThan(BigDecimal value) {
            addCriterion("medical_insurance <", value, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("medical_insurance <=", value, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceIn(List<BigDecimal> values) {
            addCriterion("medical_insurance in", values, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceNotIn(List<BigDecimal> values) {
            addCriterion("medical_insurance not in", values, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("medical_insurance between", value1, value2, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("medical_insurance not between", value1, value2, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andRetirementInsuranceIsNull() {
            addCriterion("retirement_insurance is null");
            return (Criteria) this;
        }

        public Criteria andRetirementInsuranceIsNotNull() {
            addCriterion("retirement_insurance is not null");
            return (Criteria) this;
        }

        public Criteria andRetirementInsuranceEqualTo(BigDecimal value) {
            addCriterion("retirement_insurance =", value, "retirementInsurance");
            return (Criteria) this;
        }

        public Criteria andRetirementInsuranceNotEqualTo(BigDecimal value) {
            addCriterion("retirement_insurance <>", value, "retirementInsurance");
            return (Criteria) this;
        }

        public Criteria andRetirementInsuranceGreaterThan(BigDecimal value) {
            addCriterion("retirement_insurance >", value, "retirementInsurance");
            return (Criteria) this;
        }

        public Criteria andRetirementInsuranceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("retirement_insurance >=", value, "retirementInsurance");
            return (Criteria) this;
        }

        public Criteria andRetirementInsuranceLessThan(BigDecimal value) {
            addCriterion("retirement_insurance <", value, "retirementInsurance");
            return (Criteria) this;
        }

        public Criteria andRetirementInsuranceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("retirement_insurance <=", value, "retirementInsurance");
            return (Criteria) this;
        }

        public Criteria andRetirementInsuranceIn(List<BigDecimal> values) {
            addCriterion("retirement_insurance in", values, "retirementInsurance");
            return (Criteria) this;
        }

        public Criteria andRetirementInsuranceNotIn(List<BigDecimal> values) {
            addCriterion("retirement_insurance not in", values, "retirementInsurance");
            return (Criteria) this;
        }

        public Criteria andRetirementInsuranceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retirement_insurance between", value1, value2, "retirementInsurance");
            return (Criteria) this;
        }

        public Criteria andRetirementInsuranceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retirement_insurance not between", value1, value2, "retirementInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemployedInsuranceIsNull() {
            addCriterion("unemployed_insurance is null");
            return (Criteria) this;
        }

        public Criteria andUnemployedInsuranceIsNotNull() {
            addCriterion("unemployed_insurance is not null");
            return (Criteria) this;
        }

        public Criteria andUnemployedInsuranceEqualTo(BigDecimal value) {
            addCriterion("unemployed_insurance =", value, "unemployedInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemployedInsuranceNotEqualTo(BigDecimal value) {
            addCriterion("unemployed_insurance <>", value, "unemployedInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemployedInsuranceGreaterThan(BigDecimal value) {
            addCriterion("unemployed_insurance >", value, "unemployedInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemployedInsuranceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unemployed_insurance >=", value, "unemployedInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemployedInsuranceLessThan(BigDecimal value) {
            addCriterion("unemployed_insurance <", value, "unemployedInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemployedInsuranceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unemployed_insurance <=", value, "unemployedInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemployedInsuranceIn(List<BigDecimal> values) {
            addCriterion("unemployed_insurance in", values, "unemployedInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemployedInsuranceNotIn(List<BigDecimal> values) {
            addCriterion("unemployed_insurance not in", values, "unemployedInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemployedInsuranceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unemployed_insurance between", value1, value2, "unemployedInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemployedInsuranceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unemployed_insurance not between", value1, value2, "unemployedInsurance");
            return (Criteria) this;
        }

        public Criteria andDeductionSumIsNull() {
            addCriterion("deduction_sum is null");
            return (Criteria) this;
        }

        public Criteria andDeductionSumIsNotNull() {
            addCriterion("deduction_sum is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionSumEqualTo(BigDecimal value) {
            addCriterion("deduction_sum =", value, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumNotEqualTo(BigDecimal value) {
            addCriterion("deduction_sum <>", value, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumGreaterThan(BigDecimal value) {
            addCriterion("deduction_sum >", value, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deduction_sum >=", value, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumLessThan(BigDecimal value) {
            addCriterion("deduction_sum <", value, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deduction_sum <=", value, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumIn(List<BigDecimal> values) {
            addCriterion("deduction_sum in", values, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumNotIn(List<BigDecimal> values) {
            addCriterion("deduction_sum not in", values, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduction_sum between", value1, value2, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andDeductionSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduction_sum not between", value1, value2, "deductionSum");
            return (Criteria) this;
        }

        public Criteria andSalaryBeforeTaxIsNull() {
            addCriterion("salary_before_tax is null");
            return (Criteria) this;
        }

        public Criteria andSalaryBeforeTaxIsNotNull() {
            addCriterion("salary_before_tax is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryBeforeTaxEqualTo(BigDecimal value) {
            addCriterion("salary_before_tax =", value, "salaryBeforeTax");
            return (Criteria) this;
        }

        public Criteria andSalaryBeforeTaxNotEqualTo(BigDecimal value) {
            addCriterion("salary_before_tax <>", value, "salaryBeforeTax");
            return (Criteria) this;
        }

        public Criteria andSalaryBeforeTaxGreaterThan(BigDecimal value) {
            addCriterion("salary_before_tax >", value, "salaryBeforeTax");
            return (Criteria) this;
        }

        public Criteria andSalaryBeforeTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("salary_before_tax >=", value, "salaryBeforeTax");
            return (Criteria) this;
        }

        public Criteria andSalaryBeforeTaxLessThan(BigDecimal value) {
            addCriterion("salary_before_tax <", value, "salaryBeforeTax");
            return (Criteria) this;
        }

        public Criteria andSalaryBeforeTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("salary_before_tax <=", value, "salaryBeforeTax");
            return (Criteria) this;
        }

        public Criteria andSalaryBeforeTaxIn(List<BigDecimal> values) {
            addCriterion("salary_before_tax in", values, "salaryBeforeTax");
            return (Criteria) this;
        }

        public Criteria andSalaryBeforeTaxNotIn(List<BigDecimal> values) {
            addCriterion("salary_before_tax not in", values, "salaryBeforeTax");
            return (Criteria) this;
        }

        public Criteria andSalaryBeforeTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salary_before_tax between", value1, value2, "salaryBeforeTax");
            return (Criteria) this;
        }

        public Criteria andSalaryBeforeTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salary_before_tax not between", value1, value2, "salaryBeforeTax");
            return (Criteria) this;
        }

        public Criteria andTaxIsNull() {
            addCriterion("tax is null");
            return (Criteria) this;
        }

        public Criteria andTaxIsNotNull() {
            addCriterion("tax is not null");
            return (Criteria) this;
        }

        public Criteria andTaxEqualTo(BigDecimal value) {
            addCriterion("tax =", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotEqualTo(BigDecimal value) {
            addCriterion("tax <>", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThan(BigDecimal value) {
            addCriterion("tax >", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax >=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThan(BigDecimal value) {
            addCriterion("tax <", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax <=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxIn(List<BigDecimal> values) {
            addCriterion("tax in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotIn(List<BigDecimal> values) {
            addCriterion("tax not in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax not between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andRealSalaryIsNull() {
            addCriterion("real_salary is null");
            return (Criteria) this;
        }

        public Criteria andRealSalaryIsNotNull() {
            addCriterion("real_salary is not null");
            return (Criteria) this;
        }

        public Criteria andRealSalaryEqualTo(BigDecimal value) {
            addCriterion("real_salary =", value, "realSalary");
            return (Criteria) this;
        }

        public Criteria andRealSalaryNotEqualTo(BigDecimal value) {
            addCriterion("real_salary <>", value, "realSalary");
            return (Criteria) this;
        }

        public Criteria andRealSalaryGreaterThan(BigDecimal value) {
            addCriterion("real_salary >", value, "realSalary");
            return (Criteria) this;
        }

        public Criteria andRealSalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_salary >=", value, "realSalary");
            return (Criteria) this;
        }

        public Criteria andRealSalaryLessThan(BigDecimal value) {
            addCriterion("real_salary <", value, "realSalary");
            return (Criteria) this;
        }

        public Criteria andRealSalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_salary <=", value, "realSalary");
            return (Criteria) this;
        }

        public Criteria andRealSalaryIn(List<BigDecimal> values) {
            addCriterion("real_salary in", values, "realSalary");
            return (Criteria) this;
        }

        public Criteria andRealSalaryNotIn(List<BigDecimal> values) {
            addCriterion("real_salary not in", values, "realSalary");
            return (Criteria) this;
        }

        public Criteria andRealSalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_salary between", value1, value2, "realSalary");
            return (Criteria) this;
        }

        public Criteria andRealSalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_salary not between", value1, value2, "realSalary");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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

        public Criteria andDeductionBasicNumIsNull() {
            addCriterion("deduction_basic_num is null");
            return (Criteria) this;
        }

        public Criteria andDeductionBasicNumIsNotNull() {
            addCriterion("deduction_basic_num is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionBasicNumEqualTo(BigDecimal value) {
            addCriterion("deduction_basic_num =", value, "deductionBasicNum");
            return (Criteria) this;
        }

        public Criteria andDeductionBasicNumNotEqualTo(BigDecimal value) {
            addCriterion("deduction_basic_num <>", value, "deductionBasicNum");
            return (Criteria) this;
        }

        public Criteria andDeductionBasicNumGreaterThan(BigDecimal value) {
            addCriterion("deduction_basic_num >", value, "deductionBasicNum");
            return (Criteria) this;
        }

        public Criteria andDeductionBasicNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deduction_basic_num >=", value, "deductionBasicNum");
            return (Criteria) this;
        }

        public Criteria andDeductionBasicNumLessThan(BigDecimal value) {
            addCriterion("deduction_basic_num <", value, "deductionBasicNum");
            return (Criteria) this;
        }

        public Criteria andDeductionBasicNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deduction_basic_num <=", value, "deductionBasicNum");
            return (Criteria) this;
        }

        public Criteria andDeductionBasicNumIn(List<BigDecimal> values) {
            addCriterion("deduction_basic_num in", values, "deductionBasicNum");
            return (Criteria) this;
        }

        public Criteria andDeductionBasicNumNotIn(List<BigDecimal> values) {
            addCriterion("deduction_basic_num not in", values, "deductionBasicNum");
            return (Criteria) this;
        }

        public Criteria andDeductionBasicNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduction_basic_num between", value1, value2, "deductionBasicNum");
            return (Criteria) this;
        }

        public Criteria andDeductionBasicNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduction_basic_num not between", value1, value2, "deductionBasicNum");
            return (Criteria) this;
        }

        public Criteria andHousingFundIsNull() {
            addCriterion("housing_fund is null");
            return (Criteria) this;
        }

        public Criteria andHousingFundIsNotNull() {
            addCriterion("housing_fund is not null");
            return (Criteria) this;
        }

        public Criteria andHousingFundEqualTo(BigDecimal value) {
            addCriterion("housing_fund =", value, "housingFund");
            return (Criteria) this;
        }

        public Criteria andHousingFundNotEqualTo(BigDecimal value) {
            addCriterion("housing_fund <>", value, "housingFund");
            return (Criteria) this;
        }

        public Criteria andHousingFundGreaterThan(BigDecimal value) {
            addCriterion("housing_fund >", value, "housingFund");
            return (Criteria) this;
        }

        public Criteria andHousingFundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("housing_fund >=", value, "housingFund");
            return (Criteria) this;
        }

        public Criteria andHousingFundLessThan(BigDecimal value) {
            addCriterion("housing_fund <", value, "housingFund");
            return (Criteria) this;
        }

        public Criteria andHousingFundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("housing_fund <=", value, "housingFund");
            return (Criteria) this;
        }

        public Criteria andHousingFundIn(List<BigDecimal> values) {
            addCriterion("housing_fund in", values, "housingFund");
            return (Criteria) this;
        }

        public Criteria andHousingFundNotIn(List<BigDecimal> values) {
            addCriterion("housing_fund not in", values, "housingFund");
            return (Criteria) this;
        }

        public Criteria andHousingFundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("housing_fund between", value1, value2, "housingFund");
            return (Criteria) this;
        }

        public Criteria andHousingFundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("housing_fund not between", value1, value2, "housingFund");
            return (Criteria) this;
        }

        public Criteria andSalaryMonthIsNull() {
            addCriterion("salary_month is null");
            return (Criteria) this;
        }

        public Criteria andSalaryMonthIsNotNull() {
            addCriterion("salary_month is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryMonthEqualTo(String value) {
            addCriterion("salary_month =", value, "salaryMonth");
            return (Criteria) this;
        }

        public Criteria andSalaryMonthNotEqualTo(String value) {
            addCriterion("salary_month <>", value, "salaryMonth");
            return (Criteria) this;
        }

        public Criteria andSalaryMonthGreaterThan(String value) {
            addCriterion("salary_month >", value, "salaryMonth");
            return (Criteria) this;
        }

        public Criteria andSalaryMonthGreaterThanOrEqualTo(String value) {
            addCriterion("salary_month >=", value, "salaryMonth");
            return (Criteria) this;
        }

        public Criteria andSalaryMonthLessThan(String value) {
            addCriterion("salary_month <", value, "salaryMonth");
            return (Criteria) this;
        }

        public Criteria andSalaryMonthLessThanOrEqualTo(String value) {
            addCriterion("salary_month <=", value, "salaryMonth");
            return (Criteria) this;
        }

        public Criteria andSalaryMonthLike(String value) {
            addCriterion("salary_month like", value, "salaryMonth");
            return (Criteria) this;
        }

        public Criteria andSalaryMonthNotLike(String value) {
            addCriterion("salary_month not like", value, "salaryMonth");
            return (Criteria) this;
        }

        public Criteria andSalaryMonthIn(List<String> values) {
            addCriterion("salary_month in", values, "salaryMonth");
            return (Criteria) this;
        }

        public Criteria andSalaryMonthNotIn(List<String> values) {
            addCriterion("salary_month not in", values, "salaryMonth");
            return (Criteria) this;
        }

        public Criteria andSalaryMonthBetween(String value1, String value2) {
            addCriterion("salary_month between", value1, value2, "salaryMonth");
            return (Criteria) this;
        }

        public Criteria andSalaryMonthNotBetween(String value1, String value2) {
            addCriterion("salary_month not between", value1, value2, "salaryMonth");
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