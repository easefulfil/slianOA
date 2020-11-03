package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaComplaint {
    private Integer complaintId;

    private String title;

    private Date complaintTime;

    private String complaintPerson;

    private String complaintContent;

    private String complaintAttachment;

    private String complaintResult;

    private String rejectedReason;

    private String remark;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    private String viewEmployeeIds;

    private String type;

    private String status;

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getComplaintTime() {
        return complaintTime;
    }

    public void setComplaintTime(Date complaintTime) {
        this.complaintTime = complaintTime;
    }

    public String getComplaintPerson() {
        return complaintPerson;
    }

    public void setComplaintPerson(String complaintPerson) {
        this.complaintPerson = complaintPerson == null ? null : complaintPerson.trim();
    }

    public String getComplaintContent() {
        return complaintContent;
    }

    public void setComplaintContent(String complaintContent) {
        this.complaintContent = complaintContent == null ? null : complaintContent.trim();
    }

    public String getComplaintAttachment() {
        return complaintAttachment;
    }

    public void setComplaintAttachment(String complaintAttachment) {
        this.complaintAttachment = complaintAttachment == null ? null : complaintAttachment.trim();
    }

    public String getComplaintResult() {
        return complaintResult;
    }

    public void setComplaintResult(String complaintResult) {
        this.complaintResult = complaintResult == null ? null : complaintResult.trim();
    }

    public String getRejectedReason() {
        return rejectedReason;
    }

    public void setRejectedReason(String rejectedReason) {
        this.rejectedReason = rejectedReason == null ? null : rejectedReason.trim();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        OaComplaint other = (OaComplaint) that;
        return (this.getComplaintId() == null ? other.getComplaintId() == null : this.getComplaintId().equals(other.getComplaintId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getComplaintTime() == null ? other.getComplaintTime() == null : this.getComplaintTime().equals(other.getComplaintTime()))
            && (this.getComplaintPerson() == null ? other.getComplaintPerson() == null : this.getComplaintPerson().equals(other.getComplaintPerson()))
            && (this.getComplaintContent() == null ? other.getComplaintContent() == null : this.getComplaintContent().equals(other.getComplaintContent()))
            && (this.getComplaintAttachment() == null ? other.getComplaintAttachment() == null : this.getComplaintAttachment().equals(other.getComplaintAttachment()))
            && (this.getComplaintResult() == null ? other.getComplaintResult() == null : this.getComplaintResult().equals(other.getComplaintResult()))
            && (this.getRejectedReason() == null ? other.getRejectedReason() == null : this.getRejectedReason().equals(other.getRejectedReason()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getViewEmployeeIds() == null ? other.getViewEmployeeIds() == null : this.getViewEmployeeIds().equals(other.getViewEmployeeIds()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getComplaintId() == null) ? 0 : getComplaintId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getComplaintTime() == null) ? 0 : getComplaintTime().hashCode());
        result = prime * result + ((getComplaintPerson() == null) ? 0 : getComplaintPerson().hashCode());
        result = prime * result + ((getComplaintContent() == null) ? 0 : getComplaintContent().hashCode());
        result = prime * result + ((getComplaintAttachment() == null) ? 0 : getComplaintAttachment().hashCode());
        result = prime * result + ((getComplaintResult() == null) ? 0 : getComplaintResult().hashCode());
        result = prime * result + ((getRejectedReason() == null) ? 0 : getRejectedReason().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getViewEmployeeIds() == null) ? 0 : getViewEmployeeIds().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}