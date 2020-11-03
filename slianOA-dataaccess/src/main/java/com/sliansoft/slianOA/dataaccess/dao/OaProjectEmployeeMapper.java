package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaProjectEmployee;
import com.sliansoft.slianOA.dataaccess.model.OaProjectEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaProjectEmployeeMapper {
    int countByExample(OaProjectEmployeeExample example);

    int deleteByExample(OaProjectEmployeeExample example);

    int deleteByPrimaryKey(Integer projectEmployeeId);

    int insert(OaProjectEmployee record);

    int insertSelective(OaProjectEmployee record);

    List<OaProjectEmployee> selectByExample(OaProjectEmployeeExample example);

    OaProjectEmployee selectByPrimaryKey(Integer projectEmployeeId);

    int updateByExampleSelective(@Param("record") OaProjectEmployee record, @Param("example") OaProjectEmployeeExample example);

    int updateByExample(@Param("record") OaProjectEmployee record, @Param("example") OaProjectEmployeeExample example);

    int updateByPrimaryKeySelective(OaProjectEmployee record);

    int updateByPrimaryKey(OaProjectEmployee record);

    List<OaProjectEmployee> selectPage(OaProjectEmployeeExample example);
}