package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaAsset;
import com.sliansoft.slianOA.dataaccess.model.OaAssetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaAssetMapper {
    int countByExample(OaAssetExample example);

    int deleteByExample(OaAssetExample example);

    int deleteByPrimaryKey(Integer assetId);

    int insert(OaAsset record);

    int insertSelective(OaAsset record);

    List<OaAsset> selectByExample(OaAssetExample example);

    OaAsset selectByPrimaryKey(Integer assetId);

    int updateByExampleSelective(@Param("record") OaAsset record, @Param("example") OaAssetExample example);

    int updateByExample(@Param("record") OaAsset record, @Param("example") OaAssetExample example);

    int updateByPrimaryKeySelective(OaAsset record);

    int updateByPrimaryKey(OaAsset record);

    List<OaAsset> selectPage(OaAssetExample example);
}