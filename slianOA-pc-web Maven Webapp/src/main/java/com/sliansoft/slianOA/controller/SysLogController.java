package com.sliansoft.slianOA.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.service.LogService;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
//
//import com.mz3co.pcbas.analysis.utils.ValidateCodeUtil;
//import com.mz3co.pcbas.service.LogService;
//import com.mz3co.pcbas.service.utils.DateJsonValueProcessor;
//import com.mz3co.pcbas.service.utils.DateMorpherEx;

/**
 * 
 * @author WCS
 * 
 */
@Controller
@RequestMapping(value = "/log")
public class SysLogController {

	@Autowired
	private LogService logService;

	@RequestMapping(value = "/list.do")
	public @ResponseBody
	Object list(HttpServletRequest req) {

		String keys = req.getParameter("keys");

		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		//System.out.println(logService.getLogsByPage(keys, pageSize,pageIndex).get("rows").toString());
		//return JSONObject.fromObject(logService.getLogsByPage(keys, pageSize,pageIndex));
		return logService.getLogsByPage(keys, pageSize,pageIndex);
		
	}
	
	@RequestMapping(value = "/getLogs.do")
	public @ResponseBody
	Object getLogs(String keys) {
		// List<Resources> list= resourcesService.getTreegrid(id);

		// 注册时间转换器，处理传入的JSON数据中的日期格式

		// 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:ss:mm"));

		return JSONArray.fromObject(logService.getLogs(keys),config);
	}
	
	@RequestMapping(value = "/doLog.do", consumes = "application/json")
	public @ResponseBody
	Object doLog(HttpServletRequest req) {
		String message = req.getParameter("message");
		String operation = req.getParameter("operation");
		switch (operation){
		case "checkQuotationDetail":
			System.out.println(message);
			logService.checkQuotationDetail(message);
			break;
		case "sendPriceInspection":
			System.out.println(message);
			logService.sendPriceInspection(message);
			break;
		case "sendRouteTemplateMSG":
			System.out.println(message);
			logService.sendRouteTemplateMSG(message);
		default:
			break;
		}	
		return 1;
	}

}
