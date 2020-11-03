package com.sliansoft.slianOA.dataaccess.dao;

import com.sliansoft.slianOA.dataaccess.model.SysAuthentication;
import com.sliansoft.slianOA.dataaccess.model.SysAuthenticationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAuthenticationMapper {
    int countByExample(SysAuthenticationExample example);

    int deleteByExample(SysAuthenticationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysAuthentication record);

    int insertSelective(SysAuthentication record);

    List<SysAuthentication> selectByExample(SysAuthenticationExample example);

    SysAuthentication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysAuthentication record, @Param("example") SysAuthenticationExample example);

    int updateByExample(@Param("record") SysAuthentication record, @Param("example") SysAuthenticationExample example);

    int updateByPrimaryKeySelective(SysAuthentication record);

    int updateByPrimaryKey(SysAuthentication record);

    List<SysAuthentication> selectPage(SysAuthenticationExample example);
}