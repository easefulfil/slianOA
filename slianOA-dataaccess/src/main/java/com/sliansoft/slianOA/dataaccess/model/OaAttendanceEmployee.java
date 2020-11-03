package com.sliansoft.slianOA.dataaccess.model;

public class OaAttendanceEmployee {
    private Integer attendanceEmployeeId;

    private Integer attendanceRuleId;

    private Integer employeeId;

    public Integer getAttendanceEmployeeId() {
        return attendanceEmployeeId;
    }

    public void setAttendanceEmployeeId(Integer attendanceEmployeeId) {
        this.attendanceEmployeeId = attendanceEmployeeId;
    }

    public Integer getAttendanceRuleId() {
        return attendanceRuleId;
    }

    public void setAttendanceRuleId(Integer attendanceRuleId) {
        this.attendanceRuleId = attendanceRuleId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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
        OaAttendanceEmployee other = (OaAttendanceEmployee) that;
        return (this.getAttendanceEmployeeId() == null ? other.getAttendanceEmployeeId() == null : this.getAttendanceEmployeeId().equals(other.getAttendanceEmployeeId()))
            && (this.getAttendanceRuleId() == null ? other.getAttendanceRuleId() == null : this.getAttendanceRuleId().equals(other.getAttendanceRuleId()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAttendanceEmployeeId() == null) ? 0 : getAttendanceEmployeeId().hashCode());
        result = prime * result + ((getAttendanceRuleId() == null) ? 0 : getAttendanceRuleId().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        return result;
    }
}