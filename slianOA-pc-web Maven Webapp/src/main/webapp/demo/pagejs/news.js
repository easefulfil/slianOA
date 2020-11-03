
//var yesOrNo=[
//             {ynType:'1',name:'是'},
//             {ynType:'0',name:'否'},
//             ];

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
		fitColumns : false,//设置false页面变窄时显示横向滚动条
		nowarp : false,//表格内容自动折行
		border : false,
		idField : 'id',//翻页选择标记（便于多页删除）
		//sortName : 'id',//设置排序字段
		//sortOrder : 'desc',//设置排序方式，默认升序
		remoteSort: false,//定义是否从服务器给数据排序。
		striped:true,//为true是交替显示行背景
		rowStyler:function(index,row){   
	        if (row.enabled==true){   
	            return 'background-color:#a2c592;';   
	        }
	    },
		url : getContextPath()+'/news/list.do',
		columns : [ [{
			title : '选择框',
			field : 'box',
			width : 90,
//			checkbox:false,
			
		}, {
			field:"id",title:'通知ID',width:100,sortable:true,hidden:true,
		}, {
			field:"newsTitle",title:'通知标题',width:250,sortable:true,
		}, {
			field:"publisher",title:'发布人',width:100,sortable:true,
		},{
			field:"createTime",title:'创建时间',width:130,sortable:true,
		},{
			field:"newsContent",title:'通知内容',width:250,sortable:true,hidden:true
		},{
			field:"attachmentName",title:'附件名称',width:150,sortable:true,hidden:true
		},{
			field:"attachmentUrl",title:'附件链接',width:100,sortable:true,hidden:true
		},{
			field:"viewTimes",title:'查看次数',width:100,
		}
//		, {
//			title : '是否发布',field : 'enabled',width : 65,
//			formatter:function(value){
//				for(var i=0;i<yesOrNo.length;i++){
//					if(yesOrNo[i].ynType==value)
//						return yesOrNo[i].name;
//				}
//				return value;
//			}}
		] ],//合并单元格
		toolbar : [ {
			id : 'RESOURCE_3010200',
			text : '增加',
			iconCls : 'icon-add',
			handler : function() {
				$('#news').dialog({
					title: '编辑通知信息',
					width: 720,
					height: 480,
					closed: false,
					cache: false,
					modal: true,
					maximizable:true,
					resizable:true,
					buttons:[{
						text:'确定增加',
						iconCls:'icon-save',
						handler:function(){
							insertClick();
							
							 datagrid.datagrid('unselectAll');
						}
					}]
					});
				$('#newsForm').form('clear');
				//如果多次调用，会产生多个编辑器实例，因此，使用前需要先销毁已存在的编辑器实例
                if (CKEDITOR.instances['newsContent']) {
                	CKEDITOR.instances['newsContent'].destroy();
                }
//				var editor = CKEDITOR.replace("newsContent");
				var editor = CKEDITOR.replace( 'newsContent',{toolbar : 'Basic' });
				//清空编辑器中的内容
				editor.setData("");
				
			}
		}, '-', {
			id : 'RESOURCE_3010400',
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
			var rows = datagrid.datagrid('getSelections');//获得选中项
			if(rows.length>0){
			$.messager.confirm('请确认','您确定要删除当前选择的所有项吗？',function(b){
			if(b){//选择“确定”
			var ids=[];
			for(i=0;i<rows.length;i++){
			ids.push(rows[i].id);
			}
			console.info(ids.join(','));
			$.ajax({
                url : getContextPath()+'/news/delete.do',
                data : {ids : ids.join(',')},
                dataType : 'json',
                success : function(rsp) {
                	if(rsp=="success"){
                		datagrid.datagrid('reload');
	                    datagrid.datagrid('unselectAll');
                        $.messager.show({
                         title : '提示',
                        msg : '删除成功'
                        });
                	}else{
                		$.messager.confirm("提示","删除失败，请重试！");
                	}
                }
                });
			}
			else{//选择“取消”
				datagrid.datagrid('unselectAll');
			}
			});
			}else{
			$.messager.alert('提示','请选择要删除的记录','error');
			}
			}
		}, '-', {
			id : 'RESOURCE_3010300',
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
				var rows = datagrid.datagrid('getSelections');
				if (rows.length == 1) {
					if (editRow != undefined) {
						datagrid.datagrid('endEdit', editRow);
					}
					if (editRow == undefined) {    
						
						var row = $('#datagrid').datagrid('getSelected');
			            if (row){
			            	$('#news').dialog({
								title: '修改通知内容',
								width: 720,
								height: 480,
								closed: false,
								cache: false,
								modal: true,
								maximizable:true,
								resizable:true,
								buttons:[{
									text:'确定修改',
									iconCls:'icon-save',
									handler:function(){
										updateClick();
										
										
									}
								}]
								});
			            	$('#news').form('load',row); 
			            	//如果多次调用，会产生多个编辑器实例，因此，使用前需要先销毁已存在的编辑器实例
			            	if (CKEDITOR.instances['newsContent']) {
			                	CKEDITOR.instances['newsContent'].destroy();
			                }
//			                var editor = CKEDITOR.replace("newsContent");
			            	var editor = CKEDITOR.replace( 'newsContent',{toolbar : 'Basic' });
			                //动态修改编辑器中的内容
							editor.setData(row.newsContent);
							
			            }
					}
				}
				else if(rows.length>1){                                    
					$.messager.alert('提示','一次只能修改一条记录，请重新选择','error');
					datagrid.datagrid('unselectAll');                     
				}else{                                                    
					$.messager.alert('提示','请选择要修改的记录','error');       
				}                                                       
			}
		}, '-',{
			id : 'RESOURCE_3010100',
			text : '预览',
			iconCls : 'icon-monitor',
			handler : function() {
				var rows = datagrid.datagrid('getSelections');
				if (rows.length == 1) {
					if (editRow != undefined) {
						datagrid.datagrid('endEdit', editRow);
					}
					if (editRow == undefined) {    	
						var row = $('#datagrid').datagrid('getSelected');
			            if (row){
			            	window.open("preview.html?id="+row.id); 
			            }
					}
				}
				else if(rows.length>1){              
					$.messager.alert('提示','只能选择一条记录进行预览！','error');
					datagrid.datagrid('unselectAll');                 
				}else{                                                  
					$.messager.alert('提示','未知错误，请重新尝试预览！','error');      
				}
			}
		} ,'-',{
			text : '取消',
			iconCls : 'icon-undo',
			handler : function() {
				editRow = undefined;
				datagrid.datagrid('rejectChanges');
				datagrid.datagrid('unselectAll');
			}
		}],
	});
});





/**
 * 弹框添加
 */
function insertClick(){ 
	//这样可以获取到ckeditor编辑器中的内容
	for ( instance in CKEDITOR.instances ) 
		CKEDITOR.instances[instance].updateElement(); 
	var news = JSON.stringify($('#newsForm').serializeObject());
	  $.ajax({ 
	      url : getContextPath()+'/news/insert.do', 
	      type : 'POST', 
	      data:{insert:news},
	      dataType : 'json', 
	      async : false,
	      success : function(res) { 
	          if(res=="success"){
	        	  $.messager.alert('系统提示','保存成功！','info');
	        	  $('#news').dialog('close');
	        	  datagrid.datagrid('reload');

	          	  datagrid.datagrid('unselectAll');
	          }
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
	//这样可以获取到ckeditor编辑器中的内容
	for ( instance in CKEDITOR.instances ) 
		CKEDITOR.instances[instance].updateElement(); 
	var news = JSON.stringify($('#newsForm').serializeObject());
    $.ajax({ 
        url : getContextPath()+'/news/update.do', 
        type : 'POST', 
        data:{update:news},
        dataType : 'json', 
        async : false,
        success : function(res) { 
            if(res=="success"){
          	  $.messager.alert('系统提示','修改成功！','info');
          	  $('#news').dialog('close');
          	  datagrid.datagrid('reload');
          	  
          	  datagrid.datagrid('unselectAll');
            }
        }, 
        error : function() { 
            $.messager.alert('系统提示','修改失败,请重试！','warning');
        } 
    }); 
} 


/**
 * 动态往JSON中添加修改数据
 */
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


/**
 * 查询，将查询参数不为空的放入JSON传入后台
 */
function searchNews(){
	var queryParams = $('#datagrid').datagrid('options').queryParams;  
	/*if($("#route").combobox('getValue').length>0){
		createJson("route", $("#route").combobox('getValue'));
	}
	if($("#loadingPortId").combobox('getValue').length>0){
		createJson("loadingPortId", $("#loadingPortId").combobox('getValue'));
	}
	if($("#shippingCompanyId").combobox('getValue').length>0){
		createJson("shippingCompanyId", $("#shippingCompanyId").combobox('getValue'));
	}*/
	if($('#createTime').datetimebox('getValue').length>0){
		createJson("createTime", $('#createTime').datetimebox('getValue'));
	}
	
	queryParams=JSON.stringify(json);
//	alert(queryParams);
	$('#datagrid').datagrid({url:getContextPath()+'/news/list.do?keys='+queryParams,});
	
}

/**
 * 点击清空按钮触发事件，注意将查询JSON置为空
 */
function clearNews(){
    $('#searchForm').form('clear');
    json = {};//将查询参数JSON置为空
    $('#datagrid').datagrid({url:getContextPath()+'/news/list.do',});
    $('#datagrid').datagrid('load', {});
}