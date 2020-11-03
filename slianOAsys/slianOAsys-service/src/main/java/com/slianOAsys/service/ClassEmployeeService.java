package com.slianOAsys.service;

import java.util.List;

import com.slianOAsys.model.SlianoaClassEmployee;
import com.slianOAsys.model.ex.ClassEmployeeEx;

public interface ClassEmployeeService {
	int insert( SlianoaClassEmployee slianoaClassEmployee);
	
	List<ClassEmployeeEx> getEmployeeIdByDepartId(Integer classid);
}
