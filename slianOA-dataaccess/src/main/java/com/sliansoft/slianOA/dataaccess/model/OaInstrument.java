package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaInstrument {
    private Integer instrumentId;

    private String instrumentName;

    private String instrumentCode;

    private String remark;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    private Integer isDelete;

    private Date buyDate;

    private Date calibrationTime;

    private String calibrationStatus;

    public Integer getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Integer instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName == null ? null : instrumentName.trim();
    }

    public String getInstrumentCode() {
        return instrumentCode;
    }

    public void setInstrumentCode(String instrumentCode) {
        this.instrumentCode = instrumentCode == null ? null : instrumentCode.trim();
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getCalibrationTime() {
        return calibrationTime;
    }

    public void setCalibrationTime(Date calibrationTime) {
        this.calibrationTime = calibrationTime;
    }

    public String getCalibrationStatus() {
        return calibrationStatus;
    }

    public void setCalibrationStatus(String calibrationStatus) {
        this.calibrationStatus = calibrationStatus == null ? null : calibrationStatus.trim();
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
        OaInstrument other = (OaInstrument) that;
        return (this.getInstrumentId() == null ? other.getInstrumentId() == null : this.getInstrumentId().equals(other.getInstrumentId()))
            && (this.getInstrumentName() == null ? other.getInstrumentName() == null : this.getInstrumentName().equals(other.getInstrumentName()))
            && (this.getInstrumentCode() == null ? other.getInstrumentCode() == null : this.getInstrumentCode().equals(other.getInstrumentCode()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getBuyDate() == null ? other.getBuyDate() == null : this.getBuyDate().equals(other.getBuyDate()))
            && (this.getCalibrationTime() == null ? other.getCalibrationTime() == null : this.getCalibrationTime().equals(other.getCalibrationTime()))
            && (this.getCalibrationStatus() == null ? other.getCalibrationStatus() == null : this.getCalibrationStatus().equals(other.getCalibrationStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInstrumentId() == null) ? 0 : getInstrumentId().hashCode());
        result = prime * result + ((getInstrumentName() == null) ? 0 : getInstrumentName().hashCode());
        result = prime * result + ((getInstrumentCode() == null) ? 0 : getInstrumentCode().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getBuyDate() == null) ? 0 : getBuyDate().hashCode());
        result = prime * result + ((getCalibrationTime() == null) ? 0 : getCalibrationTime().hashCode());
        result = prime * result + ((getCalibrationStatus() == null) ? 0 : getCalibrationStatus().hashCode());
        return result;
    }
}