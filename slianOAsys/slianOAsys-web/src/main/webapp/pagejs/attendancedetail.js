var signstatus_3="";
var employeeName_3="";
var className_3="";
var startdate_3="";
var enddate_3="";
var departName_3="";
var attendance_total_status_3="";
var totalPages;
function init_classes_3(){
	var temp="";
	temp+="<option>"+""+"</option>";
	$.ajax({
		url:"/slianOAsys-admin/class/list.do",
		type:"post",
		dataType:"json",
		data:{
			pageindex : 1,
			classname:"",
			createstarttime:"",
			createendtime:"",
			classstatus:""
			},
		success:function(data){
			console.log(data);
			var rows=data.rows;
			console.log(rows);
			for(var i=0;i<rows.length;i++){
				var one = rows[i];
				temp+="<option>"+one.className+"</option>";
			}
			$("#3_classes").append(temp);
		},
		"error":function(){
			alert("系统异常-from searchclass");
		}		
	});	
}
function init_detail_YI(){
	signstatus_3=1;
	init_classes_3();
	init_datagrid_3_YI("1","","","","","","");	
}
function init_detail_WEI(){
	signstatus_3=2;
	init_classes_3();
	init_datagrid_3_WEI("2","","","","","","");	
}
function init_datagrid_3_YI(signstatus,className,startdate,enddate,employeeName,attendance_total_status,departName){
	signstatus_3=1;
	$("#3_pageIndex_YI").val("1");
	$.ajax({
		url:"/slianOAsys-admin/attendance/detaillist.do",
		type:"post",
		dataType:"json",
		data:{
			pageindex : 1,
			signstatus:signstatus,
			classname:className,
			employeename:employeeName,
			attendance_total_status:attendance_total_status,
			startdate:startdate,
			enddate:enddate,
			departname:departName
			},
		success:function(data){
			console.log(data);
			var total=data.total;
			totalPages=data.totalPages;
			$("#3_totalRows_YI").text(total);
			$("#3_totalPages_YI").text(totalPages);
			listtable_3_YI(data);
		},
		"error":function(){
			alert("系统异常-from searchattendance!!!!!!!");
		}		
	});	
}
function listtable_3_YI(data){
	var rows=data.rows;
//	console.log(rows);
	var table = $("#datagrid_3_YI");
	//清空表格数据  
	table.find("tr:gt(0)").remove()		
	var temp="";
	for(var i=0;i<rows.length;i++){
		var one = rows[i];
		var TotalStatus="";
		if(one.attendanceTotalStatus=="签到签退"){
			TotalStatus="正常"
		}	
		else{
			TotalStatus="异常"
		}	
		var url="details.html?employeeName="+one.employeeName
		+"&classname="+one.className
		+"&attendanceTime="+one.attendanceTime
		+"&startTime="+one.startTime
		+"&endTime="+one.endTime
		+"&attendanceSigntime="+one.attendanceSigntime
		+"&attendanceOfftime="+one.attendanceOfftime
		+"&attendanceSignaddress="+one.attendanceSignaddress
		+"&attendanceOffaddress="+one.attendanceOffaddress
		+"&workHour="+one.workHour
		;
		temp+="<tr>";
		temp+="<td><input type='checkbox' name='id' value='"+one.attendanceId+"' /></td>";
		temp+="<td>"+one.employeeName+"</td>";
		temp+="<td>"+one.attendanceTime+"</td>";
		temp+="<td>"+TotalStatus+"</td>";
		temp+="<td>"+one.attendanceSigntime+"-"+one.attendanceOfftime+"</td>";
		temp+="<td>"+one.className+"</td>";
		temp+=" <td><span class='czan'>操作<img src='images/cz.png'></span>" +
				"<div><a href='"+url+"' target='_blank'>查看详情</a><a>导出</a></div></td>"
		temp+="</tr>";		
	}
	table.append(temp);
}

function init_datagrid_3_WEI(signstatus,className,startdate,enddate,employeeName,attendance_total_status,departName){
	signstatus_3=2;
	$("#3_pageIndex").val("1");
	$.ajax({
		url:"/slianOAsys-admin/attendance/detaillist.do",
		type:"post",
		dataType:"json",
		data:{
			pageindex : 1,
			signstatus:signstatus,
			classname:className,
			employeename:employeeName,
			attendance_total_status:attendance_total_status,
			startdate:startdate,
			enddate:enddate,
			departname:departName
			},
		success:function(data){
			console.log(data);
			var total=data.total;
			totalPages=data.totalPages;
			$("#3_totalRows_WEI").text(total);
			$("#3_totalPages_WEI").text(totalPages);
			listtable_3_WEI(data);
		},
		"error":function(){
			alert("系统异常-from searchattendance!!!!!!!");
		}		
	});	
}
function listtable_3_WEI(data){
	var rows=data.rows;
	console.log(rows);
	var table = $("#datagrid_3_WEI");
	//清空表格数据  
	table.find("tr:gt(0)").remove()		
	var temp="";
	for(var i=0;i<rows.length;i++){
		var one = rows[i];
		var TotalStatus="";
		if(one.attendanceTotalStatus=="签到签退"){
			TotalStatus="正常"
		}	
		else{
			TotalStatus="异常"
		}
		var url="details.html?employeeName="+one.employeeName
		+"&classname="+one.className
		+"&attendanceTime="+one.attendanceTime
		+"&startTime="+one.startTime
		+"&endTime="+one.endTime
		+"&attendanceSigntime="+one.attendanceSigntime
		+"&attendanceOfftime="+one.attendanceOfftime
		+"&attendanceSignaddress="+one.attendanceSignaddress
		+"&attendanceOffaddress="+one.attendanceOffaddress
		+"&workHour="+one.workHour
		;
		temp+="<tr>";
		temp+="<td><input type='checkbox' name='id' value='"+one.attendanceId+"' /></td>";
		temp+="<td>"+one.employeeName+"</td>";
		temp+="<td>"+one.attendanceTime+"</td>";
		temp+="<td>"+TotalStatus+"</td>";
		temp+="<td>"+"</td>";
		temp+="<td>"+one.className+"</td>";
		temp+=" <td><span class='czan'>操作<img src='images/cz.png'></span></td>"
		temp+="</tr>";		
	}
	table.append(temp);
}

function exportExcel_3(){
	export_3(signstatus_3,"","","","","","");
}

function export_3(signstatus,employeeName,className,startdate,enddate,departName,attendance_total_status) {
	window.location.href =
		"/slianOAsys-admin/attendance/detailExportExcel.do?signstatus="+signstatus 
		+"&classname="+className
		+"&employeename="+employeeName
		+"&attendance_total_status="+attendance_total_status
		+"&startdate="+startdate
		+"&enddate="+enddate
		+"&departname="+departName;
}

function searchBycondition_3(){
	employeeName_3=$("#3_employeeName").val();
	className_3=$("#3_classes").val();
	startdate_3=$("#Text5").val();
	enddate_3=$("#Text6").val();
	departName_3=$("#3_departName").val();
	attendance_total_status_3=$("#3_attendance_total_status").val();
	
	if(signstatus_3==1)
		init_datagrid_3_YI(1,className_3,startdate_3,enddate_3,employeeName_3,attendance_total_status_3,departName_3);
	if(signstatus_3==2)
		init_datagrid_3_WEI(2,className_3,startdate_3,enddate_3,employeeName_3,attendance_total_status_3,departName_3);
}

/*
function prepage(){
	var page=$("#2_pageIndex").val();
	var pageindex=new Number(page);
	$("#2_pageIndex").val("");
	pageindex=pageindex-1;
	if(pageindex>=1){
		$("#2_pageIndex").val(pageindex);
		searchBypage_2();
	}
	else{
		$("#2_pageIndex").val(1);
	}
}
function nextpage(){
	var page=$("#2_pageIndex").val();
	var pageindex=new Number(page);
	$("#2_pageIndex").val("");
	pageindex=pageindex+1;
	if(pageindex>totalPages_2){
		$("#2_pageIndex").val(totalPages_2);
	}
	else{
		$("#2_pageIndex").val(pageindex);
		searchBypage_2();
	}
}
function lastpage(){
	$("#2_pageIndex").val("");
	$("#2_pageIndex").val(totalPages_2);
	searchBypage_2();
}
*/