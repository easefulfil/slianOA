package com.sliansoft.slianOA.dataaccess.model;

import java.math.BigDecimal;
import java.util.Date;

public class OaProjectCharge {
    private Integer projectChargeId;

    private Integer accessGroup;

    private Date amendTime;

    private Integer creator;

    private Date createTime;

    private Integer amender;

    private Integer isDelete;

    private Date chargeDate;

    private BigDecimal chargeMoney;

    private Integer projectId;

    private String remark;

    private String chargeStatus;

    private Date factDate;

    public Integer getProjectChargeId() {
        return projectChargeId;
    }

    public void setProjectChargeId(Integer projectChargeId) {
        this.projectChargeId = projectChargeId;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }

    public BigDecimal getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(BigDecimal chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getChargeStatus() {
        return chargeStatus;
    }

    public void setChargeStatus(String chargeStatus) {
        this.chargeStatus = chargeStatus == null ? null : chargeStatus.trim();
    }

    public Date getFactDate() {
        return factDate;
    }

    public void setFactDate(Date factDate) {
        this.factDate = factDate;
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
        OaProjectCharge other = (OaProjectCharge) that;
        return (this.getProjectChargeId() == null ? other.getProjectChargeId() == null : this.getProjectChargeId().equals(other.getProjectChargeId()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getChargeDate() == null ? other.getChargeDate() == null : this.getChargeDate().equals(other.getChargeDate()))
            && (this.getChargeMoney() == null ? other.getChargeMoney() == null : this.getChargeMoney().equals(other.getChargeMoney()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getChargeStatus() == null ? other.getChargeStatus() == null : this.getChargeStatus().equals(other.getChargeStatus()))
            && (this.getFactDate() == null ? other.getFactDate() == null : this.getFactDate().equals(other.getFactDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectChargeId() == null) ? 0 : getProjectChargeId().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getChargeDate() == null) ? 0 : getChargeDate().hashCode());
        result = prime * result + ((getChargeMoney() == null) ? 0 : getChargeMoney().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getChargeStatus() == null) ? 0 : getChargeStatus().hashCode());
        result = prime * result + ((getFactDate() == null) ? 0 : getFactDate().hashCode());
        return result;
    }
}