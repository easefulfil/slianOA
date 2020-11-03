package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaAttendanceRule {
    private Integer attendanceRuleId;

    private String attendName;

    private String attendAddress;

    private Double latitude;

    private Double longitude;

    private Integer scope;

    private Float workDays;

    private String signinTime;

    private String signinBeginTime;

    private String signinEndTime;

    private String signoutTime;

    private String signoutBeginTime;

    private String signoutEndtime;

    private String signLocationIds;

    private String unattendDays;

    private String viewEmployeeIds;

    private Integer isMonday;

    private Integer isTuesdany;

    private Integer isWednesday;

    private Integer isThursday;

    private Integer isFriday;

    private Integer isSaturday;

    private Integer isSunday;

    private String status;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    private Boolean isDelete;

    public Integer getAttendanceRuleId() {
        return attendanceRuleId;
    }

    public void setAttendanceRuleId(Integer attendanceRuleId) {
        this.attendanceRuleId = attendanceRuleId;
    }

    public String getAttendName() {
        return attendName;
    }

    public void setAttendName(String attendName) {
        this.attendName = attendName == null ? null : attendName.trim();
    }

    public String getAttendAddress() {
        return attendAddress;
    }

    public void setAttendAddress(String attendAddress) {
        this.attendAddress = attendAddress == null ? null : attendAddress.trim();
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    public Float getWorkDays() {
        return workDays;
    }

    public void setWorkDays(Float workDays) {
        this.workDays = workDays;
    }

    public String getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(String signinTime) {
        this.signinTime = signinTime == null ? null : signinTime.trim();
    }

    public String getSigninBeginTime() {
        return signinBeginTime;
    }

    public void setSigninBeginTime(String signinBeginTime) {
        this.signinBeginTime = signinBeginTime == null ? null : signinBeginTime.trim();
    }

    public String getSigninEndTime() {
        return signinEndTime;
    }

    public void setSigninEndTime(String signinEndTime) {
        this.signinEndTime = signinEndTime == null ? null : signinEndTime.trim();
    }

    public String getSignoutTime() {
        return signoutTime;
    }

    public void setSignoutTime(String signoutTime) {
        this.signoutTime = signoutTime == null ? null : signoutTime.trim();
    }

    public String getSignoutBeginTime() {
        return signoutBeginTime;
    }

    public void setSignoutBeginTime(String signoutBeginTime) {
        this.signoutBeginTime = signoutBeginTime == null ? null : signoutBeginTime.trim();
    }

    public String getSignoutEndtime() {
        return signoutEndtime;
    }

    public void setSignoutEndtime(String signoutEndtime) {
        this.signoutEndtime = signoutEndtime == null ? null : signoutEndtime.trim();
    }

    public String getSignLocationIds() {
        return signLocationIds;
    }

    public void setSignLocationIds(String signLocationIds) {
        this.signLocationIds = signLocationIds == null ? null : signLocationIds.trim();
    }

    public String getUnattendDays() {
        return unattendDays;
    }

    public void setUnattendDays(String unattendDays) {
        this.unattendDays = unattendDays == null ? null : unattendDays.trim();
    }

    public String getViewEmployeeIds() {
        return viewEmployeeIds;
    }

    public void setViewEmployeeIds(String viewEmployeeIds) {
        this.viewEmployeeIds = viewEmployeeIds == null ? null : viewEmployeeIds.trim();
    }

    public Integer getIsMonday() {
        return isMonday;
    }

    public void setIsMonday(Integer isMonday) {
        this.isMonday = isMonday;
    }

    public Integer getIsTuesdany() {
        return isTuesdany;
    }

    public void setIsTuesdany(Integer isTuesdany) {
        this.isTuesdany = isTuesdany;
    }

    public Integer getIsWednesday() {
        return isWednesday;
    }

    public void setIsWednesday(Integer isWednesday) {
        this.isWednesday = isWednesday;
    }

    public Integer getIsThursday() {
        return isThursday;
    }

    public void setIsThursday(Integer isThursday) {
        this.isThursday = isThursday;
    }

    public Integer getIsFriday() {
        return isFriday;
    }

    public void setIsFriday(Integer isFriday) {
        this.isFriday = isFriday;
    }

    public Integer getIsSaturday() {
        return isSaturday;
    }

    public void setIsSaturday(Integer isSaturday) {
        this.isSaturday = isSaturday;
    }

    public Integer getIsSunday() {
        return isSunday;
    }

    public void setIsSunday(Integer isSunday) {
        this.isSunday = isSunday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
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
        OaAttendanceRule other = (OaAttendanceRule) that;
        return (this.getAttendanceRuleId() == null ? other.getAttendanceRuleId() == null : this.getAttendanceRuleId().equals(other.getAttendanceRuleId()))
            && (this.getAttendName() == null ? other.getAttendName() == null : this.getAttendName().equals(other.getAttendName()))
            && (this.getAttendAddress() == null ? other.getAttendAddress() == null : this.getAttendAddress().equals(other.getAttendAddress()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getScope() == null ? other.getScope() == null : this.getScope().equals(other.getScope()))
            && (this.getWorkDays() == null ? other.getWorkDays() == null : this.getWorkDays().equals(other.getWorkDays()))
            && (this.getSigninTime() == null ? other.getSigninTime() == null : this.getSigninTime().equals(other.getSigninTime()))
            && (this.getSigninBeginTime() == null ? other.getSigninBeginTime() == null : this.getSigninBeginTime().equals(other.getSigninBeginTime()))
            && (this.getSigninEndTime() == null ? other.getSigninEndTime() == null : this.getSigninEndTime().equals(other.getSigninEndTime()))
            && (this.getSignoutTime() == null ? other.getSignoutTime() == null : this.getSignoutTime().equals(other.getSignoutTime()))
            && (this.getSignoutBeginTime() == null ? other.getSignoutBeginTime() == null : this.getSignoutBeginTime().equals(other.getSignoutBeginTime()))
            && (this.getSignoutEndtime() == null ? other.getSignoutEndtime() == null : this.getSignoutEndtime().equals(other.getSignoutEndtime()))
            && (this.getSignLocationIds() == null ? other.getSignLocationIds() == null : this.getSignLocationIds().equals(other.getSignLocationIds()))
            && (this.getUnattendDays() == null ? other.getUnattendDays() == null : this.getUnattendDays().equals(other.getUnattendDays()))
            && (this.getViewEmployeeIds() == null ? other.getViewEmployeeIds() == null : this.getViewEmployeeIds().equals(other.getViewEmployeeIds()))
            && (this.getIsMonday() == null ? other.getIsMonday() == null : this.getIsMonday().equals(other.getIsMonday()))
            && (this.getIsTuesdany() == null ? other.getIsTuesdany() == null : this.getIsTuesdany().equals(other.getIsTuesdany()))
            && (this.getIsWednesday() == null ? other.getIsWednesday() == null : this.getIsWednesday().equals(other.getIsWednesday()))
            && (this.getIsThursday() == null ? other.getIsThursday() == null : this.getIsThursday().equals(other.getIsThursday()))
            && (this.getIsFriday() == null ? other.getIsFriday() == null : this.getIsFriday().equals(other.getIsFriday()))
            && (this.getIsSaturday() == null ? other.getIsSaturday() == null : this.getIsSaturday().equals(other.getIsSaturday()))
            && (this.getIsSunday() == null ? other.getIsSunday() == null : this.getIsSunday().equals(other.getIsSunday()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAttendanceRuleId() == null) ? 0 : getAttendanceRuleId().hashCode());
        result = prime * result + ((getAttendName() == null) ? 0 : getAttendName().hashCode());
        result = prime * result + ((getAttendAddress() == null) ? 0 : getAttendAddress().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getScope() == null) ? 0 : getScope().hashCode());
        result = prime * result + ((getWorkDays() == null) ? 0 : getWorkDays().hashCode());
        result = prime * result + ((getSigninTime() == null) ? 0 : getSigninTime().hashCode());
        result = prime * result + ((getSigninBeginTime() == null) ? 0 : getSigninBeginTime().hashCode());
        result = prime * result + ((getSigninEndTime() == null) ? 0 : getSigninEndTime().hashCode());
        result = prime * result + ((getSignoutTime() == null) ? 0 : getSignoutTime().hashCode());
        result = prime * result + ((getSignoutBeginTime() == null) ? 0 : getSignoutBeginTime().hashCode());
        result = prime * result + ((getSignoutEndtime() == null) ? 0 : getSignoutEndtime().hashCode());
        result = prime * result + ((getSignLocationIds() == null) ? 0 : getSignLocationIds().hashCode());
        result = prime * result + ((getUnattendDays() == null) ? 0 : getUnattendDays().hashCode());
        result = prime * result + ((getViewEmployeeIds() == null) ? 0 : getViewEmployeeIds().hashCode());
        result = prime * result + ((getIsMonday() == null) ? 0 : getIsMonday().hashCode());
        result = prime * result + ((getIsTuesdany() == null) ? 0 : getIsTuesdany().hashCode());
        result = prime * result + ((getIsWednesday() == null) ? 0 : getIsWednesday().hashCode());
        result = prime * result + ((getIsThursday() == null) ? 0 : getIsThursday().hashCode());
        result = prime * result + ((getIsFriday() == null) ? 0 : getIsFriday().hashCode());
        result = prime * result + ((getIsSaturday() == null) ? 0 : getIsSaturday().hashCode());
        result = prime * result + ((getIsSunday() == null) ? 0 : getIsSunday().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }
}