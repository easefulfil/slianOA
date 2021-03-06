package com.slianOAsys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.slianOAsys.model.SysResources;
import com.slianOAsys.model.SysResourcesExample;

public interface SysResourcesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated
     */
    int countByExample(SysResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated
     */
    int deleteByExample(SysResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer resourceId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated
     */
    int insert(SysResources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated
     */
    int insertSelective(SysResources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated
     */
    List<SysResources> selectByExample(SysResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated
     */
    SysResources selectByPrimaryKey(Integer resourceId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysResources record, @Param("example") SysResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysResources record, @Param("example") SysResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysResources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysResources record);
}