package com.slianOAsys.dao.ex;

import java.util.List;

import com.slianOAsys.model.ex.AttendanceEx;
import com.slianOAsys.model.ex.AttendanceExExample;

public interface SlianoaAttendanceExMapper {
	 List<AttendanceEx> selectByExample(AttendanceExExample example);
	 
	 List<AttendanceEx> MonthselectByExample(AttendanceExExample example);
	 
	 int countByExample(AttendanceExExample example);
}
