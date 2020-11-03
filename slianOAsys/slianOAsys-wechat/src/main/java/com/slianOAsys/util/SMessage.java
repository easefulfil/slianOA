package com.slianOAsys.util;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.slianOAsys.dao.SlianoaAttendanceMapper;
import com.slianOAsys.dao.SlianoaClassEmployeeMapper;
import com.slianOAsys.dao.SlianoaClassMapper;
import com.slianOAsys.dao.SlianoaEmployeeMapper;
import com.slianOAsys.model.SlianoaClass;
import com.slianOAsys.model.SlianoaClassEmployee;
import com.slianOAsys.model.SlianoaClassEmployeeExample;
import com.slianOAsys.model.SlianoaClassExample;
import com.slianOAsys.model.SlianoaEmployee;
import com.slianOAsys.model.SlianoaEmployeeExample;
import com.slianOAsys.pojo.resp.TextMessage;

public class SMessage {
	public static String POST_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";
	@Autowired
	SlianoaAttendanceMapper attendanceMapper;
	@Autowired
	SlianoaClassMapper classMapper;
	@Autowired
	SlianoaClassEmployeeMapper classEmployeeMapper;
	@Autowired
	SlianoaEmployeeMapper employeeMapper;

	/**
	 * text消息
	 * 
	 * @param touser
	 *            UserID列表（消息接收者，多个接收者用‘|’分隔）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送————"touser":
	 *            "UserID1|UserID2|UserID3"
	 * @param toparty
	 *            PartyID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"toparty": "
	 *            PartyID1 | PartyID2 "
	 * @param totag
	 *            TagID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"totag": " TagID1 |
	 *            TagID2 "
	 * @param msgtype
	 *            消息类型，此时固定为：text
	 * @param agentid
	 *            企业应用的id，整型。可在应用的设置页面查看
	 * @param content
	 *            消息内容
	 * @param safe
	 *            表示是否是保密消息，0表示否，1表示是，默认0
	 */
	public static String STextMsg(String touser, String agentid, String content) {
		String PostData = "{\"touser\": \"%s\",\"msgtype\": \"text\",\"agentid\": %s,\"text\": {\"content\": \"%s\"},\"safe\":\"0\"}";
		return String.format(PostData, touser, agentid, content);
	}

	/**
	 * 正常班(start:9:00am end:17:30pm)
	 * 
	 * 签到推送 上班前十分钟
	 */
	@SuppressWarnings("deprecation")
	public void sendSignRemindMessage() {

		String access_token = WechatAccessToken.getAccessToken(Constants.CORPID, Constants.SECRET, 1).getToken();
		TextMessage tm = new TextMessage();
		Date date = new Date();
		// 今天周几
		int num = DateHandler.getWeekOfDate(date);
		// 寻找符合条件的class列表(上班时间为9点)
		SlianoaClassExample classExample = new SlianoaClassExample();
		SlianoaClassEmployeeExample classEmployeeExample = new SlianoaClassEmployeeExample();
		SlianoaEmployeeExample employeeExample = new SlianoaEmployeeExample();
		switch (num) {
		default:
			System.out.println("日期转换失败！");
			break;
		case 1:
			classExample.or().andIsMondayEqualTo(1).andStartTimeEqualTo(new Time(9, 0, 0)).andClassStatusEqualTo("启用");
			break;
		case 2:
			classExample.or().andIsTuesdayEqualTo(1).andStartTimeEqualTo(new Time(9, 0, 0)).andClassStatusEqualTo("启用");
			break;
		case 3:
			classExample.or().andIsWednesdayEqualTo(1).andStartTimeEqualTo(new Time(9, 0, 0))
					.andClassStatusEqualTo("启用");
			break;
		case 4:
			classExample.or().andIsThursdayEqualTo(1).andStartTimeEqualTo(new Time(9, 0, 0))
					.andClassStatusEqualTo("启用");
			break;
		case 5:
			classExample.or().andIsFridayEqualTo(1).andStartTimeEqualTo(new Time(9, 0, 0)).andClassStatusEqualTo("启用");
			break;
		case 6:
			classExample.or().andIsSaturdayEqualTo(1).andStartTimeEqualTo(new Time(9, 0, 0))
					.andClassStatusEqualTo("启用");
			break;
		case 7:
			classExample.or().andIsSundayEqualTo(1).andStartTimeEqualTo(new Time(9, 0, 0)).andClassStatusEqualTo("启用");
			break;
		}
		List<SlianoaClass> classList = classMapper.selectByExample(classExample);
		// String[] userId = new String[classList.size()];
		if (!classList.isEmpty()) {
			for (int i = 0; i < classList.size(); i++) {
				// 检查是否条件能够成功被后续条件覆盖
				classEmployeeExample.clear();
				classEmployeeExample.or().andClassIdEqualTo(classList.get(i).getClassId());
				List<SlianoaClassEmployee> classEmployeeList = classEmployeeMapper
						.selectByExample(classEmployeeExample);

				for (int j = 0; j < classEmployeeList.size(); j++) {
					employeeExample.clear();
					employeeExample.or().andEmployeeIdEqualTo(classEmployeeList.get(j).getEmployeeId());
					List<SlianoaEmployee> employeeList = employeeMapper.selectByExample(employeeExample);
					// userId[i] = employeeList.get(j).getEmployeeWechat();
					tm.setContent("请考勤打卡签到！");
					if (employeeList.get(0).getEmployeeWechat() != ""
							&& employeeList.get(0).getEmployeeWechat() != null) {
						String PostData = STextMsg(employeeList.get(0).getEmployeeWechat(), "26", tm.getContent());
						int result = WechatAccessToken.PostMessage(access_token, "POST", POST_URL, PostData);
						if (0 == result) {
							System.out.println("操作成功");
						} else {
							System.out.println("操作失败");
						}
					}
				}
			}

		} else {
			System.out.println("今日无考勤记录！");
		}

	}

	/**
	 * 正常班(start:9:00am end:17:30pm)
	 * 
	 * 签退推送 17:30分
	 */
	@SuppressWarnings("deprecation")
	public void sendOffRemindMessage() {
		String access_token = WechatAccessToken.getAccessToken(Constants.CORPID, Constants.SECRET, 1).getToken();
		TextMessage tm = new TextMessage();
		Date date = new Date();
		// 今天周几
		int num = DateHandler.getWeekOfDate(date);
		// 寻找符合条件的class列表(下班时间为17:30点)
		SlianoaClassExample classExample = new SlianoaClassExample();
		SlianoaClassEmployeeExample classEmployeeExample = new SlianoaClassEmployeeExample();
		SlianoaEmployeeExample employeeExample = new SlianoaEmployeeExample();
		switch (num) {
		default:
			System.out.println("日期转换失败！");
			break;
		case 1:
			classExample.or().andIsMondayEqualTo(1).andEndTimeEqualTo(new Time(17,30,00))
					.andClassStatusEqualTo("启用");
			break;
		case 2:
			classExample.or().andIsTuesdayEqualTo(1).andEndTimeEqualTo(new Time(17,30,00))
					.andClassStatusEqualTo("启用");
			break;
		case 3:
			classExample.or().andIsWednesdayEqualTo(1).andEndTimeEqualTo(new Time(17,30,00))
					.andClassStatusEqualTo("启用");
			break;
		case 4:
			classExample.or().andIsThursdayEqualTo(1).andEndTimeEqualTo(new Time(17,30,00))
					.andClassStatusEqualTo("启用");
			break;
		case 5:
			classExample.or().andIsFridayEqualTo(1).andEndTimeEqualTo(new Time(17,30,00))
					.andClassStatusEqualTo("启用");
			break;
		case 6:
			classExample.or().andIsSaturdayEqualTo(1).andEndTimeEqualTo(new Time(17,30,00))
					.andClassStatusEqualTo("启用");
			break;
		case 7:
			classExample.or().andIsSundayEqualTo(1).andEndTimeEqualTo(new Time(17,30,00))
					.andClassStatusEqualTo("启用");
			break;
		}
		List<SlianoaClass> classList = classMapper.selectByExample(classExample);
		if (!classList.isEmpty()) {
			for (int i = 0; i < classList.size(); i++) {
				// 检查是否条件能够成功被后续条件覆盖
				classEmployeeExample.clear();
				classEmployeeExample.or().andClassIdEqualTo(classList.get(i).getClassId());
				List<SlianoaClassEmployee> classEmployeeList = classEmployeeMapper
						.selectByExample(classEmployeeExample);

				for (int j = 0; j < classEmployeeList.size(); j++) {
					employeeExample.clear();
					employeeExample.or().andEmployeeIdEqualTo(classEmployeeList.get(j).getEmployeeId());
					List<SlianoaEmployee> employeeList = employeeMapper.selectByExample(employeeExample);
					// userId[i] = employeeList.get(j).getEmployeeWechat();
					tm.setContent("请考勤打卡签退！");
					if (employeeList.get(0).getEmployeeWechat() != ""
							&& employeeList.get(0).getEmployeeWechat() != null) {
						String PostData = STextMsg(employeeList.get(0).getEmployeeWechat(), "26", tm.getContent());
						int result = WechatAccessToken.PostMessage(access_token, "POST", POST_URL, PostData);
						if (0 == result) {
							System.out.println("操作成功");
						} else {
							System.out.println("操作失败");
						}
					}
				}
			}

		}
		else {
			System.out.println("今日无考勤记录！");
		}

	}
}
