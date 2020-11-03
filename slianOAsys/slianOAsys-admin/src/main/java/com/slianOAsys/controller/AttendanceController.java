package com.slianOAsys.controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.slianOAsys.admin.utils.ExcelTemplateImport;
import com.slianOAsys.model.SlianoaAttendance;
import com.slianOAsys.model.SlianoaClass;
import com.slianOAsys.model.SlianoaClassEmployee;
import com.slianOAsys.service. AttendanceService;

import com.slianOAsys.service. EmployeeService;
import com.slianOAsys.service.utils.DateHandler;
import com.slianOAsys.service.utils.DateMorpherEx;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value = "/attendance")
public class AttendanceController {
	
	@Autowired
	private ExcelTemplateImport excelTemplateImport;
	@Autowired
	private  AttendanceService  AttendanceService;
	@Autowired
	private  EmployeeService  EmployeeService;
	
	@RequestMapping(value = "/list.do")
	public @ResponseBody
	Object list(HttpServletRequest req) {
		Integer pageSize = 10;
		Integer pageIndex = Integer.parseInt(req.getParameter("pageindex"));
		String classname=req.getParameter("classname");
		String employeename=req.getParameter("employeename");
		String attendance_total_status=req.getParameter("attendance_total_status");
		String startdate=req.getParameter("startdate");
		String enddate=req.getParameter("enddate");
		String departname=req.getParameter("departname");
		return JSONObject.fromObject( 
				AttendanceService.getAttendance(employeename,classname,attendance_total_status,startdate,enddate,departname,pageSize,pageIndex));	
	}
	@RequestMapping(value = "/listmonthdays.do")
	public @ResponseBody
	Object listmonthdays(HttpServletRequest req) throws ParseException {
		String startdate=req.getParameter("startdate");
		String enddate=req.getParameter("enddate");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate=df.parse(startdate);
		Date endDate=df.parse(enddate);
		int days = (int) ((endDate.getTime()-startDate.getTime()) / (1000 * 60 * 60 * 24));
		List<String> between=new ArrayList();
		Date temp=startDate;
		for(int i=0;i<days;i++){
			temp=com.slianOAsys.service.utils.DateHandler.addDay(temp,1);
			String between2=com.slianOAsys.service.utils.DateHandler.dateToStr(temp, "yyyy-MM-dd");
			between.add(between2);
		}
		JSONArray betweendate =JSONArray.fromObject(between);
		return betweendate;
	}
	@RequestMapping(value = "/delete1.do")
	public @ResponseBody
	Object delete1(HttpServletRequest req) {
		String[] attendancesid = req.getParameterValues("attendanceid[]");
		for(int i=0;i<attendancesid.length;i++){
        	int attendanceid=Integer.parseInt(attendancesid[i]);
        	AttendanceService.delete1(attendanceid);
        }
		return attendancesid.length;	
	}
	@RequestMapping(value = "/detaillist.do")
	public @ResponseBody
	Object detaillist(HttpServletRequest req) {
		Integer pageSize = 10;
		Integer pageIndex = Integer.parseInt(req.getParameter("pageindex"));
		String signstatus=req.getParameter("signstatus");
		String classname=req.getParameter("classname");
		String employeename=req.getParameter("employeename");
		String attendance_total_status=req.getParameter("attendance_total_status");
		String startdate=req.getParameter("startdate");
		String enddate=req.getParameter("enddate");
		String departname=req.getParameter("departname");
		return JSONObject.fromObject( 
				AttendanceService.getAttendanceDetail(signstatus,employeename,classname,attendance_total_status,startdate,enddate,departname,pageSize,pageIndex));	
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
		String classname=req.getParameter("classname");
		String employeename=req.getParameter("employeename");
		String attendance_total_status=req.getParameter("attendance_total_status");
		String startdate=req.getParameter("startdate");
		String enddate=req.getParameter("enddate");
		String departname=req.getParameter("departname");
		
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },(Date) null));
	//	Meeting meeting  = (Meeting)JSONObject.toBean(JSONObject.fromObject(queryPara),Meeting.class);
  	      try {  
  	         OutputStream out = response.getOutputStream();
  	         AttendanceService.exportExcel(employeename,classname,attendance_total_status,startdate,enddate,departname, out);
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
	
	@RequestMapping(value = "/detailExportExcel.do")
  	public void detailExportExcel(HttpServletRequest req,HttpServletResponse response ) {
		String excelFileName;
		try {
			excelFileName = new String((DateHandler.dateToStr(new Date(),"yyyyMMddhhmmss")+".xls").getBytes("gb2312"), "ISO8859-1" );
			response.setContentType("octets/stream");
	  	    response.addHeader("Content-Disposition", "attachment;filename="+excelFileName);	
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String signstatus=req.getParameter("signstatus");
		String classname=req.getParameter("classname");
		String employeename=req.getParameter("employeename");
		String attendance_total_status=req.getParameter("attendance_total_status");
		String startdate=req.getParameter("startdate");
		String enddate=req.getParameter("enddate");
		String departname=req.getParameter("departname");
		
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },(Date) null));
  	      try {  
  	         OutputStream out = response.getOutputStream();
  	         AttendanceService.detailExportExcel(signstatus,employeename,classname,attendance_total_status,startdate,enddate,departname, out);
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
	
	@RequestMapping(value = "/monthlist.do")
	public @ResponseBody
	Object monthlist(HttpServletRequest req) throws ParseException {
		Integer pageSize = 10;
		Integer pageIndex = Integer.parseInt(req.getParameter("pageindex"));
		String employeeName=req.getParameter("employeeName");
		String departName=req.getParameter("departName");
		String className=req.getParameter("className");
		String start=req.getParameter("startdate");
		String end=req.getParameter("enddate");
		
	//	return JSONObject.fromObject( AttendanceService.getAttendanceMonth(className,start,end,employeeName,departName,pageSize,pageIndex));	
	//	EmployeeService.getAttendanceMonth(className, start, end, employeeName, departName, pageSize, pageIndex);
		
//		EmployeeService.getAttendanceMonth(className,start,end,employeeName,departName,pageSize,pageIndex);
		return EmployeeService.getAttendanceMonth(className,start,end,employeeName,departName,pageSize,pageIndex);
	}
	/*
	@RequestMapping(value = "/betweendate.do")
	public @ResponseBody
	Object betweendate(HttpServletRequest req) throws ParseException {
		String start=req.getParameter("start");
		String end=req.getParameter("end");
		System.out.println("~~~~~~~~~~~~~~~~~`");
		System.out.println("start"+start);
		System.out.println("end"+end);
		System.out.println("~~~~~~~~~~~~~~~~~`");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startdate=df.parse(start);
		Date enddate=df.parse(end);
		int days = (int) ((enddate.getTime()-startdate.getTime()) / (1000 * 60 * 60 * 24));
		String[] between = null;
		Date temp=startdate;
		for(int i=0;i<days;i++){
			temp=com.slianOAsys.service.utils.DateHandler.addDay(temp,1);
			String between2=com.slianOAsys.service.utils.DateHandler.dateToStr(temp, "yyyy-MM-dd");
		}
		System.out.println("~~~~~~~~~~~~~~~~~`");
		System.out.println("between"+between);
		System.out.println("~~~~~~~~~~~~~~~~~`");
		JSONArray betweendate =JSONArray.fromObject(between);
		return betweendate;
		
	}
	*/
	@RequestMapping(value = "/update.do")
	public @ResponseBody
	Object update(HttpServletRequest req) throws ParseException {
		Integer accendanceid = Integer.parseInt(req.getParameter("attendanceid"));
		String attendanceSignstatus = req.getParameter("attendanceSignstatus");
		String attendanceOffstatus = req.getParameter("attendanceOffstatus");  
		 
	   
			SlianoaAttendance accendance = new SlianoaAttendance();
			accendance.setAttendanceId(accendanceid);
			accendance.setAttendanceSignstatus(attendanceSignstatus);
			accendance.setAttendanceOffstatus(attendanceOffstatus);
			return AttendanceService.update(accendance);
		
	}
	
	@RequestMapping(value = "/importExcel.do", method = RequestMethod.POST)
    public String importSalaryExcel(
            @RequestParam("clientFile") MultipartFile clientFile,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
    	request.setCharacterEncoding("UTF-8");//你的编码格式
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out = response.getWriter();
//        String type=request.getParameter("type");
        if(clientFile.isEmpty()) {

            out.println("文件为空，提交失败");
            out.flush();
            out.close()	;
            return "文件为空，提交失败";
        }
        String templateFile = request.getSession().getServletContext().getRealPath("/").replace("slianOAsys-admin","slianOAsys-web")+"/excel-format/"+"excel1.xml";
        String result = excelTemplateImport.importExcel(clientFile, templateFile);
   //   HttpRequest.sendPost(sendMessageUrl,"type=2" );//薪水导入成功
        System.out.println("url");
        out.println(result);
        out.flush();
        out.close();
        
        return result;
    }
	
}
