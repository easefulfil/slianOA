package com.sliansoft.slianOA.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
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













import com.sliansoft.slianOA.dataaccess.model.OaInstrument;
import com.sliansoft.slianOA.dataaccess.model.OaInstrumentCalibration;
import com.sliansoft.slianOA.service.OaInstrumentService;
import com.sliansoft.slianOA.service.httpModels.HttpJson;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;
import com.sliansoft.slianOA.utils.SysConst;

@Controller
@RequestMapping(value="/oaInstrument")
public class OaInstrumentController {

	@Autowired
	private OaInstrumentService oaInstrumentService;
	
	/**
	 * 根据条件查询仪器
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/list.do")
	public @ResponseBody Object list(HttpServletRequest req){

		String keys = req.getParameter("keys");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map =oaInstrumentService.getByPage(keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}
	@RequestMapping(value="/listCalibration.do")
	public @ResponseBody Object listCalibration(HttpServletRequest req){

		String instrumentId = req.getParameter("instrumentId");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map =oaInstrumentService.getCalibrationByPage(Integer.parseInt(instrumentId), pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insert.do")
	public @ResponseBody HttpJson insert(HttpServletRequest request){ 
		JSONObject joBDS = JSONObject.fromObject(request.getParameter("oaInstrument"));
		HttpJson j = new HttpJson();
		OaInstrument oaInstrument = (OaInstrument)JSONObject.toBean(joBDS, OaInstrument.class);
		String buyDateString = joBDS.getString("buyDate");
		String calibrationTimeString = joBDS.getString("calibrationTime");
		try{
		if(!StringUtils.isEmpty(buyDateString)){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date buyDate = simpleDateFormat.parse(buyDateString);
			oaInstrument.setBuyDate(buyDate);
		}
		if(!StringUtils.isEmpty(calibrationTimeString)){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date calibrationTime = simpleDateFormat.parse(calibrationTimeString);
			oaInstrument.setCalibrationTime(calibrationTime);
		}
		}catch (ParseException e) {
			j.setSuccess(false);
			j.setMsg("基本信息修改失败!");
			return j;
		}
		if(oaInstrumentService.insert(oaInstrument)){
			j.setSuccess(true);
			j.setMsg("基本信息保存成功！");
		}
		else{
			j.setSuccess(false);
			j.setMsg("基本信息保存成功!");
		}		
		return j;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertCalibration.do")
	public @ResponseBody HttpJson insertCalibration(HttpServletRequest request){ 
		JSONObject joBDS = JSONObject.fromObject(request.getParameter("oaInstrumentCalibration"));
		HttpJson j = new HttpJson();
		OaInstrumentCalibration oaInstrumentCalibration = (OaInstrumentCalibration)JSONObject.toBean(joBDS, OaInstrumentCalibration.class);
		String calibrationTimeString = joBDS.getString("calibrationTime");
		try{
		if(!StringUtils.isEmpty(calibrationTimeString)){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date calibrationTime = simpleDateFormat.parse(calibrationTimeString);
			oaInstrumentCalibration.setCalibrationTime(calibrationTime);
		}
		}catch (ParseException e) {
			j.setSuccess(false);
			j.setMsg("基本信息修改失败!");
			return j;
		}
		if(oaInstrumentService.insertCalibration(oaInstrumentCalibration)){
			j.setSuccess(true);
			j.setMsg("基本信息保存成功！");
		}
		else{
			j.setSuccess(false);
			j.setMsg("基本信息保存成功!");
		}		
		return j;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/update.do")
	public @ResponseBody HttpJson update(HttpServletRequest request){ 
		HttpJson j = new HttpJson();
		/*JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" }, (Date) null));*/
		JSONObject joBDS = JSONObject.fromObject(request.getParameter("oaInstrument"));
		OaInstrument oaInstrument = (OaInstrument)JSONObject.toBean(joBDS, OaInstrument.class);	
		String buyDateString = joBDS.getString("buyDate");
		String calibrationTimeString = joBDS.getString("calibrationTime");
		try{
		if(!StringUtils.isEmpty(buyDateString)){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date buyDate = simpleDateFormat.parse(buyDateString);
			oaInstrument.setBuyDate(buyDate);
		}
		if(!StringUtils.isEmpty(calibrationTimeString)){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date calibrationTime = simpleDateFormat.parse(calibrationTimeString);
			oaInstrument.setCalibrationTime(calibrationTime);
		}
		}catch (ParseException e) {
			j.setSuccess(false);
			j.setMsg("基本信息修改失败!");
			return j;
		}
		
		
		if(oaInstrumentService.update(oaInstrument)){
			j.setSuccess(true);
			j.setMsg("基本信息修改成功！");
		}
		else{
			j.setSuccess(false);
			j.setMsg("基本信息修改失败!");
		}		
		return j;
	}
	

	@RequestMapping(value = "/delete.do")
	public @ResponseBody Object delete(String ids){ 
		
		String[] Ids = ids.split(",");
		if(Ids.length == 0){
			return "false";
		}		
		return oaInstrumentService.delete(ids);

	}
}
