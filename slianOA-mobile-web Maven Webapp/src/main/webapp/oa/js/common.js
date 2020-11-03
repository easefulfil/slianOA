$(document).ready(function(){
//	showList();	
	pullToRefreshList();
})

function showList(){
	var temp ="";
	var tempUrl="http://192.168.0.108:8090/testOA/IncomingDispatch.html";
	var i = 0;
	for(i; i<20;i++){
		if(i%2 == 0){
			temp += "<div class='weui-cell weui-cell_bgc'>"
		}else{
			temp += "<div class='weui-cell'>"
		}
		temp += "<div class='weui-cell__bd weui-cell_primary weui-cell_a'>"
				+"<p>"
				+ (i+1) + ". "
				+ "<a href='"
				+ "#"
				+ "'>标题文字</a></p>"
				+ "</div>"
				+ "<div class='weui-cell__ft'>"
				+ "<a href='"
				+ tempUrl
				+ "' class='weui-btn weui-btn_mini weui-btn_primary'>办理</a>"
				+ "</div></div>";		   
	}
	$("#dispatchList").empty();
	$("#dispatchList").html(temp);
}

//下拉刷新
function pullToRefreshList(){
	
	$(document.body).pullToRefresh().on("pull-to-refresh", function() {
	   setTimeout(function() {
		   window.location.reload();
		   $(document.body).pullToRefreshDone();
	   }, 2000);
	});
}

    