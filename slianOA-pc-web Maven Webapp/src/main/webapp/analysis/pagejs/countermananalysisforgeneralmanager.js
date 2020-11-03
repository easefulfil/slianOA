/**
 * 总经理-销售行文为析图
 */
function setHeight(){
	var top = $(this).combobox('getValue');
	if(top=='10'||top=='5') $('#main5').css('height','400px');
	else $('#main5').css('height','800px');
}
$(document).ready(function() {

			require.config({
				paths : {
					echarts : './pagejs'
				}
			});

			initPage();
			
			$("#search").click(
					function() {
						require([ 'echarts', 'echarts/chart/bar',
								'echarts/chart/line' ], DrawCharts);
					});
		});

/**
 * 初始化页面
 */

function initPage() {

	setDefault();

}

function DrawCharts(ec) {
//	drawQueryTimesForMulDepartment(ec);
//	drawSendTimesForMulDepartment(ec);
	drawQueryTimes(ec);
	drawSendTimes(ec);
	drawRoute(ec);
	drawDischargingPort(ec);
	drawShipCompany(ec);
	drawFlow(ec);
}

function drawQueryTimesForMulDepartment(ec) {
	var myChart = ec.init(document.getElementById('main'));
	myChart.showLoading({
		text : "图表数据正在努力加载..."
	});

	getChartData(myChart);

}

function getChartData(myChart) {
	// 获取图表的option对象

	var options = {
		title : {
			text : '部门查询行为',
			subtext : '根据所选时间段生成'
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : []
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		dataZoom : {
			show : true,
			start : 0,
			end : 10
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : []
		} ],
		yAxis : [ {
			type : 'value',
		} ],
		series : []
	};

	$.ajax({
				type : 'POST',
				async : false,
				url : getContextPath()+'/factscreenemployee/getcountermanquerytimes.do',
				data : {
					startdate : $("#startdate").datebox("getValue"),
					enddate : $("#enddate").datebox("getValue"),
					departmentid : $("#department").combobox("getValue"),
					countermanid : $("#counterman").combobox("getValues").join(','),
					departmentsid: $("#departments").combobox("getValues").join(',')
				},

				dataType : 'json',
				success : function(result) {
					options.legend.data = result.legend;
					options.xAxis[0].data = result.category;

					for (var i = 0; i < result.series.length; i++) {
						options.series.push(result.series[i]);
						options.series[i]["itemStyle"] = {
							normal : {
								areaStyle : {
									type : 'default'
								}
							}
						};
						options.series[i]["markLine"] = {
				                data : [
				                        {type : 'average', name: '平均值'}
				                    ]
				                };
						options.series[i]["markLine"] = {
				                data : [
				                        {type : 'average', name: '平均值'}
				                    ]
				                };
						options.series[i]["smooth"] = true;
					}
					options.title.subtext=options.title.subtext+" "+result.category.length;
					myChart.setOption(options);
					myChart.hideLoading();
				},
				error : function() {
					alert("图表加载失败，请重试！");
					myChart.hideLoading();
				}

			});
}

function drawSendTimesForMulDepartment(ec) {
	var myChart1 = ec.init(document.getElementById('main1'));
	myChart1.showLoading({
		text : "图表数据正在努力加载..."
	});

	getChartData1(myChart1);

}

function getChartData1(myChart) {
	// 获取图表的option对象

	var options = {
		title : {
			text : '部门微信推送行为',
			subtext : '根据所选时间段生成'
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : []
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		dataZoom : {
			show : true,
			start : 0,
			end : 10
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : []
		} ],
		yAxis : [ {
			type : 'value',
		} ],
		series : []
	};

	$.ajax({
		type : 'POST',
		async : false,
		url : getContextPath()+'/factscreen/getMulDepSendTimesForGeneralManager.do',
		data : {
			startdate : $("#startdate").datebox("getValue"),
			enddate : $("#enddate").datebox("getValue"),
			departmentid : $("#department").combobox("getValue"),
			countermanid : $("#counterman").combobox("getValues").join(','),
			departmentsid: $("#departments").combobox("getValues").join(',')
		},

		dataType : 'json',
		success : function(result) {
			options.legend.data = result.legend;
			options.xAxis[0].data = result.category;

			for (var i = 0; i < result.series.length; i++) {
				options.series.push(result.series[i]);
				options.series[i]["itemStyle"] = {
					normal : {
						areaStyle : {
							type : 'default'
						}
					}
				};
				options.series[i]["markLine"] = {
		                data : [
		                        {type : 'average', name: '平均值'}
		                    ]
		                };
				options.series[i]["markLine"] = {
		                data : [
		                        {type : 'average', name: '平均值'}
		                    ]
		                };
				options.series[i]["smooth"] = true;
			}
			options.title.subtext=options.title.subtext+" "+result.category.length;
			myChart.setOption(options);
			myChart.hideLoading();
		},
		error : function() {
			alert("图表加载失败，请重试！");
			myChart.hideLoading();
		}

	});
}

function drawQueryTimes(ec) {
	var myChart2 = ec.init(document.getElementById('main2'));
	myChart2.showLoading({
		text : "图表数据正在努力加载..."
	});

	getChartData2(myChart2);

}

function getChartData2(myChart) {
	// 获取图表的option对象

	var options = {
		title : {
			text : '销售查询行为',
			subtext : '根据所选时间段生成'
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : []
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		dataZoom : {
			show : true,
			start : 0,
			end : 10
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : []
		} ],
		yAxis : [ {
			type : 'value',
		} ],
		series : []
	};

	$.ajax({
		type : 'GET',
		async : false,
		url : getContextPath()+'/factscreenemployee/getCountermanQueryTimes.do',
		data : {
			startdate : $("#startdate").datebox("getValue"),
			enddate : $("#enddate").datebox("getValue"),
			departmentid : $("#department").combobox("getValue"),
			countermanid : $("#counterman").combobox("getValues").join(',')
		},

		dataType : 'json',
		success : function(result) {
			options.legend.data = result.legend;
			options.xAxis[0].data = result.category;

			for (var i = 0; i < result.series.length; i++) {
				options.series.push(result.series[i]);
				options.series[i]["itemStyle"] = {
					normal : {
						areaStyle : {
							type : 'default'
						}
					}
				};
				options.series[i]["markLine"] = {
		                data : [
		                        {type : 'average', name: '平均值'}
		                    ]
		                };
				options.series[i]["markLine"] = {
		                data : [
		                        {type : 'average', name: '平均值'}
		                    ]
		                };
				options.series[i]["smooth"] = true;
			}
			options.title.subtext=options.title.subtext+" "+result.category.length;
			myChart.setOption(options);
			myChart.hideLoading();
		},
		error : function() {
			alert("图表加载失败，请重试！");
			myChart.hideLoading();
		}

	});
}

function drawSendTimes(ec) {
	var myChart3 = ec.init(document.getElementById('main3'));
	myChart3.showLoading({
		text : "图表数据正在努力加载..."
	});

	getChartData3(myChart3);

}

function getChartData3(myChart) {
	// 获取图表的option对象

	var options = {
		title : {
			text : '销售微信推送行为',
			subtext : '根据所选时间段生成'
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : []
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		dataZoom : {
			show : true,
			start : 0,
			end : 10
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : []
		} ],
		yAxis : [ {
			type : 'value',
		} ],
		series : []
	};

	$.ajax({
		type : 'POST',
		async : false,
		url : getContextPath()+'/factscreenemployee/getCountermanSendTimes.do',
		data : {
			startdate : $("#startdate").datebox("getValue"),
			enddate : $("#enddate").datebox("getValue"),
			departmentid : $("#department").combobox("getValue"),
			countermanid : $("#counterman").combobox("getValues").join(',')
		},

		dataType : 'json',
		success : function(result) {
			options.legend.data = result.legend;
			options.xAxis[0].data = result.category;

			for (var i = 0; i < result.series.length; i++) {
				options.series.push(result.series[i]);
				options.series[i]["itemStyle"] = {
					normal : {
						areaStyle : {
							type : 'default'
						}
					}
				};
				options.series[i]["markLine"] = {
		                data : [
		                        {type : 'average', name: '平均值'}
		                    ]
		                };
				options.series[i]["markLine"] = {
		                data : [
		                        {type : 'average', name: '平均值'}
		                    ]
		                };
				options.series[i]["smooth"] = true;
			}
			options.title.subtext=options.title.subtext+" "+result.category.length;
			myChart.setOption(options);
			myChart.hideLoading();
		},
		error : function() {
			alert("图表加载失败，请重试！");
			myChart.hideLoading();
		}

	});
}

function drawRoute(ec) {
	var myChart4 = ec.init(document.getElementById('main4'));
	myChart4.showLoading({
		text : "图表数据正在努力加载..."
	});

	getChartData4(myChart4);

}

function getChartData4(myChart) {
	// 获取图表的option对象
	// var options = myChart.getOption();
	// 动态加载echarts和所需图表，回调函数中可以初始化图表并驱动图表的生成
	var options = {
		title : {
			text : '关注航线',
			subtext : '根据所选时间段生成'
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : []
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		xAxis : [ {
			type : 'value',
			boundaryGap : [ 0, 0.01 ]
		} ],
		yAxis : [ {
			type : 'category',
			data : []
		} ],
		series : [ {
			name : '',
			type : '',
			itemStyle : {
				normal : {
					color : function(params) {
						// build a color map as your need.
						var colorList = [ '#FF0000', '#FF8C00', '#FAD860',
								'#ADFF2F', '#60C0DD', '#00008B', '#9932CC',
								'#FF1493', '#E9967A', '#FFD700', '#D7504B',
								'#00FF7F', '#F4E001', '#F0805A', '#26C0C0' ];
						return colorList[params.dataIndex%15];
					},
					label : {
						show : true,
						position : 'right',
						formatter : '{b}\n{c}'
					}
				}
			},
			data : [],
			markLine : {
				data : [ {
					type : 'average',
					name : '平均值'
				} ]
			}
		} ]
	};

	$
			.ajax({
				type : 'POST',
				async : false,
				url : getContextPath()+'/factscreenemployee/getHotRoutes.do',
				data : {
					startdate : $("#startdate").datebox("getValue"),
					enddate : $("#enddate").datebox("getValue"),
					topnum : $("#topnum").combobox("getValue"),
					departmentid : $("#department").combobox("getValue"),
					countermanids : $("#counterman").combobox("getValues").join(",")
				},
				dataType : 'json',
				success : function(result) {
					options.legend.data = result.legend;
					if (result.category.length < 1
							|| result.series[0].data.length < 1) {
						options.yAxis[0].data = [ '' ];
						options.series[0].data = [ 0 ];
//						alert("关注航线查询结果为空，请更换数据查询条件！");
					} else {
						options.yAxis[0].data = result.category;
						options.series[0].data = result.series[0].data;
					}
					options.series[0].name = result.series[0].name;
					options.series[0].type = result.series[0].type;
					options.title.subtext=options.title.subtext+" "+result.category.length;
					myChart.setOption(options);
					myChart.hideLoading();
				},
				error : function() {
					alert("图表加载失败，请重试！");
					myChart.hideLoading();
				}

			});
}

function drawDischargingPort(ec) {
	var myChart5 = ec.init(document.getElementById('main5'));
	myChart5.showLoading({
		text : "图表数据正在努力加载..."
	});

	getChartData5(myChart5);

}

function getChartData5(myChart) {
	// 获取图表的option对象

	var options = {
		title : {
			text : '关注港口',
			subtext : '根据所选时间段生成'
		},
		tooltip : {
			trigger : 'axis'
		},
		grid : {
			x : 180
		},
		legend : {
			data : []
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		xAxis : [ {
			type : 'value',
			boundaryGap : [ 0, 0.01 ]
		} ],
		yAxis : [ {
			type : 'category',
			data : []
		} ],
		series : [ {
			name : '',
			type : '',
			itemStyle : {
				normal : {
					color : function(params) {
						// build a color map as your need.
						var colorList = [ '#FF0000', '#FF8C00', '#FAD860',
								'#ADFF2F', '#60C0DD', '#00008B', '#9932CC',
								'#FF1493', '#E9967A', '#FFD700', '#D7504B',
								'#00FF7F', '#F4E001', '#F0805A', '#26C0C0' ];
						return colorList[params.dataIndex%15];
					},
					label : {
						show : true,
						position : 'right',
						formatter : '{b}\n{c}'
					}
				}
			},
			data : [],
			markLine : {
				data : [ {
					type : 'average',
					name : '平均值'
				} ]
			}
		} ]
	};
	$
			.ajax({
				type : 'POST',
				async : false,
				url : getContextPath()+'/factscreenemployee/getHotDischargingports.do',
				data : {
					startdate : $("#startdate").datebox("getValue"),
					enddate : $("#enddate").datebox("getValue"),
					topnum : $("#topnum").combobox("getValue"),
					departmentid : $("#department").combobox("getValue"),
					countermanids : $("#counterman").combobox("getValues").join(",")
				},
				dataType : 'json',
				success : function(result) {
					options.legend.data = result.legend;
					if (result.category.length < 1
							|| result.series[0].data.length < 1) {
						options.yAxis[0].data = [ '' ];
						options.series[0].data = [ 0 ];
//						alert("关注港口查询结果为空，请更换数据查询条件！");
					} else {
						options.yAxis[0].data = result.category;
						options.series[0].data = result.series[0].data;
					}
					options.series[0].name = result.series[0].name;
					options.series[0].type = result.series[0].type;
					options.title.subtext=options.title.subtext+" "+result.category.length;
					myChart.setOption(options);
					myChart.hideLoading();
				},
				error : function() {
					alert("图表加载失败，请重试！");
					myChart.hideLoading();
				}

			});
}


function drawShipCompany(ec) {
	var myChart6 = ec.init(document.getElementById('main6'));
	myChart6.showLoading({
		text : "图表数据正在努力加载..."
	});

	getChartData6(myChart6);

}


function getChartData6(myChart) {
	// 获取图表的option对象
	// var options = myChart.getOption();
	// 动态加载echarts和所需图表，回调函数中可以初始化图表并驱动图表的生成
	var options = {
		title : {
			text : '关注船公司',
			subtext : '根据所选时间段生成'
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : []
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		xAxis : [ {
			type : 'value',
			boundaryGap : [ 0, 0.01 ]
		} ],
		yAxis : [ {
			type : 'category',
			data : []
		} ],
		series : [ {
			name : '',
			type : '',
			itemStyle : {
				normal : {
					color : function(params) {
						// build a color map as your need.
						var colorList = [ '#FF0000', '#FF8C00', '#FAD860',
								'#ADFF2F', '#60C0DD', '#00008B', '#9932CC',
								'#FF1493', '#E9967A', '#FFD700', '#D7504B',
								'#00FF7F', '#F4E001', '#F0805A', '#26C0C0' ];
						return colorList[params.dataIndex%15];
					},
					label : {
						show : true,
						position : 'right',
						formatter : '{b}\n{c}'
					}
				}
			},
			data : [],
			markLine : {
				data : [ {
					type : 'average',
					name : '平均值'
				} ]
			}
		} ]
	};

	$
			.ajax({
				type : 'POST',
				async : false,
				url : getContextPath()+'/factscreen/getcompanyofgmanageremployee.do',
				data : {
					startdate : $("#startdate").datebox("getValue"),
					enddate : $("#enddate").datebox("getValue"),
					topnum : $("#topnum").combobox("getValue"),
					departmentid : $("#department").combobox("getValue"),
					countermanids : $("#counterman").combobox("getValues").join(",")
				},
				dataType : 'json',
				success : function(result) {
					options.legend.data = result.legend;
					if (result.category.length < 1
							|| result.series[0].data.length < 1) {
						options.yAxis[0].data = [ '' ];
						options.series[0].data = [ 0 ];
//						alert("关注航线查询结果为空，请更换数据查询条件！");
					} else {
						options.yAxis[0].data = result.category;
						options.series[0].data = result.series[0].data;
					}
					options.series[0].name = result.series[0].name;
					options.series[0].type = result.series[0].type;
					options.title.subtext=options.title.subtext+" "+result.category.length;
					myChart.setOption(options);
					myChart.hideLoading();
				},
				error : function() {
					alert("图表加载失败，请重试！");
					myChart.hideLoading();
				}

			});
}

function drawFlow(ec) {
	var myChart7 = ec.init(document.getElementById('main7'));
	myChart7.showLoading({
		text : "图表数据正在努力加载..."
	});

	getChartData7(myChart7);

}


function getChartData7(myChart) {
	// 获取图表的option对象
	// var options = myChart.getOption();
	// 动态加载echarts和所需图表，回调函数中可以初始化图表并驱动图表的生成
	var options = {
		title : {
			text : ' 流量入口统计',
			subtext : '根据所选时间段生成'
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : []
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		xAxis : [ {
			type : 'value',
			boundaryGap : [ 0, 0.01 ]
		} ],
		yAxis : [ {
			type : 'category',
			data : []
		} ],
		series : [ {
			name : '',
			type : '',
			itemStyle : {
				normal : {
					color : function(params) {
						// build a color map as your need.
						var colorList = [ '#FF0000', '#FF8C00', '#FAD860',
								'#ADFF2F', '#60C0DD', '#00008B', '#9932CC',
								'#FF1493', '#E9967A', '#FFD700', '#D7504B',
								'#00FF7F', '#F4E001', '#F0805A', '#26C0C0' ];
						return colorList[params.dataIndex%15];
					},
					label : {
						show : true,
						position : 'right',
						formatter : '{b}\n{c}'
					}
				}
			},
			data : [],
			markLine : {
				data : [ {
					type : 'average',
					name : '平均值'
				} ]
			}
		} ]
	};

	$.ajax({
				type : 'POST',
				async : false,
				url : getContextPath()+'/factscreen/getflowofgmanageremployee.do',
				data : {
					startdate : $("#startdate").datebox("getValue"),
					enddate : $("#enddate").datebox("getValue"),
					topnum : $("#topnum").combobox("getValue"),
					departmentid : $("#department").combobox("getValue"),
					countermanids : $("#counterman").combobox("getValues").join(",")
				},
				dataType : 'json',
				success : function(result) {
					options.legend.data = result.legend;
					if (result.category.length < 1
							|| result.series[0].data.length < 1) {
						options.yAxis[0].data = [ '' ];
						options.series[0].data = [ 0 ];
//						alert("关注航线查询结果为空，请更换数据查询条件！");
					} else {
						options.yAxis[0].data = result.category;
						options.series[0].data = result.series[0].data;
					}
					options.series[0].name = result.series[0].name;
					options.series[0].type = result.series[0].type;
					options.title.subtext=options.title.subtext+" "+result.category.length;
					myChart.setOption(options);
					myChart.hideLoading();
				},
				error : function() {
					alert("图表加载失败，请重试！");
					myChart.hideLoading();
				}

			});
}