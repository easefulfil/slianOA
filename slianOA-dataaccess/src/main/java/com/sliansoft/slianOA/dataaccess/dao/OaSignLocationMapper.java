package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaSignLocation;
import com.sliansoft.slianOA.dataaccess.model.OaSignLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaSignLocationMapper {
    int countByExample(OaSignLocationExample example);

    int deleteByExample(OaSignLocationExample example);

    int deleteByPrimaryKey(Integer signLocationId);

    int insert(OaSignLocation record);

    int insertSelective(OaSignLocation record);

    List<OaSignLocation> selectByExample(OaSignLocationExample example);

    OaSignLocation selectByPrimaryKey(Integer signLocationId);

    int updateByExampleSelective(@Param("record") OaSignLocation record, @Param("example") OaSignLocationExample example);

    int updateByExample(@Param("record") OaSignLocation record, @Param("example") OaSignLocationExample example);

    int updateByPrimaryKeySelective(OaSignLocation record);

    int updateByPrimaryKey(OaSignLocation record);

    List<OaSignLocation> selectPage(OaSignLocationExample example);
}