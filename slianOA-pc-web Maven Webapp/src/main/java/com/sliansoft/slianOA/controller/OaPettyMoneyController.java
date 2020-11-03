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

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaPettyMoney;
import com.sliansoft.slianOA.dataaccess.model.OaProject;
import com.sliansoft.slianOA.service.OaPettyMoneyService;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value = "/pettyMoney")
public class OaPettyMoneyController {
	@Autowired
	private OaPettyMoneyService oaPettyMoneyService;

	@RequestMapping(value = "/list.do")
	public @ResponseBody Object weeklyList(HttpServletRequest req) {
		// 注册时间转换器，处理传入的JSON数据中的日期格式///目前没用
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" }, (Date) null));

		String keys = req.getParameter("keys");//
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaPettyMoneyService.getByPage(keys, pageSize, pageIndex);
		return JSONObject.fromObject(map);
	}
	
	@RequestMapping(value = "/delete.do")
	public @ResponseBody Object delete(HttpServletRequest req) {
		String id = req.getParameter("id");		
		System.out.println("走到了controller");
		return oaPettyMoneyService.deleteByOaPettyMoneyId(Integer.parseInt(id));
	}

	@Transactional
	@RequestMapping(value = "/insertExpense.do")
	public @ResponseBody
	Object insertExpense(HttpServletRequest req) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String pettyMoney = req.getParameter("pettyMoney");
		System.out.println(pettyMoney);
		
		if (StringUtils.isEmpty(pettyMoney)){
			//
			return "false";
		}
		
		OaPettyMoney oaPettyMoney = this.convert(pettyMoney);
		oaPettyMoney.setType("支出");
		if(oaPettyMoneyService.insert(oaPettyMoney)){
			return "success";
		}else{
			return "failed";
		}

	}
	
	@Transactional
	@RequestMapping(value = "/insertIncome.do")
	public @ResponseBody
	Object insertIncome(HttpServletRequest req) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String pettyMoney = req.getParameter("pettyMoney");
		
		if (StringUtils.isEmpty(pettyMoney)){
			//
			return "false";
		}
		
		OaPettyMoney oaPettyMoney = this.convert(pettyMoney);
		oaPettyMoney.setType("收入");
		if(oaPettyMoneyService.insert(oaPettyMoney)){
			return "success";
		}else{
			return "failed";
		}

	}
	
    private  OaPettyMoney convert(String basicInfoUpdate){
    	
    	JSONUtils.getMorpherRegistry().deregisterMorpher(JSONUtils.getMorpherRegistry().getMorpherFor(Date.class));
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpherEx(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"},(Date) null));
		
		JSONObject info = JSONObject.fromObject(basicInfoUpdate);
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaPettyMoney> listUpdated = (List<OaPettyMoney>) JSONArray.toCollection(
				jsonArray, OaPettyMoney.class);
		for (OaPettyMoney oaPettyMoney : listUpdated) {			
			return oaPettyMoney;
		}		
		return null;
	}
    
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
			oaPettyMoneyService.exportExcel(keys, out);
			out.close();
			System.out.println("excel out");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
  	}

	/*
	 * @Transactional
	 * 
	 * @RequestMapping(value="/vehicle/insert.do") public @ResponseBody Object
	 * insert(HttpServletRequest req){ JSONObject jsonObject =
	 * JSONObject.fromObject(req.getParameter("vehicle")); return
	 * oaVehicleService.insert((OaVehicle)JSONObject.toBean(jsonObject,
	 * OaVehicle.class)); }
	 *//**
		 * 修改车辆信息()
		 * 
		 * @param req
		 * @return
		 *//*
		 * @Transactional
		 * 
		 * @RequestMapping(value="/vehicle/update.do") public @ResponseBody
		 * Object update(HttpServletRequest req){ JSONObject jsonObject =
		 * JSONObject.fromObject(req.getParameter("vehicle")); return
		 * oaVehicleService.update((OaVehicle)JSONObject.toBean(jsonObject,
		 * OaVehicle.class)); }
		 */

}
