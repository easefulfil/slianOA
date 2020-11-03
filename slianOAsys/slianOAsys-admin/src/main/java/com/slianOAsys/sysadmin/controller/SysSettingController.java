package com.slianOAsys.sysadmin.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slianOAsys.model.SysSetting;
import com.slianOAsys.service.SysSettingService;


@Controller
@RequestMapping(value = "/systemsetting") 
public class SysSettingController {
	
	@Autowired
	private SysSettingService systemSettingService;
	
	
	@RequestMapping(value = "/getSystemSetting.do")
	public @ResponseBody List<SysSetting> getSystemSetting(){ 

		return systemSettingService.getSystemSetting();
	}
	
	
	
	@RequestMapping(value = "/save.do")
	public @ResponseBody Object insert(HttpServletRequest req ) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return systemSettingService.insert( req.getParameter("jsonSt"));
	}


}
