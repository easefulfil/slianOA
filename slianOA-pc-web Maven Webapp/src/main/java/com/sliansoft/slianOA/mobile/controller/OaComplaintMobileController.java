package com.sliansoft.slianOA.mobile.controller;

import java.net.URLDecoder;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.service.OaComplaintService;
import com.sliansoft.slianOA.service.httpModels.HttpOaComplaint;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value="/mobile-ajax/auth/oaComplaint")
public class OaComplaintMobileController {

	@Autowired
	private OaComplaintService oaComplaintService;
	
	@RequestMapping(value="/list.do")
	public @ResponseBody Object search(HttpServletRequest req){
		
		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));
				
		int pageNow = Integer.parseInt(req.getParameter("pageNow"));
		int pageSize = 15;
		String keys = req.getParameter("keys");
		

			try {

				keys = URLDecoder.decode(keys, "utf-8");

			}
			catch (Exception e) {

				e.printStackTrace();

			}
			System.out.println("keys："+keys);
		
		
		// keys格式: {"docTime":"2017-01-01","type":"发文"}
			JSONObject obj = JSONObject.fromObject(keys);
			if(obj.containsKey("complaintTime")){
				Date startDate = DateHandler.strToDate(obj.get("complaintTime").toString(), "yyyy-MM-dd");
				Date endDate = DateHandler.strToDate(obj.get("complaintTime").toString(), "yyyy-MM-dd");
				startDate = DateHandler.addDay(startDate, -1);
				endDate = DateHandler.addDay(endDate, 1);
				System.out.println(DateHandler.dateToStr(startDate, "yyyy-MM-dd")+DateHandler.dateToStr(endDate, "yyyy-MM-dd"));
				obj.remove("complaintTime");
				obj.put("startDate", DateHandler.dateToStr(startDate, "yyyy-MM-dd"));
				obj.put("endDate", DateHandler.dateToStr(endDate, "yyyy-MM-dd"));
			}
			String nkeys = obj.toString();
			System.out.println("nkeys:"+nkeys);
		Map<String, Object> res = oaComplaintService.getByPage(nkeys, pageSize, pageNow);
		
		return JSONObject.fromObject(res);
		
	}
	
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		String complaintId = req.getParameter("complaintId");
		
		HttpOaComplaint complaint = oaComplaintService.getByIdAndType(Integer.parseInt(complaintId),"UPDATE");
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		return JSONObject.fromObject(complaint,config);
	}
}
