package com.sliansoft.slianOA.dataaccess.model;

import java.math.BigDecimal;
import java.util.Date;

public class OaSuitCharging {
    private Integer suitChargingId;

    private Integer employeeId;

    private Integer suitId;

    private Date suitTime;

    private BigDecimal suitMoney;

    private String remark;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    private Integer accessGroup;

    public Integer getSuitChargingId() {
        return suitChargingId;
    }

    public void setSuitChargingId(Integer suitChargingId) {
        this.suitChargingId = suitChargingId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getSuitId() {
        return suitId;
    }

    public void setSuitId(Integer suitId) {
        this.suitId = suitId;
    }

    public Date getSuitTime() {
        return suitTime;
    }

    public void setSuitTime(Date suitTime) {
        this.suitTime = suitTime;
    }

    public BigDecimal getSuitMoney() {
        return suitMoney;
    }

    public void setSuitMoney(BigDecimal suitMoney) {
        this.suitMoney = suitMoney;
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

    public Integer getAccessGroup() {
        return accessGroup;
    }

    public void setAccessGroup(Integer accessGroup) {
        this.accessGroup = accessGroup;
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
        OaSuitCharging other = (OaSuitCharging) that;
        return (this.getSuitChargingId() == null ? other.getSuitChargingId() == null : this.getSuitChargingId().equals(other.getSuitChargingId()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getSuitId() == null ? other.getSuitId() == null : this.getSuitId().equals(other.getSuitId()))
            && (this.getSuitTime() == null ? other.getSuitTime() == null : this.getSuitTime().equals(other.getSuitTime()))
            && (this.getSuitMoney() == null ? other.getSuitMoney() == null : this.getSuitMoney().equals(other.getSuitMoney()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSuitChargingId() == null) ? 0 : getSuitChargingId().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getSuitId() == null) ? 0 : getSuitId().hashCode());
        result = prime * result + ((getSuitTime() == null) ? 0 : getSuitTime().hashCode());
        result = prime * result + ((getSuitMoney() == null) ? 0 : getSuitMoney().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        return result;
    }
}