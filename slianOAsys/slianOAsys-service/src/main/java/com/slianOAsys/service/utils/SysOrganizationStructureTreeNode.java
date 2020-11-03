package com.slianOAsys.service.utils;

import java.util.ArrayList;

import java.util.List;

import com.slianOAsys.model.SysOrganizationStructure;

public class SysOrganizationStructureTreeNode extends SysOrganizationStructure {
	
	private Integer id;
	
	private boolean checked;
	
	private String text;
	
	private List<SysOrganizationStructureTreeNode> children;

	public List<SysOrganizationStructureTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<SysOrganizationStructureTreeNode> children) {
		this.children = children;
	}
	
	public void addChild(SysOrganizationStructureTreeNode node){
		if(this.children == null)
			children = new ArrayList<SysOrganizationStructureTreeNode>();
		
		children.add(node);
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	/*public int getLevel(OrganizationStructureTreeNode node){
		
		return 0;
	}
	
	
	//计算节点的level
	private int levelSize(int level ,OrganizationStructureTreeNode node){
		if(node == null)
			return 0;

		if(node.getChildren() !=null & node.getChildren().size() >0)
			return level + levelSize(level,node);
		else
			return level;
		
	}
*/
}
