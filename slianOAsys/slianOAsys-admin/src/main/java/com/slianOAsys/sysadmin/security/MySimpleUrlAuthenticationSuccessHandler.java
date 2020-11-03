package com.slianOAsys.sysadmin.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.slianOAsys.model.SysEmployee;
import com.slianOAsys.model.SysUsers;
import com.slianOAsys.model.SysUsersRoles;
import com.slianOAsys.model.ex.SysUsersEx;
import com.slianOAsys.service.SysEmployeeService;
import com.slianOAsys.service.SysRolesResourcesService;
import com.slianOAsys.service.SysUsersRolesService;
import com.slianOAsys.service.utils.SysConst;
import com.slianOAsys.sysadmin.security.utils.AuthencationResult;
import com.slianOAsys.util.DataAuthorityRegister;

public class MySimpleUrlAuthenticationSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private SysRolesResourcesService rolesResourcesService;

	@Autowired
	private SysUsersRolesService usersRolesService;

	@Autowired
	private SysEmployeeService employeeService;

	//@Autowired
//	private SysCustomerService customerService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

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

		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		AuthencationResult authResult = new AuthencationResult();

		this.setAuthencationResult(request, authResult);

		out.print(JSONObject.fromObject(authResult));
		out.flush();
		out.close();

		// 选择的登陆系统与角色不匹配，跳转到Error页面，例如客户登陆账号，试图登陆到管理子系统
		// response.sendRedirect("login.html?errorMsg=error");
	}

	private void setAuthencationResult(HttpServletRequest request,
			AuthencationResult authResult) {

		SysUsers user = (SysUsers) request.getAttribute("sysUser");

		authResult.setUser(user);
		authResult.setLoginingAccount((String) request
				.getAttribute("loginingAccount"));
		authResult.setStatus(true);
		authResult.setMsg("登陆验证成功！");
		
		
		HttpSession session = request.getSession();
		
		// 嘉宾登陆
		if ("嘉宾".equals(user.getType())) {
			
//			LoginingCustomer loginingCustomer = new LoginingCustomer();

//			SysCustomer customer = customerService.getCustomer(user
//					.getUserDetailId());
//
//			authResult.setCustomer(customer);//customerService.getCustomer(user.getUserDetailId())
//
//			this.setSessionForCustomer(session, user, customer);
		}

		// 嘉宾登陆
		if ("客商".equals(user.getType())) {

//			LoginingCustomer loginingCustomer = new LoginingCustomer();

//			SysCustomer customer = customerService.getCustomer(user
//					.getUserDetailId());
//
//			try {
//				BeanUtils.copyProperties(loginingCustomer, customer);
//
//			} catch (IllegalAccessException | InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			authResult.setCustomer(loginingCustomer);
//
//			this.setSessionForCustomer(session, user, customer);

		}

		// 嘉宾登陆
		if ("员工".equals(user.getType())) {
			
			SysEmployee employee = employeeService.getEmployeeById(user
					.getEmployeeId());

			authResult.setEmployee(employee);
			
			List<Integer> rrs = rolesResourcesService
			.getResourcesIdList(user.getUserId());
			
			//未分配角色
			if(rrs == null){
				authResult.setMenuJSON(null);
				authResult.setMsg("您还未分配角色，请与管理员联系！");
			}
				
			else{
				// todo 设置主菜单
				JSONObject menuJSON = SysConst.RESOURCESTREE
									.bulidMenuResourceTree(rrs);

				authResult.setMenuJSON(menuJSON);

			}
						
			this.setSessionForEmployee(session, user, employee);

		}
		
	

	}
//	SysCustomer customer
	public void setSessionForCustomer(HttpSession session,SysUsers user) {

		SysUsersEx userEx = new SysUsersEx();

		try {
			
			BeanUtils.copyProperties(userEx, user);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//说明当前登陆的是客户，创建的所有记录的数据访问组为-1
		userEx.setCounterMan(-1);
		userEx.setAccessGroup("-1");
		
		session.setAttribute("loginingUser", userEx);
		
		
	}

	
	public void setSessionForEmployee(HttpSession session,SysUsers user,SysEmployee employee ) {

		SysUsersEx userEx = new SysUsersEx();

		try {
			
			BeanUtils.copyProperties(userEx, user);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//说明当前登陆的是客户，创建的所有记录的数据访问组为 该员工所在
		userEx.setCounterMan(employee.getEmployeeId());
		userEx.setAccessGroup(employee.getEmployeeDepartment() ==null?"-1":
			employee.getEmployeeDepartment().toString());
		
		this.setDataAuthorityRegister(session, userEx);
	
		
		session.setAttribute("loginingUser", userEx);
		
	}
	
	//数据授权
	private void setDataAuthorityRegister(HttpSession session,SysUsers user){
		
		
		// 添加数据授权登记
		DataAuthorityRegister dataAuthorityRegister = new DataAuthorityRegister();

		session.setAttribute("dataAuthorityRegister", dataAuthorityRegister);
		
		// 添加角色集合
		List<Integer> roleList = new ArrayList<Integer>();

		for (SysUsersRoles ur : usersRolesService
						.getUserRoles(user.getUserId())) {
			roleList.add(ur.getRoleId());
		}

		session.setAttribute("roleList", roleList);
	}


}
