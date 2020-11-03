package com.sliansoft.slianOA.dataaccess.model;

import java.math.BigDecimal;
import java.util.Date;

public class OaSalaryDistribute {
    private Integer salaryDistributeId;

    private String employeeName;

    private String idcard;

    private String bankCard;

    private BigDecimal basicSalary;

    private BigDecimal performanceSalary;

    private BigDecimal allowance;

    private BigDecimal paySum;

    private BigDecimal medicalInsurance;

    private BigDecimal retirementInsurance;

    private BigDecimal unemployedInsurance;

    private BigDecimal deductionSum;

    private BigDecimal salaryBeforeTax;

    private BigDecimal tax;

    private BigDecimal realSalary;

    private String remarks;

    private Integer employeeId;

    private Integer accessGroup;

    private Integer creator;

    private Date createTime;

    private String amender;

    private Date amendTime;

    private BigDecimal deductionBasicNum;

    private BigDecimal housingFund;

    private String salaryMonth;

    public Integer getSalaryDistributeId() {
        return salaryDistributeId;
    }

    public void setSalaryDistributeId(Integer salaryDistributeId) {
        this.salaryDistributeId = salaryDistributeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    public BigDecimal getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    public BigDecimal getPerformanceSalary() {
        return performanceSalary;
    }

    public void setPerformanceSalary(BigDecimal performanceSalary) {
        this.performanceSalary = performanceSalary;
    }

    public BigDecimal getAllowance() {
        return allowance;
    }

    public void setAllowance(BigDecimal allowance) {
        this.allowance = allowance;
    }

    public BigDecimal getPaySum() {
        return paySum;
    }

    public void setPaySum(BigDecimal paySum) {
        this.paySum = paySum;
    }

    public BigDecimal getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(BigDecimal medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public BigDecimal getRetirementInsurance() {
        return retirementInsurance;
    }

    public void setRetirementInsurance(BigDecimal retirementInsurance) {
        this.retirementInsurance = retirementInsurance;
    }

    public BigDecimal getUnemployedInsurance() {
        return unemployedInsurance;
    }

    public void setUnemployedInsurance(BigDecimal unemployedInsurance) {
        this.unemployedInsurance = unemployedInsurance;
    }

    public BigDecimal getDeductionSum() {
        return deductionSum;
    }

    public void setDeductionSum(BigDecimal deductionSum) {
        this.deductionSum = deductionSum;
    }

    public BigDecimal getSalaryBeforeTax() {
        return salaryBeforeTax;
    }

    public void setSalaryBeforeTax(BigDecimal salaryBeforeTax) {
        this.salaryBeforeTax = salaryBeforeTax;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getRealSalary() {
        return realSalary;
    }

    public void setRealSalary(BigDecimal realSalary) {
        this.realSalary = realSalary;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getAccessGroup() {
        return accessGroup;
    }

    public void setAccessGroup(Integer accessGroup) {
        this.accessGroup = accessGroup;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAmender() {
        return amender;
    }

    public void setAmender(String amender) {
        this.amender = amender == null ? null : amender.trim();
    }

    public Date getAmendTime() {
        return amendTime;
    }

    public void setAmendTime(Date amendTime) {
        this.amendTime = amendTime;
    }

    public BigDecimal getDeductionBasicNum() {
        return deductionBasicNum;
    }

    public void setDeductionBasicNum(BigDecimal deductionBasicNum) {
        this.deductionBasicNum = deductionBasicNum;
    }

    public BigDecimal getHousingFund() {
        return housingFund;
    }

    public void setHousingFund(BigDecimal housingFund) {
        this.housingFund = housingFund;
    }

    public String getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(String salaryMonth) {
        this.salaryMonth = salaryMonth == null ? null : salaryMonth.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OaSalaryDistribute other = (OaSalaryDistribute) that;
        return (this.getSalaryDistributeId() == null ? other.getSalaryDistributeId() == null : this.getSalaryDistributeId().equals(other.getSalaryDistributeId()))
            && (this.getEmployeeName() == null ? other.getEmployeeName() == null : this.getEmployeeName().equals(other.getEmployeeName()))
            && (this.getIdcard() == null ? other.getIdcard() == null : this.getIdcard().equals(other.getIdcard()))
            && (this.getBankCard() == null ? other.getBankCard() == null : this.getBankCard().equals(other.getBankCard()))
            && (this.getBasicSalary() == null ? other.getBasicSalary() == null : this.getBasicSalary().equals(other.getBasicSalary()))
            && (this.getPerformanceSalary() == null ? other.getPerformanceSalary() == null : this.getPerformanceSalary().equals(other.getPerformanceSalary()))
            && (this.getAllowance() == null ? other.getAllowance() == null : this.getAllowance().equals(other.getAllowance()))
            && (this.getPaySum() == null ? other.getPaySum() == null : this.getPaySum().equals(other.getPaySum()))
            && (this.getMedicalInsurance() == null ? other.getMedicalInsurance() == null : this.getMedicalInsurance().equals(other.getMedicalInsurance()))
            && (this.getRetirementInsurance() == null ? other.getRetirementInsurance() == null : this.getRetirementInsurance().equals(other.getRetirementInsurance()))
            && (this.getUnemployedInsurance() == null ? other.getUnemployedInsurance() == null : this.getUnemployedInsurance().equals(other.getUnemployedInsurance()))
            && (this.getDeductionSum() == null ? other.getDeductionSum() == null : this.getDeductionSum().equals(other.getDeductionSum()))
            && (this.getSalaryBeforeTax() == null ? other.getSalaryBeforeTax() == null : this.getSalaryBeforeTax().equals(other.getSalaryBeforeTax()))
            && (this.getTax() == null ? other.getTax() == null : this.getTax().equals(other.getTax()))
            && (this.getRealSalary() == null ? other.getRealSalary() == null : this.getRealSalary().equals(other.getRealSalary()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getDeductionBasicNum() == null ? other.getDeductionBasicNum() == null : this.getDeductionBasicNum().equals(other.getDeductionBasicNum()))
            && (this.getHousingFund() == null ? other.getHousingFund() == null : this.getHousingFund().equals(other.getHousingFund()))
            && (this.getSalaryMonth() == null ? other.getSalaryMonth() == null : this.getSalaryMonth().equals(other.getSalaryMonth()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSalaryDistributeId() == null) ? 0 : getSalaryDistributeId().hashCode());
        result = prime * result + ((getEmployeeName() == null) ? 0 : getEmployeeName().hashCode());
        result = prime * result + ((getIdcard() == null) ? 0 : getIdcard().hashCode());
        result = prime * result + ((getBankCard() == null) ? 0 : getBankCard().hashCode());
        result = prime * result + ((getBasicSalary() == null) ? 0 : getBasicSalary().hashCode());
        result = prime * result + ((getPerformanceSalary() == null) ? 0 : getPerformanceSalary().hashCode());
        result = prime * result + ((getAllowance() == null) ? 0 : getAllowance().hashCode());
        result = prime * result + ((getPaySum() == null) ? 0 : getPaySum().hashCode());
        result = prime * result + ((getMedicalInsurance() == null) ? 0 : getMedicalInsurance().hashCode());
        result = prime * result + ((getRetirementInsurance() == null) ? 0 : getRetirementInsurance().hashCode());
        result = prime * result + ((getUnemployedInsurance() == null) ? 0 : getUnemployedInsurance().hashCode());
        result = prime * result + ((getDeductionSum() == null) ? 0 : getDeductionSum().hashCode());
        result = prime * result + ((getSalaryBeforeTax() == null) ? 0 : getSalaryBeforeTax().hashCode());
        result = prime * result + ((getTax() == null) ? 0 : getTax().hashCode());
        result = prime * result + ((getRealSalary() == null) ? 0 : getRealSalary().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getDeductionBasicNum() == null) ? 0 : getDeductionBasicNum().hashCode());
        result = prime * result + ((getHousingFund() == null) ? 0 : getHousingFund().hashCode());
        result = prime * result + ((getSalaryMonth() == null) ? 0 : getSalaryMonth().hashCode());
        return result;
    }
}