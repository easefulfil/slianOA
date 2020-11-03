/**
 * 
 */
package com.sliansoft.slianOA.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaWorkflowCustom;
import com.sliansoft.slianOA.service.OaWorkflowCustomService;
import com.sliansoft.slianOA.service.httpModels.HttpOaWorkflowCustom;
import com.sliansoft.slianOA.service.utils.Const;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;
import com.sliansoft.slianOA.service.utils.ExcelJson2;

/**
 * @author sliansoft.com 2017年3月23日
 */

@Controller
@RequestMapping(value = "/oaWorkflowCustom")
public class OaWorkflowCustomController {

	@Autowired
	private OaWorkflowCustomService oaWorkflowCustomService;

	@RequestMapping(value = "/list.do")
	public @ResponseBody
	Object list(HttpServletRequest req) {

		// final Integer resid =
		// ConstantInit_del.urlMap.get("/department/save.do"/*"/OaWorkflow/list.do"*/);

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");
		
		

		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaWorkflowCustomService.getByPage(keys,
				pageSize, pageIndex);

		// 注销时间转换器
		JSONUtils.getMorpherRegistry().deregisterMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },
						(Date) null));
		
		return JSONObject.fromObject(map);
	}
	
	@RequestMapping(value = "/listALL.do")
	public @ResponseBody
	Object listALL(HttpServletRequest req) {

		List<Map> workflowCustomList = new ArrayList<Map> ();
		
		Iterator<Integer>  keys = Const.OAWORKFLOWCUSTOM_ID_NAME.keySet().iterator();
		
		while(keys.hasNext()){
			
			Integer workflowCustomId = (Integer)keys.next();
			
			Map  workflowCustomMap = new HashMap();
			
			workflowCustomMap.put("workflowCustomId", workflowCustomId);
			workflowCustomMap.put("name", Const.OAWORKFLOWCUSTOM_ID_NAME.get(workflowCustomId));
			
			workflowCustomList.add(workflowCustomMap);
		}
		
		return JSONArray.fromObject(workflowCustomList);
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
		String oaWorkflowCustomInfo = req.getParameter("insert");

		if (StringUtils.isEmpty(oaWorkflowCustomInfo))
			return "false";

		return oaWorkflowCustomService.insert(this
				.convert(oaWorkflowCustomInfo));
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
		String oaWorkflowCustomInfo = req.getParameter("update");

		if (StringUtils.isEmpty(oaWorkflowCustomInfo))
			return "false";

		return oaWorkflowCustomService.update(this
				.convert(oaWorkflowCustomInfo));
	}

	private OaWorkflowCustom convert(String oaWorkflowCustomInfo) {

		JSONObject info = JSONObject.fromObject(oaWorkflowCustomInfo);
		
		String joWorkflowCustom = (String)info.get("workflowCustom");
		
		
		JSONArray jsonArray = JSONArray.fromObject(info);
		
		@SuppressWarnings("unchecked")
		List<HttpOaWorkflowCustom> listInserted = (List<HttpOaWorkflowCustom>) JSONArray
				.toCollection(jsonArray, HttpOaWorkflowCustom.class);
//		 String quotationId=null;
		
		
		
		for (HttpOaWorkflowCustom hoc : listInserted) {
			
			OaWorkflowCustom oc = new OaWorkflowCustom();
			
			BeanUtils.copyProperties(hoc, oc);
			
			oc.setWorkflowCustom(  joWorkflowCustom );//hoc.getWorkflowCustom().toString()

			return oc;
		}

		return null;
	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {

		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return oaWorkflowCustomService.deleteById(Ids);
	}

	// 导出excel
	@RequestMapping(value = "/exportExcel.do")
	public void exportExcel(String route, String loadingPortId,
			String dischargingPortId1, String isRelease, String recommend,
			String effective, String shippingCompanyId, String closingDate,
			String oaWorkflowId, HttpServletRequest request,
			HttpServletResponse response) {
		// String dischargingPortId1=dischargingPortId;
		JSONArray dlist = oaWorkflowCustomService.selectAll(route,
				loadingPortId, dischargingPortId1, isRelease, recommend,
				effective, shippingCompanyId, closingDate, oaWorkflowId);
		// JSONArray jsonArray=dlist.getJSONArray(0);
		// JSONArray jsonArray2=dlist.getJSONArray(1);
		// JSONArray jsonArray3=dlist.getJSONArray(2);

		JSONObject obj2 = new JSONObject();
		// JSONObject obj3 = new JSONObject();
		// JSONObject obj4 = new JSONObject();
		// if(jsonArray!=null){
		if (dlist != null) {
			obj2.put("data", dlist);

			/*
			 * Object obj1 = Ids.toArray()[0]; JSONObject obj2 = (JSONObject)
			 * obj1;
			 */
			String filename = "海运报价管理信息报表";
			try {
				String excelFileName = new String(
						("海运报价管理信息报表.xls").getBytes("gb2312"), "ISO8859-1");
				response.setContentType("octets/stream");
				response.addHeader("Content-Disposition",
						"attachment;filename=" + excelFileName);
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			JSONUtils.getMorpherRegistry().registerMorpher(
					new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },
							(Date) null));
			try {
				OutputStream out = response.getOutputStream();
				// scheduleEmployeeService.exportExcel(scheduleMonth,osId, out);
				ExcelJson2 excelJson2 = new ExcelJson2();
				excelJson2.createExcel(out, obj2, filename);
				out.close();
				System.out.println("excel out");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				response.setHeader(
						"Content-Disposition",
						"attachment;fileName="
								+ URLEncoder.encode("记录不存在", "UTF-8") + ".txt");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
