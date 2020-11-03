package com.slianOAsys.service;

import java.util.List;

public interface DepartmentService {
	Object getDepartment(Integer pageSize, Integer pageIndex);
	
	List<Integer> getEmployeeIdByDepartId(Integer departid);
}
