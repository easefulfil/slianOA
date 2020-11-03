package com.slianOAsys.service.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.slianOAsys.model.SysRolesResources;

public class RoleResourceOrganization {
	
	private HashMap<Integer,HashMap<Integer,List<Integer>>> mapRoleResourceOrganization;
	
	public RoleResourceOrganization(){
		mapRoleResourceOrganization=new HashMap<Integer,HashMap<Integer,List<Integer>>>();
	}

	//更新全部
	public void updateRRO(List <SysRolesResources> listRolesResources){
		mapRoleResourceOrganization.clear();
		for(SysRolesResources rolesResources:listRolesResources){
			addRROUnit(rolesResources);
		}
		show();
	}
	
	//增加一个单元
	public synchronized boolean addRROUnit(SysRolesResources rolesResources){
		boolean re=false;
		if(mapRoleResourceOrganization.containsKey(rolesResources.getResourcesId())){
			//已有此资源
			HashMap<Integer,List<Integer>> RO=mapRoleResourceOrganization.get(rolesResources.getResourcesId());
			if(RO.containsKey(rolesResources.getRoleId())){
				//已有此角色
				List<Integer> listO=RO.get(rolesResources.getRoleId());
				if(listO==null){
					//用户级资源
					//无需增加
				}else{
					//数据级资源
					if(listO.contains(rolesResources.getOrganizationId())){
						//已有此部门
						//无需增加
					}else{
						//尚无此部门
						listO.add(rolesResources.getOrganizationId());
						re=true;
					}
				}
			}else{
				//尚无此角色				
				if(rolesResources.getOrganizationId()==null){
					//用户级资源
					RO.put(rolesResources.getRoleId(),null);
				}else{
					//数据级资源
					ArrayList <Integer> lo=new ArrayList <Integer> ();
					lo.add(rolesResources.getOrganizationId());
					RO.put(rolesResources.getRoleId(),lo);
				}
				re=true;
			}
		}else{
			//尚无此资源
			HashMap<Integer,List<Integer>> newRO=new HashMap<Integer,List<Integer>>();
			if(rolesResources.getOrganizationId()==null){
				//用户级资源
				newRO.put(rolesResources.getRoleId(), null);
			}else{
				//数据级资源
				ArrayList <Integer> newLO=new ArrayList <Integer> ();
				newLO.add(rolesResources.getOrganizationId());
				newRO.put(rolesResources.getRoleId(), newLO);
			}				
			mapRoleResourceOrganization.put(rolesResources.getResourcesId(), newRO);
			re=true;
		};
		return re;
	}
	
	//删除一个单元
	public synchronized boolean removeRROUnit(SysRolesResources rolesResources){
		boolean re=false;
		if(mapRoleResourceOrganization.containsKey(rolesResources.getResourcesId())){
			//已有此资源
			HashMap<Integer,List<Integer>> RO=mapRoleResourceOrganization.get(rolesResources.getResourcesId());
			if(RO.containsKey(rolesResources.getRoleId())){
				//已有此角色
				List<Integer> listO=RO.get(rolesResources.getRoleId());
				if(listO==null){
					//用户级资源
					RO.remove(rolesResources.getRoleId());
					if(RO.isEmpty()){
						mapRoleResourceOrganization.remove(rolesResources.getResourcesId());//删除资源
					}
				}else{
					//数据级资源
					if(listO.contains(rolesResources.getOrganizationId())){
						//已有此部门
						//-----------------删除权限单元---------------------
						if(listO.remove(rolesResources.getOrganizationId())){//删除部门
							re=true;
							if(listO.isEmpty()){
								if(RO.remove(rolesResources.getRoleId())!=null){//删除角色
									if(RO.isEmpty()){
										mapRoleResourceOrganization.remove(rolesResources.getResourcesId());//删除资源
									}
								}
							}
						}
						//----------------------------------------------
					}else{
						//尚无此部门
					}
				}
			}else{
				//尚无此角色
			}
		}else{
			//尚无此资源
		};
		show();
		return re;
	}
	
	//获取当前资源的角色需求
	public synchronized Set<Integer> getRoles(Integer resourceId){
		HashMap <Integer, List<Integer>> RO=mapRoleResourceOrganization.get(resourceId);
		return RO==null?null:RO.keySet();
	}
	

		
	//获取当前资源、角色的操作部门
	public  List <Integer> getOrganizations(Integer resourceId,Integer RoleId){
		HashMap <Integer, List<Integer>> RO=mapRoleResourceOrganization.get(resourceId);
		return RO==null?null:RO.get(RoleId);
	}
	//展示
	public synchronized void show(){
		for(Integer res:mapRoleResourceOrganization.keySet()){
			System.out.println("resource:"+res);
			for(Integer role: mapRoleResourceOrganization.get(res).keySet()){
				System.out.println("\t\trole:"+role);
				if(mapRoleResourceOrganization.get(res).get(role)==null){
					//用户级
					System.out.println("\t\t\t\t-----");
				}else{
					//数据级
					for(Integer org:mapRoleResourceOrganization.get(res).get(role)){
						System.out.println("\t\t\t\torg:"+org);
					}
				}
			}
		}
	}
	
	//获取当前资源集、角色集允许的部门集
	public  Set<Integer> getOrgSetUnderResourceRoles(List<Integer> resourceIdList,List <Integer> roleList){
		
		if(roleList.contains(new Integer(-999888))){
			return null;
		}
		boolean dataUnderControl=false;
		//获取父节点集合
		Set<Integer>resParentsSet=new HashSet<Integer>();
		for(Integer resid:resourceIdList){
			resParentsSet.addAll(SysConst.RESOURCESTREE.getAncestors(resid));
		}
		
		for(Integer id:resParentsSet){
			
			if(SysConst.RESOURCESTREE_UNINCLUDE_BUSINESS.getNode(id).getType().equals("数据")){
				dataUnderControl=true;
				break;
			}
		}
		if(dataUnderControl){
			Set<Integer> orgSet=new HashSet<Integer>();
			Set<Integer> keySet=mapRoleResourceOrganization.keySet();
			for(Integer resourceId:resParentsSet) {
				if(keySet.contains(resourceId)){
					Map<Integer, List<Integer>>  ROMap=mapRoleResourceOrganization.get(resourceId);
					Set<Integer> keySet2=ROMap.keySet();
					for(Integer roleId:roleList){
						if(keySet2.contains(roleId)){
							List <Integer> orgL=ROMap.get(roleId);
							if(orgL!=null)
								orgSet.addAll(orgL);
						}
					}
				}
			}
			return orgSet;
		}else
			return null;
	}
	
}
