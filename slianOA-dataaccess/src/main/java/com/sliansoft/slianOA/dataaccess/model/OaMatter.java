package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaMatter {
    private Integer matterId;

    private String matterName;

    private String matterContent;

    private String matterStatus;

    private Integer creator;

    private Date createTime;

    private Integer amender;

    private Date amendTime;

    private Integer accessGroup;

    public Integer getMatterId() {
        return matterId;
    }

    public void setMatterId(Integer matterId) {
        this.matterId = matterId;
    }

    public String getMatterName() {
        return matterName;
    }

    public void setMatterName(String matterName) {
        this.matterName = matterName == null ? null : matterName.trim();
    }

    public String getMatterContent() {
        return matterContent;
    }

    public void setMatterContent(String matterContent) {
        this.matterContent = matterContent == null ? null : matterContent.trim();
    }

    public String getMatterStatus() {
        return matterStatus;
    }

    public void setMatterStatus(String matterStatus) {
        this.matterStatus = matterStatus == null ? null : matterStatus.trim();
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

    public Integer getAccessGroup() {
        return accessGroup;
    }

    public void setAccessGroup(Integer accessGroup) {
        this.accessGroup = accessGroup;
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
        OaMatter other = (OaMatter) that;
        return (this.getMatterId() == null ? other.getMatterId() == null : this.getMatterId().equals(other.getMatterId()))
            && (this.getMatterName() == null ? other.getMatterName() == null : this.getMatterName().equals(other.getMatterName()))
            && (this.getMatterContent() == null ? other.getMatterContent() == null : this.getMatterContent().equals(other.getMatterContent()))
            && (this.getMatterStatus() == null ? other.getMatterStatus() == null : this.getMatterStatus().equals(other.getMatterStatus()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMatterId() == null) ? 0 : getMatterId().hashCode());
        result = prime * result + ((getMatterName() == null) ? 0 : getMatterName().hashCode());
        result = prime * result + ((getMatterContent() == null) ? 0 : getMatterContent().hashCode());
        result = prime * result + ((getMatterStatus() == null) ? 0 : getMatterStatus().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        return result;
    }
}