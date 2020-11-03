package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaUnattendDays {
    private Integer unattendDaysId;

    private String unattendReason;

    private Date unattendDay;

    private Integer isOverdue;

    private String remark;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    public Integer getUnattendDaysId() {
        return unattendDaysId;
    }

    public void setUnattendDaysId(Integer unattendDaysId) {
        this.unattendDaysId = unattendDaysId;
    }

    public String getUnattendReason() {
        return unattendReason;
    }

    public void setUnattendReason(String unattendReason) {
        this.unattendReason = unattendReason == null ? null : unattendReason.trim();
    }

    public Date getUnattendDay() {
        return unattendDay;
    }

    public void setUnattendDay(Date unattendDay) {
        this.unattendDay = unattendDay;
    }

    public Integer getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(Integer isOverdue) {
        this.isOverdue = isOverdue;
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
        OaUnattendDays other = (OaUnattendDays) that;
        return (this.getUnattendDaysId() == null ? other.getUnattendDaysId() == null : this.getUnattendDaysId().equals(other.getUnattendDaysId()))
            && (this.getUnattendReason() == null ? other.getUnattendReason() == null : this.getUnattendReason().equals(other.getUnattendReason()))
            && (this.getUnattendDay() == null ? other.getUnattendDay() == null : this.getUnattendDay().equals(other.getUnattendDay()))
            && (this.getIsOverdue() == null ? other.getIsOverdue() == null : this.getIsOverdue().equals(other.getIsOverdue()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUnattendDaysId() == null) ? 0 : getUnattendDaysId().hashCode());
        result = prime * result + ((getUnattendReason() == null) ? 0 : getUnattendReason().hashCode());
        result = prime * result + ((getUnattendDay() == null) ? 0 : getUnattendDay().hashCode());
        result = prime * result + ((getIsOverdue() == null) ? 0 : getIsOverdue().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        return result;
    }
}