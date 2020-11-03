package com.slianOAsys.service;

import java.util.List;

import java.util.Map;

import com.slianOAsys.model.SysRoles;

public interface SysRolesService {

	public List<SysRoles> getRoles(String text) ;
	
	public List<SysRoles> getRoles();
	public Map<String,Object> getRoles(Integer pageSize,Integer pageIndex,SysRoles role);

	public boolean insert(SysRoles res);

	public boolean delete(Integer rid);
	
	public boolean deleteRoles(String rolesIds);

//	public boolean ddelete(Roles res);
//
//	public boolean updateAuth(SysRoles roles);
//
	public boolean update(SysRoles roles);
}
