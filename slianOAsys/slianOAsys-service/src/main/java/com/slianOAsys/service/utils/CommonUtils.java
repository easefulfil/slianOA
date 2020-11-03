package com.slianOAsys.service.utils;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Date;

/**
 * Copyright@宁波高新区敏智科技有限公司 www.mz3co.com Copyright@浙江大学软件学院S309实验室
 * 
 * @author chengxl Cteated time：2015年1月17日 上午10:45:57
 * 
 */
public class CommonUtils {

	/**
	 * 首字母大写，in:deleteDate，out:DeleteDate
	 */
	public static String upperHeadChar(String in) {
		String head = in.substring(0, 1);
		String out = head.toUpperCase() + in.substring(1, in.length());
		return out;
	}

	/**
	 * 将字符串 "1,2,3" 转为 List<Integer>
	 * 
	 * @return
	 */
	public static List<Integer> idsArrayToList(String ids) {
		List<Integer> list = new ArrayList<Integer>();

		for (String roleId : ids.split(","))
		{
//		System.out.println(roleId);
			if(roleId!="")
			list.add(Integer.parseInt(roleId));
		}

		return list;

	}

	/**
	 * 生成随即6位密码
	 * @param length
	 * @return
	 */

	public static String getRandomPassword(int length) {

		String randString = "0123456789";// éšæœºäº§ç”Ÿçš„å­—ç¬¦ä¸² ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz
		Random random = new Random();
		// ç»˜åˆ¶éšæœºå­—ç¬¦
		String randomPassword = "";
		for (int i = 1; i <= length; i++) {
			randomPassword += String.valueOf(randString.charAt(random.nextInt(randString.length())));
			
		}
		
		return randomPassword;
	}

		// 
		public static String generateQRCode() {

			return Integer.toString(new Random().nextInt(89999999)+10000000);
		}

		// 
		public static String generateQRCodeFileName() {

			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		/*	return df.format(new Date()) + new Random().nextInt(1000)+".jpg";*/
			return df.format(new Date()) + (new Random().nextInt(899999)+100000)+".jpg"; 
		}
		
		public static String QRCODE_BASE_PATH = "/slianOAsys-admin/upload/Qrimages/";
		public static String EQUIPMENT_QRCODE_BASE_PATH = "/slianOAsys-admin/upload/equipmentQrcode/";

}
