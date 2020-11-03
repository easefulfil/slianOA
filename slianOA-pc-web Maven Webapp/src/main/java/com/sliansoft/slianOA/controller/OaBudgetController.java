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
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaBudget;
import com.sliansoft.slianOA.dataaccess.model.OaPettyMoney;
import com.sliansoft.slianOA.service.OaBudgetService;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

/**
 * @author sliansoft.com 2017年3月23日 上午11:29:27
 */
@Controller
@RequestMapping(value = "/oaBudget")
public class OaBudgetController {
	@Autowired
	private OaBudgetService oaBudgetService;

	@RequestMapping(value = "/list.do")
	public @ResponseBody
	Object BudgetList(HttpServletRequest req) {
		String keys = req.getParameter("keys");//
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaBudgetService.getByPage(keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}

	@RequestMapping(value = "/getProjectBudget.do")
	public @ResponseBody
	Object getProjectBudget(HttpServletRequest req) {
		String keys = req.getParameter("keys");//
		Integer projectId = Integer.parseInt(req.getParameter("projectId"));
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaBudgetService.getProjectBudget(keys,projectId, pageSize,
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

		String oaBudget = req.getParameter("inserted");

		if (oaBudget != null) {
			if (StringUtils.isEmpty(oaBudget))
				return "false";

			return oaBudgetService.insert(this.convert(oaBudget));
		}

		// inserted = "["+inserted+"]";

		return "false";

	}

	private OaBudget convert(String budget) {

		JSONUtils.getMorpherRegistry().deregisterMorpher( 
				JSONUtils.getMorpherRegistry().getMorpherFor(Date.class));
		
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] {
						"yyyy-MM-dd HH:mm:ss" }, (Date) null));

		JSONObject info = JSONObject.fromObject(budget);
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaBudget> listUpdated = (List<OaBudget>) JSONArray.toCollection(
				jsonArray, OaBudget.class);
		for (OaBudget Budget : listUpdated) {
			return Budget;
		}
		return null;
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

		String BudgetUpdate = req.getParameter("BudgetUpdate");

		if (StringUtils.isEmpty(BudgetUpdate)) {
			// System.out.println("controller中数据:"); 说明不为空
			return "false";
		}
		// System.out.println("执行不的？"+Budget); 传过来的数据是对的
		return oaBudgetService.update(this.convert(BudgetUpdate));
	}

	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		return oaBudgetService.deleteById(Ids);
	}

	// @RequestMapping(value="/updateForm.do")
	// public @ResponseBody
	// Object updateForm(HttpServletRequest req){
	// String ids = req.getParameter("ids");
	// String[] Ids = ids.split(",");
	// return null;//attendanceService.deleteById(Ids);
	// }
	
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
			oaBudgetService.exportExcel(keys, out);
			out.close();
			System.out.println("excel out");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
  	}
}
