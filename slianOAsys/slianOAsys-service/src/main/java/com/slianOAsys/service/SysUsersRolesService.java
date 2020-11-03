package com.slianOAsys.service;

import java.util.List;

import com.slianOAsys.model.SysUsersRoles;
import com.slianOAsys.model.ex.RolesEx;

public interface SysUsersRolesService {
	
	
	
	public List<SysUsersRoles> getUserRoles(Integer userId);
	
	public List<RolesEx> getUserHttpRoles(String userId);
	
	public boolean insert(String userId,String roleId);
	
	public boolean delete(String userId,String roleId);
	
	/**
	 * 返回指定userId已分配的角色名称
	 * @param userId
	 * @return
	 */
	public String getRoleNames(Integer userId);

	public boolean isExistRoleUser(Integer userId,Integer roleId);
	
	public boolean isExistUsers(Integer roleId);

	public boolean isExistUsers(List<Integer> rolesIds);

	public boolean insert(SysUsersRoles usersRoles);

	public boolean delete(String ids);

	public boolean updata(SysUsersRoles usersRoles);
}
