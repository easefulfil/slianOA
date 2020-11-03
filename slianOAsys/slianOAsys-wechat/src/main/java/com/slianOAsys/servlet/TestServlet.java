package com.slianOAsys.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slianOAsys.service.AttendanceService;

public class TestServlet {
  @Autowired
  private AttendanceService attendanceService;
  @RequestMapping(value="/test.do")
  public void testAttendance(HttpServletRequest request,HttpServletResponse response){
	  
  }
}
