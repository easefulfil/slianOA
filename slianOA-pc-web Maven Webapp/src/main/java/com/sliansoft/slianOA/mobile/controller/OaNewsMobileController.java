package com.sliansoft.slianOA.mobile.controller;

import java.net.URLDecoder;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaDocument;
import com.sliansoft.slianOA.dataaccess.model.OaNews;
import com.sliansoft.slianOA.service.OaNewsService;
import com.sliansoft.slianOA.service.httpModels.HttpOaNews;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;


	@Controller
	@RequestMapping(value="/mobile-ajax/auth/oaNews")
	public class OaNewsMobileController {

		@Autowired
		private OaNewsService oaNewsService;
		
		/*
		 * 通知公告拟稿
		 */
		@RequestMapping(value="/insert.do")
		public @ResponseBody Object insert(HttpServletRequest req){
			
			OaNews oaNews = new OaNews();
			String title = req.getParameter("title");
			String beginTime = req.getParameter("beginTime");
			String endTime = req.getParameter("endTime");
			String informTo = req.getParameter("informTo");// 1,2,3,5格式
			String content = req.getParameter("content");
			//String viewEmployeeIds = req.getParameter("viewEmployeeIds");// {1,2,3,5}格式
			// 处理乱码的情况
			try{

				title = URLDecoder.decode(title , "utf-8");
				content = URLDecoder.decode(content , "utf-8");

			}catch(Exception e){

				e.printStackTrace();

			}
						
			Date beginDate = DateHandler.strToDate(beginTime, "yy-MM-dd");
			Date endDate = DateHandler.strToDate(endTime, "yy-MM-dd");
			
			// TODO 将informTo转成人员ID
			oaNews.setTitle(title);
			oaNews.setInformTo(informTo);
			oaNews.setContent(content);
			oaNews.setBeginTime(beginDate);
			oaNews.setEndTime(endDate);
			oaNews.setViewEmployeeIds(informTo);
			
			String res = oaNewsService.insert(oaNews);
			
			return oaNews.getNewsId();
		}
		
		/*
		 * 通知公告查询+按条件查询
		 */
		@RequestMapping(value="/list.do")
		public @ResponseBody Object search(HttpServletRequest req){
			
			// 注册时间转换器，处理传入的JSON数据中的日期格式
			JSONUtils.getMorpherRegistry().registerMorpher(
					new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));
					
			int pageNow = Integer.parseInt(req.getParameter("pageNow"));
			int pageSize = 15;
			String keys = req.getParameter("keys");
			
			// 处理乱码的情况
			try {

				keys = URLDecoder.decode(keys, "utf-8");

			}
			catch (Exception e) {

				e.printStackTrace();

			}
			
			// keys格式: {"docTime":"2017-01-01","docType":"发文"}
			JSONObject obj = JSONObject.fromObject(keys);
			if(obj.containsKey("createTime")){
				Date startDate = DateHandler.strToDate(obj.get("createTime").toString(), "yyyy-MM-dd");
				Date endDate = DateHandler.strToDate(obj.get("createTime").toString(), "yyyy-MM-dd");
				startDate = DateHandler.addDay(startDate, -1);
				endDate = DateHandler.addDay(endDate, 1);
				System.out.println(DateHandler.dateToStr(startDate, "yyyy-MM-dd")+DateHandler.dateToStr(endDate, "yyyy-MM-dd"));
				obj.remove("createTime");
				obj.put("startDate", DateHandler.dateToStr(startDate, "yyyy-MM-dd"));
				obj.put("endDate", DateHandler.dateToStr(endDate, "yyyy-MM-dd"));
			}
			String nkeys = obj.toString();
			System.out.println("nkeys:"+nkeys);
			Map<String, Object> res = oaNewsService.getByPage(nkeys, pageSize, pageNow);
			
			return JSONObject.fromObject(res);
		}
		
		/*
		 * 获取通知公告的内容
		 */
		@RequestMapping(value="/getContent.do")
		public @ResponseBody Object getContent(HttpServletRequest req){
			
			String newsId = req.getParameter("newsId");
			//HttpOaNews httpOaNews = oaNewsService.getById(newsId);
			HttpOaNews httpOaNews = oaNewsService.getNews(newsId,"VIEW");
			JsonConfig config = new JsonConfig();
			config.setIgnoreDefaultExcludes(false);
			config.registerJsonValueProcessor(Date.class,
					new DateJsonValueProcessor("yyyy-MM-dd"));
			
			return JSONObject.fromObject(httpOaNews,config);
		}
		
	}
