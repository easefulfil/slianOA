package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaAttendanceAppeal {
    private Integer appealId;

    private String account;

    private String appealName;

    private String department;

    private Date attendanceTime;

    private String abnormalSituation;

    private Integer appealTimes;

    private String approveState;

    private String attendanceDetails;

    private Date appealDate;

    private String attendanceRules;

    private String appealReason;

    private String approveName;

    private Date approveDate;

    private String approveContent;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    public Integer getAppealId() {
        return appealId;
    }

    public void setAppealId(Integer appealId) {
        this.appealId = appealId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getAppealName() {
        return appealName;
    }

    public void setAppealName(String appealName) {
        this.appealName = appealName == null ? null : appealName.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Date getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public String getAbnormalSituation() {
        return abnormalSituation;
    }

    public void setAbnormalSituation(String abnormalSituation) {
        this.abnormalSituation = abnormalSituation == null ? null : abnormalSituation.trim();
    }

    public Integer getAppealTimes() {
        return appealTimes;
    }

    public void setAppealTimes(Integer appealTimes) {
        this.appealTimes = appealTimes;
    }

    public String getApproveState() {
        return approveState;
    }

    public void setApproveState(String approveState) {
        this.approveState = approveState == null ? null : approveState.trim();
    }

    public String getAttendanceDetails() {
        return attendanceDetails;
    }

    public void setAttendanceDetails(String attendanceDetails) {
        this.attendanceDetails = attendanceDetails == null ? null : attendanceDetails.trim();
    }

    public Date getAppealDate() {
        return appealDate;
    }

    public void setAppealDate(Date appealDate) {
        this.appealDate = appealDate;
    }

    public String getAttendanceRules() {
        return attendanceRules;
    }

    public void setAttendanceRules(String attendanceRules) {
        this.attendanceRules = attendanceRules == null ? null : attendanceRules.trim();
    }

    public String getAppealReason() {
        return appealReason;
    }

    public void setAppealReason(String appealReason) {
        this.appealReason = appealReason == null ? null : appealReason.trim();
    }

    public String getApproveName() {
        return approveName;
    }

    public void setApproveName(String approveName) {
        this.approveName = approveName == null ? null : approveName.trim();
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public String getApproveContent() {
        return approveContent;
    }

    public void setApproveContent(String approveContent) {
        this.approveContent = approveContent == null ? null : approveContent.trim();
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
        OaAttendanceAppeal other = (OaAttendanceAppeal) that;
        return (this.getAppealId() == null ? other.getAppealId() == null : this.getAppealId().equals(other.getAppealId()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getAppealName() == null ? other.getAppealName() == null : this.getAppealName().equals(other.getAppealName()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getAttendanceTime() == null ? other.getAttendanceTime() == null : this.getAttendanceTime().equals(other.getAttendanceTime()))
            && (this.getAbnormalSituation() == null ? other.getAbnormalSituation() == null : this.getAbnormalSituation().equals(other.getAbnormalSituation()))
            && (this.getAppealTimes() == null ? other.getAppealTimes() == null : this.getAppealTimes().equals(other.getAppealTimes()))
            && (this.getApproveState() == null ? other.getApproveState() == null : this.getApproveState().equals(other.getApproveState()))
            && (this.getAttendanceDetails() == null ? other.getAttendanceDetails() == null : this.getAttendanceDetails().equals(other.getAttendanceDetails()))
            && (this.getAppealDate() == null ? other.getAppealDate() == null : this.getAppealDate().equals(other.getAppealDate()))
            && (this.getAttendanceRules() == null ? other.getAttendanceRules() == null : this.getAttendanceRules().equals(other.getAttendanceRules()))
            && (this.getAppealReason() == null ? other.getAppealReason() == null : this.getAppealReason().equals(other.getAppealReason()))
            && (this.getApproveName() == null ? other.getApproveName() == null : this.getApproveName().equals(other.getApproveName()))
            && (this.getApproveDate() == null ? other.getApproveDate() == null : this.getApproveDate().equals(other.getApproveDate()))
            && (this.getApproveContent() == null ? other.getApproveContent() == null : this.getApproveContent().equals(other.getApproveContent()))
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
        result = prime * result + ((getAppealId() == null) ? 0 : getAppealId().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getAppealName() == null) ? 0 : getAppealName().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getAttendanceTime() == null) ? 0 : getAttendanceTime().hashCode());
        result = prime * result + ((getAbnormalSituation() == null) ? 0 : getAbnormalSituation().hashCode());
        result = prime * result + ((getAppealTimes() == null) ? 0 : getAppealTimes().hashCode());
        result = prime * result + ((getApproveState() == null) ? 0 : getApproveState().hashCode());
        result = prime * result + ((getAttendanceDetails() == null) ? 0 : getAttendanceDetails().hashCode());
        result = prime * result + ((getAppealDate() == null) ? 0 : getAppealDate().hashCode());
        result = prime * result + ((getAttendanceRules() == null) ? 0 : getAttendanceRules().hashCode());
        result = prime * result + ((getAppealReason() == null) ? 0 : getAppealReason().hashCode());
        result = prime * result + ((getApproveName() == null) ? 0 : getApproveName().hashCode());
        result = prime * result + ((getApproveDate() == null) ? 0 : getApproveDate().hashCode());
        result = prime * result + ((getApproveContent() == null) ? 0 : getApproveContent().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        return result;
    }
}