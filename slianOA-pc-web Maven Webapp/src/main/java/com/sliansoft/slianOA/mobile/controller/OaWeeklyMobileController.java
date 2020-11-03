package com.sliansoft.slianOA.mobile.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaWeekly;
import com.sliansoft.slianOA.service.OaWeeklyService;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value = "/mobile-ajax/auth/oaWeekly")
public class OaWeeklyMobileController {

	@Autowired
	private OaWeeklyService weeklyService;
	
	@RequestMapping(value="insert.do")
	public @ResponseBody Object insert(HttpServletRequest req) throws ParseException{
		String title = req.getParameter("title");
		String content = req.getParameter("aflReason");
		String creator = req.getParameter("creator");
		String sid = req.getParameter("id");
		int id = 0;
		
		Date timenow = new Date();
		try{
			title = URLDecoder.decode(title,"utf-8");
			content = URLDecoder.decode(content,"utf-8");
			creator = URLDecoder.decode(creator,"utf-8");
			sid = URLDecoder.decode(sid,"utf-8");
			id = Integer.parseInt(sid);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		OaWeekly wk = new OaWeekly();
		//未用属性，创建者id，创建者名字
		wk.setCreateTime(timenow);
		wk.setContent(content);
		wk.setTitle(title);
		wk.setCreator(creator);
		wk.setEmployeeId(id);
		wk.setWeeklyStatus("未读");
		//wk.setWeeklyId(16);
		System.out.println(wk.getContent()+"  "+wk.getCreator()+"  "+wk.getTitle()+"  "+
		wk.getEmployeeId()+"  "+wk.getCreateTime()+"  "+wk.getAccessGroup());
		
		
		String res = weeklyService.insert(wk);
		return res;
	}
	
}
