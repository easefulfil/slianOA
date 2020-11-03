/**
 * ����Ϊ��Ȩ���ҳ�棬������Ȩ�ɹ��󣬷�װ�����ص�ǰ�˵����
 */

package com.slianOAsys.sysadmin.security.utils;

import com.slianOAsys.model.SysEmployee;
import com.slianOAsys.model.SysUsers;

import net.sf.json.JSONObject;

public class AuthencationResult {
	
	private String loginingAccount;
	
	private JSONObject menuJSON;
	
	private boolean status;
	
	private String msg;
	
	private SysUsers user;
	
	private SysEmployee employee;
	
//	private SysCustomer customer;

	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public SysEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(SysEmployee employee) {
		this.employee = employee;
	}

//	public SysCustomer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(SysCustomer customer) {
//		this.customer = customer;
//	}

	public SysUsers getUser() {
		return user;
	}

	public void setUser(SysUsers user) {
		this.user = user;
	}

	public String getLoginingAccount() {
		return loginingAccount;
	}

	public void setLoginingAccount(String loginingAccount) {
		this.loginingAccount = loginingAccount;
	}

	public JSONObject getMenuJSON() {
		return menuJSON;
	}

	public void setMenuJSON(JSONObject menuJSON) {
		this.menuJSON = menuJSON;
	}

	
}
