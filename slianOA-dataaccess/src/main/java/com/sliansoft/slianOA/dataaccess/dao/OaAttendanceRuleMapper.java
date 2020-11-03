package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaAttendanceRule;
import com.sliansoft.slianOA.dataaccess.model.OaAttendanceRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaAttendanceRuleMapper {
    int countByExample(OaAttendanceRuleExample example);

    int deleteByExample(OaAttendanceRuleExample example);

    int deleteByPrimaryKey(Integer attendanceRuleId);

    int insert(OaAttendanceRule record);

    int insertSelective(OaAttendanceRule record);

    List<OaAttendanceRule> selectByExample(OaAttendanceRuleExample example);

    OaAttendanceRule selectByPrimaryKey(Integer attendanceRuleId);

    int updateByExampleSelective(@Param("record") OaAttendanceRule record, @Param("example") OaAttendanceRuleExample example);

    int updateByExample(@Param("record") OaAttendanceRule record, @Param("example") OaAttendanceRuleExample example);

    int updateByPrimaryKeySelective(OaAttendanceRule record);

    int updateByPrimaryKey(OaAttendanceRule record);

    List<OaAttendanceRule> selectPage(OaAttendanceRuleExample example);
}