package com.slianOAsys.sysadmin.security;


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

import com.slianOAsys.model.SysUsers;
import com.slianOAsys.model.SysUsersRoles;
import com.slianOAsys.service.SysUsersRolesService;
import com.slianOAsys.service.SysUsersService;
//在这个类中，你就可以从数据库中读入用户的密码，角色信息，是否锁定，账号是否过期等
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private SysUsersService usersService;

	@Autowired
	private SysUsersRolesService usersRolesService;


//  获取用户角色信息
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

//		Users user = usersMapper.selectByPrimaryKey(Integer.parseInt(username));
		
		SysUsers user = usersService.getUsers(Integer.parseInt(username));

		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);

//		User userdetail = new User(users.get(0).getUsername(), users.get(0).getPassword(), true, true, true, true, grantedAuths);
		User userdetail = new User(user.getUserId().toString(), "123456", true, true, true, true, grantedAuths);
		return userdetail;
	}


	private Set<GrantedAuthority> obtionGrantedAuthorities(SysUsers user) {
		
		Set<GrantedAuthority> authSet=new HashSet<GrantedAuthority>();
		
		List <SysUsersRoles> listUsersRoles = usersRolesService.getUserRoles(user.getUserId());//usersRolesMapper.selectByExample(example);
		for(SysUsersRoles userRole:listUsersRoles){
			authSet.add(new SimpleGrantedAuthority(userRole.getRoleId().toString()));
		}
		authSet.add(new SimpleGrantedAuthority("-1"));
		return authSet;	
        }
}
