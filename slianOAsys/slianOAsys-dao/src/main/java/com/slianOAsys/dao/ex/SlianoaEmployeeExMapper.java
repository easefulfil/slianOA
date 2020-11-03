package com.slianOAsys.dao.ex;

import java.util.List;

import com.slianOAsys.model.SlianoaEmployee;
import com.slianOAsys.model.ex.EmployeeEx;
import com.slianOAsys.model.ex.EmployeeExExample;

public interface SlianoaEmployeeExMapper {
	 List<EmployeeEx> selectByExample(EmployeeExExample example);
	 
	 List<EmployeeEx> selectALL(EmployeeExExample example);
	 
	 int countByExample(EmployeeExExample example);
	 
	 List<EmployeeEx> getEmployeeIdByDepartId(Integer departid);
}
