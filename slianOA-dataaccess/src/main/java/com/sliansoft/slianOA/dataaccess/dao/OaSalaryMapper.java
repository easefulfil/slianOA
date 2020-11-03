package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaSalary;
import com.sliansoft.slianOA.dataaccess.model.OaSalaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaSalaryMapper {
    int countByExample(OaSalaryExample example);

    int deleteByExample(OaSalaryExample example);

    int deleteByPrimaryKey(Integer salaryId);

    int insert(OaSalary record);

    int insertSelective(OaSalary record);

    List<OaSalary> selectByExample(OaSalaryExample example);

    OaSalary selectByPrimaryKey(Integer salaryId);

    int updateByExampleSelective(@Param("record") OaSalary record, @Param("example") OaSalaryExample example);

    int updateByExample(@Param("record") OaSalary record, @Param("example") OaSalaryExample example);

    int updateByPrimaryKeySelective(OaSalary record);

    int updateByPrimaryKey(OaSalary record);

    List<OaSalary> selectPage(OaSalaryExample example);
}