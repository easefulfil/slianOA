package com.sliansoft.slianOA.mobile.controller;

import java.net.URLDecoder;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaMeetingTrain;
import com.sliansoft.slianOA.service.OaMeetingTrainService;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value="/mobile-ajax/auth/oaMeetingTrain")
public class OaMeetingMobileController {

	@Autowired
	private OaMeetingTrainService oaMeetingTrainService;
	
	@RequestMapping(value="/insert.do")
	public @ResponseBody Object insert(HttpServletRequest req){
		
		String mtNumbers = req.getParameter("mtNumbers"); //人数
		String mtSite = req.getParameter("mtSite"); // 地点
		String mtTime = req.getParameter("mtTime"); //开会时间
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String mtJoinPersons = req.getParameter("mtJoinPersons"); // 人名字，手填
		String type = req.getParameter("type");
		//String viewEmployeeIds = req.getParameter("viewEmployeeIds");
		
		try {

			mtSite = URLDecoder.decode(mtSite, "utf-8");
			title = URLDecoder.decode(title, "utf-8");
			content = URLDecoder.decode(content, "utf-8");
			mtJoinPersons = URLDecoder.decode(mtJoinPersons, "utf-8");
			type = URLDecoder.decode(type, "utf-8");

		}
		catch (Exception e) {

			e.printStackTrace();

		}
		
		OaMeetingTrain mt = new OaMeetingTrain();
		mt.setMtNumbers(mtNumbers);
		mt.setMtTime(DateHandler.strToDate(mtTime, "yy-MM-dd HH:mm")); // 24时制
		mt.setMtSite(mtSite);
		mt.setTitle(title);
		mt.setContent(content);
		mt.setMtJoinPersons(mtJoinPersons);
		mt.setType(type);
		//mt.setViewEmployeeIds(viewEmployeeIds); // 转成ids
		String res = oaMeetingTrainService.insert(mt);
		return mt.getMeetingTrainId();
	}
	
	@RequestMapping(value="/list.do")
	public @ResponseBody Object search(HttpServletRequest req){
		
		// 注册时间转换器，处理传入的JSON数据中的日期格式
				JSONUtils.getMorpherRegistry().registerMorpher(
						new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));
						
				int pageNow = Integer.parseInt(req.getParameter("pageNow"));
				int pageSize = 15;
				String keys = req.getParameter("keys");
				

					try {

						keys = URLDecoder.decode(keys, "utf-8");

					}
					catch (Exception e) {

						e.printStackTrace();

					}
					System.out.println("null");
				
				JSONObject obj = JSONObject.fromObject(keys);
				if(obj.containsKey("mtTime")){
					Date startDate = DateHandler.strToDate(obj.get("mtTime").toString(), "yyyy-MM-dd");
					Date endDate = DateHandler.strToDate(obj.get("mtTime").toString(), "yyyy-MM-dd");
					startDate = DateHandler.addDay(startDate, -1);
					endDate = DateHandler.addDay(endDate, 1);
					System.out.println(DateHandler.dateToStr(startDate, "yyyy-MM-dd")+DateHandler.dateToStr(endDate, "yyyy-MM-dd"));
					obj.remove("mtTime");
					obj.put("startDate", DateHandler.dateToStr(startDate, "yyyy-MM-dd"));
					obj.put("endDate", DateHandler.dateToStr(endDate, "yyyy-MM-dd"));
				}
				String nkeys = obj.toString();
				System.out.println("nkeys:"+nkeys);
				// keys格式: {"docTime":"2017-01-01","docType":"发文"}
				Map<String, Object> res = oaMeetingTrainService.getByPage(nkeys, pageSize, pageNow);
				
				return JSONObject.fromObject(res);
	}
	
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		String meetingTrainId = req.getParameter("meetingTrainId");
		OaMeetingTrain doc = oaMeetingTrainService.getMeetingTrain(Integer.parseInt(meetingTrainId),"VIEW");
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		
		return JSONObject.fromObject(doc,config);
	}
}
