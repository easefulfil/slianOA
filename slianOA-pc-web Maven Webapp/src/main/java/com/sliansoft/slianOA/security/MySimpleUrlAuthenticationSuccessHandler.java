package com.sliansoft.slianOA.security;

/**
 * 
 * @author M
 *
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.sliansoft.slianOA.dataaccess.dao.SysEmployeeMapper;
import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.SysUser;
import com.sliansoft.slianOA.dataaccess.model.SysUserRole;
import com.sliansoft.slianOA.dataaccess.utils.DataAuthorityRegister;
import com.sliansoft.slianOA.service.EmployeeService;
import com.sliansoft.slianOA.service.OrganizationStructureService;
import com.sliansoft.slianOA.service.ResourcesService;
import com.sliansoft.slianOA.service.RolesResourcesService;
import com.sliansoft.slianOA.service.UsersRolesService;
import com.sliansoft.slianOA.service.utils.Const;

public class MySimpleUrlAuthenticationSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {

	/*
	 * @Autowired private OlogService ologService;
	 * 
	 * @Autowired private LogAspect logAspect;
	 */

	@Autowired
	private MyAuthenticationFilter authenticationFilter;

	@Autowired
	private RolesResourcesService rolesResourcesService;


	@Autowired
	private ResourcesService resourcesService;

	@Autowired
	private UsersRolesService usersRolesService;
	
	@Autowired
	private OrganizationStructureService organizationStructureService;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@Autowired
	private SysEmployeeMapper sysEmployeeMapper;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		/*
		 * request.getSession().setAttribute("logAspect", logAspect);
		 * request.getSession().setAttribute("user", authentication.getName());
		 * String merchantIdentifier =
		 * authenticationFilter.obtainMerchantid(request);;
		 * request.getSession().setAttribute("merchantIdentifier",
		 * merchantIdentifier);
		 * 
		 * MDC.put("uid", ologService.getUid()); MDC.put("rid",
		 * ologService.getRid()); MDC.put("type", "登录");
		 * MDC.put("tablename","operate_log_"+merchantIdentifier);
		 * logger.info(ologService.getUsername()+"   登录！");
		 * 
		 * 
		 * Cookie cookie=new Cookie("merchanId",merchantIdentifier);
		 * cookie.setMaxAge(Integer.MAX_VALUE); response.addCookie(cookie);
		 */

		// 该user为spring 认证所创建的对象
		// User user = (User) authentication.getPrincipal();

		// this.setAuthenticationInfo(request,response, user,sysUser);

		this.dispatcher(request, response);
	}

	/**
	 * 根据登陆的用户类型进行跳转
	 * 
	 * @param response
	 * @param sysUser
	 * @throws IOException
	 * @throws ServletException
	 */
	private void dispatcher(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		String loginType = request.getParameter("loginType");

		if (loginType == null || "".equals(loginType)) {

			response.sendRedirect("error.jsp");
			return;
		}

		SysUser sysUser = (SysUser) request.getAttribute("sysUser");

		// 跳转到 查询子系统
		if (loginType.equals("QUERY")) {

			// 报价查询系统与管理系统在同域情况下的处理方式
			// RequestDispatcher dispatcher =
			// request.getRequestDispatcher(SysConst.QUERY_URL);
			// dispatcher.forward(request, response);

			// 跨越情况下
			// TODO将授权信息通过跨越方式，以cookie形式，写到查询系统端
//			this.setAuthenticationInfoFor_QUERY(request,response, sysUser);
			
			String sessionId = request.getSession().getId();
			
			//将当前登陆的用户Id与sessionId关联,放到HttpSessionListener中，用于分析系统登陆验证
			MyAuthenticationListener.addUserId(sessionId, sysUser.getId());

//			response.sendRedirect(SysConst.QUERY_URL+"?sessionId="+sessionId);
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
			JSONObject jo = new JSONObject();
			jo.put("loginType","QUERY");
			jo.put("sessionId",sessionId);
			
			out.print(JSONObject.fromObject(jo));
			out.flush();
			out.close();

			return;

		}

		// 登陆报价管理及分析系统
		if (loginType.equals("ANALYSIS") && "员工".equals(sysUser.getType()) ) {

			
			this.setAuthenticationInfoFor_ANALYSIS(request, response, sysUser);

//			response.sendRedirect("index.html");
			return;

		}

		// 选择的登陆系统与角色不匹配，跳转到Error页面，例如客户登陆账号，试图登陆到管理子系统
		response.sendRedirect("login.html?errorMsg=error");
	}

	
	private void setSessionInfo( HttpSession session,SysUser sysUser){

		// 将登陆的用户信息放到session中
		session.setAttribute("user", sysUser); 
		
		
		session.setAttribute("employee",sysEmployeeMapper.selectByPrimaryKey(sysUser.getUserDetailId()) );
		
		//添加数据授权登记
	    DataAuthorityRegister dataAuthorityRegister = new DataAuthorityRegister();
	    session.setAttribute("dataAuthorityRegister", dataAuthorityRegister);
	    
//		session.setAttribute("employee", employee);
	    
	    
	    
	    //添加角色集合
	    List<Integer> roleList=new ArrayList<Integer>();
	    for(SysUserRole ur: usersRolesService.getUserRoles(sysUser.getId())){
	    	roleList.add(ur.getRid());
	    }
	    session.setAttribute("roleList", roleList);
		
	}
	/**
	 * 当登陆分析子系统时(pcbas_analysisy)，根据授权成功信息设置服务器端的session及客户端的cookie信息
	 * 
	 * @param response
	 * @param user
	 * @param sysUser
	 * @throws IOException 
	 */
	private void setAuthenticationInfoFor_ANALYSIS(HttpServletRequest request,
			HttpServletResponse response, SysUser sysUser) throws IOException {

		HttpSession session = request.getSession();
		
		this.setSessionInfo(session, sysUser);
		
		try {
			
				
			Cookie userNameCookie = new Cookie("userName", URLEncoder.encode(
					sysUser.getUsername(), "UTF-8"));

			
			Cookie orgNameCookie = new Cookie("orgName", URLEncoder.encode(
					organizationStructureService.idToName(employeeService.idToOrgId(sysUser.getUserDetailId())), "UTF-8"));
						
			Cookie roleResourceIds = new Cookie("roleResourceIds",
					rolesResourcesService.getResourcesIds(sysUser.getId()));
			
			Cookie employeeType = new Cookie("employeeType",this.getEmployeeType(session));
			
			//todo 设置主菜单
			JSONObject menusJO = Const.RESOURCESTREE.bulidMenuResourceTree(rolesResourcesService.getResourcesIdList(sysUser.getId()));
//
//			Cookie menus = new Cookie("menus",URLEncoder.encode(
//					menusJO.toString(), "UTF-8"));
			

//     		userNameCookie.setPath("/pcbas-analysis");
//			roleResourceIds.setPath("/pcbas-analysis");
			
			
			response.addCookie(employeeType);
			response.addCookie(userNameCookie);
			response.addCookie(orgNameCookie);
			response.addCookie(roleResourceIds);
//			response.addCookie(menus);
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(JSONObject.fromObject(menusJO));
			out.flush();
			out.close();

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getEmployeeType(HttpSession session ){
		
		SysEmployee emp = session.getAttribute("employee")==null?null:(SysEmployee)session.getAttribute("employee");
		
		if(emp  == null)
			return "null";
		
//		if("全部".equals(emp.getEmployeeType()))
//			return "ALL";
//		
//		if("海运".equals(emp.getEmployeeType()))
//			return "HAIYUN";
//		if("报关".equals(emp.getEmployeeType()))
//			return "BAOGUAN";
//		
//		if("贸易".equals(emp.getEmployeeType()))
//			return "MAOYI";
//		
//		if("仓储".equals(emp.getEmployeeType()))
//			return "CANGCHU";
//		
//		if("运输".equals(emp.getEmployeeType()))
//			return "YUNSHU";
		
		return "ERROR";
	}
	

}
