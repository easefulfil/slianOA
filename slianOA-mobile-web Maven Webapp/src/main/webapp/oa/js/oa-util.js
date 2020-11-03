
var workflowWinHref ="/slianOA-pc-web/oa/workflow-pop.html";
var applybuydetailWinHref ="/slianOA-pc-web/oa/applybuy-asset-detail.html";

var $dgId = undefined;

/* 费用弹窗通过easyui-window的href加载，其中的参数通过正则匹配后进行获取，作进一步操作 */
function getParam(name) {
	
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	
	var currHref = $('#workflowWin').window('options').href;
	var r = currHref.substring(currHref.lastIndexOf('?') + 1, currHref.length).match(reg);
	if (r != null)
		// return unescape(r[2]);
		return unescape(decodeURI(r[2]));
	return null;
}

/* 工作流窗口打开 */
function popWorkflowWin(businessDgId,businessTable,businessId,disableCombox, isFormal) {
	
	var json = {};
	json["businessTable"] = businessTable;
	json["businessId"] = businessId;
	
	json["workflowResult"] = 'POP_VIEW_BY_BUSINESS';//View 弹出框，查看已办理的工作流  encodeURI(encodeURI('已办')) ;//
	
	var queryParams=JSON.stringify(json);

	if ($("#workflowWin").length == 0) {// 动态创建初始化费用窗口所需的div
		
		var oDiv = document.createElement('div');
		oDiv.id = "workflowWin";
		document.body.appendChild(oDiv);
	} else {
		$("#workflowWin").window('open');
	}
	$('#workflowWin').window({
		title : '流转信息',
		iconCls : 'icon-workflow',
		width : 630,
		height : 280,
		modal : true,
		collapsible : false,
		href : workflowWinHref+"?keys="+queryParams //encodeURI(encodeURI(queryParams))
	});
	$('#workflowWin').window('setTitle', "流转信息");//workflowWinTitle
	


	$dgId = $("#" + businessDgId);
	
	$dgId.datagrid('unselectAll');
	
//	if($('#business_dg')[0]!=undefined)//费用录入页面打开录入窗口选中当前行
//		$("#business_dg").datagrid('unselectAll');
}

/* 明细窗口打开 */
function popApplybuyDetailWin(assetChangeId,businessDgId,businessTable,businessId,disableCombox, isFormal) {
	

	if ($("#workflowWin").length == 0) {// 动态创建初始化费用窗口所需的div
		var oDiv = document.createElement('div');
		oDiv.id = "workflowWin";
		document.body.appendChild(oDiv);
	} else {
		$("#workflowWin").window('open');
	}
	$('#workflowWin').window({
		title : '申请明细',
		iconCls : 'icon-workflow',
		width : 630,
		height : 280,
		modal : true,
		collapsible : false,
		href : applybuydetailWinHref+"?assetChangeId="+assetChangeId
	});
	$('#workflowWin').window('setTitle', "申请明细");//workflowWinTitle
/*	


	$dgId = $("#" + businessDgId);
	
	$dgId.datagrid('unselectAll');
	
	if($('#business_dg')[0]!=undefined)//费用录入页面打开录入窗口选中当前行
		$("#business_dg").datagrid('unselectAll');*/
}


/**
 * 查询，将查询参数不为空的放入JSON传入后台
 */
function doQuery(businessDgId){
	//alert(JSON.stringify(sy.serializeObject($('#queryForm'))))
	
	$('#'+businessDgId).datagrid("reload",{"keys":JSON.stringify(sy.serializeObject($('#queryForm')))});
	
}



/**
 * 点击清空按钮触发事件，注意将查询JSON置为空
 */
function clearQuery(businessDgId,url){
    $('#queryForm').form('clear');
 
    $('#'+businessDgId).datagrid('reload', {});
    
    $('#'+businessDgId).datagrid('unSelectAll');
}


function getContextPath(){ 
	return '/slianOA-pc-web';////salesys-pc-web
}

//上传附件
function uploadFile(formId,selectedFile,businessTable,businessId,fileType,showUploadedFileLabelId,wechat){
	
	$Form = $("#" + formId);
	
	//根据上传的文件路径取得文件名称
	str=$('#'+selectedFile).val();
	if(str==''){
		$.messager.alert('系统提示','请先选择要上传的文件！','warning');
		
		
	}else{
		var arr=str.split('\\');//注split可以用字符或字符串分割
		var fileName=arr[arr.length-1];//这就是要取得的文件名称
//		document.getElementById("documentNames").value=filename;
//		document.getElementById("fileName1").value=filename;
		fileName = encodeURI(encodeURI(fileName));
		var fileType =  encodeURI(encodeURI(fileType));
		console.log(wechat);
		$Form.attr("action",getContextPath()+'/mobile-ajax/auth/uploader/uploadFile.do?wechatAccount='+wechat+'&businessTable='+businessTable+"&businessId="+businessId+"&fileName="+fileName+"&fileType="+fileType+"&showUploadedFileLabelId="+showUploadedFileLabelId);
		$Form.form("submit");
		
//		document.forms.uploadForm1.action=getContextPath()+'/uploader/uploadFile.do?businessTable='+businessTable+"&businessId="+businessId;
//		document.forms.uploadForm1.submit();
	}
}

//删除上传的文件
function deleteUploadFile(businessTable,businessId,fileName){
	
	
	
	//alert("businessTable="+businessTable +"businessId="+businessId);
	//todo 删除已保存到数据库中的文件
	
	$.ajax({ 
		url: getContextPath()+'/oaAttachment/delete.do', 
		data:{
			businessTable:businessTable,
			businessId:businessId,
			fileName:fileName
			
		}, 
		success: function(){
			
			//删除文件
			$("."+fileName).remove();

			
		},
		error:function(){
			
			alert("删除失败！");
		}
		
		
	});
}
