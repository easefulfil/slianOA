package com.sliansoft.slianOA.mobile.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.slianOA.dataaccess.model.OaAsset;
import com.sliansoft.slianOA.service.OaAssetService;
import com.sliansoft.slianOA.service.httpModels.HttpJson;
import com.sliansoft.slianOA.service.utils.DateMorpherEx;
import com.sliansoft.slianOA.service.utils.OaAssetTreeNode;
import com.sliansoft.slianOA.utils.SysConst;

@Controller
@RequestMapping(value="/mobile-ajax/auth/oaAsset")
public class OaAssetMobileController {

	@Autowired
	private OaAssetService oaAssetService;
	
	/**
	 * 根据条件查询资产
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/list.do")
	public @ResponseBody Object list(HttpServletRequest req){

		String keys = req.getParameter("keys");
		if(!StringUtils.isEmpty(keys)){
			try {
				keys = URLDecoder.decode(keys, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return "false";
			}
		}
		Integer pageSize = Integer.parseInt(req.getParameter("rows"));
		Integer pageIndex = Integer.parseInt(req.getParameter("page"));

		Map<String, Object> map =oaAssetService.getByPage(keys, pageSize,
				pageIndex);

		return JSONObject.fromObject(map);
	}
	/**
	 * 返回所有资产类别
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/type/list.do")
	public @ResponseBody Object typeList(HttpServletRequest req){
		JSONArray jsonArray = new JSONArray();
		for(OaAssetTreeNode oaAssetTreeNode : SysConst.OAASSET_TREE.getBDSParentTreeNodes()){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", oaAssetTreeNode.getId());
			jsonObject.put("name", oaAssetTreeNode.getText());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	/**
	 * 根据parentId 返回基础数据，以key，val方式返回 
	 * @param pId
	 * @return  
	 */
	@RequestMapping(value = "/getOaAssetName.do")
	public @ResponseBody JSONArray getOaAssetNamebyPId(String parentId,HttpServletRequest req){ 
		if(StringUtils.isEmpty(parentId))
			return null;		
		List<OaAssetTreeNode> listBDS =   SysConst.OAASSET_TREE.getLeafNodes(
				SysConst.OAASSET_TREE.getNode(Integer.parseInt(parentId)));		
		//按名称进行排序
		Collections.sort(listBDS, new Comparator<OaAsset>() {
			public int compare(OaAsset arg0, OaAsset arg1) {
				return arg0.getAssetId().compareTo(arg1.getAssetId());
			}
		});
		
		JSONArray array = new JSONArray();
		for (OaAsset bds : listBDS) {
			JSONObject json =new JSONObject();
			json.put("id", bds.getAssetId());
			json.put("name", bds.getName());
			array.add(json);
		}
		return array;
	}
	
	
	
	/**
	 * 根据parentId 返回基础数据，以key，val方式返回 
	 * @param pId
	 * @return  
	 */
	@RequestMapping(value = "/getOaAsset.do")
	public @ResponseBody JSONArray getOaAssetbyPId(String parentId){ 
		
		if(StringUtils.isEmpty(parentId))
			return null;		
		List<OaAssetTreeNode> listBDS =   SysConst.OAASSET_TREE.getLeafNodes(SysConst.OAASSET_TREE.getNode(Integer.parseInt(parentId)));				
		//按名称进行排序
		Collections.sort(listBDS, new Comparator<OaAsset>() {
			public int compare(OaAsset arg0, OaAsset arg1) {
				return arg0.getName().compareTo(arg1.getName());
			}
		});
		
		JSONArray array = new JSONArray();
		for (OaAsset bds : listBDS) {
			JSONObject json =new JSONObject();
			json.put("id", bds.getAssetId());
			json.put("name", bds.getName());
			array.add(json);
		}
		return array;
	}
	
	@RequestMapping(value = "/getOaAssetbyParentId.do")
	public @ResponseBody List<OaAssetTreeNode>  getOaAssetbyParentId(String parentId){ 
		
		if(StringUtils.isEmpty(parentId))
			return null;
		return SysConst.OAASSET_TREE.getNode(Integer.parseInt(parentId)).getChildren();
	}
	
	@RequestMapping(value = "/listOAATree.do")
	public @ResponseBody List<OaAssetTreeNode> listOAATree(){ 

		return SysConst.OAASSET_TREE.getBDSTreeNodes();
	}
	
	@RequestMapping(value = "/listParentOAATree.do")
	public @ResponseBody List<OaAssetTreeNode> listParentOAATree(){ 
		
		return SysConst.OAASSET_TREE.getBDSParentTreeNodes();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insert.do")
	public @ResponseBody HttpJson insert(
			HttpServletRequest request){ 
		JSONObject joBDS = JSONObject.fromObject(request.getParameter("asset"));

		HttpJson j = new HttpJson();
		if(oaAssetService.insert((OaAsset)JSONObject.toBean(joBDS, OaAsset.class))){
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
		
		JSONObject joBDS = JSONObject.fromObject(request.getParameter("asset"));
			
		HttpJson j = new HttpJson();
		
		
		if(oaAssetService.update((OaAsset)JSONObject.toBean(joBDS, OaAsset.class))){
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
		
		
		if(oaAssetService.delete(Integer.parseInt(id))){
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
