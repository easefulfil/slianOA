

package com.sliansoft.slianOA.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

import com.sliansoft.slianOA.dataaccess.model.OaProjectEmployee;
import com.sliansoft.slianOA.service.OaProjectEmployeeService;
import com.sliansoft.slianOA.service.httpModels.HttpJson;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;
import com.sliansoft.slianOA.utils.SysConst;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

/*import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;*/


/**
 * @author sliansoft.com 2017年3月23日 上午11:29:27
 */
@Controller
@RequestMapping(value = "/oaProjectEmployee")
public class OaProjectEmployeeController {
	@Autowired
	private OaProjectEmployeeService oaProjectEmployeeService;
	
//	@RequestMapping(value = "/list.do")
//	public @ResponseBody Object projectEmployeeList(HttpServletRequest req) {
//		// 注册时间转换器，处理传入的JSON数据中的日期格式///目前没用
//		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));
//
//		String keys = req.getParameter("keys");//
//		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
//		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
//		Map<String, Object> map = oaProjectEmployeeService.getByPage(keys, pageSize, pageIndex);
//		return JSONObject.fromObject(map);
//	}


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

		String projectEmployee = req.getParameter("projectEmployee");
		String projectId = req.getParameter("projectId");
		
		
		
	//	System.out.println(projectEmployee);
		
		if (StringUtils.isEmpty(projectEmployee)){
			//
			return "false";
		}
		
		OaProjectEmployee pe = this.convert(projectEmployee);
		
		pe.setProjectId(Integer.parseInt(projectId));
		
		return oaProjectEmployeeService.insert(pe);// .insert(this.convert(projectEmployee));

	}
	
	@RequestMapping(value = "/listByProjectId.do")
	public @ResponseBody Object listByProjectId(HttpServletRequest req) {
		// 注册时间转换器，处理传入的JSON数据中的日期格式///目前没用
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		//String keys = req.getParameter("keys");//
		String projectId = req.getParameter("projectId");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaProjectEmployeeService.getByPage(projectId, pageSize, pageIndex);
		return JSONObject.fromObject(map);
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
		
		String basicInfoUpdate = req.getParameter("basicInfoUpdate");
		
		if (StringUtils.isEmpty(basicInfoUpdate)){
			//System.out.println("controller中数据:"); 说明不为空
			return "false";
		}
		//System.out.println("执行不的？"+basicInfoUpdate); 传过来的数据是对的
		return oaProjectEmployeeService.update(this.convert(basicInfoUpdate));
	}
	
	private  OaProjectEmployee convert(String basicInfoUpdate){
		
		JSONObject info = JSONObject.fromObject(basicInfoUpdate);
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaProjectEmployee> listUpdated = (List<OaProjectEmployee>) JSONArray.toCollection(
				jsonArray, OaProjectEmployee.class);
		for (OaProjectEmployee oaProjectEmployee : listUpdated) {			
			return oaProjectEmployee;
		}		
		return null;
	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return oaProjectEmployeeService.deleteById(Ids);
	}
	
	@RequestMapping(value="/updateForm.do")
	public @ResponseBody 
	Object updateForm(HttpServletRequest req){
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return null;//attendanceService.deleteById(Ids);
	}
	
	@RequestMapping(value="/updateCombobox.do")
	public @ResponseBody 
	JSONArray updateCombobox(HttpServletRequest req,HttpServletResponse response){
		//Array<String> projectName = req.getParameter("projectName");
		
		List<String> data = new ArrayList<String>();
		data.addAll(SysConst.PROJECT_EMPLOYEE_MAP.keySet());
		
		//List<GPinfo> data = gPinfoService.selectManager();  
		 JSONArray jsonArr = JSONArray.fromObject(data);
      
       System.out.println(jsonArr);  
        return jsonArr;  
	}
	
	 @RequestMapping(value = "/exportExcel.do")
	  	public void exportExcel(HttpServletRequest request,HttpServletResponse response ) {
//			String scheduleMonth = request.getParameter("scheduleMonth");
		//	String keys = request.getParameter("keys");
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
				oaProjectEmployeeService.exportExcel(out);
				out.close();
				System.out.println("excel out");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	  	}

}
