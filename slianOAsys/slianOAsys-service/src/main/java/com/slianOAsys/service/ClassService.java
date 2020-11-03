package com.slianOAsys.service;

import java.text.ParseException;
import java.util.Date;

import com.slianOAsys.model.SlianoaClass;

public interface ClassService {
	Object getClass(String classname,String createstarttime,String createendtime,String classstatus,Integer pageSize, Integer pageIndex) throws ParseException;
	
	String insert(SlianoaClass classes);
	
	String update(SlianoaClass classes);
	
	Object getClassById(int classid);
	
	int delete(int classid);
	
	int insertDeleteUnattendanceDays(int classid,String date);
	
	int insertAddUnattendanceDays(int classid,String date);
}
