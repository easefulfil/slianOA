package com.sliansoft.slianOA.mobile.controller;

import java.net.URLDecoder;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaAskForLeave;
import com.sliansoft.slianOA.service.OaAskForLeaveService;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value="/mobile-ajax/auth/oaAskForLeave")
public class OaAskForLeaveMobileController {

	@Autowired
	private OaAskForLeaveService oaAskForLeaveService;
	/*
	 * 请假查询
	 */
	@RequestMapping(value="/list.do")
	public @ResponseBody Object searchAskForLeave(HttpServletRequest req){
		
		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd hh:mm" }, (Date) null));

		int pageNow = Integer.parseInt(req.getParameter("pageNow"));
		int pageSize = 15;
		String keys = req.getParameter("keys");
		
		try{
			keys = URLDecoder.decode(keys, "utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("keys:"+keys);
		// 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, 
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
		
		return JSONObject.fromObject(
				oaAskForLeaveService.getByPage(keys, pageSize, pageNow),config);
	}
	
	/*
	 * 获取请假内容
	 */
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getAflContent(HttpServletRequest req){
		
		String aflId = req.getParameter("aflId");
		
		// 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class, 
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm"));
				
		return JSONObject.fromObject(oaAskForLeaveService.getById(aflId),config);
	}
	
	/*
	 * 请假
	 */
	@RequestMapping(value="/insert.do")
	public @ResponseBody Object askForLeave(HttpServletRequest req) throws ParseException{
		// TODO TYPE STYLE
		String beginTime = req.getParameter("beginTime");
		String endTime = req.getParameter("endTime");
		String reason = req.getParameter("aflReason");
		String type = req.getParameter("aflType"); // 类型
		String title = req.getParameter("title"); // 类型
		String style = req.getParameter("aflStyle"); // ??
		//String registTime = req.getParameter("aflRegistTime");
		
		Date begin = DateHandler.strToDate(beginTime, "yy-MM-dd HH:mm");
		Date end = DateHandler.strToDate(endTime, "yy-MM-dd HH:mm");
		//Date regist = DateHandler.strToDate(registTime, "yy-MM-dd HH:mm");
		
		try{
			reason = URLDecoder.decode(reason, "utf-8");
			title =  URLDecoder.decode(title, "utf-8");
			style = URLDecoder.decode(style, "utf-8");
			type = URLDecoder.decode(type, "utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		OaAskForLeave afl = new OaAskForLeave();
		afl.setBeginTime(begin);
		afl.setEndTime(end);
		afl.setAflReason(reason);
		afl.setTitle(title);
		afl.setAflType(type);
		afl.setAflStyle(style);
		//afl.setAflRegistTime(regist);
		
		String res = oaAskForLeaveService.insert(afl);
		return res;
	}
}
