package com.slianOAsys.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slianOAsys.model.SlianoaClass;
import com.slianOAsys.model.SlianoaClassEmployee;
import com.slianOAsys.service.ClassService;
import com.slianOAsys.service.DepartmentService;
import com.slianOAsys.service.ClassEmployeeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/class")
public class ClassController {
	
	@Autowired
	private ClassService ClassService;
	@Autowired
	private DepartmentService DepartmentService;
	@Autowired
	private ClassEmployeeService ClassEmployeeService;
	@RequestMapping(value = "/list.do")
	public @ResponseBody
	Object list(HttpServletRequest req) throws ParseException {
		Integer pageSize = 10;
		Integer pageIndex = Integer.parseInt(req.getParameter("pageindex"));
		String  classname=req.getParameter("classname");
		String createstarttime=req.getParameter("createstarttime");
		String createendtime=req.getParameter("createendtime");
		String classstatus=req.getParameter("classstatus");
		return JSONObject.fromObject( ClassService.getClass(classname,createstarttime,createendtime,classstatus,pageSize,pageIndex));	
	}
	@RequestMapping(value = "/getClassByid.do")
	public @ResponseBody
	Object getClassById(HttpServletRequest req){
		int  classid= Integer.parseInt(req.getParameter("classid"));
		return  ClassService.getClassById(classid);	
	}
	@RequestMapping(value = "/forbidden.do")
	public @ResponseBody
	Object forbidden(HttpServletRequest req){
		int  classid= Integer.parseInt(req.getParameter("classid"));
		String classstatus=req.getParameter("classststus");
		SlianoaClass classes = new SlianoaClass();
		classes.setClassId(classid);
		classes.setClassStatus(classstatus);
		return  ClassService.update(classes);
	}
	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req){
		String[] classesid = req.getParameterValues("classid[]");
		for(int i=0;i<classesid.length;i++){
        	int classid=Integer.parseInt(classesid[i]);
        	ClassService.delete(classid);
        }
		return classesid.length;
	}
	@RequestMapping(value = "/update.do")
	public @ResponseBody
	Object update(HttpServletRequest req) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		Integer classid = Integer.parseInt(req.getParameter("classid"));
		String classname = req.getParameter("classname");
		String description = req.getParameter("description");
		String start= req.getParameter("starttime");          
		String end= req.getParameter("endtime");    
		 
	    Date starttime = sdf.parse(start); 
	    Date endtime = sdf.parse(end); 
			SlianoaClass classes = new SlianoaClass();
			classes.setClassId(classid);
			classes.setClassName(classname);
			classes.setDescription(description);
			classes.setStartTime(starttime);
			classes.setEndTime(endtime);
			return ClassService.update(classes);
		
	}
	@RequestMapping(value = "/insert.do")
	public @ResponseBody
	String insert(HttpServletRequest req) throws ParseException {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String insert_or_update=req.getParameter("insert_or_update");
		String classname = req.getParameter("classname");
		String starttime= req.getParameter("starttime");          
		String endtime= req.getParameter("endtime"); 
		String description = req.getParameter("description");
		String signaddress = req.getParameter("signaddress");
		float longitude=Float.parseFloat(req.getParameter("longitude"));          
		float latitude=Float.parseFloat(req.getParameter("latitude")); 
		int scope =Integer.parseInt( req.getParameter("scope"));
		String signinstart = req.getParameter("signinstart");
		String signinend= req.getParameter("signinend");          
		String signoffstart= req.getParameter("signoffstart"); 
		String signoffend = req.getParameter("signoffend");
		int ismonday =Integer.parseInt( req.getParameter("ismonday"));
		int istuesday= Integer.parseInt(req.getParameter("istuesday"));          
		int iswednesday=Integer.parseInt( req.getParameter("iswednesday")); 
		int isthursday =Integer.parseInt( req.getParameter("isthursday"));
		int isfriday=Integer.parseInt( req.getParameter("isfriday"));          
		int issaturday=Integer.parseInt( req.getParameter("issaturday")); 
		int issunday = Integer.parseInt(req.getParameter("issunday"));
		String classstatus = req.getParameter("classstatus");
		
		DateFormat df = new SimpleDateFormat("HH:MM");
		Date startTime=df.parse(starttime);
		Date endTime=df.parse(endtime);
		Date signinStart=df.parse(signinstart);
		Date signinEnd=df.parse(signinend);
		Date signoffStart=df.parse(signoffstart);
		Date signoffEnd=df.parse(signoffend);
	//	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date createtime=new Date();
		
		SlianoaClass classes = new SlianoaClass();
		classes.setClassName(classname);
		classes.setStartTime(startTime);
		classes.setEndTime(endTime);
		classes.setDescription(description);
		classes.setSignAddress(signaddress);
		classes.setLongitude(longitude);
		classes.setLatitude(latitude);
		classes.setScope(scope);
		classes.setSigninStart(signinStart);
		classes.setSigninEnd(signinEnd);
		classes.setSignoffStart(signoffStart);
		classes.setSignoffEnd(signoffEnd);
		classes.setIsMonday(ismonday);
		classes.setIsTuesday(istuesday);
		classes.setIsWednesday(iswednesday);
		classes.setIsThursday(isthursday);
		classes.setIsFriday(isfriday);
		classes.setIsSaturday(issaturday);
		classes.setIsSunday(issunday);
		classes.setClassStatus(classstatus);
		classes.setCreateTime(createtime);
		if(insert_or_update.equals("update")){
			int update_classid =Integer.parseInt( req.getParameter("update_classid"));
			classes.setClassId(update_classid);
			ClassService.update(classes);
		//	return "成功更新班次";
		}
		else if(insert_or_update.equals("insert")){
			ClassService.insert(classes);
			int classid=classes.getClassId();
			 String[] department=req.getParameterValues("department[]");
			 //ajax传数组参数不能为空
			 if(department!=null){
			        for(int i=0;i<department.length;i++){
			        	int departId=Integer.parseInt(department[i]);
			        	List<Integer> employeeid=DepartmentService.getEmployeeIdByDepartId(departId);
			        	for(int j=0;j<employeeid.size();j++){
			        		SlianoaClassEmployee slianoaClassEmployee=new SlianoaClassEmployee();
			        		slianoaClassEmployee.setClassId(classid);
			        		slianoaClassEmployee.setEmployeeId(employeeid.get(j));
			        		slianoaClassEmployee.setDepartId(departId);
			        		ClassEmployeeService.insert(slianoaClassEmployee);
			        	}
			        }
			 }
			 String[] addDate=req.getParameterValues("addDate[]");
			 if(addDate!=null){
				 for(int j=0;j<addDate.length;j++){
		        		ClassService.insertAddUnattendanceDays(classid,addDate[j]);
		        	}
			 }
			 String[] deleteDate=req.getParameterValues("addDate[]");
			 if(deleteDate!=null){
				 for(int j=0;j<deleteDate.length;j++){
		        		ClassService.insertDeleteUnattendanceDays(classid,deleteDate[j]);
		        	}
			 }
		}
		return "成功操作";
	}

}
