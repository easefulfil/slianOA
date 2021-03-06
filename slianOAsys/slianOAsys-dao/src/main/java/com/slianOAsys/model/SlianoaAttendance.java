package com.slianOAsys.model;

import java.util.Date;

public class SlianoaAttendance {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.attendance_id
     *
     * @mbggenerated
     */
    private Integer attendanceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.employee_id
     *
     * @mbggenerated
     */
    private Integer employeeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.attendance_signtime
     *
     * @mbggenerated
     */
    private Date attendanceSigntime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.attendance_offtime
     *
     * @mbggenerated
     */
    private Date attendanceOfftime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.attendance_signaddress
     *
     * @mbggenerated
     */
    private String attendanceSignaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.attendance_offaddress
     *
     * @mbggenerated
     */
    private String attendanceOffaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.attendance_signstatus
     *
     * @mbggenerated
     */
    private String attendanceSignstatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.attendance_offstatus
     *
     * @mbggenerated
     */
    private String attendanceOffstatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.attendance_time
     *
     * @mbggenerated
     */
    private String attendanceTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.attendance_total_status
     *
     * @mbggenerated
     */
    private String attendanceTotalStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.signin_longitude
     *
     * @mbggenerated
     */
    private String signinLongitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.signin_latitude
     *
     * @mbggenerated
     */
    private String signinLatitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.signoff_longitude
     *
     * @mbggenerated
     */
    private String signoffLongitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.signoff_latitude
     *
     * @mbggenerated
     */
    private String signoffLatitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.amend_time
     *
     * @mbggenerated
     */
    private Date amendTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.amender
     *
     * @mbggenerated
     */
    private String amender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.class_id
     *
     * @mbggenerated
     */
    private Integer classId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_attendance.work_hour
     *
     * @mbggenerated
     */
    private Float workHour;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.attendance_id
     *
     * @return the value of slianoa_attendance.attendance_id
     *
     * @mbggenerated
     */
    public Integer getAttendanceId() {
        return attendanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.attendance_id
     *
     * @param attendanceId the value for slianoa_attendance.attendance_id
     *
     * @mbggenerated
     */
    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.employee_id
     *
     * @return the value of slianoa_attendance.employee_id
     *
     * @mbggenerated
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.employee_id
     *
     * @param employeeId the value for slianoa_attendance.employee_id
     *
     * @mbggenerated
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.attendance_signtime
     *
     * @return the value of slianoa_attendance.attendance_signtime
     *
     * @mbggenerated
     */
    public Date getAttendanceSigntime() {
        return attendanceSigntime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.attendance_signtime
     *
     * @param attendanceSigntime the value for slianoa_attendance.attendance_signtime
     *
     * @mbggenerated
     */
    public void setAttendanceSigntime(Date attendanceSigntime) {
        this.attendanceSigntime = attendanceSigntime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.attendance_offtime
     *
     * @return the value of slianoa_attendance.attendance_offtime
     *
     * @mbggenerated
     */
    public Date getAttendanceOfftime() {
        return attendanceOfftime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.attendance_offtime
     *
     * @param attendanceOfftime the value for slianoa_attendance.attendance_offtime
     *
     * @mbggenerated
     */
    public void setAttendanceOfftime(Date attendanceOfftime) {
        this.attendanceOfftime = attendanceOfftime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.attendance_signaddress
     *
     * @return the value of slianoa_attendance.attendance_signaddress
     *
     * @mbggenerated
     */
    public String getAttendanceSignaddress() {
        return attendanceSignaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.attendance_signaddress
     *
     * @param attendanceSignaddress the value for slianoa_attendance.attendance_signaddress
     *
     * @mbggenerated
     */
    public void setAttendanceSignaddress(String attendanceSignaddress) {
        this.attendanceSignaddress = attendanceSignaddress == null ? null : attendanceSignaddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.attendance_offaddress
     *
     * @return the value of slianoa_attendance.attendance_offaddress
     *
     * @mbggenerated
     */
    public String getAttendanceOffaddress() {
        return attendanceOffaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.attendance_offaddress
     *
     * @param attendanceOffaddress the value for slianoa_attendance.attendance_offaddress
     *
     * @mbggenerated
     */
    public void setAttendanceOffaddress(String attendanceOffaddress) {
        this.attendanceOffaddress = attendanceOffaddress == null ? null : attendanceOffaddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.attendance_signstatus
     *
     * @return the value of slianoa_attendance.attendance_signstatus
     *
     * @mbggenerated
     */
    public String getAttendanceSignstatus() {
        return attendanceSignstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.attendance_signstatus
     *
     * @param attendanceSignstatus the value for slianoa_attendance.attendance_signstatus
     *
     * @mbggenerated
     */
    public void setAttendanceSignstatus(String attendanceSignstatus) {
        this.attendanceSignstatus = attendanceSignstatus == null ? null : attendanceSignstatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.attendance_offstatus
     *
     * @return the value of slianoa_attendance.attendance_offstatus
     *
     * @mbggenerated
     */
    public String getAttendanceOffstatus() {
        return attendanceOffstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.attendance_offstatus
     *
     * @param attendanceOffstatus the value for slianoa_attendance.attendance_offstatus
     *
     * @mbggenerated
     */
    public void setAttendanceOffstatus(String attendanceOffstatus) {
        this.attendanceOffstatus = attendanceOffstatus == null ? null : attendanceOffstatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.attendance_time
     *
     * @return the value of slianoa_attendance.attendance_time
     *
     * @mbggenerated
     */
    public String getAttendanceTime() {
        return attendanceTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.attendance_time
     *
     * @param attendanceTime the value for slianoa_attendance.attendance_time
     *
     * @mbggenerated
     */
    public void setAttendanceTime(String attendanceTime) {
        this.attendanceTime = attendanceTime == null ? null : attendanceTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.attendance_total_status
     *
     * @return the value of slianoa_attendance.attendance_total_status
     *
     * @mbggenerated
     */
    public String getAttendanceTotalStatus() {
        return attendanceTotalStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.attendance_total_status
     *
     * @param attendanceTotalStatus the value for slianoa_attendance.attendance_total_status
     *
     * @mbggenerated
     */
    public void setAttendanceTotalStatus(String attendanceTotalStatus) {
        this.attendanceTotalStatus = attendanceTotalStatus == null ? null : attendanceTotalStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.signin_longitude
     *
     * @return the value of slianoa_attendance.signin_longitude
     *
     * @mbggenerated
     */
    public String getSigninLongitude() {
        return signinLongitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.signin_longitude
     *
     * @param signinLongitude the value for slianoa_attendance.signin_longitude
     *
     * @mbggenerated
     */
    public void setSigninLongitude(String signinLongitude) {
        this.signinLongitude = signinLongitude == null ? null : signinLongitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.signin_latitude
     *
     * @return the value of slianoa_attendance.signin_latitude
     *
     * @mbggenerated
     */
    public String getSigninLatitude() {
        return signinLatitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.signin_latitude
     *
     * @param signinLatitude the value for slianoa_attendance.signin_latitude
     *
     * @mbggenerated
     */
    public void setSigninLatitude(String signinLatitude) {
        this.signinLatitude = signinLatitude == null ? null : signinLatitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.signoff_longitude
     *
     * @return the value of slianoa_attendance.signoff_longitude
     *
     * @mbggenerated
     */
    public String getSignoffLongitude() {
        return signoffLongitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.signoff_longitude
     *
     * @param signoffLongitude the value for slianoa_attendance.signoff_longitude
     *
     * @mbggenerated
     */
    public void setSignoffLongitude(String signoffLongitude) {
        this.signoffLongitude = signoffLongitude == null ? null : signoffLongitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.signoff_latitude
     *
     * @return the value of slianoa_attendance.signoff_latitude
     *
     * @mbggenerated
     */
    public String getSignoffLatitude() {
        return signoffLatitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.signoff_latitude
     *
     * @param signoffLatitude the value for slianoa_attendance.signoff_latitude
     *
     * @mbggenerated
     */
    public void setSignoffLatitude(String signoffLatitude) {
        this.signoffLatitude = signoffLatitude == null ? null : signoffLatitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.create_time
     *
     * @return the value of slianoa_attendance.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.create_time
     *
     * @param createTime the value for slianoa_attendance.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.amend_time
     *
     * @return the value of slianoa_attendance.amend_time
     *
     * @mbggenerated
     */
    public Date getAmendTime() {
        return amendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.amend_time
     *
     * @param amendTime the value for slianoa_attendance.amend_time
     *
     * @mbggenerated
     */
    public void setAmendTime(Date amendTime) {
        this.amendTime = amendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.amender
     *
     * @return the value of slianoa_attendance.amender
     *
     * @mbggenerated
     */
    public String getAmender() {
        return amender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.amender
     *
     * @param amender the value for slianoa_attendance.amender
     *
     * @mbggenerated
     */
    public void setAmender(String amender) {
        this.amender = amender == null ? null : amender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.class_id
     *
     * @return the value of slianoa_attendance.class_id
     *
     * @mbggenerated
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.class_id
     *
     * @param classId the value for slianoa_attendance.class_id
     *
     * @mbggenerated
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_attendance.work_hour
     *
     * @return the value of slianoa_attendance.work_hour
     *
     * @mbggenerated
     */
    public Float getWorkHour() {
        return workHour;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_attendance.work_hour
     *
     * @param workHour the value for slianoa_attendance.work_hour
     *
     * @mbggenerated
     */
    public void setWorkHour(Float workHour) {
        this.workHour = workHour;
    }
}