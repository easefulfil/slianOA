package com.slianOAsys.web;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slianOAsys.aes.AesException;
import com.slianOAsys.aes.WXBizMsgCrypt;
import com.slianOAsys.service.impl.CoreServiceImpl;
import com.slianOAsys.util.Constants;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping(value = "/entrance")
public class EntranceWController {
	private String token = Constants.TOKEN;
	private String encodingAESKey = Constants.encodingAESKey;
	private String corpId = Constants.CORPID;
	private String msg ="";
	 @Autowired
	 private BasicDataSource dataEntanceGuardSource;

		@RequestMapping(value = { "/entrance.do"},method = RequestMethod.GET)
		public void meetingGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
			//微信加密签名
			String msg_signature = request.getParameter("msg_signature");
			//时间戳
			String timestamp = request.getParameter("timestamp");
			//随机数
			String nonce = request.getParameter("nonce");
			//随机字符串
			String echostr = request.getParameter("echostr");
			
			System.out.println("request=" + request.getRequestURL());
			
			
			PrintWriter out = response.getWriter();
			//ͨ通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			String result = null;
			try{
				WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(token,encodingAESKey,corpId);
				result = wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);
			}catch(AesException e){
				e.printStackTrace();
			}
			if(result == null){
				result = token;
			}
			out.print(result);
			out.close();
			out = null;
		}
		
		@RequestMapping(value = {"/entrance.do"},method = RequestMethod.POST)
		public void meetingPost(HttpServletRequest request,
				HttpServletResponse response) throws IOException{
			//将请求、响应的编码均设置为UTF-8（防止中文乱码）
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			//微信加密签名
			String msg_signature = request.getParameter("msg_signature");
			//时间戳
			String timestamp = request.getParameter("timestamp");
			//随机数
			String nonce = request.getParameter("nonce");
			
			//从请求中读取整个post数据
			InputStream inputStream = request.getInputStream();
			String postData = IOUtils.toString(inputStream,"UTF-8");
			System.out.println(postData);
			
			//String msg = "";
			WXBizMsgCrypt wxcpt = null;
			try{
				wxcpt = new WXBizMsgCrypt(token,encodingAESKey,corpId);
				//解密消息
				msg = wxcpt.DecryptMsg(msg_signature, timestamp, nonce, postData);
			}catch(AesException e){
				e.printStackTrace();
			}
			System.out.println("msg=" + msg);
			//调用核心业务类接收消息、处理消息

				String respMessage = CoreServiceImpl.processRequest(msg);
				String respUser = CoreServiceImpl.processRequestRUser(msg);
				System.out.println("respMessage=" + respUser);
				request.getSession().setAttribute("fromusername",respUser);
				


			
			String encryptMsg = "";
			try{
				//加密回复消息
				encryptMsg = wxcpt.EncryptMsg(respMessage, timestamp, nonce);
			}catch(AesException e){
				e.printStackTrace();
			}
			//响应消息
			PrintWriter out = response.getWriter();
			out.print(encryptMsg);
			out.close();
		}
	
    @RequestMapping(value = "/searchwechat.do")
	public @ResponseBody Object searchwechat(HttpServletRequest req) {

		String time=req.getParameter("time");
//		String name=query.getString("name");


		Map<String, Object> map = new HashMap<String, Object>();
		int totalrecords = 0;
		Connection connection=null;
		ResultSet rSet=null;
		Statement statement=null;
		try {

			
			connection= dataEntanceGuardSource.getConnection();
			
			statement= connection.createStatement();
			String sql = "select log.*,u.name from acc_monitor_log log ,USERINFO u where log.pin=u.Badgenumber";
			

			if (time!=null&&(!time.isEmpty())) {

			}else{
//				Date now =new Date();
				Calendar now =Calendar.getInstance();
				time=String.valueOf(now.get(Calendar.YEAR))+"-"+String.format("%02d", now.get(Calendar.MONTH)+1)+"-"+String.format("%02d", now.get(Calendar.DATE));
				
			}
			
			sql=sql+" and time>=#"+time+" 00:00:00"+"#";
			sql=sql+" and time<=#"+time+" 23:59:59"+"#";

			rSet = statement.executeQuery(sql);
			
			JSONArray jArray = new JSONArray();

			// System.out.println(rSet);
			while (rSet.next()) {

				totalrecords++;
				
				//分页传递

					JSONObject json = new JSONObject();
					json.put("Id", rSet.getString(1));
					json.put("name", rSet.getString(23));
					json.put("devicename", rSet.getString(15));
					json.put("time", rSet.getString(10).substring(0, 19));
					json.put("pin", rSet.getString(11));
					
					jArray.add(json);
					
				}


			map.put("total", totalrecords);

			map.put("rows", jArray);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (rSet!=null) {
					rSet.close();
				}
				if (statement!=null) {
					statement.close();
				}
				if (connection!=null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}

		return JSONObject.fromObject(map);
	}
}
