		  var latitude="";
		  var longitude="";	  
		  var address = "";
	      var sign = angular.module('sign', []);
		  sign.config([ '$locationProvider', function($locationProvider) {
	        $locationProvider.html5Mode(true);
	      } ]);
		  
	      sign.controller('myCtrl', [ '$scope', '$location', '$http',
	          function($scope, $location, $http) {
	    	  	localStorage.setItem('weChatAccount', 'lwy1581410450');
	            var data = $scope.data = {};
	            data.url = $location.absUrl();
	            if ($location.search().code) {
                    data.code = $location.search().code;
                }       
	            var wechat = $scope.wechat = {};
	            //地理位置
	            data.getwechatpermission = function () {
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
	    	        });
	            }
	    	        
	    	    data.GaoDe = function(){
	    	    	console.log("开始定位");
	    	    	mapObj = new AMap.Map('iCenter');
	    	    	mapObj.plugin('AMap.Geolocation', function () {
	    	    	    geolocation = new AMap.Geolocation({
	    	    	        enableHighAccuracy: true,//是否使用高精度定位，默认:true
	    	    	        timeout: 10000,          //超过10秒后停止定位，默认：无穷大
	    	    	        maximumAge: 0,           //定位结果缓存0毫秒，默认：0
	    	    	        convert: true,           //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
	    	    	        showButton: true,        //显示定位按钮，默认：true
	    	    	        buttonPosition: 'LB',    //定位按钮停靠位置，默认：'LB'，左下角
	    	    	        buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
	    	    	        showMarker: true,        //定位成功后在定位到的位置显示点标记，默认：true
	    	    	        showCircle: true,        //定位成功后用圆圈表示定位精度范围，默认：true
	    	    	        panToLocation: true,     //定位成功后将定位到的位置作为地图中心点，默认：true
	    	    	        zoomToAccuracy:true      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
	    	    	    });
	    	    	    mapObj.addControl(geolocation);
	    	    	    
	    	    	    geolocation.getCurrentPosition(function(status,result){
	    	    	    	console.log(status);
	    	    	    	if(status == 'complete'){
	    	    	    		console.log(result);
	    	    	    		latitude = result.position.lat;
	    	    	    		longitude = result.position.lng;
	    	    	    		
	    	    	    		var lnglatXY = result.position.lng+','+result.position.lat;
	    	    	    		//alert(lnglatXY);
    	    	    		    $.ajax({
	    	                    	type:"get",
	    	                    	dataType:'json',
	    	                    	data:{key:'736a2659c5db633783db53917d0900e6',
	    	                    		location:lnglatXY,
	    	                    		roadlevel:1
	    	                    		},
	    	                    	url:"http://restapi.amap.com/v3/geocode/regeo?parameters",
	    	                    	success:function(json){
	    	                    	
		    	                    	console.log(json);
		    	                    	console.log(json.info);
		    	                    	console.log(json.regeocode.formatted_address);
		    	                    	address = json.regeocode.formatted_address;
		    	                    	//alert(json.regeocode.formatted_address);
	    	                    	},
	    	                    	error : function(err){alert("服务端错误，请刷新浏览器后重试")} 
	    	                   })
	    	    	    		 
	    	    	    	}else{
	    	    	    		alert('定位失败，请刷新！');
	    	    	    	}
	    	    	    });
	    	    	    //AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
	    	    	  // AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
	    	    	});
	    	    	
	    	    	// 解析定位结果
	    	    	function onComplete(data){
	    	    		var str = ['定位成功'];
	    	    		console.log(data);
	    	    	}
	    	    	
	    	    	function onError(data){
	    	    		console.log(data);
	    	    	}
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
	    	        		   if(res.signinStatus == '请假'){
	    	        			   $("#b1").attr('disabled',true);
		    	        		   $("#b1").css('backgroundColor','#B2B2B2');
		    	        		   $('p#signinposition').text('请假');
	    	        		   }else{
			    	        	   $("#signinposition").text(res.signinAddress);
			    	        	   $("#remark").text(res.signinRemark);
			    	        	   $("#b1").attr('disabled',true);
			    	        	   $("#b1").css('backgroundColor','#B2B2B2');
	    	        		   }
		    	           }
		    	           if(res.signoutStatus && res.signoutStatus != 'cancel'){
		    	        	   if(res.signoutStatus=='请假'){
		    	        			 $("#b2").attr('disabled',true); 
		    	        			 $("#b2").css('backgroundColor','#B2B2B2');
		    	        			 $('p#signoutposition').text('请假');
		    	        		}else{
			    	        	   $("#signoutposition").text(res.signinAddress);
			    	        	   $("#remark2").text(res.signoutRemark);
			    	        	   $("#b2").attr('disabled',true);
			    	        	   $("#b2").css('backgroundColor','#B2B2B2');
		    	        		}
		    	           }
	    	           }
	    	          // data.getwechatpermission();
	    	           data.GaoDe();
	    	        }).error(function () {
	    	        	$.toptip('系统异常！', 'error');
	    	        });
	            }
	            
	              $(window).load(function () {
	            	  
	                  if (localStorage["weChatAccount"] != null ) {
	                      data.weChatAccount = localStorage["weChatAccount"];             
	                  //    data.getwechatpermission();
	                      data.GaoDe();
	                 //     alert("欢迎进入考勤页面！"+localStorage["weChatAccount"]);
	                      data.user = localStorage["weChatAccount"];
	                      $scope.initPage();
	                  }else{                   
	                    if ( data.code == null) {       
	                      var encodeurl = encodeURIComponent(data.url);
	                      window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2c6c0614f9474f25&redirect_uri="
	                          + encodeurl
	                          + "&response_type=code&scope=snsapi_userinfo&state=0#wechat_redirect";
	                    } else{
	                    	$.ajax({
	    		            	url: "/sliansoft-wechat/core/getUser.do",
	    		                type: "GET",
	    		                async:false,
	    		                data:{
	    		                    'code': $location.search().code,
	    		                    'corpId':"wx2c6c0614f9474f25"
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
	    		       $scope.initPage();          
	                    }  
	                  }
	            	 
	              });	    	           
	              $scope.signin=function(){
				  console.log('签到')
	            	var signinTime = $scope.getNewDate();
				  $("#signinposition").text(address);
				  console.log($("#remark").val());
	       		   $http({
	       			   method:'POST',
	       			   url:"/slianOA-pc-web/mobile-ajax/auth/oaAttendance/signIn.do",
	       				params : {
	       					  "wechatAccount":data.user, 
	       			    	  "signinLatitude":latitude,
	       			    	  "signinLongitude":longitude,
	       			    	  "signinTime":signinTime,
	       			    	  "signinRemark":$("#remark").val(),
	       			    	  "signinAddress" : encodeURIComponent(address)
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

	       			});	       		 
	       }	            	              
	              $scope.signoff=function(){
					console.log('签退')				  
	            	 var signoutTime = $scope.getNewDate();
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
	      	    