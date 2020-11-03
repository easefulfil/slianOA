/**
 * 
 */

package com.sliansoft.slianOA.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.sliansoft.slianOA.service.OaDocumentService;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

/**
 * @author sliansoft.com 2017年3月23日 上午11:29:27
 */
@Controller
@RequestMapping(value = "/oaDocument")
public class OaDocumentController {

	@Autowired
	private OaDocumentService oaDocumentService;
	
	/*
	 * 根据documentId获取文件办理内容
	 */
	@RequestMapping(value="/getContent.do")
	public @ResponseBody Object getContent(HttpServletRequest req){
		
		int documentId = Integer.parseInt(req.getParameter("documentId"));
		
		String type = req.getParameter("type");
		
		OaDocument doc = oaDocumentService.getDocument(documentId,type);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		
		return JSONObject.fromObject(doc,config);
	}

//	@RequestMapping(value = "/newDocument.do")
//	public @ResponseBody
//	Object newDocument(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
//
//		try {
//			req.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		String type =   java.net.URLDecoder.decode(req.getParameter("fileType"), "UTF-8"); 
//		
////		String type = req.getParameter("fileType");
//		
////		if(StringUtils.isEmpty(type));
////			return null;
//		OaDocument odd = new OaDocument();
//		odd.setType(type);
//		
//		OaDocument od = oaDocumentService.insertDocument(odd);
//
//		// // 处理json数据中的日期格式
//		JsonConfig config = new JsonConfig();
//		config.setIgnoreDefaultExcludes(false);
//		config.registerJsonValueProcessor(Date.class,
//				new DateJsonValueProcessor("yyyy-MM-dd"));// HH:mm:ss
//		//
//		return JSONObject.fromObject(od, config);
//
//	}

	@RequestMapping(value = "/list.do")
	public @ResponseBody
	Object list(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");

		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaDocumentService.getByPage(keys, pageSize,
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

		return oaDocumentService.insert(this.convert(newsInfo));

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

		OaDocument oaDocument = this.convert(newsInfo);
		return oaDocumentService.update(oaDocument);
	}

	private OaDocument convert(String newsInfo) {

		JSONObject info = JSONObject.fromObject(newsInfo);
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaDocument> listUpdated = (List<OaDocument>) JSONArray
				.toCollection(jsonArray, OaDocument.class);
		for (OaDocument document : listUpdated) {

			return document;
		}

		return null;
	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return oaDocumentService.deleteById(Ids);
	}

}
