package com.slianOAsys.service.utils;



import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.BeanUtils;

import com.slianOAsys.model.SysResources;

/**
 * 资源树，将资源以树的方式存储
 * @author Apple
 *
 */
public class SysResourcesTree {

	private List<SysResources> listResources;

	private Map<Integer, SysResourcesTreeNode> tree = new HashMap<Integer, SysResourcesTreeNode>();


	
	public  SysResourcesTree(List<SysResources> listResources) {
		this.listResources = listResources;
		buildResourcesTree();
	}

	// 构造树
	private synchronized void buildResourcesTree() {

		for (SysResources res : listResources) {

			SysResourcesTreeNode treeNode = new SysResourcesTreeNode();
			
//			ReflectionUtils.parentToChild(res, treeNode);
			BeanUtils.copyProperties(res, treeNode);
			if (tree.containsKey(res.getParentId())) {
				SysResourcesTreeNode parentNode = (SysResourcesTreeNode) tree.get(res
						.getParentId());

				parentNode.addChild(treeNode);

			}

			tree.put(res.getResourceId(), treeNode);

		}
	}

	// 根据key,获得指定的节点
	public synchronized SysResourcesTreeNode getNode(Integer key) {

		return tree.get(key);
	}

	// 获得节点的Ancestors node
	public synchronized List<SysResourcesTreeNode> getAncestorsNodes(SysResourcesTreeNode node) {
		List<SysResourcesTreeNode> anceNodes = new ArrayList<SysResourcesTreeNode>();

		this.setAnceNodes(node, anceNodes);
		return anceNodes;
	}

	// 递归依次获取所有祖先节点
	private synchronized void setAnceNodes(SysResourcesTreeNode node,
			List<SysResourcesTreeNode> anceNodes) {
	
		if (tree.containsKey(node.getParentId())) {
			SysResourcesTreeNode parentNode = tree.get(node.getParentId());
			
			
			//是否启用的标识
			if("1".equals(parentNode.getStatus())){
				anceNodes.add(parentNode);

				this.setAnceNodes(parentNode, anceNodes);
			}
			

		}
	}

	// 获得节点的parent node
	public synchronized SysResourcesTreeNode getParentNode(SysResourcesTreeNode node) {

		return tree.get(node.getParentId());
	}
	
	// 获得节点的children node
	public synchronized List<SysResourcesTreeNode> getChildrenNode(SysResourcesTreeNode node) {

			return null;
	}

	// 判断是否根节点
	public synchronized boolean isRootNode(SysResourcesTreeNode node) {

		return (node.getParentId() == null || node.getParentId() == 0) ? true
				: false;

	}

	// 返回指定节点的所有叶子节点
	public synchronized List<SysResourcesTreeNode> getLeafNodes(SysResourcesTreeNode node) {

		List<SysResourcesTreeNode> leafNodes = new ArrayList<SysResourcesTreeNode>();
		this.setLeafNodes(node, leafNodes);

		return leafNodes;
	}

	// 递归依次获取所有叶子节点
	private void setLeafNodes(SysResourcesTreeNode node,
			List<SysResourcesTreeNode> leafNodes) {
		
		List<SysResourcesTreeNode> children = node.getChildren();

		if (children == null || children.size() < 1)
			leafNodes.add(node);

		else{
			for(SysResourcesTreeNode child:children)

				this.setLeafNodes(child, leafNodes);

		}
			
	}

	public  List<SysResources> getListResources() {
		return listResources;
	}

	public synchronized void setListResources(List<SysResources> listResources) {
		this.listResources = listResources;
	}

	public  Map<Integer, SysResourcesTreeNode> getTree() {
		return tree;
	}
	
	//根据访问的资源URL返回资源ID
	public  List<Integer> resourceMatching(String url){
		ArrayList<Integer> resourceIdList=new ArrayList<Integer>();
		for (SysResources resource :listResources ){
			if(resource.getUrl() != null && resource.getUrl().contains(url)){
//			if(url.equals(resource.getUrl())){
				resourceIdList.add(resource.getResourceId());
			}
		}
		return resourceIdList;
	}
	
	public  String typeOfResource(Integer resourceId){
		String re=null;
		for (SysResources res:this.listResources){
			if(res.getResourceId().equals(resourceId)){
				re=res.getType();
				break;
			}
		}
		return re;
	}

	public  Collection<Integer> getAncestors(Integer Id) {
		// TODO Auto-generated method stub
		HashSet <Integer> ancestors=new HashSet <Integer>();
		Integer currentId=Id;
		while(!this.getNode(currentId).getParentId().equals(new Integer(0))){
			currentId=this.getNode(currentId).getParentId();
			ancestors.add(currentId);
		}
		return ancestors;
	}
	
	/**
	 * 根据角色所赋予的资源，构造index.html 左边菜单的json 对象
	 * 菜单样式
 {
		"menus": [{
			"menuid": "1",
			"icon": "icon-groupkey",
			"menuname": "商务报价",
			"menus": [{
				    "menuid": "11",
					"menuname": "海运报价管理",
					"icon": "icon-sum",
					"url": "demo/quotation.html"
			},{
				"menuid": "12",
				"menuname": "人民币费用管理",
				"icon": "icon-bm",
				"url": "demo/rmbfee.html",
			},{
				"menuid": "12",
				"menuname": "内托运价表",
				"icon": "icon-bm",
				"url": "demo/netofee.html",
			}]
		},{
			"menuid": "1",
			"icon": "icon-groupkey",
			"menuname": "查看报价",
			"menus": [{
				    "menuid": "11",
					"menuname": "海运报价",
					"icon": "icon-sum",
					"url": "demo/quotation.html"
			},{
				"menuid": "12",
				"menuname": "人民币费用",
				"icon": "icon-bm",
				"url": "demo/rmbfee.html",
			},{
				"menuid": "12",
				"menuname": "内托运价表",
				"icon": "icon-bm",
				"url": "demo/netofee.html",
			}]
			}
}

	 */
	public synchronized JSONObject bulidMenuResourceTree(List<Integer> resourceIds){
		
		List<SysResourcesTreeNode> anceNodes = new ArrayList<SysResourcesTreeNode>();
		
		for(Integer rId: resourceIds){
			
			this.setAnceNodes(this.getNode(rId), anceNodes);
		}
		
		this.removeDuplicateWithOrder(anceNodes);
		
		JSONObject menuJSONObject = new JSONObject();
		JSONArray menus = new JSONArray();

		List<SysResourcesTreeNode> childrenNodes = null;
		//构造menu json
		for(SysResourcesTreeNode resourceNode:anceNodes){
			
			
			if(resourceNode.getPriority() == null || resourceNode.getPriority() < 100)
				continue;
			
			
			//priority 在（101-199),表示一级菜单
			else if(resourceNode.getPriority() < 200){
//				System.out.println("parentID:" + resourceNode.getId());
				
			
				//从当前父节点集合中，获取一级菜单的二级孩子节点
				childrenNodes = this.getChildren(anceNodes,resourceNode);
				
//				for(SysResourcesTreeNode childNode :childrenNodes)
//					System.out.println("childRen:" + childNode.getId());
				
				menus.add(this.buildFirstLevelMenuNode(resourceNode, childrenNodes));
			}
			
			
		}
		
		menuJSONObject.put("menus", menus);
		
		return menuJSONObject;
	}
	
	
	/**
	 * 从当前节点集合中获取指定节点的二级（priority 在10101-19999之间）孩子节点
	 * @param anceNodes
	 * @param currentNode
	 * @return
	 */
	private List<SysResourcesTreeNode> getChildren(List<SysResourcesTreeNode> anceNodes,SysResourcesTreeNode firstLevelNode){
		
		List<SysResourcesTreeNode> childrenNodes = new ArrayList<SysResourcesTreeNode>();
		
		for(SysResourcesTreeNode resourceNode:anceNodes){
//			System.out.println("aaa:"+resourceNode.getId());
			if(firstLevelNode.getResourceId().equals(resourceNode.getParentId() ))
				
				childrenNodes.add(resourceNode);
			
		}
		return childrenNodes;
	}
	
	/**
	 * 移除相同的父节点
	 */
	private  void removeDuplicateWithOrder(List list) {
		   Set set = new HashSet();
		   List newList = new ArrayList();
		   for (Iterator iter = list.iterator(); iter.hasNext();) {
		          Object element = iter.next();
		          if (set.add(element))
		             newList.add(element);
		       }
		      list.clear();
		      list.addAll(newList);
//		     System.out.println( " remove duplicate " + list);
		}
	
	/**
	 * 
	 * 节点的样式
	{
			"menuid": "1",
			"icon": "icon-groupkey",
			"menuname": "商务报价",
			"menus": [{
				    "menuid": "11",
					"menuname": "海运报价管理",
					"icon": "icon-sum",
					"url": "demo/quotation.html"
			},{
				"menuid": "12",
				"menuname": "人民币费用管理",
				"icon": "icon-bm",
				"url": "demo/rmbfee.html",
			},{
				"menuid": "12",
				"menuname": "内托运价表",
				"icon": "icon-bm",
				"url": "demo/netofee.html",
			}]
		}
	*/

	private JSONObject buildFirstLevelMenuNode(SysResourcesTreeNode firstLevelNode,List<SysResourcesTreeNode> childrenNodes){
		
		JSONObject firstLevelmenuNode = new JSONObject();
		JSONArray secondLevelMenus = new JSONArray();
		
		for(SysResourcesTreeNode secondLevelNode:childrenNodes){
			
			if(secondLevelNode.getPriority() == null || secondLevelNode.getPriority() < 10000)
				continue;
			//priority 在（10101-19999),表示二级菜单
			else if(secondLevelNode.getParentId() <20000){
				
				secondLevelMenus.add(this.buildSecondLevelMenuNode(secondLevelNode));
			}
			
		}
		
		firstLevelmenuNode.put("menuid", firstLevelNode.getResourceId());
		firstLevelmenuNode.put("menuname", firstLevelNode.getText());
		firstLevelmenuNode.put("icon",firstLevelNode.getIcon());
		firstLevelmenuNode.put("menus", secondLevelMenus);
		
		return firstLevelmenuNode;
	}
	
	
	/**
	 * 
	 * 节点的样式
	 {
	    "menuid": "11",
		"menuname": "海运报价管理",
		"icon": "icon-sum",
		"url": "demo/quotation.html"
	}
	*/

	private JSONObject buildSecondLevelMenuNode(SysResourcesTreeNode resourcesTreeNode){
		
		JSONObject menuNode = new JSONObject();
		
		menuNode.put("menuid", resourcesTreeNode.getResourceId());
		menuNode.put("menuname", resourcesTreeNode.getText());
		menuNode.put("icon",resourcesTreeNode.getIcon());
		menuNode.put("url", resourcesTreeNode.getUrl());
		
		return menuNode;
	}
}
