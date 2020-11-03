/**
 * 销售分析-考核内容分析图
 */
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

function setHeight(){
		var top = $(this).combobox('getValue');
		if(top=='10'||top=='5') $('#main4').css('height','400px');
		else $('#main4').css('height','800px');
}
/**
 * 初始化页面
 */
function clear1(){
	$('#department').combobox('clear');
}
function initPage(){
	
	
	setDefault();

}

function DrawCharts(ec){
	drawAssessmentAnalysis(ec);
	drawAssessmentAnalysisForWorkplanDevelopRatio(ec);
	drawAssessmentAnalysisForInformationIntegrity(ec);
}

function drawAssessmentAnalysis(ec){
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
				text : '工作计划完成度(%)',
				subtext : ''
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				x :'center',
				y :'28',
				itemHeight:10,
				data : []
			},
			toolbox : {
				 orient: 'vertical',      // 布局方式，默认为水平布局，可选为：
                 // 'horizontal' ¦ 'vertical'
				 x: 'right',                // 水平安放位置，默认为全图右对齐，可选为：
                    // 'center' ¦ 'left' ¦ 'right'
                    // ¦ {number}（x坐标，单位px）
				 y: '100',// 垂直安放位置，默认为全图顶端，可选为：
                    // 'top' ¦ 'bottom' ¦ 'center'
                    // ¦ {number}（y坐标，单位px）
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
			yAxis : [ {
				type : 'value',
				boundaryGap : [ 0, 0.01 ]
			} ],
			xAxis : [ {
				type : 'category',
				data : []
			} ],
			series : [ ]
		};
	$.ajax({
		type : 'POST',
		async : false,
		url:getContextPath()+'/analysisbasicassessment/assessment.do',
		data:{startdate:$("#startdate").datebox("getValue"),
				enddate:$("#enddate").datebox("getValue"),
				departmentid:$("#department").combobox("getValue")
				},
		dataType:'json',
		success:function(result){
			for(i=0; i<result.legend.length; i++){
				var item={
			            itemStyle: {
			            	normal: {
			            		label : {
			            			show: true,
			            			position: 'top'
			            		}
			            	}
			            },
						name : '',
						type : '',
						data : [ ]
				}
				options.series.push(item);
			}
			options.legend.data=result.legend;

			if(result.category.length<1||result.series[0].dataForDouble.length<1){
				options.xAxis[0].data=[''];
				for(i=0; i<result.legend.length; i++){
					options.series[i].data=[0];
				}
			}
			else{
				options.xAxis[0].data=result.category;
				for(i=0; i<result.legend.length; i++){
					options.series[i].data=result.series[i].dataForDouble;
				}
			}
			for(i=0; i<result.legend.length; i++){
				options.series[i].name=result.series[i].name;
				options.series[i].type=result.series[i].type;
			}
			
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

function drawAssessmentAnalysisForWorkplanDevelopRatio(ec){
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
				text : '计划行为比',
				subtext : ''
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				x :'center',
				y :'28',
				itemHeight:10,
				data : []
			},
			toolbox : {
				 orient: 'vertical',      // 布局方式，默认为水平布局，可选为：
                 // 'horizontal' ¦ 'vertical'
				 x: 'right',                // 水平安放位置，默认为全图右对齐，可选为：
                    // 'center' ¦ 'left' ¦ 'right'
                    // ¦ {number}（x坐标，单位px）
				 y: '100',// 垂直安放位置，默认为全图顶端，可选为：
                    // 'top' ¦ 'bottom' ¦ 'center'
                    // ¦ {number}（y坐标，单位px）
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
			yAxis : [ {
				type : 'value',
				boundaryGap : [ 0, 0.01 ]
			} ],
			xAxis : [ {
				type : 'category',
				data : []
			} ],
			series : [ ]
		};
	$.ajax({
		type : 'POST',
		async : false,
		url:getContextPath()+'/analysisbasicassessment/assessForWorkplanDevelopRatio.do',
		data:{startdate:$("#startdate").datebox("getValue"),
				enddate:$("#enddate").datebox("getValue"),
				departmentid:$("#department").combobox("getValue")
				},
		dataType:'json',
		success:function(result){
			for(i=0; i<result.legend.length; i++){
				var item={
			            itemStyle: {
			            	normal: {
			            		label : {
			            			show: true,
			            			position: 'top'
			            		}
			            	}
			            },
						name : '',
						type : '',
						data : [ ]
				}
				options.series.push(item);
			}
			options.legend.data=result.legend;

			if(result.category.length<1||result.series[0].data.length<1){
				options.xAxis[0].data=[''];
				for(i=0; i<result.legend.length; i++){
					options.series[i].data=[0];
				}
			}
			else{
				options.xAxis[0].data=result.category;
				for(i=0; i<result.legend.length; i++){
					options.series[i].data=result.series[i].data;
				}
			}
			for(i=0; i<result.legend.length; i++){
				options.series[i].name=result.series[i].name;
				options.series[i].type=result.series[i].type;
			}
			
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

function drawAssessmentAnalysisForInformationIntegrity(ec){
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
				text : '客户录入及信息完整度(%)',
				subtext : ''
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				x :'center',
				y :'28',
				itemHeight:10,
				data : []
			},
			toolbox : {
				 orient: 'vertical',      // 布局方式，默认为水平布局，可选为：
                 // 'horizontal' ¦ 'vertical'
				 x: 'right',                // 水平安放位置，默认为全图右对齐，可选为：
                    // 'center' ¦ 'left' ¦ 'right'
                    // ¦ {number}（x坐标，单位px）
				 y: '100',// 垂直安放位置，默认为全图顶端，可选为：
                    // 'top' ¦ 'bottom' ¦ 'center'
                    // ¦ {number}（y坐标，单位px）
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
			yAxis : [ {
				type : 'value',
				boundaryGap : [ 0, 0.01 ]
			} ],
			xAxis : [ {
				type : 'category',
				data : []
			} ],
			series : [ ]
		};
	$.ajax({
		type : 'POST',
		async : false,
		url:getContextPath()+'/analysisbasicassessment/assessForInformationIntegrity.do',
		data:{startdate:$("#startdate").datebox("getValue"),
				enddate:$("#enddate").datebox("getValue"),
				departmentid:$("#department").combobox("getValue")
				},
		dataType:'json',
		success:function(result){
			for(i=0; i<result.legend.length; i++){
				var item={
			            itemStyle: {
			            	normal: {
			            		label : {
			            			show: true,
			            			position: 'top'
			            		}
			            	}
			            },
						name : '',
						type : '',
						data : [ ]
				}
				options.series.push(item);
			}
			options.legend.data=result.legend;

			if(result.category.length<1||result.series[0].dataForDouble.length<1){
				options.xAxis[0].data=[''];
				for(i=0; i<result.legend.length; i++){
					options.series[i].data=[0];
				}
			}
			else{
				options.xAxis[0].data=result.category;
				for(i=0; i<result.legend.length; i++){
					options.series[i].data=result.series[i].dataForDouble;
				}
			}
			for(i=0; i<result.legend.length; i++){
				options.series[i].name=result.series[i].name;
				options.series[i].type=result.series[i].type;
			}
			
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