package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaInstrumentCalibration {
    private Integer calibrationId;

    private Integer instrumentId;

    private Date calibrationTime;

    private String calibrationContent;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    public Integer getCalibrationId() {
        return calibrationId;
    }

    public void setCalibrationId(Integer calibrationId) {
        this.calibrationId = calibrationId;
    }

    public Integer getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Integer instrumentId) {
        this.instrumentId = instrumentId;
    }

    public Date getCalibrationTime() {
        return calibrationTime;
    }

    public void setCalibrationTime(Date calibrationTime) {
        this.calibrationTime = calibrationTime;
    }

    public String getCalibrationContent() {
        return calibrationContent;
    }

    public void setCalibrationContent(String calibrationContent) {
        this.calibrationContent = calibrationContent == null ? null : calibrationContent.trim();
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
        OaInstrumentCalibration other = (OaInstrumentCalibration) that;
        return (this.getCalibrationId() == null ? other.getCalibrationId() == null : this.getCalibrationId().equals(other.getCalibrationId()))
            && (this.getInstrumentId() == null ? other.getInstrumentId() == null : this.getInstrumentId().equals(other.getInstrumentId()))
            && (this.getCalibrationTime() == null ? other.getCalibrationTime() == null : this.getCalibrationTime().equals(other.getCalibrationTime()))
            && (this.getCalibrationContent() == null ? other.getCalibrationContent() == null : this.getCalibrationContent().equals(other.getCalibrationContent()))
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
        result = prime * result + ((getCalibrationId() == null) ? 0 : getCalibrationId().hashCode());
        result = prime * result + ((getInstrumentId() == null) ? 0 : getInstrumentId().hashCode());
        result = prime * result + ((getCalibrationTime() == null) ? 0 : getCalibrationTime().hashCode());
        result = prime * result + ((getCalibrationContent() == null) ? 0 : getCalibrationContent().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        return result;
    }
}