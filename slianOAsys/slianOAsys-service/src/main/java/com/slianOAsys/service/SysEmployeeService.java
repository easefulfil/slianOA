/**
 * 
 */
package com.slianOAsys.service;

import java.io.OutputStream;

import java.util.List;
import java.util.Map;

import com.slianOAsys.model.SysEmployee;
import com.slianOAsys.model.ex.SysEmployeeEx;

/**
 * Copyright@宁波高新区敏智科技有限公司 www.mz3co.com
 * Copyright@浙江大学软件学院S309实验室
 *
 * @author chengxl
 * Cteated time：2014年12月31日 上午9:31:22   
 *
 */
public interface SysEmployeeService {
	
	public SysEmployee getByCustomerName(String employeeName);
	
	public SysEmployee getByCellPhone(String cellPhone);
	
	public Integer getByFromUserName(String fromusername);
	
	public void exportExcel(SysEmployeeEx employee,OutputStream  os);
	
	public List<SysEmployeeEx> getEmployees();
	
	public void init_EMPLOYEEMAP();
	
	public SysEmployee getEmployeeById(Integer employeeId);
	
	public Map<String,Object> getEmployeeByPage(SysEmployeeEx employee, Integer pageSize,
			Integer pageNow);
	 
	public String update(SysEmployee employee);
	 
	public String insert(SysEmployee employee);
	 
	public String deleteEmpById(String  ids[]);
	
	public List<Integer> getEmployeeIds(String employeeName);
	

}
