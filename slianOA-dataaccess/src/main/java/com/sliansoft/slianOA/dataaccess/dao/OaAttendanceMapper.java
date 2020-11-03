package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaAttendance;
import com.sliansoft.slianOA.dataaccess.model.OaAttendanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaAttendanceMapper {
    int countByExample(OaAttendanceExample example);

    int deleteByExample(OaAttendanceExample example);

    int deleteByPrimaryKey(Integer attendanceId);

    int insert(OaAttendance record);

    int insertSelective(OaAttendance record);

    List<OaAttendance> selectByExample(OaAttendanceExample example);

    OaAttendance selectByPrimaryKey(Integer attendanceId);

    int updateByExampleSelective(@Param("record") OaAttendance record, @Param("example") OaAttendanceExample example);

    int updateByExample(@Param("record") OaAttendance record, @Param("example") OaAttendanceExample example);

    int updateByPrimaryKeySelective(OaAttendance record);

    int updateByPrimaryKey(OaAttendance record);

    List<OaAttendance> selectPage(OaAttendanceExample example);

	List<OaAttendance> selectPage1(OaAttendanceExample example);
}