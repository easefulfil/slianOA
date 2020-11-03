package com.sliansoft.slianOA.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.service.httpModels.HttpJson;
import com.sliansoft.slianOA.service.ResourcesService;
import com.sliansoft.slianOA.utils.SysConst;
import com.sliansoft.slianOA.dataaccess.model.SysResource;


@Controller
@RequestMapping(value = "/resources")
public class SysResourceController {
	
	@Autowired
	private ResourcesService resourcesService;	
	
	@RequestMapping(value = "/getResources.do")
	public @ResponseBody List<SysResource> getResources(){ 
		//List<Resources> list= resourcesService.getTreegrid(id);
		return SysConst.RESOURCESTREE_UNINCLUDE_BUSINESS.getListResources();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insert.do")
	public @ResponseBody HttpJson insert(
			HttpServletRequest request){ 
		String resourceInfo = request.getParameter("resourceInfo");
		
		JSONArray jsonArray=JSONArray.fromObject("["+resourceInfo+"]");
		List<SysResource> res = (List<SysResource>)JSONArray.toCollection(jsonArray, SysResource.class);
		
		HttpJson j = new HttpJson();
		if(resourcesService.insert(res.get(0))){
			j.setSuccess(true);
			j.setMsg("资源保存成功！");
		}
		else{
			j.setSuccess(false);
			j.setMsg("资源保存成功!");
		}		
		return j;
	}
	
	
	@RequestMapping(value = "/delete.do")
	public @ResponseBody HttpJson del(SysResource res){ 
		
		HttpJson j = new HttpJson();
		
		if(resourcesService.delete(res))
		{
			
			j.setSuccess(true);
			j.setMsg("资源删除成功！");
		}
		else
		{
			j.setSuccess(false);
			j.setMsg("删除失败，可能存在以下原因：1，该资源已分配给角色；2，该资源为父节点；3，数据访问失败。");
		}
		return j;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/update.do")
	public @ResponseBody HttpJson edit(
			HttpServletRequest request){ 
		String resourceInfo = request.getParameter("resourceInfo");
		
		JSONArray jsonArray=JSONArray.fromObject("["+resourceInfo+"]");
		List<SysResource> res = (List<SysResource>)JSONArray.toCollection(jsonArray, SysResource.class);
		
		HttpJson j = new HttpJson();
		resourcesService.update(res.get(0));
		j.setSuccess(true);
		j.setMsg("ok!");
		return j;
	}
	
	
	
	
}
