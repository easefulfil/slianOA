var year = "";
var month = "";
var startTime = "";
var endTime = "";
var arr0 = [];// 正常
var arr1 = [];// 迟到
var arr2 = [];// 矿工
var arr3 = [];// 早退
var arr4 = [];// 漏签
var totalStatus1 = ("签到签退", "签到早退", "签到未签退", "迟到签退", "迟到早退", "迟到未签退","未签到签退", "未签到早退", "未签到未签退");


var sign = angular.module('sign', []);
sign.config([ '$locationProvider', function($locationProvider) {
	$locationProvider.html5Mode(true);
} ]);
sign
		.controller(
				'SignController',
				[
						'$scope',
						'$location',
						'$http',
						function($scope, $location, $http) {
							var data = $scope.data = {};
							data.url = $location.absUrl();
							if ($location.search().code) {
								data.code = $location.search().code;
							}
							var wechat = $scope.wechat = {};
							
							
							data.getCalenderDate = function() {
								 var buffer = new StringBuffer();
								 var buffer2 = new StringBuffer();
								 buffer.append(year.toString()).append("-").append(month).append("-01");
								 buffer2.append(year.toString()).append("-").append(month).append("-31");
								 startTime = buffer.toString();
								 endTime = buffer2.toString();
								 
								 $http({
					    	            method: "GET",
					    	            url: "/slianOAsys-wechat/attencontroller/attendanceCalendar.do",
					    	            params: {
					    	            	"startTime" : startTime,
											"endTime" : endTime,
											"userId" : localStorage["weChatAccount"]
					    	            },
					    	            dataType: "json"
					    	        }).success(function (resp){
					    	        	//alert(startTime);
					    	        	//alert(endTime);
					    	        	var json = eval(resp);
					    	        	 arr0 = [];// 正常
				    	        		 arr1 = [];// 迟到
				    	        		 arr2 = [];// 矿工
				    	        		 arr3 = [];// 早退
				    	        		 arr4 = [];// 漏签
					    	        	for(var l=0;l<json.length;l++){
					    	        		 
					    	        	    if(json[l].totalStatus==""||json[l].totalStatus==null){
					    	        	    	alert("没有信息！");
					    	        	    }else if(json[l].totalStatus=="签到签退"){
					    	        	    	// alert("if");
					    	        			for(var i=0;i<json[l].date.length;i++){
					    	        				// alert("签到签退for");
					    	        				arr0.push(json[l].date[i]);
					    	        			}
					    	        		}else if(json[l].totalStatus=="迟到签退"||json[l].totalStatus=="迟到早退"||json[l].totalStatus=="迟到未签退"){
					    	        			for(var i=0;i<json[l].date.length;i++){
					    	        				arr1.push(json[l].date[i]);
					    	        			}
					    	        		}else if(json[l].totalStatus=="未签到未签退"){
					    	        			for(var i=0;i<json[l].date.length;i++){
					    	        				arr2.push(json[l].date[i]);
					    	        			}
					    	        		}else if(json[l].totalStatus=="签到早退"||json[l].totalStatus=="未签到早退"){
					    	        			for(var i=0;i<json[l].date.length;i++){
					    	        				arr3.push(json[l].date[i]);
					    	        			}
					    	        		}else{
					    	        			for(var i=0;i<json[l].date.length;i++){
					    	        				arr4.push(json[l].date[i]);
					    	        				 // alert(arr4);
					    	        			}
					    	        		}
					    	        	}
					    	      
					    	        	var divs = $(".picker-calendar-day");
					    	        	for (var i = 0; i < divs.length; i++) {
					    	        		var a = 0;
					    	        		var b = 0;
					    	        		var c = 0;
					    	        		var d = 0;
					    	        		var e = 0;
					    	        		for (var j = 0; j < arr0.length; j++) {	
					    	        			if (divs[i].getAttribute("data-date") == arr0[j]) {
					    	        				var thespan = divs[i].children[0];
					    	        				$(thespan).css('background', '#66cc66');// 正常
					    	        				$(thespan).css('color', 'white');
					    	        				break;
					    	        			}
					    	        			a++;
					    	        		}
					    	        		for (var k = 0; k < arr1.length; k++) {
					    	        			if (divs[i].getAttribute("data-date")== arr1[k]) {
					    	        				var thespan = divs[i].children[0];
					    	        				$(thespan).css('background', '#ff6666');// 迟到
					    	        				$(thespan).css('color', 'white');
					    	        				break;
					    	        			}
					    	        			b++;
					    	        		}
					    	        		for (var l = 0; l < arr2.length; l++) {
					    	        			if (divs[i].getAttribute("data-date")== arr2[l]) {
					    	        				var thespan = divs[i].children[0];
					    	        				$(thespan).css('background', '#ff9933');// 旷工
					    	        				$(thespan).css('color', 'white');
					    	        				break;
					    	        			}
					    	        			c++;
					    	        		}
					    	        		for (var m = 0; m < arr3.length; m++) {
					    	        			if (divs[i].getAttribute("data-date") == arr3[m]) {
					    	        				var thespan = divs[i].children[0];
					    	        				$(thespan).css('background', '#66ccff');// 请假
					    	        				$(thespan).css('color', 'white');
					    	        				break;
					    	        			}
					    	        			d++;
					    	        		}
					    	        		for (var n = 0; n < arr4.length; n++) {
					    	        			if (divs[i].getAttribute("data-date") == arr4[n]) {
					    	        				var thespan = divs[i].children[0];
					    	        				$(thespan).css('background', '#cccc66');// 漏签
					    	        				$(thespan).css('color', 'white');
					    	        				break;
					    	        			}
					    	        			e++;
					    	        		}
					    	        	};
					    	        	document.getElementById("normal").innerHTML = a;
					    	        	document.getElementById("late").innerHTML = b;
					    	        	document.getElementById("absenteesim").innerHTML = c;
					    	        	document.getElementById("leave").innerHTML = d;
					    	        	document.getElementById("miss").innerHTML = e;
					    	        }).error(function (){
					    	        	alert("error");
					    	        })
							}
											
							// 这个function实现了获取用户userId
							$(window)
									.load(
											function() {
												var Time = new Date();
												var year1 = Time.getFullYear();
												var month1 = Time.getMonth();
												month1 = month1 + 1;
												year = year1;
												month = month1.toString();
												month=month<10?('0'+month):month;
												// alert(year + "~" + month);
												if (localStorage["weChatAccount"] != null) {
													data.weChatAccount = localStorage["weChatAccount"];
													data.getCalenderDate();
													// alert("1111");
													// data.getwechatpermission();
												} else {
													if (data.code == null) {
														var encodeurl = encodeURIComponent(data.url);
														window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx6dfdff9bb253670b&redirect_uri="
																+ encodeurl
																+ "&response_type=code&scope=snsapi_userinfo&state=0#wechat_redirect";
													} else {
														$
																.ajax({
																	url : "/slianOAsys-wechat/controller/onload.do",
																	type : 'GET',
																	dataType : 'json',
																	data : {
																		"code" : data.code
																	},
																	async : false,
																	error : function(
																			r,
																			sta) {
																		alert("身份验证失败，请重试");
																		// wx.closeWindow();
																	},
																	success : function(
																			res) {
																		console
																				.info(res);
																		data.weChatAccount = res.inspectorname;
																		localStorage["weChatAccount"] = res.inspectorname;
																		// data.getwechatpermission();
																		// displayScheduleList();
																		data.getCalenderDate();
																	}
																});
													}
												}
											});
							$(".picker-calendar-prev-month>.icon-prev").click(function() {
								//alert();
								var cm = $(".current-month-value").text();
								//function monthFormat(cm) {
									switch (cm) {
									case "一月":
										var cy = parseInt($(".current-year-value").text());
										var py = cy - 1;
										year = py;
										month = "12";
										break;
									case "二月":
										month = "01";
										break;
									case "三月":
										month = "02";
										break;
									case "四月":
										month = "03";
										break;
									case "五月":
										month = "04";
										break;
									case "六月":
										month = "05";
										break;
									case "七月":
										month = "06";
										break;
									case "八月":
										month = "07";
										break;
									case "九月":
										month = "08";
										break;
									case "十月":
										month = "09";
										break;
									case "十一月":
										month = "10";
										break;
									case "十二月":
										month = "11";
										break;
									}
								//}
								//monthFormat(cm);
								//alert(month);
								data.getCalenderDate();
							});
							$(".picker-calendar-next-month>.icon-next").click(function() {
								var cm = $(".current-month-value").text();
								var cy = parseInt($(".current-year-value").text());
								var ny = cy + 1;
								//function monthFormat(cm) {
									switch (cm) {
									case "一月":
										month = "02";
										break;
									case "二月":
										month = "03";
										break;
									case "三月":
										month = "04";
										break;
									case "四月":
										month = "05";
										break;
									case "五月":
										month = "06";
										break;
									case "六月":
										month = "07";
										break;
									case "七月":
										month = "08";
										break;
									case "八月":
										month = "09";
										break;
									case "九月":
										month = "10";
										break;
									case "十月":
										month = "11";
										break;
									case "十一月":
										month = "12";
										break;
									case "十二月":
										month = "01";
										year = ny;
										break;
									}
								//}
								//monthFormat(cm);
								data.getCalenderDate();
							});
							$(".picker-calendar-prev-year>.icon-prev").click(function() {
								var py = parseInt($(".current-year-value").text());
								year = py - 1;
								data.getCalenderDate();
							});
							$(".picker-calendar-next-year>.icon-next").click(function() {
								var ny = parseInt($(".current-year-value").text());
								year = ny + 1;
								data.getCalenderDate();
							});

						} ]);


