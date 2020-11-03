package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaSalaryDistribute;
import com.sliansoft.slianOA.dataaccess.model.OaSalaryDistributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaSalaryDistributeMapper {
    int countByExample(OaSalaryDistributeExample example);

    int deleteByExample(OaSalaryDistributeExample example);

    int deleteByPrimaryKey(Integer salaryDistributeId);

    int insert(OaSalaryDistribute record);

    int insertSelective(OaSalaryDistribute record);

    List<OaSalaryDistribute> selectByExample(OaSalaryDistributeExample example);

    OaSalaryDistribute selectByPrimaryKey(Integer salaryDistributeId);

    int updateByExampleSelective(@Param("record") OaSalaryDistribute record, @Param("example") OaSalaryDistributeExample example);

    int updateByExample(@Param("record") OaSalaryDistribute record, @Param("example") OaSalaryDistributeExample example);

    int updateByPrimaryKeySelective(OaSalaryDistribute record);

    int updateByPrimaryKey(OaSalaryDistribute record);

    List<OaSalaryDistribute> selectPage(OaSalaryDistributeExample example);
}