package com.slianOAsys.service;

/**
 * 用于获取登陆后，存储于session里面的变量
 */

import java.util.List;

import com.slianOAsys.model.ex.SysUsersEx;

public interface SessionService {

	
	public void invalidateSession();
	
	//当前session的 userDetailId（可能是：EmployeeId，customerId）
	public Integer getUserDetailId();
	
	//当前session中 用户数据的访问组
	public List<String> getDataAccessGroup();
	
	public SysUsersEx getSessionHttpUser();
	

}
