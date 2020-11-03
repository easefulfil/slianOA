package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaErrorCorrection {
    private Integer errorCorrectionId;

    private String code;

    private Integer proposerId;

    private Integer dutyId;

    private Integer chargerId;

    private Integer qualityId;

    private String content1;

    private String content2;

    private String content3;

    private String content4;

    private Date completeTime;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    private Integer isDelete;

    public Integer getErrorCorrectionId() {
        return errorCorrectionId;
    }

    public void setErrorCorrectionId(Integer errorCorrectionId) {
        this.errorCorrectionId = errorCorrectionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getProposerId() {
        return proposerId;
    }

    public void setProposerId(Integer proposerId) {
        this.proposerId = proposerId;
    }

    public Integer getDutyId() {
        return dutyId;
    }

    public void setDutyId(Integer dutyId) {
        this.dutyId = dutyId;
    }

    public Integer getChargerId() {
        return chargerId;
    }

    public void setChargerId(Integer chargerId) {
        this.chargerId = chargerId;
    }

    public Integer getQualityId() {
        return qualityId;
    }

    public void setQualityId(Integer qualityId) {
        this.qualityId = qualityId;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1 == null ? null : content1.trim();
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2 == null ? null : content2.trim();
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3 == null ? null : content3.trim();
    }

    public String getContent4() {
        return content4;
    }

    public void setContent4(String content4) {
        this.content4 = content4 == null ? null : content4.trim();
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
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
        OaErrorCorrection other = (OaErrorCorrection) that;
        return (this.getErrorCorrectionId() == null ? other.getErrorCorrectionId() == null : this.getErrorCorrectionId().equals(other.getErrorCorrectionId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getProposerId() == null ? other.getProposerId() == null : this.getProposerId().equals(other.getProposerId()))
            && (this.getDutyId() == null ? other.getDutyId() == null : this.getDutyId().equals(other.getDutyId()))
            && (this.getChargerId() == null ? other.getChargerId() == null : this.getChargerId().equals(other.getChargerId()))
            && (this.getQualityId() == null ? other.getQualityId() == null : this.getQualityId().equals(other.getQualityId()))
            && (this.getContent1() == null ? other.getContent1() == null : this.getContent1().equals(other.getContent1()))
            && (this.getContent2() == null ? other.getContent2() == null : this.getContent2().equals(other.getContent2()))
            && (this.getContent3() == null ? other.getContent3() == null : this.getContent3().equals(other.getContent3()))
            && (this.getContent4() == null ? other.getContent4() == null : this.getContent4().equals(other.getContent4()))
            && (this.getCompleteTime() == null ? other.getCompleteTime() == null : this.getCompleteTime().equals(other.getCompleteTime()))
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
        result = prime * result + ((getErrorCorrectionId() == null) ? 0 : getErrorCorrectionId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getProposerId() == null) ? 0 : getProposerId().hashCode());
        result = prime * result + ((getDutyId() == null) ? 0 : getDutyId().hashCode());
        result = prime * result + ((getChargerId() == null) ? 0 : getChargerId().hashCode());
        result = prime * result + ((getQualityId() == null) ? 0 : getQualityId().hashCode());
        result = prime * result + ((getContent1() == null) ? 0 : getContent1().hashCode());
        result = prime * result + ((getContent2() == null) ? 0 : getContent2().hashCode());
        result = prime * result + ((getContent3() == null) ? 0 : getContent3().hashCode());
        result = prime * result + ((getContent4() == null) ? 0 : getContent4().hashCode());
        result = prime * result + ((getCompleteTime() == null) ? 0 : getCompleteTime().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }
}