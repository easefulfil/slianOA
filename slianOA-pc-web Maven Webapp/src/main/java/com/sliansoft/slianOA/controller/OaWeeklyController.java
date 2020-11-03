package com.sliansoft.slianOA.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.sliansoft.slianOA.dataaccess.model.OaWeekly;
import com.sliansoft.slianOA.service.OaWeeklyService;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value = "/weekly")
public class OaWeeklyController {
	@Autowired
	private OaWeeklyService oaWeeklyService;

	@RequestMapping(value = "/list.do")
	public @ResponseBody Object weeklyList(HttpServletRequest req) {
		// 注册时间转换器，处理传入的JSON数据中的日期格式///目前没用
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");//
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaWeeklyService.getByPage(keys, pageSize, pageIndex);
		return JSONObject.fromObject(map);
	}
	@RequestMapping(value = "/list1.do")
	public @ResponseBody Object weeklyList1(HttpServletRequest req) {
		// 注册时间转换器，处理传入的JSON数据中的日期格式///目前没用
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");//
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaWeeklyService.getByPage1(keys, pageSize, pageIndex);
		return JSONObject.fromObject(map);
	}

	@RequestMapping(value = "/getById.do")
	public @ResponseBody Object weeklyGetById(HttpServletRequest req) {
		String id = req.getParameter("weeklyId");
		Integer weeklyId;
		try {
			weeklyId = Integer.parseInt(id);
		} catch (Exception e) {
			return "false";
		}
		// 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		return JSONObject.fromObject(oaWeeklyService.getWeeklyById(weeklyId), config);
	}
	@RequestMapping(value = "/save.do")
	public @ResponseBody
	Object save(HttpServletRequest req) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String WeeklyInfo = req.getParameter("inserted");
		String updated = req.getParameter("updated");
		if(WeeklyInfo != null){System.out.println(WeeklyInfo);
			if (StringUtils.isEmpty(WeeklyInfo))
				return "false";

			return oaWeeklyService.insert(this.convert(WeeklyInfo));
		}
		if (updated != null){System.out.println(updated);
			if (StringUtils.isEmpty(updated))
				return "false";
			OaWeekly temp  = this.convert(updated);
			
			return oaWeeklyService.update(this.convert(updated));
		}
		//WeeklyInfo = "["+WeeklyInfo+"]";

		return "false";

	}
	private OaWeekly convert(String WeeklyInfo) {

		//JSONObject info = JSONObject.fromObject(WeeklyInfo);
		JSONArray jsonArray = JSONArray.fromObject(WeeklyInfo);
		@SuppressWarnings("unchecked")
		List<OaWeekly> listUpdated = (List<OaWeekly>) JSONArray
				.toCollection(jsonArray, OaWeekly.class);
		for (OaWeekly Weekly : listUpdated) {

			return Weekly;
		}

		return null;
	}
	
	@RequestMapping(value = "/delete.do")
	public @ResponseBody Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		System.out.println("走到了controller");
		return oaWeeklyService.deleteById(Ids);
	}

	/*
	 * @Transactional
	 * 
	 * @RequestMapping(value="/vehicle/insert.do") public @ResponseBody Object
	 * insert(HttpServletRequest req){ JSONObject jsonObject =
	 * JSONObject.fromObject(req.getParameter("vehicle")); return
	 * oaVehicleService.insert((OaVehicle)JSONObject.toBean(jsonObject,
	 * OaVehicle.class)); }
	 *//**
		 * 修改车辆信息()
		 * 
		 * @param req
		 * @return
		 *//*
		 * @Transactional
		 * 
		 * @RequestMapping(value="/vehicle/update.do") public @ResponseBody
		 * Object update(HttpServletRequest req){ JSONObject jsonObject =
		 * JSONObject.fromObject(req.getParameter("vehicle")); return
		 * oaVehicleService.update((OaVehicle)JSONObject.toBean(jsonObject,
		 * OaVehicle.class)); }
		 */

}
