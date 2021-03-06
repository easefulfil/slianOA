package com.slianOAsys.model;

import java.util.Date;

public class SlianoaAppeal {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_appeal.appeal_id
     *
     * @mbggenerated
     */
    private Integer appealId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_appeal.employee_id
     *
     * @mbggenerated
     */
    private Integer employeeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_appeal.appeal_time
     *
     * @mbggenerated
     */
    private String appealTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_appeal.abnormal_status
     *
     * @mbggenerated
     */
    private String abnormalStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_appeal.appeal_reason
     *
     * @mbggenerated
     */
    private String appealReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_appeal.appeal_status
     *
     * @mbggenerated
     */
    private String appealStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_appeal.handle_employee_id
     *
     * @mbggenerated
     */
    private Integer handleEmployeeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_appeal.related_employee
     *
     * @mbggenerated
     */
    private String relatedEmployee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_appeal.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_appeal.handle_time
     *
     * @mbggenerated
     */
    private String handleTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_appeal.appeal_id
     *
     * @return the value of slianoa_appeal.appeal_id
     *
     * @mbggenerated
     */
    public Integer getAppealId() {
        return appealId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_appeal.appeal_id
     *
     * @param appealId the value for slianoa_appeal.appeal_id
     *
     * @mbggenerated
     */
    public void setAppealId(Integer appealId) {
        this.appealId = appealId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_appeal.employee_id
     *
     * @return the value of slianoa_appeal.employee_id
     *
     * @mbggenerated
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_appeal.employee_id
     *
     * @param employeeId the value for slianoa_appeal.employee_id
     *
     * @mbggenerated
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_appeal.appeal_time
     *
     * @return the value of slianoa_appeal.appeal_time
     *
     * @mbggenerated
     */
    public String getAppealTime() {
        return appealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_appeal.appeal_time
     *
     * @param appealTime the value for slianoa_appeal.appeal_time
     *
     * @mbggenerated
     */
    public void setAppealTime(String appealTime) {
        this.appealTime = appealTime == null ? null : appealTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_appeal.abnormal_status
     *
     * @return the value of slianoa_appeal.abnormal_status
     *
     * @mbggenerated
     */
    public String getAbnormalStatus() {
        return abnormalStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_appeal.abnormal_status
     *
     * @param abnormalStatus the value for slianoa_appeal.abnormal_status
     *
     * @mbggenerated
     */
    public void setAbnormalStatus(String abnormalStatus) {
        this.abnormalStatus = abnormalStatus == null ? null : abnormalStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_appeal.appeal_reason
     *
     * @return the value of slianoa_appeal.appeal_reason
     *
     * @mbggenerated
     */
    public String getAppealReason() {
        return appealReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_appeal.appeal_reason
     *
     * @param appealReason the value for slianoa_appeal.appeal_reason
     *
     * @mbggenerated
     */
    public void setAppealReason(String appealReason) {
        this.appealReason = appealReason == null ? null : appealReason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_appeal.appeal_status
     *
     * @return the value of slianoa_appeal.appeal_status
     *
     * @mbggenerated
     */
    public String getAppealStatus() {
        return appealStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_appeal.appeal_status
     *
     * @param appealStatus the value for slianoa_appeal.appeal_status
     *
     * @mbggenerated
     */
    public void setAppealStatus(String appealStatus) {
        this.appealStatus = appealStatus == null ? null : appealStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_appeal.handle_employee_id
     *
     * @return the value of slianoa_appeal.handle_employee_id
     *
     * @mbggenerated
     */
    public Integer getHandleEmployeeId() {
        return handleEmployeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_appeal.handle_employee_id
     *
     * @param handleEmployeeId the value for slianoa_appeal.handle_employee_id
     *
     * @mbggenerated
     */
    public void setHandleEmployeeId(Integer handleEmployeeId) {
        this.handleEmployeeId = handleEmployeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_appeal.related_employee
     *
     * @return the value of slianoa_appeal.related_employee
     *
     * @mbggenerated
     */
    public String getRelatedEmployee() {
        return relatedEmployee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_appeal.related_employee
     *
     * @param relatedEmployee the value for slianoa_appeal.related_employee
     *
     * @mbggenerated
     */
    public void setRelatedEmployee(String relatedEmployee) {
        this.relatedEmployee = relatedEmployee == null ? null : relatedEmployee.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_appeal.create_time
     *
     * @return the value of slianoa_appeal.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_appeal.create_time
     *
     * @param createTime the value for slianoa_appeal.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_appeal.handle_time
     *
     * @return the value of slianoa_appeal.handle_time
     *
     * @mbggenerated
     */
    public String getHandleTime() {
        return handleTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_appeal.handle_time
     *
     * @param handleTime the value for slianoa_appeal.handle_time
     *
     * @mbggenerated
     */
    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime == null ? null : handleTime.trim();
    }
}