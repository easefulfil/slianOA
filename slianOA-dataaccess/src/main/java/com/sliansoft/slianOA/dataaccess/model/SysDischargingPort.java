package com.sliansoft.slianOA.dataaccess.model;

public class SysDischargingPort {
    private Integer dischargingPortId;

    private String dischargingPortCname;

    private String dischargingPortEname;

    private Integer countryBasicDataId;

    private Integer routeBasicDataId;

    private String status;

    private String remark;

    private Integer dischargingPortPopularity;

    public Integer getDischargingPortId() {
        return dischargingPortId;
    }

    public void setDischargingPortId(Integer dischargingPortId) {
        this.dischargingPortId = dischargingPortId;
    }

    public String getDischargingPortCname() {
        return dischargingPortCname;
    }

    public void setDischargingPortCname(String dischargingPortCname) {
        this.dischargingPortCname = dischargingPortCname == null ? null : dischargingPortCname.trim();
    }

    public String getDischargingPortEname() {
        return dischargingPortEname;
    }

    public void setDischargingPortEname(String dischargingPortEname) {
        this.dischargingPortEname = dischargingPortEname == null ? null : dischargingPortEname.trim();
    }

    public Integer getCountryBasicDataId() {
        return countryBasicDataId;
    }

    public void setCountryBasicDataId(Integer countryBasicDataId) {
        this.countryBasicDataId = countryBasicDataId;
    }

    public Integer getRouteBasicDataId() {
        return routeBasicDataId;
    }

    public void setRouteBasicDataId(Integer routeBasicDataId) {
        this.routeBasicDataId = routeBasicDataId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getDischargingPortPopularity() {
        return dischargingPortPopularity;
    }

    public void setDischargingPortPopularity(Integer dischargingPortPopularity) {
        this.dischargingPortPopularity = dischargingPortPopularity;
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
        SysDischargingPort other = (SysDischargingPort) that;
        return (this.getDischargingPortId() == null ? other.getDischargingPortId() == null : this.getDischargingPortId().equals(other.getDischargingPortId()))
            && (this.getDischargingPortCname() == null ? other.getDischargingPortCname() == null : this.getDischargingPortCname().equals(other.getDischargingPortCname()))
            && (this.getDischargingPortEname() == null ? other.getDischargingPortEname() == null : this.getDischargingPortEname().equals(other.getDischargingPortEname()))
            && (this.getCountryBasicDataId() == null ? other.getCountryBasicDataId() == null : this.getCountryBasicDataId().equals(other.getCountryBasicDataId()))
            && (this.getRouteBasicDataId() == null ? other.getRouteBasicDataId() == null : this.getRouteBasicDataId().equals(other.getRouteBasicDataId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getDischargingPortPopularity() == null ? other.getDischargingPortPopularity() == null : this.getDischargingPortPopularity().equals(other.getDischargingPortPopularity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDischargingPortId() == null) ? 0 : getDischargingPortId().hashCode());
        result = prime * result + ((getDischargingPortCname() == null) ? 0 : getDischargingPortCname().hashCode());
        result = prime * result + ((getDischargingPortEname() == null) ? 0 : getDischargingPortEname().hashCode());
        result = prime * result + ((getCountryBasicDataId() == null) ? 0 : getCountryBasicDataId().hashCode());
        result = prime * result + ((getRouteBasicDataId() == null) ? 0 : getRouteBasicDataId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getDischargingPortPopularity() == null) ? 0 : getDischargingPortPopularity().hashCode());
        return result;
    }
}