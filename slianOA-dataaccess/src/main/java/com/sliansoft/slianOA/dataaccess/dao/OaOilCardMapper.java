package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaOilCard;
import com.sliansoft.slianOA.dataaccess.model.OaOilCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaOilCardMapper {
    int countByExample(OaOilCardExample example);

    int deleteByExample(OaOilCardExample example);

    int deleteByPrimaryKey(Integer oilCardId);

    int insert(OaOilCard record);

    int insertSelective(OaOilCard record);

    List<OaOilCard> selectByExampleWithBLOBs(OaOilCardExample example);

    List<OaOilCard> selectByExample(OaOilCardExample example);

    OaOilCard selectByPrimaryKey(Integer oilCardId);

    int updateByExampleSelective(@Param("record") OaOilCard record, @Param("example") OaOilCardExample example);

    int updateByExampleWithBLOBs(@Param("record") OaOilCard record, @Param("example") OaOilCardExample example);

    int updateByExample(@Param("record") OaOilCard record, @Param("example") OaOilCardExample example);

    int updateByPrimaryKeySelective(OaOilCard record);

    int updateByPrimaryKeyWithBLOBs(OaOilCard record);

    int updateByPrimaryKey(OaOilCard record);

    List<OaOilCard> selectPage(OaOilCardExample example);
}