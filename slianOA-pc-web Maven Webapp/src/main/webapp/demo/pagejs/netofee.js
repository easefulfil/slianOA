  

var datagrid;
var editRow = undefined;//行编辑标志
$(function() {
	datagrid = $('#datagrid').datagrid({
		title : '',
		iconCls : 'icon-save',
		pagination : true,//进度条
		pageSize : 20,//每页显示10条
		pageList : [ 10, 20, 30, 40, 50 ],//选择每页显示条数
		fit : true,
		fitColumns : false,//设置false页面变窄时显示横向滚动条
		nowarp : false,//表格内容自动折行
		border : false,
		idField : 'netoId',//翻页选择标记（便于多页删除）
	 
		remoteSort: false,//定义是否从服务器给数据排序。
		striped:true,//为true是交替显示行背景
		url : getContextPath()+'/netofee/list.do',
		columns : [ [{
			title : '选择框',
			field : 'box',
			width : 90,
			checkbox:true,
			
		}, {
			field:"netoId",title:'内托ID',width:100,sortable:true,hidden:true,
		}, {
			field:"netoName",title:'内托标题',width:150,sortable:true,
		}, {
			field:"employeeName",title:'录入人',width:100,sortable:true,
		},{
			field:"netoDetails",title:'内托详情',width:250,sortable:true,hidden:true
		},{
			field:"fileName",title:'附件名称',width:250,sortable:true,
		},{
			field:"fileUrl",title:'附件链接',width:300,sortable:true,
		},{
			field:"netoCreateTime",title:'录入时间',width:130,sortable:true,
		},{
		   field:"accessGroup",title:'权限组',width:100,sortable:true,hidden:true
		}] ],//合并单元格
		toolbar : [ {
			id : 'RESOURCE_1030200',
			text : '增加',
			iconCls : 'icon-add',
			handler : function() {
				$('#netofee').dialog({
					title: '增加内托信息',
					width: 510,
					height: 210,
					closed: false,
					cache: false,
					modal: true,
					buttons:[{
						text:'确定增加',
						iconCls:'icon-save',
						handler:function(){
							insertClick();
						}
					}]
				});
				
				$('#NtyjbForm').form('clear');
				$('#netoForm').form('clear');
				
			}
		}, '-', {
			id : 'RESOURCE_1030400',
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
			var rows = datagrid.datagrid('getSelections');//获得选中项
			if(rows.length>0){
			$.messager.confirm('请确认','您确定要删除当前选择的所有项吗？',function(b){
			if(b){//选择“确定”
			var ids=[];
			for(i=0;i<rows.length;i++){
			ids.push(rows[i].netoId);
			}
			console.info(ids.join(','));
			$.ajax({
                url : getContextPath()+'/netofee/delete.do',
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
			id : 'RESOURCE_1030300',
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
			            	$('#netofee').dialog({
								title: '修改内托信息',
								width: 510,
								height: 210,
								closed: false,
								cache: false,
								modal: true,
								buttons:[{
									text:'确定修改',
									iconCls:'icon-save',
									handler:function(){
										updateClick();
									}
								}]
							});
			            	
			            	$('#netofee').form('load',row); 
							
			            }
					}
				}
				else if(rows.length>1){                                    
					$.messager.alert('提示','一次只能修改一条记录，请重新选择','error');
					$('#datagrid').datagrid('unselectAll');                     
				}else{                                                    
					$.messager.alert('提示','请选择要修改的记录','error');       
				}                                                       
			}
		}, '-' , {
			id : 'RESOURCE_1030100',
			text : '查看详情',
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
			            	$('#netofeePre').dialog({
								title: '内托信息',
								width: 510,
								height: 130,
								closed: false,
								cache: false,
								modal: true,
								buttons:false
							});
			            	
			            	$('#netofeePre').form('load',row);
			            	if(row.fileUrl.length>0){
			            		/*$('#fileUrl1').attr('href',row.fileUrl);
			            		$('#fileUrl1').attr('download',row.netoName);
				            	$("#fileUrl1").text('请点击下载内托运价信息');*/
				            	
//			            		$("#fileUrl1").html("<a href="+row.fileUrl+" target='_blank' style='text-decoration: underline; color:#0000ff;'>点击下载内托运价</a>");
				            		$("#fileUrl1").html("<a href='"+row.fileUrl+"' download='"+row.netoName+"' target='_blank' style='text-decoration: underline; color:#0000ff;'>点击下载内托运价</a>");
				            	}else{
				            		$("#fileUrl1").html("暂无附件");
				            	}
			            	/*}else{
			            		$('#fileUrl1').attr('href','#');
				            	$("#fileUrl1").text('暂无附件');
			            	}*/
							
			            }
					}
				}
				else if(rows.length>1){                                    
					$.messager.alert('提示','一次只能查看一条记录，请重新选择！','error');
					$('#datagrid').datagrid('unselectAll');                     
				}else{                                                    
					$.messager.alert('提示','请选择要查看的记录！','error');       
				}                                                       
			}
		},'-',{
			text : '取消',
			iconCls : 'icon-undo',
			handler : function() {
				editRow = undefined;
				datagrid.datagrid('rejectChanges');
				datagrid.datagrid('unselectAll');
			}
		}],
		// 当用户双击一行时触发
		onDblClickRow : function(rowIndex, rowData) {// 双击编辑行
			if (editRow != undefined) {
				$('#datagrid').datagrid('endEdit', editRow);
			}
			if (editRow == undefined) {
				$('#netofeePre').dialog({
					title: '内托信息',
					width: 510,
					height: 130,
					closed: false,
					cache: false,
					modal: true,
					buttons:false
				});
            	
            	$('#netofeePre').form('load',rowData);
            	if(rowData.fileUrl.length>0){
            		/*$('#fileUrl1').attr('href',rowData.fileUrl);
	            	$("#fileUrl1").text('请点击下载内托运价信息');
            	}else{
            		$('#fileUrl1').attr('href','#');
	            	$("#fileUrl1").text('暂无附件');
            	}*/
            		$("#fileUrl1").html("<a href='"+rowData.fileUrl+"' download='"+rowData.netoName+"' target='_blank' style='text-decoration: underline; color:#0000ff;'>点击下载内托运价</a>");
            	}else{
            		$("#fileUrl1").html("暂无附件");
            	}
			}
		}
	});
});




/**
 * 弹框添加
 */
function insertClick(){ 
	if($("#NtyjbForm").form('validate')){
	var netofee = JSON.stringify($('#netoForm').serializeObject());
//	alert(netofee);
	  $.ajax({ 
	      url : getContextPath()+'/netofee/insert.do', 
	      type : 'POST', 
	      data:{insert:netofee},
	      dataType : 'json', 
	      async : false,
	      success : function(res) { 
	          if(res=="success"){
	        	  $.messager.alert('系统提示','保存成功！','info');
	        	  
	        	  $('#netofee').dialog('close');
	        	  datagrid.datagrid('reload');
	          }
	      }, 
	      error : function() { 
	          $.messager.alert('系统提示','保存失败,请重试！','warning');
	      } 
	  }); 
	}
}  


function uploadFile(){
	//根据上传的文件路径取得文件名称
	str=$('#selectedFile').val();
	if(str==''){
		$.messager.alert('系统提示','请先选择要上传的文件！','warning');
	}else{
		var arr=str.split('\\');//注split可以用字符或字符串分割
		var filename=arr[arr.length-1];//这就是要取得的文件名称
		document.getElementById("netoNames").value=filename;
		document.getElementById("fileName1").value=filename;
		
		document.forms.NtyjbForm.action=getContextPath()+'/uploader/uploadFile.do';
		document.forms.NtyjbForm.submit();
	}
}

/**
 * 弹框修改
 */
function updateClick(){
	var neto = JSON.stringify($('#netoForm').serializeObject());
//	alert(neto);
    $.ajax({ 
        url : getContextPath()+'/netofee/update.do', 
        type : 'POST', 
        data:{update:neto},
        dataType : 'json', 
        async : false,
        success : function(res) { 
            if(res=="success"){
          	  $.messager.alert('系统提示','修改成功！','info');
          	  $('#netofee').dialog('close');
          	  $('#datagrid').datagrid('reload');
          	  $('#datagrid').datagrid('unselectAll');   
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
function searchNeto(){
	var queryParams = $('#datagrid').datagrid('options').queryParams;  
	
	if($('#netoName').val().length>0){
		createJson("netoName", $("#netoName").val());
	}else{
		createJson("netoName", '');
	}
	if($('#startDate').datetimebox('getValue').length>0){
		createJson("startDate", $('#startDate').datetimebox('getValue'));
	}
	if($('#endDate').datetimebox('getValue').length>0){
		createJson("endDate", $('#endDate').datetimebox('getValue'));
	}
	
	queryParams=JSON.stringify(json);
//	alert(queryParams);
	$('#datagrid').datagrid({url:getContextPath()+'/netofee/list.do?keys='+queryParams,});
	
}

/**
 * 点击清空按钮触发事件，注意将查询JSON置为空
 */
function clearNeto(){
    $('#searchForm').form('clear');
    json = {};//将查询参数JSON置为空
    $('#datagrid').datagrid({url:getContextPath()+'/netofee/list.do',});
    $('#datagrid').datagrid('load', {});
}