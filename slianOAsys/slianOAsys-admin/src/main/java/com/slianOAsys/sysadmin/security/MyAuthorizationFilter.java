package com.slianOAsys.sysadmin.security;


import java.io.IOException;

import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.slianOAsys.model.SysUsers;
import com.slianOAsys.service.utils.SysConst;
import com.slianOAsys.util.DataAuthorityRegister;

public class MyAuthorizationFilter extends AbstractSecurityInterceptor implements Filter {

	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}
	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return securityMetadataSource;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}

	@Override
	public Class<? extends Object> getSecureObjectClass() {
		return FilterInvocation.class;
	}
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		FilterInvocation fi = new FilterInvocation(request, response, chain);
        
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		 //set MDC for log
	    logInfo(httpRequest);
	    		
		InterceptorStatusToken token = super.beforeInvocation(fi);

		//创建数据权限钥匙
		//获取当前数据授权部门列表
        String url = httpRequest.getRequestURI();
        
        List<Integer> roleL=(List<Integer>)httpRequest.getSession().getAttribute("roleList");
        
        Set<Integer> orgSet=SysConst.ROLE_RESOURCE.getOrgSetUnderResourceRoles(SysConst.RESOURCESTREE.resourceMatching(url),roleL);
        
        orgSet=SysConst.ORGANIZATIONSTRUCTURE_TREE.getAllChildren(orgSet);
//		Set<Integer> employeeSet= SysConst.EMPLOYEE_ORG.getEmployeeSet(orgSet);
        //获取当前线程
        Thread currentTh=Thread.currentThread();
        //
       DataAuthorityRegister dataAuthorityRegister=(DataAuthorityRegister)httpRequest.getSession().getAttribute("dataAuthorityRegister");
        
   
        if(dataAuthorityRegister == null){
        	 HttpServletResponse res = (  HttpServletResponse ) response;
             res.sendRedirect("/slianOAsys-web/login.html");
            
            return;
        }
       
       dataAuthorityRegister.addNewAuthority(currentTh.getId(), orgSet,orgSet==null?false:true);
        
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
			//销毁数据权限钥匙
			dataAuthorityRegister.delAuthority(currentTh.getId());
			
			//System.out.println("end:"+currentTh.getId());
	        //dataAuthorityRegister.show();
		} finally {
			//销毁数据权限钥匙
			dataAuthorityRegister.delAuthority(currentTh.getId());
			
			super.afterInvocation(token, null);
		}
	}
	
	public void init(FilterConfig arg0) throws ServletException {
	}

	public void destroy() {
		
	}

	private void logInfo(HttpServletRequest httpRequest){
		SysUsers user = (SysUsers)httpRequest.getSession().getAttribute("loginingUser");
		if(user!=null){
			MDC.put("UserId", user.getUserId());
		}else{
			MDC.put("UserId", new Integer(0));
		}
		MDC.put("IP", getRemortIP(httpRequest));
	}
	//获得经过代理的IP
	public String getRemortIP(HttpServletRequest request) {  
		if (request.getHeader("x-forwarded-for") == null) {  
			return request.getRemoteAddr();  
		}  
		return request.getHeader("x-forwarded-for");  
	} 

}
