package com.slianOAsys.util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataAuthorityRegister {

	private Map<Long,AuthorityRegisterUnit> dataAuthorityMap;//<threadId,单元>
	
	//构造
	public DataAuthorityRegister(){
		dataAuthorityMap=new HashMap <Long,AuthorityRegisterUnit> ();
	}
	//添加一条授权
	public synchronized boolean addNewAuthority(Long threadId,Set<Integer> orgList,boolean underControl){
		try{
			Set<Long> threadIdSet=this.dataAuthorityMap.keySet();
			Date dateNow = new Date();
			AuthorityRegisterUnit authorityRegisterUnit=new AuthorityRegisterUnit(dateNow,orgList,underControl);
			//AuthorityRegisterUnit authorityRegisterUnit=new AuthorityRegisterUnit(dateNow,orgList,underControl,employeeList);
			//清除超时数据授权
			for(Long cthreadId:threadIdSet){
				if(dateNow.getTime()-this.dataAuthorityMap.get(cthreadId).getRegisterTime().getTime()>30000){
					//时长超过30秒
					this.dataAuthorityMap.remove(cthreadId);
				}
			}
			this.dataAuthorityMap.put(threadId, authorityRegisterUnit);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	//删除一条授权
	public synchronized boolean delAuthority(Long threadId){
		try{
			this.dataAuthorityMap.remove(threadId);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public synchronized Set<Integer> getOrgList(Long thId){
		return this.dataAuthorityMap.get(thId).getOrgSet();
	}
	public synchronized Set<Integer> getEmlpoyee(Long thId){
		return this.dataAuthorityMap.get(thId).getEmployeeSet();
	}
	
	public synchronized boolean isDataUnderControl(Long thId){
		return this.dataAuthorityMap.get(thId).isDataUnderControl();
	}
	
	public synchronized void show(){
		for(Long thId:dataAuthorityMap.keySet()){
			System.out.println("thread:"+thId);
			AuthorityRegisterUnit ARU=dataAuthorityMap.get(thId);
			System.out.println("    time:"+ARU.getRegisterTime().toString());
			if(ARU.isDataUnderControl()){
				for (Integer org:ARU.getOrgSet()){
					System.out.println("        org:"+org);
				}
			}
		}
	}
	
}

class AuthorityRegisterUnit{
	private Set<Integer> orgSet;
	private Set<Integer> employeeSet;
	private Date registerTime;
	private boolean dataUnderControl;
	
	

	AuthorityRegisterUnit(Date date,Set<Integer> set,boolean underControl,Set<Integer> eSet){
		registerTime=date;
		orgSet=set;
		dataUnderControl=underControl;
		employeeSet=eSet;
	}
	AuthorityRegisterUnit(Date date,Set<Integer> set,boolean underControl){
		registerTime=date;
		orgSet=set;
		dataUnderControl=underControl;
		employeeSet=null;
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
	
}
