var datagrid;
	
		$(function() {
			
			
			
			datagrid = $('#datagrid').datagrid({
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
				url : getContextPath()+'/pc-web/customer-track/list.do?customerId=190',
				columns : [ [{
					field:"customerTypeName",title:'轨迹名称',width:100,sortable:true,hidden:false,editor:{type:'validatebox',
						options : {
							required : true
						} }
				}, {
					field:"employeeName",title:'操作人',width:120,sortable:true,editor:{type:'validatebox',
						options : {
							required : true
						} }
				},{
					field:"happenTime",title:'发生时间',width:100,sortable:true,editor:{type:'validatebox',options:{required:true}}
				}
				] ]
			});
		});
		
