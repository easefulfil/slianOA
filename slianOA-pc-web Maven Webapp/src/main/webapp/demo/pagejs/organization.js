		var datagrid;
		var editRow = undefined;//行编辑标志
		$(function() {
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
				idField : 'id',//翻页选择标记（便于多页删除）
		  
				remoteSort : false,
				url : getContextPath()+'/organization/listOSTree.do',//list.do',
				columns : [ [{
					title : '选择框',
					field : 'box',
					width : 90,
					checkbox:true,	
				 }, {
					field:"id",title:'编号',width:100,sortable:true,hidden:true,
				}, {
					field:"superior",title:'上级部门',width:80,sortable:true,editor:{type:'text'}
				}, {
					field:"name",title:'部门名称',width:200,sortable:true,editor:{type:'text'}
				},{
					field:"status",title:'状态',width:60,sortable:true,editor:{type:'text'}
				},{
					field:"creator",title:'创建者',width:60,sortable:true,editor:{type:'text'}
				},{
					field:"accessGroup",title:'访问组',width:60,sortable:true,editor:{type:'text'}
				},{
				   field:"createTime",title:'创建时间',width:140,sortable:true
				},{
				   field:"address",title:'地址',width:160,sortable:true,editor:{type:'text'}
				},{
				   field:"phone",title:'联系电话',width:100,sortable:true,editor:{type:'text'}
				},{
				   field:"head",title:'部门领导',width:80,sortable:true,editor:{type:'text'}
//				},{
//				   field:"contacts",title:'联系人',width:80,sortable:true,editor:{type:'text'}
				} ] ],//合并单元格
				toolbar : [ {
					id:"RESOURCE_4030200",
					text : '增加',
					iconCls : 'icon-add',
					handler : function() {
						add();
					}

				}, '-', {
					id:"RESOURCE_4030400",
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						remove();
					}
				}, '-', {
					id:"RESOURCE_4030300",
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						edit();
					}
				}, '-', {
					id:"RESOURCE_92",
					text : '保存',
					iconCls : 'icon-save',
					handler : function() {
						endEdit();
						save();
					}
				}, '-',   {
					id:"RESOURCE_92",
					text : '取消',
					iconCls : 'icon-redo',
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
								ids.push(rows[i].id);
							}
							console.info(ids.join(','));
							$.ajax({
								url : '/organization/delete.do',//pcbas-analysis/
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
					$.post("/organization/save.do", effectRow,//pcbas-analysis/
							function(data) {
								if (data == 'success') {

									$.messager.show({
										title : '提示',
										msg : '保存成功'
									});
									 
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
		
		
	
		/**
		 * 查询，将查询参数不为空的放入JSON传入后台,该写法支持模糊查询
		 */
		function searchOrganization(){
			$('#datagrid').datagrid('load', sy.serializeObject($('#searchForm')));
		    }
		
		/**
		 * 点击清空按钮触发事件，注意将查询JSON置为空
		 */
		function clearOrganization(){
		    $('#searchForm').form('clear');
		    json = {};//将查询参数JSON置为空
		    $('#datagrid').datagrid({url:getContextPath()+'/organization/list.do',});
		    $('#datagrid').datagrid('load', {});
		}