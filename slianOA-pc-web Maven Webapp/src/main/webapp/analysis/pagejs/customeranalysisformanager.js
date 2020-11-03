/**
 * 销售经理客户行为分析图
 */

var mes="";
var ditail="";

function setHeight(){
	var top = $(this).combobox('getValue');
	if(top=='10'||top=='5') $('#main1').css('height','400px');
	else $('#main1').css('height','800px');
}
$(document).ready(function(){
	
	require.config({
		paths : {
			echarts : './pagejs'
		}
	});

	initPage();
	
	
	$("#search").click(function(){
	$(".message").css("display","none");
	require([ 'echarts', 
	          'echarts/chart/bar', 
	          'echarts/chart/line' 
	          ], 
	          DrawCharts
	      );
	
	});
});

function initPage() {

	setDefault();

	
}

function DrawCharts(ec){
	drawRoute(ec);
	drawDischargingPort(ec);
	drawQueryTimes(ec);
	drawShipCompany(ec);
	drawFlow(ec);
}


function drawRoute(ec) {
	var myChart = ec.init(document.getElementById('main'));
	myChart.showLoading({
		text : "图表数据正在努力加载..."
	});

		getChartData(myChart);


}

function getChartData(myChart) {
	// 获取图表的option对象
//	var options = myChart.getOption();
	//动态加载echarts和所需图表，回调函数中可以初始化图表并驱动图表的生成
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
		url:getContextPath()+'/factscreen/top10routeformanager.do',
		data:{startdate:$("#startdate").datebox('getValue'),
				enddate:$("#enddate").datebox('getValue'),
				topnum:$("#topnum").combobox("getValue"),
				countermanid:$(".counterman").combobox("getValue"),
				customerid:$(".customer").combobox("getValue")},
		dataType:'json',
		success:function(result){
			options.legend.data=result.legend;
			if(result.category.length<1||result.series[0].data.length<1){
				options.yAxis[0].data=[''];
				options.series[0].data=[0];
//				alert("关注航线查询结果为空，请更换数据查询条件！");
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
	
	var ecConfig = require('echarts/config');
	function eConsole(param){
		if(typeof param.name != 'undefined'){
			mes=param.name;
		}
		document.getElementById('message').style.display="block";
		$.ajax({
			type : 'POST',
			async : false,
			url:getContextPath()+'/detail/routedetailofma.do',
			data:{startdate:$("#startdate").datebox('getValue'),
					enddate:$("#enddate").datebox('getValue'),
					countermanid:$(".counterman").combobox("getValue"),
					mes:mes},
			dataType:'json',
			success:function(result){
				detail=result;
			},
			error:function(){
				console.log("获取失败");
			}

		});
		document.getElementById('message').innerHTML=mes +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+detail;
	}
	if($(".customer").combobox("getValue")==""||$(".customer").combobox("getValue")==null){
		myChart.on(ecConfig.EVENT.DBLCLICK, eConsole);
		
	}
	else document.getElementById('message').style.display="none";
}


function drawDischargingPort(ec) {
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
				text : '关注港口',
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
		url:getContextPath()+'/factscreen/topdischargingportformanager.do',
		data:{startdate:$("#startdate").datebox('getValue'),
				enddate:$("#enddate").datebox('getValue'),
				topnum:$("#topnum").combobox("getValue"),
				countermanid:$(".counterman").combobox("getValue"),
				customerid:$(".customer").combobox("getValue")},
		dataType:'json',
		success:function(result){
			options.legend.data=result.legend;
			if(result.category.length<1||result.series[0].data.length<1){
				options.yAxis[0].data=[''];
				options.series[0].data=[0];
//				alert("关注港口查询结果为空，请更换数据查询条件！");
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
	var ecConfig = require('echarts/config');
	function eConsole(param){
		if(typeof param.name != 'undefined'){
			mes=param.name;
		}
		document.getElementById('message1').style.display="block";
		$.ajax({
			type : 'POST',
			async : false,
			url:getContextPath()+'/detail/portdetailofma.do',
			data:{startdate:$("#startdate").datebox('getValue'),
					enddate:$("#enddate").datebox('getValue'),
					countermanid:$(".counterman").combobox("getValue"),
					mes:mes},
			dataType:'json',
			success:function(result){
				detail=result;
			},
			error:function(){
				console.log("获取失败");
			}

		});
		document.getElementById('message1').innerHTML=mes +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+detail;
	}
	if($(".customer").combobox("getValue")==""||$(".customer").combobox("getValue")==null){
		myChart.on(ecConfig.EVENT.DBLCLICK, eConsole);
		
	}
	else document.getElementById('message1').style.display="none";
}


function drawQueryTimes(ec){
	var myChart2 = ec.init(document.getElementById('main3'));
	myChart2.showLoading({
		text : "图表数据正在努力加载..."
	});

		getChartData2(myChart2);


}



function getChartData2(myChart) {
	// 获取图表的option对象

	var options = {
			title : {
				text : '客户查询行为',
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
			dataZoom :{
				show : true,
				start : 0,
				end : 10
			},
			xAxis : [ {
				type : 'category',
				data : []
			} ],
			yAxis : [ {
				type : 'value',
				boundaryGap : [ 0, 0.01 ]
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
		url:getContextPath()+'/factscreen/querytimesformanager.do',
		data:{startdate:$("#startdate").datebox('getValue'),
				enddate:$("#enddate").datebox('getValue'),
				countermanid:$(".counterman").combobox("getValue"),
				customerid:$(".customer").combobox("getValue")},
		dataType:'json',
		success:function(result){
			options.legend.data=result.legend;

			if(result.category.length<1||result.series[0].data.length<1){
				options.xAxis[0].data=[''];
				options.series[0].data=[0];
//				alert("时间段内查询次数结果为空，请更换数据查询条件！");
			}
			else{
				options.xAxis[0].data=result.category;
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


function drawShipCompany(ec) {
	var myChart3 = ec.init(document.getElementById('main2'));
	myChart3.showLoading({
		text : "图表数据正在努力加载..."
	});

		getChartData3(myChart3);


}


function getChartData3(myChart) {
	// 获取图表的option对象
//	var options = myChart.getOption();
	//动态加载echarts和所需图表，回调函数中可以初始化图表并驱动图表的生成
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
		url:getContextPath()+'/factscreen/gethotcompanyofmanager.do',
		data:{startdate:$("#startdate").datebox('getValue'),
				enddate:$("#enddate").datebox('getValue'),
				topnum:$("#topnum").combobox("getValue"),
				countermanid:$(".counterman").combobox("getValue"),
				customerid:$(".customer").combobox("getValue")},
		dataType:'json',
		success:function(result){
			options.legend.data=result.legend;
			if(result.category.length<1||result.series[0].data.length<1){
				options.yAxis[0].data=[''];
				options.series[0].data=[0];
//				alert("关注航线查询结果为空，请更换数据查询条件！");
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
	var ecConfig = require('echarts/config');
	function eConsole(param){
		if(typeof param.name != 'undefined'){
			mes=param.name;
		}
		document.getElementById('message2').style.display="block";
		$.ajax({
			type : 'POST',
			async : false,
			url:getContextPath()+'/detail/companydetailofma.do',
			data:{startdate:$("#startdate").datebox('getValue'),
					enddate:$("#enddate").datebox('getValue'),
					countermanid:$(".counterman").combobox("getValue"),
					mes:mes},
			dataType:'json',
			success:function(result){
				detail=result;
			},
			error:function(){
				console.log("获取失败");
			}

		});
		document.getElementById('message2').innerHTML=mes +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+detail;
	}
	if($(".customer").combobox("getValue")==""||$(".customer").combobox("getValue")==null){
		myChart.on(ecConfig.EVENT.DBLCLICK, eConsole);
		
	}
	else document.getElementById('message2').style.display="none";
	
}

function drawFlow(ec) {
	var myChart4 = ec.init(document.getElementById('main4'));
	myChart4.showLoading({
		text : "图表数据正在努力加载..."
	});

		getChartData4(myChart4);


}

function getChartData4(myChart) {
	// 获取图表的option对象
//	var options = myChart.getOption();
	//动态加载echarts和所需图表，回调函数中可以初始化图表并驱动图表的生成
	var options = {
			title : {
				text : '流量入口统计',
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
		url:getContextPath()+'/factscreen/getflowofmanager.do',
		data:{startdate:$("#startdate").datebox('getValue'),
				enddate:$("#enddate").datebox('getValue'),
				topnum:$("#topnum").combobox("getValue"),
				countermanid:$(".counterman").combobox("getValue"),
				customerid:$(".customer").combobox("getValue")},
		dataType:'json',
		success:function(result){
			options.legend.data=result.legend;
			if(result.category.length<1||result.series[0].data.length<1){
				options.yAxis[0].data=[''];
				options.series[0].data=[0];
//				alert("关注航线查询结果为空，请更换数据查询条件！");
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