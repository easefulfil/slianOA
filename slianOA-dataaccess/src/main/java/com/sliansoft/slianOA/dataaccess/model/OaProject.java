package com.sliansoft.slianOA.dataaccess.model;

import java.math.BigDecimal;
import java.util.Date;

public class OaProject {
    private Integer projectId;

    private String projectName;

    private String projectTitle;

    private String projectCustomer;

    private String projectStatus;

    private Integer projectPeriod;

    private BigDecimal projectContractMoney;

    private BigDecimal projectLeftMoney;

    private BigDecimal projectEncourageMoney;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    private Integer isDelete;

    private String projectCode;

    private String marketPerson;

    private BigDecimal marketCost;

    private BigDecimal projectEncourageLeader;

    private BigDecimal projectEncourageTeam;

    private Date projectBeginDate;

    private Date projectEndDate;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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

    public String getProjectCustomer() {
        return projectCustomer;
    }

    public void setProjectCustomer(String projectCustomer) {
        this.projectCustomer = projectCustomer == null ? null : projectCustomer.trim();
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus == null ? null : projectStatus.trim();
    }

    public Integer getProjectPeriod() {
        return projectPeriod;
    }

    public void setProjectPeriod(Integer projectPeriod) {
        this.projectPeriod = projectPeriod;
    }

    public BigDecimal getProjectContractMoney() {
        return projectContractMoney;
    }

    public void setProjectContractMoney(BigDecimal projectContractMoney) {
        this.projectContractMoney = projectContractMoney;
    }

    public BigDecimal getProjectLeftMoney() {
        return projectLeftMoney;
    }

    public void setProjectLeftMoney(BigDecimal projectLeftMoney) {
        this.projectLeftMoney = projectLeftMoney;
    }

    public BigDecimal getProjectEncourageMoney() {
        return projectEncourageMoney;
    }

    public void setProjectEncourageMoney(BigDecimal projectEncourageMoney) {
        this.projectEncourageMoney = projectEncourageMoney;
    }

    public Integer getAccessGroup() {
        return accessGroup;
    }

    public void setAccessGroup(Integer accessGroup) {
        this.accessGroup = accessGroup;
    }

    public Date getAmendTime() {
        return amendTime;
    }

    public void setAmendTime(Date amendTime) {
        this.amendTime = amendTime;
    }

    public Integer getAmender() {
        return amender;
    }

    public void setAmender(Integer amender) {
        this.amender = amender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    public String getMarketPerson() {
        return marketPerson;
    }

    public void setMarketPerson(String marketPerson) {
        this.marketPerson = marketPerson == null ? null : marketPerson.trim();
    }

    public BigDecimal getMarketCost() {
        return marketCost;
    }

    public void setMarketCost(BigDecimal marketCost) {
        this.marketCost = marketCost;
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

    public Date getProjectBeginDate() {
        return projectBeginDate;
    }

    public void setProjectBeginDate(Date projectBeginDate) {
        this.projectBeginDate = projectBeginDate;
    }

    public Date getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
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
        OaProject other = (OaProject) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectTitle() == null ? other.getProjectTitle() == null : this.getProjectTitle().equals(other.getProjectTitle()))
            && (this.getProjectCustomer() == null ? other.getProjectCustomer() == null : this.getProjectCustomer().equals(other.getProjectCustomer()))
            && (this.getProjectStatus() == null ? other.getProjectStatus() == null : this.getProjectStatus().equals(other.getProjectStatus()))
            && (this.getProjectPeriod() == null ? other.getProjectPeriod() == null : this.getProjectPeriod().equals(other.getProjectPeriod()))
            && (this.getProjectContractMoney() == null ? other.getProjectContractMoney() == null : this.getProjectContractMoney().equals(other.getProjectContractMoney()))
            && (this.getProjectLeftMoney() == null ? other.getProjectLeftMoney() == null : this.getProjectLeftMoney().equals(other.getProjectLeftMoney()))
            && (this.getProjectEncourageMoney() == null ? other.getProjectEncourageMoney() == null : this.getProjectEncourageMoney().equals(other.getProjectEncourageMoney()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getProjectCode() == null ? other.getProjectCode() == null : this.getProjectCode().equals(other.getProjectCode()))
            && (this.getMarketPerson() == null ? other.getMarketPerson() == null : this.getMarketPerson().equals(other.getMarketPerson()))
            && (this.getMarketCost() == null ? other.getMarketCost() == null : this.getMarketCost().equals(other.getMarketCost()))
            && (this.getProjectEncourageLeader() == null ? other.getProjectEncourageLeader() == null : this.getProjectEncourageLeader().equals(other.getProjectEncourageLeader()))
            && (this.getProjectEncourageTeam() == null ? other.getProjectEncourageTeam() == null : this.getProjectEncourageTeam().equals(other.getProjectEncourageTeam()))
            && (this.getProjectBeginDate() == null ? other.getProjectBeginDate() == null : this.getProjectBeginDate().equals(other.getProjectBeginDate()))
            && (this.getProjectEndDate() == null ? other.getProjectEndDate() == null : this.getProjectEndDate().equals(other.getProjectEndDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectTitle() == null) ? 0 : getProjectTitle().hashCode());
        result = prime * result + ((getProjectCustomer() == null) ? 0 : getProjectCustomer().hashCode());
        result = prime * result + ((getProjectStatus() == null) ? 0 : getProjectStatus().hashCode());
        result = prime * result + ((getProjectPeriod() == null) ? 0 : getProjectPeriod().hashCode());
        result = prime * result + ((getProjectContractMoney() == null) ? 0 : getProjectContractMoney().hashCode());
        result = prime * result + ((getProjectLeftMoney() == null) ? 0 : getProjectLeftMoney().hashCode());
        result = prime * result + ((getProjectEncourageMoney() == null) ? 0 : getProjectEncourageMoney().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getProjectCode() == null) ? 0 : getProjectCode().hashCode());
        result = prime * result + ((getMarketPerson() == null) ? 0 : getMarketPerson().hashCode());
        result = prime * result + ((getMarketCost() == null) ? 0 : getMarketCost().hashCode());
        result = prime * result + ((getProjectEncourageLeader() == null) ? 0 : getProjectEncourageLeader().hashCode());
        result = prime * result + ((getProjectEncourageTeam() == null) ? 0 : getProjectEncourageTeam().hashCode());
        result = prime * result + ((getProjectBeginDate() == null) ? 0 : getProjectBeginDate().hashCode());
        result = prime * result + ((getProjectEndDate() == null) ? 0 : getProjectEndDate().hashCode());
        return result;
    }
}