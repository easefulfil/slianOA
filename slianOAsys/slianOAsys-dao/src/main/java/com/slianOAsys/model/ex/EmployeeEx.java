package com.slianOAsys.model.ex;


import java.util.Date;
import java.util.List;

import com.slianOAsys.model.SlianoaEmployee;

public class EmployeeEx extends SlianoaEmployee{
	private String  departName; 
	private int totalday;
	private int workday;
	private int latecount;
	private int beforecount;
	private int latetime;
	private int beforetime;
	private float workHours;
	private float workHour;
	private int actualworkday;
	private String className;
	private Date startTime;
	private Date endTime;
	private float shouldworktime;
	private String  attendanceTime;
	private String  classStatus;
	private String  attendanceTotalStatus;
	private Date attendanceSigntime;
	private Date attendanceOfftime;
	private String  attendanceSignstatus;
	private String  attendanceOffstatus;
	
	private List<DateAndStatus> DateAndStatus;
	
	public Date getattendanceSigntime() {
		return attendanceSigntime;
	}
	public void setattendanceSigntime(Date attendanceSigntime) {
		this.attendanceSigntime = attendanceSigntime;
	}
	public Date getattendanceOfftime() {
		return attendanceOfftime;
	}
	public void setattendanceOfftime(Date attendanceOfftime) {
		this.attendanceOfftime = attendanceOfftime;
	}
	public String getattendanceSignstatus() {
		return attendanceSignstatus;
	}
	public void setattendanceSignstatus(String attendanceSignstatus) {
		this.attendanceSignstatus = attendanceSignstatus;
	}
	public String getattendanceOffstatus() {
		return attendanceOffstatus;
	}
	public void setattendanceOffstatus(String attendanceOffstatus) {
		this.attendanceOffstatus = attendanceOffstatus;
	}
	public String getattendanceTotalStatus() {
		return attendanceTotalStatus;
	}
	public void setattendanceTotalStatus(String attendanceTotalStatus) {
		this.attendanceTotalStatus = attendanceTotalStatus;
	}
	public List<DateAndStatus> getDateAndStatus() {
		return DateAndStatus;
	}
	public void setDateAndStatus(List<DateAndStatus> DateAndStatus) {
		this.DateAndStatus = DateAndStatus;
	}
	
	public String getattendanceTime() {
		return attendanceTime;
	}
	public void setattendanceTime(String attendanceTime) {
		this.attendanceTime = attendanceTime;
	}
	public String getClassStatus() {
		return classStatus;
	}
	public void setClassStatus(String classStatus) {
		this.classStatus = classStatus;
	}
	
	public int getlatetime() {
		return latetime;
	}
	public void setlatetime(int latetime) {
		this.latetime = latetime;
	}
	public int getbeforetime() {
		return beforetime;
	}
	public void setbeforetime(int beforetime) {
		this.beforetime = beforetime;
	}
	public int getlatecount() {
		return latecount;
	}
	public void setlatecount(int latecount) {
		this.latecount = latecount;
	}
	public int getbeforecount() {
		return beforecount;
	}
	public void setbeforecount(int beforecount) {
		this.beforecount = beforecount;
	}
	public float getshouldworktime() {
		return shouldworktime;
	}
	public void setshouldworktime(float shouldworktime) {
		this.shouldworktime = shouldworktime;
	}
	public Date getendTime() {
		return endTime;
	}
	public void setendTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getstartTime() {
		return startTime;
	}
	public void setclassName(Date startTime) {
		this.startTime = startTime;
	}
	public String getclassName() {
		return className;
	}
	public void setclassName(String className) {
		this.className = className;
	}
	public float getworkHours() {
		return workHours;
	}
	public void setworkHours(float workHours) {
		this.workHours = workHours;
	}
	public float getworkHour() {
		return workHour;
	}
	public void setworkHour(float workHour) {
		this.workHour = workHour;
	}
	public int getactualworkday() {
		return actualworkday;
	}
	public void setactualworkday(int actualworkday) {
		this.actualworkday = actualworkday;
	}
	public int gettotalday() {
		return totalday;
	}
	public void settotalday(int totalday) {
		this.totalday = totalday;
	}
	public int getworkday() {
		return workday;
	}
	public void setworkday(int workday) {
		this.workday = workday;
	}
	public String getdepartName() {
		return departName;
	}
	public void setdepartName(String departName) {
		this.departName = departName;
	}
}
