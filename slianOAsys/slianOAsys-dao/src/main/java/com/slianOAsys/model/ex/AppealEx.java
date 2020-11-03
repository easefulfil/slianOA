package com.slianOAsys.model.ex;

import com.slianOAsys.model.SlianoaAppeal;

public class AppealEx extends SlianoaAppeal{
	private String  employeeName; 
	private String  employeeWechat;
	private String  departName;
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
}