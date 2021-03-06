package com.slianOAsys.model;

import java.util.Date;

public class SlianoaEmployee {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_id
     *
     * @mbggenerated
     */
    private Integer employeeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.depart_id
     *
     * @mbggenerated
     */
    private Integer departId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_name
     *
     * @mbggenerated
     */
    private String employeeName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_gender
     *
     * @mbggenerated
     */
    private String employeeGender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_position
     *
     * @mbggenerated
     */
    private String employeePosition;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_age
     *
     * @mbggenerated
     */
    private Integer employeeAge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_phone_number
     *
     * @mbggenerated
     */
    private String employeePhoneNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_status
     *
     * @mbggenerated
     */
    private String employeeStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_Idcard
     *
     * @mbggenerated
     */
    private String employeeIdcard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_bankcard
     *
     * @mbggenerated
     */
    private String employeeBankcard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_openbank
     *
     * @mbggenerated
     */
    private String employeeOpenbank;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.entrytime
     *
     * @mbggenerated
     */
    private Date entrytime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.leavetime
     *
     * @mbggenerated
     */
    private Date leavetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_Undergraduate_school
     *
     * @mbggenerated
     */
    private String employeeUndergraduateSchool;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_education_background
     *
     * @mbggenerated
     */
    private String employeeEducationBackground;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_grade
     *
     * @mbggenerated
     */
    private String employeeGrade;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_major
     *
     * @mbggenerated
     */
    private String employeeMajor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_email
     *
     * @mbggenerated
     */
    private String employeeEmail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slianoa_employee.employee_wechat
     *
     * @mbggenerated
     */
    private String employeeWechat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_id
     *
     * @return the value of slianoa_employee.employee_id
     *
     * @mbggenerated
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_id
     *
     * @param employeeId the value for slianoa_employee.employee_id
     *
     * @mbggenerated
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.depart_id
     *
     * @return the value of slianoa_employee.depart_id
     *
     * @mbggenerated
     */
    public Integer getDepartId() {
        return departId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.depart_id
     *
     * @param departId the value for slianoa_employee.depart_id
     *
     * @mbggenerated
     */
    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_name
     *
     * @return the value of slianoa_employee.employee_name
     *
     * @mbggenerated
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_name
     *
     * @param employeeName the value for slianoa_employee.employee_name
     *
     * @mbggenerated
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_gender
     *
     * @return the value of slianoa_employee.employee_gender
     *
     * @mbggenerated
     */
    public String getEmployeeGender() {
        return employeeGender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_gender
     *
     * @param employeeGender the value for slianoa_employee.employee_gender
     *
     * @mbggenerated
     */
    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender == null ? null : employeeGender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_position
     *
     * @return the value of slianoa_employee.employee_position
     *
     * @mbggenerated
     */
    public String getEmployeePosition() {
        return employeePosition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_position
     *
     * @param employeePosition the value for slianoa_employee.employee_position
     *
     * @mbggenerated
     */
    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition == null ? null : employeePosition.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_age
     *
     * @return the value of slianoa_employee.employee_age
     *
     * @mbggenerated
     */
    public Integer getEmployeeAge() {
        return employeeAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_age
     *
     * @param employeeAge the value for slianoa_employee.employee_age
     *
     * @mbggenerated
     */
    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_phone_number
     *
     * @return the value of slianoa_employee.employee_phone_number
     *
     * @mbggenerated
     */
    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_phone_number
     *
     * @param employeePhoneNumber the value for slianoa_employee.employee_phone_number
     *
     * @mbggenerated
     */
    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber == null ? null : employeePhoneNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_status
     *
     * @return the value of slianoa_employee.employee_status
     *
     * @mbggenerated
     */
    public String getEmployeeStatus() {
        return employeeStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_status
     *
     * @param employeeStatus the value for slianoa_employee.employee_status
     *
     * @mbggenerated
     */
    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus == null ? null : employeeStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_Idcard
     *
     * @return the value of slianoa_employee.employee_Idcard
     *
     * @mbggenerated
     */
    public String getEmployeeIdcard() {
        return employeeIdcard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_Idcard
     *
     * @param employeeIdcard the value for slianoa_employee.employee_Idcard
     *
     * @mbggenerated
     */
    public void setEmployeeIdcard(String employeeIdcard) {
        this.employeeIdcard = employeeIdcard == null ? null : employeeIdcard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_bankcard
     *
     * @return the value of slianoa_employee.employee_bankcard
     *
     * @mbggenerated
     */
    public String getEmployeeBankcard() {
        return employeeBankcard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_bankcard
     *
     * @param employeeBankcard the value for slianoa_employee.employee_bankcard
     *
     * @mbggenerated
     */
    public void setEmployeeBankcard(String employeeBankcard) {
        this.employeeBankcard = employeeBankcard == null ? null : employeeBankcard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_openbank
     *
     * @return the value of slianoa_employee.employee_openbank
     *
     * @mbggenerated
     */
    public String getEmployeeOpenbank() {
        return employeeOpenbank;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_openbank
     *
     * @param employeeOpenbank the value for slianoa_employee.employee_openbank
     *
     * @mbggenerated
     */
    public void setEmployeeOpenbank(String employeeOpenbank) {
        this.employeeOpenbank = employeeOpenbank == null ? null : employeeOpenbank.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.entrytime
     *
     * @return the value of slianoa_employee.entrytime
     *
     * @mbggenerated
     */
    public Date getEntrytime() {
        return entrytime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.entrytime
     *
     * @param entrytime the value for slianoa_employee.entrytime
     *
     * @mbggenerated
     */
    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.leavetime
     *
     * @return the value of slianoa_employee.leavetime
     *
     * @mbggenerated
     */
    public Date getLeavetime() {
        return leavetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.leavetime
     *
     * @param leavetime the value for slianoa_employee.leavetime
     *
     * @mbggenerated
     */
    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_Undergraduate_school
     *
     * @return the value of slianoa_employee.employee_Undergraduate_school
     *
     * @mbggenerated
     */
    public String getEmployeeUndergraduateSchool() {
        return employeeUndergraduateSchool;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_Undergraduate_school
     *
     * @param employeeUndergraduateSchool the value for slianoa_employee.employee_Undergraduate_school
     *
     * @mbggenerated
     */
    public void setEmployeeUndergraduateSchool(String employeeUndergraduateSchool) {
        this.employeeUndergraduateSchool = employeeUndergraduateSchool == null ? null : employeeUndergraduateSchool.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_education_background
     *
     * @return the value of slianoa_employee.employee_education_background
     *
     * @mbggenerated
     */
    public String getEmployeeEducationBackground() {
        return employeeEducationBackground;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_education_background
     *
     * @param employeeEducationBackground the value for slianoa_employee.employee_education_background
     *
     * @mbggenerated
     */
    public void setEmployeeEducationBackground(String employeeEducationBackground) {
        this.employeeEducationBackground = employeeEducationBackground == null ? null : employeeEducationBackground.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_grade
     *
     * @return the value of slianoa_employee.employee_grade
     *
     * @mbggenerated
     */
    public String getEmployeeGrade() {
        return employeeGrade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_grade
     *
     * @param employeeGrade the value for slianoa_employee.employee_grade
     *
     * @mbggenerated
     */
    public void setEmployeeGrade(String employeeGrade) {
        this.employeeGrade = employeeGrade == null ? null : employeeGrade.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_major
     *
     * @return the value of slianoa_employee.employee_major
     *
     * @mbggenerated
     */
    public String getEmployeeMajor() {
        return employeeMajor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_major
     *
     * @param employeeMajor the value for slianoa_employee.employee_major
     *
     * @mbggenerated
     */
    public void setEmployeeMajor(String employeeMajor) {
        this.employeeMajor = employeeMajor == null ? null : employeeMajor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_email
     *
     * @return the value of slianoa_employee.employee_email
     *
     * @mbggenerated
     */
    public String getEmployeeEmail() {
        return employeeEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_email
     *
     * @param employeeEmail the value for slianoa_employee.employee_email
     *
     * @mbggenerated
     */
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail == null ? null : employeeEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slianoa_employee.employee_wechat
     *
     * @return the value of slianoa_employee.employee_wechat
     *
     * @mbggenerated
     */
    public String getEmployeeWechat() {
        return employeeWechat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slianoa_employee.employee_wechat
     *
     * @param employeeWechat the value for slianoa_employee.employee_wechat
     *
     * @mbggenerated
     */
    public void setEmployeeWechat(String employeeWechat) {
        this.employeeWechat = employeeWechat == null ? null : employeeWechat.trim();
    }
}