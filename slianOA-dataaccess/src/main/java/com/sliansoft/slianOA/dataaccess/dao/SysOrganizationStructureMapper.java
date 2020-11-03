package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.SysOrganizationStructure;
import com.sliansoft.slianOA.dataaccess.model.SysOrganizationStructureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOrganizationStructureMapper {
    int countByExample(SysOrganizationStructureExample example);

    int deleteByExample(SysOrganizationStructureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysOrganizationStructure record);

    int insertSelective(SysOrganizationStructure record);

    List<SysOrganizationStructure> selectByExample(SysOrganizationStructureExample example);

    SysOrganizationStructure selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysOrganizationStructure record, @Param("example") SysOrganizationStructureExample example);

    int updateByExample(@Param("record") SysOrganizationStructure record, @Param("example") SysOrganizationStructureExample example);

    int updateByPrimaryKeySelective(SysOrganizationStructure record);

    int updateByPrimaryKey(SysOrganizationStructure record);

    List<SysOrganizationStructure> selectPage(SysOrganizationStructureExample example);
}