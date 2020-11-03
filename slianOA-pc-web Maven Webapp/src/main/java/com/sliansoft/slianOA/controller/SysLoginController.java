package com.sliansoft.slianOA.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.security.MyAuthenticationListener;
import com.sliansoft.slianOA.utils.ValidateCodeUtil;
import com.sliansoft.slianOA.dataaccess.dao.SysAuthenticationMapper;
import com.sliansoft.slianOA.dataaccess.model.SysAuthentication;
import com.sliansoft.slianOA.dataaccess.model.SysAuthenticationExample;
import com.sliansoft.slianOA.dataaccess.model.SysUser;
import com.sliansoft.slianOA.service.RolesResourcesService;
import com.sliansoft.slianOA.service.utils.Const;

@Controller
@RequestMapping(value = "/login")
public class SysLoginController {
	@Autowired
	private HttpSession session;
	@Autowired
	private SysAuthenticationMapper sysAuthenticationMapper;
	@Autowired
	private RolesResourcesService rolesResourcesService;

	//用于查询系统的登陆验证
	@RequestMapping(value = "/doLoginBySessionId.do")
	public void doLoginBySessionId(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String sessionId = request.getParameter("sessionId");
		
		Integer currentUserId = MyAuthenticationListener.getUserId(sessionId);
		
		//移出登陆信息
		MyAuthenticationListener.removeUserId(sessionId);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print((currentUserId == null|| "".equals(currentUserId ))?0:currentUserId.toString());
		out.flush();
		out.close();
		
	}
	
	//生成验证码
	@RequestMapping(value = "/getCode")
	public void generateValidateCode(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        ValidateCodeUtil randomValidateCode = new ValidateCodeUtil();
        randomValidateCode.getRandcode(request, response);//输出图片方法
    }
	
	
	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/logout.do")
	public @ResponseBody String logOut(HttpServletRequest request, HttpServletResponse response) {
		
		session.invalidate();
		
		Cookie [] cookies = request.getCookies();
		
		if(cookies == null)
			return "success";
		
		for(Cookie cookie:cookies){  
		    cookie.setMaxAge(0);  
		    response.addCookie(cookie);
		} 
		
        return "success";
    }
	
	
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/changePwd.do")
	public @ResponseBody String changePwd(HttpServletRequest request, HttpServletResponse response) {
		
		String oldPwd=request.getParameter("old");
		String newPwd=request.getParameter("new");
		
		SysUser user = (SysUser)session.getAttribute("user");
        
		SysAuthenticationExample example = new SysAuthenticationExample();
		example.or().andUidEqualTo(user.getId());
		SysAuthentication authInfo=sysAuthenticationMapper.selectByExample(example).get(0);
		
		if(!authInfo.getPassword().equals(oldPwd)){
			return "false";
		}else{
			SysAuthentication auth=new SysAuthentication();
			auth.setPassword(newPwd);
			sysAuthenticationMapper.updateByExampleSelective(auth, example);
		}
		return "success";
	}
	@RequestMapping(value="/getMenus.do")
	public @ResponseBody Object getMenus(HttpServletRequest request, HttpServletResponse response){
		SysUser user = (SysUser)session.getAttribute("user");
		JSONObject menusJO = Const.RESOURCESTREE.bulidMenuResourceTree(rolesResourcesService.getResourcesIdList(user.getId()));
		return menusJO;
		
		
	}
	
	@RequestMapping(value="/checkCode.do")
	public @ResponseBody Object checkCode(HttpServletRequest request){
		String rand = (String) session.getAttribute("rand");
		System.out.println("code："+rand);
		String code = request.getParameter("code");
		 String cc = (String) request.getSession().getAttribute("rand");
		System.out.println("cc："+cc);
		if(code.equals(rand)){
			return "success";
		}else{
			return "false";
		}
		
	}
	
}
