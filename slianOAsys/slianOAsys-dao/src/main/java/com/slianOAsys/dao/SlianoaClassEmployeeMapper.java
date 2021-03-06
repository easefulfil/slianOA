package com.slianOAsys.dao;

import com.slianOAsys.model.SlianoaClassEmployee;
import com.slianOAsys.model.SlianoaClassEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SlianoaClassEmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_class_employee
     *
     * @mbggenerated
     */
    int countByExample(SlianoaClassEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_class_employee
     *
     * @mbggenerated
     */
    int deleteByExample(SlianoaClassEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_class_employee
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer classEmployeeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_class_employee
     *
     * @mbggenerated
     */
    int insert(SlianoaClassEmployee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_class_employee
     *
     * @mbggenerated
     */
    int insertSelective(SlianoaClassEmployee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_class_employee
     *
     * @mbggenerated
     */
    List<SlianoaClassEmployee> selectByExample(SlianoaClassEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_class_employee
     *
     * @mbggenerated
     */
    SlianoaClassEmployee selectByPrimaryKey(Integer classEmployeeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_class_employee
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SlianoaClassEmployee record, @Param("example") SlianoaClassEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_class_employee
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SlianoaClassEmployee record, @Param("example") SlianoaClassEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_class_employee
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SlianoaClassEmployee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table slianoa_class_employee
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SlianoaClassEmployee record);
}