/**
 * 授权过滤器
 * 实现手机前端请求的授权控制，主要实现步骤
 * 1、根据手机用户的微信企业号里面的个人账号，获得该用户的系统账号
 * 2、通过系统账号，获取该用户的角色，和员工ID
 * 3、根据所访问的资源URL
 * 
 * create by 程学林 2016年5月5日
 * 宁波数联软件有限公司  sliansoft.com
 */

package com.sliansoft.slianOA.mobile.filter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;

import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.SysUser;
import com.sliansoft.slianOA.dataaccess.model.SysUserRole;
import com.sliansoft.slianOA.dataaccess.utils.DataAuthorityRegister;
import com.sliansoft.slianOA.service.EmployeeService;
import com.sliansoft.slianOA.service.UsersRolesService;
import com.sliansoft.slianOA.service.UsersService;
import com.sliansoft.slianOA.service.utils.Const;


public class AuthorizationFilter implements Filter {
	
	@Autowired
	private EmployeeService employeeService;	
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private UsersRolesService usersRolesService;
	
	
	
	

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		String uri = httpRequest.getRequestURI();
		
		System.out.println(uri); 
		
//		String wechatAccountAndActivityId = request.getParameter("wechatAccountAndActivityId");
//		String wechatAccountAndWorkplanId=request.getParameter("wechatAccountAndWorkplanId");
//		String wechatAccount = null;
		HttpSession session = httpRequest.getSession();
//		if(wechatAccountAndActivityId != null){
//			System.out.println("wechatAccountAndActivityId " + wechatAccountAndActivityId);
//			String[] parameters = wechatAccountAndActivityId.split(" ");
// 			wechatAccount = parameters[0];
//			String activityId = parameters[1];
//			String attitude = parameters[2];			
//			session.setAttribute("activityId", activityId);
//			session.setAttribute("attitude", attitude);
//		}else{
		String	wechatAccount = request.getParameter("wechatAccount");
//		}
//		if(wechatAccount==null){
//			if(wechatAccountAndWorkplanId!=null){
//				String[] parameters = wechatAccountAndWorkplanId.split(" ");
//	 			wechatAccount = parameters[0];			
//			}
//			else
//				wechatAccount = request.getParameter("wechatAccount");
//		}
		if(StringUtils.isEmpty(wechatAccount))
		{
			System.out.println(wechatAccount);
			throw new AccessDeniedException("未授权！");	//return 没有权限   
		}
		
		SysEmployee sysEmployee = employeeService.getEmployee(wechatAccount);System.out.println("employee："+wechatAccount);
		if(sysEmployee == null){
			throw new AccessDeniedException("未授权！");	//return 没有权限   
		}
		
//		System.out.println("wechatAccount:"+ wechatAccount);
		session.setAttribute("wechatAccount", wechatAccount);
        session.setAttribute("employee", sysEmployee);
        SysUser  sysUser = usersService.getUsers(usersService.getUserId(sysEmployee.getEmployeeId(),"员工"));
     // 将登陆的用户信息放到session中
     	session.setAttribute("user", sysUser);
     	
     	logInfo(httpRequest);
     	
		List<Integer> roleList = this.getRoleList(wechatAccount);
		session.setAttribute("roleList", roleList);
		Set<Integer> orgSet=Const.ROLE_RESOURCE.getOrgSetUnderResourceRoles(Const.RESOURCESTREE.resourceMatching(uri),roleList);
        orgSet=Const.ORGANIZATIONSTRUCTURE_TREE.getAllChildren(orgSet);
        
//        if(orgSet.size() == 0)
//        	throw new AccessDeniedException("未授权！");	//return 没有权限   
//        
        
        //获取当前线程
        Thread currentTh=Thread.currentThread();
        Long id=currentTh.getId();
        DataAuthorityRegister dataAuthorityRegister = new DataAuthorityRegister();
        dataAuthorityRegister.addNewAuthority(id, orgSet,
        		(orgSet==null )?false:true,   //orgSet==null 表示当前访问的资源不需要做数据授权 , orgSet.size() ==0
        				sysEmployee.getEmployeeId());
        session.setAttribute("dataAuthorityRegister", dataAuthorityRegister);
        session.setAttribute("orgSet", orgSet);
        
        session.setAttribute("uri", uri);
        chain.doFilter(httpRequest, response);
		//销毁数据权限钥匙
		dataAuthorityRegister.delAuthority(currentTh.getId());
		session.invalidate();
	}
	
	private void setSessionInfo( HttpSession session){

		/*// 将登陆的用户信息放到session中
		session.setAttribute("user", sysUser); 
		
		
		session.setAttribute("employee",employeeMapper.selectByPrimaryKey(sysUser.getUserDetailId()) );
		*/
		
		//添加数据授权登记
	    DataAuthorityRegister dataAuthorityRegister = new DataAuthorityRegister();
	    session.setAttribute("dataAuthorityRegister", dataAuthorityRegister);
	    
//		session.setAttribute("employee", employee);
	    
	    
	    
/*	    //添加角色集合
	    List<Integer> roleList=new ArrayList<Integer>();
	    for(UsersRoles ur: usersRolesService.getUserRoles(sysUser.getId())){
	    	roleList.add(ur.getRid());
	    }
	    session.setAttribute("roleList", roleList);*/
		
	}
	
	private List<Integer> getRoleList(String wechatAccount){
		
//		SalesysEmployeeService salesysEmployeeService = (SalesysEmployeeService)employeeService;
		
		Integer empId = employeeService.getEmployeeId(wechatAccount);
		
		if(empId == -1) //未找到对应的员工
			return null;
		
		Integer userId = usersService.getUserId(empId,"员工");
		
		if(userId == -1)//未找到userID
			return null;
		
		  //添加角色集合
	    List<Integer> roleList=new ArrayList<Integer>();
	    for(SysUserRole ur: usersRolesService.getUserRoles(userId)){
	    	roleList.add(ur.getRid());
	    }
		
		return roleList;
	}

	private void logInfo(HttpServletRequest httpRequest){
		SysEmployee user = (SysEmployee)httpRequest.getSession().getAttribute("employee");
		if(user!=null){
			MDC.put("UserId", user.getEmployeeId());
			MDC.put("employeeId", user.getEmployeeId());
		}else{
			MDC.put("UserId", new Integer(0));
			MDC.put("employeeId",  new Integer(0));
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
	

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
