package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaAttendanceAppeal;
import com.sliansoft.slianOA.dataaccess.model.OaAttendanceAppealExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaAttendanceAppealMapper {
    int countByExample(OaAttendanceAppealExample example);

    int deleteByExample(OaAttendanceAppealExample example);

    int deleteByPrimaryKey(Integer appealId);

    int insert(OaAttendanceAppeal record);

    int insertSelective(OaAttendanceAppeal record);

    List<OaAttendanceAppeal> selectByExample(OaAttendanceAppealExample example);

    OaAttendanceAppeal selectByPrimaryKey(Integer appealId);

    int updateByExampleSelective(@Param("record") OaAttendanceAppeal record, @Param("example") OaAttendanceAppealExample example);

    int updateByExample(@Param("record") OaAttendanceAppeal record, @Param("example") OaAttendanceAppealExample example);

    int updateByPrimaryKeySelective(OaAttendanceAppeal record);

    int updateByPrimaryKey(OaAttendanceAppeal record);

    List<OaAttendanceAppeal> selectPage(OaAttendanceAppealExample example);

	List<OaAttendanceAppeal> selectPage1(OaAttendanceAppealExample example);
}