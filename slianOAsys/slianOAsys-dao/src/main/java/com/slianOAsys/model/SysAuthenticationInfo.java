package com.slianOAsys.model;

import java.util.Date;

public class SysAuthenticationInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_authentication_info.authentication_id
     *
     * @mbggenerated
     */
    private Integer authenticationId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_authentication_info.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_authentication_info.account
     *
     * @mbggenerated
     */
    private String account;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_authentication_info.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_authentication_info.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_authentication_info.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_authentication_info.last_time
     *
     * @mbggenerated
     */
    private Date lastTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_authentication_info.last_ip
     *
     * @mbggenerated
     */
    private String lastIp;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_authentication_info.authentication_id
     *
     * @return the value of sys_authentication_info.authentication_id
     *
     * @mbggenerated
     */
    public Integer getAuthenticationId() {
        return authenticationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_authentication_info.authentication_id
     *
     * @param authenticationId the value for sys_authentication_info.authentication_id
     *
     * @mbggenerated
     */
    public void setAuthenticationId(Integer authenticationId) {
        this.authenticationId = authenticationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_authentication_info.user_id
     *
     * @return the value of sys_authentication_info.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_authentication_info.user_id
     *
     * @param userId the value for sys_authentication_info.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_authentication_info.account
     *
     * @return the value of sys_authentication_info.account
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_authentication_info.account
     *
     * @param account the value for sys_authentication_info.account
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_authentication_info.password
     *
     * @return the value of sys_authentication_info.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_authentication_info.password
     *
     * @param password the value for sys_authentication_info.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_authentication_info.type
     *
     * @return the value of sys_authentication_info.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_authentication_info.type
     *
     * @param type the value for sys_authentication_info.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_authentication_info.status
     *
     * @return the value of sys_authentication_info.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_authentication_info.status
     *
     * @param status the value for sys_authentication_info.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_authentication_info.last_time
     *
     * @return the value of sys_authentication_info.last_time
     *
     * @mbggenerated
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_authentication_info.last_time
     *
     * @param lastTime the value for sys_authentication_info.last_time
     *
     * @mbggenerated
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_authentication_info.last_ip
     *
     * @return the value of sys_authentication_info.last_ip
     *
     * @mbggenerated
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_authentication_info.last_ip
     *
     * @param lastIp the value for sys_authentication_info.last_ip
     *
     * @mbggenerated
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp == null ? null : lastIp.trim();
    }
}