package com.slianOAsys.sysadmin.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slianOAsys.model.SysEmployee;
import com.slianOAsys.model.ex.SysEmployeeEx;
import com.slianOAsys.service.SysEmployeeService;
import com.slianOAsys.service.utils.DateHandler;
import com.slianOAsys.service.utils.DateJsonValueProcessor;
import com.slianOAsys.service.utils.DateMorpherEx;

@Controller
@RequestMapping(value="/employee")
 
public class SysEmployeeController {

	@Autowired
	private SysEmployeeService employeeService;
	
	@RequestMapping(value = "/listAll.do")
	public @ResponseBody Object listAll(HttpServletRequest req, SysEmployee employee) {
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
	
 		return  JSONArray.fromObject(employeeService.getEmployees(),config);
	}

	@RequestMapping(value = "/list.do")
	public @ResponseBody Object list(HttpServletRequest req, SysEmployeeEx employee) {
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageNow = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = employeeService.getEmployeeByPage(employee,
				pageSize, pageNow);
 		return JSONObject.fromObject(map);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save.do")
	public @ResponseBody
	String save(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String deleted = req.getParameter("deleted");
		String inserted = req.getParameter("inserted");
		String updated = req.getParameter("updated");

//		JSONUtils.getMorpherRegistry().registerMorpher(  
//	               new DateMorpherEx(new String[] { "yyyy-MM-dd" },(Date)null));
		if (inserted != null) {
			 
			JSONArray jsonArray = JSONArray.fromObject(inserted);
			List<SysEmployee> listInserted = (List<SysEmployee>) JSONArray
					.toCollection(jsonArray, SysEmployee.class);
			for (SysEmployee employee : listInserted) {
//				employee.setEmployeeCreationTime(new Date());
				return employeeService.insert(employee);
			}
		}

		if (updated != null) {
		 
			JSONArray jsonArray = JSONArray.fromObject(updated);
			List<SysEmployee> listUpdated = (List<SysEmployee>) JSONArray
					.toCollection(jsonArray, SysEmployee.class);
			for (SysEmployee employee : listUpdated) {
//				employee.setEmployeeCreationTime(new Date());
				return employeeService.update(employee);
			}
		}
		return "false";
	} 
	
      @RequestMapping(value = "/delete.do")
	public @ResponseBody String delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] cIds= ids.split(",");
	
        return   employeeService.deleteEmpById(cIds) ;
        
   }
      
    @RequestMapping(value = "/exportExcel.do")
  	public void exportExcel(HttpServletRequest request,HttpServletResponse response ) {
  	
//  		File file = new File(getServletContext().getRealPath("WEB-INF/book.jpg"));

  		 String excelFileName;
		try {
			excelFileName = new String(("å‘˜å·¥ä¿¡æ¯"+DateHandler.dateToStr(new Date(),"yyyyMMddhhmmss")+".xls").getBytes("gb2312"), "ISO8859-1" );
			
			 response.setContentType("octets/stream");
	  	      response.addHeader("Content-Disposition", "attachment;filename="+excelFileName);
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
  		 
		
		String queryPara = request.getParameter("queryPara");
		
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },
						(Date) null));
		
		SysEmployeeEx sysEmployeeEx  = (SysEmployeeEx)JSONObject.toBean(JSONObject.fromObject(queryPara),SysEmployeeEx.class);
	
  	     
  	      try {

  	    	  
  	         OutputStream out = response.getOutputStream();
  	         employeeService.exportExcel(sysEmployeeEx, out);
  	         out.close();
  	         System.out.println("excelï¿½ï¿½ï¿½ï¿½ï¿½É¹ï¿½ï¿½ï¿½");
  	      } catch (FileNotFoundException e) {
  	         // TODO Auto-generated catch block
  	         e.printStackTrace();
  	      } catch (IOException e) {
  	         // TODO Auto-generated catch block
  	         e.printStackTrace();
  	      }
  		
  	}
    
	@RequestMapping(value = "/getByEmployeeName.do")
	public @ResponseBody Object getByCustomerName(String employeeName) {


//		String customerName = req.getParameter("customerName");
		
		if(StringUtils.isEmpty(employeeName))
			return null;


		return JSONObject.fromObject(employeeService.getByCustomerName(employeeName));

	}
	
	@RequestMapping(value = "/getByCellPhone.do")
	public @ResponseBody Object getByCellPhone(String cellPhone) {


//		String customerName = req.getParameter("customerName");
		
		if(StringUtils.isEmpty(cellPhone))
			return null;


		return JSONObject.fromObject(employeeService.getByCellPhone(cellPhone));

	}
	
}