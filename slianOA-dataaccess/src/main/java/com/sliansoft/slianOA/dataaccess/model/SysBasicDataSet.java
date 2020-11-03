package com.sliansoft.slianOA.dataaccess.model;

public class SysBasicDataSet {
    private Integer basicDataId;

    private String chineseName;

    private String englishName;

    private Integer parentNodeId;

    private String basicDataType;

    private String basicDataStatus;

    private String basicDataRemark;

    private Integer basicDataPopularity;

    public Integer getBasicDataId() {
        return basicDataId;
    }

    public void setBasicDataId(Integer basicDataId) {
        this.basicDataId = basicDataId;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public Integer getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(Integer parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public String getBasicDataType() {
        return basicDataType;
    }

    public void setBasicDataType(String basicDataType) {
        this.basicDataType = basicDataType == null ? null : basicDataType.trim();
    }

    public String getBasicDataStatus() {
        return basicDataStatus;
    }

    public void setBasicDataStatus(String basicDataStatus) {
        this.basicDataStatus = basicDataStatus == null ? null : basicDataStatus.trim();
    }

    public String getBasicDataRemark() {
        return basicDataRemark;
    }

    public void setBasicDataRemark(String basicDataRemark) {
        this.basicDataRemark = basicDataRemark == null ? null : basicDataRemark.trim();
    }

    public Integer getBasicDataPopularity() {
        return basicDataPopularity;
    }

    public void setBasicDataPopularity(Integer basicDataPopularity) {
        this.basicDataPopularity = basicDataPopularity;
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
        SysBasicDataSet other = (SysBasicDataSet) that;
        return (this.getBasicDataId() == null ? other.getBasicDataId() == null : this.getBasicDataId().equals(other.getBasicDataId()))
            && (this.getChineseName() == null ? other.getChineseName() == null : this.getChineseName().equals(other.getChineseName()))
            && (this.getEnglishName() == null ? other.getEnglishName() == null : this.getEnglishName().equals(other.getEnglishName()))
            && (this.getParentNodeId() == null ? other.getParentNodeId() == null : this.getParentNodeId().equals(other.getParentNodeId()))
            && (this.getBasicDataType() == null ? other.getBasicDataType() == null : this.getBasicDataType().equals(other.getBasicDataType()))
            && (this.getBasicDataStatus() == null ? other.getBasicDataStatus() == null : this.getBasicDataStatus().equals(other.getBasicDataStatus()))
            && (this.getBasicDataRemark() == null ? other.getBasicDataRemark() == null : this.getBasicDataRemark().equals(other.getBasicDataRemark()))
            && (this.getBasicDataPopularity() == null ? other.getBasicDataPopularity() == null : this.getBasicDataPopularity().equals(other.getBasicDataPopularity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBasicDataId() == null) ? 0 : getBasicDataId().hashCode());
        result = prime * result + ((getChineseName() == null) ? 0 : getChineseName().hashCode());
        result = prime * result + ((getEnglishName() == null) ? 0 : getEnglishName().hashCode());
        result = prime * result + ((getParentNodeId() == null) ? 0 : getParentNodeId().hashCode());
        result = prime * result + ((getBasicDataType() == null) ? 0 : getBasicDataType().hashCode());
        result = prime * result + ((getBasicDataStatus() == null) ? 0 : getBasicDataStatus().hashCode());
        result = prime * result + ((getBasicDataRemark() == null) ? 0 : getBasicDataRemark().hashCode());
        result = prime * result + ((getBasicDataPopularity() == null) ? 0 : getBasicDataPopularity().hashCode());
        return result;
    }
}