var latitude = "";
var longitude = "";
var note = "";
var toUserId="sunsui";
var flag = "0";
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
							// 地理位置
							data.getwechatpermission = function() {
								$http(
										{
											method : "GET",
											url : "/slianOAsys-wechat/controller/getParams.do",
											params : {
												'url' : data.url
											},
											dataType : "text"
										}).success(function(resp) {
									wechat.timestamp = resp.timestamp;
									wechat.nonceStr = resp.nonceStr;
									wechat.signature = resp.signature;
									// 调用微信sdk
									wx.config({
										debug : false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
										appId : 'wx6dfdff9bb253670b', // 必填，企业号的唯一标识，此处填写企业号corpid
										timestamp : wechat.timestamp, // 必填，生成签名的时间戳
										nonceStr : wechat.nonceStr, // 必填，生成签名的随机串
										signature : wechat.signature,// 必填，签名，见附录1
										jsApiList : [ 'getLocation' ]
									// 必填，需要使用的JS接口列表，所有JS接口列表见附录2
									});
								}).error(function() {
									alert("获取签名失败");
								});
								wx.ready(function() {

									wx.getLocation({
										type : 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
										success : function(res) {
											latitude = res.latitude; // 纬度，浮点数，范围为90
											// ~ -90
											longitude = res.longitude; // 经度，浮点数，范围为180
											// ~
											// -180。
											wechat.speed = res.speed; // 速度，以米/每秒计
											wechat.accuracy = res.accuracy; // 位置精度
										}

									});
								});
							}
							data.submitAppeal = function(){
								$http(
										{
											method : "GET",
											url : "/slianOAsys-wechat/attencontroller/submitAppeal.do",
											params : {
												"formUserId" : data.weChatAccount,
												"toUserId": toUserId,
												"content":note,
												"flag": flag
											},
											dataType : "text"
										}).success(function(res){
											if(res.status == 0){
												alert("没有你的信息！");
											}else if(res.status == 1){
												alert("没有审批人的信息！");
											}else if(res.status == 2){
												alert("今天没有你的考勤信息，无需申诉！");
											}else if(res.status == 3){
												alert("你提交的申诉还未审批，请耐心等待！");
											}else if(res.status == 4){
												alert("提交申诉成功!");
											}else if(res.status == 5){
												alert("你提交的申诉还未审批，请耐心等待！");
											}else{
												alert("提交申诉成功!");
											}
										}).error(function(){
											alert("error");
										})
							}
							data.showAttendanceInfo = function() {
								$http(
										{
											method : "GET",
											url : "/slianOAsys-wechat/attencontroller/showAttendanceInfo.do",
											params : {
												"userId" : data.weChatAccount
											},
											dataType : "text"
										})
										.success(
												function(res) {
													if (res.status == 0) {
														alert("没有你的信息！");
													} else if (res.status == 1) {
														alert("没有你的考勤信息!");
													} else if (res.status == 2) {
														$("#nowtime")
																.html(
																		res.signtime
																				+ "<br/>"
																				+ "<span style='color:#ff3333;font-size:0.6rem;'>"
																				+ res.signstatus
																				+ "</span>");
														$("#signinposition")
																.html(
																		res.signaddress);
														$("#nowtime1")
																.html(
																		res.offtime
																				+ "<br/>"
																				+ "<span style='color:#ff3333;font-size:0.6rem;'>"
																				+ res.offstatus
																				+ "</span>");
														$("#signoutposition")
																.html(
																		res.offaddress);
													}
												})

							}

							$(window)
									.load(
											function() {
												if (localStorage["weChatAccount"] != null) {
													data.weChatAccount = localStorage["weChatAccount"];
													data.getwechatpermission();
													data.showAttendanceInfo();
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
																	},
																	success : function(
																			res) {
																		console
																				.info(res);
																		data.weChatAccount = res.inspectorname;
																		localStorage["weChatAccount"] = res.inspectorname;
																		data
																				.getwechatpermission();
																		data
																				.showAttendanceInfo();
																	}
																});
													}
												}
												$("#addnotes-signin").click(
														function() {
															$("#boxdiv").show(
																	"slow");
														})
												$("#boxdiv").click(function() {
													$("#boxdiv").hide("slow");
												})

												$("#addnotes-signout").click(
														function() {
															$("#boxdiv1").show(
																	"slow");
														})
												$("#boxdiv1").click(function() {
													$("#boxdiv1").hide("slow");
												})
												// 点击签到备注里面的提交触发
												$("#submitbutton").click(
														function() {
															note = document.getElementById("remark").value;
															$("#boxdiv").hide("slow");
															data.submitAppeal();
														})
												// 点击签退备注里面的提交触发
												$("#submitbutton1").click(
														function() {
															note = document.getElementById("remark1").value;
															flag = "1";
															$("#boxdiv1").hide("slow");
															data.submitAppeal();
														})

											});

							$scope.signin = function() {
								var dateTime = new Date();
								var hh = dateTime.getHours();
								var mm = dateTime.getMinutes();
								var ss = dateTime.getSeconds();
								mm = extra(mm);
								ss = extra(ss);
								var t1 = hh + ":" + mm + ":" + ss;

								$http
										.get(
												"/slianOAsys-wechat/attencontroller/signin.do",
												{
													params : {
														"userId" : data.weChatAccount,
														"latitude" : latitude,
														"longitude" : longitude
													}
												})
										.success(
												function(response) {
													if (response.status == 1) {
														alert('超出定位范围无法签到！');
													} else if (response.status == 2) {
														alert('未到签到时间无法签到！');
													} else if (response.status == 3) {
														alert('已超出签到时间签到失败！');
													} else if (response.status == 4) {
														$("#nowtime")
																.html(
																		t1
																				+ "<br/>"
																				+ "<span style='color:#ff3333;font-size:0.6rem;'>你迟到了</span>");
														$("#signinposition")
																.html(
																		response.address);
													} else if (response.status == 5) {
														$("#nowtime")
																.html(
																		t1
																				+ "<br/>"
																				+ "<span style='color:#ff3333;font-size:0.6rem;'>正常上班</span>");
														$("#signinposition")
																.html(
																		response.address);
													} else if (response.status == 6) {
														alert("没有你的信息！");
													} else {
														alert('今日没有你的班次无法签到！');
													}

												});

							}
							$scope.signoff = function() {
								var dateTime = new Date();
								var hh = dateTime.getHours();
								var mm = dateTime.getMinutes();
								var ss = dateTime.getSeconds();
								mm = extra(mm);
								ss = extra(ss);
								var t11 = hh + ":" + mm + ":" + ss;
								$http
										.get(
												"/slianOAsys-wechat/attencontroller/signoff.do",
												{
													params : {
														"userId" : data.weChatAccount,
														"latitude" : latitude,
														"longitude" : longitude
													}
												})
										.success(
												function(response) {
													if (response.status == 1) {
														alert('超出定位范围无法签到！');
													} else if (response.status == 2) {
														alert('未到签退时间无法签退！');
													}
													/*
													 * else
													 * if(response.status==3){
													 * alert('已超出签到时间签到失败！'); }
													 */
													else if (response.status == 4) {
														$("#nowtime1")
																.html(
																		t11
																				+ "<br/>"
																				+ "<span style='color:#ff3333;font-size:0.6rem;'>你早退了</span>");
														$("#signoutposition")
																.html(
																		response.address);
													} else if (response.status == 5) {
														$("#nowtime1")
																.html(
																		t11
																				+ "<br/>"
																				+ "<span style='color:#ff3333;font-size:0.6rem;'>正常下班</span>");
														$("#signoutposition")
																.html(
																		response.address);
													} else if (response.status == 6) {

														alert("没有你的信息！");
													} else {
														alert('今日没有你的班次无法签退！');
													}
												});
							}

						} ]);
