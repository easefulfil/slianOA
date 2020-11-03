package com.sliansoft.slianOA.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.service.UsersRolesService;
import com.sliansoft.slianOA.service.httpModels.HttpJson;
import com.sliansoft.slianOA.service.httpModels.HttpRoles;

@Controller
@RequestMapping(value = "/usersRoles")
public class SysUserRoleController {

	@Autowired
	private UsersRolesService usersRolesService;


	@RequestMapping(value = "/getHttpRoles.do")
	public @ResponseBody List<HttpRoles> getHttpRoles(String userId) {
		
		
		
		return usersRolesService.getUserHttpRoles(userId);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insert.do")
	public @ResponseBody HttpJson add(HttpServletRequest request) {
		
		String roleId = request.getParameter("roleId");
		String userId = request.getParameter("userId");

		//
		HttpJson j = new HttpJson();
		if (usersRolesService.insert(userId,roleId)) {
			j.setSuccess(true);
			j.setMsg("角色分配成功！");
		} else {
			j.setSuccess(false);
			j.setMsg("角色分配失败!");
		}
		return j;
	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	HttpJson del(HttpServletRequest request) {

		String roleId = request.getParameter("roleId");
		String userId = request.getParameter("userId");

		//
		HttpJson j = new HttpJson();
		if (usersRolesService.delete( userId,roleId)) {
			j.setSuccess(true);
			j.setMsg("角色删除成功！");
		} else {
			j.setSuccess(false);
			j.setMsg("角色删除失败!");
		}
		return j;
	}



}
