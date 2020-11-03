package com.sliansoft.slianOA.mobile.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.service.AnalysisService;

@Controller
@RequestMapping(value="/mobile-ajax/auth/analysisController")
public class AnalysisController {

	@Autowired
	private AnalysisService analysisService;
	
	@RequestMapping(value="/document.do")
	public @ResponseBody Object analysisDocuments(HttpServletRequest req){
		
		String type = req.getParameter("type");
		//String date = req.getParameter("date");
		//String state = req.getParameter("state");
		String wechat = req.getParameter("wechatAccount");
		String start = req.getParameter("startDate");
		String end = req.getParameter("endDate");
		
		//System.out.println(type+" "+end+" "+start);
		
		end = StringUtils.isEmpty(end)==true?null:end;
		start = StringUtils.isEmpty(start)==true?null:start;
		
		return analysisService.getDocumentsPC(type, start, end);
	}
	
	@RequestMapping(value="/meetingTrain.do")
	public @ResponseBody Object analysisMeetingTrain(HttpServletRequest req){
		
		String type = req.getParameter("type");
		String start = req.getParameter("startDate");
		String end = req.getParameter("endDate");
		
		String wechat = req.getParameter("wechatAccount");
		
		end = StringUtils.isEmpty(end)==true?null:end;
		start = StringUtils.isEmpty(start)==true?null:start;
		
		return analysisService.getMeetingPC(type, start, end);
	}
	
//	@RequestMapping(value="/complaint.do")
//	public @ResponseBody Object analysisComplaint(HttpServletRequest req){
//		
//		String date = req.getParameter("date");
//		String wechat = req.getParameter("wechatAccount");
//		String start = date+"-01";
//		String end = date+"-31";
//		System.out.println(start+" "+end);
//		String keys = "{'startDate':"+start+",'endDate':"+end+"}";
//		System.out.println(date+" "+" "+wechat);
//		return analysisService.getComplaint(keys);
//	}
	
	@RequestMapping(value="/attendance.do")
	public @ResponseBody Object analysisAttendance(HttpServletRequest req){
		
		String start = req.getParameter("startDate");
		String end = req.getParameter("endDate");
		String wechat = req.getParameter("wechatAccount");
//		String start = date+"-01";
//		String end = date+"-31";
		System.out.println(start+" "+end);
		String keys;
		if(start.equals(" ") && end.equals("")){
			keys="{}";
		}else if(start.equals(" ")){
			keys = "{'endDate':'"+end+"'}";
		}else if(end.equals(" ")){
			keys = "{'startDate':'"+start+"'}";
		}else{
			keys = "{'startDate':'"+start+"','endDate':'"+end+"'}";
		}
		
		System.out.println(keys);
//		System.out.println(date+" "+" "+wechat);
		return analysisService.getAttendance(keys);
	}
	

	/**
	 * 
	   * 投诉统计
	   * @param req
	   * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/complaint.do")
	public @ResponseBody Object analysisComplaint(HttpServletRequest req) throws ParseException{
		
		String start = req.getParameter("startDate");
		String end = req.getParameter("endDate");
		String wechat = req.getParameter("wechatAccount");
//		String start = date+"-01";
//		String end = date+"-31";
		System.out.println(start+" "+end);
		String keys;
		if(start.equals(" ") && end.equals("")){
			keys="{}";
		}else if(start.equals(" ")){
			keys = "{'endDate':'"+end+"'}";
		}else if(end.equals(" ")){
			keys = "{'startDate':'"+start+"'}";
		}else{
			keys = "{'startDate':'"+start+"','endDate':'"+end+"'}";
		}
		
		System.out.println(keys);
//		System.out.println(date+" "+" "+wechat);
		return analysisService.getComplaint(keys);
	}

}
