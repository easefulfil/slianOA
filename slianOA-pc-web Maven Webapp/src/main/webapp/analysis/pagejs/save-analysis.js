

$(function() {


	$("#tabs").click(function(){
		
		reflesh(this);
	});

});


//点击tab时进行刷新
function reflesh(tabs){
	
	var current_tab = $(tabs).tabs('getSelected');
	var url = $(current_tab).find('iframe').attr("src");
	
	$(tabs).tabs('update',{
	     tab:current_tab,
	     options : {
	         content : '<iframe scrolling="auto" frameborder="0"  src="'+ url +'" style="width:100%;height:100%;"></iframe>',
	      //或者 href : '';
//	    	 href:BASE_URL +url
	     }
	});
}
