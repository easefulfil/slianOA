package com.slianOAsys.model;

public class SysSetting {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_setting.st_key
     *
     * @mbggenerated
     */
    private String stKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_setting.st_value
     *
     * @mbggenerated
     */
    private String stValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_setting.decription
     *
     * @mbggenerated
     */
    private String decription;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_setting.st_key
     *
     * @return the value of sys_setting.st_key
     *
     * @mbggenerated
     */
    public String getStKey() {
        return stKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_setting.st_key
     *
     * @param stKey the value for sys_setting.st_key
     *
     * @mbggenerated
     */
    public void setStKey(String stKey) {
        this.stKey = stKey == null ? null : stKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_setting.st_value
     *
     * @return the value of sys_setting.st_value
     *
     * @mbggenerated
     */
    public String getStValue() {
        return stValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_setting.st_value
     *
     * @param stValue the value for sys_setting.st_value
     *
     * @mbggenerated
     */
    public void setStValue(String stValue) {
        this.stValue = stValue == null ? null : stValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_setting.decription
     *
     * @return the value of sys_setting.decription
     *
     * @mbggenerated
     */
    public String getDecription() {
        return decription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_setting.decription
     *
     * @param decription the value for sys_setting.decription
     *
     * @mbggenerated
     */
    public void setDecription(String decription) {
        this.decription = decription == null ? null : decription.trim();
    }
}