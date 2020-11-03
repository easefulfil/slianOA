package com.slianOAsys.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import com.slianOAsys.model.InspectionRecord;
import com.slianOAsys.pojo.AccessToken;
import com.slianOAsys.pojo.resp.TextMessage;
import com.slianOAsys.service.CoreService;
import com.slianOAsys.util.Constants;
import com.slianOAsys.util.ImgUtil;
import com.slianOAsys.util.MessageUtil;
import com.slianOAsys.util.WechatAccessToken;
import com.slianOAsys.util.WechatTicket;
import com.slianOAsys.util.WechatWebOAuth2;

public class CoreServiceImpl implements CoreService {
	// 用于保存图片的记录ID及时间
	BigDecimal recordId;
	String recordTime;
	int imgnum;
	
	
	public static String processRequestRUser(String msg) {
		String respMessage = null;			
		String fromUserName = null;
		String toUserName = null;
		try {
			String respContent = "";
			Map<String, String> requestMap = MessageUtil.parseXml(msg);
			fromUserName = requestMap.get("FromUserName");
			toUserName = requestMap.get("ToUserName");

			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			respMessage = "error";
		}
		return fromUserName;
	}



	public static String processRequest(String msg) {
		String respMessage = null;
		try {
			String respContent = "";
			// System.out.println("msg_XML==" + msg);
			Map<String, String> requestMap = MessageUtil.parseXml(msg);
			// System.out.println("Event==" + requestMap.get("Event"));
			String fromUserName = requestMap.get("FromUserName");
			// String fromUserName = "zhongys";
			String toUserName = requestMap.get("ToUserName");
			// String msgType = requestMap.get("MsgType");
			// 访问时间
			// String createTime = requestMap.get("CreateTime");

			// String latitude = requestMap.get("Latitude");
			// String longitude = requestMap.get("Longitude");

			// SMessage.sendMessage();
			// Constants.CURRENT_USER_MAP.put("FromUserName", fromUserName);
			/*
			 * if (latitude == null || "".equals(latitude)) ; else
			 * Constants.CURRENT_USER_MAP.put("Latitude", latitude);
			 * 
			 * if (longitude == null || "".equals(longitude)) ; else
			 * Constants.CURRENT_USER_MAP.put("Longitude", longitude);
			 */
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			respMessage = "���쳣�ˡ�����";
		}
		return respMessage;
	}

	// public static String url =
	//public static String url =
	//"jdbc:mysql://10.82.1.13:3306/bspheis?useUnicode=true&characterEncoding=utf8";//characterEncoding=GBK
		public static String url = "jdbc:mysql://112.15.173.236:3306/slianoa?characterEncoding=utf8";// characterEncoding=GBK
		//public static String username = "bspheis";
		//public static String password = "s3092015";
	public static String username = "sliansoft";
	public static String password = "slianoa2017";
	public static Connection con;
	public static Statement stmt;
	public static ResultSet rs;
	public static PreparedStatement pstmt;

	 /*private synchronized BigDecimal getId(){
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Date dt = new Date();
			String date = sdf.format(dt);
		return new BigDecimal(date);
	}*/

	@Override
	public String insert(InspectionRecord inspectionrecord, int photonum) {

		/*
		 * if (Constants.CURRENT_USER_MAP.isEmpty()) return "身份验证失败";
		 */
		
		

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		inspectionrecord.setRecordTime(df.format(System.currentTimeMillis()));
		
		synchronized(this){ 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date dt = new Date();
		String date = sdf.format(dt);
		date = date.substring(date.length()-16,date.length());
		BigDecimal bd = new BigDecimal(date);
		inspectionrecord.setRecordId(bd);
		try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		}
		

		recordId = inspectionrecord.getRecordId();
		recordTime = inspectionrecord.getRecordTime();
		imgnum = photonum;

		String getusername = "select employee_name from sys_employee where from_user_name = '"
				+ inspectionrecord.getFromUserName() + "'";

		String update = "update equipment set is_inspected =  1 where equipment_id = "
				+ inspectionrecord.getEquipmentId() + "";

		// String getrecord =
		// "select * from inspection_record where record_id = ID ";
		/*
		 * String selectinspector =
		 * "select employee_id from sys_employee where from_user_name="
		 * +list.get(0);
		 * 
		 * try { int inspectorId = 0; ResultSet rs
		 * =stmt.executeQuery(selectinspector); inspectorId =
		 * rs.getInt("employee_id");; if(inspectorId==0) return "身份验证失败";
		 * 
		 * }catch (Exception e) { System.out.println(e); return "身份验证失败"; }
		 */
		try {
			if (con == null || con.isClosed() || stmt == null
					|| stmt.isClosed()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("加载驱动成功!");
				} catch (ClassNotFoundException e) {
					System.out.println("加载驱动失败!");
					e.printStackTrace();
				}
				// 建立连接
				try {
					con = DriverManager.getConnection(url, username, password);
					stmt = con.createStatement();
					System.out.println("数据库连接成功!");
				} catch (SQLException e) {
					System.out.println("数据库连接失败!");
				}
			}
			inspectionrecord.setInspectorName(" ");
			ResultSet rst = stmt.executeQuery(getusername);
			while (rst.next()) {
				// 假设数据库的表中存在USER_ID字段
				if(rst.getString("employee_name")!=null&&rst.getString("employee_name")!=""&&rst.getString("employee_name")!="null")
				if (rst.getString("employee_name") != null
						&& rst.getString("employee_name") != ""
						&& rst.getString("employee_name") != "null")
					inspectionrecord.setInspectorName(rst
							.getString("employee_name"));
				else
					inspectionrecord.setInspectorName(" ");
				else 
					inspectionrecord.setInspectorName(" ");
			}
			rst.close();
			/*
			 * ResultSet rst2 =stmt.executeQuery(getrecord.replace("ID",
			 * recordId.toString())); while (rst2.next()) { recordId.add(new
			 * BigDecimal(1)); rst2.close(); rst2
			 * =stmt.executeQuery(getrecord.replace("ID", recordId.toString()));
			 * } rst2.close();
			 */
			inspectionrecord.setRecordId(recordId);
			String sql = "insert into inspection_record (record_id, equipment_id, record_time,"
					+ "inspector_id, status, record_longtitude,"
					+ "record_latitude, temperature_in, temperature_out,"
					+ "pressure, parameter_1, parameter_2,"
					+ "parameter_3, parameter_4, parameter_5,"
					+ "parameter_6, parameter_7, parameter_8,"
					+ "parameter_9, parameter_10, parameter_11,"
					+ "parameter_12, parameter_13, parameter_14,"
					+ "parameter_15, paremeter_16, parameter_17,"
					+ "record_status, from_user_name, equipment_name,inspector_name,temperature_cold_in,temperature_cold_out)"
					+

					"values ("
					+ inspectionrecord.getRecordId()
					+ ","
					+ inspectionrecord.getEquipmentId()
					+ ",'"
					+ inspectionrecord.getRecordTime()
					+ "',"
					+ inspectionrecord.getInspectorId()
					+ ",'"
					+ inspectionrecord.getStatus()
					+ "',"
					+ inspectionrecord.getRecordLongtitude()
					+ ","
					+ inspectionrecord.getRecordLatitude()
					+ ",'"
					+ inspectionrecord.getTemperatureIn()
					+ "','"
					+ inspectionrecord.getTemperatureOut()
					+ "','"
					+ inspectionrecord.getPressure()
					+ "','"
					+ inspectionrecord.getParameter1()
					+ "','"
					+ inspectionrecord.getParameter2()
					+ "','"
					+ inspectionrecord.getParameter3()
					+ "','"
					+ inspectionrecord.getParameter4()
					+ "','"
					+ inspectionrecord.getParameter5()
					+ "','"
					+ inspectionrecord.getParameter6()
					+ "','"
					+ inspectionrecord.getParameter7()
					+ "','"
					+ inspectionrecord.getParameter8()
					+ "','"
					+ inspectionrecord.getParameter9()
					+ "','"
					+ inspectionrecord.getParameter10()
					+ "','"
					+ inspectionrecord.getParameter11()
					+ "','"
					+ inspectionrecord.getParameter12()
					+ "','"
					+ inspectionrecord.getParameter13()
					+ "','"
					+ inspectionrecord.getParameter14()
					+ "','"
					+ inspectionrecord.getParameter15()
					+ "','"
					+ inspectionrecord.getParemeter16()
					+ "','"
					+ inspectionrecord.getParameter17()
					+ "','"
					+ inspectionrecord.getRecordStatus()
					+ "','"
					+ inspectionrecord.getFromUserName()
					+ "','"
					+ inspectionrecord.getEquipmentName()
					+ "','"
					+ inspectionrecord.getInspectorName()
					+ "','"
					+ inspectionrecord.getTemperatureColdIn()
					+ "','"
					+ inspectionrecord.getTemperatureColdOut()+"')";
			stmt.clearBatch();
			stmt.addBatch(sql);
			stmt.addBatch(update);
			// System.out.println(inspectionrecord.getStatus());
			stmt.executeBatch();
			stmt.clearBatch();
			/*
			 * System.out.println("开始生成SQL语句"); System.out.println(Imglist);
			 * if(Imglist==null)
			 * System.out.println("===========图片列表为空==========="); for(String
			 * path : Imglist){ String insertimg =
			 * "insert into record_img (img, record_id, img_time)values ('"
			 * +path+"',"+inspectionrecord.getRecordId()+",'" +
			 * inspectionrecord.getRecordTime() + "')";
			 * stmt.addBatch(insertimg); System.out.println();
			 * System.out.println("SQL语句："+insertimg); } stmt.executeBatch();
			 * System.out.println("图片插入成功"); stmt.clearBatch();
			 */
			// System.out.println("数据插入成功!");
			// System.out.println("插入记录时图片数量是"+imgnum);
			// Imglist.clear();
			// con.close();
			return "数据插入成功";
		} catch (Exception e) {
			System.out.println(e);
			return "数据插入失败";
		} finally {
			// Constants.CURRENT_USER_MAP.clear();
			if (imgnum == 0) {
				try {
					if (rs != null)
						rs.close();
					if (con != null)
						con.close();
					if (stmt != null)
						stmt.close();
					if (pstmt != null)
						pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public Map getParameterById(int id) {
		double superior = 0;
		double inferior = 0;
		Map<String, Double> map = new HashMap();
		String selectsuperior = "select superior_limit from parameter where equipment_id = "
				+ id;
		String selectinferior = "select inferior_limit from parameter where equipment_id = "
				+ id;

		try {
			if (con == null || con.isClosed() || stmt == null
					|| stmt.isClosed()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("加载驱动成功!");

				} catch (ClassNotFoundException e) {
					System.out.println("加载驱动失败!");
					e.printStackTrace();
				}
				// 建立连接
				try {
					con = DriverManager.getConnection(url, username, password);
					stmt = con.createStatement();
					System.out.println("数据库连接成功!");
				} catch (SQLException e) {
					System.out.println("数据库连接失败!");
				}
			}

			ResultSet rs1 = stmt.executeQuery(selectsuperior);
			while (rs1.next()) {
				// 假设数据库的表中存在USER_ID字段
				superior = rs1.getDouble("superior_limit");
			}
			rs1.close();
			ResultSet rs2 = stmt.executeQuery(selectinferior);
			while (rs2.next()) {
				// 假设数据库的表中存在USER_ID字段
				inferior = rs2.getDouble("inferior_limit");
			}
			rs2.close();
			System.out.println(superior);
			System.out.println(inferior);

		} catch (SQLException e) {
			System.out.println("数据库连接失败!");
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/*
		 * try { ResultSet rs1 = stmt.executeQuery(selectsuperior); while
		 * (rs1.next()) { // 假设数据库的表中存在USER_ID字段 superior =
		 * rs1.getDouble("superior_limit"); } ResultSet rs2 =
		 * stmt.executeQuery(selectinferior); while (rs2.next()) { //
		 * 假设数据库的表中存在USER_ID字段 inferior = rs2.getDouble("inferior_limit"); }
		 * System.out.println(superior); System.out.println(inferior); } catch
		 * (Exception e) { System.out.println(e); return null; }
		 */
		map.put("superior", superior);
		map.put("inferior", inferior);
		return map;
	}

	public static String getuninspected() {
		Connection con2;
		Statement stmt2;
		ResultSet rs2 = null;
		// 连接数据库
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动成功!");
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败!");
			e.printStackTrace();
		}
		// 建立连接
		try {
			con2 = DriverManager.getConnection(url, username, password);
			stmt2 = con2.createStatement();
			System.out.println("数据库连接成功!");
		} catch (SQLException e) {
			System.out.println("数据库连接失败!");
			return "数据库连接失败!";
		}
		// 执行SQL语句
		String str = "";
		String select = "select equipment_name from equipment where is_inspected = 0";
		try {
			rs2 = stmt2.executeQuery(select);
			while (rs2.next()) {
				str = str + rs2.getString("equipment_name") + ",";
			}
			System.out.println(str);
			// con.close();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			try {

				if (rs2 != null)
					rs2.close();
				if (stmt2 != null)
					stmt2.close();
				if (con2 != null)
					con2.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return "数据库连接关闭失败";
			}

		}

		return str;
	}

	// 签名算法
	/*
	 * public static void main(String[] args) { String jsapi_ticket =
	 * "jsapi_ticket";
	 * 
	 * // 注意 URL 一定要动态获取，不能 hardcode String url = "http://example.com";
	 * Map<String, String> ret = sign(jsapi_ticket, url); for (Map.Entry entry :
	 * ret.entrySet()) { System.out.println(entry.getKey() + ", " +
	 * entry.getValue()); } };
	 */
	public static AccessToken token = null;
	public static String time = null;
	public static String jsapi_ticket = null;

	@Override
	public Map getParam(String url) {
		String appId = Constants.CORPID;
		String appSecret = Constants.SECRET;
		if (token == null) {
			token = WechatAccessToken.getAccessToken(appId, appSecret, 1);
			JSONObject jo = WechatTicket.getTicket(token.getToken());
			jsapi_ticket = jo.getString("ticket");
			time = getTime();
		} else {
			if (!time.substring(0, 13).equals(getTime().substring(0, 13))) { // 每小时刷新一次
				token = null;
				token = WechatAccessToken.getAccessToken(appId, appSecret, 1);
				JSONObject jo = WechatTicket.getTicket(token.getToken());
				jsapi_ticket = jo.getString("ticket");
				time = getTime();
			}
		}

		Map<String, String> params = sign(jsapi_ticket, url);
		params.put("appid", appId);
		System.out.println("jsapi_ticket    " + params.get("jsapi_ticket"));
		System.out.println("nonceStr    " + params.get("nonceStr"));
		System.out.println("timestamp    " + params.get("timestamp"));
		System.out.println("url    " + params.get("url"));
		System.out.println("signature    " + params.get("signature"));
		return params;
		/*
		 * JSONObject jsonObject = JSONObject.fromObject(params); String jsonStr
		 * = jsonObject.toString(); System.out.println(jsonStr); return jsonStr;
		 */
	}

	/*
	 * private static String getUrl(){ HttpServletRequest request =
	 * ServletActionContext.getRequest();
	 * 
	 * StringBuffer requestUrl = request.getRequestURL();
	 * 
	 * String queryString = request.getQueryString(); String url = requestUrl
	 * +"?"+queryString; return url; }
	 */

	public static Map<String, String> sign(String jsapi_ticket, String url) {
		Map<String, String> ret = new HashMap<String, String>();
		String nonce_str = create_nonce_str();
		String timestamp = create_timestamp();
		String string1;
		String signature = "";

		// 注意这里参数名必须全部小写，且必须有序
		string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str
				+ "&timestamp=" + timestamp + "&url=" + url;
		// System.out.println(string1);

		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(string1.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
			// System.out.println(signature);
			System.out.println("我是分割线----------------");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		ret.put("url", url);
		ret.put("jsapi_ticket", jsapi_ticket);
		ret.put("nonceStr", nonce_str);
		ret.put("timestamp", timestamp);
		ret.put("signature", signature);

		return ret;
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	private static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	private static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	public static String getTime() {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(dt);
	}

	/**
	 * 获取媒体文件
	 * 
	 * @param accessToken
	 *            接口访问凭证
	 * @param media_id
	 *            媒体文件id
	 * @param savePath
	 *            文件在服务器上的存储路径
	 * */
	@Override
	public String downloadMedia(String tempmediaId, String basePath) {
		String mediaId = tempmediaId.substring(tempmediaId.length() - 64,
				tempmediaId.length());
		System.out.println("已进入downloadMediaService mediaId=" + mediaId);
		String appId = Constants.CORPID;
		String appSecret = Constants.SECRET;
		if (token == null)
			token = WechatAccessToken.getAccessToken(appId, appSecret, 1);

		System.out.println("已获得token =" + token.getToken());
		String savePath = basePath;
		String accessToken = token.getToken();
		String filePath = null;
		// 拼接请求地址
		String requestUrl = "https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace(
				"MEDIA_ID", mediaId);
		System.out.println("已生成requestUrl =" + requestUrl);
		try {
			if (con == null || con.isClosed() || stmt == null
					|| stmt.isClosed()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("加载驱动成功!");

				} catch (ClassNotFoundException e) {
					System.out.println("加载驱动失败!");
					e.printStackTrace();
				}
				// 建立连接
				try {
					con = DriverManager.getConnection(url, username, password);
					stmt = con.createStatement();
					System.out.println("数据库连接成功!");
				} catch (SQLException e) {
					System.out.println("数据库连接失败!");
				}
			}
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");

			if (!savePath.endsWith("/")) {
				savePath += "/";
			}
			// 根据内容类型获取扩展名
			String fileExt = ImgUtil.getFileEndWitsh(conn
					.getHeaderField("Content-Type"));
			// 将mediaId作为文件名
			filePath = savePath + mediaId + fileExt;
			System.out.println("已生成filePath =" + filePath);
			BufferedInputStream bis = new BufferedInputStream(
					conn.getInputStream());
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1)
				fos.write(buf, 0, size);
			fos.close();
			bis.close();

			conn.disconnect();
			String info = String.format("下载媒体文件成功，filePath=" + filePath);
			filePath = filePath.substring(filePath.length() - 68,
					filePath.length());
			System.out.println(info);
			// 将图片路径插入数据库
			String insertimg = "insert into record_img (img, record_id, img_time)values ('"
					+ filePath + "'," + recordId + ",'" + recordTime + "')";
			stmt.addBatch(insertimg);
			System.out.println();
			System.out.println("SQL语句：" + insertimg);
			stmt.executeBatch();
			System.out.println("图片插入成功");
			stmt.clearBatch();
			// recordId=null;
			// recordTime=null;
		} catch (Exception e) {
			filePath = null;
			String error = String.format("下载媒体文件失败：%s", e);
			System.out.println(error);
		} finally {
			System.out.println("插入记图片时图片数量是" + imgnum);
			imgnum--;
			if (imgnum == 0) {
				try {

					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return "数据库连接关闭失败";
				}
			}
		}
		// Imglist.add(filePath);
		return "记录插入成功";
	}

	public static JSONObject onload(String code) {
//		JSONObject temp1 = WechatWebOAuth2.getAccessTokenByCode();
		// String inspectorname = "";
		String equipmentname = "";
//		JSONObject temp = WechatWebOAuth2.getUserByAccessToken(code,
//				temp1.getString("access_token"));
		JSONObject temp = WechatWebOAuth2.getUserByAccessToken(code,
				WechatWebOAuth2.ACCESS_TOCKEN);
		System.out.println("授权信息：");
		System.out.println(temp);
		// String getinspectorname =
		// "select employee_name from sys_employee where sys_employee = '"+
		// temp.getString("UserId")+"'";
		/*String getequipmentname = "select equipment_name from equipment where equipment_id ="
				+ equipemtnId;*/

		/*try {
			if (con == null || con.isClosed() || stmt == null
					|| stmt.isClosed()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("加载驱动成功!");

				} catch (ClassNotFoundException e) {
					System.out.println("加载驱动失败!");
					e.printStackTrace();
				}
				// 建立连接
				try {
					con = DriverManager.getConnection(url, username, password);
					stmt = con.createStatement();
					System.out.println("数据库连接成功!");
				} catch (SQLException e) {
					System.out.println("数据库连接失败!");
				}
			}
			
			 * ResultSet rs1 = stmt.executeQuery(getinspectorname);
			 * while(rs1.next()){ inspectorname =
			 * rs1.getString("employee_name"); }
			 
			ResultSet rs2 = stmt.executeQuery(getequipmentname);
			while (rs2.next()) {
				equipmentname = rs2.getString("equipment_name");
			}
			rs2.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
		JSONObject Jo = new JSONObject();
		if (temp.getString("UserId") == "" || temp.getString("UserId") == null)
			return Jo;
		Jo.put("inspectorname", temp.getString("UserId"));
		//Jo.put("equipmentname", equipmentname);
		return Jo;
	}
}
