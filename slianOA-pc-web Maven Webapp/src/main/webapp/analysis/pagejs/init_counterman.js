/**
 * 初始化销售
 */
var COUNTERMAN_LIST = null;

// 加载dom之前执行
(function() {
	// 初始化查询基础数据	
	initCountermansList();
	
})();

//dom就绪后执行
$(document).ready(function() {

	// 根据按照parent id分组后的基础数据,设置相应的查询条件div
	initCountermansSetDIV();

});

function initCountermansList(){
	//获取销售所辖客户
	$.ajax({
		type:"get",
		url:"/pcbas-analysis/analysisbasicdataset/getcountermans.do",
		async:false,
		success:function(result){
			COUNTERMAN_LIST = result;
		},
		error:function(e){
			
		}
	});
}


function initCountermansSetDIV(){
	var div = $(".counterman-list-set");
	//初始化前清空内容
	var ul = $("<ul class='1' title='销售名'></ul>");
	$(div).children().remove();
	$.each(COUNTERMAN_LIST, function(i,item){
		$("<li class='countermanname' id='"+item["id"]+"'><a>"+item["name"]+"</a></li>").appendTo(ul);
	});
	$(div).append(ul);
	
}