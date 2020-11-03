package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaWeekly {
    private Integer weeklyId;

    private Integer employeeId;

    private String title;

    private String content;

    private String viewerIds;

    private Integer accessGroup;

    private Date createTime;

    private String creator;

    private Integer isDelete;

    private String evaluatorId;

    private String evaluateContent;

    private Date evaluateTime;

    private String weeklyStatus;

    public Integer getWeeklyId() {
        return weeklyId;
    }

    public void setWeeklyId(Integer weeklyId) {
        this.weeklyId = weeklyId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getViewerIds() {
        return viewerIds;
    }

    public void setViewerIds(String viewerIds) {
        this.viewerIds = viewerIds == null ? null : viewerIds.trim();
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getEvaluatorId() {
        return evaluatorId;
    }

    public void setEvaluatorId(String evaluatorId) {
        this.evaluatorId = evaluatorId == null ? null : evaluatorId.trim();
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent == null ? null : evaluateContent.trim();
    }

    public Date getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public String getWeeklyStatus() {
        return weeklyStatus;
    }

    public void setWeeklyStatus(String weeklyStatus) {
        this.weeklyStatus = weeklyStatus == null ? null : weeklyStatus.trim();
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
        OaWeekly other = (OaWeekly) that;
        return (this.getWeeklyId() == null ? other.getWeeklyId() == null : this.getWeeklyId().equals(other.getWeeklyId()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getViewerIds() == null ? other.getViewerIds() == null : this.getViewerIds().equals(other.getViewerIds()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getEvaluatorId() == null ? other.getEvaluatorId() == null : this.getEvaluatorId().equals(other.getEvaluatorId()))
            && (this.getEvaluateContent() == null ? other.getEvaluateContent() == null : this.getEvaluateContent().equals(other.getEvaluateContent()))
            && (this.getEvaluateTime() == null ? other.getEvaluateTime() == null : this.getEvaluateTime().equals(other.getEvaluateTime()))
            && (this.getWeeklyStatus() == null ? other.getWeeklyStatus() == null : this.getWeeklyStatus().equals(other.getWeeklyStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWeeklyId() == null) ? 0 : getWeeklyId().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getViewerIds() == null) ? 0 : getViewerIds().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getEvaluatorId() == null) ? 0 : getEvaluatorId().hashCode());
        result = prime * result + ((getEvaluateContent() == null) ? 0 : getEvaluateContent().hashCode());
        result = prime * result + ((getEvaluateTime() == null) ? 0 : getEvaluateTime().hashCode());
        result = prime * result + ((getWeeklyStatus() == null) ? 0 : getWeeklyStatus().hashCode());
        return result;
    }
}