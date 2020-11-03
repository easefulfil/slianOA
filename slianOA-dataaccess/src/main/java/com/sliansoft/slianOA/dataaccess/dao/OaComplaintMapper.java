package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaComplaint;
import com.sliansoft.slianOA.dataaccess.model.OaComplaintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaComplaintMapper {
    int countByExample(OaComplaintExample example);

    int deleteByExample(OaComplaintExample example);

    int deleteByPrimaryKey(Integer complaintId);

    int insert(OaComplaint record);

    int insertSelective(OaComplaint record);

    List<OaComplaint> selectByExample(OaComplaintExample example);

    OaComplaint selectByPrimaryKey(Integer complaintId);

    int updateByExampleSelective(@Param("record") OaComplaint record, @Param("example") OaComplaintExample example);

    int updateByExample(@Param("record") OaComplaint record, @Param("example") OaComplaintExample example);

    int updateByPrimaryKeySelective(OaComplaint record);

    int updateByPrimaryKey(OaComplaint record);

    List<OaComplaint> selectPage(OaComplaintExample example);
}