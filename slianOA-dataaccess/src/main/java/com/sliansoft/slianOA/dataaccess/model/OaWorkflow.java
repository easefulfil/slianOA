package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaWorkflow {
    private Integer workflowId;

    private Integer workflowCustomId;

    private Integer employeeId;

    private String businessTable;

    private Integer businessId;

    private String title;

    private Date workflowTime;

    private String workflowResult;

    private String workflowOpinion;

    private Integer nextStep;

    private String workflowType;

    private String remark;

    private Integer accessGroup;

    private Integer creator;

    private Date createTime;

    private Integer amender;

    private Date amendTime;

    public Integer getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Integer workflowId) {
        this.workflowId = workflowId;
    }

    public Integer getWorkflowCustomId() {
        return workflowCustomId;
    }

    public void setWorkflowCustomId(Integer workflowCustomId) {
        this.workflowCustomId = workflowCustomId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getBusinessTable() {
        return businessTable;
    }

    public void setBusinessTable(String businessTable) {
        this.businessTable = businessTable == null ? null : businessTable.trim();
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getWorkflowTime() {
        return workflowTime;
    }

    public void setWorkflowTime(Date workflowTime) {
        this.workflowTime = workflowTime;
    }

    public String getWorkflowResult() {
        return workflowResult;
    }

    public void setWorkflowResult(String workflowResult) {
        this.workflowResult = workflowResult == null ? null : workflowResult.trim();
    }

    public String getWorkflowOpinion() {
        return workflowOpinion;
    }

    public void setWorkflowOpinion(String workflowOpinion) {
        this.workflowOpinion = workflowOpinion == null ? null : workflowOpinion.trim();
    }

    public Integer getNextStep() {
        return nextStep;
    }

    public void setNextStep(Integer nextStep) {
        this.nextStep = nextStep;
    }

    public String getWorkflowType() {
        return workflowType;
    }

    public void setWorkflowType(String workflowType) {
        this.workflowType = workflowType == null ? null : workflowType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        OaWorkflow other = (OaWorkflow) that;
        return (this.getWorkflowId() == null ? other.getWorkflowId() == null : this.getWorkflowId().equals(other.getWorkflowId()))
            && (this.getWorkflowCustomId() == null ? other.getWorkflowCustomId() == null : this.getWorkflowCustomId().equals(other.getWorkflowCustomId()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getBusinessTable() == null ? other.getBusinessTable() == null : this.getBusinessTable().equals(other.getBusinessTable()))
            && (this.getBusinessId() == null ? other.getBusinessId() == null : this.getBusinessId().equals(other.getBusinessId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getWorkflowTime() == null ? other.getWorkflowTime() == null : this.getWorkflowTime().equals(other.getWorkflowTime()))
            && (this.getWorkflowResult() == null ? other.getWorkflowResult() == null : this.getWorkflowResult().equals(other.getWorkflowResult()))
            && (this.getWorkflowOpinion() == null ? other.getWorkflowOpinion() == null : this.getWorkflowOpinion().equals(other.getWorkflowOpinion()))
            && (this.getNextStep() == null ? other.getNextStep() == null : this.getNextStep().equals(other.getNextStep()))
            && (this.getWorkflowType() == null ? other.getWorkflowType() == null : this.getWorkflowType().equals(other.getWorkflowType()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getWorkflowId() == null) ? 0 : getWorkflowId().hashCode());
        result = prime * result + ((getWorkflowCustomId() == null) ? 0 : getWorkflowCustomId().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getBusinessTable() == null) ? 0 : getBusinessTable().hashCode());
        result = prime * result + ((getBusinessId() == null) ? 0 : getBusinessId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getWorkflowTime() == null) ? 0 : getWorkflowTime().hashCode());
        result = prime * result + ((getWorkflowResult() == null) ? 0 : getWorkflowResult().hashCode());
        result = prime * result + ((getWorkflowOpinion() == null) ? 0 : getWorkflowOpinion().hashCode());
        result = prime * result + ((getNextStep() == null) ? 0 : getNextStep().hashCode());
        result = prime * result + ((getWorkflowType() == null) ? 0 : getWorkflowType().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        return result;
    }
}