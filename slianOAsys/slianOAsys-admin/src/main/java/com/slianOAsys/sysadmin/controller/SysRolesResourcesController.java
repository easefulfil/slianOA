package com.slianOAsys.sysadmin.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slianOAsys.service.SysRolesResourcesService;
import com.slianOAsys.service.httpModels.HttpJson;

@Controller
@RequestMapping(value = "/rolesresources")
public class SysRolesResourcesController {

	@Autowired
	private SysRolesResourcesService rolesResourcesService;

/*	@RequestMapping(value = "/getRolesResourcesOS.do")
	public @ResponseBody
	Object getRolesResourcesOS(HttpServletRequest request) {

		return rolesResourcesService.getRolesResourcesOS(
				request.getParameter("roleId"), request.getParameter("resourceId"));

	}*/
	@RequestMapping(value = "/getRolesResourcesOS.do")
	public @ResponseBody JSONArray getRolesResourcesOS(HttpServletRequest req) {
		return rolesResourcesService.getRolesResourcesOSTest(req.getParameter("roleId"), req.getParameter("resourceId"));

	}
	
	@RequestMapping(value = "/getRolesResourcesInitOS.do")
	public @ResponseBody JSONArray getRolesResourcesInitOS(HttpServletRequest req) {
		return rolesResourcesService.getRolesResourcesInitOS();

	}
	@RequestMapping(value = "/getRolesResources.do")
	public @ResponseBody
	Object getRolesResources(HttpServletRequest request) {

		String roleId = request.getParameter("roleId");

		return rolesResourcesService.getRolesResources(roleId);

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertResources.do")
	public @ResponseBody
	HttpJson insertResources(HttpServletRequest request) {

		String roleId = request.getParameter("roleId");
		String resourcesId = request.getParameter("resourcesId");

		// JSONArray jsonArray=JSONArray.fromObject("["+resourceInfo+"]");
		// List<Resources> res =
		// (List<Resources>)JSONArray.toCollection(jsonArray, Resources.class);
		//
		HttpJson j = new HttpJson();
		if (rolesResourcesService.insert(roleId, resourcesId)) {
			j.setSuccess(true);
			j.setMsg("ok!");
		} else {
			j.setSuccess(false);
			j.setMsg("erro!");
		}
		return j;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteResources.do")
	public @ResponseBody
	HttpJson deleteResources(HttpServletRequest request) {
	
		String roleId = request.getParameter("roleId");
		String resourcesId = request.getParameter("resourcesId");
	
		// JSONArray jsonArray=JSONArray.fromObject("["+resourceInfo+"]");
		// List<Resources> res =
		// (List<Resources>)JSONArray.toCollection(jsonArray, Resources.class);
	
		HttpJson j = new HttpJson();
		if (rolesResourcesService.delete(roleId, resourcesId)) {
			j.setSuccess(true);
			j.setMsg("ok!");
		} else {
			j.setSuccess(false);
			j.setMsg("erro!");
		}
		return j;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertOS.do")
	public @ResponseBody
	HttpJson insertOS(HttpServletRequest request) {

		String roleId = request.getParameter("roleId");
		String resourcesId = request.getParameter("resourcesId");
		String orgStrId = request.getParameter("orgStrId");

		HttpJson j = new HttpJson();
		if (rolesResourcesService.insert(roleId, resourcesId,orgStrId)) {
			j.setSuccess(true);
			j.setMsg("ok!");
		} else {
			j.setSuccess(false);
			j.setMsg("erro!");
		}
		return j;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteOS.do")
	public @ResponseBody
	HttpJson deleteOS(HttpServletRequest request) {

		String roleId = request.getParameter("roleId");
		String resourcesId = request.getParameter("resourcesId");
		String orgStrId = request.getParameter("orgStrId");

		HttpJson j = new HttpJson();
		if (rolesResourcesService.delete(roleId, resourcesId,orgStrId)) {
			j.setSuccess(true);
			j.setMsg("ok!");
		} else {
			j.setSuccess(false);
			j.setMsg("erro!");
		}
		return j;
	}



}
