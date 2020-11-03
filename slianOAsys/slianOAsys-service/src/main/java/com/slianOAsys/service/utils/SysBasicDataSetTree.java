package com.slianOAsys.service.utils;


import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.slianOAsys.model.SysBasicDataSet;

/**
 * 资源树，将资源以树的方式存储
 * 
 * @author Apple
 * 
 */
public class SysBasicDataSetTree {

	private List<SysBasicDataSet> listBasicDataSet;

	private Map<Integer, SysBasicDataSetTreeNode> tree = new HashMap<Integer, SysBasicDataSetTreeNode>();

	public SysBasicDataSetTree(List<SysBasicDataSet> listBasicDataSet) {
		this.listBasicDataSet = listBasicDataSet;
		buildBasicDataSetTree();
	}

	// 构造树
	private void buildBasicDataSetTree() {

		for (SysBasicDataSet bds : listBasicDataSet) {

			SysBasicDataSetTreeNode treeNode = new SysBasicDataSetTreeNode();

//			ReflectionUtils.parentToChild(bds, treeNode);

			BeanUtils.copyProperties(bds, treeNode);
			treeNode.setId(bds.getBasicDataId());
			treeNode.setText(bds.getEnglishName() + "||" + bds.getChineseName());
			
			
			if (tree.containsKey(bds.getParentNodeId())) {
				
				SysBasicDataSetTreeNode parentNode = (SysBasicDataSetTreeNode) tree
						.get(bds.getParentNodeId());

				parentNode.addChild(treeNode);

			}

			tree.put(bds.getBasicDataId(), treeNode);

		}
	}

	// 根据key,获得指定的节点
	public SysBasicDataSetTreeNode getNode(Integer key) {

		return tree.get(key);
	}

	// 获得节点的Ancestors node
	public List<SysBasicDataSetTreeNode> getAncestorsNodes(
			SysBasicDataSetTreeNode node) {
		List<SysBasicDataSetTreeNode> anceNodes = new ArrayList<SysBasicDataSetTreeNode>();

		this.setAnceNodes(node, anceNodes);
		return anceNodes;
	}

	// 返回指定节点所有父节点的Name
	// public String getParentsNodeName(SysBasicDataSetTreeNode node){
	//
	// if(node.getParentNodeId() == null || "0".equals(node.getParentNodeId())
	// ||"".equals(node.getParentNodeId()))
	// return "";
	//
	// List<SysBasicDataSetTreeNode> anceNodes = new
	// ArrayList<SysBasicDataSetTreeNode>();
	//
	// this.setAnceNodes(node, anceNodes);
	//
	// String parentsName = "";
	//
	// for(SysBasicDataSetTreeNode bds:anceNodes){
	//
	// parentsName += bds.getChineseName() + "##";
	//
	//
	// }
	//
	// String [] parentsArrayName = parentsName.split("##");
	//
	// String newParentsName = "";
	//
	//
	// for( int i = parentsArrayName.length ;i > 0; i--){
	//
	// newParentsName += parentsArrayName[i-1] + " || ";
	// }
	//
	//
	// return newParentsName;
	// }
	// 递归依次获取所有祖先节点
	private void setAnceNodes(SysBasicDataSetTreeNode node,
			List<SysBasicDataSetTreeNode> anceNodes) {

		if (tree.containsKey(node.getParentNodeId())) {
			SysBasicDataSetTreeNode parentNode = tree.get(node.getParentNodeId());
			anceNodes.add(parentNode);

			this.setAnceNodes(parentNode, anceNodes);

		}
	}

	// 获得节点的parent node
	public SysBasicDataSetTreeNode getParentNode(SysBasicDataSetTreeNode node) {

		return tree.get(node.getParentNodeId());
	}

	// 判断是否根节点
	public boolean isRootNode(SysBasicDataSetTreeNode node) {

		return (node.getParentNodeId() == null || "0".equals(node
				.getParentNodeId())) ? true : false;

	}

	// 返回指定节点的所有叶子节点
	public List<SysBasicDataSetTreeNode> getLeafNodes(SysBasicDataSetTreeNode node) {

		List<SysBasicDataSetTreeNode> leafNodes = new ArrayList<SysBasicDataSetTreeNode>();
		this.setLeafNodes(node, leafNodes);

		return leafNodes;
	}

	// 递归依次获取所有叶子节点
	private void setLeafNodes(SysBasicDataSetTreeNode node,
			List<SysBasicDataSetTreeNode> leafNodes) {

		List<SysBasicDataSetTreeNode> children = node.getChildren();

		if (children == null || children.size() < 1)
			leafNodes.add(node);

		else {
			for (SysBasicDataSetTreeNode child : children)

				this.setLeafNodes(child, leafNodes);

		}

	}

	public List<SysBasicDataSet> getListBasicDataSet() {
		return listBasicDataSet;
	}

	// public Set<Integer> getAllChildren(Set<Integer> orgIdSet){
	// if(orgIdSet==null)
	// return null;
	// if(orgIdSet.size()==0)
	// return new HashSet<Integer>();
	// else{
	// HashSet<Integer> reSet=new HashSet<Integer>();
	// for(Integer orgId:orgIdSet){
	// if(orgId!=-1){
	// HashSet<Integer> sonSet=new HashSet<Integer>();
	// List<SysBasicDataSetTreeNode>OSTNL=this.getNode(orgId).getChildren();
	// if(OSTNL!=null){
	// for(SysBasicDataSetTreeNode n:OSTNL){
	// sonSet.add(n.getId());
	// this.getAllChildren(sonSet);
	// }
	// reSet.addAll(sonSet);
	// }
	// }
	// }
	// reSet.addAll(orgIdSet);
	// return reSet;
	// }
	// }

	public List<SysBasicDataSetTreeNode> getBDSTreeNodes() {

		List<SysBasicDataSetTreeNode> listBDSTN = new ArrayList<SysBasicDataSetTreeNode>();
		
		for (SysBasicDataSet bds : listBasicDataSet) {
			
			SysBasicDataSetTreeNode treeNode  = new SysBasicDataSetTreeNode();

//			ReflectionUtils.parentToChild(bds, treeNode);
				

			BeanUtils.copyProperties(bds, treeNode);
			//存在子节点的父节点
			if(tree.get(bds.getBasicDataId()).getChildren() != null && tree.get(bds.getBasicDataId()).getChildren().size() > 0){

				treeNode.setState("closed");
			}
			
			treeNode.setId(bds.getBasicDataId());
			treeNode.setText(bds.getChineseName() + "||" + bds.getEnglishName());

			
			listBDSTN.add(treeNode);

		}

		return listBDSTN;
	}

	
	/**
	 * 返回所有的父节点资源
	 * @return
	 */
	public List<SysBasicDataSetTreeNode> getBDSParentTreeNodes() {

		List<SysBasicDataSetTreeNode> listBDSTN = new ArrayList<SysBasicDataSetTreeNode>();
		
//		Iterator<Integer> bdsIt = tree.keySet().iterator();
		for (SysBasicDataSet bds : listBasicDataSet) {
//		while(bdsIt.hasNext()){
			
//			Integer bdsId = (Integer)bdsIt.next();
			
//			SysBasicDataSetTreeNode treeNode = tree.get(bdsId);


			SysBasicDataSetTreeNode treeNode  = new SysBasicDataSetTreeNode();
//			ReflectionUtils.parentToChild(bds, treeNode);
			

			BeanUtils.copyProperties(bds, treeNode);
			treeNode.setId(bds.getBasicDataId());
			
			//父节点
			SysBasicDataSetTreeNode parentTreeNode = new SysBasicDataSetTreeNode();

			if(treeNode.getParentNodeId() == null ){
				parentTreeNode.setId(treeNode.getBasicDataId());
				parentTreeNode.setParentNodeId(treeNode.getParentNodeId());
				parentTreeNode.setText(treeNode.getChineseName() + "||" + treeNode.getEnglishName());
				
				listBDSTN.add(parentTreeNode);
			}
				
			
		}



		return listBDSTN;
	}
	

	public void setListBasicDataSet(List<SysBasicDataSet> listBasicDataSet) {
		this.listBasicDataSet = listBasicDataSet;
	}

	public Map<Integer, SysBasicDataSetTreeNode> getTree() {
		return tree;
	}

	// public LinkedList<Integer> getDivision(Integer dId){
	// LinkedList<Integer> ll=new LinkedList<Integer>();
	// Integer cId=dId;
	// do{
	// ll.addLast(cId);
	// cId=Integer.parseInt(this.getNode(cId).getSuperior());
	// }while(!cId.equals(new Integer(0)));
	// return ll;
	// }

}
