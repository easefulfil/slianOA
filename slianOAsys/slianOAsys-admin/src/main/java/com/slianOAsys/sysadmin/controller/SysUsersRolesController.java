package com.slianOAsys.sysadmin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slianOAsys.model.ex.RolesEx;
import com.slianOAsys.service.SysUsersRolesService;
import com.slianOAsys.service.httpModels.HttpJson;

@Controller
@RequestMapping(value = "/usersRoles")
public class SysUsersRolesController {

	@Autowired
	private SysUsersRolesService usersRolesService;


	@RequestMapping(value = "/getHttpRoles.do")
	public @ResponseBody List<RolesEx> getHttpRoles(String userId) {
		
		
		
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
			j.setMsg("角色删除成功!");
		} else {
			j.setSuccess(false);
			j.setMsg("角色删除失败!");
		}
		return j;
	}



}
