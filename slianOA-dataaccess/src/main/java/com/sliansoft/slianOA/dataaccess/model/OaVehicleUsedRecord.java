package com.sliansoft.slianOA.dataaccess.model;

import java.util.Date;

public class OaVehicleUsedRecord {
    private Integer vehicleUsedRecordId;

    private Integer vehicleId;

    private Integer employeeId;

    private Date beginTime;

    private Date endTime;

    private Date planReturnTime;

    private Date trueReturnTime;

    private String vurDestination;

    private String vurTogether;

    private String vurReportSite;

    private String vurLinkman;

    private String telephone;

    private String assignment;

    private Double beginVelMileage;

    private Double returnVelMileage;

    private Date trueOutTime;

    private String preEvents;

    private String isReaded;

    private String viewEmployeeIds;

    private String status;

    private Integer accessGroup;

    private Date amendTime;

    private Integer amender;

    private Date createTime;

    private Integer creator;

    private String remark;

    private String step;

    private Integer driver;

    private String type;

    public Integer getVehicleUsedRecordId() {
        return vehicleUsedRecordId;
    }

    public void setVehicleUsedRecordId(Integer vehicleUsedRecordId) {
        this.vehicleUsedRecordId = vehicleUsedRecordId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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

    public Date getPlanReturnTime() {
        return planReturnTime;
    }

    public void setPlanReturnTime(Date planReturnTime) {
        this.planReturnTime = planReturnTime;
    }

    public Date getTrueReturnTime() {
        return trueReturnTime;
    }

    public void setTrueReturnTime(Date trueReturnTime) {
        this.trueReturnTime = trueReturnTime;
    }

    public String getVurDestination() {
        return vurDestination;
    }

    public void setVurDestination(String vurDestination) {
        this.vurDestination = vurDestination == null ? null : vurDestination.trim();
    }

    public String getVurTogether() {
        return vurTogether;
    }

    public void setVurTogether(String vurTogether) {
        this.vurTogether = vurTogether == null ? null : vurTogether.trim();
    }

    public String getVurReportSite() {
        return vurReportSite;
    }

    public void setVurReportSite(String vurReportSite) {
        this.vurReportSite = vurReportSite == null ? null : vurReportSite.trim();
    }

    public String getVurLinkman() {
        return vurLinkman;
    }

    public void setVurLinkman(String vurLinkman) {
        this.vurLinkman = vurLinkman == null ? null : vurLinkman.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment == null ? null : assignment.trim();
    }

    public Double getBeginVelMileage() {
        return beginVelMileage;
    }

    public void setBeginVelMileage(Double beginVelMileage) {
        this.beginVelMileage = beginVelMileage;
    }

    public Double getReturnVelMileage() {
        return returnVelMileage;
    }

    public void setReturnVelMileage(Double returnVelMileage) {
        this.returnVelMileage = returnVelMileage;
    }

    public Date getTrueOutTime() {
        return trueOutTime;
    }

    public void setTrueOutTime(Date trueOutTime) {
        this.trueOutTime = trueOutTime;
    }

    public String getPreEvents() {
        return preEvents;
    }

    public void setPreEvents(String preEvents) {
        this.preEvents = preEvents == null ? null : preEvents.trim();
    }

    public String getIsReaded() {
        return isReaded;
    }

    public void setIsReaded(String isReaded) {
        this.isReaded = isReaded == null ? null : isReaded.trim();
    }

    public String getViewEmployeeIds() {
        return viewEmployeeIds;
    }

    public void setViewEmployeeIds(String viewEmployeeIds) {
        this.viewEmployeeIds = viewEmployeeIds == null ? null : viewEmployeeIds.trim();
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

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step == null ? null : step.trim();
    }

    public Integer getDriver() {
        return driver;
    }

    public void setDriver(Integer driver) {
        this.driver = driver;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
        OaVehicleUsedRecord other = (OaVehicleUsedRecord) that;
        return (this.getVehicleUsedRecordId() == null ? other.getVehicleUsedRecordId() == null : this.getVehicleUsedRecordId().equals(other.getVehicleUsedRecordId()))
            && (this.getVehicleId() == null ? other.getVehicleId() == null : this.getVehicleId().equals(other.getVehicleId()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getBeginTime() == null ? other.getBeginTime() == null : this.getBeginTime().equals(other.getBeginTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getPlanReturnTime() == null ? other.getPlanReturnTime() == null : this.getPlanReturnTime().equals(other.getPlanReturnTime()))
            && (this.getTrueReturnTime() == null ? other.getTrueReturnTime() == null : this.getTrueReturnTime().equals(other.getTrueReturnTime()))
            && (this.getVurDestination() == null ? other.getVurDestination() == null : this.getVurDestination().equals(other.getVurDestination()))
            && (this.getVurTogether() == null ? other.getVurTogether() == null : this.getVurTogether().equals(other.getVurTogether()))
            && (this.getVurReportSite() == null ? other.getVurReportSite() == null : this.getVurReportSite().equals(other.getVurReportSite()))
            && (this.getVurLinkman() == null ? other.getVurLinkman() == null : this.getVurLinkman().equals(other.getVurLinkman()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getAssignment() == null ? other.getAssignment() == null : this.getAssignment().equals(other.getAssignment()))
            && (this.getBeginVelMileage() == null ? other.getBeginVelMileage() == null : this.getBeginVelMileage().equals(other.getBeginVelMileage()))
            && (this.getReturnVelMileage() == null ? other.getReturnVelMileage() == null : this.getReturnVelMileage().equals(other.getReturnVelMileage()))
            && (this.getTrueOutTime() == null ? other.getTrueOutTime() == null : this.getTrueOutTime().equals(other.getTrueOutTime()))
            && (this.getPreEvents() == null ? other.getPreEvents() == null : this.getPreEvents().equals(other.getPreEvents()))
            && (this.getIsReaded() == null ? other.getIsReaded() == null : this.getIsReaded().equals(other.getIsReaded()))
            && (this.getViewEmployeeIds() == null ? other.getViewEmployeeIds() == null : this.getViewEmployeeIds().equals(other.getViewEmployeeIds()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAccessGroup() == null ? other.getAccessGroup() == null : this.getAccessGroup().equals(other.getAccessGroup()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStep() == null ? other.getStep() == null : this.getStep().equals(other.getStep()))
            && (this.getDriver() == null ? other.getDriver() == null : this.getDriver().equals(other.getDriver()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVehicleUsedRecordId() == null) ? 0 : getVehicleUsedRecordId().hashCode());
        result = prime * result + ((getVehicleId() == null) ? 0 : getVehicleId().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getPlanReturnTime() == null) ? 0 : getPlanReturnTime().hashCode());
        result = prime * result + ((getTrueReturnTime() == null) ? 0 : getTrueReturnTime().hashCode());
        result = prime * result + ((getVurDestination() == null) ? 0 : getVurDestination().hashCode());
        result = prime * result + ((getVurTogether() == null) ? 0 : getVurTogether().hashCode());
        result = prime * result + ((getVurReportSite() == null) ? 0 : getVurReportSite().hashCode());
        result = prime * result + ((getVurLinkman() == null) ? 0 : getVurLinkman().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getAssignment() == null) ? 0 : getAssignment().hashCode());
        result = prime * result + ((getBeginVelMileage() == null) ? 0 : getBeginVelMileage().hashCode());
        result = prime * result + ((getReturnVelMileage() == null) ? 0 : getReturnVelMileage().hashCode());
        result = prime * result + ((getTrueOutTime() == null) ? 0 : getTrueOutTime().hashCode());
        result = prime * result + ((getPreEvents() == null) ? 0 : getPreEvents().hashCode());
        result = prime * result + ((getIsReaded() == null) ? 0 : getIsReaded().hashCode());
        result = prime * result + ((getViewEmployeeIds() == null) ? 0 : getViewEmployeeIds().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAccessGroup() == null) ? 0 : getAccessGroup().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStep() == null) ? 0 : getStep().hashCode());
        result = prime * result + ((getDriver() == null) ? 0 : getDriver().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }
}