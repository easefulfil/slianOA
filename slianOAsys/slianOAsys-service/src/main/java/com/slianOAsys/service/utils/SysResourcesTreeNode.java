package com.slianOAsys.service.utils;


import java.util.ArrayList;

import java.util.List;

import com.slianOAsys.model.SysResources;

public class SysResourcesTreeNode extends SysResources {
	
	private int id;
	
	private boolean checked;
	private String name;
	private int level;
	
	private List<SysResourcesTreeNode> children;

	public List<SysResourcesTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<SysResourcesTreeNode> children) {
		this.children = children;
	}
	
	public void addChild(SysResourcesTreeNode node){
		if(this.children == null)
			children = new ArrayList<SysResourcesTreeNode>();
		
		children.add(node);
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/*public int getLevel(ResourcesTreeNode node){
		
		return 0;
	}
	
	
	//计算节点的level
	private int levelSize(int level ,ResourcesTreeNode node){
		if(node == null)
			return 0;

		if(node.getChildren() !=null & node.getChildren().size() >0)
			return level + levelSize(level,node);
		else
			return level;
		
	}
*/
}
