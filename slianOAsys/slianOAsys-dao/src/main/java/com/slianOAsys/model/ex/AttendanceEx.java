package com.slianOAsys.model.ex;


import java.util.Date;

import com.slianOAsys.model.SlianoaAttendance;

public class AttendanceEx extends SlianoaAttendance{
	private String  employeeName; 
	private String  employeeWechat;
	private String  departName;
	private String className;
	private Date  startTime;
	private Date  endTime;
	private long  late;
	private long  before;
	private String  attendanceTotalStatusToString; 
	
	public String getAttendanceTotalStatusToString() {
		return attendanceTotalStatusToString;
	}
	public void setAttendanceTotalStatusToString(String attendanceTotalStatusToString) {
		this.attendanceTotalStatusToString = attendanceTotalStatusToString;
	}
	public long getLate() {
		return late;
	}
	public void setLate(long late) {
		this.late = late;
	}
	public long getBefore() {
		return before;
	}
	public void setBefore(long before) {
		this.before = before;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeWechat() {
		return employeeWechat;
	}
	public void setEmployeeWechat(String employeeWechat) {
		this.employeeWechat = employeeWechat;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
