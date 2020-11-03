package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaProject;
import com.sliansoft.slianOA.dataaccess.model.OaProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaProjectMapper {
    int countByExample(OaProjectExample example);

    int deleteByExample(OaProjectExample example);

    int deleteByPrimaryKey(Integer projectId);

    int insert(OaProject record);

    int insertSelective(OaProject record);

    List<OaProject> selectByExample(OaProjectExample example);

    OaProject selectByPrimaryKey(Integer projectId);

    int updateByExampleSelective(@Param("record") OaProject record, @Param("example") OaProjectExample example);

    int updateByExample(@Param("record") OaProject record, @Param("example") OaProjectExample example);

    int updateByPrimaryKeySelective(OaProject record);

    int updateByPrimaryKey(OaProject record);

    List<OaProject> selectPage(OaProjectExample example);
}