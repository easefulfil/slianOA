package com.slianOAsys.util;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.slianOAsys.dao.SlianoaAttendanceMapper;
import com.slianOAsys.dao.SlianoaClassEmployeeMapper;
import com.slianOAsys.dao.SlianoaClassMapper;
import com.slianOAsys.model.SlianoaAttendance;
import com.slianOAsys.model.SlianoaAttendanceExample;
import com.slianOAsys.model.SlianoaClass;
import com.slianOAsys.model.SlianoaClassEmployee;
import com.slianOAsys.model.SlianoaClassEmployeeExample;
import com.slianOAsys.model.SlianoaClassExample;

public class AutoInsertAttenRecord {
	@Autowired
	private SlianoaAttendanceMapper attendanceMapper;
	@Autowired
	private SlianoaClassMapper classMapper;
	@Autowired
	private SlianoaClassEmployeeMapper classEmployeeMapper;

	/*
	 * 判断是否有班次，若有班次则向考勤表中插入记录
	 */
	@SuppressWarnings("deprecation")
	public void insertAttenRecord() {

		// 获取当前时间
		Date currentdate = new Date();
		Date lastDayDate = DateHandler.addDay(currentdate, 1);
		// 得到明天是周几
		int num = DateHandler.getWeekOfDate(lastDayDate);
		System.out.println(num);
		SlianoaAttendance attendance = new SlianoaAttendance();
		SlianoaClassEmployeeExample cEmployeeExample = new SlianoaClassEmployeeExample();
		// cEmployeeExample.or().andClassIdEqualTo(0);
		SlianoaClassExample classExample = new SlianoaClassExample();
		switch (num) {
		default:
			System.out.println("日期转换失败！");
			break;
		case 1:
			classExample.or().andIsMondayEqualTo(1);
			break;
		case 2:
			classExample.or().andIsTuesdayEqualTo(1);
			break;
		case 3:
			classExample.or().andIsWednesdayEqualTo(1);
			break;
		case 4:
			classExample.or().andIsThursdayEqualTo(1);
			break;
		case 5:
			classExample.or().andIsFridayEqualTo(1);
			break;
		case 6:
			classExample.or().andIsSaturdayEqualTo(1);
			break;
		case 7:
			classExample.or().andIsSundayEqualTo(1);
			break;
		}

		List<SlianoaClass> classList = null;
		// 判断是否需要上班
		if (num < 8 && num > 0) {
			System.out.println(num);
			// 查出周num需要上班的班次记录
			classList = classMapper.selectByExample(classExample);
			if (classList.size() != 0) {
				for (int i = 0; i < classList.size(); i++) {
					cEmployeeExample.or().andClassIdEqualTo(classList.get(i).getClassId());
				}
				List<SlianoaClassEmployee> classEmployeeList = classEmployeeMapper.selectByExample(cEmployeeExample);
				// 获取有班次的雇员id
				for (int i = 0; i < classEmployeeList.size(); i++) {
					attendance.setCreateTime(currentdate);
					attendance.setEmployeeId(classEmployeeList.get(i).getEmployeeId());
					attendance.setAttendanceTime(DateHandler.getLateDayDate());
					attendance.setAttendanceSigntime(new Time(0, 0, 0));
					attendance.setAttendanceOfftime(new Time(0, 0, 0));
					attendance.setAttendanceSignaddress(null);
					attendance.setAttendanceOffaddress(null);
					attendance.setAttendanceSignstatus("未签到");
					attendance.setAttendanceOffstatus("未签退");
					attendance.setAttendanceTotalStatus("未签到未签退");
					attendance.setSigninLongitude(null);
					attendance.setSigninLatitude(null);
					attendance.setSignoffLongitude(null);
					attendance.setSignoffLatitude(null);
					attendance.setAmendTime(currentdate);
					attendance.setAmender(null);
					attendance.setWorkHour((float) 0);
					attendanceMapper.insert(attendance);

					System.out.println("插入成功！");
				}
			} else {
				System.out.println("今天不上班！");
			}
		} else {

			System.out.println("插入数据失败！");
		}

	}

	/*
	 * 统计今日的考勤状态和工作时间
	 */
	public void AttendanceConclusion() {
		// 获取当前时间
		Date currentdate = new Date();
		long workTime;
		String[] status = { "正常", "迟到", "未签到", "早退", "未签退" };
		String[] totalStatus = { "签到签退", "签到早退", "签到未签退", "迟到签退", "迟到早退", "迟到未签退","未签到签退", "未签到早退", "未签到未签退"};
		SlianoaAttendanceExample attendanceExample = new SlianoaAttendanceExample();
		attendanceExample.or().andAttendanceTimeEqualTo(DateHandler.dateToStr(currentdate, "yyyy-MM-dd"));
		List<SlianoaAttendance> attendanceList = attendanceMapper.selectByExample(attendanceExample);
		for (int i = 0; i < attendanceList.size(); i++) {
			// 1.根据签到签退状态修改当日考勤状态 2.修改工作时间
			System.out.println("签到状态是"+attendanceList.get(i).getAttendanceSignstatus());
			System.out.println("签退状态是"+attendanceList.get(i).getAttendanceOffstatus());
			if (attendanceList.get(i).getAttendanceSignstatus().equals(status[0])
					&& attendanceList.get(i).getAttendanceOffstatus().equals(status[0])) {

				// 修改考勤总状态
				attendanceList.get(i).setAttendanceTotalStatus(totalStatus[0]);
				// 获取工作时间
				workTime = DateHandler.compare(attendanceList.get(i).getAttendanceOfftime(),
						attendanceList.get(i).getAttendanceSigntime());
				attendanceList.get(i).setWorkHour((float) workTime / 60);
				attendanceMapper.updateByPrimaryKeySelective(attendanceList.get(i));

			} else if (attendanceList.get(i).getAttendanceSignstatus().equals(status[0])
					&& attendanceList.get(i).getAttendanceOffstatus().equals(status[3])) {

				attendanceList.get(i).setAttendanceTotalStatus(totalStatus[1]);
				workTime = DateHandler.compare(attendanceList.get(i).getAttendanceOfftime(),
						attendanceList.get(i).getAttendanceSigntime());
				attendanceList.get(i).setWorkHour((float) workTime / 60);
				attendanceMapper.updateByPrimaryKeySelective(attendanceList.get(i));

			} else if (attendanceList.get(i).getAttendanceSignstatus().equals(status[0])
					&& attendanceList.get(i).getAttendanceOffstatus().equals(status[4])) {
				
				attendanceList.get(i).setAttendanceTotalStatus(totalStatus[2]);
				attendanceMapper.updateByPrimaryKeySelective(attendanceList.get(i));
				
			} else if (attendanceList.get(i).getAttendanceSignstatus().equals(status[1])
					&& attendanceList.get(i).getAttendanceOffstatus().equals(status[0])) {
				
				attendanceList.get(i).setAttendanceTotalStatus(totalStatus[3]);
				workTime = DateHandler.compare(attendanceList.get(i).getAttendanceOfftime(),
						attendanceList.get(i).getAttendanceSigntime());
				attendanceList.get(i).setWorkHour((float) workTime / 60);
				attendanceMapper.updateByPrimaryKeySelective(attendanceList.get(i));

			} else if (attendanceList.get(i).getAttendanceSignstatus().equals(status[1])
					&& attendanceList.get(i).getAttendanceOffstatus().equals(status[3])) {
				
				attendanceList.get(i).setAttendanceTotalStatus(totalStatus[4]);
				workTime = DateHandler.compare(attendanceList.get(i).getAttendanceOfftime(),
						attendanceList.get(i).getAttendanceSigntime());
				attendanceList.get(i).setWorkHour((float) workTime / 60);
				attendanceMapper.updateByPrimaryKeySelective(attendanceList.get(i));
				

			} else if (attendanceList.get(i).getAttendanceSignstatus().equals(status[1])
					&& attendanceList.get(i).getAttendanceOffstatus().equals(status[4])) {
				
				attendanceList.get(i).setAttendanceTotalStatus(totalStatus[5]);
				attendanceMapper.updateByPrimaryKeySelective(attendanceList.get(i));
				
			} else if (attendanceList.get(i).getAttendanceSignstatus().equals(status[2])
					&& attendanceList.get(i).getAttendanceOffstatus().equals(status[0])) {

				attendanceList.get(i).setAttendanceTotalStatus(totalStatus[6]);
				attendanceMapper.updateByPrimaryKeySelective(attendanceList.get(i));				
				
			} else if (attendanceList.get(i).getAttendanceSignstatus().equals(status[2])
					&& attendanceList.get(i).getAttendanceOffstatus().equals(status[3])) {

				attendanceList.get(i).setAttendanceTotalStatus(totalStatus[7]);
				attendanceMapper.updateByPrimaryKeySelective(attendanceList.get(i));				
				
			} else if (attendanceList.get(i).getAttendanceSignstatus().equals(status[2])
					&& attendanceList.get(i).getAttendanceOffstatus().equals(status[4])) {
				
				attendanceList.get(i).setAttendanceTotalStatus(totalStatus[8]);
				attendanceMapper.updateByPrimaryKeySelective(attendanceList.get(i));
				
			} else {
                System.out.println("异常！");
			}

		}
	}
}
