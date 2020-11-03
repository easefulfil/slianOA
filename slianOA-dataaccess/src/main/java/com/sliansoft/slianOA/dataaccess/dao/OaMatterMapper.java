package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaMatter;
import com.sliansoft.slianOA.dataaccess.model.OaMatterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaMatterMapper {
    int countByExample(OaMatterExample example);

    int deleteByExample(OaMatterExample example);

    int deleteByPrimaryKey(Integer matterId);

    int insert(OaMatter record);

    int insertSelective(OaMatter record);

    List<OaMatter> selectByExample(OaMatterExample example);

    OaMatter selectByPrimaryKey(Integer matterId);

    int updateByExampleSelective(@Param("record") OaMatter record, @Param("example") OaMatterExample example);

    int updateByExample(@Param("record") OaMatter record, @Param("example") OaMatterExample example);

    int updateByPrimaryKeySelective(OaMatter record);

    int updateByPrimaryKey(OaMatter record);

    List<OaMatter> selectPage(OaMatterExample example);

	List<OaMatter> selectPage1(OaMatterExample example);




}