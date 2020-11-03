package com.slianOAsys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slianOAsys.dao.SlianoaAppealMapper;
import com.slianOAsys.dao.SlianoaAttendanceMapper;
import com.slianOAsys.dao.SlianoaClassEmployeeMapper;
import com.slianOAsys.dao.SlianoaClassMapper;
import com.slianOAsys.dao.SlianoaEmployeeMapper;
import com.slianOAsys.model.SlianoaAppeal;
import com.slianOAsys.model.SlianoaAppealExample;
import com.slianOAsys.model.SlianoaAttendance;
import com.slianOAsys.model.SlianoaAttendanceExample;
import com.slianOAsys.model.SlianoaClass;
import com.slianOAsys.model.SlianoaClassEmployee;
import com.slianOAsys.model.SlianoaClassEmployeeExample;
import com.slianOAsys.model.SlianoaEmployee;
import com.slianOAsys.model.SlianoaEmployeeExample;
import com.slianOAsys.service.AttendanceService;
import com.slianOAsys.service.utils.DateJsonValueProcessor;
import com.slianOAsys.util.Constants;
import com.slianOAsys.util.DateHandler;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	private SlianoaAttendanceMapper attendanceMapper;
	@Autowired
	private SlianoaClassMapper classMapper;
	@Autowired
	private SlianoaEmployeeMapper employeeMapper;
	@Autowired
	private SlianoaClassEmployeeMapper classEmployeeMapper;
	@Autowired
	private SlianoaAppealMapper appealMapper;
	/*
	 * @Autowired private
	 */

	// 签到判断
	// 需要获取用户的ID
	@Override
	public synchronized JSONObject signInJudge(double latitude, double longitude, String wechatId) {
		JSONObject json = new JSONObject();
		SlianoaAttendance sa = new SlianoaAttendance();
		// pre
		Date currentTime = new Date();
		// SignLocationExam ple example = new SignLocationExample();

		// 通过wechatId找到对应的employee
		SlianoaEmployeeExample exampleEp = new SlianoaEmployeeExample();
		exampleEp.or().andEmployeeWechatEqualTo(wechatId);
		List<SlianoaEmployee> employeeList = employeeMapper.selectByExample(exampleEp);
		if (employeeList.size() == 0) {
			json.put("status", 6);
			System.out.println("没有你的信息！");
			return json;
		}
		// 通过EmployeeId获取班次ID
		SlianoaClassEmployeeExample classEmployeeExample = new SlianoaClassEmployeeExample();
		classEmployeeExample.or().andEmployeeIdEqualTo(employeeList.get(0).getEmployeeId());
		List<SlianoaClassEmployee> classEmployeeList = classEmployeeMapper.selectByExample(classEmployeeExample);
		if (classEmployeeList.size() == 0) {
			json.put("status", 7);
			System.out.println("没有你的排班信息！");
			return json;
		}
		// 设置更新记录条件为等于签到的雇员id和签到时间
		SlianoaAttendanceExample attendanceExample = new SlianoaAttendanceExample();
		attendanceExample.or().andEmployeeIdEqualTo(employeeList.get(0).getEmployeeId())
				.andAttendanceTimeEqualTo(DateHandler.dateToStr(currentTime, "yyyy-MM-dd"));

		SlianoaClass slclass = classMapper.selectByPrimaryKey(classEmployeeList.get(0).getClassId());
		if (slclass != null) {
			Double distance = DateHandler.GetDistance(slclass.getLatitude(), slclass.getLongitude(), latitude,
					longitude);
			if (distance * (1000.0) >= slclass.getScope()) {
				// 签到失败（不在地点范围）
				System.out.println("不在签到范围，签到失败");
				json.put("status", 1);
				return json;
			} else {
				// 通过微信地图api获取位置
				System.out.println("通过微信地图api获取位置");
				String url = Constants.WECHAT_API_URL + "?location=" + latitude + "," + longitude + "&key="
						+ Constants.WECHAT_API_KEY;
				String addressMsg = DateHandler.get(url);
				try {
					org.json.JSONObject obj = new org.json.JSONObject(addressMsg);
					org.json.JSONObject result = (org.json.JSONObject) obj.get("result");
					System.out.println(result.getString("address"));
					sa.setAttendanceSignaddress(result.getString("address"));
					// sar.setRecordSignaddress(result.getString("address"));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			// 时间判断

			if (DateHandler.compare(DateHandler.dateToStr(currentTime, "HH:mm:ss"),
					DateHandler.dateToStr(slclass.getSigninEnd(), "HH:mm:ss")) <= 0
					&& DateHandler.compare(DateHandler.dateToStr(currentTime, "HH:mm:ss"),
							DateHandler.dateToStr(slclass.getStartTime(), "HH:mm:ss")) > 0) {
				// 签到迟到

				sa.setSigninLatitude(Double.toString(latitude));
				sa.setSigninLongitude(Double.toString(longitude));
				sa.setAttendanceSigntime(DateHandler.dateToTime(currentTime, "HH:mm:ss"));
				sa.setAttendanceSignstatus("迟到");
				sa.setAttendanceTotalStatus("迟到");
				attendanceMapper.updateByExampleSelective(sa, attendanceExample);
				System.out.println("签到迟到");

				json.put("status", 4);
				json.put("address", sa.getAttendanceSignaddress());

			} else if (DateHandler.compare(DateHandler.dateToStr(slclass.getSigninStart(), "HH:mm:ss"),
					DateHandler.dateToStr(currentTime, "HH:mm:ss")) <= 0
					&& DateHandler.compare(DateHandler.dateToStr(slclass.getStartTime(), "HH:mm:ss"),
							DateHandler.dateToStr(currentTime, "HH:mm:ss")) >= 0) {
				// 签到成功
				sa.setSigninLatitude(Double.toString(latitude));
				sa.setSigninLongitude(Double.toString(longitude));
				sa.setAttendanceSigntime(DateHandler.dateToTime(currentTime, "HH:mm:ss"));
				sa.setAttendanceSignstatus("正常");
				sa.setAttendanceTotalStatus("正常");
				attendanceMapper.updateByExampleSelective(sa, attendanceExample);
				json.put("status", 5);// 正常签到
				json.put("address", sa.getAttendanceSignaddress());

			} else if (DateHandler.compare(DateHandler.dateToStr(currentTime, "HH:mm:ss"),
					DateHandler.dateToStr(slclass.getSigninEnd(), "HH:mm:ss")) > 0) {
				// 已经超过签到时间，无法签到
				System.out.println("已经超过签到时间，不能签到！");
				json.put("status", 3);

			} else {
				// 不在签到时间范围，签到失败
				System.out.println("不在签到时间范围，签到失败");
				json.put("status", 2);
			}
		}
		System.out.println("返回json信息如下:");
		System.out.println(json.toString());
		return json;
	}

	@Override
	public JSONObject signoffJudge(double latitude, double longitude, String wechatId) {
		JSONObject json = new JSONObject();
		SlianoaAttendance sa = new SlianoaAttendance();
		Date currentTime = new Date();
		// SignLocationExample example = new SignLocationExample();

		// 通过wechatId找到对应的employee
		SlianoaEmployeeExample exampleEp = new SlianoaEmployeeExample();
		exampleEp.or().andEmployeeWechatEqualTo(wechatId);
		List<SlianoaEmployee> employeeList = employeeMapper.selectByExample(exampleEp);
		if (employeeList.size() == 0) {
			json.put("status", 6);
			System.out.println("没有你的信息！");
			return json;
		}
		// 通过EmployeeId获取班次ID
		SlianoaClassEmployeeExample classEmployeeExample = new SlianoaClassEmployeeExample();
		classEmployeeExample.or().andEmployeeIdEqualTo(employeeList.get(0).getEmployeeId());
		List<SlianoaClassEmployee> classEmployeeList = classEmployeeMapper.selectByExample(classEmployeeExample);

		if (classEmployeeList.size() == 0) {
			json.put("status", 7);
			System.out.println("没有你的排班信息！");
			return json;
		}
		// 设置更新记录条件为等于签到的雇员id和签到时间
		SlianoaAttendanceExample attendanceExample = new SlianoaAttendanceExample();
		attendanceExample.or().andEmployeeIdEqualTo(employeeList.get(0).getEmployeeId())
				.andAttendanceTimeEqualTo(DateHandler.dateToStr(currentTime, "yyyy-MM-dd"));

		SlianoaClass slclass = classMapper.selectByPrimaryKey(classEmployeeList.get(0).getClassId());
		if (slclass != null) {
			Double distance = DateHandler.GetDistance(slclass.getLatitude(), slclass.getLongitude(), latitude,
					longitude);
			if (distance * (1000.0) >= slclass.getScope()) {
				// 签退地点有问题，签退失败
				json.put("status", 1);
				System.out.println("签退地点有问题，签退失败");
				return json;
			} else {
				// 通过微信地图api获取位置
				String url = Constants.WECHAT_API_URL + "?location=" + latitude + "," + longitude + "&key="
						+ Constants.WECHAT_API_KEY;
				String addressMsg = DateHandler.get(url);
				try {
					org.json.JSONObject obj = new org.json.JSONObject(addressMsg);
					org.json.JSONObject result = (org.json.JSONObject) obj.get("result");
					System.out.println(result.getString("address"));
					sa.setAttendanceOffaddress(result.getString("address"));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}

			// 判断签退时间，如果在当天的17：30和24：00之间才可以签退
			if (DateHandler.compare(DateHandler.dateToStr(currentTime, "HH:mm:ss"),
					DateHandler.dateToStr(slclass.getEndTime(), "HH:mm:ss")) >= 0
					&& DateHandler.compare(DateHandler.dateToStr(currentTime, "HH:mm:ss"),
							DateHandler.dateToStr(slclass.getSignoffEnd(), "HH:mm:ss")) <= 0) {

				// 签退成功
				sa.setSignoffLatitude(Double.toString(latitude));
				sa.setSignoffLongitude(Double.toString(longitude));
				sa.setAttendanceOfftime(DateHandler.dateToTime(currentTime, "HH:mm:ss"));
				sa.setAttendanceOffstatus("正常");
				attendanceMapper.updateByExampleSelective(sa, attendanceExample);
				System.out.println("签退成功");
				json.put("status", 5);
				json.put("address", sa.getAttendanceOffaddress());

			} else if (DateHandler.compare(DateHandler.dateToStr(currentTime, "HH:mm:ss"),
					DateHandler.dateToStr(slclass.getSignoffStart(), "HH:mm:ss")) >= 0
					&& DateHandler.compare(DateHandler.dateToStr(currentTime, "HH:mm:ss"),
							DateHandler.dateToStr(slclass.getEndTime(), "HH:mm:ss")) < 0) {
				// 早退
				sa.setSignoffLatitude(Double.toString(latitude));
				sa.setSignoffLongitude(Double.toString(longitude));
				sa.setAttendanceOfftime(DateHandler.dateToTime(currentTime, "HH:mm:ss"));
				sa.setAttendanceOffstatus("早退");
				attendanceMapper.updateByExampleSelective(sa, attendanceExample);
				System.out.println("早退");
				json.put("status", 4);
				json.put("address", sa.getAttendanceOffaddress());

			}
			// 如果不在签退时间范围，则显示不在时间范围
			else if (DateHandler.compare(DateHandler.dateToStr(currentTime, "HH:mm:ss"),
					DateHandler.dateToStr(slclass.getSignoffStart(), "HH:mm:ss")) < 0) {

				System.out.println("不在签退时间范围内");
				json.put("status", 2);
			}

			else {
				System.out.println("异常!");
			}
		}
		return json;
	}

	@Override
	public @ResponseBody List<JSONObject> attendanceCalendar(String startTime, String endTime, String userId) {
		// JSONArray jsonArray = new JSONArray();
		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		String s = "";

		// String[] status = {"正常","矿工","漏签","迟到","早退"};
		String[] totalStatus = { "签到签退", "签到早退", "签到未签退", "迟到签退", "迟到早退", "迟到未签退", "未签到签退", "未签到早退", "未签到未签退" };
		// 通过wechatId找到对应的employee
		SlianoaEmployeeExample exampleEp = new SlianoaEmployeeExample();
		exampleEp.or().andEmployeeWechatEqualTo(userId);
		List<SlianoaEmployee> employeeList = employeeMapper.selectByExample(exampleEp);

		if (employeeList.size() == 0) {
			// jsonArray.add(0,0);
			// json1.put("status", 0);
			// jsonList.add(json1);
			System.out.println("没有你的信息！");
			return jsonList;
		}

		/*
		 * 功能：实现查询考勤正常、迟到、矿工、漏签的日期，分类管理
		 * 条件：employeeId、startTime、endTime、attendanceTotalStatus
		 */

		SlianoaAttendanceExample attendanceExample = new SlianoaAttendanceExample();
		for (int j = 0; j < totalStatus.length; j++) {
			attendanceExample.clear();
			attendanceExample.or().andEmployeeIdEqualTo(employeeList.get(0).getEmployeeId())
					.andAttendanceTimeBetween(startTime, endTime).andAttendanceTotalStatusEqualTo(totalStatus[j]);
			List<SlianoaAttendance> saList = attendanceMapper.selectByExample(attendanceExample);
			// 表示获取个人信息正常
			// json.put("status", 1);
			if (saList.size() != 0) {
				// 获取到符合条件的考勤记录
				// jsonArray.add(1,1);
				// 存放总的考勤状态条件
				// int[] date = new int[saList.size()];
				String res[] = new String[saList.size()];
				// jsonArray.add(0,totalStatus[j]);
				JSONObject json = new JSONObject();
				json.put("totalStatus", totalStatus[j]);
				for (int i = 0; i < saList.size(); i++) {
					// jsonArray.add(i+1, saList.get(i).getAttendanceTime());
					s = saList.get(i).getAttendanceTime();
					res[i] = DateHandler.formatDate(s);
					// date[i] =
					// DateHandler.getDayFromDate(saList.get(i).getAttendanceTime());

				}
				json.put("date", res);
				jsonList.add(json);

			} /*
				 * else { //没有找到符合条件的考勤记录 jsonArray.add(1, 0);
				 * System.out.println("没有找到符合条件的考勤记录！"); }
				 */
		}
		System.out.println(jsonList.toString());
		// System.out.println(jsonArray.get(0));
		return jsonList;
	}

	@Override
	public @ResponseBody JSONObject showAttendanceInfo(String userId) {
		JSONObject json = new JSONObject();
		Date currentTime = new Date();
		// 通过wechatId找到对应的employee
		SlianoaEmployeeExample exampleEp = new SlianoaEmployeeExample();
		exampleEp.or().andEmployeeWechatEqualTo(userId);
		List<SlianoaEmployee> employeeList = employeeMapper.selectByExample(exampleEp);
		if (employeeList.size() == 0) {
			json.put("status", 0);
			System.out.println("没有你的信息！");
			return json;
		}
		// 通过employeeId和currentTime获取当天的考勤记录
		SlianoaAttendanceExample attendanceExample = new SlianoaAttendanceExample();
		attendanceExample.or().andAttendanceTimeEqualTo(DateHandler.dateToStr(currentTime, "yyyy-MM-dd"))
				.andEmployeeIdEqualTo(employeeList.get(0).getEmployeeId());
		List<SlianoaAttendance> saList = attendanceMapper.selectByExample(attendanceExample);
		// 如果当天的签到状态是正常或者迟到则返回签到地址、签到时间、签到状态
		if (!saList.isEmpty()) {
			json.put("status", 2);
			if (saList.get(0).getAttendanceSignstatus().equals("正常")
					|| saList.get(0).getAttendanceSignstatus().equals("迟到")) {
				json.put("signaddress", saList.get(0).getAttendanceSignaddress());
				json.put("signtime", DateHandler.dateToStr(saList.get(0).getAttendanceSigntime(), "HH:mm:ss"));
				json.put("signstatus", saList.get(0).getAttendanceSignstatus());
			} else {
				json.put("signaddress", "显示签到位置");
				json.put("signtime", "");
				json.put("signstatus", "");
			}
			if (saList.get(0).getAttendanceOffstatus().equals("正常")
					|| saList.get(0).getAttendanceOffstatus().equals("早退")) {
				json.put("offaddress", saList.get(0).getAttendanceOffaddress());
				json.put("offtime", DateHandler.dateToStr(saList.get(0).getAttendanceOfftime(), "HH:mm:ss"));
				json.put("offstatus", saList.get(0).getAttendanceOffstatus());
			} else {
				json.put("offaddress", "显示签退位置");
				json.put("offtime", "");
				json.put("offstatus", "");
			}
		} else {
			json.put("status", 1);
			System.out.println("没有你的考勤信息");
		}
		// 如果当天的签退状态是正常或者早退则返回签退地址、签退时间、签退状态
		return json;
	}

	/*
	 * 实现提交考请申诉 param:flag 0对应签到状态 1对应签退状态
	 * 
	 * @see
	 * com.slianOAsys.service.AttendanceService#submitAppeal(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public @ResponseBody JSONObject submitAppeal(String formUserId, String toUserId, String content, String flag) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		Date currentTime = new Date();
		SlianoaAppeal appeal = new SlianoaAppeal();
		SlianoaAppealExample appealExample = new SlianoaAppealExample();
		// 获取formUserEmployeeId
		SlianoaEmployeeExample exampleEp = new SlianoaEmployeeExample();
		exampleEp.or().andEmployeeWechatEqualTo(formUserId);
		List<SlianoaEmployee> employeeList = employeeMapper.selectByExample(exampleEp);
		if (employeeList.size() == 0) {
			json.put("status", 0);
			System.out.println("没有你的信息！");
			return json;
		}
		// 获取toUserIdEmployeeId
		SlianoaEmployeeExample exampleEp2 = new SlianoaEmployeeExample();
		exampleEp2.or().andEmployeeWechatEqualTo(toUserId);
		List<SlianoaEmployee> employeeList2 = employeeMapper.selectByExample(exampleEp2);
		if (employeeList2.size() == 0) {
			json.put("status", 1);
			System.out.println("没有审批人的信息！");
			return json;
		}
		// 通过employeeId和currentTime获取当天的考勤记录
		SlianoaAttendanceExample attendanceExample = new SlianoaAttendanceExample();
		attendanceExample.or().andAttendanceTimeEqualTo(DateHandler.dateToStr(currentTime, "yyyy-MM-dd"))
				.andEmployeeIdEqualTo(employeeList.get(0).getEmployeeId());
		List<SlianoaAttendance> saList = attendanceMapper.selectByExample(attendanceExample);
		if (saList.isEmpty()) {
			json.put("status", 2);
			System.out.println("今天没有你的考勤信息，无需申诉！");
			return json;
		}
		appeal.setAppealReason(content);
		appeal.setAppealStatus("审批中");
		appeal.setCreateTime(currentTime);
		appeal.setEmployeeId(employeeList.get(0).getEmployeeId());
		appeal.setAppealTime(DateHandler.dateToStr(currentTime, "yyyy-MM-dd"));
		appeal.setHandleEmployeeId(employeeList2.get(0).getEmployeeId());
		appeal.setHandleTime(null);
		appeal.setRelatedEmployee(null);
		// 获取abnormalstatus和时间，并且将两个拼接起来
		if (flag.equals("0")) {
			String status = saList.get(0).getAttendanceSignstatus();
			String time = DateHandler.dateToStr(saList.get(0).getAttendanceSigntime(), "HH:mm");
			String abnormalstatus = time + " " + status;
			appeal.setAbnormalStatus(abnormalstatus);
			appealExample.or().andEmployeeIdEqualTo(appeal.getEmployeeId())
					.andAbnormalStatusEqualTo(appeal.getAbnormalStatus()).andAppealTimeEqualTo(appeal.getAppealTime())
					.andAppealStatusEqualTo("审批中").andHandleEmployeeIdEqualTo(appeal.getHandleEmployeeId());
			if (!appealMapper.selectByExample(appealExample).isEmpty()) {
				// 你提交的申诉还未审批，请耐心等待！
				json.put("status", 3);
			} else {
				appealMapper.insert(appeal);
				// 提交申诉成功
				json.put("status", 4);

			}

		} else {
			String status = saList.get(0).getAttendanceOffstatus();
			String time = DateHandler.dateToStr(saList.get(0).getAttendanceOfftime(), "HH:mm");
			String abnormalstatus = time + " " + status;
			appeal.setAbnormalStatus(abnormalstatus);
			appealExample.or().andEmployeeIdEqualTo(appeal.getEmployeeId())
					.andAbnormalStatusEqualTo(appeal.getAbnormalStatus()).andAppealTimeEqualTo(appeal.getAppealTime())
					.andAppealStatusEqualTo("审批中").andHandleEmployeeIdEqualTo(appeal.getHandleEmployeeId());
			if (!appealMapper.selectByExample(appealExample).isEmpty()) {
				// 你提交的申诉还未审批，请耐心等待！
				json.put("status", 5);
			} else {
				appealMapper.insert(appeal);
				// 提交申诉成功
				json.put("status", 6);

			}
		}
		return json;
	}

	/*
	 * status:审批中、审批通过、审批未通过
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<JSONObject> showAppeal(String userId, String status) {
		// TODO Auto-generated method stub
		// JSONObject json = new JSONObject();
		String s = "";
		// 根据status的状态进行相应操作

		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		// 通过wechatId找到对应的employee
		SlianoaEmployeeExample exampleEp = new SlianoaEmployeeExample();
		exampleEp.or().andEmployeeWechatEqualTo(userId);
		List<SlianoaEmployee> employeeList = employeeMapper.selectByExample(exampleEp);
		if (employeeList.size() == 0) {
			// json.put("status", 0);
			System.out.println("没有你的信息！");
			return jsonList;
		}
		// 通过employeeId和appealstatus找到相应的申诉记录（可能是多条）
		SlianoaAppealExample appealEp = new SlianoaAppealExample();
		appealEp.or().andEmployeeIdEqualTo(employeeList.get(0).getEmployeeId()).andAppealStatusEqualTo(status);
		List<SlianoaAppeal> appealList = appealMapper.selectByExample(appealEp);
		if (appealList.isEmpty()) {
			// json.put("status", 1);
			System.out.println("没有你的申诉记录！");
			return jsonList;
		}
		// 通过审批人的ID找到审批人的信息
		SlianoaEmployeeExample exampleEp2 = new SlianoaEmployeeExample();

		// 有申诉记录
		// json.put("status", 2);
		for (int i = 0; i < appealList.size(); i++) {
			JSONObject json = new JSONObject();
			exampleEp2.clear();
			exampleEp2.or().andEmployeeIdEqualTo(appealList.get(i).getHandleEmployeeId());
			List<SlianoaEmployee> employeeList2 = employeeMapper.selectByExample(exampleEp2);
			json.put("appealTime", appealList.get(i).getAppealTime());
			json.put("abnormalStatus", appealList.get(i).getAbnormalStatus());
			json.put("name", employeeList.get(0).getEmployeeName());
			json.put("appealStatus", appealList.get(i).getAppealStatus());
			json.put("appealReason", appealList.get(i).getAppealReason());
			json.put("handleTime", appealList.get(i).getHandleTime());
			if (!employeeList2.isEmpty()) {
				json.put("handleEmployeeName", employeeList2.get(0).getEmployeeName());
			} else {
				json.put("handleEmployeeName", "");
			}
			// json.put(key, value);
			jsonList.add(json);
			
		}
		/*
		 * JsonConfig config = new JsonConfig();
		 * config.setIgnoreDefaultExcludes(false);
		 * config.registerJsonValueProcessor(Date.class, new
		 * DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		 */
		// jsonList = JSONArray.fromObject(jsonList, config);
		System.out.println("Total nums"+jsonList.size());
		return jsonList;
	}

	@Override
	public List<JSONObject> showAppealNeedToHandled(String userId, String status) {
		// TODO Auto-generated method stub
		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		// 通过wechatId找到对应的employee
		SlianoaEmployeeExample exampleEp = new SlianoaEmployeeExample();
		exampleEp.or().andEmployeeWechatEqualTo(userId);
		List<SlianoaEmployee> employeeList = employeeMapper.selectByExample(exampleEp);
		if (employeeList.size() == 0) {
			// json.put("status", 0);
			System.out.println("没有你的信息！");
			return jsonList;
		}
		// 通过employeeId和appealstatus找到相应的申诉记录（可能是多条）
		SlianoaAppealExample appealEp = new SlianoaAppealExample();
		appealEp.or().andHandleEmployeeIdEqualTo(employeeList.get(0).getEmployeeId()).andAppealStatusEqualTo(status);
		List<SlianoaAppeal> appealList = appealMapper.selectByExample(appealEp);
		if (appealList.isEmpty()) {
			// json.put("status", 1);
			System.out.println("没有你的申诉记录！");
			return jsonList;
		}
		// 通过申诉人的ID找到申诉人的信息
		SlianoaEmployeeExample exampleEp2 = new SlianoaEmployeeExample();

		for (int i = 0; i < appealList.size(); i++) {
			JSONObject json = new JSONObject();
			exampleEp2.clear();
			exampleEp2.or().andEmployeeIdEqualTo(appealList.get(i).getEmployeeId());
			List<SlianoaEmployee> employeeList2 = employeeMapper.selectByExample(exampleEp2);
			json.put("appealTime", appealList.get(i).getAppealTime());
			json.put("abnormalStatus", appealList.get(i).getAbnormalStatus());
			json.put("HandleName", employeeList.get(0).getEmployeeName());
			json.put("appealStatus", appealList.get(i).getAppealStatus());
			json.put("appealReason", appealList.get(i).getAppealReason());
			json.put("handleTime", appealList.get(i).getHandleTime());
			if (!employeeList2.isEmpty()) {
				json.put("appealName", employeeList2.get(0).getEmployeeName());
			} else {
				json.put("appealName", "");
			}
			// json.put(key, value);
			jsonList.add(json);
			System.out.println("Total nums"+jsonList.size());
		}
		return jsonList;
	}
    /*
     * 处理申诉
     * userId 为申诉者的Id
     * 当申诉通过，应该修改考勤记录为正常，修改对应的属性。
     * @see com.slianOAsys.service.AttendanceService#handleAppeal(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
	@Override
	public JSONObject handleAppeal(String userId, String appealTime, String abnormalStatus,String handleStatus) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		Date currentTime = new Date();
		// 获取申申诉者的EmployeeId
		SlianoaEmployeeExample exampleEp = new SlianoaEmployeeExample();
		exampleEp.or().andEmployeeWechatEqualTo(userId);
		List<SlianoaEmployee> employeeList = employeeMapper.selectByExample(exampleEp);
		if (employeeList.size() == 0) {
			json.put("status", 0);
			System.out.println("没有你的信息！");
			return json;
		}
		// 根据申诉者ID，申诉时间（对应当天的考勤），异常状态对未审批的信息进行审批
		SlianoaAppealExample appealEp = new SlianoaAppealExample();
		appealEp.or().andEmployeeIdEqualTo(employeeList.get(0).getEmployeeId()).andAppealTimeEqualTo(appealTime)
				.andAbnormalStatusEqualTo(abnormalStatus).andAppealStatusEqualTo("审批中");
		List<SlianoaAppeal> appealList = appealMapper.selectByExample(appealEp);
		if (appealList.isEmpty()) {
			json.put("status", 1);
			System.out.println("没有待处理的申诉记录！");
			return json;
		}
		SlianoaAppeal sa = new SlianoaAppeal();
		sa.setAppealId(appealList.get(0).getAppealId());
		sa.setAppealStatus(handleStatus);
		sa.setHandleTime(DateHandler.dateToStr(currentTime, "yyyy-MM-dd HH:mm:ss"));
		appealMapper.updateByPrimaryKeySelective(sa);
		json.put("status", 2);
		return json;
	}
}
