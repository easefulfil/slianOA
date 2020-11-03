package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaMeetingTrain {
    private Integer meetingTrainId;

    private Integer employeeId;

    private String mtNumbers;

    private String mtSite;

    private Date mtTime;

    private String title;

    private String mtJoinPersons;

    private String type;

    private String viewEmployeeIds;

    private String remark;

    private String status;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    private String content;

    public Integer getMeetingTrainId() {
        return meetingTrainId;
    }

    public void setMeetingTrainId(Integer meetingTrainId) {
        this.meetingTrainId = meetingTrainId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getMtNumbers() {
        return mtNumbers;
    }

    public void setMtNumbers(String mtNumbers) {
        this.mtNumbers = mtNumbers == null ? null : mtNumbers.trim();
    }

    public String getMtSite() {
        return mtSite;
    }

    public void setMtSite(String mtSite) {
        this.mtSite = mtSite == null ? null : mtSite.trim();
    }

    public Date getMtTime() {
        return mtTime;
    }

    public void setMtTime(Date mtTime) {
        this.mtTime = mtTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMtJoinPersons() {
        return mtJoinPersons;
    }

    public void setMtJoinPersons(String mtJoinPersons) {
        this.mtJoinPersons = mtJoinPersons == null ? null : mtJoinPersons.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getViewEmployeeIds() {
        return viewEmployeeIds;
    }

    public void setViewEmployeeIds(String viewEmployeeIds) {
        this.viewEmployeeIds = viewEmployeeIds == null ? null : viewEmployeeIds.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        OaMeetingTrain other = (OaMeetingTrain) that;
        return (this.getMeetingTrainId() == null ? other.getMeetingTrainId() == null : this.getMeetingTrainId().equals(other.getMeetingTrainId()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getMtNumbers() == null ? other.getMtNumbers() == null : this.getMtNumbers().equals(other.getMtNumbers()))
            && (this.getMtSite() == null ? other.getMtSite() == null : this.getMtSite().equals(other.getMtSite()))
            && (this.getMtTime() == null ? other.getMtTime() == null : this.getMtTime().equals(other.getMtTime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getMtJoinPersons() == null ? other.getMtJoinPersons() == null : this.getMtJoinPersons().equals(other.getMtJoinPersons()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getViewEmployeeIds() == null ? other.getViewEmployeeIds() == null : this.getViewEmployeeIds().equals(other.getViewEmployeeIds()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMeetingTrainId() == null) ? 0 : getMeetingTrainId().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getMtNumbers() == null) ? 0 : getMtNumbers().hashCode());
        result = prime * result + ((getMtSite() == null) ? 0 : getMtSite().hashCode());
        result = prime * result + ((getMtTime() == null) ? 0 : getMtTime().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getMtJoinPersons() == null) ? 0 : getMtJoinPersons().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getViewEmployeeIds() == null) ? 0 : getViewEmployeeIds().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}