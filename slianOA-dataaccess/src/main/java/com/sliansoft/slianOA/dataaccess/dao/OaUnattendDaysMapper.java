package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaUnattendDays;
import com.sliansoft.slianOA.dataaccess.model.OaUnattendDaysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaUnattendDaysMapper {
    int countByExample(OaUnattendDaysExample example);

    int deleteByExample(OaUnattendDaysExample example);

    int deleteByPrimaryKey(Integer unattendDaysId);

    int insert(OaUnattendDays record);

    int insertSelective(OaUnattendDays record);

    List<OaUnattendDays> selectByExample(OaUnattendDaysExample example);

    OaUnattendDays selectByPrimaryKey(Integer unattendDaysId);

    int updateByExampleSelective(@Param("record") OaUnattendDays record, @Param("example") OaUnattendDaysExample example);

    int updateByExample(@Param("record") OaUnattendDays record, @Param("example") OaUnattendDaysExample example);

    int updateByPrimaryKeySelective(OaUnattendDays record);

    int updateByPrimaryKey(OaUnattendDays record);

    List<OaUnattendDays> selectPage(OaUnattendDaysExample example);
}