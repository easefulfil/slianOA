package com.slianOAsys.dao.ex;

import com.slianOAsys.model.ex.AppealEx;
import com.slianOAsys.model.ex.AppealExExample;

import java.util.List;

public interface SlianoaAppealExMapper {
	List<AppealEx> selectByExample(AppealExExample example);
	 
	 int countByExample(AppealExExample example);
}