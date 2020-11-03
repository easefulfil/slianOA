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

import com.sliansoft.slianOA.dataaccess.model.OaSuit;
import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.OaSuit;
import com.sliansoft.slianOA.dataaccess.model.OaDocument;
import com.sliansoft.slianOA.service.OaSuitService;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value="/oaSuit")
public class OaSuitController {
	
	@Autowired
	private OaSuitService oaSuitService;
	
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		String suitId = req.getParameter("suitId");
		OaSuit suit = oaSuitService.getById(suitId);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		return JSONObject.fromObject(suit,config);
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

		Map<String, Object> map = oaSuitService.getByPage(keys, pageSize,
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

			return oaSuitService.insert(this.convert(suitInfo));
		}
		if (updated != null){System.out.println(updated);
			if (StringUtils.isEmpty(updated))
				return "false";
			OaSuit temp  = this.convert(updated);
			System.out.println(temp.getAppraisedPerson()+temp.getApprasingPerson());
			return oaSuitService.update(this.convert(updated));
		}
		//suitInfo = "["+suitInfo+"]";

		return "false";

	}
	
	private OaSuit convert(String suitInfo) {

		//JSONObject info = JSONObject.fromObject(suitInfo);
		JSONArray jsonArray = JSONArray.fromObject(suitInfo);
		@SuppressWarnings("unchecked")
		List<OaSuit> listUpdated = (List<OaSuit>) JSONArray
				.toCollection(jsonArray, OaSuit.class);
		for (OaSuit suit : listUpdated) {

			return suit;
		}

		return null;
	}
	
	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return oaSuitService.deleteById(Ids);
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

		String suitInfo = req.getParameter("update");
		//suitInfo = "["+suitInfo+"]";
System.out.println("update: "+suitInfo);
		if (StringUtils.isEmpty(suitInfo))
			return "false";

		return oaSuitService.update(this.convert2(suitInfo));
	}
	private OaSuit convert2(String suitInfo) {

		//JSONObject info = JSONObject.fromObject(suitInfo);
		JSONArray jsonArray = JSONArray.fromObject(suitInfo);
		@SuppressWarnings("unchecked")
		List<OaSuit> listUpdated = (List<OaSuit>) JSONArray
				.toCollection(jsonArray, OaSuit.class);
		for (OaSuit suit : listUpdated) {

			return suit;
		}

		return null;
	}
	
	@RequestMapping(value = "/newSuit.do")
	public @ResponseBody
	Object newSuit(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
//		String type =   java.net.URLDecoder.decode(req.getParameter("fileType"), "UTF-8"); 
		
//		String type = req.getParameter("fileType");
		
//		if(StringUtils.isEmpty(type));
//			return null;
		OaSuit odd = new OaSuit();
//		odd.setType(type);
		
		OaSuit od = oaSuitService.insertSuit(odd);
System.out.println("这里是测试是否获得头偶素ID： "+ od.getSuitId());
		// // 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));// HH:mm:ss
		//
		return JSONObject.fromObject(od, config);

	}
}
