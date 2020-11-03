/**
 * 
 */
package com.sliansoft.slianOA.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sliansoft.slianOA.dataaccess.dao.OaNewsMapper;
import com.sliansoft.slianOA.dataaccess.model.OaAttachment;
import com.sliansoft.slianOA.dataaccess.model.OaNews;
import com.sliansoft.slianOA.dataaccess.model.OaNewsExample;
import com.sliansoft.slianOA.dataaccess.model.OaNewsExample.Criteria;
import com.sliansoft.slianOA.service.BasicDataSetService;
import com.sliansoft.slianOA.service.EmployeeService;
import com.sliansoft.slianOA.service.OaAttachmentService;
import com.sliansoft.slianOA.service.OaNewsService;
import com.sliansoft.slianOA.service.OaWorkflowService;
import com.sliansoft.slianOA.service.OrganizationStructureService;
import com.sliansoft.slianOA.service.dataauthorize.DataAuthorizeService;
import com.sliansoft.slianOA.service.httpModels.HttpOaNews;
import com.sliansoft.slianOA.service.utils.Const;
import com.sliansoft.slianOA.service.utils.CriteriaUtils;
import com.sliansoft.slianOA.service.utils.DateHandler;
import com.sliansoft.slianOA.service.utils.DateJsonValueProcessor;
import com.sliansoft.slianOA.service.utils.ReflectionUtils;

/**
 * Copyright@宁波高新区敏智科技有限公司 www.mz3co.com Copyright@浙江大学软件学院S309实验室
 * 
 * @author chengxl Cteated time：2015年1月8日 上午9:13:48
 * @param <JSONArray>
 * 
 */
public class OaNewsServiceImpl  implements OaNewsService {

	@Autowired 
	private OaNewsMapper oaNewsMapper;
	
//	@Autowired
//	private OaNewsMapperEx oaNewsMapperEx;

	@Autowired
	private BasicDataSetService basicDataSetService;

	@Autowired
	private OrganizationStructureService organizationStructureService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private OaWorkflowService oaWorkflowService;
	
	@Autowired
	private HttpSession session;

	@Autowired
	private OaAttachmentService oaAttachmentService;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mz3co.pcbas.service.NewsService#getNewsByPage(java.lang
	 * .Integer, java.lang.Integer)
	 */
	public Map<String, Object> getByPage(String keys, Integer pageSize,
			Integer pageNow) {

		OaNewsExample example = new OaNewsExample();

		// 设置Example
		this.setNewsExample(example, keys);// this.keysToNews(keys)
		
		//添加数据访问控制权限
	//	DataAuthorizeService.setExampleByAuthorization(example,session);

		int totalrecords = oaNewsMapper.countByExample(example);

//		Page page = new Page();
//		page.setBegin((pageNow - 1)* pageSize);
//		page.setLength(pageSize);
		
		example.setPageIndex(pageNow);
		example.setPageSize(pageSize);
		example.setOrderByClause("create_time desc");

		List<OaNews> listNews = oaNewsMapper.selectByExampleWithBLOBs(example);

		// 处理json数据中的日期格式
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));// HH:mm:ss

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalrecords);
		if (totalrecords % pageSize == 0)
			map.put("totalPages", totalrecords / pageSize);
		else
			map.put("totalPages", totalrecords / pageSize + 1);

		map.put("rows",
				JSONArray.fromObject(this.converToHttpList(listNews), config));

		return map;

	}

	private List<HttpOaNews> converToHttpList(List<OaNews> listNews) {

		List<HttpOaNews> httpOaNews = new ArrayList<HttpOaNews>();
		for (OaNews oaNews : listNews) {



			httpOaNews.add(this.convertToHttp(oaNews));

		}

		return httpOaNews;

	}
	
	private HttpOaNews convertToHttp(OaNews oaNews){
		
		HttpOaNews httpOaNew = new HttpOaNews();

		BeanUtils.copyProperties(oaNews, httpOaNew);

		httpOaNew.setUserName(employeeService.idToName(oaNews.getCreator()));
		httpOaNew.setViewEmployeeName(this.convertViewEmployeeIdsToNames(oaNews.getViewEmployeeIds()));
		httpOaNew.setOrgName(organizationStructureService
				.idToName(employeeService.idToOrgId(oaNews.getCreator())));
		
		return httpOaNew;
	}
	
	private String convertViewEmployeeIdsToNames(String ids){
		
		if(StringUtils.isEmpty(ids))
			return "";
		
		String names = "";
		
		for(String id:ids.split(",")){
			
		Integer 	intID = Integer.parseInt(id) ;
		
			//大于100000 的id为员工ID
			if( intID  > 100000)
				
				names += Const.EMPLOYEE_MAP.get(intID-100000)== null?"":Const.EMPLOYEE_MAP.get(intID-100000).get("name")+",";
		}
	
		
		return names;
	}

	// 根据news model对象的值，设置Criteria
	private void setNewsExample(OaNewsExample example, String keys) {
		
		

		JSONObject jKeys = JSONObject.fromObject(keys);

		Criteria criteria = example.createCriteria();
		
		if (keys == null || "{}".equals(keys))
			return;
		
		
		//todo  be delete
		criteria.andNewsIdIsNotNull();
		
		// // 设置日期
		 if (jKeys.containsKey("startDate") && !StringUtils.isEmpty(jKeys.getString("startDate")) )
			 
			 criteria.andCreateTimeGreaterThan(DateHandler
		 .strToDate(jKeys.getString("startDate"), "yyyy-MM-dd"));
	
		 if (jKeys.containsKey("endDate") && !StringUtils.isEmpty(jKeys.getString("endDate")) )
			 criteria.andCreateTimeLessThanOrEqualTo(DateHandler.strToDate(
		 jKeys.getString("endDate"), "yyyy-MM-dd"));

		OaNews news = (OaNews) jKeys.toBean(jKeys, OaNews.class);

		if (news == null)
			return;
		

		// 获得news model非空（null）属性list
		List<Map<?, ?>> list = ReflectionUtils.getFiledValues(news, false);

		CriteriaUtils.setCriteria(criteria, list);	
		
	
	}

	@Transactional
	public String insert(OaNews oaNews) {
	//oaNews.setStatus("处理中");
		
		//用于查找自定义的工作流
		//oaNews.setType("通知");
		// 插入通知记录
		if (oaNewsMapper.insertSelective(oaNews) != 1){
			
			
		
			return "数据库访问异常，新增失败！";
		}else{
			/*//插入附件信息
			OaAttachment oaAttachment = new 	OaAttachment();
			
			oaAttachment.setBusinessTable("oa_news");
			
			oaAttachment.setBusinessId( oaNews.getNewsId());
			System.out.println(oaNews.getNewsId());
			oaAttachmentService.insertBySession(oaAttachment);*/
		}
		// 插入工作流信息
		return "success";//oaWorkflowService.insertForBusiness(oaNews);
	}

	public String update(OaNews oaNews) {

		try {
			// 修改通知记录
			oaNewsMapper.updateByPrimaryKeySelective(oaNews);

		} catch (Exception e) {

			e.printStackTrace();
			return "数据库访问异常，修改失败！";
		}

		
		return  "success";// oaWorkflowService.insertForBusiness(oaNews);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mz3co.pcbas.service.NewsService#deleteNewsById(java.lang
	 * .String[])
	 */
	public String deleteById(String[] Ids) {

		for (String id : Ids) {
			int newId = Integer.parseInt(id);

			this.doDelete(newId);

			System.out.println("删除：" + id);
		}
		return "success";
	}

	public boolean doDelete(int newId) {

		return oaNewsMapper.deleteByPrimaryKey(newId) > 0 ? true : false;
	}

	public OaNews getByKey(String key) {

		if (key == null || "".equals(key))
			return null;

		return oaNewsMapper.selectByPrimaryKey(Integer.parseInt(key));
	}

	@Override
	public HttpOaNews getById(String newsId) {

		OaNews oaNews = oaNewsMapper.selectByPrimaryKey(Integer.parseInt(newsId));
		HttpOaNews httpOaNews = new HttpOaNews();
		BeanUtils.copyProperties(oaNews, httpOaNews);
		httpOaNews.setUserName(employeeService.idToName(oaNews.getCreator()));
		httpOaNews.setOrgName(organizationStructureService
				.idToName(employeeService.idToOrgId(oaNews.getCreator())));
		httpOaNews.setViewEmployeeName(
				this.convertViewEmployeeIdsToNames(oaNews.getViewEmployeeIds()));
		

		return httpOaNews;
	}

	@Override
	public HttpOaNews getNews(String newsId, String type) {
HttpOaNews httpOaNews =  this.getById(newsId);
		
		//添加附件内容
		this.setAttachment(httpOaNews,type);
		
		
		//添加工作流信息
//		OaWorkflow oaWorkflow = oaWorkflowService.get("oa_document", id);
//		
//		httpOaDocument.setWorkflowResult(oaWorkflow.getWorkflowResult());
//		httpOaDocument.setWorkflowOpinion(oaWorkflow.getWorkflowOpinion());
		
		return httpOaNews;
	}
	

		private void setAttachment(HttpOaNews httpOaNews,String type){
			
			
			OaAttachment oaAttachment = new OaAttachment();
			
			oaAttachment.setBusinessTable("oa_news");
			oaAttachment.setBusinessId(httpOaNews.getNewsId());
			oaAttachment.setType("附件");
			httpOaNews.setAttachmentZW(oaAttachmentService.getAttachmentHTML(oaAttachment,type));
			
			/*oaAttachment.setType("附件");
			httpOaNews.setAttachmentFJ(oaAttachmentService.getAttachmentHTML(oaAttachment,type));*/
		}

}