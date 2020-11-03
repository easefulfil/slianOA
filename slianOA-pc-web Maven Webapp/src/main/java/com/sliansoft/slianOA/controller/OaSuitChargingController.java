package com.sliansoft.slianOA.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaSuitCharging;
import com.sliansoft.slianOA.service.OaSuitChargingService;
import com.sliansoft.slianOA.service.httpModels.HttpJson;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;


@Controller
@RequestMapping(value = "/oaSuitCharging")
public class OaSuitChargingController {

	@Autowired
	private OaSuitChargingService oaSuitChargingService;


	@RequestMapping(value = "/list.do")
	public @ResponseBody List<OaSuitCharging> getOaSuitCharging(String suitId) {
		
//		System.out.println("sssssssssssssssssssssssssssssssss");
		
		 List<OaSuitCharging> list = oaSuitChargingService.getOaSuitCharging(suitId);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		return JSONArray.fromObject(list,config);
		
	}
	
	
	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	HttpJson del(HttpServletRequest request) {
		
		String suitChargingId = request.getParameter("suitChargingId");
		
		HttpJson j = new HttpJson();
		
		if (suitChargingId == null || "".equals(suitChargingId)){
			j.setSuccess(false);
			j.setMsg("请选择删除的记录！");
			return j;
			
		}
	
		if (oaSuitChargingService.delete(suitChargingId)) {
			j.setSuccess(true);
			j.setMsg("记录删除成功!");
		}else{
			
			j.setSuccess(false);
			j.setMsg("记录删除失败!");
		}
		
		return j;

	}

	// 角色更新
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save.do")
	public @ResponseBody HttpJson save(HttpServletRequest request) throws UnsupportedEncodingException {

		request.setCharacterEncoding("UTF-8");

		JSONObject jAuthInfo = JSONObject.fromObject( request.getParameter("oaSuitCharging"));
//		jAuthInfo.remove("confirmPassword");
		OaSuitCharging oaSuitCharging =  (OaSuitCharging)JSONObject.toBean(jAuthInfo,OaSuitCharging.class);

//		oaSuitCharging.setStatus("启用");
		
		HttpJson j = new HttpJson();

		// do insert
		if (oaSuitCharging.getSuitChargingId() == null) {

			if (oaSuitChargingService.insert(oaSuitCharging)) {
				j.setSuccess(true);
				j.setMsg("新增保存成功!");
			} else {
				j.setSuccess(false);
				j.setMsg("新增保存失败!");
			}

		} else { // do update
			
			
			if (oaSuitChargingService.updata(oaSuitCharging)) {
				j.setSuccess(true);
				j.setMsg("修改成功!");
			} else {
				j.setSuccess(false);
				j.setMsg("修改失败!");
			}
		}

		return j;
		
	}

}
