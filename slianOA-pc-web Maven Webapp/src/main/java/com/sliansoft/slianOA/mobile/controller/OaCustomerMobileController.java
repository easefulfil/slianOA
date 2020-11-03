package com.sliansoft.slianOA.mobile.controller;

import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.SysCustomer;
import com.sliansoft.slianOA.service.CustomerService;
import com.sliansoft.slianOA.service.httpModels.HttpCustomer;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping(value="/mobile-ajax/auth/customer")
public class OaCustomerMobileController {

	@Autowired
	private CustomerService  customerService;
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value="list.do")
	public @ResponseBody Object getList(HttpServletRequest req){
		
		int pageSize = 15;
		int pageNow = Integer.parseInt(req.getParameter("pageNow"));
		String keys = req.getParameter("keys");
		
		try {

			keys = URLDecoder.decode(keys, "utf-8");

		}
		catch (Exception e) {

			e.printStackTrace();

		}
		
		System.out.println("keys:"+keys);
		JSONObject obj = JSONObject.fromObject(keys);
		HttpCustomer customer = new HttpCustomer();
		if(obj.containsKey("name")){
			customer.setCustomerName(obj.getString("name"));
		}
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		return JSONObject.fromObject(customerService.getCusByPage(
				customer, pageSize, pageNow),config);
	}
	
	@RequestMapping(value="save.do")
	public @ResponseBody Object insert(HttpServletRequest req){
		
		SysCustomer c = new SysCustomer();
		
		String keys = req.getParameter("keys");
		
		try {

			keys = URLDecoder.decode(keys, "utf-8");

		}
		catch (Exception e) {

			e.printStackTrace();

		}
		System.out.println("这里是insert"+keys);
		JSONObject obj = JSONObject.fromObject(keys);
		c = (SysCustomer)obj.toBean(obj, SysCustomer.class);
		
		return customerService.insert(c);
	}
	
	@RequestMapping(value="getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		int id = Integer.parseInt(req.getParameter("id"));
		

		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		return JSONObject.fromObject(customerService.getCustomer(id),config);
	}
}
