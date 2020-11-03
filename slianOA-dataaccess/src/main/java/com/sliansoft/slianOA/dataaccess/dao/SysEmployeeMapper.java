package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.SysEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysEmployeeMapper {
    int countByExample(SysEmployeeExample example);

    int deleteByExample(SysEmployeeExample example);

    int deleteByPrimaryKey(Integer employeeId);

    int insert(SysEmployee record);

    int insertSelective(SysEmployee record);

    List<SysEmployee> selectByExample(SysEmployeeExample example);

    SysEmployee selectByPrimaryKey(Integer employeeId);

    int updateByExampleSelective(@Param("record") SysEmployee record, @Param("example") SysEmployeeExample example);

    int updateByExample(@Param("record") SysEmployee record, @Param("example") SysEmployeeExample example);

    int updateByPrimaryKeySelective(SysEmployee record);

    int updateByPrimaryKey(SysEmployee record);

    List<SysEmployee> selectPage(SysEmployeeExample example);
    
    int insertAndGetId(SysEmployee record);
}