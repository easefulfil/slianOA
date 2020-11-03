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

import com.sliansoft.slianOA.dataaccess.model.OaDocument;
import com.sliansoft.slianOA.dataaccess.model.OaMeetingTrain;
import com.sliansoft.slianOA.dataaccess.model.OaNews;
import com.sliansoft.slianOA.service.OaNewsService;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;


@Controller
@RequestMapping(value = "/oaNews")
public class OaNewsController {

	@Autowired
	private OaNewsService newsService;
	
	
	/*
	 * 根据newsId获取文件办理内容
	 */
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		String newsId = req.getParameter("newsId");
		String type = req.getParameter("type");
		
		//OaNews news = newsService.getById(newsId);
		OaNews news = newsService.getNews(newsId,type);
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		
		return JSONObject.fromObject(news,config);
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

		Map<String, Object> map = newsService.getByPage(keys, pageSize,
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

		String newsInfo = req.getParameter("insert");

		if (StringUtils.isEmpty(newsInfo))
			return "false";

		return newsService.insert(this.convert(newsInfo));

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
		
		return newsService.update(this.convert(newsInfo));
	}
	
	private  OaNews convert(String newsInfo ){
		
		JSONObject info = JSONObject.fromObject(newsInfo);
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaNews> listUpdated = (List<OaNews>) JSONArray.toCollection(
				jsonArray, OaNews.class);
		for (OaNews news : listUpdated) {
			
			return news;
		}
		
		return null;
	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return newsService.deleteById(Ids);
	}

}
