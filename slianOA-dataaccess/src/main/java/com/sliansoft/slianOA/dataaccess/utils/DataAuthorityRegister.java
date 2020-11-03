package com.sliansoft.slianOA.dataaccess.utils;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

public class DataAuthorityRegister {

	@Autowired
	protected HttpSession session;
	private Map<Long, AuthorityRegisterUnit> dataAuthorityMap;// <threadId,单元>

	// 构造
	public DataAuthorityRegister() {
		dataAuthorityMap = new HashMap<Long, AuthorityRegisterUnit>();
	}

	// 添加一条授权
	public synchronized boolean addNewAuthority(Long threadId,
			Set<Integer> orgList, boolean underControl) {
		try {
			Set<Long> threadIdSet = this.dataAuthorityMap.keySet();
			Date dateNow = new Date();
			AuthorityRegisterUnit authorityRegisterUnit = new AuthorityRegisterUnit(
					dateNow, orgList, underControl);
			// AuthorityRegisterUnit authorityRegisterUnit=new
			// AuthorityRegisterUnit(dateNow,orgList,underControl,employeeList);
			// 清除超时数据授权
			for (Long cthreadId : threadIdSet) {
				if (dateNow.getTime()
						- this.dataAuthorityMap.get(cthreadId)
								.getRegisterTime().getTime() > 30000) {
					// 时长超过30秒
					this.dataAuthorityMap.remove(cthreadId);
				}
			}
			this.dataAuthorityMap.put(threadId, authorityRegisterUnit);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// 添加一条授权   create by cxl 2016年5月4日
	public synchronized boolean addNewAuthority(Long threadId,
			Set<Integer> orgList, boolean underControl,Integer currentSessionEmployeeId) {
		try {
			Set<Long> threadIdSet = this.dataAuthorityMap.keySet();
			Date dateNow = new Date();
			AuthorityRegisterUnit authorityRegisterUnit = new AuthorityRegisterUnit(
					dateNow, orgList, underControl);
			// AuthorityRegisterUnit authorityRegisterUnit=new
			// AuthorityRegisterUnit(dateNow,orgList,underControl,employeeList);
			// 清除超时数据授权
			for (Long cthreadId : threadIdSet) {
				if (dateNow.getTime()
						- this.dataAuthorityMap.get(cthreadId)
								.getRegisterTime().getTime() > 30000) {
					// 时长超过30秒
					this.dataAuthorityMap.remove(cthreadId);
				}
			}
			
			authorityRegisterUnit.setCurrentSessionEmployeeId(currentSessionEmployeeId);
	
			this.dataAuthorityMap.put(threadId, authorityRegisterUnit);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// 删除一条授权
	public synchronized boolean delAuthority(Long threadId) {
		try {
			this.dataAuthorityMap.remove(threadId);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public synchronized Set<Integer> getOrgList(Long thId) {
		return this.dataAuthorityMap.get(thId).getOrgSet();
	}
	
	public synchronized Integer getCurrentSessionEmployeeeId(Long thId) {
		return this.dataAuthorityMap.get(thId).getCurrentSessionEmployeeId();
	}

	public synchronized Set<Integer> getEmlpoyee(Long thId) {
		
		return this.dataAuthorityMap.get(thId).getEmployeeSet();
	}

	public synchronized boolean isDataUnderControl(Long thId) {
		boolean b = this.dataAuthorityMap.get(thId)==null;
		//System.out.println(session.getAttribute("uri")==null);
		return this.dataAuthorityMap.get(thId).isDataUnderControl();
	}
	public synchronized void show() {
		for (Long thId : dataAuthorityMap.keySet()) {
			AuthorityRegisterUnit ARU = dataAuthorityMap.get(thId);
			System.out.println("    time:" + ARU.getRegisterTime().toString());
			if (ARU.isDataUnderControl()) {
				for (Integer org : ARU.getOrgSet()) {
					System.out.println("        org:" + org);
				}
			}
		}
	}

}

class AuthorityRegisterUnit {
	private Set<Integer> orgSet;
	private Set<Integer> employeeSet;
	private Date registerTime;
	private boolean dataUnderControl;

	// 当前操作数据的员工ID，用做数据拥有（负责）人的判断
	private Integer currentSessionEmployeeId;


	AuthorityRegisterUnit(Date date, Set<Integer> set, boolean underControl,
			Set<Integer> eSet) {
		registerTime = date;
		orgSet = set;
		dataUnderControl = underControl;
		employeeSet = eSet;
	}

	AuthorityRegisterUnit(Date date, Set<Integer> set, boolean underControl) {
		registerTime = date;
		orgSet = set;
		dataUnderControl = underControl;
		employeeSet = null;
	}

	public boolean isDataUnderControl() {
		return dataUnderControl;
	}

	public Set<Integer> getOrgSet() {
		return orgSet;
	}

	public Set<Integer> getEmployeeSet() {
		return employeeSet;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public Integer getCurrentSessionEmployeeId() {
		return currentSessionEmployeeId;
	}

	public void setCurrentSessionEmployeeId(Integer currentSessionEmployeeId) {
		this.currentSessionEmployeeId = currentSessionEmployeeId;
	}


}
