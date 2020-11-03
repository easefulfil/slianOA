package com.sliansoft.slianOA.mobile.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.service.utils.DateHandler;

/*
 * 该类负责判断每位员工每日考勤的状态
 */
@Controller
@RequestMapping(value="/UpdateOaAttendance")
public class UpdateOaAttendance {

	@Autowired
	private DataSource dataSource;
	
	@RequestMapping(value="/update.do")
	public @ResponseBody int updateOaAttendance(){
		Date d = new Date();
		//SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		d = DateHandler.addDay(d, -1); // 计算前一天的班次状态
		String date = DateHandler.dateToStr(d, "yyyy-MM-dd");
		//String date = "2017-07-07";
		Connection conn = null;

		Statement stmt = null;

		int rs = 0;
		
		try{
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			
			String sql = "UPDATE oa_attendance "
					+"SET status = ( "
					+"CASE "
					+"	WHEN signin_status = '正常' THEN ( "
					+"CASE signout_status "
					+"WHEN '正常' THEN '正常' "
					+"WHEN '早退' THEN '早退' "
					+"ELSE '异常' "
					+"END ) "
					+" WHEN signout_status = '正常' THEN ( "
					+"CASE signin_status "
					+"WHEN '正常' THEN '正常' "
					+"WHEN '迟到' THEN '迟到' "
					+"ELSE '异常' "
					+"END ) "
					+" WHEN signin_status = '请假' OR signin_status = '出差' THEN ( "
					+"CASE signout_status "
					+"WHEN '正常' THEN '正常' "
					+"WHEN '迟到' THEN '迟到' "
					+"WHEN '请假' THEN '请假' "
					+"WHEN '出差' THEN '出差' "
					+"ELSE '异常' "
					+"END ) "
					+" WHEN signout_status = '请假' OR signout_status = '出差' THEN ( "
					+"CASE signin_status "
					+"WHEN '正常' THEN '正常' "
					+"WHEN '迟到' THEN '迟到' "
					+"WHEN '请假' THEN '请假' "
					+"WHEN '出差' THEN '出差' "
					+"ELSE '异常' "
					+"END ) "
					+"WHEN signin_status = '异常' or signout_status = '异常' THEN '异常' "
					+"WHEN signin_status is NULL and signout_status is NULL THEN '旷工' "
					+"WHEN signin_status = 'cancel' or signout_status = 'cancel' THEN '异常' "
					+"WHEN signin_status = 'cancel' and signout_status = 'cancel' THEN '旷工' "
					+"END )"
					+"WHERE sign_date = '" + date + "' ;";
			rs = stmt.executeUpdate(sql);
			
			return rs;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {

			try {
				if (stmt != null)
					stmt.close();

				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				return 0;
			}

		}
		
	}
}
