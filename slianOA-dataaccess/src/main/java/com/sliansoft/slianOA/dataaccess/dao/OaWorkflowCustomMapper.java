package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaWorkflowCustom;
import com.sliansoft.slianOA.dataaccess.model.OaWorkflowCustomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaWorkflowCustomMapper {
    int countByExample(OaWorkflowCustomExample example);

    int deleteByExample(OaWorkflowCustomExample example);

    int deleteByPrimaryKey(Integer workflowCustomId);

    int insert(OaWorkflowCustom record);

    int insertSelective(OaWorkflowCustom record);

    List<OaWorkflowCustom> selectByExample(OaWorkflowCustomExample example);

    OaWorkflowCustom selectByPrimaryKey(Integer workflowCustomId);

    int updateByExampleSelective(@Param("record") OaWorkflowCustom record, @Param("example") OaWorkflowCustomExample example);

    int updateByExample(@Param("record") OaWorkflowCustom record, @Param("example") OaWorkflowCustomExample example);

    int updateByPrimaryKeySelective(OaWorkflowCustom record);

    int updateByPrimaryKey(OaWorkflowCustom record);

    List<OaWorkflowCustom> selectPage(OaWorkflowCustomExample example);
}