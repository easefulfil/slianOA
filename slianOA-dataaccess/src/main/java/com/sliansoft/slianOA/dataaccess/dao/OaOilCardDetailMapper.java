package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaOilCardDetail;
import com.sliansoft.slianOA.dataaccess.model.OaOilCardDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaOilCardDetailMapper {
    int countByExample(OaOilCardDetailExample example);

    int deleteByExample(OaOilCardDetailExample example);

    int deleteByPrimaryKey(Integer oilCardDetailId);

    int insert(OaOilCardDetail record);

    int insertSelective(OaOilCardDetail record);

    List<OaOilCardDetail> selectByExampleWithBLOBs(OaOilCardDetailExample example);

    List<OaOilCardDetail> selectByExample(OaOilCardDetailExample example);

    OaOilCardDetail selectByPrimaryKey(Integer oilCardDetailId);

    int updateByExampleSelective(@Param("record") OaOilCardDetail record, @Param("example") OaOilCardDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") OaOilCardDetail record, @Param("example") OaOilCardDetailExample example);

    int updateByExample(@Param("record") OaOilCardDetail record, @Param("example") OaOilCardDetailExample example);

    int updateByPrimaryKeySelective(OaOilCardDetail record);

    int updateByPrimaryKeyWithBLOBs(OaOilCardDetail record);

    int updateByPrimaryKey(OaOilCardDetail record);

    List<OaOilCardDetail> selectPage(OaOilCardDetailExample example);
    
    int insertAndGetId(OaOilCardDetail record);
}