package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaAskForLeave;
import com.sliansoft.slianOA.dataaccess.model.OaAskForLeaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaAskForLeaveMapper {
    int countByExample(OaAskForLeaveExample example);

    int deleteByExample(OaAskForLeaveExample example);

    int deleteByPrimaryKey(Integer aflId);

    int insert(OaAskForLeave record);

    int insertSelective(OaAskForLeave record);

    List<OaAskForLeave> selectByExample(OaAskForLeaveExample example);

    OaAskForLeave selectByPrimaryKey(Integer aflId);

    int updateByExampleSelective(@Param("record") OaAskForLeave record, @Param("example") OaAskForLeaveExample example);

    int updateByExample(@Param("record") OaAskForLeave record, @Param("example") OaAskForLeaveExample example);

    int updateByPrimaryKeySelective(OaAskForLeave record);

    int updateByPrimaryKey(OaAskForLeave record);

    List<OaAskForLeave> selectPage(OaAskForLeaveExample example);

	List<OaAskForLeave> selectPage1(OaAskForLeaveExample example);
}