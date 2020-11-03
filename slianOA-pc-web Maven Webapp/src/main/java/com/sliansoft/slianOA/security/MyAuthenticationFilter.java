package com.sliansoft.slianOA.security;
/**
 * 
 * @author M
 *
 */
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sliansoft.slianOA.dataaccess.dao.SysAuthenticationMapper;
import com.sliansoft.slianOA.dataaccess.dao.SysEmployeeMapper;
import com.sliansoft.slianOA.dataaccess.dao.SysUserMapper;
import com.sliansoft.slianOA.dataaccess.dao.SysUserRoleMapper;
import com.sliansoft.slianOA.dataaccess.model.SysAuthentication;
import com.sliansoft.slianOA.dataaccess.model.SysAuthenticationExample;
import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.SysUser;
import com.sliansoft.slianOA.dataaccess.model.SysUserRole;
import com.sliansoft.slianOA.dataaccess.model.SysUserRoleExample;
import com.sliansoft.slianOA.dataaccess.utils.DataAuthorityRegister;


public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

//	private static final String MERCHANTID = "merchantId";
	private static final String USERNAME = "userName";
	private static final String PASSWORD = "password";
	private static final String RANDOMCODE = "randomCode";

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysEmployeeMapper sysEmployeeMapper;
	
	@Autowired
	private SysAuthenticationMapper sysAuthenticationMapper;
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
//	@Autowired
//	private UsersRolesService usersRolesService;
//	

	

	//*****************************************************************************************
	@Override
	public Authentication attemptAuthentication(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)  throws AuthenticationException {
		
	    if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		String randomCode = obtainRandomcode(request);
		//获取保存在session中的验证码
		HttpSession session = request.getSession();
		
//		String validateCode=(String) session.getAttribute("RANDOMVALIDATECODEKEY");

		username = username.trim();
		SysAuthenticationExample example = new SysAuthenticationExample();
		example.or().andAccountEqualTo(username);
	    List<SysAuthentication> SysAuthentication = sysAuthenticationMapper.selectByExample(example);
	    
	    if (SysAuthentication.isEmpty() || !SysAuthentication.get(0).getPassword().equals(password)) {
			BadCredentialsException exception = new BadCredentialsException("用户名或密码不匹配或验证码错误！");
			throw exception;
		}else{
			SysAuthentication sysAuthentication=new SysAuthentication();
			sysAuthentication.setId(SysAuthentication.get(0).getId());
			sysAuthentication.setLastIp(getRemortIP(request));
			sysAuthentication.setLastTime(new Date());
			sysAuthenticationMapper.updateByPrimaryKeySelective(sysAuthentication);
		}
	    
	    //该user对象为系统定义的user
	    SysUser user=sysUserMapper.selectByPrimaryKey(SysAuthentication.get(0).getUid());
	    
	    if(user==null){
	    	//未找到用户
	    	BadCredentialsException exception = new BadCredentialsException("您的用户名、密码正确，但用户异常无法登陆！");
			throw exception;
	    }else{
	    	SysUser userRecord=new SysUser();
	    	userRecord.setId(user.getId());
	    	userRecord.setLastLoginIp(getRemortIP(request));
	    	userRecord.setLastLoginTime(new Date());
	    	sysUserMapper.updateByPrimaryKeySelective(userRecord);
	    }	    
	    request.setAttribute("sysUser", user);
//	    
//	    
//	    
//	    //添加用户信息
//	    request.getSession().setAttribute("sysUser", user);
//	    if(user.getType().equals("员工")){
//	    	Employee employee= employeeMapper.selectByPrimaryKey(user.getUserDetailId());
//	    	request.getSession().setAttribute("employee", employee);
//	    }
//	    //添加数据授权登记
//	    DataAuthorityRegister dataAuthorityRegister = new DataAuthorityRegister();
//	    request.getSession().setAttribute("dataAuthorityRegister", dataAuthorityRegister);
//	    //添加角色集合
//	    UsersRolesExample exampleUR = new UsersRolesExample();
//	    exampleUR.or().andUidEqualTo(user.getId());
//	    List<UsersRoles> uRList= usersRolesMapper.selectByExample(exampleUR);
//	    List<Integer> roleList=new ArrayList<Integer>();
//	    for(UsersRoles ur:uRList){
//	    	roleList.add(ur.getRid());
//	    }
//	    if(!user.getType().equals("客户") && roleList.size()==0){
//	    	//未找到用户
//	    	BadCredentialsException exception = new BadCredentialsException("您未被授权进入系统！");
//			throw exception;
//	    }
//	    
//	    
//	    request.getSession().setAttribute("roleList", roleList);
	    
	    
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user.getId(), "123456"/*MD5Encoder.getMD5Str(password)*/);
		
		setDetails(request, authRequest);
		
		
		
		return this.getAuthenticationManager().authenticate(authRequest);
	}	
	

		


//	protected String obtainMerchantid(HttpServletRequest request) {
//		Object obj = request.getParameter(MERCHANTID);
//		return null == obj ? "" : obj.toString();
//	}
	
	@Override
	protected String obtainUsername(HttpServletRequest request) {
		Object obj = request.getParameter(USERNAME);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		Object obj = request.getParameter(PASSWORD);
		return null == obj ? "" : obj.toString();
	}
	
	protected String obtainRandomcode(HttpServletRequest request) {
		Object obj = request.getParameter(RANDOMCODE);
		return null == obj ? "" : obj.toString();
	}
	
	@Override
	protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
		super.setDetails(request, authRequest);
		return;
	}
	
	//获得经过代理的IP
	public String getRemortIP(HttpServletRequest request) {  
		if (request.getHeader("x-forwarded-for") == null) {  
			return request.getRemoteAddr();  
		}  
		return request.getHeader("x-forwarded-for");  
	} 
}
