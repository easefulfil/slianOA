		  var latitude="";
		  var longitude="";	  
		  var address = "";
	      var sign = angular.module('sign', []);
		  sign.config([ '$locationProvider', function($locationProvider) {
	        $locationProvider.html5Mode(true);
	      } ]);
		  
	      sign.controller('myCtrl', [ '$scope', '$location', '$http',
	          function($scope, $location, $http) {
	            var data = $scope.data = {};
	            data.url = $location.absUrl();
	            //alert(data.url);
	            if ($location.search().code) {
                    data.code = $location.search().code;
                    
                }       
	            var wechat = $scope.wechat = {};
	            //地理位置
	            data.getwechatpermission = function () {
	            	console.log("获取地理位置");
	    	        $http({
	    	            method: "GET",
	    	            url: "/sliansoft-wechat/controller/getParams.do",
	    	            params: {
	    	                'url': data.url
	    	            },
	    	            dataType: "text"
	    	        }).success(function (resp) {
	    	            wechat.timestamp = resp.timestamp;
	    	            wechat.nonceStr = resp.nonceStr;
	    	            wechat.signature = resp.signature;
	    	            
	    	          //调用微信sdk
	    	            wx.config({
	    	                debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	    	                appId: 'wx7e27f3589e566640', // 必填，企业号的唯一标识，此处填写企业号corpid	    	          
	    	                timestamp: wechat.timestamp, // 必填，生成签名的时间戳
	    	                nonceStr: wechat.nonceStr, // 必填，生成签名的随机串
	    	                signature: wechat.signature,// 必填，签名，见附录1
	    	                jsApiList: [
	    	                    'getLocation'
	    	                ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	    	            });
	    	        });
	    	        wx.ready(function () {
	    	        	console.log("ready获取地理位置");
	    	            wx.getLocation({
	    	                type: 'gcj02', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
	    	                success: function (res) {
	    	                    latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
	    	                    //alert(latitude);
	    	                    longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
	    	                    //alert(longitude);
	    	                    wechat.speed = res.speed; // 速度，以米/每秒计
	    	                    wechat.accuracy = res.accuracy; // 位置精度
	    	                    //alert("lat"+latitude);
	    	                    //alert("long"+longitude);
	    	                    var location = latitude+","+longitude;
	    	                    console.log("location"+location);
	    	                    var sdata={
	    	                    		location:location,
	    	                    		key:"5ICBZ-2VSKF-O3PJ6-JNFY6-CXKUQ-WGB3Y",
	    	                    		get_poi:0
	    	                   }
	    	                    
	    	                    var url="http://apis.map.qq.com/ws/geocoder/v1/";
	    	                    sdata.output="jsonp"; 
	    	                    $.ajax({
	    	                    	type:"get",
	    	                    	dataType:'jsonp',
	    	                    	data:sdata,
	    	                    	async: false,
	    	                    	 jsonp:"callback",
	    	                    	 url:url,
	    	                    	success:function(json){
	    	                    	var toStr = JSON.stringify(json);
	    	                    	console.log("str: "+toStr);
	    	                    	console.log(json.result.address);
	    	                    	address = json.result.formatted_addresses.recommend;
	    	                    	//alert("街道地址："+address+"标志物地址："+json.result.formatted_addresses.recommend);
	    	                    	},
	    	                    	error : function(err){alert("服务端错误，请刷新浏览器后重试")} 
	    	                   })
	    	                   
	    	                }
	    	            });
	    	            
	    	            
	    	        });
	            }
	    	        
	            $scope.initPage = function(){
	            	console.log("initPage");

	            	$http({
	    	            method: "POST",
	    	            url: "/slianOA-pc-web/mobile-ajax/auth/oaAttendance/getContent.do",
	    	            params:{"wechatAccount":data.user}
	    	        }).success(function (res) {
	    	        		console.log(res.signinStatus);
	    	        		console.log(res.signoutStatus);    	        		
	    	           console.log(res.attendanceRuleId);
	    	           $http({
	    	        	   method:"POST",
	    	        	   url:'/slianOA-pc-web/mobile-ajax/auth/oaAttendanceRule/getContent.do',
	    	        	   params:{"wechatAccount":data.user,"attendanceRuleId":res.attendanceRuleId}
	    	           }).success(function(data){
	    	        	   console.log(data);
	    	        	   $scope.time=data;
	    	        	   
	    	           }).error(function(data){
	    	        	   console.log(data);
	    	           })
	    	           console.log(data.user);console.log(res);
	    	           if(res == "\"null\""){
	    	        	   $.alert('无今日签到记录！');
	    	        	   $("#b1").attr('disabled',true);
	    	        	   $("#b2").attr('disabled',true);
	    	        	   $("#b1").css('backgroundColor','#B2B2B2');
	    	        	   $("#b2").css('backgroundColor','#B2B2B2');
	    	           }else{
	    	        	   if(res.signinStatus && res.signinStatus != 'cancel'){
	    	        		   if(res.signinStatus == '请假' || res.signinStatus == '出差'){
	    	        			   $("#b1").attr('disabled',true);
		    	        		   $("#b1").css('backgroundColor','#B2B2B2');
		    	        		   $('p#signinposition').text(res.signinStatus);
	    	        		   }else{
			    	        	   $("#signinposition").text(res.signinAddress);
			    	        	   $("#remark").text(res.signinRemark);
			    	        	   $("#b1").attr('disabled',true);
			    	        	   $("#b1").css('backgroundColor','#B2B2B2');
	    	        		   }
		    	           }
		    	           if(res.signoutStatus && res.signoutStatus != 'cancel'){
		    	        	   if(res.signoutStatus=='请假' || res.signinStatus == '出差'){
		    	        			 $("#b2").attr('disabled',true); 
		    	        			 $("#b2").css('backgroundColor','#B2B2B2');
		    	        			 $('p#signoutposition').text(res.signinStatus);
		    	        		}else{
			    	        	   $("#signoutposition").text(res.signinAddress);
			    	        	   $("#remark2").text(res.signoutRemark);
			    	        	   $("#b2").attr('disabled',true);
			    	        	   $("#b2").css('backgroundColor','#B2B2B2');
		    	        		}
		    	           }
	    	           }
	    	          data.getwechatpermission();
	    	           //data.GaoDe();
	    	        }).error(function () {
	    	        	$.toptip('你无权限考勤或系统异常，请与管理员联系！', 'error');
				   $("#b1").attr('disabled',true);
	    	        	   $("#b2").attr('disabled',true);
	    	        	   $("#b1").css('backgroundColor','#B2B2B2');
	    	        	   $("#b2").css('backgroundColor','#B2B2B2');
				return;
	    	        });
	            }
	            
	              $(window).load(function () {
	            	  
	                  if (localStorage["weChatAccount"] != null ) {
	                      data.weChatAccount = localStorage["weChatAccount"];             
	                  //  data.getwechatpermission();
	                   //   data.GaoDe();
	                 //     alert("欢迎进入考勤页面！"+localStorage["weChatAccount"]);
	                      data.user = localStorage["weChatAccount"];
	                      $scope.initPage();
	                  }else{                   
	                    if ( data.code == null) {       
	                      var encodeurl = encodeURIComponent(data.url);
	                      window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7e27f3589e566640&redirect_uri="
	                          + encodeurl
	                          + "&response_type=code&scope=snsapi_userinfo&agentid=1000004&state=0#wechat_redirect";
	                      //直接获取
	                      //data.user = "SongCongyi";
	                      $scope.initPage();
	                    } else{
	                    	$.ajax({
	    		            	url: "/sliansoft-wechat/core/getUser.do",
	    		                type: "GET",
	    		                async:false,
	    		                data:{
	    		                    'code': $location.search().code,
	    		                    'corpId':"wx7e27f3589e566640"
	    		                },
	    		                dataType:"json",
	    		                success:function (res) {
	    		                	data.user = res.userid; // 获取微信名
	    		                	console.log("这里是测试微信账户："+data.user);
	    		                	localStorage.setItem("weChatAccount", data.user);
	    		                	$scope.initPage();
	    		                },
	    		                error:function () {
	    		                	$.toptip('身份验证失败，请退出重新进入','error');
	    		              //  	wx.closeWindow();
	    		                },
	    		        });
	    		      // $scope.initPage();          
	                    }  
	                  }
	            	 
	              });	    	           
	              $scope.signin=function(){
				  console.log('签到')
	            	var signinTime = $scope.getNewDate();
			if(address == ""){
				 data.getwechatpermission();
			 }
				  $("#signinposition").text(address);
				  console.log($("#remark").val());
	       		   $http({
	       			   method:'POST',
	       			   url:"/slianOA-pc-web/mobile-ajax/auth/oaAttendance/signIn.do",
	       				params : {
	       					  "wechatAccount":data.user, 
	       					  //"wechatAccount":"SongCongyi",
	       			    	  "signinLatitude":latitude,
	       					  //"signinLatitude":121.64,
	       			    	  "signinLongitude":longitude,
	       					  //"signinLongitude":29.89,
	       			    	  "signinTime":signinTime,
	       			    	  "signinRemark":$("#remark").val(),
	       			    	  "signinAddress" : encodeURIComponent(address)
	       			    	  //"signinAddress" : encodeURIComponent("沈阳")
	       				}
	       			}).success(function(response) {
	       				//alert(response);
	       				$.confirm("签到状态为"+response+"，您是否要操作？", function() {
		       				  //点击确认后的回调函数
		       					$("#b1").attr('disabled',true);
			    	        	$("#b1").css('backgroundColor','#B2B2B2');
			    	        	
		       				  }, function() {
		       				  //点击取消后的回调函数
		       					  $http({
		       						  method:'POST',
		       						  url:"/slianOA-pc-web/mobile-ajax/auth/oaAttendance/cancelAttendance.do",
		       						  params:{"wechatAccount":data.user,"type":'signin'}
		       					  }).success(function(data){
		       						  
		       					  }).error(function(data){
		       						  
		       					  })
		       					  
		       					  
		       				  });
	       				
	       			/*	if(response == "正常"){
	       					$.toptip(response, "success");
				    	  }
	       				else{
	       					console.log("异常");
	       					$.toptip(response, "error");
	       				}*/

	       			}).error(function(){
	       			   console.log("传输失败");
	       		   });	       		 
	       }	            	              
	              $scope.signoff=function(){
					console.log('签退')				  
	            	 var signoutTime = $scope.getNewDate();
			if(address == ""){
				 data.getwechatpermission();
			 }
	            	 console.log($("#remark2").val());
					$("#signoutposition").text(address);
	            	  $http.get("/slianOA-pc-web/mobile-ajax/auth/oaAttendance/signOut.do", {
		       				params : {
		       					"wechatAccount":data.user, 
		       			    	  "signoutLatitude":latitude,
		       			    	  "signoutLongitude":longitude,
		       			    	  "signoutTime":signoutTime,
		       			    	  "signoutRemark":$("#remark2").val(),
		       			    	  "signoutAddress" : encodeURIComponent(address)
		       				}
		       			}).success(function(response) {
		       				//alert(response);
		       				$.confirm("签退状态为"+response+"，您是否要操作？", function() {
		       				  //点击确认后的回调函数
		       					$("#b2").attr('disabled',true);
			    	        	$("#b2").css('backgroundColor','#B2B2B2');
		       				  }, function() {
		       				  //点击取消后的回调函数
		       					  
		       					  
		       					  $http({
		       						  method:'POST',
		       						  url:"/slianOA-pc-web/mobile-ajax/auth/oaAttendance/cancelAttendance.do",
		       						  params:{"wechatAccount":data.user,"type":'signout'}
		       					  }).success(function(data){
		       						  
		       					  }).error(function(data){
		       						  
		       					  })
		       					  
		       					  
		       				  });
		       			/*	
		       				if(response == "正常"){
		       					$.toptip(response, 'success');
					    	  }
		       				else{console.log("异常");
		       					$.toptip(response, 'error');
		       				}*/

		       			});	            	
	       	   }	
	              $scope.getNewDate = function(){
	            	  var dateTime = new Date();
		          		var hh = dateTime.getHours();
		          		var mm = dateTime.getMinutes();
		          		var yy = dateTime.getMonth()+1;
		          		var dd = dateTime.getDate();
		          		mm = extra(mm);
		          		var t1=hh + ":" + mm ;
		          		var t2 = dateTime.getFullYear()+"-"+yy+"-"+dd+" "+t1;
		          		return t2;
	              };
	              
	      } ]);
	      	    