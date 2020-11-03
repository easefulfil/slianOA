package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaNews {
    private Integer newsId;

    private String title;

    private Integer isPop;

    private Date popTime;

    private Date popStyle;

    private String informTo;

    private Date beginTime;

    private Date endTime;

    private String status;

    private String viewEmployeeIds;

    private Integer accessGroup;

    private Date createTime;

    private Integer creator;

    private Date amendTime;

    private Integer amender;

    private String type;

    private String content;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getIsPop() {
        return isPop;
    }

    public void setIsPop(Integer isPop) {
        this.isPop = isPop;
    }

    public Date getPopTime() {
        return popTime;
    }

    public void setPopTime(Date popTime) {
        this.popTime = popTime;
    }

    public Date getPopStyle() {
        return popStyle;
    }

    public void setPopStyle(Date popStyle) {
        this.popStyle = popStyle;
    }

    public String getInformTo() {
        return informTo;
    }

    public void setInformTo(String informTo) {
        this.informTo = informTo == null ? null : informTo.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getViewEmployeeIds() {
        return viewEmployeeIds;
    }

    public void setViewEmployeeIds(String viewEmployeeIds) {
        this.viewEmployeeIds = viewEmployeeIds == null ? null : viewEmployeeIds.trim();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
        OaNews other = (OaNews) that;
        return (this.getNewsId() == null ? other.getNewsId() == null : this.getNewsId().equals(other.getNewsId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getIsPop() == null ? other.getIsPop() == null : this.getIsPop().equals(other.getIsPop()))
            && (this.getPopTime() == null ? other.getPopTime() == null : this.getPopTime().equals(other.getPopTime()))
            && (this.getPopStyle() == null ? other.getPopStyle() == null : this.getPopStyle().equals(other.getPopStyle()))
            && (this.getInformTo() == null ? other.getInformTo() == null : this.getInformTo().equals(other.getInformTo()))
            && (this.getBeginTime() == null ? other.getBeginTime() == null : this.getBeginTime().equals(other.getBeginTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getViewEmployeeIds() == null ? other.getViewEmployeeIds() == null : this.getViewEmployeeIds().equals(other.getViewEmployeeIds()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNewsId() == null) ? 0 : getNewsId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getIsPop() == null) ? 0 : getIsPop().hashCode());
        result = prime * result + ((getPopTime() == null) ? 0 : getPopTime().hashCode());
        result = prime * result + ((getPopStyle() == null) ? 0 : getPopStyle().hashCode());
        result = prime * result + ((getInformTo() == null) ? 0 : getInformTo().hashCode());
        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getViewEmployeeIds() == null) ? 0 : getViewEmployeeIds().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}