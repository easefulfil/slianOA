package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaInstrument;
import com.sliansoft.slianOA.dataaccess.model.OaInstrumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaInstrumentMapper {
    int countByExample(OaInstrumentExample example);

    int deleteByExample(OaInstrumentExample example);

    int deleteByPrimaryKey(Integer instrumentId);

    int insert(OaInstrument record);

    int insertSelective(OaInstrument record);

    List<OaInstrument> selectByExample(OaInstrumentExample example);

    OaInstrument selectByPrimaryKey(Integer instrumentId);

    int updateByExampleSelective(@Param("record") OaInstrument record, @Param("example") OaInstrumentExample example);

    int updateByExample(@Param("record") OaInstrument record, @Param("example") OaInstrumentExample example);

    int updateByPrimaryKeySelective(OaInstrument record);

    int updateByPrimaryKey(OaInstrument record);

    List<OaInstrument> selectPage(OaInstrumentExample example);
}