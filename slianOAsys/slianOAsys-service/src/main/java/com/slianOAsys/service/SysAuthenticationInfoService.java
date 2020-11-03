package com.slianOAsys.service;
/**
 * 
 */


import java.util.List;

import com.slianOAsys.model.SysAuthenticationInfo;

/**
 * @author Apple
 *
 */
public interface SysAuthenticationInfoService {
	
	public String updatePassword(String account,String password,String newPassword);
	
	public boolean isExistAccount(String account);
	
	public String resetPassword(String account);
	
	public List<SysAuthenticationInfo> getAuthenticationInfo(String account,String password,String type); 

	public List<SysAuthenticationInfo> getAuthenticationInfo(String account,String password); 
	
	public List<SysAuthenticationInfo> getAuthenticationInfo(String uId); 
	
	public boolean insert(SysAuthenticationInfo authInfo);
	
	public boolean delete(String ids);
	
	public boolean deleteByUserId(Integer uId);
	
	public boolean update(SysAuthenticationInfo authInfo);

}
