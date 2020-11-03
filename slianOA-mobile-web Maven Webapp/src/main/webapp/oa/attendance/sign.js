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
                      //调用微信sdk
	    	            wx.config({
	    	                debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	    	                appId: 'wx2c6c0614f9474f25', // 必填，企业号的唯一标识，此处填写企业号corpid	    	          
	    	                timestamp: wechat.timestamp, // 必填，生成签名的时间戳
	    	                nonceStr: wechat.nonceStr, // 必填，生成签名的随机串
	    	                signature: wechat.signature,// 必填，签名，见附录1
	    	                jsApiList: [
	    	                    'getLocation'
	    	                ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	    	            });
	    	        }).error(function () {
	    	            alert("获取签名失败");
	    	        });
	    	        wx.ready(function () {
	    	            wx.getLocation({
	    	                type: 'gcj02', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
	    	                success: function (res) {
	    	                    latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
	    	                    longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
	    	                    wechat.speed = res.speed; // 速度，以米/每秒计
	    	                    wechat.accuracy = res.accuracy; // 位置精度
	    	                    console.log("lat"+latitude);
	    	                    console.log("long"+longitude);
	    	                    /*var geocoder, map, marker = null;
	    		 	    	       
	    		    	        geocoder = new qq.maps.Geocoder();
	    		    	      //对指定经纬度进行解析
	    		    	        var latLng = new qq.maps.LatLng(latitude, longitude);
	    		    	        geocoder.getAddress(latLng);
	    		    	        //设置服务请求成功的回调函数
	    		    	        geocoder.setComplete(function(result) {
	    		    	            address = result.detail.address;
	    		    	            console.log(address);
	    		    	        });
	    		    	      //若服务请求失败，则运行以下函数
	    		                geocoder.setError(function() {
	    		                    alert("出错了，请输入正确的经纬度！！！");
	    		                });*/
	    	                    var location = latitude+","+longitude;
	    	                    console.log("location"+location);
	    	                    var sdata={
	    	                    		location:location,
	    	                    		key:"EFCBZ-JWWR6-GEPS4-EWRDN-6MEA2-6XBSK",
	    	                    		get_poi:0,
	    	                    		coord_type:5
	    	                   }
	    	                    
	    	                    var url="http://apis.map.qq.com/ws/geocoder/v1/";
	    	                    sdata.output="jsonp"; 
	    	                    $.ajax({
	    	                    	type:"get",
	    	                    	dataType:'jsonp',
	    	                    	data:sdata,
	    	                    	
	    	                    	 jsonp:"callback",
	    	                    	 url:url,
	    	                    	success:function(json){
	    	                    	var toStr = JSON.stringify(json);
	    	                    	console.log("str: "+toStr);
	    	                    	console.log(json.result.address);
	    	                    	address = json.result.address;
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
	    	        		if(res.signinStatus=='请假'){
	    	        			 $("#b1").attr('disabled',true);
	    	        			 $("#b1").css('backgroundColor','#B2B2B2');
	    	        			 $('p#signinposition').text('请假');
	    	        		}else{
	    	        			
	    	        		}
	    	        	
	    	        		if(res.signoutStatus=='请假'){
	    	        			 $("#b2").attr('disabled',true); 
	    	        			 $("#b2").css('backgroundColor','#B2B2B2');
	    	        			 $('p#signoutposition').text('请假');
	    	        		}else{
	    	        			
	    	        		}
	    	         alert();
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
	    	        	   if(res.signinStatus){
		    	        	   $("#signinposition").text(res.signinAddress);
		    	        	   $("#remark").text(res.signinRemark);
		    	        	   $("#b1").attr('disabled',true);
		    	        	   $("#b1").css('backgroundColor','#B2B2B2');
		    	           }
		    	           if(res.signoutStatus){
		    	        	   $("#signoutposition").text(res.signinAddress);
		    	        	   $("#remark2").text(res.signoutRemark);
		    	        	   $("#b2").attr('disabled',true);
		    	        	   $("#b2").css('backgroundColor','#B2B2B2');
		    	           }
	    	           }
	    	           data.getwechatpermission();
	    	        }).error(function () {
	    	        	$.toptip('系统异常！', 'error');
	    	        });
	            }
	            
	              $(window).load(function () {
	            	  localStorage.setItem("weChatAccount", 'lwy1581410450');
	            	  console.log("开始！");
	                  if (localStorage["weChatAccount"] != null ) {
	                      data.weChatAccount = localStorage["weChatAccount"];             
	                      data.getwechatpermission();
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
	    		                	wx.closeWindow();
	    		                },
	    		        });
	    		            data.initPage();          
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
	      	    