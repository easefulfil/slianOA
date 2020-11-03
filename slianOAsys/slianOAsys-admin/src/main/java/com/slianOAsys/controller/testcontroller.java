package com.slianOAsys.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slianOAsys.model.test;
import com.slianOAsys.service.testservice;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/test")
public class testcontroller {
	
	@Autowired
	private testservice testservice;
	@RequestMapping(value = "/list.do")
	public @ResponseBody
	Object list(HttpServletRequest req,test tt) {

		Integer pageSize = 10;
		Integer pageIndex = Integer.parseInt(req.getParameter("pageindex"));
		
		JSONObject obj=JSONObject.fromObject( testservice.getTest(pageSize,pageIndex));
		String total=obj.getString("total");
		String totalPages=obj.getString("totalPages");
		JSONArray rows=obj.getJSONArray("rows");
		return JSONObject.fromObject( testservice.getTest(pageSize,pageIndex));
	//	return rows;
		
	}
}
