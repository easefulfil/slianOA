package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.OaSuit;
import com.sliansoft.slianOA.dataaccess.model.OaSuitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaSuitMapper {
    int countByExample(OaSuitExample example);

    int deleteByExample(OaSuitExample example);

    int deleteByPrimaryKey(Integer suitId);

    int insert(OaSuit record);

    int insertSelective(OaSuit record);

    List<OaSuit> selectByExample(OaSuitExample example);

    OaSuit selectByPrimaryKey(Integer suitId);

    int updateByExampleSelective(@Param("record") OaSuit record, @Param("example") OaSuitExample example);

    int updateByExample(@Param("record") OaSuit record, @Param("example") OaSuitExample example);

    int updateByPrimaryKeySelective(OaSuit record);

    int updateByPrimaryKey(OaSuit record);

    List<OaSuit> selectPage(OaSuitExample example);
}