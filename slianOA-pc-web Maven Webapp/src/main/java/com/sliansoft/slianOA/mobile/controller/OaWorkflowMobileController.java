package com.sliansoft.slianOA.mobile.controller;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.dataaccess.model.OaWorkflow;
import com.sliansoft.slianOA.service.OaWorkflowCustomService;
import com.sliansoft.slianOA.service.OaWorkflowService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/mobile-ajax/auth/oaWorkflow")
public class OaWorkflowMobileController {

	@Autowired
	private OaWorkflowService oaWorkflowService;
	@Autowired
	private OaWorkflowCustomService oaWorkflowCustomService;
	@Autowired
	private HttpSession session;
	
	/*
	 * 我的代办模块，查询待办列表
	 */
	@RequestMapping(value="/list.do")
	public @ResponseBody Object search(HttpServletRequest req){
		
		String keys = req.getParameter("keys");
		Integer pageNow = Integer.parseInt(req.getParameter("pageNow"));
		int pageSize = 15;
		System.out.println(keys+pageNow);
		
		// 处理乱码的情况
		try{

			keys = URLDecoder.decode(keys , "utf-8");

		}catch(Exception e){

				e.printStackTrace();

		}
		
		// keys: {"workflowCustomId":"收文","title":"titleA"}
		JSONObject jkeys = JSONObject.fromObject(keys);
		
		if(jkeys.containsKey("workflowCustomId")){
			String ckeys = "{\"name\":\"" + jkeys.getString("workflowCustomId") + "\"}";
//			Const.OAWORKFLOWCUSTOM_MAP.get("oa_document").getWorkflowCustomId();
			
			Map<String,Object> map = oaWorkflowCustomService.getByPage(ckeys, 1, 1);
			JSONArray array = (JSONArray) map.get("rows");
			System.out.println("workflowCustomId: "+array.getJSONObject(0).getInt("workflowCustomId")+ckeys);
			jkeys.put("workflowCustomId", array.getJSONObject(0).get("workflowCustomId").toString());
		}
		
		String nkeys = jkeys.toString();
		System.out.println("keys=" + nkeys);
				
		Map<String,Object> res = oaWorkflowService.getByPage(nkeys, pageSize, pageNow);
		
		return JSONObject.fromObject(res);
	}
	
	/*
	 * 更新审批、查看意见及审批结果
	 */
	@RequestMapping(value="/updateWorkflow.do")
	public @ResponseBody String updateWorkflow(HttpServletRequest req){
		
		String workflowId = req.getParameter("workflowId");
		String workflowOpinion = req.getParameter("workflowOpinion");
		String workflowResult = req.getParameter("workflowResult");
//		int employeeId = ((Employee)session.getAttribute("employee")).getEmployeeId();
		// 处理乱码的情况
		try{

			workflowOpinion = URLDecoder.decode(workflowOpinion , "utf-8");
			workflowResult = URLDecoder.decode(workflowResult , "utf-8");

		}catch(Exception e){

				e.printStackTrace();

		}
		
		OaWorkflow oaWorkflow = new OaWorkflow();

		oaWorkflow.setWorkflowId((Integer.parseInt(workflowId)));
		oaWorkflow.setWorkflowOpinion(workflowOpinion);
		oaWorkflow.setWorkflowResult(workflowResult);
//		oaWorkflow.setEmployeeId(employeeId);  这个地方不能设置哦
		
		String res = oaWorkflowService.update(oaWorkflow);
		return res; // success false
	}
	
}
