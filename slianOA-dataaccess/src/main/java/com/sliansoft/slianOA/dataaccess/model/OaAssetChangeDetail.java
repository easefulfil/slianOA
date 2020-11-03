package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaAssetChangeDetail {
    private Integer assetChangeDetailId;

    private Integer assetChangeId;

    private Integer assetId;

    private String detailName;

    private String currency;

    private Double unitPrice;

    private Integer amount;

    private Integer currentAmount;

    private Date eventTime;

    private String changeType;

    private String remark;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    public Integer getAssetChangeDetailId() {
        return assetChangeDetailId;
    }

    public void setAssetChangeDetailId(Integer assetChangeDetailId) {
        this.assetChangeDetailId = assetChangeDetailId;
    }

    public Integer getAssetChangeId() {
        return assetChangeId;
    }

    public void setAssetChangeId(Integer assetChangeId) {
        this.assetChangeId = assetChangeId;
    }

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName == null ? null : detailName.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Integer currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType == null ? null : changeType.trim();
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
        OaAssetChangeDetail other = (OaAssetChangeDetail) that;
        return (this.getAssetChangeDetailId() == null ? other.getAssetChangeDetailId() == null : this.getAssetChangeDetailId().equals(other.getAssetChangeDetailId()))
            && (this.getAssetChangeId() == null ? other.getAssetChangeId() == null : this.getAssetChangeId().equals(other.getAssetChangeId()))
            && (this.getAssetId() == null ? other.getAssetId() == null : this.getAssetId().equals(other.getAssetId()))
            && (this.getDetailName() == null ? other.getDetailName() == null : this.getDetailName().equals(other.getDetailName()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getUnitPrice() == null ? other.getUnitPrice() == null : this.getUnitPrice().equals(other.getUnitPrice()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getCurrentAmount() == null ? other.getCurrentAmount() == null : this.getCurrentAmount().equals(other.getCurrentAmount()))
            && (this.getEventTime() == null ? other.getEventTime() == null : this.getEventTime().equals(other.getEventTime()))
            && (this.getChangeType() == null ? other.getChangeType() == null : this.getChangeType().equals(other.getChangeType()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getAssetChangeDetailId() == null) ? 0 : getAssetChangeDetailId().hashCode());
        result = prime * result + ((getAssetChangeId() == null) ? 0 : getAssetChangeId().hashCode());
        result = prime * result + ((getAssetId() == null) ? 0 : getAssetId().hashCode());
        result = prime * result + ((getDetailName() == null) ? 0 : getDetailName().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getUnitPrice() == null) ? 0 : getUnitPrice().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCurrentAmount() == null) ? 0 : getCurrentAmount().hashCode());
        result = prime * result + ((getEventTime() == null) ? 0 : getEventTime().hashCode());
        result = prime * result + ((getChangeType() == null) ? 0 : getChangeType().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        return result;
    }
}