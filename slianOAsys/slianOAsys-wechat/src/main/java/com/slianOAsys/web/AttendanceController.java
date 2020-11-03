package com.slianOAsys.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slianOAsys.aes.AesException;
import com.slianOAsys.aes.WXBizMsgCrypt;
import com.slianOAsys.service.AttendanceService;
import com.slianOAsys.service.impl.CoreServiceImpl;
import com.slianOAsys.util.Constants;
import com.slianOAsys.util.DateHandler;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/attencontroller")
public class AttendanceController {
	private String token = Constants.TOKEN;
	private String encodingAESKey = Constants.encodingAESKey;
	private String corpId = Constants.CORPID;
	private String msg = "";
	@Autowired
	private AttendanceService attendanceService;

	@RequestMapping(value = { "/attendance.do" }, method = RequestMethod.GET)
	public void attendanceGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 微信加密签名
		String msg_signature = request.getParameter("msg_signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		System.out.println("request=" + request.getRequestURL());
		PrintWriter out = response.getWriter();
		// ͨ通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		String result = null;
		try {
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(token, encodingAESKey, corpId);
			result = wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);
		} catch (AesException e) {
			e.printStackTrace();
		}
		if (result == null) {
			result = token;
		}
		out.print(result);
		out.close();
		out = null;
	}
	@RequestMapping(value = {"/attendance.do"},method = RequestMethod.POST)
	public void attendancePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 微信加密签名
		String msg_signature = request.getParameter("msg_signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		InputStream inputStream = request.getInputStream();
		String postData = IOUtils.toString(inputStream, "UTF-8");
		System.out.println(postData);
		// String msg = "";
		WXBizMsgCrypt wxcpt = null;
		try {
			wxcpt = new WXBizMsgCrypt(token, encodingAESKey, corpId);
			// 解密消息
			msg = wxcpt.DecryptMsg(msg_signature, timestamp, nonce, postData);
		} catch (AesException e) {
			e.printStackTrace();
		}
		System.out.println("msg=" + msg);
		// 对消息经行处理
		String respMessage = CoreServiceImpl.processRequest(msg);
		System.out.println("respMessage=" + respMessage);

		String encryptMsg = "";
		try {
			// 加密回复消息
			encryptMsg = wxcpt.EncryptMsg(respMessage, timestamp, nonce);
		} catch (AesException e) {
			e.printStackTrace();
		}
		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(encryptMsg);
		out.close();
	}

	@RequestMapping(value = "/signin.do")
	public JSONObject signin(HttpServletRequest request,HttpServletResponse response){
		String	latitude = request.getParameter("latitude").trim();
		String	longitude = request.getParameter("longitude").trim();
		String userId = request.getParameter("userId").trim();
		System.out.println(longitude);
		System.out.println(latitude);
		System.out.println(userId);
		JSONObject jo  = new JSONObject();
		jo = attendanceService.signInJudge(Double.parseDouble(latitude), Double.parseDouble(longitude),userId);
		return jo;
	}
	@RequestMapping(value = "/signoff.do")
	public JSONObject signoff(HttpServletRequest request){
		String	latitude = request.getParameter("latitude").trim();
		String	longitude = request.getParameter("longitude").trim();
		String userId = request.getParameter("userId").trim();
		JSONObject jo  = new JSONObject();
		jo = attendanceService.signoffJudge(Double.parseDouble(latitude),Double.parseDouble(longitude),userId);
		return jo;
	}
	@RequestMapping(value="/attendanceCalendar.do")
	public @ResponseBody List<JSONObject> attendanceCalendar(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将获取到的string类型的开始与结束时间格式化
		String startTime = request.getParameter("startTime").trim();
		String endTime = request.getParameter("endTime").trim();
		String userId = request.getParameter("userId").trim();
		//Date startDate = DateHandler.strToDate(startTime1, "yyyy-MM-dd");
		//Date endDate = DateHandler.strToDate(endTime1, "yyyy-MM-dd");
		//String startTime = DateHandler.dateToStr(startDate, "yyyy-MM-dd");
		//String endTime = DateHandler.dateToStr(endDate, "yyyy-MM-dd");
		/*try {
			attenStatus = new String(attenStatus.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		List<JSONObject> jsonList = null;
		jsonList = attendanceService.attendanceCalendar(startTime, endTime, userId);
		return jsonList;
		//return "111";
	}
	@RequestMapping(value="/showAttendanceInfo.do")
	public @ResponseBody JSONObject showAttendanceInfo(HttpServletRequest request,HttpServletResponse response){
		JSONObject json = new JSONObject();
		String userId = request.getParameter("userId").trim();
		json = attendanceService.showAttendanceInfo(userId);
		return json;
	}
	@RequestMapping(value="/submitAppeal.do")
	public @ResponseBody JSONObject submitAppeal(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		String formUserId = request.getParameter("formUserId").trim();
		String toUserId = request.getParameter("toUserId").trim();
		String content = request.getParameter("content").trim();
		String flag = request.getParameter("flag").trim();
		json = attendanceService.submitAppeal(formUserId, toUserId, content, flag);
		return json;
	}
	@RequestMapping(value="/showAppeal.do")
	public @ResponseBody List<JSONObject> showAppeal(HttpServletRequest request,HttpServletResponse response){
		/*try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		List<JSONObject> jsonList = null;
		String userId = request.getParameter("userId").trim();
		String status = request.getParameter("status").trim();
		try {
			status = new String(status.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("userId:"+userId);
		System.out.println("status:"+status);
		
		jsonList = attendanceService.showAppeal(userId, status);
		return jsonList;
	}
	@RequestMapping(value="/showAppealNeedToHandled.do")
	public @ResponseBody List<JSONObject> showAppealNeedToHandled(HttpServletRequest request,HttpServletResponse response){
		/*try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		List<JSONObject> jsonList = null;
		String userId = request.getParameter("userId").trim();
		String status = request.getParameter("status").trim();
		try {
			status = new String(status.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonList = attendanceService.showAppealNeedToHandled(userId, status);
		return jsonList;
	}
	@RequestMapping(value="/handleAppeal.do")
	public @ResponseBody JSONObject handleAppeal(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		String userId = request.getParameter("userId").trim();
		String appealTime = request.getParameter("appealTime").trim();
		String abnormalStatus = request.getParameter("abnormalStatus").trim();
		String handleStatus = request.getParameter("handleStatus").trim();
		json = attendanceService.handleAppeal(userId, appealTime, abnormalStatus, handleStatus);
		return json;
	}
}
