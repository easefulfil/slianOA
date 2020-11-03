package com.sliansoft.slianOA.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.utils.SysConst;
import com.sliansoft.slianOA.dataaccess.model.SysOrganizationStructure;
import com.sliansoft.slianOA.dataaccess.model.SysResource;
import com.sliansoft.slianOA.service.OrganizationStructureService;
import com.sliansoft.slianOA.service.httpModels.HttpJson;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.OrganizationStructureTreeNode;


@Controller
@RequestMapping(value = "/organization")
public class SysOrganizationStructureController {
	
	@Autowired
	private OrganizationStructureService organizationStructureService;	
	
	@RequestMapping(value = "/getOSbyKey.do")
	public @ResponseBody Object getOSbyKey(String osId){ 
		
		//List<OrganizationStructure> list= organizationStructureService.getTreegrid(id);
		
		if(StringUtils.isEmpty(osId))
			return null;
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		
		return JSONObject.fromObject(organizationStructureService.getOSbyId(Integer.parseInt(osId)),config);
		
	}
		

	
	
	@RequestMapping(value = "/listOSTree.do")
	public @ResponseBody List<OrganizationStructureTreeNode> listOSTreeNodes(){ 
		
		//List<OrganizationStructure> list= organizationStructureService.getTreegrid(id);
		return SysConst.ORGANIZATIONSTRUCTURE_TREE.getOSTreeNodes();
	}
	
	@RequestMapping(value = "/listAll.do")
	public @ResponseBody List<SysOrganizationStructure> listAll(){ 
		
		//List<OrganizationStructure> list= organizationStructureService.getTreegrid(id);
		return SysConst.ORGANIZATIONSTRUCTURE_TREE.getListOrganizationStructure();
	}

	
	@RequestMapping(value = "/list.do")
	public @ResponseBody Object getOrganizationStructure_deprecated(HttpServletRequest req,SysOrganizationStructure os){ 
		
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageNow = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = organizationStructureService.getOrganizationByPage(os,pageSize, pageNow);
 		return JSONObject.fromObject(map);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insert.do")
	public @ResponseBody HttpJson insert(
			HttpServletRequest request){ 
		String osInfo = request.getParameter("osInfo");
		
		JSONArray jsonArray=JSONArray.fromObject("["+osInfo+"]");
		List<SysOrganizationStructure> res = (List<SysOrganizationStructure>)JSONArray.toCollection(jsonArray, SysOrganizationStructure.class);
		
		HttpJson j = new HttpJson();
		if(organizationStructureService.insert(res.get(0))){
			j.setSuccess(true);
			j.setMsg("组织保存成功！");
		}
		else{
			j.setSuccess(false);
			j.setMsg("组织保存成功!");
		}		
		return j;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/update.do")
	public @ResponseBody HttpJson edit(
			HttpServletRequest request){ 
		
		String osInfo = request.getParameter("osInfo");
		
		
		
		JSONArray jsonArray=JSONArray.fromObject("["+osInfo+"]");
		List<SysOrganizationStructure> res = (List<SysOrganizationStructure>)JSONArray.toCollection(jsonArray, SysOrganizationStructure.class);
		
		
		HttpJson j = new HttpJson();
		
		
		if(organizationStructureService.update( res.get(0))){
			j.setSuccess(true);
			j.setMsg("组织修改成功！");
		}
		else{
			j.setSuccess(false);
			j.setMsg("组织修改成功!");
		}		
		return j;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save.do")
	public @ResponseBody String add_deprecated(
			HttpServletRequest req){ 
		// String deleted = req.getParameter("deleted");
		String inserted = req.getParameter("inserted");
		String updated = req.getParameter("updated");

//		JSONUtils.getMorpherRegistry().registerMorpher(  
//	               new DateMorpherEx(new String[] { "yyyy-MM-dd" },(Date)null));
		if (inserted != null) {
			 
			JSONArray jsonArray = JSONArray.fromObject(inserted);
			List<SysOrganizationStructure> listInserted = (List<SysOrganizationStructure>) JSONArray
					.toCollection(jsonArray, SysOrganizationStructure.class);
			for (SysOrganizationStructure sysOrganizationStructure : listInserted) {
				sysOrganizationStructure.setCreateTime(new Date());
				organizationStructureService.insert(sysOrganizationStructure);
			}
		}

		if (updated != null) {
		 
			JSONArray jsonArray = JSONArray.fromObject(updated);
			List<SysOrganizationStructure> listUpdated = (List<SysOrganizationStructure>) JSONArray
					.toCollection(jsonArray, SysOrganizationStructure.class);
			for (SysOrganizationStructure sysOrganizationStructure : listUpdated) {
				sysOrganizationStructure.setCreateTime(new Date());
				organizationStructureService.update(sysOrganizationStructure);
			}
		}
		return "success";
	}
	
	
	@RequestMapping(value = "/delete.do")
	public @ResponseBody String del(String id){ 
		
		if(id == null || "".equals(id))
			return "no found";
		
		
	
        return   organizationStructureService.delete(Integer.parseInt(id)) ;
	}
	
	
}
