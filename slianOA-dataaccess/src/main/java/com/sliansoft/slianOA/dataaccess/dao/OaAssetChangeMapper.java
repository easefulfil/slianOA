package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaAssetChange;
import com.sliansoft.slianOA.dataaccess.model.OaAssetChangeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OaAssetChangeMapper {
    int countByExample(OaAssetChangeExample example);

    int deleteByExample(OaAssetChangeExample example);

    int deleteByPrimaryKey(Integer assetChangeId);

    int insert(OaAssetChange record);

    int insertSelective(OaAssetChange record);

    List<OaAssetChange> selectByExampleWithBLOBs(OaAssetChangeExample example);

    List<OaAssetChange> selectByExample(OaAssetChangeExample example);

    OaAssetChange selectByPrimaryKey(Integer assetChangeId);

    int updateByExampleSelective(@Param("record") OaAssetChange record, @Param("example") OaAssetChangeExample example);

    int updateByExampleWithBLOBs(@Param("record") OaAssetChange record, @Param("example") OaAssetChangeExample example);

    int updateByExample(@Param("record") OaAssetChange record, @Param("example") OaAssetChangeExample example);

    int updateByPrimaryKeySelective(OaAssetChange record);

    int updateByPrimaryKeyWithBLOBs(OaAssetChange record);

    int updateByPrimaryKey(OaAssetChange record);

    List<OaAssetChange> selectPage(OaAssetChangeExample example);
    
    int insertAndGetId(OaAssetChange record);
}