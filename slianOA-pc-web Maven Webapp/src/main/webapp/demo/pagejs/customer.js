		var datagrid;
		var editRow = undefined;//行编辑标志
$(function() {
			
	init_datagrid();
	
	$(".rankLevel").click(function(){

		var row = datagrid.datagrid("getChecked");
		
		if(row.length !=1)
			return alert("请选择一个客户！三");
			
		setRank(row[0].customerId,$(this).val());

		$('#dialog_rank_set').dialog('close');
		
	});
	
	$(".type").click(function(){

		var rows = datagrid.datagrid("getChecked");
		
		if(rows.length < 1)
			return;
		
		var ids = [];
		for (i = 0; i < rows.length; i++) {
			ids.push(rows[i].customerId);
		}
		
		setCustomerType(ids,$(this).val());

		$('#dialog_VIP_set').dialog('close');
		
	});

});

			
function init_datagrid(){
	
	datagrid = $('#datagrid').datagrid({
		title : '',
		iconCls : 'icon-save',
	    pagination : true,//进度条
		pageSize : 50,//每页显示10条
		pageList : [ 10, 20, 30, 40, 50, 100, 200 ],//选择每页显示条数 
     	fit : true,
		fitColumns : true,//设置false页面变窄时显示横向滚动条
		nowrap : true,//设置为false表格内容自动折行但是影响性能
		border : false,
		striped : true,
		idField : 'customerId',//翻页选择标记（便于多页删除）
		sortName:'customerId',
		sortOrder:'desc',
		remoteSort : false,
		url : getContextPath()+'/customer/list.do',
		columns : [ [{
			title : '选择框',
			field : 'box',
			width : 90,
			checkbox:true,	
		 }, {
			field:"customerId",title:'客户编号',width:100,sortable:true,hidden:true,
	
		}, {
			field:"customerName",title:'姓名',width:100,sortable:true,editor:{type:'validatebox',
				options : {
					required : true
				} }
		},{
			   field:"type",title:'性别',width:60,sortable:true,editor:{type:'combobox',options:{required:true,editable:false,data:[{'type':'男'},{'type':'女'}],valueField:'type',textField:'type'}}

		}, {
			field:"customerCompany",title:'公司名称',width:250,sortable:true,editor:{type:'text'}
		}, {
			field:"typeDesc",title:'职务',width:100,sortable:true,editor:{type:'text'}
		},{
			field:"customerCellPhone",title:'手机',width:120,sortable:true,editor: {type:'validatebox',
				options : {
					validType : ['mobile'],
					required:true
				}}
		},{
			field:"customerOfficePhone",title:'电话',width:120,sortable:true,editor:{type:'text'}
		},{
			field:"email",title:'邮箱',width:160,sortable:true,editor:{type:'validatebox',options:{validType:['email']}}
		},{
			field:"officeAddr",title:'地址',width:120,sortable:true,editor:{type:'text'}
//		},{
//			field:"weixinName",title:'微信帐号名称',width:120,sortable:true,editor:{type:'text'}
//		},{
//			field:"creatorName",title:'负责人',width:80,sortable:true
//		},{
//			field:"type",title:'客户类型',width:80,sortable:true
//		},{
//		   field:"customerCreator",title:'录入人',width:80,sortable:true,editor:{type:'text'}
//		},{
//		   field:"customerAccessGroup",title:'权限组',width:80,sortable:true,editor:{type:'text'}
//		},{
//		   field:"createTime",title:'录入时间',width:150,sortable:true, 
//		},{
//		   field:"customerStatus",title:'状态',width:60,sortable:true,editor:{type:'combobox',options:{required:true,editable:false,data:[{'status':'正常'},{'status':'封停'}],valueField:'status',textField:'status'}}
//		},{
//		   field:"hy2008CustomerId",title:'2008系统客户编号',width:125,sortable:true,editor:{type:'text'}
		} ] ],//合并单元格
		toolbar : [ {
			id:"RESOURCE_4070200",
			text : '增加',
			iconCls : 'icon-add',
			handler : function() {
				add();
			}

		}, '-', {
			id:"RESOURCE_4070400",
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
				remove();
			}
		}, '-', {
			id:"RESOURCE_4070300",
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
				edit();
			}
		},  '-', {
//			id : '4050300',
			text : '保存',
			iconCls : 'icon-save',
			handler : function() {
				endEdit();
				save();
			}
//		},'-', {
//			id:"RESOURCE_4050500",
//			text : '更改负责人',
//			iconCls : 'icon-head1',
//			handler : function() {
//				
////				alert("更改负责");
//				var rows = datagrid.datagrid("getChecked");
//				
//				if(rows.length < 1){
//
//					$.messager.show({
//						title : '提示',
//						msg : "请选择客户！"
//					});
//					return;
//				}
//				show_dialog_countman();
//				
//			}
//		},'-', {
//			id:"RESOURCE_4050600",
//			text : 'VIP设置',
//			iconCls : 'icon-vip',
//			handler : function() {
//				var rows = datagrid.datagrid('getSelections');
//				
//				if(rows.length <1){
//					$.messager.alert('提示','请选择设置的客户','error');// ///////////////
//					return;
//				}
//				
//				$('#dialog_VIP_set').dialog({
//					title: '设置VIP',
//					width: 300,
//					height:150,
//					closed: false,
//					cache: false,
//					modal: true
//					});
//				
//			}
//		},'-', {
//			id:"RESOURCE_4050700",
//			text : 'A-F等级设置',
//			iconCls : 'icon-level2',
//			handler : function() {
//				var rows = datagrid.datagrid('getSelections');
//				
//				if (rows.length == 1) {
//					if (editRow != undefined) {
//						datagrid.datagrid('endEdit', editRow);
//					}
//					show_dialog_rank(rows[0].customerId,"ABCDEF");
//				}
//				else if(rows.length>1){                                   
//					$.messager.alert('提示','一次只能修改一条记录，请重新选择','error');
//					datagrid.datagrid('unselectAll');                     
//				}else{                                                   
//					$.messager.alert('提示','请选择要修改的记录','error');        
//				}
//			}
//		},'-', {
//			id:"RESOURCE_4050800",
//			text : 'C-F等级设置',
//			iconCls : 'icon-level1',
//			handler : function() {
//				
//				var rows = datagrid.datagrid('getSelections');
//				
//				if (rows.length == 1) {
//					if (editRow != undefined) {
//						datagrid.datagrid('endEdit', editRow);
//					}
//					show_dialog_rank(rows[0].customerId,"CDEF");
//				}
//				else if(rows.length>1){                                    // ///////////////////////
//					$.messager.alert('提示','一次只能修改一条记录，请重新选择','error');// ///////////////
//					datagrid.datagrid('unselectAll');                      // ///////////////
//				}else{                                                     // ///////////////
//					$.messager.alert('提示','请选择要修改的记录','error');         // ///////////////
//				}
//
//						
//			}

		}, '-',   {
			text : '取消',
			iconCls : 'icon-undo',
			handler : function() {
				redoall();
			}
		}, '-'/* , {
			text : '导出Excel',
			iconCls : 'icon-tableexport',
			handler : function() {
				tableexport();
			}
		}, '-' */ ],
		//onClickRow:autoChange,
		onAfterEdit : function() {
			//endEdit();
			save();
			datagrid.datagrid("acceptChanges");
			datagrid.datagrid("unselectRow", editRow);
			editRow = undefined;
		},
		onDblClickRow : function(rowIndex, rowData) {//双击编辑行
			if (editRow != undefined) {
			    if($('.validatebox-invalid').length>0)//判断双击行切换编辑的时候是否有必填项为空
					{
					$.messager.show('警告','必填信息不能为空！');
					return;
					}
				datagrid.datagrid('endEdit', editRow);
		}
			if (editRow == undefined) { 
				//var rows = datagrid.datagrid('getRows');
				datagrid.datagrid('beginEdit', rowIndex);
				editRow = rowIndex ;
				datagrid.datagrid('selectRow',editRow);//选中编辑行
				
				
			}
		}
	});
}

function setCustomerType(customerIds,type){
	

	$.ajax({
		type : 'POST',
		url : '/customer/setvip.do',///pcbas-analysis
		data : {
			customerIds:customerIds.join(','),
			type:type		
		},
		dataType : 'json',
		success : function(result) {
			
			
//			datagrid.datagrid('load');
			$('#datagrid').datagrid('reload');
			$('#datagrid').datagrid('unselectAll');
			$.messager.show({
				title : '提示',
				msg : result
			});
		}
	});
	

}


		
		function endEdit() {
			var rows = datagrid.datagrid('getRows');
			for ( var i = 0; i < rows.length; i++) {
				datagrid.datagrid('endEdit', i);
			}
		}
		function tableexport() {
			var url = "../export.do?method=rowSpanExport";
			window.location.href = url;
		}
		function add() {
			if (editRow != undefined)  {
			    datagrid.datagrid('endEdit', editRow);
			    $.messager.show({
						title : '提示',
						msg : '必填信息不能为空'
					});
			}
			//datagrid.datagrid('appendRow', {//末尾增加

			//});
			if (editRow == undefined) {//判断一次只能增加一行
			datagrid.datagrid('insertRow', {//首行增加
				index : 0,
				row : {

				}

			});
			var rows = datagrid.datagrid('getRows');
			//datagrid.datagrid('beginEdit', rows.length - 1);//开启行编辑模式，在末尾插入index索引从零开始，因此减1
			datagrid.datagrid('beginEdit', 0);
			editRow = 0;
			
			datagrid.datagrid('selectRow',editRow);//选中编辑行
					var ed = $('#datagrid').datagrid('getEditors', editRow);
			        for (var i = 0; i < ed.length; i++)
			        {
				        var e = ed[i];
				        if(e.field == "dptCode")
				        {
					        $(e.target).bind("keyup",function(){
	                 	        return toUpper($(this));
	            	        }).bind("change", function(){
	                 	        return toUpper($(this));
	            	        });
				        }
			        }
		    }
		}
		function remove() {
			if($('.datagrid-row-editing').length>0){
                $.messager.show('提示','存在未保存数据，不能执行删除操作，取消编辑请点击“取消”！');
                return;
                }
			var rows = datagrid.datagrid('getSelections');//获得选中项
			 
			if (rows.length > 0) {
				$.messager.confirm('请确认', '您确定要删除当前选择的所有项吗？', function(b) {
					if (b) {
						var ids = [];
						for (i = 0; i < rows.length; i++) {
							ids.push(rows[i].customerId);
						}
//						console.info(ids.join(','));
						$.ajax({
							url : getContextPath() +'/customer/delete.do',//pcbas-analysis
							data : {
								ids : ids.join(',')
							},
							dataType : 'json',
							success : function(r) {
								datagrid.datagrid('load');
								datagrid.datagrid('unselectAll');
								$.messager.show({
									title : '提示',
									msg : '删除成功'
								});
							}
						});
					}
				});
				//console.info(rows)
			} else {
				$.messager.alert('提示', '请选择要删除的记录', 'error');
			}
		}
		function edit() {
			var rows = datagrid.datagrid('getSelections');
			if (rows.length > 1){
			    $.messager.show('提示','一次只能修改一条数据！');
			    return;
			}
		 
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
      }
		
		function save() {
			var changeRows = datagrid.datagrid('getChanges');

			/*for (i = 0; i < changeRows.length; i++)
				if (isEmptyObject(changeRows[i])) {
					$.messager.show({
						title : '警告',
						msg : '存在不合法输入'
					});
					return;
				}*/
			if (datagrid.datagrid('getChanges').length) {
				var inserted = datagrid.datagrid('getChanges', "inserted");
				var updated = datagrid.datagrid('getChanges', "updated");
				var effectRow = new Object();
				if (inserted.length) {
					effectRow["inserted"] = JSON.stringify(inserted);
				}
				if (updated.length) {
					effectRow["updated"] = JSON.stringify(updated);
				}
				$.post(getContextPath() +  "/customer/save.do", effectRow,//pcbas-analysis/
						function(data) {
							if (data == 'success') {
								$.messager.show({
									title : '提示',
									msg : '保存成功'
								}); 
								datagrid.datagrid('reload');
							}
				}, "JSON").error(function() {
					$.messager.show({
						title : '提示',
						msg : '保存失败'
					});
				});
			}
		}
		function redoall() {
			editRow = undefined;
			datagrid.datagrid('rejectChanges');
			datagrid.datagrid('reload',{});
			datagrid.datagrid('unselectAll');
		}
		function redo() {
			var rows = datagrid.datagrid("getSelections"); //获取你选择的所有行
			if (rows) {
				$.messager.confirm('请确认', '您确定要取消当前编辑的项吗？', function(b) {
					if (b) {
						for (i = 0; i < rows.length; i++) {
							var index = datagrid.datagrid('getRowIndex',rows[i]);//获取某行的行号     
							datagrid.datagrid('deleteRow', index);
						}
					}
				})
			}
			if (!rows) {
				editRow = undefined;
				datagrid.datagrid('rejectChanges');
				datagrid.datagrid('unselectAll');
			}
		}
		
	
		/**
		 * 查询，将查询参数不为空的放入JSON传入后台,该写法支持模糊查询
		 */
		function serchCustom(){
			var para = sy.serializeObject($('#searchForm'));
//			para.cuonterManName=$("#counterman").combobox("getText");
//			para.counterManDepartment=$("#department").combobox("getValue");
			$('#datagrid').datagrid('load', para);
		
		
		}
		
		/**
		 * 点击清空按钮触发事件，注意将查询JSON置为空
		 */
		function clearCustom(){
		    $('#searchForm').form('clear');
		    $('#datagrid').datagrid({url:getContextPath()+'/customer/list.do',});
		    $('#datagrid').datagrid('load', {});
		}
		
function show_dialog_countman(customerId){ // 打开任务窗口
			
			$('#dialog_counterman_set').dialog({
				title: '更改负责人',
				width: 400,
				height: 500,
				closed: false,
				cache: false,
				modal: true
				});
			
			$('#customer_counterman').datagrid({
						//url : "van_task.json",/* ?userId="+userId, */
						title : '',
						iconCls : 'icon-save',
						//pagination : true,// 进度条
						//		pageSize : 10,// 每页显示10条
						//		pageList : [ 10, 20, 30, 40, 50 ],// 选择每页显示条数
						fit : true,
//						width : 300,
						fitColumns : false,// 设置false页面变窄时显示横向滚动条
						nowarp : false,// 表格内容自动折行
						border : false,
						sortName:"employeeId",
						singleSelect:true,
//						idField : 'id',// 翻页选择标记（便于多页删除）
						remoteSort : false,// 定义是否从服务器给数据排序。
						striped : true,// 为true是交替显示行背景
						url : getContextPath()
								+ '/employee/listAll.do',
						columns : [ [ {
							title : '选择框',
							field : 'checked',
							width : 30,
							// sortable:true,
							checkbox : true,

						}, {
							field : "employeeId",
							title : '员工Id',
							sortable:true,
							width : 60,
//							hidden : true
						}, {
							field : "employeeName",
							title : '员工姓名',
							sortable:true,
							width : 80,
						}, {
							field : "departmentName",
							title : '部门',
							sortable:true,
							width : 200
						} ] ],
						toolbar : [{
//							id:"RESOURCE_112",
							text : '保存',
							iconCls : 'icon-edit',
							handler : function() {
								
								var row = $("#customer_counterman").datagrid("getChecked");
								if(row.length <1){
									$.messager.show({
										title : '提示',
										msg : "请选择员工！"
									});
									
									return;
									
								}
								setCountermane(row[0].employeeId);
							}
					
						}]
					});

	}
		

function setCountermane(employeeId){

	
	var rows = datagrid.datagrid("getChecked");
	
	var customerIds = [];
	for (i = 0; i < rows.length; i++) {
		customerIds.push(rows[i].customerId);
	}
	
	$.ajax({
		type : 'POST',
		url : getContextPath() + '/customer/setCounterman.do',//pcbas-analysis/
		data : {
			customerIds:customerIds.join(','),
			employeeId:employeeId		
		},
		dataType : 'json',
		success : function(result) {
			
			
//			datagrid.datagrid('load');
			$('#datagrid').datagrid('reload');
			$('#datagrid').datagrid('unselectAll');
			$('#dialog_counterman_set').dialog('close');
			
			$.messager.show({
				title : '提示',
				msg : result
			});
		}
	});
	
	
}
		function show_dialog_rank(customerId,type){ // 打开任务窗口
			
			$('#rankLevelSetType').val(type);
			
			$('#dialog_rank').dialog({
				title: '设置客户等级',
				width: 350,
				height: 450,
				closed: false,
				cache: false,
				modal: true
				});
			
			
			$('#customer_rank').datagrid({
						//url : "van_task.json",/* ?userId="+userId, */
						title : '',
						iconCls : 'icon-save',
						//pagination : true,// 进度条
						//		pageSize : 10,// 每页显示10条
						//		pageList : [ 10, 20, 30, 40, 50 ],// 选择每页显示条数
						fit : true,
//						width : 300,
						fitColumns : false,// 设置false页面变窄时显示横向滚动条
						nowarp : false,// 表格内容自动折行
						border : false,
						sortName:"shipCompanyName",
//						idField : 'id',// 翻页选择标记（便于多页删除）
						remoteSort : false,// 定义是否从服务器给数据排序。
						striped : true,// 为true是交替显示行背景
						url : getContextPath()
								+ '/quotationrank/getHttpRanks.do?customerId='+ customerId,
						columns : [ [ {
							title : '选择框',
							field : 'checked',
							width : 30,
							// sortable:true,
							checkbox : true,

						}, {
							field : "shipCompany",
							title : '船公司ID',
							width : 20,
							hidden : true
						}, {
							field : "shipCompanyName",
							title : '船公司',
							width : 200,
						}, {
							field : "rank",
							title : '等级',
							width : 80
						} ] ],
						toolbar : [{
							id:"RESOURCE_112",
							text : '设置',
							iconCls : 'icon-edit',
							handler : function() {
								
										
								$.each($(".span_rankLevel"),function(){
									
									if(type.indexOf($(this).attr("value")) <0)
										$(this).hide();
									else
										$(this).show();
								});
								
								$('#dialog_rank_set').dialog({
									title: '设置等级',
									width: 300,
									height:150,
									closed: false,
									cache: false,
									modal: true
									});
								
								
								
								
							}
						}],
						onCheck:function(index,row){
						
						
								
//							saveUserRole(userId,row.id,"insert");
//							
//							
//							datagrid.datagrid('reload');
							
						},
						onUncheck:function(index,row){

//							saveUserRole(userId,row.id,"delete");
//							
//							
//							datagrid.datagrid('reload');
							
						}
					});

	}
		
		
	function setRank(customerId,rankLevel){
		
		var rows = $('#customer_rank').datagrid('getChecked');
		
		if(rows.length <1)
			return;
		
		var ids = [];
		
		
		for (i = 0; i < rows.length; i++) {
			ids.push(rows[i].shipCompany);
		}
		
		var url = '/quotationrank/insert.do';//pcbas-analysis/
		
		//C-F等级设置
		if($('#rankLevelSetType').val() == 'CDEF')
			url = '/quotationrank/insertAboveC.do';//pcbas-analysis/
		
		$.ajax({
			url : url,
			data : {
				customerId:customerId,
				shipCompanyIds : ids.join(','),
				rankLevel:rankLevel
				
			},
			dataType : 'json',
			success : function(result) {
				
				
//				datagrid.datagrid('load');
				$('#customer_rank').datagrid('reload');
				$('#customer_rank').datagrid('unselectAll');
				$.messager.show({
					title : '提示',
					msg : result.msg
				});
			}
		});
		
	}

	
