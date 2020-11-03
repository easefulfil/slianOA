package com.sliansoft.slianOA.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.service.OaAssetChangeDetailService;
import com.sliansoft.slianOA.service.httpModels.HttpOaAssetChangeDetail;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;

@Controller
@RequestMapping(value="/oaAssetChangeDetail")
public class OaAssetChangeDetailController {

	@Autowired
	private OaAssetChangeDetailService oaAssetChangeDetailService;
	/**
	 * 分页
	   * TODO 请在此处添加注释
	   * @param req
	   * @return
	 */
	@RequestMapping(value="/list.do")
	public @ResponseBody Object list(HttpServletRequest req){
			Integer assetChangeId = 0;
			try{
				assetChangeId = Integer.parseInt(req.getParameter("assetChangeId"));
			}catch(Exception e){
				return "error";
			}
			Integer pageSize = Integer.parseInt(req.getParameter("rows"));
			Integer pageIndex = Integer.parseInt(req.getParameter("page"));

			return oaAssetChangeDetailService.getHttpOaAssetChangeDetailsByAssetChangeId(assetChangeId, pageSize, pageIndex);
	
	}
	/**
	 * 不分页
	   * TODO 请在此处添加注释
	   * @param req
	   * @return
	 */
	@RequestMapping(value="/all/list.do")
	public @ResponseBody Object allList(HttpServletRequest req){
			Integer assetChangeId = 0;
			try{
				assetChangeId = Integer.parseInt(req.getParameter("assetChangeId"));
			}catch(Exception e){
				return "error";
			}
			return oaAssetChangeDetailService.getAllDetailsByAssetChangeId(assetChangeId);
	
	}
	
}
