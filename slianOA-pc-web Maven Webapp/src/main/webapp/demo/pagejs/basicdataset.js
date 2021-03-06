/**
 * 组织定义
 */


/**
 * 弹框增加组织
 */
function insertClick(){ 
	
	
	if($("#chineseName").val() =="" ){
		$.messager.alert('系统提示','标有*的为必填项！','warning');
		return;
	}
	
	var bds  = JSON.stringify(sy.serializeObject($('#basicdatasetForm')));
		//var resourcesId=document.getElementById("id").value;
		//检查用户输入的商户编号是否符合要求
		$.ajax({
			  url : getContextPath()+'/basicdataset/insert.do',//resources/insert.do', 
		      type : 'POST', 
		      data:{"bds":bds},
		      dataType : 'json',
		      async : false,
		      success : function(result) { 
		    	  
		          if(result.success){ 
		        	  $('#basicdataset').dialog('close');
		        	  datagrid.treegrid('reload');
		          }
		          
		          $.messager.alert('系统提示',result.msg,result.success ?"info":"error");
		      }, 
		      error : function() { 
		          $.messager.alert('系统提示','保存失败,请重试！','warning');
		      } 
		});
	
}
/**
 * 弹框修改
 */
function updateClick(){
	var bds = JSON.stringify(sy.serializeObject($('#basicdatasetForm')));
//	var theId=document.getElementById("resourceid").value;
    $.ajax({ 
        url : getContextPath()+'/basicdataset/update.do', 
        type : 'POST', 
        data:{"bds":bds},// ,"basicDataId":$('#basicDataId').val()
        dataType : 'json', 
        success : function(res) { 
            if(res){
          	  $.messager.alert('系统提示','修改成功！','info');
          	  $('#basicdataset').dialog('close');
          	  datagrid.treegrid('reload');
            }
        }, 
        error : function() { 
            $.messager.alert('系统提示','修改失败,请重试尝试！','warning');
        } 
    }); 
} 


////
	var datagrid;
	
	var editRow = undefined;// 行编辑标志
//	var enabledSelect=[
//		  	         {enabledType:'1',name:'是'},
//		  	         {enabledType:'0',name:'否'}
//		  	         ];

	
	$(function() {
		//增加和修改的公共弹出框
		$('#basicdataset').dialog({
			title: '编辑组织',
			width: 650,
			height: 250,
			closed: false,
			cache: false,
			modal: true
		}).dialog('close');
		
		datagrid = $('#datagrid').treegrid({
			url :  getContextPath()+'/basicdataset/listBDSTree.do',//list.do',getContextPath()+'/organization/listOSTree.do',
			title : '',
			iconCls : 'icon-save',
//			pagination : true,// 进度条
//			pageSize : 10,// 每页显示10条
//			pageList : [ 10, 20, 30, 40, 50 ],// 选择每页显示条数
			fit : true,
			fitColumns : false,// 设置false页面变窄时显示横向滚动条
			nowarp : false,// 表格内容自动折行
			border : false,
			idField : 'id',// 翻页选择标记（便于多页删除）
			treeField:'text',// 文件夹、文件等图片显示的位置
			rownumbers:true,
			parentField:'parentNodeId',
			remoteSort: false,// 定义是否从服务器给数据排序。
			striped:true,// 为true是交替显示行背景
//			initialState:"collapsed",
			// url : getContextPath()+'/organization/listOSTree.do',
			frozenColumns : [ [{
				field:"id",title:'基本信息编号',width:100,
				hidden:true
			}, {
				field:"text",title:'基本信息名称',width:300
			}]],
			columns:[[
//			{
//				field:"status",title:'状态',width:60,sortable:true,editor:{type:'text'}
//			},{
////				field:"creator",title:'创建者',width:60,sortable:true,editor:{type:'text'}
////			},{
////				field:"accessGroup",title:'访问组',width:60,sortable:true,editor:{type:'text'}
////			},{
////			   field:"createTime",title:'创建时间',width:140,sortable:true
//			},
			{
//			   field:"englishName",title:'类型',width:120,sortable:true
//			},{
			   field:"basicDataType",title:'类型/单位',width:180,sortable:true
			},{
			   field:"basicDataRemark",title:'备注',width:180,sortable:true
//			},{
//			   field:"phone",title:'联系电话',width:100,sortable:true
			} ]] ,// 合并单元格
			toolbar : [{
				text : '展开',
				iconCls : 'icon-open',
				handler : function() {
					openResources();// 展开（组织展开）函数
				}

			}, '-', {
				text : '折叠',
				iconCls : 'icon-close',
				handler : function() {
					foldResources();// 折叠（组织折叠）函数
				}

			}, '-',{
				id:"RESOURCE_4010200",
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					$('#basicdataset').dialog('open');
					$('#basicdatasetForm').form('clear');
					
					document.getElementById("button").innerHTML=
		                "<input type=\"button\" value=\"保存\" onclick=\"insertClick()\">";
					datagrid.datagrid('unselectAll');
					//$("#id").removeAttr("disabled","true");
				}

			}, '-', {
				id:"RESOURCE_4010400",
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					remove();
				}
			}, '-', {
				id:"RESOURCE_4010300",
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
						var rows = datagrid.treegrid('getSelections');
						if (rows.length == 1) {
							if (editRow != undefined) {
								datagrid.treegrid('endEdit', editRow);
							}
							if (editRow == undefined) {    	
								var row = $('#datagrid').treegrid('getSelected');
					            if (row){
					                $('#basicdataset').dialog('open');
					                
					                $('#basicdatasetForm').form('load',row);
					                
					                
					                document.getElementById("button").innerHTML=
					                "<input type=\"button\" value=\"保存\" onclick=\"updateClick()\">";
					                datagrid.treegrid('unselectAll');
					                
//					                $("#id").attr("disabled","true");
					            	//$("#name").combobox("disable");
					            }
							}
						}
						else if(rows.length>1){              
							$.messager.alert('提示','一次只能修改一条记录，请重新选择','error');
							datagrid.treegrid('unselectAll');                 
						}else{                                                  
							$.messager.alert('提示','请选择要修改的记录','error');      
						}                                                        
					//edit();
					/*var rows = datagrid.treegrid('getSelections');
					if (rows.length == 1) {
						if (editRow != undefined) {
							datagrid.treegrid('endEdit', editRow);
						}
						if (editRow == undefined) {    
							var index =datagrid.treegrid('getRowIndex', rows[0]);
							datagrid.treegrid('beginEdit', index);
							editRow = index;
							datagrid.treegrid('unselectAll');
						}
					}
					else if(rows.length>1){                                    // ///////////////////////
						$.messager.alert('提示','一次只能修改一条记录，请重新选择','error');// ///////////////
						datagrid.treegrid('unselectAll');                      // ///////////////
					}else{                                                     // ///////////////
						$.messager.alert('提示','请选择要修改的记录','error');         // ///////////////
					}  */                                                 // ///////////
				}
			}, '-', {
//				id:"RESOURCE_92",
				text : '取消',
				iconCls : 'icon-undo',
				handler : function() {
					datagrid.treegrid('unselectAll');
					if(editRow){
						datagrid.treegrid('cancelEdit',editRow.id);
						editRow=undefined;
					}
				}
			}, '-' , {
				text : '刷新',// 问题：刷新后不能选中！
				iconCls : 'icon-reload',
				handler : function() {
					editRow=undefined;
					$('#datagrid').treegrid('reload');
				}
			}, '-' ],
//			onBeforeExpand:function(row){
//				// 动态设置展开查询的url
//				var url=getContextPath()+'/organization/listOSTree.do';
//				$("#datagrid").treegrid("options").url=url;
//				return true;
//			},
//			onBeforeLoad:function(row,param){
//				if(row){
//					$(this).treegrid('options').url=getContextPath()+'/organization/listOSTree.do';
//				}
//			}, 
			// 当用户编辑完成时触发
			onAfterEdit : function(rowIndex, rowData, changes) {
				console.info(rowData);// 向后台传递的数据
				editRow = undefined;
			},
			// 当用户双击一行时触发
			onDblClickRow : function(rowIndex, rowData) {// 双击编辑行
				if (editRow != undefined) {
					datagrid.treegrid('endEdit', editRow);
				}
				if (editRow == undefined) {

					var rows = datagrid.treegrid('getRows');
					datagrid.treegrid('beginEdit', rowIndex);
					editRow = rowIndex;
				}
			},
			// 在节点展开的时候触发
			onExpand:function(row){
				var children=$('#datagrid').treegrid('getChildren',row.id);
				if(children.length<=0){
					$('#datagrid').treegrid('refresh',row.id);
				}
				// datagrid.treegrid('unselectAll');
			},
			// 在节点折叠的时候触发
			onCollapse:function(row){
				datagrid.treegrid('unselectAll');
			},
		});

	});
	

	function endEdit(){
        var rows = datagrid.treegrid('getRows');
        for ( var i = 0; i < rows.length; i++) {
         datagrid.treegrid('endEdit', i);
        }
       }
	
	// 展开（组织展开）函数
	function openResources(){
		var node=datagrid.treegrid('getSelected');
		if(node){
			datagrid.treegrid('expandAll',node.id);
		}else{
			datagrid.treegrid('expandAll');
		}
	}
	// 折叠（组织折叠）函数
	function foldResources(){
		var node=datagrid.treegrid('getSelected');
		if(node){
			datagrid.treegrid('collapseAll',node.id);
		}else{
			datagrid.treegrid('collapseAll');
		}
	}
	// 增加
	/*
	 * function append() { if (editRow) { $.messager.show({ msg :
	 * '您没有结束之前编辑的数据，请先保存或取消编辑！', title : '提示' }); } else { var node =
	 * datagrid.treegrid('getSelected'); var data = [ { id : '', name : '',
	 * priority : '', url : '', parentid : (node ? node.id : ''), text : '',
	 * enabled : '' } ]; var opts = { parent : data[0].parentid, data : data };
	 * $.ajax({ url : getContextPath()+'/resources/insert.do', data :
	 * data[0], cache : false, dataType : "json", success : function(r) { if
	 * (r.success) { opts.data[0].id=r.obj; datagrid.treegrid('append',
	 * opts); datagrid.treegrid('beginEdit', r.obj); editRow = data[0]; }
	 * else { $.messager.show({ msg : '添加组织失败!', title : '提示' }); } } }); } }
	 */
	// 删除
	function remove() {
		var node = datagrid.treegrid('getSelected');
		if (node) {
			$.messager.confirm('询问', '您确定要删除【' + node.text + '】组织？', function(b) {
				if (b) {
					$.ajax({
						url : getContextPath()+'/basicdataset/delete.do',
						data : {
							id : node.id
						},
						cache : false,
						dataType : "json",
						success : function(r) {
							
//							if (r.success) {

								datagrid.treegrid('load');
								editRow = undefined;
//							}
								$.messager.show({
									msg : r.msg,
									title : '提示'
								});
								
							
						}
					});
				}
			});
		}
		else{$.messager.alert('提示','请选择要删除的记录','error');}
	}