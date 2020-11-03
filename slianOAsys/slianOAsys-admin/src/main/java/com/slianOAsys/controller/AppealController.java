package com.slianOAsys.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slianOAsys.service.AppealService;
import com.slianOAsys.service.utils.DateHandler;
import com.slianOAsys.service.utils.DateMorpherEx;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value = "/appeal")
public class AppealController {
	
	@Autowired
	private  AppealService  AppealService;
	
	@RequestMapping(value = "/list.do")
	public @ResponseBody
	Object list(HttpServletRequest req) {
		Integer pageSize = 10;
		Integer pageIndex = Integer.parseInt(req.getParameter("pageindex"));
		
		String employeename=req.getParameter("employeename");
		String employeewechat=req.getParameter("employeewechat");
		String appeal_status=req.getParameter("appeal_status");
		String startdate=req.getParameter("startdate");
		String enddate=req.getParameter("enddate");
		String departname=req.getParameter("departname");
		return JSONObject.fromObject( 
				AppealService.getAppeal(employeename,departname,employeewechat,appeal_status,startdate,enddate,pageSize, pageIndex));	
	}
	@RequestMapping(value = "/handleEmployeeName.do")
	public @ResponseBody
	JSONObject handleEmployeeName(HttpServletRequest req) {
		int employeeid=Integer.parseInt(req.getParameter("employeeid"));
	//	return AppealService.getEmployeeNameById(employeeid);
		return JSONObject.fromObject( 
				AppealService.getEmployeeNameById(employeeid));
	}
	@RequestMapping(value = "/exportExcel.do")
  	public void exportExcel(HttpServletRequest req,HttpServletResponse response ) {
		String excelFileName;
		try {
			excelFileName = new String((DateHandler.dateToStr(new Date(),"yyyyMMddhhmmss")+".xls").getBytes("gb2312"), "ISO8859-1" );
			response.setContentType("octets/stream");
	  	    response.addHeader("Content-Disposition", "attachment;filename="+excelFileName);	
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String employeename=req.getParameter("employeename");
		String departname=req.getParameter("departname");
		String employeewechat=req.getParameter("employeewechat");
		String appeal_status=req.getParameter("appeal_status");
		String startdate=req.getParameter("startdate");
		String enddate=req.getParameter("enddate");
		
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },(Date) null));
	      try {  
  	         OutputStream out = response.getOutputStream();
  	       AppealService.exportExcel(employeename,departname,employeewechat,appeal_status,startdate,enddate,out);
  	         out.close();
  	         System.out.println("excel out");
  	      } catch (FileNotFoundException e) {
  	         // TODO Auto-generated catch block
  	         e.printStackTrace();
  	      } catch (IOException e) {
  	         // TODO Auto-generated catch block
  	         e.printStackTrace();
  	      }	
  	}
	
}
