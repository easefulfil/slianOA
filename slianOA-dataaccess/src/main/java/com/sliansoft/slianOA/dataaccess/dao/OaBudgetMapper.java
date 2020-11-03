package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaBudget;
import com.sliansoft.slianOA.dataaccess.model.OaBudgetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaBudgetMapper {
    int countByExample(OaBudgetExample example);

    int deleteByExample(OaBudgetExample example);

    int deleteByPrimaryKey(Integer budgetId);

    int insert(OaBudget record);

    int insertSelective(OaBudget record);

    List<OaBudget> selectByExample(OaBudgetExample example);

    OaBudget selectByPrimaryKey(Integer budgetId);

    int updateByExampleSelective(@Param("record") OaBudget record, @Param("example") OaBudgetExample example);

    int updateByExample(@Param("record") OaBudget record, @Param("example") OaBudgetExample example);

    int updateByPrimaryKeySelective(OaBudget record);

    int updateByPrimaryKey(OaBudget record);

    List<OaBudget> selectPage(OaBudgetExample example);
}