package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaVehicleMaintain;
import com.sliansoft.slianOA.dataaccess.model.OaVehicleMaintainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaVehicleMaintainMapper {
    int countByExample(OaVehicleMaintainExample example);

    int deleteByExample(OaVehicleMaintainExample example);

    int deleteByPrimaryKey(Integer vehicleMaintainId);

    int insert(OaVehicleMaintain record);

    int insertSelective(OaVehicleMaintain record);

    List<OaVehicleMaintain> selectByExample(OaVehicleMaintainExample example);

    OaVehicleMaintain selectByPrimaryKey(Integer vehicleMaintainId);

    int updateByExampleSelective(@Param("record") OaVehicleMaintain record, @Param("example") OaVehicleMaintainExample example);

    int updateByExample(@Param("record") OaVehicleMaintain record, @Param("example") OaVehicleMaintainExample example);

    int updateByPrimaryKeySelective(OaVehicleMaintain record);

    int updateByPrimaryKey(OaVehicleMaintain record);

    List<OaVehicleMaintain> selectPage(OaVehicleMaintainExample example);
    
    int insertAndGetId(OaVehicleMaintain record);
}