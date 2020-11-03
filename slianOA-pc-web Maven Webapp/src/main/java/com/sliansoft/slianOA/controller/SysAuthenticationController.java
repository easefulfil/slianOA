package com.sliansoft.slianOA.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.SysAuthentication;
import com.sliansoft.slianOA.service.AuthenticationInfoService;
import com.sliansoft.slianOA.service.httpModels.HttpJson;


@Controller
@RequestMapping(value = "/auth")
public class SysAuthenticationController {

	@Autowired
	private AuthenticationInfoService authenticationInfoService;


	@RequestMapping(value = "/getAuthenticationInfo.do")
	public @ResponseBody List<SysAuthentication> getAuthenticationInfo(String userId) {
		
		
		
		return authenticationInfoService.getAuthenticationInfo(userId);
	}
	
	
	@RequestMapping(value = "/delete.do")
	public @ResponseBody
	HttpJson del(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		
		HttpJson j = new HttpJson();
		
		if (id == null || "".equals(id)){
			j.setSuccess(false);
			j.setMsg("请选择删除的帐号！");
			return j;
			
		}
	
		if (authenticationInfoService.delete(id)) {
			j.setSuccess(true);
			j.setMsg("帐号删除成功!");
		}else{
			
			j.setSuccess(false);
			j.setMsg("帐号删除失败!");
		}
		
		return j;

	}

	// 角色更新
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/save.do")
	public @ResponseBody HttpJson save(HttpServletRequest request) throws UnsupportedEncodingException {

		request.setCharacterEncoding("UTF-8");

		JSONObject jAuthInfo = JSONObject.fromObject( request.getParameter("authencationInfo"));
		jAuthInfo.remove("confirmPassword");
		SysAuthentication authInfo =  (SysAuthentication)JSONObject.toBean(jAuthInfo,SysAuthentication.class);

		authInfo.setStatus("启用");
		
		HttpJson j = new HttpJson();

		// do insert
		if (authInfo.getId() == null) {

			if (authenticationInfoService.insert(authInfo)) {
				j.setSuccess(true);
				j.setMsg("新增保存成功!");
			} else {
				j.setSuccess(false);
				j.setMsg("新增保存失败!");
			}

		} else { // do update
			
			
			if (authenticationInfoService.updata(authInfo)) {
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
