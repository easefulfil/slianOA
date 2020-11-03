package com.sliansoft.slianOA.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaMatter;
import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.OaMatter;
import com.sliansoft.slianOA.dataaccess.model.OaDocument;
import com.sliansoft.slianOA.dataaccess.model.OaMatter;
import com.sliansoft.slianOA.service.OaMatterService;

import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value="/oaMatter")
public class OaMatterController {
	
	@Autowired
	private OaMatterService oaMatterService;
	

	
	@RequestMapping(value = "/list.do")
	public @ResponseBody
	Object list(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");

		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaMatterService.getByPage(keys, pageSize,
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

		Map<String, Object> map = oaMatterService.getByPage1(keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}
	
	@RequestMapping(value = "/save.do")
	public @ResponseBody
	Object insert(HttpServletRequest req) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String suitInfo = req.getParameter("inserted");
		String updated = req.getParameter("updated");
		if(suitInfo != null){System.out.println(suitInfo);
			if (StringUtils.isEmpty(suitInfo))
				return "false";

			return oaMatterService.insert(this.convert(suitInfo));
		}
		if (updated != null){System.out.println(updated);
			if (StringUtils.isEmpty(updated))
				return "false";
			OaMatter temp  = this.convert(updated);
			System.out.println(temp.getMatterContent()+temp.getMatterStatus());
			return oaMatterService.update(this.convert(updated));
		}
		//suitInfo = "["+suitInfo+"]";

		return "false";

	}
	
	private OaMatter convert(String suitInfo) {

		//JSONObject info = JSONObject.fromObject(suitInfo);
		JSONArray jsonArray = JSONArray.fromObject(suitInfo);
		@SuppressWarnings("unchecked")
		List<OaMatter> listUpdated = (List<OaMatter>) JSONArray
				.toCollection(jsonArray, OaMatter.class);
		for (OaMatter suit : listUpdated) {

			return suit;
		}

		return null;
	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return oaMatterService.deleteById(Ids);
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

		String MatterInfo = req.getParameter("update");
		//MatterInfo = "["+MatterInfo+"]";
System.out.println("update: "+MatterInfo);
		if (StringUtils.isEmpty(MatterInfo))
			return "false";

		return oaMatterService.update(this.convert2(MatterInfo));
	}
	private OaMatter convert2(String MatterInfo) {

		//JSONObject info = JSONObject.fromObject(MatterInfo);
		JSONArray jsonArray = JSONArray.fromObject(MatterInfo);
		@SuppressWarnings("unchecked")
		List<OaMatter> listUpdated = (List<OaMatter>) JSONArray
				.toCollection(jsonArray, OaMatter.class);
		for (OaMatter Matter : listUpdated) {

			return Matter;
		}

		return null;
	}
	


}
