package com.slianOAsys.service;

import java.text.ParseException;

public interface EmployeeService {
	public Object getAttendanceMonth1(
			String className,String start,String end,
			String employeeName,String departName,
			Integer pageSize, Integer pageIndex)throws ParseException;
	
	public Object getAttendanceMonth(
			String className,String start,String end,
			String employeeName,String departName,
			Integer pageSize, Integer pageIndex)throws ParseException;
}
