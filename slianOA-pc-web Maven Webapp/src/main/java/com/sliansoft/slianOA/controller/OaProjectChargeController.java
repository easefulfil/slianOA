package com.sliansoft.slianOA.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaBudget;
import com.sliansoft.slianOA.dataaccess.model.OaProjectCharge;
import com.sliansoft.slianOA.service.OaBudgetService;
import com.sliansoft.slianOA.service.OaProjectChargeService;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value = "/projectCharge")
public class OaProjectChargeController {

	@Autowired
	private OaProjectChargeService oaProjectChargeService;
	@Autowired
	private OaBudgetService oaBudgetService;
	
	@RequestMapping(value = "/getProjectChargeById.do")
	public @ResponseBody Object getProjectChargeById(HttpServletRequest req) {
		// 注册时间转换器，处理传入的JSON数据中的日期格式///目前没用
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" }, (Date) null));

		String projectId = req.getParameter("projectId");//
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
	//	System.out.println("项目id"+projectId);
		Map<String, Object> map = oaProjectChargeService.getProjectChargeById(Integer.parseInt(projectId), pageSize, pageIndex);
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

		String oaProjectCharge = req.getParameter("inserted");

		if (oaProjectCharge != null) {
			if (StringUtils.isEmpty(oaProjectCharge))
				return "false";

			return oaProjectChargeService.insert(this.convert(oaProjectCharge));
		}

		// inserted = "["+inserted+"]";

		return "false";

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

		String oaProjectCharge = req.getParameter("updated");

		if (oaProjectCharge != null) {
			if (StringUtils.isEmpty(oaProjectCharge))
				return "false";
			OaProjectCharge c = this.convert(oaProjectCharge);

			
			OaBudget oaBudget = new OaBudget();
			oaBudget.setIncome(c.getChargeMoney());
			oaBudget.setBudgetType("收入");
			oaBudget.setBudgetTypeName("项目收入");
			oaBudget.setHappenDate(c.getFactDate());
			oaBudget.setCreateTime(new Date());
			oaBudget.setProjectId(c.getProjectId());
			String result2 = oaBudgetService.insert(oaBudget);
			String result1 = oaProjectChargeService.update(c);
			if(result1.equals("success")&&result2.equals("success"))
				return "success";
		}

		// inserted = "["+inserted+"]";

		return "false";

	}
	
	private OaProjectCharge convert(String oaProjectCharge) {

		JSONUtils.getMorpherRegistry().deregisterMorpher( 
				JSONUtils.getMorpherRegistry().getMorpherFor(Date.class));
		
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] {
						"yyyy-MM-dd HH:mm:ss" }, (Date) null));

		JSONObject info = JSONObject.fromObject(oaProjectCharge);
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaProjectCharge> listUpdated = (List<OaProjectCharge>) JSONArray.toCollection(
				jsonArray, OaProjectCharge.class);
		for (OaProjectCharge charge : listUpdated) {
			return charge;
		}
		return null;
	}
	
	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	Object delete(HttpServletRequest req) {
		String ids = req.getParameter("ids");
		
	
		return oaProjectChargeService.delete(ids)?"success":"false";
	}
	
}
