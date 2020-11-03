package com.sliansoft.slianOA.mobile.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.OaAssetChange;
import com.sliansoft.slianOA.dataaccess.model.OaAssetChangeDetail;
import com.sliansoft.slianOA.service.OaAssetChangeDetailService;
import com.sliansoft.slianOA.service.OaAssetChangeService;
import com.sliansoft.slianOA.service.httpModels.HttpOaAssetChange;
import com.sliansoft.slianOA.service.utils.Const;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;

@Controller
@RequestMapping(value = "/mobile-ajax/auth/oaAssetChange")
public class OaAssetChangeMobileController {

	@Autowired
	private OaAssetChangeService oaAssetChangeService;
	@Autowired
	private OaAssetChangeDetailService oaAssetChangeDetailService;
	@Autowired
	private HttpSession session;

	/**
	 * 我的申购记录,需要数据权限，选择部门为空
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/myApplyBuy/list.do")
	public @ResponseBody
	Object myABlist(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },
						(Date) null));

		String keys = req.getParameter("keys");
		SysEmployee sysEmployee = (SysEmployee) session.getAttribute("employee");
		if (keys == null || "{}".equals(keys)) {
			keys = "{\"changeType\":\"申购\",\"creator\":"+sysEmployee.getEmployeeId()+"}";
		} else {
			try {
				keys = URLDecoder.decode(keys, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "false";
			}
			keys = keys.substring(0, keys.length() - 1)
					+ ",\"changeType\":\"申购\",\"creator\":"+sysEmployee.getEmployeeId()+"}";
		}
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaAssetChangeService.getByPage(keys,
				pageSize, pageIndex);

		return JSONObject.fromObject(map);
	}

	/**
	 * 申购查询
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/applyBuy/list.do")
	public @ResponseBody
	Object ablist(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },
						(Date) null));

		String keys = req.getParameter("keys");
		if (keys == null || "{}".equals(keys)) {
			keys = "{\"changeType\":\"申购\"}";
		} else {
			try {
				keys = URLDecoder.decode(keys, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "false";
			}
			keys = keys.substring(0, keys.length() - 1)
					+ ",\"changeType\":\"申购\"}";
		}
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaAssetChangeService.getByPage(keys,
				pageSize, pageIndex);

		return JSONObject.fromObject(map);
	}

	/**
	 * 入库查询
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/entry/list.do")
	public @ResponseBody
	Object elist(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },
						(Date) null));

		String keys = req.getParameter("keys");
		if (keys == null || "{}".equals(keys)) {
			keys = "{\"changeType\":\"入库\"}";
		} else {
			try {
				keys = URLDecoder.decode(keys, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "false";
			}
			keys = keys.substring(0, keys.length() - 1)
					+ ",\"changeType\":\"入库\"}";
		}
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaAssetChangeService.getByPage(keys,
				pageSize, pageIndex);

		return JSONObject.fromObject(map);
	}

	/**
	 * 出库查询
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/out/list.do")
	public @ResponseBody
	Object olist(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },
						(Date) null));

		String keys = req.getParameter("keys");
		if (keys == null || "{}".equals(keys)) {
			keys = "{\"changeType\":\"出库\"}";
		} else {
			try {
				keys = URLDecoder.decode(keys, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "false";
			}
			keys = keys.substring(0, keys.length() - 1)
					+ ",\"changeType\":\"出库\"}";
		}
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaAssetChangeService.getByPage(keys,
				pageSize, pageIndex);

		return JSONObject.fromObject(map);
	}

	/**
	 * 查询物品的出入库信息
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/detail/list.do")
	public @ResponseBody
	Object dlist(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },
						(Date) null));
		Integer assetId;
		try {
			assetId = Integer.parseInt(req.getParameter("assetId"));// 物品id
		} catch (Exception e) {
			return "false";
		}

		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));

		// return
		// JSONObject.fromObject(oaAssetChangeDetailService.getHttpOaAssetChangeDetailsByAssetId(assetId));
		return JSONArray.fromObject(oaAssetChangeDetailService
				.getHttpOaAssetChangeDetailsByAssetId(assetId), config);
	}

	/**
	 * 添加申购、申领、出库、入库、报修信息 前端应设置类型
	 * 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/insert.do")
	@Transactional(rollbackFor = Exception.class)
	public @ResponseBody
	Object insert(HttpServletRequest req) throws Exception {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String change = req.getParameter("change");// 申购基础信息
		String detail = req.getParameter("detail");// 多条请购物品信息
		if (StringUtils.isEmpty(change) || StringUtils.isEmpty(detail))
			return "false";
		try {
			change = URLDecoder.decode(change, "UTF-8");
			detail = URLDecoder.decode(detail, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "false";
		}

		List<OaAssetChange> listoaAssetChanges = this.convertChange(change);
		if (listoaAssetChanges.size() != 1) {
			return "false";
		}
		
		OaAssetChange oaAssetChange = listoaAssetChanges.get(0);
		List<OaAssetChangeDetail> oaAssetChangeDetails = this.convertDetai(detail);
		if("入库".equals(oaAssetChange.getChangeType())||"出库".equals(oaAssetChange.getChangeType())){
			for(OaAssetChangeDetail oaAssetChangeDetail : oaAssetChangeDetails){
				if(StringUtils.isEmpty(oaAssetChangeDetail.getDetailName())){
					oaAssetChangeDetail.setDetailName("无");
				}
			}		
		}
		if("出库".equals(oaAssetChange.getChangeType())){
			for(OaAssetChangeDetail oaAssetChangeDetail : oaAssetChangeDetails){
				if(oaAssetChangeDetailService.isAvailuable(oaAssetChangeDetail)){
					continue;
				}else{
					return Const.OAASSET_TREE.getNode(oaAssetChangeDetail.getAssetId()).getName()+"("+oaAssetChangeDetail.getDetailName()+")" +"库存不足！";
				}
			}
			
		}
		oaAssetChange.setType(oaAssetChange.getChangeType());
		SysEmployee sysEmployee = (SysEmployee) session.getAttribute("employee");
		oaAssetChange.setDepartmentId(sysEmployee.getEmployeeDepartment());// 微信端申请人部门就是操作人部门
		if (!"success".equals(oaAssetChangeService.insert(oaAssetChange))) {
			return "false";
		}
		System.out.println("abbbbbbbbbbbbbbbbbbbbbbbcccccccccccc");
		for (OaAssetChangeDetail oaAssetChangeDetail : oaAssetChangeDetails) {
			oaAssetChangeDetail.setAssetChangeId(oaAssetChange
					.getAssetChangeId());
			oaAssetChangeDetail.setEventTime(oaAssetChange.getEventTime());
			oaAssetChangeDetail.setChangeType(oaAssetChange.getChangeType());// 申购、申领、出库、入库、报修
			if (!"success".equals(oaAssetChangeDetailService
					.insert(oaAssetChangeDetail))) {
				return false;
			}
		}
		return "success";
	}

	/**
	 * 添加申领信息
	 * 
	 * @param req
	 * @return
	 */
	/*
	 * @RequestMapping(value = "/applyReceive/insert.do")
	 * 
	 * @Transactional public @ResponseBody Object
	 * applyRInsert(HttpServletRequest req) { try {
	 * req.setCharacterEncoding("UTF-8"); } catch (UnsupportedEncodingException
	 * e) { e.printStackTrace(); } String change = req.getParameter("change");//
	 * 申领基础信息 String detail = req.getParameter("detail");// 多条申领物品信息 if
	 * (StringUtils.isEmpty(change) || StringUtils.isEmpty(detail)) return
	 * "false"; List<OaAssetChange> listoaAssetChanges =
	 * this.convertChange(change); if (listoaAssetChanges.size() != 1) { return
	 * "false"; } OaAssetChange oaAssetChange = listoaAssetChanges.get(0); if
	 * (!"success".equals(oaAssetChangeService.insert(oaAssetChange))) { return
	 * "false"; } List<OaAssetChangeDetail> oaAssetChangeDetails =
	 * this.convertDetai(detail); for(OaAssetChangeDetail oaAssetChangeDetail :
	 * oaAssetChangeDetails){
	 * oaAssetChangeDetail.setAssetChangeId(oaAssetChange.getAssetChangeId());
	 * oaAssetChangeDetail.setChangeType("申领");
	 * if(!"success".equals(oaAssetChangeDetailService
	 * .insert(oaAssetChangeDetail))){ return false; } } return "success"; }
	 */
	/**
	 * 添加入库信息
	 * 
	 * @param req
	 * @return
	 */
	/*
	 * @RequestMapping(value = "/entry/insert.do")
	 * 
	 * @Transactional public @ResponseBody Object entryInsert(HttpServletRequest
	 * req) { try { req.setCharacterEncoding("UTF-8"); } catch
	 * (UnsupportedEncodingException e) { e.printStackTrace(); } String change =
	 * req.getParameter("change");// 申领基础信息 String detail =
	 * req.getParameter("detail");// 多条申领物品信息 if (StringUtils.isEmpty(change) ||
	 * StringUtils.isEmpty(detail)) return "false"; List<OaAssetChange>
	 * listoaAssetChanges = this.convertChange(change); if
	 * (listoaAssetChanges.size() != 1) { return "false"; } OaAssetChange
	 * oaAssetChange = listoaAssetChanges.get(0); if
	 * (!"success".equals(oaAssetChangeService.insert(oaAssetChange))) { return
	 * "false"; } List<OaAssetChangeDetail> oaAssetChangeDetails =
	 * this.convertDetai(detail); for(OaAssetChangeDetail oaAssetChangeDetail :
	 * oaAssetChangeDetails){
	 * oaAssetChangeDetail.setAssetChangeId(oaAssetChange.getAssetChangeId());
	 * oaAssetChangeDetail.setChangeType("入库");
	 * if(!"success".equals(oaAssetChangeDetailService
	 * .insert(oaAssetChangeDetail))){ return false; } } return "success"; }
	 */
	/**
	 * 我的申领记录
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/myApplyReceive/list.do")
	public @ResponseBody
	Object myARlist(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },
						(Date) null));
		SysEmployee sysEmployee = (SysEmployee) session.getAttribute("employee");
		String keys = req.getParameter("keys");
		if (keys == null || "{}".equals(keys)) {
			keys = "{\"changeType\":\"申领\",\"creator\":"+sysEmployee.getEmployeeId()+"}";
		} else {
			try {
				keys = URLDecoder.decode(keys, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "false";
			}
			keys = keys.substring(0, keys.length() - 1)
					+ ",\"changeType\":\"申领\",\"creator\":"+sysEmployee.getEmployeeId()+"}";
		}
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaAssetChangeService.getByPage(keys,
				pageSize, pageIndex);

		return JSONObject.fromObject(map);
	}

	/**
	 * 申领查询
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/applyReceive/list.do")
	public @ResponseBody
	Object arlist(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },
						(Date) null));

		String keys = req.getParameter("keys");
		if (keys == null || "{}".equals(keys)) {
			keys = "{\"changeType\":\"申领\"}";
		} else {
			try {
				keys = URLDecoder.decode(keys, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "false";
			}
			keys = keys.substring(0, keys.length() - 1)
					+ ",\"changeType\":\"申领\"}";
		}
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaAssetChangeService.getByPage(keys,
				pageSize, pageIndex);

		return JSONObject.fromObject(map);
	}

	/**
	 * 我的报修记录,需要数据权限，选择部门为空
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/myRepair/list.do")
	public @ResponseBody
	Object myRlist(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },
						(Date) null));

		String keys = req.getParameter("keys");
		SysEmployee sysEmployee = (SysEmployee) session.getAttribute("employee");
		if (keys == null || "{}".equals(keys)) {
			keys = "{\"changeType\":\"报修\",\"creator\":"+sysEmployee.getEmployeeId()+"}";
		} else {
			try {
				keys = URLDecoder.decode(keys, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "false";
			}
			keys = keys.substring(0, keys.length() - 1)
					+ ",\"changeType\":\"报修\",\"creator\":"+sysEmployee.getEmployeeId()+"}";
		}
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaAssetChangeService.getByPage(keys,
				pageSize, pageIndex);

		return JSONObject.fromObject(map);
	}

	/**
	 * 报修查询
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/repair/list.do")
	public @ResponseBody
	Object rlist(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd HH:mm:ss" },
						(Date) null));

		String keys = req.getParameter("keys");
		if (keys == null || "{}".equals(keys)) {
			keys = "{\"changeType\":\"报修\"}";
		} else {
			try {
				keys = URLDecoder.decode(keys, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "false";
			}
			keys = keys.substring(0, keys.length() - 1)
					+ ",\"changeType\":\"报修\"}";
		}
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map = oaAssetChangeService.getByPage(keys,
				pageSize, pageIndex);

		return JSONObject.fromObject(map);
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

		String change = req.getParameter("change");// 只能修改基本信息（审核意见）、明细不能修改？？
		if (StringUtils.isEmpty(change))
			return "false";
		try {
			change = URLDecoder.decode(change, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "false";
		}
		List<OaAssetChange> listoaAssetChanges = this.convertChange(change);
		if (listoaAssetChanges.size() != 1) {
			return "false";
		}
		OaAssetChange oaAssetChange = listoaAssetChanges.get(0);
		if (!"success".equals(oaAssetChangeService.update(oaAssetChange))) {
			return "false";
		}

		return "success";
	}

	private List<OaAssetChange> convertChange(String change) {

		JSONObject info = JSONObject.fromObject(change);
		String eventTime = (String)info.get("eventTime");
		JSONArray jsonArray = JSONArray.fromObject(info);
		@SuppressWarnings("unchecked")
		List<OaAssetChange> listUpdated = (List<OaAssetChange>) JSONArray
				.toCollection(jsonArray, OaAssetChange.class);
		for(OaAssetChange oaAssetChange : listUpdated){
			if(!StringUtils.isEmpty(eventTime)){
				oaAssetChange.setEventTime(DateHandler.strToDate(eventTime, "yyyy-MM-dd HH:mm:ss"));
			}
		}
		return listUpdated;
	}

	private List<OaAssetChangeDetail> convertDetai(String detail) {

		// JSONObject info = JSONObject.fromObject(detail);
		JSONArray jsonArray = JSONArray.fromObject(detail);
		@SuppressWarnings("unchecked")
		List<OaAssetChangeDetail> listUpdated = (List<OaAssetChangeDetail>) JSONArray
				.toCollection(jsonArray, OaAssetChangeDetail.class);
		return listUpdated;
	}

	/**
	 * 资产清单查询（查看入库信息但是库存还有的）
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/inventory/list.do")
	public @ResponseBody
	Object inventoryList(HttpServletRequest req) {

		// 注册时间转换器，处理传入的JSON数据中的日期格式
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpherEx(new String[] { "yyyy-MM-dd" }, (Date) null));
		Integer assetId;
		try {
			assetId = Integer.parseInt(req.getParameter("assetId"));// 物品id
		} catch (Exception e) {
			return "false";
		}
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		return JSONArray.fromObject(oaAssetChangeDetailService
				.getHttpOaAssetChangeDetailsByAssetId2(assetId), config);
	}
	/*
	 * @RequestMapping(value = "/delete.do") public @ResponseBody Object
	 * delete(HttpServletRequest req) { String ids = req.getParameter("ids");
	 * String[] Ids = ids.split(","); return newsService.deleteById(Ids); }
	 */
	
	
	
	/**
	 * 详情：申购查询、入库查询、出库查询、申领查询、报修查询
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/detail/getById.do")
	public @ResponseBody
	Object getById(HttpServletRequest req) {

		String id = req.getParameter("assetChangeId");
		Integer assetChangeId;
		try{
			assetChangeId = Integer.parseInt(id);
		}catch(Exception e){
			return "false";
		}
		HttpOaAssetChange httpOaAssetChange = oaAssetChangeService.applyBuyGetById(assetChangeId);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		return JSONObject.fromObject(httpOaAssetChange, config);
	}
}
