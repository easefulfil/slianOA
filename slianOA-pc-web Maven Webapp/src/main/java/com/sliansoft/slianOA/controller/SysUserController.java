package com.sliansoft.slianOA.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.SysUser;
import com.sliansoft.slianOA.service.UsersService;
import com.sliansoft.slianOA.service.httpModels.HttpJson;
import com.sliansoft.slianOA.service.httpModels.HttpUsers;

@Controller
@RequestMapping(value = "/users")
public class SysUserController {

	@Autowired
	private UsersService usersService;


	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/getUsers.do")
	public @ResponseBody Object getUsers(HttpServletRequest req,SysUser user) {
		
		String userType = req.getParameter("userType");
		
		user.setType(userType);
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		
		return usersService.getHttpUsers(pageSize,pageIndex,user);
	}
	
//	@RequestMapping(value = "/changePassword")
//	@ResponseBody
//	public String changePassword(HttpServletRequest request,HttpServletResponse response)
//	{ 	
//		String[] str = new String[2];
//		str[0]=request.getParameter("oldpass");
//		str[1]=request.getParameter("newpass");
//
//		String user = (String) request.getSession().getAttribute("user");
//		return merchantService.savePassword(null,str,merchantIdentifier,user);
//	}


	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	HttpJson del(HttpServletRequest request) {
		
		String usersId = request.getParameter("usersId");
		
		HttpJson j = new HttpJson();
		
		if (usersId == null || "".equals(usersId)){
			j.setSuccess(false);
			j.setMsg("请选择删除的用户！");
			
		}
	
		if (usersService.delete(usersId)) {
			j.setSuccess(true);
			j.setMsg("用户删除成功!");
		}else{
			
			j.setSuccess(false);
			j.setMsg("数据访问失败，用户删除失败!");
		}
		
		return j;
	}

	// 角色更新
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save.do")
	public @ResponseBody HttpJson save(HttpServletRequest request) {

		List<HttpUsers> userList = (List<HttpUsers>) JSONArray
				.toCollection(JSONArray.fromObject(request.getParameter("data")),
						HttpUsers.class);

		HttpJson j = new HttpJson();

		SysUser user = new SysUser();

		BeanUtils.copyProperties(userList.get(0), user);

		if( StringUtils.isEmpty(user.getUsername())){
			
			j.setSuccess(false);
			j.setMsg("用户名不能为空，保存失败!");
			return j;
		}
			
		// do insert
		if (user.getId() == null) {
			if (usersService.insert(user)) {
				j.setSuccess(true);
				j.setMsg("新增用户保存成功!");
			} else {
				j.setSuccess(false);
				j.setMsg("新增用户保存失败!");
			}

		} else { // do update
			if (usersService.update(user)) {
				j.setSuccess(true);
				j.setMsg("修改用户保存成功!");
			} else {
				j.setSuccess(false);
				j.setMsg("修改用户保存失败!");
			}
		}

		return j;
	}

}
