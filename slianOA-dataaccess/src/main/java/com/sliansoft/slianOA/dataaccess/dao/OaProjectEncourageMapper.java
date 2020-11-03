package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaProjectEncourage;
import com.sliansoft.slianOA.dataaccess.model.OaProjectEncourageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaProjectEncourageMapper {
    int countByExample(OaProjectEncourageExample example);

    int deleteByExample(OaProjectEncourageExample example);

    int deleteByPrimaryKey(Integer projectEncourageId);

    int insert(OaProjectEncourage record);

    int insertSelective(OaProjectEncourage record);

    List<OaProjectEncourage> selectByExample(OaProjectEncourageExample example);

    OaProjectEncourage selectByPrimaryKey(Integer projectEncourageId);

    int updateByExampleSelective(@Param("record") OaProjectEncourage record, @Param("example") OaProjectEncourageExample example);

    int updateByExample(@Param("record") OaProjectEncourage record, @Param("example") OaProjectEncourageExample example);

    int updateByPrimaryKeySelective(OaProjectEncourage record);

    int updateByPrimaryKey(OaProjectEncourage record);

    List<OaProjectEncourage> selectPage(OaProjectEncourageExample example);
}