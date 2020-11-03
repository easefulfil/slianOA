package com.sliansoft.slianOA.security;
/**
 * 
 * @author M
 *1
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sliansoft.slianOA.dataaccess.dao.SysResourceMapper;
import com.sliansoft.slianOA.dataaccess.dao.SysRoleMapper;
import com.sliansoft.slianOA.dataaccess.dao.SysRoleResourceMapper;
import com.sliansoft.slianOA.dataaccess.dao.SysUserMapper;
import com.sliansoft.slianOA.dataaccess.dao.SysUserRoleMapper;
import com.sliansoft.slianOA.dataaccess.model.SysUser;
import com.sliansoft.slianOA.dataaccess.model.SysUserExample;
import com.sliansoft.slianOA.dataaccess.model.SysUserRole;
import com.sliansoft.slianOA.dataaccess.model.SysUserRoleExample;

public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private SysUserMapper sysUserMapper;
//	@Autowired
//	private RolesMapper rolesMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
//	@Autowired
//	private RolesResourcesMapper rolesResourcesMapper;
//	@Autowired
//	private ResourcesMapper resourcesMapper;


//  获取用户角色信息
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		SysUser user = sysUserMapper.selectByPrimaryKey(Integer.parseInt(username));

		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);

//		User userdetail = new User(users.get(0).getUsername(), users.get(0).getPassword(), true, true, true, true, grantedAuths);
		User userdetail = new User(user.getId().toString(), "123456", true, true, true, true, grantedAuths);
		return userdetail;
	}


	private Set<GrantedAuthority> obtionGrantedAuthorities(SysUser user) {
		Set<GrantedAuthority> authSet=new HashSet<GrantedAuthority>();
		SysUserRoleExample  example=new SysUserRoleExample();
		example.or().andUidEqualTo(user.getId()).andStatusIsNull();
		List <SysUserRole> listUsersRoles = sysUserRoleMapper.selectByExample(example);
		for(SysUserRole userRole:listUsersRoles){
			authSet.add(new SimpleGrantedAuthority(userRole.getRid().toString()));
		}
		authSet.add(new SimpleGrantedAuthority("-1"));
		return authSet;	
        }
}
