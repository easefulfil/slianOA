package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaNews;
import com.sliansoft.slianOA.dataaccess.model.OaNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaNewsMapper {
    int countByExample(OaNewsExample example);

    int deleteByExample(OaNewsExample example);

    int deleteByPrimaryKey(Integer newsId);

    int insert(OaNews record);

    int insertSelective(OaNews record);

    List<OaNews> selectByExampleWithBLOBs(OaNewsExample example);

    List<OaNews> selectByExample(OaNewsExample example);

    OaNews selectByPrimaryKey(Integer newsId);

    int updateByExampleSelective(@Param("record") OaNews record, @Param("example") OaNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") OaNews record, @Param("example") OaNewsExample example);

    int updateByExample(@Param("record") OaNews record, @Param("example") OaNewsExample example);

    int updateByPrimaryKeySelective(OaNews record);

    int updateByPrimaryKeyWithBLOBs(OaNews record);

    int updateByPrimaryKey(OaNews record);

    List<OaNews> selectPage(OaNewsExample example);
}