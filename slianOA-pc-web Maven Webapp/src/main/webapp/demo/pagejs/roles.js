

var IS_INIT_TREE = true;// 用于判断是否为初次加载tree

//用于计算创建组织架构tree的数量，初始化前做++，初始化完成做--,
var CREATED_ORGSTR_NUM = 0;
/**
 * 角色管理
 */

//window.onload = function(){
//	$('#loading-mask').fadeOut();
//}


function checkResourceNode(roleId,node){
	
	if(node.checked){

//		alert('delete role resources');
		if(saveResourcesNode(roleId,node.id,"deleteResources") == false){
			alert("保存失败！");
			return;
		}
		
		return;
	}
	
	if(node.text=='数据')
		refreshOrgstrTree(node.id);
	else//刷新所有数据资源的组织架构
		refreshChildrenOrgstrTrees(node.target);

	if(saveResourcesNode(roleId,node.id,"insertResources") == false){
		alert("保存失败！");
		return;
	}
}


function saveResourcesNode(roleId,resourcesId,operType){
	
	$.ajax({
		type:"post",
		url:getContextPath()+"/rolesresources/"+operType+".do",// getContextPath()+'/resources/getTreegrid.do'+'?id=10',//
		async:false,
		data:{
			roleId:roleId,
			resourcesId:resourcesId
		},
		dataType:'json',
		success:function(result){
			//initOrgaInfo(roleId,node.id,treeData);
			
			return result.success;
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
	          //通常情况下textStatus和errorThrown只有其中一个包含信息
	          this;   //调用本次ajax请求时传递的options参数
	          alert(textStatus + errorThrown);
	          return false;
		}
	});
}

function checkRoleResourceNode(roleId,resourceId,node){
	
	if(node.checked){
		
		if(saveOrgStrNode(roleId,resourceId,node.id,"deleteOS") == false){
			alert("保存失败！");
			return;
		}
		
		
//		alert('delete role resources' +resourceId);
		return;
	}
	
	if(saveOrgStrNode(roleId,resourceId,node.id,"insertOS") == false){
		alert("保存失败！");
		return;
	}
	
//	alert('insert role resource' +resourceId);
	
}

function saveOrgStrNode(roleId,resourcesId,orgStrId,operType){
	
	$.ajax({
		type:"post",
		url:getContextPath()+"/rolesresources/"+operType+".do",// getContextPath()+'/resources/getTreegrid.do'+'?id=10',//
		async:false,
		data:{
			roleId:roleId,
			resourcesId:resourcesId,
			orgStrId:orgStrId
		},
		dataType:'json',
		success:function(result){
			//initOrgaInfo(roleId,node.id,treeData);
			
			return result.success;
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
	          //通常情况下textStatus和errorThrown只有其中一个包含信息
	          this;   //调用本次ajax请求时传递的options参数
	          alert(textStatus + errorThrown);
	          return false;
		}
	});
}

function isSelectedOneRow(rows){
	
	
	
	if (rows.length == 1) {
		if (editRow != undefined) {
			datagrid.datagrid('endEdit', editRow);
		}
		
		return true;
		
	}
	else if(rows.length>1){                                
		$.messager.alert('提示','一次只能为一个用户进行操作，请重新选择','error');
		datagrid.datagrid('unselectAll');       
		return false;
	}else{                                                
		$.messager.alert('提示','请选择要修改的记录','error');       
		return false;
	}
}
//function initInfo(roleId,treeData){// “角色授权”弹出框初始化
//	$('#rsid').tree({
function showDiv_Resources(roleId){
		 var $parent = self.parent.$; //在父窗体弹出
		$parent('#popDiv').empty(); 
		$parent('#popDiv').html('<div id="popContent" name="popContent"></div>');
		//$parent('#popdiv').window('refresh', 'users_roles.html?userId=' + userId);
		$parent('#popDiv').window({
		modal:true,
		collapsible:false,
		width:520, 
		height:550,
		//href:'demo/users_roles.html?userId='+ userId, 
		title:'分配资源', 
		onBeforeOpen:function(){
			
			showTree_Resources($parent,roleId);
		
			},

		onClose:function(){
			 $parent('#popContent').empty();
			}
			
		});
		
	}

function showTree_Resources($parent,roleId){
//		data:treeData,
//	$parent('#popContent').empty();
	 $parent('#popContent').tree({
		url:getContextPath()+'/rolesresources/getRolesResources.do'+'?roleId='+roleId,//"resources.json"
		lines:true,
		checkbox:true,
		parentField:'parentid',
		checked:true,
		formatter:function(node){
				return node.name;
			},
		textField:'type',// 因为没有字段显示“type”，所以把“type”放入text中，而树中显示的内容（text）用formatter来设置
		
		onBeforeLoad:function(node, param){ 
			IS_INIT_TREE=true; 
			

//			$("#authorize").css("display","none");
		},
		onLoadSuccess:function(){
				
				//为数据级的节点添加组织架构
				$parent(".tree-node").each(function(i) {
				
//					//这里的this是dom对象,$(this)为jquery对象
					var tn =  $parent('#popContent').tree('getNode', this);
					
					if(tn.type == '数据'){
					
						createOrgstrTree(roleId,tn.id,this);
					}

				})
			
				//初始化树形菜单完成
				IS_INIT_TREE = false;

//				$("#authorize").css("display","block");
				
			//折叠
			$parent('#popContent').tree("collapseAll");  

		},
		onCheck:function(node){
	
			if(IS_INIT_TREE )
				return;
			
			checkResourceNode(roleId,node);
			
		}
		
		
	});
//	IS_INIT_TREE = false;
}

//刷新树
function refreshOrgstrTree(resourceId){
	

	$("#orgstrTree"+resourceId).tree("reload");
	
	
}

//刷新树非数据节点下的所有子数据节点的组织架构
function refreshChildrenOrgstrTrees(targetDiv){
	
	$.each($(targetDiv).parent().find('ul[id^=orgstrTree]'),function(index){
		
		//刷新树
		$(this).tree("reload");
		
		
	});
	
	
}

function createOrgstrTree(roleId,resourceId,target){// “组织架构”弹出框初始化

	var parentDiv=$("<div style='display:block;margin-left:80px'></div>"); 
	
	
	
	var orgstr_ul = $("<ul id='orgstrTree"+resourceId+"'></ul>");
	
	$(parentDiv).append(orgstr_ul);
	
	$(target).after(parentDiv);

	$(orgstr_ul).tree({
		url:getContextPath()+"/rolesresources/getRolesResourcesOS.do?roleId="+roleId+"&resourceId="+resourceId,
		lines:true,
		checkbox:true,
		// parentField:'parentid',
		parentField:'superior',
//		checked:true,
		cascadeCheck:true,
		formatter:function(node){return node.name},
		onBeforeLoad:function(node, param){ 
		    CREATED_ORGSTR_NUM ++;
//		    console.log("before CREATED_ORGSTR_NUM :" +CREATED_ORGSTR_NUM);
		}, 
		onLoadSuccess:function(node, data){ 
			
			CREATED_ORGSTR_NUM --;
//			console.log("success CREATED_ORGSTR_NUM :" +CREATED_ORGSTR_NUM);
		}, 
		onCheck:function(node){
			
		
			//IS_INIT_TREE 当CREATED_ORGSTR_NUM == 0时，表明组织架构节点构造完成
			if( CREATED_ORGSTR_NUM != 0)
				return;
			console.log("user check CREATED_ORGSTR_NUM :" +CREATED_ORGSTR_NUM);
			checkRoleResourceNode(roleId,resourceId,node);
			
		}
	});
	
//'+tn.id  $('#orgstrId')
	 
}


	var datagrid;
	var editRow = undefined;// 行编辑标志
	var useSelect=[
		  	         {useType:'启用',name:'启用'},
		  	         {useType:'未启用',name:'未启用'}
		  	         ];
	$(function() {
		
		
		datagrid = $('#datagrid').datagrid({
			title : '',
			iconCls : 'icon-save',
			pagination : true,// 进度条
			pageSize : 10,// 每页显示10条
			pageList : [ 10, 20, 30, 40, 50 ],// 选择每页显示条数
			fit : true,
			fitColumns : false,// 设置false页面变窄时显示横向滚动条
			nowarp : false,// 表格内容自动折行
			border : false,
			idField : 'id',// 翻页选择标记（便于多页删除）
			remoteSort: false,// 定义是否从服务器给数据排序。
			striped:true,// 为true是交替显示行背景
			url : getContextPath()+'/roles/getRoles.do',
			columns : [ [{
				title : '选择框',
				field : 'box',
				width : 90,
				// sortable:true,
				checkbox:true,
				
			}, {
				field:"id",title:'角色编号',width:80,hidden:true,
				editor:{
					type:'text',
					options:{
						required:false
					}
				}
			}, {
				field:"name",title:'角色名称',width:150,
				editor:{
					type:'text',
					options:{
						required:false
					}
				}
			}, {
				field:"description",title:'角色描述',width:300,
				editor:{
					type:'text',
					options:{
						required:false
					}
				}
			}, {
				field:"createTime",title:'创建时间',width:200
				
//			}
//			, {
//				field:"status",title:'是否启用',width:100,// 0未启用，1启用
//
//				editor : {
//					type : 'combobox',
//					options : {
//						missingMessage:'请选择或输入是否启用',
//						valueField:'useType',
//						textField:'name',
//						panelHeight:45,
//						data:useSelect,
//						required : false
//					}
//				}
			}] ],// 合并单元格
			toolbar : [ {
				id:"RESOURCE_6030200",
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					if (editRow != undefined) {
						datagrid.datagrid('endEdit', editRow);
					}
					if (editRow == undefined) {
						datagrid.datagrid('insertRow', {// 首行增加

							index : 0,
							row : {
							}
						});
						var rows = datagrid.datagrid('getRows');
						// datagrid.datagrid('beginEdit', rows.length -
						// 1);//开启行编辑模式，在末尾插入index索引从零开始，因此减1
						datagrid.datagrid('beginEdit', 0);
						editRow = 0;
					}
				}

			}, '-', {
				id:"RESOURCE_6030400",
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					var rows = datagrid.datagrid('getSelections');// 获得选中项
					if(rows.length>0){
						$.messager.confirm('请确认','您确定要删除当前选择的所有项吗？',function(b){
					
					if(b){// 选择“确定”
					var ids=[];
					for(i=0;i<rows.length;i++){
						ids.push(rows[i].id);
				}
				console.info(ids.join(','));
				$.ajax({
	                url : getContextPath()+'/roles/delete.do',
	                data : {rolesIds : ids.join(',')},
	                dataType : 'json',
	                success : function(rsp) {
	                	datagrid.datagrid('reload');
	                	$.messager.alert("提示",rsp.msg);
	                }
	                });
				}
				else{// 选择“取消”
					datagrid.datagrid('unselectAll');// ////////////////////////
				}
				});
				}else{
				$.messager.alert('提示','请选择要删除的记录','error');
				}
				}
			}, '-', {
				id:"RESOURCE_6030300",
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					var rows = datagrid.datagrid('getSelections');
					if (rows.length == 1) {
						if (editRow != undefined) {
							datagrid.datagrid('endEdit', editRow);
						}
						if (editRow == undefined) {    
							var index =datagrid.datagrid('getRowIndex', rows[0]);
							datagrid.datagrid('beginEdit', index);
							editRow = index;
							datagrid.datagrid('unselectAll');
						}
					}
					else if(rows.length>1){                                    // ///////////////////////
						$.messager.alert('提示','一次只能修改一条记录，请重新选择','error');// ///////////////
						datagrid.datagrid('unselectAll');                      // ///////////////
					}else{                                                     // ///////////////
						$.messager.alert('提示','请选择要修改的记录','error');         // ///////////////
					}                                                          // ///////////
				}
			}, '-', {
				text : '保存',
				iconCls : 'icon-save',
				handler : function() {
					endEdit();
					if (datagrid.datagrid('getChanges').length) {
                        var inserted = datagrid.datagrid('getChanges', "inserted");
                        var updated = datagrid.datagrid('getChanges', "updated");
                        var effectRow = new Object();
                        
                            if (inserted.length) {
                            	effectRow["data"] = JSON.stringify(inserted);
                            }
                            if (updated.length) {
                            	effectRow["data"] = JSON.stringify(updated);
                            }
                         	$.post(getContextPath()+'/roles/save.do', effectRow, function(rsp) {
                         		
                         		$.messager.alert("提示",rsp.msg);
                         		datagrid.datagrid('reload');
                         		datagrid.datagrid('unselectAll');

                         }, "JSON").error(function() {
                            $.messager.alert("提示", "提交错误（请按规范填写）！");// ///////////////////
                         });
				    }
			    }
			}, '-', {
				text : '取消',
				iconCls : 'icon-undo',
				handler : function() {
					editRow = undefined;
					datagrid.datagrid('rejectChanges');
					datagrid.datagrid('unselectAll');
				}
			}, '-' ,{
				/*id:"RESOURCE_6030500",*/
				text : '授权',
				iconCls : 'icon-wrench',
				handler : function() {
					IS_INIT_TREE = true;
					
					var rows=datagrid.datagrid('getSelections');
					
					if(isSelectedOneRow(rows)){

						showDiv_Resources(rows[0].id);
//						return false;
					}
					
				
				}
					
//					if(rows.length != 1){
//						$.messager.alert('提示','一次只能授权一个角色，请重新选择','error');
//						datagrid.datagrid('unselectAll'); 
//						return ;
//					}
//					
//						if(editRow !=undefined){
//							datagrid.datagrid('endEdit',editRow);
//						}
//							var row=$('#datagrid').datagrid('getSelected');
//							if(row){
//								$('#authorize').dialog({
//									title:row.name+' 角色授权',
//									width:520,
//									height:550,
//									closed:false,
//									cache:false,
//									modal:true
//								});								
//								$('#authorizeForm').form('load',row);
//								initInfo(row.id);

//								datagrid.datagrid('unselectAll');
//								}else{
//									$.messager.alert('提示','请选择要授权的角色记录','error');
//								}
//							
//						}
				
			}, '-' ],
			// 当用户编辑完成时触发
			onAfterEdit : function(rowIndex, rowData, changes) {
				console.info(rowData);// 向后台传递的数据
				editRow = undefined;
			},
			// 当用户双击一行时触发
			onDblClickRow : function(rowIndex, rowData) {// 双击编辑行
				if (editRow != undefined) {
					datagrid.datagrid('endEdit', editRow);
				}
				if (editRow == undefined) {

					var rows = datagrid.datagrid('getRows');
					datagrid.datagrid('beginEdit', rowIndex);
					editRow = rowIndex;
				}
			}
		});

	});
	
	function endEdit(){
        var rows = datagrid.datagrid('getRows');
        
        for ( var i = 0; i < rows.length; i++) {
        	datagrid.datagrid('endEdit', i);
        }
       }
	
	function searchRoles(){
		
		$('#datagrid').datagrid('load',{"name":$('#name').val()} );//sy.serializeObject()
		
	}
	
	function clearRoles(){
		
		 $('#searchForm').form('clear');
		 json = {};//将查询参数JSON置为空
		 datagrid.datagrid('load', {});
		
		
	}