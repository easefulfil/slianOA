package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaVehicleUsedRecord;
import com.sliansoft.slianOA.dataaccess.model.OaVehicleUsedRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaVehicleUsedRecordMapper {
    int countByExample(OaVehicleUsedRecordExample example);

    int deleteByExample(OaVehicleUsedRecordExample example);

    int deleteByPrimaryKey(Integer vehicleUsedRecordId);

    int insert(OaVehicleUsedRecord record);

    int insertSelective(OaVehicleUsedRecord record);

    List<OaVehicleUsedRecord> selectByExample(OaVehicleUsedRecordExample example);

    OaVehicleUsedRecord selectByPrimaryKey(Integer vehicleUsedRecordId);

    int updateByExampleSelective(@Param("record") OaVehicleUsedRecord record, @Param("example") OaVehicleUsedRecordExample example);

    int updateByExample(@Param("record") OaVehicleUsedRecord record, @Param("example") OaVehicleUsedRecordExample example);

    int updateByPrimaryKeySelective(OaVehicleUsedRecord record);

    int updateByPrimaryKey(OaVehicleUsedRecord record);

    List<OaVehicleUsedRecord> selectPage(OaVehicleUsedRecordExample example);
    
    int insertAndGetId(OaVehicleUsedRecord record);
}