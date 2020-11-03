package com.slianOAsys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.slianOAsys.model.SysSetting;
import com.slianOAsys.model.SysSettingExample;

public interface SysSettingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated
     */
    int countByExample(SysSettingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated
     */
    int deleteByExample(SysSettingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String stKey);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated
     */
    int insert(SysSetting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated
     */
    int insertSelective(SysSetting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated
     */
    List<SysSetting> selectByExample(SysSettingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated
     */
    SysSetting selectByPrimaryKey(String stKey);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysSetting record, @Param("example") SysSettingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysSetting record, @Param("example") SysSettingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysSetting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_setting
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysSetting record);
}