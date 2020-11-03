/**
 * 销售经理：综合分析
 */
function setHeight(){
	var top = $(this).combobox('getValue');
	if(top=='10'||top=='5') $('#main3').css('height','400px');
	else $('#main3').css('height','800px');
}
$(document).ready(function(){
	
	require.config({
		paths : {
			echarts : './pagejs'
		}
	});
	
	initPage();

	$("#search").click(function(){
	require([ 'echarts', 
	          'echarts/chart/bar', 
	          'echarts/chart/line' 
	          ], 
	          DrawCharts
	      );
	});
});

/**
 * 初始化页面
 */

function initPage(){
	
	
	setDefault();
	
//	require([ 'echarts', 
//	          'echarts/chart/bar', 
//	          'echarts/chart/line' 
//	          ], 
//	          DrawCharts
//	      );
}

function DrawCharts(ec){
	drawActiveCounterman(ec);
	drawActiveCustomer(ec);
	drawRoute(ec);
	drawDischargingPort(ec);
	drawShipCompany(ec);
}

function drawActiveCounterman(ec){
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
				text : '活跃销售',
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
				itemStyle: {
	                normal: {
	                    color: function(params) {
	                        // build a color map as your need.
	                        var colorList = [
	                          '#FF0000','#FF8C00','#FAD860','#ADFF2F','#60C0DD',
	                           '#00008B','#9932CC','#FF1493','#E9967A','#FFD700',
	                           '#D7504B','#00FF7F','#F4E001','#F0805A','#26C0C0'
	                        ];
	                        return colorList[params.dataIndex%15];
	                    },
	                    label: {
	                        show: true,
	                        position: 'right',
	                        formatter: '{b}\n{c}'
	                    }
	                }
	            },
				data : [ ],
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
		url: getContextPath()+'/factscreen/getactivecountermanformanager.do',
		data:{startdate:$("#startdate").datebox("getValue"),
				enddate:$("#enddate").datebox("getValue"),
				topnum:$("#topnum").combobox("getValue")
				},
		dataType:'json',
		success:function(result){
			options.legend.data=result.legend;

			if(result.category.length<1||result.series[0].data.length<1){
				options.yAxis[0].data=[''];
				options.series[0].data=[0];
//				alert("活跃用户查询结果为空，请更换数据查询条件！");
			}
			else{
				options.yAxis[0].data=result.category;
				options.series[0].data=result.series[0].data;
			}
				
			options.series[0].name=result.series[0].name;
			options.series[0].type=result.series[0].type;
			options.title.subtext=options.title.subtext+" "+result.category.length;
			myChart.setOption(options);
			myChart.hideLoading();
		},
		error:function(){
			alert("图表加载失败，请重试！");
			myChart.hideLoading();
		}

	});
}

function drawActiveCustomer(ec){
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
				text : '活跃客户',
				subtext : '根据所选时间段生成'
			},
			tooltip : {
				trigger : 'axis'
			},
			grid:{x:100},
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
				itemStyle: {
	                normal: {
	                    color: function(params) {
	                        // build a color map as your need.
	                        var colorList = [
	                          '#FF0000','#FF8C00','#FAD860','#ADFF2F','#60C0DD',
	                           '#00008B','#9932CC','#FF1493','#E9967A','#FFD700',
	                           '#D7504B','#00FF7F','#F4E001','#F0805A','#26C0C0'
	                        ];
	                        return colorList[params.dataIndex%15];
	                    },
	                    label: {
	                        show: true,
	                        position: 'right',
	                        formatter: '{b}\n{c}'
	                    }
	                }
	            },
				data : [ ],
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
		url: getContextPath()+'/factscreen/getactivecustomerformanager.do',
		data:{startdate:$("#startdate").datebox("getValue"),
				enddate:$("#enddate").datebox("getValue"),
				topnum:$("#topnum").combobox("getValue"),
				countermanid:$(".counterman").combobox("getValue")
				},
		dataType:'json',
		success:function(result){
			options.legend.data=result.legend;

			if(result.category.length<1||result.series[0].data.length<1){
				options.yAxis[0].data=[''];
				options.series[0].data=[0];
//				alert("活跃用户查询结果为空，请更换数据查询条件！");
			}
			else{
				options.yAxis[0].data=result.category;
				options.series[0].data=result.series[0].data;
			}
				
			options.series[0].name=result.series[0].name;
			options.series[0].type=result.series[0].type;
			options.title.subtext=options.title.subtext+" "+result.category.length;
			myChart.setOption(options);
			myChart.hideLoading();
		},
		error:function(){
			alert("图表加载失败，请重试！");
			myChart.hideLoading();
		}

	});
}

function drawRoute(ec) {
	var myChart2 = ec.init(document.getElementById('main2'));
	myChart2.showLoading({
		text : "图表数据正在努力加载..."
	});

		getChartData2(myChart2);


}

function getChartData2(myChart) {
	// 获取图表的option对象
//	var options = myChart.getOption();
	//动态加载echarts和所需图表，回调函数中可以初始化图表并驱动图表的生成
	var options = {
			title : {
				text : '热门航线',
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
				itemStyle: {
		                normal: {
		                    color: function(params) {
		                        // build a color map as your need.
		                        var colorList = [
		                          '#FF0000','#FF8C00','#FAD860','#ADFF2F','#60C0DD',
		                           '#00008B','#9932CC','#FF1493','#E9967A','#FFD700',
		                           '#D7504B','#00FF7F','#F4E001','#F0805A','#26C0C0'
		                        ];
		                        return colorList[params.dataIndex%15];
		                    },
		                    label: {
		                        show: true,
		                        position: 'right',
		                        formatter: '{b}\n{c}'
		                    }
		                }
		            },
				data : [ ],
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
		url: getContextPath()+'/factscreen/gethotrouteformanager.do',
		data:{startdate:$("#startdate").datebox("getValue"),
				enddate:$("#enddate").datebox("getValue"),
				countermanid:$(".counterman").combobox("getValue"),
				topnum:$("#topnum").combobox("getValue")},
		dataType:'json',
		success:function(result){
			options.legend.data=result.legend;
			if(result.category.length<1||result.series[0].data.length<1){
				options.yAxis[0].data=[''];
				options.series[0].data=[0];
//				alert("热门航线查询结果为空，请更换数据查询条件！");
			}
			else{
				options.yAxis[0].data=result.category;
				options.series[0].data=result.series[0].data;
			}
			options.series[0].name=result.series[0].name;
			options.series[0].type=result.series[0].type;
			options.title.subtext=options.title.subtext+" "+result.category.length;
			myChart.setOption(options);
			myChart.hideLoading();
		},
		error:function(){
			alert("图表加载失败，请重试！");
			myChart.hideLoading();
		}

	});
}

function drawDischargingPort(ec) {
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
				text : '热门港口',
				subtext : '根据所选时间段生成'
			},
			tooltip : {
				trigger : 'axis'
			},
			grid:{x:180},
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
				itemStyle: {
	                normal: {
	                    color: function(params) {
	                        // build a color map as your need.
	                        var colorList = [
	                          '#FF0000','#FF8C00','#FAD860','#ADFF2F','#60C0DD',
	                           '#00008B','#9932CC','#FF1493','#E9967A','#FFD700',
	                           '#D7504B','#00FF7F','#F4E001','#F0805A','#26C0C0'
	                        ];
	                        return colorList[params.dataIndex%15];
	                    },
	                    label: {
	                        show: true,
	                        position: 'right',
	                        formatter: '{b}\n{c}'
	                    }
	                }
	            },
				data : [ ],
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
		url: getContextPath()+'/factscreen/gethotdischargingportformanager.do',
		data:{startdate:$("#startdate").datebox("getValue"),
				enddate:$("#enddate").datebox("getValue"),
				countermanid:$(".counterman").combobox("getValue"),
				topnum:$("#topnum").combobox("getValue")},
		dataType:'json',
		success:function(result){
			options.legend.data=result.legend;
			if(result.category.length<1||result.series[0].data.length<1){
				options.yAxis[0].data=[''];
				options.series[0].data=[0];
//				alert("热门港口查询结果为空，请更换数据查询条件！");
			}
			else{
				options.yAxis[0].data=result.category;
				options.series[0].data=result.series[0].data;
			}
			options.series[0].name=result.series[0].name;
			options.series[0].type=result.series[0].type;
			options.title.subtext=options.title.subtext+" "+result.category.length;
			myChart.setOption(options);
			myChart.hideLoading();
		},
		error:function(){
			alert("图表加载失败，请重试！");
			myChart.hideLoading();
		}

	});
}

function drawShipCompany(ec){
	var myChart4 = ec.init(document.getElementById('main4'));
	myChart4.showLoading({
		text : "图表数据正在努力加载..."
	});

		getChartData4(myChart4);

}

function getChartData4(myChart) {
	// 获取图表的option对象

	var options = {
			title : {
				text : '热门船公司',
				subtext : '根据所选时间段生成'
			},
			tooltip : {
				trigger : 'axis'
			},
			grid:{x:100},
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
				itemStyle: {
	                normal: {
	                    color: function(params) {
	                        // build a color map as your need.
	                        var colorList = [
	                          '#FF0000','#FF8C00','#FAD860','#ADFF2F','#60C0DD',
	                           '#00008B','#9932CC','#FF1493','#E9967A','#FFD700',
	                           '#D7504B','#00FF7F','#F4E001','#F0805A','#26C0C0'
	                        ];
	                        return colorList[params.dataIndex%15];
	                    },
	                    label: {
	                        show: true,
	                        position: 'right',
	                        formatter: '{b}\n{c}'
	                    }
	                }
	            },
				data : [ ],
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
		url: getContextPath()+'/factscreen/gethotcompanyformanager.do',
		data:{startdate:$("#startdate").datebox("getValue"),
				enddate:$("#enddate").datebox("getValue"),
				countermanid:$(".counterman").combobox("getValue"),
				topnum:$("#topnum").combobox("getValue")},
		dataType:'json',
		success:function(result){
			options.legend.data=result.legend;
			if(result.category.length<1||result.series[0].data.length<1){
				options.yAxis[0].data=[''];
				options.series[0].data=[0];
//				alert("热门港口查询结果为空，请更换数据查询条件！");
			}
			else{
				options.yAxis[0].data=result.category;
				options.series[0].data=result.series[0].data;
			}
			options.series[0].name=result.series[0].name;
			options.series[0].type=result.series[0].type;
			options.title.subtext=options.title.subtext+" "+result.category.length;
			myChart.setOption(options);
			myChart.hideLoading();
		},
		error:function(){
			alert("图表加载失败，请重试！");
			myChart.hideLoading();
		}

	});
}