
/**
 * 用户管理
 */


	var  datagrid,datagrid_roles;
	var editRow = undefined;// 行编辑标志
	var useSelect=[
		  	         {useType:'启用',name:'启用'},
		  	         {useType:'未启用',name:'未启用'}
		  	         ];
	
	
	
	var IS_INIT_DATAGRID = true;
	
	$(function() {
		
		datagrid = $('#datagrid').datagrid({
			title : '用户管理',
			iconCls : 'icon-save',
			pagination : true,// 进度条
			pageSize : 10,// 每页显示10条
			pageList : [ 10, 20, 30, 40, 50, 100, 200 ],// 选择每页显示条数
			fit : true,
			width:1000,
			fitColumns : false,// 设置false页面变窄时显示横向滚动条
			nowarp : false,// 表格内容自动折行
			border : false,
			idField : 'id',// 翻页选择标记（便于多页删除）
			sortName:'id',
			sortOrder:'desc',
			remoteSort: false,// 定义是否从服务器给数据排序。
			striped:true,// 为true是交替显示行背景
			url : getContextPath()+'/users/getUsers.do',
			columns : [ [{
				title : '选择框',
				field : 'box',
				width : 90,
				// sortable:true,
				checkbox:true,
				
			}, {
				field:"id",title:'用户编号',width:80,hidden:true,
				editor:{
					type:'text',
					options:{
						required:false
					}
				}
			}, {
				field:"username",title:'用户名称',width:150,
				editor:{
					type:'text',
					options:{
						required:true
					}
				}
//			}, {
//				field:"status",title:'状态',width:50,
//				editor:{
//					type:'text',
//					options:{
//						required:false
//					}
//				}
			}, {
				field:"roleNames",title:'用户角色',width:120
			}, {
				field:"userDetailName",title:'姓名',width:120,
				editor:{
					type:'text',
					options:{
						required:true
					}
				}
			}, /*{
				field:"userDetailId",title:'客户联系人或员工ID',width:100,
				editor:{
					type:'text',
					options:{
						required:true
					}
				}
			},*/{
				field:"type",title:'类型',width:100,
				editor:{type:'combobox',
					options:{
							data:[{"type":"客户"},{"type":"员工"}],
							valueField:"type",
							textField:'type',
//							parentField:'superior',
//							formatter:function(node){return node.name},
//							multiple:false
						}
				}
			}, {
				field:"sLastLoginTime",title:'最近登陆时间',width:150
			}, {
				field:"lastLoginIp",title:'最近登陆IP',width:100
			
			}, {
				field:"sCreateTime",title:'创建时间',width:150
			}] ],
		    view:detailview,
			detailFormatter:function(index,row){
				 return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
	        },
	        onExpandRow: function(index,row){
	          $('#ddv-'+index).datagrid({
	             queryParams:{
	          	  userId:row.id,
	          	  id:row.id
	
	          },
	           method: "get",
	           url: getContextPath()+'/auth/getAuthenticationInfo.do',
	           fitColumns:true,
	           singleSelect:true,
	           rownumbers:true,
	           loadMsg:'',
	           height:'auto',
	           columns: [[
	                   { field:'id', title: 'id', width: 80, hidden:true,sortable: true,halign:'center',},
	                   { field:'account', title: '帐号', width: 80, sortable: true,halign:'center',},
	                   { field:'password',title:'密码',width:100, sortable: true,hidden:true,},
	                   { field:'type', title: '类型', width: 80, sortable: true,halign:'center',},  
//	                   { field:'status', title: '状态', width: 80, sortable: true,halign:'center',},
	                   { field:'lastTime',title:'最近认证时间',width:100, sortable: true,},
	                   { field:'lastIp',title:'最近认证IP',width:100, sortable: true,},
	                   { field : 'operate',title : '操作',width : 100,sortable : true,
	   						formatter:
//	   							function(){return '<a class="l-btn l-btn-plain easyui-tooltips" href="javascript:void(0)" title="点击这里查看和修改其他费用" onclick="otherfee(\'' + row.id+ '\')">其他费用</a>'},
	   							function(val,row){
	   							return "<a class='l-btn l-btn-plain easyui-tooltips' href='javascript:void(0)' title=修改授权帐户信息' onclick=\"showDiv_authencationInfo('update','"+ 
	   										row.id+ "','"+row.account+"','"+row.password+"','"+row.type+"')\">修改</a>" +
	   							'&nbsp;&nbsp;<a class="l-btn l-btn-plain easyui-tooltips" href="javascript:void(0)" title="修改授权帐户信息" onclick="deleteAuthencationInfo(\'' + row.id+ '\')">删除</a>'
	   							
	   						},
	   				  	}
	                                         
	               ]],
	        onResize:function(){
	          $('#datagrid').datagrid('fixDetailRowHeight',index);
	        },
	        onLoadSuccess:function(){
	          setTimeout(function(){
	          $('#datagrid').datagrid('fixDetailRowHeight',index);
	          },0);
	        }
	      });
	      $('#datagrid').datagrid('fixDetailRowHeight',index);            
	      },// 合并单元格
	      toolbar : [ {
				text : '取消',
				iconCls : 'icon-undo',
				handler : function() {
					editRow = undefined;
					datagrid.datagrid('rejectChanges');
					datagrid.datagrid('unselectAll');
				}
			},'-' ,{
				id:"RESOURCE_6040500",
				text : '分配角色',
				iconCls : 'icon-wrench',
				handler : function() {
					
					var rows = datagrid.datagrid('getSelections');
					
					if(isSelectedOneRow(rows)){
						showDiv_roles(rows[0].id);
						
//						return false;
					} 
	
							
				}
				
			}, '-',{
//				id:"RESOURCE_6040500",
				text : '创建授权帐号',
				iconCls : 'icon-wrench',
				handler : function() {
					
						
					showDiv_authencationInfo('insert');
				
					
					
							
				}
				
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
		
		function endEdit(){
            var rows = datagrid.datagrid('getRows');
            for ( var i = 0; i < rows.length; i++) {
            	datagrid.datagrid('endEdit', i);
            }
           }
	});
	
	$(document).ready(function(){
		

		   $('#btnEp').click(function() {
		        saveAuthenticationInfo();
		    });

			$('#btnCancel').click(function(){
				$('#div_authencationInfo').window('close');
			});
		
	})

	//修改密码
function saveAuthenticationInfo() {
	 account = $('#account');
	 password = $('#password');
	 confirmPassword = $('#confirmPassword');
     type = $('#type');

    if (account.val() == '') {
        alert('用户名不能为空！');
        return false;
    }
    if (password.val() == '') {
    	alert('请输入新密码！');
        return false;
    }
    if (confirmPassword.val() == '') {
    	alert('请输入确认密码！');
        return false;
    }
    if (password.val().length<6 ) {
    	alert( '密码长度不能小于6位！');
        return false;
    }
    if (confirmPassword.val() != password.val()) {
    	alert('两次密码不一致！请重新输入');
        return false;
    }


    if ($('#type').combobox('getValue') == '') {
    	alert('类型不能为空！');
        return false;
    }
    $.ajax({ 
        url : getContextPath()+'/auth/save.do', 
        data:{
        	"authencationInfo": JSON.stringify(sy.serializeObject($('#authencationInfo'))),
        },
        type : 'POST', 
        dataType : 'json', 
        success : function(rsp) { 
        	
        	$('#div_authencationInfo').window('close');
        	$.messager.alert("提示",rsp.msg);
        	
        	datagrid.datagrid('load');
        	datagrid.datagrid('unSelectAll');
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
	          //通常情况下textStatus和errorThrown只有其中一个包含信息
	          this;   //调用本次ajax请求时传递的options参数
	          alert(textStatus + errorThrown);
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
	
function deleteAuthencationInfo(id){
	var rows = datagrid.datagrid('getSelections');

	if(!isSelectedOneRow(rows))
		return false;
	
		
		if(!confirm("删除授权信息后，用户将无法使用该帐户登录！") )
			return;
		
		
		
	    $.ajax({ 
	        url : getContextPath()+'/auth/delete.do', 
	        data:{
	        	"id": id,
	        },
	        type : 'POST', 
	        dataType : 'json', 
	        success : function(rsp) { 
	        	
	        
	        	$.messager.alert("提示",rsp.msg);
	        	
	        	datagrid.datagrid('load');
	        	datagrid.datagrid('selectRecord',id);
	        },
	        error:function(XMLHttpRequest, textStatus, errorThrown){
		          //通常情况下textStatus和errorThrown只有其中一个包含信息
		          this;   //调用本次ajax请求时传递的options参数
		          alert(textStatus + errorThrown);
		       }
	    });
		
}


//插入时data为userId，修改时data 为authencationId
function showDiv_authencationInfo(operType,authencationId,account,password,type){
	
	var rows = datagrid.datagrid('getSelections');

	if(!isSelectedOneRow(rows))
		return false;
	
	//清空input值
	$.each($('#div_authencationInfo input'),function(){
		
		$(this).val('');
	});
	
//	if(operType == 'insert'){
////		$("#operType").val("insert");
//		$("#userId").val(rows[0].id);
//
//	}
	
//	if(operType == 'update'){
		
			
//		$("#operType").val("update");
		$("#id").val(authencationId);
		$("#account").val(account);
		$("#password").val(password);
//		$("#type").val(type);
		$('#type').combobox('setValue',type);  
		$("#uid").val(rows[0].id);
		
//	}
	
	
	$('#div_authencationInfo').dialog({
		title: '创建授权帐号',
		width: 300,
		height:200,
		closed: false,
		cache: false,
		modal: true
		});
	
	
}
	
function showDiv_roles(userId){ // 打开任务窗口
	  var $parent = self.parent.$; //在父窗体弹出
		$parent('#popDiv').empty(); 
		$parent('#popDiv').html('<div id="popContent" name="popContent"></div>');
		//$parent('#popdiv').window('refresh', 'users_roles.html?userId=' + userId);
		$parent('#popDiv').window({
		modal:true,
		collapsible:false,
		width:450, 
		height:500,
//		href:'demo/users_roles.html?userId='+ userId, 
		title:'分配角色', 
		onBeforeOpen:function(){
			
			showDatagrid_roles($parent,userId);
		
			},
		onClose:function(){
				 $parent('#popContent').empty();
				}
		});
	}


function saveUserRole(userId,roleId,operType){
	
	$.ajax({
		type:"post",
		url:getContextPath()+"/usersRoles/"+operType+".do",// getContextPath()+'/resources/getTreegrid.do'+'?id=10',//
		async:false,
		data:{
			roleId:roleId,
			userId:userId
		},
		dataType:'json',
		success:function(result){
			//initOrgaInfo(roleId,node.id,treeData);
			
			if(result.success){
				
				datagrid.datagrid('reload');
				datagrid.datagrid('unSelectAll');
				return ;
			}
			
			alert(result.msg);
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
	          //通常情况下textStatus和errorThrown只有其中一个包含信息
	          this;   //调用本次ajax请求时传递的options参数
	          alert(textStatus + errorThrown);
	          return false;
		}
	});
}

function showDatagrid_roles($parent,userId){
	
//'#datagrid_roles'
//	 $parent('#popContent').empty();
   $parent('#popContent').datagrid(
			{
				//url : "van_task.json",/* ?userId="+userId, */
//				title : '角色列表',
//				iconCls : 'icon-save',
				//pagination : true,// 进度条
				//		pageSize : 10,// 每页显示10条
				//		pageList : [ 10, 20, 30, 40, 50 ],// 选择每页显示条数
				fit : true,
				width : 450,
				fitColumns : false,// 设置false页面变窄时显示横向滚动条
				nowarp : false,// 表格内容自动折行
				border : false,
				idField : 'id',// 翻页选择标记（便于多页删除）
				remoteSort : false,// 定义是否从服务器给数据排序。
				striped : true,// 为true是交替显示行背景
				url : getContextPath()
						+ '/usersRoles/getHttpRoles.do?userId='+ userId,
				columns : [ [ {
					title : '选择框',
					field : 'checked',
					width : 90,
					// sortable:true,
					checkbox : true,

				}, {
					field : "id",
					title : '角色编号',
					width : 80,
					hidden : true
				}, {
					field : "name",
					title : '用户名称',
					width : 100,
				}, {
					field : "description",
					title : '描述',
					width : 200
				} ] ],
				onLoadSuccess : function(data) {
					if (data) {
						$.each(data.rows, function(index, item) {
							if (item.checked) {
								 $parent('#popContent').datagrid(
										'checkRow', index);
							}
						});
					}
					
					//数据加载完成，将初始化变量置为false
					IS_INIT_DATAGRID = false;
					
					//隐藏title中的 checkall  uncheckall checkbox
					$('.datagrid-header-check input').eq(1).css('display','none')
				},
				onCheck:function(index,row){
				
					if(IS_INIT_DATAGRID)
						return;
						
					saveUserRole(userId,row.id,"insert");
					
					
					
					
				},
				onUncheck:function(index,row){

					saveUserRole(userId,row.id,"delete");
					
					
					
				}
			});
}

function searchUsers(){

	datagrid.datagrid('load', sy.serializeObject($('#searchForm')));
	datagrid.datagrid('unSelectAll');

	
	}

function clearUsers(){
	
	 $('#searchForm').form('clear');
	 json = {};//将查询参数JSON置为空
	 datagrid.datagrid('load', {});
	 datagrid.datagrid('unSelectAll');
	
	
}