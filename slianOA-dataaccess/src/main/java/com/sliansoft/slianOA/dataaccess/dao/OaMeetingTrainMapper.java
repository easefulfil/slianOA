package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaMeetingTrain;
import com.sliansoft.slianOA.dataaccess.model.OaMeetingTrainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaMeetingTrainMapper {
    int countByExample(OaMeetingTrainExample example);

    int deleteByExample(OaMeetingTrainExample example);

    int deleteByPrimaryKey(Integer meetingTrainId);

    int insert(OaMeetingTrain record);

    int insertSelective(OaMeetingTrain record);

    List<OaMeetingTrain> selectByExampleWithBLOBs(OaMeetingTrainExample example);

    List<OaMeetingTrain> selectByExample(OaMeetingTrainExample example);

    OaMeetingTrain selectByPrimaryKey(Integer meetingTrainId);

    int updateByExampleSelective(@Param("record") OaMeetingTrain record, @Param("example") OaMeetingTrainExample example);

    int updateByExampleWithBLOBs(@Param("record") OaMeetingTrain record, @Param("example") OaMeetingTrainExample example);

    int updateByExample(@Param("record") OaMeetingTrain record, @Param("example") OaMeetingTrainExample example);

    int updateByPrimaryKeySelective(OaMeetingTrain record);

    int updateByPrimaryKeyWithBLOBs(OaMeetingTrain record);

    int updateByPrimaryKey(OaMeetingTrain record);

    List<OaMeetingTrain> selectPage(OaMeetingTrainExample example);
}