package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaProjectCharge;
import com.sliansoft.slianOA.dataaccess.model.OaProjectChargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaProjectChargeMapper {
    int countByExample(OaProjectChargeExample example);

    int deleteByExample(OaProjectChargeExample example);

    int deleteByPrimaryKey(Integer projectChargeId);

    int insert(OaProjectCharge record);

    int insertSelective(OaProjectCharge record);

    List<OaProjectCharge> selectByExample(OaProjectChargeExample example);

    OaProjectCharge selectByPrimaryKey(Integer projectChargeId);

    int updateByExampleSelective(@Param("record") OaProjectCharge record, @Param("example") OaProjectChargeExample example);

    int updateByExample(@Param("record") OaProjectCharge record, @Param("example") OaProjectChargeExample example);

    int updateByPrimaryKeySelective(OaProjectCharge record);

    int updateByPrimaryKey(OaProjectCharge record);

    List<OaProjectCharge> selectPage(OaProjectChargeExample example);
}