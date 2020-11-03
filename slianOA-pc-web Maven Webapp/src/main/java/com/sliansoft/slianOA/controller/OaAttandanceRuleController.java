/**
 * 
 */

package com.sliansoft.slianOA.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaAttendanceRule;
import com.sliansoft.slianOA.service.OaAttendanceRuleService;
import com.sliansoft.slianOA.service.utils.Const;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;


@Controller
@RequestMapping(value = "/oaAttendanceRule")
public class OaAttandanceRuleController {

	@Autowired
	private OaAttendanceRuleService attendanceRuleService;
	
	
	
	@RequestMapping(value = "/listALL.do")
	public @ResponseBody
	Object listALL(HttpServletRequest req) {
		Set ruleIds = Const.ATTENDANCE_RULE_MAP.keySet();
		
		if(ruleIds == null)
			return null;
		
		Iterator it  = ruleIds.iterator();
		
		List ruleList = new ArrayList(); 
		
		while(it.hasNext()){
			
			Map  map = new HashMap();
			Integer key =  (Integer)it.next();
			
			map.put("attendanceRuleId",key);
			map.put("attendName", Const.ATTENDANCE_RULE_MAP.get(key));
			
			ruleList.add(map);
		}

		return 	JSONArray.fromObject(ruleList);
	}

	
	
	/*
	 * 根据attendanceRuleId获取文件办理内容
	 */
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		String attendanceRuleId = req.getParameter("attendanceRuleId");
		OaAttendanceRule attendanceRule = attendanceRuleService.getById(attendanceRuleId);
		System.out.println(attendanceRuleId);
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		return JSONObject.fromObject(attendanceRule,config);
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

		Map<String, Object> map = attendanceRuleService.getByPage(keys, pageSize,
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

		String attendanceRuleInfo = req.getParameter("insert");

		if (StringUtils.isEmpty(attendanceRuleInfo))
			return "false";

		return attendanceRuleService.insert(this.convert(attendanceRuleInfo));

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
		
		String attendanceRuleInfo = req.getParameter("update");

		if (StringUtils.isEmpty(attendanceRuleInfo))
			return "false";
		
		return attendanceRuleService.update(this.convert(attendanceRuleInfo));
	}
	
	private  OaAttendanceRule convert(String attendanceRuleInfo ){
		
		JSONObject info = JSONObject.fromObject(attendanceRuleInfo);
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaAttendanceRule> listUpdated = (List<OaAttendanceRule>) JSONArray.toCollection(
				jsonArray, OaAttendanceRule.class);
		for (OaAttendanceRule attendanceRule : listUpdated) {
			
			return attendanceRule;
		}
		
		return null;
	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return attendanceRuleService.deleteById(Ids);
	}
	
	

}
