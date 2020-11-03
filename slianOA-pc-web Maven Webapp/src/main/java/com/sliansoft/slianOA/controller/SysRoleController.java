package com.sliansoft.slianOA.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.service.OrganizationStructureService;
import com.sliansoft.slianOA.service.RolesService;
import com.sliansoft.slianOA.service.httpModels.HttpJson;
import com.sliansoft.slianOA.dataaccess.model.SysOrganizationStructure;
import com.sliansoft.slianOA.dataaccess.model.SysRole;

@Controller
@RequestMapping(value = "/roles")
public class SysRoleController {

	@Autowired
	private RolesService rolesService;

	@Autowired
	private OrganizationStructureService organizationService;


	@RequestMapping(value = "/getRoles.do")
	public @ResponseBody
	Object getRoles(HttpServletRequest req,SysRole role) {
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		
		return rolesService.getRoles(pageSize,pageIndex,role);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insert.do")
	public @ResponseBody
	HttpJson add(HttpServletRequest request) {

		String authorizeInfo = request.getParameter("inserted");
		JSONArray jsonArray = JSONArray.fromObject(authorizeInfo);
		List<SysRole> lroles = (List<SysRole>) JSONArray.toCollection(jsonArray,
				SysRole.class);

		HttpJson j = new HttpJson();
		if (rolesService.insert(lroles.get(0))) {
			j.setSuccess(true);
			j.setMsg("ok!");
		} else {
			j.setSuccess(false);
			j.setMsg("erro!");
		}

		return j;
	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	HttpJson del(HttpServletRequest request) {
		
		String rolesIds = request.getParameter("rolesIds");
		
		HttpJson j = new HttpJson();
		
		if (rolesIds == null || "".equals(rolesIds)){
			j.setSuccess(false);
			j.setMsg("请选择删除的角色！");
			return j;
			
		}
	
		if (rolesService.deleteRoles(rolesIds)) {
			j.setSuccess(true);
			j.setMsg("删除成功!");
		}else{
			
			j.setSuccess(false);
			j.setMsg("你所选择的角色已分配给用户或数据访问失败，删除失败!");
		}
		
		return j;
	}

	// 角色更新
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save.do")
	public @ResponseBody
	HttpJson save(HttpServletRequest request) {

		List<SysRole> lroles = (List<SysRole>) JSONArray
				.toCollection(
						JSONArray.fromObject(request.getParameter("data")),
						SysRole.class);

		HttpJson j = new HttpJson();

		SysRole role = lroles.get(0);

		// do insert
		if (role.getId() == null) {
			if (rolesService.insert(role)) {
				j.setSuccess(true);
				j.setMsg("新增保存成功!");
			} else {
				j.setSuccess(false);
				j.setMsg("新增保存失败!");
			}

		} else { // do update
			if (rolesService.update(role)) {
				j.setSuccess(true);
				j.setMsg("修改成功!");
			} else {
				j.setSuccess(false);
				j.setMsg("修改失败!");
			}
		}

		return j;

	}

}
