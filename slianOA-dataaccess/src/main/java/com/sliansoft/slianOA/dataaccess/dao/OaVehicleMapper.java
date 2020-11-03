package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaVehicle;
import com.sliansoft.slianOA.dataaccess.model.OaVehicleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaVehicleMapper {
    int countByExample(OaVehicleExample example);

    int deleteByExample(OaVehicleExample example);

    int deleteByPrimaryKey(Integer vehicleId);

    int insert(OaVehicle record);

    int insertSelective(OaVehicle record);

    List<OaVehicle> selectByExample(OaVehicleExample example);

    OaVehicle selectByPrimaryKey(Integer vehicleId);

    int updateByExampleSelective(@Param("record") OaVehicle record, @Param("example") OaVehicleExample example);

    int updateByExample(@Param("record") OaVehicle record, @Param("example") OaVehicleExample example);

    int updateByPrimaryKeySelective(OaVehicle record);

    int updateByPrimaryKey(OaVehicle record);

    List<OaVehicle> selectPage(OaVehicleExample example);
}