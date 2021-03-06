package com.sliansoft.slianOA.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.OaOilCard;
import com.sliansoft.slianOA.dataaccess.model.OaOilCardDetail;
import com.sliansoft.slianOA.dataaccess.model.OaVehicle;
import com.sliansoft.slianOA.dataaccess.model.OaVehicleInsurance;
import com.sliansoft.slianOA.dataaccess.model.OaVehicleMaintain;
import com.sliansoft.slianOA.dataaccess.model.OaVehicleUsedRecord;
import com.sliansoft.slianOA.service.EmployeeService;
import com.sliansoft.slianOA.service.OaVehicleService;
import com.sliansoft.slianOA.service.httpModels.HttpEmployee;
import com.sliansoft.slianOA.service.httpModels.HttpOaVehicle;
import com.sliansoft.slianOA.service.httpModels.HttpOaVehicleInsurance;
import com.sliansoft.slianOA.service.utils.Const;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping(value="/oaVehicle")
public class OaVehicleController {

	@Autowired
	private OaVehicleService oaVehicleService;
	@Autowired
	private EmployeeService employeeService;
	/**
	 * 外派：查看车辆使用表状态为已通过未完成，且当前时间在申请时间之后	
	 * 不可用：外派或报废
	 * 保险开始日期、结束日期 ：插入或修改车辆保险表时同步
	 * 分页返回所有车辆
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/vehicle/list.do")
	public @ResponseBody Object vehicleList(HttpServletRequest req){
		String keys = req.getParameter("keys");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaVehicleService.getByPage(keys, pageSize, pageIndex);
		return JSONObject.fromObject(map);
	}
	@RequestMapping(value="/vehicle/getById.do")
	public @ResponseBody Object vehicleGetById(HttpServletRequest req){
		String id = req.getParameter("vehicleId");
		Integer vehicleId;
		try{
			vehicleId = Integer.parseInt(id);
		}catch(Exception e){
			return "false";
		}
		// 处理json数据中的日期格式
				JsonConfig config = new JsonConfig();
				config.setIgnoreDefaultExcludes(false);
				config.registerJsonValueProcessor(Date.class,
						new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		return JSONObject.fromObject(oaVehicleService.getVehicleById(vehicleId),config);
	}
	//实际没有设置数据权限，可以查询所有车辆，若分多家公司，需要重新定义
	@RequestMapping(value="/vehicleIdName/list.do")
	public @ResponseBody Object vehicleIdNameList(HttpServletRequest req){
		List<OaVehicle> oaVehicles = oaVehicleService.getVehicleIdName();
		JSONArray jsonArray = new JSONArray();
		for(OaVehicle oaVehicle : oaVehicles){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("vehicleId", oaVehicle.getVehicleId());
			jsonObject.put("vehicleName", oaVehicle.getLicensePlate()+"("+oaVehicle.getTrademark()+")");
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	/**
	 * 查询所有可用车辆：根据查询时间范围，查询可用的车辆（所选时间没有被占用的车，即申请已通过未完成，且申请时间没有重叠的车）
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/availableVehicle/list.do")
	public @ResponseBody Object availableVehicleList(HttpServletRequest req){
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		Date start,end;
		try{
			start = DateHandler.strToDate(startDate,"yyyy-MM-dd HH:mm");
			end = DateHandler.strToDate(endDate, "yyyy-MM-dd HH:mm");
		}catch(Exception e){
			return "false";
		}
		List<OaVehicle> oaVehicles = oaVehicleService.getAvailableVehicle(start, end);
		JSONArray jsonArray = new JSONArray();
		for(OaVehicle oaVehicle : oaVehicles){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("vehicleId", oaVehicle.getVehicleId());
			jsonObject.put("vehicleName", oaVehicle.getLicensePlate()+"("+oaVehicle.getTrademark()+")");
			jsonArray.add(jsonObject);
		}
		if(oaVehicles.size() == 0){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("vehicleId", 0);
			jsonObject.put("vehicleName", "所选时间没有可用车辆");
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	/**
	 * 车辆使用情况查询，查询条件：每周开始日期和结束日期
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/allVehicle/list.do")
	public @ResponseBody Object allVehicleList(HttpServletRequest req){
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		Date start,end;
		try{
			start = DateHandler.strToDate(startDate,"yyyy-MM-dd");
			end = DateHandler.strToDate(endDate, "yyyy-MM-dd");
		}catch(Exception e){
			return "false";
		}
		List<HttpOaVehicle> httpoaVehicles = oaVehicleService.getAllVehicle(start, end);
		JSONArray jsonArray = new JSONArray();
		// 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));// HH:mm:ss
		return JSONArray.fromObject(httpoaVehicles, config);
	}
	/**
	 * 添加车辆信息
	 * @param req
	 * @return
	 */
	@Transactional
	@RequestMapping(value="/vehicle/insert.do")
	public @ResponseBody Object insert(HttpServletRequest req){
		JSONObject jsonObject = JSONObject.fromObject(req.getParameter("vehicle"));
		return oaVehicleService.insert((OaVehicle)JSONObject.toBean(jsonObject, OaVehicle.class));	
	}
	/**
	 * 修改车辆信息()
	 * @param req
	 * @return
	 */
	@Transactional
	@RequestMapping(value="/vehicle/update.do")
	public @ResponseBody Object update(HttpServletRequest req){
		JSONObject jsonObject = JSONObject.fromObject(req.getParameter("vehicle"));
		return oaVehicleService.update((OaVehicle)JSONObject.toBean(jsonObject, OaVehicle.class));
	}
	
	/**
	 * 添加用车申请,实际归还日期默认和预期一样
	 * @param req
	 * @return
	 */
	@Transactional
	@RequestMapping(value="/vehicleApply/insert.do")
	public @ResponseBody Object vehicleApplyInsert(HttpServletRequest req){
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String vehicleApply = req.getParameter("vehicleApply");// 车辆申请
		if (StringUtils.isEmpty(vehicleApply))
			return "false";
		List<OaVehicleUsedRecord> oaVehicleUsedRecords = this.convertApply(vehicleApply);
		if (oaVehicleUsedRecords.size() != 1) {
			return "false";
		}
		OaVehicleUsedRecord oaVehicleUsedRecord = oaVehicleUsedRecords.get(0);
		if(new Date().after(oaVehicleUsedRecord.getBeginTime()) || oaVehicleUsedRecord.getPlanReturnTime().before(oaVehicleUsedRecord.getBeginTime())){
			return "申请用车时间范围不对!";
		}
		if(!oaVehicleService.isAvailableVehicle(oaVehicleUsedRecord.getBeginTime(), oaVehicleUsedRecord.getPlanReturnTime(), oaVehicleUsedRecord.getVehicleId())){
			return "所选时间段内车辆被占用!";
		}
		String msg = oaVehicleService.insertVehicleApply(oaVehicleUsedRecord);
		if (!"success".equals(msg)) {
			return "false";
		}
		return "success";
	}
	@RequestMapping(value="/vehicleApply/delete.do")
	public @ResponseBody Object vehicleApplyDelete(HttpServletRequest req){
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		if(Ids.length == 0){
			return "false";
		}
		return oaVehicleService.vehicleApplyDelete(Ids);
	}
	/**
	 *只有驳回还有可以修改前端控制，
	 * @param req
	 * @return
	 */
		@RequestMapping(value = "/vehicleApply/update.do")
		public @ResponseBody Object vehicleApplyUpdate(HttpServletRequest req) {
			try {
				req.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			String vehicleApply = req.getParameter("vehicleApply");// 车辆申请
			if (StringUtils.isEmpty(vehicleApply))
				return "false";
			List<OaVehicleUsedRecord> oaVehicleUsedRecords = this.convertApply(vehicleApply);
			if (oaVehicleUsedRecords.size() != 1) {
				return "false";
			}
			OaVehicleUsedRecord oaVehicleUsedRecord = oaVehicleUsedRecords.get(0);
			if(new Date().after(oaVehicleUsedRecord.getBeginTime()) || oaVehicleUsedRecord.getPlanReturnTime().before(oaVehicleUsedRecord.getBeginTime())){
				return "申请用车时间范围不对!";
			}
			if(!oaVehicleService.isAvailableVehicle(oaVehicleUsedRecord.getBeginTime(), oaVehicleUsedRecord.getPlanReturnTime(), oaVehicleUsedRecord.getVehicleId())){
				return "所选时间段内车辆被占用!";
			}
			return oaVehicleService.updateVehicleApply(oaVehicleUsedRecord);
		}
		/**
		 *只有还车可以修改前端控制，只能修改还车里程和时间
		 * @param req
		 * @return
		 */
			@RequestMapping(value = "/vehicleApply/finish.do")
			public @ResponseBody Object vehicleApplyFinish(HttpServletRequest req) {
				try {
					req.setCharacterEncoding("UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

				String vehicleApply = req.getParameter("vehicleApply");// 车辆申请
				if (StringUtils.isEmpty(vehicleApply))
					return "false";
				List<OaVehicleUsedRecord> oaVehicleUsedRecords = this.convertApply(vehicleApply);
				if (oaVehicleUsedRecords.size() != 1) {
					return "false";
				}
				OaVehicleUsedRecord oaVehicleUsedRecord = oaVehicleUsedRecords.get(0);
				return oaVehicleService.vehicleApplyFinish(oaVehicleUsedRecord);
			}
		/**
		 *只有驳回可以修改前端控制
		 * @param req
		 * @return
		 */
			@RequestMapping(value = "/vehicleMaintain/update.do")
			public @ResponseBody Object vehicleMaintainUpdate(HttpServletRequest req) {
				try {
					req.setCharacterEncoding("UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

				String vehicleMaintain = req.getParameter("vehicleMaintain");// 车辆申请
				if (StringUtils.isEmpty(vehicleMaintain))
					return "false";
				List<OaVehicleMaintain> oaVehicleMaintains = this.convertMaintain(vehicleMaintain);
				if (oaVehicleMaintains.size() != 1) {
					return "false";
				}
				OaVehicleMaintain oaVehicleMaintain = oaVehicleMaintains.get(0);
				return oaVehicleService.updateVehicleMaintain(oaVehicleMaintain);
			}
			/**
			 *只有已完成可以修改前端控制
			 * @param req
			 * @return
			 */
				@RequestMapping(value = "/vehicleMaintain/finish.do")
				public @ResponseBody Object vehicleMaintainfinish(HttpServletRequest req) {
					try {
						req.setCharacterEncoding("UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

					String vehicleMaintain = req.getParameter("vehicleMaintain");// 车辆申请
					if (StringUtils.isEmpty(vehicleMaintain))
						return "false";
					List<OaVehicleMaintain> oaVehicleMaintains = this.convertMaintain(vehicleMaintain);
					if (oaVehicleMaintains.size() != 1) {
						return "false";
					}
					OaVehicleMaintain oaVehicleMaintain = oaVehicleMaintains.get(0);
					return oaVehicleService.vehicleMaintainFinish(oaVehicleMaintain);
				}
			@RequestMapping(value="/vehicleMaintain/delete.do")
			public @ResponseBody Object vehicleMaintainDelete(HttpServletRequest req){
				String ids = req.getParameter("ids");
				String[] Ids = ids.split(",");
				if(Ids.length == 0){
					return "false";
				}
				return oaVehicleService.vehicleMaintainDelete(Ids);
			}
	private List<OaVehicleUsedRecord> convertApply(String vehicleApply) {

		JSONObject info = JSONObject.fromObject(vehicleApply);
		String beginTime = (String)info.get("beginTime");
		String planReturnTime = (String)info.get("planReturnTime");
		String trueReturnTime = (String)info.get("trueReturnTime");
		Date beginTimeDate = DateHandler.strToDate(beginTime,"yyyy-MM-dd");
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaVehicleUsedRecord> listUpdated = (List<OaVehicleUsedRecord>) JSONArray
				.toCollection(jsonArray, OaVehicleUsedRecord.class);
		for(OaVehicleUsedRecord oaVehicleUsedRecord : listUpdated){
			if(!StringUtils.isEmpty(beginTime)){
				oaVehicleUsedRecord.setBeginTime(DateHandler.strToDate(beginTime,"yyyy-MM-dd HH:mm:ss"));
			}
			if(!StringUtils.isEmpty(planReturnTime)){
				oaVehicleUsedRecord.setPlanReturnTime(DateHandler.strToDate(planReturnTime,"yyyy-MM-dd HH:mm:ss"));
			}
			if(!StringUtils.isEmpty(trueReturnTime)){
				oaVehicleUsedRecord.setTrueReturnTime(DateHandler.strToDate(trueReturnTime,"yyyy-MM-dd HH:mm:ss"));
			}
		}
		return listUpdated;
	}
	/**
	 * 车辆申请查看
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/vehicleApply/list.do")
	public @ResponseBody Object vehicleApplyList(HttpServletRequest req){
		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaVehicleService.getApplyByPage(keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}
	@RequestMapping(value="/vehicleApply/getById.do")
	public @ResponseBody Object vehicleApplygetById(HttpServletRequest req){
		String id = req.getParameter("vehicleUsedRecordId");
		Integer vehicleUsedRecordId;
		try{
			vehicleUsedRecordId = Integer.parseInt(id);
		}catch(Exception e){
			return "false";
		}
		// 处理json数据中的日期格式
				JsonConfig config = new JsonConfig();
				config.setIgnoreDefaultExcludes(false);
				config.registerJsonValueProcessor(Date.class,
						new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		return JSONObject.fromObject(oaVehicleService.getVehicleApplyById(vehicleUsedRecordId),config);
	}
	/**
	 * 车辆使用查看，已审核且还完车的
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/vehicleUse/list.do")
	public @ResponseBody Object vehicleUseList(HttpServletRequest req){
		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaVehicleService.getUseByPage(keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}
	@RequestMapping(value="/vehicleUse/delete.do")
	public @ResponseBody Object vehicleUseDelete(HttpServletRequest req){
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		if(Ids.length == 0){
			return "false";
		}
		return oaVehicleService.vehicleApplyDelete(Ids);
	}
	@RequestMapping(value="/vehicleUse/getById.do")
	public @ResponseBody Object vehicleUsegetById(HttpServletRequest req){
		String id = req.getParameter("vehicleUsedRecordId");
		Integer vehicleUsedRecordId;
		try{
			vehicleUsedRecordId = Integer.parseInt(id);
		}catch(Exception e){
			return "false";
		}
		// 处理json数据中的日期格式
				JsonConfig config = new JsonConfig();
				config.setIgnoreDefaultExcludes(false);
				config.registerJsonValueProcessor(Date.class,
						new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		return JSONObject.fromObject(oaVehicleService.getVehicleApplyById(vehicleUsedRecordId),config);
	}
	/**
	 * 车辆维修查看
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/vehicleMaintain/list.do")
	public @ResponseBody Object vehicleMaintainList(HttpServletRequest req){
		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));

		String keys = req.getParameter("keys");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaVehicleService.getMaintainByPage(keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}
	@RequestMapping(value="/vehicleMaintain/getById.do")
	public @ResponseBody Object vehicleMaintaingetById(HttpServletRequest req){
		String id = req.getParameter("vehicleMaintainId");
		Integer vehicleMaintainId;
		try{
			vehicleMaintainId = Integer.parseInt(id);
		}catch(Exception e){
			return "false";
		}
		// 处理json数据中的日期格式
				JsonConfig config = new JsonConfig();
				config.setIgnoreDefaultExcludes(false);
				config.registerJsonValueProcessor(Date.class,
						new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		return JSONObject.fromObject(oaVehicleService.getVehicleMaintainById(vehicleMaintainId),config);
	}
	/**
	 * 添加车辆维修申请,返回id用于插入附件
	 * @param req
	 * @return
	 */
	@Transactional
	@RequestMapping(value="/vehicleMaintain/insert.do")
	public @ResponseBody Object vehicleMaintainInsert(HttpServletRequest req){
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String vehicleMaintain = req.getParameter("vehicleMaintain");// 车辆申请
		if (StringUtils.isEmpty(vehicleMaintain))
			return "false";
		List<OaVehicleMaintain> oaVehicleMaintains = this.convertMaintain(vehicleMaintain);
		if (oaVehicleMaintains.size() != 1) {
			return "false";
		}
		OaVehicleMaintain oaVehicleMaintain = oaVehicleMaintains.get(0);
		return oaVehicleService.insertVehicleMaintain(oaVehicleMaintain);
	}
	/**
	 * 车辆维修申请，插入空记录,返回id用于插入附件
	 * 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/vehicleMaintain/insertNull.do")
	@Transactional(rollbackFor = Exception.class)
	public @ResponseBody
	Object vehicleMaintainInsertNull(HttpServletRequest req) throws Exception {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		OaVehicleMaintain oaVehicleMaintain = new OaVehicleMaintain();
		return oaVehicleService.insertNullVehicleMaintain(oaVehicleMaintain);
	}
	private List<OaVehicleMaintain> convertMaintain(String vehicleMaintain) {

		JSONObject info = JSONObject.fromObject(vehicleMaintain);		
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaVehicleMaintain> listUpdated = (List<OaVehicleMaintain>) JSONArray
				.toCollection(jsonArray, OaVehicleMaintain.class);
		return listUpdated;
	}
	/**
	 * 添加车辆保险
	 * 插入一条新纪录或修改保险日期时相应修改车辆表的保险日期
	 * @param req
	 * @return
	 */
	@Transactional
	@RequestMapping(value="/vehicleInsurance/insert.do")
	public @ResponseBody Object vehicleInsuranceInsert(HttpServletRequest req){
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String vehicleInsurance = req.getParameter("vehicleInsurance");// 车辆保险
		if (StringUtils.isEmpty(vehicleInsurance))
			return "false";
		List<OaVehicleInsurance> oaVehicleInsurances = this.convertInsurance(vehicleInsurance);
		if (oaVehicleInsurances.size() != 1) {
			return "false";
		}
		OaVehicleInsurance oaVehicleInsurance = oaVehicleInsurances.get(0);

		return oaVehicleService.insertVehicleInsurance(oaVehicleInsurance);
	}
	@RequestMapping(value="/vehicleInsurance/delete.do")
	public @ResponseBody Object vehicleInsuranceDelete(HttpServletRequest req){
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		if(Ids.length == 0){
			return "false";
		}
		return oaVehicleService.vehicleInsuranceDelete(Ids);
	}
	private List<OaVehicleInsurance> convertInsurance(String vehicleInsurance) {
		JSONObject info = JSONObject.fromObject(vehicleInsurance);
		String beginTime = (String)info.get("beginTime");
		String endTime = (String)info.get("endTime");
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaVehicleInsurance> listUpdated = (List<OaVehicleInsurance>) JSONArray
				.toCollection(jsonArray, OaVehicleInsurance.class);
		for(OaVehicleInsurance oaVehicleInsurance : listUpdated){
			if(!StringUtils.isEmpty(beginTime)){
				oaVehicleInsurance.setBeginTime(DateHandler.strToDate(beginTime,"yyyy-MM-dd"));
			}
			if(!StringUtils.isEmpty(endTime)){
				oaVehicleInsurance.setEndTime(DateHandler.strToDate(endTime,"yyyy-MM-dd"));
			}
		}
		return listUpdated;
	}
	/**
	 * 修改车辆保险
	 * 插入一条新纪录或修改保险日期时相应修改车辆表的保险日期
	 * @param req
	 * @return
	 */
	@Transactional
	@RequestMapping(value="/vehicleInsurance/update.do")
	public @ResponseBody Object vehicleInsuranceUpdate(HttpServletRequest req){
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String vehicleInsurance = req.getParameter("vehicleInsurance");// 车辆保险
		if (StringUtils.isEmpty(vehicleInsurance))
			return "false";
		List<OaVehicleInsurance> oaVehicleInsurances = this.convertInsurance(vehicleInsurance);
		if (oaVehicleInsurances.size() != 1) {
			return "false";
		}
		OaVehicleInsurance oaVehicleInsurance = oaVehicleInsurances.get(0);

		return oaVehicleService.updateVehicleInsurance(oaVehicleInsurance);
	}
	/**
	 * 分页返回所有车辆保险
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/vehicleInsurance/list.do")
	public @ResponseBody Object vehicleInsuranceList(HttpServletRequest req){
		String keys = req.getParameter("keys");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaVehicleService.getvehicleInsuranceByPageGroup(keys, pageSize, pageIndex);
		return JSONObject.fromObject(map);
	}	
	
	@RequestMapping(value = "/vehicleInsurance/listinfo.do")
	public @ResponseBody List<OaVehicleInsurance> getOaSuitCharging(String vehicleId) {
		
//		System.out.println("sssssssssssssssssssssssssssssssss");
		
		 List<HttpOaVehicleInsurance> list = oaVehicleService.getOaVehicle(vehicleId);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		
		return JSONArray.fromObject(list,config);
	}
	
	@RequestMapping(value="/vehicleInsurance/getById.do")
	public @ResponseBody Object vehicleInsurancegetById(HttpServletRequest req){
		String id = req.getParameter("vehicleInsuranceId");
		Integer vehicleInsuranceId;
		try{
			vehicleInsuranceId = Integer.parseInt(id);
		}catch(Exception e){
			return "false";
		}
		// 处理json数据中的日期格式
				JsonConfig config = new JsonConfig();
				config.setIgnoreDefaultExcludes(false);
				config.registerJsonValueProcessor(Date.class,
						new DateJsonValueProcessor("yyyy-MM-dd"));
		return JSONObject.fromObject(oaVehicleService.getVehicleInsuranceById(vehicleInsuranceId),config);
	}
	/**
	 * 添加油卡
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/oilCard/insert.do")
	public @ResponseBody Object oilCardInsert(HttpServletRequest req){
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String oilCard = req.getParameter("oilCard");// 车辆保险
		if (StringUtils.isEmpty(oilCard ))
			return "false";
		List<OaOilCard> oaOilCards = this.convertOilCard(oilCard);
		if (oaOilCards.size() != 1) {
			return "false";
		}
		OaOilCard oaOilCard = oaOilCards.get(0);

		return oaVehicleService.insertOilCard(oaOilCard);
	}
	/**
	 * 修改油卡
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/oilCard/update.do")
	public @ResponseBody Object oilCardUpdate(HttpServletRequest req){
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String oilCard = req.getParameter("oilCard");// 车辆保险
		if (StringUtils.isEmpty(oilCard ))
			return "false";
		List<OaOilCard> oaOilCards = this.convertOilCard(oilCard);
		if (oaOilCards.size() != 1) {
			return "false";
		}
		OaOilCard oaOilCard = oaOilCards.get(0);

		return oaVehicleService.updateOilCard(oaOilCard);
	}
	private List<OaOilCard> convertOilCard(String oilCard) {
		JSONObject info = JSONObject.fromObject(oilCard);
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaOilCard> listUpdated = (List<OaOilCard>) JSONArray
				.toCollection(jsonArray, OaOilCard.class);
		return listUpdated;
	}
	/**
	 * 分页返回所有车辆油卡,不设置数据权限
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/oilCard/list.do")
	public @ResponseBody Object oilCardList(HttpServletRequest req){
		String keys = req.getParameter("keys");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaVehicleService.getOilCardByPage(keys, pageSize, pageIndex);
		return JSONObject.fromObject(map);
	}
	/**
	 * 添加加油记录
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/oilCardDetail/insert.do")
	public @ResponseBody Object oilCardDetailInsert(HttpServletRequest req){
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String oilCardDetail = req.getParameter("oilCardDetail");// 车辆保险
		if (StringUtils.isEmpty(oilCardDetail))
			return "false";
		List<OaOilCardDetail> oaOilCardDetails = this.convertOilCardDetail(oilCardDetail);
		if (oaOilCardDetails.size() != 1) {
			return "false";
		}
		OaOilCardDetail oaOilCardDetail = oaOilCardDetails.get(0);

		return oaVehicleService.insertOilCardDetail(oaOilCardDetail);
	}
	/**
	 * 修改加油记录（实际不能修改，因为添加附件原因调用）
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/oilCardDetail/update.do")
	public @ResponseBody Object oilCardDetailUpdate(HttpServletRequest req){
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String oilCardDetail = req.getParameter("oilCardDetail");// 车辆保险
		if (StringUtils.isEmpty(oilCardDetail))
			return "false";
		List<OaOilCardDetail> oaOilCardDetails = this.convertOilCardDetail(oilCardDetail);
		if (oaOilCardDetails.size() != 1) {
			return "false";
		}
		OaOilCardDetail oaOilCardDetail = oaOilCardDetails.get(0);

		return oaVehicleService.updateOilCardDetail(oaOilCardDetail);
	}
	@RequestMapping(value = "/oilCardDetail/insertNull.do")
	@Transactional(rollbackFor = Exception.class)
	public @ResponseBody
	Object oilCardDetailInsertNull(HttpServletRequest req) throws Exception {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		OaOilCardDetail oaOilCardDetail = new OaOilCardDetail();
		return oaVehicleService.insertNullOilCardDetail(oaOilCardDetail);
	}
	private List<OaOilCardDetail> convertOilCardDetail(String oilCardDetail) {
		JSONObject info = JSONObject.fromObject(oilCardDetail);
		String ocdParTime = (String)info.get("ocdParTime");
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaOilCardDetail> listUpdated = (List<OaOilCardDetail>) JSONArray
				.toCollection(jsonArray, OaOilCardDetail.class);
		for(OaOilCardDetail oaOilCardDetail : listUpdated){
			if(!StringUtils.isEmpty(ocdParTime)){
				oaOilCardDetail.setOcdParTime(DateHandler.strToDate(ocdParTime,"yyyy-MM-dd HH:mm:ss"));
			}
		}
		return listUpdated;
	}
	/**
	 * 分页返回所有车辆油卡记录
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/oilCardDetail/list.do")
	public @ResponseBody Object oilCardDetailList(HttpServletRequest req){
		String keys = req.getParameter("keys");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaVehicleService.getOilCardDetailByPage(keys, pageSize, pageIndex);
		return JSONObject.fromObject(map);
	}
	@RequestMapping(value="/oilCardDetail/getById.do")
	public @ResponseBody Object oilCardDetailGetById(HttpServletRequest req){
		String id = req.getParameter("oilCardDetailId");
		Integer oilCardDetailId;
		try{
			oilCardDetailId = Integer.parseInt(id);
		}catch(Exception e){
			return "false";
		}
		// 处理json数据中的日期格式
				JsonConfig config = new JsonConfig();
				config.setIgnoreDefaultExcludes(false);
				config.registerJsonValueProcessor(Date.class,
						new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		return JSONObject.fromObject(oaVehicleService.getoilCardDetailById(oilCardDetailId),config);
	}
	@RequestMapping(value="/oilCardDetail/delete.do")
	public @ResponseBody Object oilCardDetailDelete(HttpServletRequest req){
		String ids = req.getParameter("ids");
		String[] Ids = ids.split(",");
		if(Ids.length == 0){
			return "false";
		}
		return oaVehicleService.oilCardDetail(Ids);
	}
	@RequestMapping(value="/oilCardIdName/list.do")
	public @ResponseBody Object oilCardIdNameList(HttpServletRequest req){
		List<OaOilCard> oilCards = oaVehicleService.getOilCardIdName();
		JSONArray jsonArray = new JSONArray();
		for(OaOilCard oaCard : oilCards){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("oilCardId", oaCard.getOilCardId());
			jsonObject.put("ocNumber", oaCard.getOcNumber());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	/**
	 * 派车单查看，需要权限控制
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/driverView/list.do")
	public @ResponseBody Object driverViewList(HttpServletRequest req){
		String keys = req.getParameter("keys");
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));
		Map<String, Object> map = oaVehicleService.getDriverViewByPage(keys, pageSize, pageIndex);
		return JSONObject.fromObject(map);		
	}
	/**
	 * 司机查看详情时置为已读
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/driverView/getById.do")
	public @ResponseBody Object driverViewgetById(HttpServletRequest req){
		String id = req.getParameter("vehicleUsedRecordId");
		Integer vehicleUsedRecordId;
		try{
			vehicleUsedRecordId = Integer.parseInt(id);
		}catch(Exception e){
			return "false";
		}
		// 处理json数据中的日期格式
				JsonConfig config = new JsonConfig();
				config.setIgnoreDefaultExcludes(false);
				config.registerJsonValueProcessor(Date.class,
						new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		return JSONObject.fromObject(oaVehicleService.getDriverVehicleApplyById(vehicleUsedRecordId),config);
	}
	/**
	 * 车辆维修申请人范围查询
	 * @param req
	 * @param sysEmployee
	 * @return
	 */
	@RequestMapping(value = "/vehicleMaintain/listIdName.do")
	public @ResponseBody Object vehicleMaintainlistIdName(HttpServletRequest req, SysEmployee sysEmployee) {
		List<HttpEmployee> httpEmployees = employeeService.listIdNameEmployees();
		JSONArray jsonArray = new JSONArray();
		for(HttpEmployee httpEmployee : httpEmployees){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("employeeId", httpEmployee.getEmployeeId());
			jsonObject.put("employeeNameDepartment", httpEmployee.getEmployeeName()+"("+Const.ORGANIZATIONSTRUCTURE_TREE.getNode(httpEmployee.getEmployeeDepartment()).getName()+")");
			jsonArray.add(jsonObject);
		}
 		return  jsonArray;
	}
	/**
	 * 车辆申请申请人范围查询
	 * @param req
	 * @param sysEmployee
	 * @return
	 */
	@RequestMapping(value = "/vehicleApply/listIdName.do")
	public @ResponseBody Object vehicleApplylistIdName(HttpServletRequest req, SysEmployee sysEmployee) {
		List<HttpEmployee> httpEmployees = employeeService.listIdNameEmployees();
		JSONArray jsonArray = new JSONArray();
		for(HttpEmployee httpEmployee : httpEmployees){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("employeeId", httpEmployee.getEmployeeId());
			jsonObject.put("employeeNameDepartment", httpEmployee.getEmployeeName()+"("+Const.ORGANIZATIONSTRUCTURE_TREE.getNode(httpEmployee.getEmployeeDepartment()).getName()+")");
			jsonArray.add(jsonObject);
		}
 		return  jsonArray;
	}
	/**
	 * 车辆使用记录申请人范围查询
	 * @param req
	 * @param sysEmployee
	 * @return
	 */
	@RequestMapping(value = "/vehicleUse/listIdName.do")
	public @ResponseBody Object vehicleUselistIdName(HttpServletRequest req, SysEmployee sysEmployee) {
		List<HttpEmployee> httpEmployees = employeeService.listIdNameEmployees();
		JSONArray jsonArray = new JSONArray();
		for(HttpEmployee httpEmployee : httpEmployees){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("employeeId", httpEmployee.getEmployeeId());
			jsonObject.put("employeeNameDepartment", httpEmployee.getEmployeeName()+"("+Const.ORGANIZATIONSTRUCTURE_TREE.getNode(httpEmployee.getEmployeeDepartment()).getName()+")");
			jsonArray.add(jsonObject);
		}
 		return  jsonArray;
	}
	/**
	 * 派车单申请人范围查询
	 * @param req
	 * @param sysEmployee
	 * @return
	 */
	@RequestMapping(value = "/driverView/listIdName.do")
	public @ResponseBody Object driverViewlistIdName(HttpServletRequest req, SysEmployee sysEmployee) {
		List<HttpEmployee> httpEmployees = employeeService.listIdNameEmployees();
		JSONArray jsonArray = new JSONArray();
		for(HttpEmployee httpEmployee : httpEmployees){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("employeeId", httpEmployee.getEmployeeId());
			jsonObject.put("employeeNameDepartment", httpEmployee.getEmployeeName()+"("+Const.ORGANIZATIONSTRUCTURE_TREE.getNode(httpEmployee.getEmployeeDepartment()).getName()+")");
			jsonArray.add(jsonObject);
		}
 		return  jsonArray;
	}
}
