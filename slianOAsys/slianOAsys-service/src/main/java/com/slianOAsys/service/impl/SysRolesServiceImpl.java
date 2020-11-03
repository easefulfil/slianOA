package com.slianOAsys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slianOAsys.dao.SysRolesMapper;
import com.slianOAsys.model.SysRoles;
import com.slianOAsys.model.SysRolesExample;
import com.slianOAsys.page.Page;
import com.slianOAsys.service.SysRolesResourcesService;
import com.slianOAsys.service.SysRolesService;
import com.slianOAsys.service.SysUsersRolesService;
import com.slianOAsys.service.utils.CommonUtils;

@Service
public class SysRolesServiceImpl implements SysRolesService {
	
	
	@Autowired
	private SysRolesMapper rolesMapper;	
	
	@Autowired
	private SysUsersRolesService usersRolesService;
	
	@Autowired
	private SysRolesResourcesService rolesResourcesService;
	
	public List<SysRoles> getRoles(String text) {
		
		SysRolesExample example=new SysRolesExample();
		
		if (!StringUtils.isEmpty(text)) {
			example.or().andNameLike("%"+text+"%");
		}

		

		return rolesMapper.selectByExample(example);
	}
	
	public Map<String,Object> getRoles(Integer pageSize,Integer pageIndex,SysRoles role) {
		
		SysRolesExample example=new SysRolesExample();
		
		if (!StringUtils.isEmpty(role.getName())) {
			example.or().andNameLike("%" +role.getName() + "%");
		}
		
		int total=rolesMapper.countByExample(example);
		/**
		 * for my sql db
		 */
			Page page = new Page();
			
			page.setBegin((pageIndex-1)*pageSize);
			page.setLength(pageSize);
			
			example.setPage(page);
			
			List<SysRoles> roles = rolesMapper.selectByExample(example);

			
		/**
		 * for  sql server db
		 */
			
//		example.setPageIndex(pageIndex);
//		example.setPageSize(pageSize);
//		example.setOrderByClause(" id desc");
//		List<SysRoles> roles=rolesMapper.selectPage(example);

		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("total", total);
		map.put("rows", roles);
		
		return map;
	}
	
public List<SysRoles> getRoles() {
		
		return rolesMapper.selectByExample(null);
	}
	
//需要修改       资源-角色表	、角色表
//	@Transactional
	public boolean insert(SysRoles role) {
		
//		insertRole(rol);
		return rolesMapper.insertSelective(role) == 1?true:false;
	}
	
	@Transactional
	public boolean deleteRoles(String rolesIds){
		
		//判断删除的role是否已被赋予用户
		if(usersRolesService.isExistUsers(CommonUtils.idsArrayToList(rolesIds)))
			return false;
		
		
		SysRolesExample example=new SysRolesExample();
		
//		example.or().andIdIn(CommonUtils.idsArrayToList(rolesIds));
		
		for(Integer id :CommonUtils.idsArrayToList(rolesIds)){
			
			if(!this.delete(id))
				return false;
			
		}
		
		return true;
		
	}
	

	public boolean delete(Integer roleId){
		//todo 判断该角色是否已分配给用户
		
		if(usersRolesService.isExistUsers(roleId))
			return false;
		
		//删除角色已分配的资源信息 roles_resources表中的记录
		rolesResourcesService.delete(roleId);

		return rolesMapper.deleteByPrimaryKey(roleId) ==1?true:false;
		
	}

	//更新角色信息	
	public boolean update(SysRoles rol) {
		
		return rolesMapper.updateByPrimaryKey(rol) ==1?true:false;
		
	}


	



}
