package com.slianOAsys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.slianOAsys.model.SysRolesResources;
import com.slianOAsys.model.SysRolesResourcesExample;

public interface SysRolesResourcesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles_resources
     *
     * @mbggenerated
     */
    int countByExample(SysRolesResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles_resources
     *
     * @mbggenerated
     */
    int deleteByExample(SysRolesResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles_resources
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer rrId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles_resources
     *
     * @mbggenerated
     */
    int insert(SysRolesResources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles_resources
     *
     * @mbggenerated
     */
    int insertSelective(SysRolesResources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles_resources
     *
     * @mbggenerated
     */
    List<SysRolesResources> selectByExample(SysRolesResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles_resources
     *
     * @mbggenerated
     */
    SysRolesResources selectByPrimaryKey(Integer rrId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles_resources
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysRolesResources record, @Param("example") SysRolesResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles_resources
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysRolesResources record, @Param("example") SysRolesResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles_resources
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysRolesResources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles_resources
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysRolesResources record);
}