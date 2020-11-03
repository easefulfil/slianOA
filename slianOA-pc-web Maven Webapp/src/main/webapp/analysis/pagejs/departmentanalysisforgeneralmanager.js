/**
 * 总经理-部门行文为析图
 */

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
	
	if($.string.isNullOrEmpty($('#departments').combobox('getValues').toString())){
		alert("请选择部门。");
		return false;
	}
	drawQueryTimesForMulDepartment(ec);
	drawSendTimesForMulDepartment(ec);
//	drawQueryTimes(ec);
//	drawSendTimes(ec);
//	drawRoute(ec);
//	drawDischargingPort(ec);
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
				url : getContextPath()+'/factscreen/getMulDepQueryTimesForGeneralManager.do',
				data : {
					startdate : $("#startdate").datebox("getValue"),
					enddate : $("#enddate").datebox("getValue"),
//					departmentid : $("#department").combobox("getValue"),
//					countermanid : $("#counterman").combobox("getValues").join(','),
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
//					alert("图表加载失败，请重试！");
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
//			departmentid : $("#department").combobox("getValue"),
//			countermanid : $("#counterman").combobox("getValues").join(','),
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
//			alert("图表加载失败，请重试！");
			myChart.hideLoading();
		}

	});
}

