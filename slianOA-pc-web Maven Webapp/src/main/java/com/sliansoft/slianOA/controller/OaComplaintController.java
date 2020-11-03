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

import com.sliansoft.slianOA.dataaccess.model.OaComplaint;
import com.sliansoft.slianOA.dataaccess.model.OaDocument;
import com.sliansoft.slianOA.service.OaComplaintService;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value="/oaComplaint")
public class OaComplaintController {
	
	@Autowired
	private OaComplaintService oaComplaintService;
	
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		String complaintId = req.getParameter("complaintId");
		
		String type = req.getParameter("type");
		
		OaComplaint complaint = oaComplaintService.getByIdAndType(Integer.parseInt(complaintId),type);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		return JSONObject.fromObject(complaint,config);
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

		Map<String, Object> map = oaComplaintService.getByPage(keys, pageSize,
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

		String complaintInfo = req.getParameter("insert");
System.out.println(complaintInfo);
		if (StringUtils.isEmpty(complaintInfo))
			return "false";

		return oaComplaintService.insert(this.convert(complaintInfo));

	}
	
	private OaComplaint convert(String complaintInfo) {

		JSONObject info = JSONObject.fromObject(complaintInfo);
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaComplaint> listUpdated = (List<OaComplaint>) JSONArray
				.toCollection(jsonArray, OaComplaint.class);
		for (OaComplaint complaint : listUpdated) {

			return complaint;
		}

		return null;
	}
	
	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return oaComplaintService.deleteById(Ids);
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

		String complaintInfo = req.getParameter("update");
System.out.println("update: "+complaintInfo);
		if (StringUtils.isEmpty(complaintInfo))
			return "false";

		return oaComplaintService.update(this.convert(complaintInfo));
	}
	
	@RequestMapping(value = "/newComplaint.do")
	public @ResponseBody
	Object newComplaint(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {

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
		OaComplaint odd = new OaComplaint();
//		odd.setType(type);
		
		OaComplaint od = oaComplaintService.insertComplaint(odd);
System.out.println("这里是测试是否获得头偶素ID： "+ od.getComplaintId());
		// // 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));// HH:mm:ss
		//
		return JSONObject.fromObject(od, config);

	}
}
