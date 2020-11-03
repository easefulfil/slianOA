var employeeName_2="";
var className_2="";
var startdate_2="";
var enddate_2="";
var departName_2="";
var totalPages_2;
var total_2;
var current_date;
var pre_date ;
function init_month(){
	init_classes_2();
	var d = new Date();
	var year=d.getFullYear();
	var month=d.getMonth()+1;
	var day=d.getDate();
	var preyear="";
	var premonth="";                              
	var preday="";
	if(month>1){
		premonth=month-1;
		preyear=year;
	}	
	else{
		premonth=12;
		preyear=year-1;
	}
	if(day<28&&day>1)
		preday=day;	
	else if(day==1)
		preday=day;
	else if(day>28)
		preday=day-5;
	
	if(month<10)
		var date_month='0'+month;		
	else
		var date_month=month;
	if(day<10)
		var date_day='0'+day;	
	else
		var date_day=day;
	
	if(premonth<10)
		var pre_date_month='0'+premonth;		
	else
		var predate_month=premonth;
	if(preday<10)
		var pre_date_day='0'+preday;	
	else
		var pre_date_day=preday;
	current_date = year+"-"+date_month+"-"+date_day;
	pre_date = preyear+"-"+pre_date_month+"-"+pre_date_day;	
//	alert(current_date);
//	alert(pre_date);
	$("#Text3").val(pre_date);
	$("#Text4").val(current_date);
	init_datagrid_2("",pre_date,current_date,"","");	
}
function init_classes_2(){
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
			$("#2_classes").append(temp);
		},
		"error":function(){
			alert("系统异常-from searchclass");
		}		
	});	
}

function init_datagrid_2(className,startdate,enddate,employeeName,departName){
	$("#2_pageIndex").val("1");
	$("#2_class_value").text(className);
	$("#2_startdate_value").text(startdate);
	$("#2_enddate_value").text(enddate);
	$("#2_departName_value").text(departName);
	$("#Text3").text(startdate);
	$("#Text4").text(enddate);
	$.ajax({
		url:"/slianOAsys-admin/attendance/monthlist.do",
		type:"post",
		dataType:"json",
		data:{
			pageindex : 1,
			className:className,
			startdate:startdate,
			enddate:enddate,
			employeeName:employeeName,
			departName:departName
			},
		success:function(data){
		//	alert("datagrid");
			console.log("datagrid:"+data);
			total_2=data.total;
		//	totalPages_2=data.totalPages;
			$("#2_totalRows").text(total_2);
		//	$("#2_totalPages").text(totalPages_2);
			listtable_2(data);
		},
		"error":function(){
			alert("系统异常-from searchattendance!!!!");
		}	
	});	
}
function listtable_2(data){
	var rows=data.rows;
	console.log(rows);
	var table = $("#datagrid_2");
	//清空表格数据  
	table.find("tr:gt(0)").remove();
	//初始化一个月的日期表格
	var temp="";
	var temp2="";
	var betweendate = new Array(); 
	if(startdate_2=="")
		startdate_2=pre_date;
	if(enddate_2=="")
		enddate_2=current_date;
	$.ajax({
		url:"/slianOAsys-admin/attendance/listmonthdays.do",
		type:"post",
		dataType:"json",
		async:false,
		data:{
			startdate:startdate_2,
			enddate:enddate_2
			},
		success:function(data){
			console.log(data);
			for(var i=0;i<data.length;i++){
				temp2+=' <th style="width:180px;">'+data[i]+'</th>';
				betweendate.push(data[i]);
			}
			console.log("betweendate:"+betweendate);
		},
		"error":function(){
			alert("系统异常-from listmonthdays");
		}		
	});
	temp+=' <tr class="table_head">';
	temp+='<th style="width:37px;">';
	temp+='<th  style="width:100px;">账号</th>';
	temp+='<th >姓名</th>';
	temp+='<th >工号</th>';
	temp+='<th  style="width:150px;">部门</th>';
	temp+='<th  style="width:150px;">考勤规则</th>';
	temp+='<th >已选择<br/>（天）</th>';
	temp+='<th >应出勤<br/>（天）</th>';
	temp+='<th >实际出勤<br/>（天）</th>';
	temp+='<th>工作时长<br/>（小时）</th>';
	temp+='<th >标准时长<br/>（小时）</th>';
	temp+='<th >出差<br/>（天）</th>';
	temp+='<th >外勤<br/>（次）</th>';
	temp+='<th  style="width:120px;">';
	temp+='  工作日加班时长<br/>（小时）';
	temp+='</th>';
	temp+='<th  style="width:130px;">';
	temp+='   	  非工作日加班时长<br/>（小时）';
	temp+=' </th>';
	temp+='<th  style="background-color:#eee;">迟到<br>（次）</th>';
	temp+='<th  style="background-color:#eee;">迟到<br>（分钟）</th>';
	temp+='<th  style="background-color:#eee;">早退<br>（次）</th>';
	temp+='<th  style="background-color:#eee;">早退<br>（分钟）</th>';
	temp+='<th>旷工<br/>（天）</th>';
	temp+=' <th>事假<br/>（天）</th>';
	temp+='<th>病假<br/>（天）</th>';
	temp+='<th>论文答辩<br/>（天）</th>';
	temp+='<!-- <th style="width:180px;">3/1<br/>周三</th>';
	temp+='<th style="width:180px;">3/1<br/>周三</th>';
	temp+=' <th style="width:180px;">3/1<br/>周三</th> -->';
	temp+=temp2;
	temp+=' </tr>';
	
	for(var i=0;i<rows.length;i++){
		var one = rows[i];
		temp+="<tr>";
		temp+="<td><input type='checkbox' name='id' value='"+one.employeeId+"' /></td>";
		temp+="<td>"+one.employeeWechat+"</td>";
		temp+="<td>"+one.employeeName+"</td>";
		temp+="<td>"+one.employeeId+"</td>";
		temp+="<td>"+one.departName+"</td>";
		temp+="<td>"+one.className+"</td>";
		temp+="<td>"+one.totalday+"</td>";
		temp+="<td>"+one.workday+"</td>";
		temp+="<td>"+one.actualworkday+"</td>";
		temp+="<td>"+one.workHours+"</td>";
		temp+="<td>"+one.shouldworktime+"</td>";
		temp+="<td>"+"</td>";
		temp+="<td>"+"</td>";
		temp+="<td>"+"</td>";
		temp+="<td>"+"</td>";
		temp+="<td>"+one.latecount+"</td>";
		temp+="<td>"+one.latetime+"</td>";
		temp+="<td>"+one.beforecount+"</td>";
		temp+="<td>"+one.beforetime+"</td>";
		temp+="<td>"+"</td>";
		temp+="<td>"+"</td>";
		temp+="<td>"+"</td>";
		temp+="<td>"+"</td>";
		
		for(var k=0;k<betweendate.length;k++){
			var flag=0;
			for(var j=0;j<one.dateAndStatus.length;j++){
				if(one.dateAndStatus[j].attendanceTime==betweendate[k]){
					flag=1;
					console.log("one.dateAndStatus[j].attendanceTime:"
							+one.dateAndStatus[j].attendanceTime);
					temp+="<td>"+one.dateAndStatus[j].attendanceTotalStatus +"</td>";
					break;
				}	
			}
			if(flag==0){
				temp+="<td>"+"</td>";
			}
			
		}
		temp+="</tr>";
	}
	table.append(temp);
}
function searchByEmployee_2(){
	alert("searchByEmployee_2");
	employeeName_2=$("#2_quicksearch_byemployee").val();
	init_datagrid_2("","2017-03-01","2017-03-29",employeeName_2,"");
}

function getBetweenDate(start,end){
	$.ajax({
		url:"/slianOAsys-admin/attendance/betweendate.do",
		type:"post",
		dataType:"json",
		data:{
			start:start,
			end:end
			},
		success:function(data){
			console.log(data);
		},
		"error":function(){
			alert("系统异常-from betweendate!!!!");
		}	
	});	
}

function searchBycondition_2(){
	alert("searchBycondition_2");
	employeeName_2=$("#2_employeeName").val();
	className_2=$("#2_classes").val();
	startdate_2=$("#Text3").val();
	enddate_2=$("#Text4").val();
	departName_2=$("#2_departName").val();
	if($("#Text3").val()==""){
		alert("请填写开始时间！");
		return;
	}
	if($("#Text4").val()==""){
		alert("请填写结束时间！");
		return;
	}
//	getBetweenDate(startdate_2,enddate_2);
	init_datagrid_2(className_2,startdate_2,enddate_2,employeeName_2,departName_2);
}

function searchBypage_2(){
	var pageindex=$("#2_pageIndex").val();
	$.ajax({
		url:"/slianOAsys-admin/attendance/monthlist.do",
		type:"post",
		dataType:"json",
		data:{
			pageindex : pageindex,
			className:className,
			startdate:startdate,
			enddate:enddate,
			employeeName:employeeName,
			departName:departName
			},
		success:function(data){
			alert("datagrid");
			console.log(data);
			total_2=data.total;
			totalPages_2=data.totalPages;
			$("#2_totalRows").text(total_2);
			$("#2_totalPages").text(totalPages_2);
			listtable_2(data);
		},
		"error":function(){
			alert("系统异常-from searchattendance!!!!");
		}		
	});	
}
function prepage_2(){
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
function nextpage_2(){
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
function lastpage_2(){
	$("#2_pageIndex").val("");
	$("#2_pageIndex").val(totalPages_2);
	searchBypage_2();
}
