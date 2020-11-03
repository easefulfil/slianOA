package com.slianOAsys.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/******** 日期处理 ********/
public class DateHandler {

	/*
	 * * 改变日期函数， date变量为日期， amount变量为要更改的日期时间
	 * 例子：addDay("1990-1-2",2)，输出为"1990-1-4"
	 */
	public static String addDay(String date, int amount) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String changeDate = "";
		String[] arrary = date.split("-");
		int year, month, day;
		try {
			year = Integer.valueOf(arrary[0]);
			month = Integer.valueOf(arrary[1]);
			day = Integer.valueOf(arrary[2]);
			calendar.set(year, month - 1, day);
			calendar.add(Calendar.DATE, amount);
			changeDate = sdf.format(calendar.getTime());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return changeDate;
	}

	/*
	 * * 改变日期格式函数， date变量为日期， 例子：changeFormat("2013-8-4")，输出为"8月4日 周二"
	 */
	@SuppressWarnings("deprecation")
	public static String changeFormat(String date) {
		String[] arrary = date.split("-");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
		int year, month, day;
		String[] week = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
		try {
			year = Integer.valueOf(arrary[0]);
			month = Integer.valueOf(arrary[1]);
			day = Integer.valueOf(arrary[2]);
			calendar.set(year, month - 1, day);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sdf.format(calendar.getTime()) + " " + week[calendar.getTime().getDay()];
	}

	/*
	 * * 计算日期差函数， begin变量为开始日期，end变量为结束日期
	 * 例子：changeFormat("2013-8-4")，输出为"8月4日 周二"
	 */
	public static long getQuot(String begin, String end) {
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = ft.parse(begin);
			Date date2 = ft.parse(end);
			quot = date2.getTime() - date1.getTime();
			quot = quot / 86400000;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quot;

	}
	/*
	 * 根据年月日获取日
	 * example：“2017-03-03”，输出为3
	 */
    public static String formatDate(String s){
    	String[] str = new String[3];
    	str = s.split("-");
    	int a = Integer.parseInt(str[1])-1;
    	int b = Integer.parseInt(str[2]);
    	String returnString = str[0]+"-"+String.valueOf(a)+"-"+String.valueOf(b);
    	return returnString;
    }
	// 根据时间获取周几
	public static int getWeekOfDate(Date date) {
		int[] weekDays = { 7, 1, 2, 3, 4, 5, 6 };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	// 计算string类型的时间大小
	public static long compare(String first, String second) {
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss");
		try {
			Date date1 = ft.parse(first);
			Date date2 = ft.parse(second);
			quot = date1.getTime() - date2.getTime();
			quot /= 60000;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quot;

	}

	// date 计算时间大小
	public static long compare(Date first, Date second) {
		long quot = 0;
		try {
			Date date1 = first;
			Date date2 = second;
			quot = date1.getTime() - date2.getTime();
			quot /= 60000;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quot;
	}

	// 将date时间格式转换成time时间类型
	public static Time dateToTime(Date d, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Time time = Time.valueOf(sdf.format(d));
		return time;
	}

	// 将string类型转换成time时间类型
	public static Time stringToTime(String s) {
		Time time = Time.valueOf(s);
		return time;
	}

	public static long compareFormat(String first, String second, String format) {
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat(format);
		try {
			Date date1 = ft.parse(first);
			Date date2 = ft.parse(second);
			quot = date1.getTime() - date2.getTime();
			quot /= 60000;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quot;

	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @author chengxl@cst.zju.edu.cn at 2014-4-22
	 * 
	 * @param d
	 * @param format
	 * @return
	 */
	public static String dateToStr(Date d, String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		return sdf.format(d);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @author chengxl@cst.zju.edu.cn at 2014-4-22
	 * 
	 * @param d
	 * @param format
	 * @return
	 */
	public static String timestampToStr(Timestamp ts, String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		return sdf.format(ts);
	}

	/**
	 * formatStr:yyyy-MM-dd HH:mm:ss
	 * 
	 * @author chengxl@cst.zju.edu.cn at 2014-4-22
	 * 
	 * @param dateStr
	 * @param formatStr
	 * @return
	 */

	public static Date strToDate(String dateStr, String formatStr) {

		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		Date date = null;

		try {
			date = format.parse(dateStr);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;

	}

	/**
	 * 给指定日期加上指定月份
	 * 
	 * @author chengxl@cst.zju.edu.cn at 2014年10月14日
	 *
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date addMonth(Date date, int month) {

		Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		calender.add(Calendar.MONTH, month);

		return calender.getTime();
	}

	/**
	 * 给指定日期加上指定天数
	 * 
	 * @author chengxl@cst.zju.edu.cn at 2014年10月14日
	 *
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date addDay(Date date, int day) {

		Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		calender.add(Calendar.DATE, day);

		return calender.getTime();
	}

	/**
	 * 获取指定往后，几个月 的第一天 或者最后一天
	 * 
	 * @author czx
	 *
	 * @param months
	 *            eg: 2 往后两个月
	 * @param day
	 *            eg: 1 第一天 0最后一天
	 * @return
	 */
	public static Date getMonthDay(int months, int day) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) + months);
		c.set(Calendar.DAY_OF_MONTH, day);
		return c.getTime();
	}

	public static String getPreDayDate() {
		Date dNow = new Date(); // 当前时间
		Date dBefore = new Date();

		Calendar calendar = Calendar.getInstance(); // 得到日历
		calendar.setTime(dNow);// 把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -1); // 设置为前一天
		dBefore = calendar.getTime(); // 得到前一天的时间

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		String defaultStartDate = sdf.format(dBefore); // 格式化前一天

		return defaultStartDate;
	}

	public static String getLateDayDate() {
		Date dNow = new Date(); // 当前时间
		Date dAfter = new Date();

		Calendar calendar = Calendar.getInstance(); // 得到日历
		calendar.setTime(dNow);// 把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, 1); // 设置为后一天
		dAfter = calendar.getTime(); // 得到后一天的时间

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		String defaultStartDate = sdf.format(dAfter); // 格式化后一天

		return defaultStartDate;
	}

	public static void main(String[] args) {
		/*
		 * // DayHandler d = new DayHandler();
		 * 
		 * SimpleDateFormat format = new
		 * SimpleDateFormat("yyyy-MM-dd hh:mm:ss",Locale.SIMPLIFIED_CHINESE); //
		 * Calendar calender = Calendar.getInstance(); Date d = new Date();
		 * 
		 * System.out.println(dateToStr(DateHandler.addDay(new Date(),
		 * 1),"yyyy-MM-dd hh:mm:ss"));
		 */
		System.out.println(
				dateToStr(getMonthDay(2, 1), "yyyy-MM-dd") + "------" + dateToStr(getMonthDay(3, 0), "yyyy-MM-dd"));
		System.out.println(getLateDayDate());

	}

	/**
	 * 坐标转换 微信坐标转为百度地图
	 */
	private static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;

	/// <summary>
	/// 中国正常坐标系GCJ02协议的坐标，转到 百度地图对应的 BD09 协议坐标
	/// </summary>
	/// <param name="lat">维度</param>
	/// <param name="lng">经度</param>
	public static void Convert_GCJ02_To_BD09(double lat, double lng) {
		double x = lng, y = lat;
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
		lng = z * Math.cos(theta) + 0.0065;
		lat = z * Math.sin(theta) + 0.006;
	}

	private static double EARTH_RADIUS = 6378.137;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	public static double GetDistance(double lat1, double lng1, double lat2, double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(
				Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	/**
	 * get方法直接调用post方法
	 * 
	 * @param url
	 *            网络地址
	 * @return 返回网络数据
	 */
	public static String get(String url) {
		return post(url, null);
	}

	/**
	 * 设定post方法获取网络资源,如果参数为null,实际上设定为get方法
	 * 
	 * @param url
	 *            网络地址
	 * @param param
	 *            请求参数键值对
	 * @return 返回读取数据
	 */
	public static <K, V> String post(String url, Map<K, V> param) {
		HttpURLConnection conn = null;
		try {
			URL u = new URL(url);
			conn = (HttpURLConnection) u.openConnection();
			StringBuffer sb = null;
			if (param != null) {// 如果请求参数不为空
				sb = new StringBuffer();
				/*
				 * A URL connection can be used for input and/or output. Set the
				 * DoOutput flag to true if you intend to use the URL connection
				 * for output, false if not. The default is false.
				 */
				// 默认为false,post方法需要写入参数,设定true
				conn.setDoOutput(true);
				// 设定post方法,默认get
				conn.setRequestMethod("POST");
				// 获得输出流
				OutputStream out = conn.getOutputStream();
				// 对输出流封装成高级输出流
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
				// 将参数封装成键值对的形式
				for (Map.Entry s : param.entrySet()) {
					sb.append(s.getKey()).append("=").append(s.getValue()).append("&");
				}
				// 将参数通过输出流写入
				writer.write(sb.deleteCharAt(sb.toString().length() - 1).toString());
				writer.close();// 一定要关闭,不然可能出现参数不全的错误
				sb = null;
			}
			conn.connect();// 建立连接
			sb = new StringBuffer();
			// 获取连接状态码
			int recode = conn.getResponseCode();
			BufferedReader reader = null;
			if (recode == 200) {
				// Returns an input stream that reads from this open connection
				// 从连接中获取输入流
				InputStream in = conn.getInputStream();
				// 对输入流进行封装
				reader = new BufferedReader(new InputStreamReader(in));
				String str = null;
				sb = new StringBuffer();
				// 从输入流中读取数据
				while ((str = reader.readLine()) != null) {
					sb.append(str).append(System.getProperty("line.separator"));
				}
				// 关闭输入流
				reader.close();
				if (sb.toString().length() == 0) {
					return null;
				}
				return sb.toString().substring(0,
						sb.toString().length() - System.getProperty("line.separator").length());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null)// 关闭连接
				conn.disconnect();
		}
		return null;
	}
}
