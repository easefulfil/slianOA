package com.slianOAsys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slianOAsys.service.DepartmentService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/department")
public class DepartmentController {
	@Autowired
	private DepartmentService DepartmentService;
	
	@RequestMapping(value = "/list.do")
	public @ResponseBody
	Object list(HttpServletRequest req) {

		Integer pageSize = 10;
		Integer pageIndex = Integer.parseInt(req.getParameter("pageindex"));
		return JSONObject.fromObject( DepartmentService.getDepartment(pageSize,pageIndex));
		
	}
}
