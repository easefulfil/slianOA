package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaOilCard {
    private Integer oilCardId;

    private Integer employeeId;

    private String ocNumber;

    private String ocCorp;

    private Date manageTime;

    private Double ocBalance;

    private Date balanceRegTime;

    private String remark;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    private String viewEmployeeIds;

    private byte[] isDelete;

    public Integer getOilCardId() {
        return oilCardId;
    }

    public void setOilCardId(Integer oilCardId) {
        this.oilCardId = oilCardId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getOcNumber() {
        return ocNumber;
    }

    public void setOcNumber(String ocNumber) {
        this.ocNumber = ocNumber == null ? null : ocNumber.trim();
    }

    public String getOcCorp() {
        return ocCorp;
    }

    public void setOcCorp(String ocCorp) {
        this.ocCorp = ocCorp == null ? null : ocCorp.trim();
    }

    public Date getManageTime() {
        return manageTime;
    }

    public void setManageTime(Date manageTime) {
        this.manageTime = manageTime;
    }

    public Double getOcBalance() {
        return ocBalance;
    }

    public void setOcBalance(Double ocBalance) {
        this.ocBalance = ocBalance;
    }

    public Date getBalanceRegTime() {
        return balanceRegTime;
    }

    public void setBalanceRegTime(Date balanceRegTime) {
        this.balanceRegTime = balanceRegTime;
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

    public String getViewEmployeeIds() {
        return viewEmployeeIds;
    }

    public void setViewEmployeeIds(String viewEmployeeIds) {
        this.viewEmployeeIds = viewEmployeeIds == null ? null : viewEmployeeIds.trim();
    }

    public byte[] getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(byte[] isDelete) {
        this.isDelete = isDelete;
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
        OaOilCard other = (OaOilCard) that;
        return (this.getOilCardId() == null ? other.getOilCardId() == null : this.getOilCardId().equals(other.getOilCardId()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getOcNumber() == null ? other.getOcNumber() == null : this.getOcNumber().equals(other.getOcNumber()))
            && (this.getOcCorp() == null ? other.getOcCorp() == null : this.getOcCorp().equals(other.getOcCorp()))
            && (this.getManageTime() == null ? other.getManageTime() == null : this.getManageTime().equals(other.getManageTime()))
            && (this.getOcBalance() == null ? other.getOcBalance() == null : this.getOcBalance().equals(other.getOcBalance()))
            && (this.getBalanceRegTime() == null ? other.getBalanceRegTime() == null : this.getBalanceRegTime().equals(other.getBalanceRegTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getViewEmployeeIds() == null ? other.getViewEmployeeIds() == null : this.getViewEmployeeIds().equals(other.getViewEmployeeIds()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOilCardId() == null) ? 0 : getOilCardId().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getOcNumber() == null) ? 0 : getOcNumber().hashCode());
        result = prime * result + ((getOcCorp() == null) ? 0 : getOcCorp().hashCode());
        result = prime * result + ((getManageTime() == null) ? 0 : getManageTime().hashCode());
        result = prime * result + ((getOcBalance() == null) ? 0 : getOcBalance().hashCode());
        result = prime * result + ((getBalanceRegTime() == null) ? 0 : getBalanceRegTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getViewEmployeeIds() == null) ? 0 : getViewEmployeeIds().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }
}