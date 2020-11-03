package com.slianOAsys.model.ex;


import com.slianOAsys.model.SysUsers;

public class SysUsersEx extends SysUsers {
	
//	public String departmentId;
	
	public Integer counterMan;
	
	public String accessGroup;
	
	private String userDetailName;
	
	private String sCreateTime ;
	
	private String sLastLoginTime;
	
	private String roleNames;
	
	private String loginStatus;

	public String getsCreateTime() {
		return sCreateTime;
	}

	public void setsCreateTime(String sCreateTime) {
		this.sCreateTime = sCreateTime;
	}

	public String getsLastLoginTime() {
		return sLastLoginTime;
	}

	public void setsLastLoginTime(String sLastLoginTime) {
		this.sLastLoginTime = sLastLoginTime;
	}


	public String getUserDetailName() {
		return userDetailName;
	}

	public void setUserDetailName(String userDetailName) {
		this.userDetailName = userDetailName;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}
	
	public String getAccessGroup() {
		return accessGroup;
	}

	public void setAccessGroup(String accessGroup) {
		this.accessGroup = accessGroup;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public Integer getCounterMan() {
		return counterMan;
	}

	public void setCounterMan(Integer counterMan) {
		this.counterMan = counterMan;
	}



	
	

}
