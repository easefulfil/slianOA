
var $parent = self.parent.$;



function showDocument(row){
	
	var docJSON = getDocument(row.documentId,"VIEW");
	
	if(docJSON == null ){
		
		alert("获取文档失败！");
		return;
	}
		
	
	var labels= $("#document_view_dlg").find("label");
	

	$.each(labels,function(index,label){
		
		$(this).html(docJSON[$(this).attr("name")]);
	});
	
}

var getDocument = function (documentId,type){
	
	var returnValue = null;
	
	 $.ajax({ 
	      url : getContextPath()+'/oaDocument/getContent.do', 
	      type : 'GET', 
	      data:{
	    	  documentId:documentId,
	    	  type:type
	      },
	      dataType : 'json', 
	      contentType: 'application/json',
	      async : false,
	      success : function(docJSON) { 
	    	  returnValue = docJSON;
	      }, 
	      error : function(msg) { 
	          $.messager.alert('系统提示','系统异常，'+msg.statusText,'warning');
	      } 
	  }); 
	 
	 return returnValue;
}

//导出excel
function tableexport() {
	var form=$("#searchForm");
	form.attr("action","/salesys-pc-web/oaDocument/exportExcel.do");
	form.submit();
}

//设置文档编号
function setDefault(type){
	//设置默认值
	$("#businessForm input[name='status']").val('处理中');//状态改为处理中
	$("#docIsEmergency").combobox('setValue',"普通");
	$("#creator").text($.cookie("userName"));
	
	 $("#type").val(type);
	$("#createTime").datetimebox("setValue",$.date.format(new Date(),"yyyy-MM-dd HH:mm:ss"));// HH-mm-ss
	$("#docTime").datebox("setValue",$.date.format(new Date(),"yyyy-MM-dd"));
	
	$('#selectedFile').html('');
	$('#selectedFile1').html('');
	$('#uploadedFile').html('');
	$('#uploadedFile1').html('');
	
	$('#selectedFile').val('');
	$('#selectedFile1').val('');
	$('#uploadedFile').val('');
	$('#uploadedFile1').val('');
	
//	
//	var type =  encodeURI(encodeURI(type));
//
//	
//	  $.ajax({ 
//	      url : getContextPath()+'/oaDocument/newDocument.do?fileType='+type, 
//	      type : 'GET', 
////	      data:{
////	    	  fileType:type
////	      },
//	      dataType : 'json', 
//	      contentType: 'application/json',
//	      async : false,
//	      success : function(docNumberJSON) { 
//	    	  
////	    	  docNumberJSON = JSON.stringify(data);
//	    	  
//	    	  $("#docNumView").html(docNumberJSON.docNumber);
//	    	  $("#docNumber").val(docNumberJSON.docNumber);
//	    	  
//	    	  $("#documentId").val(docNumberJSON.documentId);
//	      }, 
//	      error : function(msg) { 
//	          $.messager.alert('系统提示','生成文件编号失败！','warning');
//	      } 
//	  }); 
}

/**
 * 弹框添加
 */
function insertClick(){ 
	
	if($("#selectedFile").val() != "" &&  $("#uploadedFile").text() == ""){
		
		  $.messager.alert('系统提示','点击上传，上传选定的正文！','info');
		  
		  return;
			
	}
	
	if($("#selectedFile1").val() != "" &&  $("#uploadedFile1").text() == ""){
		
		  $.messager.alert('系统提示','点击上传，上传选定的附件！','info');
		  
		  return;
			
	}
	
	
		
	if($("#businessForm").form('validate')){
		var document = JSON.stringify($('#businessForm').serializeObject());
	//	alert(document);
		  $.ajax({ 
		      url : getContextPath()+'/oaDocument/insert.do', 
		      type : 'POST', 
		      data:{insert:document},
		      dataType : 'json', 
		      async : false,
		      success : function(res) { 
		    	  
		        	  $.messager.alert('系统提示',res=="success"?'申请成功！':res,'info');
		        	  
		        	  $('#document_dlg').dialog('close');
//		        	  clearQuotation();
		        	  datagrid.datagrid('reload');
		        	  datagrid.datagrid('unselectAll'); 

		      }, 
		      error : function() { 
		          $.messager.alert('系统提示','申请失败,请重试！','warning');
		      } 
		  }); 
	}
}  

/**
 * 弹框修改
 */
function updateClick(documentId){


	if($("#selectedFile").val() != "" &&  $("#uploadedFile").text() == ""){
		
		  $.messager.alert('系统提示','点击上传，上传选定的正文！','info');
		  
		  return;
			
	}
	
	if($("#selectedFile1").val() != "" &&  $("#uploadedFile1").text() == ""){
		
		  $.messager.alert('系统提示','点击上传，上传选定的附件！','info');
		  
		  return;
			
	}
	
	var document = JSON.stringify($('#businessForm').serializeObject());
//	alert(document);
    $.ajax({ 
        url : getContextPath()+'/oaDocument/update.do', 
        type : 'POST', 
        dataType : 'json', 
        data:{update:document},
        async : false,
        success : function(res) { 
//            if(res=="success"){
          	  $.messager.alert('系统提示',res=="success"?'申请成功!':res,'info');
          	  $('#document_dlg').dialog('close');
          	  datagrid.datagrid('reload');
          	  datagrid.datagrid('unselectAll'); 
//            }
        }, 
        error : function() { 
            $.messager.alert('系统提示','申请失败,请重试！','warning');
        } 
    }); 
} 

function clearDocumentQuery(businessDgId,type){
	
	$('#queryForm').form('clear');
	
	$("input[name='type']").val(type);
	
	 doQuery(businessDgId)
	
}

//上传附件
function uploadFileForDocument(formId,selectedFile,businessTable,businessId,fileType,showUploadedFileLabelId){
	alert(1);
	alert(formId+'***'+selectedFile+'***'+businessTable+'****'+businessId+'******'+fileType+'****'+showUploadedFileLabelId+'***');
	businessId =3;//获得上传的文件ID
	
	uploadFile(formId,selectedFile,businessTable,businessId,fileType,showUploadedFileLabelId);
}



