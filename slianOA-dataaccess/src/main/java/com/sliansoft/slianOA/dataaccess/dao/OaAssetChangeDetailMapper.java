package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaAssetChangeDetail;
import com.sliansoft.slianOA.dataaccess.model.OaAssetChangeDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaAssetChangeDetailMapper {
    int countByExample(OaAssetChangeDetailExample example);

    int deleteByExample(OaAssetChangeDetailExample example);

    int deleteByPrimaryKey(Integer assetChangeDetailId);

    int insert(OaAssetChangeDetail record);

    int insertSelective(OaAssetChangeDetail record);

    List<OaAssetChangeDetail> selectByExample(OaAssetChangeDetailExample example);

    OaAssetChangeDetail selectByPrimaryKey(Integer assetChangeDetailId);

    int updateByExampleSelective(@Param("record") OaAssetChangeDetail record, @Param("example") OaAssetChangeDetailExample example);

    int updateByExample(@Param("record") OaAssetChangeDetail record, @Param("example") OaAssetChangeDetailExample example);

    int updateByPrimaryKeySelective(OaAssetChangeDetail record);

    int updateByPrimaryKey(OaAssetChangeDetail record);

    List<OaAssetChangeDetail> selectPage(OaAssetChangeDetailExample example);
}