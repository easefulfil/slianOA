	$(document).ready(function(){
		var datagrid;
		var editRow = undefined;//行编辑标志
		$(function() {
			datagrid = $('#datagrid').datagrid({
				url : getContextPath()+'/log/list.do',
//				title : '',
//				iconCls : 'icon-save',
//				pagination : true,//进度条
//				pageSize : 10,//每页显示10条
//				pageList : [ 10, 20, 30, 40, 50 ],//选择每页显示条数
//				fit : true,
//				fitColumns : false,//设置false页面变窄时显示横向滚动条
//				nowarp : false,//表格内容自动折行
//				border : false,
//				idField : 'logId',//翻页选择标记（便于多页删除）
//				sortName : 'logId',
//				sortOrder : 'desc',
//				remoteSort: false,
				
				pagination : true,//进度条
				pageSize : 10,//每页显示10条
				pageList : [ 10, 20, 30, 40, 50 ],//选择每页显示条数
				fit : true,
				fitColumns : false,//设置false页面变窄时显示横向滚动条
				nowarp : false,//表格内容自动折行
				border : false,
				idField : 'logId',//翻页选择标记（便于多页删除）
				sortName : 'logId',//设置排序字段
				//sortOrder : 'desc',//设置排序方式，默认升序
				remoteSort: false,//定义是否从服务器给数据排序。
				striped:true,//为true是交替显示行背景
				
				columns : [ [{
	            title:'日志编号',
	            field:'logId',
	            width:60,
	            sortable:true
				},{
	            title:'用户编号',
	            field:'logUserId',
	            width:60,
	            sortable:true
				},{
	            title:'操作内容',
	            field:'logParameters',
	            width:500
				},{
	            title:'操作时间',
	            field:'logTime',
	            width:150,
	            sortable:true
				},{
	            title:'操作类型',
	            field:'logType',
	            width:60
	          } ] ],//合并单元格
			});
		});
	});
	
	//查询数据
	function searchLog(){
		
		var queryParams = $('#datagrid').datagrid('options').queryParams;  
		
		queryParams.keys = JSON.stringify(sy.serializeObject($('#searchForm')));
		
//        queryParams.userId=document.getElementById("userId").value;
//        queryParams.roleId=document.getElementById("roleId").value;
//        queryParams.type=document.getElementById("type").value;
//        queryParams.startTime=$('#startTime').datetimebox('getValue'); 
//        queryParams.endTime=$('#endTime').datetimebox('getValue'); 
//        
        $('#datagrid').datagrid('load', queryParams);
	}
	
	//点击清空按钮触发事件
	function clearLog(){
	    $('#searchForm').form('clear');
	    searchLog();
	}
		
		
		