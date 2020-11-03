package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaPettyMoney;
import com.sliansoft.slianOA.dataaccess.model.OaPettyMoneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaPettyMoneyMapper {
    int countByExample(OaPettyMoneyExample example);

    int deleteByExample(OaPettyMoneyExample example);

    int deleteByPrimaryKey(Integer pettyMoneyId);

    int insert(OaPettyMoney record);

    int insertSelective(OaPettyMoney record);

    List<OaPettyMoney> selectByExample(OaPettyMoneyExample example);

    OaPettyMoney selectByPrimaryKey(Integer pettyMoneyId);

    int updateByExampleSelective(@Param("record") OaPettyMoney record, @Param("example") OaPettyMoneyExample example);

    int updateByExample(@Param("record") OaPettyMoney record, @Param("example") OaPettyMoneyExample example);

    int updateByPrimaryKeySelective(OaPettyMoney record);

    int updateByPrimaryKey(OaPettyMoney record);

    List<OaPettyMoney> selectPage(OaPettyMoneyExample example);
}