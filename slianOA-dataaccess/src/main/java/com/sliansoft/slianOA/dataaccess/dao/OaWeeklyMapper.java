package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaWeekly;
import com.sliansoft.slianOA.dataaccess.model.OaWeeklyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaWeeklyMapper {
    int countByExample(OaWeeklyExample example);

    int deleteByExample(OaWeeklyExample example);

    int deleteByPrimaryKey(Integer weeklyId);

    int insert(OaWeekly record);

    int insertSelective(OaWeekly record);

    List<OaWeekly> selectByExample(OaWeeklyExample example);

    OaWeekly selectByPrimaryKey(Integer weeklyId);

    int updateByExampleSelective(@Param("record") OaWeekly record, @Param("example") OaWeeklyExample example);

    int updateByExample(@Param("record") OaWeekly record, @Param("example") OaWeeklyExample example);

    int updateByPrimaryKeySelective(OaWeekly record);

    int updateByPrimaryKey(OaWeekly record);

    List<OaWeekly> selectPage(OaWeeklyExample example);

	List<OaWeekly> selectPage1(OaWeeklyExample example);
}