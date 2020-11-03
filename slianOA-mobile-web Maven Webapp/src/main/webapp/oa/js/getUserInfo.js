var myApp = angular.module('bodyApp', ['ngSanitize']);

myApp.controller('getUserInfo', ['$scope', '$location', '$http',function ($scope, $location, $http) {
    	   var data = $scope.data = {};  
    	     var wechat = $scope.wechat = {};
    	     wechat.successCount = 0;
    	     data.url = $location.absUrl();
    	     $scope.userinfoList = [];
    	     $scope.employee = {
	                  name: "" 
	              };
    	     $scope.result = {
	              };
    	     var searchURL = window.location.search;  
	    	 searchURL = searchURL.substring(1, searchURL.length);  
	    	 var code = searchURL.split("&")[0].split("=")[1];  
	    	 if(code){
	    		 data.code = code;
	    	 }
	    	 console.log("这里是userinfo");
    	     $(window).load(function () {
    	     
    		 if (localStorage["user"] != null) {
    		            data.user = localStorage["user"];
    		            //$scope.$broadcast('setUser',data.user);
    		        } else if (localStorage["user"] == null && data.code == null) {
    		            var encodeurl = encodeURIComponent(data.url);
    		            window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
    		            		"appid=wx7e27f3589e566640&redirect_uri=" + encodeurl 
    		            		+ "&response_type=code&scope=snsapi_userinfo&state=0&connect_redirect=1#wechat_redirect";
    		            //alert(data.url+" "+$location.search().code);
    		        }
    		        else if (localStorage["user"] == null && data.code != null) {
    		        	$.ajax({
    		            	url: "/sliansoft-wechat/core/getUser.do",
    		                type: "GET",
    		                async:false,
    		                data:{
    		                    'code': data.code,
    		                    'corpId':"wx7e27f3589e566640"
    		                },
    		                dataType:"json",
    		                success:function (res) {
    		                	data.user = res.userid; // 获取微信名
    		                	$scope.user = data.user;
    		                	console.log("这里是测试微信账户："+data.user);
    		                	localStorage.setItem("user", data.user);
    		                	$scope.$broadcast('setUser',data.user);
    		                },
    		                error:function () {
    		                	$.alert("身份验证失败，请刷新！");
    		                	wx.closeWindow();
    		                },
    		        });
    		        	//data.getwechatpermission();
    		            //data.initPage();
    		        }
    		   
  //  		   localStorage.setItem("user","njq");
 //  	 localStorage.setItem("user",'cxl');
  //  	    	 localStorage.setItem('user','lwy1581410450');
 //    	 localStorage.setItem('user','torchKing12138');
    	     });
                   
    	 }]);