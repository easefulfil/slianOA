		var datagrid;
		var editRow = undefined;//行编辑标志
		var json = {};
		// 参数：prop = 属性，val = 值
		function createJson(prop, val) {
			// 如果 val 被忽略
			if (typeof val === "undefined") {
				// 删除属性
				delete json[prop];
			} else {
				// 添加 或 修改
				json[prop] = val;
			}
		}
		
		$(function() {

			//设置查询条件为行为
			queryParams1=JSON.stringify(json);
			
			datagrid = $('#datagrid').datagrid({
				title : '',
				iconCls : 'icon-save',
			    pagination : true,//进度条
				pageSize : 10,//每页显示10条
				pageList : [ 10, 20, 30, 40, 50 ],//选择每页显示条数 
    	     	fit : true,
				fitColumns : true,//设置false页面变窄时显示横向滚动条
				nowrap : true,//设置为false表格内容自动折行但是影响性能
				border : false,
				striped : true,
				idField : 'activityID',//翻页选择标记（便于多页删除）
		  
				remoteSort : false,
				url : getContextPath()+'/pc-web/salesactivity/departments.do?keys='+queryParams1,
				
				columns : [ [/*{
					title : '选择框',
					field : 'box',
					width : 90,
					checkbox:true,	
				 }, *//*{
					field:"employeeId",title:'行为名称',width:100,sortable:true,hidden:false,editor:{type:'validatebox',
						options : {
							required : true
						} }
				},*/ {
					field:"activityTime",title:'行为时间',width:120,sortable:true,editor:{type:'validatebox',
						options : {
							required : true
						} }
				}, {
					field:"activityContent",title:'行为内容',width:100,sortable:true,editor:{type:'combobox',options:{required:true,editable:false,data:[{'status':'0-20'},{'status':'20-50'},{'status':'50以上'}],valueField:'status',textField:'status'}}
				},{
					field:"activityPhoto",title:'行为照片',width:100,sortable:true,editor:{type:'combobox',options:{required:true,editable:false,data:[{'status':'0-100'},{'status':'100-400'},{'status':'400以上'}],valueField:'status',textField:'status'}}
					,formatter:function(val,row){
						if(val == "" || val =="undefined")
							return '无照片';
						else{
							var photos = val.split(",");
							
							photos_URL ="";
							$.each(photos,function(i ,photo){
								
								photos_URL += '<a target="_blank" href="'+photo+'">图片'+(i+1)+'</a>  ';
								
								
							});
							
							return photos_URL;
						}
			
				}
				},{
					field:"status",title:'状态',width:100,sortable:true,editor:{type:'combobox',options:{required:true,editable:false,data:[{'status':'月'},{'status':'双月'},{'status':'买单'}],valueField:'status',textField:'status'}}
				},{
					field:"customerName",title:'顾客名称',width:120,sortable:true,editor:{type:'validatebox',options : {
						validType : ['number']
					}}
				},{
					field:"visitWayName",title:'拜访方式',width:120,sortable:true,editor:{type:'validatebox',options:{validType:['email']}}
				},{
					field:"relateNames",title:'同行人员',width:120,sortable:true,editor:{type:'text'}
				},{
				   field:"customerTypeName",title:'客户类型',width:100,sortable:true,editor:{type:'text'}
				},
				
				{
					field:"activityType",title:'活动类型',width:80,sortable:true,editor:{type:'text'}
				},{
				   field:"employeeName",title:'负责人',width:100,sortable:true,editor:{type:'text'}
				},{
				   field:"activityKind",title:'接受类型',width:120,sortable:true,editor:{type:'text'}
				}/*,{
				   field:"employeeCreationTime",title:'海运职位',width:150,sortable:true, 
				}*/ ] ],
				view:detailview,
				detailFormatter:function(index,row){
					 return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
		        },
		        onExpandRow: function(index,row){
		          $('#ddv-'+index).datagrid({
		             queryParams:{
		            	 activityId:row.activityId

		          },
		        method: "get",
		        url: getContextPath()+'/pc-web/audit/getActivityFee.do',
		        fitColumns:true,
		        singleSelect:true,
		        rownumbers:true,
		        loadMsg:'',
		        height:'auto',
		        columns: [[
		                   { field:'auditId', title: '审计ID', width: 80, hidden:true,sortable: true,halign:'center',},
		                   { field:'auditFeeName', title: '费用名称', width: 80, sortable: true,halign:'center',},
		                   { field:'auditFee', title: '费用(元)', width: 30, sortable: true,halign:'center',},
		                   { field:'auditManName', title: '一级审核人', width: 80, sortable: true,halign:'center',},
		                   { field:'auditManSecondName', title: '二级审核人', width: 80, sortable: true,halign:'center',},
		                   { field:'auditLevel', title: '审核水平', width: 80, sortable: true,halign:'center',},
		                   { field:'status', title: '状态', width: 80, sortable: true,halign:'center',},
		                   { field:'employeeName', title: '负责人', width: 80, sortable: true,halign:'center',},
		                   { field:'isPassed', title: '报销状态', width: 80, sortable: true,halign:'center',},
		                   /*{ field : 'operate',title : '操作',width : 100,sortable : true,
		   						formatter:
		   							function(){return '<a class="l-btn l-btn-plain easyui-tooltips" href="javascript:void(0)" title="点击这里查看和修改其他费用" onclick="otherfee(\'' + row.id+ '\')">其他费用</a>'},
		   							function(val,row){
		   							return "<a class='l-btn l-btn-plain easyui-tooltips' href='javascript:void(0)' title=修改联系人信息' onclick=\"showDiv_customerEmployee('update','"+ 
		   										row.customerEmployeeId+ "','"+row.cname+"','"+row.sex+"','"+row.mobile+"','"+row.hometel+"','"+row.duty+"')\">修改</a>" +
		   							'&nbsp;&nbsp;<a class="l-btn l-btn-plain easyui-tooltips" href="javascript:void(0)" title="删除联系人信息" onclick="deleteCustomerEmployee(\'' + row.customerEmployeeId+ '\')">删除</a>'
		   							
		   						},
		   				  	}*/
		                                         
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
				/*toolbar : [ '-',{
					id:"RESOURCE_4040200",
					text : '增加',
					iconCls : 'icon-add',
					handler : function() {
							add();
					}

				}, '-', {
					id:"RESOURCE_4040400",
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						remove();
					}
				}, /*'-', {
					id:"RESOURCE_4040300",
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						edit();
					}
				}, '-', {
					text : '保存',
					iconCls : 'icon-save',
					handler : function() {
						endEdit();
						save();
					}
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
				}, '-' ],*/
				//onClickRow:autoChange,
				/*onAfterEdit : function() {
					//endEdit();
					save();
					datagrid.datagrid("acceptChanges");
					datagrid.datagrid("unselectRow", editRow);
					editRow = undefined;
				},*/
				/*onDblClickRow : function(rowIndex, rowData) {//双击编辑行
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
				}*/
			});
			
//			function unitFormatter(value, rowData, rowIndex) {  
//			    if (value == 0) {  
//			        return "";  
//			    }  
//			    for (var i = 0; i < unitJSON.length; i++) {  
//			        if (unitJSON[i].value == value) {  
//			            return unitJSON[i].name;  
//			        }  
//			    }  
//			    return value;  
//			}     
			
			
			/*function endEdit() {
				var rows = datagrid.datagrid('getRows');
				for ( var i = 0; i < rows.length; i++) {
					datagrid.datagrid('endEdit', i);
				}
			}*/
			/*function tableexport() {
				var url = "../export.do?method=rowSpanExport";
				window.location.href = url;
			}*/
			/*function add() {
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
			}*/
			/*function remove() {
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
								ids.push(rows[i].employeeId);
							}
							console.info(ids.join(','));
							$.ajax({
								url : '/employee/delete.do',//pcbas-analysis/
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
			}*/
			/*function edit() {
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
          }*/
			
			/*function save() {
				var changeRows = datagrid.datagrid('getChanges');

				for (i = 0; i < changeRows.length; i++)
					if (isEmptyObject(changeRows[i])) {
						$.messager.show({
							title : '警告',
							msg : '存在不合法输入'
						});
						return;
					}
				if($('.validatebox-invalid').length!=0){
					$.messager.alert('警告','请按照提示输入正确信息！','error');
					return;
				}
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
					$.post("/employee/save.do", effectRow,//pcbas-analysis/
							function(data) {
								if (data == 'success') {

									$.messager.show({
										title : '提示',
										msg : '保存成功'
									});
									datagrid.datagrid('reload',{}); 
								}else if(data == 'error 用户手机号或邮箱已存在') {
									$.messager.alert('提示','用户手机号或邮箱已存在，请修改后重新保存！','error');
								}else{
									$.messager.alert('提示','2008系统员工编号已存在，请修改后重新保存！','error');
								}
							}, "JSON").error(function() {
						$.messager.show({
							title : '提示',
							msg : '保存失败'
						});
					});
				}
			}*/
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
			
			 
      function toUpper(validatebox)//小写转大写
      {
          var currentWords = $(validatebox).val();
          console.info(currentWords)
          if (currentWords)
          {
              $(validatebox).val($(validatebox).val().toUpperCase());
          }
      }

		});
		
		
/*		function GetCustomer(){//获取客户信息并插入客户信息
			$.ajax({
				url:getContextPath()+'/pc-web/salesys-customer/listAll.do',
				type:"GET",
				success:function(data){
					$.each(data,function(index,ele){
						$("#listAll").append("<option value='"+ele.customerId+"'>"+ele.customerCompany+"</option>");
					})
					
				}
			})
			
		}*/
		
/*		function GetOrganization(){//获取客户信息并插入客户信息
			$.ajax({
				url:getContextPath()+'/organization/listAll.do',
				type:"GET",
				success:function(data){
					$.each(data,function(index,ele){
						$("#listAllDp").append("<option value='"+ele.id+"'>"+ele.name+"</option>");
					})
					
				}
			})
			
		}*/
		
		
	
		/**
		 * 查询，将查询参数不为空的放入JSON传入后台,该写法支持模糊查询
		 */
		function searchActivity(){
//			var departmentId=$("#listAllDp option:selected").attr("value");
//			var customerId=$("#listAll option:selected").attr("value");
			var departmentId = $("#listAllDp").combobox("getValue");
			var customerId = $("#listAll").combobox("getValue"); 
			var queryParams2 = $('#datagrid').datagrid('options').queryParams;  
			
			//createJson("activityType", type);
			if(departmentId.length>0)
				createJson("departmentId", departmentId);
			if(customerId.length>0)
				createJson("customerId", customerId);
			if($('#startDate').datetimebox('getValue').length>0){
				createJson("startDate", $('#startDate').datetimebox('getValue'));
			}
			if($('#endDate').datetimebox('getValue').length>0){
				createJson("endDate", $('#endDate').datetimebox('getValue'));
			}
			
			queryParams2=JSON.stringify(json);
			//alert(queryParams);
			$('#datagrid').datagrid({url:getContextPath()+'/pc-web/salesactivity/departments.do?keys='+queryParams2,});
		    }
		
		/**
		 * 点击清空按钮触发事件，注意将查询JSON置为空
		 */
		function clearActivity(){
		    $('#searchForm').form('clear');
		    json = {};//将查询参数JSON置为空
		    $('#datagrid').datagrid('load', {});
		}/**
		
 * 
 */
		function tableexport() {
			var form=$("#searchForm");
			form.attr("action","/salesys-pc-web/pc-web/salesactivitydepartment/exportExcel.do");
			form.submit();
	}