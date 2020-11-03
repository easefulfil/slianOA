/**
 * 
 */

package com.sliansoft.slianOA.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
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
import com.sliansoft.slianOA.dataaccess.model.OaAttendance;
import com.sliansoft.slianOA.dataaccess.model.OaAttendanceAppeal;
import com.sliansoft.slianOA.service.OaAttendanceAppealService;
import com.sliansoft.slianOA.service.OaAttendanceService;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;


@Controller
@RequestMapping(value = "/oaAttendanceAppeal")
public class OaAttendanceAppealController {

	@Autowired
	private OaAttendanceAppealService oaAttendanceAppealService;

	@RequestMapping(value = "/exportExcel.do")
  	public void exportExcel(HttpServletRequest request,HttpServletResponse response ) {
//		String scheduleMonth = request.getParameter("scheduleMonth");
		String keys = request.getParameter("keys");
		String excelFileName;
		try {
			excelFileName = new String(
					(DateHandler.dateToStr(new Date(), "yyyyMMddhhmmss") + ".xls").getBytes("gb2312"), "ISO8859-1");
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + excelFileName);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		JSONUtils.getMorpherRegistry()
				.registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" }, (Date) null));
		try {
			OutputStream out = response.getOutputStream();
		//	attendanceAppealService.exportExcel(keys, out);
			out.close();
			System.out.println("excel out");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

		Map<String, Object> map = oaAttendanceAppealService.getByPage(keys, pageSize,
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

		Map<String, Object> map = oaAttendanceAppealService.getByPage1(keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}
	@RequestMapping(value = "/getById.do")
	public @ResponseBody Object oaAttendanceAppealGetById(HttpServletRequest req) {
		String id = req.getParameter("appealId");
		//String account;
		int appealId;
		try {
			
			appealId = Integer.parseInt(id);
		} catch (Exception e) {
			return "false";
		}
		// 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		return JSONObject.fromObject(oaAttendanceAppealService.getAttendanceAppealByAppealId(appealId), config);
	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return oaAttendanceAppealService.deleteById(Ids);
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

		String appealInfo = req.getParameter("inserted");
		String updated = req.getParameter("updated");
		if(appealInfo != null){System.out.println(appealInfo);
			if (StringUtils.isEmpty(appealInfo))
				return "false";

			return oaAttendanceAppealService.insert(this.convert(appealInfo));
		}
		if (updated != null){System.out.println(updated);
			if (StringUtils.isEmpty(updated))
				return "false";
			OaAttendanceAppeal temp  = this.convert(updated);
			//System.out.println(temp.getAppraisedPerson()+temp.getApprasingPerson());
			return oaAttendanceAppealService.update(this.convert(updated));
		}
		//appealInfo = "["+appealInfo+"]";

		return "false";

	}
	private OaAttendanceAppeal convert(String appealInfo) {

		//JSONObject info = JSONObject.fromObject(appealInfo);
		JSONArray jsonArray = JSONArray.fromObject(appealInfo);
		@SuppressWarnings("unchecked")
		List<OaAttendanceAppeal> listUpdated = (List<OaAttendanceAppeal>) JSONArray
				.toCollection(jsonArray, OaAttendanceAppeal.class);
		for (OaAttendanceAppeal suit : listUpdated) {

			return suit;
		}

		return null;
	}
}
