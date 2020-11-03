package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaWorkflow;
import com.sliansoft.slianOA.dataaccess.model.OaWorkflowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaWorkflowMapper {
    int countByExample(OaWorkflowExample example);

    int deleteByExample(OaWorkflowExample example);

    int deleteByPrimaryKey(Integer workflowId);

    int insert(OaWorkflow record);

    int insertSelective(OaWorkflow record);

    List<OaWorkflow> selectByExample(OaWorkflowExample example);

    OaWorkflow selectByPrimaryKey(Integer workflowId);

    int updateByExampleSelective(@Param("record") OaWorkflow record, @Param("example") OaWorkflowExample example);

    int updateByExample(@Param("record") OaWorkflow record, @Param("example") OaWorkflowExample example);

    int updateByPrimaryKeySelective(OaWorkflow record);

    int updateByPrimaryKey(OaWorkflow record);

    List<OaWorkflow> selectPage(OaWorkflowExample example);
}