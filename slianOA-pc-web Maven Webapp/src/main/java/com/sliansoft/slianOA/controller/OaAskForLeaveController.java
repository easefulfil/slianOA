/**
 * 
 */

package com.sliansoft.slianOA.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
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

import com.sliansoft.slianOA.dataaccess.model.OaAskForLeave;
import com.sliansoft.slianOA.service.OaAskForLeaveService;
import com.sliansoft.slianOA.service.OaWorkflowService;
import com.sliansoft.slianOA.service.httpModels.HttpOaAskForLeave;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;


@Controller//声明控制器
@RequestMapping(value = "/oaAskForLeave")//声明URL
public class OaAskForLeaveController {

	@Autowired//业务接口注入
	private OaAskForLeaveService askForLeaveService;
	
	
	
	/*
	 * 根据askForLeaveId获取文件办理内容
	 */
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		String askForLeaveId = req.getParameter("aflId");
		System.out.println(askForLeaveId);
		HttpOaAskForLeave askForLeave = askForLeaveService.getById(askForLeaveId);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		
		return JSONObject.fromObject(askForLeave,config);
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

		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd hh:mm" }, (Date) null));
		
		String newsInfo = req.getParameter("insert");

		if (StringUtils.isEmpty(newsInfo))
			return "false";
		return askForLeaveService.insert(this.convert(newsInfo));

	}
	
	private  OaAskForLeave convert(String aflInfo ){
		
		/*JSONObject info = JSONObject.fromObject(aflInfo);
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaAskForLeave> listUpdated = (List<OaAskForLeave>) JSONArray.toCollection(
				jsonArray, OaAskForLeave.class);
		for (OaAskForLeave afl : listUpdated) {
			
			return afl;
		}
		
		return null;*/
		
		JSONObject info = JSONObject.fromObject(aflInfo);
		
		JSONArray jsonArray = JSONArray.fromObject(info);

		for (Object ob : jsonArray) {

			JSONObject jo = (JSONObject)ob;
			
			
			OaAskForLeave omt = (OaAskForLeave) JSONObject.toBean(jo, OaAskForLeave.class);
//			
			//处理前端传过来的时间字段
			omt.setBeginTime(DateHandler.strToDate((String)jo.get("beginTime"), "yyyy-MM-dd HH:mm:ss"));
			omt.setEndTime(DateHandler.strToDate((String)jo.get("endTime"), "yyyy-MM-dd HH:mm:ss"));
			
			
			return omt;
		}

		return null;
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

		String newsInfo = req.getParameter("update");

		if (StringUtils.isEmpty(newsInfo))
			return "false";

		OaAskForLeave oaAskForLeave = this.convert2(newsInfo);
		oaAskForLeave.setType("请假");
		return askForLeaveService.update(oaAskForLeave);
	}

	private OaAskForLeave convert2(String newsInfo) {

		JSONObject info = JSONObject.fromObject(newsInfo);
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaAskForLeave> listUpdated = (List<OaAskForLeave>) JSONArray
				.toCollection(jsonArray, OaAskForLeave.class);
		for (OaAskForLeave askForLeave : listUpdated) {

			return askForLeave;
		}

		return null;
	}
	
	
	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return askForLeaveService.deleteById(Ids);
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

		Map<String, Object> map = askForLeaveService.getByPage(keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}
	@RequestMapping(value = "/list1.do")
	public @ResponseBody
	Object list1(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");

		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = askForLeaveService.getByPage1(keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}

}
