package com.sliansoft.slianOA.dataaccess.daoEx;

import java.util.List;

import com.sliansoft.slianOA.dataaccess.dao.SysCustomerMapper;
import com.sliansoft.slianOA.dataaccess.model.SysCustomer;
import com.sliansoft.slianOA.dataaccess.model.SysCustomerExample;

public interface SysCustomerMapperEx extends SysCustomerMapper {
	
	List<SysCustomer> selectByExampleForInit(SysCustomerExample example);

	int countByExample(SysCustomerExample example);

	int insertSelective(SysCustomer record);

}
