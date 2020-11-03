package com.slianOAsys.service;

import java.util.List;

import java.util.Map;

import com.slianOAsys.model.SysUsers;

public interface SysUsersService {

	
	public boolean deleteByUserDetailId(List<Integer> userDetailIds,List<String> types);
	
	public SysUsers getUsers(Integer userId);
	
	public Map<String,Object> getHttpUsers(Integer pageSize,Integer pageIndex,SysUsers user);
	
	public List<SysUsers> getUsers();
	
	public boolean isExistUsers(Integer roleId);
	
	public boolean insert(SysUsers user);
	
	public boolean delete(String ids);
	
	public boolean update(SysUsers user);

}
