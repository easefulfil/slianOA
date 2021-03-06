package com.slianOAsys.dao;

import com.slianOAsys.model.test;
import com.slianOAsys.model.testExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface testMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int countByExample(testExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int deleteByExample(testExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer testId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int insert(test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int insertSelective(test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    List<test> selectByExample(testExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    test selectByPrimaryKey(Integer testId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") test record, @Param("example") testExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") test record, @Param("example") testExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(test record);
    
   
}