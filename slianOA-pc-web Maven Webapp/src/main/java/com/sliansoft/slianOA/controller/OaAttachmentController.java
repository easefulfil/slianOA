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
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaAttachment;
import com.sliansoft.slianOA.dataaccess.model.OaNews;
import com.sliansoft.slianOA.dataaccess.model.OaProject;
import com.sliansoft.slianOA.service.OaAttachmentService;
import com.sliansoft.slianOA.service.httpModels.HttpJson;
import com.sliansoft.slianOA.service.httpModels.HttpOaAttachment;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;
/**
 *@author sliansoft.com
 *2017年4月3日 下午7:58:44
 */

@Controller
@RequestMapping(value = "/oaAttachment")
public class OaAttachmentController {

	@Autowired
	private OaAttachmentService attachmentService;

	@RequestMapping(value = "/list.do")
	public @ResponseBody
	Object list(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");

		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map =null;// newsService.getByPage(keys, pageSize, pageIndex);

		return JSONObject.fromObject(map);
	}
	
	@RequestMapping(value = "/getProjectFile.do")
	public @ResponseBody
	List<OaAttachment> listProjectFile(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));
		String businessId = req.getParameter("businessId");
		System.out.println("businessId="+businessId);  
		List<OaAttachment> list =attachmentService.getFileByBusinessId(businessId);// newsService.getByPage(keys, pageSize, pageIndex);
        
		return list;
	}
	@RequestMapping(value = "/atlist.do")
	public @ResponseBody
	Object fslist(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");

		String businessTable = req.getParameter("businessTable");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		System.out.println("businessTable="+businessTable);  
		Map<String, Object> map =attachmentService.getByPage(businessTable, keys, pageSize, pageIndex);// newsService.getByPage(keys, pageSize, pageIndex);

		return JSONObject.fromObject(map);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/insertProjectFile.do")
	public @ResponseBody 
	String insertProjectFile(HttpServletRequest req){
		
		String businessId = req.getParameter("businessId");
		System.out.println(businessId);
       
		String result= attachmentService.insertByBusinessId(Integer.parseInt(businessId));
		return result;
		
	
	}
	@RequestMapping(value = "/fsinsert.do")
	public @ResponseBody
	String fsinsert(HttpServletRequest req) {

		OaAttachment oaAttachment = new OaAttachment();
		oaAttachment.setBusinessTable("oa_financialStatement");
		String result= attachmentService.insertBySession(oaAttachment);
		return result;
	}

	@RequestMapping(value = "/eiinsert.do")
	public @ResponseBody
	String eiinsert(HttpServletRequest req) {

		OaAttachment oaAttachment = new OaAttachment();
		oaAttachment.setBusinessTable("oa_electronicInvoice");
		String result= attachmentService.insertBySession(oaAttachment);
		return result;
	}
	
	@RequestMapping(value = "/odinsert.do")
	public @ResponseBody
	String odinsert(HttpServletRequest req) {

		OaAttachment oaAttachment = new OaAttachment();
		oaAttachment.setBusinessTable("oa_officeDocument");
		String result= attachmentService.insertBySession(oaAttachment);
		return result;
	}
	
	@RequestMapping(value = "/tdinsert.do")
	public @ResponseBody
	String tdinsert(HttpServletRequest req) {

		OaAttachment oaAttachment = new OaAttachment();
		oaAttachment.setBusinessTable("oa_techDocument");
		String result= attachmentService.insertBySession(oaAttachment);
		return result;
	}
	
	@RequestMapping(value = "/deletebyId.do")
	public @ResponseBody
	Object deletebyId(HttpServletRequest req) {
		String id = req.getParameter("id");
		String[] ids ={id};
		return attachmentService.deleteById(ids);
	}

	
	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
	
		return attachmentService.deleteById(Ids);
	}
	
	@RequestMapping(value = "/deletePro.do")
	public @ResponseBody
	Object deletePro(HttpServletRequest req) {
		String businessTable = req.getParameter("businessTable");
		String businessId = req.getParameter("businessId");
		
	
		return attachmentService.deletePro(businessTable, businessId);
	}


}
