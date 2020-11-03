package com.slianOAsys.sysadmin.security;

import java.util.Date;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.slianOAsys.model.SysAuthenticationInfo;
import com.slianOAsys.model.SysUsers;
import com.slianOAsys.service.SysAuthenticationInfoService;
import com.slianOAsys.service.SysUsersService;

public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

//	private static final String MERCHANTID = "merchantId";
	private static final String USERNAME = "account";
	private static final String PASSWORD = "password";
	private static final String RANDOMCODE = "randomCode";
	private static final String TYPE = "type";

	
	@Autowired
	private SysUsersService sysUserService;
		
	@Autowired
	private SysAuthenticationInfoService authenticationInfoService;
	

	//*****************************************************************************************
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)  throws AuthenticationException {
		
	    if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		
	    response.setContentType("text/html;charset=utf-8"); 
	    
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		String randomCode = obtainRandomcode(request);
		
		String type =  obtainType(request);
		
		//获取保存在session中的验证
		HttpSession session = request.getSession();
//		SysUsers suser=(SysUsers)session.getAttribute("user");
////		String validateCode=(String) session.getAttribute("RANDOMVALIDATECODEKEY");
//		MDC.put("userId",suser.getUserId());
		username = username.trim();
		
//		AuthenticationInfoExample example = new AuthenticationInfoExample();
//		example.or().andAccountEqualTo(username);
	    List<SysAuthenticationInfo> authInfoList = authenticationInfoService.getAuthenticationInfo(username, password);//authenticationInfoMapper.selectByExample(example);
	    
	    
	    SysUsers user = null;
	    SysAuthenticationInfo currentAuthInfo = null;
	    
	    if (authInfoList == null ||authInfoList.isEmpty() ) {
			BadCredentialsException exception = new BadCredentialsException("用户名或密码错误！");
			throw exception;
			
		
		}else{
			//根据用户的类型（组委会（员工），嘉宾，客商类型判断登陆）
			//目前前端的登陆类型只有 员工和嘉宾，其中嘉宾类型包含了客商类型登陆
			for(SysAuthenticationInfo authInfo:authInfoList){

				  user= sysUserService.getUsers(authInfo.getUserId());
				  
				  if(type.equals(user.getType())
					|| ("嘉宾".equals(type) &&  "客商".equals(user.getType()))){
					  
					  currentAuthInfo = authInfo;
					  break;
				  }
			}
		}
      //该user对象为系统定义的user
	    if(user == null || currentAuthInfo == null){
	    	//未找到用户
	    	BadCredentialsException exception = new BadCredentialsException("账号与身份不符！");
			throw exception;
	    }

	   
	    request.setAttribute("loginingAccount",currentAuthInfo.getAccount());
	    session.setAttribute("loginingAccount",user.getUserName());
	   /* session.setAttribute("employeeId",user.getEmployeeId());*/
	    request.setAttribute("sysUser", user);
	    MDC.put("UserId", user);
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user.getUserId(), "123456"/*MD5Encoder.getMD5Str(password)*/);
		
		setDetails(request, authRequest);
		
		
		this.updateLoginLog(currentAuthInfo, user,getRemortIP(request));
		
		return this.getAuthenticationManager().authenticate(authRequest);
	}	
	

	private void updateLoginLog(SysAuthenticationInfo authInfo,SysUsers user,String ip){
//		SysAuthenticationInfo authInfo=new SysAuthenticationInfo();
		authInfo.setAuthenticationId(authInfo.getAuthenticationId());
		authInfo.setLastIp(ip);
		authInfo.setLastTime(new Date());
		
		
		user.setUserId(user.getUserId());
    	user.setLastLoginIp(ip);
    	user.setLastLoginTime(new Date());
    	
    	
		authenticationInfoService.update(authInfo);
		
		sysUserService.update(user);
	}
	
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
	
	
	protected String obtainType(HttpServletRequest request) {
		Object obj = request.getParameter(TYPE);
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
