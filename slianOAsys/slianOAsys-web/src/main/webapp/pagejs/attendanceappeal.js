function init_appeal(){
	init_datagrid_4("","","","","","");	
}
var employeeName_4="";
var employeeWechat_4="";
var startdate_4="";
var enddate_4="";
var departName_4="";
var appeal_status_4="";
var datagrid_4;	
var totalPages_4;
var handleEmployeeName="";
function init_datagrid_4(employeename,departname,employeewechat,appeal_status,startdate,enddate){
	$("#4_pageIndex").val("1");
	$.ajax({
		url:"/slianOAsys-admin/appeal/list.do",
		type:"post",
		dataType:"json",
		data:{
			pageindex : 1,
			employeename:employeename,
			employeewechat:employeewechat,
			appeal_status:appeal_status,
			startdate:startdate,
			enddate:enddate,
			departname:departname
			},
		success:function(data){
			console.log(data);
			var total=data.total;
			totalPages_4=data.totalPages;
			$("#4_totalRows").text(total);
			$("#4_totalPages").text(totalPages_4);
			listtable_4(data);
		},
		"error":function(){
			alert("系统异常-from searchattendance!!!!!!!");
		}		
	});	
}

function listtable_4(data){
	
	var rows=data.rows;
	console.log(rows);
	var table = $("#datagrid_4");
	//清空表格数据  
	table.find("tr:gt(0)").remove()		
	var temp="";
	for(var i=0;i<rows.length;i++){
		var one = rows[i];
		$.ajax({
			url:"/slianOAsys-admin/appeal/handleEmployeeName.do",
			type:"post",
			dataType:"json",
			data:{
				employeeid:one.handleEmployeeId
				},
			success:function(data){
				console.log(data);
				handleEmployeeName=data.EmployeeName;
				console.log(data.EmployeeName);
			},
			"error":function(){
				alert("系统异常-from handleEmployeeName!!!!!!!");
			}		
		});
		
		var url="appeal.html?employeeName="+one.employeeName
				+"&appealStatus="+one.appealStatus
				+"&appealReason="+one.appealReason
				+"&handleEmployeeName="+handleEmployeeName
				+"&createTime="+one.createTime
		;
		temp+="<tr>";
		temp+="<td><input type='checkbox' name='id' value='"+one.appealId+"' /></td>";
		temp+="<td>"+one.employeeName+"</td>";
		temp+="<td>"+one.employeeWechat+"</td>";
		temp+="<td>"+one.departName+"</td>";
		temp+="<td>"+one.appealTime+"</td>";
		temp+="<td>"+one.abnormalStatus+"</td>";
		temp+="<td>"+one.appealStatus+"</td>";
		temp+="<td><span class='czan2'>操作" +
				"<img src='images/cz.png'></span><div>" +
				"<a href='"+url+"' target='_blank'>申诉详情</a></div></td>"
		temp+="</tr>";	
	}
	table.append(temp);
}
function exportExcel_4(){
	alert("exportExcel_4");
	export_4("","","","","","");
}
function export_4(employeename,departname,employeewechat,appeal_status,startdate,enddate) {
	window.location.href =
		"/slianOAsys-admin/appeal/exportExcel.do?employeename="+employeename 
		+"&departname="+departname
		+"&employeewechat="+employeewechat
		+"&appeal_status="+appeal_status
		+"&startdate="+startdate
		+"&enddate="+enddate;
}
function searchBycondition_4(){
	employeeName_4=$("#employeeName_4").val();
	departName_4=$("#departName_4").val();
	employeeWechat_4=$("#employeeWechat_4").val();
	startdate_4=$("#Text7").val();
	enddate_4=$("#Text8").val();
	appeal_status_4=$("#appeal_status_4").val();
	
	init_datagrid_4(employeeName_4,departName_4,employeeWechat_4,appeal_status_4,startdate_4,enddate_4);
}
