package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaSuit {
    private Integer suitId;

    private String appraisedPerson;

    private String site;

    private Date entrustingDate;

    private String entrustingPerson;

    private String caseNumber;

    private Double receivable;

    private Double received;

    private String status;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    private String remark;

    private String apprasingPerson;

    public Integer getSuitId() {
        return suitId;
    }

    public void setSuitId(Integer suitId) {
        this.suitId = suitId;
    }

    public String getAppraisedPerson() {
        return appraisedPerson;
    }

    public void setAppraisedPerson(String appraisedPerson) {
        this.appraisedPerson = appraisedPerson == null ? null : appraisedPerson.trim();
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public Date getEntrustingDate() {
        return entrustingDate;
    }

    public void setEntrustingDate(Date entrustingDate) {
        this.entrustingDate = entrustingDate;
    }

    public String getEntrustingPerson() {
        return entrustingPerson;
    }

    public void setEntrustingPerson(String entrustingPerson) {
        this.entrustingPerson = entrustingPerson == null ? null : entrustingPerson.trim();
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber == null ? null : caseNumber.trim();
    }

    public Double getReceivable() {
        return receivable;
    }

    public void setReceivable(Double receivable) {
        this.receivable = receivable;
    }

    public Double getReceived() {
        return received;
    }

    public void setReceived(Double received) {
        this.received = received;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getApprasingPerson() {
        return apprasingPerson;
    }

    public void setApprasingPerson(String apprasingPerson) {
        this.apprasingPerson = apprasingPerson == null ? null : apprasingPerson.trim();
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
        OaSuit other = (OaSuit) that;
        return (this.getSuitId() == null ? other.getSuitId() == null : this.getSuitId().equals(other.getSuitId()))
            && (this.getAppraisedPerson() == null ? other.getAppraisedPerson() == null : this.getAppraisedPerson().equals(other.getAppraisedPerson()))
            && (this.getSite() == null ? other.getSite() == null : this.getSite().equals(other.getSite()))
            && (this.getEntrustingDate() == null ? other.getEntrustingDate() == null : this.getEntrustingDate().equals(other.getEntrustingDate()))
            && (this.getEntrustingPerson() == null ? other.getEntrustingPerson() == null : this.getEntrustingPerson().equals(other.getEntrustingPerson()))
            && (this.getCaseNumber() == null ? other.getCaseNumber() == null : this.getCaseNumber().equals(other.getCaseNumber()))
            && (this.getReceivable() == null ? other.getReceivable() == null : this.getReceivable().equals(other.getReceivable()))
            && (this.getReceived() == null ? other.getReceived() == null : this.getReceived().equals(other.getReceived()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getApprasingPerson() == null ? other.getApprasingPerson() == null : this.getApprasingPerson().equals(other.getApprasingPerson()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSuitId() == null) ? 0 : getSuitId().hashCode());
        result = prime * result + ((getAppraisedPerson() == null) ? 0 : getAppraisedPerson().hashCode());
        result = prime * result + ((getSite() == null) ? 0 : getSite().hashCode());
        result = prime * result + ((getEntrustingDate() == null) ? 0 : getEntrustingDate().hashCode());
        result = prime * result + ((getEntrustingPerson() == null) ? 0 : getEntrustingPerson().hashCode());
        result = prime * result + ((getCaseNumber() == null) ? 0 : getCaseNumber().hashCode());
        result = prime * result + ((getReceivable() == null) ? 0 : getReceivable().hashCode());
        result = prime * result + ((getReceived() == null) ? 0 : getReceived().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getApprasingPerson() == null) ? 0 : getApprasingPerson().hashCode());
        return result;
    }
}