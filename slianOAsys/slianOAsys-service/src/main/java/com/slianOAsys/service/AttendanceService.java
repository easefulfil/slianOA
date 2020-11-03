package com.slianOAsys.service;

import java.io.OutputStream;
import java.text.ParseException;
import java.util.Date;

import com.slianOAsys.model.SlianoaAttendance;

public interface AttendanceService {
	Object getAttendance(String employeename,String classname,String attendance_total_status,String startdate,String enddate,String departname,Integer pageSize, Integer pageIndex);
	
	Object getAttendanceDetail(String signstatus,String employeename,String classname,String attendance_total_status,String startdate,String enddate,String departname,Integer pageSize, Integer pageIndex);
	
	public void exportExcel(String employeename,String classname,String attendance_total_status,String startdate,String enddate,String departname, OutputStream os);
	
	public void detailExportExcel(String signstatus,String employeename,String classname,String attendance_total_status,String startdate,String enddate,String departname, OutputStream os);
	
	public Object getAttendanceMonth(String className,String startdate,String enddate,String employeeName,String departName,Integer pageSize, Integer pageIndex) throws ParseException;
	
	String update(SlianoaAttendance attendance);
	
	int delete1(int attendanceid);
}
