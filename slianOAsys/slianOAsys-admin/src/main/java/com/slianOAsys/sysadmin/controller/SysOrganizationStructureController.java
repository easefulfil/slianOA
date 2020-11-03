package com.slianOAsys.sysadmin.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slianOAsys.model.SysOrganizationStructure;
import com.slianOAsys.service.SysOrganizationStructureService;
import com.slianOAsys.service.httpModels.HttpJson;
import com.slianOAsys.service.utils.SysConst;
import com.slianOAsys.service.utils.SysOrganizationStructureTreeNode;

@Controller
@RequestMapping(value = "/organization")
public class SysOrganizationStructureController {

	@Autowired
	private SysOrganizationStructureService organizationStructureService;

	@RequestMapping(value = "/listOSTree.do")
	public @ResponseBody List<SysOrganizationStructureTreeNode> listOSTreeNodes() {

		// List<OrganizationStructure> list=
		// organizationStructureService.getTreegrid(id);
		System.out.println(10);
		return SysConst.ORGANIZATIONSTRUCTURE_TREE.getOSTreeNodes();
	}

	@RequestMapping(value = "/listAll.do")
	public @ResponseBody List<SysOrganizationStructure> listAll() {

		// List<OrganizationStructure> list=
		// organizationStructureService.getTreegrid(id);
		return SysConst.ORGANIZATIONSTRUCTURE_TREE.getListOrganizationStructure();
	}

	@RequestMapping(value = "/list.do")
	public @ResponseBody Object getOrganizationStructure_deprecated(HttpServletRequest req,
			SysOrganizationStructure os) {

		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageNow = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = organizationStructureService.getOrganizationByPage(os, pageSize, pageNow);
		return JSONObject.fromObject(map);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insert.do")
	public @ResponseBody HttpJson insert(HttpServletRequest request) {
		String osInfo = request.getParameter("osInfo");

		JSONArray jsonArray = JSONArray.fromObject("[" + osInfo + "]");
		List<SysOrganizationStructure> res = (List<SysOrganizationStructure>) JSONArray.toCollection(jsonArray,
				SysOrganizationStructure.class);

		HttpJson j = new HttpJson();
		if (organizationStructureService.insert(res.get(0))) {
			j.setSuccess(true);
			j.setMsg("组织保存成功!");
		} else {
			j.setSuccess(false);
			j.setMsg("组织保存成功!");
		}
		return j;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/update.do")
	public @ResponseBody HttpJson edit(HttpServletRequest request) {

		String osInfo = request.getParameter("osInfo");

		JSONArray jsonArray = JSONArray.fromObject("[" + osInfo + "]");
		List<SysOrganizationStructure> res = (List<SysOrganizationStructure>) JSONArray.toCollection(jsonArray,
				SysOrganizationStructure.class);

		HttpJson j = new HttpJson();

		if (organizationStructureService.update(res.get(0))) {
			j.setSuccess(true);
			j.setMsg("组织修改成功!");
		} else {
			j.setSuccess(false);
			j.setMsg("组织修改成功!");
		}
		return j;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save.do")
	public @ResponseBody String add_deprecated(HttpServletRequest req) {
		// String deleted = req.getParameter("deleted");
		String inserted = req.getParameter("inserted");
		String updated = req.getParameter("updated");

		// JSONUtils.getMorpherRegistry().registerMorpher(
		// new DateMorpherEx(new String[] { "yyyy-MM-dd" },(Date)null));
		if (inserted != null) {

			JSONArray jsonArray = JSONArray.fromObject(inserted);
			List<SysOrganizationStructure> listInserted = (List<SysOrganizationStructure>) JSONArray
					.toCollection(jsonArray, SysOrganizationStructure.class);
			for (SysOrganizationStructure organizationStructure : listInserted) {
				organizationStructure.setCreateTime(new Date());
				organizationStructureService.insert(organizationStructure);
			}
		}

		if (updated != null) {

			JSONArray jsonArray = JSONArray.fromObject(updated);
			List<SysOrganizationStructure> listUpdated = (List<SysOrganizationStructure>) JSONArray
					.toCollection(jsonArray, SysOrganizationStructure.class);
			for (SysOrganizationStructure organizationStructure : listUpdated) {
				organizationStructure.setCreateTime(new Date());
				organizationStructureService.update(organizationStructure);
			}
		}
		return "success";
	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody String del(String id) {

		if (id == null || "".equals(id))
			return "no found";

		return organizationStructureService.delete(Integer.parseInt(id));
	}

}
