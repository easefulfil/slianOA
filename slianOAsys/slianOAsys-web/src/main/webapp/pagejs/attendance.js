$(function(){
	init_classes();
	init_datagrid("","","","","","");
    /*
	$("#form1").submit(function(){
		alert("111");
    }); 
    */
});
var attendstart = [{ "value": "1", "text": "正常" }, { "value": "2", "text": "未签到" }, { "value": "3", "text": "迟到" }];
var attendend = [{ "value": "1", "text": "正常" }, { "value": "2", "text": "未签退" },{"value":"3","text":"早退"}];
var employeeName="";
var className="";
var startdate="";
var enddate="";
var departName="";
var attendance_status="";
var attendance_total_status="";
var datagrid;	
var totalPages;
function init_classes(){
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
			$("#1_classes").append(temp);
		},
		"error":function(){
			alert("系统异常-from searchclass");
		}		
	});	
}

function init_datagrid(employeeName,className,startdate,enddate,departName,attendance_total_status){
	$("#1_pageIndex").val("1");
	$("#1_class_value").text(className);
	$("#1_attendance_total_status_value").text(attendance_total_status);
	$("#1_startdate_value").text(startdate);
	$("#1_enddate_value").text(enddate);
	$("#1_departName_value").text(departName);
	
	$("#1_excel_class_value").text(className);
	$("#1_excel_attendance_total_status_value").text(attendance_total_status);
	$("#1_excel_startdate_value").text(startdate);
	$("#1_excel_enddate_value").text(enddate);
	$("#1_excel_departName_value").text(departName);
	
	$.ajax({
		url:"/slianOAsys-admin/attendance/list.do",
		type:"post",
		dataType:"json",
		data:{
			pageindex : 1,
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
			$("#1_totalRows").text(total);
			$("#1_totalPages").text(totalPages);
			listtable(data);
		},
		"error":function(){
			alert("系统异常-from searchattendance!!!!!!!");
		}		
	});	
}
function listtable(data){
	var rows=data.rows;
	console.log(rows);
	var table = $("#datagrid_1");
	//清空表格数据  
	table.find("tr:gt(0)").remove()		
	var temp="";
	for(var i=0;i<rows.length;i++){
		var one = rows[i];
	/*	for (var j = 0; j < attendstart.length; j++) {
	        if (attendstart[j].value == one.attendanceSignstatus) {
	        	var Signstatus= attendstart[j].text;
	        }
	    }
		for (var k = 0; k < attendend.length; k++) {
	        if (attendend[k].value == one.attendanceOffstatus) {
	        	var Offaddress= attendend[k].text;
	        }
	    }
	    */
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
		temp+="<td>"+one.employeeWechat+"</td>";
		temp+="<td>"+one.employeeName+"</td>";
		temp+="<td>"+one.employeeId+"</td>";
		temp+="<td>"+one.departName+"</td>";
		temp+="<td>"+one.attendanceTime+"</td>";
		temp+="<td>"+"正常"+"</td>";
		temp+="<td>"+one.attendanceSigntime+"-"+one.attendanceOfftime+"</td>";
		temp+="<td>"+one.workHour+"</td>";
		temp+="<td>"+one.late+"</td>";
		temp+="<td>"+one.before+"</td>";
		temp+="<td>"+"</td>";
		temp+="<td>"+"</td>";
		temp+="<td>"+"</td>";
		temp+="<td>"+"</td>";
		temp+="<td>"+"</td>";
		temp+="<td>"+one.className+"</td>";
		temp+="<td>"+one.startTime+"-"+one.endTime+"</td>";
		temp+="<td>"+"</td>";
		temp+="<td class='xfcz'>...<div class='cz'>" +
				"<a href='"+url+"' target='_blank'>" +
				"考勤详情</a></div> </td>"
		temp+="</tr>";	
	}
	table.append(temp);
}

function  delete_1(){
	var content = $(".low_1 .form");
	var checkbox = content.find("*[name='id']:checked"); // 被选中的复选框
	var id = [];
	for (var i = 0; i < checkbox.length; i++) {
		id.push($(checkbox[i]).val());
	}
	alert(id);
	$.ajax({
		url:"/slianOAsys-admin/attendance/delete1.do",
		type:"post",
		dataType:"json",
		data:{
			"attendanceid[]":id
			},
		success:function(data){
			alert("删除"+data+"条数据");
		},
		"error":function(){
			alert("系统异常-from delete1!!!!!!!");
		}		
	});	
}
function exportExcel_1(){
	employeeName=$("#1_employeeName").val();
	startdate=$("#Text1").val();
	enddate=$("#Text2").val();
	departName=$("#1_departName").val();
	className=$("#1_classes").val();
	attendance_status=$("#1_attendance_total_status").val();
	if(attendance_status=="正常")
		attendance_total_status=1;
	if(attendance_status=="异常")
		attendance_total_status=2;
	if(attendance_status=="全部")
		attendance_total_status="";
	export_1(employeeName,className,startdate,enddate,departName,attendance_total_status);
}

function export_1(employeeName,className,startdate,enddate,departName,attendance_total_status) {
	window.location.href =
		"/slianOAsys-admin/attendance/exportExcel.do?classname="+className
		+"&employeename="+employeeName
		+"&attendance_total_status="+attendance_total_status
		+"&startdate="+startdate
		+"&enddate="+enddate
		+"&departname="+departName;
}
function searchByEmployee_1(){
	employeeName=$("#1_quicksearch_byemployee").val();
	init_datagrid(employeeName,"","","","","");
}

function searchBycondition_1(){
	employeeName=$("#1_employeeName").val();
	startdate=$("#Text1").val();
	enddate=$("#Text2").val();
	departName=$("#1_departName").val();
	className=$("#1_classes").val();
	attendance_status=$("#1_attendance_total_status").val();
	if(attendance_status=="正常")
		attendance_total_status=1;
	if(attendance_status=="异常")
		attendance_total_status=2;
	if(attendance_status=="全部")
		attendance_total_status="";
	init_datagrid(employeeName,className,startdate,enddate,departName,attendance_total_status);
}


function searchBypage(){
	var pageindex=$("#1_pageIndex").val();
	$.ajax({
		url:"/slianOAsys-admin/attendance/list.do",
		type:"post",
		dataType:"json",
		data:{
			pageindex : pageindex,
			classname:className,
			employeename:employeeName,
			attendance_total_status:attendance_total_status,
			startdate:startdate,
			enddate:enddate,
			departname:departName
			},
		success:function(data){
			console.log(data);
			listtable(data);
		},
		"error":function(){
			alert("系统异常-from searchattendance!!!!!!!");
		}		
	});	
}
function prepage(){
	var page=$("#1_pageIndex").val();
	var pageindex=new Number(page);
	$("#1_pageIndex").val("");
	pageindex=pageindex-1;
	if(pageindex>=1){
		$("#1_pageIndex").val(pageindex);
		searchBypage();
	}
	else{
		$("#1_pageIndex").val(1);
	}
}
function nextpage(){
	var page=$("#1_pageIndex").val();
	var pageindex=new Number(page);
	$("#1_pageIndex").val("");
	pageindex=pageindex+1;
	if(pageindex>totalPages){
		$("#1_pageIndex").val(totalPages);
	}
	else{
		$("#1_pageIndex").val(pageindex);
		searchBypage();
	}
}
function lastpage(){
	$("#1_pageIndex").val("");
	$("#1_pageIndex").val(totalPages);
	searchBypage();
}
//考勤详情
function kqxq(){
	alert("111");
	window.open(
   'details.html','_blank',
   'width=400px,height=600px,top=100px,left=500px'
   )} 

function import_addition_record_excel(){
	alert("import_addition_record_excel");
	var file=$("#importfile1").val();
	
	$.ajax({
		url:"/slianOAsys-admin/attendance/importExcel.do",
		method:"post",
		dataType:"json",
		data:{
			clientFile:file
			},
		success:function(data){
			alert("success import excel!")
		},
		"error":function(){
			alert("系统异常-from import_addition_record_excel");
		}		
	});	
		
}

/*
function modify(){
	var content = $("#datagrid");
	var checkbox = content.find("*[name='id']:checked"); // 被选中的复选框
	var id = [];
	for (var i = 0; i < checkbox.length; i++) {
		id.push($(checkbox[i]).val());
	}
	if(id.length == 0){
		alert("没有选中记录");
		return;
	}
	if(id.length > 1){
		alert("请选择一条数据");
		return;
	}
	$.ajax({
		url:"/slianOAsys-admin/attendance/update.do",
		type:"post",
		dataType:"json",
		data:{
			attendanceid:id[0],
			attendanceSignstatus :2,
			attendanceOffstatus:2
			},
		success:function(rsp){
			alert(rsp);
		},
		"error":function(){
			alert("系统异常-from modifyattendance");
		}		
		
	});	
}
*/