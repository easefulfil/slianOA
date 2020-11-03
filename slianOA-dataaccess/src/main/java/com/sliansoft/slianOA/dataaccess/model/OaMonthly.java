package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaMonthly {
    private Integer monthlyId;

    private Integer employeeId;

    private String employeeName;

    private String department;

    private Integer needAttendanceDays;

    private Integer realAttendanceDays;

    private Integer lateTimes;

    private Integer lateMinutes;

    private Integer leaveEarlyTimes;

    private Integer leaveEarlyMinutes;

    private Integer absentDays;

    private Integer casualLeaveDays;

    private Integer sickLeaveDays;

    private Integer otherLeaveDays;

    private String dateDetails;

    private Integer creator;

    private Date createTime;

    private Integer accessGroup;

    private Integer amender;

    private Date amendTime;

    public Integer getMonthlyId() {
        return monthlyId;
    }

    public void setMonthlyId(Integer monthlyId) {
        this.monthlyId = monthlyId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Integer getNeedAttendanceDays() {
        return needAttendanceDays;
    }

    public void setNeedAttendanceDays(Integer needAttendanceDays) {
        this.needAttendanceDays = needAttendanceDays;
    }

    public Integer getRealAttendanceDays() {
        return realAttendanceDays;
    }

    public void setRealAttendanceDays(Integer realAttendanceDays) {
        this.realAttendanceDays = realAttendanceDays;
    }

    public Integer getLateTimes() {
        return lateTimes;
    }

    public void setLateTimes(Integer lateTimes) {
        this.lateTimes = lateTimes;
    }

    public Integer getLateMinutes() {
        return lateMinutes;
    }

    public void setLateMinutes(Integer lateMinutes) {
        this.lateMinutes = lateMinutes;
    }

    public Integer getLeaveEarlyTimes() {
        return leaveEarlyTimes;
    }

    public void setLeaveEarlyTimes(Integer leaveEarlyTimes) {
        this.leaveEarlyTimes = leaveEarlyTimes;
    }

    public Integer getLeaveEarlyMinutes() {
        return leaveEarlyMinutes;
    }

    public void setLeaveEarlyMinutes(Integer leaveEarlyMinutes) {
        this.leaveEarlyMinutes = leaveEarlyMinutes;
    }

    public Integer getAbsentDays() {
        return absentDays;
    }

    public void setAbsentDays(Integer absentDays) {
        this.absentDays = absentDays;
    }

    public Integer getCasualLeaveDays() {
        return casualLeaveDays;
    }

    public void setCasualLeaveDays(Integer casualLeaveDays) {
        this.casualLeaveDays = casualLeaveDays;
    }

    public Integer getSickLeaveDays() {
        return sickLeaveDays;
    }

    public void setSickLeaveDays(Integer sickLeaveDays) {
        this.sickLeaveDays = sickLeaveDays;
    }

    public Integer getOtherLeaveDays() {
        return otherLeaveDays;
    }

    public void setOtherLeaveDays(Integer otherLeaveDays) {
        this.otherLeaveDays = otherLeaveDays;
    }

    public String getDateDetails() {
        return dateDetails;
    }

    public void setDateDetails(String dateDetails) {
        this.dateDetails = dateDetails == null ? null : dateDetails.trim();
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

    public Integer getAccessGroup() {
        return accessGroup;
    }

    public void setAccessGroup(Integer accessGroup) {
        this.accessGroup = accessGroup;
    }

    public Integer getAmender() {
        return amender;
    }

    public void setAmender(Integer amender) {
        this.amender = amender;
    }

    public Date getAmendTime() {
        return amendTime;
    }

    public void setAmendTime(Date amendTime) {
        this.amendTime = amendTime;
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
        OaMonthly other = (OaMonthly) that;
        return (this.getMonthlyId() == null ? other.getMonthlyId() == null : this.getMonthlyId().equals(other.getMonthlyId()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getEmployeeName() == null ? other.getEmployeeName() == null : this.getEmployeeName().equals(other.getEmployeeName()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getNeedAttendanceDays() == null ? other.getNeedAttendanceDays() == null : this.getNeedAttendanceDays().equals(other.getNeedAttendanceDays()))
            && (this.getRealAttendanceDays() == null ? other.getRealAttendanceDays() == null : this.getRealAttendanceDays().equals(other.getRealAttendanceDays()))
            && (this.getLateTimes() == null ? other.getLateTimes() == null : this.getLateTimes().equals(other.getLateTimes()))
            && (this.getLateMinutes() == null ? other.getLateMinutes() == null : this.getLateMinutes().equals(other.getLateMinutes()))
            && (this.getLeaveEarlyTimes() == null ? other.getLeaveEarlyTimes() == null : this.getLeaveEarlyTimes().equals(other.getLeaveEarlyTimes()))
            && (this.getLeaveEarlyMinutes() == null ? other.getLeaveEarlyMinutes() == null : this.getLeaveEarlyMinutes().equals(other.getLeaveEarlyMinutes()))
            && (this.getAbsentDays() == null ? other.getAbsentDays() == null : this.getAbsentDays().equals(other.getAbsentDays()))
            && (this.getCasualLeaveDays() == null ? other.getCasualLeaveDays() == null : this.getCasualLeaveDays().equals(other.getCasualLeaveDays()))
            && (this.getSickLeaveDays() == null ? other.getSickLeaveDays() == null : this.getSickLeaveDays().equals(other.getSickLeaveDays()))
            && (this.getOtherLeaveDays() == null ? other.getOtherLeaveDays() == null : this.getOtherLeaveDays().equals(other.getOtherLeaveDays()))
            && (this.getDateDetails() == null ? other.getDateDetails() == null : this.getDateDetails().equals(other.getDateDetails()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMonthlyId() == null) ? 0 : getMonthlyId().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getEmployeeName() == null) ? 0 : getEmployeeName().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getNeedAttendanceDays() == null) ? 0 : getNeedAttendanceDays().hashCode());
        result = prime * result + ((getRealAttendanceDays() == null) ? 0 : getRealAttendanceDays().hashCode());
        result = prime * result + ((getLateTimes() == null) ? 0 : getLateTimes().hashCode());
        result = prime * result + ((getLateMinutes() == null) ? 0 : getLateMinutes().hashCode());
        result = prime * result + ((getLeaveEarlyTimes() == null) ? 0 : getLeaveEarlyTimes().hashCode());
        result = prime * result + ((getLeaveEarlyMinutes() == null) ? 0 : getLeaveEarlyMinutes().hashCode());
        result = prime * result + ((getAbsentDays() == null) ? 0 : getAbsentDays().hashCode());
        result = prime * result + ((getCasualLeaveDays() == null) ? 0 : getCasualLeaveDays().hashCode());
        result = prime * result + ((getSickLeaveDays() == null) ? 0 : getSickLeaveDays().hashCode());
        result = prime * result + ((getOtherLeaveDays() == null) ? 0 : getOtherLeaveDays().hashCode());
        result = prime * result + ((getDateDetails() == null) ? 0 : getDateDetails().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        return result;
    }
}