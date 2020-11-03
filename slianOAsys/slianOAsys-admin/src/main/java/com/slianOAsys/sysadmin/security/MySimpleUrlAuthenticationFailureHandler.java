
package com.slianOAsys.sysadmin.security;

/**
 * 
 * @author M
 *
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.alibaba.fastjson.JSONObject;


public class MySimpleUrlAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	 
	public MySimpleUrlAuthenticationFailureHandler() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param defaultFailureUrl
	 */
	public MySimpleUrlAuthenticationFailureHandler(String defaultFailureUrl) {
		super(defaultFailureUrl);
		
		// TODO Auto-generated constructor stub
	}

/*	@Autowired
	private OlogService ologService;
	@Autowired
	private LogAspect logAspect;*/

	@Override
	public void onAuthenticationFailure(
			HttpServletRequest request, 
			HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
		/* MDC.put("uid", ologService.getUid());
	     MDC.put("rid", ologService.getRid());
	     MDC.put("type", "登录");
	     MDC.put("tablename","operate_log" );
	     logger.info(ologService.getUsername()+"   尝试登入�?); */
//		System.out.println(exception.toString());
//		//super.onAuthenticationFailure(request, response, exception);

		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
//		out.print();
		
		JSONObject jo = new JSONObject();
		
		jo.put("status",false);
		jo.put("msg", exception.getMessage());
		
		out.print(jo);
		out.flush();
		out.close();
//		request.setCharacterEncoding("gb2312");
//		response.setCharacterEncoding("gb2312")
		
//		String message = URLEncoder.encode(exception.getMessage(),"utf-8");;
//		response.sendRedirect("login.html?errorMsg=error");
      
    }
	
}
