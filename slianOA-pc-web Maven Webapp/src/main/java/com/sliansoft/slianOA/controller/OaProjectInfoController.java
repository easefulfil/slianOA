

package com.sliansoft.slianOA.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaProject;
import com.sliansoft.slianOA.service.OaProjectInfoService;
//import com.sliansoft.slianOA.service.OaProjectInfoService;
import com.sliansoft.slianOA.service.httpModels.HttpJson;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;


/**
 * @author sliansoft.com 2017年3月23日 上午11:29:27
 */
@Controller
@RequestMapping(value = "/oaProjectInfo")
public class OaProjectInfoController {
	@Autowired
	private OaProjectInfoService oaProjectInfoService;
	
	@RequestMapping(value = "/listProjectName.do")
	public @ResponseBody Object listProjectName(HttpServletRequest req) {
		// 注册时间转换器，处理传入的JSON数据中的日期格式///目前没用
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		return oaProjectInfoService.getProjectName();
	}
	@RequestMapping(value = "/list.do")
	public @ResponseBody Object projectInfoList(HttpServletRequest req) {
		// 注册时间转换器，处理传入的JSON数据中的日期格式///目前没用
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String projectStatus = null;
		try {
			projectStatus = new String(req.getParameter("projectStatus").getBytes("ISO8859_1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	String projectStatus = req.getParameter("projectStatus");
		String keys = req.getParameter("keys");//
//		System.out.println("ID是多少"+req.getParameter("projectId"));
		System.out.println("项目状态"+projectStatus+"keys"+keys);
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaProjectInfoService.getByPage(keys,projectStatus, pageSize, pageIndex);
		return JSONObject.fromObject(map);
	}
	
	@RequestMapping(value = "/getProjectById.do")
	public @ResponseBody Object getProjectById(HttpServletRequest req) {
		// 注册时间转换器，处理传入的JSON数据中的日期格式///目前没用
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		
		Integer projectId = Integer.parseInt(req.getParameter("projectId"));
		System.out.println("ID是多少"+projectId);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		
		OaProject p = oaProjectInfoService.getOaProjectById(projectId);
		return JSONObject.fromObject(p,config);
	}
	
	@RequestMapping(value = "/listFile.do")
	public @ResponseBody Object projectFileList(HttpServletRequest req) {
		// 注册时间转换器，处理传入的JSON数据中的日期格式///目前没用
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");//
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaProjectInfoService.getFileByPage(keys, pageSize, pageIndex);
		return JSONObject.fromObject(map);
	}


	@Transactional
	@RequestMapping(value = "/insert.do")
	public @ResponseBody
	Object insert(HttpServletRequest req) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String projectInfo = req.getParameter("projectInfo");
		System.out.println(projectInfo);
		
		if (StringUtils.isEmpty(projectInfo)){
			//
			return "false";
		}
		return oaProjectInfoService.insert(this.convert(projectInfo));

	}

	@RequestMapping(value = "/update.do")
	public @ResponseBody
	Object update(HttpServletRequest req) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String basicInfoUpdate = req.getParameter("projectInfoUpdate");
		
		if (StringUtils.isEmpty(basicInfoUpdate)){
			//System.out.println("controller中数据:"); 说明不为空
			return "false";
		}
		//System.out.println("执行不的？"+basicInfoUpdate); 传过来的数据是对的
		return oaProjectInfoService.update(this.convert(basicInfoUpdate));
	}
	
	private  OaProject convert(String basicInfoUpdate){
		
		JSONObject info = JSONObject.fromObject(basicInfoUpdate);
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaProject> listUpdated = (List<OaProject>) JSONArray.toCollection(
				jsonArray, OaProject.class);
		for (OaProject oaProject : listUpdated) {			
			return oaProject;
		}		
		return null;
	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return oaProjectInfoService.deleteById(Ids);
	}
	
	@RequestMapping(value="/updateForm.do")
	public @ResponseBody 
	Object updateForm(HttpServletRequest req){
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return null;//attendanceService.deleteById(Ids);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/updateFile.do")
	public @ResponseBody 
	HttpJson updateFile(HttpServletRequest req){
        
		HttpJson j = new HttpJson();
		
		/*JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" }, (Date) null));*/
		JSONObject joBDS = JSONObject.fromObject(req.getParameter("project"));
		System.out.println(joBDS);
		OaProject oaProject = (OaProject)JSONObject.toBean(joBDS, OaProject.class);
		
		System.out.println("项目的ID"+oaProject.getProjectId());
		
		if(oaProjectInfoService.updateFile(oaProject)){
			j.setSuccess(true);
			j.setMsg("基本信息修改成功！");
		}
		else{
			j.setSuccess(false);
			j.setMsg("基本信息修改失败!");
		}		
		return j;
	}
	@RequestMapping(value = "/exportExcel.do")
  	public void exportExcel(HttpServletRequest request,HttpServletResponse response ) {
//		String scheduleMonth = request.getParameter("scheduleMonth");
		String keys = request.getParameter("keys");
		String excelFileName;
		try {
			excelFileName = new String(
					(DateHandler.dateToStr(new Date(), "yyyyMMddhhmmss") + ".xls").getBytes("gb2312"), "ISO8859-1");
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + excelFileName);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		JSONUtils.getMorpherRegistry()
				.registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" }, (Date) null));
		try {
			OutputStream out = response.getOutputStream();
			oaProjectInfoService.exportExcel(keys, out);
			out.close();
			System.out.println("excel out");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
  	}
	
}
