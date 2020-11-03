package com.sliansoft.slianOA.mobile.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaDocument;
import com.sliansoft.slianOA.service.OaDocumentService;
import com.sliansoft.slianOA.service.httpModels.HttpOaDocument;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;


@Controller
@RequestMapping(value="/mobile-ajax/auth/oaDocument")
public class OaDocumentMobileController {

	@Autowired
	private OaDocumentService oaDocumentService;
	/*
	 * 根据documentId获取文件办理内容
	 */
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		int documentId = Integer.parseInt(req.getParameter("documentId"));
		//OaDocument doc = oaDocumentService.getById(documentId);
		OaDocument doc = oaDocumentService.getDocument(documentId,"VIEW");
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		return JSONObject.fromObject(doc,config);
	}
	
	/*
	 * 公文管理中
	 */
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
			System.out.println("keys:"+keys);
		
		
		// keys格式: {"docTime":"2017-01-01","type":"发文"}
			JSONObject obj = JSONObject.fromObject(keys);
			if(obj.containsKey("docTime")){
				Date startDate = DateHandler.strToDate(obj.get("docTime").toString(), "yyyy-MM-dd");
				Date endDate = DateHandler.strToDate(obj.get("docTime").toString(), "yyyy-MM-dd");
				//startDate = DateHandler.addDay(startDate, -1);
				endDate = DateHandler.addDay(endDate, 1);
				System.out.println(DateHandler.dateToStr(startDate, "yyyy-MM-dd")+DateHandler.dateToStr(endDate, "yyyy-MM-dd"));
				obj.remove("docTime");
				obj.put("startDate2", DateHandler.dateToStr(startDate, "yyyy-MM-dd"));
				obj.put("endDate2", DateHandler.dateToStr(endDate, "yyyy-MM-dd"));
			}
			String nkeys = obj.toString();
			System.out.println("nkeys:"+nkeys);
		Map<String, Object> res = oaDocumentService.getByPage(nkeys, pageSize, pageNow);
		
		return JSONObject.fromObject(res);
		
	}
}

