package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaStash;
import com.sliansoft.slianOA.dataaccess.model.OaStashExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaStashMapper {
    int countByExample(OaStashExample example);

    int deleteByExample(OaStashExample example);

    int deleteByPrimaryKey(Integer stashId);

    int insert(OaStash record);

    int insertSelective(OaStash record);

    List<OaStash> selectByExample(OaStashExample example);

    OaStash selectByPrimaryKey(Integer stashId);

    int updateByExampleSelective(@Param("record") OaStash record, @Param("example") OaStashExample example);

    int updateByExample(@Param("record") OaStash record, @Param("example") OaStashExample example);

    int updateByPrimaryKeySelective(OaStash record);

    int updateByPrimaryKey(OaStash record);

    List<OaStash> selectPage(OaStashExample example);
}