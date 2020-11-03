package com.slianOAsys.service.impl;

import com.slianOAsys.service.ClassEmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.slianOAsys.dao.SlianoaClassEmployeeMapper;
import com.slianOAsys.dao.ex.SlianoaClassEmployeeExMapper;
import com.slianOAsys.model.SlianoaClassEmployee;
import com.slianOAsys.model.ex.ClassEmployeeEx;

public class ClassEmployeeServiceImpl implements ClassEmployeeService{
	@Autowired
	SlianoaClassEmployeeMapper SlianoaClassEmployeeMapper;
	@Autowired
	SlianoaClassEmployeeExMapper SlianoaClassEmployeeExMapper;
	
	@Override
	public int insert(SlianoaClassEmployee slianoaClassEmployee) {
		
        SlianoaClassEmployeeMapper.insertSelective(slianoaClassEmployee);
		return 1;
	}

	@Override
	public List<ClassEmployeeEx> getEmployeeIdByDepartId(Integer classid) {
		
		return SlianoaClassEmployeeExMapper.selectDepartnameByClass(classid);
	}
	
}
