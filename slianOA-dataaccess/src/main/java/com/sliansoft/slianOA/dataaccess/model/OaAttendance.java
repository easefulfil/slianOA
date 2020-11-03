package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaAttendance {
    private Integer attendanceId;

    private Integer attendanceRuleId;

    private Date signDate;

    private String signinAddress;

    private Double signinLatitude;

    private Double signinLongitude;

    private String signinStatus;

    private String signinRemark;

    private Date signinTime;

    private String signoutAddress;

    private Double signoutLatitude;

    private Double signoutLongitude;

    private Date signoutTime;

    private String signoutStatus;

    private String signoutRemark;

    private String status;

    private String remark;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    private String approval;

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Integer getAttendanceRuleId() {
        return attendanceRuleId;
    }

    public void setAttendanceRuleId(Integer attendanceRuleId) {
        this.attendanceRuleId = attendanceRuleId;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getSigninAddress() {
        return signinAddress;
    }

    public void setSigninAddress(String signinAddress) {
        this.signinAddress = signinAddress == null ? null : signinAddress.trim();
    }

    public Double getSigninLatitude() {
        return signinLatitude;
    }

    public void setSigninLatitude(Double signinLatitude) {
        this.signinLatitude = signinLatitude;
    }

    public Double getSigninLongitude() {
        return signinLongitude;
    }

    public void setSigninLongitude(Double signinLongitude) {
        this.signinLongitude = signinLongitude;
    }

    public String getSigninStatus() {
        return signinStatus;
    }

    public void setSigninStatus(String signinStatus) {
        this.signinStatus = signinStatus == null ? null : signinStatus.trim();
    }

    public String getSigninRemark() {
        return signinRemark;
    }

    public void setSigninRemark(String signinRemark) {
        this.signinRemark = signinRemark == null ? null : signinRemark.trim();
    }

    public Date getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(Date signinTime) {
        this.signinTime = signinTime;
    }

    public String getSignoutAddress() {
        return signoutAddress;
    }

    public void setSignoutAddress(String signoutAddress) {
        this.signoutAddress = signoutAddress == null ? null : signoutAddress.trim();
    }

    public Double getSignoutLatitude() {
        return signoutLatitude;
    }

    public void setSignoutLatitude(Double signoutLatitude) {
        this.signoutLatitude = signoutLatitude;
    }

    public Double getSignoutLongitude() {
        return signoutLongitude;
    }

    public void setSignoutLongitude(Double signoutLongitude) {
        this.signoutLongitude = signoutLongitude;
    }

    public Date getSignoutTime() {
        return signoutTime;
    }

    public void setSignoutTime(Date signoutTime) {
        this.signoutTime = signoutTime;
    }

    public String getSignoutStatus() {
        return signoutStatus;
    }

    public void setSignoutStatus(String signoutStatus) {
        this.signoutStatus = signoutStatus == null ? null : signoutStatus.trim();
    }

    public String getSignoutRemark() {
        return signoutRemark;
    }

    public void setSignoutRemark(String signoutRemark) {
        this.signoutRemark = signoutRemark == null ? null : signoutRemark.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval == null ? null : approval.trim();
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
        OaAttendance other = (OaAttendance) that;
        return (this.getAttendanceId() == null ? other.getAttendanceId() == null : this.getAttendanceId().equals(other.getAttendanceId()))
            && (this.getAttendanceRuleId() == null ? other.getAttendanceRuleId() == null : this.getAttendanceRuleId().equals(other.getAttendanceRuleId()))
            && (this.getSignDate() == null ? other.getSignDate() == null : this.getSignDate().equals(other.getSignDate()))
            && (this.getSigninAddress() == null ? other.getSigninAddress() == null : this.getSigninAddress().equals(other.getSigninAddress()))
            && (this.getSigninLatitude() == null ? other.getSigninLatitude() == null : this.getSigninLatitude().equals(other.getSigninLatitude()))
            && (this.getSigninLongitude() == null ? other.getSigninLongitude() == null : this.getSigninLongitude().equals(other.getSigninLongitude()))
            && (this.getSigninStatus() == null ? other.getSigninStatus() == null : this.getSigninStatus().equals(other.getSigninStatus()))
            && (this.getSigninRemark() == null ? other.getSigninRemark() == null : this.getSigninRemark().equals(other.getSigninRemark()))
            && (this.getSigninTime() == null ? other.getSigninTime() == null : this.getSigninTime().equals(other.getSigninTime()))
            && (this.getSignoutAddress() == null ? other.getSignoutAddress() == null : this.getSignoutAddress().equals(other.getSignoutAddress()))
            && (this.getSignoutLatitude() == null ? other.getSignoutLatitude() == null : this.getSignoutLatitude().equals(other.getSignoutLatitude()))
            && (this.getSignoutLongitude() == null ? other.getSignoutLongitude() == null : this.getSignoutLongitude().equals(other.getSignoutLongitude()))
            && (this.getSignoutTime() == null ? other.getSignoutTime() == null : this.getSignoutTime().equals(other.getSignoutTime()))
            && (this.getSignoutStatus() == null ? other.getSignoutStatus() == null : this.getSignoutStatus().equals(other.getSignoutStatus()))
            && (this.getSignoutRemark() == null ? other.getSignoutRemark() == null : this.getSignoutRemark().equals(other.getSignoutRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getApproval() == null ? other.getApproval() == null : this.getApproval().equals(other.getApproval()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAttendanceId() == null) ? 0 : getAttendanceId().hashCode());
        result = prime * result + ((getAttendanceRuleId() == null) ? 0 : getAttendanceRuleId().hashCode());
        result = prime * result + ((getSignDate() == null) ? 0 : getSignDate().hashCode());
        result = prime * result + ((getSigninAddress() == null) ? 0 : getSigninAddress().hashCode());
        result = prime * result + ((getSigninLatitude() == null) ? 0 : getSigninLatitude().hashCode());
        result = prime * result + ((getSigninLongitude() == null) ? 0 : getSigninLongitude().hashCode());
        result = prime * result + ((getSigninStatus() == null) ? 0 : getSigninStatus().hashCode());
        result = prime * result + ((getSigninRemark() == null) ? 0 : getSigninRemark().hashCode());
        result = prime * result + ((getSigninTime() == null) ? 0 : getSigninTime().hashCode());
        result = prime * result + ((getSignoutAddress() == null) ? 0 : getSignoutAddress().hashCode());
        result = prime * result + ((getSignoutLatitude() == null) ? 0 : getSignoutLatitude().hashCode());
        result = prime * result + ((getSignoutLongitude() == null) ? 0 : getSignoutLongitude().hashCode());
        result = prime * result + ((getSignoutTime() == null) ? 0 : getSignoutTime().hashCode());
        result = prime * result + ((getSignoutStatus() == null) ? 0 : getSignoutStatus().hashCode());
        result = prime * result + ((getSignoutRemark() == null) ? 0 : getSignoutRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getApproval() == null) ? 0 : getApproval().hashCode());
        return result;
    }
}