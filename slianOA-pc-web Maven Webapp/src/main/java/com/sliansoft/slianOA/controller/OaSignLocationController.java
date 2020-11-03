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

import com.sliansoft.slianOA.dataaccess.model.OaSignLocation;
import com.sliansoft.slianOA.service.OaSignLocationService;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;


@Controller
@RequestMapping(value = "/oaSignLocation")
public class OaSignLocationController {

	@Autowired
	private OaSignLocationService signLocationService;
	
	
	
	
	
	@RequestMapping(value = "/listALL.do")
	public @ResponseBody
	Object listALL(HttpServletRequest req) {



		return signLocationService.listALL();
	}

	
	
	/*
	 * 根据signLocationId获取文件办理内容
	 */
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		String signLocationId = req.getParameter("signLocationId");
		OaSignLocation signLocation = signLocationService.getById(signLocationId);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		return JSONObject.fromObject(signLocation,config);
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

		Map<String, Object> map = signLocationService.getByPage(keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}

	@RequestMapping(value = "/insert.do")
	public @ResponseBody
	Object insert(HttpServletRequest req) throws UnsupportedEncodingException {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		OaSignLocation osl = new OaSignLocation();

		osl.setAddress(java.net.URLDecoder.decode(req.getParameter("address"), "UTF-8") );
		
		osl.setLatitude(Double.parseDouble(req.getParameter("latitude")));

		osl.setLongitude(Double.parseDouble(req.getParameter("longitude")));
		
		osl.setScope(Integer.parseInt(req.getParameter("scope")));
		
		return signLocationService.insert(osl);

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
		
		String signLocationInfo = req.getParameter("update");

		if (StringUtils.isEmpty(signLocationInfo))
			return "false";
		
		return signLocationService.update(this.convert(signLocationInfo));
	}
	
	private  OaSignLocation convert(String signLocationInfo ){
		
		JSONObject info = JSONObject.fromObject(signLocationInfo);
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaSignLocation> listUpdated = (List<OaSignLocation>) JSONArray.toCollection(
				jsonArray, OaSignLocation.class);
		for (OaSignLocation signLocation : listUpdated) {
			
			return signLocation;
		}
		
		return null;
	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return signLocationService.deleteById(Ids);
	}

}
