package com.sliansoft.slianOA.dataaccess.model;

import java.math.BigDecimal;
import java.util.Date;

public class OaProjectEncourage {
    private Integer projectEncourageId;

    private Integer projectId;

    private String projectCode;

    private String projectName;

    private String projectTitle;

    private Integer employeeId;

    private String employeeName;

    private String employeeRole;

    private Date employeeBeginDate;

    private Date employeeEndDate;

    private Integer employeePeriod;

    private BigDecimal projectContractMoney;

    private BigDecimal projectCorporateMoney;

    private BigDecimal projectEncourage;

    private BigDecimal projectEncourageLeader;

    private BigDecimal projectEncourageTeam;

    private Date fundingDate;

    private String fundingUsage;

    private BigDecimal fundingCost;

    private BigDecimal fundingLeft;

    private String fundingRemarks;

    private BigDecimal projectEncourageSum;

    private BigDecimal employeePerformanceRate;

    private BigDecimal employeePerformanceMoney;

    private Integer accessGroup;

    private Integer creator;

    private Date createTime;

    private Integer amender;

    private Date amendTime;

    public Integer getProjectEncourageId() {
        return projectEncourageId;
    }

    public void setProjectEncourageId(Integer projectEncourageId) {
        this.projectEncourageId = projectEncourageId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle == null ? null : projectTitle.trim();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole == null ? null : employeeRole.trim();
    }

    public Date getEmployeeBeginDate() {
        return employeeBeginDate;
    }

    public void setEmployeeBeginDate(Date employeeBeginDate) {
        this.employeeBeginDate = employeeBeginDate;
    }

    public Date getEmployeeEndDate() {
        return employeeEndDate;
    }

    public void setEmployeeEndDate(Date employeeEndDate) {
        this.employeeEndDate = employeeEndDate;
    }

    public Integer getEmployeePeriod() {
        return employeePeriod;
    }

    public void setEmployeePeriod(Integer employeePeriod) {
        this.employeePeriod = employeePeriod;
    }

    public BigDecimal getProjectContractMoney() {
        return projectContractMoney;
    }

    public void setProjectContractMoney(BigDecimal projectContractMoney) {
        this.projectContractMoney = projectContractMoney;
    }

    public BigDecimal getProjectCorporateMoney() {
        return projectCorporateMoney;
    }

    public void setProjectCorporateMoney(BigDecimal projectCorporateMoney) {
        this.projectCorporateMoney = projectCorporateMoney;
    }

    public BigDecimal getProjectEncourage() {
        return projectEncourage;
    }

    public void setProjectEncourage(BigDecimal projectEncourage) {
        this.projectEncourage = projectEncourage;
    }

    public BigDecimal getProjectEncourageLeader() {
        return projectEncourageLeader;
    }

    public void setProjectEncourageLeader(BigDecimal projectEncourageLeader) {
        this.projectEncourageLeader = projectEncourageLeader;
    }

    public BigDecimal getProjectEncourageTeam() {
        return projectEncourageTeam;
    }

    public void setProjectEncourageTeam(BigDecimal projectEncourageTeam) {
        this.projectEncourageTeam = projectEncourageTeam;
    }

    public Date getFundingDate() {
        return fundingDate;
    }

    public void setFundingDate(Date fundingDate) {
        this.fundingDate = fundingDate;
    }

    public String getFundingUsage() {
        return fundingUsage;
    }

    public void setFundingUsage(String fundingUsage) {
        this.fundingUsage = fundingUsage == null ? null : fundingUsage.trim();
    }

    public BigDecimal getFundingCost() {
        return fundingCost;
    }

    public void setFundingCost(BigDecimal fundingCost) {
        this.fundingCost = fundingCost;
    }

    public BigDecimal getFundingLeft() {
        return fundingLeft;
    }

    public void setFundingLeft(BigDecimal fundingLeft) {
        this.fundingLeft = fundingLeft;
    }

    public String getFundingRemarks() {
        return fundingRemarks;
    }

    public void setFundingRemarks(String fundingRemarks) {
        this.fundingRemarks = fundingRemarks == null ? null : fundingRemarks.trim();
    }

    public BigDecimal getProjectEncourageSum() {
        return projectEncourageSum;
    }

    public void setProjectEncourageSum(BigDecimal projectEncourageSum) {
        this.projectEncourageSum = projectEncourageSum;
    }

    public BigDecimal getEmployeePerformanceRate() {
        return employeePerformanceRate;
    }

    public void setEmployeePerformanceRate(BigDecimal employeePerformanceRate) {
        this.employeePerformanceRate = employeePerformanceRate;
    }

    public BigDecimal getEmployeePerformanceMoney() {
        return employeePerformanceMoney;
    }

    public void setEmployeePerformanceMoney(BigDecimal employeePerformanceMoney) {
        this.employeePerformanceMoney = employeePerformanceMoney;
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

    public Integer getAmender() {
        return amender;
    }

    public void setAmender(Integer amender) {
        this.amender = amender;
    }

    public Date getAmendTime() {
        return amendTime;
    }

    public void setAmendTime(Date amendTime) {
        this.amendTime = amendTime;
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
        OaProjectEncourage other = (OaProjectEncourage) that;
        return (this.getProjectEncourageId() == null ? other.getProjectEncourageId() == null : this.getProjectEncourageId().equals(other.getProjectEncourageId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectCode() == null ? other.getProjectCode() == null : this.getProjectCode().equals(other.getProjectCode()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectTitle() == null ? other.getProjectTitle() == null : this.getProjectTitle().equals(other.getProjectTitle()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getEmployeeName() == null ? other.getEmployeeName() == null : this.getEmployeeName().equals(other.getEmployeeName()))
            && (this.getEmployeeRole() == null ? other.getEmployeeRole() == null : this.getEmployeeRole().equals(other.getEmployeeRole()))
            && (this.getEmployeeBeginDate() == null ? other.getEmployeeBeginDate() == null : this.getEmployeeBeginDate().equals(other.getEmployeeBeginDate()))
            && (this.getEmployeeEndDate() == null ? other.getEmployeeEndDate() == null : this.getEmployeeEndDate().equals(other.getEmployeeEndDate()))
            && (this.getEmployeePeriod() == null ? other.getEmployeePeriod() == null : this.getEmployeePeriod().equals(other.getEmployeePeriod()))
            && (this.getProjectContractMoney() == null ? other.getProjectContractMoney() == null : this.getProjectContractMoney().equals(other.getProjectContractMoney()))
            && (this.getProjectCorporateMoney() == null ? other.getProjectCorporateMoney() == null : this.getProjectCorporateMoney().equals(other.getProjectCorporateMoney()))
            && (this.getProjectEncourage() == null ? other.getProjectEncourage() == null : this.getProjectEncourage().equals(other.getProjectEncourage()))
            && (this.getProjectEncourageLeader() == null ? other.getProjectEncourageLeader() == null : this.getProjectEncourageLeader().equals(other.getProjectEncourageLeader()))
            && (this.getProjectEncourageTeam() == null ? other.getProjectEncourageTeam() == null : this.getProjectEncourageTeam().equals(other.getProjectEncourageTeam()))
            && (this.getFundingDate() == null ? other.getFundingDate() == null : this.getFundingDate().equals(other.getFundingDate()))
            && (this.getFundingUsage() == null ? other.getFundingUsage() == null : this.getFundingUsage().equals(other.getFundingUsage()))
            && (this.getFundingCost() == null ? other.getFundingCost() == null : this.getFundingCost().equals(other.getFundingCost()))
            && (this.getFundingLeft() == null ? other.getFundingLeft() == null : this.getFundingLeft().equals(other.getFundingLeft()))
            && (this.getFundingRemarks() == null ? other.getFundingRemarks() == null : this.getFundingRemarks().equals(other.getFundingRemarks()))
            && (this.getProjectEncourageSum() == null ? other.getProjectEncourageSum() == null : this.getProjectEncourageSum().equals(other.getProjectEncourageSum()))
            && (this.getEmployeePerformanceRate() == null ? other.getEmployeePerformanceRate() == null : this.getEmployeePerformanceRate().equals(other.getEmployeePerformanceRate()))
            && (this.getEmployeePerformanceMoney() == null ? other.getEmployeePerformanceMoney() == null : this.getEmployeePerformanceMoney().equals(other.getEmployeePerformanceMoney()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectEncourageId() == null) ? 0 : getProjectEncourageId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectCode() == null) ? 0 : getProjectCode().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectTitle() == null) ? 0 : getProjectTitle().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getEmployeeName() == null) ? 0 : getEmployeeName().hashCode());
        result = prime * result + ((getEmployeeRole() == null) ? 0 : getEmployeeRole().hashCode());
        result = prime * result + ((getEmployeeBeginDate() == null) ? 0 : getEmployeeBeginDate().hashCode());
        result = prime * result + ((getEmployeeEndDate() == null) ? 0 : getEmployeeEndDate().hashCode());
        result = prime * result + ((getEmployeePeriod() == null) ? 0 : getEmployeePeriod().hashCode());
        result = prime * result + ((getProjectContractMoney() == null) ? 0 : getProjectContractMoney().hashCode());
        result = prime * result + ((getProjectCorporateMoney() == null) ? 0 : getProjectCorporateMoney().hashCode());
        result = prime * result + ((getProjectEncourage() == null) ? 0 : getProjectEncourage().hashCode());
        result = prime * result + ((getProjectEncourageLeader() == null) ? 0 : getProjectEncourageLeader().hashCode());
        result = prime * result + ((getProjectEncourageTeam() == null) ? 0 : getProjectEncourageTeam().hashCode());
        result = prime * result + ((getFundingDate() == null) ? 0 : getFundingDate().hashCode());
        result = prime * result + ((getFundingUsage() == null) ? 0 : getFundingUsage().hashCode());
        result = prime * result + ((getFundingCost() == null) ? 0 : getFundingCost().hashCode());
        result = prime * result + ((getFundingLeft() == null) ? 0 : getFundingLeft().hashCode());
        result = prime * result + ((getFundingRemarks() == null) ? 0 : getFundingRemarks().hashCode());
        result = prime * result + ((getProjectEncourageSum() == null) ? 0 : getProjectEncourageSum().hashCode());
        result = prime * result + ((getEmployeePerformanceRate() == null) ? 0 : getEmployeePerformanceRate().hashCode());
        result = prime * result + ((getEmployeePerformanceMoney() == null) ? 0 : getEmployeePerformanceMoney().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        return result;
    }
}