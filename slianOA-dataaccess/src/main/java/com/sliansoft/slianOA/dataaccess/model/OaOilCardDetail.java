package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaOilCardDetail {
    private Integer oilCardDetailId;

    private Integer vehicleId;

    private Integer oilCardId;

    private Integer employeeId;

    private Double ocdAmount;

    private String ocdStyle;

    private Date ocdParTime;

    private String remark;

    private Integer accessGroup;

    private Date createTime;

    private Integer creator;

    private Date amendTime;

    private Integer amender;

    private String viewEmployeeIds;

    private byte[] isDelete;

    public Integer getOilCardDetailId() {
        return oilCardDetailId;
    }

    public void setOilCardDetailId(Integer oilCardDetailId) {
        this.oilCardDetailId = oilCardDetailId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

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

    public Double getOcdAmount() {
        return ocdAmount;
    }

    public void setOcdAmount(Double ocdAmount) {
        this.ocdAmount = ocdAmount;
    }

    public String getOcdStyle() {
        return ocdStyle;
    }

    public void setOcdStyle(String ocdStyle) {
        this.ocdStyle = ocdStyle == null ? null : ocdStyle.trim();
    }

    public Date getOcdParTime() {
        return ocdParTime;
    }

    public void setOcdParTime(Date ocdParTime) {
        this.ocdParTime = ocdParTime;
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
        OaOilCardDetail other = (OaOilCardDetail) that;
        return (this.getOilCardDetailId() == null ? other.getOilCardDetailId() == null : this.getOilCardDetailId().equals(other.getOilCardDetailId()))
            && (this.getVehicleId() == null ? other.getVehicleId() == null : this.getVehicleId().equals(other.getVehicleId()))
            && (this.getOilCardId() == null ? other.getOilCardId() == null : this.getOilCardId().equals(other.getOilCardId()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getOcdAmount() == null ? other.getOcdAmount() == null : this.getOcdAmount().equals(other.getOcdAmount()))
            && (this.getOcdStyle() == null ? other.getOcdStyle() == null : this.getOcdStyle().equals(other.getOcdStyle()))
            && (this.getOcdParTime() == null ? other.getOcdParTime() == null : this.getOcdParTime().equals(other.getOcdParTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getViewEmployeeIds() == null ? other.getViewEmployeeIds() == null : this.getViewEmployeeIds().equals(other.getViewEmployeeIds()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOilCardDetailId() == null) ? 0 : getOilCardDetailId().hashCode());
        result = prime * result + ((getVehicleId() == null) ? 0 : getVehicleId().hashCode());
        result = prime * result + ((getOilCardId() == null) ? 0 : getOilCardId().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getOcdAmount() == null) ? 0 : getOcdAmount().hashCode());
        result = prime * result + ((getOcdStyle() == null) ? 0 : getOcdStyle().hashCode());
        result = prime * result + ((getOcdParTime() == null) ? 0 : getOcdParTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getViewEmployeeIds() == null) ? 0 : getViewEmployeeIds().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }
}