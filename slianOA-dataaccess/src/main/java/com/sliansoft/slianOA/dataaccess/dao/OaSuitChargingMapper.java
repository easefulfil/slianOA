package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaSuitCharging;
import com.sliansoft.slianOA.dataaccess.model.OaSuitChargingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaSuitChargingMapper {
    int countByExample(OaSuitChargingExample example);

    int deleteByExample(OaSuitChargingExample example);

    int deleteByPrimaryKey(Integer suitChargingId);

    int insert(OaSuitCharging record);

    int insertSelective(OaSuitCharging record);

    List<OaSuitCharging> selectByExample(OaSuitChargingExample example);

    OaSuitCharging selectByPrimaryKey(Integer suitChargingId);

    int updateByExampleSelective(@Param("record") OaSuitCharging record, @Param("example") OaSuitChargingExample example);

    int updateByExample(@Param("record") OaSuitCharging record, @Param("example") OaSuitChargingExample example);

    int updateByPrimaryKeySelective(OaSuitCharging record);

    int updateByPrimaryKey(OaSuitCharging record);

    List<OaSuitCharging> selectPage(OaSuitChargingExample example);
}