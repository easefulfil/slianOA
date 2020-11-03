var update_classid_5="1";
var classname_5="";
var starttime_5="";
var endtime_5="";
var description_5="";
var signaddress_5="";
var longitude_5="";
var latitude_5="";
var scope_5="";
var signinstart_5="";
var signinend_5="";
var signoffstart_5="";
var signoffend_5="";
var classstatus_5="";
var createstarttime_5="";
var createendtime_5="";
var ismonday_5="0";
var istuesday_5="0";
var iswednesday_5="0";
var isthursday_5="0";
var isfriday_5="0";
var issaturday_5="0";
var issunday_5="0";
var workday_5="";
var totalPages_5="";
var insert_or_update_5="insert";
var class_ststus_5="";
var department_5 = new Array(); 
var addDate_5 = new Array();  
var deleteDate_5 = new Array();  
$(function(){
	// 添加位置弹出框
	$(function(){
	  $(".tjwz").click(function(){
	    $(".baiduMap1").fadeIn(500);
	  });
	  $(".SS_tit1 i,.quxiao").click(function(){
	    $(".baiduMap1").fadeOut(500);
	  });
	});
	//点击班次-编辑
	$(".tlb1").delegate(".update_class_5", "click", function(event) {
		insert_or_update_5="update";
		update_classid_5=$(this).attr("updateid");
	    $(".setup").fadeOut(500,function(){
	        $(".setup2").fadeIn(500);
	    });
	    $.ajax({
			url:"/slianOAsys-admin/class/getClassByid.do",
			type:"post",
			dataType:"json",
			data:{
				classid : update_classid_5
				},
			success:function(data){
				console.log(data);
				$("#classname_5").val(data[0].className);
				$("#starttime_5").val(data[0].startTime);
				$("#endtime_5").val(data[0].endTime);
				$("#signinstart_5").val(data[0].signinStart);
				$("#signinend_5").val(data[0].signinEnd);
				$("#signoffstart_5").val(data[0].signoffStart);
				$("#signoffend_5").val(data[0].signoffEnd);
				$("#keyword").val(data[0].signaddress);
				$("#latitude").val(data[0].latitude);
	            $("#longitude").val(data[0].longitude);
	            $("#distacne").val(data[0].scope);
			},
			"error":function(){
				alert("系统异常");
			}		
		});
	})
	
	//点击班次-禁用
	$(".tlb1").delegate(".delete_class_5", "click", function(event) {
		update_classid_5=$(this).attr("deleteid");
		class_ststus_5="禁用";
		 $.ajax({
				url:"/slianOAsys-admin/class/forbidden.do",
				type:"post",
				dataType:"json",
				data:{
					classid : update_classid_5,
					classststus:class_ststus_5
					},
				success:function(data){
					alert("禁用成功");
				},
				"error":function(){
					alert("系统异常");
				}		
			});
	})
	
	//点击-新增规则
	$(".xzgz").click(function(){
		insert_or_update_5="insert";
	    $(".setup").fadeOut(500,function(){
	        $(".setup2").fadeIn(500);
	    });
	})
	$(".xjgz").click(function(){
		insert_or_update_5="insert";
	    $(".gzgl_1").fadeOut(500,function(){
	        $(".setup2").fadeIn(500);
	    });
	})
	//规则界面-返回
	$(".gzfh").click(function(){
		if(insert_or_update_5=="insert"){
			$(".setup2").fadeOut(500,function(){
		        $(".setup").fadeIn(500);
		    });
		}
		else if(insert_or_update_5=="update"){
			$(".setup2").fadeOut(500,function(){
		        $(".gzgl_1").fadeIn(500);
		    });
		}
	})
	//部门checkbox的控制
	$(".pop_wrap6_main").delegate(".ipt-cb", "click", function(event) {
	    if($(this).is('.input-cb')){
	        $(this).removeClass('input-cb');
	        $(this).addClass('input-cb-on');
	    }else{
	        $(this).removeClass('input-cb-on');
	        $(this).addClass('input-cb');
	    }
	    event.stopPropagation();
	});
	
	//添加部门时记忆已选择数据
	$(".addto").click(function(){
		console.log(department_5);
		console.log(department_5.length);
		console.log(department_5[0]);
	    $(".pop_wrap6").fadeIn(500);
	    var str=$(".departcheck");
	    console.log("111"+str.length);
		for (i=0;i<str.length;i++)
        {
			$(".departcheck").eq(i).attr("checked",true);
			console.log("str[i].value:"+str[i].value);
			for(j=0;j<department_5.length;j++){
				if(str[i].value==department_5[j]){
					alert("222");
					alert("i:"+i);
					alert("j:"+j);
				//	str[i].checked=true;  
				}
			}
             
        }
	})
	//添加班次适用部门
	$("#departcheck_5").click(function(){
		var str=$(".departcheck");
		department_5 = new Array();
		for (i=0;i<str.length;i++)
        {
             if(str[i].checked==true)
             {
            	 department_5.push(str[i].value); 
             }  
        }
		$(".pop_wrap6").fadeOut(500);
    //    alert(department_5);
	});
	
	//点击-班次发布
	$("#publishShow").click(function(){
        var str=$(".rq");
        for (i=0;i<str.length;i++)
        {
             if(str[i].checked==true)
             {
              if(i==0)
            	  ismonday_5="1";
              if(i==1)
            	  istuesday_5="1";
              if(i==2)
            	  iswednesday_5="1";
              if(i==3)
            	  isthursday_5="1";
              if(i==4)
            	  isfriday_5="1";
              if(i==5)
            	  issaturday_5="1";
              if(i==6)
            	  issunday_5="1";
             }  
        }
        // 发布   时间不能为空
        var tac=$(".tac");
        var tlen=tac.length;
        var re = /^(?:[01]\d|2[0-3])(?::[0-5]\d)$/;
        for(i=0;i<tlen;i++)
        {
           if(!re.test(tac[i].value))
             {
              alert("请输入时间");
              tac[i].value="输入时间"
              tac[i].style.color="red";
              return;
             }   
        }
        if(!($("#latitude").val()!=null&&$("#longitude").val()!=null&&$("#distacne").val()!=null
                &&$("#latitude").val()!=""&&$("#longitude").val()!=""&&$("#distacne").val()!="")){
        alert("请输入经纬度！");
        return;
        }
        class_ststus_5="启用";
        publish_class();
 });
	//点击-班次草稿
	$("#saveShow").click(function(){
        var str=$(".rq");
        for (i=0;i<str.length;i++)
        {
             if(str[i].checked==true)
             {
              if(i==0)
            	  ismonday_5="1";
              if(i==1)
            	  istuesday_5="1";
              if(i==2)
            	  iswednesday_5="1";
              if(i==3)
            	  isthursday_5="1";
              if(i==4)
            	  isfriday_5="1";
              if(i==5)
            	  issaturday_5="1";
              if(i==6)
            	  issunday_5="1";
             }  
        }
        // 发布   时间不能为空
        var tac=$(".tac");
        var tlen=tac.length;
        var re = /^(?:[01]\d|2[0-3])(?::[0-5]\d)$/;
        for(i=0;i<tlen;i++)
        {
           if(!re.test(tac[i].value))
             {
              alert("请输入时间");
              tac[i].value="输入时间"
              tac[i].style.color="red";
              return;
             }   
        }
        if(!($("#latitude").val()!=null&&$("#longitude").val()!=null&&$("#distacne").val()!=null
                &&$("#latitude").val()!=""&&$("#longitude").val()!=""&&$("#distacne").val()!="")){
        alert("请输入经纬度！");
        return;
        }
        class_ststus_5="草稿";
        publish_class();
 });	
});
var searchService,map,markers = [];
var init = function() {
    var center = new qq.maps.LatLng(29.886850,121.637350);
    map = new qq.maps.Map(document.getElementById('container'),{
        center: center,
        zoom: 13
    });
var geocoder = new qq.maps.Geocoder({
        complete : function(result){
            if(confirm("确认将经纬度更改当前位置吗？"+result.detail.address)){
                $("#latitude").val(result.detail.location.getLat().toFixed(6));
                $("#longitude").val(result.detail.location.getLng().toFixed(6));
            } 
        }
    });
    qq.maps.event.addListener(map,'click',function(event) {
        var latLng = event.latLng,
            lat = latLng.getLat().toFixed(6),
            lng = latLng.getLng().toFixed(6);
        geocoder.getAddress(latLng);
    }); 
    var latlngBounds = new qq.maps.LatLngBounds();
    var latlngs = [];
    //调用Poi检索类
    searchService = new qq.maps.SearchService({
        complete : function(results){
            var pois = results.detail.pois;
            for(var i = 0,l = pois.length;i < l; i++){
                var poi = pois[i];
                latlngBounds.extend(poi.latLng);

               (function(n) {
                    var marker = new qq.maps.Marker({
                        map: map,
                        position:poi.latLng
                    });
                    marker.setTitle(i+1);
                    markers.push(marker);
                    qq.maps.event.addListener(marker, 'click', function() {
                        geocoder.getAddress(marker.getPosition());
                        
                    });
                })(i);      
            }
            map.fitBounds(latlngBounds);
        }
    }); 
}
//点击-新增位置
function init_location(){
	init();
}
//清除地图上的marker
function clearOverlays(overlays){
    var overlay;
    while(overlay = overlays.pop()){
        overlay.setMap(null);
    }
}
function searchKeyword() {
    var keyword = document.getElementById("keyword").value;
    var region = document.getElementById("region").value;
    clearOverlays(markers);
    searchService.setLocation(region);
    searchService.search(keyword);
}

function locationSubmint(){
	 if($("#latitude").val()!=null&&$("#longitude").val()!=null&&$("#distacne").val()!=null
             &&$("#latitude").val()!=""&&$("#longitude").val()!=""&&$("#distacne").val()!=""){
		 signaddress_5=$("#keyword").val();
		 longitude_5=$("#longitude").val();
		 latitude_5=$("#latitude").val();
		 scope_5=$("#distacne").val();
		 $(".baiduMap1").fadeOut(300);
		 
     }else{
         alert("请将信息填写完整");
     }
}
//删除班次规则
function  delete_5(){
	var content = $(".gzgl_1 .tlb1");
	var checkbox = content.find("*[name='id']:checked"); // 被选中的复选框
	var id = [];
	for (var i = 0; i < checkbox.length; i++) {
		id.push($(checkbox[i]).val());
	}
	alert(id);
	$.ajax({
		url:"/slianOAsys-admin/class/delete.do",
		type:"post",
		dataType:"json",
		data:{
			"classid[]":id
			},
		success:function(data){
			alert("删除"+data+"条数据");
		},
		"error":function(){
			alert("系统异常-from delete!!!!!!!");
		}		
	});	
}


//添加部门的初始化
function init_department_5(){
	$.ajax({
		url:"/slianOAsys-admin/department/list.do",
		type:"post",
		dataType:"json",
		data:{
			pageindex : 1
			},
		success:function(data){
			console.log(data);
			var rows=data.rows;
			var department_table_5=$("#department_table_5");
			department_table_5.find("li:gt(0)").remove()		
			var temp="";
			for(var i=0;i<rows.length;i++){
				var one = rows[i];
				temp+="<li class='clearfix'>";
				temp+="<div class='jstree-wholerow'>&nbsp;</div>";
				temp+="<div class='listInfo'>";
				temp+="<img src='https://qy.do1.com.cn/qwy/manager/images/dept_icon01.png' alt=''>";
				temp+=" <span class='deptName'>";
				temp+=one.departName;
				temp+="</span>";
				temp+=" <input type='hidden' class='deptId' value='75fb37b1-ad2a-49f1-9b7a-00cb937d3ae8'>";
				temp+="<input type='checkbox'  class='ipt-cb input-cb-on departcheck' value='"+one.departId+"'></input>";
				temp+="</div>";
				temp+="</li>";
			}
			department_table_5.append(temp);
		},
		"error":function(){
			alert("系统异常-from init_department_5");
		}		
	});
}
//点击班次管理
function management(){
	init_classes_5("","","","" );
}

function init_class_bycondition_5(){
	alert("init_class_bycondition_5");
	classname_5=$("#condition_classname_5").val();
	createstarttime_5=$("#Text9").val();
	createendtime_5=$("#Text10").val();
	classstatus_5=$("#condition_classstatus_5").val();
	if(classstatus_5=="全部")
		classstatus_5="";
	alert("classname_5:"+classname_5
			+"createstarttime_5:"+createstarttime_5
			+"createendtime_5:"+createendtime_5
			+"classstatus_5:"+classstatus_5
			);
	init_classes_5(classname_5,createstarttime_5,createendtime_5,classstatus_5 );
}

//查询班次
function init_classes_5(classname,createstarttime,createendtime,classstatus ){
	$("#5_pageIndex").val("1");
	$.ajax({
		url:"/slianOAsys-admin/class/list.do",
		type:"post",
		dataType:"json",
		data:{
			pageindex : 1,
			classname:classname,
			createstarttime:createstarttime,
			createendtime:createendtime,
			classstatus:classstatus
			},
		success:function(data){
			console.log(data);
			var total=data.total;
			totalPages_5=data.totalPages;
			$("#5_totalRows").text(total);
			$("#5_totalPages").text(totalPages_5);
			listtable_5(data);
		},
		"error":function(){
			alert("系统异常-from searchclass");
		}		
	});	
}

function listtable_5(data){
	var rows=data.rows;
	console.log(rows);
	var table = $("#datagrid_5");
	//清空表格数据  
	table.find("tr:gt(0)").remove()		
	var temp="";
	for(var i=0;i<rows.length;i++){
		workday_5="";
		var one = rows[i];
		if(one.isMonday=="1")
			workday_5+="星期一";
		if(one.isTuesday=="1")
			workday_5+="星期二";
		if(one.isWednesday=="1")
			workday_5+="星期三";
		if(one.isThursday=="1")
			workday_5+="星期四";
		if(one.isFriday=="1")
			workday_5+="星期五";
		if(one.isSaturday=="1")
			workday_5+="星期六";
		if(one.isSunday=="1")
			workday_5+="星期七";
		
		temp+="<tr>";
		temp+="<td><input type='checkbox' name='id' value='"+one.classId+"' /></td>";
		temp+="<td>"+one.className+"</td>";
		temp+="<td>"+one.departName+"</td>";
		temp+="<td>"+workday_5+"</td>";
		temp+="<td>"+one.classStatus+"</td>";
		temp+="<td>"+one.createTime+"</td>";
		temp+="<td>"+""+"</td>";
		temp+="<td><span class='czan'>操作<img src='images/cz.png'></span>" +
				"<div value='"+one.classId+"'>" +
						"<a class='delete_class_5' deleteid='"+one.classId+"'>禁用</a>" +
						"<a>浏览</a>" +
						"<a>复制</a>" +
						"<a class='update_class_5' updateid='"+one.classId+"'>编辑</a>" +
				"</div></td>"
		temp+="</tr>";	
	}
	table.append(temp);
}
//发布班次-启用
function publish_class(){
	classname_5=$("#classname_5").val();
	starttime_5=$("#starttime_5").val();
	endtime_5=$("#endtime_5").val();
	signinstart_5=$("#signinstart_5").val();	
	signinend_5=$("#signinend_5").val();
	signoffstart_5=$("#signoffstart_5").val();
	signoffend_5=$("#signoffend_5").val();
	signaddress_5=$("#keyword").val();
	longitude_5=$("#longitude").val();
	latitude_5=$("#latitude").val();
	scope_5=$("#distacne").val();
	
/*	alert("classname_5:"+classname_5+"---"
			+"starttime_5:"+starttime_5+"---"
			+"endtime_5:"+endtime_5+"---"
			+"signinstart_5:"+signinstart_5+"---"
			+"signinend_5:"+signinend_5+"---"
			+"signoffstart_5:"+signoffstart_5+"---"
			+"signoffend_5:"+signoffend_5+"---"
			+"ismonday_5:"+ismonday_5+"---"
			+"istuesday_5:"+istuesday_5+"---"
			+"iswednesday_5:"+iswednesday_5+"---"
			+"isthursday_5:"+isthursday_5+"---"
			+"isfriday_5:"+isfriday_5+"---"
			+"issaturday_5:"+issaturday_5+"---"
			+"issunday_5:"+issunday_5+"---"
			+"department_5:"+department_5+"---"
			+"class_ststus_5:"+class_ststus_5
			);
			*/
	insert_new_classes(update_classid_5,
			classname_5,starttime_5,endtime_5,
			"",
			signaddress_5,
			longitude_5,latitude_5,scope_5,
			signinstart_5,signinend_5,signoffstart_5,signoffend_5,
			ismonday_5,istuesday_5,iswednesday_5,isthursday_5,
			isfriday_5,issaturday_5,issunday_5,class_ststus_5,
			department_5,insert_or_update_5,
			addDate_5,deleteDate_5);
			
}
function insert_new_classes(update_classid,
		classname,starttime,endtime,
		description,signaddress,
		longitude,latitude,scope,
		signinstart,signinend,signoffstart,signoffend,
		ismonday,istuesday,iswednesday,
		isthursday,isfriday,issaturday,issunday
		,classstatus,
		department,insert_or_update,
		addDate,deleteDate){
	$.ajax({
		url:"/slianOAsys-admin/class/insert.do",
		type:"post",
		dataType:"json",
		data:{
			pageindex : 1,
			update_classid:update_classid,
			classname:classname,
			starttime:starttime,
			endtime:endtime,
			description:description,
			signaddress:signaddress,
			longitude:longitude,
			latitude:latitude,
			scope:scope,
			signinstart:signinstart,
			signinend:signinend,
			signoffstart:signoffstart,
			signoffend:signoffend,
			ismonday:ismonday,
			istuesday:istuesday,
			iswednesday:iswednesday,
			isthursday:isthursday,
			isfriday:isfriday,
			issaturday:issaturday,
			issunday:issunday,
			department:department,
			insert_or_update:insert_or_update,
			addDate:addDate,
			deleteDate:deleteDate,
			classstatus:classstatus
			},
		success:function(data){
			alert(data);
		},
		"error":function(){
			alert("系统异常-from searchclass");
		}		
	});
}

function prepage_5(){
	var page=$("#5_pageIndex").val();
	var pageindex=new Number(page);
	$("#5_pageIndex").val("");
	pageindex=pageindex-1;
	if(pageindex>=1){
		$("#5_pageIndex").val(pageindex);
		searchBypage_5();
	}
	else{
		$("#5_pageIndex").val(1);
	}
}
function nextpage_5(){
	var page=$("#5_pageIndex").val();
	var pageindex=new Number(page);
	$("#5_pageIndex").val("");
	pageindex=pageindex+1;
	if(pageindex>totalPages_5){
		$("#5_pageIndex").val(totalPages_5);
	}
	else{
		$("#5_pageIndex").val(pageindex);
		searchBypage_5();
	}
}

function searchBypage_5(){
	var pageindex=$("#5_pageIndex").val();
	$.ajax({
		url:"/slianOAsys-admin/class/list.do",
		type:"post",
		dataType:"json",
		data:{
			pageindex : pageindex,
			classname:classname_5,
			createstarttime:createstarttime_5,
			createendtime:createendtime_5,
			classstatus:classstatus_5
			},
		success:function(data){
			console.log(data);
			var total=data.total;
			totalPages_5=data.totalPages;
			$("#5_totalRows").text(total);
			$("#5_totalPages").text(totalPages_5);
			listtable_5(data);
		},
		"error":function(){
			alert("系统异常-from searchclass");
		}		
	});		
}

