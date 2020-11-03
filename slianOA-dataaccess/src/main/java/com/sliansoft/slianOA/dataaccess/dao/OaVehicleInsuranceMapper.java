package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaVehicleInsurance;
import com.sliansoft.slianOA.dataaccess.model.OaVehicleInsuranceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaVehicleInsuranceMapper {
    int countByExample(OaVehicleInsuranceExample example);

    int deleteByExample(OaVehicleInsuranceExample example);

    int deleteByPrimaryKey(Integer insuranceId);

    int insert(OaVehicleInsurance record);

    int insertSelective(OaVehicleInsurance record);

    List<OaVehicleInsurance> selectByExample(OaVehicleInsuranceExample example);

    OaVehicleInsurance selectByPrimaryKey(Integer insuranceId);

    int updateByExampleSelective(@Param("record") OaVehicleInsurance record, @Param("example") OaVehicleInsuranceExample example);

    int updateByExample(@Param("record") OaVehicleInsurance record, @Param("example") OaVehicleInsuranceExample example);

    int updateByPrimaryKeySelective(OaVehicleInsurance record);

    int updateByPrimaryKey(OaVehicleInsurance record);

    List<OaVehicleInsurance> selectPage(OaVehicleInsuranceExample example);
    
    List<OaVehicleInsurance> selectPageByGroup(OaVehicleInsuranceExample example);
    
    int countByExampleByGroup(OaVehicleInsuranceExample example);
}