package com.sliansoft.slianOA.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.utils.SysConst;
import com.sliansoft.slianOA.dataaccess.model.SysBasicDataSet;
import com.sliansoft.slianOA.dataaccess.model.SysEmployee;
import com.sliansoft.slianOA.service.BasicDataSetService;
import com.sliansoft.slianOA.service.httpModels.HttpJson;
import com.sliansoft.slianOA.service.utils.BasicDataSetTreeNode;

@Controller
@RequestMapping(value="/basicdataset")
 
public class SysBasicDataSetController {

	@Autowired
	private BasicDataSetService basicDataSetService;
	
	
	/**
	 * 根据parentId 返回基础数据，以key，val方式返回 
	 * @param pId
	 * @return  
	 */
	@RequestMapping(value = "/getBasicDataName.do")
	public @ResponseBody JSONArray getBasicDataSetNamebyPId(String parentId,HttpServletRequest req){ 
//		if (parentId.equals("1000")){
//			
//		HttpSession session=req.getSession();
//		Employee employee= (Employee) session.getAttribute("employee");
//		String depentment=employee.getEmployeeType();
//		if(depentment.equals("全部")){
//			parentId="357";
//		}
//		if(depentment.equals("海运"))
//			parentId="357";
//		if(depentment.equals("报关"))
//			parentId="362";
//		if(depentment.equals("外贸"))
//			parentId="380";
//		if(depentment.equals("仓储"))
//			parentId="366";
//		
//		}
//		if (parentId.equals("1001")){
//			
//			HttpSession session=req.getSession();
//			Employee employee= (Employee) session.getAttribute("employee");
//			String depentment=employee.getEmployeeType();
//			if(depentment.equals("海运"))
//				parentId="380";
//			if(depentment.equals("报关"))
//				parentId="380";
//			if(depentment.equals("外贸"))
//				parentId="370";
//			if(depentment.equals("仓储"))
//				parentId="375";
//			
//			}
		if(StringUtils.isEmpty(parentId))
			return null;
		
		List<BasicDataSetTreeNode> listBDS =   SysConst.BASICDATASET_TREE.getLeafNodes(
				SysConst.BASICDATASET_TREE.getNode(Integer.parseInt(parentId)));
		
		
		//按名称进行排序
		Collections.sort(listBDS, new Comparator<SysBasicDataSet>() {
			public int compare(SysBasicDataSet arg0, SysBasicDataSet arg1) {
				return arg0.getBasicDataId().compareTo(arg1.getBasicDataId());
			}
		});
		
		JSONArray array = new JSONArray();
		for (SysBasicDataSet bds : listBDS) {
			JSONObject json =new JSONObject();
			json.put("id", bds.getBasicDataId());
			json.put("name", bds.getChineseName());
			array.add(json);
		}
		
		


//		return basicDataSetService.getBasicDataSet(Integer.parseInt(parentId));
		return array;
	}
	
	
	
	/**
	 * 根据parentId 返回基础数据，以key，val方式返回 
	 * @param pId
	 * @return  
	 */
	@RequestMapping(value = "/getBasicData.do")
	public @ResponseBody JSONArray getBasicDataSetbyPId(String parentId){ 
		
		if(StringUtils.isEmpty(parentId))
			return null;
		
		List<BasicDataSetTreeNode> listBDS =   SysConst.BASICDATASET_TREE.getLeafNodes(SysConst.BASICDATASET_TREE.getNode(Integer.parseInt(parentId)));
		
		
		//按名称进行排序
		Collections.sort(listBDS, new Comparator<SysBasicDataSet>() {
			public int compare(SysBasicDataSet arg0, SysBasicDataSet arg1) {
				return arg0.getEnglishName().compareTo(arg1.getEnglishName());
			}
		});
		
		JSONArray array = new JSONArray();
		for (SysBasicDataSet bds : listBDS) {
			JSONObject json =new JSONObject();
			json.put("id", bds.getBasicDataId());
			json.put("name", bds.getChineseName());//bds.getEnglishName()+" || "+
			array.add(json);
		}
		
		


//		return basicDataSetService.getBasicDataSet(Integer.parseInt(parentId));
		return array;
	}
	
	@RequestMapping(value = "/getBasicDataSetbyParentId.do")
	public @ResponseBody List<BasicDataSetTreeNode>  getBasicDataSetbyParentId(String parentId){ 
		
		if(StringUtils.isEmpty(parentId))
			return null;
		

//		return basicDataSetService.getBasicDataSet(Integer.parseInt(parentId));
		return SysConst.BASICDATASET_TREE.getNode(Integer.parseInt(parentId)).getChildren();
	}
	
	@RequestMapping(value = "/listBDSTree.do")
	public @ResponseBody List<BasicDataSetTreeNode> listBDSTree(){ 

		return SysConst.BASICDATASET_TREE.getBDSTreeNodes();
	}
	
	@RequestMapping(value = "/listParentBDSTree.do")
	public @ResponseBody List<BasicDataSetTreeNode> listParentBDSTree(){ 
		
		return SysConst.BASICDATASET_TREE.getBDSParentTreeNodes();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insert.do")
	public @ResponseBody HttpJson insert(
			HttpServletRequest request){ 

		
		JSONObject joBDS = JSONObject.fromObject(request.getParameter("bds"));

		HttpJson j = new HttpJson();
		if(basicDataSetService.insert((SysBasicDataSet)JSONObject.toBean(joBDS, SysBasicDataSet.class))){
			j.setSuccess(true);
			j.setMsg("基本信息保存成功！");
		}
		else{
			j.setSuccess(false);
			j.setMsg("基本信息保存成功!");
		}		
		return j;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/update.do")
	public @ResponseBody HttpJson update(
			HttpServletRequest request){ 
		
		JSONObject joBDS = JSONObject.fromObject(request.getParameter("bds"));
			
		HttpJson j = new HttpJson();
		
		
		if(basicDataSetService.update((SysBasicDataSet)JSONObject.toBean(joBDS, SysBasicDataSet.class))){
			j.setSuccess(true);
			j.setMsg("基本信息修改成功！");
		}
		else{
			j.setSuccess(false);
			j.setMsg("基本信息修改失败!");
		}		
		return j;
	}
	

	@RequestMapping(value = "/delete.do")
	public @ResponseBody Object delete(String id){ 
		
		if(id == null || "".equals(id))
			return "no found";
		
		HttpJson j = new HttpJson();
		
		
		if(basicDataSetService.delete(Integer.parseInt(id))){
			j.setSuccess(true);
			j.setMsg("基本信息删除成功！");
		}
		else{
			j.setSuccess(false);
			j.setMsg("包含子节点的基本信息不能删除，删除失败!");
		}		
		return j;

	}
	
}
