package com.slianOAsys.dao.ex;

import java.util.List;

import com.slianOAsys.model.ex.ClassEmployeeEx;

public interface SlianoaClassEmployeeExMapper {
	
	 List<ClassEmployeeEx> selectDepartnameByClass(Integer classid);
}
