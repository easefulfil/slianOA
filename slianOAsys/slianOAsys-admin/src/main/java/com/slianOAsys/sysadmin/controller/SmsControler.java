package com.slianOAsys.sysadmin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slianOAsys.service.SmsService;

@Controller
@RequestMapping("/sms")
public class SmsControler {
	@Autowired
	private SmsService smsService;
	
	
	@RequestMapping(value = "/smsSend.do")
	public  @ResponseBody Object  smsSend(HttpServletRequest request){
		
		String mobiles = request.getParameter("mobiles");
		
		String content = request.getParameter("content");
		
		
		return smsService.sendSMS(mobiles, content);
	}

	
}
