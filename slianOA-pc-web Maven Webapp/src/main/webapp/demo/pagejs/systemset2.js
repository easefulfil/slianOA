		var datagrid;
		var editRow = undefined;//行编辑标志
//		var authority="";
//		$.ajax({
//			url : "/salesys-pc-web/mobile-ajax/auth/employee/getType.do?wechatAccount="+userId,
//			type : "POST",
//			success: function(data){
//					authority=data.obj;
//			}
//
//		});
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

				$('#dialog_CustomerStatus_set').dialog('close');
				
			});

				$('#btnCancel').click(function(){
					$('#dialog_CustomerStatus_set').window('close');
				});
		});
			
function init_datagrid(){
	
	var employeeType = $.cookie("employeeType");
	
	datagrid = $('#datagrid').datagrid({
		title : '',
		iconCls : 'icon-save',
	    pagination : true,//进度条
		pageSize : 20,//每页显示10条
		pageList : [ 10, 20, 30, 40, 50 ],//选择每页显示条数 
     	fit : true,
		fitColumns : false,//设置false页面变窄时显示横向滚动条
		nowrap : true,//设置为false表格内容自动折行但是影响性能
		border : false,
		striped : true,
		idField : 'customerId',//翻页选择标记（便于多页删除）
		sortName:'customerId',
		sortOrder:'desc',
		remoteSort : false,
		url : getContextPath()+'/pc-web/salesys-customer/list.do',
		columns : [ [{
			title : '选择框',
			field : 'box',
			width : 90,
			checkbox:true,	
		 }, {
			field:"customerId",title:'客户编号',width:100,sortable:true,hidden:true,
		}, 
		{
			field:"customerCompany",title:'公司名称',width:200,sortable:true,editor:{type:'text'}  //customerName
		},{
		   field:"officeAddr",title:'地址',width:250,sortable:false,editor:{type:'text'}
		}, {
			field:"scale",title:'公司规模',width:60,sortable:true,editor:{type:'text'}
		}, {
			field:"attitude",title:'付款态度',width:60,sortable:true,
		},
		{
			field:"customerType",title:'客户状态',width:60,sortable:true,
            formatter: function(value, rowData, rowIndex) {

                return rowData.customerTypeName;
            },
			editor : {
				type : 'combobox',
				options:{
						valueField:'id',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=294',
						editable:false
				}
			}
//			editor:{type:'combobox',options:{required:true,editable:false,data:[{'customerType':'目标客户'},{'customerType':'意向客户'},{'customerType':'成交客户'},{'customerType':'失败客户'},{'customerType':'休眠客户'}],valueField:'customerType',textField:'customerType'}}

		}, {
			field:"type",title:'客户等级',width:60,sortable:true
		},{field:"customerKind",title:'客户类型',width:60,sortable:true,
			
			/*editor:{type:'combobox',options:{required:true,editable:false,data:[{'customerKind':'海运'},
			  {'customerKind':'外贸'},{'customerKind':'报关'},{'customerKind':'仓储'}],valueField:'customerKind',textField:'customerKind'}},*/
			  editor : {
					type : 'combobox',
					options:{
							valueField:'name',
							textField:'name',
							url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=329',
							editable:false
					}
				}
		},
		//for 海运
		
		{
			field:"monthamount",title:'海运箱量',width:60,sortable:true,hidden:(employeeType=="HAIYUN" || employeeType == "ALL")?false:true,
//		editor:{type:'combobox',options:{editable:false,data:[{'monthAmount':'每月箱量：'},{'monthAmount':'0-100'},{'monthAmount':'100-400'},{'monthAmount':'400以上'},
//			{'monthAmount':'每月清关箱量：'},{'monthAmount':'1-10'},{'monthAmount':'11-40'},{'monthAmount':'>40'},{'monthAmount':'每月堆场箱量：'},
//			{'monthAmount':'1-500'},{'monthAmount':'501-2000'},{'monthAmount':'>2000'}],valueField:'monthAmount',textField:'monthAmount'}},
			editor : {
				type : 'combobox',
				options:{
						valueField:'name',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=357',
						editable:false
				}
			}
		}, {
			field:"payType",title:'海运付款方式',width:80,sortable:true,hidden:(employeeType=="HAIYUN" || employeeType == "ALL")?false:true,
			editor : {
				type : 'combobox',
				options:{
						valueField:'name',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=308',
						editable:false
				}
			}
			
//			editor:{type:'combobox',options:{required:true,editable:false,data:[{'payType':'正常'},{'payType':'积极'},{'payType':'拖延'}],valueField:'payType',textField:'payType'}}
		},
		//for 报关
		{
			field:"customerTypeBaoguan",title:'报关客户类别',width:80,sortable:true,hidden:(employeeType=="BAOGUAN" || employeeType == "ALL")?false:true,
		/*	editor:{type:'combobox',options:{editable:false,data:[{'customerTypeBaoguan':'清关'},{'customerTypeBaoguan':'汽车销售'},
	{'customerTypeBaoguan':'汽车进口'}],valueField:'customerTypeBaoguan',textField:'customerTypeBaoguan'}},*/
			editor : {
				type : 'combobox',
				options:{
						valueField:'name',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=336',
						editable:false
				}
			}
		},
		{
			field:"amountBaoguan",title:'清关箱量',width:80,sortable:true,hidden:(employeeType=="BAOGUAN" || employeeType == "ALL")?false:true,
		/*	editor:{type:'combobox',options:{editable:false,data:[{'customerTypeBaoguan':'清关'},{'customerTypeBaoguan':'汽车销售'},
	{'customerTypeBaoguan':'汽车进口'}],valueField:'customerTypeBaoguan',textField:'customerTypeBaoguan'}},*/
			editor : {
				type : 'combobox',
				options:{
						valueField:'name',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=382',
						editable:false
				}
			}
		}, {
			field:"payTypeBaoguan",title:'报关付款方式',width:80,sortable:true,hidden:(employeeType=="BAOGUAN" || employeeType == "ALL")?false:true,
			editor : {
				type : 'combobox',
				options:{
						valueField:'name',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=387',
						editable:false
				}
			}
			
//			editor:{type:'combobox',options:{required:true,editable:false,data:[{'payType':'正常'},{'payType':'积极'},{'payType':'拖延'}],valueField:'payType',textField:'payType'}}
		},
		//for 贸易

		{
			field:"customerCategory",title:'贸易客户类别',width:80,sortable:true,hidden:(employeeType=="MAOYI" || employeeType == "ALL")?false:true,
			/*editor:{type:'combobox',options:{editable:false,data:[{'customerCategory':'贸易类别：'},
		{'customerCategory':'进口'},{'customerCategory':'出口'},{'customerCategory':'代理'},{'customerCategory':'仓储类别：'},{'customerCategory':'堆场客户'},
		{'customerCategory':'进出口装箱仓储'},{'customerCategory':'第三方仓储'}],valueField:'customerCategory',textField:'customerCategory'}},
			*/
		editor : {
				type : 'combobox',
				options:{
						valueField:'name',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=370',
						editable:false
				}
			}
		},
		{
			field:"customerPropertyMaoyi",title:'贸易客户性质',width:100,sortable:true,hidden:(employeeType=="MAOYI" || employeeType == "ALL")?false:true,
			/*editor:{type:'combobox',options:{editable:false,data:[{'customerPropertyMaoyi':'国外客户'},{'customerPropertyMaoyi':'国内工厂'}],
				valueField:'customerPropertyMaoyi',textField:'customerPropertyMaoyi'}},*/
			editor : {
				type : 'combobox',
				options:{
						valueField:'name',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=342',
						editable:false
				}
			}
		}, {
			field:"payTypeMaoyi",title:'贸易付款方式',width:80,sortable:true,hidden:(employeeType=="MAOYI" || employeeType == "ALL")?false:true,
			editor : {
				type : 'combobox',
				options:{
						valueField:'name',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=391',
						editable:false
				}
			}
			
//			editor:{type:'combobox',options:{required:true,editable:false,data:[{'payType':'正常'},{'payType':'积极'},{'payType':'拖延'}],valueField:'payType',textField:'payType'}}
		},
		
		//for 仓储
		{
			field:"customerCategoryCangchu",title:'仓储客户类别',width:100,sortable:true,hidden:(employeeType=="CANGCHU" || employeeType == "ALL")?false:true,
			/*editor:{type:'combobox',options:{editable:false,data:[{'customerCategory':'贸易类别：'},
		{'customerCategory':'进口'},{'customerCategory':'出口'},{'customerCategory':'代理'},{'customerCategory':'仓储类别：'},{'customerCategory':'堆场客户'},
		{'customerCategory':'进出口装箱仓储'},{'customerCategory':'第三方仓储'}],valueField:'customerCategory',textField:'customerCategory'}},
			*/
		editor : {
				type : 'combobox',
				options:{
						valueField:'name',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=375',
						editable:false
				}
			}
		},
		{
			field:"amountCangchu",title:'每月进出口装箱箱量',width:110,sortable:true,hidden:(employeeType=="CANGCHU" || employeeType == "ALL")?false:true,
			/*editor:{type:'combobox',options:{editable:false,data:[{'amountCangchu':'1-30'},
			 {'amountCangchu':'31-50'},{'amountCangchu':'51-100'},{'amountCangchu':'>100'}],valueField:'amountCangchu',textField:'amountCangchu'}},*/
			editor : {
				type : 'combobox',
				options:{
						valueField:'name',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=345',
						editable:false
				}
			}
		}
		,
		{
			field:"amountDuicangCangchu",title:'堆场箱量',width:80,sortable:true,hidden:(employeeType=="CANGCHU" || employeeType == "ALL")?false:true,
			/*editor:{type:'combobox',options:{editable:false,data:[{'amountCangchu':'1-30'},
			 {'amountCangchu':'31-50'},{'amountCangchu':'51-100'},{'amountCangchu':'>100'}],valueField:'amountCangchu',textField:'amountCangchu'}},*/
			editor : {
				type : 'combobox',
				options:{
						valueField:'name',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=366',
						editable:false
				}
			}
		},
		
		{
			field:"areaCangchu",title:'第三方仓储面积',width:100,sortable:true,hidden:(employeeType=="CANGCHU" || employeeType == "ALL")?false:true,
			/*editor:{type:'combobox',options:{editable:false,data:[{'areaCangchu':'1-3000'},{'areaCangchu':'3001-6000'},
			{'areaCangchu':'>6000'}],valueField:'areaCangchu',textField:'areaCangchu'}},*/
			editor : {
				type : 'combobox',
				options:{
						valueField:'name',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=350',
						editable:false
				}
			}
		}, {
			field:"payTypeCangchu",title:'仓储付款方式',width:80,sortable:true,hidden:(employeeType=="CANGCHU" || employeeType == "ALL")?false:true,
			editor : {
				type : 'combobox',
				options:{
						valueField:'name',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=312',
						editable:false
				}
			}
			
//			editor:{type:'combobox',options:{required:true,editable:false,data:[{'payType':'正常'},{'payType':'积极'},{'payType':'拖延'}],valueField:'payType',textField:'payType'}}
		},
		
		{
			field:"customerCellPhone",title:'手机',width:120,sortable:true,editor: {type:'validatebox',
				options : {
					validType : ['mobile'],
					required:false
				}}
		},{
			field:"customerOfficePhone",title:'电话',width:120,sortable:true,editor:{type:'text'}
		},{
			field:"email",title:'邮箱',width:120,sortable:true,editor:{type:'validatebox',options:{validType:['email']}}
		},{
			field:"customerQq",title:'QQ',width:120,sortable:true,editor:{type:'text'}
//		},{
//			field:"weixinName",title:'微信帐号名称',width:120,sortable:true,editor:{type:'text'}
			
		},{
			field:"cuonterManName",title:'负责人',width:80,sortable:true
		
//		},{
//		   field:"customerCreator",title:'录入人',width:80,sortable:true,editor:{type:'text'}
		},{
		   field:"customerCreationTime",title:'录入时间',width:80,sortable:true, 
		},{
		   field:"customerStatus",title:'状态',width:60,sortable:true,
		 /*  editor:{type:'combobox',options:{required:true,editable:false,data:[{'status':'正常'},{'status':'封停'}],valueField:'status',textField:'status'}}*/
		   editor : {
				type : 'combobox',
				options:{
						valueField:'name',
						textField:'name',
						url:getContextPath()+'/basicdataset/getBasicDataName.do?parentId=354',
						editable:false
				}
			}
		
		},{
			   field:"hy2008CustomerId",title:'2008系统客户编号',width:125,sortable:true,editor:{type:'text'}
		},{
			   field:"remark",title:'备注',width:120,sortable:true,editor:{type:'text'}
		},{
			   field:"customerPhoto",title:'图片',width:125,sortable:true,editor:{type:'text'},
					formatter:
							function(val,row){
								if(val == "" || val =="undefined")
									return '';
								else{
									var photos = val.split(",");
									
									photos_URL ="";
									$.each(photos,function(i ,photo){
										
										photos_URL += '<a target="_blank" href="'+photo+'">图片'+(i+1)+'</a>  ';
										
										
									});
									
									return photos_URL;
								}
					
						}
		}] ],//合并单元格
		view:detailview,
			detailFormatter:function(index,row){
				 return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
	        },
	        onExpandRow: function(index,row){
	          $('#ddv-'+index).datagrid({
	             queryParams:{
	            	 customerId:row.customerId

	          },
	        method: "get",
	        url: getContextPath()+'/pc-web/customer-employee/list.do',
	        fitColumns:true,
	        singleSelect:true,
	        rownumbers:true,
	        loadMsg:'',
	        height:'auto',
	        columns: [[
	                   { field:'customerEmployeeId', title: '联系人ID', width: 80, hidden:true,sortable: true,halign:'center',},
	                   { field:'cname', title: '联系人姓名', width: 80, sortable: true,halign:'center',},
	                   { field:'sex', title: '性别', width: 30, sortable: true,halign:'center',},
	                   { field:'mobile', title: '手机', width: 80, sortable: true,halign:'center',},
	                   { field:'hometel', title: '座机', width: 80, sortable: true,halign:'center',},
	                   { field:'duty', title: '职位', width: 80, sortable: true,halign:'center',},

	                   { field : 'operate',title : '操作',width : 100,sortable : true,
	   						formatter:
//	   							function(){return '<a class="l-btn l-btn-plain easyui-tooltips" href="javascript:void(0)" title="点击这里查看和修改其他费用" onclick="otherfee(\'' + row.id+ '\')">其他费用</a>'},
	   							function(val,row){
	   							return "<a class='l-btn l-btn-plain easyui-tooltips' href='javascript:void(0)' title=修改联系人信息' onclick=\"showDiv_customerEmployee('update','"+ 
	   										row.customerEmployeeId+ "','"+row.cname+"','"+row.sex+"','"+row.mobile+"','"+row.hometel+"','"+row.duty+"')\">修改</a>" +
	   							'&nbsp;&nbsp;<a class="l-btn l-btn-plain easyui-tooltips" href="javascript:void(0)" title="删除联系人信息" onclick="deleteCustomerEmployee(\'' + row.customerEmployeeId+ '\')">删除</a>'
	   							
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
		toolbar : [  {
			id:"RESOURCE_4050600",
			text : '付款态度',
			iconCls : 'icon-head1',
			handler : function() {
				var rows = datagrid.datagrid('getSelections');
				
				if(rows.length <1){
					$.messager.alert('提示','请选择设置的客户','error');// ///////////////
					return;
				}
				
				$('#dialog_CustomerStatus_set').dialog({
					title: '付款态度',
					width: 300,
					height:150,
					closed: false,
					cache: false,
					modal: true
					});
				
			}
		},'-',{
		
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
		},
		onBeforeLoad:function(param){

	        editRow = undefined;//行编辑标志
			
			$.cookie("employeeType");
		}
	});
}


//插入时data为userId，修改时data 为customerEmployeeId
function showDiv_customerEmployee(operType,customerEmployeeId,cname,sex,mobile,hometel,duty){
	
	var rows = datagrid.datagrid('getSelections');

	if(!isSelectedOneRow(rows))
		return false;
	
	//清空input值
	$.each($('#div_customerEmployee input'),function(){
		
		$(this).val('');
	});
	
//	if(operType == 'insert'){
////		$("#operType").val("insert");
//		$("#userId").val(rows[0].id);
//
//	}
	
	var title = "新建联系人";
	
	if(operType == 'update'){
		$("#operType").val("update");
		$("#customerEmployeeId").val(customerEmployeeId);
		$("#customerEmployee_cname").val(cname);
		$('#sex').combobox('setValue',sex); 
		$("#customerEmployee_mobile").val(mobile);
		$("#hometel").val(hometel);
//		$("#type").val(type);
		$("#duty").val(duty);
	
		title = "修改联系人";
		
	}else{
		var employeeType = $.cookie("employeeType");
		if(employeeType=="HAIYUN"){
			$('#duty').combobox({    
			    url:'pagejs/combobox_data.json',    
			    valueField:'id',    
			    textField:'text'   
			});
		}
		$("#customerId").val(rows[0].customerId);
	}
		
	$('#div_customerEmployee').dialog({
		title: title,
		width: 400,
		height:300,
		closed: false,
		cache: false,
		modal: true
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
		$.messager.alert('提示','一次只能为一个客户进行操作，请重新选择','error');
		datagrid.datagrid('unselectAll');       
		return false;
	}else{                                                
		$.messager.alert('提示','请选择要修改的记录','error');       
		return false;
	}
}

function deleteCustomerEmployee(id){
	var rows = datagrid.datagrid('getSelections');

	if(!isSelectedOneRow(rows))
		return false;
	
		
		if(!confirm("确定删除客户联系人？") )
			return;
		
		
		
	    $.ajax({ 
	        url : getContextPath()+'/pc-web/customer-employee/delete.do', 
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

//修改密码
function saveCustomerEmployee() {

    if ( $('#customerEmployee_cname').val() == '') {
        alert('用户名不能为空！');
        return false;
    }
    
    if ($('#sex').combobox('getValue') == '') {
    	alert('性别不能为空！');
        return false;
    }
    
    if ($('#customerEmployee_mobile').val() == '') {
    	alert('手机号不能空！');
        return false;
    }
    
    //
    var ce = JSON.stringify(sy.serializeObject($('#customerEmployee')));
    
    ce = ce.replaceAll("customerEmployee_","");
    
//    ce.replace("customerEmployee_","");
    
    
    if ($('#operType').val() == 'update') {
    	
    	   $.ajax({ 
    	        url : getContextPath()+'/pc-web/customer-employee/save.do',  
    	        data:{
    	        	"updated":"["+ce +"]",
    	        },
    	        type : 'POST', 
    	        dataType : 'json', 
    	        success : function(rsp) { 
    	        	if(rsp.success){
    	        		$('#div_customerEmployee').window('close');
    	            	$.messager.alert("提示",rsp.msg);
    	            	datagrid.datagrid('load');
    	            	datagrid.datagrid('unSelectAll');
    	        	}else
    	        		$.messager.alert("提示",rsp.msg);
    	        	
    	        },
    	        error:function(XMLHttpRequest, textStatus, errorThrown){
    		          //通常情况下textStatus和errorThrown只有其中一个包含信息
    		          this;   //调用本次ajax请求时传递的options参数
    		          alert(textStatus + errorThrown);
    		       }
    	    });
    	   return false;
    }
    
  

    $.ajax({ 
        url : getContextPath()+'/pc-web/customer-employee/save.do',  
        data:{
        	"inserted":"["+ce +"]",
        },
        type : 'POST', 
        dataType : 'json', 
        success : function(rsp) { 
        	if(rsp.success){
        		$('#div_customerEmployee').window('close');
            	$.messager.alert("提示",rsp.msg);
            	datagrid.datagrid('load');
            	datagrid.datagrid('unSelectAll');
        	}else
        		$.messager.alert("提示",rsp.msg);
        	
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
	          //通常情况下textStatus和errorThrown只有其中一个包含信息
	          this;   //调用本次ajax请求时传递的options参数
	          alert(textStatus + errorThrown);
	       }
    });

}


function setCustomerType(customerIds,type){
	

	$.ajax({
		type : 'POST',
		url : getContextPath() +'/customer/setAttitude.do',///pcbas-analysis
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
			var url = getContextPath() + "../export.do?method=rowSpanExport";
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
							url : getContextPath() + '/customer/delete.do',//pcbas-analysis
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


			if (changeRows.length <1) 
				return;
//			{
				var inserted = datagrid.datagrid('getChanges', "inserted");
				var updated = datagrid.datagrid('getChanges', "updated");
				var effectRow = new Object();
				if (inserted.length) {
//					effectRow["inserted"] = JSON.stringify(inserted);
					effectRow["inserted"] = JSON.stringify(inserted).replace("\"salesysCustomerEmployees\":[],","");//移出不需要的属性
				}
				if (updated.length) {
//					effectRow["updated"] = JSON.stringify(updated);
					effectRow["updated"]  = JSON.stringify(updated).replace("\"salesysCustomerEmployees\":[],","");//移出不需要的属性
				}
				
				
			
				
				$.post(getContextPath() + "/pc-web/salesys-customer/save.do", effectRow,//pcbas-analysis/
						function(data) {
							if (data.success == true) {
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
//			}
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
			para.cuonterManName=$("#counterman").combobox("getText");
			para.counterManDepartment=$("#department").combobox("getValue");
		}

		function searchCustomer(){
			var para = sy.serializeObject($('#searchForm'));
//			para.cuonterManName=$("#counterman").combobox("getText");
//			para.counterManDepartment=$("#department").combobox("getValue");
			$('#datagrid').datagrid('load', para);
		
		
		}
		
		/**
		 * 点击清空按钮触发事件，注意将查询JSON置为空
		 */
		function clearCustomer(){

		    $('#searchForm').form('clear');
		    $('#datagrid').datagrid({url:getContextPath()+'/pc-web/salesys-customer/list.do',});
		    $('#datagrid').datagrid('load', {});
		}
		
function show_dialog_customer_track(customerId){ // 打开任务窗口
			
			$('#dialog_customer_track').dialog({
				title: '显示客户轨迹',
				width: 600,
				height: 400,
				closed: false,
				cache: false,
				modal: true
				});
					
			$('#customer_track').datagrid({
				
				title : '',
				iconCls : 'icon-save',
// pagination : true,//进度条
// pageSize : 10,//每页显示10条
// pageList : [ 10, 20, 30, 40, 50 ],//选择每页显示条数
    	     	fit : true,
				fitColumns : true,// 设置false页面变窄时显示横向滚动条
				nowrap : true,// 设置为false表格内容自动折行但是影响性能
				border : false,
				striped : true,
// idField : 'trackId',//翻页选择标记（便于多页删除）
		  
				remoteSort : false,
				url : getContextPath()+'/pc-web/customer-track/list.do?customerId='+customerId,
				columns : [ [{
					field:"customerTypeName",title:'轨迹名称',width:80,sortable:true,hidden:false,editor:{type:'validatebox',
						options : {
							required : true
						} }
				}, {
					field:"employeeName",title:'操作人',width:60,sortable:true,editor:{type:'validatebox',
						options : {
							required : true
						} }
				},{
					field:"happenTime",title:'发生时间',width:80,sortable:true,editor:{type:'validatebox',options:{required:true}}
				},{
					field:"salesysWorkreport",title:'工作汇报',width:180,sortable:true,editor:{type:'validatebox',options:{required:true}}
				}
				,{
					field:"reportTime",title:'汇报时间',width:120,sortable:true,editor:{type:'validatebox',options:{required:true}}
				}
				] ]
			

					});

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
//				width : 300,
				fitColumns : false,// 设置false页面变窄时显示横向滚动条
				nowarp : false,// 表格内容自动折行
				border : false,
				sortName:"employeeId",
				singleSelect:true,
//				idField : 'id',// 翻页选择标记（便于多页删除）
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
//					hidden : true
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
//					id:"RESOURCE_112",
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
		
		var url = getContextPath()+'/quotationrank/insert.do';//pcbas-analysis/
		
		//C-F等级设置
		if($('#rankLevelSetType').val() == 'CDEF')
			url = getContextPath()+'/quotationrank/insertAboveC.do';//pcbas-analysis/
		
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

	
	
	

		

	
