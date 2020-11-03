window.onload = function() { week();time(); }
function week() {
	var show_day = new Array('星期日','星期一', '星期二', '星期三', '星期四', '星期五', '星期六');
	var Time = new Date();
	var year = Time.getFullYear();
	var month = Time.getMonth();
	var date = Time.getDate();
	var day = Time.getDay();
	month = month + 1;
	var now_time = year + '年' + month + '月' + date + '日' + ' ' + show_day[day];
	document.getElementById('week').innerHTML = now_time;
}
function time() {
	//获取系统时间。  
	var dateTime = new Date();
	var hh = dateTime.getHours();
	var mm = dateTime.getMinutes();
	var ss = dateTime.getSeconds();
	//分秒时间是一位数字，在数字前补0。  
	mm = extra(mm);
	ss = extra(ss);
	//将时间显示到ID为time的位置，时间格式形如：19:18:02  
	document.getElementById("time").innerHTML = hh + ":" + mm + ":" + ss;
	//每隔1000ms执行方法systemTime()。  
	setTimeout("time()", 1000);
}
//补位函数。  
function extra(x) {
	//如果传入数字小于10，数字前补一位0。  
	if(x < 10) {
		return "0" + x;
	} else {
		return x;
	}
}

    $(function()
      {
  	  	 $("#addnotes-signin").click(function(){
  	  	 	  $("#boxdiv").show("slow");
  	  	 })
  	  	 $("#boxdiv").click(function(){
  	  	 	  $("#boxdiv").hide("slow");
  	  	 })
  	  	 
  	  })
  	$(function()
  	  {
  	  	 $("#addnotes-signout").click(function(){
  	  	 	  $("#boxdiv2").show("slow");
  	  	 })
  	  	 $("#boxdiv2").click(function(){
  	  	 	  $("#boxdiv2").hide("slow");
  	  	 })
  	  	 
  	  })
    function submitremarks()
       {
       	var remark=document.getElementById("remark").value;
       	$("#boxdiv").hide("slow");
        //document.write(remark);
       } 
    function submitremarks2()
    {
    	var remark=document.getElementById("remark2").value;
    	$("#boxdiv2").hide("slow");
     //document.write(remark);
    } 
/*$(function(){	
	$("#b1").click(function(){
		var dateTime = new Date();
		var hh = dateTime.getHours();
		var mm = dateTime.getMinutes();
		var ss = dateTime.getSeconds();
		mm = extra(mm);
		ss = extra(ss);
		var t1=hh + ":" + mm + ":" + ss;		
	    var t2='09:00:00';
	    var t11=t1.split(":");
	    var t21=t2.split(":");
	    var sj1 = parseInt((t11[0])*3600 + (t11[1])*60+t11[2]);
	    var sj2 = parseInt((t21[0])*3600 + (t21[1])*60+t21[2]);  
	    if (sj1 > sj2) 
	    {            
	        $("#nowtime").html(t1+"<br/>"+"<span style='color:#ff3333;font-size:0.6rem;'>你迟到了</span>");
	    } 
	    else
	    {
	    	$("#nowtime").html(t1+"<br/>"+"<span style='font-size:0.6rem;'>正常上班</span>");
	    }
	})
})
$(function(){
	$("#b2").click(function(){
		var dateTime = new Date();
		var hh = dateTime.getHours();
		var mm = dateTime.getMinutes();
		var ss = dateTime.getSeconds();
		mm = extra(mm);
		ss = extra(ss);
		var t11=hh + ":" + mm + ":" + ss;		
	    var t21='17:30:00';
	    var t111=t11.split(":");
	    var t211=t21.split(":");
	    var sj11 = parseInt((t111[0])*3600 + (t111[1])*60+t111[2]);
	    var sj21 = parseInt((t211[0])*3600 + (t211[1])*60+t211[2]);  
	    if (sj11 < sj21) 
	    {            
	        $("#nowtime1").html(t11+"<br/>"+"<span style='color:#ff3333;font-size:0.6rem;'>你早退了</span>");
	    } 
	    else
	    {
	    	$("#nowtime1").html(t11+"<br/>"+"<span style='font-size:0.6rem;'>正常下班</span>");
	    }
	})
})

//显示签到定位
function getLocation()
{
	if (navigator.geolocation)
	{
		navigator.geolocation.getCurrentPosition(showPosition,showError);
	}
	else
	{
		document.getElementById("signinposition").innerHTML="不支持获取地理位置";
	}
}
function showError(error)
{
	switch(error.code) 
	{
		case error.PERMISSION_DENIED:
			document.getElementById("signinposition").innerHTML="用户拒绝对获取地理位置的请求"
			break;
		case error.POSITION_UNAVAILABLE:
			document.getElementById("signinposition").innerHTML="位置信息是不可用的"
			break;
		case error.TIMEOUT:
			document.getElementById("signinposition").innerHTML="请求用户地理位置超时"
			break;
		case error.UNKNOWN_ERROR:
			document.getElementById("signinposition").innerHTML="未知错误"
			break;
	}
}
function showPosition(position){   
    var latlon = position.coords.latitude+','+position.coords.longitude;     
    //google   
    var url = 'http://maps.google.cn/maps/api/geocode/json?latlng='+latlon+'&language=CN';   
    $.ajax({    
        type: "GET",   
        url: url,    
        beforeSend: function(){   
            $("#signinposition").html('正在定位...');   
        },   
        success: function (json) {    
            if(json.status=='OK'){   
                var results = json.results;   
                $.each(results,function(index,array){   
                    if(index==0){   
                    $("#signinposition").html(array['formatted_address']);   
                    }   
                });   
            }   
        },   
        error: function (XMLHttpRequest, textStatus, errorThrown) {    
            $("#signinposition").html(latlon+"地址位置获取失败");    
        }    
    });   
}
//显示签退定位
function getLocation1()
{
	if (navigator.geolocation)
	{
		navigator.geolocation.getCurrentPosition(showPosition1,showError1);
	}
	else
	{
		document.getElementById("signoutposition").innerHTML="不支持获取地理位置。";
	}
}
function showError1(error)
{
	switch(error.code) 
	{
		case error.PERMISSION_DENIED:
			document.getElementById("signoutposition").innerHTML="用户拒绝对获取地理位置的请求"
			break;
		case error.POSITION_UNAVAILABLE:
			document.getElementById("signoutposition").innerHTML="位置信息是不可用的"
			break;
		case error.TIMEOUT:
			document.getElementById("signoutposition").innerHTML="请求用户地理位置超时"
			break;
		case error.UNKNOWN_ERROR:
			document.getElementById("signoutposition").innerHTML="未知错误"
			break;
	}
}
function showPosition1(position){   
    var latlon = position.coords.latitude+','+position.coords.longitude;     
    //google   
    var url = 'http://maps.google.cn/maps/api/geocode/json?latlng='+latlon+'&language=CN';   
    $.ajax({    
        type: "GET",   
        url: url,    
        beforeSend: function(){   
            $("#signoutposition").html('正在定位...');   
        },   
        success: function (json) {    
            if(json.status=='OK'){   
                var results = json.results;   
                $.each(results,function(index,array){   
                    if(index==0){   
                    $("#signoutposition").html(array['formatted_address']);   
                    }   
                });   
            }   
        },   
        error: function (XMLHttpRequest, textStatus, errorThrown) {    
            $("#signoutposition").html(latlon+"地址位置获取失败");    
        }    
    });   
} */
