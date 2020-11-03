/**
 * 
 */

package com.sliansoft.slianOA.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaDocument;
import com.sliansoft.slianOA.dataaccess.model.OaMeetingTrain;
import com.sliansoft.slianOA.service.OaMeetingTrainService;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

/**
 * Copyright@宁波高新区敏智科技有限公司 www.mz3co.com Copyright@浙江大学软件学院S309实验室
 * 
 * @author chengxl Created time：2015年1月8日 上午9:08:12
 * 
 */
@Controller
@RequestMapping(value = "/oaMeetingTrain")
public class OaMeetingTrainController {

	@Autowired
	private OaMeetingTrainService oaMeetingTrainService;
	
	
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		String meetingTrainId = req.getParameter("meetingTrainId");
		String type = req.getParameter("type");
		
		OaMeetingTrain doc = oaMeetingTrainService.getMeetingTrain(Integer.parseInt(meetingTrainId),"VIEW");
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		
		return JSONObject.fromObject(doc,config);
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

		Map<String, Object> map = oaMeetingTrainService.getByPage(keys,
				pageSize, pageIndex);

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

		String meetingTrainInfo = req.getParameter("insert");

		if (StringUtils.isEmpty(meetingTrainInfo))
			return "false";

		return oaMeetingTrainService.insert(this.convert(meetingTrainInfo));

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

		String meetingTrainInfo = req.getParameter("update");

		if (StringUtils.isEmpty(meetingTrainInfo))
			return "false";

		return oaMeetingTrainService.update(this.convert(meetingTrainInfo));
	}

	private OaMeetingTrain convert(String meetingTrainInfo) {

		JSONObject info = JSONObject.fromObject(meetingTrainInfo);
	
//		// 处理json数据中的日期格式
//		JsonConfig config = new JsonConfig();
//		config.setIgnoreDefaultExcludes(false);
//		config.registerJsonValueProcessor(Date.class,
//				new DateJsonValueProcessor("yyyy-MM-dd HH-mm-ss"));
//		private 
//		  String[] formats = { "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd" };
//	      JSONUtils.getMorpherRegistry().registerMorpher(new TimestampMorpher(formats));
//	      JSONObject jsonObject = JSONObject.fromObject(json);
//	      return JSONObject.toBean(jsonObject, cls);
		
		
		JSONArray jsonArray = JSONArray.fromObject(info);


//		@SuppressWarnings("unchecked")
//		List<OaMeetingTrain> listUpdated = (List<OaMeetingTrain>) JSONArray
//				.toCollection(jsonArray, OaMeetingTrain.class);

		for (Object ob : jsonArray) {

			JSONObject jo = (JSONObject)ob;
			
			
			OaMeetingTrain omt = (OaMeetingTrain) JSONObject.toBean(jo, OaMeetingTrain.class);
//			
			//处理前端传过来的时间字段
			omt.setMtTime(DateHandler.strToDate((String)jo.get("mtTime"), "yyyy-MM-dd HH:mm:ss"));
			
			
			return omt;
		}

		return null;
	}
	


	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return oaMeetingTrainService.deleteById(Ids);
	}

}
