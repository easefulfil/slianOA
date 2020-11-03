package com.sliansoft.slianOA.mobile.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaAttendanceRule;
import com.sliansoft.slianOA.service.OaAttendanceRuleService;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping(value="/mobile-ajax/auth/oaAttendanceRule")
public class OaAttendanceRuleMobileController {

	@Autowired
	private OaAttendanceRuleService attendanceRuleService;
	/*
	 * 根据attendanceRuleId获取文件办理内容
	 */
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		String attendanceRuleId = req.getParameter("attendanceRuleId");
		OaAttendanceRule attendanceRule = attendanceRuleService.getById(attendanceRuleId);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		return JSONObject.fromObject(attendanceRule,config);
	}
}
