package com.sliansoft.slianOA.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.dao.OaErrorCorrectionMapper;
import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.OaErrorCorrection;
import com.sliansoft.slianOA.dataaccess.model.OaInstrument;
import com.sliansoft.slianOA.dataaccess.model.OaInstrumentCalibration;
import com.sliansoft.slianOA.service.OaErrorCorrectionService;
import com.sliansoft.slianOA.service.httpModels.HttpJson;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;


@Controller
@RequestMapping(value="/oaErrorCorrection")
public class OaErrorCorrectionController {

	@Autowired
	private OaErrorCorrectionService oaErrorCorrectionService;
	@Autowired
	private HttpSession session;
	@Autowired
	private OaErrorCorrectionMapper oaErrorCorrectionMapper;
	/**
	 * 
	   * 提出错误
	   * @param req
	   * @return
	 */
	@RequestMapping(value="/list1.do")
	public @ResponseBody Object list1(HttpServletRequest req){

		String keys = req.getParameter("keys");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
        String type = "proposer";
		Map<String, Object> map = oaErrorCorrectionService.getByPage(type,keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}
	/**
	 * 
	   * 原因分析
	   * @param req
	   * @return
	 */
	@RequestMapping(value="/list2.do")
	public @ResponseBody Object list2(HttpServletRequest req){

		String keys = req.getParameter("keys");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
        String type = "duty";
		Map<String, Object> map = oaErrorCorrectionService.getByPage(type,keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}
	/**
	 * 
	   * 纠正措施
	   * @param req
	   * @return
	 */
	@RequestMapping(value="/list3.do")
	public @ResponseBody Object list3(HttpServletRequest req){

		String keys = req.getParameter("keys");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
        String type = "charger";
		Map<String, Object> map = oaErrorCorrectionService.getByPage(type,keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}
	/**
	 * 
	   * 效果验证
	   * @param req
	   * @return
	 */
	@RequestMapping(value="/list4.do")
	public @ResponseBody Object list4(HttpServletRequest req){

		String keys = req.getParameter("keys");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
        String type = "quality";
		Map<String, Object> map = oaErrorCorrectionService.getByPage(type,keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}


	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insert.do")
	public @ResponseBody HttpJson insert(HttpServletRequest request){ 
		JSONObject joBDS = JSONObject.fromObject(request.getParameter("oaErrorCorrection"));
		HttpJson j = new HttpJson();
		OaErrorCorrection oaErrorCorrection = (OaErrorCorrection)JSONObject.toBean(joBDS, OaErrorCorrection.class);
		/*if(joBDS.containsKey("completeTime")){
			
		}
		String completeTimeString = joBDS.getString("completeTime");
		try{
		if(!StringUtils.isEmpty(completeTimeString)){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date completeTime = simpleDateFormat.parse(completeTimeString);
			oaErrorCorrection.setCompleteTime(completeTime);
		}else{
			oaErrorCorrection.setCompleteTime(new Date());
		}
		}catch (ParseException e) {
			j.setSuccess(false);
			j.setMsg("基本信息修改失败!");
			return j;
		}*/
		SysEmployee sysEmployee = (SysEmployee) session.getAttribute("employee");
		//设置提出人
		oaErrorCorrection.setProposerId(sysEmployee.getEmployeeId());
		if(oaErrorCorrectionService.insert(oaErrorCorrection)){
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
	@RequestMapping(value = "/update2.do")
	public @ResponseBody HttpJson update2(HttpServletRequest request){ 
		HttpJson j = new HttpJson();
		
		/*JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" }, (Date) null));*/
		JSONObject joBDS = JSONObject.fromObject(request.getParameter("oaErrorCorrection"));
		OaErrorCorrection oaErrorCorrection = (OaErrorCorrection)JSONObject.toBean(joBDS, OaErrorCorrection.class);
		/*String buyDateString = joBDS.getString("buyDate");
		String calibrationTimeString = joBDS.getString("calibrationTime");
		String completeTimeString = joBDS.getString("completeTime");
		try{
		if(!StringUtils.isEmpty(completeTimeString)){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date completeTime = simpleDateFormat.parse(completeTimeString);
			oaErrorCorrection.setCompleteTime(completeTime);
		}else{
			oaErrorCorrection.setCompleteTime(new Date());
		}
		}catch (ParseException e) {
			j.setSuccess(false);
			j.setMsg("基本信息修改失败!");
			return j;
		}*/
		if(!StringUtils.isEmpty(oaErrorCorrectionMapper.selectByPrimaryKey(oaErrorCorrection.getErrorCorrectionId()).getContent2())){
			j.setSuccess(false);
			j.setMsg("已经提交，不能修改!");
			return j;
		}
		if(oaErrorCorrectionService.update(oaErrorCorrection,oaErrorCorrection.getChargerId(),"纠正措施")){
			j.setSuccess(true);
			j.setMsg("基本信息修改成功！");
		}
		else{
			j.setSuccess(false);
			j.setMsg("基本信息修改失败!");
		}		
		return j;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/update3.do")
	public @ResponseBody HttpJson update3(HttpServletRequest request){ 
		HttpJson j = new HttpJson();
		/*JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" }, (Date) null));*/
		JSONObject joBDS = JSONObject.fromObject(request.getParameter("oaErrorCorrection"));
		OaErrorCorrection oaErrorCorrection = (OaErrorCorrection)JSONObject.toBean(joBDS, OaErrorCorrection.class);
		/*String buyDateString = joBDS.getString("buyDate");
		String calibrationTimeString = joBDS.getString("calibrationTime");
		String completeTimeString = joBDS.getString("completeTime");
		try{
		if(!StringUtils.isEmpty(completeTimeString)){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date completeTime = simpleDateFormat.parse(completeTimeString);
			oaErrorCorrection.setCompleteTime(completeTime);
		}else{
			oaErrorCorrection.setCompleteTime(new Date());
		}
		}catch (ParseException e) {
			j.setSuccess(false);
			j.setMsg("基本信息修改失败!");
			return j;
		}*/
		if(!StringUtils.isEmpty(oaErrorCorrectionMapper.selectByPrimaryKey(oaErrorCorrection.getErrorCorrectionId()).getContent3())){
			j.setSuccess(false);
			j.setMsg("已经提交，不能修改!");
			return j;
		}		
		if(oaErrorCorrectionService.update(oaErrorCorrection,oaErrorCorrection.getQualityId(),"效果验证")){
			j.setSuccess(true);
			j.setMsg("基本信息修改成功！");
		}
		else{
			j.setSuccess(false);
			j.setMsg("基本信息修改失败!");
		}		
		return j;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/update4.do")
	public @ResponseBody HttpJson update4(HttpServletRequest request){ 
		HttpJson j = new HttpJson();
		/*JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" }, (Date) null));*/
		JSONObject joBDS = JSONObject.fromObject(request.getParameter("oaErrorCorrection"));
		OaErrorCorrection oaErrorCorrection = (OaErrorCorrection)JSONObject.toBean(joBDS, OaErrorCorrection.class);

		/*String completeTimeString = joBDS.getString("completeTime");
		try{
		if(!StringUtils.isEmpty(completeTimeString)){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date completeTime = simpleDateFormat.parse(completeTimeString);
			oaErrorCorrection.setCompleteTime(completeTime);
		}else{
			oaErrorCorrection.setCompleteTime(new Date());
		}
		}catch (ParseException e) {
			j.setSuccess(false);
			j.setMsg("基本信息修改失败!");
			return j;
		}*/
		if(!StringUtils.isEmpty(oaErrorCorrectionMapper.selectByPrimaryKey(oaErrorCorrection.getErrorCorrectionId()).getContent4())){
			j.setSuccess(false);
			j.setMsg("已经提交，不能修改!");
			return j;
		}
		oaErrorCorrection.setCompleteTime(new Date());		
		if(oaErrorCorrectionService.update(oaErrorCorrection,oaErrorCorrection.getProposerId(),"已完成")){
			j.setSuccess(true);
			j.setMsg("基本信息修改成功！");
		}
		else{
			j.setSuccess(false);
			j.setMsg("基本信息修改失败!");
		}		
		return j;
	}
	@RequestMapping(value="/getById.do")
	public @ResponseBody Object vehicleGetById(HttpServletRequest req){
		String id = req.getParameter("errorCorrectionId");
		Integer errorCorrectionId;
		try{
			errorCorrectionId = Integer.parseInt(id);
		}catch(Exception e){
			return "false";
		}
		// 处理json数据中的日期格式
				JsonConfig config = new JsonConfig();
				config.setIgnoreDefaultExcludes(false);
				config.registerJsonValueProcessor(Date.class,
						new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		return JSONObject.fromObject(oaErrorCorrectionService.getById(errorCorrectionId),config);
	}
/*	@RequestMapping(value = "/delete.do")
	public @ResponseBody Object delete(String ids){ 
		
		String[] Ids = ids.split(",");
		if(Ids.length == 0){
			return "false";
		}		
		return oaInstrumentService.delete(ids);

	}*/
}
