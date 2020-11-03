package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaWorkflowCustom {
    private Integer workflowCustomId;

    private String name;

    private String businessTable;

    private String workflowCustom;

    private Integer accessGroup;

    private String remark;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    public Integer getWorkflowCustomId() {
        return workflowCustomId;
    }

    public void setWorkflowCustomId(Integer workflowCustomId) {
        this.workflowCustomId = workflowCustomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBusinessTable() {
        return businessTable;
    }

    public void setBusinessTable(String businessTable) {
        this.businessTable = businessTable == null ? null : businessTable.trim();
    }

    public String getWorkflowCustom() {
        return workflowCustom;
    }

    public void setWorkflowCustom(String workflowCustom) {
        this.workflowCustom = workflowCustom == null ? null : workflowCustom.trim();
    }

    public Integer getAccessGroup() {
        return accessGroup;
    }

    public void setAccessGroup(Integer accessGroup) {
        this.accessGroup = accessGroup;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        OaWorkflowCustom other = (OaWorkflowCustom) that;
        return (this.getWorkflowCustomId() == null ? other.getWorkflowCustomId() == null : this.getWorkflowCustomId().equals(other.getWorkflowCustomId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getBusinessTable() == null ? other.getBusinessTable() == null : this.getBusinessTable().equals(other.getBusinessTable()))
            && (this.getWorkflowCustom() == null ? other.getWorkflowCustom() == null : this.getWorkflowCustom().equals(other.getWorkflowCustom()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWorkflowCustomId() == null) ? 0 : getWorkflowCustomId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getBusinessTable() == null) ? 0 : getBusinessTable().hashCode());
        result = prime * result + ((getWorkflowCustom() == null) ? 0 : getWorkflowCustom().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        return result;
    }
}