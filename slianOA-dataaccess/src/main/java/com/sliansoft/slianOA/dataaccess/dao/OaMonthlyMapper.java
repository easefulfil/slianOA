package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaMonthly;
import com.sliansoft.slianOA.dataaccess.model.OaMonthlyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaMonthlyMapper {
    int countByExample(OaMonthlyExample example);

    int deleteByExample(OaMonthlyExample example);

    int deleteByPrimaryKey(Integer monthlyId);

    int insert(OaMonthly record);

    int insertSelective(OaMonthly record);

    List<OaMonthly> selectByExample(OaMonthlyExample example);

    OaMonthly selectByPrimaryKey(Integer monthlyId);

    int updateByExampleSelective(@Param("record") OaMonthly record, @Param("example") OaMonthlyExample example);

    int updateByExample(@Param("record") OaMonthly record, @Param("example") OaMonthlyExample example);

    int updateByPrimaryKeySelective(OaMonthly record);

    int updateByPrimaryKey(OaMonthly record);

    List<OaMonthly> selectPage(OaMonthlyExample example);
}