package com.sliansoft.slianOA.dataaccess.daoEx;

import java.util.List;

import com.sliansoft.slianOA.dataaccess.dao.SysEmployeeMapper;
import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.SysEmployeeExample;

public interface SysEmployeeMapperEx extends SysEmployeeMapper {

	List<SysEmployee> selectInit(SysEmployeeExample example);
	
	public List<SysEmployee> selectByExampleWithOutAuth(SysEmployeeExample example);

	int countByExample(SysEmployeeExample example);

	int insertAndGetId(SysEmployee record);

}
