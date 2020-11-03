package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.SysBasicDataSet;
import com.sliansoft.slianOA.dataaccess.model.SysBasicDataSetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysBasicDataSetMapper {
    int countByExample(SysBasicDataSetExample example);

    int deleteByExample(SysBasicDataSetExample example);

    int deleteByPrimaryKey(Integer basicDataId);

    int insert(SysBasicDataSet record);

    int insertSelective(SysBasicDataSet record);

    List<SysBasicDataSet> selectByExample(SysBasicDataSetExample example);

    SysBasicDataSet selectByPrimaryKey(Integer basicDataId);

    int updateByExampleSelective(@Param("record") SysBasicDataSet record, @Param("example") SysBasicDataSetExample example);

    int updateByExample(@Param("record") SysBasicDataSet record, @Param("example") SysBasicDataSetExample example);

    int updateByPrimaryKeySelective(SysBasicDataSet record);

    int updateByPrimaryKey(SysBasicDataSet record);

    List<SysBasicDataSet> selectPage(SysBasicDataSetExample example);
}