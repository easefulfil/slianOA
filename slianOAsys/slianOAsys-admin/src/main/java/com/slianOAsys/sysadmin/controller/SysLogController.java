package com.slianOAsys.sysadmin.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slianOAsys.service.SysLogService;
import com.slianOAsys.service.utils.DateJsonValueProcessor;

/**
 * 
 * @author WCS
 * 
 */
@Controller
@RequestMapping(value = "/log")
public class SysLogController {

	@Autowired
	private SysLogService logService;

	@RequestMapping(value = "/list.do")
	public @ResponseBody
	Object list(HttpServletRequest req) {

		String keys = req.getParameter("keys");

		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		
		return JSONObject.fromObject( logService.getLogsByPage(keys, pageSize,pageIndex));
		
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

}
