package com.sliansoft.slianOA.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.service.AnalysisService;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value="/analysisController")
public class AnalysisPCController {

	@Autowired
	private AnalysisService analysisService;
	
	@RequestMapping(value="/document.do")
	public @ResponseBody Object analysisDocuments(HttpServletRequest req){
		
		String type = req.getParameter("type");
		//String date = req.getParameter("date");
		//String state = req.getParameter("state");
		//String wechat = req.getParameter("wechatAccount");
		String start = req.getParameter("startDate");
		String end = req.getParameter("endDate");
		
		//System.out.println(type+" "+end+" "+start);
		
		end = StringUtils.isEmpty(end)==true?null:end;
		start = StringUtils.isEmpty(start)==true?null:start;
		
		return analysisService.getDocumentsPC(type, start, end);
	}
	/**
	 * 
	   * 投诉统计
	   * @param req
	   * @return
	 */
	@RequestMapping(value="/complaint.do")
	public @ResponseBody Object analysisComplaint(HttpServletRequest req){
		
		String keys = req.getParameter("keys");
		return analysisService.getComplaint(keys);
	}
	/**
	 * 
	   * 收发文统计
	   * @param req
	   * @return
	 */
	@RequestMapping(value="/meetingTrain.do")
	public @ResponseBody Object analysisMeetingTrain(HttpServletRequest req){
		
		String type = req.getParameter("type");
		String start = req.getParameter("startDate");
		String end = req.getParameter("endDate");
		
		//String wechat = req.getParameter("wechatAccount");
		
		end = StringUtils.isEmpty(end)==true?null:end;
		start = StringUtils.isEmpty(start)==true?null:start;
		
		return analysisService.getMeetingPC(type, start, end);
	}
	@RequestMapping(value="/attendance.do")
	public @ResponseBody Object analysisAttendance(HttpServletRequest req){
		
		String keys = req.getParameter("keys");
/*		String start = date+"-01";
		String end = date+"-31";
		System.out.println(start+" "+end);
		String keys = "{'startDate':"+start+",'endDate':"+end+"}";*/
		return analysisService.getAttendance(keys);
	}
	
	@RequestMapping(value="/exportExcel.do")
	public @ResponseBody void exportExcel(HttpServletRequest req,HttpServletResponse response){
		
		String legend = req.getParameter("legend");
		String series = req.getParameter("series");
		String category = req.getParameter("category");
		String keys = req.getParameter("keys");
		String type = req.getParameter("type");
		String title = req.getParameter("title");
		System.out.println(legend);
		System.out.println(series);
		System.out.println(category);
		System.out.println(keys);
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
			analysisService.exportExcel(legend,series,category,keys,type,title, out);
			out.close();
			System.out.println("excel out");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
