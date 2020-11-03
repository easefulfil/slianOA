package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.SystemSetting;
import com.sliansoft.slianOA.dataaccess.model.SystemSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemSettingMapper {
    int countByExample(SystemSettingExample example);

    int deleteByExample(SystemSettingExample example);

    int deleteByPrimaryKey(String stKey);

    int insert(SystemSetting record);

    int insertSelective(SystemSetting record);

    List<SystemSetting> selectByExample(SystemSettingExample example);

    SystemSetting selectByPrimaryKey(String stKey);

    int updateByExampleSelective(@Param("record") SystemSetting record, @Param("example") SystemSettingExample example);

    int updateByExample(@Param("record") SystemSetting record, @Param("example") SystemSettingExample example);

    int updateByPrimaryKeySelective(SystemSetting record);

    int updateByPrimaryKey(SystemSetting record);

    List<SystemSetting> selectPage(SystemSettingExample example);
}