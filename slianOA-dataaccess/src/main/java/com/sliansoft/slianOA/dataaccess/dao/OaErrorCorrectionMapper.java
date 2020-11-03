package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaErrorCorrection;
import com.sliansoft.slianOA.dataaccess.model.OaErrorCorrectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaErrorCorrectionMapper {
    int countByExample(OaErrorCorrectionExample example);

    int deleteByExample(OaErrorCorrectionExample example);

    int deleteByPrimaryKey(Integer errorCorrectionId);

    int insert(OaErrorCorrection record);

    int insertSelective(OaErrorCorrection record);

    List<OaErrorCorrection> selectByExample(OaErrorCorrectionExample example);

    OaErrorCorrection selectByPrimaryKey(Integer errorCorrectionId);

    int updateByExampleSelective(@Param("record") OaErrorCorrection record, @Param("example") OaErrorCorrectionExample example);

    int updateByExample(@Param("record") OaErrorCorrection record, @Param("example") OaErrorCorrectionExample example);

    int updateByPrimaryKeySelective(OaErrorCorrection record);

    int updateByPrimaryKey(OaErrorCorrection record);

    List<OaErrorCorrection> selectPage(OaErrorCorrectionExample example);
    
    int insertAndGetId(OaErrorCorrection record);
}