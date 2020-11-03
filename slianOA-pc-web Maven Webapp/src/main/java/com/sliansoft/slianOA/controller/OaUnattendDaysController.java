/**
 * 
 */

package com.sliansoft.slianOA.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaUnattendDays;
import com.sliansoft.slianOA.service.OaUnattendDaysService;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;


@Controller
@RequestMapping(value = "/oaUnattendDays")
public class OaUnattendDaysController {

	@Autowired
	private OaUnattendDaysService oaUnAttendDaysService;
	
	
	
	
	
	@RequestMapping(value = "/listALL.do")
	public @ResponseBody
	Object listALL(HttpServletRequest req) {

		// 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
						new DateJsonValueProcessor("yyyy-MM-dd"));// HH:mm:ss

		Map<String, Object> map = new HashMap<String, Object>();
				
			
					

		return 	JSONArray.fromObject(oaUnAttendDaysService.listALL(), config);
	}

	
	
	/*
	 * 根据unattendDaysId获取文件办理内容
	 */
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		String unattendDaysId = req.getParameter("unattendDaysId");
		OaUnattendDays unattendDays = oaUnAttendDaysService.getByKey(unattendDaysId);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		return JSONObject.fromObject(unattendDays,config);
	}

	@RequestMapping(value = "/list.do")
	public @ResponseBody
	Object list(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");

		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaUnAttendDaysService.getByPage(keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}

	@RequestMapping(value = "/insert.do")
	public @ResponseBody
	Object insert(HttpServletRequest req) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String unattendDaysInfo = req.getParameter("insert");

		if (StringUtils.isEmpty(unattendDaysInfo))
			return "false";

		return oaUnAttendDaysService.insert(this.convert(unattendDaysInfo));

	}

	@RequestMapping(value = "/update.do")
	public @ResponseBody
	Object update(HttpServletRequest req) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String unattendDaysInfo = req.getParameter("update");

		if (StringUtils.isEmpty(unattendDaysInfo))
			return "false";
		
		return oaUnAttendDaysService.update(this.convert(unattendDaysInfo));
	}
	
	private  OaUnattendDays convert(String unattendDaysInfo ){
		
		JSONObject info = JSONObject.fromObject(unattendDaysInfo);
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaUnattendDays> listUpdated = (List<OaUnattendDays>) JSONArray.toCollection(
				jsonArray, OaUnattendDays.class);
		for (OaUnattendDays unattendDays : listUpdated) {
			
			return unattendDays;
		}
		
		return null;
	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return oaUnAttendDaysService.deleteById(Ids);
	}

}
