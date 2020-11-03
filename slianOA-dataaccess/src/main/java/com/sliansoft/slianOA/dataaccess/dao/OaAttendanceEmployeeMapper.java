package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaAttendanceEmployee;
import com.sliansoft.slianOA.dataaccess.model.OaAttendanceEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaAttendanceEmployeeMapper {
    int countByExample(OaAttendanceEmployeeExample example);

    int deleteByExample(OaAttendanceEmployeeExample example);

    int deleteByPrimaryKey(Integer attendanceEmployeeId);

    int insert(OaAttendanceEmployee record);

    int insertSelective(OaAttendanceEmployee record);

    List<OaAttendanceEmployee> selectByExample(OaAttendanceEmployeeExample example);

    OaAttendanceEmployee selectByPrimaryKey(Integer attendanceEmployeeId);

    int updateByExampleSelective(@Param("record") OaAttendanceEmployee record, @Param("example") OaAttendanceEmployeeExample example);

    int updateByExample(@Param("record") OaAttendanceEmployee record, @Param("example") OaAttendanceEmployeeExample example);

    int updateByPrimaryKeySelective(OaAttendanceEmployee record);

    int updateByPrimaryKey(OaAttendanceEmployee record);

    List<OaAttendanceEmployee> selectPage(OaAttendanceEmployeeExample example);
}