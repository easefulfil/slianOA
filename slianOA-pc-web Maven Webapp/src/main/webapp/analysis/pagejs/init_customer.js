/**
 * 初始化销售对应客户
 */
var CUSTOMER_LIST = null;

// 加载dom之前执行
(function() {
	// 初始化查询基础数据	
	initCustomersList();
	
})();

//dom就绪后执行
$(document).ready(function() {

	// 根据按照parent id分组后的基础数据,设置相应的查询条件div
	initCustomersSetDIV();

});

function initCustomersList(){
	//获取销售所辖客户
	$.ajax({
		type:"get",
		url:"/pcbas-analysis/analysisbasicdataset/getcustomers.do",
		async:false,
		success:function(result){
			CUSTOMER_LIST = result;
		},
		error:function(e){
			
		}
	});
}


function initCustomersSetDIV(){
	var div = $(".customer-list-set");
	//初始化前清空内容
	var ul = $("<ul class='1' title='客户名'></ul>");
	$(div).children().remove();
	$.each(CUSTOMER_LIST, function(i,item){
		$("<li class='customername' id='"+item["id"]+"'><a>"+item["name"]+"</a></li>").appendTo(ul);
	});
	$(div).append(ul);
	
}