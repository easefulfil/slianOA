package com.sliansoft.slianOA.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.service.OaMonthlyService;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value = "/monthly")
public class OaMonthlyController {
	@Autowired
	private OaMonthlyService oaMonthlyService;

	@RequestMapping(value = "/list.do")
	public @ResponseBody Object MonthlyList(HttpServletRequest req) {
		// 注册时间转换器，处理传入的JSON数据中的日期格式///目前没用
		//JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");//
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaMonthlyService.getByPage(keys, pageSize, pageIndex);
		return JSONObject.fromObject(map);
	}

	@RequestMapping(value = "/getById.do")
	public @ResponseBody Object MonthlyGetById(HttpServletRequest req) {
		String id = req.getParameter("monthlyId");
		Integer monthlyId;
		try {
			monthlyId = Integer.parseInt(id);
		} catch (Exception e) {
			return "false";
		}
		// 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		return JSONObject.fromObject(oaMonthlyService.getMonthlyById(monthlyId), config);
	}
	
	@RequestMapping(value = "/delete.do")
	public @ResponseBody Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		System.out.println("走到了controller");
		return oaMonthlyService.deleteById(Ids);
	}
}
