package com.slianOAsys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.slianOAsys.dao.SysUsersRolesMapper;
import com.slianOAsys.model.SysRoles;
import com.slianOAsys.model.SysUsersRoles;
import com.slianOAsys.model.SysUsersRolesExample;
import com.slianOAsys.model.SysUsersRolesExample.Criteria;
import com.slianOAsys.model.ex.RolesEx;
import com.slianOAsys.service.SysRolesService;
import com.slianOAsys.service.SysUsersRolesService;
import com.slianOAsys.service.utils.CommonUtils;

public class SysUsersRolesServiceImpl implements SysUsersRolesService {

	@Autowired
	private SysUsersRolesMapper usersRolesMapper;

	@Autowired
	private SysRolesService rolesService;

	public SysUsersRolesServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isExistRoleUser(Integer userId, Integer roleId) {
		// TODO Auto-generated method stub

		SysUsersRolesExample example = new SysUsersRolesExample();

		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andRoleIdEqualTo(roleId);

		List<SysUsersRoles> list = usersRolesMapper.selectByExample(example);

		if (list == null || list.size() < 1)
			return false;

		return true;
	}

	@Override
	public boolean isExistUsers(List<Integer> rolesIds) {
		// TODO Auto-generated method stub

		SysUsersRolesExample example = new SysUsersRolesExample();

		example.or().andRoleIdIn(rolesIds);

		List<SysUsersRoles> list = usersRolesMapper.selectByExample(example);

		if (list == null || list.size() < 1)
			return false;

		return true;
	}

	@Override
	public boolean insert(SysUsersRoles usersRoles) {

		// TODO Auto-generated method stub
		return usersRolesMapper.insertSelective(usersRoles) == 1 ? true : false;
	}

	@Override
	public boolean delete(String ids) {

		// TODO Auto-generated method stub
		SysUsersRolesExample example = new SysUsersRolesExample();

		example.or().andUrIdIn(CommonUtils.idsArrayToList(ids));
		
		try{
			
			usersRolesMapper.deleteByExample(example) ;
			
			
		}catch(Exception e){
			e.printStackTrace();
			
			return false;
			
		}
		

		return true;
	}

	@Override
	public boolean updata(SysUsersRoles usersRoles) {
		// TODO Auto-generated method stub
		return usersRolesMapper.updateByPrimaryKey(usersRoles) == 1 ? true
				: false;
	}

	@Override
	public String getRoleNames(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolesEx> getUserHttpRoles(String userId) {
		// TODO Auto-generated method stub
		if (userId == null || "".equals(userId))
			return null;

		Map<Integer, Boolean> checkedRoles = this.setCheckedRoles(this
				.getUserRoles(Integer.parseInt(userId)));

		List<SysRoles> roles = rolesService.getRoles(""); 

		List<RolesEx> httpRoles = new ArrayList<RolesEx>();
		for (SysRoles role : roles) {
			RolesEx httpRole = new RolesEx();

//			ReflectionUtils.parentToChild(role, httpRole);


			BeanUtils.copyProperties(role, httpRole);
			if (checkedRoles.containsKey(role.getRoleId()))
				httpRole.setChecked(true);
			else
				httpRole.setChecked(false);
			httpRoles.add(httpRole);
		}

		return httpRoles;
	}

	private Map<Integer, Boolean> setCheckedRoles(List<SysUsersRoles> usersRoles) {

		Map<Integer, Boolean> checkedRoles = new HashMap<Integer, Boolean>();

		for (SysUsersRoles userRole : usersRoles) {

			checkedRoles.put(userRole.getRoleId(), true);

		}

		return checkedRoles;
	}

	@Override
	public List<SysUsersRoles> getUserRoles(Integer userId) {

		// TODO Auto-generated method stub
		SysUsersRolesExample example = new SysUsersRolesExample();

		example.or().andUserIdEqualTo(userId);

		return usersRolesMapper.selectByExample(example);

	}

	@Override
	public boolean insert(String userId, String roleId) {
		// TODO Auto-generated method stub

		if (userId == null || "".equals(userId) || roleId == null
				|| "".equals(roleId))
			return false;

		// 如果存在已分配的角色不再分配
		if (this.isExistRoleUser(Integer.parseInt(userId),
				Integer.parseInt(roleId)))
			return true;

		SysUsersRoles ur = new SysUsersRoles();

		ur.setUserId(Integer.parseInt(userId));
		ur.setRoleId(Integer.parseInt(roleId));

		return this.insert(ur);
	}

	@Override
	public boolean delete(String userId, String roleId) {
		// TODO Auto-generated method stub
		if (userId == null || "".equals(userId))
			return false;

		SysUsersRolesExample example = new SysUsersRolesExample();

		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(Integer.parseInt(userId));
		
		if( roleId == null || "".equals(roleId))
		;
		else
			criteria.andRoleIdEqualTo(Integer.parseInt(roleId));
		
		try{
			usersRolesMapper.deleteByExample(example);
		}catch(Exception e){
			e.printStackTrace();
			return false;
			
		}

		return true;
	}

	@Override
	public boolean isExistUsers(Integer roleId) {
		// TODO Auto-generated method stub
		SysUsersRolesExample example = new SysUsersRolesExample();

		example.or().andRoleIdEqualTo(roleId);

		List<SysUsersRoles> list = usersRolesMapper.selectByExample(example);

		if (list == null || list.size() < 1)
			return false;
		
		return true;

	}
}
