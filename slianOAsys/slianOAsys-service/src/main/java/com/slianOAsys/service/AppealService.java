package com.slianOAsys.service;

import java.io.OutputStream;

public interface AppealService {
	
	Object getAppeal(String employeename,String departname,String employeewechat,String appeal_status,String startdate,String enddate,Integer pageSize, Integer pageIndex);
	
	public void exportExcel(String employeename,String departname,String employeewechat,String appeal_status,String startdate,String enddate, OutputStream os);
	
	Object getEmployeeNameById(int employeeId);

}
