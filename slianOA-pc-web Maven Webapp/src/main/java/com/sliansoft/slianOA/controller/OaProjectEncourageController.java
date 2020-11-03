

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

import com.sliansoft.slianOA.dataaccess.model.OaProjectEmployee;
import com.sliansoft.slianOA.service.OaProjectEncourageService;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;


/**
 * @author sliansoft.com 2017年3月23日 上午11:29:27
 */
@Controller
@RequestMapping(value = "/oaProjectEncourage")
public class OaProjectEncourageController {
	@Autowired
	private OaProjectEncourageService oaProjectEncourageService;
	
	@RequestMapping(value = "/list.do")
	public @ResponseBody Object projectEmployeeList(HttpServletRequest req) {
		// 注册时间转换器，处理传入的JSON数据中的日期格式///目前没用
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");//
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaProjectEncourageService.getByPage(keys, pageSize, pageIndex);
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

		String projectEmployee = req.getParameter("projectEmployee");
		System.out.println(projectEmployee);
		
		if (StringUtils.isEmpty(projectEmployee)){
			//
			return "false";
		}
		return oaProjectEncourageService.insert(this.convert(projectEmployee));

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
		
		String basicEncourageUpdate = req.getParameter("basicEncourageUpdate");
		
		if (StringUtils.isEmpty(basicEncourageUpdate)){
			//System.out.println("controller中数据:"); 说明不为空
			return "false";
		}
		System.out.println("执行不的？"+basicEncourageUpdate); //传过来的数据是对的
		return oaProjectEncourageService.update(this.convert(basicEncourageUpdate));
	}
	
	private  OaProjectEmployee convert(String basicEncourageUpdate){
		
		JSONObject employee = JSONObject.fromObject(basicEncourageUpdate);
		JSONArray jsonArray = JSONArray.fromObject(employee);
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
		return oaProjectEncourageService.deleteById(Ids);
	}
	
	@RequestMapping(value="/updateForm.do")
	public @ResponseBody 
	Object updateForm(HttpServletRequest req){
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return null;//attendanceService.deleteById(Ids);
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
			oaProjectEncourageService.exportExcel(keys, out);
			out.close();
			System.out.println("excel out");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
  	}
}
