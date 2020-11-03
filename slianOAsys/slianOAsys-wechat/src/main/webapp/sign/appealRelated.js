var status = "审批中";
//辅助变量，控制选择标签
var tab = ".one";
//var dataLength = 0;
var sign = angular.module('sign', []);

sign.config([ '$locationProvider', function($locationProvider) {
	$locationProvider.html5Mode(true);
} ]);
sign.controller('SignController', [ '$scope', '$location', '$http',
    function($scope, $location, $http) {
      var data = $scope.data = {};
      data.url = $location.absUrl(); 
      if ($location.search().code) {
          data.code = $location.search().code;
      }       
      var wechat = $scope.wechat = {};
      data.getAppealList = function() {
    	  $http({
	            method: "GET",
	            url: "/slianOAsys-wechat/attencontroller/showAppeal.do",
	            params: {
					"status" : status,
					"userId" : localStorage["weChatAccount"]
	            },
	            dataType: "json"
	        }).success(function (resp){
	        	var json = eval(resp);
	        	//alert(json);
	        	//dataLength = json.length;
	        	/*生成json.length个记录，每个记录显示姓名、审批状态、申诉时间和abnormal的拼接、审批时间
	        	 * 
	        	 */
	        	var a=$(tab);
        		
        		a.find("div:gt(0)").remove();
	        	for(var i=0;i<json.length;i++){
	        		if(json[i].handleTime==null){
	        			var handleTime = "";
	        		}else{
	        			var handleTime = json[i].handleTime;
	        		}
	        		
	        		$(tab).append( "<div class='appealAvator flexCenter'>"
		                       + "<div class='avator'>"+"</div>"    
		                       + "<div class='appeal-detail flexItem'>"
		                       + "<p id='repPersonName'>"+json[i].name+"</p>"
		                       + "<span id='repCreateTime'>"+json[i].appealTime+" "+json[i].abnormalStatus+"</span>"
		                       + "</div>"
		                       + "<div class='appeal-status' id='repAuditPast'>"
							   + status + "<br/>"
		                       + "<span id='time' style='color:#CCCCCC'>"+handleTime+"</span>"
							   + "</div>"  
		                     + "</div>");
	        	}
	        	if(status=="审批通过"){
	        		status = "审批未通过";
	        		data.getAppealList1();
	        	}
	        	
	        }).error(function (){
	        	alert("error");
	        })
      }     
      data.getAppealList1 = function() {
    	  $http({
	            method: "GET",
	            url: "/slianOAsys-wechat/attencontroller/showAppeal.do",
	            params: {
					"status" : status,
					"userId" : localStorage["weChatAccount"]
	            },
	            dataType: "json"
	        }).success(function (resp){
	        	var json = eval(resp);
	        	
	        	//dataLength = json.length;
	        	/*生成json.length个记录，每个记录显示姓名、审批状态、申诉时间和abnormal的拼接、审批时间
	        	 * 
	        	 */
	        	/*var a=$(tab);
      		
      		a.find("div:gt(0)").remove();*/
	        	for(var i=0;i<json.length;i++){
	        		if(json[i].handleTime==null){
	        			var handleTime = "";
	        		}else{
	        			var handleTime = json[i].handleTime;
	        		}
	        		
	        		$(tab).append( "<div class='appealAvator flexCenter'>"
		                       + "<div class='avator'>"+"</div>"    
		                       + "<div class='appeal-detail flexItem'>"
		                       + "<p id='repPersonName'>"+json[i].name+"</p>"
		                       + "<span id='repCreateTime'>"+json[i].appealTime+" "+json[i].abnormalStatus+"</span>"
		                       + "</div>"
		                       + "<div class='appeal-status' id='repAuditPast'>"
							   + status + "<br/>"
		                       + "<span id='time' style='color:#CCCCCC'>"+handleTime+"</span>"
							   + "</div>"  
		                     + "</div>");
	        	}
	        	/*if(status=="审批通过"){
	        		status = "审批未通过";
	        		data.getAppealList1();
	        	}*/
	        	
	        }).error(function (){
	        	alert("error");
	        })
    }     
        $(window).load(function () {
        	
            if (localStorage["weChatAccount"] != null ) {
            	
                data.weChatAccount = localStorage["weChatAccount"];
                data.getAppealList();
            }else{                   
              if ( data.code == null) {       
                var encodeurl = encodeURIComponent(data.url);
                window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx6dfdff9bb253670b&redirect_uri="
                    + encodeurl
                    + "&response_type=code&scope=snsapi_userinfo&state=0#wechat_redirect";
              } else{
                $.ajax({
                  url : "/slianOAsys-wechat/controller/onload.do" ,
                  type: 'GET',
                  dataType: 'json',
                  data:{"code" :data.code},
                  async:false,
                  error: function(r,sta){
                  alert("身份验证失败，请重试");
                  },
                  success : function(res) {
                	 
                    console.info(res);
                    data.weChatAccount = res.inspectorname;
                    localStorage["weChatAccount"] = res.inspectorname;
                    data.getAppealList();
                  }
                });            
              }  
            }
           
        });	 
      
        $scope.test1 = function(){
        	status="审批中";
        	tab=".one";
        	data.getAppealList();
        }
        $scope.test2 = function(){
        status="审批通过";
        	tab=".two";
        	data.getAppealList();
        	/*status="审批未通过";
        	data.getAppealList();*/
        }	            	              
        

 	   	       	   	      
} ]);