package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaInstrumentCalibration;
import com.sliansoft.slianOA.dataaccess.model.OaInstrumentCalibrationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaInstrumentCalibrationMapper {
    int countByExample(OaInstrumentCalibrationExample example);

    int deleteByExample(OaInstrumentCalibrationExample example);

    int deleteByPrimaryKey(Integer calibrationId);

    int insert(OaInstrumentCalibration record);

    int insertSelective(OaInstrumentCalibration record);

    List<OaInstrumentCalibration> selectByExample(OaInstrumentCalibrationExample example);

    OaInstrumentCalibration selectByPrimaryKey(Integer calibrationId);

    int updateByExampleSelective(@Param("record") OaInstrumentCalibration record, @Param("example") OaInstrumentCalibrationExample example);

    int updateByExample(@Param("record") OaInstrumentCalibration record, @Param("example") OaInstrumentCalibrationExample example);

    int updateByPrimaryKeySelective(OaInstrumentCalibration record);

    int updateByPrimaryKey(OaInstrumentCalibration record);

    List<OaInstrumentCalibration> selectPage(OaInstrumentCalibrationExample example);
    
    int insertAndGetId(OaInstrumentCalibration record);
}